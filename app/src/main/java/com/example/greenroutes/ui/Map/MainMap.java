package com.example.greenroutes.ui.Map;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.greenroutes.R;
import com.example.greenroutes.data.RouteRepositoryImpl;
import com.example.greenroutes.domain.GetRoutesListUseCase;
import com.example.greenroutes.domain.entites.ItemRouteEntity;
import com.example.greenroutes.domain.entites.Status;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

public class MainMap extends Fragment {

    private final GetRoutesListUseCase getRoutesListUseCase = new GetRoutesListUseCase(
            RouteRepositoryImpl.getInstance()
    );
    private final MutableLiveData<State> mutableStateLiveData = new MutableLiveData<>();
    public List<ItemRouteEntity> data = new ArrayList<>();
    public final LiveData<State> stateLiveData = mutableStateLiveData;

    private final OnMapReadyCallback callback = new OnMapReadyCallback() {
        @Override
        public void onMapReady(@NonNull GoogleMap googleMap) {
            Log.w("onMapReady","MapReady");
            googleMap.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(60,60)));

            googleMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
                @Override
                public void onMapClick(@NonNull LatLng latLng) {
                    Log.w("onClickMap","Click " + latLng.latitude + " " + latLng.longitude);
                }
            });

            Log.w("null?", data.toString());
            if (mutableStateLiveData.getValue() != null && data.toString() != null) {
                for (ItemRouteEntity item : data) {
                    googleMap.addMarker(new MarkerOptions().position(item.getLatLng()).title(item.getName()));
                    Log.w("item", "new Item");
                }
            }
            else{
                Log.w("else","!( mutableStateLiveData.getValue() != null && mutableStateLiveData.getValue().items != null)");
            }
        }
    };

    public MainMap() {
        update();
    }

    public void update() {
        mutableStateLiveData.setValue(new State(null, null, true));
        getRoutesListUseCase.execute(status -> {
            mutableStateLiveData.postValue(fromStatus(status));
            data.addAll(fromStatus(status).getItems());
            Log.w("fromStatus","statuse = " + fromStatus(status).getItems());
        });
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SupportMapFragment mapFragment =
                (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.main_google_map);
        if(mapFragment != null){
            mapFragment.getMapAsync(callback);
        }
    }

    @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            // Inflate the layout for this fragment

            return inflater.inflate(R.layout.fragment_main_map, container, false);
        }
    public class State {
        @Nullable
        private final String errorMessage;

        @Nullable
        private final List<ItemRouteEntity> items;

        private final boolean isLoading;

        public State(@Nullable String errorMessage, @Nullable List<ItemRouteEntity> items, boolean isLoading) {
            this.errorMessage = errorMessage;
            this.items = items;
            this.isLoading = isLoading;
        }

        @Nullable
        public String getErrorMessage() {
            return errorMessage;
        }

        @Nullable
        public List<ItemRouteEntity> getItems() {
            return items;
        }

        public boolean isLoading() {
            return isLoading;
        }
    }
    private State fromStatus(Status<List<ItemRouteEntity>> status) {
        return new State(
                status.getErrors() != null ? status.getErrors().getLocalizedMessage() : null,
                status.getValue(),
                false
        );
    }
}