package com.contacts.rest.service.callbacks;

import android.util.Log;

import com.contacts.db.models.bean.places.CityBean;
import com.contacts.db.models.bean.specialities.SpecialityBean;
import com.contacts.db.models.bean.specialities.SubSpecialityBean;
import com.contacts.db.models.places.City;
import com.contacts.db.models.specialities.Speciality;
import com.contacts.db.models.specialities.SubSpeciality;
import com.contacts.rest.dto.FactoryResetDto;
import com.contacts.services.places.CityService;
import com.contacts.services.specialities.SpecialityService;
import com.contacts.services.specialities.SubSpecialityService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by pkonwar on 7/7/2016.
 */
public class FactoryResetCallback implements Callback<FactoryResetDto> {

    @Override
    public void onResponse(Call<FactoryResetDto> call, Response<FactoryResetDto> response) {

        Log.d("CONTACTS", "RESULTS FOUND! Core Factory");
        FactoryResetDto factoryResetDto = response.body();

        List<CityBean> cityBeanList = factoryResetDto.getCityBeanList() == null ? new ArrayList<CityBean>() : factoryResetDto.getCityBeanList();
        //Storing City in Database
        for(CityBean bean : cityBeanList) {
            Long cityId = bean.getCityId();
            Integer journalId = bean.getJournalId();

            City city = CityService.findACity(cityId);
            if(city == null) {
                city = new City(bean.getCityId(), bean.getName(), bean.getLatitude(), bean.getLongitude(), bean.getStatus(), bean.getJournalId());
                //city.save();
                System.out.println("CITY : " + city.getName() + " saved.");
            } else if(journalId == null || !journalId.equals(city.getJournalId())) {
                city.superimpose(bean.getCityId(), bean.getName(), bean.getLatitude(), bean.getLongitude(), bean.getStatus(), bean.getJournalId());
                //city.save();
            }
        }

        //Save Speciality in Database
        List<SpecialityBean> specialityBeanList = factoryResetDto.getSpecialityBeanList() == null ? new ArrayList<SpecialityBean>() : factoryResetDto.getSpecialityBeanList();
        for(SpecialityBean bean : specialityBeanList) {
            Long specialityId = bean.getSpecialityId();
            Integer journalId = bean.getJournalId();

            Speciality speciality = SpecialityService.findASpeciality(specialityId);
            if(speciality == null) {
                speciality = new Speciality(bean.getSpecialityId(), bean.getSpeciality(), bean.getStatus(), bean.getImageBlob(), bean.getJournalId());
                //speciality.save();
                System.out.println("SPECIALITY : " + speciality.getSpeciality() + " saved.");
            } else if(journalId == null || !journalId.equals(speciality.getJournalId())) {
                speciality.superimpose(bean.getSpecialityId(), bean.getSpeciality(), bean.getStatus(), bean.getImageBlob(), bean.getJournalId());
                //speciality.save();
            }
        }

        //Save SubSpeciality in Database
        List<SubSpecialityBean> subSpecialityBeanList = factoryResetDto.getSubSpecialityBeanList() == null ? new ArrayList<SubSpecialityBean>() : factoryResetDto.getSubSpecialityBeanList();
        for(SubSpecialityBean bean : subSpecialityBeanList) {
            Long subSpecialityId = bean.getSubSpecialityId();
            Integer journalId = bean.getJournalId();

            SubSpeciality subSpeciality = SubSpecialityService.findASubSpeciality(subSpecialityId);
            if(subSpeciality == null) {
                Speciality speciality = SpecialityService.findASpeciality(bean.getSpecialityId());
                subSpeciality = new SubSpeciality(bean.getSubSpecialityId(), bean.getSubSpeciality(), bean.getStatus(), bean.getImageBlob(), speciality, bean.getJournalId());
                //subSpeciality.save();
                System.out.println("SUB-SPECIALITY : " + subSpeciality.getSubSpeciality() + " saved.");
            } else if(journalId != null || !journalId.equals(subSpeciality.getJournalId())) {
                Speciality speciality = SpecialityService.findASpeciality(bean.getSpecialityId());
                subSpeciality.superimpose(bean.getSubSpecialityId(), bean.getSubSpeciality(), bean.getStatus(), bean.getImageBlob(), speciality, bean.getJournalId());
                //subSpeciality.save();
            }
        }
    }

    @Override
    public void onFailure(Call<FactoryResetDto> call, Throwable t) {
        Log.d("CONTACTS", "MAY DAY! Core Factory" + t.getMessage() + t.fillInStackTrace());
    }
}
