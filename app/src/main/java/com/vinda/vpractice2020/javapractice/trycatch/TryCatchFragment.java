package com.vinda.vpractice2020.javapractice.trycatch;

import android.os.Bundle;

import androidx.preference.PreferenceFragmentCompat;

import com.vinda.vpractice2020.R;

import static java.sql.DriverManager.println;

/**
 * # Try Catch
 *
 * ## Kotlin
 *
 * ```
 *  val value = "10"
 *  var out: Int? = null
 *  try {
 *             out = Integer.parseInt(value)
 *             return
 *         } catch (e: NumberFormatException) {
 *             println("NumberFormatException")
 *             println(e.message)
 *             return
 *         } catch (e: Exception) {
 *             println("Exception")
 *             println(e.message)
 *             return
 *         } finally {
 *             println("out is $out")
 *         }
 * ```
 *
 * 即使returen了，catch以及finally还是会执行，但是只会捕获一个catch，捕获一个之后，后买你的catch便不再捕获了。
 *
 * 没有错误，即便在try中执行了return，finally还是会执行。
 *
 * ## Java
 *
 * catch 排列顺序应该是从特殊到一般
 *
 * 实际测试结果和kotlin相同
 */
public class TryCatchFragment extends PreferenceFragmentCompat {

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey);
        String value = "10";
        int out  = -1;
        try {
            out = Integer.parseInt(value);
            return;
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException");
            System.out.println("NumberFormatException"+e.getMessage());
            return;
        } catch (Exception e) {
            System.out.println("Exception");
            System.out.println("Exception"+e.getMessage());
            return;
        } finally {
            System.out.println("out is "+out);
        }

    }
}