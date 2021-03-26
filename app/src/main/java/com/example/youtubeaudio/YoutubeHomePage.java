package com.example.youtubeaudio;

import android.media.Image;
import android.widget.ImageView;
import android.widget.TextView;

public class YoutubeHomePage {
    private String mTitle;
    private String mThumbNail;
    private String thumbnailURL;

    public YoutubeHomePage(String mTitle, String mThumbNail, String thumbnailURL) {
        this.mTitle = mTitle;
        this.mThumbNail = mThumbNail;
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

    public String getmThumbNail() {
        return mThumbNail;
    }

    public void setmThumbNail(String mThumbNail) {
        this.mThumbNail = mThumbNail;
    }
}
