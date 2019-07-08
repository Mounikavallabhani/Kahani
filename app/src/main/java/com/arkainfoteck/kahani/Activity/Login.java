package com.arkainfoteck.kahani.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.arkainfoteck.kahani.R;

public class Login extends AppCompatActivity {
    TextView register,forgot;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        register=(TextView)findViewById(R.id.register);
        login=(Button)findViewById(R.id.login);
        forgot=(TextView)findViewById(R.id.forgot);
        forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),ForgotActivity.class);
                startActivity(intent);

            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),LanguageSelection.class);
                startActivity(intent);

            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),Registration.class);
                startActivity(intent);
            }
        });
    }
}
