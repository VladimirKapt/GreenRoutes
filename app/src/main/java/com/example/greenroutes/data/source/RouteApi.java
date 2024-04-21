package com.example.greenroutes.data.source;

import com.example.greenroutes.data.dto.FullRouteDto;
import com.example.greenroutes.data.dto.NewRouteDto;
import com.example.greenroutes.data.dto.RouteDto;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.HEAD;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;

public interface RouteApi {
    @Headers("Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJ1c2VybmFtZSI6InZvdmE0IiwidXNlcklkIjoxNjAyLCJpYXQiOjE3MTM2Nzg4NzAsImV4cCI6MTcxMzY4OTY3MH0.MpsW5LNbvIOlAbDgQhdYy4uwRkzjpP4lOg6tZIX_5ec")
    @GET("/v1/routes")
    Call<List<RouteDto>> getAll();

    @GET("/v1/routes/{id}")
    Call<FullRouteDto> getById(@Path("id") String id);

    @Headers("Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJ1c2VybmFtZSI6ImFza2FydGl1c3MiLCJ1c2VySWQiOjE0MDQsImlhdCI6MTcxMzY5NTU0NywiZXhwIjoxNzE0Nzc1NTQ3fQ.aSD125vA05Jq5pe4-ScWTt6R-w_diWxLkDc4kigQxdc")
    @POST("/v1/routes")
    Call<Object> createRoute(@Body NewRouteDto newRouteDto);
}