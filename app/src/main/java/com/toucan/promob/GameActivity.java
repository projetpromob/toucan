package com.toucan.promob;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;


public class GameActivity extends AppCompatActivity {

    List <List<String>> questionreponse = new ArrayList();

    private int score;

    private TextView question,resultat;
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private String answerstate;
    private int i;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        List <String> question1 = new ArrayList();
        question1.add("Qui est le directeur du PNRB");
        question1.add("Alexandre");
        question1.add("Macron");
        question1.add("Wolinski");
        question1.add("Trump");
        question1.add("Alexandre");


        questionreponse.add(question1);

        List <String> question2 = new ArrayList();
        question2.add("Qui est l'homme le plus fort de France");
        question2.add("Tony");
        question2.add("Kaelig");
        question2.add("Le Toumelin");
        question2.add("Tibo Inshape");
        question2.add("Tony");

        questionreponse.add(question2);

        List <String> question3 = new ArrayList ();
        question3.add("Quel est le meilleur prof de maths de France");
        question3.add("Mr Rompion");
        question3.add("Mr Rompion");
        question3.add("Mr Rompion");
        question3.add("Mr Rompion");
        question3.add("Mr Rompion");

        questionreponse.add(question3);

        i = 0;

        try {
            Intent callingIntent = getIntent();
            i = callingIntent.getIntExtra("i",0);

        } catch(Exception e){
            //This catch block catches all the exceptions
        }

        //System.out.println("%%%%%%%%%%%%%%%" + i );

        try{

            Intent callingIntent = getIntent();
            score = callingIntent.getIntExtra("scorevers1",0);

        } catch (Exception e){

        }

        final String answer = questionreponse.get(i).get(5);

        final TextView question = (TextView) findViewById(R.id.activity_game_question_text);
        final Button button1 = (Button) findViewById(R.id.activity_game_answer1_btn);
        final Button button2 = (Button) findViewById(R.id.activity_game_answer2_btn);
        final Button button3 = (Button) findViewById(R.id.activity_game_answer3_btn);
        final Button button4 = (Button) findViewById(R.id.activity_game_answer4_btn);

        question.setText(questionreponse.get(i).get(0));

        questionreponse.get(i).remove(0);
        questionreponse.get(i).remove(4);

        Collections.shuffle(questionreponse.get(i));

        button1.setText(questionreponse.get(i).get(0));
        button2.setText(questionreponse.get(i).get(1));
        button3.setText(questionreponse.get(i).get(2));
        button4.setText(questionreponse.get(i).get(3));

        questionreponse.remove(i);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(button1.getText()==answer){

                    answerstate = "Bonne réponse";

                }else {

                    answerstate = "Mauvaise réponse";

                }


                Intent gameActivity = new Intent(GameActivity.this, GameActivity2.class);
                gameActivity.putExtra("answer",answerstate);
                gameActivity.putExtra("i",i);
                gameActivity.putExtra("scorevers2",score);
                startActivity(gameActivity);

            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(button2.getText()==answer){

                    answerstate = "Bonne réponse";

                }else {

                    answerstate = "Mauvaise réponse";

                }

                Intent gameActivity = new Intent(GameActivity.this, GameActivity2.class);
                gameActivity.putExtra("answer",answerstate);
                gameActivity.putExtra("i",i);
                gameActivity.putExtra("scorevers2",score);
                startActivity(gameActivity);

            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(button3.getText()==answer){

                    answerstate = "Bonne réponse";

                }else {

                    answerstate = "Mauvaise réponse";

                }

                Intent gameActivity = new Intent(GameActivity.this, GameActivity2.class);
                gameActivity.putExtra("answer",answerstate);
                gameActivity.putExtra("i",i);
                gameActivity.putExtra("scorevers2",score);
                startActivity(gameActivity);

            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(button4.getText()==answer){

                    answerstate = "Bonne réponse";

                }else {

                    answerstate = "Mauvaise réponse";

                }

                Intent gameActivity = new Intent(GameActivity.this, GameActivity2.class);
                gameActivity.putExtra("answer",answerstate);
                gameActivity.putExtra("i",i);
                gameActivity.putExtra("scorevers2",score);
                startActivity(gameActivity);

            }
        });


    }
}
