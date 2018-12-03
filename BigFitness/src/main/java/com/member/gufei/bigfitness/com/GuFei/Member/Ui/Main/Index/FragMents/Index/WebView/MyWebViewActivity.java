package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.FragMents.Index.WebView;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LevelListDrawable;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.text.Html;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.member.gufei.bigfitness.R;
import com.member.gufei.bigfitness.base.BaseActivity;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.EventDetailBean;
import com.member.gufei.bigfitness.util.SpUtil;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.member.gufei.bigfitness.Constants.PUT_STR;
import static com.member.gufei.bigfitness.Constants.TOKENKEY;


public class MyWebViewActivity extends BaseActivity<MyWebViewActivityPresenter> implements MyWebViewActivityContract.View {


    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_content)
    TextView tvContent;
    private String token;
    private String id;
    private String html;

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_my_web_view;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        token = (String) SpUtil.get(mContext, TOKENKEY, "");
        Intent intent = getIntent();
        id = intent.getStringExtra(PUT_STR + "id");
        mPresenter.getEventDetail(id, token);
    }

    @Override
    public void outLogin() {

    }

    @Override
    public void succeed(EventDetailBean eventDetailBean) {
        tvTitle.setText(eventDetailBean.getRows().getTitle());
        html = eventDetailBean.getRows().getContent2();
        tvContent.setMovementMethod(ScrollingMovementMethod.getInstance());// 设置可滚动
        tvContent.setMovementMethod(LinkMovementMethod.getInstance());//设置超链接可以打开网页
        HtmlImageGetter htmlImageGetter = new HtmlImageGetter();
        tvContent.setText(Html.fromHtml(html, htmlImageGetter, null));
    }
    /**
     * 重写图片加载接口
     *
     * @author Ruffian
     * @date 2016年1月15日
     *
     */
    class HtmlImageGetter implements Html.ImageGetter {

        /**
         * 获取图片
         */
        @Override
        public Drawable getDrawable(String source) {
            LevelListDrawable d = new LevelListDrawable();
            Drawable empty = getResources().getDrawable(
                    R.drawable.img_private_class_details);
            d.addLevel(0, 0, empty);
            d.setBounds(0, 0, empty.getIntrinsicWidth(),
                    empty.getIntrinsicHeight());
            new LoadImage().execute(source, d);
            return d;
        }

        /**
         * 异步下载图片类
         *
         * @author Ruffian
         * @date 2016年1月15日
         */
        class LoadImage extends AsyncTask<Object, Void, Bitmap> {

            private LevelListDrawable mDrawable;

            @Override
            protected Bitmap doInBackground(Object... params) {
                String source = (String) params[0];
                mDrawable = (LevelListDrawable) params[1];
                InputStream is=null;
                try {
                    is = new URL(source).openStream();

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return BitmapFactory.decodeStream(is);
            }

            /**
             * 图片下载完成后执行
             */
            @Override
            protected void onPostExecute(Bitmap bitmap) {
                if (bitmap != null) {
                    BitmapDrawable d = new BitmapDrawable(bitmap);
                    mDrawable.addLevel(1, 1, d);
                    /**
                     * 适配图片大小 <br/>
                     * 默认大小：bitmap.getWidth(), bitmap.getHeight()<br/>
                     * 适配屏幕：getDrawableAdapter
                     */
                    mDrawable = getDrawableAdapter(mContext, mDrawable,
                            bitmap.getWidth(), bitmap.getHeight());

                    // mDrawable.setBounds(0, 0, bitmap.getWidth(),
                    // bitmap.getHeight());

                    mDrawable.setLevel(1);

                    /**
                     * 图片下载完成之后重新赋值textView<br/>
                     * mtvActNewsContent:我项目中使用的textView
                     *
                     */
                    tvContent.invalidate();
                    CharSequence t = tvContent.getText();
                    tvContent.setText(t);

                }
            }

            /**
             * 加载网络图片,适配大小
             *
             * @param context
             * @param drawable
             * @param oldWidth
             * @param oldHeight
             * @return
             * @author Ruffian
             * @date 2016年1月15日
             */
            public LevelListDrawable getDrawableAdapter(Activity context,
                                                        LevelListDrawable drawable, int oldWidth, int oldHeight) {
                LevelListDrawable newDrawable = drawable;
                long newHeight = 0;// 未知数
                int newWidth = drawable.getIntrinsicWidth();// 默认屏幕宽
                newHeight = (newWidth * oldHeight) / oldWidth;
                // LogUtils.w("oldWidth:" + oldWidth + "oldHeight:" +
                // oldHeight);
                // LogUtils.w("newHeight:" + newHeight + "newWidth:" +
                // newWidth);
                newDrawable.setBounds(0, 0, newWidth, (int) newHeight);
                return newDrawable;
            }
        }

    }
//    Html.ImageGetter imgGetter = new Html.ImageGetter() {
//        public Drawable getDrawable(String source) {
//            Log.i("RG", "source---?>>>" + source);
//            Drawable drawable = null;
//            URL url;
//            try {
//                url = new URL(source);
//                Log.i("RG", "url---?>>>" + url);
//                drawable = Drawable.createFromStream(url.openStream(), ""); // 获取网路图片
//            } catch (Exception e) {
//                e.printStackTrace();
//                return null;
//            }
//            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(),
//                    drawable.getIntrinsicHeight());
//            Log.i("RG", "url---?>>>" + url);
//            return drawable;
//        }
//    };

    @Override
    public void showEmpty() {

    }

    @Override
    public void Loading() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick(R.id.iv_back)
    public void onViewClicked() {
        finish();
    }
}
