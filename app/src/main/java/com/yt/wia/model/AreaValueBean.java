package com.yt.wia.model;

import java.util.List;

/**
 * Created by admin on 2017/4/26.
 *地区生产总值占比
 * 税收收入占比
 * 高新技术制造产值占比
 */

public class AreaValueBean {

    /**
     * result : true
     * result2 : [{"DLZB":"区域带动","LRYF":"2015","JSCODE":"29-1","UNIT":"万元","ZMCLBM":"Q01","JSNAME":"所在地级或以上城市地区生产总值（GDP）","ID":47,"KHCODE":"29","BQSJZ":"5537700","KHNAME":"地区生产总值（地区GDP）占所在地级市地区生产总值（地区GDP）比重"}]
     * result1 : [{"DLZB":"区域带动","LRYF":"2015","JSCODE":"1","UNIT":"万元","ZMCLBM":"C01","JSNAME":"地区生产总值（地区GDP）","ID":46,"KHCODE":"29","BQSJZ":"913482.8","KHNAME":"地区生产总值（地区GDP）占所在地级市地区生产总值（地区GDP）比重"}]
     */

    private boolean result;
    private List<Result2Bean> result2;
    private List<Result1Bean> result1;

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public List<Result2Bean> getResult2() {
        return result2;
    }

    public void setResult2(List<Result2Bean> result2) {
        this.result2 = result2;
    }

    public List<Result1Bean> getResult1() {
        return result1;
    }

    public void setResult1(List<Result1Bean> result1) {
        this.result1 = result1;
    }

    public static class Result2Bean {
        /**
         * DLZB : 区域带动
         * LRYF : 2015
         * JSCODE : 29-1
         * UNIT : 万元
         * ZMCLBM : Q01
         * JSNAME : 所在地级或以上城市地区生产总值（GDP）
         * ID : 47
         * KHCODE : 29
         * BQSJZ : 5537700
         * KHNAME : 地区生产总值（地区GDP）占所在地级市地区生产总值（地区GDP）比重
         */

        private String DLZB;
        private String LRYF;
        private String JSCODE;
        private String UNIT;
        private String ZMCLBM;
        private String JSNAME;
        private int ID;
        private String KHCODE;
        private String BQSJZ;
        private String KHNAME;

        public String getDLZB() {
            return DLZB;
        }

        public void setDLZB(String DLZB) {
            this.DLZB = DLZB;
        }

        public String getLRYF() {
            return LRYF;
        }

        public void setLRYF(String LRYF) {
            this.LRYF = LRYF;
        }

        public String getJSCODE() {
            return JSCODE;
        }

        public void setJSCODE(String JSCODE) {
            this.JSCODE = JSCODE;
        }

        public String getUNIT() {
            return UNIT;
        }

        public void setUNIT(String UNIT) {
            this.UNIT = UNIT;
        }

        public String getZMCLBM() {
            return ZMCLBM;
        }

        public void setZMCLBM(String ZMCLBM) {
            this.ZMCLBM = ZMCLBM;
        }

        public String getJSNAME() {
            return JSNAME;
        }

        public void setJSNAME(String JSNAME) {
            this.JSNAME = JSNAME;
        }

        public int getID() {
            return ID;
        }

        public void setID(int ID) {
            this.ID = ID;
        }

        public String getKHCODE() {
            return KHCODE;
        }

        public void setKHCODE(String KHCODE) {
            this.KHCODE = KHCODE;
        }

        public String getBQSJZ() {
            return BQSJZ;
        }

        public void setBQSJZ(String BQSJZ) {
            this.BQSJZ = BQSJZ;
        }

        public String getKHNAME() {
            return KHNAME;
        }

        public void setKHNAME(String KHNAME) {
            this.KHNAME = KHNAME;
        }
    }

    public static class Result1Bean {
        /**
         * DLZB : 区域带动
         * LRYF : 2015
         * JSCODE : 1
         * UNIT : 万元
         * ZMCLBM : C01
         * JSNAME : 地区生产总值（地区GDP）
         * ID : 46
         * KHCODE : 29
         * BQSJZ : 913482.8
         * KHNAME : 地区生产总值（地区GDP）占所在地级市地区生产总值（地区GDP）比重
         */

        private String DLZB;
        private String LRYF;
        private String JSCODE;
        private String UNIT;
        private String ZMCLBM;
        private String JSNAME;
        private int ID;
        private String KHCODE;
        private String BQSJZ;
        private String KHNAME;

        public String getDLZB() {
            return DLZB;
        }

        public void setDLZB(String DLZB) {
            this.DLZB = DLZB;
        }

        public String getLRYF() {
            return LRYF;
        }

        public void setLRYF(String LRYF) {
            this.LRYF = LRYF;
        }

        public String getJSCODE() {
            return JSCODE;
        }

        public void setJSCODE(String JSCODE) {
            this.JSCODE = JSCODE;
        }

        public String getUNIT() {
            return UNIT;
        }

        public void setUNIT(String UNIT) {
            this.UNIT = UNIT;
        }

        public String getZMCLBM() {
            return ZMCLBM;
        }

        public void setZMCLBM(String ZMCLBM) {
            this.ZMCLBM = ZMCLBM;
        }

        public String getJSNAME() {
            return JSNAME;
        }

        public void setJSNAME(String JSNAME) {
            this.JSNAME = JSNAME;
        }

        public int getID() {
            return ID;
        }

        public void setID(int ID) {
            this.ID = ID;
        }

        public String getKHCODE() {
            return KHCODE;
        }

        public void setKHCODE(String KHCODE) {
            this.KHCODE = KHCODE;
        }

        public String getBQSJZ() {
            return BQSJZ;
        }

        public void setBQSJZ(String BQSJZ) {
            this.BQSJZ = BQSJZ;
        }

        public String getKHNAME() {
            return KHNAME;
        }

        public void setKHNAME(String KHNAME) {
            this.KHNAME = KHNAME;
        }
    }
}
