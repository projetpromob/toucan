package promob.gospace.Jeu_Attaque;

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
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import java.util.Date;
import java.util.logging.Handler;

import javax.security.auth.login.LoginException;

import promob.gospace.R;


public class DeroulementJeuAttaque extends View
{

    private Bitmap at1;
    private Bitmap at3;
    private Bitmap at4;
    private Bitmap at5;

    private float atbon1X;
    private float atbon1Y;

    private float atbon2X;
    private float atbon2Y;

    private Bitmap atmauvais;

    private float atmauvaisX;
    private float atmauvaisY;

    private int canvasWidth, canvasHeight;

    private int score, lifeAttaque;

    private Bitmap backgroundImage;
    private Paint scorePaint = new Paint();
    private Bitmap life[] = new Bitmap[2];

    private float randomx1;
    private float randomy1;
    private float randomx2;
    private float randomy2;
    private float randomx3;
    private float randomy3;

    private int i;
    private int choix;
    private int choix2;


    @SuppressLint("ResourceAsColor")
    public DeroulementJeuAttaque(Context context)
    {
        super(context);


        at1 = BitmapFactory.decodeResource(getResources(),R.drawable.at1);
        atmauvais = BitmapFactory.decodeResource(getResources(),R.drawable.at2);
        at3 = BitmapFactory.decodeResource(getResources(),R.drawable.at3);
        at4 = BitmapFactory.decodeResource(getResources(),R.drawable.at4);
        at5 = BitmapFactory.decodeResource(getResources(),R.drawable.at5);

        backgroundImage = BitmapFactory.decodeResource(getResources() , R.drawable.fondkmodif);

        scorePaint.setColor(Color.RED);
        scorePaint.setTextSize(70);
        scorePaint.setTypeface(Typeface.DEFAULT_BOLD);
        scorePaint.setAntiAlias(true);

        life[0] = BitmapFactory.decodeResource(getResources() , R.drawable.coeur);

        score = 0;
        lifeAttaque = 6;

    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);

        canvasWidth = canvas.getWidth();
        canvasHeight = canvas.getHeight();

        canvas.drawBitmap(backgroundImage, 0, 0, null);

        // Faire apparâitre un objet aléatoirement


       choix = 0 + (int)(Math.random() * ((3 - 0) + 1));
       choix2 = 0 + (int)(Math.random() * ((4 - 0) + 1));


        randomx1 = (float) (Math.random()*(0.8f));
        atbon1X = randomx1*canvasWidth;
        randomy1 = (float) (Math.random()*0.6f)+0.2f;
        atbon1Y = randomy1*(canvasHeight/2);

        randomx3 = (float) (Math.random()*(0.8f));

        atbon2X = randomx3*canvasWidth;

        randomy3 = (float) (Math.random()*0.6f)+0.2f;

        atbon2Y = randomy3*canvasHeight;


        switch (choix) {
        case 0:
            canvas.drawBitmap(at1, atbon1X, atbon1Y, null);
            break;
            case 1:
                canvas.drawBitmap(at3, atbon1X, atbon1Y, null);
                break;
            case 2:
                canvas.drawBitmap(at4, atbon1X, atbon1Y, null);
                break;
            case 3:
                canvas.drawBitmap(at5, atbon1X, atbon1Y, null);
                default:
                    break;

        }
/*
        switch (choix2) {
            case 0:
                canvas.drawBitmap(at1, atbon2X, atbon2Y, null);
                break;
            case 1:
                canvas.drawBitmap(at3, atbon2X, atbon2Y, null);
                break;
            case 2:
                canvas.drawBitmap(at4, atbon2X, atbon2Y, null);
                break;
            case 3:
                canvas.drawBitmap(at5, atbon2X, atbon2Y, null);
            case 4:
                canvas.drawBitmap(atmauvais, atbon2X, atbon2Y, null);
                break;
            default:
                break;

        }*/


        // Objet mauvais :

        if (i%2 == 0) {

            randomx2 = (float) (Math.random() * (0.8f));
            atmauvaisX = randomx2 * canvasWidth;

            randomy2 = (float) (Math.random() * 0.6f) + 0.2f;

            atmauvaisY = randomy2 * canvasHeight;

            canvas.drawBitmap(atmauvais, atmauvaisX, atmauvaisY, null);
        }
        i= i+1;


        canvas.drawText("Score : " + score, 25, 80, scorePaint );

        if(lifeAttaque == 6){
            for(int i=0; i<3; i++)
            {
                int x = (int) (650 + life[0].getWidth() * 1.5 * i);
                int y = 30;
                canvas.drawBitmap(life[0],x,y,null);
            }
        }
        else if(lifeAttaque == 4){
            for(int i=0; i<2; i++)
            {
                int x = (int) (650 + life[0].getWidth() * 1.5 * i);
                int y = 30;
                canvas.drawBitmap(life[0],x,y,null);
            }
        }
        else if(lifeAttaque == 2){
            for(int i=0; i<1; i++)
            {
                int x = (int) (650 + life[0].getWidth() * 1.5 * i);
                int y = 30;
                canvas.drawBitmap(life[0],x,y,null);
            }
        }


    }



    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        float x = event.getX();
        float y = event.getY();


        if( ( ( x < ( atbon1X +at1.getWidth()) )  && (x > atbon1X) ) && ( (y>atbon1Y) && (y<(atbon1Y+at1.getHeight())) ) ){
            score = score + 5;
            Log.i("score", String.valueOf(score));
        }

        if( ( ( x < ( atbon2X +at1.getWidth()) )  && (x > atbon2X) ) && ( (y>atbon2Y) && (y<(atbon2Y+at1.getHeight())) ) ){
            score = score + 5;
            Log.i("score", String.valueOf(score));
        }

        if(x< (atmauvaisX+atmauvais.getWidth())  && x > atmauvaisX  && y>atmauvaisY  && y<(atmauvaisY+atmauvais.getHeight()) ){

            lifeAttaque--;

            if(lifeAttaque == 0)
            {
                Intent gameOverIntent = new Intent(getContext() , GameOverAttaque.class);
                gameOverIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

                //Récuperation du score :
                gameOverIntent.putExtra("scoreRecup", score);

                getContext().startActivity(gameOverIntent);

            }
        }

        return true;
    }
}
