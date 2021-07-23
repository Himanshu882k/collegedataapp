package com.example.loginpage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.ImageView;

public class login extends AppCompatActivity {
    private CardView contact_card, website_card, calender_card, profile_card, setting_card, bug_card,help_card,logout_card;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        contact_card = findViewById(R.id.contact_card);
        website_card = findViewById(R.id.website_card);
        calender_card = findViewById(R.id.calender_card);
        profile_card = findViewById(R.id.profile_card);
        setting_card = findViewById(R.id.setting_card);
        bug_card = findViewById(R.id.bug_card);
        help_card = findViewById(R.id.help_card);
        logout_card = findViewById(R.id.logout_card);

        contact_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(login.this, replacement.class);
                intent.putExtra("contact", 1);
                startActivity(intent);


            }
        });
        website_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(login.this, replacement.class);
                intent.putExtra("contact", 2);
                startActivity(intent);
            }
        });
        calender_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(login.this, replacement.class);
                intent.putExtra("contact", 3);
                startActivity(intent);
            }
        });
        profile_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(login.this, replacement.class);
                intent.putExtra("contact",4);
                startActivity(intent);
            }
        });
        setting_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(login.this, replacement.class);
                intent.putExtra("contact",5);
                startActivity(intent);

            }
        });
    }
}