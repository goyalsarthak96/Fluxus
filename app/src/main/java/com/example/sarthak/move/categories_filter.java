package com.example.sarthak.move;

import android.app.Activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class categories_filter extends Fragment {

    View view;
    Button button1,button2,button3,button4;


    categories_filter_frag_listener activitycommander;

    public interface categories_filter_frag_listener{
        void button_clicked(String category_selected);
    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try
        {
           activitycommander=(categories_filter_frag_listener)activity;
        }
        catch (Exception e)
        {

        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.categories_filter,container,false);
        //RelativeLayout relativeLayout=(RelativeLayout) view.findViewById(R.id.categories_layout);
        button1=(Button)view.findViewById(R.id.cate_button1);
        button2=(Button)view.findViewById(R.id.cate_button2);
        button3=(Button)view.findViewById(R.id.cate_button3);
        button4=(Button)view.findViewById(R.id.cate_button4);
        view.setTag(R.id.category_button_id, String.valueOf(R.id.cate_button1));
        view.setTag(R.id.category_button_selected,"All Categories");
        //Toast.makeText(getContext(), "button id="+String.valueOf(R.id.cate_button1), Toast.LENGTH_LONG).show();
        //Toast.makeText(getContext(), "button id="+String.valueOf(R.id.cate_button1), Toast.LENGTH_LONG).show();
        //Toast.makeText(getContext(), "tag="+view.getTag(R.id.category_button_tag).toString(), Toast.LENGTH_LONG).show();
        //Toast.makeText(getContext(), "tag="+view.getTag(R.id.category_button_tag).toString(), Toast.LENGTH_LONG).show();

        button1.setBackgroundColor(Color.BLACK);
        button1.setTextColor(Color.RED);
        button2.setBackgroundColor(Color.DKGRAY);
        button2.setTextColor(Color.BLACK);
        button3.setBackgroundColor(Color.DKGRAY);
        button3.setTextColor(Color.BLACK);
        button4.setBackgroundColor(Color.DKGRAY);
        button4.setTextColor(Color.BLACK);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                category_change(v);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                category_change(v);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                category_change(v);
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                category_change(v);
            }
        });

        //relativeLayout.setAlpha(1f);
        return view;
    }

    public void category_change(View v)
    {
        Button b2=(Button)view.findViewById(Integer.valueOf(view.getTag(R.id.category_button_id).toString()));
        b2.setBackgroundColor(Color.DKGRAY);
        b2.setTextColor(Color.BLACK);


        view.setTag(R.id.category_button_id, String.valueOf(v.getId()));


        Button b=(Button)view.findViewById(v.getId());
        b.setBackgroundColor(Color.BLACK);
        b.setTextColor(Color.RED);
        view.setTag(R.id.category_button_selected,b.getText().toString() );

        activitycommander.button_clicked(view.getTag(R.id.category_button_selected).toString());


    }




}
