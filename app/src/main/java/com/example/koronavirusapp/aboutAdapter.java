package com.example.koronavirusapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class aboutAdapter extends RecyclerView.Adapter<aboutAdapter.aboutCardCatcher> {

    private List<about> aboutList;
    private Context context;

    public aboutAdapter(List<about> aboutList, Context context) {
        this.aboutList = aboutList;
        this.context = context;
    }

    @NonNull
    @Override
    public aboutCardCatcher onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.about_card,parent,false);
        return new aboutCardCatcher(view);
    }

    @Override
    public void onBindViewHolder(@NonNull aboutCardCatcher holder, int position) {
        about about1 = aboutList.get(position);
        holder.aboutTitle.setText(about1.getAboutTitle());
        holder.aboutBody.setText(about1.getAboutBody());
        boolean isExpanded = aboutList.get(position).isExpanded();
        holder.expandableLayout.setVisibility(isExpanded ? View.VISIBLE : View.GONE);


    }

    @Override
    public int getItemCount() {
        return aboutList.size();
    }

    public class aboutCardCatcher extends RecyclerView.ViewHolder {
        private TextView aboutTitle,aboutBody;
        private ConstraintLayout expandableLayout;

        public aboutCardCatcher(@NonNull View itemView) {
            super(itemView);
            aboutTitle = itemView.findViewById(R.id.aboutTitle);
            aboutBody = itemView.findViewById(R.id.aboutBody);
            expandableLayout = itemView.findViewById(R.id.expandableLayout);

            aboutTitle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    about about = aboutList.get(getAdapterPosition());
                    about.setExpanded(!about.isExpanded());
                    notifyItemChanged(getAdapterPosition());
                }
            });
        }
    }
}
