package android.support.v7.internal.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.internal.view.SupportSubMenu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class SubMenuWrapperICS extends MenuWrapperICS implements SubMenu {
    /* JADX INFO: Access modifiers changed from: package-private */
    public SubMenuWrapperICS(Context context, SupportSubMenu subMenu) {
        super(context, subMenu);
    }

    @Override // android.support.v7.internal.view.menu.BaseWrapper
    public SupportSubMenu getWrappedObject() {
        return (SupportSubMenu) this.mWrappedObject;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(int titleRes) {
        getWrappedObject().setHeaderTitle(titleRes);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(CharSequence title) {
        getWrappedObject().setHeaderTitle(title);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(int iconRes) {
        getWrappedObject().setHeaderIcon(iconRes);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(Drawable icon) {
        getWrappedObject().setHeaderIcon(icon);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderView(View view) {
        getWrappedObject().setHeaderView(view);
        return this;
    }

    @Override // android.view.SubMenu
    public void clearHeader() {
        getWrappedObject().clearHeader();
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(int iconRes) {
        getWrappedObject().setIcon(iconRes);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(Drawable icon) {
        getWrappedObject().setIcon(icon);
        return this;
    }

    @Override // android.view.SubMenu
    public MenuItem getItem() {
        return getMenuItemWrapper(getWrappedObject().getItem());
    }
}