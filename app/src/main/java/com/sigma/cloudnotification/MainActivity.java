package com.sigma.cloudnotification;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;

public class MainActivity extends AppCompatActivity {

    private CheckBox sports, news, tech, entertainment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sports = findViewById(R.id.sports_Id);
        news = findViewById(R.id.news_Id);
        tech = findViewById(R.id.tech_Id);
        entertainment = findViewById(R.id.entertainment_Id);


        sports.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (sports.isChecked()){
                    FirebaseMessaging.getInstance().subscribeToTopic("sports").addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            Toast.makeText(MainActivity.this, "You are subscribed to sports", Toast.LENGTH_SHORT).show();
                        }
                    });
                } else {
                    FirebaseMessaging.getInstance().unsubscribeFromTopic("sports").addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            Toast.makeText(MainActivity.this, "You are unsubscribed to sports", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });

        news.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (news.isChecked()){
                    FirebaseMessaging.getInstance().subscribeToTopic("news").addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            Toast.makeText(MainActivity.this, "You are subscribed to news", Toast.LENGTH_SHORT).show();
                        }
                    });
                } else {
                    FirebaseMessaging.getInstance().unsubscribeFromTopic("news").addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            Toast.makeText(MainActivity.this, "You are unsubscribed to news", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });

        tech.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (tech.isChecked()){
                    FirebaseMessaging.getInstance().subscribeToTopic("tech").addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            Toast.makeText(MainActivity.this, "You are subscribed to tech", Toast.LENGTH_SHORT).show();
                        }
                    });
                } else {
                    FirebaseMessaging.getInstance().unsubscribeFromTopic("tech").addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            Toast.makeText(MainActivity.this, "You are unsubscribed to tech", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });

        entertainment.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (entertainment.isChecked()){
                    FirebaseMessaging.getInstance().subscribeToTopic("entertainment").addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            Toast.makeText(MainActivity.this, "You are subscribed to entertainment", Toast.LENGTH_SHORT).show();
                        }
                    });
                } else {
                    FirebaseMessaging.getInstance().unsubscribeFromTopic("entertainment").addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            Toast.makeText(MainActivity.this, "You are unsubscribed to entertainment", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });



    }
}