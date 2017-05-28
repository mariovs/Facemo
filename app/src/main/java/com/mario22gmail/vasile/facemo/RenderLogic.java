package com.mario22gmail.vasile.facemo;

import android.graphics.Bitmap;
import android.util.Log;

import org.opencv.android.OpenCVLoader;
import org.opencv.android.Utils;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Rect;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;
import org.opencv.videoio.VideoCapture;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * Created by mario on 28/05/2017.
 */

public class RenderLogic {

}

//    public void RenderFunction(){
//        ArrayList<Rect> returnFacesList = new ArrayList<Rect>();
//
////        Mat replaceFace = new Mat()
//
//        String face_cascade_name = "haarcascade_frontalface_alt.xml";
//        String eyes_cascade_name = "haarcascade_eye_tree_eyeglasses.xml";
//
//        CascadeClassifier face_cascade = new CascadeClassifier();
//        CascadeClassifier eyes_cascade = new CascadeClassifier();
//        String window_name = "Capture - Face detection";
//
//        String path = "android.resource://" + "com.mario22gmail.vasile.facemo"+ "/" + R.raw.godfather;
//
//        VideoCapture capture = new VideoCapture(path);
//
//        ArrayList<Mat> frameList = new ArrayList<>();
//
//        Mat userFrame = new Mat();
//        Mat videoFrame = new Mat();
//        int no_frames = 0;
//
//        if(! face_cascade.load(face_cascade_name))
//        {
//            Log.e("MERROR", "errorLoading");
//            return;
//        }
//
//        if(! eyes_cascade.load(eyes_cascade_name))
//        {
//            Log.e("MERROR", "errorLoading");
//            return;
//        }
//
//        try{
//            userFrame = Utils.loadResource(this,R.raw.elon_musk, CvType.CV_8UC4);
//        }catch (Exception e)
//        {
//            Log.e("MERROR", "error load map");
//        }
//        if(capture.isOpened())
//        {
//            while (no_frames < 1000)
//            {
//                no_frames++;
//                Log.i("MMM", no_frames + " ");
//                capture.read(videoFrame);
//                frameList.add(videoFrame);
//            }
//
//            if(!frameList.isEmpty()){
//
//            }
//        }
//
//
//    }

//    public List<Rect> ReturnFaces(Mat frame){
//        List<Rect> faces = new ArrayList<>();
//        Mat frame_Gray = new Mat();
//        Mat faceOriginal = new Mat();
//
//        Bitmap b = Utils.bitmapToMat(b,frame);
//
//        Mat tmp = new Mat (b.getWidth(), b.getHeight(), CvType.CV_8UC1);
//        Utils.bitmapToMat(b, tmp);
//        Imgproc.cvtColor(tmp, tmp, Imgproc.COLOR_RGB2GRAY);
////there could be some processing
//        Imgproc.cvtColor(tmp, tmp, Imgproc.COLOR_GRAY2RGB, 4);
//        Utils.matToBitmap(tmp, b);
//
//
//
//    }
//
//    public void DetectAndDisplay(Mat frameUser, Mat frameVideo){
//
//    }
