package com.mo.http;

import com.mo.filter.LogFilter;
import com.mo.model.LogDO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.ClientHttpRequest;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.util.Assert;
import org.springframework.web.client.*;

import java.io.IOException;
import java.net.URI;

/**
 * Created by mo on 2021/5/24
 */
public class MyRestTemplate extends RestTemplate {

    @Override
    protected <T> T doExecute(URI url, HttpMethod method, RequestCallback requestCallback, ResponseExtractor<T> responseExtractor) throws RestClientException {

        Assert.notNull(url, "URI is required");
        Assert.notNull(method, "HttpMethod is required");
        ClientHttpResponse response = null;
        try {
            ClientHttpRequest request = createRequest(url, method);
            if (requestCallback != null) {
                requestCallback.doWithRequest(request);
            }

            //把当前的日志信息放入请求头中，远程调用的时候带过去
            LogDO logDO = LogFilter.threadLocal.get();
            HttpHeaders httpHeaders = request.getHeaders();
            httpHeaders.add("rid", logDO.getRid());
            httpHeaders.add("sid", logDO.getSid());
            httpHeaders.add("tid", logDO.getTid());
            httpHeaders.add("ip", logDO.getIp());

            response = request.execute();
            handleResponse(url, method, response);
            return (responseExtractor != null ? responseExtractor.extractData(response) : null);
        } catch (IOException ex) {
            String resource = url.toString();
            String query = url.getRawQuery();
            resource = (query != null ? resource.substring(0, resource.indexOf('?')) : resource);
            throw new ResourceAccessException("I/O error on " + method.name() +
                    " request for \"" + resource + "\": " + ex.getMessage(), ex);
        } finally {
            if (response != null) {
                response.close();
            }
        }
    }
}
