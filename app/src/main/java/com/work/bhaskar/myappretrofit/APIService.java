package com.work.bhaskar.myappretrofit;


import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface APIService {

    @POST("counterapp/insertuser.php")
    @FormUrlEncoded
    Call<String> registerPost(@Field("name") String name,
                        @Field("mobile") String mobile,
                        @Field("email") String email,
                         @Field("password") String password,
                         @Field("id") int id);


    @GET("counterapp/myfile.php")
    Call<ArrayList<PostRegister>> getUserListData();
}