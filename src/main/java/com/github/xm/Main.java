package com.github.xm;

import com.github.xm.parser.*;
import com.github.xm.parser.house.loupan.HouseContentParser;
import com.github.xm.parser.house.loupan.HouseResultProcessor;
import com.github.xm.provider.InMemoryUrlProvider;
import com.github.xm.provider.UrlProvider;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @author: XuMeng
 * @create: 2018/9/6 9:18
 * @description:
 **/
public class Main {

    public static String ROOT_URL_FDC = "https://zjyjxc.wh.fdc.com.cn/portal/getScannedHouse2?housebid=595c870fa093c060be004171";

    public static String ROOT_URL_LOUPAN= "http://wh.loupan.com/xinfang/p1/?ajax=1";


    //设置爬虫线程数量与计算机核心数保持一直
    public static int THREAD_COUNT = Runtime.getRuntime().availableProcessors();

    public static Executor executor = Executors.newFixedThreadPool(THREAD_COUNT);

    public static void main(String[] args) {

        //创建url仓库
        UrlProvider urlProvider=new InMemoryUrlProvider();

        //设置待爬取根url
        urlProvider.setUrl(ROOT_URL_LOUPAN);

        //创建爬取的内容解析器
        ContentParser contentParser=new HouseContentParser();

        //创建爬取结果处理器
        ResultProcessor resultProcessor = new HouseResultProcessor();


        for (int i=0;i<THREAD_COUNT;i++){
            //实例化爬虫
            Spider spider=new Spider(urlProvider,contentParser,resultProcessor);
            executor.execute(spider);
        }

        while (true){

        }
    }
}
