package com.example.koronavirusapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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

public class NewsFragment extends Fragment {
    private RecyclerView recyclerViewNews;
    private ApiInterface apiInterface;
    private newsAdapter adapter;
    private List<news> newsList;
    private ShimmerLayout shimmerLayout3;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news, container, false);
        recyclerViewNews = view.findViewById(R.id.recyclerViewNews);
        shimmerLayout3 = view.findViewById(R.id.shimmerlayout3);

        recyclerViewNews.setHasFixedSize(true);
        recyclerViewNews.setLayoutManager(new LinearLayoutManager(getActivity()));

        adapter = new newsAdapter(new ArrayList<news>(),getActivity());
        recyclerViewNews.setAdapter(adapter);

        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);

        Call<List<news>> call = apiInterface.getNews();

        call.enqueue(new Callback<List<news>>() {
            @Override
            public void onResponse(Call<List<news>> call, Response<List<news>> response) {
                if (response.isSuccessful() && response.body() != null){
                        newsList = response.body();
                        adapter.addData(response.body());
                        shimmerLayout3.setVisibility(View.GONE);
                }
            }

            @Override
            public void onFailure(Call<List<news>> call, Throwable t) {

            }
        });



        return view;
    }


}
