package com.example.koronavirusapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class newsAdapter extends RecyclerView.Adapter<newsAdapter.newsCardCatcher> {

    private List<news> newsList;
    private Context context;

    public newsAdapter(List<news> newsList, Context context) {
        this.newsList = newsList;
        this.context = context;
    }

    @NonNull
    @Override
    public newsCardCatcher onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.news_card,parent,false);
        return new newsCardCatcher(view);
    }

    @Override
    public void onBindViewHolder(@NonNull newsCardCatcher holder, int position) {
        final news news1  = newsList.get(position);
        holder.title.setText(news1.getTitle());

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,newsDetailActivity.class);
                intent.putExtra("title",news1.getTitle());
                intent.putExtra("body",news1.getBody());

                context.startActivity(intent);
            }
        });
    }

    void addData(List<news> newsList){
        this.newsList = newsList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    public class newsCardCatcher extends RecyclerView.ViewHolder {
        private TextView title;
        private CardView cardView;
        public newsCardCatcher(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.newsDetailTitle);
            cardView = itemView.findViewById(R.id.cardViewNews);
        }
    }
}
