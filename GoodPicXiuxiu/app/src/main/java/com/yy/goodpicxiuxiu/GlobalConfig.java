package com.yy.goodpicxiuxiu;


import android.content.Context;

public class GlobalConfig {
    private GlobalConfig() {
    }

    private static class Holder{
        public static final GlobalConfig sINSCTANCE = new GlobalConfig();
    }

    private Context mContext;

    public static GlobalConfig getInstance(){
        return Holder.sINSCTANCE;
    }

    public Context getContext() {
        return mContext;
    }

    public void setContext(Context mContext) {
        this.mContext = mContext;
    }
}
