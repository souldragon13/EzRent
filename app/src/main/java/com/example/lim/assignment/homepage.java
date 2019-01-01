package com.example.lim.assignment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.view.View;

public class homepage extends AppCompatActivity {
    private Button button;
    private Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        button = (Button)findViewById(R.id.HostelButton);
        button2 = (Button)findViewById(R.id.button);

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
