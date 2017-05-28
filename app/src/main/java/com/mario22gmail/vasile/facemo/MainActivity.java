package com.mario22gmail.vasile.facemo;

import android.graphics.Bitmap;
import android.media.AudioManager;
import android.media.FaceDetector;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.ImageView;
import android.widget.VideoView;

import org.opencv.android.OpenCVLoader;

import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import wseemann.media.FFmpegMediaMetadataRetriever;

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

    Bitmap bitmap;

    @Override
    protected void onResume() {
        super.onResume();
        try {
            Handler handler = new Handler(getMainLooper()){
                @Override
                public void handleMessage(Message msg) {
                    super.handleMessage(msg);

//            mmr.setDataSource(uri);
//            mmr.setDataSource(path);


//        mmr.setDataSource(this, uri);
//            String path2 = "android.resource://" + getPackageName() + "/" + R.raw.godfather;

                }
            };



        }catch (Exception e)
        {
            e.printStackTrace();
        }



    }

    public void ClickOnMe(View view){
        ImageView imgView = (ImageView) findViewById(R.id.imageViewForMovie);
        imgView.setImageBitmap(bitmap);
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

//
//        String  path3 = "android.resource://" + getPackageName() + "/" + "raw"+ "/" + "gladiator.mp4";
//
//        FFmpegMediaMetadataRetriever mmr = new FFmpegMediaMetadataRetriever();
//        Uri uri2 = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.elon_musk);
//        mmr.setDataSource(path3);
//        mmr.extractMetadata(FFmpegMediaMetadataRetriever.METADATA_KEY_ALBUM);
//        mmr.extractMetadata(FFmpegMediaMetadataRetriever.METADATA_KEY_ARTIST);
//        Bitmap b = mmr.getFrameAtTime(2000000, FFmpegMediaMetadataRetriever.OPTION_CLOSEST); // frame at 2 seconds
//        byte[] artwork = mmr.getEmbeddedPicture();
//        bitmap = b;
//        ImageView imgView = (ImageView) findViewById(R.id.imageViewForMovie);
//        imgView.setImageBitmap(b);
//
//        mmr.release();
//        try {
//            FileInputStream fileInputStream = new FileInputStream(path);
//            mediaPlayer = new MediaPlayer();
//            mediaPlayer.setDisplay(surfaceHolder);
//            mediaPlayer.setDataSource(this, uri);
//            mediaPlayer.prepare();
//            mediaPlayer.setOnPreparedListener(this);
//            mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);

//        } catch (IOException e) {
//            e.printStackTrace();
//        }


    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }
}
