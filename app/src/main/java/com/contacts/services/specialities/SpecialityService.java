package com.contacts.services.specialities;

import com.activeandroid.query.Select;
import com.contacts.db.models.specialities.Speciality;

/**
 * Created by pkonwar on 7/7/2016.
 */
public class SpecialityService {

    public static Speciality findASpeciality(Long specialityId) {
        return new Select().from(Speciality.class).where("SPECIALITY_ID = ?", specialityId).executeSingle();
    }

}
