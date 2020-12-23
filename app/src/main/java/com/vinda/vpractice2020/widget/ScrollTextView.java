package com.vinda.vpractice2020.widget;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Rect;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.LinearInterpolator;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

/**
 * VPractice2020
 * <p>
 * Created by Vinda on 2020/12/23
 * Copyright © 2020年 BroadVideo. All rights reserved.
 * <p>
 * Describe:
 */
public class ScrollTextView extends LinearLayout {
    private String TAG = "ScrollTextView";
    private Context mContext;
    private SmartScrollTextViewParams smartScrollTextViewParams = new SmartScrollTextViewParams();
    private ObjectAnimator mObjectAnimator;
    private TextView contentShowTextView;
    private int contentShowTextViewWidth;
    private int mViewWidth =1920;

    public ScrollTextView(Context context) {
        super(context);
        mContext = context;
        init();
    }

    public ScrollTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        init();
    }

    public ScrollTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        init();
    }

    public ScrollTextView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        mContext = context;
        init();
    }

    /**
     * 初始化
     *
     * @param params
     */
    public void initialization(SmartScrollTextViewParams params) {
        smartScrollTextViewParams = params;
        setBackgroundColor(smartScrollTextViewParams.getBgColor());
        contentShowTextView = new TextView(mContext);
        contentShowTextView.setTextSize(smartScrollTextViewParams.getTextSize());
        contentShowTextView.setTextColor(smartScrollTextViewParams.getTextColor());
        contentShowTextView.setSingleLine(true);
        contentShowTextView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {

                Log.d(TAG, "textView.getWidth()" + contentShowTextView.getWidth());
            }
        });
        getTextViewWidth();
        Log.d(TAG, "contentShowTextViewWidth width " + contentShowTextViewWidth);
        ViewGroup.LayoutParams ps = new LayoutParams(contentShowTextViewWidth, ViewGroup.LayoutParams.WRAP_CONTENT);
        contentShowTextView.setLayoutParams(ps);
        contentShowTextView.setText(smartScrollTextViewParams.getContent());
        addView(contentShowTextView);
    }

    /**
     * 计算出显示当前文字，所需的TextView宽度是多少
     */
    private void getTextViewWidth() {
        Rect bounds = new Rect();
        TextPaint paint = contentShowTextView.getPaint();
        paint.getTextBounds(smartScrollTextViewParams.getContent(), 0, smartScrollTextViewParams.getContent().length(), bounds);
        contentShowTextViewWidth = bounds.width();
    }

    public void startScroll() {
        buildInterpolator(contentShowTextView).start();
    }

    public void stopScroll() {
        if (mObjectAnimator != null) {
            mObjectAnimator.cancel();
            mObjectAnimator = null;
        }
    }


    private void init() {
        mViewWidth = getWidth();
    }

    private ObjectAnimator buildInterpolator(TextView textView) {
        if (mObjectAnimator == null) {
            TimeInterpolator mTimeInterpolator;
            if (smartScrollTextViewParams.getScrollDirect() == SmartScrollTextViewParams.SCROLL_LEFT_TO_RIGHT) {
                mObjectAnimator = ObjectAnimator.ofFloat(textView, "translationX", -contentShowTextViewWidth, mViewWidth);
            } else {
                mObjectAnimator = ObjectAnimator.ofFloat(textView, "translationX", mViewWidth, -contentShowTextViewWidth);
            }

            mObjectAnimator.setDuration(resultSpeed());
            mObjectAnimator.setRepeatCount(-1);
            mTimeInterpolator = new LinearInterpolator();
            mObjectAnimator.setInterpolator(mTimeInterpolator);
            mObjectAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float value = (float) valueAnimator.getAnimatedValue();
                    //Log.d(TAG, "onAnimationUpdate " + value);
                }
            });
            mObjectAnimator.addListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animation) {
                    Log.d(TAG, "onAnimationStart ");
                }

                @Override
                public void onAnimationEnd(Animator animation) {
                    Log.d(TAG, "onAnimationEnd ");
                }

                @Override
                public void onAnimationCancel(Animator animation) {
                    Log.d(TAG, "onAnimationCancel ");
                }

                @Override
                public void onAnimationRepeat(Animator animation) {
                    Log.d(TAG, "onAnimationRepeat ");
                }
            });
        }
        return mObjectAnimator;
    }

    private long resultSpeed() {
        return (long) ((mViewWidth+contentShowTextViewWidth)/0.07);
    }
}
