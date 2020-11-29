package com.vinda.vpractice2020.annotate.myknife;

import com.vinda.vpractice2020.annotate.Student;

import java.lang.reflect.Field;

/**
 * <p>文件描述：通过注解方式像特定类中进行值的注入
 * <p>作者：vinda <p>
 * <p>创建时间：2020/11/29<p>
 * <p>更改时间：2020/11/29<p>
 * <p>版本号：1<p>
 */
public class MyButterKnife {

    /**
     * 实现类
     *
     * @param student
     * @throws Exception
     */
    public static void bind(Student student) throws Exception {
        //获取字节码文件
        Class clazz = student.getClass();
        //通过反射方式获取私有变量
        Field fieldName = clazz.getDeclaredField("name");
        Field fieldAge = clazz.getDeclaredField("age");
        //设置可以写入
        fieldName.setAccessible(true);
        fieldAge.setAccessible(true);
        //通过反射获取注解
        BindView annotate = fieldName.getAnnotation(BindView.class);
        if (annotate != null) {
            //获取注解值
            String name = annotate.name();
            int age = annotate.age();
            //成员变量赋值，相当于传递了一下
            fieldName.set(student, name);
            fieldAge.set(student, age);
        } else {
            System.out.println("get annotate failed! annotate is null!!");
        }
    }
}
