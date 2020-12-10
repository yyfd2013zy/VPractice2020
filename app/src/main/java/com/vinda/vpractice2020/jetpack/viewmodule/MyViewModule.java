package com.vinda.vpractice2020.jetpack.viewmodule;

import android.util.Log;

import androidx.lifecycle.ViewModel;

/**
 * VPractice2020
 * <p>
 * Created by Vinda on 2020/12/5
 * Copyright © 2020年 BroadVideo. All rights reserved.
 * <p>
 * Describe:
 */
public class MyViewModule extends ViewModel {

    @Override
    protected void onCleared() {
        super.onCleared();
        Log.d("MyViewModule","onCleared");
    }
}
