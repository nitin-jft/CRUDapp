package com.example.crudapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import java.util.ArrayList;

public class CreatePageActivity extends AppCompatActivity {


    public DatabaseHelper db;
    public TextView tv1;
    public TextView tv2;
    public TextView tv3;

    String name;
    String city;
    String hobby;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_page);

        db = new DatabaseHelper(this);
        tv1 = (TextView) findViewById(R.id.t1);
        tv2 = (TextView) findViewById(R.id.t2);
        tv3 = (TextView) findViewById(R.id.t2);

        ArrayList<Person> person = db.viewPerson();

       /* ArrayList<String> list = new ArrayList<>();
        list.add("Nitin");
        list.add("Sharma");
        list.add("Mudit");
        list.add("Punia");
        list.add("Himanshu");
        list.add("Amit");
        list.add("Ankit");
        list.add("Rahul");
        list.add("Ram"); */


        RecyclerView r1 = (RecyclerView) findViewById(R.id.r1);
        r1.setLayoutManager(new LinearLayoutManager(this));
        r1.setAdapter(new MyAdapter(person));

        //finish();



    }






}
