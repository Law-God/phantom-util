package com.phantom.util.compare;

import com.phantom.util.collection.MapUtil;
import junit.framework.Assert;
import org.junit.Test;

import java.util.*;

/**
 * @Author 张志凯 https://github.com/Law-God/phantom-util
 * util
 * com.phantom.util.compare.PhantomMapKeyComparableTest
 * 2016-08-15 15:36
 */
public class PhantomMapKeyComparableTest {

    @Test
    public void struct(){
        PhantomMapComparable p = new PhantomMapComparable(PhantomComparable.EnumSort.ASC,false);
    }

    @Test
    public void sortMapKey(){
        List<Object> list = new ArrayList<Object>();
        list.add(new HashMap(){{put("1","1");}});
        list.add(new HashMap(){{put(null,"1");}});
        list.add(new HashMap(){{put("2","2");}});
        list.add(new HashMap(){{put("2","2");}});
        list.add(new HashMap(){{put("3","3");}});

        Collections.sort(list, new PhantomMapComparable(PhantomComparable.EnumSort.ASC,false));
        for(int i=0,len=list.size();i<len;i++){
            switch (i){
                case 0 :
                    Assert.assertEquals("1", MapUtil.getFirstKey((Map)list.get(i)));
                    break;
                case 1 :
                    Assert.assertEquals("2",MapUtil.getFirstKey((Map)list.get(i)));
                    break;
                case 2 :
                    Assert.assertEquals("2",MapUtil.getFirstKey((Map)list.get(i)));
                    break;
                case 3 :
                    Assert.assertEquals("3",MapUtil.getFirstKey((Map)list.get(i)));
                    break;
                case 4 :
                    Assert.assertNull(MapUtil.getFirstKey((Map)list.get(i)));
                    break;
            }
        }
    }

    @Test
    public void sortMapValue(){
        List<Object> list = new ArrayList<Object>();
        list.add(new HashMap(){{put("3",null);}});
        list.add(new HashMap(){{put("1","1");}});
        list.add(new HashMap(){{put(null,"5");}});
        list.add(new HashMap(){{put("2","2");}});
        list.add(new HashMap(){{put("2","2");}});
        list.add(new HashMap(){{put("3","3");}});

        Collections.sort(list, new PhantomMapComparable(PhantomComparable.EnumSort.ASC,true));
        for(int i=0,len=list.size();i<len;i++){
            switch (i){
                case 0 :
                    Assert.assertEquals("1", MapUtil.getFirstValue((Map)list.get(i)));
                    break;
                case 1 :
                    Assert.assertEquals("2",MapUtil.getFirstValue((Map)list.get(i)));
                    break;
                case 2 :
                    Assert.assertEquals("2",MapUtil.getFirstValue((Map)list.get(i)));
                    break;
                case 3 :
                    Assert.assertEquals("3",MapUtil.getFirstValue((Map)list.get(i)));
                    break;
                case 4 :
                    Assert.assertEquals("5",MapUtil.getFirstValue((Map)list.get(i)));
                    break;
                case 5 :
                    Assert.assertNull(MapUtil.getFirstValue((Map)list.get(i)));
                    break;
            }
        }
    }

}
