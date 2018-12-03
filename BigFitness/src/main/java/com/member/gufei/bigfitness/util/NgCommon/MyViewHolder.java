package com.member.gufei.bigfitness.util.NgCommon;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.member.gufei.bigfitness.R;
import com.member.gufei.bigfitness.util.NgCommon.view.SlidingButtonView;

import static com.member.gufei.bigfitness.Constants.BASEURL;


/**
 * Created by jiangzn on 17/1/1.
 */

public class MyViewHolder extends RecyclerView.ViewHolder {
    private SparseArray<View> views; // 控件集合
    private View currentView; // 当前视图
    private Context context; // 上下文

    public TextView textView;
    public ViewGroup layout_content;
    public SlidingButtonView slidingButtonView;
    public RelativeLayout rl_left;
    public RadioButton rbtn;

    /**
     * 构造函数，初始化属性
     */
    public MyViewHolder(View itemView, Context context) {
        super(itemView);
        this.currentView = itemView;
        this.context = context;
        this.views = new SparseArray<>();
        textView = (TextView) itemView.findViewById(R.id.text);
        layout_content = (ViewGroup) itemView.findViewById(R.id.layout_content);
        slidingButtonView = (SlidingButtonView) itemView;
        rl_left = (RelativeLayout) itemView.findViewById(R.id.rl_left);
        slidingButtonView = (SlidingButtonView) itemView;
        rbtn = (RadioButton) itemView.findViewById(R.id.rbtn);
    }

    /**
     * 实例方法
     * @param layoutId 布局ID
     * @param context 上下文
     * @param parent 父容器
     */
    public static MyViewHolder getInstants(int layoutId, Context context, ViewGroup parent) {




        return new MyViewHolder(LayoutInflater.from(context).inflate(layoutId, parent, false),context);
    }

    /**
     * 通过控件ID 获取控件
     * @param viewId 控件ID
     * @param <V> 控件
     */
    public <V extends View> V getView(int viewId) {
        View view = views.get(viewId);
        if (view == null) {
            view = currentView.findViewById(viewId);
            views.put(viewId, view);
        }
        return (V) view;
    }

    /**
     * 设置 TextView 内容
     * @param viewId 控件ID
     * @param text 内容
     */
    public MyViewHolder setText(int viewId, String text) {
        TextView textView = getView(viewId);
        textView.setText(text);
        return this;
    }

    /**
     * 设置图片
     * 以下 setXXX 方法可随时添加,方便调用者处理绑定控件.
     */
    public MyViewHolder setImage(int viewId, int resId) {
        ImageView imageView = getView(viewId);
        imageView.setImageResource(resId);
        return this;
    }

    /**
     * 设置图片
     * 使用 Glide 请求网络图片
     */
    public MyViewHolder setImage(int viewId, String url) {
        ImageView imageView = getView(viewId);


        RequestOptions options = new RequestOptions();
        options.centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL);



        Glide.with(context)
                .load(url)
                .apply(options)
                .into(imageView);


        return this;
    }

    /**
     * 设置控件点击事件
     */
    public MyViewHolder setOnClickListener(int viewId, View.OnClickListener listener) {
        View view = getView(viewId);
        view.setOnClickListener(listener);
        return this;
    }
}
