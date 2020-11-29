package com.vinda.vpractice2020.annotate.myknife;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <p>文件描述：使用注解例子
 * @Target(ElementType.FIELD)//定义当前注解使用在方法上
 * @Retention(RetentionPolicy.SOURCE)//表示注解存在于源码中，编译成字节码的时候这个注解会被清除
 * @Retention(RetentionPolicy.CLASS)//表示这个注解存在于字节码中，不会被清除
 * <p>作者：vinda <p>
 * <p>创建时间：2020/11/29<p>
 * <p>更改时间：2020/11/29<p>
 * <p>版本号：1<p>
 */
@Retention(RetentionPolicy.RUNTIME)//表示这个注解存在于jvm中
@Target(ElementType.FIELD)//定义当前注解使用在变量上
public  @interface BindView {
    int age();
    String name();
}
