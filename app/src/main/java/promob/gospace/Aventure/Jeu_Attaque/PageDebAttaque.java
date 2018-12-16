package promob.gospace.Aventure.Jeu_Attaque;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import promob.gospace.Jeu_Attaque.DeroulementJeuAttaque;
import promob.gospace.MainActivity;
import promob.gospace.R;

public class PageDebAttaque extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_deb_attaque);

        Intent callingIntent = getIntent();
        int scoreprec = callingIntent.getIntExtra("scoresoucoupe",0);

        SharedPreferences prefs = getSharedPreferences("myPrefsKey", Context.MODE_PRIVATE);
        int scores = prefs.getInt("key", 0); //0 is the default value

        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt("key", scores + scoreprec);
        editor.commit();

        Log.i("DEBUG",String.valueOf(scores+ scoreprec));


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

        Intent gameActivity = new Intent(PageDebAttaque.this, MainActivity.class);
        startActivity(gameActivity);
    }
}
