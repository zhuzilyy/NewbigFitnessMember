package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.MyCenter.MyCardList.UpGradeCard;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.member.gufei.bigfitness.R;
import com.member.gufei.bigfitness.base.BaseActivity;
import com.member.gufei.bigfitness.base.RecyclerviewBase.CommonAdapter;
import com.member.gufei.bigfitness.base.RecyclerviewBase.ViewHolder;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.AllCulbsList.PrivateClass.Cashier.CashierActivity;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.AppGetMyMemberCardListBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.CodeBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.MemberCardOnlineUpInfoBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.UpGradeCardListBean;
import com.member.gufei.bigfitness.util.SpUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

import static com.member.gufei.bigfitness.App.SCREEN_WIDTH;
import static com.member.gufei.bigfitness.Constants.ID_CARD_UP;
import static com.member.gufei.bigfitness.Constants.PUT_STR;
import static com.member.gufei.bigfitness.Constants.RESULT_ID;
import static com.member.gufei.bigfitness.Constants.SELECTEDCULBIDKEY;
import static com.member.gufei.bigfitness.Constants.TOKENKEY;
import static com.member.gufei.bigfitness.Constants.USERIDKEY;
import static com.member.gufei.bigfitness.util.ToastUtil.s;

public class UpGradeCardActivity extends BaseActivity<UpGradeCardActivityPresenter> implements UpGradeCardActivityContract.View {


    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.btn_complete)
    Button btnComplete;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.text_type_card)
    TextView textTypeCard;
    @BindView(R.id.text_time_expire)
    TextView textTimeExpire;
    @BindView(R.id.text_type_card_new)
    TextView textTypeCardNew;
    @BindView(R.id.btn_type_card_new)
    RelativeLayout btnTypeCardNew;
    @BindView(R.id.text_time_expire_new)
    TextView textTimeExpireNew;
    @BindView(R.id.text_mone_pay)
    TextView textMonePay;
    @BindView(R.id.btn_confirm)
    TextView btnConfirm;
    private View contentView;
    private PopupWindow popupWindow;
    RecyclerView recyclerView;

    int UserId;
    String token;
    String Id;
    String ClubId;
    String MemberCardId;
    String ConsumeType;
    String MemberCardTypeName;
    String MemberCardTypeId;
    String NewMemberCardTypeId;
    String NumberRemaining;
    String TimeExpire;
    String MoneyTotal;

    int CardCheckedId;
    String CardCheckedText;
    private boolean isLoadingMore = true;//加载标志位
    private CommonAdapter<UpGradeCardListBean.RowsBean> commonAdapter;
    private List<UpGradeCardListBean.RowsBean> datas = new ArrayList<UpGradeCardListBean.RowsBean>();

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.member_activity_renew_my_card;
    }

    @Override
    protected void initView() {
        toolbar.setNavigationIcon(R.mipmap.left);
        setToolBar(toolbar, "");
        tvTitle.setText("会员卡升级");
        btnComplete.setVisibility(View.GONE);

        Intent intent = getIntent();


        UserId = (int) SpUtil.get(mContext, USERIDKEY, 0);
        token = (String) SpUtil.get(mContext, TOKENKEY, "");
        Id = intent.getStringExtra(PUT_STR + "id");
        ClubId =(String) SpUtil.get(mContext, SELECTEDCULBIDKEY, "");
        // TODO: 2018/4/7 ClubId为假数据


        MemberCardId = intent.getStringExtra(PUT_STR + "MemberCardId");
        MemberCardTypeName = intent.getStringExtra(PUT_STR + "MemberCardTypeName");
        MemberCardTypeId = intent.getStringExtra(PUT_STR + "MemberCardTypeId");
        NumberRemaining = intent.getStringExtra(PUT_STR + "NumberRemaining");
        ConsumeType = intent.getStringExtra(PUT_STR + "ConsumeType");
        TimeExpire = intent.getStringExtra(PUT_STR + "ExpireTime");

        textTypeCard.setText(MemberCardTypeName);
        textTimeExpire.setText(TimeExpire);


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
    public void succeedUp(UpGradeCardListBean upGradeCardListBean) {
//        if (contentView != null) contentView = null;
        datas=upGradeCardListBean.getRows();
        contentView = LayoutInflater.from(this).inflate(R.layout.member_pop_view_card, null);
        recyclerView = (RecyclerView) contentView.findViewById(R.id.recyclerviewid);
        commonAdapter = new CommonAdapter<UpGradeCardListBean.RowsBean>(R.layout.upgrade_card_list_item, mContext, datas) {
            @Override
            protected void convert( ViewHolder holder, final UpGradeCardListBean.RowsBean rowsBean, final int position) {

                holder.setText(R.id.tv_upgrade_name, rowsBean.getMemberCardTypeName());
                final ImageView imageView = (ImageView) holder.getView(R.id.iv_upgrade_select);
                imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        imageView.setImageResource(R.drawable.img_ev_selected);
                        NewMemberCardTypeId = String.valueOf(rowsBean.getMemberCardTypeId());
                        textTypeCardNew.setText(rowsBean.getMemberCardTypeName());
                        mPresenter.appMemberCardOnlineUpInfo(MemberCardTypeId,
                                NewMemberCardTypeId,
                                TimeExpire,
                                token);
                        popupWindow.dismiss();
                    }
                });
            }
        };
        commonAdapter.setShowFooter(false);
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ge, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(commonAdapter);

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
                    if (isLoadingMore && totalItemCount - 5 <= lastVisubleItem && dy > 0) {
                        isLoadingMore = false;
                        loading();
                    }
                }
            });

        }
    }

    @Override
    public void succeedUpInfo(MemberCardOnlineUpInfoBean memberCardOnlineUpInfoBean) {
        textTimeExpireNew.setText(memberCardOnlineUpInfoBean.getRows().getNewExpireTime());
        textMonePay.setText(memberCardOnlineUpInfoBean.getRows().getDifferencePrice() + "元");
        MoneyTotal = String.valueOf(memberCardOnlineUpInfoBean.getRows().getDifferencePrice());
    }

    public void SelectPopup(View v, final int tag) {

//        if (popupWindow != null) popupWindow = null;
        // 一个自定义的布局，作为显示的内容
        popupWindow = new PopupWindow(contentView, SCREEN_WIDTH - 200, RecyclerView.LayoutParams.WRAP_CONTENT, true);
        popupWindow.setTouchable(true);
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                backgroundAlpha(1f);
            }
        });


        // 如果不设置PopupWindow的背景，无论是点击外部区域还是Back键都无法dismiss弹框
        // 我觉得这里是API的一个bug
        popupWindow.setBackgroundDrawable(getResources().getDrawable(R.color.white));
        // 设置好参数之后再show
        //获取点击View的坐标

        int[] point = {0, 0};

        v.getLocationOnScreen(point);

//        popupWindow.showAtLocation(v, Gravity.CENTER, 0, point[1] + v.getHeight());
        popupWindow.showAtLocation(v, Gravity.CENTER, 0, 150);


//        popupWindow.setAnimationStyle(R.style.take_photo_anim);
    }
    private void loading() {
//        Page++;
//
//        getList();
    }


    @OnClick({R.id.btn_type_card_new, R.id.btn_confirm})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_type_card_new:
                mPresenter.appMemberUpGradeCardList(ClubId,
                        token,
                        MemberCardTypeId);
                SelectPopup(view, 0);
                break;
            case R.id.btn_confirm:
                Intent Cashier = new Intent(mContext, CashierActivity.class);
                Cashier.putExtra(PUT_STR + "TypeId",ID_CARD_UP);
                Cashier.putExtra(PUT_STR + "titleInfoBuy", "升级后会员卡");
                Cashier.putExtra(PUT_STR + "textInfoBuy", textTypeCardNew.getText().toString());
                Cashier.putExtra(PUT_STR + "TitleForFirst", "到期时间");
                Cashier.putExtra(PUT_STR + "TextForFirst", textTimeExpireNew.getText().toString());
                Cashier.putExtra(PUT_STR + "TitleForSecond", "");
                Cashier.putExtra(PUT_STR + "TextForSecond", "");
                Cashier.putExtra(PUT_STR + "textMoneyTotal",MoneyTotal);
                Cashier.putExtra(PUT_STR + "NewMemberCardTypeId", String.valueOf(NewMemberCardTypeId));
                Cashier.putExtra(PUT_STR + "MemberCardId", MemberCardId);
                startActivity(Cashier);
                break;
        }
    }
}


