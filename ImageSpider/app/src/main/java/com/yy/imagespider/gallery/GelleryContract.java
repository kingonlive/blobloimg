package com.yy.imagespider.gallery;

import com.yy.imagespider.BasePresenter;
import com.yy.imagespider.BaseView;

/**
 * Created by chenyanyin on 18/1/30.
 */

public class GelleryContract {

    interface Presenter extends BasePresenter{

    }

    interface View extends BaseView<Presenter>{
        void setDatas();

    }

}
