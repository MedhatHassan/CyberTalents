package android.support.v7.internal.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.os.Parcelable;
import android.support.v7.appcompat.R;
import android.support.v7.internal.view.menu.MenuPresenter;
import android.support.v7.internal.view.menu.MenuView;
import android.support.v7.widget.ListPopupWindow;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class MenuPopupHelper implements AdapterView.OnItemClickListener, View.OnKeyListener, ViewTreeObserver.OnGlobalLayoutListener, PopupWindow.OnDismissListener, MenuPresenter {
    static final int ITEM_LAYOUT = R.layout.abc_popup_menu_item_layout;
    private static final String TAG = "MenuPopupHelper";
    private final MenuAdapter mAdapter;
    private View mAnchorView;
    private int mContentWidth;
    private final Context mContext;
    private int mDropDownGravity;
    boolean mForceShowIcon;
    private boolean mHasContentWidth;
    private final LayoutInflater mInflater;
    private ViewGroup mMeasureParent;
    private final MenuBuilder mMenu;
    private final boolean mOverflowOnly;
    private ListPopupWindow mPopup;
    private final int mPopupMaxWidth;
    private final int mPopupStyleAttr;
    private final int mPopupStyleRes;
    private MenuPresenter.Callback mPresenterCallback;
    private ViewTreeObserver mTreeObserver;

    public MenuPopupHelper(Context context, MenuBuilder menu) {
        this(context, menu, null, false, R.attr.popupMenuStyle);
    }

    public MenuPopupHelper(Context context, MenuBuilder menu, View anchorView) {
        this(context, menu, anchorView, false, R.attr.popupMenuStyle);
    }

    public MenuPopupHelper(Context context, MenuBuilder menu, View anchorView, boolean overflowOnly, int popupStyleAttr) {
        this(context, menu, anchorView, overflowOnly, popupStyleAttr, 0);
    }

    public MenuPopupHelper(Context context, MenuBuilder menu, View anchorView, boolean overflowOnly, int popupStyleAttr, int popupStyleRes) {
        this.mDropDownGravity = 0;
        this.mContext = context;
        this.mInflater = LayoutInflater.from(context);
        this.mMenu = menu;
        this.mAdapter = new MenuAdapter(this.mMenu);
        this.mOverflowOnly = overflowOnly;
        this.mPopupStyleAttr = popupStyleAttr;
        this.mPopupStyleRes = popupStyleRes;
        Resources res = context.getResources();
        this.mPopupMaxWidth = Math.max(res.getDisplayMetrics().widthPixels / 2, res.getDimensionPixelSize(R.dimen.abc_config_prefDialogWidth));
        this.mAnchorView = anchorView;
        menu.addMenuPresenter(this, context);
    }

    public void setAnchorView(View anchor) {
        this.mAnchorView = anchor;
    }

    public void setForceShowIcon(boolean forceShow) {
        this.mForceShowIcon = forceShow;
    }

    public void setGravity(int gravity) {
        this.mDropDownGravity = gravity;
    }

    public void show() {
        if (!tryShow()) {
            throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
        }
    }

    public ListPopupWindow getPopup() {
        return this.mPopup;
    }

    public boolean tryShow() {
        this.mPopup = new ListPopupWindow(this.mContext, null, this.mPopupStyleAttr, this.mPopupStyleRes);
        this.mPopup.setOnDismissListener(this);
        this.mPopup.setOnItemClickListener(this);
        this.mPopup.setAdapter(this.mAdapter);
        this.mPopup.setModal(true);
        View anchor = this.mAnchorView;
        if (anchor != null) {
            boolean addGlobalListener = this.mTreeObserver == null;
            this.mTreeObserver = anchor.getViewTreeObserver();
            if (addGlobalListener) {
                this.mTreeObserver.addOnGlobalLayoutListener(this);
            }
            this.mPopup.setAnchorView(anchor);
            this.mPopup.setDropDownGravity(this.mDropDownGravity);
            if (!this.mHasContentWidth) {
                this.mContentWidth = measureContentWidth();
                this.mHasContentWidth = true;
            }
            this.mPopup.setContentWidth(this.mContentWidth);
            this.mPopup.setInputMethodMode(2);
            this.mPopup.show();
            this.mPopup.getListView().setOnKeyListener(this);
            return true;
        }
        return false;
    }

    public void dismiss() {
        if (isShowing()) {
            this.mPopup.dismiss();
        }
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.mPopup = null;
        this.mMenu.close();
        if (this.mTreeObserver != null) {
            if (!this.mTreeObserver.isAlive()) {
                this.mTreeObserver = this.mAnchorView.getViewTreeObserver();
            }
            this.mTreeObserver.removeGlobalOnLayoutListener(this);
            this.mTreeObserver = null;
        }
    }

    public boolean isShowing() {
        return this.mPopup != null && this.mPopup.isShowing();
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        MenuAdapter adapter = this.mAdapter;
        adapter.mAdapterMenu.performItemAction(adapter.getItem(position), 0);
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View v, int keyCode, KeyEvent event) {
        if (event.getAction() == 1 && keyCode == 82) {
            dismiss();
            return true;
        }
        return false;
    }

    private int measureContentWidth() {
        int maxWidth = 0;
        View itemView = null;
        int itemType = 0;
        ListAdapter adapter = this.mAdapter;
        int widthMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int heightMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int count = adapter.getCount();
        for (int i = 0; i < count; i++) {
            int positionType = adapter.getItemViewType(i);
            if (positionType != itemType) {
                itemType = positionType;
                itemView = null;
            }
            if (this.mMeasureParent == null) {
                this.mMeasureParent = new FrameLayout(this.mContext);
            }
            itemView = adapter.getView(i, itemView, this.mMeasureParent);
            itemView.measure(widthMeasureSpec, heightMeasureSpec);
            int itemWidth = itemView.getMeasuredWidth();
            if (itemWidth >= this.mPopupMaxWidth) {
                int maxWidth2 = this.mPopupMaxWidth;
                return maxWidth2;
            }
            if (itemWidth > maxWidth) {
                maxWidth = itemWidth;
            }
        }
        return maxWidth;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        if (isShowing()) {
            View anchor = this.mAnchorView;
            if (anchor == null || !anchor.isShown()) {
                dismiss();
            } else if (isShowing()) {
                this.mPopup.show();
            }
        }
    }

    @Override // android.support.v7.internal.view.menu.MenuPresenter
    public void initForMenu(Context context, MenuBuilder menu) {
    }

    @Override // android.support.v7.internal.view.menu.MenuPresenter
    public MenuView getMenuView(ViewGroup root) {
        throw new UnsupportedOperationException("MenuPopupHelpers manage their own views");
    }

    @Override // android.support.v7.internal.view.menu.MenuPresenter
    public void updateMenuView(boolean cleared) {
        this.mHasContentWidth = false;
        if (this.mAdapter != null) {
            this.mAdapter.notifyDataSetChanged();
        }
    }

    @Override // android.support.v7.internal.view.menu.MenuPresenter
    public void setCallback(MenuPresenter.Callback cb) {
        this.mPresenterCallback = cb;
    }

    @Override // android.support.v7.internal.view.menu.MenuPresenter
    public boolean onSubMenuSelected(SubMenuBuilder subMenu) {
        if (subMenu.hasVisibleItems()) {
            MenuPopupHelper subPopup = new MenuPopupHelper(this.mContext, subMenu, this.mAnchorView);
            subPopup.setCallback(this.mPresenterCallback);
            boolean preserveIconSpacing = false;
            int count = subMenu.size();
            int i = 0;
            while (true) {
                if (i >= count) {
                    break;
                }
                MenuItem childItem = subMenu.getItem(i);
                if (!childItem.isVisible() || childItem.getIcon() == null) {
                    i++;
                } else {
                    preserveIconSpacing = true;
                    break;
                }
            }
            subPopup.setForceShowIcon(preserveIconSpacing);
            if (subPopup.tryShow()) {
                if (this.mPresenterCallback != null) {
                    this.mPresenterCallback.onOpenSubMenu(subMenu);
                }
                return true;
            }
        }
        return false;
    }

    @Override // android.support.v7.internal.view.menu.MenuPresenter
    public void onCloseMenu(MenuBuilder menu, boolean allMenusAreClosing) {
        if (menu == this.mMenu) {
            dismiss();
            if (this.mPresenterCallback != null) {
                this.mPresenterCallback.onCloseMenu(menu, allMenusAreClosing);
            }
        }
    }

    @Override // android.support.v7.internal.view.menu.MenuPresenter
    public boolean flagActionItems() {
        return false;
    }

    @Override // android.support.v7.internal.view.menu.MenuPresenter
    public boolean expandItemActionView(MenuBuilder menu, MenuItemImpl item) {
        return false;
    }

    @Override // android.support.v7.internal.view.menu.MenuPresenter
    public boolean collapseItemActionView(MenuBuilder menu, MenuItemImpl item) {
        return false;
    }

    @Override // android.support.v7.internal.view.menu.MenuPresenter
    public int getId() {
        return 0;
    }

    @Override // android.support.v7.internal.view.menu.MenuPresenter
    public Parcelable onSaveInstanceState() {
        return null;
    }

    @Override // android.support.v7.internal.view.menu.MenuPresenter
    public void onRestoreInstanceState(Parcelable state) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class MenuAdapter extends BaseAdapter {
        private MenuBuilder mAdapterMenu;
        private int mExpandedIndex = -1;

        public MenuAdapter(MenuBuilder menu) {
            this.mAdapterMenu = menu;
            findExpandedIndex();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            ArrayList<MenuItemImpl> items = MenuPopupHelper.this.mOverflowOnly ? this.mAdapterMenu.getNonActionItems() : this.mAdapterMenu.getVisibleItems();
            if (this.mExpandedIndex < 0) {
                return items.size();
            }
            return items.size() - 1;
        }

        @Override // android.widget.Adapter
        public MenuItemImpl getItem(int position) {
            ArrayList<MenuItemImpl> items = MenuPopupHelper.this.mOverflowOnly ? this.mAdapterMenu.getNonActionItems() : this.mAdapterMenu.getVisibleItems();
            if (this.mExpandedIndex >= 0 && position >= this.mExpandedIndex) {
                position++;
            }
            return items.get(position);
        }

        @Override // android.widget.Adapter
        public long getItemId(int position) {
            return position;
        }

        @Override // android.widget.Adapter
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = MenuPopupHelper.this.mInflater.inflate(MenuPopupHelper.ITEM_LAYOUT, parent, false);
            }
            MenuView.ItemView itemView = (MenuView.ItemView) convertView;
            if (MenuPopupHelper.this.mForceShowIcon) {
                ((ListMenuItemView) convertView).setForceShowIcon(true);
            }
            itemView.initialize(getItem(position), 0);
            return convertView;
        }

        void findExpandedIndex() {
            MenuItemImpl expandedItem = MenuPopupHelper.this.mMenu.getExpandedItem();
            if (expandedItem != null) {
                ArrayList<MenuItemImpl> items = MenuPopupHelper.this.mMenu.getNonActionItems();
                int count = items.size();
                for (int i = 0; i < count; i++) {
                    MenuItemImpl item = items.get(i);
                    if (item == expandedItem) {
                        this.mExpandedIndex = i;
                        return;
                    }
                }
            }
            this.mExpandedIndex = -1;
        }

        @Override // android.widget.BaseAdapter
        public void notifyDataSetChanged() {
            findExpandedIndex();
            super.notifyDataSetChanged();
        }
    }
}