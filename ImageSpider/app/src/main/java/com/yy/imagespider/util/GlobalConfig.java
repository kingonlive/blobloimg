package com.yy.imagespider.util;


import android.content.Context;

public class GlobalConfig {
    private Context mContext;

    private static class Holder{
        private static final GlobalConfig sINSTANCE = new GlobalConfig();
    }

    private GlobalConfig() {
    }


    public Context getContext() {
        return mContext;
    }

    public void setContext(Context mContext) {
        this.mContext = mContext;
    }

    public static GlobalConfig getInstance(){
        return Holder.sINSTANCE;
    }
}
