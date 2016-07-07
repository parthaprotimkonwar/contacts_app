package com.contacts.services.abergin;

import com.activeandroid.query.Select;
import com.contacts.db.models.abergin.AUser;
import com.contacts.db.models.abergin.Address;

/**
 * Created by pkonwar on 7/7/2016.
 */
public class AddressService {

    public static Address findAAddress(Long addressId) {
        return new Select().from(Address.class).where("ADDRESS_ID = ?", addressId).executeSingle();
    }

    public static Address findAddressForUser(Long userId) {
        AUser user = AUserService.findAUser(userId);
        return new Select().from(Address.class).where("USER = ?", user.getId()).executeSingle();
    }
}
