package com.example.android.mangaquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;


/**
 * This app quizzes the user on their manga knowledge.
 */
public class MainActivity extends AppCompatActivity {

    private EditText name;
    private EditText enteredCharName;
    private int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This function checks if the correct answers are chosen, calculates total scores,
     * displays a toast message that shows the user's name and the final result,
     * and resets the score after the toast message is displayed.
     */
    public void showResult(View view) {

        // Check if the right radio buttons are selected and then calculate points accordingly.
        RadioButton q1Answer = (RadioButton) findViewById(R.id.ans1c);
        RadioButton q2Answer = (RadioButton) findViewById(R.id.ans2e);
        RadioButton q3Answer = (RadioButton) findViewById(R.id.ans3a);
        RadioButton q5Answer = (RadioButton) findViewById(R.id.ans5b);
        RadioButton q6Answer = (RadioButton) findViewById(R.id.ans6a);

        if (q1Answer.isChecked()) {
            score += 5;
        }
        if (q2Answer.isChecked()) {
            score += 5;
        }
        if (q3Answer.isChecked()) {
            score += 5;
        }
        if (q5Answer.isChecked()) {
            score += 5;
        }
        if (q6Answer.isChecked()) {
            score += 5;
        }

        // Check if the right checkboxes are selected. Each right checkbox is 1 point.
        // (Hint: All boxes are correct. Toriyama is the source of Goku's power.)
        CheckBox q4AnswerA = findViewById(R.id.ans4a);
        CheckBox q4AnswerB = findViewById(R.id.ans4b);
        CheckBox q4AnswerC = findViewById(R.id.ans4c);
        CheckBox q4AnswerD = findViewById(R.id.ans4d);
        CheckBox q4AnswerE = findViewById(R.id.ans4e);

        if (q4AnswerA.isChecked()) {
            score++;
        }
        if (q4AnswerB.isChecked()) {
            score++;
        }
        if (q4AnswerC.isChecked()) {
            score++;
        }
        if (q4AnswerD.isChecked()) {
            score++;
        }
        if (q4AnswerE.isChecked()) {
            score++;
        }

        enteredCharName = (EditText) findViewById(R.id.ans7); // Get entered character's name
        String charName = enteredCharName.getText().toString(); // Convert to string
        if (charName.equalsIgnoreCase(getString(R.string.charName))) {
            score += 5;
        }

        name = (EditText) findViewById(R.id.userName); // Get user's name

        if (score == 35) {
            Toast toast = Toast.makeText(this, getString(R.string.hello)
                    + name.getText().toString() + getString(R.string.youGot) + score
                    + getString(R.string.over30) + getString(R.string.congrats), Toast.LENGTH_LONG);
            toast.show(); // Display toast message for perfect score.
            score = 0; // Reset score after the toast message is already displayed.

        } else {
            Toast toast = Toast.makeText(this, getString(R.string.hello)
                    + name.getText().toString() + getString(R.string.youGot) + score
                    + getString(R.string.over30) + getString(R.string.retry), Toast.LENGTH_LONG);
            toast.show(); // Display toast message and ask if the user wants to play again.
            score = 0; // Reset score after the toast message is already displayed.
        }
    }
}