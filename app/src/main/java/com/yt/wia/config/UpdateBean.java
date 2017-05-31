package com.yt.wia.config;

/**
 * Created by admin on 2016/7/28.
 */
public class UpdateBean {

    /**
     * id : 52
     * version : V9.6.6
     * releaseTerminal : ANDROID
     * forciblyUpdate : true
     * effective : true
     * fileUrl : /apk/bc1a3b884e1f4129b48917a847199cb1.apk
     * releaseNotes : 方法
     * submitDate : 1466352000000
     */

    private int id;
    private String version;
    private String releaseTerminal;
    private boolean forciblyUpdate;
    private boolean effective;
    private String fileUrl;
    private String releaseNotes;
    private long submitDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getReleaseTerminal() {
        return releaseTerminal;
    }

    public void setReleaseTerminal(String releaseTerminal) {
        this.releaseTerminal = releaseTerminal;
    }

    public boolean isForciblyUpdate() {
        return forciblyUpdate;
    }

    public void setForciblyUpdate(boolean forciblyUpdate) {
        this.forciblyUpdate = forciblyUpdate;
    }

    public boolean isEffective() {
        return effective;
    }

    public void setEffective(boolean effective) {
        this.effective = effective;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public String getReleaseNotes() {
        return releaseNotes;
    }

    public void setReleaseNotes(String releaseNotes) {
        this.releaseNotes = releaseNotes;
    }

    public long getSubmitDate() {
        return submitDate;
    }

    public void setSubmitDate(long submitDate) {
        this.submitDate = submitDate;
    }
}
