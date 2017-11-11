package com.example.tarikpc.giphy11;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    ListView listView;
    APIGiphy apiGiphy;
    List<Giphy> giphyList = new ArrayList<Giphy>();
    GiphyAdapter giphyAdapter;
    static String apiKey = "yXeFI6D8TyVNtjLVYv17riJr0Or4kp23";
    static String limit = "25";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText) findViewById(R.id.editText);
        listView = (ListView) findViewById(R.id.listView);
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api.giphy.com/v1/gifs/").addConverterFactory(GsonConverterFactory.create()).build();
        apiGiphy = retrofit.create(APIGiphy.class);
        giphyAdapter = new GiphyAdapter(this, R.layout.giphyitem, giphyList);
        listView.setAdapter(giphyAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, giphyActivity.class);
                intent.putExtra("link", giphyList.get(position).getImages().getOriginal().getUrl());
                startActivity(intent);
            }
        });
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                get(s.toString(), apiKey, limit);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    public void get(final String search, String apiKey, String limit){
        apiGiphy.getList(search, apiKey, limit).enqueue(new Callback<Data>() {
            @Override
            public void onResponse(Call<Data> call, Response<Data> response) {
                giphyList.clear();
                giphyList.addAll(response.body().getData());
                giphyAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<Data> call, Throwable t) {

            }
        });
    }
}
