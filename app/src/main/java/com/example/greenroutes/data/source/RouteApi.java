package com.example.greenroutes.data.source;

import com.example.greenroutes.data.dto.FullRouteDto;
import com.example.greenroutes.data.dto.RouteDto;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Part;
import retrofit2.http.Path;

public interface RouteApi {
    @GET("/v1/routes")
    Call<List<RouteDto>> getAll();
    @GET("/v1/routes/{id}")
    Call<FullRouteDto> getById(@Path("id") String id);
}
