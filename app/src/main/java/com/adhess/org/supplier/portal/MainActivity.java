package com.adhess.org.supplier.portal;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.TextView;
import android.widget.Toast;

import com.adhess.org.supplier.portal.model.InfoChart;
import com.adhess.org.supplier.portal.model.AppUser;
import com.adhess.org.supplier.portal.model.invoice;
import com.adhess.org.supplier.portal.model.order;
import com.adhess.org.supplier.portal.service.UserClient;

import java.util.ArrayList;
import java.util.List;

import lecho.lib.hellocharts.model.PieChartData;
import lecho.lib.hellocharts.model.SliceValue;
import lecho.lib.hellocharts.view.PieChartView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private static AppUser userInfo;

    String BASE_URL = "http://10.0.2.2:8765";

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    UserClient userClient = retrofit.create(UserClient.class);
    private static String token;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);


        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        String token = getIntent().getStringExtra("token");
        Toast.makeText(getApplicationContext(), token, Toast.LENGTH_LONG).show();
        MainActivity.token = token;
        initializer();


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    Menu menu;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        this.menu = menu;
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_invoices) {
            Intent intent = new Intent(getApplicationContext(), InvoiceActivity.class);
            intent.putExtra("token", MainActivity.token);
            startActivity(intent);



        } else if (id == R.id.nav_orders) {
            Intent intent = new Intent(getApplicationContext(), OrderActivity.class);
            intent.putExtra("token", MainActivity.token);
            startActivity(intent);
        } else if (id == R.id.nav_contacts) {
            Intent intent = new Intent(getApplicationContext(), ContactActivity.class);
            intent.putExtra("token", MainActivity.token);
            startActivity(intent);
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void initializer() {
        Call<AppUser> userInfoCall = userClient.getUserInfo(token);

        userInfoCall.enqueue(new Callback<AppUser>() {
            @Override
            public void onResponse(Call<AppUser> call, Response<AppUser> response) {
                MainActivity.userInfo = response.body();

                if (response.body() != null) {
                    ((TextView) findViewById(R.id.email_nav_bar)).setText(response.body().getEmail());
                    ((TextView) findViewById(R.id.name_nav_bar)).setText(response.body().getName());
                }
            }

            @Override
            public void onFailure(Call<AppUser> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "error Token", Toast.LENGTH_LONG).show();
            }
        });

        Call<InfoChart> infoChartsCall = userClient.getInfoCharts(token);
        infoChartsCall.enqueue(new Callback<InfoChart>() {
            @Override
            public void onResponse(Call<InfoChart> call, Response<InfoChart> response) {
                if (response.body() != null) {
                    Toast.makeText(getApplicationContext(), response.body().toString(), Toast.LENGTH_LONG).show();
                    invoice invoice = response.body().getInvoice();

                    PieChartView pieChartView = findViewById(R.id.chartInvoice);
                    List<SliceValue> pieData = new ArrayList<>();


                    int color1 = Color.rgb(16, 124, 188);
                    int color2 = Color.rgb(54, 188, 16);
                    int color3 = Color.rgb(252, 35, 35);
                    int color4 = Color.rgb(188, 130, 16);


                    pieData.add(new SliceValue(invoice.getONGOING(), color1));
                    pieData.add(new SliceValue(invoice.getACCOUNTED(), color2));
                    pieData.add(new SliceValue(invoice.getREFUSED(), color3));
                    pieData.add(new SliceValue(invoice.getBLOCKED(), color4));


                    TextView textView = (TextView) findViewById(R.id.textView);
                    textView.setText("En Cours: " + invoice.getONGOING());
                    textView.setBackgroundColor(color1);

                    TextView textView2 = (TextView) findViewById(R.id.textView2);
                    textView2.setText("Comptabilisée: " + invoice.getACCOUNTED());
                    textView2.setBackgroundColor(color2);

                    TextView textView3 = (TextView) findViewById(R.id.textView3);
                    textView3.setText("Refusée: " + invoice.getREFUSED());
                    textView3.setBackgroundColor(color3);

                    TextView textView4 = (TextView) findViewById(R.id.textView4);
                    textView4.setText("Bloquée: " + invoice.getBLOCKED());
                    textView4.setBackgroundColor(color4);


                    PieChartData pieChartData = new PieChartData(pieData);
                    pieChartView.setPieChartData(pieChartData);


                    order order = response.body().getOrder();

                    PieChartView pieChartView2 = findViewById(R.id.chartOder);
                    List<SliceValue> pieData2 = new ArrayList<>();


                    int color5 = Color.rgb(32, 159, 188);
                    int color6 = Color.rgb(117, 188, 32);


                    pieData2.add(new SliceValue(order.getTRANSMITTED(), color5));
                    pieData2.add(new SliceValue(order.getCLOSED(), color6));


                    TextView textView5 = (TextView) findViewById(R.id.textView5);
                    textView5.setText("Transmise: " + order.getTRANSMITTED());
                    textView5.setBackgroundColor(color5);

                    TextView textView6 = (TextView) findViewById(R.id.textView6);
                    textView6.setText("Cloturé: " + order.getCLOSED());
                    textView6.setBackgroundColor(color6);


                    PieChartData pieChartData2 = new PieChartData(pieData2);
                    pieChartView2.setPieChartData(pieChartData2);





                }
            }

            @Override
            public void onFailure(Call<InfoChart> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "error Token", Toast.LENGTH_LONG).show();
            }
        });
    }

}
