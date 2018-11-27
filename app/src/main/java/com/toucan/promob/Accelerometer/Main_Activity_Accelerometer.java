package com.toucan.promob.Accelerometer;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.toucan.promob.MainActivity_PD;

import java.util.List;

public class Main_Activity_Accelerometer extends Activity {
    // Identifiant de la boîte de dialogue de victoire
    public static final int VICTORY_DIALOG = 0;
    // Identifiant de la boîte de dialogue de défaite
    public static final int DEFEAT_DIALOG = 1;

    private long chrono_debut;
    private long chrono_fin;

    private float time;

    // Le moteur graphique du jeu
    private Moteur_Graphique mView = null;
    // Le moteur physique du jeu
    private Moteur_Physique mEngine = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Fusee b = new Fusee();

        mView = new Moteur_Graphique(this);
        mView.setFusee(b);

        mEngine = new Moteur_Physique(this);

        mEngine.setFusee(b);

        setContentView(mView);

        List<Planete> mList = mEngine.create_game();
        mView.setPlanetes(mList);

        chrono_debut = new java.util.Date().getTime();



    }

    @Override
    protected void onResume() {
        super.onResume();
        chrono_debut = new java.util.Date().getTime();

        mEngine.resume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mEngine.stop();
    }

    @Override
    public Dialog onCreateDialog (int id) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        chrono_fin = new java.util.Date().getTime() ;
        time = chrono_fin - chrono_debut;

        float result_time = time/1000;

        Integer score_time = (int) (long) ((1/result_time)*100);

        Integer final_time = (score_time * score_time)*2 ;


        Log.i("DEBUG", String.valueOf(score_time));



        switch(id) {
            case VICTORY_DIALOG:
                builder.setCancelable(false)
                        .setMessage("Votre fusée vient d'atterir ! \nScore : " + final_time)
                        .setTitle("Gagné")
                        .setNeutralButton("Suivant", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // L'utilisateur peut recommencer s'il le veut
                                Intent gameActivity = new Intent(Main_Activity_Accelerometer.this, MainActivity_PD.class);
                                startActivity(gameActivity);


                            }
                        });
                break;

            case DEFEAT_DIALOG:
                builder.setCancelable(false)
                        .setMessage("Vous avez explosé votre fusée")
                        .setTitle(" Perdu !")
                        .setNeutralButton("Recommencer", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                mEngine.reset();
                                mEngine.resume();
                            }
                        });
        }
        return builder.create();
    }

    @Override
    public void onPrepareDialog (int id, Dialog box) {
        // A chaque fois qu'une boîte de dialogue est lancée, on arrête le moteur physique

        mEngine.stop();
    }
}