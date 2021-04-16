package com.zetatech.foodapp.ui.dashboard;


import com.zetatech.foodapp.data.models.ResponseDashboard;
import com.zetatech.foodapp.ui.base.BaseInteractor;

import io.reactivex.rxjava3.core.Observable;

public interface DashboardIntegrator extends BaseInteractor {


     int getAreaId();

    Observable<ResponseDashboard> loadDashboardData(int areaId);


}
