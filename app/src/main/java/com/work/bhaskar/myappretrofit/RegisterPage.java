package com.work.bhaskar.myappretrofit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterPage extends AppCompatActivity {

    private static final String TAG = "Bhaskar";
    EditText nameField, mobileField, emailField,passwoedField;
    Button registerButton, userlistButton;

    private TextView mResponseTv;
    private APIService mAPIService;
    PostRegister register;

    ArrayList<PostRegister> listdata;
    private RecyclerView recyclerView;
    private ArrayList<PostRegister> userlistList = new ArrayList<>();

    private UserListAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page);

        nameField =(EditText)findViewById(R.id.name);
        mobileField =(EditText)findViewById(R.id.mobile);
        emailField =(EditText)findViewById(R.id.email);
        passwoedField =(EditText)findViewById(R.id.password);
        registerButton =(Button)findViewById(R.id.register);
        userlistButton = (Button)findViewById(R.id.listData);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        mAdapter = new UserListAdapter(userlistList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        mAPIService = ApiUtils.getAPIService();

        userlistButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getUserListData();
            }
        });

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameFieldtext = nameField.getText().toString().trim();
                String mobileFieldtext = mobileField.getText().toString().trim();
                String emailFieldtext = emailField.getText().toString().trim();
                String passwodFieldtext = passwoedField.getText().toString().trim();
                register = new PostRegister(nameFieldtext,mobileFieldtext,emailFieldtext,passwodFieldtext,1);
                sendPost(register);
            }
        });
    }

public void getUserListData() {
    mAPIService.getUserListData().enqueue(new Callback<ArrayList<PostRegister>>() {
        @Override
        public void onResponse(Call<ArrayList<PostRegister>> call, Response<ArrayList<PostRegister>> response) {

            List<PostRegister> data =  response.body();
            for(int i = 0; i <data.size(); i++){
                userlistList.add(new PostRegister(data.get(i).getName(),data.get(i).getEmail(),data.get(i).getId()));
            }
            mAdapter.notifyDataSetChanged();
        }

        @Override
        public void onFailure(Call<ArrayList<PostRegister>> call, Throwable t) {
            Log.d(TAG, t.getMessage().toString());
        }

    });

}

//public void displayData(List<PostRegister> listdata){
//    int k = 0;
//    int lengthofusr = listdata.size();
//     while (lengthofusr >= 0){
//         -- lengthofusr;
//         listdata.get(k).getMobile();
//         k++;
//     }

//    for ( int k = 0; k < lengthofusr; k++);{
//        listdata.get(k).getMobile();
//        Log.d(TAG, "Id: "+listdata.get(k).getMobile());
//    }
//}
    public void sendPost(final PostRegister register) {

        mAPIService.registerPost(register.getName(),register.getMobile(),register.getEmail(), register.getPassword(), register.getId())
                .enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {
                        Toast.makeText(RegisterPage.this, "Successfully Registered !!", Toast.LENGTH_SHORT).show();
                        Log.d(TAG, response.toString());
                    }

                    @Override
                    public void onFailure(Call<String> call, Throwable t) {
                        Toast.makeText(RegisterPage.this, t.getMessage().toString(), Toast.LENGTH_SHORT).show();
                    }
                });
    }




    public void showResponse(String response) {
        if(mResponseTv.getVisibility() == View.GONE) {
            mResponseTv.setVisibility(View.VISIBLE);
        }
        mResponseTv.setText(response);
    }
}
