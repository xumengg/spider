package com.github.xm;

import com.github.xm.parser.*;
import com.github.xm.provider.InMemoryUrlProvider;
import com.github.xm.provider.UrlProvider;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: XuMeng
 * @create: 2018/9/6 9:18
 * @description:
 **/
public class Main {

    public static String ROOT_URL = "https://zjyjxc.wh.fdc.com.cn/portal/getScannedHouse2?housebid=595c870fa093c060be004171";


    //设置爬虫线程数量
    public static int THEAD_COUNT = 5;

    public static Executor executor = Executors.newFixedThreadPool(THEAD_COUNT);

    public static void main(String[] args) {

        //创建url仓库
        UrlProvider urlProvider=new InMemoryUrlProvider();

        //设置待爬取根url
        urlProvider.setUrl(ROOT_URL);

        //创建爬取的内容解析器
        ContentParse contentParse=new HouseContentParse();

        //创建爬取结果处理器
        ResultProcessor resultProcessor = new HouseResultProcessor();


        for (int i=0;i<THEAD_COUNT;i++){
            //实例化爬虫
            Spider spider=new Spider(urlProvider,contentParse,resultProcessor);
            executor.execute(spider);
        }

        while (true){

        }
    }
}
