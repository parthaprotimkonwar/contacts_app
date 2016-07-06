package com.contacts.services.places;

import com.activeandroid.query.Select;
import com.contacts.db.models.places.City;

/**
 * Created by pkonwar on 7/7/2016.
 */
public class CityService {

    public static City findACity(Long cityId) {
        return new Select().from(City.class).where("CITY_ID = ?", cityId).executeSingle();
    }
}
