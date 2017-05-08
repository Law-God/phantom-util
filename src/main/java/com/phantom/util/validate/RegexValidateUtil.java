package com.phantom.util.validate;

import com.phantom.util.constant.PatternConstant;
import com.phantom.util.string.StringUtil;
import org.apache.log4j.Logger;

/**
 * @Author 张志凯 https://github.com/Law-God/phantom-util
 * util
 * com.phantom.util.validate.ValidateUtil
 * 2016-08-03 9:16
 */
public final class RegexValidateUtil {
    private final Logger log = Logger.getLogger(RegexValidateUtil.class);

    /**
     * 全部是中文字符串匹配
     * @param string
     * @return
     */
    public static boolean isChinese(String string){
        return isChinese(string,null,null);
    }

    /**
     * 包含中文匹配
     * @param string
     * @return
     */
    public static boolean hasChinese(String string){
        if(string == null)
            return false;
        return PatternUtil.find(string,PatternConstant.CHINESE_REGEX_DEFAULT);
    }

    /**
     * 中文字符串带长度匹配
     * @param string
     * @param index
     * @param end
     * @return
     */
    public static boolean isChinese(String string,Integer index,Integer end){
        if(string == null)
            return false;
        String regex = PatternConstant.CHINESE_REGEX_EXTEND;
        String indexStr = index == null ? "1" : String.valueOf(index);
        String endStr = end == null ? "" : String.valueOf(end);
        regex = String.format(regex, indexStr,endStr);
        return  PatternUtil.match(string,regex);
    }

    /**
     * 邮箱地址匹配
     * @param string
     * @return
     */
    public static boolean isEmail(String string){
        if(StringUtil.empty(string))
            return false;
        return PatternUtil.match(string,PatternConstant.EMAIL_REGEX);
    }

    /**
     * 手机号匹配
     * @param string
     * @return
     */
    public static boolean isTelephone(String string){
        if(StringUtil.empty(string))
            return false;
        return PatternUtil.match(string,PatternConstant.TELEPHONE_REGEX);
    }

    /**
     * ip地址匹配
     * @param string
     * @return
     */
    public static boolean isIp(String string){
        if(StringUtil.empty(string))
            return false;
        return PatternUtil.match(string,PatternConstant.IP_REGEX);
    }

    /**
     * qq号匹配
     * @param string
     * @return
     */
    public static boolean isQQ(String string){
        if(StringUtil.empty(string))
            return false;
        return PatternUtil.match(string,PatternConstant.QQ_REGEX);
    }

    /**
     * 双字节匹配
     * @param string
     * @return
     */
    public static boolean doubleByteChar(String string){
        if(StringUtil.empty(string))
            return false;
        return PatternUtil.match(string,PatternConstant.DOUBLE_BYTE_CHAR);
    }

    /**
     * 日期格式 yyyy-MM-dd  yyyy-MM-dd HH:mm:ss
     * @param string
     * @return
     */
    public static boolean isDate(String string){
        if(StringUtil.empty(string))
            return  false;
        return PatternUtil.match(string,PatternConstant.PATTERN_DATE) || PatternUtil.match(string,PatternConstant.PATTERN_DATE_TIME);
    }

    public static boolean isNumber(String string){
        if(StringUtil.empty(string))
            return false;
        return PatternUtil.match(string,PatternConstant.NUMBER_REGEX);
    }

}
