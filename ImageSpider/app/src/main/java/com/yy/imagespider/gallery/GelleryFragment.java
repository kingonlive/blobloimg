package com.yy.imagespider.gallery;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yy.imagespider.R;
import com.yy.imagespider.data.Image;
import com.yy.imagespider.data.imgurl.ImageUrlFetcher;
import com.yy.imagespider.gallery.view.GelleryAdapter;

import java.util.List;

public class GelleryFragment extends Fragment implements GelleryContract.View {

    private RecyclerView mGridView;
    private GelleryAdapter mGelleryAdapter;
    private GelleryContract.Presenter mPresenter;

    @Override
    public void setPresenter(GelleryContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void addDatas(List<String> list) {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
       View root = inflater.inflate(R.layout.gellery_main, container, false);
        mGridView = (RecyclerView) root.findViewById(R.id.recycleview);
        mGridView.setOnScrollChangeListener();
        mGridView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                mPresenter.onScrollStateChanged(newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            }
        });
        mGelleryAdapter = new GelleryAdapter();
        mGridView.setAdapter(mGelleryAdapter);
        return root;
    }
}
