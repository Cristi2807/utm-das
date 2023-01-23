package com.example.kidsafe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignUpActivity extends AppCompatActivity {

    TextInputEditText etSignUpID;
    TextInputLayout SignUpID;

    TextInputEditText etSignUpPass;
    TextInputLayout SignUpPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Sign Up as Student");

        etSignUpID = findViewById(R.id.textInputEditText);
        SignUpID = findViewById(R.id.textInputLayout);

        etSignUpPass = findViewById(R.id.textInputEditText1);
        SignUpPass = findViewById(R.id.textInputLayout1);

        etSignUpID.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() < 13) {
                    SignUpID.setError("ID number is 13 characters long!");
                } else SignUpID.setError(null);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        etSignUpPass.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() < 8) {
                    SignUpPass.setError("Minimum 8 characters");
                } else SignUpPass.setError(null);

                Pattern digit = Pattern.compile("[0-9]");
                Pattern special = Pattern.compile("[!@#$%&*()_+=|<>?{}\\[\\]~-]");

                Matcher hasDigit = digit.matcher(charSequence);
                Matcher hasSpecial = special.matcher(charSequence);

                if (!hasSpecial.find()) {
                    SignUpPass.setError("Minimum 1 special character");
                }

                if (!hasDigit.find()) {
                    SignUpPass.setError("Minimum 1 digit");
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        MaterialButton signUpButton = findViewById(R.id.materialButton1);

        signUpButton.setOnClickListener(view -> signUp());
    }

    private void signUp() {
        if (SignUpID.getError() == null && SignUpPass.getError() == null &&
                !TextUtils.isEmpty(Objects.requireNonNull(etSignUpID.getText()).toString()) &&
                !TextUtils.isEmpty(Objects.requireNonNull(etSignUpPass.getText()).toString())) {

            Toast toast = Toast.makeText(SignUpActivity.this, "User registered successfully", Toast.LENGTH_LONG);
            toast.getView().setBackgroundResource(R.drawable.toast_blue);
            toast.show();

            startActivity(new Intent(SignUpActivity.this, StudentActivity.class));
            finish();
        } else {
            Toast toast = Toast.makeText(SignUpActivity.this, "Sign Up Error", Toast.LENGTH_SHORT);
            toast.getView().setBackgroundResource(R.drawable.toast_red);
            toast.show();
        }
    }

}