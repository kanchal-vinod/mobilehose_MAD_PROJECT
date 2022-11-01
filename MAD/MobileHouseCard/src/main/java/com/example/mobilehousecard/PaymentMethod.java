package com.example.mobilehousecard;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class PaymentMethod extends AppCompatActivity {

    EditText cardNum,cardYear,cardCvv,cardName;
    Button delete;
    DatabaseReference databaseReference;
    private String Cnum,Cyear,Ccvv,Cname;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.payment_methods);
        databaseReference = FirebaseDatabase.getInstance().getReference("cards");

        cardNum = findViewById(R.id.editTextTextPersonName8);
        cardYear = findViewById(R.id.editTextTextPersonName6);
        cardCvv = findViewById(R.id.editTextTextPersonName7);
        cardName = findViewById(R.id.add_cn);
        delete = findViewById(R.id.bt_delete);

        Cnum =getIntent().getStringExtra("CNum");
        Cyear =getIntent().getStringExtra("CYear");
        Ccvv =getIntent().getStringExtra("CCvv");
        Cname =getIntent().getStringExtra("CName");

        cardNum.setText(Cnum);
        cardYear.setText(Cyear);
        cardCvv.setText(Ccvv);
        cardName.setText(Cname);

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mUser = cardNum.getText().toString().trim();

                databaseReference.child(mUser).setValue(null);
                Toast.makeText(com.example.mobilehousecard.PaymentMethod.this, "Card Details Deleted", Toast.LENGTH_LONG).show();
                cardNum.setText("");
                cardYear.setText("");
                cardCvv.setText("");
                cardName.setText("");

            }
        });
    }

    public void AddAnother(View view) {
        Intent intent=new Intent(getApplicationContext(), PayCards.class);
        startActivity(intent);
    }
}
