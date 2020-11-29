package com.vinda.vpractice2020.gragger2.test2;

import com.vinda.vpractice2020.componet.AppComponent;

import dagger.Component;

/**
 * <p>文件描述：说明如何在Activity中使用通过依赖注入当时创建的全局变量
 *
 * 比如说我们需要Student对象和SharedPerferences对象，前者是A02Component提供的
 * ，后者则需要「依赖（dependencies）」AppComponent提供，等于这次inject(A02Activity activity)
 * 依赖注入需要两个Component共同出力完成。
 * <p>作者：vinda <p>
 * <p>创建时间：2020/11/28<p>
 * <p>更改时间：2020/11/28<p>
 * <p>版本号：1<p>
 */
@Component(modules = A02Module.class, dependencies = AppComponent.class)
public interface A02Component {
    void inject(Dragger2TwoActivity activity);
}
