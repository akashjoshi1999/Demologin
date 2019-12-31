package com.example.my;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText logusername;
    EditText logpassword;
    Button logbuttton;
    TextView register;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseHelper = new DatabaseHelper(this);
        logusername = (EditText)findViewById(R.id.username_edit);
        logpassword = (EditText)findViewById(R.id.password_edit);
        logbuttton = (Button)findViewById(R.id.button_edit);
        register = (TextView)findViewById(R.id.register_edit);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registreintent = new Intent(MainActivity.this,LoginActivity.class);
                startActivity(registreintent);
            }
        });

        logbuttton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = logusername.getText().toString().trim();
                String pwd = logpassword.getText().toString().trim();
                Boolean res = databaseHelper.checkUser(user,pwd);

                if(res == true){
                    Toast.makeText(MainActivity.this,"Sucessfullly logged in",Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(MainActivity.this,"Log in ERROR",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
