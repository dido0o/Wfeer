package com.example.wfeer;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class GratitudeActivity extends AppCompatActivity {

    TextView finishTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gratitude);

        finishTextView = findViewById(R.id.finish_text_view);

        finishTextView.setOnClickListener(new View.OnClickListener() {
            //The next line is because finishAffinity works only with specific versions of android
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {
                finishAffinity();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

    }
}
