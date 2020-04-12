package com.example.koronavirusapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private Toolbar toolbar;
    private DrawerLayout drawer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawer = findViewById(R.id.Drawer);
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Statistika");
        setSupportActionBar(toolbar);

        NavigationView navigationView = findViewById(R.id.navigationView);
        navigationView.setNavigationItemSelectedListener(this);



        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawer, toolbar, 0, 0);

        drawer.addDrawerListener(actionBarDrawerToggle);

        actionBarDrawerToggle.syncState();

        getSupportFragmentManager().beginTransaction().replace(R.id.frame, new ListFragment()).commit();
        navigationView.setCheckedItem(R.id.country);
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {

            case R.id.about:

                getSupportFragmentManager().beginTransaction().replace(R.id.frame, new AboutFragment()).commit();
                toolbar.setTitle("Haqqında");
                break;

            case R.id.country:

                getSupportFragmentManager().beginTransaction().replace(R.id.frame, new ListFragment()).commit();
                toolbar.setTitle("Statistika");
                break;
            case R.id.news:
                getSupportFragmentManager().beginTransaction().replace(R.id.frame, new NewsFragment()).commit();
                toolbar.setTitle("Xəbərlər");
                break;
        }

        drawer.closeDrawer(GravityCompat.START);

        return true;
    }
}
