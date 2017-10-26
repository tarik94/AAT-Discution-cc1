package com.example.tarikpc.aatdiscutioncc1;

import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.sip.SipAudioCall;
import android.net.sip.SipSession;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import io.realm.Realm;

public class MainActivity extends AppCompatActivity {
    Button acc2;
    Button dialog;
    AlertDialog.Builder builder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Realm.init(this);
        builder = new AlertDialog.Builder(this);
        acc2 = (Button) findViewById(R.id.buttonNavigation);
        dialog = (Button) findViewById(R.id.buttonDialog);
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

    /*@Override
    protected void onResume() {
        super.onResume();
        Realm realm = Realm.getDefaultInstance();
        boolean test = realm.where(Rezultat.class).isNotEmpty("rez").isValid();
        if(test){
            builder.setTitle("Rezultat").setMessage("OK").show();
            realm.deleteAll();
        } else {
            builder.setTitle("Rezultat").setMessage("NOT OK").show();
        }
    }*/
}
