package android.support.v7.app;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.appcompat.R;
import android.support.v7.internal.app.WindowCallback;
import android.support.v7.internal.view.SupportMenuInflater;
import android.support.v7.view.ActionMode;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class ActionBarActivityDelegate {
    static final String METADATA_UI_OPTIONS = "android.support.UI_OPTIONS";
    private static final String TAG = "ActionBarActivityDelegate";
    private ActionBar mActionBar;
    final ActionBarActivity mActivity;
    boolean mHasActionBar;
    private boolean mIsDestroyed;
    boolean mIsFloating;
    private MenuInflater mMenuInflater;
    boolean mOverlayActionBar;
    boolean mOverlayActionMode;
    final WindowCallback mDefaultWindowCallback = new WindowCallback() { // from class: android.support.v7.app.ActionBarActivityDelegate.1
        @Override // android.support.v7.internal.app.WindowCallback
        public boolean onMenuItemSelected(int featureId, MenuItem menuItem) {
            return ActionBarActivityDelegate.this.mActivity.onMenuItemSelected(featureId, menuItem);
        }

        @Override // android.support.v7.internal.app.WindowCallback
        public boolean onCreatePanelMenu(int featureId, Menu menu) {
            return ActionBarActivityDelegate.this.mActivity.superOnCreatePanelMenu(featureId, menu);
        }

        @Override // android.support.v7.internal.app.WindowCallback
        public boolean onPreparePanel(int featureId, View menuView, Menu menu) {
            return ActionBarActivityDelegate.this.mActivity.superOnPreparePanel(featureId, menuView, menu);
        }

        @Override // android.support.v7.internal.app.WindowCallback
        public void onPanelClosed(int featureId, Menu menu) {
            ActionBarActivityDelegate.this.mActivity.onPanelClosed(featureId, menu);
        }

        @Override // android.support.v7.internal.app.WindowCallback
        public boolean onMenuOpened(int featureId, Menu menu) {
            return ActionBarActivityDelegate.this.mActivity.onMenuOpened(featureId, menu);
        }

        @Override // android.support.v7.internal.app.WindowCallback
        public ActionMode startActionMode(ActionMode.Callback callback) {
            return ActionBarActivityDelegate.this.startSupportActionModeFromWindow(callback);
        }

        @Override // android.support.v7.internal.app.WindowCallback
        public View onCreatePanelView(int featureId) {
            return null;
        }
    };
    private WindowCallback mWindowCallback = this.mDefaultWindowCallback;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void addContentView(View view, ViewGroup.LayoutParams layoutParams);

    abstract ActionBar createSupportActionBar();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract View createView(String str, @NonNull Context context, @NonNull AttributeSet attributeSet);

    abstract int getHomeAsUpIndicatorAttrId();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean onBackPressed();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void onConfigurationChanged(Configuration configuration);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void onContentChanged();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean onCreatePanelMenu(int i, Menu menu);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract View onCreatePanelView(int i);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean onKeyShortcut(int i, KeyEvent keyEvent);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean onMenuOpened(int i, Menu menu);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void onPanelClosed(int i, Menu menu);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void onPostResume();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean onPreparePanel(int i, View view, Menu menu);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void onStop();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void onTitleChanged(CharSequence charSequence);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void setContentView(int i);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void setContentView(View view);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void setContentView(View view, ViewGroup.LayoutParams layoutParams);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void setSupportActionBar(Toolbar toolbar);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void setSupportProgress(int i);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void setSupportProgressBarIndeterminate(boolean z);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void setSupportProgressBarIndeterminateVisibility(boolean z);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void setSupportProgressBarVisibility(boolean z);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract ActionMode startSupportActionMode(ActionMode.Callback callback);

    abstract ActionMode startSupportActionModeFromWindow(ActionMode.Callback callback);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void supportInvalidateOptionsMenu();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean supportRequestWindowFeature(int i);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ActionBarActivityDelegate createDelegate(ActionBarActivity activity) {
        return Build.VERSION.SDK_INT >= 11 ? new ActionBarActivityDelegateHC(activity) : new ActionBarActivityDelegateBase(activity);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ActionBarActivityDelegate(ActionBarActivity activity) {
        this.mActivity = activity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final ActionBar getSupportActionBar() {
        if (this.mHasActionBar && this.mActionBar == null) {
            this.mActionBar = createSupportActionBar();
        }
        return this.mActionBar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final ActionBar peekSupportActionBar() {
        return this.mActionBar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void setSupportActionBar(ActionBar actionBar) {
        this.mActionBar = actionBar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MenuInflater getMenuInflater() {
        if (this.mMenuInflater == null) {
            this.mMenuInflater = new SupportMenuInflater(getActionBarThemedContext());
        }
        return this.mMenuInflater;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onCreate(Bundle savedInstanceState) {
        TypedArray a = this.mActivity.obtainStyledAttributes(R.styleable.Theme);
        if (!a.hasValue(R.styleable.Theme_windowActionBar)) {
            a.recycle();
            throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
        }
        if (a.getBoolean(R.styleable.Theme_windowActionBar, false)) {
            this.mHasActionBar = true;
        }
        if (a.getBoolean(R.styleable.Theme_windowActionBarOverlay, false)) {
            this.mOverlayActionBar = true;
        }
        if (a.getBoolean(R.styleable.Theme_windowActionModeOverlay, false)) {
            this.mOverlayActionMode = true;
        }
        this.mIsFloating = a.getBoolean(R.styleable.Theme_android_windowIsFloating, false);
        a.recycle();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean onPrepareOptionsPanel(View view, Menu menu) {
        return Build.VERSION.SDK_INT < 16 ? this.mActivity.onPrepareOptionsMenu(menu) : this.mActivity.superOnPrepareOptionsPanel(view, menu);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final ActionBarDrawerToggle.Delegate getDrawerToggleDelegate() {
        return new ActionBarDrawableToggleImpl();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final ActionBarDrawerToggle.Delegate getV7DrawerToggleDelegate() {
        return new ActionBarDrawableToggleImpl();
    }

    final String getUiOptionsFromMetadata() {
        try {
            PackageManager pm = this.mActivity.getPackageManager();
            ActivityInfo info = pm.getActivityInfo(this.mActivity.getComponentName(), 128);
            if (info.metaData == null) {
                return null;
            }
            String uiOptions = info.metaData.getString(METADATA_UI_OPTIONS);
            return uiOptions;
        } catch (PackageManager.NameNotFoundException e) {
            Log.e(TAG, "getUiOptionsFromMetadata: Activity '" + this.mActivity.getClass().getSimpleName() + "' not in manifest");
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Context getActionBarThemedContext() {
        Context context = null;
        ActionBar ab = getSupportActionBar();
        if (ab != null) {
            context = ab.getThemedContext();
        }
        if (context == null) {
            Context context2 = this.mActivity;
            return context2;
        }
        return context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class ActionBarDrawableToggleImpl implements ActionBarDrawerToggle.Delegate, ActionBarDrawerToggle.Delegate {
        private ActionBarDrawableToggleImpl() {
        }

        @Override // android.support.v7.app.ActionBarDrawerToggle.Delegate, android.support.v4.app.ActionBarDrawerToggle.Delegate
        public Drawable getThemeUpIndicator() {
            TypedArray a = ActionBarActivityDelegate.this.getActionBarThemedContext().obtainStyledAttributes(new int[]{ActionBarActivityDelegate.this.getHomeAsUpIndicatorAttrId()});
            Drawable result = a.getDrawable(0);
            a.recycle();
            return result;
        }

        @Override // android.support.v7.app.ActionBarDrawerToggle.Delegate
        public Context getActionBarThemedContext() {
            return ActionBarActivityDelegate.this.getActionBarThemedContext();
        }

        @Override // android.support.v7.app.ActionBarDrawerToggle.Delegate, android.support.v4.app.ActionBarDrawerToggle.Delegate
        public void setActionBarUpIndicator(Drawable upDrawable, int contentDescRes) {
            ActionBar ab = ActionBarActivityDelegate.this.getSupportActionBar();
            if (ab != null) {
                ab.setHomeAsUpIndicator(upDrawable);
                ab.setHomeActionContentDescription(contentDescRes);
            }
        }

        @Override // android.support.v7.app.ActionBarDrawerToggle.Delegate, android.support.v4.app.ActionBarDrawerToggle.Delegate
        public void setActionBarDescription(int contentDescRes) {
            ActionBar ab = ActionBarActivityDelegate.this.getSupportActionBar();
            if (ab != null) {
                ab.setHomeActionContentDescription(contentDescRes);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void setWindowCallback(WindowCallback callback) {
        if (callback == null) {
            throw new IllegalArgumentException("callback can not be null");
        }
        this.mWindowCallback = callback;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final WindowCallback getWindowCallback() {
        return this.mWindowCallback;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void destroy() {
        this.mIsDestroyed = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean isDestroyed() {
        return this.mIsDestroyed;
    }
}