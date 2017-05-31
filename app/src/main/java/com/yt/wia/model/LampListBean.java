package com.yt.wia.model;

import java.util.List;

/**
 * Created by admin on 2017/5/25.
 */

public class LampListBean {

    /**
     * pageNum : 1
     * pageSize : 3
     * size : 3
     * orderBy : null
     * startRow : 1
     * endRow : 3
     * total : 63
     * pages : 21
     * list : [{"cntr_cntr_name":"A-1","lamp_subordinate_circuit":"4","cntr_cntr_adrs":"1","lamp_cntr_mcad":"001000002491","lamp_cntr_crnt":"","type_name":"LED灯","cntr_cntr_id":10,"cntr_cntr_lngt":105.978104,"lamp_cntr_tmpr":"0","cntr_cntr_mbph":"1","cntr_cntr_ccst":"Online","lamp_cntr_lttd":34.54514,"lamp_cntr_name":"A-02","cntr_cntr_lttd":34.545777,"lamp_cntr_lngt":105.973629,"lamp_cntr_elqn":"0","lamp_cntr_vltg":"","lamp_cntr_pwr":"","lamp_cntr_lccn":"Offline","lamp_cntr_lmnn":"","lamp_cntr_id":835,"lamp_cntr_sn":"2","lamp_cntr_pwfc":""},{"cntr_cntr_name":"A-1","lamp_subordinate_circuit":"2","cntr_cntr_adrs":"1","lamp_cntr_mcad":"001000002580","lamp_cntr_crnt":"","type_name":"LED灯","cntr_cntr_id":10,"cntr_cntr_lngt":105.978104,"lamp_cntr_tmpr":"0","cntr_cntr_mbph":"1","cntr_cntr_ccst":"Online","lamp_cntr_lttd":34.545185,"lamp_cntr_name":"A-03","cntr_cntr_lttd":34.545777,"lamp_cntr_lngt":105.973988,"lamp_cntr_elqn":"0","lamp_cntr_vltg":"","lamp_cntr_pwr":"","lamp_cntr_lccn":"Offline","lamp_cntr_lmnn":"","lamp_cntr_id":836,"lamp_cntr_sn":"3","lamp_cntr_pwfc":""},{"cntr_cntr_name":"A-1","lamp_subordinate_circuit":"4","cntr_cntr_adrs":"1","lamp_cntr_mcad":"001000002093","lamp_cntr_crnt":"","type_name":"LED灯","cntr_cntr_id":10,"cntr_cntr_lngt":105.978104,"lamp_cntr_tmpr":"0","cntr_cntr_mbph":"1","cntr_cntr_ccst":"Online","lamp_cntr_lttd":34.545199,"lamp_cntr_name":"A-04","cntr_cntr_lttd":34.545777,"lamp_cntr_lngt":105.974204,"lamp_cntr_elqn":"0","lamp_cntr_vltg":"","lamp_cntr_pwr":"","lamp_cntr_lccn":"Offline","lamp_cntr_lmnn":"","lamp_cntr_id":837,"lamp_cntr_sn":"4","lamp_cntr_pwfc":""}]
     * firstPage : 1
     * prePage : 0
     * nextPage : 2
     * lastPage : 8
     * isFirstPage : true
     * isLastPage : false
     * hasPreviousPage : false
     * hasNextPage : true
     * navigatePages : 8
     * navigatepageNums : [1,2,3,4,5,6,7,8]
     */

    private int pageNum;
    private int pageSize;
    private int size;
    private Object orderBy;
    private int startRow;
    private int endRow;
    private int total;
    private int pages;
    private int firstPage;
    private int prePage;
    private int nextPage;
    private int lastPage;
    private boolean isFirstPage;
    private boolean isLastPage;
    private boolean hasPreviousPage;
    private boolean hasNextPage;
    private int navigatePages;
    private List<ListBean> list;
    private List<Integer> navigatepageNums;

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Object getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(Object orderBy) {
        this.orderBy = orderBy;
    }

    public int getStartRow() {
        return startRow;
    }

    public void setStartRow(int startRow) {
        this.startRow = startRow;
    }

    public int getEndRow() {
        return endRow;
    }

    public void setEndRow(int endRow) {
        this.endRow = endRow;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getFirstPage() {
        return firstPage;
    }

    public void setFirstPage(int firstPage) {
        this.firstPage = firstPage;
    }

    public int getPrePage() {
        return prePage;
    }

    public void setPrePage(int prePage) {
        this.prePage = prePage;
    }

    public int getNextPage() {
        return nextPage;
    }

    public void setNextPage(int nextPage) {
        this.nextPage = nextPage;
    }

    public int getLastPage() {
        return lastPage;
    }

    public void setLastPage(int lastPage) {
        this.lastPage = lastPage;
    }

    public boolean isIsFirstPage() {
        return isFirstPage;
    }

    public void setIsFirstPage(boolean isFirstPage) {
        this.isFirstPage = isFirstPage;
    }

    public boolean isIsLastPage() {
        return isLastPage;
    }

    public void setIsLastPage(boolean isLastPage) {
        this.isLastPage = isLastPage;
    }

    public boolean isHasPreviousPage() {
        return hasPreviousPage;
    }

    public void setHasPreviousPage(boolean hasPreviousPage) {
        this.hasPreviousPage = hasPreviousPage;
    }

    public boolean isHasNextPage() {
        return hasNextPage;
    }

    public void setHasNextPage(boolean hasNextPage) {
        this.hasNextPage = hasNextPage;
    }

    public int getNavigatePages() {
        return navigatePages;
    }

    public void setNavigatePages(int navigatePages) {
        this.navigatePages = navigatePages;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public List<Integer> getNavigatepageNums() {
        return navigatepageNums;
    }

    public void setNavigatepageNums(List<Integer> navigatepageNums) {
        this.navigatepageNums = navigatepageNums;
    }

    public static class ListBean {
        /**
         * cntr_cntr_name : A-1
         * lamp_subordinate_circuit : 4
         * cntr_cntr_adrs : 1
         * lamp_cntr_mcad : 001000002491
         * lamp_cntr_crnt :
         * type_name : LED灯
         * cntr_cntr_id : 10
         * cntr_cntr_lngt : 105.978104
         * lamp_cntr_tmpr : 0
         * cntr_cntr_mbph : 1
         * cntr_cntr_ccst : Online
         * lamp_cntr_lttd : 34.54514
         * lamp_cntr_name : A-02
         * cntr_cntr_lttd : 34.545777
         * lamp_cntr_lngt : 105.973629
         * lamp_cntr_elqn : 0
         * lamp_cntr_vltg :
         * lamp_cntr_pwr :
         * lamp_cntr_lccn : Offline
         * lamp_cntr_lmnn :
         * lamp_cntr_id : 835
         * lamp_cntr_sn : 2
         * lamp_cntr_pwfc :
         */

        private String cntr_cntr_name;
        private String lamp_subordinate_circuit;
        private String cntr_cntr_adrs;
        private String lamp_cntr_mcad;
        private String lamp_cntr_crnt;
        private String type_name;
        private int cntr_cntr_id;
        private double cntr_cntr_lngt;
        private String lamp_cntr_tmpr;
        private String cntr_cntr_mbph;
        private String cntr_cntr_ccst;
        private double lamp_cntr_lttd;
        private String lamp_cntr_name;
        private double cntr_cntr_lttd;
        private double lamp_cntr_lngt;
        private String lamp_cntr_elqn;
        private String lamp_cntr_vltg;
        private String lamp_cntr_pwr;
        private String lamp_cntr_lccn;
        private String lamp_cntr_lmnn;
        private String lamp_cntr_lcst;
        private int lamp_cntr_id;
        private String lamp_cntr_sn;
        private String lamp_cntr_pwfc;

        public String getLamp_cntr_lcst() {
            return lamp_cntr_lcst;
        }

        public void setLamp_cntr_lcst(String lamp_cntr_lcst) {
            this.lamp_cntr_lcst = lamp_cntr_lcst;
        }

        public String getCntr_cntr_name() {
            return cntr_cntr_name;
        }

        public void setCntr_cntr_name(String cntr_cntr_name) {
            this.cntr_cntr_name = cntr_cntr_name;
        }

        public String getLamp_subordinate_circuit() {
            return lamp_subordinate_circuit;
        }

        public void setLamp_subordinate_circuit(String lamp_subordinate_circuit) {
            this.lamp_subordinate_circuit = lamp_subordinate_circuit;
        }

        public String getCntr_cntr_adrs() {
            return cntr_cntr_adrs;
        }

        public void setCntr_cntr_adrs(String cntr_cntr_adrs) {
            this.cntr_cntr_adrs = cntr_cntr_adrs;
        }

        public String getLamp_cntr_mcad() {
            return lamp_cntr_mcad;
        }

        public void setLamp_cntr_mcad(String lamp_cntr_mcad) {
            this.lamp_cntr_mcad = lamp_cntr_mcad;
        }

        public String getLamp_cntr_crnt() {
            return lamp_cntr_crnt;
        }

        public void setLamp_cntr_crnt(String lamp_cntr_crnt) {
            this.lamp_cntr_crnt = lamp_cntr_crnt;
        }

        public String getType_name() {
            return type_name;
        }

        public void setType_name(String type_name) {
            this.type_name = type_name;
        }

        public int getCntr_cntr_id() {
            return cntr_cntr_id;
        }

        public void setCntr_cntr_id(int cntr_cntr_id) {
            this.cntr_cntr_id = cntr_cntr_id;
        }

        public double getCntr_cntr_lngt() {
            return cntr_cntr_lngt;
        }

        public void setCntr_cntr_lngt(double cntr_cntr_lngt) {
            this.cntr_cntr_lngt = cntr_cntr_lngt;
        }

        public String getLamp_cntr_tmpr() {
            return lamp_cntr_tmpr;
        }

        public void setLamp_cntr_tmpr(String lamp_cntr_tmpr) {
            this.lamp_cntr_tmpr = lamp_cntr_tmpr;
        }

        public String getCntr_cntr_mbph() {
            return cntr_cntr_mbph;
        }

        public void setCntr_cntr_mbph(String cntr_cntr_mbph) {
            this.cntr_cntr_mbph = cntr_cntr_mbph;
        }

        public String getCntr_cntr_ccst() {
            return cntr_cntr_ccst;
        }

        public void setCntr_cntr_ccst(String cntr_cntr_ccst) {
            this.cntr_cntr_ccst = cntr_cntr_ccst;
        }

        public double getLamp_cntr_lttd() {
            return lamp_cntr_lttd;
        }

        public void setLamp_cntr_lttd(double lamp_cntr_lttd) {
            this.lamp_cntr_lttd = lamp_cntr_lttd;
        }

        public String getLamp_cntr_name() {
            return lamp_cntr_name;
        }

        public void setLamp_cntr_name(String lamp_cntr_name) {
            this.lamp_cntr_name = lamp_cntr_name;
        }

        public double getCntr_cntr_lttd() {
            return cntr_cntr_lttd;
        }

        public void setCntr_cntr_lttd(double cntr_cntr_lttd) {
            this.cntr_cntr_lttd = cntr_cntr_lttd;
        }

        public double getLamp_cntr_lngt() {
            return lamp_cntr_lngt;
        }

        public void setLamp_cntr_lngt(double lamp_cntr_lngt) {
            this.lamp_cntr_lngt = lamp_cntr_lngt;
        }

        public String getLamp_cntr_elqn() {
            return lamp_cntr_elqn;
        }

        public void setLamp_cntr_elqn(String lamp_cntr_elqn) {
            this.lamp_cntr_elqn = lamp_cntr_elqn;
        }

        public String getLamp_cntr_vltg() {
            return lamp_cntr_vltg;
        }

        public void setLamp_cntr_vltg(String lamp_cntr_vltg) {
            this.lamp_cntr_vltg = lamp_cntr_vltg;
        }

        public String getLamp_cntr_pwr() {
            return lamp_cntr_pwr;
        }

        public void setLamp_cntr_pwr(String lamp_cntr_pwr) {
            this.lamp_cntr_pwr = lamp_cntr_pwr;
        }

        public String getLamp_cntr_lccn() {
            return lamp_cntr_lccn;
        }

        public void setLamp_cntr_lccn(String lamp_cntr_lccn) {
            this.lamp_cntr_lccn = lamp_cntr_lccn;
        }

        public String getLamp_cntr_lmnn() {
            return lamp_cntr_lmnn;
        }

        public void setLamp_cntr_lmnn(String lamp_cntr_lmnn) {
            this.lamp_cntr_lmnn = lamp_cntr_lmnn;
        }

        public int getLamp_cntr_id() {
            return lamp_cntr_id;
        }

        public void setLamp_cntr_id(int lamp_cntr_id) {
            this.lamp_cntr_id = lamp_cntr_id;
        }

        public String getLamp_cntr_sn() {
            return lamp_cntr_sn;
        }

        public void setLamp_cntr_sn(String lamp_cntr_sn) {
            this.lamp_cntr_sn = lamp_cntr_sn;
        }

        public String getLamp_cntr_pwfc() {
            return lamp_cntr_pwfc;
        }

        public void setLamp_cntr_pwfc(String lamp_cntr_pwfc) {
            this.lamp_cntr_pwfc = lamp_cntr_pwfc;
        }
    }
}
