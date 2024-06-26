package com.example.greenroutes.data;

import android.util.Log;

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
    private final RouteApi routeApi = RetrofitFactory.getInstance().getRouteApi();

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
                    ArrayList<ItemRouteEntity> result = new ArrayList<>();
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
                    Log.w("routesDto" , routesDto.toString());
                    return result;
                }
        ));
    }

    @Override
    public void getRoute(@NonNull String id, @NonNull Consumer<Status<FullRouteEntity>> callback) {
        routeApi.getById(id).enqueue(new CallToConsumer<>(
                callback,
                route ->{
                    Log.w("route2" , route.toString());

                    final String name = route.name;
                    List<LatLng> latLngList = new ArrayList<>();
                    if (route.coordinations != null) {
                        for (FullRouteDto.Coordination coordination : route.coordinations) {
                            latLngList.add(new LatLng(coordination.x, coordination.y));
                        }
                    }
                    Log.w("route" , route.toString());
                    return new FullRouteEntity(
                            id,
                            name,
                            route.authorNickname,
                            route.distance,
                            route.favoriteN,
                            latLngList,
                            route.passed,
                            route.description
                    );
                    /*if (name != null) {
                        return new FullRouteEntity(
                                name,
                                route.authorNickname,
                                route.distance,
                                route.favoriteN,
                                latLngList,
                                route.passed,
                                route.description
                        );
                    } else {
                        return null;
                    }*/
                }
        ));

    }
}
