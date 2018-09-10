package com.github.xm.parser;

import cn.hutool.http.HttpUtil;
import com.github.xm.provider.UrlProvider;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;

/**
 * @author: XuMeng
 * @create: 2018/9/6 11:24
 * @description:
 **/
@Slf4j
public class Spider implements ParseAble ,Runnable {

    private UrlProvider urlProvider;

    private ContentParser contentParser;

    private ResultProcessor resultProcessor;

    private static volatile int count = 1;

    public Spider(UrlProvider urlProvider, ContentParser contentParse, ResultProcessor resultProcessor) {
        this.urlProvider = urlProvider;
        this.contentParser = contentParse;
        this.resultProcessor = resultProcessor;
    }

    @Override
    public void parse() {
        String url = urlProvider.getUrl();
       // log.info("第{}次爬取的url={}",count++,url);
        String content = HttpUtil.get(url);
        Result result = contentParser.parse(content);
        result.getUrl().forEach(str->urlProvider.setUrl((String)str));
        resultProcessor.process(result);
    }


    @Override
    public void run() {
        while (true){
            parse();
        }
    }
}
