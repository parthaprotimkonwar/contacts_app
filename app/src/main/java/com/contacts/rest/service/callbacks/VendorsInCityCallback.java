package com.contacts.rest.service.callbacks;

import com.contacts.db.models.abergin.AUser;
import com.contacts.db.models.abergin.Address;
import com.contacts.db.models.bean.abergin.AUserBean;
import com.contacts.db.models.bean.abergin.AddressBean;
import com.contacts.db.models.bean.specialities.UserSubSpecialityBean;
import com.contacts.db.models.places.City;
import com.contacts.db.models.specialities.SubSpeciality;
import com.contacts.db.models.specialities.UserSubSpeciality;
import com.contacts.rest.dto.VendorsInCityDto;
import com.contacts.services.abergin.AUserService;
import com.contacts.services.abergin.AddressService;
import com.contacts.services.places.CityService;
import com.contacts.services.specialities.SubSpecialityService;
import com.contacts.services.specialities.UserSubSpecialityService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by pkonwar on 7/8/2016.
 */
public class VendorsInCityCallback implements Callback<VendorsInCityDto> {

    @Override
    public void onResponse(Call<VendorsInCityDto> call, Response<VendorsInCityDto> response) {

        VendorsInCityDto vendorsInCityDto = response.body();

        //Save User
        List<AUserBean> userBeanList = vendorsInCityDto.getUserBeanList() == null ? new ArrayList<AUserBean>() : vendorsInCityDto.getUserBeanList();

        for(AUserBean bean : userBeanList) {
            Long userId = bean.getUserId();
            Integer journalId = bean.getJournalId();

            AUser user = AUserService.findAUser(userId);
            if(user == null) {
                City city = CityService.findACity(bean.getCityId());
                user = new AUser(bean.getUserId(), bean.getUserType(), bean.getName(), bean.getEmail(), bean.getMobile(), bean.getPassword(), bean.getImageBlob(), bean.getLastLogin(), bean.getCreatedOn(), bean.getStatus(), city, bean.getJournalId());
                user.save();
                System.out.println("User saved");
            } else if(journalId == null || !journalId.equals(bean.getJournalId())) {
                City city = CityService.findACity(bean.getCityId());
                user.superimpose(bean.getUserId(), bean.getUserType(), bean.getName(), bean.getEmail(), bean.getMobile(), bean.getPassword(), bean.getImageBlob(), bean.getLastLogin(), bean.getCreatedOn(), bean.getStatus(), city, bean.getJournalId());
                user.save();
            }

        }

        //Save all Addresses
        List<AddressBean> addressBeanList = vendorsInCityDto.getAddressBeanList() == null ? new ArrayList<AddressBean>() : vendorsInCityDto.getAddressBeanList();

        for(AddressBean bean : addressBeanList) {
            Long addressId = bean.getAddressId();
            Integer journalId = bean.getJournalId();

            Address address = AddressService.findAAddress(addressId);
            if(address == null) {
                AUser user = AUserService.findAUser(bean.getUserId());
                address = new Address(bean.getAddressId(), bean.getAddressHeading(), bean.getPincode(), bean.getAddress(), bean.getLandmark(), bean.getPhoneNo(),bean.getCity(), bean.getState(), bean.getCountry(), bean.getLongitude(), bean.getLatitude(), user, bean.getJournalId());
                address.save();
                System.out.println("Address saved");
            } else if(journalId == null || !journalId.equals(address.getJournalId())) {
                AUser user = AUserService.findAUser(bean.getUserId());
                address.superimpose(bean.getAddressId(), bean.getAddressHeading(), bean.getPincode(), bean.getAddress(), bean.getLandmark(), bean.getPhoneNo(),bean.getCity(), bean.getState(), bean.getCountry(), bean.getLongitude(), bean.getLatitude(), user, bean.getJournalId());
                address.save();
            }
        }

        List<UserSubSpecialityBean> userSubSpecialityBeanList = vendorsInCityDto.getUserSubSpecialityBeanList() == null ? new ArrayList<UserSubSpecialityBean>() : vendorsInCityDto.getUserSubSpecialityBeanList();

        for(UserSubSpecialityBean bean : userSubSpecialityBeanList) {
            Long userId = bean.getUserIdSubSpecialityIdBean().getUserId();
            Long subSpecialityId = bean.getUserIdSubSpecialityIdBean().getSubSpecialityId();

            AUser user = AUserService.findAUser(userId);
            SubSpeciality subSpeciality = SubSpecialityService.findASubSpeciality(subSpecialityId);

            Integer journalId = bean.getJournalId();
            UserSubSpeciality userSubSpeciality = UserSubSpecialityService.findAUserSubSpeciality(userId, subSpecialityId);

            if(userSubSpeciality == null) {
                userSubSpeciality = new UserSubSpeciality(user, subSpeciality, bean.getPrice(), journalId);
                userSubSpeciality.save();
                System.out.println("User Sub Spec saved");
            } else if(journalId == null || !journalId.equals(bean.getJournalId())) {
                userSubSpeciality.superimpose(user, subSpeciality, bean.getPrice(), journalId);
                userSubSpeciality.save();
            }
        }
    }

    @Override
    public void onFailure(Call<VendorsInCityDto> call, Throwable t) {
        System.out.println("MAY DAY!! MAY DAY!!");
    }
}
