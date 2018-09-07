package com.github.xm.comm;

import lombok.Data;

import java.io.Serializable;

/**
 * @author: XuMeng
 * @create: 2018/9/7 15:35
 * @description:
 **/
@Data
public class House implements Serializable {

    private static final long serialVersionUID = 6084373243607183165L;

    private String houseId;
    private String url;
    private String houseName;
    private String districtName;
    private String scannedImg;
    private Integer scannedPrice;
    private String discount;

}
