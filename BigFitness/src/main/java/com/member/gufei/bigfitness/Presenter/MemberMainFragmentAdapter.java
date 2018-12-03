package com.member.gufei.bigfitness.Presenter;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;


import java.util.List;

/**
 * Created by Administrator on 2018/3/2.
 */

public class MemberMainFragmentAdapter extends FragmentStatePagerAdapter {

    public static final String TAB_TAG = "@dream@";

    private List<String> mTitles;
    private List<Fragment> mFragMentList;

    public MemberMainFragmentAdapter(FragmentManager fm, List<String> titles,List<Fragment> fragments) {
        super(fm);

        mFragMentList = fragments;
        mTitles = titles;

    }


    @Override
    public Fragment getItem(int position) {
//        //初始化Fragment数据
//        ContentFragment fragment = new ContentFragment();
//        String[] title = mTitles.get(position).split(TAB_TAG);
//        fragment.setType(Integer.parseInt(title[1]));
//        fragment.setTitle(title[0]);

            return mFragMentList.get(position);
    }


    @Override
    public int getCount() {
        return mFragMentList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        Log.e("getPageTitle",position+"");
        for (int i=0;i<mTitles.size();i++){
            Log.e("mTitles",mTitles.get(i).toString()+"");
        }
        return mTitles.get(position).split(TAB_TAG)[0];
    }
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        Fragment fragment = ((Fragment) object);
    }

    @Override
    public boolean isViewFromObject(View view, Object obj) {
        return view == ((Fragment) obj).getView();
    }

}
