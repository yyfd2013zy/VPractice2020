package com.vinda.vpractice2020.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.util.Log;

import com.vinda.vpractice2020.R;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * VPractice2020
 * <p>
 * Created by Vinda on 2021/1/7
 * Copyright © 2021年 BroadVideo. All rights reserved.
 * <p>
 * Describe:
 */
public class ImageCompresstest {
    private Context context;

    public ImageCompresstest(Context context) {
        this.context = context;
    }

    public void comPressImage(){
        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.flower);// 将图片读取到bitmap中
        String aa = bitmapToBase64(bitmap,10);
        Log.d("ImageCompresstest",aa.length()+"");
    }

    /**
     * bitmap转为base64
     *
     * @param bitmap
     * @return
     */
    public static String bitmapToBase64(Bitmap bitmap,int compress) {
        if (bitmap == null) {
            return "";
        }
        String result = null;
        ByteArrayOutputStream baos = null;
        try {
            if (bitmap != null) {
                baos = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG, compress, baos);

                baos.flush();
                baos.close();

                byte[] bitmapBytes = baos.toByteArray();
                result = Base64.encodeToString(bitmapBytes, Base64.DEFAULT);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (baos != null) {
                    baos.flush();
                    baos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}
