package com.phantom.util.collection;

import org.apache.log4j.Logger;

import java.util.List;
import java.util.Map;

/**
 * @Author 张志凯 https://github.com/Law-God/phantom-util
 * util
 * com.phantom.util.collection.ListUtil
 * 2016-08-12 9:16
 */
public final class ListUtil {
    private final Logger log = Logger.getLogger(ListUtil.class);
    /**
     *
     * @param list 要取子集的集合
     * @param pageNo 第几页
     * @param pageSize 每页显示条数
     * @return Object
     */
    public static List listPage(List list,int pageNo,int pageSize ){
        if(list == null)
            return null;

        int size = list.size();
        if(size == 0)
            return list;

        pageNo = pageNo < 1 ? 1 : pageNo;
        pageSize = pageSize < 0 ? 0 : pageSize;

        int fromIndex = (pageNo-1) * pageSize;
        int toIndex = pageNo * pageSize;
        toIndex = toIndex > size ? size : toIndex;
        return list.subList(fromIndex,toIndex);
    }

}
