package com.rgp.kushun.pcgamesdealstracker.models;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
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
import com.rgp.kushun.pcgamesdealstracker.R;
import com.rgp.kushun.pcgamesdealstracker.ui.slideshow.SlideshowFragment;
import com.squareup.picasso.Picasso;

import java.sql.Date;

public class AdapterDeals extends RecyclerView.Adapter<AdapterDeals.DealsViewHolder> {

    private com.rgp.kushun.pcgamesdealstracker.models.Deals[] arrayDeals;
    private NavController navController;
    private Context context;
    private int tienda;

    public AdapterDeals(com.rgp.kushun.pcgamesdealstracker.models.Deals[] arrayDeals, NavController navController, Context context, int tienda) {
        this.arrayDeals = arrayDeals;
        this.navController = navController;
        this.context = context;
        this.tienda = tienda;
    }


    @NonNull
    @Override
    public AdapterDeals.DealsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        DealsViewHolder vh;

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_games3, parent, false);
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        vh = new DealsViewHolder(v);
        return vh;
    }


    @Override
    public void onBindViewHolder(@NonNull AdapterDeals.DealsViewHolder holder, final int position) {
        Long saving;
        String img;
        String numero = arrayDeals[position].getReleaseDate().toString();
        long epoca = Long.parseLong(numero);
        Date fecha = new Date(epoca * 1000);

        if (SlideshowFragment.sale==5){


        }

        holder.tvGameName.setText(arrayDeals[position].getTitle());
        holder.tvFinalPrice.setText(arrayDeals[position].getSalePrice());
        //Conversio a data, buscar format tvRelease (integer)
        //header.jpg
        //library_600x900_2x.jpg
        //page_bg_generated_v6b.jpg
        Picasso.get().load(arrayDeals[position].getThumb().replace("capsule_sm_120.jpg", "header.jpg")).into(holder.ivBanner);
        holder.tvRelease.setText(fecha.toString());
        holder.tvOriginalPrice.setText(arrayDeals[position].getNormalPrice());
        saving = Math.round(Double.parseDouble(arrayDeals[position].getSavings()));
        holder.tvDiscount.setText(saving.toString() + "%");


        holder.ivBanner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                if (tienda == 1) {
                    intent = new Intent(Intent.ACTION_VIEW,
                            Uri.parse("https://store.steampowered.com/app/" + arrayDeals[position].getSteamAppID()));
                    context.startActivity(intent);
                } else if (tienda == 2) {
                    String busquedaBotiga2;
                    busquedaBotiga2 = arrayDeals[position].getTitle().toLowerCase();
                    busquedaBotiga2 = busquedaBotiga2.replace(" ", "-");
                    busquedaBotiga2 = busquedaBotiga2.replace(":-", "-");
                    intent = new Intent(Intent.ACTION_VIEW,
                            Uri.parse("https://es.gamersgate.com/es/product/" + busquedaBotiga2));
                    context.startActivity(intent);

                } else if (tienda == 3) {
                    String busqueda = null;
                    busqueda = arrayDeals[position].getTitle().toLowerCase();
                    busqueda = busqueda.replace(" ", "-");
                    busqueda = busqueda.replace("--", "-");
                    intent = new Intent(Intent.ACTION_VIEW,
                            Uri.parse("https://www.gamebillet.com/search?q=" + busqueda));
                    context.startActivity(intent);
                }

            }
        });

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
        public View viewItem;

        public TextView getTvFinalPrice() {
            return tvFinalPrice;
        }

        public void setTvFinalPrice(TextView tvFinalPrice) {
            this.tvFinalPrice = tvFinalPrice;
        }

        public DealsViewHolder(@NonNull View itemView) {
            super(itemView);
            tvGameName = itemView.findViewById(R.id.tvGameName);
            tvRelease = itemView.findViewById(R.id.tvRelease);
            tvOriginalPrice = itemView.findViewById(R.id.tvOriginalPrice);
            tvFinalPrice = itemView.findViewById(R.id.tvFinalPrice);
            tvDiscount = itemView.findViewById(R.id.tvDiscount);
            ivBanner = itemView.findViewById(R.id.ivBanner);
            viewItem = itemView.findViewById(R.id.viewItem3);


        }
    }
}
