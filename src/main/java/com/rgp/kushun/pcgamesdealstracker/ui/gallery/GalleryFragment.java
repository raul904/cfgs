package com.rgp.kushun.pcgamesdealstracker.ui.gallery;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.rgp.kushun.pcgamesdealstracker.R;
import com.rgp.kushun.pcgamesdealstracker.models.AdapterDeals;
import com.rgp.kushun.pcgamesdealstracker.models.Deals;
import com.rgp.kushun.pcgamesdealstracker.ui.home.HomeViewModel;

public class GalleryFragment extends Fragment {

    private GalleryViewModel galleryViewModel;

    private HomeViewModel homeViewModel;
    private Deals[] arrayDeals;
    private RequestQueue queue;
    private View root;
    private RecyclerView recyclerView;
    private AdapterDeals adapterDeals;
    NavHostFragment navHostFragment;
    NavController navController;
    private TextView finalPrice;
    String url = "https://codea.app/android/lanzar-un-link";
    String rulas = "https://codea.app/android/lanzar-un-link";


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        galleryViewModel =
                ViewModelProviders.of(this).get(GalleryViewModel.class);
        root = inflater.inflate(R.layout.fragment_gallery, container, false);
        inicialiceData();
        finalPrice = root.findViewById(R.id.tvFinalPrice);
        recyclerView = root.findViewById(R.id.rv_deals2);
        recyclerView.setOnClickListener(new View.OnClickListener(){
                                          @Override
                                          public void onClick(View v) {
                                              Toast toast1 =
                                                      Toast.makeText(getContext(),
                                                              "Toast por defecto", Toast.LENGTH_SHORT);

                                              toast1.show();
                                          }
                                      }
        );

        //finalPrice.setOnClickListener((View.OnClickListener) );



        return  root;
    }

    private void inicialiceData() {
        queue = Volley.newRequestQueue(getContext());
        String url = "https://www.cheapshark.com/api/1.0/deals?storeID=1&upperPrice=15";

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Gson gson = new Gson();
                        arrayDeals = gson.fromJson(response.toString(), Deals[].class);
                        Log.i("TAG",arrayDeals.toString());
                        inicialiceRv();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("TAG",error.toString());
            }
        });
        queue.add(stringRequest);
    }

    private void inicialiceRv() {
        recyclerView = root.findViewById(R.id.rv_deals2);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                layoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);
        //set data and list adapter
        //cryptoAdapter = new AdapterCrypto2(arrayCrypto);
        adapterDeals = new AdapterDeals(arrayDeals,navController,getContext());
        recyclerView.setAdapter(adapterDeals);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);



    }

}