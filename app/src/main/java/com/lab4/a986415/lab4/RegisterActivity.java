package com.lab4.a986415.lab4;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;

import android.support.v7.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        final EditText fname_txt=findViewById(R.id.txt_fname);
        final EditText lname_txt=findViewById(R.id.txt_lname);
        final EditText email_txt=findViewById(R.id.txt_email);
        final EditText pass_txt=findViewById(R.id.txt_pass);
        final Context ctx=this;
        Button register_btn=findViewById(R.id.create_btn);
        register_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fname=fname_txt.getText().toString();
                String lname=lname_txt.getText().toString();
                String email=email_txt.getText().toString();
                String pass=pass_txt.getText().toString();
                if(ValidateFields(fname,lname,email,pass)) {
                    Log.d("test","before"+Application.users.size());
                    Application.users.add(new User(email,pass));
                    Log.d("test","after"+Application.users.size());
                    Intent intent= new Intent(ctx,MainActivity.class);
                    MainActivity.displayToast(ctx, "Account Created!");
                    startActivity(intent);
                }
            }
        });
    }
    private boolean  ValidateFields(String fname,String lname,String email,String pass){
        if(fname.isEmpty()||lname.isEmpty()||email.isEmpty()||pass.isEmpty()){
            MainActivity.displayToast(this, "Fill all required fields!");
            return false;
        }
        return true;
    }
}
