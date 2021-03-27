package com.example.youtubeaudio;

import android.media.Image;
import android.widget.ImageView;
import android.widget.TextView;

public class YoutubeHomePage {
    private String mTitle;
    private String thumbnailURL;
    private String channelTitle;

    public YoutubeHomePage(String mTitle, String channelTitle, String thumbnailURL) {
        this.mTitle = mTitle;
        this.channelTitle = channelTitle;
        this.thumbnailURL = thumbnailURL;
    }

    public String getThumbnailURL() {
        return thumbnailURL;
    }

    public void setThumbnailURL(ImageView sampleT) {
        this.thumbnailURL = thumbnailURL;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public void setThumbnailURL(String thumbnailURL) {
        this.thumbnailURL = thumbnailURL;
    }

    public String getChannelTitle() {
        return channelTitle;
    }

    public void setChannelTitle(String channelTitle) {
        this.channelTitle = channelTitle;
    }
}
