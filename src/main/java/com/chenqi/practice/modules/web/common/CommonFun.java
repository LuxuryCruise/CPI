package com.chenqi.practice.modules.web.common;

import java.util.Collection;
import java.util.Map;

/**
 * @description: 封装的公共方法
 * @auther: chenqi
 * @date: 2019/6/2 16:06
 */
public class CommonFun {


    public static  <E> void printCollctions(Collection<E> collection){
        if(checkCollectionEmpty(collection)){
            System.out.println("集合为空！");
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        collection.stream()
                .forEach(ele ->sb.append(ele.toString()).append(","));
        System.out.println(sb.substring(0,sb.length()-1) + "]");
    }

    /** 将集合转换为字符串，默认逗号分隔 */
    public static String collection2Str(Collection<String> collection){
        return collection2Str(collection,",");
    }

    /** 将集合转换为字符串 */
    public static String collection2Str(Collection<String> collection,String seperator){
        if(checkCollectionEmpty(collection)){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        collection.stream()
                .forEach(ele ->sb.append(ele.toString()).append(seperator));
        return sb.substring(0,sb.length()-1);
    }

    public static boolean checkMapNotEmpty(Map map){
        return !checkMapEmpty(map);
    }

    public static boolean checkMapEmpty(Map map){
        if(null == map || map.size() == 0){
            return true;
        }
        return false;
    }

    public static boolean checkCollectionNotEmpty(Collection collection){
        return !checkCollectionEmpty(collection);
    }

    public static boolean checkCollectionEmpty(Collection collection){
        if(null == collection || collection.size() == 0){
            return true;
        }
        return false;
    }


}
