package com.github.xm.parser;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.xm.comm.House;

import java.util.List;

/**
 * @author: XuMeng
 * @create: 2018/9/7 23:01
 * @description:
 **/
public class HouseResultProcessor implements ResultProcessor {

    private ObjectMapper objectMapper = new ObjectMapper();
    @Override
    public void process(Result result) {
        Object data = result.getData();
        if(data != null && data instanceof List){
            for (Object obj : (List)data) {

                if(obj instanceof  House){

                    /**
                     *  实际上应该对数据清理 写入数据库
                     *  方便以后对数据进行统计分析
                     *
                     *  目前只是简单的将数据打印
                     */
                    try {
                        System.out.println(objectMapper.writeValueAsString((House) obj));
                    } catch (JsonProcessingException e) {
                        e.printStackTrace();
                    }



                }
            }
        }
    }
}
