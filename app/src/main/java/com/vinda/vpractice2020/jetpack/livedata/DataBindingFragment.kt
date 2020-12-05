package com.vinda.vpractice2020.jetpack.livedata

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.vinda.vpractice2020.R
import com.vinda.vpractice2020.databinding.FragmentDataBindingBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class DataBindingFragment : Fragment(), View.OnClickListener {
    var dataBindingBinding:FragmentDataBindingBinding ?=null
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        dataBindingBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_data_binding, container, false)
        dataBindingBinding?.textStr = "这个是设置进去的数据"
        return dataBindingBinding?.root

        //return inflater.inflate(R.layout.fragment_data_binding, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.button_second).setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }
    }

    override fun onClick(p0: View?) {

    }

}