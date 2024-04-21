package com.example.greenroutes.ui.Map;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.greenroutes.R;
import com.example.greenroutes.data.RouteRepositoryImpl;
import com.example.greenroutes.domain.GetRouteByIdUseCase;
import com.example.greenroutes.domain.GetRoutesListUseCase;
import com.example.greenroutes.domain.entites.FullRouteEntity;
import com.example.greenroutes.domain.entites.ItemRouteEntity;
import com.example.greenroutes.domain.entites.Status;
import com.example.greenroutes.ui.MainActivity;
import com.example.greenroutes.ui.routecreation.RouteCreationScreen;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MainMap extends Fragment {

    private final GetRoutesListUseCase getRoutesListUseCase = new GetRoutesListUseCase(
            RouteRepositoryImpl.getInstance()
    );
    private final GetRouteByIdUseCase getRouteByIdUseCase = new GetRouteByIdUseCase(
            RouteRepositoryImpl.getInstance()
    );
    private final MutableLiveData<State> mutableStateLiveData = new MutableLiveData<>();
    public List<FullRouteEntity> data = new ArrayList<>();
    public FullRouteEntity fullData;
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

            googleMap.setOnMapLongClickListener(new GoogleMap.OnMapLongClickListener() {
                @Override
                public void onMapLongClick(@NonNull LatLng latLng) {
                    FragmentTransaction ft = getChildFragmentManager().beginTransaction();
                    ft.add(new RouteCreationScreen(),"addRoute");
                    ft.commit();
                }
            });

            Log.w("null?", data.toString());
            if (mutableStateLiveData.getValue() != null && data.toString() != null) {
                for (FullRouteEntity item : data) {
                    for (LatLng latLng: item.getPoints()){
                        googleMap.addMarker(new MarkerOptions().position(latLng).title(item.getName()));
                    }
                    Log.w("item", "new Item");
                }
            }
            else{
                Log.w("else","!( mutableStateLiveData.getValue() != null && mutableStateLiveData.getValue().items != null)");
            }

           /* googleMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
                @Override
                public boolean onMarkerClick(@NonNull Marker marker) {
                    Log.w("null?", data.toString());
                    getRouteByIdUseCase.execute(getIdByName(data, marker.getTitle()),status -> {
                        fullData = (fromFullStatus(status).getItem());
                        Log.w("FullData","statuse = " + fromFullStatus(status).getItem());
                    });
                    return false;
                }
            });*/
        }
    };
    public String getIdByName(List<FullRouteEntity> data, String sourceName){
        String id = "";
        for (FullRouteEntity item : data){
            if (item.getName().equals(sourceName)){
                id = item.getId();
            }
        }
        return id;
    }
    public MainMap() {
        update();
    }

    public void update() {
        mutableStateLiveData.setValue(new State(null, null, true));
        getRoutesListUseCase.execute(status -> {
            //mutableStateLiveData.postValue(fromStatus(status));
            Log.w("after fromStatus","fromStatus(status).getItems().toString()");
            data.addAll(fromStatus(status).getItems());

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
    public static class State {
        @Nullable
        private final String errorMessage;

        @Nullable
        private final List<FullRouteEntity> items;

        private final boolean isLoading;

        public State(@Nullable String errorMessage, @Nullable List<FullRouteEntity> items, boolean isLoading) {
            this.errorMessage = errorMessage;
            this.items = items;
            this.isLoading = isLoading;
            Log.w("frState","items.toString()");
            //Log.w("frState",items.toString());
        }

        @Nullable
        public String getErrorMessage() {
            return errorMessage;
        }

        @Nullable
        public List<FullRouteEntity> getItems() {
            return items;
        }

        public boolean isLoading() {
            return isLoading;
        }
    }
    private State fromStatus(Status<List<FullRouteEntity>> status) {
        Log.w("fromStatus","status.getValue().toString()");
        Log.w("fromStatus",status.getValue().toString());
        return new State(
                status.getErrors() != null ? status.getErrors().getLocalizedMessage() : null,
                status.getValue(),
                false
        );
    }

    public static class FullState {
        @Nullable
        private final String errorMessage;

        @Nullable
        private final FullRouteEntity item;

        private final boolean isLoading;

        public FullState(@Nullable String errorMessage, @Nullable FullRouteEntity item, boolean isLoading) {
            this.errorMessage = errorMessage;
            this.item = item;
            this.isLoading = isLoading;
        }

        @Nullable
        public String getErrorMessage() {
            return errorMessage;
        }

        @Nullable
        public FullRouteEntity getItem() {
            return item;
        }

        public boolean isLoading() {
            return isLoading;
        }
    }
    private FullState fromFullStatus(Status<FullRouteEntity> status) {
        return new FullState(
                status.getErrors() != null ? status.getErrors().getLocalizedMessage() : null,
                status.getValue(),
                false
        );
    }
}