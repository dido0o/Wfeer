package com.example.wfeer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ShowExistCamps extends AppCompatActivity {

    CampsDataBase db = new CampsDataBase(this);
    TextView camp2Name;
    TextView camp2FoodDescription;
    TextView email2;
    TextView phone2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_exist_camps);

        camp2Name = findViewById(R.id.camp2_name);
        camp2FoodDescription = findViewById(R.id.camp2_food_description);
        email2 = findViewById(R.id.email2);
        phone2 = findViewById(R.id.phone_2);

        if (db.added){

            camp2Name.setText(db.name);
            camp2FoodDescription.setText(db.foodType);
            email2.setText(db.email);
            phone2.setText("Data Are Added : )");
        }
    }
}
