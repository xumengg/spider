package com.github.xm.parser;

import cn.hutool.http.HttpUtil;
import com.github.xm.provider.UrlProvider;

/**
 * @author: XuMeng
 * @create: 2018/9/6 11:24
 * @description:
 **/
public class Spider implements ParseAble ,Runnable {

    private UrlProvider urlProvider;

    private ContentParse contentParse;

    private ResultProcessor resultProcessor;

    public Spider(UrlProvider urlProvider,ContentParse contentParse,ResultProcessor resultProcessor) {
        this.urlProvider = urlProvider;
        this.contentParse = contentParse;
        this.resultProcessor = resultProcessor;
    }

    @Override
    public void parse() {
        String content = HttpUtil.get(urlProvider.getUrl());
        Result result = contentParse.parse(content);
        result.getUrl().forEach(url->urlProvider.setUrl((String)url));
        resultProcessor.process(result);
    }


    @Override
    public void run() {
        while (true){
            parse();
        }
    }
}
