package com.zetatech.foodapp.data.network.webservice;


import com.zetatech.foodapp.data.models.ResponseDashboard;
import com.zetatech.foodapp.data.models.ResponseKitchenDetails;
import com.zetatech.foodapp.data.models.ResponseLogin;
import com.zetatech.foodapp.data.models.ResponseMealDetails;
import com.zetatech.foodapp.data.models.ResponseMenuDetails;
import com.zetatech.foodapp.data.network.Urls;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;


public interface BaseApi {


    @FormUrlEncoded
    @POST(Urls.ENDPOINTS.LOGIN)
    Observable<ResponseLogin> login(@Field("phone") String phone,
                                    @Field("country_code_lookup_id") int countryCodeLookupID,
                                    @Field("password") String password);

    @GET(Urls.ENDPOINTS.DASH_BOARD)
    Observable<ResponseDashboard> getDashboardData(@Path("area_id") int areaId);


    @GET(Urls.ENDPOINTS.KITCHENS)
    Observable<ResponseKitchenDetails> getKitchensData(@Path("kitchen_id") int kitchenId);


    @GET(Urls.ENDPOINTS.MENU_DETAILS)
    Observable<ResponseMenuDetails> getMenuDetails(@Path("menu_id") int menuId);


    @GET(Urls.ENDPOINTS.MEAL_DETAILS)
    Observable<ResponseMealDetails> getMealDetails(@Path("meal_id") int mealId);


}
