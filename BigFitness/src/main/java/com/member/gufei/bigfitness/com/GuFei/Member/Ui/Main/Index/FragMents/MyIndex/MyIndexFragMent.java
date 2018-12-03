package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.FragMents.MyIndex;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.member.gufei.bigfitness.R;
import com.member.gufei.bigfitness.base.BaseFragment;
import com.member.gufei.bigfitness.base.RecyclerviewBase.CommonAdapter;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.InformationClass.Notice.NoticeListActivity;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.AllCulbsList.AllCulbsListActivity;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.MyCenter.MyCardList.MyCardListActivity;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.MyCenter.MyCourseList.MyCourseListActivity;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.MyCenter.MyGroupClass.MyGroupClassActivity;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.MyCenter.MyPrivateTeaching.MyPrivateTeachingActivity;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.MyCenter.PayRecordList.PayRecordListActivity;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.QRCode.MyQRCode.MyQRCodeActivity;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.User.Login.LoginActivity;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.User.Set.EditPwd.EditPwdActivity;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.User.Set.SetInfoActivity;
import com.member.gufei.bigfitness.com.GuFei.Model.local.MainMsgBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.PublicSeaBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.SineForMainPageBean;
import com.member.gufei.bigfitness.util.SpUtil;
import com.uuzuche.lib_zxing.activity.CaptureActivity;

//import net.simonvt.menudrawer.MenuDrawer;

import org.joda.time.Instant;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import permissions.dispatcher.NeedsPermission;
import permissions.dispatcher.RuntimePermissions;

import static com.member.gufei.bigfitness.App.context;
import static com.member.gufei.bigfitness.Constants.ACCOUNTKEY;
import static com.member.gufei.bigfitness.Constants.HEADERURLKEY;
import static com.member.gufei.bigfitness.Constants.NICKNAMEKEY;
import static com.member.gufei.bigfitness.util.LoadImage.ImagLoader;
import static com.member.gufei.bigfitness.util.LoadImage.loadBgImg;
import static com.member.gufei.bigfitness.util.LoadImage.loadImgForRadius;
import static com.member.gufei.bigfitness.util.LoadImage.loadImgForRadius1;

/**
 * Created by GuFei_lyf on 2017/3/22
 * <p>
 * 实际业务人员主页
 */

@RuntimePermissions
public class MyIndexFragMent extends BaseFragment<MyIndexFragMentPresenter> implements MyIndexFragMentContract.View {


    @BindView(R.id.btn_mail)
    ImageView btnMail;
    @BindView(R.id.btn_scan)
    ImageView btnScan;
    @BindView(R.id.img_user)
    ImageView imgUser;
    @BindView(R.id.text_name)
    TextView textName;
    @BindView(R.id.text_user)
    TextView textUser;
    @BindView(R.id.btn_mycard)
    LinearLayout btnMycard;
    @BindView(R.id.btn_mycourse)
    LinearLayout btnMycourse;
    @BindView(R.id.btn_grouplesson)
    LinearLayout btnGrouplesson;
    @BindView(R.id.btn_classrecord)
    LinearLayout btnClassrecord;
    @BindView(R.id.btn_consumption)
    LinearLayout btnConsumption;
    @BindView(R.id.btn_set)
    LinearLayout btnSet;
    Unbinder unbinder;
    private Context context;
    private View viewContent;
    private int mType = 0;
    private String mTitle;


    private CommonAdapter<PublicSeaBean.ResultBean> commonAdapter;
    private List<PublicSeaBean.ResultBean> datas = new ArrayList<PublicSeaBean.ResultBean>();
//    MenuDrawer mDrawer;


    @Override
    public void onAttach(Context context) {
        mActivity = (Activity) context;
        mContext = context;
        super.onAttach(context);


    }


    @Override
    public void onResume() {
        super.onResume();

        refresh();

    }


    @Override
    protected void initInject() {

        getFragmentComponent().inject(this);

    }

    @Override
    protected int getLayoutId() {
        return R.layout.member_fragment_index_my;
    }


    private void refresh() {

    }


    @Override
    protected void initData() {

//        TextView textView = (TextView) viewContent.findViewById(R.id.tv_content);
//        textView.setText(this.mTitle);
        String headerurl = (String) SpUtil.get(mContext, HEADERURLKEY, "");
        String nickname = (String) SpUtil.get(mContext, NICKNAMEKEY, "");
        String account = (String) SpUtil.get(mContext, ACCOUNTKEY, "");
        boolean status = headerurl.contains("uploadFiles");
        if (status){
            loadImgForRadius(mContext, headerurl, R.mipmap.head_img_big, imgUser);
        }else {
            loadImgForRadius1(mContext, headerurl, R.mipmap.head_img_big, imgUser);
        }
//        loadImgForRadius(mContext, headerurl, R.mipmap.head_img_big, imgUser);
        textUser.setText("用户名"+account);
        textName.setText(nickname);
    }


    @Override
    public void showError(String msg) {

//        noticeSystemBtn.setVisibility(View.GONE);
    }

    @Override
    public void showEmpty() {

    }

    @Override
    public void outLogin() {
        Intent intent = new Intent(mContext, LoginActivity.class);
        startActivity(intent);
    }


    @Override
    public void Loading() {

    }


    @NeedsPermission(Manifest.permission.CAMERA)
    void Scan() {

        Intent intent = new Intent(mContext, CaptureActivity.class);
        startActivityForResult(intent, REQUEST_CODE);

    }


    @Override
    public void succeed(MainMsgBean mainMsgBean) {


    }

    @Override
    public void MainPagesucceed(SineForMainPageBean sineForMainPageBean) {


    }



    @OnClick({R.id.btn_mail, R.id.btn_scan, R.id.img_user, R.id.btn_mycard, R.id.btn_mycourse, R.id.btn_grouplesson, R.id.btn_classrecord, R.id.btn_consumption, R.id.btn_set})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_mail:
                Intent tz = new Intent(mContext,NoticeListActivity.class);
                startActivity(tz);

                break;
            case R.id.btn_scan:
                Intent mMyScan = new Intent(mContext,MyQRCodeActivity.class);
                startActivity(mMyScan);
                break;
            case R.id.img_user:
                Intent intent = new Intent(mContext, SetInfoActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_mycard:
                Intent mMyCardI = new Intent(mContext,MyCardListActivity.class);
                startActivity(mMyCardI);
                break;
            case R.id.btn_mycourse:

                Intent mMyPrivateTeachingActivity = new Intent(mContext,MyPrivateTeachingActivity.class);
                startActivity(mMyPrivateTeachingActivity);
                break;
            case R.id.btn_grouplesson:
                Intent mMyGroupClassActivity = new Intent(mContext,MyGroupClassActivity.class);
                startActivity(mMyGroupClassActivity);

                break;
            case R.id.btn_classrecord:
                Intent mMyCourseListActivity = new Intent(mContext,MyCourseListActivity.class);
                startActivity(mMyCourseListActivity);
                break;
            case R.id.btn_consumption:

                Intent mPayRecordListActivity = new Intent(mContext,PayRecordListActivity.class);
                startActivity(mPayRecordListActivity);
                break;
            case R.id.btn_set:
                Intent msetting = new Intent(mContext,EditPwdActivity.class);
                startActivity(msetting);
                break;
        }
    }
}

