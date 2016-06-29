package com.contacts.db.beans;

/**
 * Created by pkonwar on 6/28/2016.
 */
public class CategoriesBean {

    private Integer categoryImage;
    private String categoryName;

    public CategoriesBean() {
    }

    public CategoriesBean(Integer categoryImage, String categoryName) {
        this.categoryImage = categoryImage;
        this.categoryName = categoryName;
    }


    public Integer getCategoryImage() {
        return categoryImage;
    }

    public void setCategoryImage(Integer categoryImage) {
        this.categoryImage = categoryImage;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
