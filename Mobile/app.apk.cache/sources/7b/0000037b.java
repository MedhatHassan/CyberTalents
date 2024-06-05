package android.support.v7.internal.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.R;
import android.support.v7.internal.text.AllCapsTransformationMethod;
import android.support.v7.internal.view.menu.MenuBuilder;
import android.support.v7.internal.view.menu.MenuView;
import android.support.v7.internal.widget.CompatTextView;
import android.support.v7.widget.ActionMenuView;
import android.support.v7.widget.ListPopupWindow;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

/* loaded from: classes.dex */
public class ActionMenuItemView extends CompatTextView implements MenuView.ItemView, View.OnClickListener, View.OnLongClickListener, ActionMenuView.ActionMenuChildView {
    private static final int MAX_ICON_SIZE = 32;
    private static final String TAG = "ActionMenuItemView";
    private boolean mAllowTextWithIcon;
    private boolean mExpandedFormat;
    private ListPopupWindow.ForwardingListener mForwardingListener;
    private Drawable mIcon;
    private MenuItemImpl mItemData;
    private MenuBuilder.ItemInvoker mItemInvoker;
    private int mMaxIconSize;
    private int mMinWidth;
    private PopupCallback mPopupCallback;
    private int mSavedPaddingLeft;
    private CharSequence mTitle;

    /* loaded from: classes.dex */
    public static abstract class PopupCallback {
        public abstract ListPopupWindow getPopup();
    }

    public ActionMenuItemView(Context context) {
        this(context, null);
    }

    public ActionMenuItemView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ActionMenuItemView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        Resources res = context.getResources();
        this.mAllowTextWithIcon = res.getBoolean(R.bool.abc_config_allowActionMenuItemTextWithIcon);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.ActionMenuItemView, defStyle, 0);
        this.mMinWidth = a.getDimensionPixelSize(R.styleable.ActionMenuItemView_android_minWidth, 0);
        a.recycle();
        float density = res.getDisplayMetrics().density;
        this.mMaxIconSize = (int) ((32.0f * density) + 0.5f);
        setOnClickListener(this);
        setOnLongClickListener(this);
        setTransformationMethod(new AllCapsTransformationMethod(context));
        this.mSavedPaddingLeft = -1;
    }

    @Override // android.widget.TextView, android.view.View
    public void onConfigurationChanged(Configuration newConfig) {
        if (Build.VERSION.SDK_INT >= 8) {
            super.onConfigurationChanged(newConfig);
        }
        this.mAllowTextWithIcon = getContext().getResources().getBoolean(R.bool.abc_config_allowActionMenuItemTextWithIcon);
        updateTextButtonVisibility();
    }

    @Override // android.widget.TextView, android.view.View
    public void setPadding(int l, int t, int r, int b) {
        this.mSavedPaddingLeft = l;
        super.setPadding(l, t, r, b);
    }

    @Override // android.support.v7.internal.view.menu.MenuView.ItemView
    public MenuItemImpl getItemData() {
        return this.mItemData;
    }

    @Override // android.support.v7.internal.view.menu.MenuView.ItemView
    public void initialize(MenuItemImpl itemData, int menuType) {
        this.mItemData = itemData;
        setIcon(itemData.getIcon());
        setTitle(itemData.getTitleForItemView(this));
        setId(itemData.getItemId());
        setVisibility(itemData.isVisible() ? 0 : 8);
        setEnabled(itemData.isEnabled());
        if (itemData.hasSubMenu() && this.mForwardingListener == null) {
            this.mForwardingListener = new ActionMenuItemForwardingListener();
        }
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent e) {
        if (this.mItemData.hasSubMenu() && this.mForwardingListener != null && this.mForwardingListener.onTouch(this, e)) {
            return true;
        }
        return super.onTouchEvent(e);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        if (this.mItemInvoker != null) {
            this.mItemInvoker.invokeItem(this.mItemData);
        }
    }

    public void setItemInvoker(MenuBuilder.ItemInvoker invoker) {
        this.mItemInvoker = invoker;
    }

    public void setPopupCallback(PopupCallback popupCallback) {
        this.mPopupCallback = popupCallback;
    }

    @Override // android.support.v7.internal.view.menu.MenuView.ItemView
    public boolean prefersCondensedTitle() {
        return true;
    }

    @Override // android.support.v7.internal.view.menu.MenuView.ItemView
    public void setCheckable(boolean checkable) {
    }

    @Override // android.support.v7.internal.view.menu.MenuView.ItemView
    public void setChecked(boolean checked) {
    }

    public void setExpandedFormat(boolean expandedFormat) {
        if (this.mExpandedFormat != expandedFormat) {
            this.mExpandedFormat = expandedFormat;
            if (this.mItemData != null) {
                this.mItemData.actionFormatChanged();
            }
        }
    }

    private void updateTextButtonVisibility() {
        boolean z = false;
        boolean visible = !TextUtils.isEmpty(this.mTitle);
        if (this.mIcon == null || (this.mItemData.showsTextAsAction() && (this.mAllowTextWithIcon || this.mExpandedFormat))) {
            z = true;
        }
        setText(visible & z ? this.mTitle : null);
    }

    @Override // android.support.v7.internal.view.menu.MenuView.ItemView
    public void setIcon(Drawable icon) {
        this.mIcon = icon;
        if (icon != null) {
            int width = icon.getIntrinsicWidth();
            int height = icon.getIntrinsicHeight();
            if (width > this.mMaxIconSize) {
                float scale = this.mMaxIconSize / width;
                width = this.mMaxIconSize;
                height = (int) (height * scale);
            }
            if (height > this.mMaxIconSize) {
                float scale2 = this.mMaxIconSize / height;
                height = this.mMaxIconSize;
                width = (int) (width * scale2);
            }
            icon.setBounds(0, 0, width, height);
        }
        setCompoundDrawables(icon, null, null, null);
        updateTextButtonVisibility();
    }

    public boolean hasText() {
        return !TextUtils.isEmpty(getText());
    }

    @Override // android.support.v7.internal.view.menu.MenuView.ItemView
    public void setShortcut(boolean showShortcut, char shortcutKey) {
    }

    @Override // android.support.v7.internal.view.menu.MenuView.ItemView
    public void setTitle(CharSequence title) {
        this.mTitle = title;
        setContentDescription(this.mTitle);
        updateTextButtonVisibility();
    }

    @Override // android.support.v7.internal.view.menu.MenuView.ItemView
    public boolean showsIcon() {
        return true;
    }

    @Override // android.support.v7.widget.ActionMenuView.ActionMenuChildView
    public boolean needsDividerBefore() {
        return hasText() && this.mItemData.getIcon() == null;
    }

    @Override // android.support.v7.widget.ActionMenuView.ActionMenuChildView
    public boolean needsDividerAfter() {
        return hasText();
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View v) {
        if (hasText()) {
            return false;
        }
        int[] screenPos = new int[2];
        Rect displayFrame = new Rect();
        getLocationOnScreen(screenPos);
        getWindowVisibleDisplayFrame(displayFrame);
        Context context = getContext();
        int width = getWidth();
        int height = getHeight();
        int midy = screenPos[1] + (height / 2);
        int referenceX = screenPos[0] + (width / 2);
        if (ViewCompat.getLayoutDirection(v) == 0) {
            int screenWidth = context.getResources().getDisplayMetrics().widthPixels;
            referenceX = screenWidth - referenceX;
        }
        Toast cheatSheet = Toast.makeText(context, this.mItemData.getTitle(), 0);
        if (midy < displayFrame.height()) {
            cheatSheet.setGravity(8388661, referenceX, height);
        } else {
            cheatSheet.setGravity(81, 0, height);
        }
        cheatSheet.show();
        return true;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        boolean textVisible = hasText();
        if (textVisible && this.mSavedPaddingLeft >= 0) {
            super.setPadding(this.mSavedPaddingLeft, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthMode = View.MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = View.MeasureSpec.getSize(widthMeasureSpec);
        int oldMeasuredWidth = getMeasuredWidth();
        int targetWidth = widthMode == Integer.MIN_VALUE ? Math.min(widthSize, this.mMinWidth) : this.mMinWidth;
        if (widthMode != 1073741824 && this.mMinWidth > 0 && oldMeasuredWidth < targetWidth) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(targetWidth, 1073741824), heightMeasureSpec);
        }
        if (!textVisible && this.mIcon != null) {
            int w = getMeasuredWidth();
            int dw = this.mIcon.getBounds().width();
            super.setPadding((w - dw) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
    }

    /* loaded from: classes.dex */
    private class ActionMenuItemForwardingListener extends ListPopupWindow.ForwardingListener {
        public ActionMenuItemForwardingListener() {
            super(ActionMenuItemView.this);
        }

        @Override // android.support.v7.widget.ListPopupWindow.ForwardingListener
        public ListPopupWindow getPopup() {
            if (ActionMenuItemView.this.mPopupCallback != null) {
                return ActionMenuItemView.this.mPopupCallback.getPopup();
            }
            return null;
        }

        @Override // android.support.v7.widget.ListPopupWindow.ForwardingListener
        protected boolean onForwardingStarted() {
            ListPopupWindow popup;
            return ActionMenuItemView.this.mItemInvoker != null && ActionMenuItemView.this.mItemInvoker.invokeItem(ActionMenuItemView.this.mItemData) && (popup = getPopup()) != null && popup.isShowing();
        }

        @Override // android.support.v7.widget.ListPopupWindow.ForwardingListener
        protected boolean onForwardingStopped() {
            ListPopupWindow popup = getPopup();
            if (popup != null) {
                popup.dismiss();
                return true;
            }
            return false;
        }
    }
}