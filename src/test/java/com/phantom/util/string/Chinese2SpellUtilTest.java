package com.phantom.util.string;

import com.github.stuxuhai.jpinyin.PinyinException;
import org.junit.Assert;
import org.junit.Test;

/**
 * @Author 张志凯 https://github.com/Law-God/phantom-util
 * util
 * com.phantom.util.string.Chinese2SpellUtilTest
 * 2016-08-04 10:20
 */
public class Chinese2SpellUtilTest {
    @Test
    public void struct(){
        Chinese2SpellUtil c = new Chinese2SpellUtil();
    }

    @Test
    public void c2s(){
        Assert.assertNull(Chinese2SpellUtil.c2s(null));
        Assert.assertEquals("",Chinese2SpellUtil.c2s(""));

        String s = "长沙";

        System.out.println(Chinese2SpellUtil.c2s(s));
        //Assert.assertEquals("zhangsan",Chinese2SpellUtil.c2s(s));

        String s2 = "a张三";
        //Assert.assertEquals("azhangsan",Chinese2SpellUtil.c2s(s2));
    }

    @Test
    public void c2s2(){
        String s = "长沙";

        System.out.println(Chinese2SpellUtil.c2s(s,Chinese2SpellUtil.DEF_SPLIT));
    }
}
