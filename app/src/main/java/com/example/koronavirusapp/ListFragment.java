package com.example.koronavirusapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import io.supercharge.shimmerlayout.ShimmerLayout;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListFragment extends Fragment {

    private RecyclerView recyclerView;
    private ApiInterface apiInterface;
    private ApiInterface apiInterfaceAz;
    private ShimmerLayout shimmerLayout,shimmerLayout2;
    private List<stats> statsList;
    private List<azstats> azstatsList;

    private listAdapter adapter;
    private TextView country,infected,recovered,deceased,tested;
    ProgressBar progressBar;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_list, container, false);


        country = view.findViewById(R.id.country);
        infected = view.findViewById(R.id.infected);
        recovered = view.findViewById(R.id.recovered);
        deceased = view.findViewById(R.id.deceased);
        tested = view.findViewById(R.id.tested);
        recyclerView = view.findViewById(R.id.rv);
        shimmerLayout = view.findViewById(R.id.shimmerlayout);
        shimmerLayout2 = view.findViewById(R.id.shimmerlayout2);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);
        shimmerLayout.startShimmerAnimation();

        //Adapteri evvelceden qurub gozledin, data gelende elave edersiz
        adapter = new listAdapter(getActivity(), new ArrayList<stats>());
        recyclerView.setAdapter(adapter);


        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        apiInterfaceAz = ApiClient.getAzStat().create(ApiInterface.class);

        Call<List<stats>> call = apiInterface.getStats();
        Call<azstats> azStatCall = apiInterfaceAz.getAzstats();

        call.enqueue(new Callback<List<stats>>() {
            @Override
            public void onResponse(Call<List<stats>> call, Response<List<stats>> response) {

                //Response'i hemise yoxla, null ola biler
                if (response.isSuccessful() && response.body() != null) {
                    statsList = response.body();
                    adapter.addData(response.body());
                    shimmerLayout2.setVisibility(View.GONE);

                }

            }

            @Override
            public void onFailure(Call<List<stats>> call, Throwable t) {

            }
        });

        azStatCall.enqueue(new Callback<azstats>() {
            @Override
            public void onResponse(Call<azstats> call, Response<azstats> response) {

                shimmerLayout.stopShimmerAnimation();
                shimmerLayout.setVisibility(View.GONE);

                country.setText(response.body().getCountry());
                infected.setText("Xəstələr: " + Integer.toString(response.body().getInfected()));
                recovered.setText("Sağalanlar: " + Integer.toString(response.body().getRecovered()));
                deceased.setText("Ölənlər: " + Integer.toString(response.body().getDeceased()));
                tested.setText("Yoxlanılanlar: " + Integer.toString(response.body().getTested()));





            }

            @Override
            public void onFailure(Call<azstats> call, Throwable t) {

            }
        });

        return view;
    }
}
