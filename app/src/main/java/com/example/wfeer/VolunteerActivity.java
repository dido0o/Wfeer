package com.example.wfeer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.text.TextUtils;

public class VolunteerActivity extends AppCompatActivity {

    Button submitButton;
    EditText nameEditText;
    EditText addressEditText;
    EditText emailEditText;
    EditText mobileEditText;
    EditText ageEditText;
    EditText idEditText;
    TextView someWrongTextView;
    Intent intent;
    Uri selectedImageUri;
    volunteerDataTempStorage volunTempData;

    private static final String TAG = "VolunteerActivity";

    volunteerDataBase dataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volunteer);

        dataBase = new volunteerDataBase(this);

        nameEditText = findViewById(R.id.input_name);
        addressEditText = findViewById(R.id.input_address);
        emailEditText = findViewById(R.id.input_email);
        mobileEditText = findViewById(R.id.input_mobile);
        ageEditText = findViewById(R.id.input_age);
        idEditText = findViewById(R.id.input_id);
        someWrongTextView = findViewById(R.id.some_wrong_text_view);

        submitButton = findViewById(R.id.submitButton);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(checkForEmptyFields()){
                    someWrongTextView.setText(getString(R.string.missing_info_ET));
                }else {
                    addToDB();
                    sendDataByEmail();
                    String volunteerName = nameEditText.getText().toString();
                    intent = new Intent(VolunteerActivity.this, Agreement.class);
                    intent.putExtra("volunteerName", volunteerName);
                    startActivity(intent);
                }
            }//End submit button onClickListener


        });
    }

    public boolean addToDB(){

        /*For some reason i think we don't need to store the volunteer data because i have
        no idea what to do with the data, but for now i am going to store it any way.*/
        String imageUri = null;
        if (selectedImageUri != null){
            imageUri = selectedImageUri.toString();
        }

        String name = nameEditText.getText().toString();
        String address = addressEditText.getText().toString();
        String email = emailEditText.getText().toString();
        String mobile = mobileEditText.getText().toString();
        String age = ageEditText.getText().toString();
        String nationalID = idEditText.getText().toString();

        boolean result = dataBase.addData(name, address, email, mobile, age,
                nationalID, imageUri);

        return result;
    }

    public boolean checkForEmptyFields(){

        boolean isEmptyField;

        if (nameEditText.getText().toString().matches("")||
                addressEditText.getText().toString().matches("")||
                //idEditText.getText().toString().matches("")|| //something wrong with this line
                emailEditText.getText().toString().matches("")||
                mobileEditText.getText().toString().matches("")||
                ageEditText.getText().toString().matches("")||
                idEditText.getText().toString().matches("")){
            isEmptyField = true;
        }else
            isEmptyField = false;

        return isEmptyField;
    }

    public String sendDataByEmail (){

        /*The sitters here are working fine, but the getters in camp info aren't reading the same info
        * entered by this method, so i will use regular intent.putExtra instead*/
        String name = nameEditText.getText().toString();
        String address = addressEditText.getText().toString();
        String email = emailEditText.getText().toString();
        String mobile = mobileEditText.getText().toString();
        String age = ageEditText.getText().toString();
        String legalID = idEditText.getText().toString();

        volunTempData = new volunteerDataTempStorage(name, address, email, mobile, age, legalID);

        volunTempData.setName(name);
        volunTempData.setAddress(address);
        volunTempData.setEmail(email);
        volunTempData.setMobile(mobile);
        volunTempData.setAge(age);
        volunTempData.setLegalID(legalID);

        return name + address + email + mobile + age + legalID;
    }

    public void sendVolunteerDataByInten (){

        String name = nameEditText.getText().toString();
        String address = addressEditText.getText().toString();
        String email = emailEditText.getText().toString();
        String mobile = mobileEditText.getText().toString();
        String age = ageEditText.getText().toString();
        String legalID = idEditText.getText().toString();

        intent.putExtra("volunteerName", name);
        intent.putExtra("volunteerAddress", address);
        intent.putExtra("volunteerEmail", email);
        intent.putExtra("volunteerMobile", mobile);
        intent.putExtra("volunteerAge", age);
        intent.putExtra("volunteerLegalID", legalID);

    }
}