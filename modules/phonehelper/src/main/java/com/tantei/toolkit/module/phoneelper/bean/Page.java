package com.tantei.toolkit.module.phoneelper.bean;

import androidx.fragment.app.Fragment;

public class Page {
    private String name;
    private Fragment fragment;

    public Page(String name, Fragment fragment) {
        this.name = name;
        this.fragment = fragment;
    }

    public String getName() {
        return name;
    }

    public Fragment getFragment() {
        return fragment;
    }
}
