package com.utilscontrol.hoclaixe;

import com.utilscontrol.hoclaixe.core.dagger.components.DaggerDCComponent;

import dagger.android.AndroidInjector;
import dagger.android.support.DaggerApplication;

/**
 * Created by ManhPQ on 2/22/20.
 */

public class DCApplication extends DaggerApplication {
    private static DCApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
    }

    public static synchronized DCApplication getInstance() {
        return instance;
    }
    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerDCComponent.builder().create(this);
    }
}
