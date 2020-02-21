package com.utilscontrol.hoclaixe.screens.main;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ManhPQ on 2/22/20.
 */

@Module
public class MainActivityModule {
    @Provides
    MainActivityViewModel provideMainActivityViewModel(MainActivityRepository repository){
        return new MainActivityViewModel(repository);
    }
}
