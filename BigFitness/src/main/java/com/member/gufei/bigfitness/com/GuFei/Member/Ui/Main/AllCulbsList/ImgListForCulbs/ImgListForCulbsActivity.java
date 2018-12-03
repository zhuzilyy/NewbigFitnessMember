package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.AllCulbsList.ImgListForCulbs;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.member.gufei.bigfitness.R;
import com.member.gufei.bigfitness.base.BaseActivity;
import com.member.gufei.bigfitness.base.RecyclerviewBase.CommonAdapter;
import com.member.gufei.bigfitness.base.RecyclerviewBase.ViewHolder;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.AllCulbsList.ImagActivity.ImageActivity;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.main.MainActivity;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.ClubImagesBean;
import com.member.gufei.bigfitness.util.SpUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.member.gufei.bigfitness.Constants.PUT_STR;
import static com.member.gufei.bigfitness.Constants.SELECTEDCULBIDKEY;
import static com.member.gufei.bigfitness.Constants.TOKENKEY;
import static com.member.gufei.bigfitness.Constants.USERIDKEY;
import static com.member.gufei.bigfitness.util.LoadImage.loadBgImg;

/*
*
* 会所图片
* */
public class ImgListForCulbsActivity extends BaseActivity<ImgListForCulbsActivityPresenter> implements ImgListForCulbsActivityContract.View {



    @BindView(R.id.tv_title)
    TextView tvTitle;

    @BindView(R.id.recyclerviewid)
    RecyclerView recyclerView;
    @BindView(R.id.swiperefreshlayoutid)
    SwipeRefreshLayout swipeRefreshLayout;
    @BindView(R.id.btn_complete)
    Button btnComplete;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    private CommonAdapter<ClubImagesBean.RowsBean> commonAdapter;

    private List<ClubImagesBean.RowsBean> datas = new ArrayList<ClubImagesBean.RowsBean>();


    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.member_activity_imgforculbs_list;
    }

    @Override
    protected void initView() {

        toolbar.setNavigationIcon(R.mipmap.back);
        setToolBar(toolbar, "");
        tvTitle.setText("会所图片");

        datas = new ArrayList<>();
        btnComplete.setVisibility(View.INVISIBLE);
//        Otherdatas = new ArrayList<>();

        commonAdapter = new CommonAdapter<ClubImagesBean.RowsBean>(R.layout.cardview_imglist_culibs, mContext, datas) {
            @Override
            protected void convert(ViewHolder holder, final ClubImagesBean.RowsBean dataBean, int position) {


                loadBgImg(mContext, dataBean.getImageURL(), R.mipmap.img_club_list, (ImageView) holder.getView(R.id.img));
//                }
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

//                        GoMainActivity(String.valueOf(dataBean.getClubId()));
                        Intent intent = new Intent(mContext, ImageActivity.class);
                        intent.putExtra(PUT_STR + "imageurl", dataBean.getImageURL());
                        startActivity(intent);

                    }
                });
            }
        };

        LinearLayoutManager LayoutManager = new LinearLayoutManager(mContext);

        recyclerView.setLayoutManager(LayoutManager);
        recyclerView.setAdapter(commonAdapter);
        commonAdapter.setShowdiy(false);
        commonAdapter.setShowFooter(false);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
//        //解决列表左右位移的问题
        staggeredGridLayoutManager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_NONE);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);
//        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        //设置进度条的颜色
        swipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary, R.color.colorPrimaryDark);
        //设置进度条的大小样式
        swipeRefreshLayout.setSize(SwipeRefreshLayout.DEFAULT);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
//                refresh();
                swipeRefreshLayout.setRefreshing(false);

            }
        });


    }

    public void GoMainActivity(String culibId) {

        SpUtil.put(mContext, SELECTEDCULBIDKEY, culibId);
        Intent intent = new Intent(ImgListForCulbsActivity.this, MainActivity.class);
        startActivity(intent);

    }

    @Override
    protected void initData() {
        refresh();
    }

    private void refresh() {
        int UserId = (int) SpUtil.get(mContext, USERIDKEY, 0);
        String token = (String) SpUtil.get(mContext, TOKENKEY, "");
        // TODO: 2018/4/3  Clubid   坐标等是假定数据
        String ClubId = (String) SpUtil.get(mContext, SELECTEDCULBIDKEY, "");

        mPresenter.getClubImages(String.valueOf(UserId),
                ClubId, token);

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
    public void succeed(ClubImagesBean clubImagesBean) {

        swipeRefreshLayout.setRefreshing(false);


        datas = clubImagesBean.getRows();


        commonAdapter.replaceData(datas);
        recyclerView.setAdapter(commonAdapter);

    }

}
