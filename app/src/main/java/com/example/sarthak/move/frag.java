package com.example.sarthak.move;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.widget.AdapterView;
import android.widget.ListView;
import android.view.*;
import android.widget.Toast;


import java.util.ArrayList;



public class frag extends Fragment {


    public static final String ARG_PAGE = "ARG_PAGE";
    public static final String category_string = "CATEGORY";
    static String category="All Categories";

    String[] event_detail={ "event1,desc1,hh:mm-hh:mm",
                                "event2,desc2,hh:mm-hh:mm",
                                "event3,desc3,hh:mm-hh:mm",
                                "event4,desc4,hh:mm-hh:mm",
                                "event5,desc5,hh:mm-hh:mm",
                                "event6,desc6,hh:mm-hh:mm"
                                };
    String[] event_type={  "Technical","Cultural","Technical","Informal","Cultural","Informal"};
    //String[] valid_event_list = new String[event_detail.length];

    ArrayList<String> valid_event_list=new ArrayList<>();
    int mPage;
    //private List<String> mItems = new ArrayList<String>();

    list_adapter adapter;

    clicklistener activitycommander;
    public interface clicklistener
    {
        void layout_clicked();
        void return_adapter(int page_no,list_adapter adapter,ArrayList<String> list1,ListView id);
        void listview_clicked(int page_no,int position,View view);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try
        {
            activitycommander=(clicklistener)activity;
        }
        catch (Exception e){

        }
    }

    public static frag newInstance(int page,String category1) {

        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        //args.putString(category_string,category1);
        frag fragment = new frag();
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        mPage = getArguments().getInt(ARG_PAGE);
        //category=getArguments().getString(category_string);

        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_layout, container, false);

        //category=getArguments().getString(category_string);
        Toast.makeText(getContext(),"page"+String.valueOf(mPage)+"category"+category,Toast.LENGTH_SHORT).show();


        //valid_event_list=event_detail;

        valid_event_list.clear();

        if (category.equals("All Categories")) {
            for (int i = 0; i < event_type.length; i++) {
                valid_event_list.add(event_detail[i]);
            }
            //valid_event_list=event_detail;
        } else {
            //Toast.makeText(context,category_sel,Toast.LENGTH_LONG).show();
            int i;

            for (i = 0; i < event_type.length; i++) {
                if (event_type[i].equals(category)) {
                    valid_event_list.add(event_detail[i]);

                    //Toast.makeText(context,valid_event_list[j-1],Toast.LENGTH_SHORT).show();
                }
            }
        }





            //TextView textView = (TextView) view.findViewById(R.id.textView);
            //textView.setText("Fragment #" + mPage);
            //Toast.makeText(getContext(),"onCreateView",Toast.LENGTH_LONG).show();
        ListView listView=(ListView) view.findViewById(R.id.event_list);
                /*listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Toast.makeText(getContext(),"listview",Toast.LENGTH_LONG).show();
                    }
                });*/



        adapter=new list_adapter(getContext(),valid_event_list);

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getContext(),"list clicked",Toast.LENGTH_SHORT).show();
                activitycommander.listview_clicked(mPage,position,view);
            }
        });
        activitycommander.return_adapter(mPage, adapter, valid_event_list,listView);


        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"view clicked",Toast.LENGTH_SHORT).show();
                activitycommander.layout_clicked();
            }
        });
        //Toast.makeText(getContext(),"frag"+String.valueOf(mPage),Toast.LENGTH_LONG).show();
        return view;
    }



    public void update_category(String category1)
    {
        category=category1;
    }


    public void data_change(String category_sel,Context context,list_adapter adapter1,ArrayList<String> list) {

        if (adapter1 != null) {
            list.clear();
            //Toast.makeText(context,"data_change",Toast.LENGTH_LONG).show();
            if (category_sel.equals("All Categories")) {
                for (int i = 0; i < event_type.length; i++) {
                    list.add(event_detail[i]);
                }
                //valid_event_list=event_detail;
            } else {
                //Toast.makeText(context,category_sel,Toast.LENGTH_LONG).show();
                int i;

                for (i = 0; i < event_type.length; i++) {
                    if (event_type[i].equals(category_sel)) {
                        list.add(event_detail[i]);

                        //Toast.makeText(context,valid_event_list[j-1],Toast.LENGTH_SHORT).show();
                    }
                }
            /*for(int k=j;k<event_type.length;k++)
              {
                valid_event_list[k]="";
               }*/
                //}
                //Toast.makeText(context,String.valueOf(adapter1.tag),Toast.LENGTH_SHORT).show();

            }
            adapter1.change_list();
        }
    }




}
