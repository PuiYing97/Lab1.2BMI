package com.example.user.lab12bmi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText editTextWeight, editTextHeight;
    private TextView textViewResult;
    private ImageView imageViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextWeight = (EditText)findViewById(R.id.editTextWeight);
        editTextHeight = (EditText)findViewById(R.id.editTextHeight);
        textViewResult = (TextView)findViewById(R.id.textViewResult);
        imageViewResult = (ImageView)findViewById(R.id.imageViewResult);
    }

    public void calculateBMI (View view) {
        double weight, height, BMI, heightInM;

        weight = Double.parseDouble(editTextWeight.getText().toString());
        height = Double.parseDouble(editTextHeight.getText().toString());

        heightInM = height / 100;
        BMI = (weight / (heightInM * heightInM));

        if (BMI <= 15){
            textViewResult.setText("Your BMI is " + BMI + ".You are underweight.");
            imageViewResult.setImageResource(R.drawable.under);
        }
        else if (BMI >= 25) {
            textViewResult.setText("Your BMI is " + BMI + ".You are overweight.");
            imageViewResult.setImageResource(R.drawable.over);
        }
        else {
            textViewResult.setText("Your BMI is " + BMI + ".You are normal.");
            imageViewResult.setImageResource(R.drawable.normal);
        }



    }

    public void reset (View view) {
        editTextWeight.setText("");
        editTextHeight.setText("");
        textViewResult.setText("");
        imageViewResult.setImageResource(R.drawable.empty);

    }
}
