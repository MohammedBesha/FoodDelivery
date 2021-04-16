package com.zetatech.foodapp.ui.kitchendetails;


import com.zetatech.foodapp.data.models.ResponseKitchenDetails;
import com.zetatech.foodapp.ui.base.BaseInteractor;

import io.reactivex.rxjava3.core.Observable;

public interface KitchenDetailsIntegrator extends BaseInteractor {



    Observable<ResponseKitchenDetails> loadKitchensData(int kitchenId);


}
