package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.CulibsListList;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.member.gufei.bigfitness.R;
import com.member.gufei.bigfitness.base.BaseActivity;
import com.member.gufei.bigfitness.base.RecyclerviewBase.CommonAdapter;
import com.member.gufei.bigfitness.base.RecyclerviewBase.ViewHolder;
import com.member.gufei.bigfitness.com.GuFei.Model.local.CodeBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.PublicSeaBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.PublicSeaMemberBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.Schedule;

import net.simonvt.menudrawer.MenuDrawer;
import net.simonvt.menudrawer.Position;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CulbsListActivity extends BaseActivity<CulbsListPresenter> implements CulbsListContract.View {


    @BindView(R.id.tv_title)
    TextView tvTitle;

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.recyclerviewid)
    RecyclerView recyclerView;
    @BindView(R.id.swiperefreshlayoutid)
    SwipeRefreshLayout swiperefreshlayoutid;
    @BindView(R.id.btn_left)
    ImageView btnLeft;
    @BindView(R.id.btn_right)
    ImageView btnRight;
    @BindView(R.id.text_culbs_type)
    TextView textCulbsType;

    private CommonAdapter<Schedule.ResultBean.DataBean> commonAdapter;
    private CommonAdapter<Schedule.ResultBean.DataBean> commonAdapterOther;
    private List<PublicSeaBean.ResultBean> datas = new ArrayList<PublicSeaBean.ResultBean>();
    MenuDrawer mDrawer;

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.member_activity_culbs_list;
    }

    @Override
    protected void initView() {

        btnLeft.setImageResource(R.mipmap.more_img);

        btnRight.setImageResource(R.mipmap.scan_img);


//        toolbar.setNavigationIcon(R.mipmap.more_img);
//        setToolBar(toolbar, "");
        tvTitle.setText("我的会所");


        commonAdapter = new CommonAdapter<Schedule.ResultBean.DataBean>(R.layout.cardview_member_allculibs, mContext, null) {
            @Override
            protected void convert(ViewHolder holder, final Schedule.ResultBean.DataBean dataBean, int position) {

            }
        };

        commonAdapter.setShowFooter(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        recyclerView.setAdapter(commonAdapter);

        mDrawer = MenuDrawer.attach(this, MenuDrawer.Type.OVERLAY, Position.LEFT);
        mDrawer.setContentView(R.layout.member_activity_all_culbs_list);
        mDrawer.setMenuView(R.layout.member_item_left);
    }

    @Override
    protected void initData() {

    }


    @Override
    public void showEmpty() {

    }

    @Override
    public void Loading() {

    }

    @Override
    public void outLogin() {

    }


    @Override
    public void succeed(PublicSeaBean publicSeaBean) {

    }

    @Override
    public void succeedEdit(CodeBean codeBean) {

    }

    @Override
    public void succeedoperate() {

    }

    @Override
    public void membersucceed(PublicSeaMemberBean publicSeaBean) {

    }


    @OnClick({R.id.btn_left, R.id.btn_right,R.id.text_culbs_type})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_left:

                mDrawer.openMenu();
                break;
            case R.id.btn_right:
                break;

                case R.id.text_culbs_type:
                break;

        }
    }




}
