package com.phantom.util.network;

import com.phantom.util.string.StringUtil;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @Author 张志凯 https://github.com/Law-God/phantom-util
 * util
 * com.phantom.util.network.IpConnect
 * 2017-01-11 15:15
 */
public final class IpConnectUtil {
    private final Logger log = Logger.getLogger(IpConnectUtil.class);

    /**
     * 判断IP及端口是否能链接
     * @param host
     * @param port
     * @return
     */
    public static boolean isHostConnectable(String host,int port){
        if(StringUtil.empty(host)) return false;
        Socket socket = new Socket();
        try {
            socket.connect(new InetSocketAddress(host,port));
        } catch (IOException e) {
            //e.printStackTrace();
            return false;
        }finally {
            try {
                socket.close();
            } catch (IOException e) {
                //e.printStackTrace();
            }
        }
        return true;
    }

    /**
     *
     * @param host
     * @param timeOut
     * @return
     */
    public static boolean isHostReachable(String host, Integer timeOut) {
        try {
            return InetAddress.getByName(host).isReachable(timeOut);
        } catch (UnknownHostException e) {
            //e.printStackTrace();
        } catch (IOException e) {
            //e.printStackTrace();
        }
        return false;
    }


}
