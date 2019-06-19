package com.adhess.org.supplier.portal;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.adhess.org.supplier.portal.model.P2p_invoice;

import java.util.List;


public class InvoiceAdapter extends RecyclerView.Adapter <InvoiceAdapter.ViewHolder>{
    Context context;
    List<P2p_invoice> list_mod;
    OnInvoiceRowListner mOnInvoiceRowListner;

    public InvoiceAdapter(Context context, List<P2p_invoice> list_mod, OnInvoiceRowListner o) {
        this.context = context;
        this.list_mod = list_mod;
        this.mOnInvoiceRowListner = o;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.content_invoice,parent,false);
        return new ViewHolder(view, mOnInvoiceRowListner);


    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        P2p_invoice invoice = list_mod.get(position);
        holder.tv_ref.setText(" Réf: " + invoice.getRoot().getDocref());
        holder.tv_ech.setText(" Ech. date: " + invoice.getRoot().getEchdat().substring(0,10));
        holder.tv_mnt.setText(" Mnt: " + invoice.getRoot().getDevBruMnt());
        holder.tv_rec.setText(" Réc. date: " + invoice.getRoot().getRecdat().substring(0,10));
        int color = 0;
        switch (invoice.getRoot().getStatus()) {
            case "ONGOING":
                color = Color.rgb(16, 124, 188);
                break;
            case "ACCOUNTED":
                color = Color.rgb(54, 188, 16);
                break;
            case "REFUSED":
                color = Color.rgb(252, 35, 35);
                break;
            case "BLOCKED":
                color = Color.rgb(188, 130, 16);
                break;
        }
        holder.invoice_color.setColorFilter(color);
    }

    @Override
    public int getItemCount() {
        return list_mod != null ? list_mod.size(): 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tv_ref, tv_ech,tv_mnt,tv_rec;
        ImageView invoice_color;

        OnInvoiceRowListner onInvoiceRowListner;
        public ViewHolder(View itemView, OnInvoiceRowListner onInvoiceRowListner) {
            super(itemView);
            this.onInvoiceRowListner = onInvoiceRowListner;

            tv_ref = itemView.findViewById(R.id.tv_ref);
            tv_ech = itemView.findViewById(R.id.tv_ech);
            tv_mnt = itemView.findViewById(R.id.tv_mnt);
            tv_rec = itemView.findViewById(R.id.tv_rec);
            invoice_color = itemView.findViewById(R.id.invoice_color);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onInvoiceRowListner.onRowClick(getAdapterPosition());
        }
    }


    public interface OnInvoiceRowListner {
        void onRowClick(int position);
    }
}
