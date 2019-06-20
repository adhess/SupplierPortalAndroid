package com.adhess.org.supplier.portal;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.adhess.org.supplier.portal.model.AppUser;

import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter <ContactAdapter.ViewHolder>{

    Context context;
    List<AppUser> list_mod;


    public ContactAdapter(Context context, List<AppUser> list_mod) {
        this.context = context;
        this.list_mod = list_mod;
    }


    @Override
    public ContactAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.content_contact,parent,false);
        return new ContactAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ContactAdapter.ViewHolder holder, int position) {
        AppUser user = list_mod.get(position);
        holder.tv_contact_username.setText(" " + user.getUsername());
        holder.tv_contact_email.setText(" Email: " + user.getEmail());
        holder.tv_contact_name.setText(" " + user.getName());
        holder.tv_contact_tel.setText(" Tél: " + user.getTelephone());
        int color = 0;
        switch (user.getRole()) {
            case "ADMIN":
                color = Color.rgb(255, 147, 0);
                break;
            case "SUPPLIER":
                color = Color.rgb(0, 255, 161);
                break;
            case "CONTACT":
                color = Color.rgb(0, 198, 255);
                break;

        }
        holder.contact_color.setColorFilter(color);
    }

    @Override
    public int getItemCount() {
        return list_mod != null ? list_mod.size(): 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tv_contact_username, tv_contact_email, tv_contact_name, tv_contact_tel;
        ImageView contact_color;

        public ViewHolder(View itemView) {
            super(itemView);

            tv_contact_username = itemView.findViewById(R.id.tv_contact_username);
            tv_contact_email = itemView.findViewById(R.id.tv_contact_email);
            tv_contact_name = itemView.findViewById(R.id.tv_contact_name);
            tv_contact_tel = itemView.findViewById(R.id.tv_contact_tel);
            contact_color = itemView.findViewById(R.id.contact_color);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
        }
    }

}
