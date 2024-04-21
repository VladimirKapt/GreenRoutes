package com.example.greenroutes.domain;

import androidx.annotation.NonNull;

import com.example.greenroutes.domain.entites.FullRouteEntity;
import com.example.greenroutes.domain.entites.Status;

import java.util.List;
import java.util.function.Consumer;

public class GetRouteByIdUseCase {
    private final RouteRepository repo;

    public GetRouteByIdUseCase(RouteRepository repo) {
        this.repo = repo;
    }

    public void execute(@NonNull String id, @NonNull Consumer<Status<List<FullRouteEntity>>> callback){
        repo.getAllRoutes(callback);
    }
}
