package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.AllCulbsList.ImagActivity;

import com.member.gufei.bigfitness.base.RxPresenter;
import com.member.gufei.bigfitness.com.GuFei.NetWork.Api;

import javax.inject.Inject;


public class ImageActivityPresenter extends RxPresenter<ImageActivityContract.View> implements ImageActivityContract.Presenter {
    private Api api;


    @Inject
    public ImageActivityPresenter(Api api) {
        this.api = api;
    }
}
