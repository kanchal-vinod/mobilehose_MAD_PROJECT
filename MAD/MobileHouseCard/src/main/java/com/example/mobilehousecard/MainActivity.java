package com.example.mobilehousecard;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void GetPayment(View view) {

        Intent intent = new Intent(MainActivity.this, Checkout.class);
        startActivity(intent);

    }

    public void GetOrder(View view) {
        Intent intent = new Intent(MainActivity.this, View_Additems.class);
        startActivity(intent);
    }
}