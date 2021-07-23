package com.example.loginpage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.SignInButton;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.SignInMethodQueryResult;

public class    MainActivity extends AppCompatActivity {
    private FirebaseAuth Mauth;
    private EditText email, password;
    private Button login;
    private TextView signup;
    private TextView forgotpass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        login = findViewById(R.id.login);
        Mauth = FirebaseAuth.getInstance();
        forgotpass = findViewById(R.id.fpass);
        signup = findViewById(R.id.sin);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = email.getText().toString();
                String Password = password.getText().toString();

                if(TextUtils.isEmpty(username)) {
                    email.setError("Enter mail");
                }
                else if( TextUtils.isEmpty(Password)){
                    password.setError("Enter password");
                }
                else{
                Login(username, Password);}
            }

        });
        signup.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,sigupactivity.class));
            }
        });
        forgotpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,fpass.class));
            }
        });
    }
        public void Login(String a, String b){
            Mauth.signInWithEmailAndPassword(a, b).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull @org.jetbrains.annotations.NotNull Exception e) {
                    Toast.makeText(MainActivity.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();

                }
            }).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                @Override
                public void onSuccess(AuthResult authResult) {
                    Toast.makeText(MainActivity.this, "Welcome", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(MainActivity.this,login.class));
                }
            });

        }

    }
