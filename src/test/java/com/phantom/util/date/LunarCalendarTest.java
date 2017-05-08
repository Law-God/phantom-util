package com.phantom.util.date;

import junit.framework.Assert;
import org.junit.Test;

import java.util.Date;

/**
 * @Author 张志凯 https://github.com/Law-God/phantom-util
 * util
 * com.phantom.util.date.LunarCalendarTest
 * 2016-09-07 14:19
 */
public class LunarCalendarTest {
    @Test
    public void struct(){
        long currTime = 1473232882056L;
        LunarCalendar lunarCalendar = new LunarCalendar(currTime);
        Assert.assertEquals("猴",lunarCalendar.getAnimalString());
        Assert.assertEquals("二零一六年八月初七日",lunarCalendar.getDateString());
    }

    @Test
    public void struct2(){
        new LunarCalendar(new Date());
        new LunarCalendar(null);
    }

}
