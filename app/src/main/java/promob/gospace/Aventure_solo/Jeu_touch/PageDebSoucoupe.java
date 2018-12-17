package promob.gospace.Aventure_solo.Jeu_touch;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import promob.gospace.Jeu_Attaque.DeroulementJeuAttaque;
import promob.gospace.MainActivity;
import promob.gospace.R;

public class PageDebSoucoupe extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_deb_soucoupe);

        Thread thread = new Thread()
        {
            @Override
            public void run()
            {
                try
                {
                    // Affichage de l'introduction du jeu pendant un temps donné :
                    sleep(2500);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
                finally
                {
                    Intent mainIntent = new Intent(PageDebSoucoupe.this , promob.gospace.Aventure_solo.Jeu_touch.LancementJeuSoucoupe.class);
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

        Intent gameActivity = new Intent(PageDebSoucoupe.this, MainActivity.class);
        startActivity(gameActivity);
    }
}
