package com.lab4.a986415.lab4;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Spinner;

public class ClothingActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clothing);
        final Context ctx=this;
        ListView lview=findViewById(R.id.listview1);
        final String[] products = getResources().getStringArray(R.array.beautyproducts);
        ArrayAdapter adapter = new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_1, products);
        lview.setAdapter(adapter);
    }
}