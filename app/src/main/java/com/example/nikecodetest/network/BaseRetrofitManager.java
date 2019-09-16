package com.example.nikecodetest.network;

import com.example.nikecodetest.model.WordDefinition;
import com.example.nikecodetest.model.WordDefinitions;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Srinivas on 4/14/2018.
 */

public class BaseRetrofitManager {

    public static Retrofit getRetrofit() {
        Gson gson = new GsonBuilder().setLenient().create();

        Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(URL);

        OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient.Builder();

        okHttpClientBuilder.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request origReq = chain.request();

                Request.Builder requestBuilder = origReq.newBuilder()
                        .addHeader("x-rapidapi-host", "mashape-community-urban-dictionary.p.rapidapi.com")
                        .addHeader("x-rapidapi-key", "80ebaff931mshd4a1fb8e3bd80d1p1377b5jsnd93c23c6070d");


                Request request = requestBuilder.build();

                return chain.proceed(request);
            }
        });

        OkHttpClient okHttpClient = okHttpClientBuilder
                .connectTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(20, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .build();
        retrofitBuilder.client(okHttpClient);

//
//        OkHttpClient client = new OkHttpClient();
//
//        Request request = new Request.Builder()
//                .url("https://mashape-community-urban-dictionary.p.rapidapi.com/define?term=bad")
//                .get()
//                .addHeader("x-rapidapi-host", "mashape-community-urban-dictionary.p.rapidapi.com")
//                .addHeader("x-rapidapi-key", "80ebaff931mshd4a1fb8e3bd80d1p1377b5jsnd93c23c6070d")
//                .build();
//
//        Response response = client.newCall(request).execute();


        return retrofitBuilder.build();
    }

    public static void callWebService(Observable observable, Subscriber<WordDefinitions> subscriber) {

        observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    private static final String URL = "https://mashape-community-urban-dictionary.p.rapidapi.com/";
}