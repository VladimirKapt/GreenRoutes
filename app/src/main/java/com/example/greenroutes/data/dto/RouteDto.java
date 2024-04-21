package com.example.greenroutes.data.dto;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.gms.maps.model.LatLng;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RouteDto {
    @Nullable
    @SerializedName("id")
    public String id;

    @Nullable
    @SerializedName("name")
    public String name;

    @Nullable
    @SerializedName("startCoordination")
    public Coordination startCoordination;

    @Nullable
    @SerializedName("passed")
    public boolean passed;

    public static class Coordination {
        @SerializedName("x")
        public Float x;
        @SerializedName("y")
        public Float y;
    }
}
