package com.yy.goodpicxiuxiu.gallery;

import android.support.v7.widget.RecyclerView;

import com.yy.goodpicxiuxiu.BasePresenter;
import com.yy.goodpicxiuxiu.BaseView;

import java.util.List;

/**
 * Gellery主要就一个图片墙壁,体验上滚动时不加载图片,停止滚动时加载图片.
 */
public class GelleryContract {

    interface Presenter extends BasePresenter {
        /**
         * 列表的滚动回调
         * @param newState     新的滚动状态,其值是 {@link #RecyclerView.SCROLL_STATE_IDLE},{@link #RecyclerView.SCROLL_STATE_DRAGGING},{@link #RecyclerView.SCROLL_STATE_SETTLING}之一
         * @param firstVisibleItem 下一屏第一个可见项索引
         * @param count 一屏的数量
         */
        void onScrollStateChanged(int newState, int firstVisibleItem, int count);
    }

    interface View extends BaseView<Presenter> {
        /**
         * 添加图片的url
         * @param list
         */
        void addDatas(List<String> list);
    }

}
