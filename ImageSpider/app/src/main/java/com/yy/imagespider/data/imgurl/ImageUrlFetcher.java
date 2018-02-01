package com.yy.imagespider.data.imgurl;


import java.security.PublicKey;
import java.util.List;

public class ImageUrlFetcher implements IImageUrlSource{
    /**
     * URL缓存策略
     */
    public enum Strategy{
        LRU
    }

    private IImageUrlSource mDataSource;

    /**
     * 根据缓存策略创建对应的数据源
     * @param strategy
     */
    private void createDataSource(Strategy strategy){
        switch (strategy){
            case LRU:
                mDataSource = new ImageUrlSourceLRU();
                break;
        }
    }

    public ImageUrlFetcher(Strategy strategy) {
        createDataSource(strategy);
    }

    @Override
    public void getImageUrl(int position, int count, OnUrlGetListener listener) {
        mDataSource.getImageUrl(position, count, listener);
    }
}
