package com.vinda.vpractice2020.gragger2;

import android.content.SharedPreferences;
import android.view.View;
import android.widget.Toast;

import com.vinda.vpractice2020.base.MyBaseActivity;
import com.vinda.vpractice2020.R;

import javax.inject.Inject;

/**
 * Dragger2 :
 * Android 神兵利器Dagger2使用详解（一）Module&Component源码分析
 * https://blog.csdn.net/mq2553299/article/details/73065745
 * Android 神兵利器Dagger2使用详解（二）Module&Component源码分析
 * https://blog.csdn.net/mq2553299/article/details/73136396
 */
public class Dragger2Activity extends MyBaseActivity {

    @Inject
    Student student;



    @Override
    public void onCreate() {
        setView(R.layout.activity_dragger2);
        DaggerA01SimpleComponent.builder()
                .a01SimpleModule(new A01SimpleModule(this))
                .build()
                .inject(this);
        findViewById(R.id.btn_showinfo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Dragger2Activity.this, student.toString(), Toast.LENGTH_SHORT).show();

            }
        });
    }
}
