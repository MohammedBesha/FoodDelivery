package com.zetatech.foodapp.ui.mealdetails;



import com.zetatech.foodapp.data.models.ResponseMealDetails;
import com.zetatech.foodapp.ui.base.BaseInteractor;

import io.reactivex.rxjava3.core.Observable;

public interface MealDetailsIntegrator extends BaseInteractor {



    Observable<ResponseMealDetails> loadMealDetails(int mealId);


}
