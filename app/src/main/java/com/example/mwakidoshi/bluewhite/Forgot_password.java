package com.example.mwakidoshi.bluewhite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Forgot_password extends AppCompatActivity {

    ImageView fback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        fback = (ImageView)findViewById(R.id.fback);
        fback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent it = new Intent(Forgot_password.this, signin.class);
                startActivity(it);

            }
        });
    }
}
