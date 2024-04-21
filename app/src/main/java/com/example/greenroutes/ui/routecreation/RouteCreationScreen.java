package com.example.greenroutes.ui.routecreation;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.example.greenroutes.R;
import com.example.greenroutes.data.dto.NewRouteDto;
import com.example.greenroutes.data.network.RetrofitFactory;

import java.util.ArrayList;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RouteCreationScreen extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.screen_route_creation, container, false);

        // Add maps to the screen
        MapsFragment mapsFragment = new MapsFragment();
        getChildFragmentManager().beginTransaction().replace(R.id.map_frame, mapsFragment).commit();

        // Logic for FAB
        view.findViewById(R.id.fab).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editRouteName = view.findViewById(R.id.edit_route_name);
                NewRouteDto newRouteDto = new NewRouteDto(editRouteName.getText().toString(), mapsFragment.getPoints(), "", new ArrayList<>());

                Call<Object> call = RetrofitFactory.getInstance().getRouteApi().createRoute(newRouteDto);
                call.enqueue(new Callback<Object>() {
                    @Override
                    public void onResponse(@NonNull Call<Object> call, @NonNull Response<Object> response) {
                        Log.d("RouteCreation", Objects.requireNonNull(response.body()).toString());
                        Toast.makeText(getContext(), "Route created", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(@NonNull Call<Object> call, @NonNull Throwable t) {
                        Log.d("RouteCreation", Objects.requireNonNull(t.getMessage()));
                    }
                });

                getParentFragment().getActivity().getSupportFragmentManager().beginTransaction().remove(getParentFragment()).commit();
            }
        });

        return view;
    }
}