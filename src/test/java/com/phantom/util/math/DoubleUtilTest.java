package com.phantom.util.math;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

/**
 * @Author 张志凯 https://github.com/Law-God/phantom-util
 * util
 * com.phantom.util.math.DoubleUtilTest
 * 2016-08-12 13:59
 */
public class DoubleUtilTest {
    @Test
    public void struct(){
        DoubleUtil d = new DoubleUtil();
    }

    @Test
    public void add(){
        Assert.assertTrue(5.7 == DoubleUtil.add(3.3,2.4));
        Assert.assertTrue(8.9 == DoubleUtil.add(3.3,2.4,3.2));
        Assert.assertTrue(11.3 == DoubleUtil.add(3.3,2.4,3.2,2.4));
    }

    @Test
    public void sub(){
        Assert.assertTrue(0.9 == DoubleUtil.sub(3.3,2.4));
        Assert.assertTrue(0.6 == DoubleUtil.sub(3.3,2.4,0.3));
    }

    @Test
    public void mul(){
        Assert.assertTrue(7.92 == DoubleUtil.mul(3.3,2.4));
        Assert.assertTrue(15.048 == DoubleUtil.mul(3.3,2.4,1.9));
    }

    @Test(expected = IllegalArgumentException.class)
    public void div(){
        Assert.assertTrue(0.3333 == DoubleUtil.div(1,3,4));
        Assert.assertTrue(0.3333333333 == DoubleUtil.div(1,3));
        Assert.assertTrue(0.3333 == DoubleUtil.div(1,3,-1));
        Assert.assertTrue(0.3333333333 == DoubleUtil.div(1,3,1d));
        Assert.assertTrue(0.0370 == DoubleUtil.div(1,3,4,9));
        Assert.assertTrue(0.3333333333 == DoubleUtil.div(1,3));
        DoubleUtil.div(1,2,-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void round(){
        Assert.assertTrue(0.3333 == DoubleUtil.round(0.333333,4));
        Assert.assertTrue(0.3333 == DoubleUtil.round(0.333333,-1));
    }

    public static void main(String[] args){
        double a = (3.3+2.4);
        System.out.println(a);
        System.out.println(DoubleUtil.add(3.3,2.4));

        double b = (3.3+2.4+3.2);
        System.out.println(b);

        double c = (3.3+2.4+3.2+2.4);
        System.out.println(c);


        System.out.println(3.3-2.4);
        System.out.println(DoubleUtil.sub(3.3,2.4));

        System.out.println("3.3-2.4-2.4 = " + (3.3-2.4-0.3));

        System.out.println(3.3 * 2.4);
        System.out.println(DoubleUtil.mul(3.3,2.4));

        System.out.println("3.3 * 2.4*1.1 = "+(3.3 * 2.4*1.9));

        System.out.println("1 / 3 = " + DoubleUtil.div(1,3,4));

        System.out.println("1/3/9 = " + (1/3.0/9.0));
        System.out.println("1/3/9 = " + DoubleUtil.div(1,3,4,9));

    }
}
