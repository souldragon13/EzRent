package com.example.lim.assignment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.ImageButton;

public class Homepage extends AppCompatActivity {
    private ImageButton Find,Post,Notification,Profile,Likes,Help;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        Find = (ImageButton)findViewById(R.id.bt_find);
        Post = (ImageButton)findViewById(R.id.bt_post);
        Notification = (ImageButton)findViewById(R.id.bt_notification);
        Profile = (ImageButton)findViewById(R.id.bt_profile);
        Likes = (ImageButton)findViewById(R.id.bt_like);
        Help = (ImageButton)findViewById(R.id.bt_help);

        Find.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(Homepage.this, Find.class));
            }
        });
        Post.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(Homepage.this, Post.class));
            }
        });
        Notification.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(Homepage.this, Notification.class));
            }
        });
        Profile.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(Homepage.this, Profile.class));
            }
        });
        Likes.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(Homepage.this, like.class));
            }
        });
        Help.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(Homepage.this, Help.class));
            }
        });
    }

}
