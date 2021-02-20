package com.rgp.kushun.pcgamesdealstracker.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
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

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private Deals[] arrayDeals;
    private RequestQueue queue;
    private View root;
    private RecyclerView recyclerView;
    private AdapterDeals adapterDeals;
    NavHostFragment navHostFragment;
    NavController navController;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        root = inflater.inflate(R.layout.fragment_home, container, false);
        navHostFragment = (NavHostFragment) getActivity().getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
        navController = navHostFragment.getNavController();

        inicialiceData();
        return root;
    }

    private void inicialiceData() {
        queue = Volley.newRequestQueue(getContext());
        String url = "https://www.cheapshark.com/api/1.0/deals?storeID=2&upperPrice=15";

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
        recyclerView = root.findViewById(R.id.rv_deals);
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
}