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
import com.yy.goodpicxiuxiu.util.Log;

import java.util.List;

public class GridFragment extends Fragment implements GridContract.View {
    public static final String TAG = "GridFragment";
    /** 网格视图的列数 **/
    public static final int COLUMN_NUM = 2;

    private RecyclerView mGridView;
    private GelleryAdapter mGelleryAdapter;
    private GridContract.Presenter mPresenter;
    private GridLayoutManager mLayoutManager;
    @Override
    public void setPresenter(GridContract.Presenter presenter) {
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
                int lastVisibleItemPosition = mLayoutManager.findLastVisibleItemPosition();
                Log.d(TAG, "onScrollStateChanged newState:" + newState + ",lastVisibleItemPosition:" + lastVisibleItemPosition);

                mPresenter.onScrollStateChanged(newState, mLayoutManager.findLastVisibleItemPosition());
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            }
        });

        mGelleryAdapter = new GelleryAdapter();
        mGridView.setAdapter(mGelleryAdapter);
        mLayoutManager = new GridLayoutManager(getContext(), COLUMN_NUM);
        mGridView.setLayoutManager(mLayoutManager);
        return root;
    }
}
