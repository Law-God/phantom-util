package com.phantom.util.xml;

import junit.framework.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author 张志凯 https://github.com/Law-God/phantom-util
 * phantom-util
 * com.phantom.util.xml.XmlFieldUtilTest
 * 2016-08-02 10:54
 */
public class XmlFieldUtilTest {
    @Test
    public void struct(){
        XmlField x = new XmlField();
    }

    @Test(expected = RuntimeException.class)
    public void putXmlField1(){
        XmlField xmlField = new XmlField();
        xmlField.putXmlField(null,"");

        String name = "zhangsan";
        String value = "1";
        XmlField xmlField1 = new XmlField();
        xmlField1.putXmlField(name,value);
        String xmlStr = xmlField1.getFieldXmlString();
        Assert.assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\" ?><fields><field><name>zhangsan</name><value><![CDATA[1]]></value></field></fields>",xmlStr);
    }

    @Test(expected = RuntimeException.class)
    public void putXmlField2(){
        Map<String,String> map1 = null;
        XmlField xmlField = new XmlField();
        xmlField.putXmlField(map1);

        Map<String,String> map = new HashMap<String,String>(){
            {
                put("zhangsan","1");
            }
        };

        XmlField xmlField1 = new XmlField();
        xmlField1.putXmlField(map);
        String xmlStr = xmlField1.getFieldXmlString();
        Assert.assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\" ?><fields><field><name>zhangsan</name><value><![CDATA[1]]></value></field></fields>",xmlStr);
    }

    @Test(expected = RuntimeException.class)
    public void putXmlField3(){
        List<Map<String,String>> list1 = null;
        XmlField xmlField = new XmlField();
        xmlField.putXmlField(list1);

        List<Map<String,String>> list = new ArrayList<Map<String,String>>();
        Map<String,String> map = new HashMap<String,String>(){
            {
                put("zhangsan","1");
            }
        };
        list.add(map);
        XmlField xmlField1 = new XmlField();
        xmlField1.putXmlField(list);
        String xmlStr = xmlField1.getFieldXmlString();
        Assert.assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\" ?><fields><field><name>zhangsan</name><value><![CDATA[1]]></value></field></fields>",xmlStr);
    }

}
