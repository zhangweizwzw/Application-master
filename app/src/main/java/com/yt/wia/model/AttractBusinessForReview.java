package com.yt.wia.model;

/**
 * Created by admin on 2017/6/22.
 */

public class AttractBusinessForReview {
/*
    "id":2,
            "reviewTime":"2017-04-07",
            "reviewOrgName":"天水开发区管委会",
            "reviewUserId":0,
            "reviewUserName":"111",
            "reviewResult":true,
            "reviewDesc":"aaaa"*/
    private int id;
    private String reviewTime;
    private String reviewOrgName;
    private String reviewUserId;
    private String reviewUserName;
    private String reviewResult;
    private String reviewDesc;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReviewTime() {
        return reviewTime;
    }

    public void setReviewTime(String reviewTime) {
        this.reviewTime = reviewTime;
    }

    public String getReviewOrgName() {
        return reviewOrgName;
    }

    public void setReviewOrgName(String reviewOrgName) {
        this.reviewOrgName = reviewOrgName;
    }

    public String getReviewUserId() {
        return reviewUserId;
    }

    public void setReviewUserId(String reviewUserId) {
        this.reviewUserId = reviewUserId;
    }

    public String getReviewUserName() {
        return reviewUserName;
    }

    public void setReviewUserName(String reviewUserName) {
        this.reviewUserName = reviewUserName;
    }

    public String getReviewResult() {
        return reviewResult;
    }

    public void setReviewResult(String reviewResult) {
        this.reviewResult = reviewResult;
    }

    public String getReviewDesc() {
        return reviewDesc;
    }

    public void setReviewDesc(String reviewDesc) {
        this.reviewDesc = reviewDesc;
    }
}
