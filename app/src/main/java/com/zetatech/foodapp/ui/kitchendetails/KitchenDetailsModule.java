package com.zetatech.foodapp.ui.kitchendetails;



import dagger.Binds;
import dagger.Module;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ActivityComponent;
import dagger.hilt.android.scopes.ActivityScoped;

@Module
@InstallIn(ActivityComponent.class)
public abstract class KitchenDetailsModule {



    @ActivityScoped
    @Binds
    public abstract  KitchenDetailsContract.Presenter bindKitchenPresenter(KitchenDetailsPresenter presenter);


    @ActivityScoped
    @Binds
    public abstract KitchenDetailsIntegrator bindKitchenIntegrator(
             KitchenDetailsIntegratorImpl integrator
    );



}
