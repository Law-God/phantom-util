package com.phantom.util.collection;

import org.apache.log4j.Logger;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @Author 张志凯 https://github.com/Law-God/phantom-util
 * util
 * com.phantom.util.collection.MapUtil
 * 2016-08-15 16:13
 */
public class MapUtil {
    private final Logger log = Logger.getLogger(MapUtil.class);

    /**
     * 获取Map第一个key值
     * @param m
     * @return object
     */
    public static Object getFirstKey(Map m){
        if(m == null)
            return null;

        Object k = null;

        for(Object key : m.keySet()){
            k = key;break;
        }
        return k;
    }

    /**
     * 获取Map集合第一个value值
     * @param m
     * @return
     */
    public static Object getFirstValue(Map m){
        if(m == null)
            return null;

        Object v = null;
        for(Object key : m.keySet()){
            v = m.get(key);break;
        }
        return v;
    }
}
