package com.tantei.toolkit.lib.common.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;

public abstract class BaseFragmentVB<VB extends ViewBinding> extends BaseFragment {
    protected VB mBinding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        ParameterizedType type = (ParameterizedType) getClass().getGenericSuperclass();
        Class<?> aClass = (Class<?>) type.getActualTypeArguments()[0];
        Method method = null;
        try {
            method = aClass.getDeclaredMethod("inflate", LayoutInflater.class, ViewGroup.class, Boolean.class);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        try {
            mBinding = (VB) method.invoke(null, getLayoutInflater(), container, false);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return mBinding.getRoot();
    }
}
