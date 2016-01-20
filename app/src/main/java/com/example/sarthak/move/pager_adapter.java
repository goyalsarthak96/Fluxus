package com.example.sarthak.move;


import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentManager;





public class pager_adapter extends FragmentPagerAdapter {


    final int PAGE_COUNT = 3;
    private String tabTitles[] = new String[] { "Day1", "Day2", "Day3" };
    static String category;
    String source;
    Context mcontext;
    int item_no;


    /*getcategoryinterface activitycommander=(getcategoryinterface);
    public interface getcategoryinterface
    {
        void return_category();
    }*/





    public pager_adapter(FragmentManager fm,Context context,String category1,String from) {
        super(fm);
        mcontext=context;
        category=category1;
        source=from;
    }


    public pager_adapter(FragmentManager fm,Context context,int item_no1,String from) {
        super(fm);
        mcontext=context;
        //category=category1;
        source=from;
        item_no=item_no1;
    }



    @Override
    public Fragment getItem(int position) {

        if(source.equals("events")) {
            //Toast.makeText(mcontext,"position="+String.valueOf(position+1)+"category="+category,Toast.LENGTH_SHORT).show();
            return frag.newInstance(position, category);
        }
        return null;
    }



    @Override
    public int getCount() {
        if(source.equals("events"))
        return PAGE_COUNT;
        else
            return item_no;
    }




    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        if(source.equals("events"))
        return tabTitles[position];
        else
            return null;
    }

}
