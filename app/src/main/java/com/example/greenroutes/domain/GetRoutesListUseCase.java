package com.example.greenroutes.domain;

import androidx.annotation.NonNull;

import com.example.greenroutes.domain.entites.FullRouteEntity;
import com.example.greenroutes.domain.entites.ItemRouteEntity;
import com.example.greenroutes.domain.entites.Status;

import java.util.List;
import java.util.function.Consumer;

public class GetRoutesListUseCase {
    private final RouteRepository repo;

    public GetRoutesListUseCase(RouteRepository repo) {
        this.repo = repo;
    }

    public void execute(@NonNull Consumer<Status<List<ItemRouteEntity>>> callback){
        repo.getAllRoutes(callback);
    }
}
