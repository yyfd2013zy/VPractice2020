package com.vinda.vpractice2020

import android.app.Activity
import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.text.InputType
import android.text.TextUtils
import android.util.DisplayMetrics
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.input.input
import com.afollestad.materialdialogs.lifecycle.lifecycleOwner
import com.afollestad.materialdialogs.list.listItems
import com.vinda.vpractice2020.util.ImageCompresstest

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ImageCompresstest(this).comPressImage()
        val display = window.windowManager.defaultDisplay
        val displayMetrics = DisplayMetrics()
        display.getMetrics(displayMetrics)

        val width = displayMetrics.widthPixels//宽度
        val height = displayMetrics.heightPixels//高度
        val density = displayMetrics.density//密度
        val densityDpi = displayMetrics.densityDpi //每英寸点数(打印分辨率)
        val xdpi = displayMetrics.xdpi//x轴物理密度
        val ydpi = displayMetrics.ydpi//y轴物理密度

        windowManager.defaultDisplay.getRealMetrics(displayMetrics)
        val width1 = displayMetrics.widthPixels//实际宽度（含状态栏）
        val height1 = displayMetrics.heightPixels//实际高度（含状态栏）
        findViewById<TextView>(R.id.tv_screen_info).text = "宽度  = " + width + "\n"+ "高度 = " + height + "\n"+ "密度 = " + density + "\n" +
                "x轴物理密度 = " + xdpi + "\n" +
                "y轴物理密度 = " + ydpi + "\n" +
                "实际宽度（含状态栏） = " + width1 + "\n"+
                "实际高度 含状态栏= "+height1+ "\n"+
                "densityDpi = "+densityDpi
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        //menuInflater.inflate(R.menu.menu_main, menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }


    fun SHowDialog(view: View) {
//        var array = arrayListOf<String>()
//        array.add("1")
//        array.add("2")
//        MaterialDialog(this).show {
//            listItems(items = array) { _, index, text ->
//                Toast.makeText(this@MainActivity,"Selected item $text at index $index",Toast.LENGTH_SHORT).show()
//            }
//            debugMode(false)
//            title = "切换设备"
//            title(text = "切换设备1")
//
//        }
        MaterialDialog(this).show {
            title(text = "改名")
            input(
                inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_FLAG_CAP_WORDS
            ) { _, text ->


            }
            positiveButton(text = "ok") { dialog ->


            }
            negativeButton(text = "cancle")
            message(text = "输入名字")

        }

//        var progressDialog = ProgressDialog(this)
//        progressDialog.setTitle("This is ProgressDialog")
//        progressDialog.setMessage("Loading...")
//        progressDialog.setCancelable(true)
//        progressDialog.show()

      /*  MaterialDialog(this).show {
            title(text = "aklfn")
            message(text = "aklfn")
            positiveButton(text = "ok"){ dialog ->
                // Pull the password out of the custom view when the positive button is pressed
                Toast.makeText(this@MainActivity,"111",Toast.LENGTH_SHORT).show()
            }
            negativeButton(text = "cancle")

        }*/
    }

    fun showi(){
        val items =
            arrayOf("多选1", "多选2", "多选3", "多选4", "多选5", "多选6")
        //默认都未选中

        //默认都未选中
        val isSelect = booleanArrayOf(false, false, false, false, false, false)
        var buider = AlertDialog.Builder(this)
            .setSingleChoiceItems(items,0,object :DialogInterface.OnClickListener{
                override fun onClick(p0: DialogInterface?, p1: Int) {

                }

            }).create().show()
    }

}