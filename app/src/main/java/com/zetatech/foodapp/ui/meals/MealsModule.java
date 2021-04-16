package com.zetatech.foodapp.ui.meals;



import com.zetatech.foodapp.injection.annotation.FragmentDisposable;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ActivityComponent;
import dagger.hilt.android.components.FragmentComponent;
import dagger.hilt.android.scopes.ActivityScoped;
import dagger.hilt.android.scopes.FragmentScoped;
import io.reactivex.rxjava3.disposables.CompositeDisposable;


@Module
@InstallIn(FragmentComponent.class)
public abstract class MealsModule {



    @FragmentScoped
    @Binds
    public abstract  MealsContract.Presenter bindMealsPresenter(MealsPresenter presenter);


    @FragmentScoped
    @Binds
    public abstract MealsIntegrator bindMealsIntegrator(
             MealsIntegratorImpl integrator
    );



    @FragmentDisposable
    @Provides
    @FragmentScoped
    public static CompositeDisposable provideCompositeDisposable() {
        return new CompositeDisposable();
    }

}
