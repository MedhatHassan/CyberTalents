package android.support.v7.internal.view.menu;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.internal.view.SupportMenuItem;
import android.support.v4.view.ActionProvider;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.internal.view.menu.MenuView;
import android.support.v7.internal.widget.TintManager;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/* loaded from: classes.dex */
public final class MenuItemImpl implements SupportMenuItem {
    private static final int CHECKABLE = 1;
    private static final int CHECKED = 2;
    private static final int ENABLED = 16;
    private static final int EXCLUSIVE = 4;
    private static final int HIDDEN = 8;
    private static final int IS_ACTION = 32;
    static final int NO_ICON = 0;
    private static final int SHOW_AS_ACTION_MASK = 3;
    private static final String TAG = "MenuItemImpl";
    private static String sDeleteShortcutLabel;
    private static String sEnterShortcutLabel;
    private static String sPrependShortcutLabel;
    private static String sSpaceShortcutLabel;
    private ActionProvider mActionProvider;
    private View mActionView;
    private final int mCategoryOrder;
    private MenuItem.OnMenuItemClickListener mClickListener;
    private final int mGroup;
    private Drawable mIconDrawable;
    private final int mId;
    private Intent mIntent;
    private Runnable mItemCallback;
    private MenuBuilder mMenu;
    private ContextMenu.ContextMenuInfo mMenuInfo;
    private MenuItemCompat.OnActionExpandListener mOnActionExpandListener;
    private final int mOrdering;
    private char mShortcutAlphabeticChar;
    private char mShortcutNumericChar;
    private int mShowAsAction;
    private SubMenuBuilder mSubMenu;
    private CharSequence mTitle;
    private CharSequence mTitleCondensed;
    private int mIconResId = 0;
    private int mFlags = 16;
    private boolean mIsActionViewExpanded = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MenuItemImpl(MenuBuilder menu, int group, int id, int categoryOrder, int ordering, CharSequence title, int showAsAction) {
        this.mShowAsAction = 0;
        this.mMenu = menu;
        this.mId = id;
        this.mGroup = group;
        this.mCategoryOrder = categoryOrder;
        this.mOrdering = ordering;
        this.mTitle = title;
        this.mShowAsAction = showAsAction;
    }

    public boolean invoke() {
        if ((this.mClickListener == null || !this.mClickListener.onMenuItemClick(this)) && !this.mMenu.dispatchMenuItemSelected(this.mMenu.getRootMenu(), this)) {
            if (this.mItemCallback != null) {
                this.mItemCallback.run();
                return true;
            }
            if (this.mIntent != null) {
                try {
                    this.mMenu.getContext().startActivity(this.mIntent);
                    return true;
                } catch (ActivityNotFoundException e) {
                    Log.e(TAG, "Can't find activity to handle intent; ignoring", e);
                }
            }
            return this.mActionProvider != null && this.mActionProvider.onPerformDefaultAction();
        }
        return true;
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        return (this.mFlags & 16) != 0;
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean enabled) {
        if (enabled) {
            this.mFlags |= 16;
        } else {
            this.mFlags &= -17;
        }
        this.mMenu.onItemsChanged(false);
        return this;
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return this.mGroup;
    }

    @Override // android.view.MenuItem
    @ViewDebug.CapturedViewProperty
    public int getItemId() {
        return this.mId;
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return this.mCategoryOrder;
    }

    public int getOrdering() {
        return this.mOrdering;
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return this.mIntent;
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent intent) {
        this.mIntent = intent;
        return this;
    }

    Runnable getCallback() {
        return this.mItemCallback;
    }

    public MenuItem setCallback(Runnable callback) {
        this.mItemCallback = callback;
        return this;
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return this.mShortcutAlphabeticChar;
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char alphaChar) {
        if (this.mShortcutAlphabeticChar != alphaChar) {
            this.mShortcutAlphabeticChar = Character.toLowerCase(alphaChar);
            this.mMenu.onItemsChanged(false);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return this.mShortcutNumericChar;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char numericChar) {
        if (this.mShortcutNumericChar != numericChar) {
            this.mShortcutNumericChar = numericChar;
            this.mMenu.onItemsChanged(false);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char numericChar, char alphaChar) {
        this.mShortcutNumericChar = numericChar;
        this.mShortcutAlphabeticChar = Character.toLowerCase(alphaChar);
        this.mMenu.onItemsChanged(false);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public char getShortcut() {
        return this.mMenu.isQwertyMode() ? this.mShortcutAlphabeticChar : this.mShortcutNumericChar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getShortcutLabel() {
        char shortcut = getShortcut();
        if (shortcut == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(sPrependShortcutLabel);
        switch (shortcut) {
            case '\b':
                sb.append(sDeleteShortcutLabel);
                break;
            case '\n':
                sb.append(sEnterShortcutLabel);
                break;
            case ' ':
                sb.append(sSpaceShortcutLabel);
                break;
            default:
                sb.append(shortcut);
                break;
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean shouldShowShortcut() {
        return this.mMenu.isShortcutsVisible() && getShortcut() != 0;
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return this.mSubMenu;
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        return this.mSubMenu != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setSubMenu(SubMenuBuilder subMenu) {
        this.mSubMenu = subMenu;
        subMenu.setHeaderTitle(getTitle());
    }

    @Override // android.view.MenuItem
    @ViewDebug.CapturedViewProperty
    public CharSequence getTitle() {
        return this.mTitle;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CharSequence getTitleForItemView(MenuView.ItemView itemView) {
        return (itemView == null || !itemView.prefersCondensedTitle()) ? getTitle() : getTitleCondensed();
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence title) {
        this.mTitle = title;
        this.mMenu.onItemsChanged(false);
        if (this.mSubMenu != null) {
            this.mSubMenu.setHeaderTitle(title);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int title) {
        return setTitle(this.mMenu.getContext().getString(title));
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        CharSequence ctitle = this.mTitleCondensed != null ? this.mTitleCondensed : this.mTitle;
        if (Build.VERSION.SDK_INT < 18 && ctitle != null && !(ctitle instanceof String)) {
            return ctitle.toString();
        }
        return ctitle;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence title) {
        this.mTitleCondensed = title;
        if (title == null) {
            CharSequence title2 = this.mTitle;
        }
        this.mMenu.onItemsChanged(false);
        return this;
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        if (this.mIconDrawable != null) {
            return this.mIconDrawable;
        }
        if (this.mIconResId != 0) {
            Drawable icon = TintManager.getDrawable(this.mMenu.getContext(), this.mIconResId);
            this.mIconResId = 0;
            this.mIconDrawable = icon;
            return icon;
        }
        return null;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable icon) {
        this.mIconResId = 0;
        this.mIconDrawable = icon;
        this.mMenu.onItemsChanged(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int iconResId) {
        this.mIconDrawable = null;
        this.mIconResId = iconResId;
        this.mMenu.onItemsChanged(false);
        return this;
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        return (this.mFlags & 1) == 1;
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean checkable) {
        int oldFlags = this.mFlags;
        this.mFlags = (checkable ? 1 : 0) | (this.mFlags & (-2));
        if (oldFlags != this.mFlags) {
            this.mMenu.onItemsChanged(false);
        }
        return this;
    }

    public void setExclusiveCheckable(boolean exclusive) {
        this.mFlags = (exclusive ? 4 : 0) | (this.mFlags & (-5));
    }

    public boolean isExclusiveCheckable() {
        return (this.mFlags & 4) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        return (this.mFlags & 2) == 2;
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean checked) {
        if ((this.mFlags & 4) != 0) {
            this.mMenu.setExclusiveItemChecked(this);
        } else {
            setCheckedInt(checked);
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setCheckedInt(boolean checked) {
        int oldFlags = this.mFlags;
        this.mFlags = (checked ? 2 : 0) | (this.mFlags & (-3));
        if (oldFlags != this.mFlags) {
            this.mMenu.onItemsChanged(false);
        }
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        return (this.mActionProvider == null || !this.mActionProvider.overridesItemVisibility()) ? (this.mFlags & 8) == 0 : (this.mFlags & 8) == 0 && this.mActionProvider.isVisible();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean setVisibleInt(boolean shown) {
        int oldFlags = this.mFlags;
        this.mFlags = (shown ? 0 : 8) | (this.mFlags & (-9));
        return oldFlags != this.mFlags;
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean shown) {
        if (setVisibleInt(shown)) {
            this.mMenu.onItemVisibleChanged(this);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener clickListener) {
        this.mClickListener = clickListener;
        return this;
    }

    public String toString() {
        return this.mTitle.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setMenuInfo(ContextMenu.ContextMenuInfo menuInfo) {
        this.mMenuInfo = menuInfo;
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.mMenuInfo;
    }

    public void actionFormatChanged() {
        this.mMenu.onItemActionRequestChanged(this);
    }

    public boolean shouldShowIcon() {
        return this.mMenu.getOptionalIconsVisible();
    }

    public boolean isActionButton() {
        return (this.mFlags & 32) == 32;
    }

    public boolean requestsActionButton() {
        return (this.mShowAsAction & 1) == 1;
    }

    public boolean requiresActionButton() {
        return (this.mShowAsAction & 2) == 2;
    }

    public void setIsActionButton(boolean isActionButton) {
        if (isActionButton) {
            this.mFlags |= 32;
        } else {
            this.mFlags &= -33;
        }
    }

    public boolean showsTextAsAction() {
        return (this.mShowAsAction & 4) == 4;
    }

    @Override // android.support.v4.internal.view.SupportMenuItem, android.view.MenuItem
    public void setShowAsAction(int actionEnum) {
        switch (actionEnum & 3) {
            case 0:
            case 1:
            case 2:
                this.mShowAsAction = actionEnum;
                this.mMenu.onItemActionRequestChanged(this);
                return;
            default:
                throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
        }
    }

    @Override // android.support.v4.internal.view.SupportMenuItem, android.view.MenuItem
    public SupportMenuItem setActionView(View view) {
        this.mActionView = view;
        this.mActionProvider = null;
        if (view != null && view.getId() == -1 && this.mId > 0) {
            view.setId(this.mId);
        }
        this.mMenu.onItemActionRequestChanged(this);
        return this;
    }

    @Override // android.support.v4.internal.view.SupportMenuItem, android.view.MenuItem
    public SupportMenuItem setActionView(int resId) {
        Context context = this.mMenu.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        setActionView(inflater.inflate(resId, (ViewGroup) new LinearLayout(context), false));
        return this;
    }

    @Override // android.support.v4.internal.view.SupportMenuItem, android.view.MenuItem
    public View getActionView() {
        if (this.mActionView != null) {
            return this.mActionView;
        }
        if (this.mActionProvider != null) {
            this.mActionView = this.mActionProvider.onCreateActionView(this);
            return this.mActionView;
        }
        return null;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(android.view.ActionProvider actionProvider) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
    }

    @Override // android.view.MenuItem
    public android.view.ActionProvider getActionProvider() {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
    }

    @Override // android.support.v4.internal.view.SupportMenuItem
    public ActionProvider getSupportActionProvider() {
        return this.mActionProvider;
    }

    @Override // android.support.v4.internal.view.SupportMenuItem
    public SupportMenuItem setSupportActionProvider(ActionProvider actionProvider) {
        if (this.mActionProvider != null) {
            this.mActionProvider.setVisibilityListener(null);
        }
        this.mActionView = null;
        this.mActionProvider = actionProvider;
        this.mMenu.onItemsChanged(true);
        if (this.mActionProvider != null) {
            this.mActionProvider.setVisibilityListener(new ActionProvider.VisibilityListener() { // from class: android.support.v7.internal.view.menu.MenuItemImpl.1
                @Override // android.support.v4.view.ActionProvider.VisibilityListener
                public void onActionProviderVisibilityChanged(boolean isVisible) {
                    MenuItemImpl.this.mMenu.onItemVisibleChanged(MenuItemImpl.this);
                }
            });
        }
        return this;
    }

    @Override // android.support.v4.internal.view.SupportMenuItem, android.view.MenuItem
    public SupportMenuItem setShowAsActionFlags(int actionEnum) {
        setShowAsAction(actionEnum);
        return this;
    }

    @Override // android.support.v4.internal.view.SupportMenuItem, android.view.MenuItem
    public boolean expandActionView() {
        if (hasCollapsibleActionView()) {
            if (this.mOnActionExpandListener == null || this.mOnActionExpandListener.onMenuItemActionExpand(this)) {
                return this.mMenu.expandItemActionView(this);
            }
            return false;
        }
        return false;
    }

    @Override // android.support.v4.internal.view.SupportMenuItem, android.view.MenuItem
    public boolean collapseActionView() {
        if ((this.mShowAsAction & 8) == 0) {
            return false;
        }
        if (this.mActionView == null) {
            return true;
        }
        if (this.mOnActionExpandListener == null || this.mOnActionExpandListener.onMenuItemActionCollapse(this)) {
            return this.mMenu.collapseItemActionView(this);
        }
        return false;
    }

    @Override // android.support.v4.internal.view.SupportMenuItem
    public SupportMenuItem setSupportOnActionExpandListener(MenuItemCompat.OnActionExpandListener listener) {
        this.mOnActionExpandListener = listener;
        return this;
    }

    public boolean hasCollapsibleActionView() {
        if ((this.mShowAsAction & 8) != 0) {
            if (this.mActionView == null && this.mActionProvider != null) {
                this.mActionView = this.mActionProvider.onCreateActionView(this);
            }
            return this.mActionView != null;
        }
        return false;
    }

    public void setActionViewExpanded(boolean isExpanded) {
        this.mIsActionViewExpanded = isExpanded;
        this.mMenu.onItemsChanged(false);
    }

    @Override // android.support.v4.internal.view.SupportMenuItem, android.view.MenuItem
    public boolean isActionViewExpanded() {
        return this.mIsActionViewExpanded;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener listener) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setOnActionExpandListener()");
    }
}