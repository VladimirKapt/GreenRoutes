package com.example.greenroutes.data.network;

import com.example.greenroutes.data.RouteRepositoryImpl;
import com.example.greenroutes.data.source.RouteApi;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitFactory {
    private static RetrofitFactory INSTANCE;
    private RetrofitFactory(){}
    private HttpLoggingInterceptor logging = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
    public OkHttpClient client = new OkHttpClient.Builder()
            .addInterceptor(logging)
            .build();
    public static synchronized RetrofitFactory getInstance(){

        if (INSTANCE == null){
            INSTANCE = new RetrofitFactory();
        }
        return INSTANCE;
    }
    private Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://26.159.188.148:4050/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build();
    public RouteApi getRouteApi(){
        return retrofit.create(RouteApi.class);
    }
}
