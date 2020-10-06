package com.example.wfeer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Agreement extends AppCompatActivity {

    Button agreeButton;
    Button cancelButton;
    TextView agreementText;
    Intent intent;
    private static final String TAG = "Agreement Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agreement);

        agreeButton = findViewById(R.id.agree_button);
        cancelButton = findViewById(R.id.cancel_button);
        agreementText = findViewById(R.id.agreement_text);

        //Changing the size of the layout to look like a pup-up window
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int windowWidth = dm.widthPixels;
        int windowHeight = dm.heightPixels;

        //  To make the pop-up window size in percentage: the width is screen width*0.8 and 0.6 for height
        getWindow().setLayout((int)(windowWidth*.8), (int)(windowHeight*.60));

        intent = getIntent();
        String volunteerName = intent.getStringExtra("volunteerName");
        String agreementText1 = getString(R.string.agreement1);
        String agreementText2 = this.getString(R.string.agreement2);
        agreementText.setText(agreementText1+ " '" + volunteerName + "' " + agreementText2);

        agreeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(Agreement.this, AvailableCamps.class);
                passVolunteerDataThrowIntent();
                startActivity(intent);

            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void passVolunteerDataThrowIntent(){

        //First we need to get the extras (Volunteer info) from the previous intent
        intent = getIntent();
        String volunteerName = intent.getStringExtra("volunteerName");
        String volunteerAddress = intent.getStringExtra("volunteerAddress");
        String volunteerEmail = intent.getStringExtra("volunteerEmail");
        String volunteerMobile = intent.getStringExtra("volunteerMobile");
        String volunteerAge = intent.getStringExtra("volunteerAge");
        String volunteerLegalID = intent.getStringExtra("volunteerLegalID");
        Toast.makeText(this, "" + volunteerName, Toast.LENGTH_SHORT).show();

        //Second we attach the data again to the next intent
        intent.putExtra("volunteerName", volunteerName);
        intent.putExtra("volunteerAddress", volunteerAddress);
        intent.putExtra("volunteerEmail", volunteerEmail);
        intent.putExtra("volunteerMobile", volunteerMobile );
        intent.putExtra("volunteerAge", volunteerAge);
        intent.putExtra("volunteerLegalID", volunteerLegalID);
    }
}
