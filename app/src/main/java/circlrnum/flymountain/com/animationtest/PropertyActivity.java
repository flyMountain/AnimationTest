package circlrnum.flymountain.com.animationtest;

import android.animation.AnimatorSet;
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

/**
 * 作者 yuanfei on 2016/10/24.
 * 邮箱 yuanfei221@126.com
 */

public class PropertyActivity extends Activity {
    ImageView img;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.property_act);
        img = (ImageView) findViewById(R.id.img);
        btn = (Button) findViewById(R.id.btn);
//        img.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                ObjectAnimator.ofFloat(img,"rotationY",0.0F,360F).setDuration(1000).start();
//                ObjectAnimator anim = ObjectAnimator//
//                        .ofFloat(img, "yuan", 1.0F,  0.0F)//
//                        .setDuration(500);//
//                anim.setRepeatCount(5);
//                anim.start();
//                /**
//                 * 将侦听器添加到在动画的生命周期中发送更新事件的侦听器集合。
//                 * 在计算动画的值之后，在动画的每个帧的所有侦听器上调用此方法。
//                 * 监听每一帧的变化  其中cVal 范围是 1-0之间变化
//                 */
//                anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//                    @Override
//                    public void onAnimationUpdate(ValueAnimator animation) {
//                        float cVal = (Float) animation.getAnimatedValue();
//                        Log.e("cVal",cVal+"");
//                        img.setAlpha(cVal);
//                        img.setScaleX(cVal);
//                        img.setScaleY(cVal);
//                    }
//                });
//
//            }
//        });
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAnimations();
//                PropertyValuesHolder pvhX = PropertyValuesHolder.ofFloat("alpha", 1f,
//                        0f, 1f);
//                PropertyValuesHolder pvhY = PropertyValuesHolder.ofFloat("scaleX", 1f,
//                        0, 1f);
//                PropertyValuesHolder pvhZ = PropertyValuesHolder.ofFloat("scaleY", 1f,
//                        0, 1f);
//                ObjectAnimator.ofPropertyValuesHolder(img, pvhX, pvhY,pvhZ).setDuration(1000).setDuration(1000).setRepeatMode();
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ValueAnimator valueAnimator = new ValueAnimator();
                valueAnimator.setDuration(3000);
                valueAnimator.setObjectValues(new PointF(0,0));
                valueAnimator.setInterpolator(new LinearInterpolator());
                valueAnimator.setEvaluator(new TypeEvaluator() {
                    @Override
                    public Object evaluate(float fraction, Object startValue, Object endValue) {
                        Log.e("fraction", fraction  + "");
                        // x方向200px/s ，则y方向0.5 * 10 * t
                        PointF point = new PointF();
                        point.x = 200 * fraction * 3;
                        point.y = 0.5f * 200 * (fraction * 3) * (fraction * 3);
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
                        img.setX(point.x);
                        img.setY(point.y);

                    }
                });
            }
        });
    }
    public void setAnimations(){
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(
                ObjectAnimator.ofFloat(this,"backgroundColor",0x00ff00,0xff0000),
                ObjectAnimator.ofFloat(img,"alpha",1f,0f,1f),
                ObjectAnimator.ofFloat(img,"scaleX",1f,0f,1f)
        );
        animatorSet.start();
    }
}
