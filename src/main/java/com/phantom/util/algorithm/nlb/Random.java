package com.phantom.util.algorithm.nlb;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Author 张志凯 https://github.com/Law-God/phantom-module-util
 * util
 * com.phantom.util.algorithm.nlb.Random
 * 2017-02-10 14:30
 * 随机算法
 * 算法原理：从后台服务器列表中随机返回一台服务器
 */
public class Random {
    /**
     * 获取服务器地址
     * @return
     */
    public static String getServer(){
        Map<String,String> serverMap = IpMap.serverWeightMap;
        Set<String> ipSet = serverMap.keySet();
        List<String> ipList = new ArrayList<String>(ipSet);

        java.util.Random random = new java.util.Random();
        int pos = random.nextInt(ipList.size());

        return ipList.get(pos);
    }

}
