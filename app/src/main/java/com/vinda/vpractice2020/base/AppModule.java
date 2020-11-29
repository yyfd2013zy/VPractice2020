package com.vinda.vpractice2020.base;

import android.content.Context;
import android.content.SharedPreferences;

import dagger.Module;
import dagger.Provides;

/**
 * <p>文件描述：<p>
 * <p>作者：vinda <p>
 * <p>创建时间：2020/11/28<p>
 * <p>更改时间：2020/11/28<p>
 * <p>版本号：1<p>
 */
@Module
public class AppModule {
    private MyApplication myApplication;

    public AppModule(MyApplication myApplication) {
        this.myApplication = myApplication;
    }

    //提供全局的sp对象
    @Provides
    SharedPreferences provideSharedPreferences(){
        return myApplication.getSharedPreferences("spfile", Context.MODE_PRIVATE);
    }

    //提供全局的Application对象
    @Provides
    MyApplication provideApplication(){
        return myApplication;
    }
}
