package com.phantom.util.algorithm.nlb;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Author 张志凯 https://github.com/Law-God/phantom-module-util
 * util
 * com.phantom.util.algorithm.nlb.RoundRobin
 * 2017-02-10 13:45
 * 轮询算法
 * 算法原理：将每次用户的请求依次序轮流分配给服务器，从1开始，直到N（服务器个数），然后重新循环。
 * 流程:
 * 1、创建一个表示位置pos，用于记录当前已取的地址，使用Integer，增加锁（synchronized）防止并发问题
 * 2、重新创建一个Map存放服务器IpMap，避免服务器上下线并发问题。
 * 3、创建一个list存放IpMap中要路由的地址，用于用户请求循环取服务器地址
 * 4、根据pos取服务器地址
 */
public class RoundRobin {
    //标记当前位置
    private static Integer pos = 0;

    /**
     * 获取服务器地址
     * @return
     */
    public static String getServer(){
        //要返回的服务器地址
        String server = null;

        Map<String,String> serverMap = IpMap.serverWeightMap;
        Set<String> ipSet = serverMap.keySet();
        List<String> ipList = new ArrayList<String>(ipSet);

        synchronized (pos){
            if(pos > ipList.size())
                pos = 0;
            server = ipList.get(pos);
            pos++;
        }

        return server;
    }
}
