package com.adhess.org.supplier.portal;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.adhess.org.supplier.portal.model.AppUser;
import com.adhess.org.supplier.portal.model.Content;
import com.adhess.org.supplier.portal.model.P2p_invoice;
import com.adhess.org.supplier.portal.service.UserClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class ContactActivity extends AppCompatActivity {
    InvoiceAdapter.OnInvoiceRowListner _this;
    String BASE_URL = "http://10.0.2.2:8765";

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    UserClient userClient = retrofit.create(UserClient.class);

    List<AppUser> contacts = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);




        String token = getIntent().getStringExtra("token");

        Call<List<AppUser>> invoicesCall = userClient.findAllUser(token);

        invoicesCall.enqueue(new Callback<List<AppUser>>() {

            @Override
            public void onResponse(Call<List<AppUser>> call, Response<List<AppUser>> response) {

                RecyclerView data_rc = findViewById(R.id.data_contact);
                LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(),
                        LinearLayoutManager.VERTICAL,
                        false);

                contacts = response.body();
                Log.d("contacts : ", response.body().toString());

                ContactAdapter adapter = new ContactAdapter(getApplicationContext(), contacts);
                data_rc.setLayoutManager(layoutManager);
                data_rc.setAdapter(adapter);
                data_rc.addItemDecoration(new DividerItemDecoration(getApplicationContext(), DividerItemDecoration.VERTICAL));

            }

            @Override
            public void onFailure(Call<List<AppUser>> call, Throwable t) {
                Log.d("contacts : erreur ",t.toString());

            }
        });

    }

}
