package com.example.koronavirusapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class newsDetailActivity extends AppCompatActivity {
    private TextView newsDetailTitle,newsDetailBody;
    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail);

        newsDetailBody = findViewById(R.id.newsDetailBody);
        newsDetailTitle = findViewById(R.id.newsDetailTitle);
        toolbar = findViewById(R.id.toolbar2);
        toolbar.setTitle("Təfərrüatlar");
        setSupportActionBar(toolbar);
        Intent intent = getIntent();

        String title = intent.getStringExtra("title");
        String body = intent.getStringExtra("body");

        newsDetailBody.setText(body);
        newsDetailTitle.setText(title);

    }
}
