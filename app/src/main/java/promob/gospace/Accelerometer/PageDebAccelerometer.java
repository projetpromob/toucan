package promob.gospace.Accelerometer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import promob.gospace.ChoixJoueurSolo;
import promob.gospace.R;

public class PageDebAccelerometer extends AppCompatActivity {

    private String reponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_deb_accelerometer);

        Intent callingIntent = getIntent();
        reponse = callingIntent.getStringExtra("niveau");



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
                    Intent mainIntent = new Intent(PageDebAccelerometer.this , Main_Activity_Accelerometer.class);
                    mainIntent.putExtra("niveau",reponse);
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

        Intent gameActivity = new Intent(PageDebAccelerometer.this, ChoixJoueurSolo.class);
        startActivity(gameActivity);
    }
}
