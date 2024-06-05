package android.support.v7.widget;

import android.support.v7.internal.app.WindowCallback;
import android.support.v7.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

/* loaded from: classes.dex */
public class WindowCallbackWrapper implements WindowCallback {
    private WindowCallback mWrapped;

    public WindowCallbackWrapper(WindowCallback wrapped) {
        if (wrapped == null) {
            throw new IllegalArgumentException("Window callback may not be null");
        }
        this.mWrapped = wrapped;
    }

    @Override // android.support.v7.internal.app.WindowCallback
    public boolean onMenuItemSelected(int featureId, MenuItem menuItem) {
        return this.mWrapped.onMenuItemSelected(featureId, menuItem);
    }

    @Override // android.support.v7.internal.app.WindowCallback
    public boolean onCreatePanelMenu(int featureId, Menu menu) {
        return this.mWrapped.onCreatePanelMenu(featureId, menu);
    }

    @Override // android.support.v7.internal.app.WindowCallback
    public boolean onPreparePanel(int featureId, View menuView, Menu menu) {
        return this.mWrapped.onPreparePanel(featureId, menuView, menu);
    }

    @Override // android.support.v7.internal.app.WindowCallback
    public void onPanelClosed(int featureId, Menu menu) {
        this.mWrapped.onPanelClosed(featureId, menu);
    }

    @Override // android.support.v7.internal.app.WindowCallback
    public boolean onMenuOpened(int featureId, Menu menu) {
        return this.mWrapped.onMenuOpened(featureId, menu);
    }

    @Override // android.support.v7.internal.app.WindowCallback
    public ActionMode startActionMode(ActionMode.Callback callback) {
        return this.mWrapped.startActionMode(callback);
    }

    @Override // android.support.v7.internal.app.WindowCallback
    public View onCreatePanelView(int featureId) {
        return this.mWrapped.onCreatePanelView(featureId);
    }
}