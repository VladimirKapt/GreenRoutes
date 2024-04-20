package com.example.greenroutes.data.network;

import com.example.greenroutes.data.RouteRepositoryImpl;
import com.example.greenroutes.data.source.RouteApi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitFactory {
    private static RetrofitFactory INSTANCE;
    private RetrofitFactory(){}
    public static synchronized RetrofitFactory getInstance(){
        if (INSTANCE == null){
            INSTANCE = new RetrofitFactory();
        }
        return INSTANCE;
    }
    private Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://26.159.188.148:4050/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    public RouteApi getRouteApi(){
        return retrofit.create(RouteApi.class);
    }
}
