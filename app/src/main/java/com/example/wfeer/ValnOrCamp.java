package com.example.wfeer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ValnOrCamp extends AppCompatActivity {

    Button VolunteerButton;
    Button CampButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_valn_or_camp);

        VolunteerButton = findViewById(R.id.VolunteerButton);
        CampButton = findViewById(R.id.CampButton);

        VolunteerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ValnOrCamp.this, VolunteerActivity.class);
                startActivity(intent);
            }
        });//VolunteerButton OnClickListener

        CampButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ValnOrCamp.this, CampActivity.class);
                startActivity(intent);
            }
        });//CampButton OnClickListener

    }//End onCreate

    /*@Override
    public void onBackPressed() {}
    هذا الميثود معناه إذا المستخدم ضغط زر الرجوع ما يصير شي و يمديك تغير تخليه إذا ضغط زر
    الرجوع يصير أي شي انت تبغاه
     */
}
