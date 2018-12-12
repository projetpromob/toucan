package promob.gospace.Tape;

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

import promob.gospace.R;


public class DeroulementTape extends View
{


    @SuppressLint("ResourceAsColor")
    public DeroulementTape(Context context)
    {
        super(context);

    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);


    }

    // Fonction pour savoir quand la soucoupe touche les objets
    public boolean ToucherObjet(int x, int y)
    {
    return true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
    return true;
    }
}
