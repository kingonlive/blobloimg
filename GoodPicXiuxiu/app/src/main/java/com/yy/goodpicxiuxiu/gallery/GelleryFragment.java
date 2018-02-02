package com.yy.goodpicxiuxiu.gallery;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.yy.goodpicxiuxiu.R;
import com.yy.goodpicxiuxiu.gallery.view.GelleryAdapter;

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
        mGelleryAdapter.addDatas(list);
        mGelleryAdapter.notifyDataSetChanged();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
       View root = inflater.inflate(R.layout.gellery_main, container, false);
        mGridView = (RecyclerView) root.findViewById(R.id.recycleview);
        mGridView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
//                mPresenter.onScrollStateChanged(newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            }
        });

        mGelleryAdapter = new GelleryAdapter();
        mGridView.setAdapter(mGelleryAdapter);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getContext(), 2);
        mGridView.setLayoutManager(layoutManager);

        mPresenter.start();
        return root;
    }
}
