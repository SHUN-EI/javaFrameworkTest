package com.mo.mysql.constant;

import lombok.Data;

/**
 * Created by mo on 2021/10/27
 * 通用返回结果
 */
@Data
public class ResultData<T> {
    private Integer code;
    private String msg;
    private T data;
}
