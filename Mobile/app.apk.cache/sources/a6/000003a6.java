package android.support.v7.internal.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.support.v7.appcompat.R;
import android.support.v7.internal.view.ViewPropertyAnimatorCompatSet;
import android.support.v7.internal.view.menu.MenuBuilder;
import android.support.v7.internal.widget.ActivityChooserView;
import android.support.v7.view.ActionMode;
import android.support.v7.widget.ActionMenuPresenter;
import android.support.v7.widget.ActionMenuView;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;
import android.widget.TextView;

/* loaded from: classes.dex */
public class ActionBarContextView extends AbsActionBarView implements ViewPropertyAnimatorListener {
    private static final int ANIMATE_IDLE = 0;
    private static final int ANIMATE_IN = 1;
    private static final int ANIMATE_OUT = 2;
    private static final String TAG = "ActionBarContextView";
    private boolean mAnimateInOnLayout;
    private int mAnimationMode;
    private View mClose;
    private int mCloseItemLayout;
    private ViewPropertyAnimatorCompatSet mCurrentAnimation;
    private View mCustomView;
    private Drawable mSplitBackground;
    private CharSequence mSubtitle;
    private int mSubtitleStyleRes;
    private TextView mSubtitleView;
    private CharSequence mTitle;
    private LinearLayout mTitleLayout;
    private boolean mTitleOptional;
    private int mTitleStyleRes;
    private TextView mTitleView;

    @Override // android.support.v7.internal.widget.AbsActionBarView
    public /* bridge */ /* synthetic */ void animateToVisibility(int x0) {
        super.animateToVisibility(x0);
    }

    @Override // android.support.v7.internal.widget.AbsActionBarView
    public /* bridge */ /* synthetic */ boolean canShowOverflowMenu() {
        return super.canShowOverflowMenu();
    }

    @Override // android.support.v7.internal.widget.AbsActionBarView
    public /* bridge */ /* synthetic */ void dismissPopupMenus() {
        super.dismissPopupMenus();
    }

    @Override // android.support.v7.internal.widget.AbsActionBarView
    public /* bridge */ /* synthetic */ int getAnimatedVisibility() {
        return super.getAnimatedVisibility();
    }

    @Override // android.support.v7.internal.widget.AbsActionBarView
    public /* bridge */ /* synthetic */ int getContentHeight() {
        return super.getContentHeight();
    }

    @Override // android.support.v7.internal.widget.AbsActionBarView
    public /* bridge */ /* synthetic */ boolean isOverflowMenuShowPending() {
        return super.isOverflowMenuShowPending();
    }

    @Override // android.support.v7.internal.widget.AbsActionBarView
    public /* bridge */ /* synthetic */ boolean isOverflowReserved() {
        return super.isOverflowReserved();
    }

    @Override // android.support.v7.internal.widget.AbsActionBarView
    public /* bridge */ /* synthetic */ void postShowOverflowMenu() {
        super.postShowOverflowMenu();
    }

    @Override // android.support.v7.internal.widget.AbsActionBarView
    public /* bridge */ /* synthetic */ void setSplitView(ViewGroup x0) {
        super.setSplitView(x0);
    }

    @Override // android.support.v7.internal.widget.AbsActionBarView
    public /* bridge */ /* synthetic */ void setSplitWhenNarrow(boolean x0) {
        super.setSplitWhenNarrow(x0);
    }

    public ActionBarContextView(Context context) {
        this(context, null);
    }

    public ActionBarContextView(Context context, AttributeSet attrs) {
        this(context, attrs, R.attr.actionModeStyle);
    }

    public ActionBarContextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        TintTypedArray a = TintTypedArray.obtainStyledAttributes(context, attrs, R.styleable.ActionMode, defStyle, 0);
        setBackgroundDrawable(a.getDrawable(R.styleable.ActionMode_background));
        this.mTitleStyleRes = a.getResourceId(R.styleable.ActionMode_titleTextStyle, 0);
        this.mSubtitleStyleRes = a.getResourceId(R.styleable.ActionMode_subtitleTextStyle, 0);
        this.mContentHeight = a.getLayoutDimension(R.styleable.ActionMode_height, 0);
        this.mSplitBackground = a.getDrawable(R.styleable.ActionMode_backgroundSplit);
        this.mCloseItemLayout = a.getResourceId(R.styleable.ActionMode_closeItemLayout, R.layout.abc_action_mode_close_item_material);
        a.recycle();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.mActionMenuPresenter != null) {
            this.mActionMenuPresenter.hideOverflowMenu();
            this.mActionMenuPresenter.hideSubMenus();
        }
    }

    @Override // android.support.v7.internal.widget.AbsActionBarView
    public void setSplitToolbar(boolean split) {
        if (this.mSplitActionBar != split) {
            if (this.mActionMenuPresenter != null) {
                ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-2, -1);
                if (!split) {
                    this.mMenuView = (ActionMenuView) this.mActionMenuPresenter.getMenuView(this);
                    this.mMenuView.setBackgroundDrawable(null);
                    ViewGroup oldParent = (ViewGroup) this.mMenuView.getParent();
                    if (oldParent != null) {
                        oldParent.removeView(this.mMenuView);
                    }
                    addView(this.mMenuView, layoutParams);
                } else {
                    this.mActionMenuPresenter.setWidthLimit(getContext().getResources().getDisplayMetrics().widthPixels, true);
                    this.mActionMenuPresenter.setItemLimit(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
                    layoutParams.width = -1;
                    layoutParams.height = this.mContentHeight;
                    this.mMenuView = (ActionMenuView) this.mActionMenuPresenter.getMenuView(this);
                    this.mMenuView.setBackgroundDrawable(this.mSplitBackground);
                    ViewGroup oldParent2 = (ViewGroup) this.mMenuView.getParent();
                    if (oldParent2 != null) {
                        oldParent2.removeView(this.mMenuView);
                    }
                    this.mSplitView.addView(this.mMenuView, layoutParams);
                }
            }
            super.setSplitToolbar(split);
        }
    }

    @Override // android.support.v7.internal.widget.AbsActionBarView
    public void setContentHeight(int height) {
        this.mContentHeight = height;
    }

    public void setCustomView(View view) {
        if (this.mCustomView != null) {
            removeView(this.mCustomView);
        }
        this.mCustomView = view;
        if (this.mTitleLayout != null) {
            removeView(this.mTitleLayout);
            this.mTitleLayout = null;
        }
        if (view != null) {
            addView(view);
        }
        requestLayout();
    }

    public void setTitle(CharSequence title) {
        this.mTitle = title;
        initTitle();
    }

    public void setSubtitle(CharSequence subtitle) {
        this.mSubtitle = subtitle;
        initTitle();
    }

    public CharSequence getTitle() {
        return this.mTitle;
    }

    public CharSequence getSubtitle() {
        return this.mSubtitle;
    }

    private void initTitle() {
        int i = 8;
        if (this.mTitleLayout == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            inflater.inflate(R.layout.abc_action_bar_title_item, this);
            this.mTitleLayout = (LinearLayout) getChildAt(getChildCount() - 1);
            this.mTitleView = (TextView) this.mTitleLayout.findViewById(R.id.action_bar_title);
            this.mSubtitleView = (TextView) this.mTitleLayout.findViewById(R.id.action_bar_subtitle);
            if (this.mTitleStyleRes != 0) {
                this.mTitleView.setTextAppearance(getContext(), this.mTitleStyleRes);
            }
            if (this.mSubtitleStyleRes != 0) {
                this.mSubtitleView.setTextAppearance(getContext(), this.mSubtitleStyleRes);
            }
        }
        this.mTitleView.setText(this.mTitle);
        this.mSubtitleView.setText(this.mSubtitle);
        boolean hasTitle = !TextUtils.isEmpty(this.mTitle);
        boolean hasSubtitle = !TextUtils.isEmpty(this.mSubtitle);
        this.mSubtitleView.setVisibility(hasSubtitle ? 0 : 8);
        LinearLayout linearLayout = this.mTitleLayout;
        if (hasTitle || hasSubtitle) {
            i = 0;
        }
        linearLayout.setVisibility(i);
        if (this.mTitleLayout.getParent() == null) {
            addView(this.mTitleLayout);
        }
    }

    public void initForMode(final ActionMode mode) {
        if (this.mClose == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            this.mClose = inflater.inflate(this.mCloseItemLayout, (ViewGroup) this, false);
            addView(this.mClose);
        } else if (this.mClose.getParent() == null) {
            addView(this.mClose);
        }
        View closeButton = this.mClose.findViewById(R.id.action_mode_close_button);
        closeButton.setOnClickListener(new View.OnClickListener() { // from class: android.support.v7.internal.widget.ActionBarContextView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                mode.finish();
            }
        });
        MenuBuilder menu = (MenuBuilder) mode.getMenu();
        if (this.mActionMenuPresenter != null) {
            this.mActionMenuPresenter.dismissPopupMenus();
        }
        this.mActionMenuPresenter = new ActionMenuPresenter(getContext());
        this.mActionMenuPresenter.setReserveOverflow(true);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-2, -1);
        if (!this.mSplitActionBar) {
            menu.addMenuPresenter(this.mActionMenuPresenter, this.mPopupContext);
            this.mMenuView = (ActionMenuView) this.mActionMenuPresenter.getMenuView(this);
            this.mMenuView.setBackgroundDrawable(null);
            addView(this.mMenuView, layoutParams);
        } else {
            this.mActionMenuPresenter.setWidthLimit(getContext().getResources().getDisplayMetrics().widthPixels, true);
            this.mActionMenuPresenter.setItemLimit(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            layoutParams.width = -1;
            layoutParams.height = this.mContentHeight;
            menu.addMenuPresenter(this.mActionMenuPresenter, this.mPopupContext);
            this.mMenuView = (ActionMenuView) this.mActionMenuPresenter.getMenuView(this);
            this.mMenuView.setBackgroundDrawable(this.mSplitBackground);
            this.mSplitView.addView(this.mMenuView, layoutParams);
        }
        this.mAnimateInOnLayout = true;
    }

    public void closeMode() {
        if (this.mAnimationMode != 2) {
            if (this.mClose == null) {
                killMode();
                return;
            }
            finishAnimation();
            this.mAnimationMode = 2;
            this.mCurrentAnimation = makeOutAnimation();
            this.mCurrentAnimation.start();
        }
    }

    private void finishAnimation() {
        ViewPropertyAnimatorCompatSet a = this.mCurrentAnimation;
        if (a != null) {
            this.mCurrentAnimation = null;
            a.cancel();
        }
    }

    public void killMode() {
        finishAnimation();
        removeAllViews();
        if (this.mSplitView != null) {
            this.mSplitView.removeView(this.mMenuView);
        }
        this.mCustomView = null;
        this.mMenuView = null;
        this.mAnimateInOnLayout = false;
    }

    @Override // android.support.v7.internal.widget.AbsActionBarView
    public boolean showOverflowMenu() {
        if (this.mActionMenuPresenter != null) {
            return this.mActionMenuPresenter.showOverflowMenu();
        }
        return false;
    }

    @Override // android.support.v7.internal.widget.AbsActionBarView
    public boolean hideOverflowMenu() {
        if (this.mActionMenuPresenter != null) {
            return this.mActionMenuPresenter.hideOverflowMenu();
        }
        return false;
    }

    @Override // android.support.v7.internal.widget.AbsActionBarView
    public boolean isOverflowMenuShowing() {
        if (this.mActionMenuPresenter != null) {
            return this.mActionMenuPresenter.isOverflowMenuShowing();
        }
        return false;
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-1, -2);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new ViewGroup.MarginLayoutParams(getContext(), attrs);
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthMode = View.MeasureSpec.getMode(widthMeasureSpec);
        if (widthMode != 1073741824) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_width=\"match_parent\" (or fill_parent)");
        }
        int heightMode = View.MeasureSpec.getMode(heightMeasureSpec);
        if (heightMode == 0) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_height=\"wrap_content\"");
        }
        int contentWidth = View.MeasureSpec.getSize(widthMeasureSpec);
        int maxHeight = this.mContentHeight > 0 ? this.mContentHeight : View.MeasureSpec.getSize(heightMeasureSpec);
        int verticalPadding = getPaddingTop() + getPaddingBottom();
        int availableWidth = (contentWidth - getPaddingLeft()) - getPaddingRight();
        int height = maxHeight - verticalPadding;
        int childSpecHeight = View.MeasureSpec.makeMeasureSpec(height, Integer.MIN_VALUE);
        if (this.mClose != null) {
            int availableWidth2 = measureChildView(this.mClose, availableWidth, childSpecHeight, 0);
            ViewGroup.MarginLayoutParams lp = (ViewGroup.MarginLayoutParams) this.mClose.getLayoutParams();
            availableWidth = availableWidth2 - (lp.leftMargin + lp.rightMargin);
        }
        if (this.mMenuView != null && this.mMenuView.getParent() == this) {
            availableWidth = measureChildView(this.mMenuView, availableWidth, childSpecHeight, 0);
        }
        if (this.mTitleLayout != null && this.mCustomView == null) {
            if (this.mTitleOptional) {
                int titleWidthSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                this.mTitleLayout.measure(titleWidthSpec, childSpecHeight);
                int titleWidth = this.mTitleLayout.getMeasuredWidth();
                boolean titleFits = titleWidth <= availableWidth;
                if (titleFits) {
                    availableWidth -= titleWidth;
                }
                this.mTitleLayout.setVisibility(titleFits ? 0 : 8);
            } else {
                availableWidth = measureChildView(this.mTitleLayout, availableWidth, childSpecHeight, 0);
            }
        }
        if (this.mCustomView != null) {
            ViewGroup.LayoutParams lp2 = this.mCustomView.getLayoutParams();
            int customWidthMode = lp2.width != -2 ? 1073741824 : Integer.MIN_VALUE;
            int customWidth = lp2.width >= 0 ? Math.min(lp2.width, availableWidth) : availableWidth;
            int customHeightMode = lp2.height != -2 ? 1073741824 : Integer.MIN_VALUE;
            int customHeight = lp2.height >= 0 ? Math.min(lp2.height, height) : height;
            this.mCustomView.measure(View.MeasureSpec.makeMeasureSpec(customWidth, customWidthMode), View.MeasureSpec.makeMeasureSpec(customHeight, customHeightMode));
        }
        if (this.mContentHeight <= 0) {
            int measuredHeight = 0;
            int count = getChildCount();
            for (int i = 0; i < count; i++) {
                View v = getChildAt(i);
                int paddedViewHeight = v.getMeasuredHeight() + verticalPadding;
                if (paddedViewHeight > measuredHeight) {
                    measuredHeight = paddedViewHeight;
                }
            }
            setMeasuredDimension(contentWidth, measuredHeight);
            return;
        }
        setMeasuredDimension(contentWidth, maxHeight);
    }

    private ViewPropertyAnimatorCompatSet makeInAnimation() {
        int count;
        ViewCompat.setTranslationX(this.mClose, (-this.mClose.getWidth()) - ((ViewGroup.MarginLayoutParams) this.mClose.getLayoutParams()).leftMargin);
        ViewPropertyAnimatorCompat buttonAnimator = ViewCompat.animate(this.mClose).translationX(0.0f);
        buttonAnimator.setDuration(200L);
        buttonAnimator.setListener(this);
        buttonAnimator.setInterpolator(new DecelerateInterpolator());
        ViewPropertyAnimatorCompatSet set = new ViewPropertyAnimatorCompatSet();
        set.play(buttonAnimator);
        if (this.mMenuView != null && (count = this.mMenuView.getChildCount()) > 0) {
            int i = count - 1;
            int j = 0;
            while (i >= 0) {
                View child = this.mMenuView.getChildAt(i);
                ViewCompat.setScaleY(child, 0.0f);
                ViewPropertyAnimatorCompat a = ViewCompat.animate(child).scaleY(1.0f);
                a.setDuration(300L);
                set.play(a);
                i--;
                j++;
            }
        }
        return set;
    }

    private ViewPropertyAnimatorCompatSet makeOutAnimation() {
        ViewPropertyAnimatorCompat buttonAnimator = ViewCompat.animate(this.mClose).translationX((-this.mClose.getWidth()) - ((ViewGroup.MarginLayoutParams) this.mClose.getLayoutParams()).leftMargin);
        buttonAnimator.setDuration(200L);
        buttonAnimator.setListener(this);
        buttonAnimator.setInterpolator(new DecelerateInterpolator());
        ViewPropertyAnimatorCompatSet set = new ViewPropertyAnimatorCompatSet();
        set.play(buttonAnimator);
        if (this.mMenuView != null) {
            int count = this.mMenuView.getChildCount();
            if (count > 0) {
                for (int i = 0; i < 0; i++) {
                    View child = this.mMenuView.getChildAt(i);
                    ViewCompat.setScaleY(child, 1.0f);
                    ViewPropertyAnimatorCompat a = ViewCompat.animate(child).scaleY(0.0f);
                    a.setDuration(300L);
                    set.play(a);
                }
            }
        }
        return set;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        boolean isLayoutRtl = ViewUtils.isLayoutRtl(this);
        int x = isLayoutRtl ? (r - l) - getPaddingRight() : getPaddingLeft();
        int y = getPaddingTop();
        int contentHeight = ((b - t) - getPaddingTop()) - getPaddingBottom();
        if (this.mClose != null && this.mClose.getVisibility() != 8) {
            ViewGroup.MarginLayoutParams lp = (ViewGroup.MarginLayoutParams) this.mClose.getLayoutParams();
            int startMargin = isLayoutRtl ? lp.rightMargin : lp.leftMargin;
            int endMargin = isLayoutRtl ? lp.leftMargin : lp.rightMargin;
            int x2 = next(x, startMargin, isLayoutRtl);
            x = next(x2 + positionChild(this.mClose, x2, y, contentHeight, isLayoutRtl), endMargin, isLayoutRtl);
            if (this.mAnimateInOnLayout) {
                this.mAnimationMode = 1;
                this.mCurrentAnimation = makeInAnimation();
                this.mCurrentAnimation.start();
                this.mAnimateInOnLayout = false;
            }
        }
        if (this.mTitleLayout != null && this.mCustomView == null && this.mTitleLayout.getVisibility() != 8) {
            x += positionChild(this.mTitleLayout, x, y, contentHeight, isLayoutRtl);
        }
        if (this.mCustomView != null) {
            int positionChild = x + positionChild(this.mCustomView, x, y, contentHeight, isLayoutRtl);
        }
        int x3 = isLayoutRtl ? getPaddingLeft() : (r - l) - getPaddingRight();
        if (this.mMenuView != null) {
            int positionChild2 = x3 + positionChild(this.mMenuView, x3, y, contentHeight, !isLayoutRtl);
        }
    }

    @Override // android.support.v4.view.ViewPropertyAnimatorListener
    public void onAnimationStart(View view) {
    }

    @Override // android.support.v4.view.ViewPropertyAnimatorListener
    public void onAnimationEnd(View view) {
        if (this.mAnimationMode == 2) {
            killMode();
        }
        this.mAnimationMode = 0;
    }

    @Override // android.support.v4.view.ViewPropertyAnimatorListener
    public void onAnimationCancel(View view) {
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent event) {
        if (Build.VERSION.SDK_INT >= 14) {
            if (event.getEventType() == 32) {
                event.setSource(this);
                event.setClassName(getClass().getName());
                event.setPackageName(getContext().getPackageName());
                event.setContentDescription(this.mTitle);
                return;
            }
            super.onInitializeAccessibilityEvent(event);
        }
    }

    public void setTitleOptional(boolean titleOptional) {
        if (titleOptional != this.mTitleOptional) {
            requestLayout();
        }
        this.mTitleOptional = titleOptional;
    }

    public boolean isTitleOptional() {
        return this.mTitleOptional;
    }
}