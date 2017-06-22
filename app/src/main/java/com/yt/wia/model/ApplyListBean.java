package com.yt.wia.model;

import java.util.List;

/**
 * Created by admin on 2017/6/22.
 */

public class ApplyListBean {

    /**
     * pageNum : 1
     * pageSize : 10
     * size : 1
     * orderBy : null
     * startRow : 1
     * endRow : 1
     * total : 1
     * pages : 1
     * list : [{"id":6,"orgName":"qqq","personName":"qqq","phone":"qqq","mail":"ash@qq.com","projectName":"qqq","tze":1231,"requireTdmj":"123","projectContext":"qqq","ssqk":"qqq","jyqk":"qqq","yye":"qqq","entryTime":"2017-06-22T03:24:03.032+0000","entryUserName":null,"entryUserId":null,"review_link":1,"reviews":null}]
     * firstPage : 1
     * prePage : 0
     * nextPage : 0
     * lastPage : 1
     * isFirstPage : true
     * isLastPage : true
     * hasPreviousPage : false
     * hasNextPage : false
     * navigatePages : 8
     * navigatepageNums : [1]
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
         * id : 6
         * orgName : qqq
         * personName : qqq
         * phone : qqq
         * mail : ash@qq.com
         * projectName : qqq
         * tze : 1231.0
         * requireTdmj : 123
         * projectContext : qqq
         * ssqk : qqq
         * jyqk : qqq
         * yye : qqq
         * entryTime : 2017-06-22T03:24:03.032+0000
         * entryUserName : null
         * entryUserId : null
         * reviewLink : 1
         * reviews : null
         */

        private Long id;
        private String orgName;
        private String personName;
        private String phone;
        private String mail;
        private String projectName;
        private double tze;
        private String requireTdmj;
        private String projectContext;
        private String ssqk;
        private String jyqk;
        private String yye;
        private String entryTime;
        private Object entryUserName;
        private Object entryUserId;
        private int reviewLink;
        private Object reviews;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getOrgName() {
            return orgName;
        }

        public void setOrgName(String orgName) {
            this.orgName = orgName;
        }

        public String getPersonName() {
            return personName;
        }

        public void setPersonName(String personName) {
            this.personName = personName;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getMail() {
            return mail;
        }

        public void setMail(String mail) {
            this.mail = mail;
        }

        public String getProjectName() {
            return projectName;
        }

        public void setProjectName(String projectName) {
            this.projectName = projectName;
        }

        public double getTze() {
            return tze;
        }

        public void setTze(double tze) {
            this.tze = tze;
        }

        public String getRequireTdmj() {
            return requireTdmj;
        }

        public void setRequireTdmj(String requireTdmj) {
            this.requireTdmj = requireTdmj;
        }

        public String getProjectContext() {
            return projectContext;
        }

        public void setProjectContext(String projectContext) {
            this.projectContext = projectContext;
        }

        public String getSsqk() {
            return ssqk;
        }

        public void setSsqk(String ssqk) {
            this.ssqk = ssqk;
        }

        public String getJyqk() {
            return jyqk;
        }

        public void setJyqk(String jyqk) {
            this.jyqk = jyqk;
        }

        public String getYye() {
            return yye;
        }

        public void setYye(String yye) {
            this.yye = yye;
        }

        public String getEntryTime() {
            return entryTime;
        }

        public void setEntryTime(String entryTime) {
            this.entryTime = entryTime;
        }

        public Object getEntryUserName() {
            return entryUserName;
        }

        public void setEntryUserName(Object entryUserName) {
            this.entryUserName = entryUserName;
        }

        public Object getEntryUserId() {
            return entryUserId;
        }

        public void setEntryUserId(Object entryUserId) {
            this.entryUserId = entryUserId;
        }

        public int getReviewLink() {
            return reviewLink;
        }

        public void setReviewLink(int reviewLink) {
            this.reviewLink = reviewLink;
        }

        public Object getReviews() {
            return reviews;
        }

        public void setReviews(Object reviews) {
            this.reviews = reviews;
        }
    }
}
