package com.androidmads.shapetransformation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.androidmads.shapetransformation.glide.GlideCircleTransformation;
import com.androidmads.shapetransformation.picasso.PicassoCircleTransformation;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Picasso.with(getApplicationContext()).load("http://i.imgur.com/DvpvklR.png")
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .transform(new PicassoCircleTransformation())
                .into((ImageView) findViewById(R.id.picassoImageView));

        Glide.with(getApplicationContext()).load("http://i.imgur.com/DvpvklR.png")
                .thumbnail(0.5f)
                .crossFade()
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .bitmapTransform(new GlideCircleTransformation(getApplicationContext()))
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into((ImageView) findViewById(R.id.glideImageView));

    }
}
