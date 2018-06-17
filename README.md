# AndroidGestureLock
Android 手势锁。支持错误指示。

### 本应用的示例

![image](https://github.com/iWay7/AndroidGestureLock/blob/master/sample.gif)   

### 本示例基于 AndroidHelpers 库，访问 https://github.com/iWay7/AndroidHelpers 添加依赖。

#### 开始使用：
#####  准备正常图片资源，示例用 xml 配置：
```
<?xml version="1.0" encoding="utf-8"?>
<shape
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:shape="oval">

    <size
        android:width="17dp"
        android:height="17dp" />

    <solid android:color="#e7e7e7" />

</shape>
```

#####  准备选中图片资源，示例用 xml 配置：
```
<?xml version="1.0" encoding="utf-8"?>
<layer-list
    xmlns:android="http://schemas.android.com/apk/res/android">
    <item>
        <shape android:shape="oval">
            <size
                android:width="43dp"
                android:height="43dp" />
            <solid android:color="#f8f2e8" />
        </shape>
    </item>
    <item
        android:bottom="13dp"
        android:left="13dp"
        android:right="13dp"
        android:top="13dp">
        <shape android:shape="oval">
            <solid android:color="#bea473" />
        </shape>
    </item>
</layer-list>
```

#####  准备错误图片资源，示例用 xml 配置：
```
<?xml version="1.0" encoding="utf-8"?>
<layer-list
    xmlns:android="http://schemas.android.com/apk/res/android">
    <item>
        <shape android:shape="oval">
            <size
                android:width="43dp"
                android:height="43dp" />
            <solid android:color="#ffe4e3" />
        </shape>
    </item>
    <item
        android:bottom="13dp"
        android:left="13dp"
        android:right="13dp"
        android:top="13dp">
        <shape android:shape="oval">
            <solid android:color="#e93b39" />
        </shape>
    </item>
</layer-list>
```

##### 在布局文件中声明一个 GestureLock 视图：
```
<site.iway.androidhelpers.GestureLock
    android:id="@+id/gestureLock"
    android:layout_width="282dp"
    android:layout_height="282dp"
    android:layout_gravity="center"
    app:errorDrawable="@drawable/icon_gesture_error"
    app:normalDrawable="@drawable/icon_gesture_normal"
    app:routeColorError="#e93b39"
    app:routeColorSelected="#bea473"
    app:routeShrink="21.5dp"
    app:routeWidth="2dp"
    app:selectedDrawable="@drawable/icon_gesture_selected"
    app:touchDetectRadius="21.5dp" />
```

##### 给这个 GestureLock 设置回调方法：
```
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
```

##### 属性说明：
```
app:errorDrawable 指定错误状态的 Drawable
app:normalDrawable 指定正常状态的 Drawable
app:routeColorError 指定错误状态的线颜色
app:routeColorSelected 指定选中状态的线颜色
app:routeShrink 指定线的两端跟 Drawable 圆心的距离，通常为 Drawable 半径
app:routeWidth 指定线宽
app:selectedDrawable 指定选中状态的 Drawable
app:touchDetectRadius 指定触摸感知半径，通常为 Drawable 半径
```
