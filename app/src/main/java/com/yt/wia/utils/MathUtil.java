package com.yt.wia.utils;

import java.text.DecimalFormat;

/**
 * Created by admin on 2017/4/25.
 */

public class MathUtil {

    public static float geto1(double d){
        DecimalFormat df = new DecimalFormat("#.0");
       String f=df.format(d / 1000);

        return Float.parseFloat(f);

    }
}
