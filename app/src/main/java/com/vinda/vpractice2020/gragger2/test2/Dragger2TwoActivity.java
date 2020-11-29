package com.vinda.vpractice2020.gragger2.test2;

import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.vinda.vpractice2020.R;
import com.vinda.vpractice2020.base.ComponentHolder;
import com.vinda.vpractice2020.base.MyBaseActivity;
import com.vinda.vpractice2020.gragger2.Student;

import javax.inject.Inject;

/**
 * Dragger2 :
 * Android 神兵利器Dagger2使用详解（一）Module&Component源码分析
 * https://blog.csdn.net/mq2553299/article/details/73065745
 * Android 神兵利器Dagger2使用详解（二）Module&Component源码分析
 * https://blog.csdn.net/mq2553299/article/details/73136396
 */
public class Dragger2TwoActivity extends MyBaseActivity {

    @Inject
    Student2 student2;
    @Inject
    SharedPreferences sp;

    @Override
    public void onCreate() {
        setView(R.layout.activity_dragger3);

        findViewById(R.id.btn_showinfo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        inject();
    }

    private void inject() {
        DaggerA02Component.builder()
                .appComponent(ComponentHolder.getAppComponent())//添加appComponent注入器
                .a02Module(new A02Module(this))
                .build()
                .inject(this);

        Log.i("tag", "注入完毕，Student = " + student2.toString());
        Log.i("tag", "注入完毕，sp = " + sp.toString());}
}
