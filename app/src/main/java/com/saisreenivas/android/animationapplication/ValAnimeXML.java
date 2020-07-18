package com.saisreenivas.android.animationapplication;

import android.animation.AnimatorInflater;
import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ValAnimeXML extends AppCompatActivity {

    Button play;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_val_anime_xml);

        play = findViewById(R.id.btn);
        textView = findViewById(R.id.textView);

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ValueAnimator valueAnimator =
                        (ValueAnimator) AnimatorInflater.loadAnimator(
                                getApplicationContext(), R.animator.val_anime
                        );
                valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        float progress = (float) valueAnimator.getAnimatedValue();
                        textView.setTranslationY(progress);
                    }
                });

                valueAnimator.start();
            }
        });

    }
}
