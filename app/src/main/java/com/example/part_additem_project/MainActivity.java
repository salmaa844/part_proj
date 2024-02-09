package com.example.part_additem_project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;



public class MainActivity extends AppCompatActivity {
    private TextInputEditText name,price,count,category,details;
    private AppCompatButton addbtn;
    DatabaseReference ref;
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

        /*addbtn = findViewById(R.id.addbtn);
        name=findViewById(R.id.name);
        price=findViewById(R.id.price);
        count=findViewById(R.id.count);
        category=findViewById(R.id.category);
        details=findViewById(R.id.details);
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        ref = db.getReference().child("items");

        addbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addItemToDatabase();
            }
        });
    }

    private void addItemToDatabase() {
        String itemName = name.getText().toString().trim();
        String itemPrice = price.getText().toString().trim();
        String itemCount = count.getText().toString().trim();
        String itemCategory = category.getText().toString().trim();
        String itemDetails = details.getText().toString().trim();

        // Check if any field is empty
        if (TextUtils.isEmpty(itemName) || TextUtils.isEmpty(itemPrice) ||
                TextUtils.isEmpty(itemCount) || TextUtils.isEmpty(itemCategory) || TextUtils.isEmpty(itemDetails)) {
            Toast.makeText(MainActivity.this, "All fields are required", Toast.LENGTH_SHORT).show();
            return;
        }

        // Create a new Item object with the retrieved values
        item newItem = new item(itemName, itemPrice, itemCount, itemCategory, itemDetails);

        // Push the new item to the Firebase database under the "items" node
        
        ref.push().setValue(newItem)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        // Item added successfully
                        Toast.makeText(MainActivity.this, "Item added successfully", Toast.LENGTH_SHORT).show();

                        // Clear the TextInputEditText fields after adding the item
                        name.setText("");
                        price.setText("");
                        count.setText("");
                        category.setText("");
                        details.setText("");
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        // Error occurred while adding the item
                        Toast.makeText(MainActivity.this, "Failed to add item: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });*/
    }
}
