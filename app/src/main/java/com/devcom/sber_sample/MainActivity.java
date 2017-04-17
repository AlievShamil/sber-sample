package com.devcom.sber_sample;

import android.animation.ValueAnimator;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;

public class MainActivity extends AppCompatActivity {

    private View mFirstAnimatorView, mSecondAnimatorView, mThirdAnimatorView;
    private ValueAnimator mAnimator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFirstAnimatorView = findViewById(R.id.first_animated_view);
        mSecondAnimatorView = findViewById(R.id.second_animated_view);
        mThirdAnimatorView = findViewById(R.id.third_animated_view);

        firstAnimView();
        secondAnimView();
        thirdAnimView();

    }

    private void firstAnimView() {
        ValueAnimator mAnimator = ValueAnimator.ofInt(0, 10000);
        mAnimator.setRepeatCount(ValueAnimator.INFINITE);
        mAnimator.setDuration(5000);
        mAnimator.setInterpolator(new LinearInterpolator());
        mAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int value = (int) animation.getAnimatedValue();
                mFirstAnimatorView.getBackground().setLevel(value);
            }
        });
        mAnimator.start();
    }

    private void secondAnimView() {
        ValueAnimator mAnimator = ValueAnimator.ofInt(0, 10000);
        mAnimator.setRepeatCount(ValueAnimator.INFINITE);
        mAnimator.setRepeatMode(ValueAnimator.REVERSE);
        mAnimator.setDuration(2000);
        mAnimator.setInterpolator(new OvershootInterpolator());
        mAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int value = (int) animation.getAnimatedValue();
                mSecondAnimatorView.getBackground().setLevel(value);
            }
        });
        mAnimator.start();
    }

    private void thirdAnimView() {
        ValueAnimator mAnimator = ValueAnimator.ofInt(0, 10000);
        mAnimator.setRepeatCount(ValueAnimator.INFINITE);
        mAnimator.setRepeatMode(ValueAnimator.REVERSE);
        mAnimator.setDuration(2000);
        mAnimator.setInterpolator(new LinearInterpolator());
        mAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int value = (int) animation.getAnimatedValue();
                mThirdAnimatorView.getBackground().setLevel(value);
            }
        });
        mAnimator.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        mAnimator.cancel();
        mAnimator.removeAllUpdateListeners();
        mAnimator = null;
    }
}
