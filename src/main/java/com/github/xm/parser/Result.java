package com.github.xm.parser;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: XuMeng
 * @create: 2018/9/7 22:40
 * @description:
 **/
@Data
public class Result<T> implements Serializable {

    private static final long serialVersionUID = 6081862528095854004L;

    /**
     *  待爬取 url
     */
    private List<String> url = new ArrayList();

    /**
     * 数据对象
     */
    private T data;
}
