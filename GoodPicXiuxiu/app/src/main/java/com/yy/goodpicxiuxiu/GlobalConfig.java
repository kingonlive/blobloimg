package com.yy.goodpicxiuxiu;


import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Window;

public class GlobalConfig {
    private GlobalConfig() {
    }

    private static class Holder{
        public static final GlobalConfig sINSCTANCE = new GlobalConfig();
    }

    private Context mContext;

    private int mWindowHeight;
    private int mWindowWidth;

    public static GlobalConfig getInstance(){
        return Holder.sINSCTANCE;
    }

    public Context getContext() {
        return mContext;
    }

    public void setContext(Context mContext) {
        this.mContext = mContext;
    }

    public int getWindowHeight() {
        return mWindowHeight;
    }

    public int getWindowWidth() {
        return mWindowWidth;
    }

    public void calculateWindowSize(Window window){
        if (mWindowWidth == 0 || mWindowHeight == 0){
            DisplayMetrics displayMetrics = new DisplayMetrics();
            window.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            mWindowWidth = displayMetrics.widthPixels;
            mWindowHeight = displayMetrics.heightPixels;
        }
    }

    /**
     * 需求:
     * 一.浏览
     * 1.点击某一个网格，出现一个下沉再放大的效果
     * 2.第一步操作完厚弹出图片浏览视图
     *
     * 二．分类
     * 1.增加能够分类功能[大小类]
     * 例如大类 明星 植物 动物　鱼类
     * 例如小类　刘德华　周星驰 ...
     */
}
