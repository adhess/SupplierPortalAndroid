package com.adhess.org.supplier.portal;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.adhess.org.supplier.portal.model.Login;
import com.adhess.org.supplier.portal.model.P2p_order;
import com.adhess.org.supplier.portal.model.intermediary.EPCTET;

import java.util.List;



public class OrderAdapter extends RecyclerView.Adapter <OrderAdapter.ViewHolder>{

    Context context;
    List<P2p_order> list_mod;
    OnOrderRowListner mOnOrderRowListner;

    public OrderAdapter(Context context, List<P2p_order> list_mod, OnOrderRowListner o) {
        this.context = context;
        this.list_mod = list_mod;
        this.mOnOrderRowListner = o;
    }

    @Override
    public OrderAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.content_order,parent,false);
        return new OrderAdapter.ViewHolder(view, mOnOrderRowListner);
    }


    @Override
    public void onBindViewHolder(OrderAdapter.ViewHolder holder, int position) {
        EPCTET order = list_mod.get(position).getRoot();
        Log.d("order",order.toString());
        holder.tv_order_num.setText(" Numéro: " + order.getEpcnum());
        holder.tv_order_recdat.setText("Date de création: " + getDate(order.getCredat()));
        int color = 0;
        switch (order.getStatus()) {
            case "0":
                color = Color.rgb(32, 159, 188);
                break;
            case "1":
                color = Color.rgb(117, 188, 32);
                break;
        }
        holder.order_color.setColorFilter(color);
    }

    private String getDate(String date) {
        if (date == null) return "";
        return date.substring(0,10);
    }

    @Override
    public int getItemCount() {
        return list_mod != null ? list_mod.size(): 0;
    }
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView tv_order_num, tv_order_recdat, tv_order_livdat,tv_rec;
        ImageView order_color;

        OrderAdapter.OnOrderRowListner onOrderRowListner;
        public ViewHolder(View itemView, OrderAdapter.OnOrderRowListner onOrderRowListner) {
            super(itemView);
            this.onOrderRowListner = onOrderRowListner;

            tv_order_num = itemView.findViewById(R.id.tv_order_num);
            tv_order_recdat = itemView.findViewById(R.id.tv_order_recdat);
            order_color = itemView.findViewById(R.id.order_color);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onOrderRowListner.onRowClick(getAdapterPosition());
        }
    }


    public interface OnOrderRowListner {
        void onRowClick(int position);
    }
}
