package com.example.georgi.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Defining gloobal variables for score and all of the right answers

    int score;
    private RadioButton question1;
    private RadioButton question2;
    private EditText question3;
    private RadioButton question4;
    private CheckBox question5_anwer1;
    private CheckBox question5_answer2;
    private RadioButton question6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);


        //Initializing variables
        question1 = (RadioButton) findViewById(R.id.q1_a2);
        question2 = (RadioButton) findViewById(R.id.q2_a1);
        question3 = (EditText) findViewById(R.id.answer_continent);
        question4 = (RadioButton) findViewById(R.id.q4_a2);
        question5_anwer1 = (CheckBox) findViewById(R.id.q5_a4);
        question5_answer2 = (CheckBox) findViewById(R.id.q5_a5);
        question6 = (RadioButton) findViewById(R.id.q6_a2);


    }


    /**
     * Checks if the right radioButton is clicked for Qestion 1
     * If it returns true its going to add 1 point to the score
     */
    public void checkQuestionOne() {
        if (question1.isChecked()) {
            score += 1;
        }
    }

    /**
     * Checks if the right radioButton is clicked for Qestion 2
     * If it returns true its going to add 1 point to the score
     */
    public void checkQuestionTwo() {
        if (question2.isChecked()) {
            score += 1;
        }
    }


    /**
     * This method checks the EditText value that we have entered
     * first we initalize a String valuable to compare it with rightAnswer
     * then we initialize a new string that contains the value from the EditText using the getText() method
     * if the if function returns true that both strings are correct it adds 1 point to the score
     * <p>
     * we use equalsIgnorecase(String) so that the result it is not case sensitive
     */
    public void checkQuestionThree() {
        String rightAnswer = "Europe";
        String continent = question3.getText().toString();
        if (continent.equalsIgnoreCase(rightAnswer)) {
            score += 1;
        }
    }


    /**
     * Checks if the right radioButton is clicked for Qestion 1
     * If it returns true its going to add 1 point to the score
     */
    public void checkQuestionFour() {
        if (question4.isChecked()) {
            score += 1;
        }
    }


    /**
     * First if function checks the first right Checkbox is clicked
     * If it returns true its going to add 1 point to the score
     * Second if function checks the second right Checkbox is clicked
     * If it returns true its going to add 1 point to the score
     * <p>
     * Both funstions execute independely from one another
     */
    public void checkQuestionFive() {
        if (question5_anwer1.isChecked()) {
            score += 1;
        }

        if (question5_answer2.isChecked()) {
            score += 1;
        }
    }


    /**
     * Checks if the right radioButton is clicked for Qestion 6
     * If it returns true its going to add 1 point to the score
     */
    public void checkQuestionSix() {
        if (question6.isChecked()) {
            score += 1;
        }
    }


    /**
     * This method calls all the checkQuestion methods initalized before and displays a Toast message with the result
     * the if else function is used to display a diffrent message
     * <p>
     * we declare the score to euaal 0
     * so that if the submit button is pressed it would not add all the right answers again
     * but it would start adding from 0 again
     */
    public void submitAnswers(View view) {
        score = 0;
        checkQuestionOne();
        checkQuestionTwo();
        checkQuestionThree();
        checkQuestionFour();
        checkQuestionFive();
        checkQuestionSix();

        if (score == 7) {
            Toast toast = Toast.makeText(this, getString(R.string.fullscore), Toast.LENGTH_LONG);
            toast.show();
        } else {
            Toast toast = Toast.makeText(this, getString(R.string.results_start) + score + getString(R.string.results_end), Toast.LENGTH_LONG);
            toast.show();
        }
    }
}




