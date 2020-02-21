package com.utilscontrol.hoclaixe.core.dagger.modules;

import android.content.Context;
import com.utilscontrol.hoclaixe.DCApplication;
import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;

/**
 * Created by ManhPQ on 2/22/20.
 */

@Module
public class DCAppModule {
    @Singleton
    @Provides
    public Context provideContext(DCApplication application){
        return application;
    }
}
