package com.zetatech.foodapp.data.network.connection;



import com.zetatech.foodapp.data.network.Urls;
import com.zetatech.foodapp.data.network.webservice.BaseApi;

import java.net.CookieHandler;
import java.net.CookieManager;

import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
import okhttp3.JavaNetCookieJar;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.logging.HttpLoggingInterceptor.Level;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class RetroConnect {

  //Represents  initialize Retrofit
    public BaseApi initRetrofit() {

        Retrofit retrofit = new Retrofit.Builder().baseUrl(Urls.BASE_URL)
                .client(getClient())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(BaseApi.class);


    }


    private OkHttpClient getClient() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(Level.BODY);

        // initialize cookie manager
        CookieHandler cookieHandler = new CookieManager();

        OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .cookieJar(new JavaNetCookieJar(cookieHandler))
                .retryOnConnectionFailure(true);

        return clientBuilder.build();
    }


}
