package com.mo.designPattern.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mo on 2020/11/23
 * 享元⼯⼚⻆⾊：负责创建和管理享元⻆⾊
 */
public class WebSiteFactory {

    private Map<String, ConcreteWebSite> map = new HashMap<>();


    /**
     * 根据key获取分类的站点
     *
     * @param category
     * @return
     */
    public CloudWebSite getWebSiteByCategory(String category) {

        if (map.containsKey(category)) {
            return map.get(category);
        } else {
            ConcreteWebSite site = new ConcreteWebSite(category);
            map.put(category, site);
            return site;
        }
    }

    /**
     * 获取分类个数
     * @return
     */
    public int getWebsiteCategorySize() {
        return map.size();
    }
}
