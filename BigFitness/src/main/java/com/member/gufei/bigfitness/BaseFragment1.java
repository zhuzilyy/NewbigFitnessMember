package com.member.gufei.bigfitness;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.member.gufei.bigfitness.base.BasePresenter;
import com.member.gufei.bigfitness.base.BaseView;

import javax.inject.Inject;

public abstract class BaseFragment1<T extends BasePresenter> extends Fragment implements BaseView {
    protected final String TAG = this.getClass().getSimpleName();

    /**
     * Fragment当前状态是否可见
     */
    protected boolean isVisible = false;
    /**
     * Fragment的view是否已创建
     */
    protected boolean mIsViewCreated = false;
    @Inject
    protected T mPresenter;
    protected View mView;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.xxx,container,false);
        System.out.println(TAG + "--onCreateView");


        mPresenter.attachView(this);
        mIsViewCreated = true;
        return null;
    }
    protected abstract void initData();
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        mPresenter.attachView(this);
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        System.out.println(TAG + "--onDestroyView");
        mIsViewCreated = false;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        System.out.println(TAG + "--onDestroy");
    }


    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (!mIsViewCreated)//view没有创建的时候不进行操作
            return;

        if (getUserVisibleHint()) {
            if (!isVisible) {//确保在一个可见周期中只调用一次onVisible()
                isVisible = true;
                onVisible();
            }
        } else {
            if (isVisible) {
                isVisible = false;
                onHidden();
            }
        }
    }


    /**
     * 可见
     */
    protected void onVisible() {

    }

    /**
     * fragment不可见的时候操作,onPause的时候,以及不可见的时候调用
     */
    protected void onHidden() {

    }


    @Override
    public void onResume() {//和activity的onResume绑定，Fragment初始化的时候必调用，但切换fragment的hide和visible的时候可能不会调用！
        super.onResume();
        System.out.println(TAG + "--Base onResume");
        if (isAdded() && !isHidden()) {//用isVisible此时为false，因为mView.getWindowToken为null
            onVisible();
            isVisible = true;
        }
    }

    @Override
    public void onPause() {
        System.out.println(TAG + "--Base onPause");
        if (isVisible()||isVisible) {
            onHidden();
            isVisible = false;
        }
        super.onPause();
    }

    @Override
    public void onHiddenChanged(boolean hidden) {//默认fragment创建的时候是可见的，但是不会调用该方法！切换可见状态的时候会调用，但是调用onResume，onPause的时候却不会调用
        super.onHiddenChanged(hidden);
        System.out.println(TAG + "--Base onHiddenChanged:" + hidden);
        if (!hidden) {
            onVisible();
            isVisible = true;
        } else {
            onHidden();
            isVisible = false;
        }
    }

    @Override
    public void showError(String msg) {

    }

    @Override
    public void showEmpty() {

    }

    @Override
    public void Loading() {

    }
}
