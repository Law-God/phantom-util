package com.phantom.util.compare;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

/**
 * @Author 张志凯 https://github.com/Law-God/phantom-util
 * util
 * com.phantom.util.compare.PhantomStringComparable
 * 2016-08-12 14:44
 * List集合中元素实现了compareTo都可用此比较器
 */
public class PhantomDefaultComparable extends PhantomComparable{
    private final Logger log = Logger.getLogger(PhantomDefaultComparable.class);
    private EnumSort sortValue;

    public PhantomDefaultComparable(EnumSort sort){
        this.sortValue = sort;
    }

    public int compare(Object o1,Object o2) {
        //将null值置为最后
        int nullLast = putNullLast(o1,o2);
        if(0 != nullLast){
            return nullLast;
        }

        //使用String原生compateTo方法实现比较
        return stringCompareTo(o1,o2,sortValue);
    }
}
