package com.yy.goodpicxiuxiu.widget;

import android.content.Context;
import android.support.v7.widget.AppCompatImageView;
import android.view.MotionEvent;

import com.yy.goodpicxiuxiu.util.Log;

/**
 * 加按压特效的ImageView
 */

public class PressiveImageView extends AppCompatImageView {
    private static final String TAG = "PressiveImageView";

    /** 按下时的缩放比 **/
    public static final float PRESSED_SCALE = 0.9f;

    /** 松手时的缩放比 **/
    public static final float RELEASED_SCALE = 1f;

    /** 按下之后开始缩放的最小时间(ms) **/
    public static final long TIME_TO_SCALE_BETWWEN_MOVEMENT = 100;

    /** 正在执行按压动画 **/
    private boolean mDoingPressedScale = false;

    /** 按下事件的屏幕横坐标 **/
    private float mDownEventRawX;

    /** 按下事件的屏幕纵坐标 **/
    private float mDownEventRawY;

    public PressiveImageView(Context context) {
        super(context);
    }

    private void checkPressedScale(MotionEvent eventMove){
        //时间上防抖，按压到动画的时间间隔
        long movingTime = eventMove.getEventTime() - eventMove.getDownTime();

        if (movingTime < TIME_TO_SCALE_BETWWEN_MOVEMENT && !mDoingPressedScale){
            mDoingPressedScale = true;
            Log.d(TAG, "fire scale!!");
            animate().scaleY(PRESSED_SCALE).scaleX(PRESSED_SCALE);
        }
    }

    private void checkReleaseScale(MotionEvent event){
        //直接复原
        animate().scaleY(RELEASED_SCALE).scaleX(RELEASED_SCALE);
    }


    private void resetPressState(MotionEvent downEvent){
        mDownEventRawX = downEvent.getRawX();
        mDownEventRawY = downEvent.getRawY();
        mDoingPressedScale = false;
        Log.d(TAG, "reset scale state");
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                resetPressState(event);
                return true;
            case MotionEvent.ACTION_MOVE:
                checkPressedScale(event);
                break;
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:
                checkReleaseScale(event);
                break;
        }
        return super.onTouchEvent(event);
    }

    @Override
    public boolean callOnClick() {
        Log.d(TAG, "callOnClick");
        return super.callOnClick();
    }
}
