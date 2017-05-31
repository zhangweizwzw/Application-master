package com.yt.wia.model;

import java.util.List;

/**
 * Created by admin on 2017/4/26.
 */

public class IndustryTotalzBean {

    /**
     * result : true
     * result2 : [{"UNIT":"万元","QUOTA":"二、工业总产值（当年价格）","THIRDTBZJ":100,"LYSQ":0,"LYTQ":0,"THIRDQUART":491780,"LYOQ":0,"SECONDTBZJ":100,"SECONDQUART":292238,"LRYF":"2011","CODE":"A2","FOURTHTBZJ":100,"FOURTHQUART":872618,"FIRSTTBZJ":100,"ID":61,"LYFQ":0,"FIRSTQUART":111475},{"UNIT":"万元","QUOTA":"二、工业总产值（当年价格）","THIRDTBZJ":100,"LYSQ":0,"LYTQ":0,"THIRDQUART":893888.75,"LYOQ":0,"SECONDTBZJ":100,"SECONDQUART":586425.25,"LRYF":"2012","CODE":"A2","FOURTHTBZJ":100,"FOURTHQUART":1125677,"FIRSTTBZJ":100,"ID":115,"LYFQ":0,"FIRSTQUART":213052.9},{"UNIT":"万元","QUOTA":"二、工业总产值（当年价格）","THIRDTBZJ":100,"LYSQ":0,"LYTQ":0,"THIRDQUART":1166409,"LYOQ":0,"SECONDTBZJ":100,"SECONDQUART":743372.4,"LRYF":"2013","CODE":"A2","FOURTHTBZJ":100,"FOURTHQUART":1516686,"FIRSTTBZJ":100,"ID":169,"LYFQ":0,"FIRSTQUART":340473.4},{"UNIT":"万元","QUOTA":"二、工业总产值（当年价格）","THIRDTBZJ":-5.55,"LYSQ":743372.4,"LYTQ":1166409,"THIRDQUART":1101721,"LYOQ":1516686,"SECONDTBZJ":-9.03,"SECONDQUART":676215,"LRYF":"2014","CODE":"A2","FOURTHTBZJ":9.6,"FOURTHQUART":1662353,"FIRSTTBZJ":2.21,"ID":7,"LYFQ":340473.4,"FIRSTQUART":348006},{"UNIT":"万元","QUOTA":"二、工业总产值（当年价格）","THIRDTBZJ":10.6,"LYSQ":676215,"LYTQ":1101721,"THIRDQUART":1218537,"LYOQ":1662353,"SECONDTBZJ":10.96,"SECONDQUART":750311,"LRYF":"2015","CODE":"A2","FOURTHTBZJ":9.51,"FOURTHQUART":1820453,"FIRSTTBZJ":7.19,"ID":223,"LYFQ":348006,"FIRSTQUART":373042},{"UNIT":"万元","QUOTA":"二、工业总产值（当年价格）","THIRDTBZJ":7.19,"LYSQ":750311,"LYTQ":1218537,"THIRDQUART":1306150,"LYOQ":1820453,"SECONDTBZJ":8.2,"SECONDQUART":811832.9,"LRYF":"2016","CODE":"A2","FOURTHTBZJ":8.97,"FOURTHQUART":1983748,"FIRSTTBZJ":5.02,"ID":277,"LYFQ":373042,"FIRSTQUART":391768.7}]
     * result1 : [{"LRYF":"2011","BNSJZ":872618,"CODE":"6","UNIT":" 万元","QUOTA":" 工业总产值","YGSBZ":"否","ID":6,"LYSJZ":589570,"TB":48.01},{"LRYF":"2012","BNSJZ":1125677,"CODE":"6","UNIT":" 万元","QUOTA":" 工业总产值","YGSBZ":"否","ID":74,"LYSJZ":872618,"TB":29},{"LRYF":"2013","BNSJZ":1516687,"CODE":"6","UNIT":" 万元","QUOTA":" 工业总产值","YGSBZ":"否","ID":142,"LYSJZ":1125677,"TB":34.74},{"LRYF":"2014","BNSJZ":1662353,"CODE":"6","UNIT":" 万元","QUOTA":" 工业总产值","YGSBZ":"否","ID":422,"LYSJZ":1516687,"TB":9.6},{"LRYF":"2015","BNSJZ":1820453,"CODE":"6","UNIT":" 万元","QUOTA":" 工业总产值","YGSBZ":"否","ID":223,"LYSJZ":1662353,"TB":9.51},{"LRYF":"2016","BNSJZ":1983747.6,"CODE":"6","UNIT":" 万元","QUOTA":" 工业总产值","YGSBZ":"是","ID":291,"LYSJZ":1820453,"TB":8.97}]
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
         * UNIT : 万元
         * QUOTA : 二、工业总产值（当年价格）
         * THIRDTBZJ : 100.0
         * LYSQ : 0.0
         * LYTQ : 0.0
         * THIRDQUART : 491780.0
         * LYOQ : 0.0
         * SECONDTBZJ : 100.0
         * SECONDQUART : 292238.0
         * LRYF : 2011
         * CODE : A2
         * FOURTHTBZJ : 100.0
         * FOURTHQUART : 872618.0
         * FIRSTTBZJ : 100.0
         * ID : 61
         * LYFQ : 0.0
         * FIRSTQUART : 111475.0
         */

        private String UNIT;
        private String QUOTA;
        private double THIRDTBZJ;
        private double LYSQ;
        private double LYTQ;
        private double THIRDQUART;
        private double LYOQ;
        private double SECONDTBZJ;
        private double SECONDQUART;
        private String LRYF;
        private String CODE;
        private double FOURTHTBZJ;
        private double FOURTHQUART;
        private double FIRSTTBZJ;
        private int ID;
        private double LYFQ;
        private double FIRSTQUART;

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

        public double getTHIRDTBZJ() {
            return THIRDTBZJ;
        }

        public void setTHIRDTBZJ(double THIRDTBZJ) {
            this.THIRDTBZJ = THIRDTBZJ;
        }

        public double getLYSQ() {
            return LYSQ;
        }

        public void setLYSQ(double LYSQ) {
            this.LYSQ = LYSQ;
        }

        public double getLYTQ() {
            return LYTQ;
        }

        public void setLYTQ(double LYTQ) {
            this.LYTQ = LYTQ;
        }

        public double getTHIRDQUART() {
            return THIRDQUART;
        }

        public void setTHIRDQUART(double THIRDQUART) {
            this.THIRDQUART = THIRDQUART;
        }

        public double getLYOQ() {
            return LYOQ;
        }

        public void setLYOQ(double LYOQ) {
            this.LYOQ = LYOQ;
        }

        public double getSECONDTBZJ() {
            return SECONDTBZJ;
        }

        public void setSECONDTBZJ(double SECONDTBZJ) {
            this.SECONDTBZJ = SECONDTBZJ;
        }

        public double getSECONDQUART() {
            return SECONDQUART;
        }

        public void setSECONDQUART(double SECONDQUART) {
            this.SECONDQUART = SECONDQUART;
        }

        public String getLRYF() {
            return LRYF;
        }

        public void setLRYF(String LRYF) {
            this.LRYF = LRYF;
        }

        public String getCODE() {
            return CODE;
        }

        public void setCODE(String CODE) {
            this.CODE = CODE;
        }

        public double getFOURTHTBZJ() {
            return FOURTHTBZJ;
        }

        public void setFOURTHTBZJ(double FOURTHTBZJ) {
            this.FOURTHTBZJ = FOURTHTBZJ;
        }

        public double getFOURTHQUART() {
            return FOURTHQUART;
        }

        public void setFOURTHQUART(double FOURTHQUART) {
            this.FOURTHQUART = FOURTHQUART;
        }

        public double getFIRSTTBZJ() {
            return FIRSTTBZJ;
        }

        public void setFIRSTTBZJ(double FIRSTTBZJ) {
            this.FIRSTTBZJ = FIRSTTBZJ;
        }

        public int getID() {
            return ID;
        }

        public void setID(int ID) {
            this.ID = ID;
        }

        public double getLYFQ() {
            return LYFQ;
        }

        public void setLYFQ(double LYFQ) {
            this.LYFQ = LYFQ;
        }

        public double getFIRSTQUART() {
            return FIRSTQUART;
        }

        public void setFIRSTQUART(double FIRSTQUART) {
            this.FIRSTQUART = FIRSTQUART;
        }
    }

    public static class Result1Bean {
        /**
         * LRYF : 2011
         * BNSJZ : 872618.0
         * CODE : 6
         * UNIT :  万元
         * QUOTA :  工业总产值
         * YGSBZ : 否
         * ID : 6
         * LYSJZ : 589570.0
         * TB : 48.01
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
