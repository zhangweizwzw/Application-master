package com.yt.wia.model;

import java.util.List;

/**
 * Created by admin on 2017/4/25.
 */

public class UnitAreaBean {


    /**
     * result : true
     * result4 : [{"LRYF":"2011","CODE":"C3","UNIT":"公顷","QUOTA":"三、开发区实际控制面积","ID":3,"QN":971.7,"QNTBZF":100,"TBZF":100,"SBN":931.7,"SNTQ":0,"QNSNTQ":0},{"LRYF":"2012","CODE":"C3","UNIT":"公顷","QUOTA":"三、开发区实际控制面积","ID":55,"QN":1064.21,"QNTBZF":100,"TBZF":100,"SBN":1064.21,"SNTQ":0,"QNSNTQ":0},{"LRYF":"2013","CODE":"C3","UNIT":"公顷","QUOTA":"三、开发区实际控制面积","ID":109,"QN":1070.24,"QNTBZF":100,"TBZF":100,"SBN":1070.24,"SNTQ":0,"QNSNTQ":0},{"LRYF":"2014","CODE":"C3","UNIT":"公顷","QUOTA":"三、开发区实际控制面积","ID":163,"QN":1095.24,"QNTBZF":2.34,"TBZF":0,"SBN":1070.24,"SNTQ":1070.24,"QNSNTQ":1070.24},{"LRYF":"2015","CODE":"C3","UNIT":"公顷","QUOTA":"三、开发区实际控制面积","ID":217,"QN":1130.59,"QNTBZF":3.23,"TBZF":2.34,"SBN":1095.24,"SNTQ":1070.24,"QNSNTQ":1095.24},{"LRYF":"2016","CODE":"C3","UNIT":"公顷","QUOTA":"三、开发区实际控制面积","ID":271,"QN":1169.71,"QNTBZF":3.46,"TBZF":3.23,"SBN":1130.59,"SNTQ":1095.24,"QNSNTQ":1130.59}]
     * result3 : [{"UNIT":"万元","QUOTA":"五、税收总收入","THIRDTBZJ":100,"LYSQ":0,"LYTQ":0,"THIRDQUART":87629,"LYOQ":0,"SECONDTBZJ":100,"SECONDQUART":54716,"LRYF":"2011","CODE":"A5","FOURTHTBZJ":100,"FOURTHQUART":110359,"FIRSTTBZJ":100,"ID":71,"LYFQ":0,"FIRSTQUART":19266},{"UNIT":"万元","QUOTA":"五、税收总收入","THIRDTBZJ":100,"LYSQ":0,"LYTQ":0,"THIRDQUART":110944,"LYOQ":0,"SECONDTBZJ":100,"SECONDQUART":63201,"LRYF":"2012","CODE":"A5","FOURTHTBZJ":100,"FOURTHQUART":130228,"FIRSTTBZJ":100,"ID":125,"LYFQ":0,"FIRSTQUART":25045},{"UNIT":"万元","QUOTA":"五、税收总收入","THIRDTBZJ":100,"LYSQ":0,"LYTQ":0,"THIRDQUART":115251,"LYOQ":0,"SECONDTBZJ":100,"SECONDQUART":76834.52,"LRYF":"2013","CODE":"A5","FOURTHTBZJ":100,"FOURTHQUART":153670,"FIRSTTBZJ":100,"ID":179,"LYFQ":0,"FIRSTQUART":36279},{"UNIT":"万元","QUOTA":"五、税收总收入","THIRDTBZJ":12.64,"LYSQ":76834.5,"LYTQ":115251,"THIRDQUART":129820,"LYOQ":153670,"SECONDTBZJ":7.12,"SECONDQUART":82305,"LRYF":"2014","CODE":"A5","FOURTHTBZJ":3.7,"FOURTHQUART":159355.8,"FIRSTTBZJ":19.82,"ID":17,"LYFQ":36279,"FIRSTQUART":43469},{"UNIT":"万元","QUOTA":"五、税收总收入","THIRDTBZJ":3.52,"LYSQ":82305,"LYTQ":129820,"THIRDQUART":134386,"LYOQ":159355.8,"SECONDTBZJ":4.34,"SECONDQUART":85881,"LRYF":"2015","CODE":"A5","FOURTHTBZJ":3.7,"FOURTHQUART":165251,"FIRSTTBZJ":3.78,"ID":233,"LYFQ":43469,"FIRSTQUART":45113},{"UNIT":"万元","QUOTA":"五、税收总收入","THIRDTBZJ":3.67,"LYSQ":85881,"LYTQ":134386,"THIRDQUART":139323,"LYOQ":165251,"SECONDTBZJ":6.31,"SECONDQUART":91300,"LRYF":"2016","CODE":"A5","FOURTHTBZJ":5.06,"FOURTHQUART":173607,"FIRSTTBZJ":4.42,"ID":287,"LYFQ":45113,"FIRSTQUART":47108}]
     * result2 : [{"LRYF":"2011","CODE":"C42","UNIT":"万元/亩","QUOTA":"（二）单位面积工业增加值产出率","ID":11,"QN":40.5,"QNTBZF":100,"TBZF":100,"SBN":15.7,"SNTQ":0,"QNSNTQ":0},{"LRYF":"2012","CODE":"C42","UNIT":"万元/亩","QUOTA":"（二）单位面积工业增加值产出率","ID":64,"QN":47.81,"QNTBZF":100,"TBZF":100,"SBN":29.71,"SNTQ":0,"QNSNTQ":0},{"LRYF":"2013","CODE":"C42","UNIT":"万元/亩","QUOTA":"（二）单位面积工业增加值产出率","ID":118,"QN":64.1,"QNTBZF":100,"TBZF":100,"SBN":32.04,"SNTQ":0,"QNSNTQ":0},{"LRYF":"2014","CODE":"C42","UNIT":"万元/亩","QUOTA":"（二）单位面积工业增加值产出率","ID":172,"QN":52.8,"QNTBZF":14.04,"TBZF":21.72,"SBN":39,"SNTQ":32.04,"QNSNTQ":46.3},{"LRYF":"2015","CODE":"C42","UNIT":"万元/亩","QUOTA":"（二）单位面积工业增加值产出率","ID":226,"QN":46.13,"QNTBZF":6.78,"TBZF":7.8,"SBN":24.04,"SNTQ":22.3,"QNSNTQ":43.2},{"LRYF":"2016","CODE":"C42","UNIT":"万元/亩","QUOTA":"（二）单位面积工业增加值产出率","ID":280,"QN":48.29,"QNTBZF":4.68,"TBZF":-3.08,"SBN":23.3,"SNTQ":24.04,"QNSNTQ":46.13}]
     * result1 : [{"LRYF":"2011","CODE":"C41","UNIT":"万元/亩","QUOTA":"（一）单位面积土地投资强度","ID":10,"QN":48.29,"QNTBZF":100,"TBZF":100,"SBN":44.13,"SNTQ":0,"QNSNTQ":0},{"LRYF":"2012","CODE":"C41","UNIT":"万元/亩","QUOTA":"（一）单位面积土地投资强度","ID":63,"QN":56.13,"QNTBZF":100,"TBZF":100,"SBN":48.93,"SNTQ":0,"QNSNTQ":0},{"LRYF":"2013","CODE":"C41","UNIT":"万元/亩","QUOTA":"（一）单位面积土地投资强度","ID":117,"QN":79.9,"QNTBZF":100,"TBZF":100,"SBN":68.17,"SNTQ":0,"QNSNTQ":0},{"LRYF":"2014","CODE":"C41","UNIT":"万元/亩","QUOTA":"（一）单位面积土地投资强度","ID":171,"QN":90.3,"QNTBZF":13.02,"TBZF":33.49,"SBN":91,"SNTQ":68.17,"QNSNTQ":79.9},{"LRYF":"2015","CODE":"C41","UNIT":"万元/亩","QUOTA":"（一）单位面积土地投资强度","ID":225,"QN":100.7,"QNTBZF":18.19,"TBZF":1.78,"SBN":86,"SNTQ":84.5,"QNSNTQ":85.2},{"LRYF":"2016","CODE":"C41","UNIT":"万元/亩","QUOTA":"（一）单位面积土地投资强度","ID":279,"QN":116.4,"QNTBZF":15.59,"TBZF":29.12,"SBN":111.04,"SNTQ":86,"QNSNTQ":100.7}]
     */

    private boolean result;
    private List<Result4Bean> result4;
    private List<Result3Bean> result3;
    private List<Result2Bean> result2;
    private List<Result1Bean> result1;

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public List<Result4Bean> getResult4() {
        return result4;
    }

    public void setResult4(List<Result4Bean> result4) {
        this.result4 = result4;
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

    public static class Result4Bean {
        /**
         * LRYF : 2011
         * CODE : C3
         * UNIT : 公顷
         * QUOTA : 三、开发区实际控制面积
         * ID : 3
         * QN : 971.7
         * QNTBZF : 100.0
         * TBZF : 100.0
         * SBN : 931.7
         * SNTQ : 0.0
         * QNSNTQ : 0.0
         */

        private String LRYF;
        private String CODE;
        private String UNIT;
        private String QUOTA;
        private int ID;
        private double QN;
        private double QNTBZF;
        private double TBZF;
        private double SBN;
        private double SNTQ;
        private double QNSNTQ;

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

        public int getID() {
            return ID;
        }

        public void setID(int ID) {
            this.ID = ID;
        }

        public double getQN() {
            return QN;
        }

        public void setQN(double QN) {
            this.QN = QN;
        }

        public double getQNTBZF() {
            return QNTBZF;
        }

        public void setQNTBZF(double QNTBZF) {
            this.QNTBZF = QNTBZF;
        }

        public double getTBZF() {
            return TBZF;
        }

        public void setTBZF(double TBZF) {
            this.TBZF = TBZF;
        }

        public double getSBN() {
            return SBN;
        }

        public void setSBN(double SBN) {
            this.SBN = SBN;
        }

        public double getSNTQ() {
            return SNTQ;
        }

        public void setSNTQ(double SNTQ) {
            this.SNTQ = SNTQ;
        }

        public double getQNSNTQ() {
            return QNSNTQ;
        }

        public void setQNSNTQ(double QNSNTQ) {
            this.QNSNTQ = QNSNTQ;
        }
    }

    public static class Result3Bean {
        /**
         * UNIT : 万元
         * QUOTA : 五、税收总收入
         * THIRDTBZJ : 100.0
         * LYSQ : 0.0
         * LYTQ : 0.0
         * THIRDQUART : 87629.0
         * LYOQ : 0.0
         * SECONDTBZJ : 100.0
         * SECONDQUART : 54716.0
         * LRYF : 2011
         * CODE : A5
         * FOURTHTBZJ : 100.0
         * FOURTHQUART : 110359.0   ////////////////
         * FIRSTTBZJ : 100.0
         * ID : 71
         * LYFQ : 0.0
         * FIRSTQUART : 19266.0
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
        private double FOURTHQUART;//税收总收入
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

    public static class Result2Bean {
        /**
         * LRYF : 2011
         * CODE : C42
         * UNIT : 万元/亩
         * QUOTA : （二）单位面积工业增加值产出率
         * ID : 11
         * QN : 40.5   //实际面积
         * QNTBZF : 100.0
         * TBZF : 100.0
         * SBN : 15.7
         * SNTQ : 0.0
         * QNSNTQ : 0.0
         */

        private String LRYF;
        private String CODE;
        private String UNIT;
        private String QUOTA;
        private int ID;
        private double QN;
        private double QNTBZF;
        private double TBZF;
        private double SBN;
        private double SNTQ;
        private double QNSNTQ;

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

        public int getID() {
            return ID;
        }

        public void setID(int ID) {
            this.ID = ID;
        }

        public double getQN() {
            return QN;
        }

        public void setQN(double QN) {
            this.QN = QN;
        }

        public double getQNTBZF() {
            return QNTBZF;
        }

        public void setQNTBZF(double QNTBZF) {
            this.QNTBZF = QNTBZF;
        }

        public double getTBZF() {
            return TBZF;
        }

        public void setTBZF(double TBZF) {
            this.TBZF = TBZF;
        }

        public double getSBN() {
            return SBN;
        }

        public void setSBN(double SBN) {
            this.SBN = SBN;
        }

        public double getSNTQ() {
            return SNTQ;
        }

        public void setSNTQ(double SNTQ) {
            this.SNTQ = SNTQ;
        }

        public double getQNSNTQ() {
            return QNSNTQ;
        }

        public void setQNSNTQ(double QNSNTQ) {
            this.QNSNTQ = QNSNTQ;
        }
    }

    public static class Result1Bean {
        /**
         * LRYF : 2011
         * CODE : C41
         * UNIT : 万元/亩
         * QUOTA : （一）单位面积土地投资强度
         * ID : 10
         * QN : 48.29
         * QNTBZF : 100.0
         * TBZF : 100.0
         * SBN : 44.13
         * SNTQ : 0.0
         * QNSNTQ : 0.0
         */

        private String LRYF;      //时间
        private String CODE;
        private String UNIT;
        private String QUOTA;   //标题
        private int ID;
        private double QN;        //全年值
        private double QNTBZF;
        private double TBZF;
        private double SBN;
        private double SNTQ;
        private double QNSNTQ;

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

        public int getID() {
            return ID;
        }

        public void setID(int ID) {
            this.ID = ID;
        }

        public double getQN() {
            return QN;
        }

        public void setQN(double QN) {
            this.QN = QN;
        }

        public double getQNTBZF() {
            return QNTBZF;
        }

        public void setQNTBZF(double QNTBZF) {
            this.QNTBZF = QNTBZF;
        }

        public double getTBZF() {
            return TBZF;
        }

        public void setTBZF(double TBZF) {
            this.TBZF = TBZF;
        }

        public double getSBN() {
            return SBN;
        }

        public void setSBN(double SBN) {
            this.SBN = SBN;
        }

        public double getSNTQ() {
            return SNTQ;
        }

        public void setSNTQ(double SNTQ) {
            this.SNTQ = SNTQ;
        }

        public double getQNSNTQ() {
            return QNSNTQ;
        }

        public void setQNSNTQ(double QNSNTQ) {
            this.QNSNTQ = QNSNTQ;
        }
    }
}
