package com.phantom.util.compare;

import junit.framework.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author 张志凯 https://github.com/Law-God/phantom-util
 * util
 * com.phantom.util.compare.PhantomStringComparableTest
 * 2016-08-15 15:02
 */
public class PhantomDefaultComparableTest {
    @Test
    public void struct(){
        PhantomDefaultComparable p = new PhantomDefaultComparable(PhantomComparable.EnumSort.DEFAULT);
    }

    @Test
    public void sortString(){
        List<String> list = new ArrayList<String>();
        list.add("0");
        list.add("3");
        list.add(null);
        list.add("2");
        list.add("2");
        list.add(null);
        Collections.sort(list,new PhantomDefaultComparable(PhantomComparable.EnumSort.ASC));
        for(int i=0,len=list.size();i<len;i++){
            switch (i){
                case 0 :
                    Assert.assertEquals("0",list.get(i));
                    break;
                case 1 :
                    Assert.assertEquals("2",list.get(i));
                    break;
                case 2 :
                    Assert.assertEquals("2",list.get(i));
                    break;
                case 3 :
                    Assert.assertEquals("3",list.get(i));
                    break;
                case 4 :
                    Assert.assertNull(list.get(i));
                    break;
                case 5 :
                    Assert.assertNull(list.get(i));
                    break;
            }
        }

        Collections.sort(list,new PhantomDefaultComparable(PhantomComparable.EnumSort.DESC));
        for(int i=0,len=list.size();i<len;i++){
            switch (i){
                case 0 :
                    Assert.assertEquals("3",list.get(i));
                    break;
                case 1 :
                    Assert.assertEquals("2",list.get(i));
                    break;
                case 2 :
                    Assert.assertEquals("2",list.get(i));
                    break;
                case 3 :
                    Assert.assertEquals("0",list.get(i));
                    break;
                case 4 :
                    Assert.assertNull(list.get(i));
                    break;
                case 5 :
                    Assert.assertNull(list.get(i));
                    break;

            }
        }

        Collections.sort(list,new PhantomDefaultComparable(PhantomComparable.EnumSort.DEFAULT));
    }

    @Test
    public void sortInt(){
        List<Object> list = new ArrayList<Object>();
        list.add(0);
        list.add(3);
        list.add(null);
        list.add(2);
        list.add(2);
        list.add(null);
        Collections.sort(list,new PhantomDefaultComparable(PhantomComparable.EnumSort.ASC));
        for(int i=0,len=list.size();i<len;i++){
            switch (i){
                case 0 :
                    Assert.assertEquals(0,list.get(i));
                    break;
                case 1 :
                    Assert.assertEquals(2,list.get(i));
                    break;
                case 2 :
                    Assert.assertEquals(2,list.get(i));
                    break;
                case 3 :
                    Assert.assertEquals(3,list.get(i));
                    break;
                case 4 :
                    Assert.assertNull(list.get(i));
                    break;
                case 5 :
                    Assert.assertNull(list.get(i));
                    break;
            }
        }

        Collections.sort(list,new PhantomDefaultComparable(PhantomComparable.EnumSort.DESC));
        for(int i=0,len=list.size();i<len;i++){
            switch (i){
                case 0 :
                    Assert.assertEquals(3,list.get(i));
                    break;
                case 1 :
                    Assert.assertEquals(2,list.get(i));
                    break;
                case 2 :
                    Assert.assertEquals(2,list.get(i));
                    break;
                case 3 :
                    Assert.assertEquals(0,list.get(i));
                    break;
                case 4 :
                    Assert.assertNull(list.get(i));
                    break;
                case 5 :
                    Assert.assertNull(list.get(i));
                    break;

            }
        }
    }

    @Test
    public void sortInteger(){
        List<Object> list = new ArrayList<Object>();
        list.add(new Integer(0));
        list.add(new Integer(3));
        list.add(null);
        list.add(new Integer(2));
        list.add(new Integer(2));
        list.add(null);
        Collections.sort(list,new PhantomDefaultComparable(PhantomComparable.EnumSort.ASC));
        for(int i=0,len=list.size();i<len;i++){
            switch (i){
                case 0 :
                    Assert.assertEquals(new Integer(0),list.get(i));
                    break;
                case 1 :
                    Assert.assertEquals(new Integer(2),list.get(i));
                    break;
                case 2 :
                    Assert.assertEquals(new Integer(2),list.get(i));
                    break;
                case 3 :
                    Assert.assertEquals(new Integer(3),list.get(i));
                    break;
                case 4 :
                    Assert.assertNull(list.get(i));
                    break;
                case 5 :
                    Assert.assertNull(list.get(i));
                    break;
            }
        }

        Collections.sort(list,new PhantomDefaultComparable(PhantomComparable.EnumSort.DESC));
        for(int i=0,len=list.size();i<len;i++){
            switch (i){
                case 0 :
                    Assert.assertEquals(new Integer(3),list.get(i));
                    break;
                case 1 :
                    Assert.assertEquals(new Integer(2),list.get(i));
                    break;
                case 2 :
                    Assert.assertEquals(new Integer(2),list.get(i));
                    break;
                case 3 :
                    Assert.assertEquals(new Integer(0),list.get(i));
                    break;
                case 4 :
                    Assert.assertNull(list.get(i));
                    break;
                case 5 :
                    Assert.assertNull(list.get(i));
                    break;
            }
        }

    }

}
