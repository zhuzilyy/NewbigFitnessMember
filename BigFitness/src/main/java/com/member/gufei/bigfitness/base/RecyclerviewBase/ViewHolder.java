package com.member.gufei.bigfitness.base.RecyclerviewBase;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by tre on 16/9/17.
 */
public class ViewHolder extends RecyclerView.ViewHolder {

    private SparseArray<View> views; //控件集合

    private View currentView;  //当前视图


    public ViewHolder(View itemView) {

        super(itemView);

        this.views = new SparseArray<>();

        this.currentView = itemView;
    }


    public  static ViewHolder getInstants(int layoutId, Context context, ViewGroup parent){


        return new ViewHolder(LayoutInflater.from(context).inflate(layoutId,parent,false));

    }

    /*
    * 通过控件ID 获取控件
    * */

    public <T extends View>T getView(int viewId){

        View view=views.get(viewId);

        if (view==null){
            view=currentView.findViewById(viewId);
            views.put(viewId,view);

        }


        return (T) view;
    }

//
//     /*
//    * 通过控件ID 获取布局
//    * */
//
//    public <T extends LinearLayout>T getView(int viewId){
//
//        View view=views.get(viewId);
//
//        if (view==null){
//            view=currentView.findViewById(viewId);
//            views.put(viewId,view);
//
//        }
//
//
//        return (T) view;
//    }
//

    /*
    * 设置TextView内容*/

    public ViewHolder setText(int viewId, String text){

        TextView textView=getView(viewId);

        textView.setText(text);

        return this;
    }

    //设置图片内容
    public ImageView setImage(int viewId){


        ImageView imageView=getView(viewId);

        return  imageView;
      }

    //
    public ViewHolder setOnClickListener(int viewId, View.OnClickListener listener){



        View view=getView(viewId);

        view.setOnClickListener(listener);

        return this;

    }
}
