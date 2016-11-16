package circlrnum.flymountain.com.animationtest;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.Button;

/**
 * 作者 yuanfei on 2016/11/16.
 * 邮箱 yuanfei221@126.com
 */

public class ButtonAct extends Activity {
    Button btn,btn1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_button);
        btn = (Button) findViewById(R.id.btn);
        btn1 = (Button) findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setBtnObject1();
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setBtn1();
            }
        });
    }
    public void setBtnObject(){
        ObjectAnimator.ofInt(btn,"width",500).setDuration(500).start();
    }
    public void setBtnObject1(){
        AnimationSet animationSet = new AnimationSet(true);
        ScaleAnimation scaleAnimation = new ScaleAnimation(1f,1.5f,1f,1f, Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        animationSet.setFillAfter(true);
        animationSet.addAnimation(scaleAnimation);
        animationSet.setDuration(2000);
        btn1.startAnimation(animationSet);

    }
    public void setBtn1(){
        ViewProject viewProject = new ViewProject(btn);
        ObjectAnimator.ofInt(viewProject,"width",500).setDuration(3000).start();
    }
    public void setbtn2(final View view){
        ValueAnimator valueAnimator = ValueAnimator.ofInt(0,1);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int index = (int) animation.getAnimatedValue();
                view.getLayoutParams().width = index * 100 + 100;
                view.requestLayout();
            }
        });
    }
    class ViewProject{
        private View view;
        public ViewProject(View view){
            this.view = view;
        }
        public void setWidth(int width){
            view.getLayoutParams().width = width;
            view.requestLayout();
        }
        public int getWidth(){
            return view.getLayoutParams().width;
        }
    }
}
