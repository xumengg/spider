package com.github.xm.parser.house.loupan;

import lombok.Data;

import java.io.Serializable;

/**
 * @author: XuMeng
 * @create: 2018/9/10 22:16
 * @description:
 **/
@Data
public class House implements Serializable {

    private static final long serialVersionUID = 775214209184647884L;

    /**
     * 楼盘名称
     */
    private String name;

    /**
     * 楼盘价格
     */
    private String price;


    /**
     * 地理位置
     */
    private String location;

    public House(String name, String price, String location) {
        this.name = name;
        this.price = price;
        this.location = location;
    }
}
