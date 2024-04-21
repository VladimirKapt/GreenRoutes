package com.example.greenroutes.data.dto;

import androidx.annotation.Nullable;

import com.google.android.gms.maps.model.LatLng;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FullRouteDto {
    @Nullable
    @SerializedName("name")
    public String name;
    @Nullable
    @SerializedName("authorNickname")
    public String authorNickname;
    @Nullable
    @SerializedName("distance")
    public Long distance;
    @Nullable
    @SerializedName("favoriteN")
    public Long favoriteN;
    @Nullable
    @SerializedName("points")
    public List<Coordination> coordinations;
    @Nullable
    @SerializedName("passed")
    public Boolean passed;
    @Nullable
    @SerializedName("description")
    public String description;

    public static class Coordination {

        @SerializedName("x")
        public Float x;

        @SerializedName("y")
        public Float y;


    }

}
