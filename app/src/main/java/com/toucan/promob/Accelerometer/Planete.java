package com.toucan.promob.Accelerometer;

import android.graphics.Bitmap;
import android.graphics.RectF;

public class Planete {
    enum  Type { LUNE, METEORITE, TERRE };

    private Type mType = null;
    private RectF mRectangle = null;

    private Bitmap bitmapPlanete;

    private float coordX;
    private float coordY;

    private float tailleX;
    private float tailleY;

    public void setCoordX(float x){
        coordX = x;
    }

    public float getCoordX(){
        return coordX;
    }

    public void setCoordY(float y){
        coordY = y;
    }

    public float getCoordY(){
        return coordY;
    }

    public void setTailleX(float x){
        tailleX = x;
    }

    public float getTailleX(){
        return tailleX;
    }

    public void setTailleY(float y){
        tailleY = y;
    }

    public float getTailleY(){
        return tailleY;
    }







    public Type getType() {
        return mType;
    }

    public String getStringType() {
        return mType.toString();
    }



    public RectF getRectangle() {
        return mRectangle;
    }

    public Planete(Type pType) {
        this.mType = pType;
    }
}

