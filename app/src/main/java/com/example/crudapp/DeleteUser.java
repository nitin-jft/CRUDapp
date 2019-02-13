package com.example.crudapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class DeleteUser extends AppCompatActivity {

    public DatabaseHelper db;
    Button deleteButton;
    EditText deleteUser;
    String text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_user);

        db = new DatabaseHelper(this);

        deleteUser = (EditText) findViewById(R.id.e1);
        deleteButton =(Button) findViewById(R.id.deleteButton);


        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    text = deleteUser.getText().toString();
                    int deletedUser = db.deleteUser(text);

                    if(deletedUser>1)
                    {
                        Toast.makeText(getApplicationContext(),"User DELETED !!!",Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(),"Something went wrong",Toast.LENGTH_SHORT).show();
                    }

                }


        });



    }
}
