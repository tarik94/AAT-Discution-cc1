package com.example.tarikpc.giphy11;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Tarik PC on 11-11-17.
 */

public interface APIGiphy {
    @GET("search")
    Call<Data> getList(@Query("q") String search, @Query("api_key") String key, @Query("limit") String brElemenata);
}

