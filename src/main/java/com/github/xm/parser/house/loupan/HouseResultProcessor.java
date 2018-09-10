package com.github.xm.parser.house.loupan;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.xm.parser.Result;
import com.github.xm.parser.ResultProcessor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

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

        private ObjectMapper objectMapper = new ObjectMapper();

        @Override
        public void run() {
            while (true){
                try {
                    String html = queue.take();
                    Document doc = Jsoup.parse(html);
                    Elements elements = doc.select("#house_list > li");
                    for(Element element:elements){

                        String name = element.select("div h3 a").text().trim();
                        String price = element.select("ul .price").text().trim();
                        String location = element.select("div .add a").text().trim();

                        House house = new House(name,price,location);
                        System.out.println(objectMapper.writeValueAsString(house));

                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }



}
