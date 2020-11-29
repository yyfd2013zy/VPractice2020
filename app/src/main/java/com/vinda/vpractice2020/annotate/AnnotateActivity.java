package com.vinda.vpractice2020.annotate;
import com.vinda.vpractice2020.R;
import com.vinda.vpractice2020.annotate.myknife.MyButterKnife;
import com.vinda.vpractice2020.base.MyBaseActivity;

/**
 * 注解 :
 */
public class AnnotateActivity extends MyBaseActivity {

    @Override
    public void onCreate() {
        setView(R.layout.activity_dragger3);
        Student student = new Student();
        try {
            MyButterKnife.bind(student);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(student);

    }
}
