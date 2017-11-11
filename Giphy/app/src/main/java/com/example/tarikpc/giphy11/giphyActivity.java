package com.example.tarikpc.giphy11;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

/**
 * Created by Tarik PC on 11-11-17.
 */

public class giphyActivity extends Activity {
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.giphy);
        imageView = (ImageView) findViewById(R.id.gif);
        String link = getIntent().getStringExtra("link");
        Glide.with(getBaseContext()).load(link).asGif().placeholder(R.drawable.loading_bar).diskCacheStrategy(DiskCacheStrategy.SOURCE).into(imageView);
    }
}

