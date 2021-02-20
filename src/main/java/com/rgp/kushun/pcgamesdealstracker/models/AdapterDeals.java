package com.rgp.kushun.pcgamesdealstracker.models;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.recyclerview.widget.RecyclerView;

import com.rgp.kushun.pcgamesdealstracker.R;
import com.squareup.picasso.Picasso;

import java.security.Timestamp;

public class AdapterDeals extends RecyclerView.Adapter<AdapterDeals.DealsViewHolder> {

    private Deals[] arrayDeals;
    private NavController navController;
    private Context context;

    public AdapterDeals(Deals[] arrayDeals, NavController navController,Context context) {
        this.arrayDeals = arrayDeals;
        this.navController = navController;
        this.context = context;
    }

    @NonNull
    @Override
    public AdapterDeals.DealsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        DealsViewHolder vh;

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_games,parent,false);
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        vh = new DealsViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterDeals.DealsViewHolder holder, int position) {
        Long saving;
        String img;
        Timestamp ts;
        Log.i("caca",arrayDeals[position].toString());
    holder.tvGameName.setText(arrayDeals[position].getTitle());
    holder.tvFinalPrice.setText(arrayDeals[position].getSalePrice());
    //Conversio a data, buscar format tvRelease (integer)
        //ts = (Timestamp) arrayDeals[position].getReleaseDate();
        //Timestamp ts=new Timestamp(System.currentTimeMillis());
        //Date date=new Date(ts.getTime());
       // System.out.println(date);
        //header.jpg
        //library_600x900_2x.jpg
        //page_bg_generated_v6b.jpg
        Picasso.get().load(arrayDeals[position].getThumb().replace("capsule_sm_120.jpg","header.jpg")).into(holder.ivBanner);
        holder.tvRelease.setText(""+arrayDeals[position].getReleaseDate());
    holder.tvOriginalPrice.setText(arrayDeals[position].getNormalPrice());
        saving =  Math.round(Double.parseDouble(arrayDeals[position].getSavings()));
    holder.tvDiscount.setText(saving.toString()+"%");
    }

    @Override
    public int getItemCount() {
        return arrayDeals.length;
    }

    public class DealsViewHolder extends RecyclerView.ViewHolder {
        public TextView tvGameName;
        public TextView tvRelease;
        public TextView tvOriginalPrice;
        public TextView tvFinalPrice;
        public TextView tvDiscount;
        public ImageView ivBanner;

        public DealsViewHolder(@NonNull View itemView) {
            super(itemView);
            tvGameName = itemView.findViewById(R.id.tvGameName);
            tvRelease = itemView.findViewById(R.id.tvRelease);
            tvOriginalPrice = itemView.findViewById(R.id.tvOriginalPrice);
            tvFinalPrice = itemView.findViewById(R.id.tvFinalPrice);
            tvDiscount = itemView.findViewById(R.id.tvDiscount);
            ivBanner = itemView.findViewById(R.id.ivBanner);
        }
    }
}
