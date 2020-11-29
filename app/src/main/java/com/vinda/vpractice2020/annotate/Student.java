package com.vinda.vpractice2020.annotate;

import com.vinda.vpractice2020.annotate.myknife.BindView;

/**
 * <p>文件描述：使用注解BindView例子,在这里使用了BindView注解，通过注解赋值
 * <p>作者：vinda <p>
 * <p>创建时间：2020/11/29<p>
 * <p>更改时间：2020/11/29<p>
 * <p>版本号：1<p>
 */
public class Student {

    @BindView(name= "张三",age = 20)
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private void study(){

    }

    @Override
    public String toString(){
        return "name:"+name+" age:"+age;
    }
}
