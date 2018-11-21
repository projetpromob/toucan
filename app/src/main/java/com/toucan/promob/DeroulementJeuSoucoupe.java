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
import android.media.MediaPlayer;
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

    private int starJX, starJY, starJSpeed = 20;
    private Bitmap starJ;
    //private Paint starJPaint = new Paint();

    private int starRX, starRY, starRSpeed = 10;
    //private Paint starRPaint = new Paint();
    private Bitmap starR;

    private int meteoriteX, meteoriteY, meteoriteSpeed = 25;
    //private Paint meteoritePaint = new Paint();
    private Bitmap meteorite;

    private int asteroX, asteroY, asteroSpeed = 15;
    private Bitmap astero;

    private int score, lifeCounterOfSoucoupe;

    private boolean touch = false;

    private Bitmap backgroundImage;
    private Paint scorePaint = new Paint();
    private Bitmap life[] = new Bitmap[2];

    MediaPlayer mediaPlayer;

    @SuppressLint("ResourceAsColor")
    public DeroulementJeuSoucoupe(Context context)
    {
        super(context);

        soucoupe[0] = BitmapFactory.decodeResource(getResources() , R.drawable.soucoupehomer);
        soucoupe[1] = BitmapFactory.decodeResource(getResources() , R.drawable.soucoupehomerrouge);

        backgroundImage = BitmapFactory.decodeResource(getResources() , R.drawable.fondjeu);

        starJ = BitmapFactory.decodeResource(getResources() , R.drawable.star);
        starR = BitmapFactory.decodeResource(getResources() , R.drawable.star2);
        meteorite = BitmapFactory.decodeResource(getResources() , R.drawable.aste1);
        astero = BitmapFactory.decodeResource(getResources() , R.drawable.aste2);

        scorePaint.setColor(Color.RED);
        scorePaint.setTextSize(70);
        scorePaint.setTypeface(Typeface.DEFAULT_BOLD);
        scorePaint.setAntiAlias(true);

        life[0] = BitmapFactory.decodeResource(getResources() , R.drawable.coeur);
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

        // Faire avancer starJ
        starJX = starJX - starJSpeed;

        if(ToucherObjet(starJX, starJY) || ToucherObjet(starJX  , starJY + starJ.getHeight()))
        {
            score = score + 20;

            mediaPlayer = MediaPlayer.create(getContext(), R.raw.ting);
            mediaPlayer.start();


            starJX = - 100;
        }

        if (starJX < 0)
        {
            starJX = canvasWidth + 21;
            starJY = (int) Math.floor(Math.random() * (maxSoucoupeY - minSoucoupeY)) + minSoucoupeY;
        }
        canvas.drawBitmap(starJ , starJX , starJY , null);

        starRX = starRX - starRSpeed;

        if(ToucherObjet(starRX, starRY) || ToucherObjet(starRX , starRY + starR.getHeight()))
        {
            score = score + 10;

            mediaPlayer = MediaPlayer.create(getContext(), R.raw.ting);
            mediaPlayer.start();


            starRX = - 100;
        }

        if (starRX < 0)
        {
            starRX = canvasWidth + 21;
            starRY = (int) Math.floor(Math.random() * (maxSoucoupeY - minSoucoupeY)) + minSoucoupeY;
        }
        canvas.drawBitmap(starR , starRX , starRY , null);

        meteoriteX = meteoriteX - meteoriteSpeed;

        if(ToucherObjet(meteoriteX, meteoriteY) || ToucherObjet(meteoriteX , meteoriteY + meteorite.getHeight()))
        {
            meteoriteX = - 100;
            lifeCounterOfSoucoupe--;
            mediaPlayer = MediaPlayer.create(getContext(), R.raw.explosion);
            mediaPlayer.start();


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

        asteroX = asteroX - asteroSpeed;

        if(ToucherObjet(asteroX, asteroY) || ToucherObjet(asteroX , asteroY + astero.getHeight()))
        {
            asteroX = - 100;
            lifeCounterOfSoucoupe--;
            mediaPlayer = MediaPlayer.create(getContext(), R.raw.explosion);
            mediaPlayer.start();

            if(lifeCounterOfSoucoupe == 0)
            {
                Intent gameOverIntent = new Intent(getContext() , GameOverActivity.class);
                gameOverIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

                //Récuperation du score :
                gameOverIntent.putExtra("scoreRecup", score);

                getContext().startActivity(gameOverIntent);

            }
        }

        if (asteroX < 0)
        {
            asteroX = canvasWidth + 21;
            asteroY = (int) Math.floor(Math.random() * (maxSoucoupeY - minSoucoupeY)) + minSoucoupeY;
        }
        canvas.drawBitmap(astero , asteroX , asteroY , null);

        canvas.drawText("Score : " + score, 25, 80, scorePaint );

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
