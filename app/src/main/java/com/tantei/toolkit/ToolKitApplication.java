package com.tantei.toolkit;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;

public class ToolKitApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ARouter.init(this);
    }
}
