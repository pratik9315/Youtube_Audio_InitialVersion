package com.example.youtubeaudio;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    private HomePageAdapter mAdapter;
    ImageView thumbN;
    private static final String API_KEY = "AIzaSyAmLCwjyAbi65JNQo8pQmg51qto1piED08";
    private static final String SAMPLE_API = "https://youtube.googleapis.com/youtube/v3/search?part=snippet&q=the%20weekend&key=AIzaSyAmLCwjyAbi65JNQo8pQmg51qto1piED08";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getSupportActionBar().hide();
        TextView thumbNailView = (TextView) findViewById(R.id.thumbNail);
        TextView titleView = (TextView) findViewById(R.id.ytTitle);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        QueryUtils queryUtils = new QueryUtils(this);

        queryUtils.getYTInfo(new QueryUtils.VolleyResponseListener() {
            @Override
            public void onError(String message) {

            }

            @Override
            public void onResponse(ArrayList<YoutubeHomePage> youtubeHomePages) {
                HomePageAdapter homePageAdapter = new HomePageAdapter(HomeActivity.this, youtubeHomePages);
                recyclerView.setAdapter(homePageAdapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(HomeActivity.this));
            }
        });


    }
}

