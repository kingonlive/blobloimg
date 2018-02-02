package com.yy.goodpicxiuxiu.data.imgurl;

import android.text.TextUtils;
import android.util.LruCache;

import com.yy.goodpicxiuxiu.util.Log;

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

    private class GetImageUrlRequest implements IGetURLListener {
        IGetURLListener callback;
        int requestPos;
        int requestCount;

        public GetImageUrlRequest(IGetURLListener callback, int requestPos, int requestCount) {
            this.callback = callback;
            this.requestPos = requestPos;
            this.requestCount = requestCount;
        }

        private void logIfNeeded(List<String> urls){
            Log.d(ImgUrlUtil.TAG, "onGetUrl>>>>>>>>>>>>>>>>>>>>>>");
            for (String url: urls){
                Log.d(ImgUrlUtil.TAG, url);
            }
            Log.d(ImgUrlUtil.TAG, "onGetUrl<<<<<<<<<<<<<<<<<<<");
            Log.d(ImgUrlUtil.TAG, "mDatas.size:" + mDatas.size());
        }

        @Override
        public void onGetUrl(List<String> urls) {

            logIfNeeded(urls);

            //1.从网络返回的数据汇总到缓存
            int lastIndex = mDatas.size() - 1;
            for (int i = 0 ; i < urls.size() ; i++){
                mDatas.put(lastIndex + i + 1, urls.get(i));
            }

            //2.判断当前已有的数据中是否存在从requestPos开始的requestCount个
            //mDatas 至少要有(requestPos + requestCount)个
            if (requestPos + requestCount > mDatas.size()){
                //接着去网络取
                ImgUrlUtil.getImagesUrl(this);
                return;
            }

            //2.返回请求的剩余数据
            List<String> list = new ArrayList<String>();
            for (int i = requestPos ; i < requestCount + requestPos ; i++){
                String url = mDatas.get(i);
                list.add(url);
            }
            callback.onGetUrl(list);
        }
    }


    @Override
    public void getImageUrl(int position, int count, IGetURLListener listener) {
        String firstUrl = mDatas.get(position);
        String lastUrl = mDatas.get(position + count - 1);

        //第一个和最后一个url都存在，说明被请求的全部url都存在
        if (!TextUtils.isEmpty(firstUrl) && !TextUtils.isEmpty(lastUrl)) {
            List<String> list = new ArrayList<String>();
            for (int i = position ; i < count + position ; i++){
                list.add(mDatas.get(i));
            }
            listener.onGetUrl(list);
        } else {
            //缓存中的url不够
            ImgUrlUtil.getImagesUrl(new GetImageUrlRequest(listener, position, count));
        }

    }
}
