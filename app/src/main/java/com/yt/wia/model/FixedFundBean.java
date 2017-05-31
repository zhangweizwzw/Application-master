package com.yt.wia.model;

import java.util.List;

/**
 * Created by admin on 2017/4/26.
 */

public class FixedFundBean {


    /**
     * result : true
     * result2 : [{"LRYF":"2011","BNSJZ":0,"CODE":"34","UNIT":" 万元","QUOTA":" 　　其中：基础设施投资","YGSBZ":"否","ID":34,"LYSJZ":0,"TB":0},{"LRYF":"2012","BNSJZ":34622,"CODE":"34","UNIT":" 万元","QUOTA":" 　　其中：基础设施投资","YGSBZ":"否","ID":102,"LYSJZ":0,"TB":0},{"LRYF":"2013","BNSJZ":51030,"CODE":"34","UNIT":" 万元","QUOTA":" 　　其中：基础设施投资","YGSBZ":"否","ID":170,"LYSJZ":34622,"TB":47.39},{"LRYF":"2014","BNSJZ":71664,"CODE":"34","UNIT":" 万元","QUOTA":" 　　其中：基础设施投资","YGSBZ":"否","ID":450,"LYSJZ":51030,"TB":40.44},{"LRYF":"2015","BNSJZ":83225,"CODE":"34","UNIT":" 万元","QUOTA":" 　　其中：基础设施投资","YGSBZ":"否","ID":251,"LYSJZ":71664,"TB":16.13},{"LRYF":"2016","BNSJZ":91334,"CODE":"34","UNIT":" 万元","QUOTA":" 　　其中：基础设施投资","YGSBZ":"是","ID":319,"LYSJZ":83225,"TB":9.74}]
     * result1 : [{"LRYF":"2011","BNSJZ":100852,"CODE":"33","UNIT":" 万元","QUOTA":" 当年固定资产投资（不含农户）","YGSBZ":"否","ID":33,"LYSJZ":51358,"TB":96.37},{"LRYF":"2012","BNSJZ":183858,"CODE":"33","UNIT":" 万元","QUOTA":" 当年固定资产投资（不含农户）","YGSBZ":"否","ID":101,"LYSJZ":100852,"TB":82.3},{"LRYF":"2013","BNSJZ":300185,"CODE":"33","UNIT":" 万元","QUOTA":" 当年固定资产投资（不含农户）","YGSBZ":"否","ID":169,"LYSJZ":183858,"TB":63.27},{"LRYF":"2014","BNSJZ":319959,"CODE":"33","UNIT":" 万元","QUOTA":" 当年固定资产投资（不含农户）","YGSBZ":"否","ID":449,"LYSJZ":300185,"TB":6.59},{"LRYF":"2015","BNSJZ":307493,"CODE":"33","UNIT":" 万元","QUOTA":" 当年固定资产投资（不含农户）","YGSBZ":"否","ID":250,"LYSJZ":319959,"TB":-3.9},{"LRYF":"2016","BNSJZ":339900,"CODE":"33","UNIT":" 万元","QUOTA":" 当年固定资产投资（不含农户）","YGSBZ":"是","ID":318,"LYSJZ":307493,"TB":10.54}]
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
         * LRYF : 2011
         * BNSJZ : 0.0
         * CODE : 34
         * UNIT :  万元
         * QUOTA :  　　其中：基础设施投资
         * YGSBZ : 否
         * ID : 34
         * LYSJZ : 0.0
         * TB : 0.0
         */

        private String LRYF;
        private double BNSJZ;//基础设施投资
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
         * BNSJZ : 100852.0
         * CODE : 33
         * UNIT :  万元
         * QUOTA :  当年固定资产投资（不含农户）
         * YGSBZ : 否
         * ID : 33
         * LYSJZ : 51358.0
         * TB : 96.37
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
