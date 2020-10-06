package com.example.wfeer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class FoodPicturePreview extends AppCompatActivity {

    ImageView imageView;
    Button okButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_picture_preview);

        imageView = findViewById(R.id.image_view);
        okButton = findViewById(R.id.ok_button);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int windowWidth = dm.widthPixels;
        int windowHeight = dm.heightPixels;

        //  To make the pop-up window size in percentage: the width is screen width*0.8 and 0.6 for height
        getWindow().setLayout((int)(windowWidth*.8), (int)(windowHeight*.60));

        Intent intent = getIntent();
        String receivedUri = intent.getStringExtra("image_Uri");
        Uri uri = Uri.parse(Uri.decode(receivedUri));
        imageView.setImageURI(uri);

        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
