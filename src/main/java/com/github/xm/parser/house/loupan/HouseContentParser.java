package com.github.xm.parser.house.loupan;

import com.github.xm.comm.ParserUtil;
import com.github.xm.parser.ContentParser;
import com.github.xm.parser.Result;

/**
 * @author: XuMeng
 * @create: 2018/9/10 17:01
 * @description:
 **/
public class HouseContentParser implements ContentParser<String> {

    private static volatile  int  page = 2;

    @Override
    public Result<String> parse(String content) {
        Result<String> result = new Result();

        /**
         * 构建下一步待处理url
         */
        result.getUrl().add(ParserUtil.getUrl(String.valueOf(page++)));

        /**
         *   将下载下来的页面不做任何处理
         *   放入结果中
         */
        result.setData(content);

        return result;

    }


}
