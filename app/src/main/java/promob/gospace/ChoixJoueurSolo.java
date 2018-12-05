package promob.gospace;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

import promob.gospace.Jeu_touch.PageDebSoucoupe;
import promob.gospace.Pilotage.LancementJeuPilotage;
import promob.gospace.Pilotage.PageDebPilotage;
import promob.gospace.QCM.GameActivity;
import promob.gospace.Accelerometer.PageDebAccelerometer;


    public class ChoixJoueurSolo extends AppCompatActivity {


    private Button jeuTouch;
    private Button jeuAcce;
    private Button morpion;
    private Button quizz;
    private Button test;

    private VideoView video;
    private VideoView video2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choix_joueur_solo);

        jeuTouch = (Button) findViewById(R.id.jeuTouch);
        jeuAcce = (Button) findViewById(R.id.jeuAccelerometre);
        morpion = (Button) findViewById(R.id.jeuMorpion);
        quizz = (Button) findViewById(R.id.jeuQuizz);
        test = (Button) findViewById(R.id.button);

        video = (VideoView) findViewById(R.id.videoView);
        String videopath = "android.resource://" + getPackageName() + "/" + R.raw.videotouch;
        Uri uri = Uri.parse(videopath);
        video.setVideoURI(uri);
        video.start();

        video2 = (VideoView) findViewById(R.id.videoView2);
        String videopath2 = "android.resource://" + getPackageName() + "/" + R.raw.videoacce;
        Uri uri2 = Uri.parse(videopath2);
        video2.setVideoURI(uri2);
        video2.start();


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

        test.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent gameActivity = new Intent(ChoixJoueurSolo.this , PageDebPilotage.class);
                startActivity(gameActivity);
            }
        });

    }
    }

