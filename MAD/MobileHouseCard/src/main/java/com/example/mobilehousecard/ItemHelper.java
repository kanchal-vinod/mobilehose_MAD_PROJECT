package com.example.mobilehousecard;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;

public class ItemHelper {

    private FirebaseDatabase mdata;
    private DatabaseReference mRef;
    private List<Item> items =new ArrayList<>();

    public interface DataStatus{
        void DataIsLoaded(List<Item> items, List<String> keys);
        void DataIsUpdated();
        void DataIsDeleted();
    }

    public ItemHelper() {
        mdata= FirebaseDatabase.getInstance();
        mRef=mdata.getReference("items");

    }

    public void readItems(final DataStatus dataStatus){
        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                items.clear();
                List<String> keys=new ArrayList<>();
                for (DataSnapshot keyNode:dataSnapshot.getChildren()){
                    keys.add(keyNode.getKey());
                    Item feedBack=keyNode.getValue(Item.class);
                    items.add(feedBack);
                }
                dataStatus.DataIsLoaded(items,keys);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void updateItems(String key, Item items, final DataStatus dataStatus){
        mRef.child(key).setValue(items).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                dataStatus.DataIsUpdated();
            }
        });
    }



}
