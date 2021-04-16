package com.zetatech.foodapp.ui.base;



import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;


//Represents Base Presenter implements
public abstract class BasePresenterImp<V extends BaseView, I extends BaseInteractor> implements BasePresenter<V, I> {

    protected V mView;
    protected I mIntegrator;
    private final CompositeDisposable mCompositeDisposable;


    public BasePresenterImp(I mIntegrator, CompositeDisposable compositeDisposable) {

        this.mIntegrator = mIntegrator;
        mCompositeDisposable = compositeDisposable;
    }


    @Override
    public void onAttach(V mvpView) {
        this.mView = mvpView;

    }

    protected void addDisposable(Disposable disposable) {
        this.mCompositeDisposable.add(disposable);
    }


    public boolean isViewAttached() {
        return mView != null;
    }


    @Override
    public V getView() {
        return this.mView;
    }

    @Override
    public I getIntegrator() {
        return this.mIntegrator;
    }


    @Override
    public void onDetach() {
        if (mCompositeDisposable != null)
            this.mCompositeDisposable.clear();

        this.mView = null;
        this.mIntegrator = null;
    }
}