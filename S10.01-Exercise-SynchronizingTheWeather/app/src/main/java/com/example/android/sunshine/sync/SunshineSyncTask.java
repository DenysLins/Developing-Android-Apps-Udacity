package com.example.android.sunshine.sync;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;

import com.example.android.sunshine.data.WeatherContract;
import com.example.android.sunshine.utilities.NetworkUtils;
import com.example.android.sunshine.utilities.OpenWeatherJsonUtils;

import java.net.URL;

//  Completed (1) Create a class called SunshineSyncTask
public class SunshineSyncTask {

    //  Completed (2) Within SunshineSyncTask, create a synchronized public static void method called syncWeather
    synchronized public static void syncWeather(Context context) {

        try {
            //      Completed (3) Within syncWeather, fetch new weather data
            URL weatherRequestUrl = NetworkUtils.getUrl(context);

            String jsonWeatherResponse = NetworkUtils
                    .getResponseFromHttpUrl(weatherRequestUrl);

            ContentValues[] contentValues = OpenWeatherJsonUtils
                    .getWeatherContentValuesFromJson(context, jsonWeatherResponse);

            //      Completed (4) If we have valid results, delete the old data and insert the new
            if (contentValues != null && contentValues.length != 0) {

                ContentResolver resolver = context.getContentResolver();
                resolver.delete(WeatherContract.WeatherEntry.CONTENT_URI, null, null);
                resolver.bulkInsert(WeatherContract.WeatherEntry.CONTENT_URI, contentValues);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}