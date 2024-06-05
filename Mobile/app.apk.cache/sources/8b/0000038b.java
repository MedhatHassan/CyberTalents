package android.support.v7.internal.view.menu;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.internal.view.SupportMenuItem;
import android.support.v4.view.MenuItemCompat;
import android.util.Log;
import android.view.ActionProvider;
import android.view.CollapsibleActionView;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.FrameLayout;
import java.lang.reflect.Method;

@TargetApi(14)
/* loaded from: classes.dex */
public class MenuItemWrapperICS extends BaseMenuWrapper<SupportMenuItem> implements MenuItem {
    static final String LOG_TAG = "MenuItemWrapper";
    private Method mSetExclusiveCheckableMethod;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MenuItemWrapperICS(Context context, SupportMenuItem object) {
        super(context, object);
    }

    @Override // android.view.MenuItem
    public int getItemId() {
        return ((SupportMenuItem) this.mWrappedObject).getItemId();
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return ((SupportMenuItem) this.mWrappedObject).getGroupId();
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return ((SupportMenuItem) this.mWrappedObject).getOrder();
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence title) {
        ((SupportMenuItem) this.mWrappedObject).setTitle(title);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int title) {
        ((SupportMenuItem) this.mWrappedObject).setTitle(title);
        return this;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitle() {
        return ((SupportMenuItem) this.mWrappedObject).getTitle();
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence title) {
        ((SupportMenuItem) this.mWrappedObject).setTitleCondensed(title);
        return this;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        return ((SupportMenuItem) this.mWrappedObject).getTitleCondensed();
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable icon) {
        ((SupportMenuItem) this.mWrappedObject).setIcon(icon);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int iconRes) {
        ((SupportMenuItem) this.mWrappedObject).setIcon(iconRes);
        return this;
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        return ((SupportMenuItem) this.mWrappedObject).getIcon();
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent intent) {
        ((SupportMenuItem) this.mWrappedObject).setIntent(intent);
        return this;
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return ((SupportMenuItem) this.mWrappedObject).getIntent();
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char numericChar, char alphaChar) {
        ((SupportMenuItem) this.mWrappedObject).setShortcut(numericChar, alphaChar);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char numericChar) {
        ((SupportMenuItem) this.mWrappedObject).setNumericShortcut(numericChar);
        return this;
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return ((SupportMenuItem) this.mWrappedObject).getNumericShortcut();
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char alphaChar) {
        ((SupportMenuItem) this.mWrappedObject).setAlphabeticShortcut(alphaChar);
        return this;
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return ((SupportMenuItem) this.mWrappedObject).getAlphabeticShortcut();
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean checkable) {
        ((SupportMenuItem) this.mWrappedObject).setCheckable(checkable);
        return this;
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        return ((SupportMenuItem) this.mWrappedObject).isCheckable();
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean checked) {
        ((SupportMenuItem) this.mWrappedObject).setChecked(checked);
        return this;
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        return ((SupportMenuItem) this.mWrappedObject).isChecked();
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean visible) {
        return ((SupportMenuItem) this.mWrappedObject).setVisible(visible);
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        return ((SupportMenuItem) this.mWrappedObject).isVisible();
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean enabled) {
        ((SupportMenuItem) this.mWrappedObject).setEnabled(enabled);
        return this;
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        return ((SupportMenuItem) this.mWrappedObject).isEnabled();
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        return ((SupportMenuItem) this.mWrappedObject).hasSubMenu();
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return getSubMenuWrapper(((SupportMenuItem) this.mWrappedObject).getSubMenu());
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener menuItemClickListener) {
        ((SupportMenuItem) this.mWrappedObject).setOnMenuItemClickListener(menuItemClickListener != null ? new OnMenuItemClickListenerWrapper(menuItemClickListener) : null);
        return this;
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return ((SupportMenuItem) this.mWrappedObject).getMenuInfo();
    }

    @Override // android.view.MenuItem
    public void setShowAsAction(int actionEnum) {
        ((SupportMenuItem) this.mWrappedObject).setShowAsAction(actionEnum);
    }

    @Override // android.view.MenuItem
    public MenuItem setShowAsActionFlags(int actionEnum) {
        ((SupportMenuItem) this.mWrappedObject).setShowAsActionFlags(actionEnum);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionView(View view) {
        if (view instanceof CollapsibleActionView) {
            view = new CollapsibleActionViewWrapper(view);
        }
        ((SupportMenuItem) this.mWrappedObject).setActionView(view);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionView(int resId) {
        ((SupportMenuItem) this.mWrappedObject).setActionView(resId);
        View actionView = ((SupportMenuItem) this.mWrappedObject).getActionView();
        if (actionView instanceof CollapsibleActionView) {
            ((SupportMenuItem) this.mWrappedObject).setActionView(new CollapsibleActionViewWrapper(actionView));
        }
        return this;
    }

    @Override // android.view.MenuItem
    public View getActionView() {
        View actionView = ((SupportMenuItem) this.mWrappedObject).getActionView();
        if (actionView instanceof CollapsibleActionViewWrapper) {
            return ((CollapsibleActionViewWrapper) actionView).getWrappedView();
        }
        return actionView;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(ActionProvider provider) {
        ((SupportMenuItem) this.mWrappedObject).setSupportActionProvider(provider != null ? createActionProviderWrapper(provider) : null);
        return this;
    }

    @Override // android.view.MenuItem
    public ActionProvider getActionProvider() {
        android.support.v4.view.ActionProvider provider = ((SupportMenuItem) this.mWrappedObject).getSupportActionProvider();
        if (provider instanceof ActionProviderWrapper) {
            return ((ActionProviderWrapper) provider).mInner;
        }
        return null;
    }

    @Override // android.view.MenuItem
    public boolean expandActionView() {
        return ((SupportMenuItem) this.mWrappedObject).expandActionView();
    }

    @Override // android.view.MenuItem
    public boolean collapseActionView() {
        return ((SupportMenuItem) this.mWrappedObject).collapseActionView();
    }

    @Override // android.view.MenuItem
    public boolean isActionViewExpanded() {
        return ((SupportMenuItem) this.mWrappedObject).isActionViewExpanded();
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener listener) {
        ((SupportMenuItem) this.mWrappedObject).setSupportOnActionExpandListener(listener != null ? new OnActionExpandListenerWrapper(listener) : null);
        return this;
    }

    public void setExclusiveCheckable(boolean checkable) {
        try {
            if (this.mSetExclusiveCheckableMethod == null) {
                this.mSetExclusiveCheckableMethod = ((SupportMenuItem) this.mWrappedObject).getClass().getDeclaredMethod("setExclusiveCheckable", Boolean.TYPE);
            }
            this.mSetExclusiveCheckableMethod.invoke(this.mWrappedObject, Boolean.valueOf(checkable));
        } catch (Exception e) {
            Log.w(LOG_TAG, "Error while calling setExclusiveCheckable", e);
        }
    }

    ActionProviderWrapper createActionProviderWrapper(ActionProvider provider) {
        return new ActionProviderWrapper(this.mContext, provider);
    }

    /* loaded from: classes.dex */
    private class OnMenuItemClickListenerWrapper extends BaseWrapper<MenuItem.OnMenuItemClickListener> implements MenuItem.OnMenuItemClickListener {
        OnMenuItemClickListenerWrapper(MenuItem.OnMenuItemClickListener object) {
            super(object);
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem item) {
            return ((MenuItem.OnMenuItemClickListener) this.mWrappedObject).onMenuItemClick(MenuItemWrapperICS.this.getMenuItemWrapper(item));
        }
    }

    /* loaded from: classes.dex */
    private class OnActionExpandListenerWrapper extends BaseWrapper<MenuItem.OnActionExpandListener> implements MenuItemCompat.OnActionExpandListener {
        OnActionExpandListenerWrapper(MenuItem.OnActionExpandListener object) {
            super(object);
        }

        @Override // android.support.v4.view.MenuItemCompat.OnActionExpandListener
        public boolean onMenuItemActionExpand(MenuItem item) {
            return ((MenuItem.OnActionExpandListener) this.mWrappedObject).onMenuItemActionExpand(MenuItemWrapperICS.this.getMenuItemWrapper(item));
        }

        @Override // android.support.v4.view.MenuItemCompat.OnActionExpandListener
        public boolean onMenuItemActionCollapse(MenuItem item) {
            return ((MenuItem.OnActionExpandListener) this.mWrappedObject).onMenuItemActionCollapse(MenuItemWrapperICS.this.getMenuItemWrapper(item));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class ActionProviderWrapper extends android.support.v4.view.ActionProvider {
        final ActionProvider mInner;

        public ActionProviderWrapper(Context context, ActionProvider inner) {
            super(context);
            this.mInner = inner;
        }

        @Override // android.support.v4.view.ActionProvider
        public View onCreateActionView() {
            return this.mInner.onCreateActionView();
        }

        @Override // android.support.v4.view.ActionProvider
        public boolean onPerformDefaultAction() {
            return this.mInner.onPerformDefaultAction();
        }

        @Override // android.support.v4.view.ActionProvider
        public boolean hasSubMenu() {
            return this.mInner.hasSubMenu();
        }

        @Override // android.support.v4.view.ActionProvider
        public void onPrepareSubMenu(SubMenu subMenu) {
            this.mInner.onPrepareSubMenu(MenuItemWrapperICS.this.getSubMenuWrapper(subMenu));
        }
    }

    /* loaded from: classes.dex */
    static class CollapsibleActionViewWrapper extends FrameLayout implements android.support.v7.view.CollapsibleActionView {
        final CollapsibleActionView mWrappedView;

        CollapsibleActionViewWrapper(View actionView) {
            super(actionView.getContext());
            this.mWrappedView = (CollapsibleActionView) actionView;
            addView(actionView);
        }

        @Override // android.support.v7.view.CollapsibleActionView
        public void onActionViewExpanded() {
            this.mWrappedView.onActionViewExpanded();
        }

        @Override // android.support.v7.view.CollapsibleActionView
        public void onActionViewCollapsed() {
            this.mWrappedView.onActionViewCollapsed();
        }

        View getWrappedView() {
            return (View) this.mWrappedView;
        }
    }
}