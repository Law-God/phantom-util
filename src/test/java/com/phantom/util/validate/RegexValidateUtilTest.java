package com.phantom.util.validate;

import junit.framework.Assert;
import org.junit.Test;

/**
 * @Author 张志凯 https://github.com/Law-God/phantom-util
 * util
 * com.phantom.util.validate.RegexValidateUtilTest
 * 2016-08-03 9:49
 */
public class RegexValidateUtilTest {
    @Test
    public void struct(){
        RegexValidateUtil r = new RegexValidateUtil();
    }

    @Test
    public void hasChinese(){
        Assert.assertFalse(RegexValidateUtil.hasChinese(null));
        Assert.assertFalse(RegexValidateUtil.hasChinese("abc-=[]12dfs"));
        Assert.assertTrue(RegexValidateUtil.hasChinese("abc-=[]12dfs啊"));
    }


    @Test
    public void chinese(){
        String str = "张三";
        Assert.assertTrue(RegexValidateUtil.isChinese(str));
        Assert.assertFalse(RegexValidateUtil.isChinese(null));

        Assert.assertTrue(RegexValidateUtil.isChinese(str,1,null));
        Assert.assertTrue(RegexValidateUtil.isChinese(str,1,3));
        Assert.assertFalse(RegexValidateUtil.isChinese(str,1,1));

        Assert.assertTrue(RegexValidateUtil.isChinese(str,null,null));
    }

    @Test
    public void email(){
        Assert.assertFalse(RegexValidateUtil.isEmail(null));
        Assert.assertFalse(RegexValidateUtil.isEmail(""));

        String email = "767030396@qq.com";
        Assert.assertTrue(RegexValidateUtil.isEmail(email));

        String email2 = "阿十点半@q.com";
        Assert.assertFalse(RegexValidateUtil.isEmail(email2));
    }

    @Test
    public void telephone(){
        Assert.assertFalse(RegexValidateUtil.isTelephone(null));
        Assert.assertFalse(RegexValidateUtil.isTelephone(""));

        for(int i=0;i<10;i++){
            String telephone = "1"+i+"000000000";
            if(i == 3 || i==4 || i== 5 || i== 7 || i== 8){
                Assert.assertTrue(RegexValidateUtil.isTelephone(telephone));
            }else{
                Assert.assertFalse(RegexValidateUtil.isTelephone(telephone));
            }
        }
    }

    @Test
    public void ip(){
        Assert.assertFalse(RegexValidateUtil.isIp(null));
        Assert.assertFalse(RegexValidateUtil.isIp(""));
        Assert.assertFalse(RegexValidateUtil.isIp("a.b.c.d"));
        Assert.assertFalse(RegexValidateUtil.isIp("-1.0.0.0"));
        Assert.assertFalse(RegexValidateUtil.isIp("-1.0.0"));
        for(int i=0;i<256;i++){
            String ip = i+"."+i+"."+i+"."+i;
            Assert.assertTrue(RegexValidateUtil.isIp(ip));
        }
        Assert.assertFalse(RegexValidateUtil.isIp("256.256.256.256"));
    }

    @Test
    public void qq(){
        Assert.assertFalse(RegexValidateUtil.isQQ(null));
        Assert.assertFalse(RegexValidateUtil.isQQ(""));
        Assert.assertFalse(RegexValidateUtil.isQQ("0"));
        Assert.assertFalse(RegexValidateUtil.isQQ("10000"));
        Assert.assertFalse(RegexValidateUtil.isQQ("90000"));

        Assert.assertTrue(RegexValidateUtil.isQQ("100000"));
        Assert.assertTrue(RegexValidateUtil.isQQ("100000000000"));
        Assert.assertFalse(RegexValidateUtil.isQQ("1000000000000"));

        Assert.assertTrue(RegexValidateUtil.isQQ("900000"));
        Assert.assertTrue(RegexValidateUtil.isQQ("900000000000"));
        Assert.assertFalse(RegexValidateUtil.isQQ("9000000000000"));
    }

    @Test
    public void doubleByteChar(){
        Assert.assertFalse(RegexValidateUtil.doubleByteChar(null));
        Assert.assertFalse(RegexValidateUtil.doubleByteChar(""));
        Assert.assertFalse(RegexValidateUtil.doubleByteChar("a"));
        Assert.assertTrue(RegexValidateUtil.doubleByteChar("张"));
    }

    @Test
    public void isDate(){
        Assert.assertFalse(RegexValidateUtil.isDate(null));
        Assert.assertFalse(RegexValidateUtil.isDate(""));
        Assert.assertFalse(RegexValidateUtil.isDate("2014"));
        Assert.assertFalse(RegexValidateUtil.isDate("2015-02-29"));
        Assert.assertTrue(RegexValidateUtil.isDate("2016-08-03"));
        Assert.assertTrue(RegexValidateUtil.isDate("2016-08-03 21:45:02"));
    }

    @Test
    public void isNumber(){
        Assert.assertFalse(RegexValidateUtil.isNumber(null));
        Assert.assertFalse(RegexValidateUtil.isNumber(""));
        Assert.assertFalse(RegexValidateUtil.isNumber("12稍等s"));
        Assert.assertTrue(RegexValidateUtil.isNumber("0123"));
    }
}
