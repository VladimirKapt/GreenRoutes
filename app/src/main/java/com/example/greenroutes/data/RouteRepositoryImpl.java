package com.example.greenroutes.data;

import androidx.annotation.NonNull;

import com.example.greenroutes.data.dto.FullRouteDto;
import com.example.greenroutes.data.dto.RouteDto;
import com.example.greenroutes.data.network.RetrofitFactory;
import com.example.greenroutes.data.source.RouteApi;
import com.example.greenroutes.data.utils.CallToConsumer;
import com.example.greenroutes.domain.RouteRepository;
import com.example.greenroutes.domain.entites.FullRouteEntity;
import com.example.greenroutes.domain.entites.ItemRouteEntity;
import com.example.greenroutes.domain.entites.Status;
import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class RouteRepositoryImpl implements RouteRepository {
    private static RouteRepositoryImpl INSTANCE;
    private RouteApi routeApi = RetrofitFactory.getInstance().getRouteApi();

    private RouteRepositoryImpl(){}
    public static synchronized RouteRepositoryImpl getInstance(){
     if (INSTANCE == null){
        INSTANCE = new RouteRepositoryImpl();
     }
     return INSTANCE;
    }

    @Override
    public void getAllRoutes(@NonNull Consumer<Status<List<ItemRouteEntity>>> callback) {
        routeApi.getAll().enqueue(new CallToConsumer<>(
                callback,
                routesDto ->{
                    ArrayList<ItemRouteEntity> result = new ArrayList<>(routesDto.size());
                    for(RouteDto route : routesDto){
                        final String id = route.id;
                        final String name = route.name;
                        final Float x = route.startCoordination.x;
                        final Float y = route.startCoordination.y;
                        final Boolean passed = route.passed;
                        if(id != null && name != null && x != null && y != null){
                            result.add(new ItemRouteEntity(id,name,new LatLng(x,y),passed));
                        }
                    }
                    return result;
                }
        ));
    }

    @Override
    public void getRoute(@NonNull String id, @NonNull Consumer<Status<FullRouteEntity>> callback) {
        routeApi.getById(id).enqueue(new CallToConsumer<>(
                callback,
                routes ->{
                    final String name = routes.name;
                    List<LatLng> latLngList = new ArrayList<>();
                    if (routes.coordinations != null) {
                        for (FullRouteDto.Coordination coordination : routes.coordinations) {
                            latLngList.add(new LatLng(coordination.x, coordination.y));
                        }
                    }
                    if (name != null) {
                        return new FullRouteEntity(
                                name,
                                routes.authorNickname,
                                routes.distance,
                                routes.favoriteN,
                                latLngList,
                                routes.passed,
                                routes.description
                        );
                    } else {
                        return null;
                    }
                }
        ));
    }
}
