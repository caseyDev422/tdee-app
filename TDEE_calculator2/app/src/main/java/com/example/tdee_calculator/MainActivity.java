package com.example.tdee_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView mainPageDescription = findViewById(R.id.txtMainPageDescript);
        mainPageDescription.setText("• Thank you for choosing our app!\n" +
                "• This app can show you an estimated TDEE based of the factors in our calculator\n" +
                "• Not only does our app show your caloric needs, we show you your macros as well\n" +
                "• We include a GPS to see what stores are around your area also" +
                "• If you want to know more about TDEE details or don't know what it is in general, click Know More!\n" +
                "• If you know what about the details already, proceed to the calculator and again, thank you for using our app!");
    }
}