package com.contacts.db.models.bean.specialities;

import com.google.gson.annotations.Expose;

/**
 * Created by pkonwar on 7/2/2016.
 */
public class UserSubSpecialityBean {

    @Expose
    private UserIdSubSpecialityIdBean userIdSubSpecialityIdBean;
    @Expose
    private Integer price;
    @Expose
    private Integer journalId;

    public UserSubSpecialityBean() {
    }

    public UserSubSpecialityBean(UserIdSubSpecialityIdBean userIdSubSpecialityIdBean, Integer price, Integer journalId) {
        this.userIdSubSpecialityIdBean = userIdSubSpecialityIdBean;
        this.price = price;
        this.journalId = journalId;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public UserIdSubSpecialityIdBean getUserIdSubSpecialityIdBean() {
        return userIdSubSpecialityIdBean;
    }

    public void setUserIdSubSpecialityIdBean(UserIdSubSpecialityIdBean userIdSubSpecialityIdBean) {
        this.userIdSubSpecialityIdBean = userIdSubSpecialityIdBean;
    }

    public Integer getJournalId() {
        return journalId;
    }

    public void setJournalId(Integer journalId) {
        this.journalId = journalId;
    }
}
