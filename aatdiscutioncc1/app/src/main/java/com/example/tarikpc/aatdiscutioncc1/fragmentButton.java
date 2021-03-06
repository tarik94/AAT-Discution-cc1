package com.example.tarikpc.aatdiscutioncc1;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.Button;

import io.realm.Realm;

import static android.app.Activity.RESULT_OK;

/**
 * Created by Tarik PC on 26-10-17.
 */

public class fragmentButton extends Fragment {
    Button back;
    Realm realm;
    private View view;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_button, container, false);
        back = (Button) view.findViewById(R.id.buttonBack);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                realm = Realm.getDefaultInstance();
                realm.beginTransaction();
                Pokusaj pokusaj = realm.createObject(Pokusaj.class);
                pokusaj.setRezultat("Ober");
                realm.commitTransaction();
                getActivity().finish();
            }
        });
        return view;
    }
}
