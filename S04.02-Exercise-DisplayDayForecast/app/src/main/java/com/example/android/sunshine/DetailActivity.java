package com.example.android.sunshine;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    private static final String FORECAST_SHARE_HASHTAG = " #SunshineApp";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        // COMPLETED (2) Display the weather forecast that was passed from MainActivity
        TextView mWeatherForDay = (TextView) findViewById(R.id.tv_weather_for_day);
        String mWeatherForDayBundleExtra = getIntent().getStringExtra("weatherForDay");
        mWeatherForDay.setText(mWeatherForDayBundleExtra);

    }
}