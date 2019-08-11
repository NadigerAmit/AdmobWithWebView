package com.amit.nadiger.AdMobWebViewDemo;

import android.app.Application;
import android.util.Log;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

public class App extends Application {
    private static final String TAG = "App";
    private InterstitialAd mInterstitialAd;
    private static App sInstance;
    public static App getInstance() {
        return sInstance;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
        Log.e(TAG,"Application on create" );
        MobileAds.initialize(this,
                "ca-app-pub-3940256099942544~3347511713");
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());
    }

    public InterstitialAd getInterstitaialAddInstance() {
        return mInterstitialAd;
    }
}
