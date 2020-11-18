package com.example.gridview1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class GridItem extends AppCompatActivity {

    TextView iddongho,idgia;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_item);

        iddongho = findViewById(R.id.iddongho);
        imageView = findViewById(R.id.imageView);
        idgia = findViewById(R.id.idgia);
        Intent intent = getIntent();
        String receivedName =  intent.getStringExtra("name");
        int receivedImage = intent.getIntExtra("image",0);
        String receivedGia =  intent.getStringExtra("gia");

        iddongho.setText(receivedName);
        imageView.setImageResource(receivedImage);
        idgia.setText(receivedGia);
    }
}