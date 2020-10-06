package com.example.wfeer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class VolunteerFoodPicPrev extends AppCompatActivity {

    ImageView imageView;
    Button finishButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volunteer_food_pic_prev);


        //Changing the size of the layout to look like a pup-up window
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int windowWidth = dm.widthPixels;
        int windowHeight = dm.heightPixels;

        //  To make the pop-up window size in percentage: the width is screen width*0.8 and 0.6 for height
        getWindow().setLayout((int)(windowWidth*.8), (int)(windowHeight*.60));

        finishButton = findViewById(R.id.ok_button);
        finishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        ActivityCompat.requestPermissions(VolunteerFoodPicPrev.this,
                new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},1);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case 1: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // permission granted and now can proceed
                    myMethod();
                } else {
                    // permission denied, boo! Disable the functionality that depends on this permission.
                    Toast.makeText(VolunteerFoodPicPrev.this, "Permission denied to read your External storage", Toast.LENGTH_SHORT).show();
                }
                return;
            }//End case1
        }//End switch
    }

    public void myMethod(){
        imageView = findViewById(R.id.image_view);

        Intent intent = getIntent();
        String image = intent.getStringExtra("Image_Uri");
        Uri uri = Uri.parse(Uri.decode(image));

        imageView.setImageURI(uri);

    }
}
