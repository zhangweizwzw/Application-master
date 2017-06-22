package com.yt.wia.utils;

/**
 * 计算两个经纬度之间的距离
 */

public class RangeUtil {
    private static double EARTH_RADIUS = 6378.137;

    private static double rad(double d) {
        return d * Math.PI / 180.0;
    }

    /**
     * 通过经纬度获取距离(单位：米)
     * @param lat1
     * @param lng1
     * @param lat2
     * @param lng2
     * @return
     */
    public static double getDistance(double lat1, double lng1, double lat2,
                                     double lng2) {
        double radLat1 = rad(lat1);
        double radLat2 = rad(lat2);
        double a = radLat1 - radLat2;
        double b = rad(lng1) - rad(lng2);
        double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2)
                + Math.cos(radLat1) * Math.cos(radLat2)
                * Math.pow(Math.sin(b / 2), 2)));
        s = s * EARTH_RADIUS;
        s = Math.round(s * 10000d) / 10000d;
        s = s*1000;
        return s;
    }

    public static String getAreaString(double dValue){
        long area = Math.abs(Math.round(dValue));
        String sArea = "";
        // 顺时针绘制多边形，面积为正，逆时针绘制，则面积为负
        if(area >= 1000000){
            double dArea = area / 1000000.0;
            sArea = Double.toString(dArea) + " 平方公里";
        } else {
            sArea = Double.toString(area) + " 平方米";
        }
        return sArea;
    }

}
