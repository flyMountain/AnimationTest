package circlrnum.flymountain.com.animationtest;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;

/**
 * 作者 yuanfei on 2016/10/25.
 * 邮箱 yuanfei221@126.com
 */

public class JavaAnimationAct extends Activity {
    ImageView img;
    Button btn1,btn2,btn3,btn4,btn5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);
        img = (ImageView) findViewById(R.id.img);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AnimationSet animationSet = new AnimationSet(true);
                AlphaAnimation alphaAnimation = new AlphaAnimation(1,0);
                animationSet.setDuration(100);
                animationSet.addAnimation(alphaAnimation);

                img.startAnimation(animationSet);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AnimationSet animationSet = new AnimationSet(true);
                /**
                 * 参数1： 从哪个角度开始旋转
                 * 参数2： 转到什么角度
                 * 后面四个参数是关于圆心位置的设置
                 * 参数3：x轴的坐标类型 ABSOLUTE 绝对坐标 RELATIVE_TO_SELF相对于自身的坐标 RELATIVE_TO_PARENT相对于父控件的坐标
                 *
                 */
                RotateAnimation rotateAnimation = new RotateAnimation(0,360, Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
                animationSet.setDuration(1000);
                AccelerateInterpolator accelerateInterpolator = new AccelerateInterpolator();
                animationSet.addAnimation(rotateAnimation);
                img.startAnimation(animationSet);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AnimationSet animationSet = new AnimationSet(true);
                /**
                 * 参数1 x轴的初始值
                 * 参数2 x轴收缩都的值
                 * 参数3 y轴的初始值
                 * 参数4 y轴收缩的值
                 */
                ScaleAnimation scaleAnimation = new ScaleAnimation(0,0.5f,0,0.5f,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
                animationSet.addAnimation(scaleAnimation);
                animationSet.setDuration(2000);
                img.startAnimation(animationSet);
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AnimationSet animationSet = new AnimationSet(true);
                /**
                 * 参数1 2 x轴开始的位置
                 * 参数3 4 y轴开始的位置
                 * 参数5 6 x轴结束的位置
                 * 参数7 8 y轴结束的位置
                 */
                TranslateAnimation translateAnimation = new TranslateAnimation(Animation.RELATIVE_TO_SELF,0,Animation.RELATIVE_TO_SELF,0,Animation.RELATIVE_TO_SELF,0,Animation.RELATIVE_TO_SELF,1);
                animationSet.addAnimation(translateAnimation);
                animationSet.setDuration(2000);
                img.startAnimation(animationSet);
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AnimationSet animationSet = new AnimationSet(true);
                RotateAnimation rotateAnimation = new RotateAnimation(0,360, Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
                TranslateAnimation translateAnimation = new TranslateAnimation(Animation.RELATIVE_TO_SELF,0,Animation.RELATIVE_TO_SELF,0,Animation.RELATIVE_TO_SELF,0,Animation.RELATIVE_TO_SELF,2);
                animationSet.addAnimation(translateAnimation);
                animationSet.addAnimation(rotateAnimation);
                animationSet.setDuration(2000);
                img.startAnimation(animationSet);
            }
        });
    }
}
