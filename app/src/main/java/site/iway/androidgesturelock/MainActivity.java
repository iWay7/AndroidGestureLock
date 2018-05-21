package site.iway.androidgesturelock;

import android.app.Activity;
import android.os.Bundle;

import java.util.Random;

import site.iway.androidhelpers.GestureLock;
import site.iway.androidhelpers.GestureLock.GestureLockListener;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GestureLock gestureLock = findViewById(R.id.gestureLock);
        gestureLock.setListener(new GestureLockListener() {
            @Override
            public void onGestureLockBegin() {
                // 手势开始时回调
            }

            @Override
            public void onGesturePointAdded(int[] ints) {
                // 有新的点加入时回调
            }

            @Override
            public boolean onGestureLockFinish(int[] ints) {
                // 返回一个布尔值表示结果正确与否
                return new Random(System.nanoTime()).nextBoolean();
            }
        });
    }


}
