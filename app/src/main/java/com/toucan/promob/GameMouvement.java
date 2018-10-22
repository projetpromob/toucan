package com.toucan.promob;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.TextView;

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
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            return false;
        }

        @Override
        public void onLongPress(MotionEvent e) {
            gestureText.setText("onLongPress");
            Log.d("Gesture", "onLongPress");
        }

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            
            return false;
        }
    }

    public boolean onTouchEvent(MotionEvent , event){
        myGestureDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }
}
