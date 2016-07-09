package com.contacts.services.places;

import com.activeandroid.query.Select;
import com.contacts.db.models.places.City;

import java.util.List;

/**
 * Created by pkonwar on 7/7/2016.
 */
public class CityService {

    public static City findACity(Long cityId) {
        return new Select().from(City.class).where("CITY_ID = ?", cityId).executeSingle();
    }

    /**
     * Find all Cities
     * @return
     */
    public static List<City> cities() {
        return new Select().from(City.class).execute();
    }
}
