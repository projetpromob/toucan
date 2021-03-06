package promob.gospace;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

import promob.gospace.Accelerometer.Choix_Niveau_Acce;
import promob.gospace.Jeu_Attaque.DeroulementJeuAttaque;
import promob.gospace.Jeu_Attaque.PageDebAttaque;
import promob.gospace.Jeu_touch.PageDebSoucoupe;
import promob.gospace.QCM.GameActivity;
import promob.gospace.Accelerometer.PageDebAccelerometer;


public class ChoixJoueurSolo extends AppCompatActivity {


    private Button jeuTouch;
    private Button jeuAcce;
    private Button planete;
    private Button quizz;
    private Button aventure;

    private VideoView video;
    private VideoView video2;
    private VideoView video3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choix_joueur_solo);

        jeuTouch = (Button) findViewById(R.id.jeuTouch);
        jeuAcce = (Button) findViewById(R.id.jeuAccelerometre);
        planete = (Button) findViewById(R.id.jeuPlanete);
        quizz = (Button) findViewById(R.id.jeuQuizz);
        aventure = (Button) findViewById(R.id.aventuresolo);

        video = (VideoView) findViewById(R.id.videoView);
        String videopath = "android.resource://" + getPackageName() + "/" + R.raw.videotouchre;
        Uri uri = Uri.parse(videopath);
        video.setVideoURI(uri);
        video.start();

        video2 = (VideoView) findViewById(R.id.videoView2);
        String videopath2 = "android.resource://" + getPackageName() + "/" + R.raw.videoaccere;
        Uri uri2 = Uri.parse(videopath2);
        video2.setVideoURI(uri2);
        video2.start();

        video3 = (VideoView) findViewById(R.id.videoView3);
        String videopath3 = "android.resource://" + getPackageName() + "/" + R.raw.videoplan;
        Uri uri3 = Uri.parse(videopath3);
        video3.setVideoURI(uri3);
        video3.start();


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
                Intent gameActivity = new Intent(ChoixJoueurSolo.this , Choix_Niveau_Acce.class);
                startActivity(gameActivity);
            }

        });

        planete.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent gameActivity = new Intent(ChoixJoueurSolo.this , PageDebAttaque.class);
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

        aventure.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent gameActivity = new Intent(ChoixJoueurSolo.this , promob.gospace.Aventure_solo.PageDeb.class);
                startActivity(gameActivity);
            }
        });

    }

    @Override
    public void onBackPressed() {

        Intent gameActivity = new Intent(ChoixJoueurSolo.this, MainActivity.class);
        startActivity(gameActivity);
    }

    }

