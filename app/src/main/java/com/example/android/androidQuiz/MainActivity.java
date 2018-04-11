package com.example.android.androidQuiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    int pay = 0;
    int Q2Answer = 50;
    int unitScore = 0;

    RadioButton a3, b3, c3, d3, a4, b4, c4, d4;
    CheckBox a1, b1, c1, d1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private int Q1() {
        int points = 0;
        a1 = findViewById(R.id.checkbox_LG);
        boolean a1correct = a1.isChecked();

        b1 = findViewById(R.id.checkbox_Samsung);
        boolean b1correct = b1.isChecked();

        if ((a1correct && b1correct)) {
            points += 1;
        }
        return points;
    }

    private int Q2() {
        int points = 0;
        if (pay == Q2Answer) {
            points += 1;
        }
        return points;
    }


//    private int Q3() {
//        int points = 0;
//
//        d3 = findViewById(R.id.radio_5lolipop);
//        boolean checked = d3.isChecked();
//        switch (d3.getId()) {
//            case R.id.radio_5lolipop:
//                if (checked)
//                    points += 1;
//                break;
//        }
//        return points;
//    }

    private int Q3() {
        int points = 0;

        d3 = findViewById(R.id.radio_5lolipop);
        boolean checked = d3.isChecked();
        switch (d3.getId()) {
            case R.id.radio_5lolipop:
                if (checked)
                    points += 1;
                break;
        }
        return points;
    }


    public int onRadioButtonClicked(View view) {
        int points = 0;
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.radio_5lolipop:
                if (checked)
                    points += 1;
                break;
        }
        return points;
    }


//    private int Q3(View view) {
//        int points = 0;
//        // Is the button now checked?
//        boolean checked = ((RadioButton) view).isChecked();
//
//        // Check which radio button was clicked
//        switch(view.getId()) {
//            case R.id.correct_answer: // this is id/krzyzyk
//                if (checked)
//                    score++;
//                // Go to next question
//                break;
//        }
//    }


    private int Q4() {
        int points = 0;

        a4 = findViewById(R.id.radio_TMobileG1);
        boolean checked = a4.isChecked();
        switch (a4.getId()) {
            case R.id.radio_TMobileG1:
                if (checked)
                    points += 1;
                break;
        }
        return points;
    }

    public void submitOrder(View view) {
        EditText nameField = findViewById(R.id.name_field);
        String name = nameField.getText().toString();

        int points = Q1() + Q2() + Q3() + Q4();
        String result = "  ";

        switch (points) {
            case 0:
            case 1:
            case 2:
                result = "\n Read up more and try again! \n Correct: " + points;
                break;
            case 3:
            case 4:
                result = "\n Awesome Job!\n Correct: " + points;
                break;
        }
        Toast.makeText(this, "Thanks for playing " + name + result, Toast.LENGTH_LONG).show();

    }

    /**
     * This method is called when the + button is clicked.
     */
    public void increment(View view) {
        if (pay == 100) {
            Toast.makeText(getApplicationContext(), "Max 100!", Toast.LENGTH_SHORT).show();
            return;
        }
        pay = pay + 10;
        displayPay(pay);
    }

    /**
     * This method is called when the - button is clicked.
     */
    public void decrement(View view) {
        if (pay == 10) {
            Toast.makeText(getApplicationContext(), "Hint: It wasn't Free :)", Toast.LENGTH_SHORT).show();
            return;
        }
        pay = pay - 10;
        displayPay(pay);

    }

    /**
     * This method displays the given pay value on the screen.
     */
    private void displayPay(int quantity) {
        TextView quantityTextView = findViewById(R.id.textView_pay);
        quantityTextView.setText("" + pay);
    }
}
