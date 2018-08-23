package com.work.bhaskar.myappretrofit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroFitClient {

    private static Retrofit retrofit = null;
     static Gson gson = new GsonBuilder()
            .setLenient()
            .create();
    static OkHttpClient client = new OkHttpClient();

     public static Retrofit getClient(String baseUrl) {

        if (retrofit==null) {
         retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        }
        return retrofit;

    }
}