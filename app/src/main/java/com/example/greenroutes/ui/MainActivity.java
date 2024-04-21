package com.example.greenroutes.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.example.greenroutes.R;
import com.example.greenroutes.databinding.ActivityMainBinding;
import com.example.greenroutes.ui.Map.MainMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.checkerframework.checker.units.qual.Current;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private FrameLayout frameLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        replaceFragment(new MainMap());

        binding.bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.item_map:
                        replaceFragment(new MainMap());
                        return true;
                    case R.id.item_routes:
                        replaceFragment(new MainMap());
                        return true;
                    case R.id.item_profile:
                        replaceFragment(new MainMap());
                        return true;
                }
                return false;
            }
        });
    }
    private void replaceFragment(Fragment fragment){
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frame_layout,fragment);
        ft.commit();
    }


}