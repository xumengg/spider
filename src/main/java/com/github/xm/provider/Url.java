package com.github.xm.provider;

import lombok.Data;

import java.io.Serializable;

/**
 * @author: XuMeng
 * @create: 2018/9/6 10:42
 * @description:
 **/
@Data
public class Url implements Serializable {

    private static final long serialVersionUID = 425213898206100902L;

    private String url;

    /**
     * 0 ：未被爬取   1：已被爬取
     */
    private Integer state;


    public Url() {

    }

    public Url(String url, Integer state) {
        this.url = url;
        this.state = state;
    }
}
