package com.yy.goodpicxiuxiu.data.imgurl;

/**
 * 获取图片ＵＲＬ的接口
 */

public interface IImageUrlSource {
    /**
     * 最大图片数
     */
    int MAX_IMGES = 20480;

    /**
     *
     * 返回指定位置的图片url,制定的位置是一段区间
     * @param position 返回图片的起始位置
     * @param count 返回图片的总数
     * @param listener 接受请求结果的接口
     */
    void getImageUrl(int position, int count, IGetURLListener listener);
}
