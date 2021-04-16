package com.zetatech.foodapp.ui.dashboard;



import dagger.Binds;
import dagger.Module;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ActivityComponent;
import dagger.hilt.android.scopes.ActivityScoped;

@Module
@InstallIn(ActivityComponent.class)
public abstract class DashboardModule {



    @ActivityScoped
    @Binds
    public abstract  DashboardContract.Presenter bindDashPresenter(DashboardPresenter presenter);


    @ActivityScoped
    @Binds
    public abstract DashboardIntegrator bindDashIntegrator(
             DashboardIntegratorImpl integrator
    );



}
