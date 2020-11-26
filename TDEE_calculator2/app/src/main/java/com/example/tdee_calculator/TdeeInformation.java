package com.example.tdee_calculator;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class TdeeInformation extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tdee_info);

        TextView info = findViewById(R.id.txtInfo);

        info.setText("TDEE stands for Total Daily Energy Expenditure. The TDEE is composed of three parts:\n" +
                "BMR-Basal Metabolic Rate\n TEF-Thermic effect of Food\n Physical activity including exercise and NEAT\n");
    }
}
