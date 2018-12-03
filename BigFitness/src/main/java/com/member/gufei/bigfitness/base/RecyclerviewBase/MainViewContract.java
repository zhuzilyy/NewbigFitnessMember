package com.member.gufei.bigfitness.base.RecyclerviewBase;

import java.util.List;

/**
 * Created by tre on 16/9/13.
 */
public interface MainViewContract {

      interface  MainViewPresenter{

        void getData(final String URl, final int index);

      }

        interface  MainSendRequest<T>{

            void SendRequest(List<T> list);
        }

    interface MainView{

        /**
         * 隐藏 recyclerView 并显示加载动画
         */
        void loading();

        /**
         * 为 adapter 设置数据集合, 并显示 recyclerView 提示加载完成隐藏加载动画
         */
        void refresh();

        /**
         * 显示加载失败错误提示信息, 显示刷新重试按钮
         */
        void error();

    }

}
