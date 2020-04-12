package com.example.koronavirusapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class listAdapter extends RecyclerView.Adapter<listAdapter.cardViewCatcher> {

    private Context context;
    private List<stats> statsList;

    public listAdapter(Context context, List<stats> statsList) {
        this.context = context;
        this.statsList = statsList;
    }

    @NonNull
    @Override
    public cardViewCatcher onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.card_view2,parent,false);
        return new cardViewCatcher(view);
    }

    @Override
    public void onBindViewHolder(@NonNull cardViewCatcher holder, int position) {
        stats stat = statsList.get(position);



        holder.country.setText(stat.country);
        holder.new_cases.setText(stat.new_cases);
        holder.new_deaths.setText(stat.new_deaths);
        holder.total_cases.setText(stat.total_cases);
        holder.total_deaths.setText(stat.total_deaths);
        holder.total_recovered.setText(stat.total_recovered);

        if (holder.new_deaths.getText().toString().equals("")) {
            holder.new_deaths.setText("-");
        }
        if (holder.new_cases.getText().toString().equals("")) {
            holder.new_cases.setText("-");
        }
        if (holder.total_deaths.getText().toString().equals("")) {
            holder.total_deaths.setText("-");
        }
        if (holder.total_recovered.getText().toString().equals("")) {
            holder.total_recovered.setText("-");
        }


    }

    //Bu metod eyer pagination istifade etmiyeceksen se isine yarayacaq
    void addData(List<stats> statsList){
        this.statsList = statsList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return statsList.size();
    }

    public class cardViewCatcher extends RecyclerView.ViewHolder {
        private TextView country,new_cases,new_deaths,total_cases,total_deaths,total_recovered;
        public cardViewCatcher(@NonNull View itemView) {
            super(itemView);

            country = itemView.findViewById(R.id.country);
            new_cases = itemView.findViewById(R.id.new_cases);
            new_deaths = itemView.findViewById(R.id.new_deaths);
            total_deaths = itemView.findViewById(R.id.total_deaths);
            total_recovered = itemView.findViewById(R.id.total_recovered);
            total_cases = itemView.findViewById(R.id.total_cases);


        }
    }
}