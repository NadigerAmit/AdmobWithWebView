package com.amit.nadiger.AdMobWebViewDemo;

import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class VcWebViewClient extends WebViewClient {
    private static final String TAG = "VcWebViewClient";
    private ProgressDialog mProgDailog;
    Activity mParentActivity ;
    public VcWebViewClient(Activity parentActivity) {
        mParentActivity = parentActivity;
    }
    @Override
    public void onPageStarted(WebView view, String url, Bitmap favicon) {
        super.onPageStarted(view, url, favicon);

        if(mProgDailog == null){
            mProgDailog = ProgressDialog.show(mParentActivity, null, "Loading...");
            mProgDailog.setCancelable(true);
        }
    }
    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) { ;
        view.loadUrl(url);
        return true;
    }
    @Override
    public void onPageFinished(WebView view, String url) {
        super.onPageFinished(view, url);
        Log.e(TAG, "onPageFinished called ");
        if(mProgDailog.isShowing()) {
            mProgDailog.dismiss();
        }
    }
}
