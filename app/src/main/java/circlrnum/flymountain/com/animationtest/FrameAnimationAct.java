package circlrnum.flymountain.com.animationtest;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.widget.ImageView;

/**
 * 作者 yuanfei on 2016/10/24.
 * 邮箱 yuanfei221@126.com
 */

public class FrameAnimationAct extends Activity {
    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frame_act);
        img = (ImageView) findViewById(R.id.img);
        /**
         * 因为当我们在onCreate中调用AnimationDrawable的start方法时，窗口Window对象还没有完全初始化，AnimationDrawable不能完全追加到窗口Window对象中
         * 需要把这段代码放在onWindowFocusChanged方法中，
         * 当Activity展示给用户时，onWindowFocusChanged方法就会被调用，
         * 我们正是在这个时候实现我们的动画效果。
         * 当然，onWindowFocusChanged是在onCreate之后被调用的
         */
//        animation.start();//这样写不行
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        AnimationDrawable  animation = (AnimationDrawable) img.getBackground();
        animation.start();
    }
}
