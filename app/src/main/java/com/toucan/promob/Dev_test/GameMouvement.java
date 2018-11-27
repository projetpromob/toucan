package com.toucan.promob.Dev_test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.TextView;

import com.toucan.promob.R;

public class GameMouvement extends AppCompatActivity {

    private TextView gestureText;
    private GestureDetector myGestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_mouvement);

        gestureText = (TextView) findViewById(R.id.tvGesture);
        AndroidGestureDetector androidGestureDetector = new AndroidGestureDetector();
        myGestureDetector = new GestureDetector(GameMouvement.this , androidGestureDetector);

    }
    class AndroidGestureDetector implements GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener{

        @Override
        public boolean onSingleTapConfirmed(MotionEvent e) {
            gestureText.setText("onSingleTapConfirmed");
            Log.d("Gesture", "onSingleTapConfirmed");
            return false;
        }

        @Override
        public boolean onDoubleTap(MotionEvent e) {
            gestureText.setText("onDoubleTap");
            Log.d("Gesture", "onDoubleTap");
            return false;
        }

        @Override
        public boolean onDoubleTapEvent(MotionEvent e) {
            gestureText.setText("onDoubleTapEvent");
            Log.d("Gesture", "onDoubleTapEvent");
            return false;
        }

        @Override
        public boolean onDown(MotionEvent e) {
            gestureText.setText("onDown");
            Log.d("Gesture", "onDown");
            return false;
        }

        @Override
        public void onShowPress(MotionEvent e) {
            gestureText.setText("onShowPress");
            Log.d("Gesture", "onShowPress");

        }

        @Override
        public boolean onSingleTapUp(MotionEvent e) {
            gestureText.setText("onSingleTapUp");
            Log.d("Gesture", "onSingleTapUp");
            return false;
        }

        @Override
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float distanceX, float distanceY) {
            gestureText.setText("onScroll");
            if(motionEvent.getX() < motionEvent1.getX()){
                Log.d ("Gesture" , "Left to Right Scroll: " + motionEvent.getX() + " - " + motionEvent1.getX());
                Log.d ("Speed " , String.valueOf(distanceX) + " pixels/second");
            }
            if(motionEvent.getX() > motionEvent1.getX()){
                Log.d ("Gesture" , "Right to Left Scroll: " + motionEvent.getX() + " - " + motionEvent1.getX());
                Log.d ("Speed " , String.valueOf(distanceX) + " pixels/second");
            }
            if(motionEvent.getY() < motionEvent1.getY()){
                Log.d ("Gesture" , "Up to Down Scroll: " + motionEvent.getY() + " - " + motionEvent1.getY());
                Log.d ("Speed " , String.valueOf(distanceY) + " pixels/second");
            }
            if(motionEvent.getY() > motionEvent1.getY()){
                Log.d ("Gesture" , "Down to Up Scroll: " + motionEvent.getY() + " - " + motionEvent1.getY());
                Log.d ("Speed " , String.valueOf(distanceY) + " pixels/second");
            }

            return false;
        }

        @Override
        public void onLongPress(MotionEvent motionEvent) {
            gestureText.setText("onLongPress");
            Log.d("Gesture", "onLongPress");
        }

        @Override
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
            gestureText.setText("onFling");
            if(motionEvent.getX() < motionEvent1.getX()){
                Log.d ("Gesture" , "Left to Right Fling: " + motionEvent.getX() + " - " + motionEvent1.getX());
                Log.d ("Speed " , String.valueOf(v) + " pixels/second");
            }
            if(motionEvent.getX() > motionEvent1.getX()){
                Log.d ("Gesture" , "Right to Left Fling: " + motionEvent.getX() + " - " + motionEvent1.getX());
                Log.d ("Speed " , String.valueOf(v) + " pixels/second");
            }
            if(motionEvent.getY() < motionEvent1.getY()){
                Log.d ("Gesture" , "Up to Down Fling: " + motionEvent.getY() + " - " + motionEvent1.getY());
                Log.d ("Speed " , String.valueOf(v1) + " pixels/second");
            }
            if(motionEvent.getY() > motionEvent1.getY()){
                Log.d ("Gesture" , "Down to Up Fling: " + motionEvent.getY() + " - " + motionEvent1.getY());
                Log.d ("Speed " , String.valueOf(v1) + " pixels/second");
            }

            return false;
        }
    }

    public boolean onTouchEvent(MotionEvent  event){
        myGestureDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
        
    }
}
