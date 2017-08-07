package com.example.mwakidoshi.bluewhite;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class Home extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawer;
    NavigationView navigationView;
    Toolbar toolbar=null;
    EditText final_result;
    EditText final_code;
    EditText expiry_date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        final_result = (EditText) findViewById(R.id.result_Number);
       final_code = (EditText) findViewById(R.id.result_code);
       expiry_date = (EditText) findViewById(R.id.expiry_date);

        final_result.setVisibility(View.INVISIBLE);
        final_code.setVisibility(View.INVISIBLE);
        expiry_date.setVisibility(View.INVISIBLE);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        Button btnPayment = (Button) findViewById(R.id.btnPayment);

        btnPayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder mBuilder = new AlertDialog.Builder(Home.this);
                mBuilder.setMessage(R.string.dialog_msg);
                mBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {


                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        Intent intent = new Intent(getBaseContext(), Home.class);
                        startActivity(intent);
                    }
                });
                AlertDialog alertDialog = mBuilder.create();
                alertDialog.show();


            }
        });


    }

    public void selectPayment(View view)
    {
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId())
        {
            case R.id.paymentMPesa:
                if (checked) {
                   // final_result.setText("you select M-Pesa");
                    final_result.setVisibility(View.INVISIBLE);
                    final_code.setVisibility(View.INVISIBLE);
                    expiry_date.setVisibility(View.INVISIBLE);
                }
                break;

            case R.id.paymentCard:
                if (checked) {
                    //final_result.setText("you select card");
                    final_result.setVisibility(View.VISIBLE);
                    final_code.setVisibility(View.VISIBLE);
                    expiry_date.setVisibility(View.VISIBLE);
                }
                else
                {
                    final_result.setVisibility(View.INVISIBLE);
                    final_code.setVisibility(View.INVISIBLE);
                    expiry_date.setVisibility(View.INVISIBLE);

                }
                break;

        }

    }

    public void selectUtility(View view) {
        boolean checked = ((CheckBox) view).isChecked();

        switch (view.getId()) {
            case R.id.checkZuku:
                if (checked) {
                    EditText edit = (EditText) findViewById(R.id.editZuku);
                    edit.setFocusableInTouchMode(true);

                }
                else
                {
                    EditText edit = (EditText) findViewById(R.id.editZuku);
                    edit.setFocusableInTouchMode(false);
                }
                break;
            case R.id.checkKPLC:
                if (checked) {
                    EditText edit = (EditText) findViewById(R.id.editKPLC);
                    edit.setFocusableInTouchMode(true);

                }
                else
                {
                    EditText edit = (EditText) findViewById(R.id.editKPLC);
                    edit.setFocusableInTouchMode(false);
                }
                break;
            case R.id.checkNCWSC:
                if (checked) {
                    EditText edit = (EditText) findViewById(R.id.editNCWSC);
                    edit.setFocusableInTouchMode(true);

                }
                else
                {
                    EditText edit = (EditText) findViewById(R.id.editNCWSC);
                    edit.setFocusableInTouchMode(false);
                }
                break;


        }
    }



    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }



    @SuppressWarnings("StatementWithEmptyBody")
    @Override

    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        android.app.FragmentManager fragmentManager = getFragmentManager();
        if (id == R.id.nav_payment) {
            // Handle the camera action
            Intent cinemaIntent = new Intent(this, Home.class);
            startActivity(cinemaIntent);
        } else if (id == R.id.nav_utility) {
            Intent cinemaIntent = new Intent(this, Utility.class);
            startActivity(cinemaIntent);
        } else if (id == R.id.nav_transaction) {
            Intent cinemaIntent = new Intent(this, Transaction.class);
            startActivity(cinemaIntent);
        }

         else if (id == R.id.nav_password) {
            Intent cinemaIntent = new Intent(this, Change_password.class);
            startActivity(cinemaIntent);

        } else if (id == R.id.nav_logout) {
            Intent cinemaIntent = new Intent(this, signin.class);
            startActivity(cinemaIntent);

        } else if (id == R.id.nav_manage) {



        }

       /* DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START); */
        return true;
    }


}