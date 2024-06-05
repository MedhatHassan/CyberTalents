package android.support.v7.app;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.v4.app.NavUtils;
import android.support.v4.view.OnApplyWindowInsetsListener;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewConfigurationCompat;
import android.support.v4.view.WindowInsetsCompat;
import android.support.v7.appcompat.R;
import android.support.v7.internal.app.ToolbarActionBar;
import android.support.v7.internal.app.WindowCallback;
import android.support.v7.internal.app.WindowDecorActionBar;
import android.support.v7.internal.view.StandaloneActionMode;
import android.support.v7.internal.view.menu.ListMenuPresenter;
import android.support.v7.internal.view.menu.MenuBuilder;
import android.support.v7.internal.view.menu.MenuPresenter;
import android.support.v7.internal.view.menu.MenuView;
import android.support.v7.internal.widget.ActionBarContextView;
import android.support.v7.internal.widget.DecorContentParent;
import android.support.v7.internal.widget.FitWindowsViewGroup;
import android.support.v7.internal.widget.TintCheckBox;
import android.support.v7.internal.widget.TintCheckedTextView;
import android.support.v7.internal.widget.TintEditText;
import android.support.v7.internal.widget.TintRadioButton;
import android.support.v7.internal.widget.TintSpinner;
import android.support.v7.internal.widget.ViewStubCompat;
import android.support.v7.internal.widget.ViewUtils;
import android.support.v7.view.ActionMode;
import android.support.v7.widget.Toolbar;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.PopupWindow;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ActionBarActivityDelegateBase extends ActionBarActivityDelegate implements MenuBuilder.Callback {
    private static final String TAG = "ActionBarActivityDelegateBase";
    private ActionMenuPresenterCallback mActionMenuPresenterCallback;
    ActionMode mActionMode;
    PopupWindow mActionModePopup;
    ActionBarContextView mActionModeView;
    private boolean mClosingActionMenu;
    private DecorContentParent mDecorContentParent;
    private boolean mEnableDefaultActionBarUp;
    private boolean mFeatureIndeterminateProgress;
    private boolean mFeatureProgress;
    private int mInvalidatePanelMenuFeatures;
    private boolean mInvalidatePanelMenuPosted;
    private final Runnable mInvalidatePanelMenuRunnable;
    private PanelMenuPresenterCallback mPanelMenuPresenterCallback;
    private PanelFeatureState[] mPanels;
    private PanelFeatureState mPreparedPanel;
    Runnable mShowActionModePopup;
    private View mStatusGuard;
    private ViewGroup mSubDecor;
    private boolean mSubDecorInstalled;
    private Rect mTempRect1;
    private Rect mTempRect2;
    private CharSequence mTitleToSet;
    private ListMenuPresenter mToolbarListMenuPresenter;
    private ViewGroup mWindowDecor;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ActionBarActivityDelegateBase(ActionBarActivity activity) {
        super(activity);
        this.mInvalidatePanelMenuRunnable = new Runnable() { // from class: android.support.v7.app.ActionBarActivityDelegateBase.1
            @Override // java.lang.Runnable
            public void run() {
                if ((ActionBarActivityDelegateBase.this.mInvalidatePanelMenuFeatures & 1) != 0) {
                    ActionBarActivityDelegateBase.this.doInvalidatePanelMenu(0);
                }
                if ((ActionBarActivityDelegateBase.this.mInvalidatePanelMenuFeatures & 256) != 0) {
                    ActionBarActivityDelegateBase.this.doInvalidatePanelMenu(8);
                }
                ActionBarActivityDelegateBase.this.mInvalidatePanelMenuPosted = false;
                ActionBarActivityDelegateBase.this.mInvalidatePanelMenuFeatures = 0;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // android.support.v7.app.ActionBarActivityDelegate
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.mWindowDecor = (ViewGroup) this.mActivity.getWindow().getDecorView();
        if (NavUtils.getParentActivityName(this.mActivity) != null) {
            ActionBar ab = peekSupportActionBar();
            if (ab == null) {
                this.mEnableDefaultActionBarUp = true;
            } else {
                ab.setDefaultDisplayHomeAsUpEnabled(true);
            }
        }
    }

    @Override // android.support.v7.app.ActionBarActivityDelegate
    public ActionBar createSupportActionBar() {
        ensureSubDecor();
        ActionBar ab = new WindowDecorActionBar(this.mActivity, this.mOverlayActionBar);
        ab.setDefaultDisplayHomeAsUpEnabled(this.mEnableDefaultActionBarUp);
        return ab;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // android.support.v7.app.ActionBarActivityDelegate
    public void setSupportActionBar(Toolbar toolbar) {
        ActionBar ab = getSupportActionBar();
        if (ab instanceof WindowDecorActionBar) {
            throw new IllegalStateException("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
        }
        if (ab instanceof ToolbarActionBar) {
            ((ToolbarActionBar) ab).setListMenuPresenter(null);
        }
        ToolbarActionBar tbab = new ToolbarActionBar(toolbar, this.mActivity.getTitle(), this.mActivity.getWindow(), this.mDefaultWindowCallback);
        ensureToolbarListMenuPresenter();
        tbab.setListMenuPresenter(this.mToolbarListMenuPresenter);
        setSupportActionBar(tbab);
        setWindowCallback(tbab.getWrappedWindowCallback());
        tbab.invalidateOptionsMenu();
    }

    @Override // android.support.v7.app.ActionBarActivityDelegate
    public void onConfigurationChanged(Configuration newConfig) {
        ActionBar ab;
        if (this.mHasActionBar && this.mSubDecorInstalled && (ab = getSupportActionBar()) != null) {
            ab.onConfigurationChanged(newConfig);
        }
    }

    @Override // android.support.v7.app.ActionBarActivityDelegate
    public void onStop() {
        ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setShowHideAnimationEnabled(false);
        }
    }

    @Override // android.support.v7.app.ActionBarActivityDelegate
    public void onPostResume() {
        ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setShowHideAnimationEnabled(true);
        }
    }

    @Override // android.support.v7.app.ActionBarActivityDelegate
    public void setContentView(View v) {
        ensureSubDecor();
        ViewGroup contentParent = (ViewGroup) this.mActivity.findViewById(16908290);
        contentParent.removeAllViews();
        contentParent.addView(v);
        this.mActivity.onSupportContentChanged();
    }

    @Override // android.support.v7.app.ActionBarActivityDelegate
    public void setContentView(int resId) {
        ensureSubDecor();
        ViewGroup contentParent = (ViewGroup) this.mActivity.findViewById(16908290);
        contentParent.removeAllViews();
        this.mActivity.getLayoutInflater().inflate(resId, contentParent);
        this.mActivity.onSupportContentChanged();
    }

    @Override // android.support.v7.app.ActionBarActivityDelegate
    public void setContentView(View v, ViewGroup.LayoutParams lp) {
        ensureSubDecor();
        ViewGroup contentParent = (ViewGroup) this.mActivity.findViewById(16908290);
        contentParent.removeAllViews();
        contentParent.addView(v, lp);
        this.mActivity.onSupportContentChanged();
    }

    @Override // android.support.v7.app.ActionBarActivityDelegate
    public void addContentView(View v, ViewGroup.LayoutParams lp) {
        ensureSubDecor();
        ViewGroup contentParent = (ViewGroup) this.mActivity.findViewById(16908290);
        contentParent.addView(v, lp);
        this.mActivity.onSupportContentChanged();
    }

    @Override // android.support.v7.app.ActionBarActivityDelegate
    public void onContentChanged() {
    }

    final void ensureSubDecor() {
        Context themedContext;
        if (!this.mSubDecorInstalled) {
            if (this.mHasActionBar) {
                TypedValue outValue = new TypedValue();
                this.mActivity.getTheme().resolveAttribute(R.attr.actionBarTheme, outValue, true);
                if (outValue.resourceId != 0) {
                    themedContext = new ContextThemeWrapper(this.mActivity, outValue.resourceId);
                } else {
                    themedContext = this.mActivity;
                }
                this.mSubDecor = (ViewGroup) LayoutInflater.from(themedContext).inflate(R.layout.abc_screen_toolbar, (ViewGroup) null);
                this.mDecorContentParent = (DecorContentParent) this.mSubDecor.findViewById(R.id.decor_content_parent);
                this.mDecorContentParent.setWindowCallback(getWindowCallback());
                if (this.mOverlayActionBar) {
                    this.mDecorContentParent.initFeature(9);
                }
                if (this.mFeatureProgress) {
                    this.mDecorContentParent.initFeature(2);
                }
                if (this.mFeatureIndeterminateProgress) {
                    this.mDecorContentParent.initFeature(5);
                }
            } else {
                if (this.mOverlayActionMode) {
                    this.mSubDecor = (ViewGroup) LayoutInflater.from(this.mActivity).inflate(R.layout.abc_screen_simple_overlay_action_mode, (ViewGroup) null);
                } else {
                    this.mSubDecor = (ViewGroup) LayoutInflater.from(this.mActivity).inflate(R.layout.abc_screen_simple, (ViewGroup) null);
                }
                if (Build.VERSION.SDK_INT >= 21) {
                    ViewCompat.setOnApplyWindowInsetsListener(this.mSubDecor, new OnApplyWindowInsetsListener() { // from class: android.support.v7.app.ActionBarActivityDelegateBase.2
                        @Override // android.support.v4.view.OnApplyWindowInsetsListener
                        public WindowInsetsCompat onApplyWindowInsets(View v, WindowInsetsCompat insets) {
                            int top = insets.getSystemWindowInsetTop();
                            int newTop = ActionBarActivityDelegateBase.this.updateStatusGuard(top);
                            if (top != newTop) {
                                return insets.replaceSystemWindowInsets(insets.getSystemWindowInsetLeft(), newTop, insets.getSystemWindowInsetRight(), insets.getSystemWindowInsetBottom());
                            }
                            return insets;
                        }
                    });
                } else {
                    ((FitWindowsViewGroup) this.mSubDecor).setOnFitSystemWindowsListener(new FitWindowsViewGroup.OnFitSystemWindowsListener() { // from class: android.support.v7.app.ActionBarActivityDelegateBase.3
                        @Override // android.support.v7.internal.widget.FitWindowsViewGroup.OnFitSystemWindowsListener
                        public void onFitSystemWindows(Rect insets) {
                            insets.top = ActionBarActivityDelegateBase.this.updateStatusGuard(insets.top);
                        }
                    });
                }
            }
            ViewUtils.makeOptionalFitsSystemWindows(this.mSubDecor);
            this.mActivity.superSetContentView(this.mSubDecor);
            View decorContent = this.mActivity.findViewById(16908290);
            decorContent.setId(-1);
            View abcContent = this.mActivity.findViewById(R.id.action_bar_activity_content);
            abcContent.setId(16908290);
            if (decorContent instanceof FrameLayout) {
                ((FrameLayout) decorContent).setForeground(null);
            }
            if (this.mTitleToSet != null && this.mDecorContentParent != null) {
                this.mDecorContentParent.setWindowTitle(this.mTitleToSet);
                this.mTitleToSet = null;
            }
            applyFixedSizeWindow();
            onSubDecorInstalled();
            this.mSubDecorInstalled = true;
            PanelFeatureState st = getPanelState(0, false);
            if (isDestroyed()) {
                return;
            }
            if (st == null || st.menu == null) {
                invalidatePanelMenu(8);
            }
        }
    }

    void onSubDecorInstalled() {
    }

    private void applyFixedSizeWindow() {
        TypedArray a = this.mActivity.obtainStyledAttributes(R.styleable.Theme);
        if (a.hasValue(R.styleable.Theme_windowFixedWidthMajor)) {
            mFixedWidthMajor = 0 == 0 ? new TypedValue() : null;
            a.getValue(R.styleable.Theme_windowFixedWidthMajor, mFixedWidthMajor);
        }
        if (a.hasValue(R.styleable.Theme_windowFixedWidthMinor)) {
            mFixedWidthMinor = 0 == 0 ? new TypedValue() : null;
            a.getValue(R.styleable.Theme_windowFixedWidthMinor, mFixedWidthMinor);
        }
        if (a.hasValue(R.styleable.Theme_windowFixedHeightMajor)) {
            mFixedHeightMajor = 0 == 0 ? new TypedValue() : null;
            a.getValue(R.styleable.Theme_windowFixedHeightMajor, mFixedHeightMajor);
        }
        if (a.hasValue(R.styleable.Theme_windowFixedHeightMinor)) {
            mFixedHeightMinor = 0 == 0 ? new TypedValue() : null;
            a.getValue(R.styleable.Theme_windowFixedHeightMinor, mFixedHeightMinor);
        }
        DisplayMetrics metrics = this.mActivity.getResources().getDisplayMetrics();
        boolean isPortrait = metrics.widthPixels < metrics.heightPixels;
        int w = -1;
        int h = -1;
        TypedValue tvw = isPortrait ? mFixedWidthMinor : mFixedWidthMajor;
        if (tvw != null && tvw.type != 0) {
            if (tvw.type == 5) {
                w = (int) tvw.getDimension(metrics);
            } else if (tvw.type == 6) {
                w = (int) tvw.getFraction(metrics.widthPixels, metrics.widthPixels);
            }
        }
        TypedValue tvh = isPortrait ? mFixedHeightMajor : mFixedHeightMinor;
        if (tvh != null && tvh.type != 0) {
            if (tvh.type == 5) {
                h = (int) tvh.getDimension(metrics);
            } else if (tvh.type == 6) {
                h = (int) tvh.getFraction(metrics.heightPixels, metrics.heightPixels);
            }
        }
        if (w != -1 || h != -1) {
            this.mActivity.getWindow().setLayout(w, h);
        }
        a.recycle();
    }

    @Override // android.support.v7.app.ActionBarActivityDelegate
    public boolean supportRequestWindowFeature(int featureId) {
        switch (featureId) {
            case 2:
                throwFeatureRequestIfSubDecorInstalled();
                this.mFeatureProgress = true;
                return true;
            case 3:
            case 4:
            case 6:
            case 7:
            default:
                return this.mActivity.requestWindowFeature(featureId);
            case 5:
                throwFeatureRequestIfSubDecorInstalled();
                this.mFeatureIndeterminateProgress = true;
                return true;
            case 8:
                throwFeatureRequestIfSubDecorInstalled();
                this.mHasActionBar = true;
                return true;
            case 9:
                throwFeatureRequestIfSubDecorInstalled();
                this.mOverlayActionBar = true;
                return true;
            case 10:
                throwFeatureRequestIfSubDecorInstalled();
                this.mOverlayActionMode = true;
                return true;
        }
    }

    @Override // android.support.v7.app.ActionBarActivityDelegate
    public void onTitleChanged(CharSequence title) {
        if (this.mDecorContentParent != null) {
            this.mDecorContentParent.setWindowTitle(title);
        } else if (getSupportActionBar() != null) {
            getSupportActionBar().setWindowTitle(title);
        } else {
            this.mTitleToSet = title;
        }
    }

    @Override // android.support.v7.app.ActionBarActivityDelegate
    public View onCreatePanelView(int featureId) {
        View panelView = null;
        if (this.mActionMode != null) {
            return null;
        }
        WindowCallback callback = getWindowCallback();
        if (callback != null) {
            panelView = callback.onCreatePanelView(featureId);
        }
        if (panelView == null && this.mToolbarListMenuPresenter == null) {
            PanelFeatureState st = getPanelState(featureId, true);
            openPanel(st, (KeyEvent) null);
            if (st.isOpen) {
                View panelView2 = st.shownPanelView;
                return panelView2;
            }
            return panelView;
        }
        return panelView;
    }

    @Override // android.support.v7.app.ActionBarActivityDelegate
    public boolean onCreatePanelMenu(int featureId, Menu menu) {
        if (featureId != 0) {
            return getWindowCallback().onCreatePanelMenu(featureId, menu);
        }
        return false;
    }

    @Override // android.support.v7.app.ActionBarActivityDelegate
    public boolean onPreparePanel(int featureId, View view, Menu menu) {
        if (featureId != 0) {
            return getWindowCallback().onPreparePanel(featureId, view, menu);
        }
        return false;
    }

    @Override // android.support.v7.app.ActionBarActivityDelegate
    public void onPanelClosed(int featureId, Menu menu) {
        PanelFeatureState st = getPanelState(featureId, false);
        if (st != null) {
            closePanel(st, false);
        }
        if (featureId == 8) {
            ActionBar ab = getSupportActionBar();
            if (ab != null) {
                ab.dispatchMenuVisibilityChanged(false);
            }
        } else if (!isDestroyed()) {
            this.mActivity.superOnPanelClosed(featureId, menu);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // android.support.v7.app.ActionBarActivityDelegate
    public boolean onMenuOpened(int featureId, Menu menu) {
        if (featureId == 8) {
            ActionBar ab = getSupportActionBar();
            if (ab != null) {
                ab.dispatchMenuVisibilityChanged(true);
                return true;
            }
            return true;
        }
        return this.mActivity.superOnMenuOpened(featureId, menu);
    }

    @Override // android.support.v7.internal.view.menu.MenuBuilder.Callback
    public boolean onMenuItemSelected(MenuBuilder menu, MenuItem item) {
        PanelFeatureState panel;
        WindowCallback cb = getWindowCallback();
        if (cb == null || isDestroyed() || (panel = findMenuPanel(menu.getRootMenu())) == null) {
            return false;
        }
        return cb.onMenuItemSelected(panel.featureId, item);
    }

    @Override // android.support.v7.internal.view.menu.MenuBuilder.Callback
    public void onMenuModeChange(MenuBuilder menu) {
        reopenMenu(menu, true);
    }

    @Override // android.support.v7.app.ActionBarActivityDelegate
    public ActionMode startSupportActionMode(ActionMode.Callback callback) {
        if (callback == null) {
            throw new IllegalArgumentException("ActionMode callback can not be null.");
        }
        if (this.mActionMode != null) {
            this.mActionMode.finish();
        }
        ActionMode.Callback wrappedCallback = new ActionModeCallbackWrapper(callback);
        ActionBar ab = getSupportActionBar();
        if (ab != null) {
            this.mActionMode = ab.startActionMode(wrappedCallback);
            if (this.mActionMode != null) {
                this.mActivity.onSupportActionModeStarted(this.mActionMode);
            }
        }
        if (this.mActionMode == null) {
            this.mActionMode = startSupportActionModeFromWindow(wrappedCallback);
        }
        return this.mActionMode;
    }

    @Override // android.support.v7.app.ActionBarActivityDelegate
    public void supportInvalidateOptionsMenu() {
        ActionBar ab = getSupportActionBar();
        if (ab == null || !ab.invalidateOptionsMenu()) {
            invalidatePanelMenu(0);
        }
    }

    @Override // android.support.v7.app.ActionBarActivityDelegate
    ActionMode startSupportActionModeFromWindow(ActionMode.Callback callback) {
        if (this.mActionMode != null) {
            this.mActionMode.finish();
        }
        ActionMode.Callback wrappedCallback = new ActionModeCallbackWrapper(callback);
        Context context = getActionBarThemedContext();
        if (this.mActionModeView == null) {
            if (this.mIsFloating) {
                this.mActionModeView = new ActionBarContextView(context);
                this.mActionModePopup = new PopupWindow(context, (AttributeSet) null, R.attr.actionModePopupWindowStyle);
                this.mActionModePopup.setContentView(this.mActionModeView);
                this.mActionModePopup.setWidth(-1);
                TypedValue heightValue = new TypedValue();
                this.mActivity.getTheme().resolveAttribute(R.attr.actionBarSize, heightValue, true);
                int height = TypedValue.complexToDimensionPixelSize(heightValue.data, this.mActivity.getResources().getDisplayMetrics());
                this.mActionModeView.setContentHeight(height);
                this.mActionModePopup.setHeight(-2);
                this.mShowActionModePopup = new Runnable() { // from class: android.support.v7.app.ActionBarActivityDelegateBase.4
                    @Override // java.lang.Runnable
                    public void run() {
                        ActionBarActivityDelegateBase.this.mActionModePopup.showAtLocation(ActionBarActivityDelegateBase.this.mActionModeView, 55, 0, 0);
                    }
                };
            } else {
                ViewStubCompat stub = (ViewStubCompat) this.mActivity.findViewById(R.id.action_mode_bar_stub);
                if (stub != null) {
                    stub.setLayoutInflater(LayoutInflater.from(context));
                    this.mActionModeView = (ActionBarContextView) stub.inflate();
                }
            }
        }
        if (this.mActionModeView != null) {
            this.mActionModeView.killMode();
            ActionMode mode = new StandaloneActionMode(context, this.mActionModeView, wrappedCallback, this.mActionModePopup == null);
            if (callback.onCreateActionMode(mode, mode.getMenu())) {
                mode.invalidate();
                this.mActionModeView.initForMode(mode);
                this.mActionModeView.setVisibility(0);
                this.mActionMode = mode;
                if (this.mActionModePopup != null) {
                    this.mActivity.getWindow().getDecorView().post(this.mShowActionModePopup);
                }
                this.mActionModeView.sendAccessibilityEvent(32);
                if (this.mActionModeView.getParent() != null) {
                    ViewCompat.requestApplyInsets((View) this.mActionModeView.getParent());
                }
            } else {
                this.mActionMode = null;
            }
        }
        if (this.mActionMode != null && this.mActivity != null) {
            this.mActivity.onSupportActionModeStarted(this.mActionMode);
        }
        return this.mActionMode;
    }

    @Override // android.support.v7.app.ActionBarActivityDelegate
    public boolean onBackPressed() {
        if (this.mActionMode != null) {
            this.mActionMode.finish();
            return true;
        }
        ActionBar ab = getSupportActionBar();
        return ab != null && ab.collapseActionView();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // android.support.v7.app.ActionBarActivityDelegate
    public void setSupportProgressBarVisibility(boolean visible) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // android.support.v7.app.ActionBarActivityDelegate
    public void setSupportProgressBarIndeterminateVisibility(boolean visible) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // android.support.v7.app.ActionBarActivityDelegate
    public void setSupportProgressBarIndeterminate(boolean indeterminate) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // android.support.v7.app.ActionBarActivityDelegate
    public void setSupportProgress(int progress) {
    }

    @Override // android.support.v7.app.ActionBarActivityDelegate
    int getHomeAsUpIndicatorAttrId() {
        return R.attr.homeAsUpIndicator;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // android.support.v7.app.ActionBarActivityDelegate
    public boolean onKeyShortcut(int keyCode, KeyEvent ev) {
        if (this.mPreparedPanel != null) {
            boolean handled = performPanelShortcut(this.mPreparedPanel, ev.getKeyCode(), ev, 1);
            if (handled) {
                if (this.mPreparedPanel != null) {
                    this.mPreparedPanel.isHandled = true;
                    return true;
                }
                return true;
            }
        }
        if (this.mPreparedPanel == null) {
            PanelFeatureState st = getPanelState(0, true);
            preparePanel(st, ev);
            boolean handled2 = performPanelShortcut(st, ev.getKeyCode(), ev, 1);
            st.isPrepared = false;
            if (handled2) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // android.support.v7.app.ActionBarActivityDelegate
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        return onKeyShortcut(keyCode, event);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // android.support.v7.app.ActionBarActivityDelegate
    public View createView(String name, @NonNull Context context, @NonNull AttributeSet attrs) {
        if (Build.VERSION.SDK_INT < 21) {
            char c = 65535;
            switch (name.hashCode()) {
                case -1455429095:
                    if (name.equals("CheckedTextView")) {
                        c = 4;
                        break;
                    }
                    break;
                case -339785223:
                    if (name.equals("Spinner")) {
                        c = 1;
                        break;
                    }
                    break;
                case 776382189:
                    if (name.equals("RadioButton")) {
                        c = 3;
                        break;
                    }
                    break;
                case 1601505219:
                    if (name.equals("CheckBox")) {
                        c = 2;
                        break;
                    }
                    break;
                case 1666676343:
                    if (name.equals("EditText")) {
                        c = 0;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    return new TintEditText(context, attrs);
                case 1:
                    return new TintSpinner(context, attrs);
                case 2:
                    return new TintCheckBox(context, attrs);
                case 3:
                    return new TintRadioButton(context, attrs);
                case 4:
                    return new TintCheckedTextView(context, attrs);
            }
        }
        return null;
    }

    private void openPanel(int featureId, KeyEvent event) {
        if (featureId == 0 && this.mDecorContentParent != null && this.mDecorContentParent.canShowOverflowMenu() && !ViewConfigurationCompat.hasPermanentMenuKey(ViewConfiguration.get(this.mActivity))) {
            this.mDecorContentParent.showOverflowMenu();
        } else {
            openPanel(getPanelState(featureId, true), event);
        }
    }

    private void openPanel(PanelFeatureState st, KeyEvent event) {
        if (!st.isOpen && !isDestroyed()) {
            if (st.featureId == 0) {
                Context context = this.mActivity;
                Configuration config = context.getResources().getConfiguration();
                boolean isXLarge = (config.screenLayout & 15) == 4;
                boolean isHoneycombApp = context.getApplicationInfo().targetSdkVersion >= 11;
                if (isXLarge && isHoneycombApp) {
                    return;
                }
            }
            WindowCallback cb = getWindowCallback();
            if (cb != null && !cb.onMenuOpened(st.featureId, st.menu)) {
                closePanel(st, true);
            } else if (preparePanel(st, event)) {
                if (st.decorView == null || st.refreshDecorView) {
                    initializePanelDecor(st);
                }
                if (initializePanelContent(st) && st.hasPanelItems()) {
                    st.isHandled = false;
                    st.isOpen = true;
                }
            }
        }
    }

    private void initializePanelDecor(PanelFeatureState st) {
        st.decorView = this.mWindowDecor;
        st.setStyle(getActionBarThemedContext());
    }

    private void reopenMenu(MenuBuilder menu, boolean toggleMenuMode) {
        if (this.mDecorContentParent != null && this.mDecorContentParent.canShowOverflowMenu() && (!ViewConfigurationCompat.hasPermanentMenuKey(ViewConfiguration.get(this.mActivity)) || this.mDecorContentParent.isOverflowMenuShowPending())) {
            WindowCallback cb = getWindowCallback();
            if (!this.mDecorContentParent.isOverflowMenuShowing() || !toggleMenuMode) {
                if (cb != null && !isDestroyed()) {
                    if (this.mInvalidatePanelMenuPosted && (this.mInvalidatePanelMenuFeatures & 1) != 0) {
                        this.mWindowDecor.removeCallbacks(this.mInvalidatePanelMenuRunnable);
                        this.mInvalidatePanelMenuRunnable.run();
                    }
                    PanelFeatureState st = getPanelState(0, true);
                    if (st.menu != null && !st.refreshMenuContent && cb.onPreparePanel(0, null, st.menu)) {
                        cb.onMenuOpened(8, st.menu);
                        this.mDecorContentParent.showOverflowMenu();
                        return;
                    }
                    return;
                }
                return;
            }
            this.mDecorContentParent.hideOverflowMenu();
            if (!isDestroyed()) {
                this.mActivity.onPanelClosed(8, getPanelState(0, true).menu);
                return;
            }
            return;
        }
        PanelFeatureState st2 = getPanelState(0, true);
        st2.refreshDecorView = true;
        closePanel(st2, false);
        openPanel(st2, (KeyEvent) null);
    }

    private boolean initializePanelMenu(PanelFeatureState st) {
        Context context = this.mActivity;
        if ((st.featureId == 0 || st.featureId == 8) && this.mDecorContentParent != null) {
            TypedValue outValue = new TypedValue();
            Resources.Theme baseTheme = context.getTheme();
            baseTheme.resolveAttribute(R.attr.actionBarTheme, outValue, true);
            Resources.Theme widgetTheme = null;
            if (outValue.resourceId != 0) {
                widgetTheme = context.getResources().newTheme();
                widgetTheme.setTo(baseTheme);
                widgetTheme.applyStyle(outValue.resourceId, true);
                widgetTheme.resolveAttribute(R.attr.actionBarWidgetTheme, outValue, true);
            } else {
                baseTheme.resolveAttribute(R.attr.actionBarWidgetTheme, outValue, true);
            }
            if (outValue.resourceId != 0) {
                if (widgetTheme == null) {
                    widgetTheme = context.getResources().newTheme();
                    widgetTheme.setTo(baseTheme);
                }
                widgetTheme.applyStyle(outValue.resourceId, true);
            }
            if (widgetTheme != null) {
                Context context2 = new ContextThemeWrapper(context, 0);
                context2.getTheme().setTo(widgetTheme);
                context = context2;
            }
        }
        MenuBuilder menu = new MenuBuilder(context);
        menu.setCallback(this);
        st.setMenu(menu);
        return true;
    }

    private boolean initializePanelContent(PanelFeatureState st) {
        if (st.menu == null) {
            return false;
        }
        if (this.mPanelMenuPresenterCallback == null) {
            this.mPanelMenuPresenterCallback = new PanelMenuPresenterCallback();
        }
        MenuView menuView = st.getListMenuView(this.mPanelMenuPresenterCallback);
        st.shownPanelView = (View) menuView;
        return st.shownPanelView != null;
    }

    private boolean preparePanel(PanelFeatureState st, KeyEvent event) {
        if (isDestroyed()) {
            return false;
        }
        if (st.isPrepared) {
            return true;
        }
        if (this.mPreparedPanel != null && this.mPreparedPanel != st) {
            closePanel(this.mPreparedPanel, false);
        }
        boolean isActionBarMenu = st.featureId == 0 || st.featureId == 8;
        if (isActionBarMenu && this.mDecorContentParent != null) {
            this.mDecorContentParent.setMenuPrepared();
        }
        if (st.menu == null || st.refreshMenuContent) {
            if (st.menu == null && (!initializePanelMenu(st) || st.menu == null)) {
                return false;
            }
            if (isActionBarMenu && this.mDecorContentParent != null) {
                if (this.mActionMenuPresenterCallback == null) {
                    this.mActionMenuPresenterCallback = new ActionMenuPresenterCallback();
                }
                this.mDecorContentParent.setMenu(st.menu, this.mActionMenuPresenterCallback);
            }
            st.menu.stopDispatchingItemsChanged();
            if (!getWindowCallback().onCreatePanelMenu(st.featureId, st.menu)) {
                st.setMenu(null);
                if (!isActionBarMenu || this.mDecorContentParent == null) {
                    return false;
                }
                this.mDecorContentParent.setMenu(null, this.mActionMenuPresenterCallback);
                return false;
            }
            st.refreshMenuContent = false;
        }
        st.menu.stopDispatchingItemsChanged();
        if (st.frozenActionViewState != null) {
            st.menu.restoreActionViewStates(st.frozenActionViewState);
            st.frozenActionViewState = null;
        }
        if (!getWindowCallback().onPreparePanel(0, null, st.menu)) {
            if (isActionBarMenu && this.mDecorContentParent != null) {
                this.mDecorContentParent.setMenu(null, this.mActionMenuPresenterCallback);
            }
            st.menu.startDispatchingItemsChanged();
            return false;
        }
        KeyCharacterMap kmap = KeyCharacterMap.load(event != null ? event.getDeviceId() : -1);
        st.qwertyMode = kmap.getKeyboardType() != 1;
        st.menu.setQwertyMode(st.qwertyMode);
        st.menu.startDispatchingItemsChanged();
        st.isPrepared = true;
        st.isHandled = false;
        this.mPreparedPanel = st;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkCloseActionMenu(MenuBuilder menu) {
        if (!this.mClosingActionMenu) {
            this.mClosingActionMenu = true;
            this.mDecorContentParent.dismissPopups();
            WindowCallback cb = getWindowCallback();
            if (cb != null && !isDestroyed()) {
                cb.onPanelClosed(8, menu);
            }
            this.mClosingActionMenu = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void closePanel(PanelFeatureState st, boolean doCallback) {
        if (doCallback && st.featureId == 0 && this.mDecorContentParent != null && this.mDecorContentParent.isOverflowMenuShowing()) {
            checkCloseActionMenu(st.menu);
            return;
        }
        if (st.isOpen && doCallback) {
            callOnPanelClosed(st.featureId, st, null);
        }
        st.isPrepared = false;
        st.isHandled = false;
        st.isOpen = false;
        st.shownPanelView = null;
        st.refreshDecorView = true;
        if (this.mPreparedPanel == st) {
            this.mPreparedPanel = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callOnPanelClosed(int featureId, PanelFeatureState panel, Menu menu) {
        if (menu == null) {
            if (panel == null && featureId >= 0 && featureId < this.mPanels.length) {
                panel = this.mPanels[featureId];
            }
            if (panel != null) {
                menu = panel.menu;
            }
        }
        if (panel == null || panel.isOpen) {
            getWindowCallback().onPanelClosed(featureId, menu);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PanelFeatureState findMenuPanel(Menu menu) {
        PanelFeatureState[] panels = this.mPanels;
        int N = panels != null ? panels.length : 0;
        for (int i = 0; i < N; i++) {
            PanelFeatureState panel = panels[i];
            if (panel != null && panel.menu == menu) {
                return panel;
            }
        }
        return null;
    }

    private PanelFeatureState getPanelState(int featureId, boolean required) {
        PanelFeatureState[] ar = this.mPanels;
        if (ar == null || ar.length <= featureId) {
            PanelFeatureState[] nar = new PanelFeatureState[featureId + 1];
            if (ar != null) {
                System.arraycopy(ar, 0, nar, 0, ar.length);
            }
            ar = nar;
            this.mPanels = nar;
        }
        PanelFeatureState st = ar[featureId];
        if (st == null) {
            PanelFeatureState st2 = new PanelFeatureState(featureId);
            ar[featureId] = st2;
            return st2;
        }
        return st;
    }

    final boolean performPanelShortcut(PanelFeatureState st, int keyCode, KeyEvent event, int flags) {
        if (event.isSystem()) {
            return false;
        }
        boolean handled = false;
        if ((st.isPrepared || preparePanel(st, event)) && st.menu != null) {
            handled = st.menu.performShortcut(keyCode, event, flags);
        }
        if (handled && (flags & 1) == 0 && this.mDecorContentParent == null) {
            closePanel(st, true);
            return handled;
        }
        return handled;
    }

    private void invalidatePanelMenu(int featureId) {
        this.mInvalidatePanelMenuFeatures |= 1 << featureId;
        if (!this.mInvalidatePanelMenuPosted && this.mWindowDecor != null) {
            ViewCompat.postOnAnimation(this.mWindowDecor, this.mInvalidatePanelMenuRunnable);
            this.mInvalidatePanelMenuPosted = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doInvalidatePanelMenu(int featureId) {
        PanelFeatureState st;
        PanelFeatureState st2 = getPanelState(featureId, true);
        if (st2.menu != null) {
            Bundle savedActionViewStates = new Bundle();
            st2.menu.saveActionViewStates(savedActionViewStates);
            if (savedActionViewStates.size() > 0) {
                st2.frozenActionViewState = savedActionViewStates;
            }
            st2.menu.stopDispatchingItemsChanged();
            st2.menu.clear();
        }
        st2.refreshMenuContent = true;
        st2.refreshDecorView = true;
        if ((featureId == 8 || featureId == 0) && this.mDecorContentParent != null && (st = getPanelState(0, false)) != null) {
            st.isPrepared = false;
            preparePanel(st, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int updateStatusGuard(int insetTop) {
        boolean showStatusGuard = false;
        if (this.mActionModeView != null && (this.mActionModeView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            ViewGroup.MarginLayoutParams mlp = (ViewGroup.MarginLayoutParams) this.mActionModeView.getLayoutParams();
            boolean mlpChanged = false;
            if (this.mActionModeView.isShown()) {
                if (this.mTempRect1 == null) {
                    this.mTempRect1 = new Rect();
                    this.mTempRect2 = new Rect();
                }
                Rect insets = this.mTempRect1;
                Rect localInsets = this.mTempRect2;
                insets.set(0, insetTop, 0, 0);
                ViewUtils.computeFitSystemWindows(this.mSubDecor, insets, localInsets);
                int newMargin = localInsets.top == 0 ? insetTop : 0;
                if (mlp.topMargin != newMargin) {
                    mlpChanged = true;
                    mlp.topMargin = insetTop;
                    if (this.mStatusGuard == null) {
                        this.mStatusGuard = new View(this.mActivity);
                        this.mStatusGuard.setBackgroundColor(this.mActivity.getResources().getColor(R.color.abc_input_method_navigation_guard));
                        this.mSubDecor.addView(this.mStatusGuard, -1, new ViewGroup.LayoutParams(-1, insetTop));
                    } else {
                        ViewGroup.LayoutParams lp = this.mStatusGuard.getLayoutParams();
                        if (lp.height != insetTop) {
                            lp.height = insetTop;
                            this.mStatusGuard.setLayoutParams(lp);
                        }
                    }
                }
                showStatusGuard = this.mStatusGuard != null;
                if (!this.mOverlayActionMode && showStatusGuard) {
                    insetTop = 0;
                }
            } else if (mlp.topMargin != 0) {
                mlpChanged = true;
                mlp.topMargin = 0;
            }
            if (mlpChanged) {
                this.mActionModeView.setLayoutParams(mlp);
            }
        }
        if (this.mStatusGuard != null) {
            this.mStatusGuard.setVisibility(showStatusGuard ? 0 : 8);
        }
        return insetTop;
    }

    private void ensureToolbarListMenuPresenter() {
        if (this.mToolbarListMenuPresenter == null) {
            TypedValue outValue = new TypedValue();
            this.mActivity.getTheme().resolveAttribute(R.attr.panelMenuListTheme, outValue, true);
            Context context = new ContextThemeWrapper(this.mActivity, outValue.resourceId != 0 ? outValue.resourceId : R.style.Theme_AppCompat_CompactMenu);
            this.mToolbarListMenuPresenter = new ListMenuPresenter(context, R.layout.abc_list_menu_item_layout);
        }
    }

    private void throwFeatureRequestIfSubDecorInstalled() {
        if (this.mSubDecorInstalled) {
            throw new AndroidRuntimeException("supportRequestWindowFeature() must be called before adding content");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class ActionModeCallbackWrapper implements ActionMode.Callback {
        private ActionMode.Callback mWrapped;

        public ActionModeCallbackWrapper(ActionMode.Callback wrapped) {
            this.mWrapped = wrapped;
        }

        @Override // android.support.v7.view.ActionMode.Callback
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            return this.mWrapped.onCreateActionMode(mode, menu);
        }

        @Override // android.support.v7.view.ActionMode.Callback
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            return this.mWrapped.onPrepareActionMode(mode, menu);
        }

        @Override // android.support.v7.view.ActionMode.Callback
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            return this.mWrapped.onActionItemClicked(mode, item);
        }

        @Override // android.support.v7.view.ActionMode.Callback
        public void onDestroyActionMode(ActionMode mode) {
            this.mWrapped.onDestroyActionMode(mode);
            if (ActionBarActivityDelegateBase.this.mActionModePopup != null) {
                ActionBarActivityDelegateBase.this.mActivity.getWindow().getDecorView().removeCallbacks(ActionBarActivityDelegateBase.this.mShowActionModePopup);
                ActionBarActivityDelegateBase.this.mActionModePopup.dismiss();
            } else if (ActionBarActivityDelegateBase.this.mActionModeView != null) {
                ActionBarActivityDelegateBase.this.mActionModeView.setVisibility(8);
                if (ActionBarActivityDelegateBase.this.mActionModeView.getParent() != null) {
                    ViewCompat.requestApplyInsets((View) ActionBarActivityDelegateBase.this.mActionModeView.getParent());
                }
            }
            if (ActionBarActivityDelegateBase.this.mActionModeView != null) {
                ActionBarActivityDelegateBase.this.mActionModeView.removeAllViews();
            }
            if (ActionBarActivityDelegateBase.this.mActivity != null) {
                try {
                    ActionBarActivityDelegateBase.this.mActivity.onSupportActionModeFinished(ActionBarActivityDelegateBase.this.mActionMode);
                } catch (AbstractMethodError e) {
                }
            }
            ActionBarActivityDelegateBase.this.mActionMode = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class PanelMenuPresenterCallback implements MenuPresenter.Callback {
        private PanelMenuPresenterCallback() {
        }

        @Override // android.support.v7.internal.view.menu.MenuPresenter.Callback
        public void onCloseMenu(MenuBuilder menu, boolean allMenusAreClosing) {
            MenuBuilder rootMenu = menu.getRootMenu();
            boolean isSubMenu = rootMenu != menu;
            ActionBarActivityDelegateBase actionBarActivityDelegateBase = ActionBarActivityDelegateBase.this;
            if (isSubMenu) {
                menu = rootMenu;
            }
            PanelFeatureState panel = actionBarActivityDelegateBase.findMenuPanel(menu);
            if (panel != null) {
                if (isSubMenu) {
                    ActionBarActivityDelegateBase.this.callOnPanelClosed(panel.featureId, panel, rootMenu);
                    ActionBarActivityDelegateBase.this.closePanel(panel, true);
                    return;
                }
                ActionBarActivityDelegateBase.this.mActivity.closeOptionsMenu();
                ActionBarActivityDelegateBase.this.closePanel(panel, allMenusAreClosing);
            }
        }

        @Override // android.support.v7.internal.view.menu.MenuPresenter.Callback
        public boolean onOpenSubMenu(MenuBuilder subMenu) {
            WindowCallback cb;
            if (subMenu == null && ActionBarActivityDelegateBase.this.mHasActionBar && (cb = ActionBarActivityDelegateBase.this.getWindowCallback()) != null && !ActionBarActivityDelegateBase.this.isDestroyed()) {
                cb.onMenuOpened(8, subMenu);
                return true;
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class ActionMenuPresenterCallback implements MenuPresenter.Callback {
        private ActionMenuPresenterCallback() {
        }

        @Override // android.support.v7.internal.view.menu.MenuPresenter.Callback
        public boolean onOpenSubMenu(MenuBuilder subMenu) {
            WindowCallback cb = ActionBarActivityDelegateBase.this.getWindowCallback();
            if (cb != null) {
                cb.onMenuOpened(8, subMenu);
                return true;
            }
            return true;
        }

        @Override // android.support.v7.internal.view.menu.MenuPresenter.Callback
        public void onCloseMenu(MenuBuilder menu, boolean allMenusAreClosing) {
            ActionBarActivityDelegateBase.this.checkCloseActionMenu(menu);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class PanelFeatureState {
        ViewGroup decorView;
        int featureId;
        Bundle frozenActionViewState;
        Bundle frozenMenuState;
        boolean isHandled;
        boolean isOpen;
        boolean isPrepared;
        ListMenuPresenter listMenuPresenter;
        Context listPresenterContext;
        MenuBuilder menu;
        public boolean qwertyMode;
        boolean refreshDecorView = false;
        boolean refreshMenuContent;
        View shownPanelView;
        boolean wasLastOpen;

        PanelFeatureState(int featureId) {
            this.featureId = featureId;
        }

        public boolean hasPanelItems() {
            return this.shownPanelView != null && this.listMenuPresenter.getAdapter().getCount() > 0;
        }

        public void clearMenuPresenters() {
            if (this.menu != null) {
                this.menu.removeMenuPresenter(this.listMenuPresenter);
            }
            this.listMenuPresenter = null;
        }

        void setStyle(Context context) {
            TypedValue outValue = new TypedValue();
            Resources.Theme widgetTheme = context.getResources().newTheme();
            widgetTheme.setTo(context.getTheme());
            widgetTheme.resolveAttribute(R.attr.actionBarPopupTheme, outValue, true);
            if (outValue.resourceId != 0) {
                widgetTheme.applyStyle(outValue.resourceId, true);
            }
            widgetTheme.resolveAttribute(R.attr.panelMenuListTheme, outValue, true);
            if (outValue.resourceId != 0) {
                widgetTheme.applyStyle(outValue.resourceId, true);
            } else {
                widgetTheme.applyStyle(R.style.Theme_AppCompat_CompactMenu, true);
            }
            Context context2 = new ContextThemeWrapper(context, 0);
            context2.getTheme().setTo(widgetTheme);
            this.listPresenterContext = context2;
        }

        void setMenu(MenuBuilder menu) {
            if (menu != this.menu) {
                if (this.menu != null) {
                    this.menu.removeMenuPresenter(this.listMenuPresenter);
                }
                this.menu = menu;
                if (menu == null || this.listMenuPresenter == null) {
                    return;
                }
                menu.addMenuPresenter(this.listMenuPresenter);
            }
        }

        MenuView getListMenuView(MenuPresenter.Callback cb) {
            if (this.menu == null) {
                return null;
            }
            if (this.listMenuPresenter == null) {
                this.listMenuPresenter = new ListMenuPresenter(this.listPresenterContext, R.layout.abc_list_menu_item_layout);
                this.listMenuPresenter.setCallback(cb);
                this.menu.addMenuPresenter(this.listMenuPresenter);
            }
            return this.listMenuPresenter.getMenuView(this.decorView);
        }

        Parcelable onSaveInstanceState() {
            SavedState savedState = new SavedState();
            savedState.featureId = this.featureId;
            savedState.isOpen = this.isOpen;
            if (this.menu != null) {
                savedState.menuState = new Bundle();
                this.menu.savePresenterStates(savedState.menuState);
            }
            return savedState;
        }

        void onRestoreInstanceState(Parcelable state) {
            SavedState savedState = (SavedState) state;
            this.featureId = savedState.featureId;
            this.wasLastOpen = savedState.isOpen;
            this.frozenMenuState = savedState.menuState;
            this.shownPanelView = null;
            this.decorView = null;
        }

        void applyFrozenState() {
            if (this.menu != null && this.frozenMenuState != null) {
                this.menu.restorePresenterStates(this.frozenMenuState);
                this.frozenMenuState = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static class SavedState implements Parcelable {
            public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: android.support.v7.app.ActionBarActivityDelegateBase.PanelFeatureState.SavedState.1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public SavedState createFromParcel(Parcel in) {
                    return SavedState.readFromParcel(in);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public SavedState[] newArray(int size) {
                    return new SavedState[size];
                }
            };
            int featureId;
            boolean isOpen;
            Bundle menuState;

            private SavedState() {
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeInt(this.featureId);
                dest.writeInt(this.isOpen ? 1 : 0);
                if (this.isOpen) {
                    dest.writeBundle(this.menuState);
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static SavedState readFromParcel(Parcel source) {
                SavedState savedState = new SavedState();
                savedState.featureId = source.readInt();
                savedState.isOpen = source.readInt() == 1;
                if (savedState.isOpen) {
                    savedState.menuState = source.readBundle();
                }
                return savedState;
            }
        }
    }
}