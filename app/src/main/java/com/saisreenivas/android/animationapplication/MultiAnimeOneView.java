package com.saisreenivas.android.animationapplication;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MultiAnimeOneView extends AppCompatActivity {

    Button playBtn;
    TextView testingArea;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_anime_one_view);

        playBtn = findViewById(R.id.play_btn);
        testingArea = findViewById(R.id.testing_view);

        playBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //ViewPropertyAnimator
                testingArea.animate().rotation(360f).y(500f).setDuration(2000);



//                ObjectAnimator rotationAnimator = ObjectAnimator.ofFloat(testingArea, "rotation", 360f);
//                rotationAnimator.setDuration(2000);
//                ObjectAnimator translateAnimator = ObjectAnimator.ofFloat(testingArea, "translationY", 500f);
//                translateAnimator.setDuration(2000);
//                AnimatorSet set  = new AnimatorSet();
//                set.playTogether(rotationAnimator,translateAnimator);
//                set.start();
            }
        });
    }
}
