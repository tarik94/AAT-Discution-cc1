package com.example.tarikpc.novahuehuehue;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by Tarik PC on 02-11-17.
 */

public interface APIService {
    @POST("pet")
    Call<Void> savePost(@Body Example root);
}

