package promob.gospace.Aventure;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import promob.gospace.R;

public class PageDeb extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_deb);

        Thread thread = new Thread()
        {
            @Override
            public void run()
            {
                try
                {
                    // Affichage de l'introduction du jeu pendant un temps donné :
                    sleep(1500);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
                finally
                {
                    Intent mainIntent = new Intent(PageDeb.this , Quizz1.class);
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
