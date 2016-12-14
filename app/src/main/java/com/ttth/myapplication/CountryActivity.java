package com.ttth.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

/**
 * Created by Hang on 12/14/2016.
 */

public class CountryActivity extends Activity {
    private static final String TAG = "Coutry Activity";
    private TextView tvItemCountry;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_country);
        initView();
    }

    private void initView() {
        // recceive data
        Intent intent = getIntent();
//        Country seriCountry = (Country) intent.getSerializableExtra(MainActivity.KEY_COUNTRY);
        CountryWithParcelable seriCountry = intent.getParcelableExtra(CountryParcelableActivity.KEY_COUNTRY);
        Log.e(TAG,""+seriCountry);
        tvItemCountry = (TextView) this.findViewById(R.id.tvItemcountry);
        tvItemCountry.setText("Country: "+seriCountry.getName()+"\n"
                +"Thủ đô: "+seriCountry.getCapital()+"\n"+
                "Dân số: "+seriCountry.getPopulation());
    }
}
