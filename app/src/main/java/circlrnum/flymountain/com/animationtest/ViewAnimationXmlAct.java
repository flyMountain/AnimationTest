package circlrnum.flymountain.com.animationtest;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

/**
 * 作者 yuanfei on 2016/10/24.
 * 邮箱 yuanfei221@126.com
 */

public class ViewAnimationXmlAct extends Activity {
    ImageView img;
    Button btn1,btn2,btn3,btn4,btn5,btn6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);
        btn6 = (Button) findViewById(R.id.btn6);
        img = (ImageView) findViewById(R.id.img);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Animation animation =  AnimationUtils.loadAnimation(ViewAnimationXmlAct.this,R.anim.alpha);
                animation.setFillBefore(true);
                img.startAnimation(animation);

            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation =  AnimationUtils.loadAnimation(ViewAnimationXmlAct.this,R.anim.rotate);
                animation.setFillBefore(true);
                img.startAnimation(animation);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation =  AnimationUtils.loadAnimation(ViewAnimationXmlAct.this,R.anim.scale);
                animation.setFillBefore(true);
                img.startAnimation(animation);
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AnimationSet animationSet = new AnimationSet(true);
                Animation animation =  AnimationUtils.loadAnimation(ViewAnimationXmlAct.this,R.anim.translate);
                animation.setFillBefore(true);
                img.startAnimation(animation);
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AnimationSet animationSet = new AnimationSet(true);

                Animation animation =  AnimationUtils.loadAnimation(ViewAnimationXmlAct.this,R.anim.combination);
                animation.setFillBefore(true);
                img.startAnimation(animation);
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation =  AnimationUtils.loadAnimation(ViewAnimationXmlAct.this,R.anim.show);
                animation.setFillBefore(true);
                img.startAnimation(animation);
            }
        });
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        Animation animation =  AnimationUtils.loadAnimation(ViewAnimationXmlAct.this,R.anim.hide);
        animation.setFillBefore(true);
        img.startAnimation(animation);
    }
}
