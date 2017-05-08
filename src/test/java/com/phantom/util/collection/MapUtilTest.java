package com.phantom.util.collection;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author 张志凯 https://github.com/Law-God/phantom-util
 * util
 * com.phantom.util.collection.MapUtilTest
 * 2016-08-15 16:14
 */
public class MapUtilTest {
    @Test
    public void struct(){
        MapUtil m = new MapUtil();
    }

    @Test
    public void getFirstKey(){
        Map m = null;
        Assert.assertNull(MapUtil.getFirstKey(m));

        m = new HashMap();
        m.put(null,null);

        Assert.assertNull(MapUtil.getFirstKey(m));

        m.clear();
        m.put("1",1);
        m.put("2",2);
        Assert.assertNotNull(MapUtil.getFirstKey(m));

    }

    @Test
    public void getFirstValue(){
        Map m = null;
        Assert.assertNull(MapUtil.getFirstValue(m));

        m = new HashMap();
        m.put(null,null);

        Assert.assertNull(MapUtil.getFirstValue(m));

        m.clear();
        m.put("1",1);
        m.put("2",2);
        Assert.assertNotNull(MapUtil.getFirstValue(m));

    }

}
