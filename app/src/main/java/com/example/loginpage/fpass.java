package com.example.loginpage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import org.jetbrains.annotations.NotNull;

public class fpass extends AppCompatActivity {
    private EditText useremail;
    private Button reset;
    private FirebaseAuth Fauth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fpass);
        useremail = findViewById(R.id.useremail);
        reset = findViewById(R.id.reset);


        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = useremail.getText().toString();
                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(fpass.this, "Enter your registered Email ID", Toast.LENGTH_SHORT).show();
                    return;
                }
                else{
               Auth(email);
            }
            }
        });
    }
    public void Auth(String mail){
        Fauth = FirebaseAuth.getInstance();
        Fauth.sendPasswordResetEmail(mail)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(fpass.this, "Send successfully", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(fpass.this,MainActivity.class));
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull @NotNull Exception e) {
                Toast.makeText(fpass.this,"Something went wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }
}