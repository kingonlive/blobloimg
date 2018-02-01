package com.yy.imagespider.gallery.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.yy.imagespider.util.GlobalConfig;

import java.util.ArrayList;
import java.util.List;


public class GelleryAdapter extends RecyclerView.Adapter {
    private List<String> mDatas = new ArrayList<String>();

    private class ViewHolder extends RecyclerView.ViewHolder{
        ImageView view;
        ViewHolder(View itemView) {
            super(itemView);
            view = (ImageView) itemView;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewHolder viewHolder = new ViewHolder(new ImageView(parent.getContext()));
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        String imgUrl = mDatas.get(position);
        Picasso.with(GlobalConfig.getInstance().getContext()).load(imgUrl).into((ImageView) holder.itemView);
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    public void addDatas(List<String> list){
        mDatas.addAll(list);
    }
}
