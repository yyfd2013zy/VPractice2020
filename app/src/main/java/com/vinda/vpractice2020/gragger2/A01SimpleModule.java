package com.vinda.vpractice2020.gragger2;

import javax.inject.Inject;

import dagger.Module;

/**
 * <p>文件描述：Module类上方的@Module注解意味着这是一个提供数据的【模块】
 * <p>作者：vinda <p>
 * <p>创建时间：2020/11/28<p>
 * <p>更改时间：2020/11/28<p>
 * <p>版本号：1<p>
 */
@Module
public class A01SimpleModule {

    private Dragger2Activity dragger2Activity;

    public A01SimpleModule(Dragger2Activity dragger2Activity) {
        this.dragger2Activity = dragger2Activity;
    }
}
