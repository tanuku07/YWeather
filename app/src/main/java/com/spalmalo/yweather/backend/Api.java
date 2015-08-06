package com.spalmalo.yweather.backend;

import com.spalmalo.yweather.pojos.WeatherResponse;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

public interface Api {

    @GET("/weather")
    void getWeatherByCityName(@Query("q") String cityName,
                              Callback<WeatherResponse> callback);
}
