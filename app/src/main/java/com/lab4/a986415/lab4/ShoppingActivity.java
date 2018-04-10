package com.lab4.a986415.lab4;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;

public class ShoppingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping);
        Toolbar myToolbar =findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message = intent.getStringExtra("username");
        TextView welcomtxt=findViewById(R.id.txt_welcome);
        welcomtxt.setText("Welcome "+message);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String msg="";
        switch (item.getItemId()) {
            case R.id.menu_electronic:
                msg="Electronics";
                launchActivity(this,ElectronicActivity.class,msg);
                return true;
            case R.id.menu_clothing:
                msg="Clothing";
                launchActivity(this,ClothingActivity.class,msg);
                return true;
            case R.id.menu_beauty:
                msg="Beauty";
                launchActivity(this,BeautyActivity.class,msg);
                return true;
            case R.id.menu_food:
                return true;
            case R.id.menu_logout:
                AlertDialog.Builder  builder = new AlertDialog.Builder(this, android.R.style.Theme_Material_Dialog_Alert);
                builder.setTitle("Logout")
                        .setMessage("Do you want to exit ?")
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
//                                launchActivity(this,MainActivity.class,"logout");
                                moveTaskToBack(true);
                                android.os.Process.killProcess(android.os.Process.myPid());
                                System.exit(1);
                            }
                        })
                        .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // do nothing
                            }
                        })
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }



    public void categoryclick(View v){
        String msg="";
        Intent intent;
       switch (v.getId()){

           case R.id.imageView1:
               msg="Electronics";
               intent=new Intent(this,ElectronicActivity.class);
               startActivity(intent);
               break;

           case R.id.imageView2:
               msg="Clothing";
               intent=new Intent(this,ClothingActivity.class);
               startActivity(intent);
               break;

           case R.id.imageView3:
               msg="Beauty";
               intent=new Intent(this,BeautyActivity.class);
               startActivity(intent);
               break;

           case R.id.imageView4:
               msg="Food";
               break;
       }
        MainActivity.displayToast(v.getContext(), "You have chosen " +msg+" category of shopping");
    }


    public void launchActivity(Context ctx, Class Activityclass, String msg){
        Intent intent;
        intent=new Intent(this,Activityclass);
        MainActivity.displayToast(ctx, "You have chosen " +msg+" category of shopping");
        startActivity(intent);
    }
}
