package com.zetatech.foodapp.ui.base;

public interface BasePresenter<V extends BaseView, I extends BaseInteractor> {

    void onAttach(V view);

    void onDetach();

    V getView();

    BaseInteractor getIntegrator();

}
