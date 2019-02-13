package com.example.crudapp;

public class Person {

    private String name;
    private String city;
   // private String hobby;
    //private int id;



    public Person(String name, String city) {
        this.name = name;
        this.city = city;
      //  this.hobby = hobby;
        //this.id =id;
    }

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }






}
