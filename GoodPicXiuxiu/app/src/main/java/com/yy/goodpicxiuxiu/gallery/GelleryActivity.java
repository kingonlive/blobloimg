package com.yy.goodpicxiuxiu.gallery;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.yy.goodpicxiuxiu.GlobalConfig;
import com.yy.goodpicxiuxiu.R;


public class GelleryActivity extends AppCompatActivity {

    private GelleryContract.Presenter mPresenter;
    private GelleryContract.View mView;

    private void initUI(){
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        GelleryFragment gelleryFragment = (GelleryFragment) getSupportFragmentManager().findFragmentById(R.id.contentframe);

        if (gelleryFragment == null) {
            // Create the fragment
            gelleryFragment = new GelleryFragment();

            //Add the fragment
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.add(R.id.contentframe, gelleryFragment);
            fragmentTransaction.commit();
        }

        mView = gelleryFragment;
        mPresenter = new GelleryPresenter(gelleryFragment);
        mView.setPresenter(mPresenter);
        mPresenter.start();
    }

    private void initEnv(){
        GlobalConfig.getInstance().setContext(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initEnv();
        initUI();
    }

}
