package com.adhess.org.supplier.portal;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.adhess.org.supplier.portal.model.P2p_invoice;
import com.adhess.org.supplier.portal.model.P2p_order;

import java.text.ParseException;

public class DetailsOrderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_order);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        P2p_order order = (P2p_order)getIntent().getSerializableExtra("order");

        ((TextView)findViewById(R.id.textView34)).setText(order.getRoot().getEpcnum() + "");
        ((TextView)findViewById(R.id.textView35)).setText(order.getRoot().getStatus());
        ((TextView)findViewById(R.id.textView36)).setText(order.getRoot().getDevbrumnt() + "");
        ((TextView)findViewById(R.id.textView37)).setText(order.getRoot().getDevcod());
        ((TextView)findViewById(R.id.textView38)).setText(getDate(order.getRoot().getCredat()));
        ((TextView)findViewById(R.id.textView39)).setText(getDate(order.getRoot().getDealivdat()));
        ((TextView)findViewById(R.id.textView40)).setText(order.getRoot().getEpmadrlib());



        RecyclerView data_rc = findViewById(R.id.data_details_order);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(),
                LinearLayoutManager.VERTICAL,
                false);

        DetailsOrderAdapter adapter = new DetailsOrderAdapter(getApplicationContext(), order.getRoot().getEpcdet());
        data_rc.setLayoutManager(layoutManager);
        data_rc.setAdapter(adapter);
        data_rc.addItemDecoration(new DividerItemDecoration(getApplicationContext(), DividerItemDecoration.VERTICAL));
    }

    private String getDate(String date) {
        if (date == null) return "";
//        SimpleDateFormat formatter1=new SimpleDateFormat("dd/MM/yyyy");
//        SimpleDateFormat formatter5=new SimpleDateFormat("E MMM dd HH:mm:ss zzz yyyy");
//
//        Date date5=formatter5.parse(date);
//
//        return formatter1.format(date5);

        return date.substring(8,10) + "/" + date.substring(4,7) + "/" + date.substring(date.length()-4);
    }

}
