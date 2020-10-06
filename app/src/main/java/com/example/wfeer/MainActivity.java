package com.example.wfeer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";

    TextView nextTextView;
    TextView exitTextView;
    TextView fullAccessTextView;
    int counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//this line to link activity with class


        nextTextView = findViewById(R.id.next_text_view);
        exitTextView = findViewById(R.id.exit_text_view);
        fullAccessTextView = findViewById(R.id.full_access_test);

        nextTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ValnOrCamp.class);
                startActivity(intent);
            }
        });

        exitTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    finishAffinity();//Exit from the application
                    //System.exit(0);
                }
            }
        });

        fullAccessTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    counter++;

                if (counter == 3){
                Intent intent = new Intent(MainActivity.this, FullAccessTest.class);
                startActivity(intent);
                counter = 0;
                }
            }
        });

    } //onCreate

} //MainActivity
