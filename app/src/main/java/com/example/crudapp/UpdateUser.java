package com.example.crudapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateUser extends AppCompatActivity {



    EditText et1;
    EditText et2;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_user);



        db = new DatabaseHelper(this);
        et1 = (EditText) findViewById(R.id.et1);
        et2 =  (EditText) findViewById(R.id.et2);

        Button bt1 = (Button) findViewById(R.id.buttonU);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = et1.getText().toString();
                String city = et2.getText().toString();
                Person p = new Person(name,city);
                boolean check =db.updateUser(p);

                if(check==true)
                {
                    Toast.makeText(getApplicationContext(),"User UPDATED !!!",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"SOMETHING WENT WRONG !!!",Toast.LENGTH_SHORT).show();
                }


            }
        });
    }
}
