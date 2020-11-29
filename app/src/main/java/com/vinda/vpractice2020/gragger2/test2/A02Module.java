package com.vinda.vpractice2020.gragger2.test2;

import com.vinda.vpractice2020.gragger2.Student;

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
public class A02Module {
    private Dragger2TwoActivity dragger2TwoActivity;

    public A02Module(Dragger2TwoActivity dragger2TwoActivity) {
        this.dragger2TwoActivity = dragger2TwoActivity;
    }

    //显然我们并不是很多地方都需要某对象，我们在需要用该对象的界面的Module中提供注入即可
    @Provides
    Student2 provideStudent() {
        return new Student2();
    }
}
