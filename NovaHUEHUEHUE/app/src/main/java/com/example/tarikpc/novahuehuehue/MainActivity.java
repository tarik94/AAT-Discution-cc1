package com.example.tarikpc.novahuehuehue;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import io.realm.Realm;
import io.realm.RealmResults;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity{
    Button acc2;
    Button dialog;
    Button send;
    Button get;
    AlertDialog.Builder builder;
    APIService testApi;
    APIServiceDogs testApiDogs;
    Realm realm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://58489054.ngrok.io/").addConverterFactory(GsonConverterFactory.create()).build();
        testApi = retrofit.create(APIService.class);
        Retrofit retrofit1 = new Retrofit.Builder().baseUrl("https://dog.ceo/").addConverterFactory(GsonConverterFactory.create()).build();
        testApiDogs = retrofit1.create(APIServiceDogs.class);
        builder = new AlertDialog.Builder(this);
        Realm.init(this);
        acc2 = (Button) findViewById(R.id.buttonNavigation);
        dialog = (Button) findViewById(R.id.buttonDialog);
        send = (Button) findViewById(R.id.buttonSend);
        get = (Button) findViewById(R.id.buttonGet);
        acc2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(v.getContext(), Activity2.class);
                startActivity(myIntent);//startActivityForResult(myIntent, 0);
            }
        });
        dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder.setTitle("Rezultat").setMessage("Nista").show();
            }
        });
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Example root = new Example();
                root.setRoot(new Root());
                root.getRoot().setNonRoot("Tarik");
                sendPost(root);
            }
        });
        get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                get();
            }
        });
    }

    /*@Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(0, resultCode, data);
        /*if(resultCode == RESULT_OK){
            builder.setTitle("Rezultat").setMessage("OK").show();
        } else {
            builder.setTitle("Rezultat").setMessage("NOT OK").show();
        }*//*
        realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        RealmResults<Rezultat> rezultats = realm.where(Rezultat.class).findAll();
        if(rezultats.size() > 0 && rezultats.first().isRez()){
            builder.setTitle("Rezultat").setMessage("OK").show();
        } else {
            builder.setTitle("Rezultat").setMessage("NOT OK").show();
        }
        realm.deleteAll();
        realm.commitTransaction();
    }*/

    public void sendPost(Example root){
        testApi.savePost(root).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {

            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {

            }
        });
    }

    public void get(){
        testApiDogs.getAll().enqueue(new Callback<Dogs>() {
            @Override
            public void onResponse(Call<Dogs> call, Response<Dogs> response) {
                Log.d("kerovi",response.body().getStatus());
            }

            @Override
            public void onFailure(Call<Dogs> call, Throwable t) {

            }
        });
    }

    @Override
    public void onResume(){
        super.onResume();
        realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        RealmResults<Rezultat> rezultats = realm.where(Rezultat.class).findAll();
        if(rezultats.size() > 0 && rezultats.first().isRez()){
            builder.setTitle("Rezultat").setMessage("OK").show();
        } else {
            builder.setTitle("Rezultat").setMessage("NOT OK").show();
        }
        realm.deleteAll();
        realm.commitTransaction();
    }
}
