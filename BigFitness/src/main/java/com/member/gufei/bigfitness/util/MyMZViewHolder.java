package com.member.gufei.bigfitness.util;

import com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.AllCulbsList.PrivateClass.PrivateClassDetails.PrivateClassDetailsActivity;

/**
 * Created by GuFei on 2018/4/13.
 */


public interface MyMZViewHolder<T> {
    android.view.View createView(android.content.Context context);

    void onBind(android.content.Context context, int i, T t);
    void Pause();
}
