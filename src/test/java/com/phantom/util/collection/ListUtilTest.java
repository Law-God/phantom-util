package com.phantom.util.collection;

import junit.framework.Assert;
import org.junit.Test;

import java.util.*;

/**
 * @Author 张志凯 https://github.com/Law-God/phantom-util
 * util
 * com.phantom.util.collection.ListUtilTest
 * 2016-08-12 10:15
 */
public class ListUtilTest {
    @Test
    public void struct(){
        ListUtil listUtil = new ListUtil();
    }

    @Test
    public void listPage(){
        Assert.assertNull(ListUtil.listPage(null,0,0));
        Assert.assertEquals(0,ListUtil.listPage(new ArrayList(),0,0).size());

        List list = new ArrayList();
        for(int i=0;i<101;i++){
            list.add(i);
        }
        Assert.assertEquals(1,ListUtil.listPage(list,-1,1).size());
        Assert.assertEquals(1,ListUtil.listPage(list,11,10).size());
        Assert.assertEquals(0,ListUtil.listPage(list,1,-1).size());

        List list2 = new ArrayList();
        list2.add(1);
        list2.add(3);
        list2.add(2);
        Collections.sort(list2);
        System.out.println(list2);



    }
}
