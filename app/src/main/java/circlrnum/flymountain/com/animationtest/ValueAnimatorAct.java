package circlrnum.flymountain.com.animationtest;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.graphics.PointF;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageView;

import circlrnum.flymountain.com.animationtest.util.DeviceUtil;

/**
 * 作者 yuanfei on 2016/10/25.
 * 邮箱 yuanfei221@126.com
 */

public class ValueAnimatorAct extends Activity {
    ImageView img;
    DeviceUtil deviceUtil;
    Button btn,btn1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.value_act);
        deviceUtil = new DeviceUtil(ValueAnimatorAct.this);
        btn = (Button) findViewById(R.id.btn);
        btn1 = (Button) findViewById(R.id.btn1);
        img = (ImageView) findViewById(R.id.img);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ValueAnimator valueAnimator = ValueAnimator.ofFloat(0, deviceUtil.getHeight() - img.getHeight());
                valueAnimator.setTarget(img);
                valueAnimator.setDuration(1000).start();
                valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
                {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation)
                    {
                        img.setTranslationY((Float) animation.getAnimatedValue());
                    }
                });
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ValueAnimator valueAnimator = new ValueAnimator();
                valueAnimator.setDuration(1000);
                valueAnimator.setObjectValues(0,1);
                valueAnimator.setTarget(img);
                valueAnimator.setObjectValues(new PointF(0, 0));
                valueAnimator.setInterpolator(new LinearInterpolator());
                valueAnimator.setEvaluator(new TypeEvaluator() {
                    @Override
                    public Object evaluate(float fraction, Object startValue, Object endValue) {
                        // x方向200px/s ，则y方向0.5 * 10 * t
                        PointF point = new PointF();
                        point.x = 200 * fraction * 3;
                        point.y = 0.5f * 200 * (fraction * 3) * (fraction * 3);
                        Log.e("PointF","X: "+point.x+"   Y:"+point.y);
                        return point;
                    }
                });
                valueAnimator.start();
                valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
                {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation)
                    {
                        PointF point = (PointF) animation.getAnimatedValue();
//                        float point = (float) animation.getAnimatedValue();
//                        Log.e("animation",200 * point * 3+"           "+0.5f * 200 * (point * 3) * (point * 3));
                        img.setX(point.x);
                        img.setY(point.y);
                        Log.e("PointF","point: "+point.x+"     "+point.y);

                    }
                });
            }
        });
        /**
         * 动画监听
         */
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(img,"alpha",1.0f,0.0f);
                objectAnimator.addListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {
                        Log.e("animation","开始");
                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                        Log.e("animation","结束");
                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {
                        Log.e("animation","取消");
                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {
                        Log.e("animation","重置");
                    }
                });
                objectAnimator.start();
            }
        });
    }
}
