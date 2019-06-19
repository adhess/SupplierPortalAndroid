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
import android.widget.Toast;

import com.adhess.org.supplier.portal.model.P2p_invoice;

import java.io.Serializable;
import java.util.Arrays;

public class DetailsInvoiceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_invoice);


        P2p_invoice invoice = (P2p_invoice)getIntent().getSerializableExtra("invoice");

        ((TextView)findViewById(R.id.textView14)).setText(invoice.getRoot().getDocref());
        ((TextView)findViewById(R.id.textView15)).setText(invoice.getRoot().getStatus());
        ((TextView)findViewById(R.id.textView16)).setText(invoice.getRoot().getDevcod());
        ((TextView)findViewById(R.id.textView17)).setText(invoice.getRoot().getDevnetmnt() + "");
        ((TextView)findViewById(R.id.textView18)).setText(invoice.getRoot().getDevBruMnt() + "");
        ((TextView)findViewById(R.id.textView19)).setText(invoice.getRoot().getEchdat().substring(0,10));
        ((TextView)findViewById(R.id.textView20)).setText(invoice.getRoot().getRecdat().substring(0,10));


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        RecyclerView data_rc = findViewById(R.id.data_details_invoice);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(),
                LinearLayoutManager.VERTICAL,
                false);

        DetailsInvoiceAdapter adapter = new DetailsInvoiceAdapter(getApplicationContext(), invoice.getRoot().getEpfdet());
        data_rc.setLayoutManager(layoutManager);
        data_rc.setAdapter(adapter);
        data_rc.addItemDecoration(new DividerItemDecoration(getApplicationContext(), DividerItemDecoration.VERTICAL));


    }

}
