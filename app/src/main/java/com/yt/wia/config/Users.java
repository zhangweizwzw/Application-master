package com.yt.wia.config;

/**
 * Created by wxixis on 16/7/11.
 */
//@Table(name="users")
public class Users {
    /**
     * id : 0
     * account : admin
     * password : 96e79218965eb72c92a549dd5a330112
     * userName : 管理员
     * sex : M
     * email :
     * addr : 北京市差阳区北四环中路6号
     * fixedTelephone :
     * phone :
     * idNumber : 1111111
     * code : 36-01
     * remark :
     * avatarImage : /user_head/8dfa7b43827448f28a810fae2df73ac7.jpg
     * status :
     * createDate : 1441073404000
     * createOpName : SYSTTEM
     * orgId : 0
     * orgName : 北京雅图科技有限公司
     * roleId :
     * roleName : 系统管理员
     */

    private int id;
    private String account;
    private String password;
    private String userName;
    private String sex;
    private String email;
    private String addr;
    private String fixedTelephone;
    private String phone;
    private String idNumber;
    private String code;
    private String remark;
    private String avatarImage;
    private String status;
    private long createDate;
    private String createOpName;
    private int orgId;
    private String orgName;
    private String roleId;
    private String roleName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getFixedTelephone() {
        return fixedTelephone;
    }

    public void setFixedTelephone(String fixedTelephone) {
        this.fixedTelephone = fixedTelephone;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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

    public long getCreateDate() {
        return createDate;
    }

    public void setCreateDate(long createDate) {
        this.createDate = createDate;
    }

    public String getCreateOpName() {
        return createOpName;
    }

    public void setCreateOpName(String createOpName) {
        this.createOpName = createOpName;
    }

    public int getOrgId() {
        return orgId;
    }

    public void setOrgId(int orgId) {
        this.orgId = orgId;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

//    @Column(name = "id",isId = true,autoGen=true)
//    private int id;
//    private String account;
//    @Column(name = "password")
//    private String password;
//    @Column(name = "avatarImage")
//    private String avatarImage;
//    private String status;
//
//
//    public Users(){
//
//    }
//
//    public Users(int id,String password,String avatarImage){
//        this.id=id;
//        this.password=password;
//        this.avatarImage=avatarImage;
//
//    }
//
//    public String getAccount() {
//        return account;
//    }
//
//    public void setAccount(String account) {
//        this.account = account;
//    }
//
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public String getAvatarImage() {
//        return avatarImage;
//    }
//
//    public void setAvatarImage(String avatarImage) {
//        this.avatarImage = avatarImage;
//    }
//
//    public String getStatus() {
//        return status;
//    }
//
//    public void setStatus(String status) {
//        this.status = status;
//    }
//
//    @Override
//    public String toString() {
//        return "Users{" +
//                "id=" + id +
//                ", password='" + password + '\'' +
//                ", avatarImage='" + avatarImage + '\'' +
//                ", status='" + status + '\'' +
//                '}';
//    }
}
