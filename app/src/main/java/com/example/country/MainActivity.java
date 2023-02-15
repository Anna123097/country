package com.example.country;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    ImageView btnPlay;
    ImageView btnRules;
    ImageView btnExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION |
                        View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        getSupportActionBar().hide();

        btnPlay = findViewById(R.id.imagePlay);
        btnRules = findViewById(R.id.imageRules);
        btnExit = findViewById(R.id.imageExit);

        btnExit.setOnClickListener(this);
        btnRules.setOnClickListener(this);
        btnPlay.setOnClickListener(this);



    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.imagePlay:
                Intent intentGame = new Intent(MainActivity.this, GameActivity.class);
                startActivity(intentGame);
                finish();
                break;
            case R.id.imageRules:
                Intent intentRules = new Intent(MainActivity.this, RulesActivity.class);
                startActivity(intentRules);
                finish();
                break;

            case R.id.imageExit:
                finish();
                break;
        }
    }
}