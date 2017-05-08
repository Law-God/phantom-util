package com.phantom.util.string;

import com.github.stuxuhai.jpinyin.PinyinException;
import com.github.stuxuhai.jpinyin.PinyinFormat;
import com.phantom.util.constant.PatternConstant;
import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;
import org.apache.log4j.Logger;

/**
 * @Author 张志凯 https://github.com/Law-God/phantom-util
 * util
 * com.phantom.util.string.Chinese2SpellUtil
 * 2016-08-04 10:10
 * 汉字转拼音
 */
public final class Chinese2SpellUtil {
    private static final Logger log = Logger.getLogger(Chinese2SpellUtil.class);

    /**
     * 中文转拼音
     * 使用pinyin4j方式
     * @param string
     * @return
     */
    public static String c2s(String string){
        if(string == null)
            return null;

        HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
        format.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        format.setVCharType(HanyuPinyinVCharType.WITH_V);

        char[] input = string.toCharArray();
        String output = "";

        try {
            for (int i = 0; i < input.length; i++) {
                if (Character.toString(input[i]).matches(PatternConstant.CHINESE_REGEX_DEFAULT)) {
                    String[] temp = PinyinHelper.toHanyuPinyinStringArray(input[i], format);
                    output += temp[0];
                } else
                    output += Character.toString(input[i]);
            }
        } catch (BadHanyuPinyinOutputFormatCombination e) {
            log.error("中文："+string +"转化拼音失败",e);
            throw new RuntimeException(e);
        }
        return output;
    }

    /**
     * 中文转拼音
     * 使用jpinyin方式
     * @param string
     * @param split
     * @return
     */
    public  static  final String DEF_SPLIT = "";
    public static String c2s(String string,String split){
        if(string == null)
            return null;
        try{
           return  com.github.stuxuhai.jpinyin.PinyinHelper.convertToPinyinString(string, split, PinyinFormat.WITHOUT_TONE);
        }catch (PinyinException e){
            log.error("中文："+string +"转化拼音失败",e);
            e.printStackTrace();
        }
       return  null;
    }
}
