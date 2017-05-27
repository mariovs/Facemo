package com.mario22gmail.vasile.facemo;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.os.Bundle;
import android.support.annotation.IntDef;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.face.Face;
import com.google.android.gms.vision.face.FaceDetector;

import java.io.InputStream;

public class FaceDetectionActivity extends AppCompatActivity {
    private String errorTag = "MMM_ERROR";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_face_detection);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

    public void FaceDetection(ImageView imageView, InputStream imageStream)
    {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inMutable = true;
        Bitmap myBitMap = BitmapFactory.decodeStream(imageStream, null, options);


        Paint myRectPaint = new Paint();
        myRectPaint.setStrokeWidth(5);
        myRectPaint.setColor(Color.RED);
        myRectPaint.setStyle(Paint.Style.STROKE);

        Bitmap tempBitmap = Bitmap.createBitmap(myBitMap.getWidth(), myBitMap.getHeight(), Bitmap.Config.RGB_565);
        Canvas tempCanvas = new Canvas(tempBitmap);
        tempCanvas.drawBitmap(myBitMap, 0, 0, null);


        com.google.android.gms.vision.face.FaceDetector faceDetector = new
                FaceDetector.Builder(getApplicationContext()).setTrackingEnabled(false)
                .build();
        if (!faceDetector.isOperational()) {
            new AlertDialog.Builder(imageView.getContext()).setMessage("Could not set up the face detector!").show();
            return;
        }

        Frame frame = new Frame.Builder().setBitmap(myBitMap).build();
        SparseArray<Face> faces = faceDetector.detect(frame);

        for (int i = 0; i < faces.size(); i++) {
            Face thisFace = faces.valueAt(i);
            float x1 = thisFace.getPosition().x;
            float y1 = thisFace.getPosition().y;
            float x2 = x1 + thisFace.getWidth();
            float y2 = y1 + thisFace.getHeight();
            tempCanvas.drawRoundRect(new RectF(x1, y1, x2, y2), 2, 2, myRectPaint);
        }
        imageView.setImageDrawable(new BitmapDrawable(getResources(), tempBitmap));


    }

    public void OnButtonPRocessClick(View view) {



        ImageView imgView = (ImageView) findViewById(R.id.imageViewMe);
        InputStream stream = getResources().openRawResource(R.raw.elon_musk);
        FaceDetection(imgView, stream);

        ImageView imgView2 = (ImageView) findViewById(R.id.imageViewTarget);
        InputStream stream2 = getResources().openRawResource(R.raw.paul_graham);
        FaceDetection(imgView2, stream2);



//        Bitmap myBitMap = BitmapFactory.decodeStream(stream, null, options);
//
//
//
//        Paint myRectPaint = new Paint();
//        myRectPaint.setStrokeWidth(5);
//        myRectPaint.setColor(Color.RED);
//        myRectPaint.setStyle(Paint.Style.STROKE);
//
//        Bitmap tempBitmap = Bitmap.createBitmap(myBitMap.getWidth(), myBitMap.getHeight(), Bitmap.Config.RGB_565);
//        Canvas tempCanvas = new Canvas(tempBitmap);
//        tempCanvas.drawBitmap(myBitMap, 0, 0, null);
//
//
//        com.google.android.gms.vision.face.FaceDetector faceDetector = new
//                FaceDetector.Builder(getApplicationContext()).setTrackingEnabled(false)
//                .build();
//        if (!faceDetector.isOperational()) {
//            new AlertDialog.Builder(view.getContext()).setMessage("Could not set up the face detector!").show();
//            return;
//        }
//
//        Frame frame = new Frame.Builder().setBitmap(myBitMap).build();
//        SparseArray<Face> faces = faceDetector.detect(frame);
//
//        for (int i = 0; i < faces.size(); i++) {
//            Face thisFace = faces.valueAt(i);
//            float x1 = thisFace.getPosition().x;
//            float y1 = thisFace.getPosition().y;
//            float x2 = x1 + thisFace.getWidth();
//            float y2 = y1 + thisFace.getHeight();
//            tempCanvas.drawRoundRect(new RectF(x1, y1, x2, y2), 2, 2, myRectPaint);
//        }
//        imgView.setImageDrawable(new BitmapDrawable(getResources(), tempBitmap));
//
//
//        ImageView imageTarget = (ImageView) findViewById(R.id.imageViewTarget);
//        InputStream streamPaul = getResources().openRawResource(R.raw.paul_graham);
//        Bitmap myBitMapPaul = BitmapFactory.decodeStream(streamPaul, null, options);
//
//
//        Paint myRectPaintPaul = new Paint();
//        myRectPaintPaul.setStrokeWidth(5);
//        myRectPaintPaul.setColor(Color.RED);
//        myRectPaintPaul.setStyle(Paint.Style.STROKE);
//
//        tempBitmap = Bitmap.createBitmap(myBitMapPaul.getWidth(), myBitMapPaul.getHeight(), Bitmap.Config.RGB_565);
//        tempCanvas.drawBitmap(myBitMapPaul, 0, 0, null);
//
//
//        if (!faceDetector.isOperational()) {
//            new AlertDialog.Builder(view.getContext()).setMessage("Could not set up the face detector!").show();
//            return;
//        }
//
//        Frame framePaul = new Frame.Builder().setBitmap(myBitMapPaul).build();
//        SparseArray<Face> facesPaul = faceDetector.detect(framePaul);
//
//        for (int i = 0; i < facesPaul.size(); i++) {
//            Face thisFace = faces.valueAt(i);
//            float x1 = thisFace.getPosition().x;
//            float y1 = thisFace.getPosition().y;
//            float x2 = x1 + thisFace.getWidth();
//            float y2 = y1 + thisFace.getHeight();
//            tempCanvas.drawRoundRect(new RectF(x1, y1, x2, y2), 2, 2, myRectPaint);
//        }
//        imageTarget.setImageDrawable(new BitmapDrawable(getResources(), tempBitmap));
//
//        InputStream stream = getResources().openRawResource(R.raw.elon_musk);

    }

}

