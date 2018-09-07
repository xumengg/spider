package com.github.xm.parser;

import java.io.Serializable;

/**
 * @author: XuMeng
 * @create: 2018/9/7 22:37
 * @description:
 **/
public interface ContentParse<T> {
    Result<T> parse(String content);
}
