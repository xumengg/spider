package com.github.xm.provider;

import com.github.xm.comm.Constant;

/**
 * @author: XuMeng
 * @create: 2018/9/6 9:24
 * @description:
 **/
public abstract class AbstractUrlProvider implements UrlProvider {


    @Override
    public void setUrl(String url) {
        if(!isCrawl(url)){
            setUrl(new Url(url,Constant.NOT_READY_CRAWL));
        }
    }

    private boolean isCrawl(String urlStr) {
        Url url = getUrl(urlStr);
        if(url == null){
            return false;
        }else {
            return true;
        }
    }

    protected abstract Url getUrl(String urlStr) ;

    protected abstract void setUrl (Url url);
}
