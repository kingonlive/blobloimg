package com.yy.goodpicxiuxiu.gallery;

import android.support.v7.widget.RecyclerView;


import com.yy.goodpicxiuxiu.GlobalConfig;
import com.yy.goodpicxiuxiu.data.imgurl.ImageUrlFetcher;
import com.yy.goodpicxiuxiu.data.imgurl.IGetURLListener;
import com.yy.goodpicxiuxiu.util.Log;

import java.util.List;

public class GridPresenter implements GridContract.Presenter, IGetURLListener {
    private static final String TAG = "GridPresenter";

    private ImageUrlFetcher mImageUrlFetcher = new ImageUrlFetcher(ImageUrlFetcher.Strategy.LRU);
    private GridContract.View mView;
    private boolean mGettingData = false;
    private int itemCountPerScreen = 0;
    public GridPresenter(GridContract.View view) {
        this.mView = view;
    }

    /**
     * 返回一屏幕有多少个项
     * @return
     */
    private int calculateHowManyItemPerScreen(){
        if (itemCountPerScreen == 0){
            int itemWidth = GlobalConfig.getInstance().getWindowWidth() / GridFragment.COLUMN_NUM;
            //每屏的个数
            itemCountPerScreen = GlobalConfig.getInstance().getWindowHeight() / itemWidth * GridFragment.COLUMN_NUM;
        }
        return itemCountPerScreen;
    }

    @Override
    public void start() {
        //启动后默认拿2屏数据
        mImageUrlFetcher.getImageUrl(0, calculateHowManyItemPerScreen() * 2, this);
    }

    @Override
    public void onGetUrl(List<String> urls) {
        mGettingData = false;
        mView.addDatas(urls);
        Log.d(TAG, "onGetUrl urls.size:" + urls.size());
    }

    /**
     * 返回下一屏数据
     * @param nextFirstShouldVisibleItem 下一屏首项位置
     */
    private void getNextScreen(int nextFirstShouldVisibleItem){
        mImageUrlFetcher.getImageUrl(nextFirstShouldVisibleItem, calculateHowManyItemPerScreen()* 4, this);
    }

    @Override
    public void onScrollStateChanged(int newState, int nextFirstShouldVisibleItem) {
        if (newState == RecyclerView.SCROLL_STATE_IDLE){
            if (mGettingData){
                return;
            }
            mGettingData = true;
            getNextScreen(nextFirstShouldVisibleItem);

        }
    }
}
