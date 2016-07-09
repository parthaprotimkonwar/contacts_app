package com.contacts.ui.listeners.contacts;

import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.contacts.db.models.places.City;
import com.contacts.ui.cache.DataBundle;

import java.util.List;

/**
 * Created by pkonwar on 7/9/2016.
 */
public class CityListSpinnerListener implements AdapterView.OnItemSelectedListener{

    private final List<City> cityList;

    public CityListSpinnerListener(List<City> cityList) {
        this.cityList = cityList;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        City city = cityList.get(position);
        DataBundle.getInstance().setCityId(city.getCityId());
        System.out.println("Partha : Selected city :" + city.getName());
        //TODO : load the Categories available in the city

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
