package com.work.bhaskar.myappretrofit;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class UserListActivity extends Activity {

    private List<PostRegister> userlistList = new ArrayList<>();
    private RecyclerView recyclerView;

    private UserListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        mAdapter = new UserListAdapter(userlistList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

//
      //  Intent intent = getIntent();
//        Bundle args = intent.getBundleExtra("BUNDLE");
//        List<PostRegister> mJsonMyObject  = (List<PostRegister>) args.getSerializable("myObj");
//        try{
//            Log.d("Bhaskar: ",mJsonMyObject.toString());
//            for(int i = 0; i < mJsonMyObject.size(); i++){
//                userlistList.add(new PostRegister(mJsonMyObject.get(i).getName(),mJsonMyObject.get(i).getEmail(),mJsonMyObject.get(i).getId()));
//            }
//        }catch (NullPointerException ae){
//            Log.d("Bhaskar", ae.getMessage());
//        }
        prepareMovieData();

        mAdapter.notifyDataSetChanged();
    }

    private void prepareMovieData() {
        PostRegister movie = new PostRegister("Bhaskar", "bsjdbdasbads@gmail.com", 1);
        userlistList.add(movie);

        movie = new PostRegister("Bhaskar", "bsjdbdasbads@gmail.com", 1);
        userlistList.add(movie);

        movie = new PostRegister("Bhaskar", "bsjdbdasbads@gmail.com", 1);
        userlistList.add(movie);

        movie = new PostRegister("Bhaskar", "bsjdbdasbads@gmail.com", 1);
        userlistList.add(movie);
        movie = new PostRegister("Bhaskar", "bsjdbdasbads@gmail.com", 1);
        userlistList.add(movie);

        movie = new PostRegister("Bhaskar", "bsjdbdasbads@gmail.com", 1);
        userlistList.add(movie);

        movie = new PostRegister("Bhaskar", "bsjdbdasbads@gmail.com", 1);
        userlistList.add(movie);
        movie = new PostRegister("Bhaskar", "bsjdbdasbads@gmail.com", 1);
        userlistList.add(movie);

        movie = new PostRegister("Bhaskar", "bsjdbdasbads@gmail.com", 1);
        userlistList.add(movie);

        movie = new PostRegister("Bhaskar", "bsjdbdasbads@gmail.com", 1);
        userlistList.add(movie);
        movie = new PostRegister("Bhaskar", "bsjdbdasbads@gmail.com", 1);
        userlistList.add(movie);

        movie = new PostRegister("Bhaskar", "bsjdbdasbads@gmail.com", 1);
        userlistList.add(movie);

        movie = new PostRegister("Bhaskar", "bsjdbdasbads@gmail.com", 1);
        userlistList.add(movie);


    }

}
