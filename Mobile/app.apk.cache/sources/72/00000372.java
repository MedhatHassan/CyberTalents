package android.support.v7.internal.view;

import android.content.Context;
import android.support.v7.internal.view.menu.MenuBuilder;
import android.support.v7.internal.view.menu.MenuPopupHelper;
import android.support.v7.internal.view.menu.SubMenuBuilder;
import android.support.v7.internal.widget.ActionBarContextView;
import android.support.v7.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public class StandaloneActionMode extends ActionMode implements MenuBuilder.Callback {
    private ActionMode.Callback mCallback;
    private Context mContext;
    private ActionBarContextView mContextView;
    private WeakReference<View> mCustomView;
    private boolean mFinished;
    private boolean mFocusable;
    private MenuBuilder mMenu;

    public StandaloneActionMode(Context context, ActionBarContextView view, ActionMode.Callback callback, boolean isFocusable) {
        this.mContext = context;
        this.mContextView = view;
        this.mCallback = callback;
        this.mMenu = new MenuBuilder(context).setDefaultShowAsAction(1);
        this.mMenu.setCallback(this);
        this.mFocusable = isFocusable;
    }

    @Override // android.support.v7.view.ActionMode
    public void setTitle(CharSequence title) {
        this.mContextView.setTitle(title);
    }

    @Override // android.support.v7.view.ActionMode
    public void setSubtitle(CharSequence subtitle) {
        this.mContextView.setSubtitle(subtitle);
    }

    @Override // android.support.v7.view.ActionMode
    public void setTitle(int resId) {
        setTitle(this.mContext.getString(resId));
    }

    @Override // android.support.v7.view.ActionMode
    public void setSubtitle(int resId) {
        setSubtitle(this.mContext.getString(resId));
    }

    @Override // android.support.v7.view.ActionMode
    public void setTitleOptionalHint(boolean titleOptional) {
        super.setTitleOptionalHint(titleOptional);
        this.mContextView.setTitleOptional(titleOptional);
    }

    @Override // android.support.v7.view.ActionMode
    public boolean isTitleOptional() {
        return this.mContextView.isTitleOptional();
    }

    @Override // android.support.v7.view.ActionMode
    public void setCustomView(View view) {
        this.mContextView.setCustomView(view);
        this.mCustomView = view != null ? new WeakReference<>(view) : null;
    }

    @Override // android.support.v7.view.ActionMode
    public void invalidate() {
        this.mCallback.onPrepareActionMode(this, this.mMenu);
    }

    @Override // android.support.v7.view.ActionMode
    public void finish() {
        if (!this.mFinished) {
            this.mFinished = true;
            this.mContextView.sendAccessibilityEvent(32);
            this.mCallback.onDestroyActionMode(this);
        }
    }

    @Override // android.support.v7.view.ActionMode
    public Menu getMenu() {
        return this.mMenu;
    }

    @Override // android.support.v7.view.ActionMode
    public CharSequence getTitle() {
        return this.mContextView.getTitle();
    }

    @Override // android.support.v7.view.ActionMode
    public CharSequence getSubtitle() {
        return this.mContextView.getSubtitle();
    }

    @Override // android.support.v7.view.ActionMode
    public View getCustomView() {
        if (this.mCustomView != null) {
            return this.mCustomView.get();
        }
        return null;
    }

    @Override // android.support.v7.view.ActionMode
    public MenuInflater getMenuInflater() {
        return new MenuInflater(this.mContext);
    }

    @Override // android.support.v7.internal.view.menu.MenuBuilder.Callback
    public boolean onMenuItemSelected(MenuBuilder menu, MenuItem item) {
        return this.mCallback.onActionItemClicked(this, item);
    }

    public void onCloseMenu(MenuBuilder menu, boolean allMenusAreClosing) {
    }

    public boolean onSubMenuSelected(SubMenuBuilder subMenu) {
        if (subMenu.hasVisibleItems()) {
            new MenuPopupHelper(this.mContext, subMenu).show();
        }
        return true;
    }

    public void onCloseSubMenu(SubMenuBuilder menu) {
    }

    @Override // android.support.v7.internal.view.menu.MenuBuilder.Callback
    public void onMenuModeChange(MenuBuilder menu) {
        invalidate();
        this.mContextView.showOverflowMenu();
    }

    @Override // android.support.v7.view.ActionMode
    public boolean isUiFocusable() {
        return this.mFocusable;
    }
}