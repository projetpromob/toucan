package com.toucan.promob.Accelerometer;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;

import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.toucan.promob.R;

import java.util.List;
import java.util.Random;

public class Moteur_Graphique extends SurfaceView implements SurfaceHolder.Callback {

    Fusee fusee;

    Bitmap bitmapfusee = BitmapFactory.decodeResource( getResources(), R.drawable.fusee_tintin);


    public void setFusee(Fusee pFusee) {
        this.fusee = pFusee;
        fusee.setFusee_largeur(bitmapfusee.getWidth());
        fusee.setFusee_hauteur(bitmapfusee.getHeight());
    }

    SurfaceHolder mSurfaceHolder;
    DrawingThread mThread;

    private List<Planete> planetes = null;

    public void setPlanetes(List<Planete> planetes) {
        this.planetes = planetes;
    }

    public Moteur_Graphique(Context pContext) {
        super(pContext);
        mSurfaceHolder = getHolder();
        mSurfaceHolder.addCallback(this);
        mThread = new DrawingThread();
        fusee = new Fusee();
        fusee.reset();

    }

    @Override
    protected void onDraw(Canvas pCanvas) {
        // Dessiner le fond de l'écran en premier
        Bitmap background = BitmapFactory.decodeResource( getResources(), R.drawable.background);

        pCanvas.drawBitmap(background,0,0,null);

        if(planetes != null) {
            // Dessiner tous les blocs du labyrinthe
            for(Planete b : planetes) {
                switch(b.getType()) {
                    case LUNE:
                        Bitmap lune = BitmapFactory.decodeResource( getResources(), R.drawable.moon);
                        pCanvas.drawBitmap(lune, fusee.getWidth()*b.getRandomx1(), fusee.getHeight()*0.1f, null);
                        b.setCoordX(fusee.getWidth()*b.getRandomx1());
                        b.setCoordY(fusee.getHeight()*0.1f);
                        b.setTailleX(lune.getWidth());
                        b.setTailleY(lune.getHeight());


                        break;
                    case METEORITE:
                        Bitmap meteorite = BitmapFactory.decodeResource( getResources(), R.drawable.meteor);

                        pCanvas.drawBitmap(meteorite, fusee.getWidth()*b.getRandomx1(), fusee.getHeight()*b.getRandomy1(), null);


                        b.setCoordX(fusee.getWidth()*b.getRandomx1());
                        b.setCoordY(fusee.getHeight()*b.getRandomy1());
                        b.setTailleX(meteorite.getWidth());
                        b.setTailleY(meteorite.getHeight());
                        break;

                    case TERRE:

                        Bitmap earth = BitmapFactory.decodeResource(getResources(), R.drawable.earth);

                        pCanvas.drawBitmap(earth, (getWidth()/2)-(earth.getWidth()/2), getHeight()-earth.getHeight(), null);



                        break;
                }

            }
        }

        // Dessiner la Fusee
        if(fusee != null) {
            //Log.i("DEBUG",  String.valueOf(fusee.getWidth()) + " |-| " + String.valueOf(fusee.getHeight()));

            pCanvas.drawBitmap(bitmapfusee, fusee.getX(), fusee.getY(), null);
        }
    }

    @Override
    public void surfaceChanged(SurfaceHolder pHolder, int pFormat, int pWidth, int pHeight) {
        //
    }

    @Override
    public void surfaceCreated(SurfaceHolder pHolder) {

        if(fusee != null ) {
            this.fusee.setHeight(getHeight());
            this.fusee.setWidth(getWidth());

            this.fusee.reset();
        }

        mThread.keepDrawing = true;
        mThread.start();
        // Quand on crée la Fusee, on lui indique les coordonnées de l'écran

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder pHolder) {
        mThread.keepDrawing = false;
        boolean retry = true;
        while (retry) {
            try {
                mThread.join();
                retry = false;
            } catch (InterruptedException e) {}
        }

    }

    private class DrawingThread extends Thread {
        boolean keepDrawing = true;

        @SuppressLint("WrongCall")
        @Override
        public void run() {
            Canvas canvas;
            while (keepDrawing) {
                canvas = null;

                try {
                    canvas = mSurfaceHolder.lockCanvas();
                    synchronized (mSurfaceHolder) {
                        onDraw(canvas);
                    }
                } finally {
                    if (canvas != null)
                        mSurfaceHolder.unlockCanvasAndPost(canvas);
                }

                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {}
            }
        }
    }
}