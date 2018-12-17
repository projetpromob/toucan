package promob.gospace.Jeu_Attaque;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import promob.gospace.Accelerometer.Choix_Niveau_Acce;
import promob.gospace.ChoixJoueurSolo;
import promob.gospace.R;

public class PageDebAttaque extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_deb_attaque);

        Thread thread = new Thread()
        {
            @Override
            public void run()
            {
                try
                {
                    // Affichage de l'introduction du jeu pendant un temps donné :
                    sleep(3500);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
                finally
                {
                    Intent mainIntent = new Intent(PageDebAttaque.this , LancementJeuAttaque.class);
                    startActivity(mainIntent);
                }
            }
        };

        thread.start();
    }

    @Override
    protected void onPause()
    {
        super.onPause();
        finish();
    }

    @Override
    public void onBackPressed() {

        Intent gameActivity = new Intent(PageDebAttaque.this, ChoixJoueurSolo.class);
        startActivity(gameActivity);
    }
}
