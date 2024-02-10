package com.example.part_additem_project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;



public class MainActivity extends AppCompatActivity {
    private TextInputEditText name,price,count,details;
    private AppCompatButton addbtn;

    DatabaseReference ref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addbtn = findViewById(R.id.addbtn);
        name=findViewById(R.id.name);
        price=findViewById(R.id.price);
        count=findViewById(R.id.count);
        Spinner category = findViewById(R.id.category);
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
        String itemDetails = details.getText().toString().trim();

        Spinner categorySpinner = findViewById(R.id.category);
        String itemCategory = categorySpinner.getSelectedItem().toString();

        if (TextUtils.isEmpty(itemName)) {
            Toast.makeText(MainActivity.this, "Item name is required", Toast.LENGTH_SHORT).show();
            return;
        }
        if (!itemName.matches("[a-zA-Z]+")) {
            Toast.makeText(MainActivity.this, "Item name must contain only letters", Toast.LENGTH_SHORT).show();
            return;
        }

        if (TextUtils.isEmpty(itemPrice)) {
            Toast.makeText(MainActivity.this, "Item price is required", Toast.LENGTH_SHORT).show();
            return;
        }
        if (!itemPrice.matches("\\d+")) {
            Toast.makeText(MainActivity.this, "Item price must contain only digits", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(itemCount)) {
            Toast.makeText(MainActivity.this, "Item count is required", Toast.LENGTH_SHORT).show();
            return;
        }
        if (categorySpinner.getSelectedItemPosition() == 0) {
            Toast.makeText(MainActivity.this, "Please select an item category", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(itemDetails)) {
            Toast.makeText(MainActivity.this, "Item details are required", Toast.LENGTH_SHORT).show();
            return;
        }


        item newItem = new item(itemName, itemPrice, itemCount, itemCategory, itemDetails);


        ref.push().setValue(newItem)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {

                        Toast.makeText(MainActivity.this, "Item added successfully", Toast.LENGTH_SHORT).show();
                        name.setText("");
                        price.setText("");
                        count.setText("");
                        details.setText("");
                        categorySpinner.setSelection(0);
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        // Error occurred while adding the item
                        Toast.makeText(MainActivity.this, "Failed to add item: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
