package com.example.homnayangi.view.main;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.example.homnayangi.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.example.homnayangi.NoteActivity;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    Fragment fragment;

    FrameLayout frameLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.bnv_dash_board);
        frameLayout = findViewById(R.id.fl_container);

        fragment = HomeFragment.newInstance();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(frameLayout.getId(), fragment);
        fragmentTransaction.commit();


        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_home: {
                        fragment = HomeFragment.newInstance();
                        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(frameLayout.getId(), fragment);
                        fragmentTransaction.commit();
                        return true;
                    }
                    case R.id.nav_store: {
                        fragment = StoreFragment.newInstance();
                        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(frameLayout.getId(), fragment);
                        fragmentTransaction.commit();
                        return true;
                    }
                    case R.id.nav_note: {
                        Intent intent = new Intent(MainActivity.this, NoteActivity.class );
                        startActivity(intent);
                        return true;
                    }
                    default:
                        return false;
                }
            }
        });
    }
}