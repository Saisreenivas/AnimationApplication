package com.saisreenivas.android.animationapplication;

import android.animation.AnimatorInflater;
import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ObjAnimeXML extends AppCompatActivity {

    Button playBtn;
    TextView txtView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_obj_anime_xml);

        playBtn = findViewById(R.id.play_btn);
        txtView = findViewById(R.id.testing);

        playBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ObjectAnimator objectAnimator = (ObjectAnimator) AnimatorInflater.loadAnimator(
                        getApplicationContext(), R.animator.obj_anime
                );
                objectAnimator.setTarget(txtView);
                objectAnimator.start();
            }
        });
    }
}
