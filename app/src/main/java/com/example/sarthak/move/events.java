package com.example.sarthak.move;


import android.animation.ObjectAnimator;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.ActionMenuItemView;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class events extends AppCompatActivity implements frag.clicklistener,
        categories_filter.categories_filter_frag_listener{

    View view;
    String category="All Categories";
    ViewPager viewPager;
    list_adapter adapters[]=new list_adapter[3];
    ListView listview_list[]=new ListView[3];
    ArrayList<String>[] valid_string_list=new ArrayList[3];


    int height,width;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_events);


        Display display = getWindowManager().getDefaultDisplay();
        height = display.getHeight();
        width = display.getWidth();



        view=findViewById(R.id.categories_filter_frag);
        view.setVisibility(View.INVISIBLE);



        /*view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(), "sgjlkl", Toast.LENGTH_SHORT).show();
            }
        });*/
        /*layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(),"gkj",Toast.LENGTH_SHORT).show();
                /*if(v.getId()==R.id.categories_filter_frag)
                    Toast.makeText(getBaseContext(),"frag",Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(getBaseContext(),"list",Toast.LENGTH_SHORT).show();*/
        //}
        //});





        viewPager=(ViewPager)findViewById(R.id.viewpager2);
        final pager_adapter adap=new pager_adapter(getSupportFragmentManager(),getBaseContext(),category,"events");
        viewPager.setAdapter(adap);
        viewPager.setHorizontalScrollBarEnabled(true);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                //adap.update_page(position);
            }

            @Override
            public void onPageSelected(int position) {
                //Toast.makeText(getBaseContext(),"viewpager="+String.valueOf(position),Toast.LENGTH_SHORT).show();

                //frag dummy_frag=new frag();
                //dummy_frag.data_change(category,getBaseContext(),adapters[position],list[position]);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        /*viewPager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(),"lolwa",Toast.LENGTH_SHORT).show();
            }
        });*/



    }







    public void layout_clicked()
    {
        //Toast.makeText(getBaseContext(),"list_clicked",Toast.LENGTH_SHORT).show();
        if(view.getVisibility()==View.VISIBLE)
        {
            viewPager.setAlpha(1f);
            //viewPager.setClickable(true);
            view.setVisibility(View.INVISIBLE);
        }
        else
        {

        }
        //Toast.makeText(getBaseContext(),"list click detect",Toast.LENGTH_LONG).show();
    }


    @Override
    public void listview_clicked(int page_no,int position,View clicked_row) {

        if(view.getVisibility()==View.VISIBLE)
        {
            viewPager.setAlpha(1f);
            //viewPager.setClickable(true);
            view.setVisibility(View.INVISIBLE);
        }
        else
        {
            ListView listView=listview_list[page_no];
            for(int i=0;i<listView.getChildCount();i++)
            {
                if(i!=position)
                {
                    ObjectAnimator animator = ObjectAnimator.ofFloat(listView.getChildAt(i), "y",listView.getChildAt(i).getY() , height);
                    animator.setDuration(1500);
                    animator.start();
                }
            }


        }
    }

    @Override
    public void return_adapter(int page_no,list_adapter adapter,ArrayList<String> list1,ListView id) {
        adapters[page_no]=adapter;
        valid_string_list[page_no]=list1;
        listview_list[page_no]=id;
        //Toast.makeText(getBaseContext(),"events"+String.valueOf(page_no),Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_events, menu);
        //Toast.makeText(getBaseContext(), "checkpoint5", Toast.LENGTH_SHORT).show();

        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        //Toast.makeText(getBaseContext(),"checkpoint6",Toast.LENGTH_SHORT).show();

        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.category_menu) {
            //Toast.makeText(getBaseContext(),"old="+item.getItemId(),Toast.LENGTH_LONG).show();
            viewPager.setAlpha(0.2f);
            //viewPager.setClickable(false);
            view.setVisibility(View.VISIBLE);
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onBackPressed() {
        frag.category="All Categories";
        Intent intent=new Intent(events.this,MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void button_clicked(String category_selected) {
        category=category_selected;

        ActionMenuItemView menuItem=(ActionMenuItemView)findViewById(R.id.category_menu);
        menuItem.setText(category_selected);
        viewPager.setAlpha(1f);
        //viewPager.setClickable(true);
        view.setVisibility(View.INVISIBLE);



        //Toast.makeText(getBaseContext(),String.valueOf(viewPager.getCurrentItem()),Toast.LENGTH_LONG).show();
        // list_adapter adapter_used=



        //int current_page=viewPager.getCurrentItem();
        frag dummy_frag=new frag();
        dummy_frag.update_category(category);

        for(int var=0;var<3;var++)
            dummy_frag.data_change(category_selected, getBaseContext(), adapters[var], valid_string_list[var]);








        //viewPager.removeAllViews();
        //pager_adapter adap=new pager_adapter(getSupportFragmentManager(),getBaseContext(),category);
        //adap.getItem(0);
        //adap.getItem(1);
        //adap.getItem(2);


        //frag fragment1=(frag) getSupportFragmentManager().findFragmentById(R.id.dummy_fragment);
        //fragment1.data_change(category_selected);
        //finish();
        //overridePendingTransition(0, 0);
        //getIntent().putExtra("category",category);
        //startActivity(getIntent());
        //overridePendingTransition(0,0);

        //Toast.makeText(getBaseContext(),"new="+menuItem.getId(),Toast.LENGTH_LONG).show();
    }
}
