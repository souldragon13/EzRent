package com.example.lim.assignment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Find extends AppCompatActivity {
    private Button MoreDetail,MoreDetail2,MoreDetail3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find);

        MoreDetail =(Button)findViewById(R.id.more_detail);
        MoreDetail2 =(Button)findViewById(R.id.more_detail2);
        MoreDetail3 =(Button)findViewById(R.id.more_detail3);

        MoreDetail.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(Find.this, Find_Details.class));
                }
        });
                 MoreDetail2.setOnClickListener(new View.OnClickListener() {
                  @Override
                  public void onClick(View v) {
                   startActivity(new Intent(Find.this, Find_Details.class));
                  }
                 });
                           MoreDetail3.setOnClickListener(new View.OnClickListener() {
                           @Override
                           public void onClick(View v) {
                           startActivity(new Intent(Find.this, Find_Details.class));
                           }
                           });
    }
}
