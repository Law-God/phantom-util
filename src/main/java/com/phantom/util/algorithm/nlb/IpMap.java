package com.phantom.util.algorithm.nlb;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author 张志凯 https://github.com/Law-God/phantom-module-util
 * util
 * com.phantom.util.algorithm.nlb.IpMap
 * 2017-02-10 11:41
 * 待路由的Ip地址，key表示地址，value表示权重
 */
public class IpMap {
    public static Map<String,String> serverWeightMap = new HashMap<String,String>(){{
        put("192.168.1.100","1");
        put("192.168.1.101","1");
        //权重为4
        put("192.168.1.102","4");
        put("192.168.1.103","1");
        put("192.168.1.104","1");
        //权重为3
        put("192.168.1.105","3");
        put("192.168.1.106","1");
        //权重为2
        put("192.168.1.107","2");
        put("192.168.1.108","1");
        put("192.168.1.109","1");
        put("192.168.1.110","1");
    }};
}
