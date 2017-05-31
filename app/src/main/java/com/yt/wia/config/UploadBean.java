package com.yt.wia.config;

/**
 * Created by admin on 2016/8/17.
 */
public class UploadBean {

    /**
     * newName : 3d9a640a3b0d4f29822a6267be33a530.svg
     * uploadDate : 2016-08-17 15:52:10
     * fileSize : 3196
     * savePath : handwrite
     * oldName : /storage/emulated/0/Pictures/SignaturePad/Signature_1471420324366.svg
     * fileType : 1
     */

    private String newName;
    private String uploadDate;
    private String fileSize;
    private String savePath;
    private String oldName;
    private String fileType;

    public String getNewName() {
        return newName;
    }

    public void setNewName(String newName) {
        this.newName = newName;
    }

    public String getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(String uploadDate) {
        this.uploadDate = uploadDate;
    }

    public String getFileSize() {
        return fileSize;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }

    public String getSavePath() {
        return savePath;
    }

    public void setSavePath(String savePath) {
        this.savePath = savePath;
    }

    public String getOldName() {
        return oldName;
    }

    public void setOldName(String oldName) {
        this.oldName = oldName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }
}
