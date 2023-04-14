package com.example.chefschoice.Register;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.chefschoice.HomeScreen;
import com.example.chefschoice.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SigninScreen extends AppCompatActivity { // used firebase authen. & realtime & shared pref to get and save user information
    FirebaseDatabase firebaseDatabase;
    DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin_screen);

        EditText edtEmail = findViewById(R.id.email);
        EditText edtname = findViewById(R.id.fullname);
        EditText edtphone = findViewById(R.id.phonenumber);
        EditText editpass = findViewById(R.id.password);
        Button btnsignin = findViewById(R.id.signin);

        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();

        firebaseDatabase = FirebaseDatabase.getInstance();
        reference = firebaseDatabase.getReference("users");

        btnsignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firebaseAuth.createUserWithEmailAndPassword(edtEmail.getText().toString(), editpass.getText().toString())
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    //startActivity(new Intent(MainActivity.this, viewprofile.class));
                                    //  finish();
                                    // Toast.makeText(MainActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(SigninScreen.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                }
                            }
                        });

                user userdata = new user(edtEmail.getText().toString(), edtname.getText().toString(), edtphone.getText().toString());
                reference.push().setValue(userdata);

                AppSharedPref.writeToSharedPref(SigninScreen.this, edtname.getText().toString(),
                        edtEmail.getText().toString(), edtphone.getText().toString());
                Intent intent = new Intent(SigninScreen.this, HomeScreen.class);
                startActivity(intent);
                finish();

            }
        });



    }
}