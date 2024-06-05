package android.support.v7.app;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggleHoneycomb;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

/* loaded from: classes.dex */
public class ActionBarDrawerToggle implements DrawerLayout.DrawerListener {
    private final Delegate mActivityImpl;
    private final int mCloseDrawerContentDescRes;
    private boolean mDrawerIndicatorEnabled;
    private final DrawerLayout mDrawerLayout;
    private boolean mHasCustomUpIndicator;
    private Drawable mHomeAsUpIndicator;
    private final int mOpenDrawerContentDescRes;
    private DrawerToggle mSlider;
    private View.OnClickListener mToolbarNavigationClickListener;

    /* loaded from: classes.dex */
    public interface Delegate {
        Context getActionBarThemedContext();

        Drawable getThemeUpIndicator();

        void setActionBarDescription(int i);

        void setActionBarUpIndicator(Drawable drawable, int i);
    }

    /* loaded from: classes.dex */
    public interface DelegateProvider {
        @Nullable
        Delegate getDrawerToggleDelegate();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface DrawerToggle {
        float getPosition();

        void setPosition(float f);
    }

    /* loaded from: classes.dex */
    interface TmpDelegateProvider {
        @Nullable
        Delegate getV7DrawerToggleDelegate();
    }

    public ActionBarDrawerToggle(Activity activity, DrawerLayout drawerLayout, int openDrawerContentDescRes, int closeDrawerContentDescRes) {
        this(activity, null, drawerLayout, null, openDrawerContentDescRes, closeDrawerContentDescRes);
    }

    public ActionBarDrawerToggle(Activity activity, DrawerLayout drawerLayout, Toolbar toolbar, int openDrawerContentDescRes, int closeDrawerContentDescRes) {
        this(activity, toolbar, drawerLayout, null, openDrawerContentDescRes, closeDrawerContentDescRes);
    }

    <T extends Drawable & DrawerToggle> ActionBarDrawerToggle(Activity activity, Toolbar toolbar, DrawerLayout drawerLayout, T slider, int openDrawerContentDescRes, int closeDrawerContentDescRes) {
        this.mDrawerIndicatorEnabled = true;
        if (toolbar != null) {
            this.mActivityImpl = new ToolbarCompatDelegate(toolbar);
            toolbar.setNavigationOnClickListener(new View.OnClickListener() { // from class: android.support.v7.app.ActionBarDrawerToggle.1
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    if (ActionBarDrawerToggle.this.mDrawerIndicatorEnabled) {
                        ActionBarDrawerToggle.this.toggle();
                    } else if (ActionBarDrawerToggle.this.mToolbarNavigationClickListener != null) {
                        ActionBarDrawerToggle.this.mToolbarNavigationClickListener.onClick(v);
                    }
                }
            });
        } else if (activity instanceof DelegateProvider) {
            this.mActivityImpl = ((DelegateProvider) activity).getDrawerToggleDelegate();
        } else if (activity instanceof TmpDelegateProvider) {
            this.mActivityImpl = ((TmpDelegateProvider) activity).getV7DrawerToggleDelegate();
        } else if (Build.VERSION.SDK_INT >= 18) {
            this.mActivityImpl = new JellybeanMr2Delegate(activity);
        } else if (Build.VERSION.SDK_INT >= 11) {
            this.mActivityImpl = new HoneycombDelegate(activity);
        } else {
            this.mActivityImpl = new DummyDelegate(activity);
        }
        this.mDrawerLayout = drawerLayout;
        this.mOpenDrawerContentDescRes = openDrawerContentDescRes;
        this.mCloseDrawerContentDescRes = closeDrawerContentDescRes;
        if (slider == null) {
            this.mSlider = new DrawerArrowDrawableToggle(activity, this.mActivityImpl.getActionBarThemedContext());
        } else {
            this.mSlider = slider;
        }
        this.mHomeAsUpIndicator = getThemeUpIndicator();
    }

    public void syncState() {
        if (this.mDrawerLayout.isDrawerOpen(8388611)) {
            this.mSlider.setPosition(1.0f);
        } else {
            this.mSlider.setPosition(0.0f);
        }
        if (this.mDrawerIndicatorEnabled) {
            setActionBarUpIndicator((Drawable) this.mSlider, this.mDrawerLayout.isDrawerOpen(8388611) ? this.mCloseDrawerContentDescRes : this.mOpenDrawerContentDescRes);
        }
    }

    public void onConfigurationChanged(Configuration newConfig) {
        if (!this.mHasCustomUpIndicator) {
            this.mHomeAsUpIndicator = getThemeUpIndicator();
        }
        syncState();
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item != null && item.getItemId() == 16908332 && this.mDrawerIndicatorEnabled) {
            toggle();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void toggle() {
        if (this.mDrawerLayout.isDrawerVisible(8388611)) {
            this.mDrawerLayout.closeDrawer(8388611);
        } else {
            this.mDrawerLayout.openDrawer(8388611);
        }
    }

    public void setHomeAsUpIndicator(Drawable indicator) {
        if (indicator == null) {
            this.mHomeAsUpIndicator = getThemeUpIndicator();
            this.mHasCustomUpIndicator = false;
        } else {
            this.mHomeAsUpIndicator = indicator;
            this.mHasCustomUpIndicator = true;
        }
        if (!this.mDrawerIndicatorEnabled) {
            setActionBarUpIndicator(this.mHomeAsUpIndicator, 0);
        }
    }

    public void setHomeAsUpIndicator(int resId) {
        Drawable indicator = null;
        if (resId != 0) {
            indicator = this.mDrawerLayout.getResources().getDrawable(resId);
        }
        setHomeAsUpIndicator(indicator);
    }

    public boolean isDrawerIndicatorEnabled() {
        return this.mDrawerIndicatorEnabled;
    }

    public void setDrawerIndicatorEnabled(boolean enable) {
        if (enable != this.mDrawerIndicatorEnabled) {
            if (enable) {
                setActionBarUpIndicator((Drawable) this.mSlider, this.mDrawerLayout.isDrawerOpen(8388611) ? this.mCloseDrawerContentDescRes : this.mOpenDrawerContentDescRes);
            } else {
                setActionBarUpIndicator(this.mHomeAsUpIndicator, 0);
            }
            this.mDrawerIndicatorEnabled = enable;
        }
    }

    @Override // android.support.v4.widget.DrawerLayout.DrawerListener
    public void onDrawerSlide(View drawerView, float slideOffset) {
        this.mSlider.setPosition(Math.min(1.0f, Math.max(0.0f, slideOffset)));
    }

    @Override // android.support.v4.widget.DrawerLayout.DrawerListener
    public void onDrawerOpened(View drawerView) {
        this.mSlider.setPosition(1.0f);
        if (this.mDrawerIndicatorEnabled) {
            setActionBarDescription(this.mCloseDrawerContentDescRes);
        }
    }

    @Override // android.support.v4.widget.DrawerLayout.DrawerListener
    public void onDrawerClosed(View drawerView) {
        this.mSlider.setPosition(0.0f);
        if (this.mDrawerIndicatorEnabled) {
            setActionBarDescription(this.mOpenDrawerContentDescRes);
        }
    }

    @Override // android.support.v4.widget.DrawerLayout.DrawerListener
    public void onDrawerStateChanged(int newState) {
    }

    public View.OnClickListener getToolbarNavigationClickListener() {
        return this.mToolbarNavigationClickListener;
    }

    public void setToolbarNavigationClickListener(View.OnClickListener onToolbarNavigationClickListener) {
        this.mToolbarNavigationClickListener = onToolbarNavigationClickListener;
    }

    void setActionBarUpIndicator(Drawable upDrawable, int contentDescRes) {
        this.mActivityImpl.setActionBarUpIndicator(upDrawable, contentDescRes);
    }

    void setActionBarDescription(int contentDescRes) {
        this.mActivityImpl.setActionBarDescription(contentDescRes);
    }

    Drawable getThemeUpIndicator() {
        return this.mActivityImpl.getThemeUpIndicator();
    }

    /* loaded from: classes.dex */
    static class DrawerArrowDrawableToggle extends DrawerArrowDrawable implements DrawerToggle {
        private final Activity mActivity;

        public DrawerArrowDrawableToggle(Activity activity, Context themedContext) {
            super(themedContext);
            this.mActivity = activity;
        }

        @Override // android.support.v7.app.ActionBarDrawerToggle.DrawerToggle
        public void setPosition(float position) {
            if (position == 1.0f) {
                setVerticalMirror(true);
            } else if (position == 0.0f) {
                setVerticalMirror(false);
            }
            super.setProgress(position);
        }

        @Override // android.support.v7.app.DrawerArrowDrawable
        boolean isLayoutRtl() {
            return ViewCompat.getLayoutDirection(this.mActivity.getWindow().getDecorView()) == 1;
        }

        @Override // android.support.v7.app.ActionBarDrawerToggle.DrawerToggle
        public float getPosition() {
            return super.getProgress();
        }
    }

    /* loaded from: classes.dex */
    private static class HoneycombDelegate implements Delegate {
        final Activity mActivity;
        ActionBarDrawerToggleHoneycomb.SetIndicatorInfo mSetIndicatorInfo;

        private HoneycombDelegate(Activity activity) {
            this.mActivity = activity;
        }

        @Override // android.support.v7.app.ActionBarDrawerToggle.Delegate, android.support.v4.app.ActionBarDrawerToggle.Delegate
        public Drawable getThemeUpIndicator() {
            return ActionBarDrawerToggleHoneycomb.getThemeUpIndicator(this.mActivity);
        }

        @Override // android.support.v7.app.ActionBarDrawerToggle.Delegate
        public Context getActionBarThemedContext() {
            android.app.ActionBar actionBar = this.mActivity.getActionBar();
            if (actionBar != null) {
                Context context = actionBar.getThemedContext();
                return context;
            }
            Context context2 = this.mActivity;
            return context2;
        }

        @Override // android.support.v7.app.ActionBarDrawerToggle.Delegate, android.support.v4.app.ActionBarDrawerToggle.Delegate
        public void setActionBarUpIndicator(Drawable themeImage, int contentDescRes) {
            this.mActivity.getActionBar().setDisplayShowHomeEnabled(true);
            this.mSetIndicatorInfo = ActionBarDrawerToggleHoneycomb.setActionBarUpIndicator(this.mSetIndicatorInfo, this.mActivity, themeImage, contentDescRes);
            this.mActivity.getActionBar().setDisplayShowHomeEnabled(false);
        }

        @Override // android.support.v7.app.ActionBarDrawerToggle.Delegate, android.support.v4.app.ActionBarDrawerToggle.Delegate
        public void setActionBarDescription(int contentDescRes) {
            this.mSetIndicatorInfo = ActionBarDrawerToggleHoneycomb.setActionBarDescription(this.mSetIndicatorInfo, this.mActivity, contentDescRes);
        }
    }

    /* loaded from: classes.dex */
    private static class JellybeanMr2Delegate implements Delegate {
        final Activity mActivity;

        private JellybeanMr2Delegate(Activity activity) {
            this.mActivity = activity;
        }

        @Override // android.support.v7.app.ActionBarDrawerToggle.Delegate, android.support.v4.app.ActionBarDrawerToggle.Delegate
        public Drawable getThemeUpIndicator() {
            TypedArray a = getActionBarThemedContext().obtainStyledAttributes(null, new int[]{16843531}, 16843470, 0);
            Drawable result = a.getDrawable(0);
            a.recycle();
            return result;
        }

        @Override // android.support.v7.app.ActionBarDrawerToggle.Delegate
        public Context getActionBarThemedContext() {
            android.app.ActionBar actionBar = this.mActivity.getActionBar();
            if (actionBar != null) {
                Context context = actionBar.getThemedContext();
                return context;
            }
            Context context2 = this.mActivity;
            return context2;
        }

        @Override // android.support.v7.app.ActionBarDrawerToggle.Delegate, android.support.v4.app.ActionBarDrawerToggle.Delegate
        public void setActionBarUpIndicator(Drawable drawable, int contentDescRes) {
            android.app.ActionBar actionBar = this.mActivity.getActionBar();
            if (actionBar != null) {
                actionBar.setHomeAsUpIndicator(drawable);
                actionBar.setHomeActionContentDescription(contentDescRes);
            }
        }

        @Override // android.support.v7.app.ActionBarDrawerToggle.Delegate, android.support.v4.app.ActionBarDrawerToggle.Delegate
        public void setActionBarDescription(int contentDescRes) {
            android.app.ActionBar actionBar = this.mActivity.getActionBar();
            if (actionBar != null) {
                actionBar.setHomeActionContentDescription(contentDescRes);
            }
        }
    }

    /* loaded from: classes.dex */
    static class ToolbarCompatDelegate implements Delegate {
        final Toolbar mToolbar;

        ToolbarCompatDelegate(Toolbar toolbar) {
            this.mToolbar = toolbar;
        }

        @Override // android.support.v7.app.ActionBarDrawerToggle.Delegate, android.support.v4.app.ActionBarDrawerToggle.Delegate
        public void setActionBarUpIndicator(Drawable upDrawable, int contentDescRes) {
            this.mToolbar.setNavigationIcon(upDrawable);
            this.mToolbar.setNavigationContentDescription(contentDescRes);
        }

        @Override // android.support.v7.app.ActionBarDrawerToggle.Delegate, android.support.v4.app.ActionBarDrawerToggle.Delegate
        public void setActionBarDescription(int contentDescRes) {
            this.mToolbar.setNavigationContentDescription(contentDescRes);
        }

        @Override // android.support.v7.app.ActionBarDrawerToggle.Delegate, android.support.v4.app.ActionBarDrawerToggle.Delegate
        public Drawable getThemeUpIndicator() {
            TypedArray a = this.mToolbar.getContext().obtainStyledAttributes(new int[]{16908332});
            Drawable result = a.getDrawable(0);
            a.recycle();
            return result;
        }

        @Override // android.support.v7.app.ActionBarDrawerToggle.Delegate
        public Context getActionBarThemedContext() {
            return this.mToolbar.getContext();
        }
    }

    /* loaded from: classes.dex */
    static class DummyDelegate implements Delegate {
        final Activity mActivity;

        DummyDelegate(Activity activity) {
            this.mActivity = activity;
        }

        @Override // android.support.v7.app.ActionBarDrawerToggle.Delegate, android.support.v4.app.ActionBarDrawerToggle.Delegate
        public void setActionBarUpIndicator(Drawable upDrawable, int contentDescRes) {
        }

        @Override // android.support.v7.app.ActionBarDrawerToggle.Delegate, android.support.v4.app.ActionBarDrawerToggle.Delegate
        public void setActionBarDescription(int contentDescRes) {
        }

        @Override // android.support.v7.app.ActionBarDrawerToggle.Delegate, android.support.v4.app.ActionBarDrawerToggle.Delegate
        public Drawable getThemeUpIndicator() {
            return null;
        }

        @Override // android.support.v7.app.ActionBarDrawerToggle.Delegate
        public Context getActionBarThemedContext() {
            return this.mActivity;
        }
    }
}