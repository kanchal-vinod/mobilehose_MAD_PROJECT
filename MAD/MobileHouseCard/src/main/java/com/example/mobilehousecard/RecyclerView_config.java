package com.example.mobilehousecard;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerView_config {

    private Context mContext;
    private ItemAdapter mFeedBackAdapter;

    public void setConfig(RecyclerView recyclerView, Context context, List<Item> items, List<String> keys){
        mContext=context;
        mFeedBackAdapter =new ItemAdapter(items,keys);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(mFeedBackAdapter);
    }

    class ItemView extends RecyclerView.ViewHolder{
        private TextView itemName;
        private TextView itemPrice;
        private TextView itemNote;
        private ImageView imageView;

        private String key;

        public ItemView(ViewGroup parent){
            super(LayoutInflater.from(mContext).inflate(R.layout.add_list_item,parent,false));


            itemName =(TextView)itemView.findViewById(R.id.Item_Name);
            itemPrice =(TextView)itemView.findViewById(R.id.Item_Price);
            itemNote =(TextView)itemView.findViewById(R.id.Item_Note);

            imageView=(ImageView)itemView.findViewById(R.id.imageView4);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(mContext, View_item.class);
                    intent.putExtra("key",key);
                    intent.putExtra("IName", itemName.getText().toString());
                    intent.putExtra("IPrice", itemPrice.getText().toString());
                    intent.putExtra("INote", itemNote.getText().toString());


                    mContext.startActivity(intent);
                }
            });
        }
        public void bind(Item item, String key){
            itemName.setText(item.getItemName());
            itemPrice.setText(item.getItemPrice());
            itemNote.setText(item.getItemNote());
            String imageUri=null;
            imageUri=item.getImage();
            Picasso.get().load(imageUri).into(imageView);
            this.key=key;

        }
    }
    class ItemAdapter extends RecyclerView.Adapter<ItemView>{
        private List<Item> itemList;
        private List<String> mKeys;

        public ItemAdapter(List<Item> itemList, List<String> mKeys) {
            this.itemList = itemList;
            this.mKeys = mKeys;
        }

        @NonNull
        @Override
        public ItemView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new ItemView(parent);
        }

        @Override
        public void onBindViewHolder(@NonNull ItemView holder, int position) {
            holder.bind(itemList.get(position),mKeys.get(position));

        }

        @Override
        public int getItemCount() {
            return itemList.size();
        }
    }
}
