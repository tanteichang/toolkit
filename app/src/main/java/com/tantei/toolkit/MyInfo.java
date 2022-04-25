package com.tantei.toolkit;

import android.util.Log;

import javax.inject.Inject;

public class MyInfo {

    private static final String TAG = "MyInfo";
    
    @Inject
    public MyInfo() {
    }
    
    public void hi() {
        Log.d(TAG, "hi: hi");
    }
}
