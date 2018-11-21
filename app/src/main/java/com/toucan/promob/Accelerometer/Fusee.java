package com.toucan.promob.Accelerometer;


import android.graphics.Color;
import android.graphics.RectF;


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


    // Couleur de la fusee
    private int mCouleur = Color.YELLOW;
    public int getCouleur() {
        return mCouleur;
    }


    public float getX() {
        return mX;
    }

    public void setPosX(float pPosX) {
        mX = pPosX;

        // Si la fusee sort du cadre, on rebondit
        if(mX < 0) {
            mX = 0;
            // Rebondir, c'est changer la direction de la balle

        } else if(mX + fusee_largeur  > mWidth ) {
            mX = mWidth - fusee_largeur;
        }
    }

    public float getY() {
        return mY;
    }

    public void setPosY(float pPosY) {
        mY = pPosY;
        if(mY < 0) {
            mY = 0;

        } else if(mY + fusee_hauteur > mHeight) {
            mY = mHeight - fusee_hauteur;
        }
    }

    // Taille de l'écran en hauteur
    private int mHeight = -1;

    public void setHeight(int pHeight) {
        this.mHeight = pHeight;
    }

    public float getHeight (){
        return mHeight;
    }

    // Taille de l'écran en largeur
    private int mWidth = -1;
    public void setWidth(int pWidth) {
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

        // Met à jour les coordonnées du rectangle de collision
        //mRectangle.set(mX - pX , mY + pY, mX - pX + fusee_largeur, mY + pY + fusee_hauteur);
    }

    // Remet la fusee à sa position de départ
    public void reset() {

        this.mX = this.getWidth()/2;
        this.mY = this.getHeight();
    }
}
