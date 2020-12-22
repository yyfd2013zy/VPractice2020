package com.vinda.vpractice2020.widget;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.animation.LinearInterpolator;

import androidx.annotation.NonNull;

/**
 * VPractice2020
 * <p>
 * Created by Vinda on 2020/12/22
 * Copyright © 2020年 BroadVideo. All rights reserved.
 * <p>
 * Describe:
 */
public class SmartScrollText extends SurfaceView implements SurfaceHolder.Callback {
    final String TAG = "SmartScrollText";

    private DrawThread mThread = null;

    public SmartScrollText(Context context) {
        super(context);
        init();
    }

    public SmartScrollText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public SmartScrollText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public SmartScrollText(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        Log.d(TAG, "init");
        SurfaceHolder holder = getHolder();
        holder.addCallback(this);
        mThread = new DrawThread(holder);

        ObjectAnimator mObjectAnimator;
        TimeInterpolator mTimeInterpolator;

        mObjectAnimator = ObjectAnimator.ofFloat(null,"",0,1900);
        mObjectAnimator.setDuration(10000);
        mTimeInterpolator = new LinearInterpolator();
        mObjectAnimator.setInterpolator(mTimeInterpolator);
        mObjectAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(){

            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                valueAnimator.getAnimatedValue();
                Log.d(TAG, "onAnimationUpdate-------------"+valueAnimator.getAnimatedValue());
                mThread.setTextX((Float) valueAnimator.getAnimatedValue());
            }
        });
        mObjectAnimator.start();

    }

    @Override
    public void surfaceCreated(@NonNull SurfaceHolder surfaceHolder) {
        Log.d(TAG, "surfaceCreated");
        mThread.setRun(true);
        mThread.start();
    }

    @Override
    public void surfaceChanged(@NonNull SurfaceHolder surfaceHolder, int i, int i1, int i2) {
        Log.d(TAG, "surfaceChanged");
    }

    @Override
    public void surfaceDestroyed(@NonNull SurfaceHolder surfaceHolder) {
        Log.d(TAG, "surfaceDestroyed");
        mThread.setRun(false);
    }


    /**
     * 绘制线程
     */
    public class DrawThread extends Thread {
        private SurfaceHolder mHolder = null;
        private boolean isRun = false;
        private float textX = 0;

        public void setTextX(float textX) {
            this.textX = textX;
        }

        private Paint paintText = new Paint();

        public DrawThread(SurfaceHolder holder) {
            Log.d(TAG, "DrawThread Constructor");
            mHolder = holder;

        }

        public void setRun(boolean isRun) {
            Log.d(TAG, "DrawThread setRun: " + isRun);
            this.isRun = isRun;
        }

        @Override
        public void run() {
            Log.d(TAG, "DrawThread run");
            paintText.setColor(Color.BLACK);
            paintText.setTextSize(20);
            while (isRun) {
                Canvas canvas = null;
                synchronized (mHolder) {
                    try {
                        //Log.d(TAG, "Drawing-------------");
                        canvas = mHolder.lockCanvas();
                        canvas.drawColor(Color.WHITE);
                        Paint p = new Paint();
                        p.setColor(Color.RED);

                        Rect r = new Rect(100, 50, 300, 250);
                        canvas.drawRect(r, p);
                        canvas.drawText("Hello Word!", textX, 310, paintText);

                        //Thread.sleep(12);// 1s绘制16次

                    } catch (Exception e) {
                        Log.d(TAG, "throw Exception in run");
                        e.printStackTrace();
                    } finally {
                        if (null != canvas) {
                            mHolder.unlockCanvasAndPost(canvas);
                        }
                    }

                }

            }
        }

    }
}
