package com.example.tdee_calculator;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class FoodRecommendations extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.food_recommendations);

        TextView textView = findViewById(R.id.txtFoodRecmd);
        TextView Foods = findViewById(R.id.txtFood);

        textView.setText("Here are some foods for you that can help you get started to achieving your goals." +
                "You don't have to necessarily eat just these types of foods to achieve your results, but can " +
                "help with micronutrients and satiation. You can still technically whatever you want achieve your respected goals. \n" +
                "Remember, these are just recommendations. You can eat whatever you want or to whatever type of diet (keto, balanced, etc). \n" +
                "Always make sure to consult a doctor about any type of diet regimen or exercise.");

        Foods.setText("Some of these foods that can use are: \n •Protein \n Chicken breast/thigh(best protein ratio to calorie), " +
                "whole eggs, egg whites(high protein/low calorie ratio), lean beef cuts, yogurt cottage cheese, protein powder(any type)" +
                "\n •Carbohydrates \n rice, potatoes(including white! high in potassium), basically any vegetable, fruit" +
                "\n •Fats \n eggs, avocado, different types of oils (olive, avocado, coconut), dairy products, trace fats from other foods");
    }
}
