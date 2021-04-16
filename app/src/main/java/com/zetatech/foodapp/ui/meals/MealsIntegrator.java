package com.zetatech.foodapp.ui.meals;



import com.zetatech.foodapp.data.models.ResponseMenuDetails;
import com.zetatech.foodapp.ui.base.BaseInteractor;

import io.reactivex.rxjava3.core.Observable;


public interface MealsIntegrator extends BaseInteractor {


    Observable<ResponseMenuDetails> loadMenuDetails(int menuId );


}
