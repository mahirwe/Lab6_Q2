package com.lab4.a986415.lab4;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Context ctx;
    public static final String MyPREFERENCES = "MyPrefs" ;
    SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ctx=this;
        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        final EditText email_txt=findViewById(R.id.txt_email);
        final EditText pass_txt=findViewById(R.id.txt_pass);
        Button login_btn=findViewById(R.id.btn_signin);
        TextView create_btn=findViewById(R.id.btn_createacc);
        String last_username=sharedpreferences.getString("last_username","");
        email_txt.setText(last_username);
        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User user=new User(email_txt.getText().toString(),pass_txt.getText().toString());
                Log.d("test","user"+user.toString()+"contains"+Application.users.contains(user));
                if (user.getEmail().isEmpty()||user.getPass().isEmpty()){
                    displayToast(ctx,"Fields cannot be empty");
                }
                else if (Application.users.contains(user)) {
                    Intent logintent=new Intent(ctx,ShoppingActivity.class);
                    logintent.putExtra("last_username", user.getEmail());
                    startActivity(logintent);
                    SharedPreferences.Editor editor = sharedpreferences.edit();
                    editor.putString("username",user.getEmail());
                    editor.commit();
                    editor.
                } else {
                    displayToast(ctx,"Wrong credentials provided!");
                }
            }
        });


        create_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ctx,RegisterActivity.class);
                startActivity(intent);

            }
        });


    }

    public static void displayToast(Context ctx,String msg){
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(ctx, msg, duration);
        toast.show();

    }
}
