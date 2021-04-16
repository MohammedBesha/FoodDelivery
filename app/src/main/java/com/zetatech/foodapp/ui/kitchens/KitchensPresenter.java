package com.zetatech.foodapp.ui.kitchens;

import com.zetatech.foodapp.ui.base.BaseInteractor;
import com.zetatech.foodapp.ui.base.BasePresenterImp;
import javax.inject.Inject;



public class KitchensPresenter extends BasePresenterImp<KitchensContract.View, BaseInteractor> implements KitchensContract.Presenter {


    @Inject
    public KitchensPresenter() {
        super(null, null);
    }



}
