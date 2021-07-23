package com.example.loginpage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;

public class replacement extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_replacement);
        Bundle bundle =  getIntent().getExtras();
        int value = bundle.getInt("contact");
        String value2 = bundle.getString("contact");
        if (value == 1){
            replacefrag(new contactfrag());
        }
        if (value == 2){
            replacefrag(new websitefrag());
        }
        if (value == 3){
            replacefrag(new calenderfrag());
        }
        if (value == 4){
            replacefrag(new profilefrag());
        }
        //if (value == 5){
            //replacefrag(new settingfrag());
        //}




    }
    private void replacefrag(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.framelayout,fragment);
        fragmentTransaction.commit();

    }
}