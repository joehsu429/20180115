package com.example.student.a20180115;


import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {
    ProgressBar pb;//m3
    ImageView img;//m3
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pb=findViewById(R.id.progressBar);//m3
        img=findViewById(R.id.imageView);//m3
    }
    //m1
    public void click1(View v) {
        RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
        pb.setVisibility(View.VISIBLE);//m3
        img.setVisibility(View.INVISIBLE);//m3
        ImageRequest request = new ImageRequest("https://5.imimg.com/data5/UH/ND/MY-4431270/red-rose-flower-500x500.jpg",
                new Response.Listener<Bitmap>() {
                    @Override
                    public void onResponse(Bitmap response) {
                        img.setImageBitmap(response);
                        pb.setVisibility(View.INVISIBLE);//m3
                        img.setVisibility(View.VISIBLE);//m3
                    }
                }, 0, 0, ImageView.ScaleType.FIT_XY, Bitmap.Config.RGB_565, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        queue.add(request);
        queue.start();
    }
    public void  click2(View v)//m2
    {
        RequestQueue queue=Volley.newRequestQueue(MainActivity.this);
        StringRequest request = new UTF8StringRequest("https://www.mobile01.com/rss/news.xml",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("NET", response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        queue.add(request);
        queue.start();

    }
}
