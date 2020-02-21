package com.utilscontrol.hoclaixe.screens.main;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.gson.Gson;
import com.utilscontrol.hoclaixe.R;
import com.utilscontrol.hoclaixe.core.base.BaseActivity;

import javax.inject.Inject;

import dagger.android.AndroidInjection;

/**
 * Created by ManhPQ on 2/22/20.
 */

public class MainActivity extends BaseActivity<MainActivityViewModel> {

    @Inject
    MainActivityViewModel mViewModel;

    TextView tvData;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AndroidInjection.inject(this);
        initView();
        initListenerData();
        initData();
    }

    @Override
    public MainActivityViewModel getViewModel() {
        return mViewModel;
    }

    @Override
    protected void initView() {
        tvData = findViewById(R.id.data);
    }

    protected void initListenerData() {
        getViewModel().getQuestionLiveData().observe(this, questionResponse -> {
            Log.e("MainActivity", "" + new Gson().toJson(questionResponse.getData().get(0).content));
            tvData.setText(questionResponse.getData().get(0).content);
        });
    }

    @Override
    protected void initData() {
        getViewModel().getListQuestion();
    }
}
