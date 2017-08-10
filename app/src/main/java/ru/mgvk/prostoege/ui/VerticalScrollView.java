package ru.mgvk.prostoege.ui;

import android.content.Context;
import android.support.v4.widget.NestedScrollView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import ru.mgvk.prostoege.MainActivity;

/**
 * Created by mihail on 12.09.16.
 */
public class VerticalScrollView extends NestedScrollView {
    boolean scrollEnabled = true;

    public VerticalScrollView(Context context) {
        super(context);
    }

    public VerticalScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public VerticalScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public boolean isScrollEnabled() {
        return scrollEnabled;
    }

    public void setScrollEnabled(boolean scrollEnabled) {
        this.scrollEnabled = scrollEnabled;
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            ((MainActivity) getContext()).ui.mainScroll.setScrollEnabled(false);
        }
        if (ev.getAction() == MotionEvent.ACTION_UP) {
            ((MainActivity) getContext()).ui.mainScroll.setScrollEnabled(true);
        }
        return isScrollEnabled() && super.onTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return isScrollEnabled() && super.onInterceptTouchEvent(ev);
    }
}
