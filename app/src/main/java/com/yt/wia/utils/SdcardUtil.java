package com.yt.wia.utils;

import android.os.Environment;

/**
 * Created by admin on 2017/4/28.
 */

public class SdcardUtil {

    /**
     * 获取SD卡位置
     * @return
     */
    public static String getSDPath(){
        String sdDir = null;
        boolean sdCardExist = Environment.getExternalStorageState()
                .equals(android.os.Environment.MEDIA_MOUNTED);   //判断sd卡是否存在
        if   (sdCardExist) {
            sdDir = Environment.getExternalStorageDirectory().getAbsolutePath();//获取根目录
        }
        return sdDir.toString();
    }
}
