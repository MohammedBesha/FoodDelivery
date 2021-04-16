package com.zetatech.foodapp.ui.mealdetails;



import dagger.Binds;
import dagger.Module;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ActivityComponent;
import dagger.hilt.android.scopes.ActivityScoped;

@Module
@InstallIn(ActivityComponent.class)
public abstract class MealDetailsModule {



    @ActivityScoped
    @Binds
    public abstract  MealDetailsContract.Presenter bindMealDetailsPresenter(MealDetailsPresenter presenter);


    @ActivityScoped
    @Binds
    public abstract MealDetailsIntegrator bindMealDetailsIntegrator(
             MealDetailsIntegratorImpl integrator
    );



}
