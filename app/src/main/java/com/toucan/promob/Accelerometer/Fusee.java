package com.toucan.promob.Accelerometer;


import android.graphics.Color;
import android.graphics.RectF;
import android.util.Log;


public class Fusee {
    // Rayon de la fusee

    private float fusee_largeur;
    private float fusee_hauteur;

    public void setFusee_largeur(float fusee_largeur) {
        this.fusee_largeur = fusee_largeur;
    }

    public void setFusee_hauteur(float fusee_hauteur) {
        this.fusee_hauteur = fusee_hauteur;
    }

    public float getFusee_largeur() {
        return this.fusee_largeur;
    }

    public float getFusee_hauteur() {
        return this.fusee_hauteur;
    }

    // Coordonnées en x
    private float mX;

    // Coordonnées en y
    private float mY;


    public float getX() {
        return mX;
    }

    private void setPosX(float pPosX) {
        mX = pPosX;

        // Si la fusee sort du cadre, on rebondit
        if(mX < 0) {
            mX = 0;
            // Rebondir, c'est changer la direction de la fusée

        } else if(mX + fusee_largeur  > mWidth ) {
            mX = mWidth - fusee_largeur;
        }
    }

    public float getY() {
        return mY;
    }

    private void setPosY(float pPosY) {
        mY = pPosY;
        if(mY < 0) {
            mY = 0;

        } else if(mY + fusee_hauteur > mHeight) {
            mY = mHeight - fusee_hauteur;
        }
    }

    // Taille de l'écran en hauteur
    private float mHeight;

    public void setHeight(float pHeight) {
        this.mHeight = pHeight;
    }

    public float getHeight (){
        return mHeight;
    }

    // Taille de l'écran en largeur
    private float mWidth;
    public void setWidth(float pWidth) {
        this.mWidth = pWidth;
    }

    public float getWidth (){
        return mWidth;
    }

    public Fusee() {

    }

    // Mettre à jour les coordonnées de la fusee
    public void putXAndY(float pX, float pY) {

        setPosX(mX - pX);
        setPosY(mY + pY);

    }

    // Remet la fusee à sa position de départ
    public void reset() {

        this.mX = this.getWidth()/2 - this.getFusee_largeur()/2;
        this.mY = this.getHeight();
    }
}
