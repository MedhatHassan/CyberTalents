package android.support.v7.app;

import android.annotation.TargetApi;
import android.content.Context;
import android.support.v7.internal.view.SupportActionModeWrapper;
import android.support.v7.internal.widget.NativeActionModeAwareLayout;
import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.View;

/* JADX INFO: Access modifiers changed from: package-private */
@TargetApi(11)
/* loaded from: classes.dex */
public class ActionBarActivityDelegateHC extends ActionBarActivityDelegateBase implements NativeActionModeAwareLayout.OnActionModeForChildListener {
    private NativeActionModeAwareLayout mNativeActionModeAwareLayout;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ActionBarActivityDelegateHC(ActionBarActivity activity) {
        super(activity);
    }

    @Override // android.support.v7.app.ActionBarActivityDelegateBase
    void onSubDecorInstalled() {
        this.mNativeActionModeAwareLayout = (NativeActionModeAwareLayout) this.mActivity.findViewById(16908290);
        if (this.mNativeActionModeAwareLayout != null) {
            this.mNativeActionModeAwareLayout.setActionModeForChildListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // android.support.v7.app.ActionBarActivityDelegateBase, android.support.v7.app.ActionBarActivityDelegate
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        return false;
    }

    @Override // android.support.v7.internal.widget.NativeActionModeAwareLayout.OnActionModeForChildListener
    public ActionMode startActionModeForChild(View originalView, ActionMode.Callback callback) {
        Context context = originalView.getContext();
        android.support.v7.view.ActionMode supportActionMode = startSupportActionMode(new SupportActionModeWrapper.CallbackWrapper(context, callback));
        if (supportActionMode != null) {
            return new SupportActionModeWrapper(this.mActivity, supportActionMode);
        }
        return null;
    }
}