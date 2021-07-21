package com.example.loginpage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;

import org.jetbrains.annotations.NotNull;

import java.net.PasswordAuthentication;
import java.util.HashMap;
import java.util.Map;

public class sigupactivity extends AppCompatActivity {
    private EditText name, mail, pass ,phone, id;
    private Spinner branch;
    private Button Submit;
    private FirebaseAuth mAuth;
    private FirebaseFirestore Fstore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sigupactivity);
        name = findViewById(R.id.name);
        mail = findViewById(R.id.mail);
        pass = findViewById(R.id.pass);
        phone = findViewById(R.id.Phone);
        id = findViewById(R.id.id);
        branch = findViewById(R.id.branch);
        Submit = findViewById(R.id.register);



        String[] stream = new String[]{"engineering", "BSC.IT", "BSC.CS", "BMS"};
        ArrayAdapter<String> Branch = new ArrayAdapter<String>(sigupactivity.this, android.R.layout.simple_spinner_dropdown_item, stream);
        Branch.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        branch.setAdapter(Branch);

        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = name.getText().toString();
                String email = mail.getText().toString();
                String Password = pass.getText().toString();
                String Phone = phone.getText().toString();
                String ID = id.getText().toString();
                String BRANCH = branch.getSelectedItem().toString();

                if (TextUtils.isEmpty(username)) {
                    name.setError("name can't be empty");
                }
                if (TextUtils.isEmpty(email)) {
                    mail.setError("mail can't be empty");
                }
                if (TextUtils.isEmpty(Password)) {
                    pass.setError("password can't be empty");
                }
                if (TextUtils.isEmpty(Phone)) {
                    phone.setError("phonenumber can't be empty");
                }
                if (TextUtils.isEmpty(ID)) {
                    id.setError("ID can't be empty");
                }
                if (phone.length() != 10 ){
                    phone.setError("Phone number can't exceed 10 digits");
                }
                else {
                    Register(username,email,Password,Phone,ID,BRANCH);
                }



            }
        });
    }

        public void Register (String u, String e, String P, String Ph, String I, String B){
            mAuth = FirebaseAuth.getInstance();
            Fstore = FirebaseFirestore.getInstance();
            mAuth.createUserWithEmailAndPassword(e , P).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                @Override
                public void onSuccess(AuthResult authResult) {
                    Map<String, Object> user= new HashMap<>();
                    user.put("Name", u);
                    user.put("emial", e);
                    user.put("password", P);
                    user.put("phone",  Ph);
                    user.put("ID", I);
                    user.put("Branch", B);
                    Fstore.collection("College_data").document(I).set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void unused) {
                            startActivity(new Intent(sigupactivity.this, MainActivity.class));
                            finish();

                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull @NotNull Exception e) {
                            Toast.makeText(sigupactivity.this, "Reistration Failed",Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull @NotNull Exception e) {
                    Toast.makeText(sigupactivity.this, "error",Toast.LENGTH_SHORT).show();
                }
            });


        }

}

