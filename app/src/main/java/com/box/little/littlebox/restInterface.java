package com.box.little.littlebox;

import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.PUT;

public interface restInterface {

    @GET("/20x56")
    void getUser(Callback<POJO> uscb);

    @PUT("/20x56")
    void createUser(@Body POJO user, Callback<POJO> cb);
}
