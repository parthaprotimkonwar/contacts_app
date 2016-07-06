package com.contacts.rest.service;

import com.contacts.rest.dto.FactoryResetDto;
import com.contacts.rest.dto.VendorsInCityDto;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Url;

/**
 * Created by pkonwar on 4/30/2016.
 */
public interface CoreServices {

    @GET(value = "factory/reset")
    public Call<FactoryResetDto> factoryResetData();

    @GET(value = "vendors/city/{cityId}")
    public Call<VendorsInCityDto> vendorsInCity(@Path("cityId") Long cityId);

    /**
     * Download image assets
     * @param url
     * @return
     */
    @GET
    public Call<ResponseBody> downloadImage(@Url String url);

}
