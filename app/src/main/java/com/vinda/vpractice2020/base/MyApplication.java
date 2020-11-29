package com.vinda.vpractice2020.base;

import android.app.Application;

import com.vinda.vpractice2020.componet.AppComponent;
import com.vinda.vpractice2020.componet.DaggerAppComponent;

/**
 * <p>文件描述：<p>
 * <p>作者：vinda <p>
 * <p>创建时间：2020/11/28<p>
 * <p>更改时间：2020/11/28<p>
 * <p>版本号：1<p>
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        inject();
    }

    private void inject() {
        AppComponent appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
        ComponentHolder.setAppComponent(appComponent);
    }
}
