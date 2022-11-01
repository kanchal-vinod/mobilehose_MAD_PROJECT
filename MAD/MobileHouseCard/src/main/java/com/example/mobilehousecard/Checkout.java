package com.example.mobilehousecard;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Checkout extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.checkout);
    }

    public void CardPayment(View view) {

        Intent intent = new Intent(Checkout.this, PayCards.class);
        startActivity(intent);
    }
}
