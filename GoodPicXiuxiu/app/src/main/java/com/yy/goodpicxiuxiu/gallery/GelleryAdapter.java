package com.yy.goodpicxiuxiu.gallery;

import android.app.Activity;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.yy.goodpicxiuxiu.GlobalConfig;
import com.yy.goodpicxiuxiu.widget.PressiveImageView;

import java.util.ArrayList;
import java.util.List;


public class GelleryAdapter extends RecyclerView.Adapter {
    private List<String> mDatas = new ArrayList<String>();

    private class ViewHolder extends RecyclerView.ViewHolder{
        PressiveImageView view;
        ViewHolder(View itemView) {
            super(itemView);
            view = (PressiveImageView) itemView;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewHolder viewHolder = new ViewHolder(new PressiveImageView(parent.getContext()));
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int width = GlobalConfig.getInstance().getWindowWidth();
        String imgUrl = mDatas.get(position);
        holder.itemView.setBackgroundColor(Color.BLUE);

        ((ImageView) holder.itemView).setLayoutParams(new ViewGroup.LayoutParams(width/2, width/2));
        Picasso.with(GlobalConfig.getInstance().getContext()).load(imgUrl).resize(width/2,width/2).centerCrop().into((ImageView) holder.itemView);
//        Picasso.with(GlobalConfig.getInstance().getContext()).load(imgUrl).resize(width/2,width/2).centerInside().into((ImageView) holder.itemView);
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    public void addDatas(List<String> list){
        mDatas.addAll(list);
    }

}
