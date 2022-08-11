package com.example.aa;

import androidx.annotation.DrawableRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout layout = findViewById(R.id.layout);
        EditText number1 = findViewById(R.id.quiz);
        EditText number2 = findViewById(R.id.homework);
        EditText number3 = findViewById(R.id.mid);
        EditText number4 = findViewById(R.id.fin);
        TextView result = findViewById(R.id.Result);
        TextView total = findViewById(R.id.total);
        Button button = findViewById(R.id.button);
        Button reset = findViewById(R.id.reset);
        final ImageButton[] dark = {findViewById(R.id.dark)};

        final int[] on = {0};





      button.setOnClickListener(new View.OnClickListener() {
          @SuppressLint({"SetTextI18n", "ResourceAsColor"})
          @Override
          public void onClick(View hew) {



            //if on section is empty
              if (number1.getText().toString().isEmpty() || number2.getText().toString().isEmpty()
              || number3.getText().toString().isEmpty() || number3.getText().toString().isEmpty()){



                  if(number1.getText().toString().isEmpty()){
                      number1.setError( "Fill the Quizes section!" );
                  }

                  if(number2.getText().toString().isEmpty()){
                      number2.setError( "Fill the Homework section!" );
                  }

                  if(number3.getText().toString().isEmpty()){
                      number3.setError( "Fill the Mid Terms section!" );
                  }

                  if(number4.getText().toString().isEmpty()){
                      number4.setError( "Fill the Final section!" );
                  }


              }else {

                  int num1 = Integer.parseInt(number1.getText().toString());
                  int num2 = Integer.parseInt(number2.getText().toString());
                  int num3 = Integer.parseInt(number3.getText().toString());
                  int num4 = Integer.parseInt(number4.getText().toString());

                  if (num1 > 100 || num2 > 100 || num3 > 100 || num4 > 100){

                      if (num1 > 100){
                          number1.setError( "The grates grade is 100!" );
                      }

                      if (num2 > 100){
                          number2.setError( "The grates grade is 100!" );
                      }

                      if (num3 > 100){
                          number3.setError( "The grates grade is 100!" );
                      }

                      if (num4 > 100){
                          number4.setError( "The grates grade is 100!" );
                      }


                  }else {

                      int totaln = (num1 * 15 / 100) + (num2 * 25 / 100) + (num3 * 30 / 100) + (num4 * 30 / 100);

                      total.setText(String.valueOf(totaln));

                      result.setText("Result: %");
                  }

              }
          }
      });


        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               number1.setText("");
               number2.setText("");
               number3.setText("");
               number4.setText("");

                total.setText("");
                result.setText("Result:");
            }
        });

       dark[0].setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {

               on[0]++;

               if(on[0] == 2){
                   on[0] = 0;
               }

               if (on[0] == 1) {
                   AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
               }

               if (on[0] == 0 || on[0] == 2) {
                       AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
               }

               }



       });
    }



}