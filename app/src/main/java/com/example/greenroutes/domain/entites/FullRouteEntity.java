package com.example.greenroutes.domain.entites;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.gms.maps.model.LatLng;

import java.util.List;

public class FullRouteEntity {
    @NonNull
    private final String name;
    @NonNull
    private final String authorNickname;
    @Nullable
    private final Long distance;
    @Nullable
    private final Long favoriteN;
    @NonNull
    private final List<LatLng> points;
    @Nullable
    private final Boolean passed;
    @Nullable
    private final String description;

    public FullRouteEntity(
            @NonNull String name,
            @NonNull String authorNickname,
            @NonNull Long distance,
            @NonNull Long favoriteN,
            @NonNull List<LatLng> points,
            @NonNull Boolean passed,
            @NonNull String description
    ) {
        this.name = name;
        this.authorNickname = authorNickname;
        this.distance = distance;
        this.favoriteN = favoriteN;
        this.points = points;
        this.passed = passed;
        this.description = description;
    }

    @NonNull
    public String getName() {
        return name;
    }

    @NonNull
    public String getAuthorNickname() {
        return authorNickname;
    }

    @NonNull
    public Long getDistance() {
        return distance;
    }

    @NonNull
    public Long getFavoriteN() {
        return favoriteN;
    }

    @NonNull
    public List<LatLng> getPoints() {
        return points;
    }

    @NonNull
    public Boolean getPassed() {
        return passed;
    }

    @NonNull
    public String getDescription() {
        return description;
    }
}
