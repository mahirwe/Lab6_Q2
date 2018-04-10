package com.lab4.a986415.lab4;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class ElectronicActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_electronic);
        final Context ctx=this;
        ListView lview=findViewById(R.id.listviewproducts);
        final String[] products = getResources().getStringArray(R.array.beautyproducts);
        CustomAdapter adapter= new CustomAdapter(this,R.id.listviewproducts,Application.products);
        lview.setAdapter(adapter);
        lview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(ctx,ViewProductActivity.class);
                intent.putExtra("product_id", position);
                startActivity(intent);
            }
        });

    }
}


class CustomAdapter extends ArrayAdapter<Product>{
    public CustomAdapter(@NonNull Context context, int resource, @NonNull List<Product> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if (v == null) {
            LayoutInflater vi = LayoutInflater.from(getContext());
            v = vi.inflate(R.layout.product_layout, null);
        }
        Product p = getItem(position);
        if (p != null) {
            ImageView img=v.findViewById(R.id.img_pro);
            TextView name_txt = v.findViewById(R.id.txt_name);
            TextView color_txt =  v.findViewById(R.id.txt_color);
            TextView price_txt =  v.findViewById(R.id.txt_price);
            img.setImageDrawable(Application.getImageDrawable(p.getImage(),v.getContext()));
            name_txt.setText(p.getTitle());
            color_txt.setText(p.getColor());
            price_txt.setText(String.valueOf(p.getPrice()));
        }
        return v;
    }




}
