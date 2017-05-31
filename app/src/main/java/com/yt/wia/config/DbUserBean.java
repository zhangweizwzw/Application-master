package com.yt.wia.config;

import android.graphics.Bitmap;

import org.xutils.db.annotation.Column;
import org.xutils.db.annotation.Table;

import java.util.Date;

/**
 * Created by wxixis on 16/7/11.
 */
@Table(name="users")
public class DbUserBean {
    @Column(name = "id",isId = true,autoGen=true)
    private int id;
    @Column(name = "password")
    private String password;
    @Column(name = "upasword")
    private String upasword;
    @Column(name = "account")
    private String account;
    @Column(name = "avatarImage")
    private String avatarImage;
    private String status;
    @Column(name = "insertDate")
    private Date insertDate;


    public DbUserBean(){

    }

    public DbUserBean(int id,String password,String avatarImage,Date insertDate,String upasword){
        this.id=id;
        this.password=password;
        this.avatarImage=avatarImage;
        this.insertDate=insertDate;
        this.upasword=upasword;
    }

    public Date getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(Date insertDate) {
        this.insertDate = insertDate;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUpasword() {
        return upasword;
    }

    public void setUpasword(String upasword) {
        this.upasword = upasword;
    }

    public String getAvatarImage() {
        return avatarImage;
    }

    public void setAvatarImage(String avatarImage) {
        this.avatarImage = avatarImage;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", password='" + password + '\'' +
                ", avatarImage='" + avatarImage + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
