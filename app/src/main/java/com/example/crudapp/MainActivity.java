package com.example.crudapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {


    DatabaseHelper db = new DatabaseHelper(this);
    EditText e1;
    EditText e2;
   // EditText e3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);


        e1 = (EditText) findViewById(R.id.et1);
        e2 = (EditText) findViewById(R.id.et2);
       // e3 = (EditText) findViewById(R.id.et3);


        // Functionality for CREATE BUTTON
        Button createButton = (Button) findViewById(R.id.create);
        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String userName = e1.getText().toString();
                String userCity = e2.getText().toString();
              //  String userHobby = e3.getText().toString();

                if(userName.equals("")||userCity.equals(""))
                {
                    Toast.makeText(getApplicationContext(),"Please Fill the Data",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Person p = new Person(userName,userCity);
                    int i=db.addPerson(p);
                    if(i==1) {
                        Toast.makeText(getApplicationContext(),"Data Inserted",Toast.LENGTH_SHORT).show();
                        e1.setText("");
                        e2.setText("");
                        //e3.setText("");
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(),"Something went WRONG!!!",Toast.LENGTH_SHORT).show();
                    }
                }
            }

        });

        // Functionality for READ BUTTON
        Button readButton = (Button) findViewById(R.id.read);
        readButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // new method to open a another activity
                startActivity(new Intent(MainActivity.this,CreatePageActivity.class));
              //  finish();

            }

        });


        // Functionality od delete Button
        Button deleteButton = (Button) findViewById(R.id.delete);
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,DeleteUser.class));
               // finish();
            }
        });

        // Functionality for UPDATE Button
        Button updateButton = (Button) findViewById(R.id.update);
        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,UpdateUser.class));
               // finish();
            }
        });



    }



}
