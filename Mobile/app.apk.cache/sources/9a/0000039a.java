package android.support.v7.internal.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.internal.view.menu.MenuBuilder;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* loaded from: classes.dex */
public class SubMenuBuilder extends MenuBuilder implements SubMenu {
    private MenuItemImpl mItem;
    private MenuBuilder mParentMenu;

    public SubMenuBuilder(Context context, MenuBuilder parentMenu, MenuItemImpl item) {
        super(context);
        this.mParentMenu = parentMenu;
        this.mItem = item;
    }

    @Override // android.support.v7.internal.view.menu.MenuBuilder, android.view.Menu
    public void setQwertyMode(boolean isQwerty) {
        this.mParentMenu.setQwertyMode(isQwerty);
    }

    @Override // android.support.v7.internal.view.menu.MenuBuilder
    public boolean isQwertyMode() {
        return this.mParentMenu.isQwertyMode();
    }

    @Override // android.support.v7.internal.view.menu.MenuBuilder
    public void setShortcutsVisible(boolean shortcutsVisible) {
        this.mParentMenu.setShortcutsVisible(shortcutsVisible);
    }

    @Override // android.support.v7.internal.view.menu.MenuBuilder
    public boolean isShortcutsVisible() {
        return this.mParentMenu.isShortcutsVisible();
    }

    public Menu getParentMenu() {
        return this.mParentMenu;
    }

    @Override // android.view.SubMenu
    public MenuItem getItem() {
        return this.mItem;
    }

    @Override // android.support.v7.internal.view.menu.MenuBuilder
    public void setCallback(MenuBuilder.Callback callback) {
        this.mParentMenu.setCallback(callback);
    }

    @Override // android.support.v7.internal.view.menu.MenuBuilder
    public MenuBuilder getRootMenu() {
        return this.mParentMenu;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // android.support.v7.internal.view.menu.MenuBuilder
    public boolean dispatchMenuItemSelected(MenuBuilder menu, MenuItem item) {
        return super.dispatchMenuItemSelected(menu, item) || this.mParentMenu.dispatchMenuItemSelected(menu, item);
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(Drawable icon) {
        this.mItem.setIcon(icon);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(int iconRes) {
        this.mItem.setIcon(iconRes);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(Drawable icon) {
        super.setHeaderIconInt(icon);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(int iconRes) {
        super.setHeaderIconInt(ContextCompat.getDrawable(getContext(), iconRes));
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(CharSequence title) {
        super.setHeaderTitleInt(title);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(int titleRes) {
        super.setHeaderTitleInt(getContext().getResources().getString(titleRes));
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderView(View view) {
        super.setHeaderViewInt(view);
        return this;
    }

    @Override // android.support.v7.internal.view.menu.MenuBuilder
    public boolean expandItemActionView(MenuItemImpl item) {
        return this.mParentMenu.expandItemActionView(item);
    }

    @Override // android.support.v7.internal.view.menu.MenuBuilder
    public boolean collapseItemActionView(MenuItemImpl item) {
        return this.mParentMenu.collapseItemActionView(item);
    }

    @Override // android.support.v7.internal.view.menu.MenuBuilder
    public String getActionViewStatesKey() {
        int itemId = this.mItem != null ? this.mItem.getItemId() : 0;
        if (itemId == 0) {
            return null;
        }
        return super.getActionViewStatesKey() + ":" + itemId;
    }
}