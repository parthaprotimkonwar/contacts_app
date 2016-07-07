package com.contacts.db.models.specialities;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.contacts.db.models.abergin.AUser;


/**
 * Created by pkonwar on 7/2/2016.
 */
@Table(name = "USER_SUB_SPECIALITY")
public class UserSubSpeciality extends Model{


    @Column(name = "USER")
    private AUser user;

    @Column(name = "SUB_SPECIALITY")
    private SubSpeciality subSpeciality;

    @Column(name = "PRICE")
    private Integer price;

    @Column(name = "JOURNAL_ID")
    private Integer journalId;

    public UserSubSpeciality(AUser user, SubSpeciality subSpeciality, Integer price, Integer journalId) {
        this.user = user;
        this.subSpeciality = subSpeciality;
        this.price = price;
        this.journalId = journalId;
    }

    public void superimpose(AUser user, SubSpeciality subSpeciality, Integer price, Integer journalId) {
        this.user = user;
        this.subSpeciality = subSpeciality;
        this.price = price;
        this.journalId = journalId;
    }

    public UserSubSpeciality() {
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getJournalId() {
        return journalId;
    }

    public void setJournalId(Integer journalId) {
        this.journalId = journalId;
    }
}
