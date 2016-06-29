package com.contacts.db.beans;

/**
 * Created by pkonwar on 6/29/2016.
 */
public class ContactsBean {

    private String name;
    private Integer contactImageId;
    private Integer price;
    private Long contactNumber;
    private Integer yearsOfExperience;

    public ContactsBean(String name, Integer contactImageId, Integer price, Long contactNumber, Integer yearsOfExperience) {
        this.name = name;
        this.contactImageId = contactImageId;
        this.price = price;
        this.contactNumber = contactNumber;
        this.yearsOfExperience = yearsOfExperience;
    }

    public ContactsBean() {
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getContactImageId() {
        return contactImageId;
    }

    public void setContactImageId(Integer contactImageId) {
        this.contactImageId = contactImageId;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Long getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(Long contactNumber) {
        this.contactNumber = contactNumber;
    }

    public Integer getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(Integer yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }
}
