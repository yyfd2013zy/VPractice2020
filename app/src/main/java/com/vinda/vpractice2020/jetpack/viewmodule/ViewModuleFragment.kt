package com.vinda.vpractice2020.jetpack.viewmodule

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.vinda.vpractice2020.R

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class ViewModuleFragment : Fragment(), View.OnClickListener {
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_data_view_module, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.button_second).setOnClickListener {
            findNavController().navigate(R.id.action_ViewModuleFragment_to_FirstFragment)
        }

    }

    override fun onClick(p0: View?) {

    }

}