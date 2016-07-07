package com.contacts.rest.dto;

import com.contacts.db.models.bean.abergin.AUserBean;
import com.contacts.db.models.bean.abergin.AddressBean;
import com.contacts.db.models.bean.specialities.UserSubSpecialityBean;
import com.google.gson.annotations.Expose;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by pkonwar on 7/6/2016.
 */

public class VendorsInCityDto implements Serializable{

    @Expose
    private List<AUserBean> userBeanList;                                       //List of USERS
    @Expose
    private List<AddressBean> addressBeanList;                                  //Address for the USERS
    @Expose
    private List<UserSubSpecialityBean> userSubSpecialityBeanList;              //User's SPECIALITY

    public void addToUserBeanList(AUserBean userBean) {
        if(userBeanList == null)
            userBeanList = new ArrayList<>();
        userBeanList.add(userBean);
    }

    public void addToAddressBeanList(AddressBean addressBean) {
        if(addressBeanList == null)
            addressBeanList = new ArrayList<>();
        addressBeanList.add(addressBean);
    }

    public void addToUserSubSpeciality(UserSubSpecialityBean userSubSpecialityBean) {
        if(userSubSpecialityBeanList == null)
            userSubSpecialityBeanList = new ArrayList<>();
        userSubSpecialityBeanList.add(userSubSpecialityBean);
    }

    public List<AUserBean> getUserBeanList() {
        return userBeanList;
    }

    public void setUserBeanList(List<AUserBean> userBeanList) {
        this.userBeanList = userBeanList;
    }

    public List<AddressBean> getAddressBeanList() {
        return addressBeanList;
    }

    public void setAddressBeanList(List<AddressBean> addressBeanList) {
        this.addressBeanList = addressBeanList;
    }

    public List<UserSubSpecialityBean> getUserSubSpecialityBeanList() {
        return userSubSpecialityBeanList;
    }

    public void setUserSubSpecialityBeanList(List<UserSubSpecialityBean> userSubSpecialityBeanList) {
        this.userSubSpecialityBeanList = userSubSpecialityBeanList;
    }
}
