package com.vinda.vpractice2020.gragger2;

import dagger.Component;

/**
 * <p>文件描述：Component接口上方的@Component(modules = A01SimpleModule.class)
 * 说明这是一个【组件】（我更喜欢称呼它为注射器）
 * <p>作者：vinda <p>
 * <p>创建时间：2020/11/28<p>
 * <p>更改时间：2020/11/28<p>
 * <p>版本号：1<p>
 */
@Component(modules = A01SimpleModule.class)
public interface A01SimpleComponent {
    void inject(Dragger2Activity activity);
}
