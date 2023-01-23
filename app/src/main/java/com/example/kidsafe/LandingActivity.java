package com.example.kidsafe;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;


public class LandingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);
        Objects.requireNonNull(getSupportActionBar()).hide();


        Button join = findViewById(R.id.materialButton);

        join.setOnClickListener(view -> startActivity(new Intent(LandingActivity.this, SignUpActivity.class)));

        Button login = findViewById(R.id.materialButton1);

        login.setOnClickListener(view -> startActivity(new Intent(LandingActivity.this, LoginActivity.class)));
    }
}
