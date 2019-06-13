package com.adhess.org.supplier.portal.service;

import com.adhess.org.supplier.portal.model.Login;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface UserClient {
    @POST("/API/auth/login2")
    Call<String> login(@Body Login login);

    @POST
    Call<Login> getData(@Header("authorization") String token);
}
