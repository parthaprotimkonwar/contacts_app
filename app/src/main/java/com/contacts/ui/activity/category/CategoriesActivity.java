package com.contacts.ui.activity.category;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.contacts.contacts.R;
import com.contacts.db.models.places.City;
import com.contacts.rest.RestClient;
import com.contacts.rest.dto.FactoryResetDto;
import com.contacts.rest.dto.VendorsInCityDto;
import com.contacts.rest.service.callbacks.FactoryResetCallback;
import com.contacts.rest.service.callbacks.VendorsInCityCallback;
import com.contacts.services.places.CityService;
import com.contacts.ui.listeners.contacts.CityListSpinnerListener;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;

public class CategoriesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //removing the action bar
        /*requestWindowFeature(Window.FEATURE_ACTION_BAR_OVERLAY);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);*/

        setContentView(R.layout.activity_categories);
        Toolbar toolbar = (Toolbar) findViewById(R.id.categoriesToolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setElevation(4.0F);

        Typeface pacificoFont = Typeface.createFromAsset(getAssets(),"fonts/Pacifico.ttf");

        TextView titleText = (TextView) toolbar.getChildAt(0);
        titleText.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.logo_font_size));
        titleText.setTypeface(pacificoFont);

        //Call for factory reset
        RestClient client = new RestClient();
        Call<FactoryResetDto> factoryResetDtoCall = client.getCoreServices().factoryResetData();
        factoryResetDtoCall.enqueue(new FactoryResetCallback());


        Call<VendorsInCityDto> vendorsInCityDtoCall = client.getCoreServices().vendorsInCity(2l);
        vendorsInCityDtoCall.enqueue(new VendorsInCityCallback());


        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_categories, menu);

        MenuItem item = menu.findItem(R.id.categoriesMenuLocationNameSpinner);
        Spinner spinner = (Spinner) MenuItemCompat.getActionView(item);

        List<City> cityList = CityService.cities();
        List<String> cityNames = getCityNames(cityList);
        /*locations.add("bangalore12");
        locations.add("pune");
        locations.add("hydrabad");
*/
        //ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, locations);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.spinner_item, cityNames);
        //adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //adapter.setDropDownViewResource(R.layout.adapter_spinner_dropdown);
        spinner.setAdapter(adapter); // set the adapter to provide layout of rows and content
        spinner.setOnItemSelectedListener(new CityListSpinnerListener(cityList));
        return true;
    }

    /**
     * Get City Names
     * @param cityList
     * @return
     */
    List<String> getCityNames(List<City> cityList) {
        List<String> cityName = new ArrayList<>();
        for(City city : cityList) {
            cityName.add(city.getName());
        }
        return cityName;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        /*if (id == R.id.action_settings) {
            return true;
        }*/

        return super.onOptionsItemSelected(item);
    }

    /*@Override
    protected void onResume() {
        super.onResume();

        //Remove the Navigation Bar
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
    }*/
}
