package com.example.tarikpc.aatdiscutioncc1;

import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.Service;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.sip.SipAudioCall;
import android.net.sip.SipSession;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.ActionMode;
import android.view.View;
import android.widget.Button;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

public class MainActivity extends AppCompatActivity{
    Button acc2;
    Button dialog;
    Button send;
    AlertDialog.Builder builder;
    APIService testApi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://58489054.ngrok.io/").addConverterFactory(GsonConverterFactory.create()).build();
        testApi = retrofit.create(APIService.class);
        builder = new AlertDialog.Builder(this);
        Realm.init(this);
        acc2 = (Button) findViewById(R.id.buttonNavigation);
        dialog = (Button) findViewById(R.id.buttonDialog);
        send = (Button) findViewById(R.id.buttonSend);
        acc2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(v.getContext(), Activity2.class);
                startActivityForResult(myIntent, 0);
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
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(0, resultCode, data);
        if(resultCode == RESULT_OK){
            builder.setTitle("Rezultat").setMessage("OK").show();
        } else {
            builder.setTitle("Rezultat").setMessage("NOT OK").show();
        }
    }

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
}
