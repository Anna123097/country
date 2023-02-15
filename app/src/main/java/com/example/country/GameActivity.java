package com.example.country;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

public class GameActivity extends AppCompatActivity {
    Flags flags;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION |
                        View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

        getSupportActionBar().hide();

        Flags.Starter starter = new Flags.Starter() {
            @Override
            public void showEnd(int answers) {
                Intent intent = new Intent(GameActivity.this, finishActivity.class);
                intent.putExtra("answers",answers);
                startActivity(intent);
                finish();
            }
        };

        flags = new Flags(GameActivity.this, starter);
        flags.setFlags(10);
        flags.getNextFlag();

    }
}