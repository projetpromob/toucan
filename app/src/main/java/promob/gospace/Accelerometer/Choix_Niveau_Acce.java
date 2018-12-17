package promob.gospace.Accelerometer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import promob.gospace.ChoixJoueurSolo;
import promob.gospace.R;

public class Choix_Niveau_Acce extends AppCompatActivity {

    private Button facile;
    private Button difficile;
    private Button extreme;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choix__niveau__acce);

        facile = (Button) findViewById(R.id.facile);
        difficile = (Button) findViewById(R.id.difficile);
        extreme = (Button) findViewById(R.id.extreme);



        facile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(Choix_Niveau_Acce.this, PageDebAccelerometer.class);
                i.putExtra("niveau","facile");
                startActivity(i);

            }
        });

        difficile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(Choix_Niveau_Acce.this, PageDebAccelerometer.class);
                i.putExtra("niveau","difficile");
                startActivity(i);

            }
        });

        extreme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(Choix_Niveau_Acce.this, PageDebAccelerometer.class);
                i.putExtra("niveau","extreme");
                startActivity(i);

            }
        });


    }

    @Override
    public void onBackPressed() {

        Intent gameActivity = new Intent(Choix_Niveau_Acce.this, ChoixJoueurSolo.class);
        startActivity(gameActivity);
    }
}
