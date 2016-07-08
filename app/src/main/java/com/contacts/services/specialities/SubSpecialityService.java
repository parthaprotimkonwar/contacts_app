package com.contacts.services.specialities;

import com.activeandroid.query.Select;
import com.contacts.db.models.specialities.Speciality;
import com.contacts.db.models.specialities.SubSpeciality;

import java.util.List;

/**
 * Created by pkonwar on 7/7/2016.
 */
public class SubSpecialityService {

    /**
     * List one SubSpeciality
     * @param subSpecialityId
     * @return
     */
    public static SubSpeciality findASubSpeciality(Long subSpecialityId) {
        return new Select().from(SubSpeciality.class).where("SUB_SPECIALITY_ID = ?", subSpecialityId).executeSingle();
    }

    /**
     * List all SubSpeciality
     * @return
     */
    public static List<SubSpeciality> findAllSubSpeciality() {
        return new Select().from(SubSpeciality.class).execute();
    }
}
