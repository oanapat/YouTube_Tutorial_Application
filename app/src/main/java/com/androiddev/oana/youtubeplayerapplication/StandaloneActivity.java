package com.androiddev.oana.youtubeplayerapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.google.android.youtube.player.YouTubeStandalonePlayer;

public class StandaloneActivity extends AppCompatActivity implements View.OnClickListener
{
    private String GOOGLE_API_KEY = "AIzaSyDEoUmpLodDx4dRaAThAbW4Km6fy018jVk";
    private String YOUTUBE_VIDEO_ID = "92S4zgXN17o";
    private String YOUTUBE_PLAYLIST = "PL2_aWCzGMAwI3W_JlcBbtYTwiQSsOTa6P";
    private Button btnPlayVideo;
    private Button btnPlayPlaylist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_standalone);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //connect code with Buttons from layout
        btnPlayVideo = (Button)findViewById(R.id.btnPlayVideo);
        btnPlayPlaylist = (Button) findViewById(R.id.btnPlayList);

        //set up onClickListener
        btnPlayVideo.setOnClickListener(this);
        btnPlayPlaylist.setOnClickListener(this);


//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }

    //retrieving what the actual button ID is becasue depending on the button that is clicked we either
    //play one video or the entire playlist(the switch statement takes care of that
    //-->the onClickListener is setup so that both buttons have access to only this method
    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch(v.getId()){
            case R.id.btnPlayVideo:
                intent = YouTubeStandalonePlayer.createVideoIntent(this, GOOGLE_API_KEY, YOUTUBE_VIDEO_ID);
                break;
            case R.id.btnPlayList:
                intent = YouTubeStandalonePlayer.createPlaylistIntent(this, GOOGLE_API_KEY, YOUTUBE_PLAYLIST);
                break;
            default:

        }
        if(intent!=null){
            startActivity(intent);
        }

    }
}
