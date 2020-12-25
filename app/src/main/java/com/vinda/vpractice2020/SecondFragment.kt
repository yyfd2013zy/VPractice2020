package com.vinda.vpractice2020

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.button_second).setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }


        val value = "10"
        var out: Int? = null
        //错误处理
        try {
            out = Integer.parseInt(value)
            return
        } catch (e: NumberFormatException) {
            println("NumberFormatException")
            println("NumberFormatException" + e.message)
            return
        } catch (e: Exception) {
            println("Exception")
            println("Exception"+e.message)
            return
        } finally {
            println("out is $out")
        }
    }
}