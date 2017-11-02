package com.example.tarikpc.novahuehuehue;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Tarik PC on 02-11-17.
 */

public interface APIServiceDogs {
    @GET("api/breeds/list")
    Call<Dogs> getAll();
}
