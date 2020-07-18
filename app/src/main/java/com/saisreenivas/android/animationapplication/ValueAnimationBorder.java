package com.saisreenivas.android.animationapplication;

import android.animation.AnimatorSet;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;

public class ValueAnimationBorder extends AppCompatActivity {

    View top, left, bottom, right;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_value_animation_border);

        top = findViewById(R.id.border_top);
        left= findViewById(R.id.border_left);
        bottom = findViewById(R.id.border_bottom);
        right = findViewById(R.id.border_right);
    }

    public void border_anime(View view) {
        if(top.getLayoutParams().width == ViewGroup.LayoutParams.MATCH_PARENT){


//            AnimatorSet animatorSet = new AnimatorSet();
//            animatorSet.play(top);
//            animatorSet.play(left).after(top);

        }else{

        }
    }
}
