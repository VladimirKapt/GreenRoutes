package com.example.greenroutes.ui;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.greenroutes.R;
import com.example.greenroutes.databinding.ActivityMainBinding;
import com.example.greenroutes.ui.domain.Part;
import com.example.greenroutes.ui.recycler.DemoAdapter;

import java.util.LinkedList;
import java.util.List;

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

        /*
        setContentView(R.layout.rated);
        //binding = ActivityMainBinding.inflate(getLayoutInflater());
        //setContentView(binding.getRoot());
        List<Part> items=new LinkedList<>();
        items.add(new Part("Владимир Дьяченко","1234.0 км","112535"));
        items.add(new Part("Анис Ячменко","280.5 км","12344"));
        items.add(new Part("Размик ","288.0 км","1634"));
        items.add(new Part("Виктор Корнеплод","52.0 км","1375"));
        items.add(new Part("Олег 1","134.0 км","1573"));
        items.add(new Part("Олег 2","143.0 км","139"));
        items.add(new Part("Владимир Дьяченко","1234.0 км","112535"));
        items.add(new Part("Анис Ячменко","280.5 км","12344"));
        items.add(new Part("Размик ","288.0 км","1634"));
        items.add(new Part("Виктор Корнеплод","52.0 км","1375"));
        items.add(new Part("Олег 1","134.0 км","1573"));
        items.add(new Part("Олег 2","143.0 км","139"));
        items.add(new Part("Владимир Дьяченко","1234.0 км","112535"));
        items.add(new Part("Анис Ячменко","280.5 км","12344"));
        items.add(new Part("Размик ","288.0 км","1634"));
        items.add(new Part("Виктор Корнеплод","52.0 км","1375"));
        items.add(new Part("Олег 1","134.0 км","1573"));
        items.add(new Part("Олег 2","143.0 км","139"));
        items.add(new Part("Владимир Дьяченко","1234.0 км","112535"));
        items.add(new Part("Анис Ячменко","280.5 км","12344"));
        items.add(new Part("Размик ","288.0 км","1634"));
        items.add(new Part("Виктор Корнеплод","52.0 км","1375"));
        items.add(new Part("Олег 1","134.0 км","1573"));
        items.add(new Part("Олег 2","143.0 км","139"));
        items.add(new Part("Владимир Дьяченко","1234.0 км","112535"));
        items.add(new Part("Анис Ячменко","280.5 км","12344"));
        items.add(new Part("Размик ","288.0 км","1634"));
        items.add(new Part("Виктор Корнеплод","52.0 км","1375"));
        items.add(new Part("Олег 1","134.0 км","1573"));
        items.add(new Part("Олег 2","143.0 км","139"));
        items.add(new Part("Владимир Дьяченко","1234.0 км","112535"));
        items.add(new Part("Анис Ячменко","280.5 км","12344"));
        items.add(new Part("Размик ","288.0 км","1634"));
        items.add(new Part("Виктор Корнеплод","52.0 км","1375"));
        items.add(new Part("Олег 1","134.0 км","1573"));
        items.add(new Part("Олег 2","143.0 км","139"));
        RecyclerView recyclerView=findViewById(R.id.rectanglerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        DemoAdapter adapter=new DemoAdapter(items);
        recyclerView.setAdapter(adapter);
        */

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        replaceFragment(new MainMap());

       /* binding.bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
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
        });*/
    }
    private void replaceFragment(Fragment fragment){
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frame_layout,fragment);
        ft.commit();

    }


}