package com.adhess.org.supplier.portal.service;

import com.adhess.org.supplier.portal.model.Content;
import com.adhess.org.supplier.portal.model.InfoChart;
import com.adhess.org.supplier.portal.model.Login;
import com.adhess.org.supplier.portal.model.P2p_invoice;
import com.adhess.org.supplier.portal.model.P2p_order;
import com.adhess.org.supplier.portal.model.AppUser;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface UserClient {
    @POST("/API/auth/login2")
    Call<String> login(@Body Login login);

    @POST("/API/auth/auth/getUserInfo")
    Call<AppUser> getUserInfo(@Header("authorization") String token);

    @GET("/API/p2p/auth/getInfoStatusCharts")
    Call<InfoChart>  getInfoCharts(@Header("authorization") String token);

    @GET("/API/p2p/auth/invoice/{page}/100")
    Call<Content<P2p_invoice>> getInvoices(@Header("authorization") String token, @Path("page") int page);

    @GET("/API/p2p/auth/order/{page}/100")
    Call<Content<P2p_order>> getOrders(@Header("authorization") String token, @Path("page") int page);

    @GET("/API/auth/admin/find_all_user")
    Call<List<AppUser>> findAllUser(@Header("authorization") String token);
}
