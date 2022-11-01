package com.example.mobilehousecard;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;

public class View_item extends AppCompatActivity {

    TextView iName;
    TextView iPrice;
    EditText iNote;

    Button Add_delivery;

    private String key;
    private String IName;
    private String IPrice;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_item);
        getSupportActionBar().hide();

        key=getIntent().getStringExtra("key");
        IName =getIntent().getStringExtra("IName");
        IPrice =getIntent().getStringExtra("IPrice");


        iName =(TextView) findViewById(R.id.textView3);
        iName.setText(IName);
        iPrice =(TextView) findViewById(R.id.textView5);
        iPrice.setText(IPrice);

        Add_delivery =(Button)findViewById(R.id.addcart);

        Add_delivery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Item item=new Item();
                item.setItemName(iName.getText().toString());
                item.setItemPrice(iPrice.getText().toString());



                new ItemHelper().updateItems(key, item, new ItemHelper.DataStatus() {
                    @Override
                    public void DataIsLoaded(List<Item> items, List<String> keys) {

                    }

                    @Override
                    public void DataIsUpdated() {
                        Toast.makeText(View_item.this,"Item Updated Successfully", Toast.LENGTH_LONG).show();
                        finish();return;

                    }

                    @Override
                    public void DataIsDeleted() {

                    }
                });
            }
        });




    }



}
