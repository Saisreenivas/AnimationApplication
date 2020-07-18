package com.saisreenivas.android.animationapplication;

import android.animation.ValueAnimator;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ValueAnimator widthAnimator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView textView = findViewById(R.id.textView);

        int duration = 4000; //in millis

        widthAnimator = ValueAnimator.ofFloat(0f, 1000f);

        widthAnimator.setDuration(duration);

        widthAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float animatedValue = (float) animation.getAnimatedValue();
                textView.setTranslationX(animatedValue);
//                textView.getLayoutParams().width = animatedValue;
//                textView.requestLayout();
            }
        });

        widthAnimator.setRepeatCount(5);


    }


    public void animation(View view) {

    }

    public void valueanimation(View view) {
        startActivity(new Intent(MainActivity.this, ValueAnimation.class));
    }

    public void valueanimation_fab(View view) {
        startActivity(new Intent(MainActivity.this, ValueAnimationFAB.class));
    }

    public void valueanimation_border(View view) {
        startActivity(new Intent(MainActivity.this, ValueAnimationBorder.class));
    }

    public void val_anime(View view) {
        startActivity(new Intent(MainActivity.this, ValAnimeXML.class));
    }

    public void obj_anime(View view) {
        startActivity(new Intent(MainActivity.this, ObjAnime.class));
    }

    public void obj_anime_xml(View view){
        startActivity(new Intent(MainActivity.this, ObjAnimeXML.class));
    }

    public void anime_set(View view) {
        startActivity(new Intent( MainActivity.this, AnimeSet.class));
    }

    public void multianime_on_one_view(View view) {
        startActivity(new Intent(MainActivity.this, MultiAnimeOneView.class));
    }
}
