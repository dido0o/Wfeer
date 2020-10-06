package com.example.wfeer;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.TextView;

public class volunGratitude extends AppCompatActivity {

    TextView gratitudeParagraph;
    TextView finishButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volun_gratitude);

        //Changing the size of the layout to look like a pup-up window
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int windowWidth = dm.widthPixels;
        int windowHeight = dm.heightPixels;

        //  To make the pop-up window size in percentage: the width is screen width*0.8 and 0.6 for height
        getWindow().setLayout((int)(windowWidth*.8), (int)(windowHeight*.56));

        gratitudeParagraph = findViewById(R.id.volunteer_gratitude_paragraph);
        finishButton = findViewById(R.id.volunteer_finish_text_view);

        finishButton.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {
            finishAffinity();
            }
        });
    }
}
