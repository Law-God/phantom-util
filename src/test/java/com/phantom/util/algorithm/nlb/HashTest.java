package com.phantom.util.algorithm.nlb;

import org.junit.Test;

/**
 * @Author 张志凯 https://github.com/Law-God/phantom-util
 * util
 * com.phantom.util.algorithm.nlb.HashTest
 * 2017-03-03 下午 05:20
 */
public class HashTest {

    @Test
    public void getServer(){
        for(int i=0;i<IpMap.serverWeightMap.size();i++){
            String server = Hash.getServer("127.0.0."+i);
            System.out.println(server);

        }
    }
}
