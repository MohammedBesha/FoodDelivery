package com.zetatech.foodapp.ui.login;


import dagger.Binds;
import dagger.Module;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ActivityComponent;
import dagger.hilt.android.scopes.ActivityScoped;


@Module
@InstallIn(ActivityComponent.class)
public abstract class LoginModule {



    @ActivityScoped
    @Binds
    public abstract LoginContract.Presenter bindLoginPresenter(LoginPresenter presenter);



    @ActivityScoped
    @Binds
    public abstract LoginIntegrator bindLoginIntegrator(
            LoginIntegratorImpl integrator
    );

}
