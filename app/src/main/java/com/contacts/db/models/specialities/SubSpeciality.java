package com.contacts.db.models.specialities;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.contacts.app.enums.STATUS;

import java.util.List;

/**
 * Created by pkonwar on 7/3/2016.
 */
@Table(name = "SUB_SPECIALITY")
public class SubSpeciality extends Model {

    public SubSpeciality() {
    }

    public SubSpeciality(String subSpeciality, STATUS status, byte[] imageBlob, Speciality speciality) {
        this.subSpeciality = subSpeciality;
        this.status = status;
        this.imageBlob = imageBlob;
        this.speciality = speciality;
    }

    @Column(name = "SUB_SPECIALITY_ID")
    private Long subSpecialityId;

    @Column(name = "SUB_SPECIALITY", length = 30, notNull = true, unique = true)
    private String subSpeciality;

    @Column(name = "STATUS")
    private STATUS status;

    @Column(name = "IMAGE_BLOB")
    private byte[] imageBlob;

    @Column(name = "SPECIALITY")
    private Speciality speciality;

    @Column(name = "JOURNAL_ID")
    private Integer journalId;

    private List<UserSubSpeciality> userSubSpecialityList;

    public Long getSubSpecialityId() {
        return subSpecialityId;
    }

    public void setSubSpecialityId(Long subSpecialityId) {
        this.subSpecialityId = subSpecialityId;
    }

    public String getSubSpeciality() {
        return subSpeciality;
    }

    public void setSubSpeciality(String subSpeciality) {
        this.subSpeciality = subSpeciality;
    }

    public STATUS getStatus() {
        return status;
    }

    public void setStatus(STATUS status) {
        this.status = status;
    }

    public Speciality getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Speciality speciality) {
        this.speciality = speciality;
    }

    public Integer getJournalId() {
        return journalId;
    }

    public void setJournalId(Integer journalId) {
        this.journalId = journalId;
    }

    public List<UserSubSpeciality> getUserSubSpecialityList() {
        return getMany(UserSubSpeciality.class, "SUB_SPECIALITY");
    }

    public void setUserSubSpecialityList(List<UserSubSpeciality> userSubSpecialityList) {
        this.userSubSpecialityList = userSubSpecialityList;
    }
}
