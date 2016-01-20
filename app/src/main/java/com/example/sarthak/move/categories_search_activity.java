package com.example.sarthak.move;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Explode;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.view.Window;


public class categories_search_activity extends AppCompatActivity {

    //TextView tech_text,cult_text,informal_text,pronites_text,literary_text;
    RelativeLayout clicked_layout;
    TextView target_textview;
    ImageView target_image;
    int text_id,layout_id,image_id;
    int[] id_list={R.id.technical_text_layout,R.id.pronites_text_layout,R.id.cultural_text_layout,
                R.id.informal_text_layout,R.id.literary_text_layout};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories_search_activity);



        //getWindow().setExitTransition(new Explode());

        /*tech_text=(TextView)findViewById(R.id.technical_text);
        cult_text=(TextView)findViewById(R.id.cultural_text);
        informal_text=(TextView)findViewById(R.id.informal_text);
        pronites_text=(TextView)findViewById(R.id.pro_nites_text);
        literary_text=(TextView)findViewById(R.id.literary_text);
*/

        //informal_layout=(LinearLayout)findViewById(R.id.informal_text_layout);
    }


    public void click(View v)
    {

        layout_id=v.getId();
        switch (v.getId())
        {
            case R.id.technical_text_layout:  text_id=R.id.technical_text;
                                                image_id=R.id.technical_image;
                                                break;
            case R.id.cultural_text_layout:   text_id=R.id.cultural_text;
                                                image_id=R.id.cultural_image;
                                            break;
            case R.id.informal_text_layout:    text_id=R.id.informal_text;
                                                image_id=R.id.informal_image;
                                                break;
            case R.id.literary_text_layout:    text_id=R.id.literary_text;
                                                image_id=R.id.literary_image;
                                                break;
            case R.id.pronites_text_layout:    text_id=R.id.pro_nites_text;
                                                image_id=R.id.pronites_image;
                                                break;
        }


        for(int i=0;i<5;i++)
        {
            if(id_list[i]!=v.getId())
            findViewById(id_list[i]).setVisibility(View.INVISIBLE);
        }



        clicked_layout=(RelativeLayout)findViewById(v.getId());
        target_textview=(TextView)findViewById(text_id);
        target_image=(ImageView)findViewById(image_id);

        //clicked_layout.setGravity(Gravity.CENTER);

        float view_width=clicked_layout.getWidth();
        float view_height=clicked_layout.getHeight();


        /*RelativeLayout.LayoutParams layoutParams=new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT);
        layoutParams.addRule(RelativeLayout.CENTER_IN_PARENT, RelativeLayout.TRUE);
        clicked_layout.setLayoutParams(layoutParams);*/

        /*RelativeLayout parent=(RelativeLayout)clicked_layout.getParent();

        float parent_height = parent.getHeight();
        float parent_width  = parent.getWidth();

        float newx=(parent_width-view_width)/2;
        float newy=(parent_height-view_height)/2;
        //clicked_layout.setX(newx);
        //clicked_layout.setY(newy);
        //clicked_layout.setScaleX(2f);
        //clicked_layout.setScaleY(2f);


        //Toast.makeText(getBaseContext(),"newx="+String.valueOf(new_x)+" oldx="+String.valueOf(old_x),Toast.LENGTH_LONG).show();
        //Toast.makeText(getBaseContext(),"newy="+String.valueOf(new_y)+" oldy="+String.valueOf(old_y),Toast.LENGTH_LONG).show();
        ObjectAnimator animator8=ObjectAnimator.ofFloat(clicked_layout, "x", newx );
        ObjectAnimator animator9=ObjectAnimator.ofFloat(clicked_layout,"y",newy);
        AnimatorSet animatorSet1=new AnimatorSet();
        animatorSet1.playTogether(animator8, animator9);
        animatorSet1.setDuration(700);
        //animatorSet1.start();


        ObjectAnimator animator =ObjectAnimator.ofFloat(target_image,"rotationY",720f);
        ObjectAnimator animator1=ObjectAnimator.ofFloat(target_textview,"alpha",0f);
       // ObjectAnimator animator2=ObjectAnimator.ofFloat(clicked_layout,"scaleX",2f);
       // ObjectAnimator animator3=ObjectAnimator.ofFloat(clicked_layout, "scaleY", 2f);
*/








        Animator.AnimatorListener animatorListener=new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                Intent intent=new Intent(categories_search_activity.this,grid_view_activity.class);
                startActivity(intent);
                overridePendingTransition(0, 0);
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        };




        ObjectAnimator animator =ObjectAnimator.ofFloat(target_image,"rotationY",180f,90f);
        animator.setDuration(5000);
        animator.addListener(animatorListener);


        Intent intent=new Intent(categories_search_activity.this,grid_view_activity.class);
        startActivity(intent);
        overridePendingTransition(0, 0);
        //animator.start();

        //ObjectAnimator animator4=ObjectAnimator.ofInt(clicked_layout, "gravity", RelativeLayout.CENTER_IN_PARENT);



        /*AnimatorSet animatorSet=new AnimatorSet();
        animatorSet.playTogether(animator, animator1);
        animatorSet.setDuration(1000);
        animatorSet.addListener(animatorListener);
        //animatorSet.start();



        //clicked_layout.setGravity(RelativeLayout.CENTER_IN_PARENT);
        //Toast.makeText(getBaseContext(),clicked_layout.getParent().toString(),Toast.LENGTH_SHORT).show();*/

    }







}
