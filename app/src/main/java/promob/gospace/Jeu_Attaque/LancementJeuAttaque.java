package promob.gospace.Jeu_Attaque;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import promob.gospace.ChoixJoueurSolo;
import promob.gospace.MainActivity;
import promob.gospace.R;

import java.util.Timer;
import java.util.TimerTask;

public class LancementJeuAttaque extends AppCompatActivity
{

    private DeroulementJeuAttaque gameView;
    private Handler handler = new Handler();
    private final static long Interval = 1500;

    MediaPlayer mediaPlayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.music);
        mediaPlayer.start();



        gameView = new DeroulementJeuAttaque(this);
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

        Intent gameActivity = new Intent(LancementJeuAttaque.this, ChoixJoueurSolo.class);
        startActivity(gameActivity);
    }
}
