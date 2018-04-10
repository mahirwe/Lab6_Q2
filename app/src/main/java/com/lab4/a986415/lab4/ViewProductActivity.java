package com.lab4.a986415.lab4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ViewProductActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_product);
        Intent intent = getIntent();
        int pos=intent.getIntExtra("product_id", 0);
        Product product =Application.products.get(pos);
        ImageView img=findViewById(R.id.product_img);

        TextView pro_name=findViewById(R.id.product_name);
        TextView pro_id=findViewById(R.id.product_id);
        TextView pro_color=findViewById(R.id.product_color);
        TextView pro_price=findViewById(R.id.product_price);
        TextView pro_descr=findViewById(R.id.product_descr);
        img.setImageDrawable(Application.getImageDrawable(product.getImage(),this));
        pro_name.setText(product.getTitle());
        pro_color.setText("Color:"+product.getColor());
        pro_id.setText("Walmart #: "+product.getTitle());
        pro_price.setText(String.valueOf(product.getPrice()));
        pro_descr.setText(product.getDesc());
    }
}
