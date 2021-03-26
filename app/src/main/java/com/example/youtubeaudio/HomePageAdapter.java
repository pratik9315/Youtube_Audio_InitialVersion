package com.example.youtubeaudio;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.net.URI;
import java.util.ArrayList;

public class HomePageAdapter extends RecyclerView.Adapter<HomePageAdapter.ViewHolder> {

    private Context context;
    public ArrayList<YoutubeHomePage> homePage;


    public HomePageAdapter(Context context, ArrayList<YoutubeHomePage> homePage) {
        this.context = context;
        this.homePage = homePage;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.youtube_home_page, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        YoutubeHomePage youtubeHomePage = homePage.get(position);

        String title = youtubeHomePage.getmTitle();
        String thumbNail = youtubeHomePage.getmThumbNail();


        //Uri uri = Uri.parse("src\\main\\res\\drawable-v24\\yt.png");
        Picasso.get().load(youtubeHomePage.getThumbnailURL()).into(holder.sampleThumbNail);
        holder.thumbNail.setText(thumbNail);
        holder.ytTitle.setText(title);
    }

    @Override
    public int getItemCount() {
        return homePage.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView ytTitle;
        TextView thumbNail;
        ImageView sampleThumbNail;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            ytTitle = itemView.findViewById(R.id.ytTitle);
            thumbNail = itemView.findViewById(R.id.thumbNail);
            sampleThumbNail = itemView.findViewById(R.id.sampleThumbNail);
        }
    }
    
}
