package circlrnum.flymountain.com.animationtest;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageView;

import circlrnum.flymountain.com.animationtest.util.DeviceUtil;

/**
 * 作者 yuanfei on 2016/10/25.
 * 邮箱 yuanfei221@126.com
 */

public class AnimatorSetAct extends Activity {
    ImageView img;
    Button btn1,btn2;
    DeviceUtil deviceUtil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.animator_act);
        deviceUtil = new DeviceUtil(AnimatorSetAct.this);
        img = (ImageView) findViewById(R.id.img);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(img,"alpha",1.0f,0.0f);
                ObjectAnimator objectAnimator1 = ObjectAnimator.ofFloat(img,"rotationX",0f, 180, 360f);
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.setDuration(1000);
                animatorSet.setInterpolator(new LinearInterpolator());
                /**
                 * 两个动画同事进行
                 */
                animatorSet.playTogether(objectAnimator,objectAnimator1);
                animatorSet.start();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float cx = img.getX();
                ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(img,"alpha",1.0f,0.0f);
                ObjectAnimator objectAnimator1 = ObjectAnimator.ofFloat(img,
                        "x", cx);
                ObjectAnimator objectAnimator2 = ObjectAnimator.ofFloat(img, "scaleX",
                        1.0f, 2f);
                ObjectAnimator objectAnimator3 = ObjectAnimator.ofFloat(img, "scaleY",
                        1.0f, 2f);
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.setDuration(1000);
                animatorSet.setInterpolator(new LinearInterpolator());
                /**
                 * 3个动画同事进行 objectAnimator后面执行
                 */
                animatorSet.play(objectAnimator1).with(objectAnimator2).with(objectAnimator3).after(objectAnimator);
//                animatorSet.play(objectAnimator1).with(objectAnimator);
                animatorSet.start();
            }
        });
    }
}
