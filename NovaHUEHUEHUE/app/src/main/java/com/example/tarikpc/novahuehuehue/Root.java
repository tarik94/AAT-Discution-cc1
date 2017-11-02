package com.example.tarikpc.novahuehuehue;

/**
 * Created by Tarik PC on 02-11-17.
 */
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Root {

    @SerializedName("non_root")
    @Expose
    private String nonRoot;

    public String getNonRoot() {
        return nonRoot;
    }

    public void setNonRoot(String nonRoot) {
        this.nonRoot = nonRoot;
    }

}
