package com.example.mwakidoshi.bluewhite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class signin extends AppCompatActivity {

    TextView sign;
    TextView signupforfree;
    TextView getPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        sign = (TextView)findViewById(R.id.sin);
        signupforfree = (TextView)findViewById(R.id.signupforfree);
        getPassword = (TextView)findViewById(R.id.getpass);
        signupforfree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent it = new Intent(signin.this,signup.class);
                startActivity(it);

            }
        });

        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(signin.this,Home.class);
                startActivity(it);
            }
        });

        getPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(signin.this,Forgot_password.class);
                startActivity(it);
            }
        });

    }
}
