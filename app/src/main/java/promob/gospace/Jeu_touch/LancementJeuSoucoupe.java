package promob.gospace.Jeu_touch;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import promob.gospace.Jeu_Attaque.DeroulementJeuAttaque;
import promob.gospace.MainActivity;
import promob.gospace.R;

import java.util.Timer;
import java.util.TimerTask;

public class LancementJeuSoucoupe extends AppCompatActivity
{

    private DeroulementJeuSoucoupe gameView;
    private Handler handler = new Handler();
    private final static long Interval = 30;

    MediaPlayer mediaPlayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.music);
        mediaPlayer.start();



        gameView = new DeroulementJeuSoucoupe(this);
        setContentView(gameView);

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run()
            {
                handler.post(new Runnable() {
                    @Override
                    public void run()
                    {
                        gameView.invalidate();
                    }
                });
                // Il faut invalidate pour redessiner et refaire appel a onDraw
                // invalidate permet les changements d'etat
                // handler effectue les calculs pour ensuite mettre à jour l'interface graphique
            }
        }, 0, Interval);

    }

    @Override
    public void onBackPressed() {

        Intent gameActivity = new Intent(LancementJeuSoucoupe.this, MainActivity.class);
        startActivity(gameActivity);
    }
}
