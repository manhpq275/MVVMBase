package com.utilscontrol.hoclaixe.core.dagger.modules;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.utilscontrol.hoclaixe.core.network.ApiService;
import com.utilscontrol.hoclaixe.utils.ApiConstants;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ManhPQ on 2/22/20.
 */

@Module
public class NetworkModule {
    @Singleton
    @Provides
    OkHttpClient providesClient()  {
        long requestTimeOut = 120;
        return new OkHttpClient.Builder()
                .connectTimeout(requestTimeOut, TimeUnit.SECONDS)
                .readTimeout(requestTimeOut, TimeUnit.SECONDS)
                .build();
    }

    @Singleton
    @Provides
    Retrofit provideRetrofit()  {
        return new Retrofit.Builder()
                .baseUrl(ApiConstants.BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(providesClient())
                .build();
    }

    @Singleton
    @Provides
    ApiService provideApiService(Retrofit retrofit) {
        return retrofit.create(ApiService.class);
    }
}
