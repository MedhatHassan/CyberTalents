package android.support.v7.internal.app;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.internal.view.menu.ListMenuPresenter;
import android.support.v7.internal.view.menu.MenuBuilder;
import android.support.v7.internal.view.menu.MenuPresenter;
import android.support.v7.internal.widget.DecorToolbar;
import android.support.v7.internal.widget.ToolbarWidgetWrapper;
import android.support.v7.view.ActionMode;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.WindowCallbackWrapper;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.SpinnerAdapter;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class ToolbarActionBar extends ActionBar {
    private DecorToolbar mDecorToolbar;
    private boolean mLastMenuVisibility;
    private ListMenuPresenter mListMenuPresenter;
    private boolean mMenuCallbackSet;
    private Toolbar mToolbar;
    private boolean mToolbarMenuPrepared;
    private Window mWindow;
    private WindowCallback mWindowCallback;
    private ArrayList<ActionBar.OnMenuVisibilityListener> mMenuVisibilityListeners = new ArrayList<>();
    private final Runnable mMenuInvalidator = new Runnable() { // from class: android.support.v7.internal.app.ToolbarActionBar.1
        @Override // java.lang.Runnable
        public void run() {
            ToolbarActionBar.this.populateOptionsMenu();
        }
    };
    private final Toolbar.OnMenuItemClickListener mMenuClicker = new Toolbar.OnMenuItemClickListener() { // from class: android.support.v7.internal.app.ToolbarActionBar.2
        @Override // android.support.v7.widget.Toolbar.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem item) {
            return ToolbarActionBar.this.mWindowCallback.onMenuItemSelected(0, item);
        }
    };

    public ToolbarActionBar(Toolbar toolbar, CharSequence title, Window window, WindowCallback windowCallback) {
        this.mToolbar = toolbar;
        this.mDecorToolbar = new ToolbarWidgetWrapper(toolbar, false);
        this.mWindowCallback = new ToolbarCallbackWrapper(windowCallback);
        this.mDecorToolbar.setWindowCallback(this.mWindowCallback);
        toolbar.setOnMenuItemClickListener(this.mMenuClicker);
        this.mDecorToolbar.setWindowTitle(title);
        this.mWindow = window;
    }

    public WindowCallback getWrappedWindowCallback() {
        return this.mWindowCallback;
    }

    @Override // android.support.v7.app.ActionBar
    public void setCustomView(View view) {
        setCustomView(view, new ActionBar.LayoutParams(-2, -2));
    }

    @Override // android.support.v7.app.ActionBar
    public void setCustomView(View view, ActionBar.LayoutParams layoutParams) {
        view.setLayoutParams(layoutParams);
        this.mDecorToolbar.setCustomView(view);
    }

    @Override // android.support.v7.app.ActionBar
    public void setCustomView(int resId) {
        LayoutInflater inflater = LayoutInflater.from(this.mToolbar.getContext());
        setCustomView(inflater.inflate(resId, (ViewGroup) this.mToolbar, false));
    }

    @Override // android.support.v7.app.ActionBar
    public void setIcon(int resId) {
        this.mDecorToolbar.setIcon(resId);
    }

    @Override // android.support.v7.app.ActionBar
    public void setIcon(Drawable icon) {
        this.mDecorToolbar.setIcon(icon);
    }

    @Override // android.support.v7.app.ActionBar
    public void setLogo(int resId) {
        this.mDecorToolbar.setLogo(resId);
    }

    @Override // android.support.v7.app.ActionBar
    public void setLogo(Drawable logo) {
        this.mDecorToolbar.setLogo(logo);
    }

    @Override // android.support.v7.app.ActionBar
    public void setStackedBackgroundDrawable(Drawable d) {
    }

    @Override // android.support.v7.app.ActionBar
    public void setSplitBackgroundDrawable(Drawable d) {
    }

    @Override // android.support.v7.app.ActionBar
    public void setHomeButtonEnabled(boolean enabled) {
    }

    @Override // android.support.v7.app.ActionBar
    public void setElevation(float elevation) {
        ViewCompat.setElevation(this.mToolbar, elevation);
    }

    @Override // android.support.v7.app.ActionBar
    public float getElevation() {
        return ViewCompat.getElevation(this.mToolbar);
    }

    @Override // android.support.v7.app.ActionBar
    public Context getThemedContext() {
        return this.mToolbar.getContext();
    }

    @Override // android.support.v7.app.ActionBar
    public boolean isTitleTruncated() {
        return super.isTitleTruncated();
    }

    @Override // android.support.v7.app.ActionBar
    public void setHomeAsUpIndicator(Drawable indicator) {
        this.mToolbar.setNavigationIcon(indicator);
    }

    @Override // android.support.v7.app.ActionBar
    public void setHomeAsUpIndicator(int resId) {
        this.mToolbar.setNavigationIcon(resId);
    }

    @Override // android.support.v7.app.ActionBar
    public void setHomeActionContentDescription(CharSequence description) {
        this.mDecorToolbar.setNavigationContentDescription(description);
    }

    @Override // android.support.v7.app.ActionBar
    public void setDefaultDisplayHomeAsUpEnabled(boolean enabled) {
    }

    @Override // android.support.v7.app.ActionBar
    public void setHomeActionContentDescription(int resId) {
        this.mDecorToolbar.setNavigationContentDescription(resId);
    }

    @Override // android.support.v7.app.ActionBar
    public void setShowHideAnimationEnabled(boolean enabled) {
    }

    @Override // android.support.v7.app.ActionBar
    public void onConfigurationChanged(Configuration config) {
        super.onConfigurationChanged(config);
    }

    @Override // android.support.v7.app.ActionBar
    public ActionMode startActionMode(ActionMode.Callback callback) {
        return this.mWindowCallback.startActionMode(callback);
    }

    @Override // android.support.v7.app.ActionBar
    public void setListNavigationCallbacks(SpinnerAdapter adapter, ActionBar.OnNavigationListener callback) {
        this.mDecorToolbar.setDropdownParams(adapter, new NavItemSelectedListener(callback));
    }

    @Override // android.support.v7.app.ActionBar
    public void setSelectedNavigationItem(int position) {
        switch (this.mDecorToolbar.getNavigationMode()) {
            case 1:
                this.mDecorToolbar.setDropdownSelectedPosition(position);
                return;
            default:
                throw new IllegalStateException("setSelectedNavigationIndex not valid for current navigation mode");
        }
    }

    @Override // android.support.v7.app.ActionBar
    public int getSelectedNavigationIndex() {
        return -1;
    }

    @Override // android.support.v7.app.ActionBar
    public int getNavigationItemCount() {
        return 0;
    }

    @Override // android.support.v7.app.ActionBar
    public void setTitle(CharSequence title) {
        this.mDecorToolbar.setTitle(title);
    }

    @Override // android.support.v7.app.ActionBar
    public void setTitle(int resId) {
        this.mDecorToolbar.setTitle(resId != 0 ? this.mDecorToolbar.getContext().getText(resId) : null);
    }

    @Override // android.support.v7.app.ActionBar
    public void setWindowTitle(CharSequence title) {
        this.mDecorToolbar.setWindowTitle(title);
    }

    @Override // android.support.v7.app.ActionBar
    public void setSubtitle(CharSequence subtitle) {
        this.mDecorToolbar.setSubtitle(subtitle);
    }

    @Override // android.support.v7.app.ActionBar
    public void setSubtitle(int resId) {
        this.mDecorToolbar.setSubtitle(resId != 0 ? this.mDecorToolbar.getContext().getText(resId) : null);
    }

    @Override // android.support.v7.app.ActionBar
    public void setDisplayOptions(int options) {
        setDisplayOptions(options, -1);
    }

    @Override // android.support.v7.app.ActionBar
    public void setDisplayOptions(int options, int mask) {
        int currentOptions = this.mDecorToolbar.getDisplayOptions();
        this.mDecorToolbar.setDisplayOptions((options & mask) | ((mask ^ (-1)) & currentOptions));
    }

    @Override // android.support.v7.app.ActionBar
    public void setDisplayUseLogoEnabled(boolean useLogo) {
        setDisplayOptions(useLogo ? 1 : 0, 1);
    }

    @Override // android.support.v7.app.ActionBar
    public void setDisplayShowHomeEnabled(boolean showHome) {
        setDisplayOptions(showHome ? 2 : 0, 2);
    }

    @Override // android.support.v7.app.ActionBar
    public void setDisplayHomeAsUpEnabled(boolean showHomeAsUp) {
        setDisplayOptions(showHomeAsUp ? 4 : 0, 4);
    }

    @Override // android.support.v7.app.ActionBar
    public void setDisplayShowTitleEnabled(boolean showTitle) {
        setDisplayOptions(showTitle ? 8 : 0, 8);
    }

    @Override // android.support.v7.app.ActionBar
    public void setDisplayShowCustomEnabled(boolean showCustom) {
        setDisplayOptions(showCustom ? 16 : 0, 16);
    }

    @Override // android.support.v7.app.ActionBar
    public void setBackgroundDrawable(@Nullable Drawable d) {
        this.mToolbar.setBackgroundDrawable(d);
    }

    @Override // android.support.v7.app.ActionBar
    public View getCustomView() {
        return this.mDecorToolbar.getCustomView();
    }

    @Override // android.support.v7.app.ActionBar
    public CharSequence getTitle() {
        return this.mToolbar.getTitle();
    }

    @Override // android.support.v7.app.ActionBar
    public CharSequence getSubtitle() {
        return this.mToolbar.getSubtitle();
    }

    @Override // android.support.v7.app.ActionBar
    public int getNavigationMode() {
        return 0;
    }

    @Override // android.support.v7.app.ActionBar
    public void setNavigationMode(int mode) {
        if (mode == 2) {
            throw new IllegalArgumentException("Tabs not supported in this configuration");
        }
        this.mDecorToolbar.setNavigationMode(mode);
    }

    @Override // android.support.v7.app.ActionBar
    public int getDisplayOptions() {
        return this.mDecorToolbar.getDisplayOptions();
    }

    @Override // android.support.v7.app.ActionBar
    public ActionBar.Tab newTab() {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    @Override // android.support.v7.app.ActionBar
    public void addTab(ActionBar.Tab tab) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    @Override // android.support.v7.app.ActionBar
    public void addTab(ActionBar.Tab tab, boolean setSelected) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    @Override // android.support.v7.app.ActionBar
    public void addTab(ActionBar.Tab tab, int position) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    @Override // android.support.v7.app.ActionBar
    public void addTab(ActionBar.Tab tab, int position, boolean setSelected) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    @Override // android.support.v7.app.ActionBar
    public void removeTab(ActionBar.Tab tab) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    @Override // android.support.v7.app.ActionBar
    public void removeTabAt(int position) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    @Override // android.support.v7.app.ActionBar
    public void removeAllTabs() {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    @Override // android.support.v7.app.ActionBar
    public void selectTab(ActionBar.Tab tab) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    @Override // android.support.v7.app.ActionBar
    public ActionBar.Tab getSelectedTab() {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    @Override // android.support.v7.app.ActionBar
    public ActionBar.Tab getTabAt(int index) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    @Override // android.support.v7.app.ActionBar
    public int getTabCount() {
        return 0;
    }

    @Override // android.support.v7.app.ActionBar
    public int getHeight() {
        return this.mToolbar.getHeight();
    }

    @Override // android.support.v7.app.ActionBar
    public void show() {
        this.mToolbar.setVisibility(0);
    }

    @Override // android.support.v7.app.ActionBar
    public void hide() {
        this.mToolbar.setVisibility(8);
    }

    @Override // android.support.v7.app.ActionBar
    public boolean isShowing() {
        return this.mToolbar.getVisibility() == 0;
    }

    @Override // android.support.v7.app.ActionBar
    public boolean openOptionsMenu() {
        return this.mToolbar.showOverflowMenu();
    }

    @Override // android.support.v7.app.ActionBar
    public boolean invalidateOptionsMenu() {
        this.mToolbar.removeCallbacks(this.mMenuInvalidator);
        ViewCompat.postOnAnimation(this.mToolbar, this.mMenuInvalidator);
        return true;
    }

    @Override // android.support.v7.app.ActionBar
    public boolean collapseActionView() {
        if (this.mToolbar.hasExpandedActionView()) {
            this.mToolbar.collapseActionView();
            return true;
        }
        return false;
    }

    void populateOptionsMenu() {
        Menu menu = getMenu();
        MenuBuilder mb = menu instanceof MenuBuilder ? (MenuBuilder) menu : null;
        if (mb != null) {
            mb.stopDispatchingItemsChanged();
        }
        try {
            menu.clear();
            if (!this.mWindowCallback.onCreatePanelMenu(0, menu) || !this.mWindowCallback.onPreparePanel(0, null, menu)) {
                menu.clear();
            }
        } finally {
            if (mb != null) {
                mb.startDispatchingItemsChanged();
            }
        }
    }

    @Override // android.support.v7.app.ActionBar
    public boolean onMenuKeyEvent(KeyEvent event) {
        if (event.getAction() == 1) {
            openOptionsMenu();
        }
        return true;
    }

    @Override // android.support.v7.app.ActionBar
    public void addOnMenuVisibilityListener(ActionBar.OnMenuVisibilityListener listener) {
        this.mMenuVisibilityListeners.add(listener);
    }

    @Override // android.support.v7.app.ActionBar
    public void removeOnMenuVisibilityListener(ActionBar.OnMenuVisibilityListener listener) {
        this.mMenuVisibilityListeners.remove(listener);
    }

    @Override // android.support.v7.app.ActionBar
    public void dispatchMenuVisibilityChanged(boolean isVisible) {
        if (isVisible != this.mLastMenuVisibility) {
            this.mLastMenuVisibility = isVisible;
            int count = this.mMenuVisibilityListeners.size();
            for (int i = 0; i < count; i++) {
                this.mMenuVisibilityListeners.get(i).onMenuVisibilityChanged(isVisible);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View getListMenuView(Menu menu) {
        if (menu == null || this.mListMenuPresenter == null || this.mListMenuPresenter.getAdapter().getCount() <= 0) {
            return null;
        }
        return (View) this.mListMenuPresenter.getMenuView(this.mToolbar);
    }

    /* loaded from: classes.dex */
    private class ToolbarCallbackWrapper extends WindowCallbackWrapper {
        public ToolbarCallbackWrapper(WindowCallback wrapped) {
            super(wrapped);
        }

        @Override // android.support.v7.widget.WindowCallbackWrapper, android.support.v7.internal.app.WindowCallback
        public boolean onPreparePanel(int featureId, View view, Menu menu) {
            boolean result = super.onPreparePanel(featureId, view, menu);
            if (result && !ToolbarActionBar.this.mToolbarMenuPrepared) {
                ToolbarActionBar.this.mDecorToolbar.setMenuPrepared();
                ToolbarActionBar.this.mToolbarMenuPrepared = true;
            }
            return result;
        }

        @Override // android.support.v7.widget.WindowCallbackWrapper, android.support.v7.internal.app.WindowCallback
        public View onCreatePanelView(int featureId) {
            switch (featureId) {
                case 0:
                    if (!ToolbarActionBar.this.mToolbarMenuPrepared) {
                        ToolbarActionBar.this.populateOptionsMenu();
                        ToolbarActionBar.this.mToolbar.removeCallbacks(ToolbarActionBar.this.mMenuInvalidator);
                    }
                    if (ToolbarActionBar.this.mToolbarMenuPrepared && ToolbarActionBar.this.mWindowCallback != null) {
                        Menu menu = ToolbarActionBar.this.getMenu();
                        if (ToolbarActionBar.this.mWindowCallback.onPreparePanel(featureId, null, menu) && ToolbarActionBar.this.mWindowCallback.onMenuOpened(featureId, menu)) {
                            return ToolbarActionBar.this.getListMenuView(menu);
                        }
                    }
                    break;
            }
            return super.onCreatePanelView(featureId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Menu getMenu() {
        if (!this.mMenuCallbackSet) {
            this.mToolbar.setMenuCallbacks(new ActionMenuPresenterCallback(), new MenuBuilderCallback());
            this.mMenuCallbackSet = true;
        }
        return this.mToolbar.getMenu();
    }

    public void setListMenuPresenter(ListMenuPresenter listMenuPresenter) {
        Menu menu = getMenu();
        if (menu instanceof MenuBuilder) {
            MenuBuilder mb = (MenuBuilder) menu;
            if (this.mListMenuPresenter != null) {
                this.mListMenuPresenter.setCallback(null);
                mb.removeMenuPresenter(this.mListMenuPresenter);
            }
            this.mListMenuPresenter = listMenuPresenter;
            if (listMenuPresenter != null) {
                listMenuPresenter.setCallback(new PanelMenuPresenterCallback());
                mb.addMenuPresenter(listMenuPresenter);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class ActionMenuPresenterCallback implements MenuPresenter.Callback {
        private boolean mClosingActionMenu;

        private ActionMenuPresenterCallback() {
        }

        @Override // android.support.v7.internal.view.menu.MenuPresenter.Callback
        public boolean onOpenSubMenu(MenuBuilder subMenu) {
            if (ToolbarActionBar.this.mWindowCallback != null) {
                ToolbarActionBar.this.mWindowCallback.onMenuOpened(8, subMenu);
                return true;
            }
            return false;
        }

        @Override // android.support.v7.internal.view.menu.MenuPresenter.Callback
        public void onCloseMenu(MenuBuilder menu, boolean allMenusAreClosing) {
            if (!this.mClosingActionMenu) {
                this.mClosingActionMenu = true;
                ToolbarActionBar.this.mToolbar.dismissPopupMenus();
                if (ToolbarActionBar.this.mWindowCallback != null) {
                    ToolbarActionBar.this.mWindowCallback.onPanelClosed(8, menu);
                }
                this.mClosingActionMenu = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class PanelMenuPresenterCallback implements MenuPresenter.Callback {
        private PanelMenuPresenterCallback() {
        }

        @Override // android.support.v7.internal.view.menu.MenuPresenter.Callback
        public void onCloseMenu(MenuBuilder menu, boolean allMenusAreClosing) {
            if (ToolbarActionBar.this.mWindowCallback != null) {
                ToolbarActionBar.this.mWindowCallback.onPanelClosed(0, menu);
            }
            ToolbarActionBar.this.mWindow.closePanel(0);
        }

        @Override // android.support.v7.internal.view.menu.MenuPresenter.Callback
        public boolean onOpenSubMenu(MenuBuilder subMenu) {
            if (subMenu == null && ToolbarActionBar.this.mWindowCallback != null) {
                ToolbarActionBar.this.mWindowCallback.onMenuOpened(0, subMenu);
                return true;
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class MenuBuilderCallback implements MenuBuilder.Callback {
        private MenuBuilderCallback() {
        }

        @Override // android.support.v7.internal.view.menu.MenuBuilder.Callback
        public boolean onMenuItemSelected(MenuBuilder menu, MenuItem item) {
            return false;
        }

        @Override // android.support.v7.internal.view.menu.MenuBuilder.Callback
        public void onMenuModeChange(MenuBuilder menu) {
            if (ToolbarActionBar.this.mWindowCallback != null) {
                if (ToolbarActionBar.this.mToolbar.isOverflowMenuShowing()) {
                    ToolbarActionBar.this.mWindowCallback.onPanelClosed(8, menu);
                } else if (ToolbarActionBar.this.mWindowCallback.onPreparePanel(0, null, menu)) {
                    ToolbarActionBar.this.mWindowCallback.onMenuOpened(8, menu);
                }
            }
        }
    }
}