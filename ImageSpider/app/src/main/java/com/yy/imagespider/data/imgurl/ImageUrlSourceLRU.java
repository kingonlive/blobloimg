package com.yy.imagespider.data.imgurl;

import android.text.TextUtils;
import android.util.LruCache;

import java.util.ArrayList;
import java.util.List;

public class ImageUrlSourceLRU implements IImageUrlSource{
    /**
     * 所有图片url的缓存
     */
    private LruCache<Integer, String> mDatas;

    public ImageUrlSourceLRU() {
        mDatas = new LruCache<Integer, String>(MAX_IMGES);
    }

    private class GetImageUrlRequest implements OnUrlGetListener{
        OnUrlGetListener callback;
        int requestPos;
        int requestCount;

        public GetImageUrlRequest(OnUrlGetListener callback, int requestPos, int requestCount) {
            this.callback = callback;
            this.requestPos = requestPos;
            this.requestCount = requestCount;
        }

        @Override
        public void onGetUrl(List<String> urls) {

            //1.从网络返回的数据汇总到缓存
            int lastIndex = mDatas.size() - 1;
            for (int i = 0 ; i < urls.size() ; i++){
                mDatas.put(lastIndex + i + 1, urls.get(i));
            }

            //2.返回请求的剩余数据
            List<String> list = new ArrayList<String>();
            for (int i = requestPos ; i < requestCount ; i++){
                String url = mDatas.get(i);
                list.add(url);
            }
            callback.onGetUrl(urls);
        }
    }


    @Override
    public void getImageUrl(int position, int count, OnUrlGetListener listener) {
        String firstUrl = mDatas.get(position);
        String lastUrl = mDatas.get(position + count - 1);

        //第一个和最后一个url都存在，说明被请求的全部url都存在
        if (!TextUtils.isEmpty(firstUrl) && !TextUtils.isEmpty(lastUrl)) {
            List<String> list = new ArrayList<String>();
            for (int i = position ; i < count ; i++){
                list.add(mDatas.get(i));
            }
            listener.onGetUrl(list);
        } else {
            //缓存中的url不够
            ImgUrlUtil.getImagesUrl(new GetImageUrlRequest(listener, position, count));
        }

    }
}
