package com.phantom.util.algorithm.nlb;

import junit.framework.Assert;
import org.junit.Test;

/**
 * @Author 张志凯 https://github.com/Law-God/phantom-util
 * util
 * com.phantom.util.algorithm.nlb.RoundRobinTest
 * 2017-03-03 下午 05:16
 */
public class RoundRobinTest {

    @Test
    public void getServer(){
        for(int i=0;i<IpMap.serverWeightMap.size();i++){
            String server = RoundRobin.getServer();
            System.out.println(server);
            Assert.assertNotNull(server);
        }


    }
}
