package com.example.greenroutes.data.dto;

import androidx.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class NewRouteDto {
    @Nullable
    @SerializedName("name")
    public String name;

    @Nullable
    @SerializedName("points")
    public List<Coordination> points;

    @Nullable
    @SerializedName("description")
    public String description;

    @Nullable
    @SerializedName("photosId")
    public List<Integer> photosId;

    public static class Coordination {
        public double x;
        public double y;

        public Coordination(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    public NewRouteDto(@Nullable String name, @Nullable List<Coordination> points, @Nullable String description, @Nullable List<Integer> photosId) {
        this.name = name;
        this.points = points;
        this.description = description;
        this.photosId = photosId;
    }
}
