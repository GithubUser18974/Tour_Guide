package com.example.android.tourguide;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    ResourcesDetails resourcesDetails;
    ImageView imageView;
    TextView nameTextView;
    TextView detailsTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        imageView = findViewById(R.id.imageview_details_activity);
        nameTextView = findViewById(R.id.textview_name_details_activity);
        detailsTextView = findViewById(R.id.textview_full_details_activity);
        resourcesDetails = (ResourcesDetails) getIntent().getExtras().get("data");
        imageView.setImageResource(resourcesDetails.getImage());
        nameTextView.setText(resourcesDetails.getName());
        detailsTextView.setText(resourcesDetails.getDescription());
    }


}
