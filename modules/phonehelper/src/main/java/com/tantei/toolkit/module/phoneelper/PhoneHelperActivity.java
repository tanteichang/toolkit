package com.tantei.toolkit.module.phoneelper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;

@Route(path = "/phonehelper/PhoneHelperActivity")
public class PhoneHelperActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.phonehelper_activity_phone_helper);
    }
}