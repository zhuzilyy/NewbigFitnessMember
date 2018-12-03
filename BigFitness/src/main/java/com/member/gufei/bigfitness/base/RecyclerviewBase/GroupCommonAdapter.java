package com.member.gufei.bigfitness.base.RecyclerviewBase;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.member.gufei.bigfitness.R;
import com.member.gufei.bigfitness.com.GuFei.Model.local.TrainingPlanBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tre on 16/9/17.
 */
public abstract class GroupCommonAdapter<T> extends RecyclerView.Adapter<ViewHolder> {

    protected Context context; // 上下文

    protected int layoutId; // 布局ID

    protected int mCount; // 布局ID

    protected List<T> datas; // 数据集合

    private List<Integer> datasCount = new ArrayList<Integer>();


    private static final int TYPE_PLUS = 101;

    private static final int TYPE_HEAD = 99;


    /**
     * 构造，初始化属性
     */
    public GroupCommonAdapter(int layoutId, Context context, List<T> datas) {

        this(layoutId, context, datas, null);
    }

    public GroupCommonAdapter(int layoutId, Context context, List<T> datas, MultiItemTypeSupport<T> multiItemTypeSupport) {

        this.context = context;

        this.layoutId = layoutId;

        this.datas = datas;

        this.multiItemTypeSupport = multiItemTypeSupport;
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
    public interface MultiItemTypeSupport<T> {
        /**
         * 根据Bean获取项目类型
         */
        int getItemViewType(int position, int Count);

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

        // TODO: 2017/4/13 强制修改了不显示自定义加载部分

        //        showFooter=false;
        if (position + 1 == getItemCount()) {

            return TYPE_PLUS;

        } else {

            if (multiItemTypeSupport != null) {

//                if (datasCount.contains(position)) {
//
//                    return TYPE_HEAD;
//
//                } else {

                    return multiItemTypeSupport.getItemViewType(position, mCount);

//                }


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

        if (viewType == TYPE_PLUS) {
            return ViewHolder.getInstants(R.layout.cardview_training_plan_list_plus, context, parent);
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

//        if (showFooter && position + 1 == getItemCount()) {
//            return;
//        }
        if (position + 1 == getItemCount()) {

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
//        int index=position % 10;
//        if (position<10){
//
//        }else

//      convert(holder, datas.get(position), position);
      convert(holder,  position,mCount);


    }

    /**
     * 抽象方法，需要使用者实现具体的绑定细节
     *
     * @param holder   holder对象
     * @param position 位置
     * @param mCount        数据对象
     */
//    protected abstract void convert(ViewHolder holder, T t, int position);
    protected abstract void convert(ViewHolder holder,  int position,int mCount);

    /**
     * 数据数量
     */
    @Override
    public int getItemCount() {


        int count = datas.size();

        int headcount = 0;

        for (int i = 0; i < datas.size(); i++) {

            TrainingPlanBean.ResultBean resultBean = new TrainingPlanBean.ResultBean();

            try {

                resultBean = (TrainingPlanBean.ResultBean) datas.get(i);

                count += resultBean.getList().size();

                datasCount.add(headcount);

                headcount += i + resultBean.getList().size();

            } catch (Exception e) {

                e.printStackTrace();

            }


        }

        mCount = count;

        return count + 1;


    }

    /**
     * 设置数据
     *
     * @param datas data
     */
    public void replaceData(List<T> datas) {

        this.datas = datas;

        datasCount.clear();


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


}
