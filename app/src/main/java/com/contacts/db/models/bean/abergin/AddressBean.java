package com.contacts.db.models.bean.abergin;

import com.google.gson.annotations.Expose;

import java.io.Serializable;

public class AddressBean implements Serializable {

    public AddressBean() {
    }

    public AddressBean(Long addressId, String addressHeading, String pincode, String address, String landmark, String phoneNo, String city, String state, String country, Double longitude, Double latitude, Long userId, Integer journalId) {
        this.addressId = addressId;
        this.addressHeading = addressHeading;
        this.pincode = pincode;
        this.address = address;
        this.landmark = landmark;
        this.phoneNo = phoneNo;
        this.city = city;
        this.state = state;
        this.country = country;
        this.latitude = latitude;
        this.longitude = longitude;
        this.userId = userId;
        this.journalId = journalId;
    }

    @Expose
    private Long addressId;
    @Expose
    private String addressHeading;
    @Expose
    private String pincode;
    @Expose
    private String address;
    @Expose
    private String landmark;
    @Expose
    private String phoneNo;
    @Expose
    private String city;
    @Expose
    private String state;
    @Expose
    private String country;
    @Expose
    private Double longitude;
    @Expose
    private Double latitude;
    @Expose
    private Long userId;        //@Mandatory
    @Expose
    private Integer journalId;     //JournalID of the record

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    public String getAddressHeading() {
        return addressHeading;
    }

    public void setAddressHeading(String addressHeading) {
        this.addressHeading = addressHeading;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLandmark() {
        return landmark;
    }

    public void setLandmark(String landmark) {
        this.landmark = landmark;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getJournalId() {
        return journalId;
    }

    public void setJournalId(Integer journalId) {
        this.journalId = journalId;
    }
}
