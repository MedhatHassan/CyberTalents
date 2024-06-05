package android.support.v7.internal.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.v7.appcompat.R;
import android.util.AttributeSet;
import android.view.View;
import android.widget.PopupWindow;

/* loaded from: classes.dex */
public class AppCompatPopupWindow extends PopupWindow {
    private final boolean mOverlapAnchor;

    public AppCompatPopupWindow(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TintTypedArray a = TintTypedArray.obtainStyledAttributes(context, attrs, R.styleable.PopupWindow, defStyleAttr, 0);
        this.mOverlapAnchor = a.getBoolean(R.styleable.PopupWindow_overlapAnchor, false);
        setBackgroundDrawable(a.getDrawable(R.styleable.PopupWindow_android_popupBackground));
        a.recycle();
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View anchor, int xoff, int yoff) {
        if (Build.VERSION.SDK_INT < 21 && this.mOverlapAnchor) {
            yoff -= anchor.getHeight();
        }
        super.showAsDropDown(anchor, xoff, yoff);
    }

    @Override // android.widget.PopupWindow
    @TargetApi(19)
    public void showAsDropDown(View anchor, int xoff, int yoff, int gravity) {
        if (Build.VERSION.SDK_INT < 21 && this.mOverlapAnchor) {
            yoff -= anchor.getHeight();
        }
        super.showAsDropDown(anchor, xoff, yoff, gravity);
    }

    @Override // android.widget.PopupWindow
    public void update(View anchor, int xoff, int yoff, int width, int height) {
        if (Build.VERSION.SDK_INT < 21 && this.mOverlapAnchor) {
            yoff -= anchor.getHeight();
        }
        super.update(anchor, xoff, yoff, width, height);
    }
}