package com.phantom.util.string;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

/**
 * @Author 张志凯 https://github.com/Law-God/phantom-util
 * phantom-util
 * com.phantom.util.string.StringUtil
 * 2016-07-27 17:30
 */
public class StringUtilTest {
    @Test
    public void struct(){
        StringUtil s = new StringUtil();
    }

    @Test
    public void isString(){
        Assert.assertFalse(StringUtil.isString(null));
        Assert.assertFalse(StringUtil.isString(new ArrayList()));
        Assert.assertTrue(StringUtil.isString(""));
    }

    @Test
    public void isEmpty(){
        Assert.assertTrue(StringUtil.empty(null));
        Assert.assertTrue(StringUtil.empty(""));
        Assert.assertFalse(StringUtil.empty("String"));
    }

    @Test
    public void split(){
        Assert.assertNull(StringUtil.split(null,""));
        Assert.assertNull(StringUtil.split("",null));
        Assert.assertNotNull(StringUtil.split("a,b,c,,",","));
        Assert.assertTrue(3==StringUtil.split("a,b,c,,",",").length);
        Assert.assertTrue(5==StringUtil.split("a,b,c,,",",",true).length);
    }

    @Test
    public void encryptTelephone(){
        Assert.assertNull(StringUtil.encryptTelephone(null));
        Assert.assertEquals("",StringUtil.encryptTelephone(""));
        Assert.assertEquals("123",StringUtil.encryptTelephone("123"));
        Assert.assertEquals("123****8901",StringUtil.encryptTelephone("12345678901"));
    }
}
