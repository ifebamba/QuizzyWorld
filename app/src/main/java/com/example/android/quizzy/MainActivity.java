package com.example.android.quizzy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkQuiz();


    }


    /**
     * Calculate the score
     * //     * @param score is the current score of the user in the quiz initialized to zero
     * //     * @param ankaraChecked checks if the user selected Ankara
     * //     * @param buddhaChecked checks if the user selected buddha
     * //     * @param obamaChecked checks if the user selected obama
     * //      *@param kentuckyName checks if the user typed in kentucky
     * //       *@param rupeeChecked checks if the user selected rupee
     * //       *@param uranusYes, jupiterYes, kratosYes, genusYes are boolean values set to check what selections user made for question 4
     */


    private int calculateScore() {
        int score = 0;


        RadioButton q1a1 = findViewById(R.id.ankara);
        boolean ankaraChecked = q1a1.isChecked();
        // add 1 to score if user selected Ankara

        if (ankaraChecked) {
            score = score + 1;
        } else {
            score = score;
        }

        RadioButton q2a2 = findViewById(R.id.buddhism);
        boolean buddhaChecked = q2a2.isChecked();
        // add 1 to score if user selected buddhism

        if (buddhaChecked) {
            score = score + 1;
        } else {
            score = score;
        }


        RadioButton q3a2 = findViewById(R.id.obama);
        boolean obamaChecked = q3a2.isChecked();
        // add 1 to score if user selected obama

        if (obamaChecked) {
            score = score + 1;
        } else {
            score = score;
        }

        CheckBox q4op1 = findViewById(R.id.uranus);
        boolean uranusYes = q4op1.isChecked();

        CheckBox q4op2 = findViewById(R.id.jupiter);
        boolean jupiterYes = q4op2.isChecked();

        CheckBox q4op3 = findViewById(R.id.kratos);
        boolean kratosYes = q4op3.isChecked();

        CheckBox q4op4 = findViewById(R.id.genus);
        boolean genusYes = q4op4.isChecked();


        // checks of the two correct options: Uranus and Jupiter are checked, then adds to score

        if (uranusYes && jupiterYes && kratosYes && genusYes) {
            score = score;
        }

        if (uranusYes && jupiterYes && genusYes) {
            score = score;
        } else if (uranusYes && jupiterYes && kratosYes) {
            score = score;
        } else if (uranusYes && jupiterYes) {
            score = score + 1;
        }


        // checks if user correctly typed in KENTUCKY and then adds 1 to the current score

        EditText kentuckyName = findViewById(R.id.questionFive);
        if (kentuckyName.getText().toString().equalsIgnoreCase("Kentucky")) {

            score = score + 1;
        } else {
            score = score;
        }

        // add 1 to score if user selected rupee

        RadioButton q6a1 = findViewById(R.id.rupee);
        boolean rupeeChecked = q3a2.isChecked();

        if (rupeeChecked) {
            score = score + 1;
        } else {
            score = score;
        }

        return score;


    }


    /**
     * this method checks that all fields in the quiz are completely filled
     **/


    public void checkQuiz() {

        EditText nameField = findViewById(R.id.name_field);
        RadioGroup q1 = findViewById(R.id.capitalOfTurkey);
        RadioGroup q2 = findViewById(R.id.religionDalai);
        RadioGroup q3 = findViewById(R.id.firstBlackPresident);

        CheckBox q4op1 = findViewById(R.id.uranus);
        boolean uranusYes = q4op1.isChecked();


        CheckBox q4op2 = findViewById(R.id.jupiter);
        boolean jupiterYes = q4op2.isChecked();

        CheckBox q4op3 = findViewById(R.id.kratos);
        boolean kratosYes = q4op3.isChecked();

        CheckBox q4op4 = findViewById(R.id.genus);
        boolean genusYes = q4op4.isChecked();

        EditText q5 = findViewById(R.id.questionFive);

        RadioGroup q6 = findViewById(R.id.currencyOfIndia);

        //check that Name was answered

        if (nameField.getText().toString().length() == 0) {

            Toast.makeText(getApplicationContext(), "Please Enter Your Name", Toast.LENGTH_LONG).show();
            return;


        }


        //check that question 1 was answered

        if (q1.getCheckedRadioButtonId() == -1) {
            Toast.makeText(getApplicationContext(), "Please Select an option in Question 1", Toast.LENGTH_LONG).show();
            return;
        }

        //check that question 2 was answered

        if (q2.getCheckedRadioButtonId() == -1) {
            Toast.makeText(getApplicationContext(), "Please Select an option in Question 2", Toast.LENGTH_LONG).show();
            return;
        }

        //check that question 3 was answered

        if (q3.getCheckedRadioButtonId() == -1) {
            Toast.makeText(getApplicationContext(), "Please Select an option in Question 3", Toast.LENGTH_LONG).show();
            return;
        }


        //check that question 4 was answered

        if (!uranusYes && !jupiterYes && !kratosYes && !genusYes) {
            Toast.makeText(getApplicationContext(), "Please Answer Question 4", Toast.LENGTH_LONG).show();
            return;
        }

        //check that question 5 was answered
        if (q5.getText().toString().length() == 0) {

            Toast.makeText(getApplicationContext(), "Question 5 has not been answered", Toast.LENGTH_LONG).show();
            return;
        }

        //check that question 6 was answered
        if (q6.getCheckedRadioButtonId() == -1) {
            Toast.makeText(getApplicationContext(), "Please answer the last question", Toast.LENGTH_LONG).show();
            return;
        }


    }


    /**
     * This method is called whenever the Score Quiz button is pressed and calculates the score
     */

    public void gradeQuiz(View view) {

        EditText nameField = (EditText) findViewById(R.id.name_field);
        String nameValue = nameField.getText().toString();
        RadioGroup q1 = findViewById(R.id.capitalOfTurkey);
        RadioGroup q2 = findViewById(R.id.religionDalai);
        RadioGroup q3 = findViewById(R.id.firstBlackPresident);
        EditText q5 = findViewById(R.id.questionFive);
        RadioGroup q6 = findViewById(R.id.currencyOfIndia);

        // Execute checkQuiz method - This step checks if all fields are filled before calculating and displaying the score
        checkQuiz();


        if (nameField.getText().toString().length() != 0 && q1.getCheckedRadioButtonId() != -1 && q2.getCheckedRadioButtonId() != -1 && q3.getCheckedRadioButtonId() != -1 && q5.getText().toString().length() != 0 && q6.getCheckedRadioButtonId() != -1) {

            calculateScore();
            Toast.makeText(getApplicationContext(), "Thanks for taking the Quiz " + nameValue + "," + "\nYour Score is " + calculateScore() + "/6", Toast.LENGTH_LONG).show();
            return;


        }



    }


    /**
     * This method clears all the filled in fields in the quiz when the user hits the Reset Quiz button
     **/

    public void clearQuiz(View view) {

        //name field reset
        EditText nameField = findViewById(R.id.name_field);
        nameField.setText("");

        //question one reset
        RadioGroup qOne = findViewById(R.id.capitalOfTurkey);
        qOne.clearCheck();

        //question two reset
        RadioGroup qTwo = findViewById(R.id.religionDalai);
        qTwo.clearCheck();

        //question three reset

        RadioGroup qThree = findViewById(R.id.firstBlackPresident);
        qThree.clearCheck();

        //question four reset
        // planet checkboxes reset

        CheckBox planetTwo = findViewById(R.id.uranus);
        planetTwo.setChecked(false);

        CheckBox planetThree = findViewById(R.id.jupiter);
        planetThree.setChecked(false);

        CheckBox planetFour = findViewById(R.id.kratos);
        planetFour.setChecked(false);

        CheckBox planetOne = findViewById(R.id.genus);
        planetOne.setChecked(false);


        // question five reset

        EditText qFive = findViewById(R.id.questionFive);
        qFive.setText("");


        // question six reset

        RadioGroup qSix = findViewById(R.id.currencyOfIndia);
        qSix.clearCheck();

    }



}
