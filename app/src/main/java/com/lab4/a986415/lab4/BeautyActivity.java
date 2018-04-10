package com.lab4.a986415.lab4;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class BeautyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beauty);
        final Context ctx=this;
        Spinner spinner=findViewById(R.id.spinner);
        final String[] products = getResources().getStringArray(R.array.beautyproducts);
        ArrayAdapter autocompletetextAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_dropdown_item_1line, products);
        spinner.setAdapter(autocompletetextAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(ctx, "Clicked "+products[i],Toast.LENGTH_SHORT ).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
//        spinner.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(ctx, "Clicked "+products[position],Toast.LENGTH_SHORT ).show();
//            }
//        });
    }
}
