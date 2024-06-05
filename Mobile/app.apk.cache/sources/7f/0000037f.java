package android.support.v7.internal.view.menu;

import android.content.Context;
import android.support.v4.internal.view.SupportMenuItem;
import android.support.v4.internal.view.SupportSubMenu;
import android.support.v4.util.ArrayMap;
import android.view.MenuItem;
import android.view.SubMenu;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
abstract class BaseMenuWrapper<T> extends BaseWrapper<T> {
    final Context mContext;
    private Map<SupportMenuItem, MenuItem> mMenuItems;
    private Map<SupportSubMenu, SubMenu> mSubMenus;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BaseMenuWrapper(Context context, T object) {
        super(object);
        this.mContext = context;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final MenuItem getMenuItemWrapper(MenuItem menuItem) {
        if (menuItem instanceof SupportMenuItem) {
            SupportMenuItem supportMenuItem = (SupportMenuItem) menuItem;
            if (this.mMenuItems == null) {
                this.mMenuItems = new ArrayMap();
            }
            MenuItem wrappedItem = this.mMenuItems.get(menuItem);
            if (wrappedItem == null) {
                MenuItem wrappedItem2 = MenuWrapperFactory.wrapSupportMenuItem(this.mContext, supportMenuItem);
                this.mMenuItems.put(supportMenuItem, wrappedItem2);
                return wrappedItem2;
            }
            return wrappedItem;
        }
        return menuItem;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final SubMenu getSubMenuWrapper(SubMenu subMenu) {
        if (subMenu instanceof SupportSubMenu) {
            SupportSubMenu supportSubMenu = (SupportSubMenu) subMenu;
            if (this.mSubMenus == null) {
                this.mSubMenus = new ArrayMap();
            }
            SubMenu wrappedMenu = this.mSubMenus.get(supportSubMenu);
            if (wrappedMenu == null) {
                SubMenu wrappedMenu2 = MenuWrapperFactory.wrapSupportSubMenu(this.mContext, supportSubMenu);
                this.mSubMenus.put(supportSubMenu, wrappedMenu2);
                return wrappedMenu2;
            }
            return wrappedMenu;
        }
        return subMenu;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void internalClear() {
        if (this.mMenuItems != null) {
            this.mMenuItems.clear();
        }
        if (this.mSubMenus != null) {
            this.mSubMenus.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void internalRemoveGroup(int groupId) {
        if (this.mMenuItems != null) {
            Iterator<SupportMenuItem> iterator = this.mMenuItems.keySet().iterator();
            while (iterator.hasNext()) {
                MenuItem menuItem = iterator.next();
                if (groupId == menuItem.getGroupId()) {
                    iterator.remove();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void internalRemoveItem(int id) {
        if (this.mMenuItems != null) {
            Iterator<SupportMenuItem> iterator = this.mMenuItems.keySet().iterator();
            while (iterator.hasNext()) {
                MenuItem menuItem = iterator.next();
                if (id == menuItem.getItemId()) {
                    iterator.remove();
                    return;
                }
            }
        }
    }
}