package com.phantom.util.algorithm;

import junit.framework.Assert;
import org.junit.Test;

/**
 * @Author 张志凯 https://github.com/Law-God/phantom-module-email
 * util
 * com.phantom.util.algorithm.MinHeapTest
 * 2017-01-20 14:31
 */
public class MinHeapTest {

    @Test
    public void struct(){
        int[] arr = {1,23,4};
        MinHeap minHeap = new MinHeap(arr);
        Assert.assertNotNull(minHeap);
    }

    @Test
    public void root(){
        // 源数据
        int[] data = {56,275,12,6,45,478,41,1236,456,12,546,45};

        MinHeap minHeap = new MinHeap(data);
        System.out.println(minHeap.getRoot());

        for(int d : minHeap.getData()){
            System.out.print(d + "  ");
        }
    }
}
