package com.mpa.android.nefertari.model;

/**
 * Created by phamngocthanh on 7/19/17.
 */

public class FWeather {
    // KEY -----------------------------------------------------
    static String forecastJson = "forecastJson";
    static String conditionJson = "conditionJson";
    // KEY -----------------------------------------------------

    ForecastDay[] forecast;
    WeatherToday today;
}
