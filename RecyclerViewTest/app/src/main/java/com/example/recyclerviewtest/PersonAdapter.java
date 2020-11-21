package com.example.recyclerviewtest;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;


public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.ViewHolder>{

    private List<Person> mPersonList;

    static class ViewHolder extends RecyclerView.ViewHolder{
        View personView;
        ImageView personImage;
        TextView personName;
        Button send;
        Button dia;


        public ViewHolder(View view) {
            super(view);
            personView = view;
            personImage = (ImageView) view.findViewById(R.id.person_image);
            personName = (TextView) view.findViewById(R.id.person_name);
            send = (Button) view.findViewById(R.id.send);
            dia = (Button) view.findViewById(R.id.dia);

        }
    }

    public PersonAdapter(List<Person> personList){
        mPersonList = personList;
    }

    @Override
    public ViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.person_item, parent, false);
        final  ViewHolder holder = new ViewHolder(view);
        holder.send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("android.intent.action.ACTION_SEND");
                parent.getContext().startActivity(intent);
            }
        });
        holder.dia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:15819091730"));
                parent.getContext().startActivity(intent);
            }
        });

        holder.personView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                Person person = mPersonList.get(position);
                Toast.makeText(v.getContext(),"You clicked view" + person.getName(),
                Toast.LENGTH_SHORT).show();


            }

        });
        holder.personImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                Person person = mPersonList.get(position);
                Toast.makeText(v.getContext(),"You clicked image" + person.getName(),
                        Toast.LENGTH_SHORT).show();
                if (person.getName() == "邓超 "){
                    Intent intent = new Intent("android.intent.action.ACTION_DC");
                    parent.getContext().startActivity(intent);
                }
                if (person.getName() == "陈伟霆"){
                    Intent intent = new Intent("android.intent.action.ACTION_CWT");
                    parent.getContext().startActivity(intent);
                }

            }

        });



        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Person person = mPersonList.get(position);
        holder.personImage.setImageResource(person.getImageId());
        holder.personName.setText(person.getName());
    }

    @Override
    public int getItemCount() {
        return mPersonList.size();
    }

}
