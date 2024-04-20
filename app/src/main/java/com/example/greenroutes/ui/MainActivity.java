package com.example.greenroutes.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.greenroutes.R;
import com.example.greenroutes.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.rated);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}