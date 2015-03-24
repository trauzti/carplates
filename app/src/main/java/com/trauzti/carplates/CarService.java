package com.trauzti.carplates;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

public interface CarService {

    @GET("/car")
    void lookUpNumber(@Query("number") String number, Callback<CarResponse> cb);

}
