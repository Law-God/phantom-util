package com.phantom.util.xml;

import com.phantom.util.string.StringUtil;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author 张志凯 https://github.com/Law-God/phantom-util
 * util
 * com.phantom.util.xml.XmlField
 * 2016-08-02 10:13
 */
public final class XmlField {
    private final Logger log = Logger.getLogger(XmlField.class);
    private List<XmlFieldItem> xmlFields = new ArrayList<XmlFieldItem>();

    public void putXmlField(String name,String value){
        if(StringUtil.empty(name)){
            String errorMsg = XmlField.class.getName() + " putXmlField(String name,String value),参数name不能为空";
            RuntimeException e = new RuntimeException(errorMsg);
            log.error(errorMsg,e);
            throw e;
        }
        XmlFieldItem xmlFieldItem = new XmlFieldItem(name,value);
        xmlFields.add(xmlFieldItem);
    }

    public void putXmlField(Map<String,?> m){
        if(m == null){
            String errorMsg = XmlField.class.getName() + " putXmlField(Map<String,?> m),参数不能为空";
            RuntimeException e = new RuntimeException(errorMsg);
            log.error(errorMsg,e);
            throw e;
        }
        for(Map.Entry<String,?> e : m.entrySet()){
            String name = e.getKey();
            String value = e.getValue()+"";
            XmlFieldItem xmlFieldItem = new XmlFieldItem(name,value);
            xmlFields.add(xmlFieldItem);
        }
    }

    public void putXmlField(List<? extends Map<String,?>> list){
        if(list == null){
            String errorMsg = XmlField.class.getName() + " putXmlField(List<? extends Map<String,?>> list),参数不能为空";
            RuntimeException e = new RuntimeException(errorMsg);
            log.error(errorMsg,e);
            throw e;
        }
        for(int i=0,len=list.size();i<len;i++){
            putXmlField(list.get(i));
        }
    }

    public String getFieldXmlString(){
        StringBuilder sb = new StringBuilder("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>");
        sb.append("<fields>");
        for(int i=0,len=xmlFields.size();i<len;i++){
            XmlFieldItem itemBean = xmlFields.get(i);
            String name = itemBean.name;
            String value = itemBean.value;
            sb.append("<field><name>").append(name).append("</name>").append("<value><![CDATA[").append(value).append("]]></value></field>");
        }
        sb.append("</fields>");
        log.debug(sb.toString());
        return sb.toString();
    }

    /**
     * Xml字段bean
     */
    private class XmlFieldItem{
        private String name;
        private String value;
        public XmlFieldItem(String name,String value){
            this.name = name;
            this.value = value;
        }
    }
}
