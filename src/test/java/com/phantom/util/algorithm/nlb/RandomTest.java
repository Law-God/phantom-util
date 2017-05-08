package com.phantom.util.algorithm.nlb;

import junit.framework.Assert;
import org.junit.Test;

/**
 * @Author 张志凯 https://github.com/Law-God/phantom-util
 * util
 * com.phantom.util.algorithm.nlb.RandomTest
 * 2017-03-03 下午 05:10
 */
public class RandomTest {

    @Test
    public void getServer(){
        for(int i=0;i<IpMap.serverWeightMap.size();i++){
            System.out.println(Random.getServer());
            Assert.assertNotNull(Random.getServer());
        }
    }

}
