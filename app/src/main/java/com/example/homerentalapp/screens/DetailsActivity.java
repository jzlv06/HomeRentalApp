package com.example.homerentalapp.screens;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.homerentalapp.R;

public class DetailsActivity extends AppCompatActivity {

    private ImageView imageView;
    private TextView price;
    private TextView shortDescription;
    private TextView description;
    String p_rice;
    String short_description;
    String descrip_tion;
    String im_age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        imageView = findViewById(R.id.imageView);
        price = findViewById(R.id.price);
        shortDescription = findViewById(R.id.short_description);
        description = findViewById(R.id.description);

        p_rice = getIntent().getStringExtra("price");
        short_description = getIntent().getStringExtra("shortDescription");
        descrip_tion = getIntent().getStringExtra("description");
        im_age = getIntent().getStringExtra("image");

        price.setText("$" + p_rice);
        shortDescription.setText(short_description);
        description.setText(descrip_tion);
        Glide.with(this)
                .load(im_age)
                .centerCrop()
                .placeholder(R.drawable.ic_account)
                .into(imageView);
    }
}