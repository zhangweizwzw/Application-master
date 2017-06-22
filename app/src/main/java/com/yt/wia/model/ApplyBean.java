package com.yt.wia.model;

import java.util.List;

/**
 * zw
 * 保存申请  实体
 * Created by admin on 2017/6/21.
 */

public class ApplyBean {
    private Long id;//主键

    private String orgName;//企业名称

    private String personName;//联系人

    private String phone;//联系方式

    private String mail;//联系邮箱

    private String projectName;//项目名称

    private String tze;//投资额

    private String requireTdmj;//土地需求面积

    private String projectContext;//项目建设内容

    private String ssqk;//税收情况

    private String jyqk;//就业情况

    private String yye;//营业额

    private String entryTime;//录入时间

    private String entryUserName;//录入人姓名

    private Long entryUserId;//录入人id

    private int reviewLink=1;//流程环节(1/2/3/4/99=村/乡/县/市/完结)

    private List<AttractBusinessForReview> reviews;//关联审核列表

    public int getReviewLink() {
        return reviewLink;
    }

    public void setReviewLink(int reviewLink) {
        this.reviewLink = reviewLink;
    }

    public List<AttractBusinessForReview> getReviews() {
        return reviews;
    }

    public void setReviews(List<AttractBusinessForReview> reviews) {
        this.reviews = reviews;
    }

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

    public String getTze() {
        return tze;
    }

    public void setTze(String tze) {
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

    public String getEntryUserName() {
        return entryUserName;
    }

    public void setEntryUserName(String entryUserName) {
        this.entryUserName = entryUserName;
    }

    public Long getEntryUserId() {
        return entryUserId;
    }

    public void setEntryUserId(Long entryUserId) {
        this.entryUserId = entryUserId;
    }
}
