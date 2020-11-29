package com.vinda.vpractice2020.base;

import com.vinda.vpractice2020.componet.AppComponent;

/**
 * <p>文件描述：<p>
 * <p>作者：vinda <p>
 * <p>创建时间：2020/11/28<p>
 * <p>更改时间：2020/11/28<p>
 * <p>版本号：1<p>
 */
public class ComponentHolder {

    private static AppComponent myAppComponent;

    public static void setAppComponent(AppComponent component) {
        myAppComponent = component;
    }

    public static AppComponent getAppComponent() {
        return myAppComponent;
    }
}
