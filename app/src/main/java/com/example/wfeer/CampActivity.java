package com.example.wfeer;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CampActivity extends AppCompatActivity {

    private static final int LOAD_IMAGE_RESULT = 1;
    private static final String TAG = "CampActivity";

    Button submitButton;
    EditText nameEditText;
    EditText addressEditText;
    EditText idEditText;
    EditText emailEditText;
    EditText phoneNumberEditText;
    EditText foodTypeEditText;
    EditText foodAmountEditText;
    EditText expireDateEditText;
    TextView someWrongTextView;
    TextView addPictureTextView;
    Uri selectedImageUri;
    CampsDataBase dataBase;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camp);

        dataBase = new CampsDataBase(this);
        submitButton = findViewById(R.id.submitButton);
        nameEditText = findViewById(R.id.input_name);
        addressEditText = findViewById(R.id.input_address);
        idEditText = findViewById(R.id.input_id);
        emailEditText = findViewById(R.id.input_email);
        phoneNumberEditText = findViewById(R.id.input_mobile);
        foodTypeEditText = findViewById(R.id.input_food_type);
        foodAmountEditText = findViewById(R.id.input_food_amount);
        expireDateEditText = findViewById(R.id.input_expire_date);
        someWrongTextView = findViewById(R.id.some_wrong_text_view);
        addPictureTextView = findViewById(R.id.add_photo_text_view);


        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //***next if statement is just to check if all the fields are not empty***
                if (checkForEmptyFields())
                    someWrongTextView.setText(getString(R.string.missing_info_ET));
                else{
                    //adding data to the database
                    boolean result = addToDB();
                    if (result){
                        Toast.makeText(CampActivity.this, "Added successfully", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(CampActivity.this, GratitudeActivity.class);
                        startActivity(intent);
                    }else
                        //To test this else condition try to add data row without deleting the old database
                        Toast.makeText(CampActivity.this, "Error: Not Added, Please try again", Toast.LENGTH_SHORT).show();
                }
            }
        });

        addPictureTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pictureIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(pictureIntent, LOAD_IMAGE_RESULT);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == LOAD_IMAGE_RESULT && resultCode == RESULT_OK && data != null){
            selectedImageUri = data.getData();
            Log.d(TAG, "Image Uri is : " + selectedImageUri);

            //send image Uri to imagePreview page
            Intent intent = new Intent(CampActivity.this, FoodPicturePreview.class);
            intent.putExtra("image_Uri", selectedImageUri.toString());
            startActivity(intent);
        }
    }

    public boolean addToDB(){

        String imageUri = null;
        if (selectedImageUri != null){
            imageUri = selectedImageUri.toString();
        }
        String campName = nameEditText.getText().toString();
        String campAddress = addressEditText.getText().toString();
        String campEmail = emailEditText.getText().toString();
        String campPhone = phoneNumberEditText.getText().toString();
        String foodType = foodTypeEditText.getText().toString();
        String foodAmount = foodAmountEditText.getText().toString();
        String expireDate = expireDateEditText.getText().toString();


        boolean result = dataBase.addData(campName, campAddress, campEmail, campPhone,
                foodType, foodAmount, expireDate, imageUri );

        return result;
    }

    public boolean checkForEmptyFields(){

        boolean isEmptyField;

        if (nameEditText.getText().toString().matches("")||
                addressEditText.getText().toString().matches("")||
                //idEditText.getText().toString().matches("")|| //something wrong with this line
                emailEditText.getText().toString().matches("")||
                phoneNumberEditText.getText().toString().matches("")||
                foodAmountEditText.getText().toString().matches("")||
                foodTypeEditText.getText().toString().matches("")||
                expireDateEditText.getText().toString().matches("")){
            isEmptyField = true;
        }else
            isEmptyField = false;

        return isEmptyField;
    }
}
