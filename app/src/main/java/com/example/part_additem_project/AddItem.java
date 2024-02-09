package com.example.part_additem_project;


import com.google.android.material.textfield.TextInputEditText;

import java.util.HashMap;
import java.util.Map;

public class AddItem {

    String profileUrl = "";
    private TextInputEditText NameProduct,price,count,Itemtype,details;
    private void insertItem() {
        Map<String, String> dataToSave = new HashMap<>();
        dataToSave.put("Name", NameProduct.getText().toString());
        dataToSave.put("Price", price.getText().toString());
        dataToSave.put("count", count.getText().toString());
        dataToSave.put("typeofproducts", Itemtype.getText().toString());
        dataToSave.put("Detailsofproducts", details.getText().toString());
    }

}
