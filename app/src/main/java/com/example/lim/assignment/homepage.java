package com.example.lim.assignment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.view.View;
import android.widget.ImageButton;

public class homepage extends AppCompatActivity {
    private ImageButton FindBtn;
    private ImageButton PostBtn;
    private ImageButton NotificationBtn;
    private ImageButton ProfileBtn;
    private ImageButton LikeBtn;
    private ImageButton HelpBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);



        public void goToFind(View view) {
            Intent intent = new Intent(this, Find.class);
            startActivity(intent);
        }
        /*
         FindBtn = findViewById(R.id.bt_find);
         PostBtn = findViewById(R.id.bt_post);
         NotificationBtn = findViewById(R.id.bt_notification);
         ProfileBtn = findViewById(R.id.bt_profile);
         LikeBtn= findViewById(R.id.bt_like);
         HelpBtn = findViewById(R.id.bt_help);

        FindBtn.setOnClickListener(this);
        PostBtn.setOnClickListener(this);
        NotificationBtn.setOnClickListener(this);
        ProfileBtn.setOnClickListener(this);
        LikeBtn.setOnClickListener(this);
        HelpBtn.setOnClickListener(this);


        public void goToFind() {
            Intent intent = new Intent(this, Find.class);
            startActivity(intent);
        }
        */
        /*
       // FindBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()){
                    case R.id.FindBtn:
                        Intent intent1 = new Intent(this, AnActivity.class);
                        startActivity(intent1);
                        break;
                    case R.id.button2:
                        Intent intent2 = new Intent(this, AnotherActivity.class);
                        startActivity(intent2);
                        break;
                    default:
                        break;
                    Intent intent = new Intent(this, Find.class);
                    startActivity(intent);
                }
            }); */

    /*
       // button = (Button)findViewById(R.id.bt_post);
       // button2 = (Button)findViewById(R.id.bt_help);

        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Post();
            }
        });
        button.setOnClickListener(new View.OnClickListener(){
            @Override
                    public void onClick(View v){
                     Hostel();
            }
        });

    */
    /* example of buttons to another activity
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.main_activity);

            button1 = (Button) findViewById(R.id.button1);
            button2 = (Button) findViewById(R.id.button2);
            button1.setOnClickListener(this);
            button2.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.button1:
                    Intent intent1 = new Intent(this, AnActivity.class);
                    startActivity(intent1);
                    break;
                case R.id.button2:
                    Intent intent2 = new Intent(this, AnotherActivity.class);
                    startActivity(intent2);
                    break;
                default:
                    break;
            }*/
    }
    public void Post(){
        Intent intent = new Intent(this,Post.class);
        startActivity(intent);
    }
    public void Hostel(){
      Intent intent = new Intent(this,Hostel.class);
      startActivity(intent);
    }
   /* Button yourButton = (Button) findViewById(R.id.button5);

  yourButton.setOnClickListener(new OnClickListener(){
        public void onClick(View view){
            startActivity(new Intent(homepage.this, Hostel.class));
        }
    });*/
}
