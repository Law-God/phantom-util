package com.phantom.util.math;

import org.apache.log4j.Logger;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * @Author 张志凯 https://github.com/Law-God/phantom-util
 * util
 * com.phantom.util.math.DoubleUtil
 * 2016-08-10 14:39
 */
public final class DoubleUtil {
    private static final Logger log = Logger.getLogger(DoubleUtil.class);
    private static int DEF_DIV_SCALE = 10;

    /**
     * 加法
     * @param d1
     * @param d2
     * @return
     */
    public static double add(double d1,double d2){
        BigDecimal b1 = new BigDecimal(String.valueOf(d1));
        BigDecimal b2 = new BigDecimal(String.valueOf(d2));
        return b1.add(b2).doubleValue();
    }

    /**
     * 加法
     * 多个double相加
     * @param d1
     * @param d2
     * @param d3
     * @return
     */
    public static double add(double d1,double d2,double... d3){
        double sum = 0;
        sum = add(d1,d2);
        for(double d : d3){
            sum = add(sum,d);
        }
        return sum;
    }

    /**
     * 减法
     * @param d1
     * @param d2
     * @return
     */
    public static double sub(double d1,double d2){
        BigDecimal b1 = new BigDecimal(String.valueOf(d1));
        BigDecimal b2 = new BigDecimal(String.valueOf(d2));
        return b1.subtract(b2).doubleValue();
    }

    /**
     * 减法
     * 多个double相减
     * @param d1
     * @param d2
     * @param d3
     * @return
     */
    public static double sub(double d1,double d2,double... d3){
        double sum = 0;
        sum = sub(d1,d2);
        for(double d : d3){
            sum = sub(sum,d);
        }
        return sum;
    }

    /**
     * 乘法
     * @param d1
     * @param d2
     * @return
     */
    public static double mul(double d1,double d2){
        BigDecimal b1 = new BigDecimal(String.valueOf(d1));
        BigDecimal b2 = new BigDecimal(String.valueOf(d2));
        return b1.multiply(b2).doubleValue();
    }

    /**
     * 乘法
     * @param d1
     * @param d2
     * @return
     */
    public static double mul(double d1,double d2,double... d3){
        double sum = 0;
        sum = mul(d1,d2);
        for(double d : d3){
            sum = mul(sum,d);
        }
        return sum;
    }

    /**
     * 除法
     * 默认小数点10位
     * @param d1
     * @param d2
     * @return
     */
    public static double div(double d1,double d2){
        return div(d1,d2,DEF_DIV_SCALE);
    }

    /**
     * 除法
     * 默认小数点10位
     * @param d1
     * @param d2
     * @return
     */
    public static double div(double d1,double d2,double... d3){
        return div(d1,d2,DEF_DIV_SCALE,d3);
    }

    public static double div(double d1,double d2,int scale,double... d3){
        if(scale < 0){
            String errorMsg = "除法的商位数必须为自然数";
            IllegalArgumentException e = new IllegalArgumentException(errorMsg);
            log.error(errorMsg,e);
            throw e;
        }
        BigDecimal b1 = new BigDecimal(String.valueOf(d1));
        BigDecimal b2 = new BigDecimal(String.valueOf(d2));
        double sum = 0;
        sum = b1.divide(b2,scale,BigDecimal.ROUND_HALF_UP).doubleValue();
        for(double d : d3){
            BigDecimal sumB = new BigDecimal(sum);
            BigDecimal dB = new BigDecimal(d);
            sum = sumB.divide(dB,scale,BigDecimal.ROUND_HALF_UP).doubleValue();
        }
        return sum;
    }

    /**
     * 保留小数点几位数
     * @param d1
     * @param scale
     * @return
     */
    public static double round(double d1,int scale){
        if(scale < 0){
            String errorMsg = "除法的商位数必须为自然数";
            IllegalArgumentException e = new IllegalArgumentException(errorMsg);
            log.error(errorMsg,e);
            throw e;
        }
        BigDecimal b1 = new BigDecimal(String.valueOf(d1));
        BigDecimal b2 = new BigDecimal("1");
        return b1.divide(b2,scale,BigDecimal.ROUND_HALF_UP).doubleValue();
    }
}
