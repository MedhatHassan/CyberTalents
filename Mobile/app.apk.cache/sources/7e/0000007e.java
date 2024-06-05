package android.support.v4.app;

import android.content.Context;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/* loaded from: classes.dex */
class NoSaveStateFrameLayout extends FrameLayout {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static ViewGroup wrap(View child) {
        NoSaveStateFrameLayout wrapper = new NoSaveStateFrameLayout(child.getContext());
        ViewGroup.LayoutParams childParams = child.getLayoutParams();
        if (childParams != null) {
            wrapper.setLayoutParams(childParams);
        }
        FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(-1, -1);
        child.setLayoutParams(lp);
        wrapper.addView(child);
        return wrapper;
    }

    public NoSaveStateFrameLayout(Context context) {
        super(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSaveInstanceState(SparseArray<Parcelable> container) {
        dispatchFreezeSelfOnly(container);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> container) {
        dispatchThawSelfOnly(container);
    }
}