package com.example.ticktacktoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity
    {

    @Override
    protected void onCreate(Bundle savedInstanceState)
        {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        }

    public void newGameClick(View v)
        {
        Intent intent = new Intent(this, MainGame.class);
        startActivity(intent);
        }
    }