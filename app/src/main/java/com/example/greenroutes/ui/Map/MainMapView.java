package com.example.greenroutes.ui.Map;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.greenroutes.R;
import com.example.greenroutes.databinding.MainMapBinding;

public class MainMapView extends Fragment {
    private MainMapBinding binding;
    private MainMapViewModel viewModel;
    public MainMapView(){
        super(R.layout.main_map_fragment);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding = MainMapBinding.bind(view);
        viewModel = new ViewModelProvider(this).get(MainMapViewModel.class);

    }

    @Override
    public void onDestroy() {
        binding = null;
        super.onDestroy();
    }
}
