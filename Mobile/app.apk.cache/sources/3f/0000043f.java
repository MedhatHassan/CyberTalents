package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.MarginLayoutParamsCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.appcompat.R;
import android.support.v7.internal.view.SupportMenuInflater;
import android.support.v7.internal.view.menu.MenuBuilder;
import android.support.v7.internal.view.menu.MenuItemImpl;
import android.support.v7.internal.view.menu.MenuPresenter;
import android.support.v7.internal.view.menu.MenuView;
import android.support.v7.internal.view.menu.SubMenuBuilder;
import android.support.v7.internal.widget.DecorToolbar;
import android.support.v7.internal.widget.RtlSpacingHelper;
import android.support.v7.internal.widget.TintManager;
import android.support.v7.internal.widget.TintTypedArray;
import android.support.v7.internal.widget.ToolbarWidgetWrapper;
import android.support.v7.internal.widget.ViewUtils;
import android.support.v7.view.CollapsibleActionView;
import android.support.v7.widget.ActionMenuView;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class Toolbar extends ViewGroup {
    private static final String TAG = "Toolbar";
    private MenuPresenter.Callback mActionMenuPresenterCallback;
    private int mButtonGravity;
    private ImageButton mCollapseButtonView;
    private CharSequence mCollapseDescription;
    private Drawable mCollapseIcon;
    private boolean mCollapsible;
    private final RtlSpacingHelper mContentInsets;
    private boolean mEatingTouch;
    View mExpandedActionView;
    private ExpandedActionViewMenuPresenter mExpandedMenuPresenter;
    private int mGravity;
    private ImageView mLogoView;
    private int mMaxButtonHeight;
    private MenuBuilder.Callback mMenuBuilderCallback;
    private ActionMenuView mMenuView;
    private final ActionMenuView.OnMenuItemClickListener mMenuViewItemClickListener;
    private int mMinHeight;
    private ImageButton mNavButtonView;
    private OnMenuItemClickListener mOnMenuItemClickListener;
    private ActionMenuPresenter mOuterActionMenuPresenter;
    private Context mPopupContext;
    private int mPopupTheme;
    private final Runnable mShowOverflowMenuRunnable;
    private CharSequence mSubtitleText;
    private int mSubtitleTextAppearance;
    private int mSubtitleTextColor;
    private TextView mSubtitleTextView;
    private final int[] mTempMargins;
    private final ArrayList<View> mTempViews;
    private final TintManager mTintManager;
    private int mTitleMarginBottom;
    private int mTitleMarginEnd;
    private int mTitleMarginStart;
    private int mTitleMarginTop;
    private CharSequence mTitleText;
    private int mTitleTextAppearance;
    private int mTitleTextColor;
    private TextView mTitleTextView;
    private ToolbarWidgetWrapper mWrapper;

    /* loaded from: classes.dex */
    public interface OnMenuItemClickListener {
        boolean onMenuItemClick(MenuItem menuItem);
    }

    public Toolbar(Context context) {
        this(context, null);
    }

    public Toolbar(Context context, AttributeSet attrs) {
        this(context, attrs, R.attr.toolbarStyle);
    }

    public Toolbar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(themifyContext(context, attrs, defStyleAttr), attrs, defStyleAttr);
        this.mContentInsets = new RtlSpacingHelper();
        this.mGravity = 8388627;
        this.mTempViews = new ArrayList<>();
        this.mTempMargins = new int[2];
        this.mMenuViewItemClickListener = new ActionMenuView.OnMenuItemClickListener() { // from class: android.support.v7.widget.Toolbar.1
            @Override // android.support.v7.widget.ActionMenuView.OnMenuItemClickListener
            public boolean onMenuItemClick(MenuItem item) {
                if (Toolbar.this.mOnMenuItemClickListener != null) {
                    return Toolbar.this.mOnMenuItemClickListener.onMenuItemClick(item);
                }
                return false;
            }
        };
        this.mShowOverflowMenuRunnable = new Runnable() { // from class: android.support.v7.widget.Toolbar.2
            @Override // java.lang.Runnable
            public void run() {
                Toolbar.this.showOverflowMenu();
            }
        };
        TintTypedArray a = TintTypedArray.obtainStyledAttributes(getContext(), attrs, R.styleable.Toolbar, defStyleAttr, 0);
        this.mTitleTextAppearance = a.getResourceId(R.styleable.Toolbar_titleTextAppearance, 0);
        this.mSubtitleTextAppearance = a.getResourceId(R.styleable.Toolbar_subtitleTextAppearance, 0);
        this.mGravity = a.getInteger(R.styleable.Toolbar_android_gravity, this.mGravity);
        this.mButtonGravity = 48;
        int dimensionPixelOffset = a.getDimensionPixelOffset(R.styleable.Toolbar_titleMargins, 0);
        this.mTitleMarginBottom = dimensionPixelOffset;
        this.mTitleMarginTop = dimensionPixelOffset;
        this.mTitleMarginEnd = dimensionPixelOffset;
        this.mTitleMarginStart = dimensionPixelOffset;
        int marginStart = a.getDimensionPixelOffset(R.styleable.Toolbar_titleMarginStart, -1);
        if (marginStart >= 0) {
            this.mTitleMarginStart = marginStart;
        }
        int marginEnd = a.getDimensionPixelOffset(R.styleable.Toolbar_titleMarginEnd, -1);
        if (marginEnd >= 0) {
            this.mTitleMarginEnd = marginEnd;
        }
        int marginTop = a.getDimensionPixelOffset(R.styleable.Toolbar_titleMarginTop, -1);
        if (marginTop >= 0) {
            this.mTitleMarginTop = marginTop;
        }
        int marginBottom = a.getDimensionPixelOffset(R.styleable.Toolbar_titleMarginBottom, -1);
        if (marginBottom >= 0) {
            this.mTitleMarginBottom = marginBottom;
        }
        this.mMaxButtonHeight = a.getDimensionPixelSize(R.styleable.Toolbar_maxButtonHeight, -1);
        int contentInsetStart = a.getDimensionPixelOffset(R.styleable.Toolbar_contentInsetStart, Integer.MIN_VALUE);
        int contentInsetEnd = a.getDimensionPixelOffset(R.styleable.Toolbar_contentInsetEnd, Integer.MIN_VALUE);
        int contentInsetLeft = a.getDimensionPixelSize(R.styleable.Toolbar_contentInsetLeft, 0);
        int contentInsetRight = a.getDimensionPixelSize(R.styleable.Toolbar_contentInsetRight, 0);
        this.mContentInsets.setAbsolute(contentInsetLeft, contentInsetRight);
        if (contentInsetStart != Integer.MIN_VALUE || contentInsetEnd != Integer.MIN_VALUE) {
            this.mContentInsets.setRelative(contentInsetStart, contentInsetEnd);
        }
        this.mCollapseIcon = a.getDrawable(R.styleable.Toolbar_collapseIcon);
        this.mCollapseDescription = a.getText(R.styleable.Toolbar_collapseContentDescription);
        CharSequence title = a.getText(R.styleable.Toolbar_title);
        if (!TextUtils.isEmpty(title)) {
            setTitle(title);
        }
        CharSequence subtitle = a.getText(R.styleable.Toolbar_subtitle);
        if (!TextUtils.isEmpty(subtitle)) {
            setSubtitle(subtitle);
        }
        this.mPopupContext = getContext();
        setPopupTheme(a.getResourceId(R.styleable.Toolbar_popupTheme, 0));
        Drawable navIcon = a.getDrawable(R.styleable.Toolbar_navigationIcon);
        if (navIcon != null) {
            setNavigationIcon(navIcon);
        }
        CharSequence navDesc = a.getText(R.styleable.Toolbar_navigationContentDescription);
        if (!TextUtils.isEmpty(navDesc)) {
            setNavigationContentDescription(navDesc);
        }
        this.mMinHeight = a.getDimensionPixelSize(R.styleable.Toolbar_android_minHeight, 0);
        a.recycle();
        this.mTintManager = a.getTintManager();
    }

    public void setPopupTheme(int resId) {
        if (this.mPopupTheme != resId) {
            this.mPopupTheme = resId;
            if (resId == 0) {
                this.mPopupContext = getContext();
            } else {
                this.mPopupContext = new ContextThemeWrapper(getContext(), resId);
            }
        }
    }

    public int getPopupTheme() {
        return this.mPopupTheme;
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int layoutDirection) {
        if (Build.VERSION.SDK_INT >= 17) {
            super.onRtlPropertiesChanged(layoutDirection);
        }
        this.mContentInsets.setDirection(layoutDirection == 1);
    }

    public void setLogo(int resId) {
        setLogo(this.mTintManager.getDrawable(resId));
    }

    public boolean canShowOverflowMenu() {
        return getVisibility() == 0 && this.mMenuView != null && this.mMenuView.isOverflowReserved();
    }

    public boolean isOverflowMenuShowing() {
        return this.mMenuView != null && this.mMenuView.isOverflowMenuShowing();
    }

    public boolean isOverflowMenuShowPending() {
        return this.mMenuView != null && this.mMenuView.isOverflowMenuShowPending();
    }

    public boolean showOverflowMenu() {
        return this.mMenuView != null && this.mMenuView.showOverflowMenu();
    }

    public boolean hideOverflowMenu() {
        return this.mMenuView != null && this.mMenuView.hideOverflowMenu();
    }

    public void setMenu(MenuBuilder menu, ActionMenuPresenter outerPresenter) {
        if (menu != null || this.mMenuView != null) {
            ensureMenuView();
            MenuBuilder oldMenu = this.mMenuView.peekMenu();
            if (oldMenu != menu) {
                if (oldMenu != null) {
                    oldMenu.removeMenuPresenter(this.mOuterActionMenuPresenter);
                    oldMenu.removeMenuPresenter(this.mExpandedMenuPresenter);
                }
                if (this.mExpandedMenuPresenter == null) {
                    this.mExpandedMenuPresenter = new ExpandedActionViewMenuPresenter();
                }
                outerPresenter.setExpandedActionViewsExclusive(true);
                if (menu != null) {
                    menu.addMenuPresenter(outerPresenter, this.mPopupContext);
                    menu.addMenuPresenter(this.mExpandedMenuPresenter, this.mPopupContext);
                } else {
                    outerPresenter.initForMenu(this.mPopupContext, null);
                    this.mExpandedMenuPresenter.initForMenu(this.mPopupContext, null);
                    outerPresenter.updateMenuView(true);
                    this.mExpandedMenuPresenter.updateMenuView(true);
                }
                this.mMenuView.setPopupTheme(this.mPopupTheme);
                this.mMenuView.setPresenter(outerPresenter);
                this.mOuterActionMenuPresenter = outerPresenter;
            }
        }
    }

    public void dismissPopupMenus() {
        if (this.mMenuView != null) {
            this.mMenuView.dismissPopupMenus();
        }
    }

    public boolean isTitleTruncated() {
        Layout titleLayout;
        if (this.mTitleTextView == null || (titleLayout = this.mTitleTextView.getLayout()) == null) {
            return false;
        }
        int lineCount = titleLayout.getLineCount();
        for (int i = 0; i < lineCount; i++) {
            if (titleLayout.getEllipsisCount(i) > 0) {
                return true;
            }
        }
        return false;
    }

    public void setLogo(Drawable drawable) {
        if (drawable != null) {
            ensureLogoView();
            if (this.mLogoView.getParent() == null) {
                addSystemView(this.mLogoView);
                updateChildVisibilityForExpandedActionView(this.mLogoView);
            }
        } else if (this.mLogoView != null && this.mLogoView.getParent() != null) {
            removeView(this.mLogoView);
        }
        if (this.mLogoView != null) {
            this.mLogoView.setImageDrawable(drawable);
        }
    }

    public Drawable getLogo() {
        if (this.mLogoView != null) {
            return this.mLogoView.getDrawable();
        }
        return null;
    }

    public void setLogoDescription(int resId) {
        setLogoDescription(getContext().getText(resId));
    }

    public void setLogoDescription(CharSequence description) {
        if (!TextUtils.isEmpty(description)) {
            ensureLogoView();
        }
        if (this.mLogoView != null) {
            this.mLogoView.setContentDescription(description);
        }
    }

    public CharSequence getLogoDescription() {
        if (this.mLogoView != null) {
            return this.mLogoView.getContentDescription();
        }
        return null;
    }

    private void ensureLogoView() {
        if (this.mLogoView == null) {
            this.mLogoView = new ImageView(getContext());
        }
    }

    public boolean hasExpandedActionView() {
        return (this.mExpandedMenuPresenter == null || this.mExpandedMenuPresenter.mCurrentExpandedItem == null) ? false : true;
    }

    public void collapseActionView() {
        MenuItemImpl item = this.mExpandedMenuPresenter == null ? null : this.mExpandedMenuPresenter.mCurrentExpandedItem;
        if (item != null) {
            item.collapseActionView();
        }
    }

    public CharSequence getTitle() {
        return this.mTitleText;
    }

    public void setTitle(int resId) {
        setTitle(getContext().getText(resId));
    }

    public void setTitle(CharSequence title) {
        if (!TextUtils.isEmpty(title)) {
            if (this.mTitleTextView == null) {
                Context context = getContext();
                this.mTitleTextView = new TextView(context);
                this.mTitleTextView.setSingleLine();
                this.mTitleTextView.setEllipsize(TextUtils.TruncateAt.END);
                if (this.mTitleTextAppearance != 0) {
                    this.mTitleTextView.setTextAppearance(context, this.mTitleTextAppearance);
                }
                if (this.mTitleTextColor != 0) {
                    this.mTitleTextView.setTextColor(this.mTitleTextColor);
                }
            }
            if (this.mTitleTextView.getParent() == null) {
                addSystemView(this.mTitleTextView);
                updateChildVisibilityForExpandedActionView(this.mTitleTextView);
            }
        } else if (this.mTitleTextView != null && this.mTitleTextView.getParent() != null) {
            removeView(this.mTitleTextView);
        }
        if (this.mTitleTextView != null) {
            this.mTitleTextView.setText(title);
        }
        this.mTitleText = title;
    }

    public CharSequence getSubtitle() {
        return this.mSubtitleText;
    }

    public void setSubtitle(int resId) {
        setSubtitle(getContext().getText(resId));
    }

    public void setSubtitle(CharSequence subtitle) {
        if (!TextUtils.isEmpty(subtitle)) {
            if (this.mSubtitleTextView == null) {
                Context context = getContext();
                this.mSubtitleTextView = new TextView(context);
                this.mSubtitleTextView.setSingleLine();
                this.mSubtitleTextView.setEllipsize(TextUtils.TruncateAt.END);
                if (this.mSubtitleTextAppearance != 0) {
                    this.mSubtitleTextView.setTextAppearance(context, this.mSubtitleTextAppearance);
                }
                if (this.mSubtitleTextColor != 0) {
                    this.mSubtitleTextView.setTextColor(this.mSubtitleTextColor);
                }
            }
            if (this.mSubtitleTextView.getParent() == null) {
                addSystemView(this.mSubtitleTextView);
                updateChildVisibilityForExpandedActionView(this.mSubtitleTextView);
            }
        } else if (this.mSubtitleTextView != null && this.mSubtitleTextView.getParent() != null) {
            removeView(this.mSubtitleTextView);
        }
        if (this.mSubtitleTextView != null) {
            this.mSubtitleTextView.setText(subtitle);
        }
        this.mSubtitleText = subtitle;
    }

    public void setTitleTextAppearance(Context context, int resId) {
        this.mTitleTextAppearance = resId;
        if (this.mTitleTextView != null) {
            this.mTitleTextView.setTextAppearance(context, resId);
        }
    }

    public void setSubtitleTextAppearance(Context context, int resId) {
        this.mSubtitleTextAppearance = resId;
        if (this.mSubtitleTextView != null) {
            this.mSubtitleTextView.setTextAppearance(context, resId);
        }
    }

    public void setTitleTextColor(int color) {
        this.mTitleTextColor = color;
        if (this.mTitleTextView != null) {
            this.mTitleTextView.setTextColor(color);
        }
    }

    public void setSubtitleTextColor(int color) {
        this.mSubtitleTextColor = color;
        if (this.mSubtitleTextView != null) {
            this.mSubtitleTextView.setTextColor(color);
        }
    }

    @Nullable
    public CharSequence getNavigationContentDescription() {
        if (this.mNavButtonView != null) {
            return this.mNavButtonView.getContentDescription();
        }
        return null;
    }

    public void setNavigationContentDescription(int resId) {
        setNavigationContentDescription(resId != 0 ? getContext().getText(resId) : null);
    }

    public void setNavigationContentDescription(@Nullable CharSequence description) {
        if (!TextUtils.isEmpty(description)) {
            ensureNavButtonView();
        }
        if (this.mNavButtonView != null) {
            this.mNavButtonView.setContentDescription(description);
        }
    }

    public void setNavigationIcon(int resId) {
        setNavigationIcon(this.mTintManager.getDrawable(resId));
    }

    public void setNavigationIcon(@Nullable Drawable icon) {
        if (icon != null) {
            ensureNavButtonView();
            if (this.mNavButtonView.getParent() == null) {
                addSystemView(this.mNavButtonView);
                updateChildVisibilityForExpandedActionView(this.mNavButtonView);
            }
        } else if (this.mNavButtonView != null && this.mNavButtonView.getParent() != null) {
            removeView(this.mNavButtonView);
        }
        if (this.mNavButtonView != null) {
            this.mNavButtonView.setImageDrawable(icon);
        }
    }

    @Nullable
    public Drawable getNavigationIcon() {
        if (this.mNavButtonView != null) {
            return this.mNavButtonView.getDrawable();
        }
        return null;
    }

    public void setNavigationOnClickListener(View.OnClickListener listener) {
        ensureNavButtonView();
        this.mNavButtonView.setOnClickListener(listener);
    }

    public Menu getMenu() {
        ensureMenu();
        return this.mMenuView.getMenu();
    }

    private void ensureMenu() {
        ensureMenuView();
        if (this.mMenuView.peekMenu() == null) {
            MenuBuilder menu = (MenuBuilder) this.mMenuView.getMenu();
            if (this.mExpandedMenuPresenter == null) {
                this.mExpandedMenuPresenter = new ExpandedActionViewMenuPresenter();
            }
            this.mMenuView.setExpandedActionViewsExclusive(true);
            menu.addMenuPresenter(this.mExpandedMenuPresenter, this.mPopupContext);
        }
    }

    private void ensureMenuView() {
        if (this.mMenuView == null) {
            this.mMenuView = new ActionMenuView(getContext());
            this.mMenuView.setPopupTheme(this.mPopupTheme);
            this.mMenuView.setOnMenuItemClickListener(this.mMenuViewItemClickListener);
            this.mMenuView.setMenuCallbacks(this.mActionMenuPresenterCallback, this.mMenuBuilderCallback);
            LayoutParams lp = generateDefaultLayoutParams();
            lp.gravity = 8388613 | (this.mButtonGravity & 112);
            this.mMenuView.setLayoutParams(lp);
            addSystemView(this.mMenuView);
        }
    }

    private MenuInflater getMenuInflater() {
        return new SupportMenuInflater(getContext());
    }

    public void inflateMenu(int resId) {
        getMenuInflater().inflate(resId, getMenu());
    }

    public void setOnMenuItemClickListener(OnMenuItemClickListener listener) {
        this.mOnMenuItemClickListener = listener;
    }

    public void setContentInsetsRelative(int contentInsetStart, int contentInsetEnd) {
        this.mContentInsets.setRelative(contentInsetStart, contentInsetEnd);
    }

    public int getContentInsetStart() {
        return this.mContentInsets.getStart();
    }

    public int getContentInsetEnd() {
        return this.mContentInsets.getEnd();
    }

    public void setContentInsetsAbsolute(int contentInsetLeft, int contentInsetRight) {
        this.mContentInsets.setAbsolute(contentInsetLeft, contentInsetRight);
    }

    public int getContentInsetLeft() {
        return this.mContentInsets.getLeft();
    }

    public int getContentInsetRight() {
        return this.mContentInsets.getRight();
    }

    private void ensureNavButtonView() {
        if (this.mNavButtonView == null) {
            this.mNavButtonView = new ImageButton(getContext(), null, R.attr.toolbarNavigationButtonStyle);
            LayoutParams lp = generateDefaultLayoutParams();
            lp.gravity = 8388611 | (this.mButtonGravity & 112);
            this.mNavButtonView.setLayoutParams(lp);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ensureCollapseButtonView() {
        if (this.mCollapseButtonView == null) {
            this.mCollapseButtonView = new ImageButton(getContext(), null, R.attr.toolbarNavigationButtonStyle);
            this.mCollapseButtonView.setImageDrawable(this.mCollapseIcon);
            this.mCollapseButtonView.setContentDescription(this.mCollapseDescription);
            LayoutParams lp = generateDefaultLayoutParams();
            lp.gravity = 8388611 | (this.mButtonGravity & 112);
            lp.mViewType = 2;
            this.mCollapseButtonView.setLayoutParams(lp);
            this.mCollapseButtonView.setOnClickListener(new View.OnClickListener() { // from class: android.support.v7.widget.Toolbar.3
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    Toolbar.this.collapseActionView();
                }
            });
        }
    }

    private void addSystemView(View v) {
        LayoutParams lp;
        ViewGroup.LayoutParams vlp = v.getLayoutParams();
        if (vlp == null) {
            lp = generateDefaultLayoutParams();
        } else if (!checkLayoutParams(vlp)) {
            lp = generateLayoutParams(vlp);
        } else {
            lp = (LayoutParams) vlp;
        }
        lp.mViewType = 1;
        addView(v, lp);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState state = new SavedState(super.onSaveInstanceState());
        if (this.mExpandedMenuPresenter != null && this.mExpandedMenuPresenter.mCurrentExpandedItem != null) {
            state.expandedMenuItemId = this.mExpandedMenuPresenter.mCurrentExpandedItem.getItemId();
        }
        state.isOverflowOpen = isOverflowMenuShowing();
        return state;
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable state) {
        MenuItem item;
        SavedState ss = (SavedState) state;
        super.onRestoreInstanceState(ss.getSuperState());
        Menu menu = this.mMenuView != null ? this.mMenuView.peekMenu() : null;
        if (ss.expandedMenuItemId != 0 && this.mExpandedMenuPresenter != null && menu != null && (item = menu.findItem(ss.expandedMenuItemId)) != null) {
            MenuItemCompat.expandActionView(item);
        }
        if (ss.isOverflowOpen) {
            postShowOverflowMenu();
        }
    }

    private void postShowOverflowMenu() {
        removeCallbacks(this.mShowOverflowMenuRunnable);
        post(this.mShowOverflowMenuRunnable);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.mShowOverflowMenuRunnable);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent ev) {
        int action = MotionEventCompat.getActionMasked(ev);
        if (action == 0) {
            this.mEatingTouch = false;
        }
        if (!this.mEatingTouch) {
            boolean handled = super.onTouchEvent(ev);
            if (action == 0 && !handled) {
                this.mEatingTouch = true;
            }
        }
        if (action == 1 || action == 3) {
            this.mEatingTouch = false;
        }
        return true;
    }

    private void measureChildConstrained(View child, int parentWidthSpec, int widthUsed, int parentHeightSpec, int heightUsed, int heightConstraint) {
        ViewGroup.MarginLayoutParams lp = (ViewGroup.MarginLayoutParams) child.getLayoutParams();
        int childWidthSpec = getChildMeasureSpec(parentWidthSpec, getPaddingLeft() + getPaddingRight() + lp.leftMargin + lp.rightMargin + widthUsed, lp.width);
        int childHeightSpec = getChildMeasureSpec(parentHeightSpec, getPaddingTop() + getPaddingBottom() + lp.topMargin + lp.bottomMargin + heightUsed, lp.height);
        int childHeightMode = View.MeasureSpec.getMode(childHeightSpec);
        if (childHeightMode != 1073741824 && heightConstraint >= 0) {
            int size = childHeightMode != 0 ? Math.min(View.MeasureSpec.getSize(childHeightSpec), heightConstraint) : heightConstraint;
            childHeightSpec = View.MeasureSpec.makeMeasureSpec(size, 1073741824);
        }
        child.measure(childWidthSpec, childHeightSpec);
    }

    private int measureChildCollapseMargins(View child, int parentWidthMeasureSpec, int widthUsed, int parentHeightMeasureSpec, int heightUsed, int[] collapsingMargins) {
        ViewGroup.MarginLayoutParams lp = (ViewGroup.MarginLayoutParams) child.getLayoutParams();
        int leftDiff = lp.leftMargin - collapsingMargins[0];
        int rightDiff = lp.rightMargin - collapsingMargins[1];
        int leftMargin = Math.max(0, leftDiff);
        int rightMargin = Math.max(0, rightDiff);
        int hMargins = leftMargin + rightMargin;
        collapsingMargins[0] = Math.max(0, -leftDiff);
        collapsingMargins[1] = Math.max(0, -rightDiff);
        int childWidthMeasureSpec = getChildMeasureSpec(parentWidthMeasureSpec, getPaddingLeft() + getPaddingRight() + hMargins + widthUsed, lp.width);
        int childHeightMeasureSpec = getChildMeasureSpec(parentHeightMeasureSpec, getPaddingTop() + getPaddingBottom() + lp.topMargin + lp.bottomMargin + heightUsed, lp.height);
        child.measure(childWidthMeasureSpec, childHeightMeasureSpec);
        return child.getMeasuredWidth() + hMargins;
    }

    private boolean shouldCollapse() {
        if (this.mCollapsible) {
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                View child = getChildAt(i);
                if (shouldLayout(child) && child.getMeasuredWidth() > 0 && child.getMeasuredHeight() > 0) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int marginStartIndex;
        int marginEndIndex;
        int height = 0;
        int childState = 0;
        int[] collapsingMargins = this.mTempMargins;
        if (ViewUtils.isLayoutRtl(this)) {
            marginStartIndex = 1;
            marginEndIndex = 0;
        } else {
            marginStartIndex = 0;
            marginEndIndex = 1;
        }
        int navWidth = 0;
        if (shouldLayout(this.mNavButtonView)) {
            measureChildConstrained(this.mNavButtonView, widthMeasureSpec, 0, heightMeasureSpec, 0, this.mMaxButtonHeight);
            navWidth = this.mNavButtonView.getMeasuredWidth() + getHorizontalMargins(this.mNavButtonView);
            height = Math.max(0, this.mNavButtonView.getMeasuredHeight() + getVerticalMargins(this.mNavButtonView));
            childState = ViewUtils.combineMeasuredStates(0, ViewCompat.getMeasuredState(this.mNavButtonView));
        }
        if (shouldLayout(this.mCollapseButtonView)) {
            measureChildConstrained(this.mCollapseButtonView, widthMeasureSpec, 0, heightMeasureSpec, 0, this.mMaxButtonHeight);
            navWidth = this.mCollapseButtonView.getMeasuredWidth() + getHorizontalMargins(this.mCollapseButtonView);
            height = Math.max(height, this.mCollapseButtonView.getMeasuredHeight() + getVerticalMargins(this.mCollapseButtonView));
            childState = ViewUtils.combineMeasuredStates(childState, ViewCompat.getMeasuredState(this.mCollapseButtonView));
        }
        int contentInsetStart = getContentInsetStart();
        int width = 0 + Math.max(contentInsetStart, navWidth);
        collapsingMargins[marginStartIndex] = Math.max(0, contentInsetStart - navWidth);
        int menuWidth = 0;
        if (shouldLayout(this.mMenuView)) {
            measureChildConstrained(this.mMenuView, widthMeasureSpec, width, heightMeasureSpec, 0, this.mMaxButtonHeight);
            menuWidth = this.mMenuView.getMeasuredWidth() + getHorizontalMargins(this.mMenuView);
            height = Math.max(height, this.mMenuView.getMeasuredHeight() + getVerticalMargins(this.mMenuView));
            childState = ViewUtils.combineMeasuredStates(childState, ViewCompat.getMeasuredState(this.mMenuView));
        }
        int contentInsetEnd = getContentInsetEnd();
        int width2 = width + Math.max(contentInsetEnd, menuWidth);
        collapsingMargins[marginEndIndex] = Math.max(0, contentInsetEnd - menuWidth);
        if (shouldLayout(this.mExpandedActionView)) {
            width2 += measureChildCollapseMargins(this.mExpandedActionView, widthMeasureSpec, width2, heightMeasureSpec, 0, collapsingMargins);
            height = Math.max(height, this.mExpandedActionView.getMeasuredHeight() + getVerticalMargins(this.mExpandedActionView));
            childState = ViewUtils.combineMeasuredStates(childState, ViewCompat.getMeasuredState(this.mExpandedActionView));
        }
        if (shouldLayout(this.mLogoView)) {
            width2 += measureChildCollapseMargins(this.mLogoView, widthMeasureSpec, width2, heightMeasureSpec, 0, collapsingMargins);
            height = Math.max(height, this.mLogoView.getMeasuredHeight() + getVerticalMargins(this.mLogoView));
            childState = ViewUtils.combineMeasuredStates(childState, ViewCompat.getMeasuredState(this.mLogoView));
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View child = getChildAt(i);
            LayoutParams lp = (LayoutParams) child.getLayoutParams();
            if (lp.mViewType == 0 && shouldLayout(child)) {
                width2 += measureChildCollapseMargins(child, widthMeasureSpec, width2, heightMeasureSpec, 0, collapsingMargins);
                height = Math.max(height, child.getMeasuredHeight() + getVerticalMargins(child));
                childState = ViewUtils.combineMeasuredStates(childState, ViewCompat.getMeasuredState(child));
            }
        }
        int titleWidth = 0;
        int titleHeight = 0;
        int titleVertMargins = this.mTitleMarginTop + this.mTitleMarginBottom;
        int titleHorizMargins = this.mTitleMarginStart + this.mTitleMarginEnd;
        if (shouldLayout(this.mTitleTextView)) {
            measureChildCollapseMargins(this.mTitleTextView, widthMeasureSpec, width2 + titleHorizMargins, heightMeasureSpec, titleVertMargins, collapsingMargins);
            titleWidth = this.mTitleTextView.getMeasuredWidth() + getHorizontalMargins(this.mTitleTextView);
            titleHeight = this.mTitleTextView.getMeasuredHeight() + getVerticalMargins(this.mTitleTextView);
            childState = ViewUtils.combineMeasuredStates(childState, ViewCompat.getMeasuredState(this.mTitleTextView));
        }
        if (shouldLayout(this.mSubtitleTextView)) {
            titleWidth = Math.max(titleWidth, measureChildCollapseMargins(this.mSubtitleTextView, widthMeasureSpec, width2 + titleHorizMargins, heightMeasureSpec, titleHeight + titleVertMargins, collapsingMargins));
            titleHeight += this.mSubtitleTextView.getMeasuredHeight() + getVerticalMargins(this.mSubtitleTextView);
            childState = ViewUtils.combineMeasuredStates(childState, ViewCompat.getMeasuredState(this.mSubtitleTextView));
        }
        int height2 = Math.max(height, titleHeight);
        int width3 = width2 + titleWidth + getPaddingLeft() + getPaddingRight();
        int height3 = height2 + getPaddingTop() + getPaddingBottom();
        int measuredWidth = ViewCompat.resolveSizeAndState(Math.max(width3, getSuggestedMinimumWidth()), widthMeasureSpec, (-16777216) & childState);
        int measuredHeight = ViewCompat.resolveSizeAndState(Math.max(height3, getSuggestedMinimumHeight()), heightMeasureSpec, childState << 16);
        if (shouldCollapse()) {
            measuredHeight = 0;
        }
        setMeasuredDimension(measuredWidth, measuredHeight);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int titleTop;
        boolean isRtl = ViewCompat.getLayoutDirection(this) == 1;
        int width = getWidth();
        int height = getHeight();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int left = paddingLeft;
        int right = width - paddingRight;
        int[] collapsingMargins = this.mTempMargins;
        collapsingMargins[1] = 0;
        collapsingMargins[0] = 0;
        int alignmentHeight = getMinimumHeightCompat();
        if (shouldLayout(this.mNavButtonView)) {
            if (isRtl) {
                right = layoutChildRight(this.mNavButtonView, right, collapsingMargins, alignmentHeight);
            } else {
                left = layoutChildLeft(this.mNavButtonView, left, collapsingMargins, alignmentHeight);
            }
        }
        if (shouldLayout(this.mCollapseButtonView)) {
            if (isRtl) {
                right = layoutChildRight(this.mCollapseButtonView, right, collapsingMargins, alignmentHeight);
            } else {
                left = layoutChildLeft(this.mCollapseButtonView, left, collapsingMargins, alignmentHeight);
            }
        }
        if (shouldLayout(this.mMenuView)) {
            if (isRtl) {
                left = layoutChildLeft(this.mMenuView, left, collapsingMargins, alignmentHeight);
            } else {
                right = layoutChildRight(this.mMenuView, right, collapsingMargins, alignmentHeight);
            }
        }
        collapsingMargins[0] = Math.max(0, getContentInsetLeft() - left);
        collapsingMargins[1] = Math.max(0, getContentInsetRight() - ((width - paddingRight) - right));
        int left2 = Math.max(left, getContentInsetLeft());
        int right2 = Math.min(right, (width - paddingRight) - getContentInsetRight());
        if (shouldLayout(this.mExpandedActionView)) {
            if (isRtl) {
                right2 = layoutChildRight(this.mExpandedActionView, right2, collapsingMargins, alignmentHeight);
            } else {
                left2 = layoutChildLeft(this.mExpandedActionView, left2, collapsingMargins, alignmentHeight);
            }
        }
        if (shouldLayout(this.mLogoView)) {
            if (isRtl) {
                right2 = layoutChildRight(this.mLogoView, right2, collapsingMargins, alignmentHeight);
            } else {
                left2 = layoutChildLeft(this.mLogoView, left2, collapsingMargins, alignmentHeight);
            }
        }
        boolean layoutTitle = shouldLayout(this.mTitleTextView);
        boolean layoutSubtitle = shouldLayout(this.mSubtitleTextView);
        int titleHeight = 0;
        if (layoutTitle) {
            LayoutParams lp = (LayoutParams) this.mTitleTextView.getLayoutParams();
            titleHeight = 0 + lp.topMargin + this.mTitleTextView.getMeasuredHeight() + lp.bottomMargin;
        }
        if (layoutSubtitle) {
            LayoutParams lp2 = (LayoutParams) this.mSubtitleTextView.getLayoutParams();
            titleHeight += lp2.topMargin + this.mSubtitleTextView.getMeasuredHeight() + lp2.bottomMargin;
        }
        if (layoutTitle || layoutSubtitle) {
            View topChild = layoutTitle ? this.mTitleTextView : this.mSubtitleTextView;
            View bottomChild = layoutSubtitle ? this.mSubtitleTextView : this.mTitleTextView;
            LayoutParams toplp = (LayoutParams) topChild.getLayoutParams();
            LayoutParams bottomlp = (LayoutParams) bottomChild.getLayoutParams();
            boolean titleHasWidth = (layoutTitle && this.mTitleTextView.getMeasuredWidth() > 0) || (layoutSubtitle && this.mSubtitleTextView.getMeasuredWidth() > 0);
            switch (this.mGravity & 112) {
                case 48:
                    titleTop = getPaddingTop() + toplp.topMargin + this.mTitleMarginTop;
                    break;
                case 80:
                    titleTop = (((height - paddingBottom) - bottomlp.bottomMargin) - this.mTitleMarginBottom) - titleHeight;
                    break;
                default:
                    int space = (height - paddingTop) - paddingBottom;
                    int spaceAbove = (space - titleHeight) / 2;
                    if (spaceAbove < toplp.topMargin + this.mTitleMarginTop) {
                        spaceAbove = toplp.topMargin + this.mTitleMarginTop;
                    } else {
                        int spaceBelow = (((height - paddingBottom) - titleHeight) - spaceAbove) - paddingTop;
                        if (spaceBelow < toplp.bottomMargin + this.mTitleMarginBottom) {
                            spaceAbove = Math.max(0, spaceAbove - ((bottomlp.bottomMargin + this.mTitleMarginBottom) - spaceBelow));
                        }
                    }
                    titleTop = paddingTop + spaceAbove;
                    break;
            }
            if (isRtl) {
                int rd = (titleHasWidth ? this.mTitleMarginStart : 0) - collapsingMargins[1];
                right2 -= Math.max(0, rd);
                collapsingMargins[1] = Math.max(0, -rd);
                int titleRight = right2;
                int subtitleRight = right2;
                if (layoutTitle) {
                    int titleLeft = titleRight - this.mTitleTextView.getMeasuredWidth();
                    int titleBottom = titleTop + this.mTitleTextView.getMeasuredHeight();
                    this.mTitleTextView.layout(titleLeft, titleTop, titleRight, titleBottom);
                    titleRight = titleLeft - this.mTitleMarginEnd;
                    titleTop = titleBottom + ((LayoutParams) this.mTitleTextView.getLayoutParams()).bottomMargin;
                }
                if (layoutSubtitle) {
                    LayoutParams lp3 = (LayoutParams) this.mSubtitleTextView.getLayoutParams();
                    int titleTop2 = titleTop + lp3.topMargin;
                    int subtitleLeft = subtitleRight - this.mSubtitleTextView.getMeasuredWidth();
                    int subtitleBottom = titleTop2 + this.mSubtitleTextView.getMeasuredHeight();
                    this.mSubtitleTextView.layout(subtitleLeft, titleTop2, subtitleRight, subtitleBottom);
                    subtitleRight -= this.mTitleMarginEnd;
                    int titleTop3 = subtitleBottom + lp3.bottomMargin;
                }
                if (titleHasWidth) {
                    right2 = Math.min(titleRight, subtitleRight);
                }
            } else {
                int ld = (titleHasWidth ? this.mTitleMarginStart : 0) - collapsingMargins[0];
                left2 += Math.max(0, ld);
                collapsingMargins[0] = Math.max(0, -ld);
                int titleLeft2 = left2;
                int subtitleLeft2 = left2;
                if (layoutTitle) {
                    int titleRight2 = titleLeft2 + this.mTitleTextView.getMeasuredWidth();
                    int titleBottom2 = titleTop + this.mTitleTextView.getMeasuredHeight();
                    this.mTitleTextView.layout(titleLeft2, titleTop, titleRight2, titleBottom2);
                    titleLeft2 = titleRight2 + this.mTitleMarginEnd;
                    titleTop = titleBottom2 + ((LayoutParams) this.mTitleTextView.getLayoutParams()).bottomMargin;
                }
                if (layoutSubtitle) {
                    LayoutParams lp4 = (LayoutParams) this.mSubtitleTextView.getLayoutParams();
                    int titleTop4 = titleTop + lp4.topMargin;
                    int subtitleRight2 = subtitleLeft2 + this.mSubtitleTextView.getMeasuredWidth();
                    int subtitleBottom2 = titleTop4 + this.mSubtitleTextView.getMeasuredHeight();
                    this.mSubtitleTextView.layout(subtitleLeft2, titleTop4, subtitleRight2, subtitleBottom2);
                    subtitleLeft2 = subtitleRight2 + this.mTitleMarginEnd;
                    int titleTop5 = subtitleBottom2 + lp4.bottomMargin;
                }
                if (titleHasWidth) {
                    left2 = Math.max(titleLeft2, subtitleLeft2);
                }
            }
        }
        addCustomViewsWithGravity(this.mTempViews, 3);
        int leftViewsCount = this.mTempViews.size();
        for (int i = 0; i < leftViewsCount; i++) {
            left2 = layoutChildLeft(this.mTempViews.get(i), left2, collapsingMargins, alignmentHeight);
        }
        addCustomViewsWithGravity(this.mTempViews, 5);
        int rightViewsCount = this.mTempViews.size();
        for (int i2 = 0; i2 < rightViewsCount; i2++) {
            right2 = layoutChildRight(this.mTempViews.get(i2), right2, collapsingMargins, alignmentHeight);
        }
        addCustomViewsWithGravity(this.mTempViews, 1);
        int centerViewsWidth = getViewListMeasuredWidth(this.mTempViews, collapsingMargins);
        int parentCenter = paddingLeft + (((width - paddingLeft) - paddingRight) / 2);
        int halfCenterViewsWidth = centerViewsWidth / 2;
        int centerLeft = parentCenter - halfCenterViewsWidth;
        int centerRight = centerLeft + centerViewsWidth;
        if (centerLeft < left2) {
            centerLeft = left2;
        } else if (centerRight > right2) {
            centerLeft -= centerRight - right2;
        }
        int centerViewsCount = this.mTempViews.size();
        for (int i3 = 0; i3 < centerViewsCount; i3++) {
            centerLeft = layoutChildLeft(this.mTempViews.get(i3), centerLeft, collapsingMargins, alignmentHeight);
        }
        this.mTempViews.clear();
    }

    private int getViewListMeasuredWidth(List<View> views, int[] collapsingMargins) {
        int collapseLeft = collapsingMargins[0];
        int collapseRight = collapsingMargins[1];
        int width = 0;
        int count = views.size();
        for (int i = 0; i < count; i++) {
            View v = views.get(i);
            LayoutParams lp = (LayoutParams) v.getLayoutParams();
            int l = lp.leftMargin - collapseLeft;
            int r = lp.rightMargin - collapseRight;
            int leftMargin = Math.max(0, l);
            int rightMargin = Math.max(0, r);
            collapseLeft = Math.max(0, -l);
            collapseRight = Math.max(0, -r);
            width += v.getMeasuredWidth() + leftMargin + rightMargin;
        }
        return width;
    }

    private int layoutChildLeft(View child, int left, int[] collapsingMargins, int alignmentHeight) {
        LayoutParams lp = (LayoutParams) child.getLayoutParams();
        int l = lp.leftMargin - collapsingMargins[0];
        int left2 = left + Math.max(0, l);
        collapsingMargins[0] = Math.max(0, -l);
        int top = getChildTop(child, alignmentHeight);
        int childWidth = child.getMeasuredWidth();
        child.layout(left2, top, left2 + childWidth, child.getMeasuredHeight() + top);
        return left2 + lp.rightMargin + childWidth;
    }

    private int layoutChildRight(View child, int right, int[] collapsingMargins, int alignmentHeight) {
        LayoutParams lp = (LayoutParams) child.getLayoutParams();
        int r = lp.rightMargin - collapsingMargins[1];
        int right2 = right - Math.max(0, r);
        collapsingMargins[1] = Math.max(0, -r);
        int top = getChildTop(child, alignmentHeight);
        int childWidth = child.getMeasuredWidth();
        child.layout(right2 - childWidth, top, right2, child.getMeasuredHeight() + top);
        return right2 - (lp.leftMargin + childWidth);
    }

    private int getChildTop(View child, int alignmentHeight) {
        LayoutParams lp = (LayoutParams) child.getLayoutParams();
        int childHeight = child.getMeasuredHeight();
        int alignmentOffset = alignmentHeight > 0 ? (childHeight - alignmentHeight) / 2 : 0;
        switch (getChildVerticalGravity(lp.gravity)) {
            case 48:
                return getPaddingTop() - alignmentOffset;
            case 80:
                return (((getHeight() - getPaddingBottom()) - childHeight) - lp.bottomMargin) - alignmentOffset;
            default:
                int paddingTop = getPaddingTop();
                int paddingBottom = getPaddingBottom();
                int height = getHeight();
                int space = (height - paddingTop) - paddingBottom;
                int spaceAbove = (space - childHeight) / 2;
                if (spaceAbove < lp.topMargin) {
                    spaceAbove = lp.topMargin;
                } else {
                    int spaceBelow = (((height - paddingBottom) - childHeight) - spaceAbove) - paddingTop;
                    if (spaceBelow < lp.bottomMargin) {
                        spaceAbove = Math.max(0, spaceAbove - (lp.bottomMargin - spaceBelow));
                    }
                }
                return paddingTop + spaceAbove;
        }
    }

    private int getChildVerticalGravity(int gravity) {
        int vgrav = gravity & 112;
        switch (vgrav) {
            case 16:
            case 48:
            case 80:
                return vgrav;
            default:
                return this.mGravity & 112;
        }
    }

    private void addCustomViewsWithGravity(List<View> views, int gravity) {
        boolean isRtl = ViewCompat.getLayoutDirection(this) == 1;
        int childCount = getChildCount();
        int absGrav = GravityCompat.getAbsoluteGravity(gravity, ViewCompat.getLayoutDirection(this));
        views.clear();
        if (isRtl) {
            for (int i = childCount - 1; i >= 0; i--) {
                View child = getChildAt(i);
                LayoutParams lp = (LayoutParams) child.getLayoutParams();
                if (lp.mViewType == 0 && shouldLayout(child) && getChildHorizontalGravity(lp.gravity) == absGrav) {
                    views.add(child);
                }
            }
            return;
        }
        for (int i2 = 0; i2 < childCount; i2++) {
            View child2 = getChildAt(i2);
            LayoutParams lp2 = (LayoutParams) child2.getLayoutParams();
            if (lp2.mViewType == 0 && shouldLayout(child2) && getChildHorizontalGravity(lp2.gravity) == absGrav) {
                views.add(child2);
            }
        }
    }

    private int getChildHorizontalGravity(int gravity) {
        int ld = ViewCompat.getLayoutDirection(this);
        int absGrav = GravityCompat.getAbsoluteGravity(gravity, ld);
        int hGrav = absGrav & 7;
        switch (hGrav) {
            case 1:
            case 3:
            case 5:
                return hGrav;
            case 2:
            case 4:
            default:
                return ld == 1 ? 5 : 3;
        }
    }

    private boolean shouldLayout(View view) {
        return (view == null || view.getParent() != this || view.getVisibility() == 8) ? false : true;
    }

    private int getHorizontalMargins(View v) {
        ViewGroup.MarginLayoutParams mlp = (ViewGroup.MarginLayoutParams) v.getLayoutParams();
        return MarginLayoutParamsCompat.getMarginStart(mlp) + MarginLayoutParamsCompat.getMarginEnd(mlp);
    }

    private int getVerticalMargins(View v) {
        ViewGroup.MarginLayoutParams mlp = (ViewGroup.MarginLayoutParams) v.getLayoutParams();
        return mlp.topMargin + mlp.bottomMargin;
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new LayoutParams(getContext(), attrs);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams p) {
        if (p instanceof LayoutParams) {
            return new LayoutParams((LayoutParams) p);
        }
        if (p instanceof ActionBar.LayoutParams) {
            return new LayoutParams((ActionBar.LayoutParams) p);
        }
        if (p instanceof ViewGroup.MarginLayoutParams) {
            return new LayoutParams((ViewGroup.MarginLayoutParams) p);
        }
        return new LayoutParams(p);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams p) {
        return super.checkLayoutParams(p) && (p instanceof LayoutParams);
    }

    private static boolean isCustomView(View child) {
        return ((LayoutParams) child.getLayoutParams()).mViewType == 0;
    }

    public DecorToolbar getWrapper() {
        if (this.mWrapper == null) {
            this.mWrapper = new ToolbarWidgetWrapper(this, true);
        }
        return this.mWrapper;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setChildVisibilityForExpandedActionView(boolean expand) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View child = getChildAt(i);
            LayoutParams lp = (LayoutParams) child.getLayoutParams();
            if (lp.mViewType != 2 && child != this.mMenuView) {
                child.setVisibility(expand ? 8 : 0);
            }
        }
    }

    private void updateChildVisibilityForExpandedActionView(View child) {
        LayoutParams lp = (LayoutParams) child.getLayoutParams();
        if (lp.mViewType != 2 && child != this.mMenuView) {
            child.setVisibility(this.mExpandedActionView != null ? 8 : 0);
        }
    }

    public void setCollapsible(boolean collapsible) {
        this.mCollapsible = collapsible;
        requestLayout();
    }

    public void setMenuCallbacks(MenuPresenter.Callback pcb, MenuBuilder.Callback mcb) {
        this.mActionMenuPresenterCallback = pcb;
        this.mMenuBuilderCallback = mcb;
    }

    @Override // android.view.View
    public void setMinimumHeight(int minHeight) {
        this.mMinHeight = minHeight;
        super.setMinimumHeight(minHeight);
    }

    private int getMinimumHeightCompat() {
        return Build.VERSION.SDK_INT >= 16 ? ViewCompat.getMinimumHeight(this) : this.mMinHeight;
    }

    /* loaded from: classes.dex */
    public static class LayoutParams extends ActionBar.LayoutParams {
        static final int CUSTOM = 0;
        static final int EXPANDED = 2;
        static final int SYSTEM = 1;
        int mViewType;

        public LayoutParams(Context c, AttributeSet attrs) {
            super(c, attrs);
            this.mViewType = 0;
        }

        public LayoutParams(int width, int height) {
            super(width, height);
            this.mViewType = 0;
            this.gravity = 8388627;
        }

        public LayoutParams(int width, int height, int gravity) {
            super(width, height);
            this.mViewType = 0;
            this.gravity = gravity;
        }

        public LayoutParams(int gravity) {
            this(-2, -1, gravity);
        }

        public LayoutParams(LayoutParams source) {
            super((ActionBar.LayoutParams) source);
            this.mViewType = 0;
            this.mViewType = source.mViewType;
        }

        public LayoutParams(ActionBar.LayoutParams source) {
            super(source);
            this.mViewType = 0;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams source) {
            super(source);
            this.mViewType = 0;
            copyMarginsFromCompat(source);
        }

        public LayoutParams(ViewGroup.LayoutParams source) {
            super(source);
            this.mViewType = 0;
        }

        void copyMarginsFromCompat(ViewGroup.MarginLayoutParams source) {
            this.leftMargin = source.leftMargin;
            this.topMargin = source.topMargin;
            this.rightMargin = source.rightMargin;
            this.bottomMargin = source.bottomMargin;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: android.support.v7.widget.Toolbar.SavedState.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel source) {
                return new SavedState(source);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int size) {
                return new SavedState[size];
            }
        };
        public int expandedMenuItemId;
        public boolean isOverflowOpen;

        public SavedState(Parcel source) {
            super(source);
            this.expandedMenuItemId = source.readInt();
            this.isOverflowOpen = source.readInt() != 0;
        }

        public SavedState(Parcelable superState) {
            super(superState);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel out, int flags) {
            super.writeToParcel(out, flags);
            out.writeInt(this.expandedMenuItemId);
            out.writeInt(this.isOverflowOpen ? 1 : 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class ExpandedActionViewMenuPresenter implements MenuPresenter {
        MenuItemImpl mCurrentExpandedItem;
        MenuBuilder mMenu;

        private ExpandedActionViewMenuPresenter() {
        }

        @Override // android.support.v7.internal.view.menu.MenuPresenter
        public void initForMenu(Context context, MenuBuilder menu) {
            if (this.mMenu != null && this.mCurrentExpandedItem != null) {
                this.mMenu.collapseItemActionView(this.mCurrentExpandedItem);
            }
            this.mMenu = menu;
        }

        @Override // android.support.v7.internal.view.menu.MenuPresenter
        public MenuView getMenuView(ViewGroup root) {
            return null;
        }

        @Override // android.support.v7.internal.view.menu.MenuPresenter
        public void updateMenuView(boolean cleared) {
            if (this.mCurrentExpandedItem != null) {
                boolean found = false;
                if (this.mMenu != null) {
                    int count = this.mMenu.size();
                    int i = 0;
                    while (true) {
                        if (i >= count) {
                            break;
                        }
                        MenuItem item = this.mMenu.getItem(i);
                        if (item != this.mCurrentExpandedItem) {
                            i++;
                        } else {
                            found = true;
                            break;
                        }
                    }
                }
                if (!found) {
                    collapseItemActionView(this.mMenu, this.mCurrentExpandedItem);
                }
            }
        }

        @Override // android.support.v7.internal.view.menu.MenuPresenter
        public void setCallback(MenuPresenter.Callback cb) {
        }

        @Override // android.support.v7.internal.view.menu.MenuPresenter
        public boolean onSubMenuSelected(SubMenuBuilder subMenu) {
            return false;
        }

        @Override // android.support.v7.internal.view.menu.MenuPresenter
        public void onCloseMenu(MenuBuilder menu, boolean allMenusAreClosing) {
        }

        @Override // android.support.v7.internal.view.menu.MenuPresenter
        public boolean flagActionItems() {
            return false;
        }

        @Override // android.support.v7.internal.view.menu.MenuPresenter
        public boolean expandItemActionView(MenuBuilder menu, MenuItemImpl item) {
            Toolbar.this.ensureCollapseButtonView();
            if (Toolbar.this.mCollapseButtonView.getParent() != Toolbar.this) {
                Toolbar.this.addView(Toolbar.this.mCollapseButtonView);
            }
            Toolbar.this.mExpandedActionView = item.getActionView();
            this.mCurrentExpandedItem = item;
            if (Toolbar.this.mExpandedActionView.getParent() != Toolbar.this) {
                LayoutParams lp = Toolbar.this.generateDefaultLayoutParams();
                lp.gravity = 8388611 | (Toolbar.this.mButtonGravity & 112);
                lp.mViewType = 2;
                Toolbar.this.mExpandedActionView.setLayoutParams(lp);
                Toolbar.this.addView(Toolbar.this.mExpandedActionView);
            }
            Toolbar.this.setChildVisibilityForExpandedActionView(true);
            Toolbar.this.requestLayout();
            item.setActionViewExpanded(true);
            if (Toolbar.this.mExpandedActionView instanceof CollapsibleActionView) {
                ((CollapsibleActionView) Toolbar.this.mExpandedActionView).onActionViewExpanded();
            }
            return true;
        }

        @Override // android.support.v7.internal.view.menu.MenuPresenter
        public boolean collapseItemActionView(MenuBuilder menu, MenuItemImpl item) {
            if (Toolbar.this.mExpandedActionView instanceof CollapsibleActionView) {
                ((CollapsibleActionView) Toolbar.this.mExpandedActionView).onActionViewCollapsed();
            }
            Toolbar.this.removeView(Toolbar.this.mExpandedActionView);
            Toolbar.this.removeView(Toolbar.this.mCollapseButtonView);
            Toolbar.this.mExpandedActionView = null;
            Toolbar.this.setChildVisibilityForExpandedActionView(false);
            this.mCurrentExpandedItem = null;
            Toolbar.this.requestLayout();
            item.setActionViewExpanded(false);
            return true;
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
    }

    private static Context themifyContext(Context context, AttributeSet attrs, int defStyleAttr) {
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.Toolbar, defStyleAttr, 0);
        int themeId = a.getResourceId(R.styleable.Toolbar_theme, 0);
        if (themeId != 0) {
            context = new ContextThemeWrapper(context, themeId);
        }
        a.recycle();
        return context;
    }
}