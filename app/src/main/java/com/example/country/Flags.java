package com.example.country;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Flags implements View.OnClickListener{

    interface Starter{
        void showEnd(int ansvers);
    }
    Starter starter;
    Activity activity;
    ImageView imageFlag, button1, button2, button3, button4, imageAnswer;
    int usedFlag[];
    int curFlag;
    int rightAnswers;
    int idx;
    int table[] = new int[4];
    int[] names = new int[]{
            R.drawable.b_egypt,
            R.drawable.b_france,
            R.drawable.b_india,
            R.drawable.b_romania,
            R.drawable.b_spain,
            R.drawable.b_tunisia,
            R.drawable.b_turkey,
            R.drawable.b_ukraine,
            R.drawable.b_usa,
            R.drawable.b_vietnam,
            R.drawable.b_australia,
            R.drawable.b_russia,
            R.drawable.b_england,
            R.drawable.b_bulgaria,
            R.drawable.b_albania,
            R.drawable.b_belaruse,

    };
    int[] id_names = new int[]{
            R.drawable.egypt,
            R.drawable.france,
            R.drawable.india,
            R.drawable.romania,
            R.drawable.spain,
            R.drawable.tunisia,
            R.drawable.tunisia,
            R.drawable.ukraine,
            R.drawable.usa,
            R.drawable.vietnam,
            R.drawable.australia,
            R.drawable.russia,
            R.drawable.russia,
            R.drawable.england,
            R.drawable.bulgaria,
            R.drawable.albania,
            R.drawable.belaluse
    };

    public Flags(Activity activity, Starter starter){
        this.starter = starter;
        this.activity = activity;
        imageFlag = activity.findViewById(R.id.imageFlag);
        button1 = activity.findViewById(R.id.imageAnswer1);
        button2 = activity.findViewById(R.id.imageAnswer2);
        button3 = activity.findViewById(R.id.imageAnswer3);
        button4 = activity.findViewById(R.id.imageAnswer4);
        imageAnswer = activity.findViewById(R.id.imageAnswer);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
    }

    public void setFlags(int n){
        int[] width = new int[names.length];
        usedFlag = new int[n];
        for(int i = 0; i != n;){
            int random_number1 = (int) (Math.random() * n);
            if(width[random_number1] ==  1) continue;
            width[random_number1] = 1;
            usedFlag[i] = random_number1;
            i++;
        }
        curFlag = 0;
        rightAnswers = 0;
        imageAnswer.setImageResource(R.drawable.num0);
    }

    public void getNextFlag(){
        idx = usedFlag[curFlag];
        table[1] = table[2] = table[3] = 0;
        table[0] = idx;
        for(int i = 1; i!=4;){
            int id = (int) (Math.random() * usedFlag.length);
            boolean inTrue = true;
            for(int g = 0; g!=i;g++)
                if(table[g] == id){
                    inTrue = false;
                    break;
                }
            if (inTrue){
               table[i] = id;
               i++;
            }
        }
        Random rnd = ThreadLocalRandom.current();
        for (int i = table.length - 1; i > 0; i--)
        {
            int index = rnd.nextInt(i + 1);

            int a = table[index];
            table[index] = table[i];
            table[i] = a;
        }
        imageFlag.setImageResource(id_names[idx]);
        button1.setImageResource(names[table[0]]);
        button2.setImageResource(names[table[1]]);
        button3.setImageResource(names[table[2]]);
        button4.setImageResource(names[table[3]]);

        Animation animation = AnimationUtils.loadAnimation(activity, R.anim.lefttoright);
        imageFlag.startAnimation(animation);
    }


    @Override
    public void onClick(View view) {
        boolean is_true = false;

        switch (view.getId()){
            case R.id.imageAnswer1:
                if(idx == table[0]) is_true = true;
                break;

            case R.id.imageAnswer2:
                if(idx == table[1]) is_true = true;
                break;

            case R.id.imageAnswer3:
                if(idx == table[2]) is_true = true;
                break;

            case R.id.imageAnswer4:
                if(idx == table[3]) is_true = true;
                break;
        }

        if(is_true){
            rightAnswers++;
            switch (rightAnswers){
                case 1:  imageAnswer.setImageResource(R.drawable.num1); break;
                case 2:  imageAnswer.setImageResource(R.drawable.num2); break;
                case 3:  imageAnswer.setImageResource(R.drawable.num3); break;
                case 4:  imageAnswer.setImageResource(R.drawable.num4); break;
                case 5:  imageAnswer.setImageResource(R.drawable.num5); break;
                case 6:  imageAnswer.setImageResource(R.drawable.num6); break;
                case 7:  imageAnswer.setImageResource(R.drawable.num7); break;
                case 8:  imageAnswer.setImageResource(R.drawable.num8); break;
                case 9:  imageAnswer.setImageResource(R.drawable.num9); break;
                case 10: imageAnswer.setImageResource(R.drawable.num10); break;
            }
            Animation animation= AnimationUtils.loadAnimation(activity,R.anim.bounce);
            imageAnswer.startAnimation(animation);
        }

        curFlag++;
        if (curFlag == 10){
            starter.showEnd(rightAnswers);

        }
        else getNextFlag();

    }
}
