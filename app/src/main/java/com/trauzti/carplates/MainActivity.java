package com.trauzti.carplates;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.internal.bind.DateTypeAdapter;

import java.util.Date;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;
import retrofit.converter.GsonConverter;


public class MainActivity extends Activity {
    public final String TAG = MainActivity.class.getName();

    private CarService carService;
    private EditText etInputNumber;
    private TextView tvTextContainer;
    private RestAdapter restAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .registerTypeAdapter(Date.class, new DateTypeAdapter())
                .create();


        RestAdapter.LogLevel logLevel = RestAdapter.LogLevel.NONE;

        if (BuildConfig.DEBUG) {
            logLevel = RestAdapter.LogLevel.FULL;
        }

        restAdapter = new RestAdapter.Builder()
//                .setEndpoint("https://api.github.com")
                .setEndpoint("http://apis.is")
                .setConverter(new GsonConverter(gson))
                .setLogLevel(logLevel)
                .build();




        tvTextContainer = (TextView) findViewById(R.id.textContainer);
        etInputNumber = (EditText) findViewById(R.id.inputNumber);




        carService = restAdapter.create(CarService.class);



    }


    public void lookUpNumber(View view) {
        carService.lookUpNumber(getNumber(), new Callback<CarResponse>() {
            @Override
            public void success(CarResponse carResponse, Response response) {

                if (carResponse == null || carResponse.results == null || carResponse.results.size() == 0) {
                    tvTextContainer.setText("Ekkert fannst");
                }

                for (RegistrationInfo registrationInfo : carResponse.results) {
                    tvTextContainer.setText(registrationInfo.toString());
                }

            }

            @Override
            public void failure(RetrofitError error) {
                tvTextContainer.setText("Villa kom upp");

            }
        });

    }

    public String getNumber() {
        return etInputNumber.getText().toString();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
