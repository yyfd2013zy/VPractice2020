package com.vinda.vpractice2020.widget;

import android.graphics.Color;
import android.text.TextUtils;

/**
 * VPractice2020
 * <p>
 * Created by Vinda on 2020/12/23
 * Copyright © 2020年 BroadVideo. All rights reserved.
 * <p>
 * Describe:
 */
public class SmartScrollTextViewParams {
    public static final int SCROLL_RIGHT_TO_LEFT = 0x01;
    public static final int SCROLL_LEFT_TO_RIGHT = 0x02;

    private String content;
    private int textSize ;
    private int textColor = Color.BLACK;
    private int bgColor = Color.TRANSPARENT;
    private int speed;
    private int scrollDirect = SCROLL_RIGHT_TO_LEFT;


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
        covertString();
    }

    public int getScrollDirect() {
        return scrollDirect;
    }

    public void setScrollDirect(int scrollDirect) {
        this.scrollDirect = scrollDirect;
        covertString();
    }

    private void covertString() {
        if (scrollDirect == SCROLL_LEFT_TO_RIGHT && !TextUtils.isEmpty(content)) {
            StringBuffer sb = new StringBuffer();
            for (int i = content.length() - 1; i >= 0; i--) {
                sb.append(content.charAt(i));
            }
            this.content = sb.toString();
        }
    }

    public int getTextSize() {
        return textSize;
    }

    public void setTextSize(int textSize) {
        this.textSize = textSize;
    }


    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getTextColor() {
        return textColor;
    }

    public void setTextColor(int textColor) {
        this.textColor = textColor;
    }

    public int getBgColor() {
        return bgColor;
    }

    public void setBgColor(int bgColor) {
        this.bgColor = bgColor;
    }
}
