package com.github.xm.provider;

import com.github.xm.comm.Constant;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author: XuMeng
 * @create: 2018/9/6 11:08
 * @description:
 **/
public class InMemoryUrlProvider extends AbstractUrlProvider {

    private Map<String,Url> urls=new ConcurrentHashMap<>();

    private BlockingDeque<Url> queue=new LinkedBlockingDeque<>();

    @Override
    protected Url getUrl(String urlStr) {
         return urls.get(urlStr);
    }

    @Override
    protected void setUrl(Url url) {
        urls.put(url.getUrl(),url);
        queue.add(url);
    }


    @Override
    public String getUrl() {
        Url url = null;
        try {

            //将队列首的url取出
            url = queue.take();

            //将map里面对应的url标记为已爬取
            urls.get(url.getUrl()).setState(Constant.READY_CRAWL);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return url.getUrl();
    }
}
