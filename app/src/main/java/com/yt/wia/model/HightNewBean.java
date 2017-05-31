package com.yt.wia.model;

import java.util.List;

/**
 * Created by admin on 2017/4/25.
 */

public class HightNewBean {

    /**
     * result : true
     * result2 : [{"LRYF":"2011","CODE":"C81","UNIT":"项","QUOTA":"（一）累计申请专利数","ID":22,"QN":30,"QNTBZF":100,"TBZF":100,"SBN":15,"SNTQ":0,"QNSNTQ":0},{"LRYF":"2012","CODE":"C81","UNIT":"项","QUOTA":"（一）累计申请专利数","ID":75,"QN":49,"QNTBZF":100,"TBZF":100,"SBN":43,"SNTQ":0,"QNSNTQ":0},{"LRYF":"2013","CODE":"C81","UNIT":"项","QUOTA":"（一）累计申请专利数","ID":129,"QN":58,"QNTBZF":100,"TBZF":100,"SBN":54,"SNTQ":0,"QNSNTQ":0},{"LRYF":"2014","CODE":"C81","UNIT":"项","QUOTA":"（一）累计申请专利数","ID":183,"QN":63,"QNTBZF":8.62,"TBZF":12.96,"SBN":61,"SNTQ":54,"QNSNTQ":58},{"LRYF":"2015","CODE":"C81","UNIT":"项","QUOTA":"（一）累计申请专利数","ID":237,"QN":67,"QNTBZF":6.35,"TBZF":9.84,"SBN":67,"SNTQ":61,"QNSNTQ":63},{"LRYF":"2016","CODE":"C81","UNIT":"项","QUOTA":"（一）累计申请专利数","ID":291,"QN":75,"QNTBZF":11.94,"TBZF":5.97,"SBN":71,"SNTQ":67,"QNSNTQ":67}]
     * result1 : [{"LRYF":"2011","CODE":"C51","UNIT":"个","QUOTA":"（一）高新技术企业数","ID":13,"QN":6,"QNTBZF":100,"TBZF":100,"SBN":6,"SNTQ":0,"QNSNTQ":0},{"LRYF":"2012","CODE":"C51","UNIT":"个","QUOTA":"（一）高新技术企业数","ID":66,"QN":8,"QNTBZF":100,"TBZF":100,"SBN":7,"SNTQ":0,"QNSNTQ":0},{"LRYF":"2013","CODE":"C51","UNIT":"个","QUOTA":"（一）高新技术企业数","ID":120,"QN":9,"QNTBZF":100,"TBZF":100,"SBN":8,"SNTQ":0,"QNSNTQ":0},{"LRYF":"2014","CODE":"C51","UNIT":"个","QUOTA":"（一）高新技术企业数","ID":174,"QN":10,"QNTBZF":11.11,"TBZF":25,"SBN":10,"SNTQ":8,"QNSNTQ":9},{"LRYF":"2015","CODE":"C51","UNIT":"个","QUOTA":"（一）高新技术企业数","ID":228,"QN":16,"QNTBZF":60,"TBZF":20,"SBN":12,"SNTQ":10,"QNSNTQ":10},{"LRYF":"2016","CODE":"C51","UNIT":"个","QUOTA":"（一）高新技术企业数","ID":282,"QN":19,"QNTBZF":18.75,"TBZF":33.33,"SBN":16,"SNTQ":12,"QNSNTQ":16}]
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
         * CODE : C81
         * UNIT : 项
         * QUOTA : （一）累计申请专利数
         * ID : 22
         * QN : 30.0
         * QNTBZF : 100.0
         * TBZF : 100.0
         * SBN : 15.0
         * SNTQ : 0.0
         * QNSNTQ : 0.0
         */

        private int LRYF;
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
         * LRYF : 2011                         //时间
         * CODE : C51
         * UNIT : 个
         * QUOTA : （一）高新技术企业数       //标题
         * ID : 13
         * QN : 6.0                          //全年值
         * QNTBZF : 100.0
         * TBZF : 100.0
         * SBN : 6.0
         * SNTQ : 0.0
         * QNSNTQ : 0.0
         */

        private int LRYF;
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

        public int getLRYF() {
            return LRYF;
        }

        public void setLRYF(int LRYF) {
            this.LRYF = LRYF;
        }

        public double getQN() {
            return QN;
        }

        public void setQN(double QN) {
            this.QN = QN;
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
