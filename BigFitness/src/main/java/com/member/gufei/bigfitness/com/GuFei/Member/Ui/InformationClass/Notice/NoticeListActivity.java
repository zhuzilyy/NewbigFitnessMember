package com.member.gufei.bigfitness.com.GuFei.Member.Ui.InformationClass.Notice;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.member.gufei.bigfitness.R;
import com.member.gufei.bigfitness.base.BaseActivity;
import com.member.gufei.bigfitness.base.RecyclerviewBase.CommonAdapter;
import com.member.gufei.bigfitness.base.RecyclerviewBase.ViewHolder;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.Buy.NoticeListBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.CodeBean;
import com.member.gufei.bigfitness.util.SpUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.member.gufei.bigfitness.Constants.TOKENKEY;
import static com.member.gufei.bigfitness.Constants.USERIDKEY;

public class NoticeListActivity extends BaseActivity<NoticeListActivityPresenter> implements NoticeListActivityContract.View {


    @BindView(R.id.ScanImg)
    ImageView ScanImg;
    @BindView(R.id.titletext)
    TextView titletext;
    @BindView(R.id.img_system)
    ImageView imgSystem;
    @BindView(R.id.text_system)
    TextView textSystem;
    @BindView(R.id.btn_system)
    LinearLayout btnSystem;
    @BindView(R.id.img_course)
    ImageView imgCourse;
    @BindView(R.id.text_course)
    TextView textCourse;
    @BindView(R.id.btn_course)
    LinearLayout btnCourse;
    @BindView(R.id.img_push)
    ImageView imgPush;
    @BindView(R.id.text_push)
    TextView textPush;
    @BindView(R.id.btn_push)
    LinearLayout btnPush;
    @BindView(R.id.layput_btn_class)
    LinearLayout layputBtnClass;
    @BindView(R.id.recyclerviewid)
    RecyclerView recyclerView;
    @BindView(R.id.swiperefreshlayoutid)
    SwipeRefreshLayout swiperefreshlayoutid;
    @BindView(R.id.notice_menu)
    ImageView noticeMenu;
    @BindView(R.id.tv_noMore)
    TextView tvNoMore;
    //    @BindView(R.id.spinner_select)
//    Spinner spinnerSelect;
    private CommonAdapter<NoticeListBean.RowsBean> mSystemCommonAdapter;
    private CommonAdapter<NoticeListBean.RowsBean> mCourseCommonAdapter;
    private CommonAdapter<NoticeListBean.RowsBean> mPushCommonAdapter;
    private List<NoticeListBean.RowsBean> datas = new ArrayList<NoticeListBean.RowsBean>();
    private String[] spinnerArr;
    private ArrayAdapter adapter = null;
    int UserId;
    String token;
    private int Page = 1;
    private int PageSize = 20;
    private static int refresh = 0;
    private boolean mLoading = false;
    private boolean isLoadingMore = true;//加载标志位


    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.member_activity_notice_list;
    }
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.messagemenu, menu);
//        return super.onCreateOptionsMenu(menu);
//    }

    @Override
    protected void initView() {


//        toolbar.setNavigationIcon(R.mipmap.left);
//        setToolBar(toolbar, "");
        titletext.setText("通知");

        imgSystem.setPadding(0, 0, 0, 0);
        textSystem.setTextSize(14);
        textCourse.setTextSize(12);
        textPush.setTextSize(12);
        imgPush.setPadding(5, 5, 5, 5);
        imgCourse.setPadding(5, 5, 5, 5);

        spinnerArr = this.getResources().getStringArray(R.array.MsgSpingArr);

//        spinnerSelect.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//
//                switch (position) {
//
//                    case 0:
//                        break;
//                    case 1:
//
//                        break;
//                        case 2:
//
//                        break;
//                }
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
////                Status="";
//
//            }
//        });


        adapter = new ArrayAdapter(this, R.layout.spinnerlayout, spinnerArr);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//
//        simpleAdapter = new SimpleAdapter(this, getData(), R.layout.item,
//                new String[] {"pic", "text"}, new int[]{R.id.id_image, R.id.id_text1});


//        spinnerSelect.setAdapter(adapter);
//
//
//        spinnerSelect.setDropDownVerticalOffset(60);
        datas = new ArrayList<>();
        //注释部分为假数据
//        for (
//                int i = 0;
//                i < 10; i++)
//
//        {
//            NoticeListBean.RowsBean bean = new NoticeListBean.RowsBean();
//            datas.add(bean);
//        }

        mSystemCommonAdapter = new CommonAdapter<NoticeListBean.RowsBean>(R.layout.cardview_member_sms_system, mContext, datas)

        {
            @Override
            protected void convert(final ViewHolder holder,
                                   final NoticeListBean.RowsBean dataBean, final int position) {
                TextView tvRed = (TextView) holder.getView(R.id.tv_red);
                holder.setText(R.id.text_name, dataBean.getTitle());
                holder.setText(R.id.text_notice_time, dataBean.getCreateTime());
                holder.setText(R.id.text_notice_cotent, dataBean.getContent());


                //0为未读，1为已读
                if (dataBean.getIsRead() == 0) {
                    tvRed.setVisibility(View.VISIBLE);
                } else {
                    tvRed.setVisibility(View.GONE);
                }
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(mContext, dataBean.getContent(), Toast.LENGTH_SHORT).show();
                        int Id = dataBean.getRowId();
                        int IsAPPPush = dataBean.getIsAPPPush();
                        mPresenter.getReadMessage(String.valueOf(UserId),
                                token,
                                String.valueOf(Id),
                                String.valueOf(IsAPPPush));


                    }
                });

                holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View view) {
                        final int Id = dataBean.getRowId();
                        final int IsAPPPush = dataBean.getIsAPPPush();
                        AlertDialog dialog = new AlertDialog.Builder(mContext)
//                                .setIcon(R.mipmap.icon)//设置标题的图片
                                .setTitle("")//设置对话框的标题
                                .setMessage("确定删除此条信息?")//设置对话框的内容
                                //设置对话框的按钮
                                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
//                                        Toast.makeText(mContext, "点击了取消按钮", Toast.LENGTH_SHORT).show();
                                        dialog.dismiss();
                                    }
                                })
                                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
//                                        Toast.makeText(mContext, "点击了确定的按钮", Toast.LENGTH_SHORT).show();
//                                        mSystemCommonAdapter.removeData(position);
                                        mPresenter.getDeleteMessage(String.valueOf(UserId),
                                                token,
                                                String.valueOf(Id),
                                                String.valueOf(IsAPPPush));

                                        dialog.dismiss();
                                    }
                                }).create();
                        dialog.show();
                        return false;
                    }
                });

            }
        }

        ;
        mCourseCommonAdapter = new CommonAdapter<NoticeListBean.RowsBean>(R.layout.cardview_member_sms_course, mContext, datas)

        {
            @Override
            protected void convert(ViewHolder holder,
                                   final NoticeListBean.RowsBean dataBean, int position) {
                TextView tvClassRed = (TextView) holder.getView(R.id.tv_class_red);
                holder.setText(R.id.text_course_name, dataBean.getTitle());
                holder.setText(R.id.text_course_time, dataBean.getCreateTime());
                holder.setText(R.id.text_course_cotent, dataBean.getContent());

                //0为未读，1为已读
                if (dataBean.getIsRead() == 0) {
                    tvClassRed.setVisibility(View.VISIBLE);
                } else {
                    tvClassRed.setVisibility(View.GONE);
                }
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Toast.makeText(mContext, dataBean.getContent(), Toast.LENGTH_SHORT).show();
                        int Id = dataBean.getRowId();
                        int IsAPPPush = dataBean.getIsAPPPush();
                        mPresenter.getReadMessage(String.valueOf(UserId),
                                token,
                                String.valueOf(Id),
                                String.valueOf(IsAPPPush));


                    }
                });

                holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View view) {
                        final int Id = dataBean.getRowId();
                        final int IsAPPPush = dataBean.getIsAPPPush();
                        AlertDialog dialog = new AlertDialog.Builder(mContext)
//                                .setIcon(R.mipmap.icon)//设置标题的图片
                                .setTitle("")//设置对话框的标题
                                .setMessage("确定删除此条信息?")//设置对话框的内容
                                //设置对话框的按钮
                                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
//                                        Toast.makeText(mContext, "点击了取消按钮", Toast.LENGTH_SHORT).show();
                                        dialog.dismiss();
                                    }
                                })
                                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
//                                        Toast.makeText(mContext, "点击了确定的按钮", Toast.LENGTH_SHORT).show();
//                                        mSystemCommonAdapter.removeData(position);
                                        mPresenter.getDeleteMessage(String.valueOf(UserId),
                                                token,
                                                String.valueOf(Id),
                                                String.valueOf(IsAPPPush));

                                        dialog.dismiss();
                                    }
                                }).create();
                        dialog.show();
                        return false;
                    }
                });
            }
        }

        ;
        mPushCommonAdapter = new CommonAdapter<NoticeListBean.RowsBean>(R.layout.cardview_member_sms_push, mContext, datas)

        {
            @Override
            protected void convert(ViewHolder holder,
                                   final NoticeListBean.RowsBean dataBean, int position) {
                TextView tvPushRed = (TextView) holder.getView(R.id.tv_push_red);
                holder.setText(R.id.text_push_name, dataBean.getTitle());
                holder.setText(R.id.text_push_time, dataBean.getCreateTime());
                holder.setText(R.id.text_push_cotent, dataBean.getContent());

                //0为未读，1为已读
                if (dataBean.getIsRead() == 0) {
                    tvPushRed.setVisibility(View.VISIBLE);
                } else {
                    tvPushRed.setVisibility(View.GONE);
                }
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(mContext, dataBean.getContent(), Toast.LENGTH_SHORT).show();
                        int Id = dataBean.getRowId();
                        int IsAPPPush = dataBean.getIsAPPPush();
                        mPresenter.getReadMessage(String.valueOf(UserId),
                                token,
                                String.valueOf(Id),
                                String.valueOf(IsAPPPush));


                    }
                });
                holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View view) {
                        final int Id = dataBean.getRowId();
                        final int IsAPPPush = dataBean.getIsAPPPush();
                        AlertDialog dialog = new AlertDialog.Builder(mContext)
//                                .setIcon(R.mipmap.icon)//设置标题的图片
                                .setTitle("")//设置对话框的标题
                                .setMessage("确定删除此条信息?")//设置对话框的内容
                                //设置对话框的按钮
                                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
//                                        Toast.makeText(mContext, "点击了取消按钮", Toast.LENGTH_SHORT).show();
                                        dialog.dismiss();
                                    }
                                })
                                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
//                                        Toast.makeText(mContext, "点击了确定的按钮", Toast.LENGTH_SHORT).show();
//                                        mSystemCommonAdapter.removeData(position);
                                        mPresenter.getDeleteMessage(String.valueOf(UserId),
                                                token,
                                                String.valueOf(Id),
                                                String.valueOf(IsAPPPush));
                                        dialog.dismiss();
                                    }
                                }).create();
                        dialog.show();
                        return false;
                    }
                });
            }
        }

        ;

        mSystemCommonAdapter.setShowFooter(false);
        mCourseCommonAdapter.setShowFooter(false);
        mPushCommonAdapter.setShowFooter(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        recyclerView.setAdapter(mSystemCommonAdapter);
//设置进度条的颜色
        swiperefreshlayoutid.setColorSchemeResources(R.color.colorPrimary, R.color.colorPrimaryDark);
        //设置进度条的大小样式
        swiperefreshlayoutid.setSize(SwipeRefreshLayout.DEFAULT);
        swiperefreshlayoutid.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
               new Handler().postDelayed(new Runnable() {
                   @Override
                   public void run() {
                       //停止刷新
                       swiperefreshlayoutid.setRefreshing(false);
                   }
               }, 3000);
            }
        });

//
////
    }

    @Override
    protected void initData() {
        UserId = (int) SpUtil.get(mContext, USERIDKEY, 0);
        token = (String) SpUtil.get(mContext, TOKENKEY, "");
        Page = 1;
        refresh(1);
    }

    private void refresh(int i) {
        Page = 1;
//      1-系统通知,9-课程通知,10-推送通知
        PageSize = 20;
        refresh = i;
//            mListType = tvTitle.getText().toString();

        getList();
    }

    private void getList() {

        mPresenter.getNoticeList(String.valueOf(UserId),
                token, String.valueOf(Page), String.valueOf(PageSize), String.valueOf(refresh));
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
    public void succeed(NoticeListBean noticeListBean) {
        datas = noticeListBean.getRows();
            if (refresh == 1) {
//                if (datas.size() != 0) {
                    if (mLoading) {
                        mSystemCommonAdapter.insertData(datas);
                        mLoading = false;
                    } else {
                        mSystemCommonAdapter.replaceData(datas);
                    }
                    isLoadingMore = true;
                    recyclerView.setAdapter(mSystemCommonAdapter);
//                } else {
//                    tvNoMore.setVisibility(View.VISIBLE);
//                }
            } else if (refresh == 9) {
//                if (datas.size() != 0){
                    if (mLoading) {
                        mCourseCommonAdapter.insertData(datas);
                        mLoading = false;
                    } else {
                        mCourseCommonAdapter.replaceData(datas);
                    }
                    isLoadingMore = true;
                    recyclerView.setAdapter(mCourseCommonAdapter);
//                }else {
//                    tvNoMore.setVisibility(View.VISIBLE);
//                }

            } else if (refresh == 10) {
//                if (datas.size() != 0){
                    if (mLoading) {
                        mPushCommonAdapter.insertData(datas);
                        mLoading = false;
                    } else {
                        mPushCommonAdapter.replaceData(datas);
                    }
                    isLoadingMore = true;
                    recyclerView.setAdapter(mPushCommonAdapter);
//                }else {
//                    tvNoMore.setVisibility(View.VISIBLE);
//                }

            }

    }

    @Override
    public void succeedRead(CodeBean codeBean) {
        if (refresh == 1) {
            refresh(1);
        } else if (refresh == 9) {
            refresh(9);
        } else if (refresh == 10) {
            refresh(10);
        }

    }

    @Override
    public void succeedDelete(CodeBean codeBean) {
        if (refresh == 1) {
            refresh(1);
        } else if (refresh == 9) {
            refresh(9);
        } else if (refresh == 10) {
            refresh(10);
        }
    }

    @Override
    public void succeedAllRead(CodeBean codeBean) {
        if (refresh == 1) {
            refresh(1);
        } else if (refresh == 9) {
            refresh(9);
        } else if (refresh == 10) {
            refresh(10);
        }
    }

    @Override
    public void succeedAllDelete(CodeBean codeBean) {
        if (refresh == 1) {
            refresh(1);
        } else if (refresh == 9) {
            refresh(9);
        } else if (refresh == 10) {
            refresh(10);
        }
    }

    @Override
    public void unsucceed() {

    }

    public void popupMenu(View v) {
        PopupMenu popupMenu = new PopupMenu(this, v);
        final MenuInflater inflater = popupMenu.getMenuInflater();
        //添加单击事件
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.notice_sign:
                        int MsgTypeId = 0;
                        if (refresh == 1) {
//                            Toast.makeText(mContext, "标记系统消息全部已读", Toast.LENGTH_SHORT).show();
                            MsgTypeId = 1;
                        } else if (refresh == 9) {
//                            Toast.makeText(mContext, "标记课程消息全部已读", Toast.LENGTH_SHORT).show();
                            MsgTypeId = 9;
                        } else if (refresh == 10) {
//                            Toast.makeText(mContext, "标记推送消息全部已读", Toast.LENGTH_SHORT).show();
                            MsgTypeId = 10;
                        }
                        mPresenter.getAllRead(String.valueOf(UserId),
                                token,
                                String.valueOf(MsgTypeId));
                        return true;
                    case R.id.notice_delete:
                        int DMsgTypeId = 0;
                        if (refresh == 1) {
                            DMsgTypeId = 1;
                        } else if (refresh == 9) {
                            DMsgTypeId = 9;
                        } else if (refresh == 10) {
                            DMsgTypeId = 10;
                        }
                        mPresenter.getAllDelete(String.valueOf(UserId),
                                token,
                                String.valueOf(DMsgTypeId));
                        return true;
                }
                return false;
            }
        });
        inflater.inflate(R.menu.popupmenu, popupMenu.getMenu());

        popupMenu.show();
    }


    @OnClick({R.id.ScanImg, R.id.titletext, R.id.btn_system, R.id.btn_course, R.id.btn_push})
    public void onViewClicked(View view) {
        switch (view.getId()) {

            case R.id.btn_system:
                setView(btnSystem.getId());
                refresh(1);
//                recyclerView.setAdapter(mSystemCommonAdapter);
//                mSystemCommonAdapter.notifyDataSetChanged();

                break;
            case R.id.btn_course:
                setView(btnCourse.getId());
                refresh(9);
//                recyclerView.setAdapter(mCourseCommonAdapter);
//                mCourseCommonAdapter.notifyDataSetChanged();
                break;
            case R.id.btn_push:
                setView(btnPush.getId());
                refresh(10);
//                recyclerView.setAdapter(mPushCommonAdapter);
//                mPushCommonAdapter.notifyDataSetChanged();
                break;

            case R.id.ScanImg:
                finish();
                break;
            case R.id.spinner_select:
                break;
            case R.id.titletext:
                break;
        }
    }

    private void setView(int i) {

        if (btnSystem.getId() == i) {
            imgSystem.setPadding(0, 0, 0, 0);
            textSystem.setTextSize(14);

        } else {
            imgSystem.setPadding(5, 5, 5, 5);
            textSystem.setTextSize(12);

        }

        if (btnCourse.getId() == i) {
            imgCourse.setPadding(0, 0, 0, 0);
            textCourse.setTextSize(14);

        } else {
            imgCourse.setPadding(5, 5, 5, 5);
            textCourse.setTextSize(12);
        }

        if (btnPush.getId() == i) {
            imgPush.setPadding(0, 0, 0, 0);
            textPush.setTextSize(14);

        } else {
            imgPush.setPadding(5, 5, 5, 5);
            textPush.setTextSize(12);
        }

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}


