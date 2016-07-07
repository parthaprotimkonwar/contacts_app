package com.contacts.db.models.specialities;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.contacts.app.enums.STATUS;

import java.util.List;

/**
 * Created by pkonwar on 7/2/2016.
 */
@Table(name = "SPECIALITY")
public class Speciality extends Model {

    public Speciality() {
    }

    public Speciality(Long specialityId, String speciality, STATUS status, byte[] imageBlob, Integer journalId) {
        this.specialityId = specialityId;
        this.speciality = speciality;
        this.status = status;
        this.imageBlob = imageBlob;
        this.journalId = journalId;
    }

    @Column(name = "SPECIALITY_ID")
    private Long specialityId;

    @Column(name = "SPECIALITY", length = 30, notNull = true, unique = true)
    private String speciality;

    @Column(name = "STATUS")
    private STATUS status;

    @Column(name = "IMAGE_BLOB")
    private byte[] imageBlob;

    @Column(name = "JOURNAL_ID")
    private Integer journalId;

    private List<SubSpeciality> subSpecialityList;

    public void superimpose(Long specialityId, String speciality, STATUS status, byte[] imageBlob, Integer journalId) {
        this.specialityId = specialityId;
        this.speciality = speciality;
        this.status = status;
        this.imageBlob = imageBlob;
        this.journalId = journalId;
    }

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

    public Integer getJournalId() {
        return journalId;
    }

    public void setJournalId(Integer journalId) {
        this.journalId = journalId;
    }

    public List<SubSpeciality> getSubSpecialityList() {
        return getMany(SubSpeciality.class, "SPECIALITY");
    }

    public void setSubSpecialityList(List<SubSpeciality> subSpecialityList) {
        this.subSpecialityList = subSpecialityList;
    }
}
