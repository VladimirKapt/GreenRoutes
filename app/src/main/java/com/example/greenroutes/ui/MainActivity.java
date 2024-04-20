package com.example.greenroutes.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.greenroutes.R;

import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //com.example.greenroutes.databinding.ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        //setContentView(binding.getRoot());
        setContentView(R.layout.rated);
        List<Part> items=new LinkedList<>();
        items.add(new Part("Олег 1","134.0 км","1573"));
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
    }
}