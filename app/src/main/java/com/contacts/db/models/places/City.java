package com.contacts.db.models.places;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.contacts.app.enums.STATUS;
import com.contacts.db.models.abergin.AUser;

import java.util.List;

/**
 * Created by pkonwar on 7/2/2016.
 */
@Table(name = "CITY")
public class City extends Model{

    public City(){}

    public City(String name, Double latitude, Double longitude, STATUS status){
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.status = status;
    }

    @Column(name = "CITY_ID")
    private Long cityId;

    @Column(name = "NAME", length = 30)
    private String name;

    @Column(name = "LATITUDE")
    private Double latitude;

    @Column(name = "LONGITUDE")
    private Double longitude;

    @Column(name = "STATUS")
    private STATUS status;

    @Column(name = "JOURNAL_ID")
    private Integer journalId;

    private List<AUser> userList;

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Integer getJournalId() {
        return journalId;
    }

    public void setJournalId(Integer journalId) {
        this.journalId = journalId;
    }

    public STATUS getStatus() {
        return status;
    }

    public void setStatus(STATUS status) {
        this.status = status;
    }

    public List<AUser> getUserList() {
        return getMany(AUser.class, "CITY");
    }

    public void setUserList(List<AUser> userList) {
        this.userList = userList;
    }
}
