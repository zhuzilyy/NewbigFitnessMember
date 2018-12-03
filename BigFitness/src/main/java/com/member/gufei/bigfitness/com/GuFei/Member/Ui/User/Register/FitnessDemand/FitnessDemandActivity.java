package com.member.gufei.bigfitness.com.GuFei.Member.Ui.User.Register.FitnessDemand;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.igexin.sdk.PushManager;
import com.member.gufei.bigfitness.R;
import com.member.gufei.bigfitness.base.BaseActivity;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.AllCulbsList.AllCulbsListActivity;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.FitnessRequestBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.MemberMyInfoBean;
import com.member.gufei.bigfitness.com.GuFei.Push.IntentService;
import com.member.gufei.bigfitness.util.SpUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.member.gufei.bigfitness.Constants.ACCOUNTKEY;
import static com.member.gufei.bigfitness.Constants.BIRTHDAYKEY;
import static com.member.gufei.bigfitness.Constants.CLIENTID;
import static com.member.gufei.bigfitness.Constants.FITNESSREQUESTKEY;
import static com.member.gufei.bigfitness.Constants.FITNESSREQUESTLISTKEY;
import static com.member.gufei.bigfitness.Constants.HEADERURLKEY;
import static com.member.gufei.bigfitness.Constants.HEIGHTKEY;
import static com.member.gufei.bigfitness.Constants.LOGINKEY;
import static com.member.gufei.bigfitness.Constants.NICKNAMEKEY;
import static com.member.gufei.bigfitness.Constants.PASSWRODKEY;
import static com.member.gufei.bigfitness.Constants.SELECTBRITHADAYEY;
import static com.member.gufei.bigfitness.Constants.SELECTHEIGHTKEY;
import static com.member.gufei.bigfitness.Constants.SELECTNAMEKEY;
import static com.member.gufei.bigfitness.Constants.SELECTSEXKEY;
import static com.member.gufei.bigfitness.Constants.SELECTWEIGHTKEY;
import static com.member.gufei.bigfitness.Constants.SEXKEY;
import static com.member.gufei.bigfitness.Constants.TOKENKEY;
import static com.member.gufei.bigfitness.Constants.USERIDKEY;
import static com.member.gufei.bigfitness.Constants.WEIGHTKEY;
import static com.member.gufei.bigfitness.util.ListUtil.Fitness2Bean;
import static com.member.gufei.bigfitness.util.ListUtil.toList;
import static com.member.gufei.bigfitness.util.ListUtil.toidstring;
import static com.member.gufei.bigfitness.util.ToastUtil.s;

/**
 * Created by GuFei_lyf on 2017/3/22
 * 登录页面 实现
 */


public class FitnessDemandActivity extends BaseActivity<FitnessDemandActivityPresenter> implements FitnessDemandActivityContract.View {


    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tv_title)
    TextView tvTitle;

    @BindView(R.id.btn_select_1)
    TextView btnSelect1;
    @BindView(R.id.btn_select_2)
    TextView btnSelect2;
    @BindView(R.id.btn_select_3)
    TextView btnSelect3;
    @BindView(R.id.btn_select_4)
    TextView btnSelect4;
    @BindView(R.id.btn_select_5)
    TextView btnSelect5;
    @BindView(R.id.btn_select_6)
    TextView btnSelect6;
    @BindView(R.id.btn_select_7)
    TextView btnSelect7;
    @BindView(R.id.btn_select_8)
    TextView btnSelect8;
    @BindView(R.id.btn_select_9)
    TextView btnSelect9;
    @BindView(R.id.btn_select_10)
    TextView btnSelect10;
    @BindView(R.id.btn_select_11)
    TextView btnSelect11;
    @BindView(R.id.btn_next)
    ImageView btnNext;

    private List<Integer> mDatas;
    private String[] demands = new String[]{"减脂", "增肌", "塑形", "产后恢复", "康复", "柔韧性",
            "反应", "休闲", "社交", "改善体质",
            "竞技性训练（拳击、综合格斗、健体、健美）"};
    List<FitnessRequestBean.RowsBean> beans = new ArrayList<FitnessRequestBean.RowsBean>();
    private String mFitnessRequest;


    @Override
    protected void initInject() {

        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.member_activity_fitness_demand;
    }

    @Override
    protected void initView() {
        toolbar.setNavigationIcon(R.mipmap.left);
        setToolBar(toolbar, "");
        tvTitle.setText("你的健身需求?(可多选)");
//        String fitnessrequest = (String) SpUtil.get(mContext, FITNESSREQUESTKEY, "");
//        beans = Fitness2Bean((String) SpUtil.get(mContext, FITNESSREQUESTLISTKEY, ""));//8.4
        beans.add(new FitnessRequestBean.RowsBean(448, "减脂"));
        beans.add(new FitnessRequestBean.RowsBean(450, "塑形"));
        beans.add(new FitnessRequestBean.RowsBean(449, "增肌"));
        beans.add(new FitnessRequestBean.RowsBean(451, "产后恢复"));
        beans.add(new FitnessRequestBean.RowsBean(452, "康复"));
        beans.add(new FitnessRequestBean.RowsBean(453, "柔韧性"));
        beans.add(new FitnessRequestBean.RowsBean(454, "反应"));
        beans.add(new FitnessRequestBean.RowsBean(455, "休闲"));
        beans.add(new FitnessRequestBean.RowsBean(456, "社交"));
        beans.add(new FitnessRequestBean.RowsBean(457, "改善体质"));
        beans.add(new FitnessRequestBean.RowsBean(458, "竞技性训练（拳击、综合格斗、健身、健美）"));
        for (int i = 0; i < beans.size(); i++) {
            try {
                TextView TV = (TextView) findViewById(R.id.class.getDeclaredField("btn_select_" + String.valueOf(i + 1)).getInt(null));
                TV.setText(beans.get(i).getDicName());
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }
        }
//        mDatas = toList(fitnessrequest);

//        for (int i = 0; i < beans.size(); i++) {
//            beans.get(i).setDicSelected(mDatas.contains(beans.get(i).getDicid() + ""));
//        }

//

    }


    @Override
    protected void initData() {

//        JPushInterface.init(getApplicationContext());

    }


    @Override
    public void showError(String msg) {

        s(this, msg);

    }

    @Override
    public void showEmpty() {

    }

    @Override
    public void outLogin() {

//        Intent intent = new Intent(mContext, LoginActivity.class);
//        startActivity(intent);

    }


    @Override
    public void Loading() {

    }


    @Override
    public void succeed(MemberMyInfoBean memberMyInfoBean) {
        SpUtil.put(mContext, TOKENKEY, memberMyInfoBean.getRows().getToken());
        SpUtil.put(mContext, SEXKEY, memberMyInfoBean.getRows().getSex());
//        SpUtil.put(mContext, HEADERURLKEY, memberMyInfoBean.getRows().getHeaderURL());
        SpUtil.put(mContext, BIRTHDAYKEY, memberMyInfoBean.getRows().getBirthday());
        SpUtil.put(mContext, HEIGHTKEY, memberMyInfoBean.getRows().getHeight());
        SpUtil.put(mContext, FITNESSREQUESTKEY, memberMyInfoBean.getRows().getFitnessRequest());
        SpUtil.put(mContext, NICKNAMEKEY, memberMyInfoBean.getRows().getNickName());
        SpUtil.put(mContext, WEIGHTKEY, memberMyInfoBean.getRows().getWeight());
        Intent intent = new Intent();
        intent.setClass(FitnessDemandActivity.this, AllCulbsListActivity.class);
        startActivity(intent);
        finish();

    }

    public void RefreshButton() {
        boolean b = false;
        for (int i = 0; i < beans.size(); i++) {
            try {
                TextView TV = (TextView) findViewById(R.id.class.getDeclaredField("btn_select_" + String.valueOf(i + 1)).getInt(null));
                int imgId = 0;
                if (beans.get(i).isDicSelected()) {
                    b = true;
                    imgId = R.drawable.btn_type_selected_shape;
                } else {
                    imgId = R.drawable.btn_type_shape;
                }
                TV.setBackgroundResource(imgId);
                TV.setText(beans.get(i).getDicName());
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }

        }
        if (b) {
            btnNext.setImageResource(R.mipmap.img_btn_next_selected);
        } else {
            btnNext.setImageResource(R.mipmap.img_btn_next_select);
        }


    }

    @OnClick({R.id.btn_next, R.id.btn_select_1, R.id.btn_select_2, R.id.btn_select_3, R.id.btn_select_4, R.id.btn_select_5, R.id.btn_select_6, R.id.btn_select_7, R.id.btn_select_8, R.id.btn_select_9, R.id.btn_select_10, R.id.btn_select_11})
    public void onViewClicked(View view) {
        switch (view.getId()) {

//                Intent resultIntent = new Intent();
//
//                Bundle bundle = new Bundle();
//
//                bundle.putInt(RESULT_TYPE, RESULT_SUCCESS);
//
//                String mId = "";
//                String mName = "";
//                String b = "";
//
//                for (int i = 0; i < beans.size(); i++) {
//                    if (beans.get(i).isDicSelected()) {
//
//                        mId+=b+beans.get(i).getDicid();
//                        mName+=b+beans.get(i).getDicName();
//                        if (i==beans.size()){
//                            b="";
//                        }else{
//                            b=",";
//                        }
//
//                    }
//
//
//                }

//
//                bundle.putString(RESULT_ID, mId);
//                bundle.putString(RESULT_STRING, mName);
//
//
//                resultIntent.putExtras(bundle);
//
//                this.setResult(RESULT_OK, resultIntent);


            case R.id.btn_next:

                String mNickname = (String) SpUtil.get(mContext, SELECTNAMEKEY, "");
                String mBirthday = (String) SpUtil.get(mContext, SELECTBRITHADAYEY, "");
                String mHeigt = (String) SpUtil.get(mContext, SELECTHEIGHTKEY, "");
                String mWeight = (String) SpUtil.get(mContext, SELECTWEIGHTKEY, "");
                String mUserSex = (String) SpUtil.get(mContext, SELECTSEXKEY, "");
                Integer UserId = (Integer) SpUtil.get(mContext, USERIDKEY, 1);
                PushManager.getInstance().registerPushIntentService(this.getApplicationContext(), IntentService.class);


                SpUtil.put(mContext, CLIENTID, PushManager.getInstance().getClientid(mContext));
                String clientId = (String) SpUtil.get(mContext, CLIENTID, "");

                if (mBirthday.equals("")) {
                    s(mContext, "生日不可为空!");
                    break;
                }

                if (mNickname.equals("")) {
                    s(mContext, "昵称不可为空!");
                    break;
                }

                if (mHeigt.equals("")) {
                    s(mContext, "身高不可为空!");
                    break;
                }
                if (mWeight.equals("")) {
                    s(mContext, "身高不可为空!");
                    break;
                }

                String mId = "";
                String mName = "";
                String b = "";

                for (int i = 0; i < beans.size(); i++) {
                    if (beans.get(i).isDicSelected()) {

                        mId += b + beans.get(i).getDicid();
                        mName += b + beans.get(i).getDicName();
                        if (i == beans.size()) {
                            b = "";
                        } else {
                            b = ",";
                        }

                    }


                }
                SpUtil.put(mContext, FITNESSREQUESTKEY, mName);

                mPresenter.updateAppUserInfo(String.valueOf(UserId),
                        clientId,
                        mUserSex,
                        mNickname,
                        mBirthday,
                        String.valueOf(mHeigt),
                        String.valueOf(mWeight),
                        mName,  "ANDROID ");
                break;

            case R.id.btn_select_1:
                if (beans != null && beans.size() > 0) {
                    beans.get(0).setDicSelected(!beans.get(0).isDicSelected());
                }
                break;
            case R.id.btn_select_2:
                if (beans != null && beans.size() > 0) {
                    beans.get(1).setDicSelected(!beans.get(1).isDicSelected());
                }
                break;
            case R.id.btn_select_3:
                if (beans != null && beans.size() > 0) {
                    beans.get(2).setDicSelected(!beans.get(2).isDicSelected());
                }
                break;
            case R.id.btn_select_4:
                if (beans != null && beans.size() > 0) {
                    beans.get(3).setDicSelected(!beans.get(3).isDicSelected());
                }
                break;
            case R.id.btn_select_5:
                if (beans != null && beans.size() > 0) {
                    beans.get(4).setDicSelected(!beans.get(4).isDicSelected());
                }
                break;
            case R.id.btn_select_6:
                if (beans != null && beans.size() > 0) {
                    beans.get(5).setDicSelected(!beans.get(5).isDicSelected());
                }
                break;
            case R.id.btn_select_7:
                if (beans != null && beans.size() > 0) {
                    beans.get(6).setDicSelected(!beans.get(6).isDicSelected());
                }
                break;
            case R.id.btn_select_8:
                if (beans != null && beans.size() > 0) {
                    beans.get(7).setDicSelected(!beans.get(7).isDicSelected());
                }
                break;
            case R.id.btn_select_9:
                if (beans != null && beans.size() > 0) {
                    beans.get(8).setDicSelected(!beans.get(8).isDicSelected());
                }
                break;
            case R.id.btn_select_10:
                if (beans != null && beans.size() > 0) {
                    beans.get(9).setDicSelected(!beans.get(9).isDicSelected());
                }
                break;
            case R.id.btn_select_11:
                if (beans != null && beans.size() > 0) {
                    beans.get(10).setDicSelected(!beans.get(10).isDicSelected());
                }
                break;
        }
        RefreshButton();
    }


}

