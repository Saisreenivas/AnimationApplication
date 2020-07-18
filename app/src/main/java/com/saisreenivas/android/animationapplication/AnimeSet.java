package com.saisreenivas.android.animationapplication;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

public class AnimeSet extends AppCompatActivity {

    ImageButton search;
    Button cancel;
    ImageView logo_img;
    EditText editText;
    private static final int SEARCH_ANIMATION_DURATION = 1000; // 1 sec

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anime_set);

        search = findViewById(R.id.search_img);
        cancel =findViewById(R.id.cancel_btn);
        logo_img = findViewById(R.id.logo_img);
        editText = findViewById(R.id.edit_text);

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // take to leftmost position
                DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
                int modifierX = -(displayMetrics.widthPixels - search.getWidth());

                ObjectAnimator searchIconLeftAnimation = ObjectAnimator.ofFloat(search, "translationX", modifierX);
                searchIconLeftAnimation.setDuration(SEARCH_ANIMATION_DURATION);

                ObjectAnimator logoFadeOutAnimator = ObjectAnimator.ofFloat(logo_img, "alpha", 1f, 0f);
                logoFadeOutAnimator.setDuration(SEARCH_ANIMATION_DURATION);

                ObjectAnimator cancelImageFadeInAnimator = ObjectAnimator.ofFloat(cancel, "alpha", 0f, 1f);
                cancelImageFadeInAnimator.setDuration(SEARCH_ANIMATION_DURATION);

                ObjectAnimator searchEditTextAnimator = ObjectAnimator.ofFloat(editText, "alpha", 0f, 1f);
                searchEditTextAnimator.setDuration(SEARCH_ANIMATION_DURATION);

                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.play(searchIconLeftAnimation).with(logoFadeOutAnimator);
                animatorSet.play(searchIconLeftAnimation).with(cancelImageFadeInAnimator);
                animatorSet.play(searchIconLeftAnimation).with(searchEditTextAnimator);

                animatorSet.start();

                animatorSet.addListener(new Animator.AnimatorListener(){
                    @Override
                    public void onAnimationStart(Animator animator) {
                        // do anything before animation start

                    }

                    @Override
                    public void onAnimationEnd(Animator animator) {
                        // do other stuff after animation ends
                    }

                    @Override
                    public void onAnimationCancel(Animator animator) {
                        // do something when animation is cancelled (by user/
                        // developer)
                    }

                    @Override
                    public void onAnimationRepeat(Animator animator) {
                        // do something when animation is repeating
                    }
                });
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ObjectAnimator searchIconRightAnimation = ObjectAnimator.ofFloat(search, "translationX", 0);
                searchIconRightAnimation.setDuration(SEARCH_ANIMATION_DURATION);

                ObjectAnimator logoFadeInAnimator = ObjectAnimator.ofFloat(logo_img, "alpha", 0f, 1f);
                logoFadeInAnimator.setDuration(SEARCH_ANIMATION_DURATION);

                ObjectAnimator cancelImageFadeOutAnimator = ObjectAnimator.ofFloat(cancel, "alpha", 1f, 0f);
                cancelImageFadeOutAnimator.setDuration(SEARCH_ANIMATION_DURATION);

                ObjectAnimator searchEditTextFadeInAnimator = ObjectAnimator.ofFloat(editText, "alpha", 1f, 0f);
                searchEditTextFadeInAnimator.setDuration(SEARCH_ANIMATION_DURATION);

                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.play(searchIconRightAnimation).with(logoFadeInAnimator);
                animatorSet.play(searchIconRightAnimation).with(cancelImageFadeOutAnimator);
                animatorSet.play(searchIconRightAnimation).with(searchEditTextFadeInAnimator);

                animatorSet.start();
            }
        });
    }
}
