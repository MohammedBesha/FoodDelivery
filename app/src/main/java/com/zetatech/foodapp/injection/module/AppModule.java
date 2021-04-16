package com.zetatech.foodapp.injection.module;


import com.zetatech.foodapp.data.network.connection.RetroConnect;
import com.zetatech.foodapp.data.network.webservice.BaseApi;

import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;


@Module
@InstallIn(SingletonComponent.class)
public class AppModule {

    @Provides
    @Singleton
    public static BaseApi provideApiService() {
        return new RetroConnect().initRetrofit();
    }
}
