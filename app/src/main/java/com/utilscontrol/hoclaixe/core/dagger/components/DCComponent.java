package com.utilscontrol.hoclaixe.core.dagger.components;

import com.utilscontrol.hoclaixe.DCApplication;
import com.utilscontrol.hoclaixe.core.dagger.builders.ActivityBuilder;
import com.utilscontrol.hoclaixe.core.dagger.modules.DCAppModule;
import com.utilscontrol.hoclaixe.core.dagger.modules.NetworkModule;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

/**
 * Created by ManhPQ on 2/22/20.
 */

@Singleton
@Component(
        modules = {
                AndroidSupportInjectionModule.class,
                NetworkModule.class,
                DCAppModule.class,
                ActivityBuilder.class
        }
)

public interface DCComponent extends AndroidInjector<DCApplication> {
    @SuppressWarnings("deprecation")
    @Component.Builder
    abstract class Builder extends AndroidInjector.Builder<DCApplication>{}
}