package com.utilscontrol.hoclaixe.core.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModel;

import dagger.android.support.DaggerAppCompatActivity;

/**
 * Created by ManhPQ on 2/22/20.
 */

public abstract class BaseActivity<T extends ViewModel> extends DaggerAppCompatActivity {

    private T viewModel;

    /**
     *
     * @return view model instance
     */
    public abstract T getViewModel();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.viewModel = viewModel == null ? getViewModel() : viewModel;
    }

    protected abstract void initView();
    protected abstract void initListenerData();
    protected abstract void initData();

}
