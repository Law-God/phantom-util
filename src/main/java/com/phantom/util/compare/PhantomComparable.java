package com.phantom.util.compare;

import org.apache.log4j.Logger;

import java.util.Comparator;

/**
 * @Author 张志凯 https://github.com/Law-God/phantom-util
 * util
 * com.phantom.util.compare.PhantomCompare
 * 2016-08-12 14:29
 * 排序比较器
 */
public abstract class PhantomComparable implements Comparator{
    private final Logger log = Logger.getLogger(PhantomComparable.class);
    public abstract int compare(Object o1, Object o2);

    /**
     * 将集合中null放置最后位置
     * @param o1
     * @param o2
     * @return
     */
    public int putNullLast(Object o1,Object o2){
        //将null值放置最后
        if(o1 == null){
            return 1;
        }else if(o2 == null){
            return -1;
        }else{
            return 0;
        }
    }

    /**
     * 使用String的原生方法compareTo实现比较
     * @param o1
     * @param o2
     * @param sort
     * @return
     */
    public int stringCompareTo(Object o1,Object o2,EnumSort sort){
        String s1 = o1.toString();
        String s2 = o2.toString();
        if (sort == EnumSort.ASC){
            return s1.compareTo(s2);
        }else if(sort == EnumSort.DESC){
            return -s1.compareTo(s2);
        }else {
            return 0;
        }
    }

    /**
     * 枚举排序字段
     */
    public enum EnumSort{
        ASC,DESC,DEFAULT
    }
}
