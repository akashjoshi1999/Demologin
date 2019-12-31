package com.example.my;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RemoteViewsService;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    DatabaseHelper databaseHelper;
    EditText regusername;
    EditText regpassword;
    EditText regconfirmpass;
    Button regbuttton;
    TextView login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        databaseHelper = new DatabaseHelper(this);
        regusername = (EditText)findViewById(R.id.username_edit);
        regpassword = (EditText)findViewById(R.id.password_edit);
        regconfirmpass = (EditText)findViewById(R.id.comfirm_password_edit);
        regbuttton = (Button)findViewById(R.id.button_register);
        login = (TextView)findViewById(R.id.register_login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent log = new Intent(LoginActivity.this,MainActivity.class);
                startActivity(log);
            }
        });

        regbuttton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = regusername.getText().toString().trim();
                String pwd_1 = regpassword.getText().toString().trim();
                String pwd_2 = regconfirmpass.getText().toString().trim();

                if(pwd_1.equals(pwd_2)){
                    long val = databaseHelper.addUser(user,pwd_1);
                    if (val > 0) {
                        Toast.makeText(LoginActivity.this,"register sucessful",Toast.LENGTH_SHORT).show();
                        Intent moveTologin = new Intent(LoginActivity.this,MainActivity.class);
                        startActivity(moveTologin);
                    }
                    else {
                        Toast.makeText(LoginActivity.this,"Registration ERROR",Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    Toast.makeText(LoginActivity.this,"Password are not same",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
