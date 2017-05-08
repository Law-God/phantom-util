package com.phantom.util.compare;

import com.phantom.util.collection.MapUtil;
import org.apache.log4j.Logger;

import java.util.Map;
import java.util.Set;

/**
 * @Author 张志凯 https://github.com/Law-God/phantom-util
 * util
 * com.phantom.util.compare.PhantomMapComparable
 * 2016-08-15 15:34
 */
public class PhantomMapComparable extends PhantomComparable {
    private final Logger log = Logger.getLogger(PhantomMapComparable.class);
    private EnumSort sortValue;
    private boolean keyOrValue;//按Mmp集合key比较还是value比较

    public PhantomMapComparable(EnumSort sortValue, boolean keyOrValue){
        this.sortValue = sortValue;
        this.keyOrValue = keyOrValue;
    }

    @Override
    public int compare(Object o1, Object o2) {
        //将null值置为最后
        int nullLast = putNullLast(o1,o2);
        if(0 != nullLast){
            return nullLast;
        }

        if(!keyOrValue){
            return  compareByKey(o1,o2);
        }else{
            return  compareByValue(o1,o2);
        }
    }

    /**
     * 根据Map集合key值进行比较
     * @param o1
     * @param o2
     * @return
     */
    private int compareByKey(Object o1,Object o2){
        Map m1 = (Map)o1;
        Map m2 = (Map)o2;
        Object k1 = MapUtil.getFirstKey(m1);
        Object k2 = MapUtil.getFirstKey(m2);;

        int nullLast = putNullLast(k1,k2);
        if(0 != nullLast){
            return nullLast;
        }
        //使用String原生compateTo方法实现比较
        return stringCompareTo(k1,k2,sortValue);
    }

    /**
     * 根据Map集合value值进行比较
     * @param o1
     * @param o2
     * @return
     */
    private int compareByValue(Object o1,Object o2){
        Map m1 = (Map)o1;
        Map m2 = (Map)o2;
        Object v1 = MapUtil.getFirstValue(m1);
        Object v2 = MapUtil.getFirstValue(m2);;

        int nullLast = putNullLast(v1,v2);
        if(0 != nullLast){
            return nullLast;
        }
        //使用String原生compateTo方法实现比较
        return stringCompareTo(v1,v2,sortValue);
    }
}
