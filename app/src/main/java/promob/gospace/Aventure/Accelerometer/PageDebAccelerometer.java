package promob.gospace.Aventure.Accelerometer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import promob.gospace.R;

public class PageDebAccelerometer extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_deb_accelerometer);

        Intent callingIntent = getIntent();

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
                    Intent mainIntent = new Intent(PageDebAccelerometer.this , promob.gospace.Aventure.Accelerometer.Main_Activity_Accelerometer.class);
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
}
