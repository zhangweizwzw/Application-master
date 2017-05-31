package com.yt.wia.model;

import java.util.List;

/**
 * Created by admin on 2017/4/26.
 */

public class AreaProductionBean {

    /**
     * result : true
     * result3 : [{"LRYF":"2011","BNSJZ":442095,"CODE":"1","UNIT":" 万元","QUOTA":" 地区生产总值","YGSBZ":"否","ID":1,"LYSJZ":278000,"TB":59.03},{"LRYF":"2012","BNSJZ":572513,"CODE":"1","UNIT":" 万元","QUOTA":" 地区生产总值","YGSBZ":"否","ID":69,"LYSJZ":442095,"TB":29.5},{"LRYF":"2013","BNSJZ":742464,"CODE":"1","UNIT":" 万元","QUOTA":" 地区生产总值","YGSBZ":"否","ID":137,"LYSJZ":572513,"TB":29.69},{"LRYF":"2014","BNSJZ":825198,"CODE":"1","UNIT":" 万元","QUOTA":" 地区生产总值","YGSBZ":"否","ID":417,"LYSJZ":742464,"TB":11.14},{"LRYF":"2015","BNSJZ":913482.8,"CODE":"1","UNIT":" 万元","QUOTA":" 地区生产总值","YGSBZ":"否","ID":218,"LYSJZ":825198,"TB":10.7},{"LRYF":"2016","BNSJZ":995687.1,"CODE":"1","UNIT":" 万元","QUOTA":" 地区生产总值","YGSBZ":"是","ID":286,"LYSJZ":913482.8,"TB":9}]
     * result2 : [{"LRYF":"2011","BNSJZ":354016,"CODE":"3","UNIT":" 万元","QUOTA":" 　　　　其中：工业","YGSBZ":"否","ID":3,"LYSJZ":209865,"TB":68.69},{"LRYF":"2012","BNSJZ":476708,"CODE":"3","UNIT":" 万元","QUOTA":" 　　　　其中：工业","YGSBZ":"否","ID":71,"LYSJZ":354016,"TB":34.66},{"LRYF":"2013","BNSJZ":645943,"CODE":"3","UNIT":" 万元","QUOTA":" 　　　　其中：工业","YGSBZ":"否","ID":139,"LYSJZ":476708,"TB":35.5},{"LRYF":"2014","BNSJZ":709231.7,"CODE":"3","UNIT":" 万元","QUOTA":" 　　　　其中：工业","YGSBZ":"否","ID":419,"LYSJZ":645943,"TB":9.8},{"LRYF":"2015","BNSJZ":782232.8,"CODE":"3","UNIT":" 万元","QUOTA":" 　　　　其中：工业","YGSBZ":"否","ID":220,"LYSJZ":709231.7,"TB":10.29},{"LRYF":"2016","BNSJZ":847287,"CODE":"3","UNIT":" 万元","QUOTA":" 　　　　其中：工业","YGSBZ":"是","ID":288,"LYSJZ":782232.8,"TB":8.32}]
     * result1 : [{"LRYF":"2011","BNSJZ":88079,"CODE":"5","UNIT":" 万元","QUOTA":" 　　第三产业","YGSBZ":"否","ID":5,"LYSJZ":68135,"TB":29.27},{"LRYF":"2012","BNSJZ":95805,"CODE":"5","UNIT":" 万元","QUOTA":" 　　第三产业","YGSBZ":"否","ID":73,"LYSJZ":88079,"TB":8.77},{"LRYF":"2013","BNSJZ":96520,"CODE":"5","UNIT":" 万元","QUOTA":" 　　第三产业","YGSBZ":"否","ID":141,"LYSJZ":95805,"TB":0.75},{"LRYF":"2014","BNSJZ":115966.24,"CODE":"5","UNIT":" 万元","QUOTA":" 　　第三产业","YGSBZ":"否","ID":421,"LYSJZ":96520,"TB":20.15},{"LRYF":"2015","BNSJZ":131250,"CODE":"5","UNIT":" 万元","QUOTA":" 　　第三产业","YGSBZ":"否","ID":222,"LYSJZ":115966.24,"TB":13.18},{"LRYF":"2016","BNSJZ":148400.1,"CODE":"5","UNIT":" 万元","QUOTA":" 　　第三产业","YGSBZ":"是","ID":290,"LYSJZ":131250,"TB":13.07}]
     */

    private boolean result;
    private List<Result3Bean> result3;
    private List<Result2Bean> result2;
    private List<Result1Bean> result1;

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public List<Result3Bean> getResult3() {
        return result3;
    }

    public void setResult3(List<Result3Bean> result3) {
        this.result3 = result3;
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

    public static class Result3Bean {
        /**
         * LRYF : 2011
         * BNSJZ : 442095.0
         * CODE : 1
         * UNIT :  万元
         * QUOTA :  地区生产总值
         * YGSBZ : 否
         * ID : 1
         * LYSJZ : 278000.0
         * TB : 59.03
         */

        private String LRYF;
        private double BNSJZ;
        private String CODE;
        private String UNIT;
        private String QUOTA;
        private String YGSBZ;
        private int ID;
        private double LYSJZ;
        private double TB;

        public String getLRYF() {
            return LRYF;
        }

        public void setLRYF(String LRYF) {
            this.LRYF = LRYF;
        }

        public double getBNSJZ() {
            return BNSJZ;
        }

        public void setBNSJZ(double BNSJZ) {
            this.BNSJZ = BNSJZ;
        }

        public String getCODE() {
            return CODE;
        }

        public void setCODE(String CODE) {
            this.CODE = CODE;
        }

        public String getUNIT() {
            return UNIT;
        }

        public void setUNIT(String UNIT) {
            this.UNIT = UNIT;
        }

        public String getQUOTA() {
            return QUOTA;
        }

        public void setQUOTA(String QUOTA) {
            this.QUOTA = QUOTA;
        }

        public String getYGSBZ() {
            return YGSBZ;
        }

        public void setYGSBZ(String YGSBZ) {
            this.YGSBZ = YGSBZ;
        }

        public int getID() {
            return ID;
        }

        public void setID(int ID) {
            this.ID = ID;
        }

        public double getLYSJZ() {
            return LYSJZ;
        }

        public void setLYSJZ(double LYSJZ) {
            this.LYSJZ = LYSJZ;
        }

        public double getTB() {
            return TB;
        }

        public void setTB(double TB) {
            this.TB = TB;
        }
    }

    public static class Result2Bean {
        /**
         * LRYF : 2011
         * BNSJZ : 354016.0
         * CODE : 3
         * UNIT :  万元
         * QUOTA :  　　　　其中：工业
         * YGSBZ : 否
         * ID : 3
         * LYSJZ : 209865.0
         * TB : 68.69
         */

        private String LRYF;
        private double BNSJZ;
        private String CODE;
        private String UNIT;
        private String QUOTA;
        private String YGSBZ;
        private int ID;
        private double LYSJZ;
        private double TB;

        public String getLRYF() {
            return LRYF;
        }

        public void setLRYF(String LRYF) {
            this.LRYF = LRYF;
        }

        public double getBNSJZ() {
            return BNSJZ;
        }

        public void setBNSJZ(double BNSJZ) {
            this.BNSJZ = BNSJZ;
        }

        public String getCODE() {
            return CODE;
        }

        public void setCODE(String CODE) {
            this.CODE = CODE;
        }

        public String getUNIT() {
            return UNIT;
        }

        public void setUNIT(String UNIT) {
            this.UNIT = UNIT;
        }

        public String getQUOTA() {
            return QUOTA;
        }

        public void setQUOTA(String QUOTA) {
            this.QUOTA = QUOTA;
        }

        public String getYGSBZ() {
            return YGSBZ;
        }

        public void setYGSBZ(String YGSBZ) {
            this.YGSBZ = YGSBZ;
        }

        public int getID() {
            return ID;
        }

        public void setID(int ID) {
            this.ID = ID;
        }

        public double getLYSJZ() {
            return LYSJZ;
        }

        public void setLYSJZ(double LYSJZ) {
            this.LYSJZ = LYSJZ;
        }

        public double getTB() {
            return TB;
        }

        public void setTB(double TB) {
            this.TB = TB;
        }
    }

    public static class Result1Bean {
        /**
         * LRYF : 2011
         * BNSJZ : 88079.0
         * CODE : 5
         * UNIT :  万元
         * QUOTA :  　　第三产业
         * YGSBZ : 否
         * ID : 5
         * LYSJZ : 68135.0
         * TB : 29.27
         */

        private String LRYF;
        private double BNSJZ;
        private String CODE;
        private String UNIT;
        private String QUOTA;
        private String YGSBZ;
        private int ID;
        private double LYSJZ;
        private double TB;

        public String getLRYF() {
            return LRYF;
        }

        public void setLRYF(String LRYF) {
            this.LRYF = LRYF;
        }

        public double getBNSJZ() {
            return BNSJZ;
        }

        public void setBNSJZ(double BNSJZ) {
            this.BNSJZ = BNSJZ;
        }

        public String getCODE() {
            return CODE;
        }

        public void setCODE(String CODE) {
            this.CODE = CODE;
        }

        public String getUNIT() {
            return UNIT;
        }

        public void setUNIT(String UNIT) {
            this.UNIT = UNIT;
        }

        public String getQUOTA() {
            return QUOTA;
        }

        public void setQUOTA(String QUOTA) {
            this.QUOTA = QUOTA;
        }

        public String getYGSBZ() {
            return YGSBZ;
        }

        public void setYGSBZ(String YGSBZ) {
            this.YGSBZ = YGSBZ;
        }

        public int getID() {
            return ID;
        }

        public void setID(int ID) {
            this.ID = ID;
        }

        public double getLYSJZ() {
            return LYSJZ;
        }

        public void setLYSJZ(double LYSJZ) {
            this.LYSJZ = LYSJZ;
        }

        public double getTB() {
            return TB;
        }

        public void setTB(double TB) {
            this.TB = TB;
        }
    }
}
