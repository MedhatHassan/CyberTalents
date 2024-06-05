package android.support.v7.internal.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.View;

@TargetApi(11)
/* loaded from: classes.dex */
public class NativeActionModeAwareLayout extends ContentFrameLayout {
    private OnActionModeForChildListener mActionModeForChildListener;

    /* loaded from: classes.dex */
    public interface OnActionModeForChildListener {
        ActionMode startActionModeForChild(View view, ActionMode.Callback callback);
    }

    public NativeActionModeAwareLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setActionModeForChildListener(OnActionModeForChildListener listener) {
        this.mActionModeForChildListener = listener;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public ActionMode startActionModeForChild(View originalView, ActionMode.Callback callback) {
        return this.mActionModeForChildListener != null ? this.mActionModeForChildListener.startActionModeForChild(originalView, callback) : super.startActionModeForChild(originalView, callback);
    }
}