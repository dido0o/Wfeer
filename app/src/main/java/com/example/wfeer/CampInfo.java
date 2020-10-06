package com.example.wfeer;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CampInfo extends AppCompatActivity{

    TextView campNameTextView;
    TextView campPhoneTextView;
    TextView campEmailTextView;
    TextView foodDescriptionTextView;
    TextView doneButton;
    volunteerDataTempStorage volunTempData;
    Button viewFoodImageButton, viewCampMapButton;

    private static final String TAG = "CampInfo Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camp_info);

        campNameTextView = findViewById(R.id.camp_name_text_view);
        campPhoneTextView = findViewById(R.id.camp_phone);
        campEmailTextView = findViewById(R.id.camp_email);
        foodDescriptionTextView = findViewById(R.id.food_description);
        viewFoodImageButton = findViewById(R.id.view_food_image);
        viewCampMapButton = findViewById(R.id.view_camp_map);
        doneButton = findViewById(R.id.done_button);

        Intent intent = getIntent();
        ListItem listItem = intent.getParcelableExtra("listItem");//To get the list item passed from the other activity

        //Storing each info from the list item in a variable
        String campName = listItem.getCampName();
        String campPhone = listItem.getPhoneNumber();
        String campEmail = listItem.getEmail();
        String foodDescription = listItem.getFoodDescription();
        final String imageUri = listItem.getImageUri();

        //Routing each info to its correct place
        campNameTextView.setText(campName);
        campPhoneTextView.setText(campPhone);
        campEmailTextView.setText(campEmail);
        foodDescriptionTextView.setText(foodDescription);




        viewFoodImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(CampInfo.this, VolunteerFoodPicPrev.class);
                intent1.putExtra("Image_Uri", imageUri);
                startActivity(intent1);
                Log.d(TAG, "onClick: viewFoodImageButton clicked");
                getVolunteerDataThrowIntent();
            }
        });

        viewCampMapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(CampInfo.this, CampMap.class);
                startActivity(intent1);


            }
        });

        doneButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent1 = new Intent(CampInfo.this, volunGratitude.class);
                startActivity(intent1);
//                doneButton.setVisibility(View.GONE);
            }
        });
    }

    public void getVolunteerData(){

        /*I don't know any way to get the same data that the volunteer entered in the volunteerDataTempStorage
        * from the volunteer activity, and that is because getName in this method and the other getters are
        * reading their data from the constructor here, not from the sitters in the temp storage class
        * so i think i will have to use regular Intents to deliver volunteer data to this class*/
        volunTempData = new volunteerDataTempStorage();

        String volunteerName = volunTempData.getName();
        String volunteerAddress = volunTempData.getAddress();
        String volunteerEmail = volunTempData.getEmail();
        String volunteerMobile = volunTempData.getMobile();
        String volunteerAge = volunTempData.getAge();
        String volunteerLegalID = volunTempData.getLegalID();

        Log.d(TAG, "VolunteerData are : " + volunteerName + volunteerAddress
        + volunteerEmail + volunteerMobile + volunteerAge + volunteerLegalID);
    }

    public void getVolunteerDataThrowIntent (){

        Intent intent = getIntent();
        String volunteerName = intent.getStringExtra("volunteerName");
        String volunteerAddress = intent.getStringExtra("volunteerAddress");
        String volunteerEmail = intent.getStringExtra("volunteerEmail");
        String volunteerMobile = intent.getStringExtra("volunteerMobile");
        String volunteerAge = intent.getStringExtra("volunteerAge");
        String volunteerLegalID = intent.getStringExtra("volunteerLegalID");
        Toast.makeText(this, "" + volunteerName, Toast.LENGTH_SHORT).show();
    }
}
