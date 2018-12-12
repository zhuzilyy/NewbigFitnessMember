package com.member.gufei.bigfitness.com.GuFei.Member.Ui.User.Login;

import android.app.ActivityManager;
import android.content.Intent;
import android.os.Bundle;
import android.text.Selection;
import android.text.Spannable;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.igexin.sdk.PushManager;
import com.member.gufei.bigfitness.App;
import com.member.gufei.bigfitness.R;
import com.member.gufei.bigfitness.base.BaseActivity;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.AllCulbsList.AllCulbsListActivity;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.MyCenter.MyCardList.MyCardListActivity;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.MyCenter.MyPrivateTeaching.MyPrivateTeachingActivity;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.main.MainActivity;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.User.Register.RegisterActivity;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.User.Register.Sex.SexActivity;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.User.Register.UserInfo.UserInfoActivity;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.User.Set.ResetPwd.FindPwd.FindPwdActivity;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.FitnessRequestBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.LandAppUserBean;

import com.member.gufei.bigfitness.com.GuFei.Push.IntentService;
import com.member.gufei.bigfitness.util.ProgressBar.LoadingDialog;
import com.member.gufei.bigfitness.util.SpUtil;
import com.member.gufei.bigfitness.util.StringUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.member.gufei.bigfitness.Constants.ACCOUNTKEY;
import static com.member.gufei.bigfitness.Constants.BIRTHDAYKEY;
import static com.member.gufei.bigfitness.Constants.CLIENTID;

import static com.member.gufei.bigfitness.Constants.DEVICECODEKEY;

import static com.member.gufei.bigfitness.Constants.FITNESSREQUESTKEY;
import static com.member.gufei.bigfitness.Constants.FITNESSREQUESTLISTKEY;
import static com.member.gufei.bigfitness.Constants.FITNESSREQUESTNAMEKEY;
import static com.member.gufei.bigfitness.Constants.HEADERURLKEY;
import static com.member.gufei.bigfitness.Constants.HEIGHTKEY;
import static com.member.gufei.bigfitness.Constants.LOGINKEY;
import static com.member.gufei.bigfitness.Constants.MOBLIEKEY;
import static com.member.gufei.bigfitness.Constants.NICKNAMEKEY;
import static com.member.gufei.bigfitness.Constants.PASSWRODKEY;

import static com.member.gufei.bigfitness.Constants.PUT_STR;
import static com.member.gufei.bigfitness.Constants.SEXKEY;
import static com.member.gufei.bigfitness.Constants.TOKENKEY;
import static com.member.gufei.bigfitness.Constants.USERIDKEY;

import static com.member.gufei.bigfitness.Constants.WEIGHTKEY;
import static com.member.gufei.bigfitness.Constants.WELCOMESHOWKEY;
import static com.member.gufei.bigfitness.util.ListUtil.toJson;
import static com.member.gufei.bigfitness.util.ToastUtil.s;

/**
 * Created by GuFei_lyf on 2017/3/22
 * 登录页面 实现
 */


public class LoginActivity extends BaseActivity<LoginActivityPresenter> implements LoginActivityContract.View {
    @BindView(R.id.username)
    EditText username;
    @BindView(R.id.password)
    EditText password;
    @BindView(R.id.invisible_password)
    ImageView invisiblePassword;
    @BindView(R.id.login_btn)
    Button loginBtn;
    @BindView(R.id.btn_forget)
    TextView btnForget;
    @BindView(R.id.btn_register)
    TextView btnRegister;

    private boolean isHidden = true;

    String clientId;
    private LoadingDialog loadingDialog;

    @Override
    protected void initInject() {

        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView() {
        loadingDialog = new LoadingDialog(this);
        InitGPS();
        //String CLIENTID = PushManager.getInstance().getClientid(mContext);
       /* if(!TextUtils.isEmpty(PushManager.getInstance().getClientid(mContext))){
            SpUtil.put(mContext, CLIENTID, PushManager.getInstance().getClientid(mContext));
        }*/
        Log.e("Tmde", "laji");
        String name = (String) SpUtil.get(mContext, ACCOUNTKEY, "");
        String pwd = (String) SpUtil.get(mContext, PASSWRODKEY, "");
        String login = (String) SpUtil.get(mContext, LOGINKEY, "");
        clientId = (String) SpUtil.get(mContext, "clientId", "");
//        if (!StringUtil.isSpace(name) && !StringUtil.isSpace(pwd)) {
//            username.setText(name);
//            password.setText(pwd);
////            remberCheckBox.setChecked(true);
//            if (login.equals("1")) {
//                mPresenter.landAppUser(name, pwd, clientId, true);//设备码未填写 为假数据
//                SpUtil.put(mContext, LOGINKEY, "0");
//            }
//        }
    }
    /**
     * 固化用户信息
     * @param account         帐号
     * @param password        密码
     * @param deviceCode      设备号
     * @param landAppUserBean 登录返回信息
     * @param flag            记录标识
     */
    @Override
    public void remember(String account, String password, String deviceCode, LandAppUserBean landAppUserBean, boolean flag) {
        if (flag) {
            SpUtil.put(mContext, ACCOUNTKEY, account);
            SpUtil.put(mContext, PASSWRODKEY, password);
            SpUtil.put(mContext, LOGINKEY, "1");
        }
        SpUtil.put(mContext, WELCOMESHOWKEY, "1");
        SpUtil.put(mContext, DEVICECODEKEY, deviceCode);
        SpUtil.put(mContext, USERIDKEY, landAppUserBean.getRows().getAPPUserId());
        SpUtil.put(mContext, MOBLIEKEY, landAppUserBean.getRows().getMobile());
        if (landAppUserBean.getRows().getIsAppUserInfo() == 1){
            SpUtil.put(mContext, SEXKEY, landAppUserBean.getRows().getSex());
            SpUtil.put(mContext, HEADERURLKEY, landAppUserBean.getRows().getHeaderURL());
            SpUtil.put(mContext, BIRTHDAYKEY, landAppUserBean.getRows().getBirthday());
            SpUtil.put(mContext, HEIGHTKEY, landAppUserBean.getRows().getHeight());
            SpUtil.put(mContext, FITNESSREQUESTKEY, landAppUserBean.getRows().getFitnessRequest());
            SpUtil.put(mContext, NICKNAMEKEY, landAppUserBean.getRows().getNickName());
            SpUtil.put(mContext, WEIGHTKEY, landAppUserBean.getRows().getWeight());
        }
//        SpUtil.put(mContext, FITNESSREQUESTNAMEKEY, toJson( landAppUserBean.getRows().getFitnessRequestName()));
    }


    @Override
    public void remove() {

        SpUtil.remove(mContext, ACCOUNTKEY);
        SpUtil.remove(mContext, PASSWRODKEY);
        SpUtil.remove(mContext, DEVICECODEKEY);
        SpUtil.remove(mContext, USERIDKEY);

//        SpUtil.remove(mContext, USERNAMEKEY);
//        SpUtil.remove(mContext, SEXKEY);
//        SpUtil.remove(mContext, CLUBIDKEY);
//        SpUtil.remove(mContext, TOKENKEY);
//        SpUtil.remove(mContext, PERSONTYPEKEY);
//        SpUtil.remove(mContext, ISDERPARTMANAGERKEY);
//        SpUtil.remove(mContext, DEPARTIDKEY);

    }

    @Override
    protected void initData() {
//        JPushInterface.init(getApplicationContext());
        mPresenter.getFitnessRequest("GuFei");
    }
    @Override
    public void showError(String msg) {
        loadingDialog.dismiss();
        s(this, msg);
        if (msg.contains("机器码")){
            String name = username.getText().toString();
            String pwd = password.getText().toString();
            login(name,pwd,true,"ANDROID");
        }
    }
    @Override
    public void showEmpty() {

    }

    @Override
    public void outLogin() {
    }
    @Override
    public void Loading() {
        //显示加载的进度条
        loadingDialog.show();
    }
    @Override
    public void succeed(LandAppUserBean landAppUserBean) {
        loadingDialog.dismiss();
        Intent intent;
        String gson = new Gson().toJson(landAppUserBean);
        String msg = landAppUserBean.getMsg();
        s(this, msg);
        Log.e("landAppUserBean", gson);
        if (landAppUserBean.getRet() == 0 && landAppUserBean.getRows().getIsAppUserInfo() == 1) {
            SpUtil.put(mContext, TOKENKEY, landAppUserBean.getRows().getToken());
            intent = new Intent(LoginActivity.this, AllCulbsListActivity.class);
            startActivity(intent);
            finish();

        } else {
            SpUtil.put(mContext, ACCOUNTKEY, username.getText().toString());
            SpUtil.put(mContext, USERIDKEY, landAppUserBean.getRows().getAPPUserId());
            intent = new Intent(LoginActivity.this, SexActivity.class);
            intent.putExtra(PUT_STR + "popCode", "0");
            startActivity(intent);
            finish();
        }
    }

    @Override
    public void FitnessRequestsucceed(FitnessRequestBean fitnessRequestBean) {
        String s = toJson(fitnessRequestBean.getRows());
        SpUtil.put(mContext, FITNESSREQUESTLISTKEY, s);

    }

    @OnClick({R.id.invisible_password, R.id.login_btn, R.id.btn_forget, R.id.btn_register})
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.invisible_password:
                if (isHidden) {
                    //设置EditText文本为可见的
                    password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                } else {
                    //设置EditText文本为隐藏的
                    password.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
                isHidden = !isHidden;
                if (!isHidden) {
                    invisiblePassword.setImageResource(R.mipmap.signin07);
                } else {
                    invisiblePassword.setImageResource(R.mipmap.signin_07);
                }

                password.postInvalidate();

                //切换后将EditText光标置于末尾
                CharSequence charSequence = password.getText();

                if (charSequence instanceof Spannable) {

                    Spannable spanText = (Spannable) charSequence;

                    Selection.setSelection(spanText, charSequence.length());

                }
                break;

//            case R.id.remberCheckBox:
//                break;
            case R.id.login_btn:

                String name = username.getText().toString();
                String pwd = password.getText().toString();
                if (StringUtil.isSpace(name)) {
                    username.requestFocus();
                    s(App.getInstance(), "请输入帐户");
                    return;
                }
                if (StringUtil.isSpace(pwd)) {
                    password.requestFocus();
                    s(App.getInstance(), "请输入密码");
                    return;
                }
                // TODO: 2017/4/10
                if (StringUtil.length(pwd) < 1) {
                    password.requestFocus();
                    s(App.getInstance(), "密码不得小于六位");
                    return;
                }
                login(name,pwd,true,"ANDROID");
              /*  clientId = (String) SpUtil.get(mContext, "clientId", "");
                mPresenter.landAppUser(name, pwd, clientId, true, "ANDROID");*/
//                Intent intent = new Intent(LoginActivity.this, AllCulbsListActivity.class);
//                startActivity(intent);
//                finish();
                break;
            case R.id.btn_forget:
//                Intent register = new Intent(LoginActivity.this, SexActivity.class);
                Intent register = new Intent(LoginActivity.this, FindPwdActivity.class);
//                finish();
                startActivity(register);
                break;
            case R.id.btn_register:
                Intent register1 = new Intent(LoginActivity.this, RegisterActivity.class);
//                Intent register1 = new Intent(LoginActivity.this, SexActivity.class);
//                finish();
                startActivity(register1);
                break;
        }
    }
    //登录的方法
    private void login(String name, String pwd, boolean b, String android) {
        clientId = (String) SpUtil.get(mContext, "clientId", "");
        mPresenter.landAppUser(name, pwd, clientId, true, "ANDROID");
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
                Intent intent = new Intent();
// 为Intent设置Action、Category属性
                intent.setAction(Intent.ACTION_MAIN);// "android.intent.action.MAIN"
                intent.addCategory(Intent.CATEGORY_HOME); //"android.intent.category.HOME"
                startActivity(intent);
//                App.getInstance().exitApp();
////                BaseActivity.getInstance().clear();
//////
//                int currentVersion = android.os.Build.VERSION.SDK_INT;
//                if (currentVersion > android.os.Build.VERSION_CODES.ECLAIR_MR1) {
//                    Intent startMain = new Intent(Intent.ACTION_MAIN);
//                    startMain.addCategory(Intent.CATEGORY_HOME);
//                    startMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                    startActivity(startMain);
//                    System.exit(0);
//                } else {// android2.1
//                    ActivityManager am = (ActivityManager) getSystemService(ACTIVITY_SERVICE);
//                    am.restartPackage(getPackageName());
//                }
            }

            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

}

