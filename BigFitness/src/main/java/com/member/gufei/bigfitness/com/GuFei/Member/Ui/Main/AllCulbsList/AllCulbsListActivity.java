package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.AllCulbsList;

import android.app.ActivityManager;
import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.member.gufei.bigfitness.R;
import com.member.gufei.bigfitness.base.BaseActivity;
import com.member.gufei.bigfitness.base.RecyclerviewBase.CommonAdapter;
import com.member.gufei.bigfitness.base.RecyclerviewBase.ViewHolder;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.InformationClass.Notice.NoticeListActivity;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.main.MainActivity;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.QRCode.MyQRCode.MyQRCodeActivity;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.User.Login.LoginActivity;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.User.Set.EditPwd.EditPwdActivity;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.User.Set.SetInfoActivity;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.ClubListForMemberBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.ClubListForMemberNoBuyBean;
import com.member.gufei.bigfitness.util.SpUtil;
import com.youth.banner.loader.ImageLoader;

import net.simonvt.menudrawer.MenuDrawer;
import net.simonvt.menudrawer.Position;

import java.util.ArrayList;
import java.util.List;

import static com.member.gufei.bigfitness.Constants.ACCOUNTKEY;
import static com.member.gufei.bigfitness.Constants.HEADERURLKEY;
import static com.member.gufei.bigfitness.Constants.LATITUDEKEY;
import static com.member.gufei.bigfitness.Constants.LOCATIONKEY;
import static com.member.gufei.bigfitness.Constants.LONGITUDEKEY;
import static com.member.gufei.bigfitness.Constants.NICKNAMEKEY;
import static com.member.gufei.bigfitness.Constants.PUT_STR;
import static com.member.gufei.bigfitness.Constants.SELECTEDCULBIDKEY;
import static com.member.gufei.bigfitness.Constants.TOKENKEY;
import static com.member.gufei.bigfitness.Constants.USERIDKEY;
import static com.member.gufei.bigfitness.util.LoadImage.ImagLoader;
import static com.member.gufei.bigfitness.util.LoadImage.loadBgImg;
import static com.member.gufei.bigfitness.util.LoadImage.loadImgForRadius;
import static com.member.gufei.bigfitness.util.ToastUtil.s;

public class AllCulbsListActivity extends BaseActivity<AllCulbsListPresenter> implements AllCulbsListContract.View {


    TextView tvTitle;
    TextView textNickName;
    TextView textUserName;


    RecyclerView recyclerView;
    SwipeRefreshLayout swipeRefreshLayout;
    ImageView btnLeft;
    ImageView btnRight;
    ImageView btnBack;
    ImageView imgUser;
    RelativeLayout btnSet;
    RelativeLayout btnMessage;

    private CommonAdapter<ClubListForMemberBean.RowsBean.AllClubBean> commonAdapter;
    private CommonAdapter<ClubListForMemberBean.RowsBean.MyClubBean> commonAdapterMy;
    private CommonAdapter<ClubListForMemberNoBuyBean.RowsBean> commonAdapterOther;
    private List<ClubListForMemberBean.RowsBean.AllClubBean> datas = new ArrayList<ClubListForMemberBean.RowsBean.AllClubBean>();
    private List<ClubListForMemberBean.RowsBean.MyClubBean> Mydatas = new ArrayList<ClubListForMemberBean.RowsBean.MyClubBean>();
//    private List<ClubListForMemberNoBuyBean.RowsBean> Otherdatas = new ArrayList<ClubListForMemberNoBuyBean.RowsBean>();
    MenuDrawer mDrawer;
    private boolean isLoadingMore = true;//加载标志位
    private int Page = 1;
    private boolean mLoading = false;
    private boolean FirstShow = true;
    private String mListType = "我的会所";
    private static int refresh = 0;
    private int TotalPage;
    private int MyTotalPage;

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.member_activity_all_culbs_list;
    }

    @Override
    protected void initView() {

        mDrawer = MenuDrawer.attach(this, MenuDrawer.Type.OVERLAY, Position.LEFT);
        mDrawer.setContentView(R.layout.member_activity_all_culbs_list);
        mDrawer.setMenuView(R.layout.member_item_left);


        String headerurl = (String) SpUtil.get(mContext, HEADERURLKEY, "");
        String nickname = (String) SpUtil.get(mContext, NICKNAMEKEY, "");
        String account = (String) SpUtil.get(mContext, ACCOUNTKEY, "");


        btnBack = (ImageView) mDrawer.getMenuView().findViewById(R.id.btn_back);
        imgUser = (ImageView) mDrawer.getMenuView().findViewById(R.id.img_user);
        btnSet = (RelativeLayout) mDrawer.getMenuView().findViewById(R.id.btn_set);
        btnMessage = (RelativeLayout) mDrawer.getMenuView().findViewById(R.id.btn_message);
        textNickName = (TextView) mDrawer.getMenuView().findViewById(R.id.text_nickname);
        textUserName = (TextView) mDrawer.getMenuView().findViewById(R.id.text_user_name);
//        loading();

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDrawer.closeMenu();
            }
        });

        btnMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(AllCulbsListActivity.this, NoticeListActivity.class);
                startActivity(intent);

            }
        });
        btnSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AllCulbsListActivity.this, EditPwdActivity.class);
                startActivity(intent);


            }
        });

        imgUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AllCulbsListActivity.this, SetInfoActivity.class);
                startActivity(intent);
            }
        });

        textNickName.setText(nickname);
        textUserName.setText("用户名：" + account);
        boolean status = headerurl.contains("uploadFiles");
        if (status){
            loadBgImg(mContext, headerurl, R.mipmap.head_img_big, imgUser);
        }else {
            ImagLoader(mContext, headerurl, R.mipmap.head_img_big, imgUser);
        }

//        if (!headerurl.equals("")){
//            SpUtil.put(mContext, HEADERURLKEY, headerurl);
//        }

        tvTitle = (TextView) mDrawer.findViewById(R.id.tv_title);
        recyclerView = (RecyclerView) mDrawer.findViewById(R.id.recyclerviewid);
        swipeRefreshLayout = (SwipeRefreshLayout) mDrawer.findViewById(R.id.swiperefreshlayoutid);
        btnLeft = (ImageView) mDrawer.findViewById(R.id.btn_left);
        btnRight = (ImageView) mDrawer.findViewById(R.id.btn_right);


//        btnLeft.setVisibility(View.GONE);
        btnLeft.setImageResource(R.mipmap.more_img);
        btnLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDrawer.openMenu();
            }
        });

        btnRight.setImageResource(R.mipmap.scan_img);
        btnRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AllCulbsListActivity.this, MyQRCodeActivity.class);
                startActivity(intent);

            }
        });


        tvTitle.setText("所有会所");

        datas = new ArrayList<>();
        Mydatas = new ArrayList<>();
//        Otherdatas = new ArrayList<>();

        commonAdapter = new CommonAdapter<ClubListForMemberBean.RowsBean.AllClubBean>(R.layout.cardview_member_allculibs, mContext, datas) {
            @Override
            protected void convert(ViewHolder holder, final ClubListForMemberBean.RowsBean.AllClubBean dataBean, int position) {

                holder.setText(R.id.text_name_culibs, dataBean.getClubName());
                holder.setText(R.id.text_time_culibs, "营业时间:" + dataBean.getBusinessStartHours() + "-" + dataBean.getBusinessEndHours());
                holder.setText(R.id.text_address_culibs, "地址:" + dataBean.getAddress());
                holder.setText(R.id.text_distance, "距离:" + dataBean.getDistance() + "km");
                String imageURL = dataBean.getImageURL();
                Log.i("tag",imageURL+"=====imageURL========");
//                if (!dataBean.getImageURL().equals("null")) {
                loadBgImg(mContext, dataBean.getImageURL(), R.mipmap.img_bg_list, (ImageView) holder.getView(R.id.img_bg));
//                }
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if (dataBean.getStatus() == 0){
                            GoMainActivity(String.valueOf(dataBean.getClubId()));
                        }else {
                            Toast.makeText(mContext, "该会所已锁定", Toast.LENGTH_SHORT).show();
                        }

                    }
                });
            }
        };


        commonAdapterMy = new CommonAdapter<ClubListForMemberBean.RowsBean.MyClubBean>(R.layout.cardview_member_allculibs, mContext, Mydatas) {
            @Override
            protected void convert(ViewHolder holder, final ClubListForMemberBean.RowsBean.MyClubBean dataBean, int position) {

                holder.setText(R.id.text_name_culibs, dataBean.getClubName());
                holder.setText(R.id.text_time_culibs, "营业时间:" + dataBean.getBusinessStartHours() + "-" + dataBean.getBusinessEndHours());
                holder.setText(R.id.text_address_culibs, "地址:" + dataBean.getAddress());
                holder.setText(R.id.text_distance, "距离:" + dataBean.getDistance() + "km");
//                if (!dataBean.getImageURL().equals("null")) {
                loadBgImg(mContext, dataBean.getImageURL(), R.mipmap.img_bg_list, (ImageView) holder.getView(R.id.img_bg));
//                }
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

//                        GoMainActivity(String.valueOf(dataBean.getClubId()));
                        if (dataBean.getStatus() == 0){
                            GoMainActivity(String.valueOf(dataBean.getClubId()));
                        }else {
                            Toast.makeText(mContext, "该会所已锁定", Toast.LENGTH_SHORT).show();
                        }

                    }
                });

            }
        };

//        commonAdapterOther = new CommonAdapter<ClubListForMemberNoBuyBean.RowsBean>(R.layout.cardview_member_allculibs, mContext, Otherdatas) {
//            @Override
//            protected void convert(ViewHolder holder, final ClubListForMemberNoBuyBean.RowsBean dataBean, int position) {
//
//                holder.setText(R.id.text_name_culibs, dataBean.getClubName());
//                holder.setText(R.id.text_time_culibs, "营业时间:" + dataBean.getIntroduce());
//                holder.setText(R.id.text_address_culibs, "地址:" + dataBean.getAddress());
//                holder.setText(R.id.text_distance, "距离:" + "" + "km");
//                if (!dataBean.getImageURL().equals("")) {
//                    loadBgImg(mContext, dataBean.getImageURL(), R.mipmap.img_bg_list, (ImageView) holder.getView(R.id.img_bg));
//                }
//
//
//            }
//        };


        LinearLayoutManager LayoutManager = new LinearLayoutManager(mContext);
//        LayoutManager.setAutoMeasureEnabled(true);

        recyclerView.setLayoutManager(LayoutManager);
        recyclerView.setAdapter(commonAdapter);

//        commonAdapterMy.setShowFooter(false);
        commonAdapter.setShowFooter(true);

        commonAdapter.setfootOnClickListener(new CommonAdapter.FootOnClickListener() {
            @Override
            public void OnClick() {
                refresh(2);
            }
        });
        commonAdapterMy.setfootOnClickListener(new CommonAdapter.FootOnClickListener() {
            @Override
            public void OnClick() {
                refresh(1);
            }
        });
//        commonAdapterOther.setfootOnClickListener(new CommonAdapter.FootOnClickListener() {
//            @Override
//            public void OnClick() {
//                refresh(2);
//            }
//        });

        //设置进度条的颜色
        swipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary, R.color.colorPrimaryDark);
        //设置进度条的大小样式
        swipeRefreshLayout.setSize(SwipeRefreshLayout.DEFAULT);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refresh(3);
            }
        });

        if (recyclerView.getLayoutManager() instanceof LinearLayoutManager) {
            //获取列表华东监听器 用于获取当前所在条数
            final LinearLayoutManager RecycViewlayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
            //添加滚动条见监听器
            recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {

                @Override
                public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                    super.onScrolled(recyclerView, dx, dy);
                    //总记录条数
                    //　int totalItemCount = linearLayoutManager.getItemCount();
                    int totalItemCount = recyclerView != null ? recyclerView.getAdapter().getItemCount() : 0;
                    //最后条数的位置
                    int lastVisubleItem = RecycViewlayoutManager.findLastVisibleItemPosition();
                    if (tvTitle.getText().toString().equals("我的会所")){
                        if (Page >= MyTotalPage){
                            isLoadingMore = false;
                        }
                    }else {
                        if (Page >= TotalPage){
                            isLoadingMore = false;
                        }
                    }
                    if (isLoadingMore && totalItemCount - 1 <= lastVisubleItem && dy > 0) {
                        isLoadingMore = false;
                        loading();

                    }
                }
            });

        }


    }

    public void GoMainActivity(String culibId) {

        SpUtil.put(mContext, SELECTEDCULBIDKEY, culibId);
        Intent intent = new Intent(AllCulbsListActivity.this, MainActivity.class);
        intent.putExtra(PUT_STR + "AddAppointment", "0");
        startActivity(intent);

    }

    @Override
    protected void initData() {
        refresh(3);
    }


    private void loading() {
        Page++;
        mLoading = true;
        getList();
    }

    private void refresh(int i) {
        Page = 1;
//      0-所有会所,1-我的会所,2-其他会所,3-下拉刷新
        refresh = i;
//            mListType = tvTitle.getText().toString();

        getList();
    }

    @Override
    protected void onResume() {
        FirstShow = true;
        super.onResume();

        floatTips.hide();
        initView();
        initData();

//        refresh(0);
    }

    private void getList() {

        String mLongitude;
        String mLatitude;
        String mLocation;
//        mLongitude = (String) SpUtil.get(mContext, LONGITUDEKEY, "");
//        mLatitude = (String) SpUtil.get(mContext, LATITUDEKEY, "");
        mLocation = (String) SpUtil.get(mContext, LOCATIONKEY, "");

        int UserId = (int) SpUtil.get(mContext, USERIDKEY, 0);
            String token = (String) SpUtil.get(mContext, TOKENKEY, "");
        // TODO: 2018/4/3  Clubid   坐标等是假定数据
        String ClubId = (String) SpUtil.get(mContext, SELECTEDCULBIDKEY, "");

        mPresenter.getClubListForMember(String.valueOf(UserId),
                token, String.valueOf(Page), mLocation
        );
//        mPresenter.getClubListForMemberNoBuy(String.valueOf(UserId), ClubId,
//                token, mLatitude, mLongitude
//        );
    }


    @Override
    public void showEmpty() {

    }

    @Override
    public void Loading() {

    }

    @Override
    public void outLogin() {
        s(this, "您的帐号在其他设备登录");
        Intent intent = new Intent(mContext, LoginActivity.class);
        remove();

        startActivity(intent);
    }


    /**
     * @param clubListForMemberBean
     */
    @Override
    public void succeed(ClubListForMemberBean clubListForMemberBean) {

        TotalPage = clubListForMemberBean.getRows().getAllClubPages();
        MyTotalPage = clubListForMemberBean.getRows().getMyClubPages();
        swipeRefreshLayout.setRefreshing(false);
        if (refresh == 1) {
            datas = clubListForMemberBean.getRows().getAllClub();
            tvTitle.setText("其他会所");
            mListType = "我的会所";
            commonAdapter.setFooterText(mListType);
            commonAdapter.setShowFooter(true);
            commonAdapter.setShowdiy(true);
            if (mLoading) {
                commonAdapter.insertData(datas);
                mLoading = false;
            } else {
                commonAdapter.replaceData(datas);
            }
            isLoadingMore = true;
            recyclerView.setAdapter(commonAdapter);
        } else if (refresh == 2) {
            Mydatas = clubListForMemberBean.getRows().getMyClub();
            mListType = "其他会所";
            tvTitle.setText("我的会所");
            commonAdapterMy.setFooterText(mListType);
            commonAdapterMy.setShowFooter(true);
            commonAdapterMy.setShowdiy(true);
            if (mLoading) {
                commonAdapterMy.insertData(Mydatas);
                mLoading = false;
            } else {
                if (Page == 1) {
                    commonAdapterMy.replaceData(Mydatas);
                } else {
                    commonAdapterMy.insertData(Mydatas);
                }
            }

            isLoadingMore = true;
            recyclerView.setAdapter(commonAdapterMy);
        } else if (refresh == 3) {
            if (FirstShow) {

                if (clubListForMemberBean.getRows().getMyClub().size() > 0) {

                    Mydatas = clubListForMemberBean.getRows().getMyClub();
                    mListType = "其他会所";
                    tvTitle.setText("我的会所");
                    commonAdapterMy.setFooterText(mListType);
                    commonAdapterMy.setShowFooter(true);
                    commonAdapterMy.setShowdiy(true);
                    if (mLoading) {
                        commonAdapterMy.insertData(Mydatas);
                        mLoading = false;
                    } else {
                        if (Page == 1) {
                            commonAdapterMy.replaceData(Mydatas);
                        } else {
                            commonAdapterMy.insertData(Mydatas);
                        }
                    }

                    isLoadingMore = true;
                    recyclerView.setAdapter(commonAdapterMy);

                } else {
                    datas = clubListForMemberBean.getRows().getAllClub();
                    tvTitle.setText("所有会所");
                    mListType = "已展示全部会所";
                    commonAdapter.setFooterText(mListType);
                    commonAdapter.setShowFooter(true);
                    commonAdapter.setShowdiy(true);
                    if (mLoading) {
                        commonAdapter.insertData(datas);
                        mLoading = false;
                    } else {
                        commonAdapter.replaceData(datas);
                    }
                    isLoadingMore = true;
                    recyclerView.setAdapter(commonAdapter);
                }
            } else {

                if (mListType.equals("其他会所")) {
                    Mydatas = clubListForMemberBean.getRows().getMyClub();
                    if (mLoading) {
                        commonAdapterMy.insertData(Mydatas);
                        mLoading = false;
                    } else {
                        if (Page == 1) {
                            commonAdapterMy.replaceData(Mydatas);
                        } else {
                            commonAdapterMy.insertData(Mydatas);
                        }
                    }

                    isLoadingMore = true;
                    recyclerView.setAdapter(commonAdapterMy);

                } else if (mListType.equals("我的会所")) {
                    datas = clubListForMemberBean.getRows().getAllClub();
                    if (mLoading) {
                        commonAdapter.insertData(datas);
                        mLoading = false;
                    } else {
                        commonAdapter.replaceData(datas);
                    }
                    isLoadingMore = true;
                    recyclerView.setAdapter(commonAdapter);

                } else {
                    datas = clubListForMemberBean.getRows().getAllClub();
                    if (mLoading) {
                        commonAdapter.insertData(datas);
                        mLoading = false;
                    } else {
                        if (Page == 1) {
                            commonAdapter.replaceData(datas);
                        } else {
                            commonAdapter.insertData(datas);
                        }
                    }

                    isLoadingMore = true;
                    recyclerView.setAdapter(commonAdapter);
                }


            }
        }
//         else {
//           if (FirstShow) {
//
//            if (clubListForMemberBean.getRows().getMyClub().size() > 0) {
//
//                Mydatas = clubListForMemberBean.getRows().getMyClub();
//                mListType = "其他会所";
//                tvTitle.setText("我的会所");
//                commonAdapterMy.setFooterText(mListType);
//                commonAdapterMy.setShowFooter(true);
//                commonAdapterMy.setShowdiy(true);
//                if (mLoading) {
//                    commonAdapterMy.insertData(Mydatas);
//                    mLoading = false;
//                } else {
//                    commonAdapterMy.replaceData(Mydatas);
//                }
//
//                isLoadingMore = true;
//                recyclerView.setAdapter(commonAdapterMy);
//
//            } else {
//                datas = clubListForMemberBean.getRows().getAllClub();
//                tvTitle.setText("所有会所");
//                mListType = "已展示全部会所";
//                commonAdapter.setFooterText(mListType);
//                commonAdapter.setShowFooter(true);
//                commonAdapter.setShowdiy(true);
//                if (Page == 1) {
//                    commonAdapter.replaceData(datas);
//                } else {
//                    commonAdapter.insertData(datas);
//                }
//                isLoadingMore = true;
//                recyclerView.setAdapter(commonAdapter);
//            }
//            } else {
//
//
//                if (mListType.equals("其他会所")) {
//                    datas = clubListForMemberBean.getRows().getAllClub();
//                    mListType = "我的会所";
//                    tvTitle.setText("其他会所");
//                    commonAdapter.setFooterText(mListType);
//                    commonAdapter.setShowFooter(true);
//                    commonAdapter.setShowdiy(true);
//
//                    if (mLoading) {
//                        commonAdapter.insertData(datas);
//                        mLoading = false;
//                    } else {
//                        if (Page == 1) {
//                            commonAdapter.replaceData(datas);
//                        } else {
//                            commonAdapter.insertData(datas);
//                        }
//                    }
//
//                    isLoadingMore = true;
//                    recyclerView.setAdapter(commonAdapter);
//
//
//                } else {
//                    Mydatas = clubListForMemberBean.getRows().getMyClub();
//                    mListType = "其他会所";
//                    tvTitle.setText("我的会所");
//                    commonAdapterMy.setFooterText(mListType);
//                    commonAdapterMy.setShowFooter(true);
//                    commonAdapterMy.setShowdiy(true);
//                    if (mLoading) {
//                        commonAdapterMy.insertData(Mydatas);
//                        mLoading = false;
//                    } else {
//                        commonAdapterMy.replaceData(Mydatas);
//                    }
//
//                    isLoadingMore = true;
//                    recyclerView.setAdapter(commonAdapterMy);
//
//
//                }
//
//
//            }
//        }

        FirstShow = false;
    }

//    @Override
//    public void succeedNoBuy(ClubListForMemberNoBuyBean clubListForMemberNoBuy) {
//
//        swipeRefreshLayout.setRefreshing(false);
//        if (clubListForMemberNoBuy.getRows().size() > 0) {
//            Otherdatas = clubListForMemberNoBuy.getRows();
//            mListType = "我的会所";
//            commonAdapterOther.setFooterText(mListType);
//            commonAdapterOther.setShowFooter(false);
//            commonAdapterOther.setShowdiy(true);
//            commonAdapterOther.replaceData(Otherdatas);
//            isLoadingMore = true;
//            recyclerView.setAdapter(commonAdapterOther);
//
//        }
//
//    }

    @Override
    public void unsucceed() {
        refresh(0);
    }

    long exitTime;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
            if ((System.currentTimeMillis() - exitTime) > 2000)  //System.currentTimeMillis()无论何时调用，肯定大于2000
            {
                Toast.makeText(getApplicationContext(), "再按一次返回键退出", Toast.LENGTH_SHORT).show();
                exitTime = System.currentTimeMillis();
            } else {
//
                int currentVersion = android.os.Build.VERSION.SDK_INT;
                if (currentVersion > android.os.Build.VERSION_CODES.ECLAIR_MR1) {
                    Intent startMain = new Intent(Intent.ACTION_MAIN);
                    startMain.addCategory(Intent.CATEGORY_HOME);
                    startMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(startMain);
                    System.exit(0);
                } else {// android2.1
                    ActivityManager am = (ActivityManager) getSystemService(ACTIVITY_SERVICE);
                    am.restartPackage(getPackageName());
                }
            }

            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
