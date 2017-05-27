package com.mario22gmail.vasile.facemo;
import android.app.Activity;
import android.app.AlertDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.SparseArray;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.face.Face;
import com.google.android.gms.vision.face.FaceDetector;

import java.io.InputStream;

public class FaceDetectionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_face_detection);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);





//        com.google.android.gms.vision.face.FaceDetector detector = new com.google.android.gms.vision
//                .face.FaceDetector.Builder(getApplicationContext()).setTrackingEnabled(false)
//                .setLandmarkType(com.google.android.gms.vision.face.FaceDetector.ALL_LANDMARKS)
//                .build();
//        InputStream stream = getResources().openRawResource( R.raw.elon_musk );
//        Bitmap bm = BitmapFactory.decodeStream(stream);
////        Bitmap bm = BitmapFactory.decodeResource(getResources(), R.drawable.my_photo);
//        ImageView imgView = (ImageView) findViewById(R.id.imageViewMe);
////        Bitmap bm  = ((BitmapDrawable)imgView.getDrawable()).getBitmap();
//
//
//
//        Frame frame = new Frame.Builder().setBitmap(bm).build();
//        SparseArray<Face> faces = detector.detect(frame);
//        Bitmap mutableBitmap = bm.copy(Bitmap.Config.ARGB_8888, true);
//        Canvas canvas = new Canvas(mutableBitmap);
////        Paint paint = new Paint();
////        paint.setColor(Color.RED);
////        paint.setStyle(Paint.Style.FILL);
//        for(int i = 0; i< faces.size(); i++){
//            Face face = faces.valueAt(i);
//            for(Landmark landmark : face.getLandmarks()){
//                int cx = (int)(landmark.getPosition().x * 0.1);
//                int cy = (int) (landmark.getPosition().y * 0.1);
//                canvas. drawColor(Color.WHITE);
//                Paint paint = new Paint();
//                paint.setStyle(Paint.Style.FILL);
////                canvas.drawCircle(cx/2, cy/2 , cy/2, paint);
////                canvas.drawCircle(cx, cy, 10, paint);
//            }
//        }
//
//
//        Drawable  drawable = new BitmapDrawable(getResources(),mutableBitmap);
//        imgView.setBackground(drawable);
//
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }


    public void OnButtonPRocessClick(View view)
    {
        ImageView imgView = (ImageView) findViewById(R.id.imageViewMe);
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inMutable=true;
        InputStream stream = getResources().openRawResource(R.raw.elon_musk);
        Bitmap myBitMap = BitmapFactory.decodeStream(stream,null,options);


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
        if(!faceDetector.isOperational()){
            new AlertDialog.Builder(view.getContext()).setMessage("Could not set up the face detector!").show();
            return;
        }

        Frame frame = new Frame.Builder().setBitmap(myBitMap).build();
        SparseArray<Face> faces = faceDetector.detect(frame);

        for(int i=0; i<faces.size(); i++) {
            Face thisFace = faces.valueAt(i);
            float x1 = thisFace.getPosition().x;
            float y1 = thisFace.getPosition().y;
            float x2 = x1 + thisFace.getWidth();
            float y2 = y1 + thisFace.getHeight();
            tempCanvas.drawRoundRect(new RectF(x1, y1, x2, y2), 2, 2, myRectPaint);
        }
        imgView.setImageDrawable(new BitmapDrawable(getResources(),tempBitmap));


    }

}
