package com.spalmalo.yweather.activities;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.spalmalo.yweather.R;
import com.spalmalo.yweather.http.RestClient;
import com.spalmalo.yweather.pojos.WeatherResponse;
import com.squareup.picasso.Picasso;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends Activity {
    private TextView weatherDescriptionTextView, degreeTextView;
    private ImageView iconImageView;
    private static final String cityName = "Bishkek";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        weatherDescriptionTextView = (TextView) findViewById(R.id.weatherDescriptionTextView);
        degreeTextView = (TextView) findViewById(R.id.degreeTextView);
        iconImageView = (ImageView) findViewById(R.id.weatherIconImageView);

        RestClient.get().getWeatherByCityName(cityName, new Callback<WeatherResponse>() {
            @Override
            public void success(WeatherResponse weatherResponse, Response response) {
                weatherDescriptionTextView.setText(weatherResponse.getWeather().get(0).getDescription());
                degreeTextView.setText("" + weatherResponse.getMain().getTemp());
                Picasso.with(getApplicationContext()).load("http://openweathermap.org/img/w/" + weatherResponse.getWeather().get(0).getIcon() + ".png").fit().into(iconImageView);
            }

            @Override
            public void failure(RetrofitError error) {
                Log.e("TAG", error.getResponse().getReason());
            }
        });
    }
//    http://openweathermap.org/img/w/10d.png

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        return id == R.id.action_settings || super.onOptionsItemSelected(item);

    }
}
