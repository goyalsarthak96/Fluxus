package com.example.sarthak.move;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.Color;
import android.graphics.Outline;
import android.graphics.Typeface;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.Window;

import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class grid_view_activity extends AppCompatActivity {

    ViewPager viewPager;
    int no_of_items=2;
    String s="(dshjkhopasjf)assfnlkaslfhslfhlkasnfsfhak";
    String temp="";
    LinearLayout event_detail_layout;
    AppBarLayout app_bar_layout;
    CardView event_card,card2,card1;
    CoordinatorLayout layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_grid_view_activity);




        //getSupportActionBar().hide();


        layout=(CoordinatorLayout)findViewById(R.id.coordinate_lay);







        CollapsingToolbarLayout collapsingToolbarLayout=(CollapsingToolbarLayout)findViewById(R.id.collapse_toolbar);
        collapsingToolbarLayout.setTitle("Working");
        collapsingToolbarLayout.setCollapsedTitleTextColor(Color.WHITE);
        collapsingToolbarLayout.setExpandedTitleColor(Color.WHITE);


        app_bar_layout=(AppBarLayout)findViewById(R.id.app_bar_layout);
        app_bar_layout.setBackgroundColor(Color.TRANSPARENT);


        event_card=(CardView)findViewById(R.id.detail_card);
        //event_card.setCardBackgroundColor(Color.argb(1500, 0, 0, 0));
        Toast.makeText(getBaseContext(),String.valueOf(event_card.getCardElevation()),Toast.LENGTH_LONG).show();
        //event_card.setMaxCardElevation(4000f);





        card1=(CardView)findViewById(R.id.detail_card1);
        //card1.setCardBackgroundColor(Color.argb(1500, 0, 0, 0));


        card2=(CardView)findViewById(R.id.detail_card2);
        //card2.setCardBackgroundColor(Color.argb(1500, 0, 0, 0));


        event_detail_layout=(LinearLayout) findViewById(R.id.card_linear_layout);


        LinearLayout.LayoutParams layoutParams=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        layoutParams.bottomMargin=20;



        LinearLayout.LayoutParams layoutParams1=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);


        int i=0;
        do {
            if(s.charAt(i)=='(')
            {
                if(!temp.equals(""))
                {
                    TextView textView=new TextView(getBaseContext());
                    textView.setText(temp);
                    textView.setLayoutParams(layoutParams);
                    textView.setTextColor(Color.BLACK);
                    textView.setTextSize(15);
                    event_detail_layout.addView(textView);
                }
                temp="";
            }
            else if(s.charAt(i)==')')
            {
                TextView textView=new TextView(getBaseContext());
                textView.setText(temp);
                textView.setLayoutParams(layoutParams1);
                textView.setTextColor(Color.BLACK);
                textView.setTypeface(null, Typeface.BOLD);
                textView.setTextSize(17);
                event_detail_layout.addView(textView);
                temp="";
            }
            else
            {
                temp=temp.concat(String.valueOf(s.charAt(i)));
            }
            i++;
        }while(i<s.length());

        if(!temp.equals(""))
        {
            TextView textView=new TextView(getBaseContext());
            textView.setText(temp);
            textView.setLayoutParams(layoutParams);
            textView.setTextColor(Color.BLACK);
            textView.setTextSize(15);
            event_detail_layout.addView(textView);
        }



        ObjectAnimator objectAnimator1=ObjectAnimator.ofFloat(card1,"cardElevation",4.0f,15.0f);
        ObjectAnimator objectAnimator2=ObjectAnimator.ofFloat(card2,"cardElevation",4.0f,15.0f);
        ObjectAnimator objectAnimator3=ObjectAnimator.ofFloat(event_card,"cardElevation",4.0f,15.0f);
        AnimatorSet animatorSet=new AnimatorSet();
        animatorSet.playTogether(objectAnimator1,objectAnimator2,objectAnimator3);
        animatorSet.setDuration(2000);
        animatorSet.start();



        /*if(savedInstanceState==null)
        {
            ViewTreeObserver observer = layout.getViewTreeObserver();
            observer.addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
                @Override
                public boolean onPreDraw() {

                    layout.getViewTreeObserver().removeOnPreDrawListener(this);


                    ObjectAnimator animator1 = ObjectAnimator.ofFloat(layout, "alpha",  0f, 1f);
                    animator1.setDuration(1000);
                    animator1.start();


                    ObjectAnimator animator = ObjectAnimator.ofFloat(layout, "rotationY",  90f, 0f);
                    animator.setDuration(1000);
                    animator.start();

                    return true;
                }
            });
        }*/






        //viewPager=(ViewPager)findViewById(R.id.categories_viewpager);
        //final pager_adapter adap=new pager_adapter(getSupportFragmentManager(),getBaseContext(),no_of_items,"grid_view");
        //viewPager.setAdapter(adap);


    }
}
