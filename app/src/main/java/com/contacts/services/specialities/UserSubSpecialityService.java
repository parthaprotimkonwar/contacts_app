package com.contacts.services.specialities;

import com.activeandroid.query.Select;
import com.contacts.db.models.abergin.AUser;
import com.contacts.db.models.specialities.SubSpeciality;
import com.contacts.db.models.specialities.UserSubSpeciality;
import com.contacts.services.abergin.AUserService;

import java.util.List;

/**
 * Created by pkonwar on 7/8/2016.
 */
public class UserSubSpecialityService {

    /*public static SubSpeciality findAUserSubSpeciality(Long user, Long subSpeciality) {
        return new Select().from(UserSubSpeciality.class).where("USER = ?", user).and("SUB_SPECIALITY = ?", subSpeciality).executeSingle();
    }*/

    public static UserSubSpeciality findAUserSubSpeciality(Long userId, Long subSpecialityId) {
        AUser user = AUserService.findAUser(userId);
        SubSpeciality subSpeciality = SubSpecialityService.findASubSpeciality(subSpecialityId);
        return new Select().from(UserSubSpeciality.class).where("USER = ?", user.getId()).and("SUB_SPECIALITY = ?", subSpeciality.getId()).executeSingle();
    }

    public static List<UserSubSpeciality> findAllUserSubSpeciality(Long subSpecialityId) {
        SubSpeciality subSpeciality = SubSpecialityService.findASubSpeciality(subSpecialityId);
        return new Select().from(UserSubSpeciality.class).where("SUB_SPECIALITY = ?", subSpeciality.getId()).execute();
    }
}
