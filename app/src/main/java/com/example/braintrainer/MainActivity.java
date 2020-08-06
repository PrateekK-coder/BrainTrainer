package com.example.braintrainer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;

public class MainActivity extends AppCompatActivity {

    Button goButton;

    ArrayList<Integer>answer=new ArrayList<Integer>();
    int location;
    TextView Result;
        int Score=0;
    int Questions;
    TextView Scoret;
    Button button0;
    Button button1;
    Button button2;
    Button button3;
    TextView sumTextView;
    TextView timer;
    Button PlayAgain;
    boolean gameactive=true;

    public void PlayAgain(View view) {
        gameactive=true;

        Score = 0;
        Questions = 0;
        timer.setText("30s");
        Scoret.setText(Integer.toString(Score) + "/" + Integer.toString(Questions));
        newQuestion();
        PlayAgain.setVisibility(View.INVISIBLE);
        new CountDownTimer(31000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {

                timer.setText(String.valueOf(millisUntilFinished / 1000) + "s");


            }

            @Override
            public void onFinish() {

                Result.setText("Its Enough For you ");
                PlayAgain.setVisibility(View.VISIBLE);



            }
        }.start();

        Result.setText("LEts Go");

    }








    public void chooseAnswer(View view){

        if (gameactive) {


            if (Integer.toString(location).equals(view.getTag().toString())) {
                Result.setText("CORRECT");
                Score++;
                Log.i("Coorect", "you got it");
            } else {
                Result.setText("Wrong Answer");
                Log.i("Wrong", ":(");

            }
            Questions++;
            Scoret.setText(Integer.toString(Score) + "/" + Integer.toString(Questions));
            newQuestion();
        }
    }



    public void start(View view){
        goButton.setVisibility(View.INVISIBLE);
        Scoret.setVisibility(View.VISIBLE);
        button0.setVisibility(View.VISIBLE);
        button1.setVisibility(View.VISIBLE);
        button2.setVisibility(View.VISIBLE);
        button3.setVisibility(View.VISIBLE);
        Result.setVisibility(View.VISIBLE);
        Scoret.setVisibility(View.VISIBLE);
        timer.setVisibility(View.VISIBLE);
        sumTextView.setVisibility(View.VISIBLE);
        Score = 0;
        Questions = 0;
        timer.setText("30s");
        Scoret.setText(Integer.toString(Score) + "/" + Integer.toString(Questions));
        newQuestion();
        PlayAgain.setVisibility(View.INVISIBLE);
        new CountDownTimer(31000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {

                timer.setText(String.valueOf(millisUntilFinished / 1000) + "s");


            }

            @Override
            public void onFinish() {

                Result.setText("Its Enough For you ");
                PlayAgain.setVisibility(View.VISIBLE);
                sumTextView.setVisibility(View.VISIBLE);




                gameactive=false;

            }
        }.start();

        Result.setText("LEts Go");

    }
            public void newQuestion(){

                Random random=new Random();

                int a=random.nextInt(21);
                int b=random.nextInt(21);
                sumTextView.setText(Integer.toString(a) + " + " + Integer.toString(b));

                location= random.nextInt(4);

                answer.clear();


                for (int i=0;i<4;i++){

                    if(i==location){

                        answer.add(a+b);
                    }

                    else{

                        int wrong=random.nextInt(41);

                        while(wrong==a+b){

                            wrong=random.nextInt(41);
                        }

                        answer.add(wrong);
                    }

                }


                button0.setText(Integer.toString(answer.get(0)));
                button1.setText(Integer.toString(answer.get(1)));
                button2.setText(Integer.toString(answer.get(2)));
                button3.setText(Integer.toString(answer.get(3)));



            }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);











        sumTextView=findViewById(R.id.sumTextView);
        sumTextView.setVisibility(View.INVISIBLE);
        button0=findViewById(R.id.Button0);
        button0.setVisibility(View.INVISIBLE);
        button1=findViewById(R.id.button1);
        button1.setVisibility(View.INVISIBLE);
        button2=findViewById(R.id.button2);
        button2.setVisibility(View.INVISIBLE);
        button3=findViewById(R.id.button3);
        button3.setVisibility(View.INVISIBLE);

         goButton=findViewById(R.id.gobutton);
        goButton.setVisibility(View.VISIBLE);
        newQuestion();


        Result=findViewById(R.id.resultTextView);
        Result.setVisibility(View.INVISIBLE);
        Scoret=findViewById(R.id.scoreTextView);
        Scoret.setVisibility(View.INVISIBLE);
        goButton=findViewById(R.id.gobutton);

        timer=findViewById(R.id.timerTextView);
        timer.setVisibility(View.INVISIBLE);
        PlayAgain=findViewById(R.id.PlayAgain);
        PlayAgain.setVisibility(View.INVISIBLE);
       //PlayAgain(PlayAgain);
    }



}
