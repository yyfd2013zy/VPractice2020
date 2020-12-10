package com.vinda.vpractice2020.jetpack.viewmodule

import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.vinda.vpractice2020.R
import com.vinda.vpractice2020.base.MyBaseActivity

/**
 *  VPractice2020
 *
 *  Created by Vinda on 2020/12/5
 *  Copyright © 2020年 BroadVideo. All rights reserved.
 *
 *  Describe:
 */
public class ViewModuleActivity :MyBaseActivity(){
    val TAG = "ViewModuleActivity"
    private lateinit var myViewModel: MyViewModule
    override fun onCreate() {
        setView(R.layout.fragment_data_view_module)
       var myViewModel = ViewModelProvider(this)[MyViewModule::class.java] // 关键代码
        Log.e(TAG,"onCreate ${myViewModel.hashCode()}")
    }

    override fun onResume() {
        super.onResume()
        var myViewModel = ViewModelProvider(this)[MyViewModule::class.java] // 关键代码
        Log.e(TAG,"onResume ${myViewModel.hashCode()}")
    }

    override fun onPause() {
        super.onPause()
        var myViewModel = ViewModelProvider(this)[MyViewModule::class.java] // 关键代码
        Log.e(TAG,"onPause ${myViewModel.hashCode()}")
    }

    override fun onDestroy() {
        super.onDestroy()
        var myViewModel = ViewModelProvider(this)[MyViewModule::class.java] // 关键代码
        Log.e(TAG,"onDestroy ${myViewModel.hashCode()}")
    }

}