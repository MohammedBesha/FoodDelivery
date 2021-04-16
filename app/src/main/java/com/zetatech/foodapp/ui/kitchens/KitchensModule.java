package com.zetatech.foodapp.ui.kitchens;



import dagger.Binds;
import dagger.Module;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ActivityComponent;
import dagger.hilt.android.components.FragmentComponent;
import dagger.hilt.android.scopes.ActivityScoped;
import dagger.hilt.android.scopes.FragmentScoped;

@Module
@InstallIn(FragmentComponent.class)
public abstract class KitchensModule {



    @FragmentScoped
    @Binds
    public abstract  KitchensContract.Presenter bindKitchensPresenter(KitchensPresenter presenter);



}
