package com.example.chefschoice.Register;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.Toolbar;

import com.example.chefschoice.HomeScreen;
import com.example.chefschoice.R;
import com.google.firebase.auth.FirebaseAuth;

public class MainRegisterScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_register_screen);

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        Toolbar tool = findViewById(R.id.toolbar);
        setSupportActionBar(tool);

        Button signin=findViewById(R.id.signinbutton);
        Button login=findViewById(R.id.loginbutton);
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        if (firebaseAuth.getCurrentUser() != null) {


            startActivity(new Intent(MainRegisterScreen.this, HomeScreen.class));
            finish();
        }
        else {

            signin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(MainRegisterScreen.this, SigninScreen.class));
                }
            });
            login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(MainRegisterScreen.this, LoginScreen.class));
                }
            });
        }

    }


}