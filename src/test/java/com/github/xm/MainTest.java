package com.github.xm;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.text.UnicodeUtil;
import cn.hutool.http.HttpUtil;
import lombok.extern.java.Log;

import java.net.URL;
import java.util.List;

/**
 * @author: XuMeng
 * @create: 2018/9/10 16:53
 * @description:
 **/
@Log
public class MainTest {
    public static void main(String[] args) {
//        String url = "http://wh.loupan.com/xinfang/";
//        String s = HttpUtil.get(url);
//        log.info(s);

        URL resource = MainTest.class.getClassLoader().getResource("ajax.json");

        List<String> strings = FileUtil.readLines(resource, "utf-8");
        for(String line:strings){
            String s1 = UnicodeUtil.toString(line);
            System.out.println(s1);
        }

    }
}
