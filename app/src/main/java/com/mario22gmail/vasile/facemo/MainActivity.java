package com.mario22gmail.vasile.facemo;

import android.media.AudioManager;
import android.media.FaceDetector;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.VideoView;

import java.io.FileInputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity implements SurfaceHolder.Callback, MediaPlayer.OnPreparedListener {

    private MediaPlayer mediaPlayer;
    private SurfaceView surfaceView;
    private SurfaceHolder surfaceHolder;

    String newString;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                newString = null;
            } else {
                newString = extras.getString("film");
            }
        } else {
            newString = (String) savedInstanceState.getSerializable("film");
        }
        setContentView(R.layout.activity_main);

        surfaceView = (SurfaceView) findViewById(R.id.surfaceView);
        surfaceHolder = surfaceView.getHolder();
        surfaceHolder.addCallback(this);

    }

    @Override
    protected void onResume() {
        super.onResume();
//        VideoView videoview = (VideoView) findViewById(R.id.videoView);
//        Uri uri = null;
//        switch(newString){
//            case "godfather":
//                uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.godfather);
//                break;
//            case "gladiator":
//                uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.gladiator);
//                break;
//            case "scarface":
//                uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.scarface);
//                break;
//            default:
//        }
//
//        videoview.setVideoURI(uri);
//        videoview.start();

    }

    @Override
    public void onPrepared(MediaPlayer mp) {
        mediaPlayer.start();
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
//        mediaPlayer.setDataSource("/Users/mario/Downloads/godfather");
        Uri uri = null;
        String path = null;
        switch(newString){
            case "godfather":
                path = "android.resource://" + getPackageName() + "/" + R.raw.godfather;
                uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.godfather);
                break;
            case "gladiator":
                path = "android.resource://" + getPackageName() + "/" + R.raw.gladiator;
                uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.gladiator);
                break;
            case "scarface":
                path = "android.resource://" + getPackageName() + "/" + R.raw.scarface;
                uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.scarface);
                break;
            default:
        }

        try {
//            FileInputStream fileInputStream = new FileInputStream(path);
            mediaPlayer = new MediaPlayer();
            mediaPlayer.setDisplay(surfaceHolder);
            mediaPlayer.setDataSource(this, uri);
            mediaPlayer.prepare();
            mediaPlayer.setOnPreparedListener(this);
            mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }
}
