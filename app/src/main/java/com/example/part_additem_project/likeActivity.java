package com.example.part_additem_project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class likeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.like);
         RecyclerView recycler= findViewById(R.id.item_recycler);
        String[] name = new String[product.p.length];
       String[] price = new String[product.p.length];
       int[] ids = new int[product.p.length];

        for (int i=0; i<name.length;i++){
            name[i] =product.p[i].getName();
            price[i] =product.p[i].getprice();
            ids[i]=product.p[i].getImgid();
        }
        recycler.setLayoutManager(new LinearLayoutManager(this));
       CaptionedItemAdapter adapter = new CaptionedItemAdapter(name,price,ids);
        recycler.setAdapter(adapter);
    }
}