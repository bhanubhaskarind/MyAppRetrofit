package com.work.bhaskar.myappretrofit;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegistrationActivity extends AppCompatActivity {

    private static final String TAG = "Bhaskar";

    EditText nameField, mobileField, emailField,passwoedField;
    Button register;
    Spinner gender;

    private APIService mAPIService;
    PostRegister mPostRegister;

    private ProgressDialog mProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        progressBayProperties();
          getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mobileField = (EditText)findViewById(R.id.mobile);
        nameField = (EditText)findViewById(R.id.name);
        passwoedField = (EditText)findViewById(R.id.password);
        emailField = (EditText)findViewById(R.id.email);
        register = (Button)findViewById(R.id.register_button);
        gender = (Spinner)findViewById(R.id.gender_button);

        mAPIService = ApiUtils.getAPIService();


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.gender_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        gender.setAdapter(adapter);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // goToLoginPage();
                String nameFieldtext = nameField.getText().toString().trim();
                String mobileFieldtext = mobileField.getText().toString().trim();
                String emailFieldtext = emailField.getText().toString().trim();
                String passwodFieldtext = passwoedField.getText().toString().trim();
                String genderText = gender.getSelectedItem().toString();

                mPostRegister = new PostRegister(nameFieldtext,mobileFieldtext,emailFieldtext,passwodFieldtext,1,genderText);
                sendPost(mPostRegister);
                mProgress.show();
            }
        });
    }

    public void resetAllFields(){
        nameField.setText("");
        mobileField.setText("");
        emailField.setText("");
        passwoedField.setText("");
    }
    public void sendPost(final PostRegister register) {

        mAPIService.registerPost(register.getName(),register.getMobile(),register.getEmail(), register.getPassword(), register.getId(), register.getGender())
                .enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {
                        mProgress.dismiss();
                        Toast.makeText(RegistrationActivity.this, "Successfully Registered !!", Toast.LENGTH_SHORT).show();
                        Log.d(TAG, response.toString());
                        resetAllFields();
                        goToLoginPage();
                    }

                    @Override
                    public void onFailure(Call<String> call, Throwable t) {
                        mProgress.dismiss();
                        Toast.makeText(RegistrationActivity.this, t.getMessage().toString(), Toast.LENGTH_SHORT).show();
                    }
                });
    }

    public void goToLoginPage(){
        Intent intent = new Intent(RegistrationActivity.this, LoginActivity.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(RegistrationActivity.this, LoginActivity.class);
        startActivity(intent);
        super.onBackPressed();
        this.finish();
    }

    public void progressBayProperties(){
        mProgress = new ProgressDialog(RegistrationActivity.this);
        mProgress.setTitle("Processing...");
        mProgress.setMessage("Please wait...");
        mProgress.setCancelable(false);
        mProgress.setIndeterminate(true);
    }
}
