package com.phantom.util.file;

import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.util.Zip4jConstants;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * @Author 张志凯 https://github.com/Law-God/phantom-util
 * util
 * com.phantom.util.file.Zip4jUtil
 * 2017-03-09 上午 09:59
 * zip4j
 * 支持创建，修改，添加，删除，解压 压缩文件
 * 支持读/写密码保护
 * 支持AES加密 128/256
 * 支持标准ZIP加密
 * 支持进度监视器
 * 支持Unicode 文件名
 * 支持创建分卷压缩文件
 * 支持将文件添加到压缩包中但不进行压缩
 */
public  class Zip4jUtil {
    private static final Logger log = Logger.getLogger(Zip4jUtil.class);
    /**
     * 压缩单个文件不需要密码
     * @param zipFileName 要生成压缩文件夹如 D:\files.zip
     * @param sourceFile 需要添加到压缩夹中的文件
     * @return
     */
    public static boolean addFilesToZip(String zipFileName, File sourceFile){
        ArrayList sourceFiles = new ArrayList();
        sourceFiles.add(sourceFile);
        return addFileToZipBase(zipFileName, sourceFiles,null);
    }

    /**
     * 压缩多个文件不需要密码
     * @param zipFileName 要生成压缩文件夹名
     * @param sourceFiles 需要添加到压缩夹中的文件
     * @return
     */
    public static boolean addFilesToZip(String zipFileName, ArrayList<File> sourceFiles){
        return addFileToZipBase(zipFileName, sourceFiles,null);
    }

    /**
     * 压缩单个文件需要密码
     * @param zipFileName 要生成压缩文件名
     * @param sourceFile 需要添加到压缩夹中的文件
     * @return
     */
    public static boolean addFilesToZip(String zipFileName, File sourceFile,String password){
        ArrayList sourceFiles = new ArrayList();
        sourceFiles.add(sourceFile);
        return addFileToZipBase(zipFileName, sourceFiles,password);
    }

    /**
     * 压缩多个文件要密码
     * @param zipFileName 要生成压缩文件名
     * @param sourceFiles 需要添加到压缩夹中的文件
     * @param password 加密密码
     * @return
     */
    public static boolean addFilesToZip(String zipFileName, ArrayList<File> sourceFiles,String password){
        return addFileToZipBase(zipFileName, sourceFiles,password);
    }


    /**
     *
     * @param zipFileName 要生成压缩文件名
     * @param sourceFiles 需要添加到压缩夹中的文件
     * @param password 加密密码
     * @return
     */
    private static boolean addFileToZipBase(String zipFileName, ArrayList<File> sourceFiles,String password){
        try{
            //创建压缩文件夹
            ZipFile zipFile = new ZipFile(zipFileName);

            if(null == sourceFiles){
                String errorMsg = "要添加压缩的文件不能为空";
                RuntimeException e = new RuntimeException(errorMsg);
                log.error(errorMsg,e);
                throw e;
            }

            //压缩文件参数配置
            ZipParameters zipParameters = new ZipParameters();
            zipParameters.setCompressionMethod(Zip4jConstants.COMP_DEFLATE);
            zipParameters.setCompressionLevel(Zip4jConstants.DEFLATE_LEVEL_NORMAL);
            //是否需要密码
            if(null != password){
                zipParameters.setEncryptFiles(true);
                zipParameters.setEncryptionMethod(Zip4jConstants.ENC_METHOD_AES);
                zipParameters.setAesKeyStrength(Zip4jConstants.AES_STRENGTH_256);
                zipParameters.setPassword(password);
            }
            //压缩操作
            zipFile.addFiles(sourceFiles, zipParameters);
        }catch (Exception e){
            String errorMsg = "压缩文件失败";
            log.error(errorMsg,e);
            e.printStackTrace();
            return false;
        }
        return true;
    }


    /**
     * 压缩文件流不需要密码
     * @param zipFileName 要生成压缩文件名
     * @param is 需要添加到压缩夹中的文件流
     * @param fileName 需要添加到压缩夹中的文件流文件名
     * @return
     */
    public static boolean addFilesToZipInputStream(String zipFileName,InputStream is,String fileName){
        return addFileToZip(zipFileName,is,fileName,null);
    }

    /**
     * 压缩文件流需要密码
     * @param zipFileName 要生成压缩文件名
     * @param is 需要添加到压缩夹中的文件流
     * @param fileName 需要添加到压缩夹中的文件流文件名
     * @return
     */
    public static boolean addFilesToZipInputStream(String zipFileName,InputStream is,String fileName,String password){
        return addFileToZip(zipFileName,is,fileName,password);
    }

    /**
     * 文件流的方式添加到压缩文件中
     * @param zipFileName 要生成压缩文件名
     * @param is  需要添加到压缩夹中的文件流
     * @param fileName 在压缩文件夹中的文件名
     * @param password 密码
     * @return
     */
    private static boolean addFileToZip(String zipFileName, InputStream is,String fileName, String password){
        try{
            //如果已经存在压缩的文件，则再次调用为添加，应删除操作下
            File isExistFile = new File(zipFileName);
            if(isExistFile.isFile() && isExistFile.exists()){
                isExistFile.delete();
            }

            //创建压缩文件夹
            ZipFile zipFile = new ZipFile(zipFileName);

            if(null == is){
                String errorMsg = "要添加压缩的文件流不能为空";
                RuntimeException e = new RuntimeException(errorMsg);
                log.error(errorMsg,e);
                throw e;
            }

            //压缩文件参数配置
            ZipParameters zipParameters = new ZipParameters();
            zipParameters.setCompressionMethod(Zip4jConstants.COMP_DEFLATE);
            zipParameters.setCompressionLevel(Zip4jConstants.DEFLATE_LEVEL_NORMAL);
            zipParameters.setFileNameInZip(fileName);
            zipParameters.setSourceExternalStream(true);
            //是否需要密码
            if(null != password){
                zipParameters.setEncryptFiles(true);
                zipParameters.setEncryptionMethod(Zip4jConstants.ENC_METHOD_AES);
                zipParameters.setAesKeyStrength(Zip4jConstants.AES_STRENGTH_256);
                zipParameters.setPassword(password);
            }
            //压缩操作
            zipFile.addStream(is, zipParameters);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }finally{
            if(is != null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return true;
    }

    /**
     * 压缩文件夹无密码
     * @param zipFileName
     * @param fileFolder
     * @return
     */
    public static boolean addFileFolderToZip(String zipFileName, String fileFolder){
        return addFileFolderToZipBase(zipFileName, fileFolder,null);
    }

    /**
     * 压缩文件夹要密码
     * @param zipFileName
     * @param fileFolder
     * @return
     */
    public static boolean addFileFolderToZip(String zipFileName, String fileFolder,String password){
        return addFileFolderToZipBase(zipFileName, fileFolder,password);
    }
    /**
     *
     * @param zipFileName
     * @param fileFolder
     * @param password
     * @return
     */
    private static boolean addFileFolderToZipBase(String zipFileName,String fileFolder,String password){
        try {
            ZipFile zipFile = new ZipFile(zipFileName);

            ZipParameters zipParameters = new ZipParameters();
            zipParameters.setCompressionMethod(Zip4jConstants.COMP_DEFLATE);
            zipParameters.setCompressionLevel(Zip4jConstants.DEFLATE_LEVEL_NORMAL);

            //是否需要密码
            if(null != password){
                zipParameters.setEncryptFiles(true);
                zipParameters.setEncryptionMethod(Zip4jConstants.ENC_METHOD_AES);
                zipParameters.setAesKeyStrength(Zip4jConstants.AES_STRENGTH_256);
                zipParameters.setPassword(password);
            }
            zipFile.addFolder(fileFolder, zipParameters);
        } catch (Exception e) {
            String errorMsg = "压缩文件失败";
            log.error(errorMsg,e);
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
