package com.toucan.promob;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;


public class DeroulementJeuSoucoupe extends View
{

    private Bitmap soucoupe[] = new Bitmap[2];


    private int soucoupeX = 10;
    private int soucoupeY;
    private int soucoupeSpeed;

    private int canvasWidth, canvasHeight;

    private int homerX, homerY, homerSpeed = 10;
    private Bitmap homer;
    //private Paint homerPaint = new Paint();

    private int martienX, martienY, martienSpeed = 20;
    //private Paint martienPaint = new Paint();
    private Bitmap martien;

    private int meteoriteX, meteoriteY, meteoriteSpeed = 25;
    //private Paint meteoritePaint = new Paint();
    private Bitmap meteorite;

    private int score, lifeCounterOfSoucoupe;

    private boolean touch = false;

    private Bitmap backgroundImage;
    private Paint scorePaint = new Paint();
    private Bitmap life[] = new Bitmap[2];

    @SuppressLint("ResourceAsColor")
    public DeroulementJeuSoucoupe(Context context)
    {
        super(context);

        soucoupe[0] = BitmapFactory.decodeResource(getResources() , R.drawable.soucoupehomer);
        soucoupe[1] = BitmapFactory.decodeResource(getResources() , R.drawable.soucoupehomerrouge);

        backgroundImage = BitmapFactory.decodeResource(getResources() , R.drawable.fondsimpson);

        homer = BitmapFactory.decodeResource(getResources() , R.drawable.homer);

        martien = BitmapFactory.decodeResource(getResources() , R.drawable.martien);

        meteorite = BitmapFactory.decodeResource(getResources() , R.drawable.meteo);

        scorePaint.setColor(Color.RED);
        scorePaint.setTextSize(70);
        scorePaint.setTypeface(Typeface.DEFAULT_BOLD);
        scorePaint.setAntiAlias(true);

        life[0] = BitmapFactory.decodeResource(getResources() , R.drawable.hearts);
        //life[1] = BitmapFactory.decodeResource(getResources() , R.drawable.blanc);

        soucoupeY = 550;
        score = 0;
        lifeCounterOfSoucoupe = 3;

    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);

        canvasWidth = canvas.getWidth();
        canvasHeight = canvas.getHeight();

        canvas.drawBitmap(backgroundImage, 0, 0, null);

        // Gérer juqu'ou monte la soucoupe
        int minSoucoupeY = soucoupe[0].getHeight();

        // Gérer jusqu'ou la soucoupe va en bas:
        int maxSoucoupeY = canvasHeight - soucoupe[0].getHeight() * 2;
        soucoupeY = soucoupeY + soucoupeSpeed;

        // Pour qu'il ne sorte pas du décor :
        if (soucoupeY < minSoucoupeY)
        {
            soucoupeY = minSoucoupeY;
        }
        if (soucoupeY > maxSoucoupeY)
        {
            soucoupeY = maxSoucoupeY;
        }

        soucoupeSpeed = soucoupeSpeed + 2;

        if (touch)
        {
            canvas.drawBitmap(soucoupe[1], soucoupeX, soucoupeY, null);
            touch = false;
        }
        else
        {
            canvas.drawBitmap(soucoupe[0], soucoupeX, soucoupeY, null);
        }

        // Faire avancer homer
        homerX = homerX - homerSpeed;

        if(ToucherObjet(homerX, homerY) || ToucherObjet(homerX  , homerY + homer.getHeight()))
        {
            score = score + 20;
            homerX = - 100;
        }

        if (homerX < 0)
        {
            homerX = canvasWidth + 21;
            homerY = (int) Math.floor(Math.random() * (maxSoucoupeY - minSoucoupeY)) + minSoucoupeY;
        }
        canvas.drawBitmap(homer , homerX , homerY , null);

        martienX = martienX - martienSpeed;

        if(ToucherObjet(martienX, martienY) || ToucherObjet(martienX , martienY + martien.getHeight()))
        {
            score = score + 10;
            martienX = - 100;
        }

        if (martienX < 0)
        {
            martienX = canvasWidth + 21;
            martienY = (int) Math.floor(Math.random() * (maxSoucoupeY - minSoucoupeY)) + minSoucoupeY;
        }
        canvas.drawBitmap(martien , martienX , martienY , null);


        meteoriteX = meteoriteX - meteoriteSpeed;

        if(ToucherObjet(meteoriteX, meteoriteY) || ToucherObjet(meteoriteX , meteoriteY + meteorite.getHeight()))
        {
            meteoriteX = - 100;
            lifeCounterOfSoucoupe--;

            if(lifeCounterOfSoucoupe == 0)
            {
                Intent gameOverIntent = new Intent(getContext() , GameOverActivity.class);
                gameOverIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

                //Récuperation du score :
                gameOverIntent.putExtra("scoreRecup", score);

                getContext().startActivity(gameOverIntent);

            }
        }

        if (meteoriteX < 0)
        {
            meteoriteX = canvasWidth + 21;
            meteoriteY = (int) Math.floor(Math.random() * (maxSoucoupeY - minSoucoupeY)) + minSoucoupeY;
        }
        canvas.drawBitmap(meteorite , meteoriteX , meteoriteY , null);

        canvas.drawText("Score : " + score, 20, 80, scorePaint );

        for(int i=0; i<3; i++)
        {
            // gérer la position des coeurs de vies :
            int x = (int) (650 + life[0].getWidth() * 1.5 * i);
            int y = 30;

            if(i < lifeCounterOfSoucoupe)
            {
                canvas.drawBitmap(life[0], x, y, null);
            }
            else
            {
                //canvas.drawBitmap(life[1], x, y, null);
            }
        }

    }

    // Fonction pour savoir quand la soucoupe touche les objets
    public boolean ToucherObjet(int x, int y)
    {
        if(soucoupeX < x && x < (soucoupeX + soucoupe[0].getWidth()) && soucoupeY<y && y< (soucoupeY + soucoupe[0].getHeight()))
        {
            return true;
        }
        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        if (event.getAction() == MotionEvent.ACTION_DOWN)
        {
            touch = true;

            soucoupeSpeed = -22;
        }
        return true;
    }
}
