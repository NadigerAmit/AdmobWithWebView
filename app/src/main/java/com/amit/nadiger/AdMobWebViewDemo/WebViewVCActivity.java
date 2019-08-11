package com.amit.nadiger.AdMobWebViewDemo;

import androidx.appcompat.app.AppCompatActivity;

import android.net.http.SslError;
import android.os.Bundle;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebViewVCActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view_vc);
        WebView myWebView = (WebView) findViewById(R.id.webview);
        myWebView.getSettings().setLoadWithOverviewMode(true);
        myWebView.getSettings().setUseWideViewPort(true);
        myWebView.setWebViewClient (new VcWebViewClient(this));
        myWebView.getSettings().setJavaScriptEnabled(true);
        myWebView.setWebViewClient(new SSLTolerentWebViewClient());
        myWebView.loadUrl("https://www.google.co.in/");
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    class SSLTolerentWebViewClient extends WebViewClient {
        @Override
        public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
                handler.proceed(); // Ignore SSL certificate errors
        }
    }
}
