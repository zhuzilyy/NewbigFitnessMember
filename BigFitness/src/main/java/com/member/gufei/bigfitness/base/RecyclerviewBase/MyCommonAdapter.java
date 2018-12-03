package com.member.gufei.bigfitness.base.RecyclerviewBase;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;


import com.member.gufei.bigfitness.util.NgCommon.MyViewHolder;
import com.member.gufei.bigfitness.util.NgCommon.util.LogUtils;
import com.member.gufei.bigfitness.util.NgCommon.util.Utils;
import com.member.gufei.bigfitness.util.NgCommon.view.SlidingButtonView;

import java.util.List;

/**
 * Created by tre on 16/9/17.
 */
public abstract class MyCommonAdapter<T> extends RecyclerView.Adapter<MyViewHolder>  implements SlidingButtonView.IonSlidingButtonListener{

    protected Context context; // 上下文
    protected int layoutId; // 布局ID
    protected List<T> datas; // 数据集合



//    private boolean showFooter = true;
//    private static final int TYPE_FOOTER = 100;
//    private MyCommonAdapter.IonSlidingViewClickListener mIDeleteBtnClickListener;
    private SlidingButtonView mMenu = null;

    /**
     * 构造，初始化属性
     */
    public MyCommonAdapter(int layoutId, Context context, List<T> datas) {
        this(layoutId, context, datas, null);
    }

    public MyCommonAdapter(int layoutId, Context context, List<T> datas, MultiItemTypeSupport<T> multiItemTypeSupport) {

        this.context = context;

        this.layoutId = layoutId;

        this.datas = datas;





        this.multiItemTypeSupport = multiItemTypeSupport;

//        mIDeleteBtnClickListener = (MyCommonAdapter.IonSlidingViewClickListener) context;
    }



    /**
     * ItemView 点击事件回调接口
     */
    public interface OnItemClickListener<T> {
        void onItemClick(T t, int position);
    }

    /**
     * 多布局类型处理接口
     */
    public interface MultiItemTypeSupport<T>{
        /**
         * 根据Bean获取项目类型
         */
        int getItemViewType(int position, T t);

        /**
         * 根据项目类型获取布局ID
         */
        int getLayoutId(int itemType);
    }

    protected OnItemClickListener<T> listener;

    /**
     * 设置 item listener
     */
    public void setListener(OnItemClickListener<T> listener) {
        this.listener = listener;
    }

    protected MultiItemTypeSupport<T> multiItemTypeSupport;

    /**
     * 设置 multiItemTypeSupport
     */
    public void setMultiItemTypeSupport(MultiItemTypeSupport<T> multiItemTypeSupport) {
        this.multiItemTypeSupport = multiItemTypeSupport;
    }

    /**
     * 获取条目布局类型,返回值到 onCreateViewHolder 方法中第二个参数
     */
    @Override
    public int getItemViewType(int position) {
//        if (!showFooter) {
//            if (multiItemTypeSupport != null) {
//                return multiItemTypeSupport.getItemViewType(position, datas.get(position));
//            } else {
//                return super.getItemViewType(position);
//            }
//        }
//        if (position + 1 == getItemCount()) {
//            return TYPE_FOOTER;
//        } else {
//            if (multiItemTypeSupport != null) {
//                return multiItemTypeSupport.getItemViewType(position, datas.get(position));
//            } else {
//                return super.getItemViewType(position);
//            }
//        }
        return super.getItemViewType(position);
    }

    /**
     * 创建 ViewHolder
     */
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        return MyViewHolder.getInstants(layoutId,context,parent);

//        if (viewType == TYPE_FOOTER) {
//            return MyViewHolder.getInstants(R.layout.item_footer, context, parent);
//        }
//        if (multiItemTypeSupport != null) {
//            return MyViewHolder.getInstants(multiItemTypeSupport.getLayoutId(viewType), context, parent);
//        } else {
//            return MyViewHolder.getInstants(layoutId,context,parent);
//        }
    }
/*
* 设置全部打开
* */
    boolean allopen = false;

    public void setAllopen(boolean allopen) {

        this.allopen = allopen;

    }

    /**
     * 绑定控件
     */
    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {



//        final MyViewHolder viewHolder = (MyViewHolder) holder;

        holder.layout_content.getLayoutParams().width = Utils.getScreenWidth(context) + holder.rl_left.getLayoutParams().width;

        holder.itemView.setTag(new Integer(position));//设置tag 否则划回来时选中消失


//        if (selectedArr != null) {
//
//            holder.rbtn.setSelected(selectedArr.get(position));
//
//        } else {
//            holder.rbtn.setSelected(false);
//
//          }

//        viewHolder.setIsRecyclable(false);



//        if (showFooter && position + 1 == getItemCount()) {
//            return;
//        }


        if (listener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    listener.onItemClick(datas.get(holder.getAdapterPosition()),position);


                }
            });
        }

//        holder.rbtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
////                selectedArr.set(position,!selectedArr.get(position));
//
////                notifyDataSetChanged();
//
//            }
//        });


        if (allopen) {


                  LogUtils.d("打开？");
                  holder.slidingButtonView.openMenu();
                  holder.slidingButtonView.setCanTouch(false);
//                  holder.slidingButtonView.setSelecteBtn(selectedArr.get(position));
//                    holder.itemView.setTag(new Integer(position));//设置tag 否则划回来时选中消失



//            viewHolder.rbtn.setSelected(selectedArr.get(position));

        } else {
            LogUtils.d("？");
            holder.slidingButtonView.closeMenu();
            holder.slidingButtonView.setCanTouch(true);

        }

        convert(holder, datas.get(position), position);
    }

    /**
     * 抽象方法，需要使用者实现具体的绑定细节
     *
     * @param holder   holder对象
     * @param t        数据对象
     * @param position 位置
     */
    protected abstract void convert(MyViewHolder holder, T t, int position);

    /**
     * 数据数量
     */
    @Override
    public int getItemCount() {
        return datas.size();
    }

    /**
     * 设置数据
     * @param datas data
     */
    public void replaceData(List<T> datas) {

        this.datas = datas;


        this.notifyDataSetChanged();
    }

    /**
     * 追加数据
     * @param datas data
     */
    public void insertData(List<T> datas) {
        this.datas.addAll(datas);
        this.notifyDataSetChanged();
    }

    /**
     * 关闭菜单
     */
    public void closeMenu() {
        mMenu.closeMenu();
        mMenu = null;

    }

    /**
     * 判断是否有菜单打开
     */
    public Boolean menuIsOpen() {
        if (mMenu != null) {
            return true;
        }
        return false;
    }

    public interface IonSlidingViewClickListener {

        void onItemClick(View view, int position);

        void onDeleteBtnCilck(View view, int position);
    }

//    public void setShowFooter(boolean showFooter) {
//        this.showFooter = showFooter;
//   }

}
