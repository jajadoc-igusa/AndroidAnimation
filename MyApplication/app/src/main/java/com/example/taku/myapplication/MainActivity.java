package com.example.taku.myapplication;

import android.graphics.Path;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.BounceInterpolator;
import android.view.animation.OvershootInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

public class MainActivity extends AppCompatActivity {

    boolean mIsReserved = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ImageView image = (ImageView) findViewById(R.id.image);
        assert image != null;

        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                final ScaleAnimation anim = new ScaleAnimation(
                        1.0f,
                        1.7f,
                        1.0f,
                        1.7f,
                        Animation.RELATIVE_TO_SELF,
                        0.5f,
                        Animation.RELATIVE_TO_SELF,
                        0.5f
                );

                final ScaleAnimation anim2 = new ScaleAnimation(
                        1.0f,
                        0.6f,
                        1.0f,
                        0.6f,
                        Animation.RELATIVE_TO_SELF,
                        0.5f,
                        Animation.RELATIVE_TO_SELF,
                        0.5f
                );

                final ScaleAnimation anim3 = new ScaleAnimation(
                        1.0f,
                        1.3f,
                        1.0f,
                        1.3f,
                        Animation.RELATIVE_TO_SELF,
                        0.5f,
                        Animation.RELATIVE_TO_SELF,
                        0.5f
                );

                anim.setDuration(200);
                anim2.setDuration(200);
                anim2.setStartOffset(200);
                anim2.setFillEnabled(true);
                anim2.setFillAfter(true);
                anim2.setFillBefore(false);

                anim3.setDuration(200);

                //anim2.setInterpolator(new BounceInterpolator());
                anim2.setInterpolator(new OvershootInterpolator());

                AnimationSet set = new AnimationSet(false);
                set.addAnimation(anim);
                set.addAnimation(anim2);
                //set.addAnimation(anim3);
                v.startAnimation(set);
                */
                ImageView imageView = (ImageView) v;

                int imageId;
                if (mIsReserved) {
                    imageId = R.drawable.ic_notifications_black_24dp;
                } else {
                    imageId = R.drawable.ic_notifications_blue_24dp;
                    Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.touch_bell);
                    v.startAnimation(animation);

                }
                imageView.setImageResource(imageId);
                mIsReserved = !mIsReserved;
            }
        });

        ViewSwitcher viewSwitcher = (ViewSwitcher) findViewById(R.id.switcher);
        assert viewSwitcher != null;
        viewSwitcher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ViewSwitcher switcher = (ViewSwitcher) v;

                Animation animation;
                if (switcher.getDisplayedChild() == 0) {
                    animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.touch_bell);
                    switcher.setInAnimation(animation);
                    switcher.showNext();
                } else {
                    animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.fadein);
                    switcher.setInAnimation(animation);
                    switcher.showPrevious();
                }
            }
        });

    }
}
