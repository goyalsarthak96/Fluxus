package com.example.sarthak.move;

import android.content.Context;

import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.view.LayoutInflater;
import android.widget.TextView;


import java.util.ArrayList;


public class listview_row_anim extends ArrayAdapter<String> {

    Context context1;

    static View view[]=new View[5];
    listview_row_anim(Context context, String[] contents)
    {
        super(context,R.layout.listview_row_anim,contents);
        context1=context;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


            LayoutInflater layoutInflater = LayoutInflater.from(getContext());

            convertView = layoutInflater.inflate(R.layout.listview_row_anim, parent, false);
            TextView t1=(TextView) convertView.findViewById(R.id.anim_text);

            t1.setText(getItem(position));
        t1.setTextColor(Color.WHITE);
        //convertView.setBackgroundResource(R.mipmap.new_back_orig);
        view[position]=convertView;


        return convertView;


    }

    static public View[] return_view()
    {
        return view;
    }


}
