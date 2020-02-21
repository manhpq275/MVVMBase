package com.utilscontrol.hoclaixe.core.dagger.builders;

import com.utilscontrol.hoclaixe.screens.main.MainActivity;
import com.utilscontrol.hoclaixe.screens.main.MainActivityModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by ManhPQ on 2/22/20.
 */


@Module
public abstract class ActivityBuilder {
    @ContributesAndroidInjector(
            modules = {
                    MainActivityModule.class
            }
    )
    abstract MainActivity contributeMainActivity();
}
