package com.example.wfeer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

public class AvailableCamps extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<ListItem> listItems;
    RelativeLayout itemRelativeLayout;
    CampsDataBase db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_available_camps);

        recyclerView = findViewById(R.id.camp_recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        itemRelativeLayout = findViewById(R.id.item_relative_layout);
        listItems = new ArrayList<>();
        db = new CampsDataBase(this);
        Cursor res = db.getAllData();
        StringBuffer buffer = new StringBuffer();

        while (res.moveToNext()){ //Go throw the database and view all the data, and its good to know that this wile loop goes throw the database vertically

            //Fetching data from the data base, and storing them into variables
            //its good to know that getString method goes throw the database horizontally, column by column
            String campName = buffer.append("Camp name: "+res.getString(1)).toString();
            buffer.delete(0,buffer.length());
            String campPhone = buffer.append("Camp Phone: " + res.getString(4)+ "\n").toString();
            buffer.delete(0,buffer.length());
            String campEmail = buffer.append("Camp Email: " + res.getString(3)+ "\n").toString();
            buffer.delete(0,buffer.length());
            String foodDescription = buffer.append("Food description: " + res.getString(6)+ "\n").toString();
            buffer.delete(0,buffer.length());
            String imageUri = buffer.append(res.getString(9)).toString();
            ListItem listItem = new ListItem(campName, campPhone, campEmail, foodDescription, imageUri);
            listItems.add(listItem);
            adapter = new campsAdapter(listItems, this);
            recyclerView.setAdapter(adapter);
            buffer.delete(0,buffer.length());// Clear the buffer before adding the next value to the buffer
            /*في كل دورة يقوم البفر بتجميع البيانات فوق بعضها البعض , وهذا لا يتوافق مع منطق التطبيق, لذلك يجب تنظيف البفر
            * بعد كل دورة حتى نضمن أن كل id سيذهب إلى list item جديدة, وليس جميعهم إلى نفس ال list item*/
        }//End while
    }
}
