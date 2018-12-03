package com.member.gufei.bigfitness.com.GuFei.Moudel;

import android.app.Activity;
import android.support.v4.app.Fragment;


import com.member.gufei.bigfitness.com.GuFei.Component.FragmentScope;

import dagger.Module;
import dagger.Provides;

/**
 * @author GuFei
 * @version 2016 10 04 14:57
 *    Fragment Module 基类
 */
@Module
public class FragmentModule {

    private Fragment fragment;

    public FragmentModule(Fragment fragment) {
        this.fragment = fragment;
    }

    @Provides
    @FragmentScope
    public Activity provideActivity() {
        return fragment.getActivity();
    }
}