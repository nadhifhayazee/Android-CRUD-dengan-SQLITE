package com.example.abdullah.crudsqlite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnCreate(View v){
        Intent goCreate = new Intent(this, MainCreate.class);
        startActivity(goCreate);
    }

    public void btnRead(View v){
        Intent goRead = new Intent(this, MainRead.class);
        startActivity(goRead);
    }
}
