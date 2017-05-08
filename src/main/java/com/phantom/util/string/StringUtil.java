package com.phantom.util.string;

import org.apache.log4j.Logger;

/**
 * @Author 张志凯 https://github.com/Law-God/phantom-util
 * phantom-util
 * com.phantom.util.string.StringUtil
 * 2016-07-27 17:30
 */
public final class StringUtil {
    private final Logger log = Logger.getLogger(StringUtil.class);

    /**
     * 字符串类型判断
     * @param object
     * @return
     */
    public static boolean isString(Object object){
        return object == null ? false : (object instanceof String ? true : false);
    }

    /**
     * 判断字符串是否为空
     * @param str
     * @return
     * */
    public static boolean empty(String str){
        return  str == null || str.length() == 0 ? true : false;
    }

    /**
     * 字符串根据指定字符分割字符串
     * @param str
     * @param reg
     * @return
     */
    public static String[] split(String str,String reg){
        return split(str,reg,false);
    }

    /**
     * 字符串根据指定字符分割字符串
     * @param str
     * @param reg
     * @param last 遇到最后字符为分隔符时，true则分割最后空值保留,false则不保留最后空值
     * @return
     */
    public static String[] split(String str,String reg,boolean last){
        if(str == null || reg == null) {
            return null;
        }
        if(last){
            return str.split(reg,-1);
        }else{
            return str.split(reg);
        }
    }

    /**
     * 将手机号中间4位用*号替换
     * @param str
     * @return
     */
    public static String encryptTelephone(String str){
        if(empty(str) || str.length()<11)
            return str;
        return str.replaceAll("(\\d{3,})\\d{4}(\\d{4})","$1****$2");
    }
}
