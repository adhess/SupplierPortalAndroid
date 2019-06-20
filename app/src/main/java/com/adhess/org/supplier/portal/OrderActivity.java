package com.adhess.org.supplier.portal;
//data_order
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.adhess.org.supplier.portal.model.Content;
import com.adhess.org.supplier.portal.model.P2p_invoice;
import com.adhess.org.supplier.portal.model.P2p_order;
import com.adhess.org.supplier.portal.service.UserClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class OrderActivity extends AppCompatActivity implements OrderAdapter.OnOrderRowListner {
    OrderAdapter.OnOrderRowListner _this;
    String BASE_URL = "http://10.0.2.2:8765";

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    UserClient userClient = retrofit.create(UserClient.class);

    List<P2p_order> orders = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        _this = this;
        String token = getIntent().getStringExtra("token");

        Call<Content<P2p_order>> ordersCall = userClient.getOrders(token, 1);

        ordersCall.enqueue(new Callback<Content<P2p_order>>() {

            @Override
            public void onResponse(Call<Content<P2p_order>> call, Response<Content<P2p_order>> response) {

                RecyclerView data_rc = findViewById(R.id.data_order);
                LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(),
                        LinearLayoutManager.VERTICAL,
                        false);

                orders = response.body().getContent();
                Log.d("invoice : ", response.body().toString());

                OrderAdapter adapter = new OrderAdapter(getApplicationContext(), orders, _this);
                data_rc.setLayoutManager(layoutManager);
                data_rc.setAdapter(adapter);
                data_rc.addItemDecoration(new DividerItemDecoration(getApplicationContext(), DividerItemDecoration.VERTICAL));

            }

            @Override
            public void onFailure(Call<Content<P2p_order>> call, Throwable t) {

            }
        });
    }


    @Override
    public void onRowClick(int position) {
        Intent intent = new Intent(getApplicationContext(), DetailsOrderActivity.class);
        intent.putExtra("order", this.orders.get(position));
        startActivity(intent);
    }
}
