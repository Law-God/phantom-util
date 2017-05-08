package com.phantom.util.date;

import com.phantom.util.constant.PatternConstant;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author 张志凯 https://github.com/Law-God/phantom-util
 * phantom-util
 * com.phantom.util.date.DateUtilTest
 * 2016-07-28 19:23
 */
public class DateUtilTest {

    @Test
    public void struct(){
        DateUtil d = new DateUtil();
    }

    @Test
    public void nowDate(){
        Pattern p = Pattern.compile(PatternConstant.PATTERN_DATE);
        for(int i=1000;i<9999;i++){
            for(int j=1;j<=12;j++){
                if(j==1 || j==3 || j==5 || j==7 || j==8 || j==10 || j==12){

                    String date1 = i + (j < 10 ? "-0"+j :"-"+j)+"-00";
                    String date2 = i + (j < 10 ? "-0"+j :"-"+j)+"-01";
                    String date3 = i + (j < 10 ? "-0"+j :"-"+j)+"-31";
                    String date4 = i + (j < 10 ? "-0"+j :"-"+j)+"-32";
                    Assert.assertFalse(p.matcher(date1).matches());
                    Assert.assertTrue(p.matcher(date2).matches());
                    Assert.assertTrue(p.matcher(date3).matches());
                    Assert.assertFalse(p.matcher(date4).matches());
                }else if(j==2){
                    if((i%4 == 0 && i%100 != 0)|| i%400 == 0){
                        String date1 = i + "-02-00";
                        String date2 = i + "-02-01";
                        String date3 = i + "-02-29";
                        String date4 = i + "-02-30";
                        Assert.assertFalse(p.matcher(date1).matches());
                        Assert.assertTrue(p.matcher(date2).matches());
                        Assert.assertTrue(p.matcher(date3).matches());
                        Assert.assertFalse(p.matcher(date4).matches());
                    }else{
                        String date1 = i + "-02-00";
                        String date2 = i + "-02-01";
                        String date3 = i + "-02-28";
                        String date4 = i + "-02-29";
                        Assert.assertFalse(p.matcher(date1).matches());
                        Assert.assertTrue(p.matcher(date2).matches());
                        Assert.assertTrue(p.matcher(date3).matches());
                        Assert.assertFalse(p.matcher(date4).matches());
                    }
                }else{
                    String date1 = i + (j < 10 ? "-0"+j :"-"+j)+"-00";
                    String date2 = i + (j < 10 ? "-0"+j :"-"+j)+"-01";
                    String date3 = i + (j < 10 ? "-0"+j :"-"+j)+"-30";
                    String date4 = i + (j < 10 ? "-0"+j :"-"+j)+"-31";
                    Assert.assertFalse(p.matcher(date1).matches());
                    Assert.assertTrue(p.matcher(date2).matches());
                    Assert.assertTrue(p.matcher(date3).matches());
                    Assert.assertFalse(p.matcher(date4).matches());
                }
            }
        }

        //System.out.println(p.matcher("2003-02-20").matches());
        //System.out.println(DateUtil.nowDate());
        //System.out.println(p.matcher(DateUtil.nowDate()).matches());
        String nowDate = DateUtil.nowDate();
        Assert.assertTrue(p.matcher(nowDate).matches());
    }

    @Test
    public void nowTime(){
        Pattern p = Pattern.compile(PatternConstant.PATTERN_TIME);
        for(int i=0;i<24;i++){
            for(int j=0;j<60;j++){
                String time = ((i<10) ? ("0"+i) : i)+":"+ ((j<10) ? ("0"+j) : j)+":"+((j<10) ? ("0"+j) : j);
                Assert.assertTrue(p.matcher(time).matches());
            }
        }
        Assert.assertFalse(p.matcher("24:00:00").matches());

        String nowTime = DateUtil.nowTime();
        Assert.assertTrue(p.matcher(nowTime).matches());

    }

    @Test
    public void nowDateTime(){
        Pattern p = Pattern.compile(PatternConstant.PATTERN_DATE_TIME);
        for(int i=1000;i<9999;i++){
            for(int j=1;j<=12;j++){
                if(j==1 || j==3 || j==5 || j==7 || j==8 || j==10 || j==12){

                    String date1 = i + (j < 10 ? "-0"+j :"-"+j)+"-00" + " 00:00:00";
                    String date2 = i + (j < 10 ? "-0"+j :"-"+j)+"-01"+ " 00:00:01";
                    String date3 = i + (j < 10 ? "-0"+j :"-"+j)+"-31"+ " 23:59:59";
                    String date4 = i + (j < 10 ? "-0"+j :"-"+j)+"-32"+ " 24:00:00";
                    Assert.assertFalse(p.matcher(date1).matches());
                    Assert.assertTrue(p.matcher(date2).matches());
                    Assert.assertTrue(p.matcher(date3).matches());
                    Assert.assertFalse(p.matcher(date4).matches());
                }else if(j==2){
                    if((i%4 == 0 && i%100 != 0)|| i%400 == 0){
                        String date1 = i + "-02-00"+ " 00:00:00";
                        String date2 = i + "-02-01"+ " 00:00:01";
                        String date3 = i + "-02-29"+ " 23:59:59";
                        String date4 = i + "-02-30"+ " 24:00:00";
                        Assert.assertFalse(p.matcher(date1).matches());
                        Assert.assertTrue(p.matcher(date2).matches());
                        Assert.assertTrue(p.matcher(date3).matches());
                        Assert.assertFalse(p.matcher(date4).matches());
                    }else{
                        String date1 = i + "-02-00"+ " 00:00:00";
                        String date2 = i + "-02-01"+ " 00:00:01";
                        String date3 = i + "-02-28"+ " 23:59:59";
                        String date4 = i + "-02-29"+ " 24:00:00";
                        Assert.assertFalse(p.matcher(date1).matches());
                        Assert.assertTrue(p.matcher(date2).matches());
                        Assert.assertTrue(p.matcher(date3).matches());
                        Assert.assertFalse(p.matcher(date4).matches());
                    }
                }else{
                    String date1 = i + (j < 10 ? "-0"+j :"-"+j)+"-00"+ " 00:00:00";
                    String date2 = i + (j < 10 ? "-0"+j :"-"+j)+"-01"+ " 00:00:01";
                    String date3 = i + (j < 10 ? "-0"+j :"-"+j)+"-30"+ " 23:59:59";
                    String date4 = i + (j < 10 ? "-0"+j :"-"+j)+"-31"+ " 24:00:00";
                    Assert.assertFalse(p.matcher(date1).matches());
                    Assert.assertTrue(p.matcher(date2).matches());
                    Assert.assertTrue(p.matcher(date3).matches());
                    Assert.assertFalse(p.matcher(date4).matches());
                }
            }
        }

        String nowDateTime = DateUtil.nowDateTime();
        Assert.assertTrue(p.matcher(nowDateTime).matches());
    }

    @Test
    public void dateStr1(){
        Assert.assertNull(DateUtil.date2Str(null));
        String dateStr = DateUtil.date2Str(new Date());
        Pattern p = Pattern.compile(PatternConstant.PATTERN_DATE);
        Assert.assertTrue(p.matcher(dateStr).matches());
    }

    @Test
    public void dateStr2(){
        Assert.assertNull(DateUtil.date2Str(null,"yyyy-MM-dd"));
        Assert.assertNull(DateUtil.date2Str(new Date(),null));
        String dateStr = DateUtil.date2Str(new Date(),"yyyy-MM-dd");
        Pattern p = Pattern.compile(PatternConstant.PATTERN_DATE);
        Assert.assertTrue(p.matcher(dateStr).matches());

        String dateStr2 = DateUtil.date2Str(new Date(),"yyyy-MM-dd HH:mm:ss");
        Pattern p2 = Pattern.compile(PatternConstant.PATTERN_DATE_TIME);
        Assert.assertTrue(p2.matcher(dateStr2).matches());

        try{
            String dateStr3 = DateUtil.date2Str(new Date(),"yyyy-MM-dd HH:mm");
        }catch (RuntimeException e){}
    }

    @Test
    public void parseDate1(){
        Assert.assertNull(DateUtil.parseDate(""));
        Assert.assertNull(DateUtil.parseDate(null));
        String date = "2016-08-02";
        Assert.assertNotNull(DateUtil.parseDate(date));
        try{
            Assert.assertNull(DateUtil.parseDate("abc"));
        }catch (Exception e){}
    }

    @Test
    public void parseDate2(){
        Assert.assertNull(DateUtil.parseDate("","yyyy-MM-dd"));
        Assert.assertNull(DateUtil.parseDate("2016-08-02",""));
        Assert.assertNotNull(DateUtil.parseDate("2016-08-02","yyyy-MM-dd"));
        Assert.assertNotNull(DateUtil.parseDate("15:32:00","HH:mm:ss"));
        Assert.assertNotNull(DateUtil.parseDate("2016-08-02 15:32:00","yyyy-MM-dd HH:mm:ss"));
        try{
            Assert.assertNull(DateUtil.parseDate("2016-08-02 15:32:00:999","yyyy-MM-dd HH:mm:ss:SSS"));
        }catch (Exception e){}
        try{
            Assert.assertNull(DateUtil.parseDate("abc","yyyy-MM-dd HH:mm:ss"));
        }catch (Exception e){}
    }

    @Test
    public void addYear(){
        Date date = DateUtil.parseDate("2016-08-02");

        Assert.assertNull(DateUtil.addYear(null,0));
        Date date2 = DateUtil.addYear(date,4);
        Assert.assertEquals(2020,DateUtil.getDateYear(date2));

        Assert.assertNull(DateUtil.addMonth(null,0));
        Date date3 = DateUtil.addMonth(date,4);
        Assert.assertEquals(11,DateUtil.getDateMonth(date3));

        Assert.assertNull(DateUtil.addDay(null,0));
        Date date4 = DateUtil.addDay(date,30);
        Assert.assertEquals(1,DateUtil.getDateDay(date4));

        try{
            Assert.assertNull(DateUtil.getDateCompose(null));
        }catch (RuntimeException e){}
    }

    @Test
    public void getBetweenDays(){
        Date date1 = DateUtil.parseDate("2016-08-06 23:59:59","yyyy-MM-dd HH:mm:ss");
        Date date2 = DateUtil.parseDate("2015-08-02 00:00:01","yyyy-MM-dd HH:mm:ss");

        try{
            Assert.assertNull(DateUtil.getBetweenDays(null,date1));
        }catch (RuntimeException e){}

        try{
            Assert.assertNull(DateUtil.getBetweenDays(date2,null));
        }catch (RuntimeException e){}

        Assert.assertEquals(370,DateUtil.getBetweenDays(date1,date2));
        Assert.assertEquals(-370,DateUtil.getBetweenDays(date2,date1));

    }
}
