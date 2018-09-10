package com.github.xm.parser.house.fdc;

import cn.hutool.core.util.StrUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.xm.comm.House;
import com.github.xm.comm.ParserUtil;
import com.github.xm.parser.ContentParser;
import com.github.xm.parser.Result;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * @author: XuMeng
 * @create: 2018/9/7 22:45
 * @description:
 **/
public class HouseContentParser implements ContentParser<List> {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public Result<List> parse(String content) {

        Result<List> result = new Result();
        List<House> data=new ArrayList<>();

        String houseStr = getDataString(content);

        try {
            List<LinkedHashMap> houses = objectMapper.readValue(houseStr, List.class);

            for(LinkedHashMap map:houses){
                House house = ParserUtil.map2Object(map, House.class);
                data.add(house);
                result.getUrl().add(ParserUtil.getUrl(house));
            }

            result.setData(data);
            return result;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    //截取返回json字符串当中的必要信息
    private String getDataString(String content) {
        int begin = content.indexOf("[");
        int end = content.indexOf("]") + 1;
        return StrUtil.sub(content,begin,end);
    }
}
