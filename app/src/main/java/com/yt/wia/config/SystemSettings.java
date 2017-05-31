package com.yt.wia.config;

import okhttp3.OkHttpClient;

/**
 * Created by YU on 2016/5/19.
 */
public class SystemSettings {

    public static OkHttpClient mOkHttpClient=null;

    public static String STATUS_CODE="200";
//    public static String CHECKISCONNECT="http://192.168.1.108";//检查是否连接服务器
//      public static String CHECKISCONNECT="http://192.168.1.103:8080";//检查是否连接服务器
//    public static String ISCONN="/isConn";

    public static String REQUEST_URL="http://192.168.1.103:8080/mobile/";//网络请求路径

    public static String CAPTURE_URL="http://192.168.1.103:8080/projection/verify/";//二维码扫描验证

        public static final String BASE_URL = "http://192.168.1.103:8080/rm/upload/handwrite";//长传签名图片路径
//    public static final String BASE_URL = "http://192.168.1.110:8080/manager/upload/handwrite";//长传签名图片路径

    //接口请求url
    //    public static String NEWREQUEST_URL="http://192.168.1.115:80/manager/";//老大

    //    public static String CHARTREQUEST_URL="http://192.168.1.132:8080/manager/mobilereport/";//耿星报标地址
//    public static String NEWREQUEST_URL="http://192.168.1.132:8080/manager/";//耿星


    public static String LAMP_URL="http://192.168.1.105:8080/manager/lamp/";
//    public static String CHECKISCONNECT="http://192.168.1.103:8080";//检查是否连接服务器
    public static String NEWREQUEST_URL="http://192.168.1.105:8080/manager/";//103服务器
    public static String UPLOADREQUEST_URL="http://192.168.1.105:8080/";//上传经纬度
    public static String CHARTREQUEST_URL="http://192.168.1.105:8080/mobilereport/";//报标地址

    //public static String UPLOADREQUEST_URL="http://192.168.1.115:80/manager/";//上传经纬度


    public static String UPLOADSHAPEREQUEST_URL="http://192.168.1.105:80/shp/";//下载shape文件地址

}
