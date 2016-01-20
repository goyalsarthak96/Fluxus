package com.example.sarthak.move;

import android.content.Context;

import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;



/*
 * Created by Sarthak on 1/5/2016.
 */
public class list_adapter extends ArrayAdapter<String> {

    Context context1;

    //String[] array;
    list_adapter(Context context, ArrayList<String> contents)
    {
        super(context,R.layout.frag_layout,contents);
        context1=context;
        //array=contents;
        //Toast.makeText(getContext(),"constructor",Toast.LENGTH_SHORT).show();

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final viewholder vholder;
        if(convertView==null) {
            LayoutInflater layoutInflater = LayoutInflater.from(getContext());
            convertView = layoutInflater.inflate(R.layout.event_row, parent, false);
            convertView.setBackgroundColor(Color.TRANSPARENT);

            vholder=new viewholder();

            vholder.t1 = (TextView) convertView.findViewById(R.id.event_name);
            vholder.t2 = (TextView) convertView.findViewById(R.id.event_type);
            vholder.t3 = (TextView) convertView.findViewById(R.id.event_timing);
            vholder.im= (ImageView) convertView.findViewById(R.id.star_image);
            convertView.setTag(vholder);
        }
        else
        {
            vholder=(viewholder)convertView.getTag();
        }
        String event_info = getItem(position);
        int i,j=0,start=0;
        for(i=0;i<event_info.length();i++)
        {
            if(event_info.charAt(i)==',')
            {
                //Toast.makeText(getContext(),"at "+String.valueOf(i),Toast.LENGTH_SHORT).show();
                switch (j)
                {
                    case 0:vholder.t1.setText(event_info.substring(start, i));
                        break;
                    case 1:vholder.t2.setText(event_info.substring(start, i));

                        vholder.t3.setText(event_info.substring(i + 1));
                        break;
                     //default:Toast.makeText(getContext(),":(",Toast.LENGTH_SHORT).show();
                }
                start=i+1;
                j++;
            }
        }

        vholder.im.setTag(R.id.star_image_tag, "unfilled");
        vholder.im.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "image", Toast.LENGTH_LONG).show();
                if (vholder.im.getTag(R.id.star_image_tag).equals("unfilled")) {
                    vholder.im.setImageResource(R.mipmap.starfilled);
                    vholder.im.setTag(R.id.star_image_tag, "filled");
                } else {
                    vholder.im.setTag(R.id.star_image_tag, "unfilled");
                    vholder.im.setImageResource(R.mipmap.starunfilled);
                }
            }
        });


        /*convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"list")
            }
        });*/
            return convertView;


    }


    public void change_list()
    {
        //for(int i=0;i<array.length;i++)
        //    Toast.makeText(getContext(),array[i],Toast.LENGTH_SHORT).show();
        notifyDataSetChanged();
        //Toast.makeText(getContext(),"change list",Toast.LENGTH_SHORT).show();
    }

    /*@Override
    public void notifyDataSetChanged() {
        Toast.makeText(getContext(),"notify",Toast.LENGTH_LONG).show();
        super.notifyDataSetChanged();
    }*/
}
