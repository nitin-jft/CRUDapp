package com.example.crudapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.strictmode.SqliteObjectLeakedViolation;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {


    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "crud.db";
    public static final String TABLE_NAME ="_crud_table";
  //  public static final String COLUMN_ID= "_id";
    public static final String COLUMN_NAME ="_name";
    public static final String COLUMN_CITY ="_city";
 //   public static final String COLUMN_HOBBY ="_hobby";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        //create table

        String query = " CREATE TABLE " + TABLE_NAME + "(" +
            //    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT ," +
                COLUMN_NAME + " TEXT ," +
                COLUMN_CITY + " TEXT " +
                ");";



        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        //Upgrading database
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);

        // Create tables again
        onCreate(db);

    }


    // Inserting person

    public int addPerson(Person person){

        int i = 0;
        ContentValues values = new ContentValues();

      //  values.put(COLUMN_ID, person.getId());
        values.put(COLUMN_NAME, person.getName());
        values.put(COLUMN_CITY, person.getCity());
      //  values.put(COLUMN_HOBBY,person.getHobby());

        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_NAME, null, values);
        i=1;
        db.close();
        return  i;
    }



    // view user method to READ db

    public ArrayList<Person> viewPerson()
    {
        String query = " SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.rawQuery(query,null);


        ArrayList<Person> personArrayList = new ArrayList<>();


        if (cursor.moveToFirst())
        {
            do {
                Person p1 = new Person();
             //   p1.setId(cursor.getInt(0));
                p1.setName(cursor.getString(0));
                p1.setCity(cursor.getString(1));
             //   p1.setHobby(cursor.getString(2));
                personArrayList.add(p1);
            }
            while(cursor.moveToNext());
        }

        db.close();
        return  personArrayList;

    }

    // DELETE user data

    public int deleteUser(String text)
    {
        int counter= 1 ;
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(" DELETE FROM " + TABLE_NAME + " WHERE " + COLUMN_NAME + "=\"" + text + "\";");
        counter++;
        db.close();
        return counter;
    }

    public boolean updateUser(Person person)
    {

        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME,person.getName());
        values.put(COLUMN_CITY,person.getCity());
        db.update(TABLE_NAME,values," _name=?",new String[]{person.getName()});
        db.close();
        return true;
    }
























    // display data

    public String databaseToString(){

        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME ;

        //Cursor points to a location in your results
        Cursor record = db.rawQuery(query, null);
        record.moveToFirst();


        String row = record.getString(record.getColumnIndex("name"));
        return row;

    }


}
