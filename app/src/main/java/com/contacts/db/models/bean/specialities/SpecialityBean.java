package com.contacts.db.models.bean.specialities;

import com.contacts.app.enums.STATUS;
import com.google.gson.annotations.Expose;

import java.io.Serializable;

/**
 * Created by pkonwar on 7/2/2016.
 */
public class SpecialityBean implements Serializable {

    public SpecialityBean() {
    }

    public SpecialityBean(Long specialityId) {
        this.specialityId = specialityId;
    }

    public SpecialityBean(Long specialityId, String speciality, STATUS status, Integer journalId) {
        this.specialityId = specialityId;
        this.speciality = speciality;
        this.status = status;
        this.journalId = journalId;
    }

    @Expose
    private Long specialityId;
    @Expose
    private String speciality;
    @Expose
    private STATUS status;
    @Expose
    private byte[] imageBlob;       //only one of imageUrl or imageBlob need to be filled.
    @Expose
    private Integer journalId;

    public Long getSpecialityId() {
        return specialityId;
    }

    public void setSpecialityId(Long specialityId) {
        this.specialityId = specialityId;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
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
}
