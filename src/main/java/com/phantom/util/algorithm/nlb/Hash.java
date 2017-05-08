package com.phantom.util.algorithm.nlb;

import com.phantom.util.validate.RegexValidateUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Author 张志凯 https://github.com/Law-God/phantom-module-util
 * util
 * com.phantom.util.algorithm.nlb.Hash
 * 2017-02-10 14:54
 * 源地址哈希（Hash）法
 * 算法原理：根据客户请求ip地址，通过哈希函数计算得到一个值，用该数字与服务器总数取模，得到的结果就是客户端要访问的服务器地址
 * 算法：ip哈希值 取模 服务器数量，取模值就是要访问的服务器
 * 优点：同一个ip地址访问的服务器都是同一台，直达后台服务器数改变
 */
public class Hash {

    /**
     * 获取服务器地址
     * @return
     */
    public static String getServer(String ip){
        if(!RegexValidateUtil.isIp(ip))
            return null;

        Map<String,String> serverMap = IpMap.serverWeightMap;
        Set<String> ipSet = serverMap.keySet();
        List<String> ipList = new ArrayList<String>(ipSet);

        int ipHashCode = ip.hashCode();

        int len = ipList.size();
        if(len <= 0)
            return null;
        int pos = Math.abs(ipHashCode % ipList.size());

        return ipList.get(pos);
    }

}
