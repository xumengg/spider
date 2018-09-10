package com.github.xm.comm;

/**
 * @author: XuMeng
 * @create: 2018/9/6 10:49
 * @description:
 **/
public interface Constant {

    /**
     * 未被爬取
     */
    int NOT_READY_CRAWL = 0;

    /**
     *  已被爬取
     */
    int READY_CRAWL  = 1 ;

    /**
     *  fdc 数据接口
     */
    String BASE_URL_FDC="https://zjyjxc.wh.fdc.com.cn/portal/getScannedHouse2";


    /**
     *  loupan 数据接口
     *  将 *号 替换为 要爬取的具体页号
     */
    String BASE_URL_loupan = "http://wh.loupan.com/xinfang/p*/?ajax=1";
}
