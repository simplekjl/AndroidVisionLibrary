package com.example.android.emojify;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.util.SparseArray;
import android.widget.Toast;
import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.face.Face;
import com.google.android.gms.vision.face.FaceDetector;

public class Emojifier {

    private static final String TAG = Emojifier.class.getName();
    public static void detectFaces(Context context, Bitmap mResultsBitmap) {

        FaceDetector detector = new FaceDetector.Builder(context)
                .setTrackingEnabled(false)
                .setLandmarkType(FaceDetector.ALL_CLASSIFICATIONS)
                .build();

        Frame frame = new Frame.Builder().setBitmap(mResultsBitmap).build();

        SparseArray<Face> faces = detector.detect(frame);

        Log.d(TAG, "detectFaces: "+faces.size());
        if(faces.size() ==0){
            Toast.makeText(context, "No faces detected", Toast.LENGTH_SHORT).show();
        }

        detector.release();
    }
}
