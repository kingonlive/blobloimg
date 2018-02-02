package com.yy.goodpicxiuxiu.gallery;

import android.support.v7.widget.RecyclerView;


import com.yy.goodpicxiuxiu.data.imgurl.ImageUrlFetcher;
import com.yy.goodpicxiuxiu.data.imgurl.OnUrlGetListener;

import java.util.List;

public class GelleryPresenter implements GelleryContract.Presenter, OnUrlGetListener {
    private ImageUrlFetcher mImageUrlFetcher = new ImageUrlFetcher(ImageUrlFetcher.Strategy.LRU);
    private GelleryContract.View mView;

    public GelleryPresenter(GelleryContract.View view) {
        this.mView = view;
    }

    @Override
    public void start() {
        mImageUrlFetcher.getImageUrl(0, 1000, this);
    }

    @Override
    public void onGetUrl(List<String> urls) {
        mView.addDatas(urls);
    }

    @Override
    public void onScrollStateChanged(int newState, int firstVisibleItem, int count) {
        if (newState == RecyclerView.SCROLL_STATE_IDLE){
            mImageUrlFetcher.getImageUrl(firstVisibleItem, count, this);
        }
    }
}
