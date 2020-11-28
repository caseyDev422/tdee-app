package com.example.tdee_calculator;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class CalculatorResults extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator_results);

        TextView bmrText = findViewById(R.id.txtbmrResults);
        TextView tdeeText = findViewById(R.id.txttdeeResults);
        Bundle bundle = getIntent().getExtras();
        String bmr = bundle.getString("BMR");
        String tdee = bundle.getString("TDEE");


        bmrText.setText("Your BMR is: " + bmr);
        tdeeText.setText("Your TDEE is: " + tdee);




    }
}
