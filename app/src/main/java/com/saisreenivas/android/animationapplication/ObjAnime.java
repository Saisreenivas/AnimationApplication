package com.saisreenivas.android.animationapplication;

import android.animation.AnimatorInflater;
import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.TextView;

public class ObjAnime extends AppCompatActivity {

    Button playBtn;
    TextView txtView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_obj_anime);

        playBtn = findViewById(R.id.playbtn);
        txtView = findViewById(R.id.test_element);

        playBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ObjectAnimator objectAnimator =
                        ObjectAnimator.ofFloat(txtView, "translationY", 0f, 500f);
                objectAnimator.setDuration(2000);
                objectAnimator.setInterpolator(new LinearInterpolator());
                objectAnimator.start();
            }
        });


    }
}
