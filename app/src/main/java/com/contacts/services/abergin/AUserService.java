package com.contacts.services.abergin;

import com.activeandroid.query.Select;
import com.contacts.db.models.abergin.AUser;

import java.util.List;

/**
 * Created by pkonwar on 7/7/2016.
 */
public class AUserService {

    public static AUser findAUser(Long userId) {
        return new Select().from(AUser.class).where("USER_ID = ?", userId).executeSingle();
    }

    public static List<AUser> users() {
        return new Select().from(AUser.class).execute();
    }
}
