package com.github.xm.parser.house.loupan;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.xm.comm.House;
import com.github.xm.parser.Result;
import com.github.xm.parser.ResultProcessor;

import java.util.List;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author: XuMeng
 * @create: 2018/9/7 23:01
 * @description:
 **/
public class HouseResultProcessor implements ResultProcessor {

    private static volatile  int  page = 1;

    private BlockingDeque<String> queue = new LinkedBlockingDeque<>();

    private static int wokerCount = 4;

    private static Executor executor = Executors.newFixedThreadPool(wokerCount);

    public HouseResultProcessor(){
        for (int i = 0;i<wokerCount;i++){
            executor.execute(new Worker());
        }
    }

    @Override
    public void process(Result result) {
        Object data = result.getData();
        if(data instanceof  String){
            queue.add((String) data);
        }
    }


    /**
     *  Worker 对网页内容进行解析提取出有用数据写进数据库
     */
    class Worker implements Runnable{

        @Override
        public void run() {
            try {
                String html = queue.take();
                System.out.println(html);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }



}
