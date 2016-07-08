package com.contacts.ui.cache;

/**
 * Created by pkonwar on 7/8/2016.
 */
public class DataBundle {

    private Long cityId;
    private Long subSpecilityId;

    private DataBundle(){}
    private static DataBundle dataBundle = null;

    //Singleton Instance of DataBundle cache
    public static DataBundle getInstance() {
        if(dataBundle == null) {
            synchronized (DataBundle.class) {
                if(dataBundle == null) {
                    dataBundle = new DataBundle();
                }
            }
        }
        return dataBundle;
    }
    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public Long getSubSpecilityId() {
        return subSpecilityId;
    }

    public void setSubSpecilityId(Long subSpecilityId) {
        this.subSpecilityId = subSpecilityId;
    }
}
