package com.adhess.org.supplier.portal;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.adhess.org.supplier.portal.model.intermediary.EPFDET;

import java.util.List;

public class DetailsInvoiceAdapter extends RecyclerView.Adapter <DetailsInvoiceAdapter.ViewHolder>{
    Context context;
    List<EPFDET> list_mod;

    public DetailsInvoiceAdapter(Context context, List<EPFDET> list_mod) {

        this.context = context;
        this.list_mod = list_mod;
    }

    @Override
    public DetailsInvoiceAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.content_invoice_details, parent,false);
        return new DetailsInvoiceAdapter.ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(DetailsInvoiceAdapter.ViewHolder holder, int position) {
        EPFDET invoice = list_mod.get(position);
        holder.tv_lib_det_inv.setText("" + invoice.getMvtlib());
        holder.tv_qt_det_inv.setText("" + invoice.getFacqte());
        holder.tv_mnt_det_inv.setText("" + invoice.getDevbruliq());
        holder.tv_up_det_inv.setText("" + invoice.getUniprx());
    }

    @Override
    public int getItemCount() {
        return list_mod != null ? list_mod.size(): 0;
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tv_lib_det_inv, tv_qt_det_inv, tv_mnt_det_inv, tv_up_det_inv;

        public ViewHolder(View itemView) {
            super(itemView);
            tv_lib_det_inv = itemView.findViewById(R.id.tv_lib_det_inv);
            tv_qt_det_inv = itemView.findViewById(R.id.tv_qt_det_inv);
            tv_mnt_det_inv = itemView.findViewById(R.id.tv_mnt_det_inv);
            tv_up_det_inv = itemView.findViewById(R.id.tv_up_det_inv);
        }
    }
}
