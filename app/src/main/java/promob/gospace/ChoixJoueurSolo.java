package promob.gospace;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

import promob.gospace.Jeu_touch.PageDebSoucoupe;
import promob.gospace.QCM.GameActivity;
import promob.gospace.Accelerometer.PageDebAccelerometer;


    public class ChoixJoueurSolo extends AppCompatActivity {


    private Button jeuTouch;
    private Button jeuAcce;
    private Button morpion;
    private Button quizz;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choix_joueur_solo);

        jeuTouch = (Button) findViewById(R.id.jeuTouch);
        jeuAcce = (Button) findViewById(R.id.jeuAccelerometre);
        morpion = (Button) findViewById(R.id.jeuMorpion);
        quizz = (Button) findViewById(R.id.jeuQuizz);


        //jeuTouch.setEnabled(false);
        jeuTouch.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent gameActivity = new Intent(ChoixJoueurSolo.this , PageDebSoucoupe.class);
                startActivity(gameActivity);
            }

        });


         //Envoi vers jeu accelerometre :
        jeuAcce.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent gameActivity = new Intent(ChoixJoueurSolo.this , PageDebAccelerometer.class);
                startActivity(gameActivity);
            }

        });

        morpion.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent gameActivity = new Intent(ChoixJoueurSolo.this , Morpion.class);
                startActivity(gameActivity);
            }
        });

        quizz.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent gameActivity = new Intent(ChoixJoueurSolo.this , GameActivity.class);
                startActivity(gameActivity);
            }
        });

    }
    }

