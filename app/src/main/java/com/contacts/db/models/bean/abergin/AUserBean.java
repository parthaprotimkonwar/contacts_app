package com.contacts.db.models.bean.abergin;

import com.contacts.app.enums.STATUS;
import com.contacts.app.enums.USER_TYPE;
import com.google.gson.annotations.Expose;

import java.io.Serializable;
import java.util.Date;

public class AUserBean implements Serializable {

    @Expose
    private Long userId;
    @Expose
    private USER_TYPE userType;
    @Expose
    private String name;
    @Expose
    private String email;
    @Expose
    private String mobile;
    @Expose
    private String password;
    @Expose
    private byte[] imageBlob;   //either of imageUrl or imageBlob should be set
    @Expose
    private Date lastLogin;
    @Expose
    private Date createdOn;
    @Expose
    private Long cityId;
    @Expose
    private Long addressId;
    @Expose
    private STATUS status;
    @Expose
    private Integer journalId;     //only during response


    public AUserBean() {
    }

    /**
     * @param userId
     * @param userType
     * @param name
     * @param email
     * @param mobile
     * @param password
     * @param imageBlob
     * @param lastLogin
     * @param createdOn
     * @param status
     * @param journalId
     * @param cityId
     * @param addressId
     */
    public AUserBean(Long userId, USER_TYPE userType, String name, String email, String mobile, String password, byte[] imageBlob, Date lastLogin, Date createdOn, STATUS status, Integer journalId, Long cityId, Long addressId) {
        this.userId = userId;
        this.userType = userType;
        this.name = name;
        this.email = email;
        this.mobile = mobile;
        this.password = password;
        this.imageBlob = imageBlob;
        this.lastLogin = lastLogin;
        this.createdOn = createdOn;
        this.status = status;
        this.journalId = journalId;
        this.cityId = cityId;
        this.addressId = addressId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public USER_TYPE getUserType() {
        return userType;
    }

    public void setUserType(USER_TYPE userType) {
        this.userType = userType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public STATUS getStatus() {
        return status;
    }

    public void setStatus(STATUS status) {
        this.status = status;
    }

    public byte[] getImageBlob() {
        return imageBlob;
    }

    public void setImageBlob(byte[] imageBlob) {
        this.imageBlob = imageBlob;
    }

    public Integer getJournalId() {
        return journalId;
    }

    public void setJournalId(Integer journalId) {
        this.journalId = journalId;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }
}
