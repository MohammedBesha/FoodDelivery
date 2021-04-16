

package com.zetatech.foodapp.injection.module;


import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ActivityComponent;
import dagger.hilt.android.scopes.ActivityScoped;
import io.reactivex.rxjava3.disposables.CompositeDisposable;


@Module
@InstallIn(ActivityComponent.class)
public class ActivityModule {


    @Provides
    @ActivityScoped
    public static CompositeDisposable provideCompositeDisposable() {
        return new CompositeDisposable();
    }




}
