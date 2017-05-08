package com.phantom.util.file;

import junit.framework.Assert;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author 张志凯 https://github.com/Law-God/phantom-util
 * util
 * com.phantom.util.file.Zip4jUtil
 * 2017-03-09 上午 10:12
 */
public class Zip4jUtilTest {

    @Test
    public void testStruct(){
        Zip4jUtil zip4jUtil = new Zip4jUtil();
    }

    @Test
    public void testAddFilesToZipUnUsePassword(){
        File f1 = new File("d:\\中文.txt");
        File f2 = new File("d:\\测试.txt");
        //File f3 = new File("D:\\网开流水手机号导出_20170307165210_1.xls");
        ArrayList<File> files = new ArrayList<File>();
        files.add(f1);
        files.add(f2);
        //files.add(f3);
        Assert.assertTrue(Zip4jUtil.addFilesToZip("D:\\压缩.rar",files));
        ArrayList<File> files1 = null;
        Zip4jUtil.addFilesToZip("D:\\压缩.rar",files1);

        Assert.assertTrue(Zip4jUtil.addFilesToZip("D:\\压缩.rar",f1));

        Assert.assertTrue(Zip4jUtil.addFilesToZip("D:\\压缩.rar",f1,"123456"));
    }

    @Test
    public void testAddFilesToZipUsePassword(){
        File f1 = new File("D:\\中文.txt");
        File f2 = new File("D:\\测试.txt");
        //File f3 = new File("D:\\网开流水手机号导出_20170307165210_1.xls");
        ArrayList<File> files = new ArrayList<File>();
        files.add(f1);
        files.add(f2);
        //files.add(f3);
        Assert.assertTrue(Zip4jUtil.addFilesToZip("D:\\压缩.zip",files,"123456"));
    }

    @Test
    public void testAddFileInputStreamToZipUnUsePassword() throws FileNotFoundException {
        File f1 = new File("D:\\中文.txt");
        InputStream is = new FileInputStream(f1);
        Assert.assertTrue(Zip4jUtil.addFilesToZipInputStream("D:\\压缩.zip",is,"中文2.txt"));

        File f2 = new File("D:\\中文.txt");
        InputStream is2 = new FileInputStream(f1);
        Assert.assertTrue(Zip4jUtil.addFilesToZipInputStream("D:\\压缩.zip",is2,"中文2.txt","123456"));


        InputStream is3 = null;
        Zip4jUtil.addFilesToZipInputStream("D:\\压缩.zip",is3,"中文2.txt");
    }

    @Test
    public void testAddFilefolderToZip(){
        Zip4jUtil.addFileFolderToZip("D:\\压缩.zip","D:\\folder");
        Zip4jUtil.addFileFolderToZip("D:\\压缩.zip","D:\\folder","phantom");
    }
}
