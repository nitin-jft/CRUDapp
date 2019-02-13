package com.example.crudapp;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

   /* String name;
    String city;
    String hobby;


   public MyAdapter(Person p)
   {
      name = p.getName();
      city = p.getCity();
      hobby = p.getHobby();
   } */





   public ArrayList<Person> myPeople ;

   public MyAdapter(ArrayList<Person> myPeople)
   {
       this.myPeople = myPeople;
   }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.mylayout,viewGroup,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {


       Person p = myPeople.get(i);
         //  myViewHolder.text0.setText(p.getId());
           myViewHolder.name.setText(p.getName());
           myViewHolder.city.setText(p.getCity());
          // myViewHolder.hobby.setText(p.getHobby());


    }

    @Override
    public int getItemCount() {
        return myPeople.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView imgicon;
        TextView text0;
        TextView name;
        TextView city;
       // TextView hobby;
        public MyViewHolder(@NonNull View itemView) {
                super(itemView);
               imgicon = (ImageView) itemView.findViewById(R.id.imgicon);
               // text0 =   (TextView) itemView.findViewById(R.id.t0);
                name =    (TextView) itemView.findViewById(R.id.t1);
                city=    (TextView) itemView.findViewById(R.id.t2);
             //   hobby=    (TextView) itemView.findViewById(R.id.t2);
            }
        }
    }

