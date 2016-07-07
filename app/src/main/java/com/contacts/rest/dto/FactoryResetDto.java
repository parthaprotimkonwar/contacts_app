package com.contacts.rest.dto;


import com.contacts.db.models.bean.places.CityBean;
import com.contacts.db.models.bean.specialities.SpecialityBean;
import com.contacts.db.models.bean.specialities.SubSpecialityBean;
import com.google.gson.annotations.Expose;

import java.io.Serializable;
import java.util.List;

/**
 * Created by pkonwar on 7/4/2016.
 */
public class FactoryResetDto{

    @Expose
    private List<CityBean> cityBeanList;                        // CITY List
    @Expose
    private List<SpecialityBean> specialityBeanList;            // SPECIALITY List
    @Expose
    private List<SubSpecialityBean> subSpecialityBeanList;      // SUB-SPECIALITY List


    public List<CityBean> getCityBeanList() {
        return cityBeanList;
    }

    public void setCityBeanList(List<CityBean> cityBeanList) {
        this.cityBeanList = cityBeanList;
    }

    public List<SpecialityBean> getSpecialityBeanList() {
        return specialityBeanList;
    }

    public void setSpecialityBeanList(List<SpecialityBean> specialityBeanList) {
        this.specialityBeanList = specialityBeanList;
    }

    public List<SubSpecialityBean> getSubSpecialityBeanList() {
        return subSpecialityBeanList;
    }

    public void setSubSpecialityBeanList(List<SubSpecialityBean> subSpecialityBeanList) {
        this.subSpecialityBeanList = subSpecialityBeanList;
    }
}
