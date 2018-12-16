package promob.gospace.Aventure.Jeu_Attaque;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;

import promob.gospace.R;

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
}
