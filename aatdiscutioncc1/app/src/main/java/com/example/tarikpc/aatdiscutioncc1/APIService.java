package com.example.tarikpc.aatdiscutioncc1;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Tarik PC on 30-10-17.
 */

public interface APIService {
    @POST("pet")
    Call<Void> savePost(@Body Example root);
}
