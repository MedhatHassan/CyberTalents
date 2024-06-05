package android.support.v7.app;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.NavUtils;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.view.ActionMode;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes.dex */
public class ActionBarActivity extends FragmentActivity implements ActionBar.Callback, TaskStackBuilder.SupportParentable, ActionBarDrawerToggle.DelegateProvider, ActionBarDrawerToggle.TmpDelegateProvider {
    private ActionBarActivityDelegate mDelegate;

    public ActionBar getSupportActionBar() {
        return getDelegate().getSupportActionBar();
    }

    public void setSupportActionBar(@Nullable Toolbar toolbar) {
        getDelegate().setSupportActionBar(toolbar);
    }

    @Override // android.app.Activity
    public MenuInflater getMenuInflater() {
        return getDelegate().getMenuInflater();
    }

    @Override // android.app.Activity
    public void setContentView(int layoutResID) {
        getDelegate().setContentView(layoutResID);
    }

    @Override // android.app.Activity
    public void setContentView(View view) {
        getDelegate().setContentView(view);
    }

    @Override // android.app.Activity
    public void setContentView(View view, ViewGroup.LayoutParams params) {
        getDelegate().setContentView(view, params);
    }

    @Override // android.app.Activity
    public void addContentView(View view, ViewGroup.LayoutParams params) {
        getDelegate().addContentView(view, params);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getDelegate().onCreate(savedInstanceState);
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        getDelegate().onConfigurationChanged(newConfig);
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        super.onStop();
        getDelegate().onStop();
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onPostResume() {
        super.onPostResume();
        getDelegate().onPostResume();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public View onCreatePanelView(int featureId) {
        return featureId == 0 ? getDelegate().onCreatePanelView(featureId) : super.onCreatePanelView(featureId);
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity, android.view.Window.Callback
    public final boolean onMenuItemSelected(int featureId, MenuItem item) {
        if (super.onMenuItemSelected(featureId, item)) {
            return true;
        }
        ActionBar ab = getSupportActionBar();
        if (item.getItemId() == 16908332 && ab != null && (ab.getDisplayOptions() & 4) != 0) {
            return onSupportNavigateUp();
        }
        return false;
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        getDelegate().destroy();
    }

    @Override // android.app.Activity
    protected void onTitleChanged(CharSequence title, int color) {
        super.onTitleChanged(title, color);
        getDelegate().onTitleChanged(title);
    }

    public boolean supportRequestWindowFeature(int featureId) {
        return getDelegate().supportRequestWindowFeature(featureId);
    }

    @Override // android.support.v4.app.FragmentActivity
    public void supportInvalidateOptionsMenu() {
        getDelegate().supportInvalidateOptionsMenu();
    }

    @Override // android.app.Activity
    public void invalidateOptionsMenu() {
        getDelegate().supportInvalidateOptionsMenu();
    }

    public void onSupportActionModeStarted(ActionMode mode) {
    }

    public void onSupportActionModeFinished(ActionMode mode) {
    }

    public ActionMode startSupportActionMode(ActionMode.Callback callback) {
        return getDelegate().startSupportActionMode(callback);
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity, android.view.Window.Callback
    public boolean onCreatePanelMenu(int featureId, Menu menu) {
        return getDelegate().onCreatePanelMenu(featureId, menu);
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity, android.view.Window.Callback
    public boolean onPreparePanel(int featureId, View view, Menu menu) {
        return getDelegate().onPreparePanel(featureId, view, menu);
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int featureId, Menu menu) {
        getDelegate().onPanelClosed(featureId, menu);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuOpened(int featureId, Menu menu) {
        return getDelegate().onMenuOpened(featureId, menu);
    }

    @Override // android.support.v4.app.FragmentActivity
    protected boolean onPrepareOptionsPanel(View view, Menu menu) {
        return getDelegate().onPrepareOptionsPanel(view, menu);
    }

    void superSetContentView(int resId) {
        super.setContentView(resId);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void superSetContentView(View v) {
        super.setContentView(v);
    }

    void superSetContentView(View v, ViewGroup.LayoutParams lp) {
        super.setContentView(v, lp);
    }

    void superAddContentView(View v, ViewGroup.LayoutParams lp) {
        super.addContentView(v, lp);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean superOnCreatePanelMenu(int featureId, Menu frameworkMenu) {
        return super.onCreatePanelMenu(featureId, frameworkMenu);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean superOnPreparePanel(int featureId, View view, Menu menu) {
        return super.onPreparePanel(featureId, view, menu);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean superOnPrepareOptionsPanel(View view, Menu menu) {
        return super.onPrepareOptionsPanel(view, menu);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void superOnPanelClosed(int featureId, Menu menu) {
        super.onPanelClosed(featureId, menu);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean superOnMenuOpened(int featureId, Menu menu) {
        return super.onMenuOpened(featureId, menu);
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        if (!getDelegate().onBackPressed()) {
            super.onBackPressed();
        }
    }

    public void setSupportProgressBarVisibility(boolean visible) {
        getDelegate().setSupportProgressBarVisibility(visible);
    }

    public void setSupportProgressBarIndeterminateVisibility(boolean visible) {
        getDelegate().setSupportProgressBarIndeterminateVisibility(visible);
    }

    public void setSupportProgressBarIndeterminate(boolean indeterminate) {
        getDelegate().setSupportProgressBarIndeterminate(indeterminate);
    }

    public void setSupportProgress(int progress) {
        getDelegate().setSupportProgress(progress);
    }

    public void onCreateSupportNavigateUpTaskStack(TaskStackBuilder builder) {
        builder.addParentStack(this);
    }

    public void onPrepareSupportNavigateUpTaskStack(TaskStackBuilder builder) {
    }

    public boolean onSupportNavigateUp() {
        Intent upIntent = getSupportParentActivityIntent();
        if (upIntent != null) {
            if (supportShouldUpRecreateTask(upIntent)) {
                TaskStackBuilder b = TaskStackBuilder.create(this);
                onCreateSupportNavigateUpTaskStack(b);
                onPrepareSupportNavigateUpTaskStack(b);
                b.startActivities();
                try {
                    ActivityCompat.finishAffinity(this);
                } catch (IllegalStateException e) {
                    finish();
                }
            } else {
                supportNavigateUpTo(upIntent);
            }
            return true;
        }
        return false;
    }

    @Override // android.support.v4.app.TaskStackBuilder.SupportParentable
    public Intent getSupportParentActivityIntent() {
        return NavUtils.getParentActivityIntent(this);
    }

    public boolean supportShouldUpRecreateTask(Intent targetIntent) {
        return NavUtils.shouldUpRecreateTask(this, targetIntent);
    }

    public void supportNavigateUpTo(Intent upIntent) {
        NavUtils.navigateUpTo(this, upIntent);
    }

    @Override // android.support.v4.app.ActionBarDrawerToggle.DelegateProvider
    public final ActionBarDrawerToggle.Delegate getDrawerToggleDelegate() {
        return getDelegate().getDrawerToggleDelegate();
    }

    @Override // android.support.v7.app.ActionBarDrawerToggle.TmpDelegateProvider
    @Nullable
    public ActionBarDrawerToggle.Delegate getV7DrawerToggleDelegate() {
        return getDelegate().getV7DrawerToggleDelegate();
    }

    @Override // android.app.Activity
    public boolean onKeyShortcut(int keyCode, KeyEvent event) {
        return getDelegate().onKeyShortcut(keyCode, event);
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (super.onKeyDown(keyCode, event)) {
            return true;
        }
        return getDelegate().onKeyDown(keyCode, event);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public final void onContentChanged() {
        getDelegate().onContentChanged();
    }

    public void onSupportContentChanged() {
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity, android.view.LayoutInflater.Factory
    public View onCreateView(String name, @NonNull Context context, @NonNull AttributeSet attrs) {
        View result = super.onCreateView(name, context, attrs);
        return result != null ? result : getDelegate().createView(name, context, attrs);
    }

    private ActionBarActivityDelegate getDelegate() {
        if (this.mDelegate == null) {
            this.mDelegate = ActionBarActivityDelegate.createDelegate(this);
        }
        return this.mDelegate;
    }
}