package com.saisreenivas.android.animationapplication;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class ValueAnimation extends Activity {

    Button animeBtn;
    RadioGroup process,testingType,widthOptions;
    RadioButton radioBtn;
    EditText duration,repetition;
    EditText customOptions1, customOptions2;

    Button testObject_1;
    TextView testObject_2;
    int startWidth, endWidth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_value_animation);

        animeBtn = findViewById(R.id.v_anime_btn);
        process = findViewById(R.id.wanna_do);
        duration = findViewById(R.id.duration);
        repetition = findViewById(R.id.repetition);
        testingType = findViewById(R.id.testing_type);
        widthOptions = findViewById(R.id.width_options);
        customOptions1 = findViewById(R.id.custom_options_start);
        customOptions2 = findViewById(R.id.custom_options_end);

        int selectedTesting = testingType.getCheckedRadioButtonId();
        final RadioButton selectedRB = findViewById(selectedTesting);


        int selectedOptions = widthOptions.getCheckedRadioButtonId();
        final LinearLayout customOptions = findViewById(R.id.custom_options);
        final RadioButton selectedO = findViewById(selectedOptions);

        widthOptions.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedID) {
                if(checkedID == R.id.width_options_2){
                    customOptions.setVisibility(View.VISIBLE);
                }else {
                    customOptions.setVisibility(View.GONE);
                }
            }
        });

        animeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ValueAnimator valAnime = null;
                int selectedProcess = process.getCheckedRadioButtonId();
                radioBtn = (RadioButton) findViewById(selectedProcess);

                int selectedTesting = testingType.getCheckedRadioButtonId();
                final RadioButton selectedRB = findViewById(selectedTesting);
                int selectedOptions = widthOptions.getCheckedRadioButtonId();
                final LinearLayout customOptions = findViewById(R.id.custom_options);
                final RadioButton selectedO = findViewById(selectedOptions);


                if( radioBtn.getId() == R.id.changeProp){

                    if(selectedRB.getId() == R.id.button){
                        final Button testObject = findViewById(R.id.test_obj_1);
                        int startWidth, endWidth;
                        if(selectedO.getId() == R.id.width_options_1) {
                            startWidth = testObject.getWidth();
                            endWidth = ((View) testObject.getParent()).getMeasuredWidth();
                        }else{
                            startWidth = Integer.parseInt(customOptions1.getText().toString());
                            endWidth = Integer.parseInt(customOptions2.getText().toString());
                        }
                        valAnime = ValueAnimator.ofInt(
                                startWidth, endWidth);
                        valAnime.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                            @Override
                            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                                int animatedValue = (int) valueAnimator.getAnimatedValue();
                                testObject.getLayoutParams().width = animatedValue;
                                testObject.requestLayout();
                            }
                        });
                    }else
//                        if(selectedRB.getId() == R.id.testview)
                        {
                        final TextView testObject = findViewById(R.id.test_obj_2);
                        int startWidth, endWidth;
                        if(selectedO.getId() == R.id.width_options_1) {
                            startWidth = testObject.getWidth();
                            endWidth = ((View) testObject.getParent()).getMeasuredWidth();
                        }else{
                            startWidth = Integer.parseInt(customOptions1.getText().toString());
                            endWidth = Integer.parseInt(customOptions2.getText().toString());
                        }
                        valAnime = ValueAnimator.ofInt(
                                startWidth, endWidth);
                        valAnime.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                            @Override
                            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                                int animatedValue = (int) valueAnimator.getAnimatedValue();
                                testObject.getLayoutParams().width = animatedValue;
                                testObject.requestLayout();
                            }
                        });
                    }
//                    ValueAnimator valAnime = ValueAnimator.ofInt(10,500);
//                    ValueAnimator valAnime = ValueAnimator.ofInt(
//                            startWidth, endWidth);

                    valAnime.setDuration(Long.parseLong(duration.getText().toString()));
                    valAnime.setRepeatCount(Integer.parseInt(repetition.getText().toString()));

                    valAnime.start();

                }else {
                    Toast.makeText(getApplicationContext(), radioBtn.getText() , Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    public void reset_button(View view) {
        Toast.makeText(getApplicationContext(), "Not working yet", Toast.LENGTH_SHORT).show();
    }
}
