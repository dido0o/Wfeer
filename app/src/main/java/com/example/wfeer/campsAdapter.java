package com.example.wfeer;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class campsAdapter extends RecyclerView.Adapter<campsAdapter.viewHolder> {

    private List<ListItem> listItems;
    private Context context;


    public campsAdapter(List<ListItem> listItems, Context context) {
        this.listItems = listItems;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new viewHolder(v);
    }

    @Override
    //This method will be called whenever there is a need to add new item to the list
    public void onBindViewHolder(@NonNull final viewHolder holder, final int position) {

        final ListItem listItem = listItems.get(position);

        holder.campNameTextView.setText(listItem.getCampName());
        holder.phoneTextView.setText(listItem.getPhoneNumber());
        holder.emailTextView.setText(listItem.getEmail());
        holder.foodDescriptionTextView.setText(listItem.getFoodDescription());
        listItem.getImageUri();


        holder.itemRelativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, CampInfo.class);
                intent.putExtra("listItem", listItems.get(position));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder{

        public TextView campNameTextView;
        public TextView phoneTextView;
        public TextView emailTextView;
        public TextView foodDescriptionTextView;
        RelativeLayout itemRelativeLayout;

        public viewHolder(@NonNull View itemView) {
            super(itemView);

            campNameTextView = itemView.findViewById(R.id.camp_name);
            phoneTextView = itemView.findViewById(R.id.camp_phone);
            emailTextView = itemView.findViewById(R.id.camp_email);
            foodDescriptionTextView = itemView.findViewById(R.id.food_description);
            itemRelativeLayout = itemView.findViewById(R.id.item_relative_layout);

        }// End viewHolder
    }// End class
}
