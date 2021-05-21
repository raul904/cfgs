package com.rgp.kushun.pcgamesdealstracker.ui.home;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.tabs.TabLayout;
import com.google.gson.Gson;
import com.rgp.kushun.pcgamesdealstracker.R;
import com.rgp.kushun.pcgamesdealstracker.models.AdapterDeals;
import com.rgp.kushun.pcgamesdealstracker.models.Deals;
import com.tapadoo.alerter.Alerter;

public class HomeFragment extends Fragment {

    private com.rgp.kushun.pcgamesdealstracker.ui.home.HomeViewModel homeViewModel;
    private Deals[] arrayDeals;
    private RequestQueue queue;
    private View root;
    private RecyclerView recyclerView;
    private AdapterDeals adapterDeals;
    private Button button;
    private Button btSearch;
    private EditText editText;
    private TabLayout guiTabs;
    private NavController navController;


    String url;
    MediaPlayer mp;


    public View onCreateView(@NonNull final LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        mp = MediaPlayer.create(getContext(), R.raw.menu);

        mp.start();
        homeViewModel =
                ViewModelProviders.of(this).get(com.rgp.kushun.pcgamesdealstracker.ui.home.HomeViewModel.class);
        root = inflater.inflate(R.layout.fragment_home, container, false);

        url = "https://www.cheapshark.com/api/1.0/deals?storeID=2&upperPrice=5";
        inicialiceData();
        //Declarem els botons
        editText = root.findViewById(R.id.etBuscador);
        button = root.findViewById(R.id.button);
        guiTabs = root.findViewById(R.id.tabLayout3);
        btSearch = root.findViewById(R.id.button);


        btSearch.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                inicialiceDataSearch(editText.getText().toString());
//


            }

        });


        guiTabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 0:
                        url = "https://www.cheapshark.com/api/1.0/deals?storeID=2&upperPrice=5";
                        mp = MediaPlayer.create(getContext(), R.raw.tabs);
                        mp.start();
                        inicialiceData();
                        break;
                    case 1:
                        url = "https://www.cheapshark.com/api/1.0/deals?storeID=2&lowerPrice=10";
                        mp = MediaPlayer.create(getContext(), R.raw.tabs);
                        mp.start();
                        inicialiceData();
                        break;
                    case 2:
                        url = "https://www.cheapshark.com/api/1.0/deals?storeID=2&lowerPrice=20";
                        mp = MediaPlayer.create(getContext(), R.raw.tabs);
                        mp.start();
                        inicialiceData();
                        break;
                    case 3:
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        return root;
    }

    private void inicialiceDataSearch(String editText) {
        queue = Volley.newRequestQueue(getContext());
        String url = "https://www.cheapshark.com/api/1.0/deals?storeID=2&title=" + editText;

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Gson gson = new Gson();
                        arrayDeals = gson.fromJson(response, Deals[].class);
                        Log.i("TAG", arrayDeals.toString());
                        if (arrayDeals.length == 0) {
                            Alerter.create(getActivity())
                                    .setTitle(R.string.notFound)
                                    .setText(R.string.noAvailable)
                                    .setDuration(2000)
                                    .setIcon(R.drawable.notfound)
                                    .setBackgroundColorRes(R.color.colorAccent)
                                    .show();
                        }
                        inicialiceRv();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("TAG", error.toString());


            }
        });

        queue.add(stringRequest);
    }

    private void inicialiceData() {
        queue = Volley.newRequestQueue(getContext());
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Gson gson = new Gson();
                        arrayDeals = gson.fromJson(response, Deals[].class);
                        Log.i("TAG", arrayDeals.toString());
                        inicialiceRv();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("TAG", error.toString());
            }
        });
        queue.add(stringRequest);
    }

    private void inicialiceRv() {
        recyclerView = root.findViewById(R.id.rv_deals);
        GridLayoutManager layoutManager = new GridLayoutManager(getContext(), 2);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        recyclerView.setHasFixedSize(true);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                layoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);

        adapterDeals = new AdapterDeals(arrayDeals, navController, getContext(), 2);
        recyclerView.setAdapter(adapterDeals);
    }
}