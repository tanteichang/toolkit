package com.tantei.toolkit.module.phoneelper.utils;

import java.util.Locale;

import javax.inject.Inject;

public class SystemUtil {

    @Inject
    public SystemUtil() {}

    public  String getSystemLanguage() {
        return Locale.getDefault().getLanguage();
    }
}
