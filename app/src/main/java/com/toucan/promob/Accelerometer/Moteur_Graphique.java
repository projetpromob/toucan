package com.toucan.promob.Accelerometer;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.toucan.promob.R;

import java.util.List;
import java.util.Random;

public class Moteur_Graphique extends SurfaceView implements SurfaceHolder.Callback {

    Fusee fusee;

    public void setFusee(Fusee pFusee) {
        this.fusee = pFusee;
    }

    SurfaceHolder mSurfaceHolder;
    DrawingThread mThread;

    private List<Planete> planetes = null;



    public void setPlanetes(List<Planete> planetes) {
        this.planetes = planetes;
    }

    Paint mPaint;

    public Moteur_Graphique(Context pContext) {
        super(pContext);
        mSurfaceHolder = getHolder();
        mSurfaceHolder.addCallback(this);
        mThread = new DrawingThread();

        mPaint = new Paint();
        mPaint.setStyle(Paint.Style.FILL);

        fusee = new Fusee();
    }

    @Override
    protected void onDraw(Canvas pCanvas) {
        // Dessiner le fond de l'écran en premier
        pCanvas.drawColor(Color.BLACK);
        if(planetes != null) {
            // Dessiner tous les blocs du labyrinthe
            for(Planete b : planetes) {
                switch(b.getType()) {
                    case LUNE:
                        Bitmap lune = BitmapFactory.decodeResource( getResources(), R.drawable.moon);
                        pCanvas.drawBitmap(lune, fusee.getWidth()*0.5f, fusee.getHeight()*0.1f, null);
                        b.setCoordX(fusee.getWidth()*0.5f);
                        b.setCoordY(fusee.getHeight()*0.1f);
                        b.setTailleX(lune.getWidth());
                        b.setTailleY(lune.getHeight());


                        break;
                    case METEORITE:
                        Bitmap meteorite = BitmapFactory.decodeResource( getResources(), R.drawable.meteor);


                        float x1 = (float) (Math.random()*0.5f)+0.3f;
                        float y1 = (float) (Math.random()*0.5f)+0.3f;

                        pCanvas.drawBitmap(meteorite, fusee.getWidth()*x1, fusee.getHeight()*y1, null);


                        b.setCoordX(fusee.getWidth()*x1);
                        b.setCoordY(fusee.getHeight()*y1);
                        b.setTailleX(meteorite.getWidth());
                        b.setTailleY(meteorite.getHeight());
                        break;

                    case TERRE:
                        mPaint.setColor(Color.BLUE);
                        break;
                }

            }
        }

        // Dessiner la Fusee
        if(fusee != null) {
            Bitmap bitmapfusee = BitmapFactory.decodeResource( getResources(), R.drawable.fusee_tintin);
            fusee.setFusee_largeur(bitmapfusee.getWidth());
            fusee.setFusee_hauteur(bitmapfusee.getHeight());

            pCanvas.drawBitmap(bitmapfusee, fusee.getX(), fusee.getY(), null);
        }
    }

    @Override
    public void surfaceChanged(SurfaceHolder pHolder, int pFormat, int pWidth, int pHeight) {
        //
    }

    @Override
    public void surfaceCreated(SurfaceHolder pHolder) {
        mThread.keepDrawing = true;
        mThread.start();
        // Quand on crée la Fusee, on lui indique les coordonnées de l'écran
        if(fusee != null ) {
            this.fusee.setHeight(getHeight());
            this.fusee.setWidth(getWidth());
        }
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

                // Pour dessiner à 50 fps
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {}
            }
        }
    }
}
