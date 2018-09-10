package com.github.xm.comm;

import com.github.xm.parser.house.fdc.House;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Map;

/**
 * @author: XuMeng
 * @create: 2018/9/7 15:53
 * @description:
 **/
public class ParserUtil {

    /**
     * 从返回的数据构建新的url,用来做后续的爬取工作
     * @param house
     * @return
     */
    public static String getUrl(House house){
       return Constant.BASE_URL_FDC + "?housebid=" + house.getHouseId();
    }

    /**
     *
     * @param i
     * @return
     */
    public static String getUrl(String i){
        return Constant.BASE_URL_loupan.replace("*",i);
    }


    /**
     * 将map转换成对象
     * @param map
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T map2Object(Map<String, Object> map, Class<T> clazz) {
        if (map == null) {
            return null;
        }
        Object obj = null;
        try {
            obj = clazz.newInstance();

            Field[] fields = obj.getClass().getDeclaredFields();
            for (Field field : fields) {
                int mod = field.getModifiers();
                if (Modifier.isStatic(mod) || Modifier.isFinal(mod)) {
                    continue;
                }
                field.setAccessible(true);
                field.set(obj, map.get(field.getName()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (T)obj;
    }
}
