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
                "BMR-Basal Metabolic Rate\n TEF-Thermic effect of Food\n Physical activity including exercise and NEAT\n\n" +
                "Your BMR is the basal rate of calories that allows you to basically live.\n The TEF is the energy it takes" +
                "to digest food.\n NEAT (Non-exercise activity thermogenesis) is a fancy way of saying our unconscious movements." +
                "\n This would be movements that we don't really notice we do, but still do them. Examples of this could be twitching," +
                "blinking, and typing. Your NEAT gets adjusted without even being noticed when you are losing or gaining weight.  \n" +
                "Once you have your estimation of your TDEE, you can manipulate this to gain or lose weight.");
    }
}
