package com.vinda.vpractice2020.web;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.os.Bundle;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.tencent.smtt.export.external.extension.interfaces.IX5WebChromeClientExtension;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewExtension;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase;
import com.tencent.smtt.export.external.interfaces.JsResult;
import com.tencent.smtt.export.external.interfaces.MediaAccessPermissionsCallback;
import com.tencent.smtt.export.external.interfaces.SslErrorHandler;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;
import com.vinda.vpractice2020.R;
import com.vinda.vpractice2020.databinding.ActivityMainBinding;
import com.vinda.vpractice2020.databinding.ActivityWebviewBinding;

import java.util.HashMap;

/**
 * VPractice2020
 * <p>
 * Created by Vinda on 2021/1/13
 * Copyright © 2021年 BroadVideo. All rights reserved.
 * <p>
 * Describe:
 */
public class WebViewActivity extends Activity {
    private final String TAG = this.getClass().getSimpleName();


   // private ActivityWebviewBinding binding;
    private WebView webView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // binding = ActivityWebviewBinding.inflate(LayoutInflater.from(this));
        setContentView(R.layout.activity_webview);

           }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume");
        if (QbSdk.canLoadX5(this)) {
            Log.i(TAG, "已安装好，直接显示");
            createWebview();
        } else {
            new Thread(){
                @Override
                public void run() {
                    super.run();
                    boolean ok = QbSdk.preinstallStaticTbs(WebViewActivity.this);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Log.i(TAG, "安装结果：$ok");
                            createWebview();
                        }
                    });
                }
            }.start();

        }
    }

    private void createWebview() {
        //手动创建WebView，显示到容器中，这样就能保证WebView一定是在X5内核准备好后创建的
        RelativeLayout rl_content = findViewById(R.id.rl_content);
        webView =new WebView(this);
        LinearLayout.LayoutParams css =new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT
        );
        rl_content.addView(webView, css);

        webView.setWebViewClient(webViewClient);
        webView.setWebChromeClient(webChromeClient);
        webView.setWebViewClientExtension(ix5WebViewClientExtension);
        webView.setWebChromeClientExtension(ix5WebChromeClientExtension);

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setAllowFileAccess(true);
        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        webSettings.setSupportZoom(true);
        webSettings.setBuiltInZoomControls(true);
        webSettings.setSupportMultipleWindows(true);
        webSettings.setUseWideViewPort(true);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setDisplayZoomControls(false);//设定缩放控件隐藏
        webSettings.setDomStorageEnabled(true);
        webSettings.setAppCacheEnabled(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.setAllowContentAccess(true);
        webSettings.setSavePassword(true);
        webSettings.setSaveFormData(true);
        webSettings.setLoadsImagesAutomatically(true);
        webSettings.setBlockNetworkImage(false);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            webSettings.setMediaPlaybackRequiresUserGesture(false);
        }
        webSettings.setJavaScriptCanOpenWindowsAutomatically(false);

//      var url = "https://10.155.0.134:31311"
//        var url =  "https://10.155.0.134:31311/static/testvideo/video.html?sid=60cbd910-d555-11ea-af73-45d5ffed74da&userName=cross&token=09080DC0E2A711EA9A1E5DA467561DB4&serverAddress=wss://10.155.0.135:30670/hari&accountId=AZ019121"
//      var url = "https://apprtc.webrtcserver.cn/r/319960624"
        webView.loadUrl("https://10.155.0.134:31311/static/pspmobile/index.html?sid=3af36230-e82e-11ea-87a2-19c1cf68fe0e&userName=patrol_admin&token=BD122FA05A1911EBA65C8FE637D6AF14&serverAddress=wss://10.155.254.134:20004/hari?harix_switch_server=http://10.42.11.181:9443/hari&accountId=AZ019111\n");

        Log.d(TAG,"load ${url}");

    }
    IX5WebViewClientExtension ix5WebViewClientExtension = new IX5WebViewClientExtension() {
        @Override
        public void onMissingPluginClicked(String s, String s1, String s2, int i) {

        }

        @Override
        public void onHideListBox() {

        }

        @Override
        public void onShowListBox(String[] strings, int[] ints, int[] ints1, int i) {

        }

        @Override
        public void onShowMutilListBox(String[] strings, int[] ints, int[] ints1, int[] ints2) {

        }

        @Override
        public void onFlingScrollBegin(int i, int i1, int i2) {

        }

        @Override
        public void onScrollChanged(int i, int i1, int i2, int i3) {

        }

        @Override
        public void onInputBoxTextChanged(IX5WebViewExtension ix5WebViewExtension, String s) {

        }

        @Override
        public void onTransitionToCommitted() {

        }

        @Override
        public void onUploadProgressStart(int i) {

        }

        @Override
        public void onUploadProgressChange(int i, int i1, String s) {

        }

        @Override
        public void onSoftKeyBoardShow() {

        }

        @Override
        public void onSoftKeyBoardHide(int i) {

        }

        @Override
        public void onSetButtonStatus(boolean b, boolean b1) {

        }

        @Override
        public void onHistoryItemChanged() {

        }

        @Override
        public void hideAddressBar() {

        }

        @Override
        public void handlePluginTag(String s, String s1, boolean b, String s2) {

        }

        @Override
        public void onDoubleTapStart() {

        }

        @Override
        public void onPinchToZoomStart() {

        }

        @Override
        public void onSlidingTitleOffScreen(int i, int i1) {

        }

        @Override
        public boolean preShouldOverrideUrlLoading(IX5WebViewExtension ix5WebViewExtension, String s) {
            return false;
        }

        @Override
        public void onPreReadFinished() {

        }

        @Override
        public void onPromptScaleSaved() {

        }

        @Override
        public void onFlingScrollEnd() {

        }

        @Override
        public void onUrlChange(String s, String s1) {

        }

        @Override
        public void onReportAdFilterInfo(int i, int i1, String s, boolean b) {

        }

        @Override
        public void onNativeCrashReport(int i, String s) {

        }

        @Override
        public Object onMiscCallBack(String s, Bundle bundle) {
            return null;
        }

        @Override
        public void onReportHtmlInfo(int i, String s) {

        }

        @Override
        public Object onMiscCallBack(String s, Bundle bundle, Object o, Object o1, Object o2, Object o3) {
            return null;
        }

        @Override
        public boolean onInterceptTouchEvent(MotionEvent motionEvent, View view) {
            return false;
        }

        @Override
        public boolean onTouchEvent(MotionEvent motionEvent, View view) {
            return false;
        }

        @Override
        public boolean dispatchTouchEvent(MotionEvent motionEvent, View view) {
            return false;
        }

        @Override
        public boolean overScrollBy(int i, int i1, int i2, int i3, int i4, int i5, int i6, int i7, boolean b, View view) {
            return false;
        }

        @Override
        public void onScrollChanged(int i, int i1, int i2, int i3, View view) {

        }

        @Override
        public void onOverScrolled(int i, int i1, boolean b, boolean b1, View view) {

        }

        @Override
        public void computeScroll(View view) {

        }

        @Override
        public void onMetricsSavedCountReceived(String s, boolean b, long l, String s1, int i) {

        }

        @Override
        public void showTranslateBubble(int i, String s, String s1, int i1) {

        }

        @Override
        public boolean notifyAutoAudioPlay(String s, JsResult jsResult) {
            return false;
        }

        @Override
        public boolean onShowLongClickPopupMenu() {
            return false;
        }

        @Override
        public void onResponseReceived(WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse, int i) {

        }

        @Override
        public boolean allowJavaScriptOpenWindowAutomatically(String s, String s1) {
            return false;
        }

        @Override
        public boolean notifyJavaScriptOpenWindowsBlocked(String s, String[] strings, ValueCallback<Boolean> valueCallback, boolean b) {
            return false;
        }

        @Override
        public void documentAvailableInMainFrame() {

        }

        @Override
        public void didFirstVisuallyNonEmptyPaint() {

        }

        @Override
        public void onReceivedViewSource(String s) {

        }

        @Override
        public void onPrefetchResourceHit(boolean b) {

        }

        @Override
        public void onReceivedSslErrorCancel() {

        }

        @Override
        public void invalidate() {

        }
    };



    IX5WebChromeClientExtension ix5WebChromeClientExtension = new IX5WebChromeClientExtension() {
        @Override
        public Object getX5WebChromeClientInstance() {
            return null;
        }

        @Override
        public View getVideoLoadingProgressView() {
            return null;
        }

        @Override
        public void onAllMetaDataFinished(IX5WebViewExtension ix5WebViewExtension, HashMap<String, String> hashMap) {

        }

        @Override
        public void onBackforwardFinished(int i) {

        }

        @Override
        public void onHitTestResultForPluginFinished(IX5WebViewExtension ix5WebViewExtension, IX5WebViewBase.HitTestResult hitTestResult, Bundle bundle) {

        }

        @Override
        public void onHitTestResultFinished(IX5WebViewExtension ix5WebViewExtension, IX5WebViewBase.HitTestResult hitTestResult) {

        }

        @Override
        public void onPromptScaleSaved(IX5WebViewExtension ix5WebViewExtension) {

        }

        @Override
        public void onPromptNotScalable(IX5WebViewExtension ix5WebViewExtension) {

        }

        @Override
        public boolean onAddFavorite(IX5WebViewExtension ix5WebViewExtension, String s, String s1, JsResult jsResult) {
            return false;
        }

        @Override
        public void onPrepareX5ReadPageDataFinished(IX5WebViewExtension ix5WebViewExtension, HashMap<String, String> hashMap) {

        }

        @Override
        public boolean onSavePassword(String s, String s1, String s2, boolean b, Message message) {
            return false;
        }

        @Override
        public boolean onSavePassword(ValueCallback<String> valueCallback, String s, String s1, String s2, String s3, String s4, boolean b) {
            return false;
        }

        @Override
        public void onX5ReadModeAvailableChecked(HashMap<String, String> hashMap) {

        }

        @Override
        public void addFlashView(View view, ViewGroup.LayoutParams layoutParams) {

        }

        @Override
        public void h5videoRequestFullScreen(String s) {

        }

        @Override
        public void h5videoExitFullScreen(String s) {

        }

        @Override
        public void requestFullScreenFlash() {

        }

        @Override
        public void exitFullScreenFlash() {

        }

        @Override
        public void jsRequestFullScreen() {

        }

        @Override
        public void jsExitFullScreen() {

        }

        @Override
        public void acquireWakeLock() {

        }

        @Override
        public void releaseWakeLock() {

        }

        @Override
        public Context getApplicationContex() {
            return null;
        }

        @Override
        public boolean onPageNotResponding(Runnable runnable) {
            return false;
        }

        @Override
        public Object onMiscCallBack(String s, Bundle bundle) {
            return null;
        }

        @Override
        public void openFileChooser(ValueCallback<Uri[]> valueCallback, String s, String s1) {

        }

        @Override
        public void onPrintPage() {

        }

        @Override
        public void onColorModeChanged(long l) {

        }

        @Override
        public boolean onPermissionRequest(String s, long l, MediaAccessPermissionsCallback mediaAccessPermissionsCallback) {
            Log.i(TAG, "申请权限");
            long allowed = 0;
            allowed = allowed | MediaAccessPermissionsCallback.ALLOW_AUDIO_CAPTURE| MediaAccessPermissionsCallback.ALLOW_VIDEO_CAPTURE
            |MediaAccessPermissionsCallback.BITMASK_RESOURCE_AUDIO_CAPTURE|MediaAccessPermissionsCallback.BITMASK_RESOURCE_VIDEO_CAPTURE;
            boolean retain = true;
            mediaAccessPermissionsCallback.invoke(s, allowed,retain);
            return true;
        }
    };

    WebViewClient webViewClient =  new WebViewClient() {
        @Override
        public boolean shouldOverrideUrlLoading(WebView webView, String s) {
            webView.loadUrl(s);
            return false;
        }

        @Override
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, com.tencent.smtt.export.external.interfaces.SslError sslError) {
            sslErrorHandler.proceed();
        }

        @Override
        public void onReceivedError(WebView webView, int i, String s, String s1) {
            super.onReceivedError(webView, i, s, s1);
        }
    };



    com.tencent.smtt.sdk.WebChromeClient webChromeClient = new WebChromeClient() {

        @Override
        public void onProgressChanged(WebView webView, int i) {
            super.onProgressChanged(webView, i);
        }

    };

    @Override
    protected void onPause() {
        super.onPause();
        webView.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        webView.destroy();
    }

}
