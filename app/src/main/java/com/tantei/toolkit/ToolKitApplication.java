package com.tantei.toolkit;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;

import dagger.hilt.android.HiltAndroidApp;

@HiltAndroidApp
public class ToolKitApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ARouter.openLog();
        ARouter.openDebug();
        ARouter.init(this);
    }
}
