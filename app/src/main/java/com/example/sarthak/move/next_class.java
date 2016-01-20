package com.example.sarthak.move;


import android.animation.ObjectAnimator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import android.widget.AdapterView;

import android.widget.ListAdapter;
import android.widget.ListView;

import android.view.Display;
public class next_class extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next_class);



        String[] options={"options1","options2","options3","options4","options5"};
        final ListAdapter adap=new listview_row_anim(this,options);


        final ListView list=(ListView)findViewById(R.id.list_view);
        list.setAdapter(adap);


        Display display = getWindowManager().getDefaultDisplay();
        final int height = display.getHeight();
        final int width = display.getWidth();


        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //view.setBackgroundColor(Color.RED);
                //view.setBackgroundResource(R.mipmap.new_back);
                //View view1[]=listview_row_anim.return_view();

                //if(view1[position]==view)
                //    Toast.makeText(getBaseContext(),"same",Toast.LENGTH_SHORT).show();
                //else
                //    Toast.makeText(getBaseContext(),"diff",Toast.LENGTH_SHORT).show();
                for(int i=4;i>=0;i--) {
                    if (i != position) {
                        ObjectAnimator animator = ObjectAnimator.ofFloat(list.getChildAt(i), "y",list.getChildAt(i).getY() , height);
                        animator.setDuration(1500);
                        animator.start();

                        //wait(3000);

                    }
                }




                //ObjectAnimator animator1= ObjectAnimator.ofFloat(view, "y", view.getY(), 0f);
                //animator1.setDuration(500);
                //animator1.start();






            }
        });



       /* final ViewTreeObserver observer = list.getViewTreeObserver();





        observer.addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {

            @Override
            public boolean onPreDraw() {
                list.getViewTreeObserver().removeOnPreDrawListener(this);



                ObjectAnimator animator= ObjectAnimator.ofFloat(imageView, "y", imageView.getY(), (float)height);

                animator.setDuration(1000);
                animator.start();








                Animator.AnimatorListener listener=new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animator) {

                    }

                    @Override
                    public void onAnimationEnd(Animator animator) {





                        ObjectAnimator obj=ObjectAnimator.ofFloat(list,"y",(float)height,0f);
                        obj.setDuration(1000);
                        obj.start();
                    }

                    @Override
                    public void onAnimationCancel(Animator animator) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animator) {

                    }
                };

                animator.addListener(listener);


                ObjectAnimator bgAnim = ObjectAnimator.ofInt(mBackground, "alpha", 0, 255);
                bgAnim.setDuration(5000);
                bgAnim.start();



                return true;
            }
        });*/
    }






}
