package com.example.tdee_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button tdeeInfo;
    Button tdeeCalculator;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tdeeCalculator = (Button) findViewById(R.id.btnTdeeCalculator);
        tdeeCalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openTdeeCalculator();
            }
        });

        tdeeInfo = (Button) findViewById(R.id.btnKnowMore);
        tdeeInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openTdeeInfo();
            }
        });

        TextView mainPageDescription = findViewById(R.id.txtMainPageDescript);
        mainPageDescription.setText("• Thank you for choosing our app!\n" +
                "• This app can show you an estimated TDEE based of the factors in our calculator\n" +
                "• Not only does our app show your caloric needs, we show you your macros as well\n" +
                "• We include a GPS to see what stores are around your area also" +
                "• If you want to know more about TDEE details or don't know what it is in general, click Know More!\n" +
                "• If you know what about the details already, proceed to the calculator and again, thank you for using our app!");
    }

    public void openTdeeInfo() {
        Intent intent = new Intent(this, TdeeInformation.class);
        startActivity(intent);
    }

    public void openTdeeCalculator() {
        Intent intent = new Intent(this, TdeeCalculator.class);
        startActivity(intent);
    }
}