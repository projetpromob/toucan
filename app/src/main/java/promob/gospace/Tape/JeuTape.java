package promob.gospace.Tape;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Date;

import promob.gospace.Jeu_touch.GameOverActivity;
import promob.gospace.R;

import static promob.gospace.R.*;
import static promob.gospace.R.color.colorAccent;
import static promob.gospace.R.color.colorPrimary;

public class JeuTape extends AppCompatActivity implements View.OnClickListener {

    //Tableau a deux dimensions
    //plateau[colonne][ligne]
    // 0 : case vide
    // 1 : X
    // 2 : O
    private int plateau[][] = new int[3][3];

    // 1 : X
    // 2 : O
    private int joueurEnCours = 1;

    private TextView tvJoueur;

    private ArrayList<Button> all_buttons = new ArrayList<>();

    private int nombreAleatoire;
    private boolean gameover = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_jeu_tape);

        tvJoueur = (TextView) findViewById(id.joueur);

        // Récuperation des boutons

        Button bt1 = (Button) findViewById(id.bt1);
        Button bt2 = (Button) findViewById(id.bt2);
        Button bt3 = (Button) findViewById(id.bt3);
        Button bt4 = (Button) findViewById(id.bt4);
        Button bt5 = (Button) findViewById(id.bt5);
        Button bt6 = (Button) findViewById(id.bt6);
        Button bt7 = (Button) findViewById(id.bt7);
        Button bt8 = (Button) findViewById(id.bt8);
        Button bt9 = (Button) findViewById(id.bt9);

        View l1 = (View) findViewById(id.line1);
        View l2 = (View) findViewById(id.line2);
        View l3 = (View) findViewById(id.line3);
        View l4 = (View) findViewById(id.line4);


        //Suppression des lignes :
        l1.setBackgroundDrawable(null);
        l2.setBackgroundDrawable(null);
        l3.setBackgroundDrawable(null);
        l4.setBackgroundDrawable(null);

        // Ajout des boutons dans l'ArrayList :

        all_buttons.add(bt1);
        all_buttons.add(bt2);
        all_buttons.add(bt3);
        all_buttons.add(bt4);
        all_buttons.add(bt5);
        all_buttons.add(bt6);
        all_buttons.add(bt7);
        all_buttons.add(bt8);
        all_buttons.add(bt9);

        // On retire le fond des boutons :

        /*for (Button bt : all_buttons) {
            bt.setBackgroundDrawable(null);
            bt.setOnClickListener(this);
        }*/


        nombreAleatoire = 1 + (int)(Math.random() * ((9 - 1) + 1));
        Change(nombreAleatoire);

        //Change(1);


    }


    private void attente(int nbSecondes){
        int attente = nbSecondes*1000;
        Date date = new Date();
        long debut = date.getTime();
        long somme = debut + attente;
        while(debut<somme){
            date = new Date();
            debut = date.getTime();
        }
    }



    @SuppressLint("ResourceAsColor")
    public void Change(int nbAl){
        switch (nbAl) {
            case 1:
                all_buttons.get(0).setBackgroundColor(colorAccent);
                break;
            case 2:
                all_buttons.get(1).setBackgroundColor(colorAccent);
                break;
            case 3:
                all_buttons.get(2).setBackgroundColor(colorAccent);
                break;
            case 4:
                all_buttons.get(3).setBackgroundColor(colorAccent);
                break;
            case 5:
                all_buttons.get(4).setBackgroundColor(colorAccent);
                break;
            case 6:
                all_buttons.get(5).setBackgroundColor(colorAccent);
                break;
            case 7:
                all_buttons.get(6).setBackgroundColor(colorAccent);
                break;
            case 8:
                all_buttons.get(7).setBackgroundColor(colorAccent);
                break;
            case 9:
                all_buttons.get(8).setBackgroundColor(colorAccent);
                break;
            default:
        }


    }

    @Override
    public void onClick(View v) {

    }
}
