package com.member.gufei.bigfitness.base.RecyclerviewBase;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.member.gufei.bigfitness.R;

import java.util.List;

/**
 * Created by tre on 16/9/17.
 */
public abstract class CommonAdapter<T> extends RecyclerView.Adapter<ViewHolder> {

    protected Context context; // 上下文

    protected int layoutId; // 布局ID


    protected int mCount; // 布局ID

    protected List<T> datas; // 数据集合


    private boolean showFooter = true;

    private boolean showdiy = false;
    private String FooterText = "";


    private static final int TYPE_FOOTER = 100;

    private static final int TYPE_PLUS = 101;

//    private OnItemLongClickListener mOnItemLongClickListener;


    /**
     * 构造，初始化属性
     */
    public CommonAdapter(int layoutId, Context context, List<T> datas) {

        this(layoutId, context, datas, null);
    }

    public CommonAdapter(int layoutId, Context context, List<T> datas, MultiItemTypeSupport<T> multiItemTypeSupport) {
        this.context = context;
        this.layoutId = layoutId;
        this.datas = datas;
        this.multiItemTypeSupport = multiItemTypeSupport;
    }

//    public void setOnItemLongClickListener(OnItemLongClickListener mOnItemLongClickListener) {
//        this.mOnItemLongClickListener = mOnItemLongClickListener;
//    }


    /**
     * ItemView 点击事件回调接口
     */
    public interface OnItemClickListener<T> {
        void onItemClick(T t, int position);
    }
//    /**
//     * ItemView 长按事件回调接口
//     */
//    public interface OnItemLongClickListener<T>{
//        void onItemLongClick(T t,int position);
//    }

    /**
     * 多布局类型处理接口
     */
    public interface MultiItemTypeSupport<T> {
        /**
         * 根据Bean获取项目类型
         */
        int getItemViewType(int position, T t);

        /**
         * 根据项目类型获取布局ID
         */
        int getLayoutId(int itemType);
    }

    /**
     * foot点击事件回调
     */
    public interface FootOnClickListener {
        /**
         * 点击
         */
         void OnClick();


    }

    protected OnItemClickListener<T> listener;
    protected FootOnClickListener footOnClickListener;

    /**
     * 设置 item listener
     */
    public void setListener(OnItemClickListener<T> listener) {
        this.listener = listener;
    }
    public void setfootOnClickListener(FootOnClickListener footOnClickListener) {
        this.footOnClickListener = footOnClickListener;
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

        // TODO: 2017/4/13 强制修改了不显示自定义加载部分

            //        showFooter=false;
            if (!showFooter && !showdiy) {
                if (multiItemTypeSupport != null) {
                    return multiItemTypeSupport.getItemViewType(position, datas.get(position));
                } else {
                    return super.getItemViewType(position);
                }
            }
            if (position + 1 == getItemCount()) {

                if (showdiy){
                    return TYPE_PLUS;
                }else{
                    return TYPE_FOOTER;
                }

            } else {
                if (multiItemTypeSupport != null) {
                    return multiItemTypeSupport.getItemViewType(position, datas.get(position));
                } else {
                    return super.getItemViewType(position);
                }
            }

    }

    /**
     * 创建 ViewHolder
     */
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_FOOTER) {
            return ViewHolder.getInstants(R.layout.item_footer, context, parent);
        }
        if (viewType == TYPE_PLUS) {

//            ViewHolder viewHolder= ViewHolder.getInstants(R.layout.cardview_training_plan_list_plus, context, parent);
            ViewHolder viewHolder= ViewHolder.getInstants(R.layout.item_footer, context, parent);
            viewHolder.setText(R.id.btn_foot,FooterText);

            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    footOnClickListener.OnClick();

                }
            });


            return viewHolder;
        }
        if (multiItemTypeSupport != null) {
            return ViewHolder.getInstants(multiItemTypeSupport.getLayoutId(viewType), context, parent);
        } else {
            return ViewHolder.getInstants(layoutId, context, parent);
        }
    }

    /**
     * 绑定控件
     */
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        if (showFooter && position + 1 == getItemCount()) {
            return;
        }
        if (showdiy && position + 1 == getItemCount()) {
            return;
        }

        if (listener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    listener.onItemClick(datas.get(holder.getAdapterPosition()), position);

                }
            });
        }

//        if(mOnItemLongClickListener != null){
//            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
//                @Override
//                public boolean onLongClick(View v) {
//                    int position = holder.getLayoutPosition();
//                    mOnItemLongClickListener.onItemLongClick(holder.itemView,position);
//                    //返回true 表示消耗了事件 事件不会继续传递
//                    return true;
//                }
//            });
//        }

            convert(holder, datas.get(position), position);



    }

    /**
     * 抽象方法，需要使用者实现具体的绑定细节
     *
     * @param holder   holder对象
     * @param t        数据对象
     * @param position 位置
     */
    protected abstract void convert(ViewHolder holder, T t, int position);

    /**
     * 数据数量
     */
    @Override
    public int getItemCount() {


        if (showdiy) {

              return datas.size() + (showdiy ? 1 : 0);

        } else {

             return datas.size() + (showFooter ? 1 : 0);

        }


    }

    /**
     * 设置数据
     *
     * @param datas data
     */
    public void replaceData(List<T> datas) {

        this.datas = datas;

        this.notifyDataSetChanged();
    }

    /**
     * 设置底部文字
     *
     * @param FooterText
     */
    public void setFooterText(String FooterText) {

        this.FooterText = FooterText;


    }
    /**
     * 刷新数据
     *
     * @param datas data
     */
    public void refreshData(List<T> datas) {

        this.datas = datas;

        this.notifyDataSetChanged();
    }

    /**
     * 追加数据
     *
     * @param datas data
     */
    public void insertData(List<T> datas) {
        this.datas.addAll(datas);
        this.notifyDataSetChanged();
    }
    //  删除数据
    public void removeData(int position) {
        datas.remove(position);
        //删除动画
        notifyItemRemoved(position);
        notifyDataSetChanged();
    }

    /**
     * 最前面追加数据
     *
     * @param datas data
     */
    public void FirstinsertData(List<T> datas) {

        List<T> Firstdatas=this.datas;

        datas.addAll(Firstdatas);

        this.datas=datas;

        this.notifyDataSetChanged();
    }

    public void addItems(List<T> datas,int position)
    {
        this.datas.addAll(position, datas);
        notifyItemRangeInserted(position, datas.size());
        notifyItemRangeChanged(position + datas.size(), getItemCount()-datas.size());

    }

    public void setShowFooter(boolean showFooter) {
        this.showFooter = showFooter;
    }

    public void setShowdiy(boolean showdiy) {
        this.showdiy = showdiy;
    }

}
