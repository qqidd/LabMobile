package com.example.networkingassigment.API;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {
    @GET("api/users")
    Call<DataResponse> getUser(@Query("per_page") String per_page);

    @GET("api/users/{id}")
    Call<SingleUserDataResponse> getUserById(@Path("id") String id);
}