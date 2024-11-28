package com.muje.utskelompok;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.muje.utskelompok.R;
import com.muje.utskelompok.RecyclerViewActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigation = findViewById(R.id.bottomNavigation);

        // Set listener untuk navigasi bottom bar

        bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();
                if (itemId == R.id.navigation_home) {
                    // Tetap di Home
                    return true;
                } else if (itemId == R.id.navigation_help) {
                    startActivity(new Intent(MainActivity.this, RecyclerViewActivity.class));
                    return true;
                } else if (itemId == R.id.navigation_profile) {
                    startActivity(new Intent(MainActivity.this, RecyclerViewActivity.class));
                    return true;
                }
                return false;
            }
        });
    }
        public void openRecyclerViewActivity(View view) {
            Intent intent = new Intent(this, RecyclerViewActivity.class);
            startActivity(intent);
    }
}
