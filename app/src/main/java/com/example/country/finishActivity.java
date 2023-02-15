package com.example.country;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

public class finishActivity extends AppCompatActivity implements View.OnClickListener{
    ImageView number;

    ImageView btn_exit;
    ImageView btn_again;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish);

        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION |
                        View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

        getSupportActionBar().hide();

        number = findViewById(R.id.imageView9);
        btn_exit = findViewById(R.id.imageView10);
        btn_again = findViewById(R.id.imageView11);

        btn_again.setOnClickListener(this);
        btn_exit.setOnClickListener(this);

        Intent intent = getIntent();
        int a = intent.getIntExtra("answers", 0);

        switch (a){
            case 0: number.setImageResource(R.drawable.num0); break;
            case 1: number.setImageResource(R.drawable.num1); break;
            case 2: number.setImageResource(R.drawable.num2); break;
            case 3: number.setImageResource(R.drawable.num3); break;
            case 4: number.setImageResource(R.drawable.num4); break;
            case 5: number.setImageResource(R.drawable.num5); break;
            case 6: number.setImageResource(R.drawable.num6); break;
            case 7: number.setImageResource(R.drawable.num7); break;
            case 8: number.setImageResource(R.drawable.num8); break;
            case 9: number.setImageResource(R.drawable.num9); break;
            case 10: number.setImageResource(R.drawable.num10); break;
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.imageView10:
                finish();
                break;
            case R.id.imageView11:
                Intent intent = new Intent(finishActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
                break;
        }
    }
}