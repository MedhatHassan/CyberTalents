package android.support.v7.widget;

import android.content.Context;
import android.support.v7.appcompat.R;
import android.support.v7.internal.view.SupportMenuInflater;
import android.support.v7.internal.view.menu.MenuBuilder;
import android.support.v7.internal.view.menu.MenuPopupHelper;
import android.support.v7.internal.view.menu.MenuPresenter;
import android.support.v7.internal.view.menu.SubMenuBuilder;
import android.support.v7.widget.ListPopupWindow;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

/* loaded from: classes.dex */
public class PopupMenu implements MenuBuilder.Callback, MenuPresenter.Callback {
    private View mAnchor;
    private Context mContext;
    private OnDismissListener mDismissListener;
    private View.OnTouchListener mDragListener;
    private MenuBuilder mMenu;
    private OnMenuItemClickListener mMenuItemClickListener;
    private MenuPopupHelper mPopup;

    /* loaded from: classes.dex */
    public interface OnDismissListener {
        void onDismiss(PopupMenu popupMenu);
    }

    /* loaded from: classes.dex */
    public interface OnMenuItemClickListener {
        boolean onMenuItemClick(MenuItem menuItem);
    }

    public PopupMenu(Context context, View anchor) {
        this(context, anchor, 0);
    }

    public PopupMenu(Context context, View anchor, int gravity) {
        this(context, anchor, gravity, R.attr.popupMenuStyle, 0);
    }

    public PopupMenu(Context context, View anchor, int gravity, int popupStyleAttr, int popupStyleRes) {
        this.mContext = context;
        this.mMenu = new MenuBuilder(context);
        this.mMenu.setCallback(this);
        this.mAnchor = anchor;
        this.mPopup = new MenuPopupHelper(context, this.mMenu, anchor, false, popupStyleAttr, popupStyleRes);
        this.mPopup.setGravity(gravity);
        this.mPopup.setCallback(this);
    }

    public View.OnTouchListener getDragToOpenListener() {
        if (this.mDragListener == null) {
            this.mDragListener = new ListPopupWindow.ForwardingListener(this.mAnchor) { // from class: android.support.v7.widget.PopupMenu.1
                @Override // android.support.v7.widget.ListPopupWindow.ForwardingListener
                protected boolean onForwardingStarted() {
                    PopupMenu.this.show();
                    return true;
                }

                @Override // android.support.v7.widget.ListPopupWindow.ForwardingListener
                protected boolean onForwardingStopped() {
                    PopupMenu.this.dismiss();
                    return true;
                }

                @Override // android.support.v7.widget.ListPopupWindow.ForwardingListener
                public ListPopupWindow getPopup() {
                    return PopupMenu.this.mPopup.getPopup();
                }
            };
        }
        return this.mDragListener;
    }

    public Menu getMenu() {
        return this.mMenu;
    }

    public MenuInflater getMenuInflater() {
        return new SupportMenuInflater(this.mContext);
    }

    public void inflate(int menuRes) {
        getMenuInflater().inflate(menuRes, this.mMenu);
    }

    public void show() {
        this.mPopup.show();
    }

    public void dismiss() {
        this.mPopup.dismiss();
    }

    public void setOnMenuItemClickListener(OnMenuItemClickListener listener) {
        this.mMenuItemClickListener = listener;
    }

    public void setOnDismissListener(OnDismissListener listener) {
        this.mDismissListener = listener;
    }

    @Override // android.support.v7.internal.view.menu.MenuBuilder.Callback
    public boolean onMenuItemSelected(MenuBuilder menu, MenuItem item) {
        if (this.mMenuItemClickListener != null) {
            return this.mMenuItemClickListener.onMenuItemClick(item);
        }
        return false;
    }

    @Override // android.support.v7.internal.view.menu.MenuPresenter.Callback
    public void onCloseMenu(MenuBuilder menu, boolean allMenusAreClosing) {
        if (this.mDismissListener != null) {
            this.mDismissListener.onDismiss(this);
        }
    }

    @Override // android.support.v7.internal.view.menu.MenuPresenter.Callback
    public boolean onOpenSubMenu(MenuBuilder subMenu) {
        if (subMenu == null) {
            return false;
        }
        if (subMenu.hasVisibleItems()) {
            new MenuPopupHelper(this.mContext, subMenu, this.mAnchor).show();
            return true;
        }
        return true;
    }

    public void onCloseSubMenu(SubMenuBuilder menu) {
    }

    @Override // android.support.v7.internal.view.menu.MenuBuilder.Callback
    public void onMenuModeChange(MenuBuilder menu) {
    }
}