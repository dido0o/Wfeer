package com.example.wfeer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FullAccessTest extends AppCompatActivity {

    Button valnOrCampButton, volunteerButton, agreementButton, availableCampsButton,
            campInfoButton, campButton, gratitudeButton, volunteerGratitudeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_access_test);

        valnOrCampButton = findViewById(R.id.to_valn_or_camp);
        volunteerButton = findViewById(R.id.to_volunteer_activity);
        agreementButton = findViewById(R.id.to_agreement_activity);
        availableCampsButton = findViewById(R.id.to_available_cams_activity);
        campInfoButton = findViewById(R.id.to_camp_info_activity);
        campButton = findViewById(R.id.to_camp_activity);
        gratitudeButton = findViewById(R.id.to_gratitude_activity);
        volunteerGratitudeButton = findViewById(R.id.to_volunteer_gratitude_activity);

        valnOrCampButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FullAccessTest.this, ValnOrCamp.class);
                startActivity(intent);
            }
        });

        volunteerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FullAccessTest.this, VolunteerActivity.class);
                startActivity(intent);
            }
        });

        agreementButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FullAccessTest.this, Agreement.class);
                startActivity(intent);
            }
        });

        availableCampsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FullAccessTest.this, AvailableCamps.class);
                startActivity(intent);
            }
        });

        campInfoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(FullAccessTest.this, "Sorry, Access denied", Toast.LENGTH_SHORT).show();
            }
        });

        campButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FullAccessTest.this, CampActivity.class);
                startActivity(intent);
            }
        });

        gratitudeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FullAccessTest.this, GratitudeActivity.class);
                startActivity(intent);
            }
        });

        volunteerGratitudeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FullAccessTest.this, volunGratitude.class);
                startActivity(intent);
            }
        });

    }
}
