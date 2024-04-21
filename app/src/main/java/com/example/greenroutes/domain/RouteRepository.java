package com.example.greenroutes.domain;

import androidx.annotation.NonNull;

import com.example.greenroutes.domain.entites.FullRouteEntity;
import com.example.greenroutes.domain.entites.ItemRouteEntity;
import com.example.greenroutes.domain.entites.Status;

import java.util.List;
import java.util.function.Consumer;

public interface RouteRepository {
    void getAllRoutes(@NonNull Consumer<Status<List<ItemRouteEntity>>> callback);
    void getRoute(@NonNull String id, @NonNull Consumer<Status<FullRouteEntity>> callback);

}
