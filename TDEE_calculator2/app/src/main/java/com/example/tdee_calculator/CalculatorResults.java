package com.example.tdee_calculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class CalculatorResults extends AppCompatActivity {

    private String bmr, tdee, weightKgs = "";
    private double weightLbs = 0.0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator_results);



        TextView bmrText = findViewById(R.id.txtbmrResults);
        TextView tdeeText = findViewById(R.id.txttdeeResults);
        TextView textView = findViewById(R.id.txtOtheResults);
        Bundle bundle = getIntent().getExtras();
        bmr = bundle.getString("BMR");
        tdee = bundle.getString("TDEE");
        weightKgs = bundle.getString("weightKgs");
        weightLbs = Double.parseDouble(weightKgs) * 2.2;

        bmrText.setText("Your BMR is: " + bmr);
        tdeeText.setText("Your TDEE is: " + tdee);
        textView.setText("Now that you have your TDEE or calories to maintain your weight, below is adjustments" +
                " for you to either gain weight \nor lose weight. \n\nWe recommend staying with these results to lose weight at" +
                " \na healthy pace or gain weight with minimal fat gain.");
        Switch switchWeight = findViewById(R.id.switchWeight);

        TextView txtDescription = findViewById(R.id.txtDescription);

        txtDescription.setText("Now that you know your macros and calories, head over to see what stores are around you to" +
                "get groceries needed to achieve your results. Not sure what groceries to get? Not a problem. We can give you " +
                "recommendations for that as well.");

        MaintenanceMacroResults();

        switchWeight.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    getLosingWeightMacros();
                } else {
                    getGainingWeightMacros();
                }
            }
        });

        Button mapButton = (Button) findViewById(R.id.btnMap);
        mapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMap();
            }
        });

        Button recommendBtn = (Button) findViewById(R.id.btnRecommend);
        recommendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openRecommendations();
            }
        });
    }



    public void getLosingWeightMacros() {
        double TDEE = Double.parseDouble(tdee);
        TDEE -= 500;
        TextView calories = findViewById(R.id.txtCalories);
        calories.setText(String.valueOf(TDEE));

        int proteinMacros = (int) (weightLbs * 1); // 1g/lb of bodyweight
        TextView protein = findViewById(R.id.txtProtein);
        protein.setText(String.valueOf(proteinMacros));
        int proteinCalories = proteinMacros * 4; //get the calories from the grams of protein, 4 calories/g of protein
        TDEE -= proteinCalories; // calories left from protein

        long fatMacros = (long) (weightLbs * .4); // .4g/lb of bodyweight
        TextView fats = findViewById(R.id.txtFats);
        fats.setText(String.valueOf(fatMacros));
        double fatCalories = fatMacros * 9; // 9 calories/g of fat
        fatCalories = Math.round(fatCalories);
        TDEE -= fatCalories;

        double carbMarcos = TDEE / 4; //whatever calories are left go to carbs
        TextView carbs = findViewById(R.id.txtCarbs);
        carbs.setText(String.valueOf(carbMarcos));
    }

    public void getGainingWeightMacros() {

        double TDEE = Double.parseDouble(tdee);
        TDEE += 250;
        TextView calories = findViewById(R.id.txtCalories);
        calories.setText(String.valueOf(TDEE));

        int proteinMacros = (int) (weightLbs * .8); // .8g/lb of bodyweight since need more carbs for energy and not as much protein
        TextView protein = findViewById(R.id.txtProtein);
        protein.setText(String.valueOf(proteinMacros));
        int proteinCalories = proteinMacros * 4; //get the calories from the grams of protein, 4 calories/g of protein
        TDEE -= proteinCalories; // calories left from protein

        long fatMacros = (long) (weightLbs * .4); // .4g/lb of bodyweight
        TextView fats = findViewById(R.id.txtFats);
        fats.setText(String.valueOf(fatMacros));
        double fatCalories = fatMacros * 9; // 9 calories/g of fat
        fatCalories = Math.round(fatCalories);
        TDEE -= fatCalories;

        double carbMarcos = TDEE / 4; //whatever calories are left go to carbs
        TextView carbs = findViewById(R.id.txtCarbs);
        carbs.setText(String.valueOf(carbMarcos));
    }

    public void MaintenanceMacroResults() {
        double TDEE = Double.parseDouble(tdee);
        TextView calories = findViewById(R.id.txtCalories);
        calories.setText(String.valueOf(TDEE));

        int proteinMacros = (int) (weightLbs * 1); // 1g/lb of bodyweight
        TextView protein = findViewById(R.id.txtProtein);
        protein.setText(String.valueOf(proteinMacros));
        int proteinCalories = proteinMacros * 4; //get the calories from the grams of protein, 4 calories/g of protein
        TDEE -= proteinCalories; // calories left from protein

        long fatMacros = (long) (weightLbs * .4); // .4g/lb of bodyweight
        TextView fats = findViewById(R.id.txtFats);
        fats.setText(String.valueOf(fatMacros));
        double fatCalories = fatMacros * 9; // 9 calories/g of fat
        fatCalories = Math.round(fatCalories);
        TDEE -= fatCalories;

        double carbMarcos = TDEE / 4; //whatever calories are left go to carbs
        TextView carbs = findViewById(R.id.txtCarbs);
        carbs.setText(String.valueOf(carbMarcos));
    }

    public void openMap() {
        Intent intent = new Intent(this, Map.class);
        startActivity(intent);
    }

    public void openRecommendations() {
        Intent intent = new Intent(this, FoodRecommendations.class);
        startActivity(intent);
    }
}
