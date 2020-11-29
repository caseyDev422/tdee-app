package com.example.tdee_calculator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class TdeeCalculator extends AppCompatActivity {

    private double tdee,bf,BMR = 0.0;
    private long weightKgs;
    private int age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator);

        Button button = findViewById(R.id.btnCalculate);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText textBf = findViewById(R.id.txtBodyFat);
                String stringBf = textBf.getText().toString();

                if (stringBf.matches("")) {
                    harrisBenedictEquation();
                } else {
                    mullerEquation();
                }
            }
        });

    }

    public void mullerEquation() {

        RadioButton female = (RadioButton) findViewById(R.id.rdBtnFemale);
        RadioButton male = (RadioButton) findViewById(R.id.rdBtnMale);
        RadioButton radioButton = (RadioButton) findViewById(R.id.rdioCheck);
        EditText textAge = findViewById(R.id.txtAge);
        TextView textView = findViewById(R.id.txtGender);
        EditText textWeight = findViewById(R.id.txtWeight);
        String weightLbs = textWeight.getText().toString();
        EditText textBf = findViewById(R.id.txtBodyFat);

        String stringBf = textBf.getText().toString();
        String stringAge = textAge.getText().toString();

        if (weightLbs.matches("")) {
            textWeight.setError("Please input your weight"); }
        if (stringAge.matches("")) {
            textAge.setError("Please input your age"); }
        if (radioButton.isChecked()) {
            radioButton.setError("Please select Male or Female.");
        } else {
            age = Integer.parseInt(stringAge);
            bf = Double.parseDouble(stringBf) / 100;
            weightKgs = Math.round(Integer.parseInt(weightLbs) / 2.2);
            double fm = weightKgs * bf; //fat mass
            double lbm = weightKgs - fm; //lean body mass

            int gender = 0;
            if (female.isChecked()) {
                gender = 0;
            } else if (male.isChecked()) {
                gender = 1;
            }
            BMR = Math.round((13.587 * lbm) + (9.613 * fm) + (198 * gender) - (3.351 * age) + 674);

            tdeeResults();
            openResults();
        }


    }

    public void harrisBenedictEquation() {

        //bad practice DRY not implemented
        RadioButton female = findViewById(R.id.rdBtnFemale);
        RadioButton male = findViewById(R.id.rdBtnMale);
        RadioButton radioButton = findViewById(R.id.rdioCheck);
        EditText textAge = findViewById(R.id.txtAge);
        EditText textWeight = findViewById(R.id.txtWeight);
        EditText textHeight = findViewById(R.id.txtHeight);

        String stringAge = textAge.getText().toString();
        String heightInches = textHeight.getText().toString();
        String weightLbs = textWeight.getText().toString();

        if (weightLbs.matches("")) {
            textWeight.setError("Please input weight");
        } else if (stringAge.matches("")) {
            textAge.setError("Please input age");
        } else if (radioButton.isChecked()) {
            radioButton.setError("Please choose Male or Female");
        } else if (heightInches.matches("")) {
            textHeight.setError("Please input height");
        } else {
            age = Integer.parseInt(stringAge);
            double heightCms = Double.parseDouble(heightInches) * 2.54; // 1 in = 2.54 cms
            weightKgs = Math.round(Integer.parseInt(weightLbs) / 2.2);

            if (female.isChecked()) {
                BMR = Math.round(447.593 + (9.247 * weightKgs) + (3.098 * heightCms) - (4.330 * age));
                System.out.println("Female checked");
            } else if (male.isChecked()) {
                BMR = Math.round(88.362 + (13.397 * weightKgs) + (4.799 * heightCms) - (5.677 * age));
                System.out.println("Male checked");
            }

            tdeeResults();
            openResults();
        }
    }

    public void tdeeResults() {
        System.out.println(BMR);

        Spinner activityLvl = findViewById(R.id.spnrActivityLevel);
        String activity = (String) activityLvl.getSelectedItem();
        System.out.println(activity);

        //I feel like this could have been better implemented, but I'm not sure how.
        if (activity.matches("Sedentary")) {
            tdee = 1.2;
        } else if (activity.matches("Light Activity")) {
            tdee = 1.375;
        } else if (activity.matches("Moderate Activity")) {
            tdee = 1.55;
        } else if (activity.matches("Very Active")) {
            tdee = 1.725;
        } else if (activity.matches("Extra Active")) {
            tdee = 1.9;
        }
        tdee *= BMR;
        tdee = Math.round(tdee);
    }

    public void openResults() {
        Intent intent = new Intent(this, CalculatorResults.class);
        Bundle bundle = new Bundle();
        bundle.putString("BMR", String.valueOf(BMR));
        bundle.putString("TDEE", String.valueOf(tdee));
        bundle.putString("weightKgs", String.valueOf(weightKgs));
        intent.putExtras(bundle);
        startActivity(intent);
    }


}
