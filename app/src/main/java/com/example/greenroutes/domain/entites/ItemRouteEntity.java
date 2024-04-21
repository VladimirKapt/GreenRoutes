package com.example.greenroutes.domain.entites;

import androidx.annotation.NonNull;

import com.google.android.gms.maps.model.LatLng;

import java.util.List;

public class ItemRouteEntity {
    @NonNull
    private final String id;
    @NonNull
    private final String name;
    @NonNull
    private final LatLng latLng;
    @NonNull
    private final Boolean passed;
    public ItemRouteEntity(
            @NonNull String id,
            @NonNull String name,
            @NonNull LatLng latLng,
            @NonNull Boolean passed
    ) {
        this.id = id;
        this.name = name;
        this.latLng = latLng;
        this.passed = passed;
    }

    @NonNull
    public String getId() {
        return id;
    }

    @NonNull
    public String getName() {
        return name;
    }

    @NonNull
    public LatLng getLatLng() {
        return latLng;
    }

    @NonNull
    public Boolean getPassed() {
        return passed;
    }
}
