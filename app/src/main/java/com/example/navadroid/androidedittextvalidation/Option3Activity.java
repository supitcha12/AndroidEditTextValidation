package com.example.navadroid.androidedittextvalidation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Option3Activity extends AppCompatActivity {

    private EditText etName;
    private EditText etPwd;
    private EditText etEmail;
    private EditText etPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option3);
        bindView();
        initView();
    }

    private void bindView(){
        etName = (EditText) findViewById(R.id.et_name3);
        etPwd = (EditText) findViewById(R.id.et_pwd3);
        etEmail = (EditText) findViewById(R.id.et_email3);
        etPhone = (EditText) findViewById(R.id.et_phone3);
    }

    private void initView(){
        // OnClickListener
        findViewById(R.id.btn_validate3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validateEditText()){
                    Toast.makeText(Option3Activity.this, "Okay. You are good to go.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // TextChangedListener
        etName.addTextChangedListener(new TextValidator(etName) {
            @Override
            public void validate(TextView textView, String text) {
                if (etName.getText().toString().length() == 0) {
                    etName.setError("Required");
                }
                else if(!(etName.getText().toString().matches("^[A-Za-z0-9 ]{1,40}$"))){
                    etName.setError("Wrong format");
                }
            }
        });

        etPwd.addTextChangedListener(new TextValidator(etPwd) {
            @Override
            public void validate(TextView textView, String text) {
                // TODO: add your Password validation here
                if (etName.getText().toString().length() == 0) {
                    etName.setError("Required");
                }
                else if(!(etName.getText().toString().matches("^[A-Za-z0-9 ]{1,40}$"))){
                    etName.setError("Wrong format");
                }
            }
        });

        //etEmail.addTextChangedListener(...);
        //etPhone.addTextChangedListener(...);
        etEmail.addTextChangedListener(new TextValidator(etEmail) {
            @Override
             public void validate(TextView textView, String text) {
                if (etEmail.getText().toString().length() == 0) {
                    etEmail.setError("Required");
                }
                else if(!(etEmail.getText().toString().matches("^[A-Za-z0-9]{1,40}[@]{1}[A-za-z0-9]{1,10}[.]{1}[A-Za-z]{3}$"))){
                    etEmail.setError("Wrong format");
                }
            }
        });

        etPhone.addTextChangedListener(new TextValidator(etPhone) {
            @Override
           public void validate(TextView textView, String text) {
                if (etPhone.getText().toString().length() == 0) {
                    etPhone.setError("Required");
                }
                else if(!(etPhone.getText().toString().matches("^[0]{1}[0-9]{9}$"))){
                    etPhone.setError("Wrong format");
                }
            }
     });
    }


    // To validate all EditTexts
    private boolean validateEditText(){
        boolean isValidated = true;
        if (etName.getText().toString().length() == 0) {
            etName.setError("Required");
            isValidated = false;
        }
        else if (!(etName.getText().toString().matches("^[A-Za-z0-9 ]{1,40}$"))){
            etName.setError("Wrong format");
            isValidated = false;
        }
        if (etPwd.getText().toString().length() == 0) {
            etPwd.setError("Required");
            isValidated = false;
        }
        else if(!(etPwd.getText().toString().matches("^[A-Za-z0-9]{1,40}$"))){
            etPwd.setError("wrong format");
            isValidated = false;

        }

        if (etEmail.getText().toString().length() == 0) {
            etEmail.setError("Wrong fowmat");
            isValidated = false;
        }
        else if (!(etEmail.getText().toString().matches("^[A-Za-z0-9]{1,40}[@]{1}[A-za-z0-9]{1,10}[.]{1}[A-Za-z]{3}$"))) {
            etEmail.setError("Wrong format");
            isValidated = false;
    }
        if (etPhone.getText().toString().length() == 0) {
            etPhone.setError("Required");
            isValidated = false;
        }
        else if(!(etPhone.getText().toString().matches("^[0]{1}[0-9]{9}$"))){
            etPhone.setError("use 10 number only");
            isValidated = false;
        }
        // TODO: add your EditText validation here

        return isValidated;
    }
}
