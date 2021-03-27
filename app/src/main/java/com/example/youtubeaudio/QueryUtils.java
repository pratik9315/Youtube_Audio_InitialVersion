package com.example.youtubeaudio;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class QueryUtils {

    Context context;

    public QueryUtils(Context context) {
        this.context = context;
    }

    public interface VolleyResponseListener {
        void onError(String message);

        void onResponse(ArrayList<YoutubeHomePage> youtubeHomePages);
    }

    private static final String SAMPLE_API = "https://youtube.googleapis.com/youtube/v3/search?part=snippet&q=the%20reddead&key=AIzaSyAmLCwjyAbi65JNQo8pQmg51qto1piED08";
    public void getYTInfo( VolleyResponseListener volleyResponseListener) {
        //RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
        String url = SAMPLE_API;

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                ArrayList<YoutubeHomePage> ytContents = new ArrayList<YoutubeHomePage>();

                try {
                    JSONArray vidInfo = response.getJSONArray("items");
                    for (int i=0; i<vidInfo.length(); i++){
                        JSONObject firstVid = vidInfo.getJSONObject(i);
                        JSONObject firstObj = firstVid.getJSONObject("snippet");
                        String title = firstObj.getString("title");
                        String description = firstObj.getString("channelTitle");
                        JSONObject thumbnails = firstObj.getJSONObject("thumbnails");
                        JSONObject defaultThumbnail = thumbnails.getJSONObject("default");
                        String firstThumbnailURL = defaultThumbnail.getString("url");

                        YoutubeHomePage youtubeHomePage = new YoutubeHomePage(title, description, firstThumbnailURL);
                        ytContents.add(youtubeHomePage);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                //Toast.makeText(context, "City ID is :" +cityID, Toast.LENGTH_LONG).show();
                volleyResponseListener.onResponse(ytContents);
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, "Something went wrong", Toast.LENGTH_LONG).show();
                volleyResponseListener.onError("Wrong");

            }
        });
        //queue.add(jsonArrayRequest);
        MySingleton.getInstance(context).addToRequestQueue(jsonObjectRequest);

        //return cityName;
    }


}


