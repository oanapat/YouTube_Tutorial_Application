package com.androiddev.oana.youtubeplayerapplication;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

//change extends to tell it to use the YoutubeLibrary that we added
public class YoutubeActivity extends YouTubeBaseActivity
    implements YouTubePlayer.OnInitializedListener
    {
        private String GOOGLE_API_KEY = "TBA";
        private String YOUTUBE_VIDEO_ID = "TBA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_youtube);
        //formed a link to the content_youtube layout
        YouTubePlayerView youtubePlayerView = (YouTubePlayerView)findViewById(R.id.youtube_player);
        //directs youtube player to what it needs to do after it was initialized
        youtubePlayerView.initialize(GOOGLE_API_KEY, this);

//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }
        //methods generated due to the extends YouTubeBaseActivity
        //added Toast to display a message
        //set up listeners and queues up the video so that YouTube Player knows where to go and get the results
        @Override
        public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean wasRestored) {
            Toast.makeText(this, "Initialized Youtube Player Successfully", Toast.LENGTH_SHORT).show();
            youTubePlayer.setPlayerStateChangeListener(playerStateChangedListener);
            youTubePlayer.setPlaybackEventListener(playbackEventListener);

            //if it was not restored play video
            if(!wasRestored){
                youTubePlayer.cueVideo(YOUTUBE_VIDEO_ID);
            }
        }

        //implement the Listeners
         YouTubePlayer.PlaybackEventListener playbackEventListener = new YouTubePlayer.PlaybackEventListener() {
            @Override
            public void onPlaying() {
                Toast.makeText(YoutubeActivity.this,"Good, video is playing ok", Toast.LENGTH_LONG).show();

            }

            @Override
            public void onPaused() {
                Toast.makeText(YoutubeActivity.this,"Video has paused", Toast.LENGTH_LONG).show();

            }

            @Override
            public void onStopped() {

            }

            @Override
            public void onBuffering(boolean b) {

            }

            @Override
            public void onSeekTo(int i) {

            }
        };

        YouTubePlayer.PlayerStateChangeListener playerStateChangedListener = new YouTubePlayer.PlayerStateChangeListener(){
            @Override
            public void onLoading() {

            }

            @Override
            public void onLoaded(String s) {

            }

            @Override
            public void onAdStarted() {
                Toast.makeText(YoutubeActivity.this, "Click Ad now if you like", Toast.LENGTH_LONG).show();

            }

            @Override
            public void onVideoStarted() {
                Toast.makeText(YoutubeActivity.this, "Video has started", Toast.LENGTH_LONG).show();

            }

            @Override
            public void onVideoEnded() {

            }

            @Override
            public void onError(YouTubePlayer.ErrorReason errorReason) {

            }
        };

        public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
            Toast.makeText(this, "Failed to initialize Youtube Player", Toast.LENGTH_SHORT).show();

        }
    }
