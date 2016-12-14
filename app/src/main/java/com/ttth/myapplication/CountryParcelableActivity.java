package com.ttth.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Hang on 12/14/2016.
 */

public class CountryParcelableActivity extends AppCompatActivity {
    public static final String KEY_COUNTRY = "key_country";
    private ArrayList<Country> arrCountries;
    private ArrayAdapter<Country> countryAdapter;
    private Button btnCountry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initData() {
        arrCountries = new ArrayList<>();
        arrCountries.add(new Country("Việt Nam","Hà Nội",90));
        arrCountries.add(new Country("Trung Quốc","Băc Kinh",300));
        arrCountries.add(new Country("Thaí Lan","Băng Cốc",100));
        arrCountries.add(new Country("Pháp","Paris",60));
        arrCountries.add(new Country("Mỹ","Wasington",200));

    }

    private void initView() {
        btnCountry = (Button) this.findViewById(R.id.btnCountry);
        btnCountry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random = new Random();
                int indext = random.nextInt(arrCountries.size());
                for (int i = 0; i <= arrCountries.size(); i++){
                    if (i == indext){
                        CountryWithParcelable sendData = new CountryWithParcelable(arrCountries.get(i).getName(),
                                arrCountries.get(i).getCapital(),arrCountries.get(i).getPopulation());
                        //send data
                        Intent intent = new Intent(CountryParcelableActivity.this, CountryActivity.class);
                        intent.putExtra(KEY_COUNTRY,sendData);
                        startActivity(intent);
                    }
                }
            }
        });
    }
}
