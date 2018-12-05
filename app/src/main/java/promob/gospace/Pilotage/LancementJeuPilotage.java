package promob.gospace.Pilotage;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.Timer;
import java.util.TimerTask;

public class LancementJeuPilotage extends AppCompatActivity
{

    private JeuPilotage gameView;
    private Handler handler = new Handler();
    private final static long Interval = 30;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        gameView = new JeuPilotage(this);
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
