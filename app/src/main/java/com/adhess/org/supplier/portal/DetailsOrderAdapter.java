package com.adhess.org.supplier.portal;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.adhess.org.supplier.portal.model.intermediary.EPCDET;

import java.util.List;

public class DetailsOrderAdapter extends RecyclerView.Adapter <DetailsOrderAdapter.ViewHolder> {


    Context context;
    List<EPCDET> list_mod;

    public DetailsOrderAdapter(Context context, List<EPCDET> list_mod) {
        this.context = context;
        this.list_mod = list_mod;
    }

    @Override
    public DetailsOrderAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.content_details_order_adapter, parent,false);
        return new DetailsOrderAdapter.ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(DetailsOrderAdapter.ViewHolder holder, int position) {
        EPCDET order_det = list_mod.get(position);
        holder.tv_desgnt_det_ord.setText("" + order_det.getArtlib());
        holder.tv_qt_det_ord.setText("" + order_det.getCmdqte());
        holder.tv_mnt_det_ord.setText("" + order_det.getDevbrumnt());
        holder.tv_tva_det_ord.setText("" + order_det.getDevtvamnt());
    }

    @Override
    public int getItemCount() {
        return list_mod != null ? list_mod.size(): 0;
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tv_desgnt_det_ord, tv_qt_det_ord, tv_mnt_det_ord, tv_tva_det_ord;

        public ViewHolder(View itemView) {
            super(itemView);
            tv_desgnt_det_ord = itemView.findViewById(R.id.tv_desgnt_det_ord);
            tv_qt_det_ord = itemView.findViewById(R.id.tv_qt_det_ord);
            tv_mnt_det_ord = itemView.findViewById(R.id.tv_mnt_det_ord);
            tv_tva_det_ord = itemView.findViewById(R.id.tv_tva_det_ord);
            Log.d("emmm", tv_desgnt_det_ord == null ?"null1 ":""
                    + tv_qt_det_ord == null ?"null2 ":""
                    + tv_mnt_det_ord == null ?"null3 ":""
                    + tv_tva_det_ord == null ?"null4 ":"");
        }
    }
}
