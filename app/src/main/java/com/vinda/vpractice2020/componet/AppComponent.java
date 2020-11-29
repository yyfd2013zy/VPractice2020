package com.vinda.vpractice2020.componet;

import android.content.SharedPreferences;

import com.vinda.vpractice2020.base.AppModule;
import com.vinda.vpractice2020.base.MyApplication;

import dagger.Component;

/**
 * <p>文件描述：<p>
 * <p>作者：vinda <p>
 * <p>创建时间：2020/11/28<p>
 * <p>更改时间：2020/11/28<p>
 * <p>版本号：1<p>
 */
@Component(modules = AppModule.class)
public interface AppComponent {
    SharedPreferences sharedPreferences();

    MyApplication myApplication();
}
