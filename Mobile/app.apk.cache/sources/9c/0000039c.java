package android.support.v7.internal.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Build;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.support.v7.appcompat.R;
import android.support.v7.internal.view.ViewPropertyAnimatorCompatSet;
import android.support.v7.widget.ActionMenuPresenter;
import android.support.v7.widget.ActionMenuView;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class AbsActionBarView extends ViewGroup {
    private static final int FADE_DURATION = 200;
    private static final Interpolator sAlphaInterpolator = new DecelerateInterpolator();
    protected ActionMenuPresenter mActionMenuPresenter;
    protected int mContentHeight;
    protected ActionMenuView mMenuView;
    protected final Context mPopupContext;
    protected boolean mSplitActionBar;
    protected ViewGroup mSplitView;
    protected boolean mSplitWhenNarrow;
    protected final VisibilityAnimListener mVisAnimListener;
    protected ViewPropertyAnimatorCompat mVisibilityAnim;

    AbsActionBarView(Context context) {
        this(context, null);
    }

    AbsActionBarView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbsActionBarView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.mVisAnimListener = new VisibilityAnimListener();
        TypedValue tv = new TypedValue();
        if (context.getTheme().resolveAttribute(R.attr.actionBarPopupTheme, tv, true) && tv.resourceId != 0) {
            this.mPopupContext = new ContextThemeWrapper(context, tv.resourceId);
        } else {
            this.mPopupContext = context;
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration newConfig) {
        if (Build.VERSION.SDK_INT >= 8) {
            super.onConfigurationChanged(newConfig);
        }
        TypedArray a = getContext().obtainStyledAttributes(null, R.styleable.ActionBar, R.attr.actionBarStyle, 0);
        setContentHeight(a.getLayoutDimension(R.styleable.ActionBar_height, 0));
        a.recycle();
        if (this.mActionMenuPresenter != null) {
            this.mActionMenuPresenter.onConfigurationChanged(newConfig);
        }
    }

    public void setSplitToolbar(boolean split) {
        this.mSplitActionBar = split;
    }

    public void setSplitWhenNarrow(boolean splitWhenNarrow) {
        this.mSplitWhenNarrow = splitWhenNarrow;
    }

    public void setContentHeight(int height) {
        this.mContentHeight = height;
        requestLayout();
    }

    public int getContentHeight() {
        return this.mContentHeight;
    }

    public void setSplitView(ViewGroup splitView) {
        this.mSplitView = splitView;
    }

    public int getAnimatedVisibility() {
        return this.mVisibilityAnim != null ? this.mVisAnimListener.mFinalVisibility : getVisibility();
    }

    public void animateToVisibility(int visibility) {
        if (this.mVisibilityAnim != null) {
            this.mVisibilityAnim.cancel();
        }
        if (visibility == 0) {
            if (getVisibility() != 0) {
                ViewCompat.setAlpha(this, 0.0f);
                if (this.mSplitView != null && this.mMenuView != null) {
                    ViewCompat.setAlpha(this.mMenuView, 0.0f);
                }
            }
            ViewPropertyAnimatorCompat anim = ViewCompat.animate(this).alpha(1.0f);
            anim.setDuration(200L);
            anim.setInterpolator(sAlphaInterpolator);
            if (this.mSplitView != null && this.mMenuView != null) {
                ViewPropertyAnimatorCompatSet set = new ViewPropertyAnimatorCompatSet();
                ViewPropertyAnimatorCompat splitAnim = ViewCompat.animate(this.mMenuView).alpha(1.0f);
                splitAnim.setDuration(200L);
                set.setListener(this.mVisAnimListener.withFinalVisibility(anim, visibility));
                set.play(anim).play(splitAnim);
                set.start();
                return;
            }
            anim.setListener(this.mVisAnimListener.withFinalVisibility(anim, visibility));
            anim.start();
            return;
        }
        ViewPropertyAnimatorCompat anim2 = ViewCompat.animate(this).alpha(0.0f);
        anim2.setDuration(200L);
        anim2.setInterpolator(sAlphaInterpolator);
        if (this.mSplitView != null && this.mMenuView != null) {
            ViewPropertyAnimatorCompatSet set2 = new ViewPropertyAnimatorCompatSet();
            ViewPropertyAnimatorCompat splitAnim2 = ViewCompat.animate(this.mMenuView).alpha(0.0f);
            splitAnim2.setDuration(200L);
            set2.setListener(this.mVisAnimListener.withFinalVisibility(anim2, visibility));
            set2.play(anim2).play(splitAnim2);
            set2.start();
            return;
        }
        anim2.setListener(this.mVisAnimListener.withFinalVisibility(anim2, visibility));
        anim2.start();
    }

    public boolean showOverflowMenu() {
        if (this.mActionMenuPresenter != null) {
            return this.mActionMenuPresenter.showOverflowMenu();
        }
        return false;
    }

    public void postShowOverflowMenu() {
        post(new Runnable() { // from class: android.support.v7.internal.widget.AbsActionBarView.1
            @Override // java.lang.Runnable
            public void run() {
                AbsActionBarView.this.showOverflowMenu();
            }
        });
    }

    public boolean hideOverflowMenu() {
        if (this.mActionMenuPresenter != null) {
            return this.mActionMenuPresenter.hideOverflowMenu();
        }
        return false;
    }

    public boolean isOverflowMenuShowing() {
        if (this.mActionMenuPresenter != null) {
            return this.mActionMenuPresenter.isOverflowMenuShowing();
        }
        return false;
    }

    public boolean isOverflowMenuShowPending() {
        if (this.mActionMenuPresenter != null) {
            return this.mActionMenuPresenter.isOverflowMenuShowPending();
        }
        return false;
    }

    public boolean isOverflowReserved() {
        return this.mActionMenuPresenter != null && this.mActionMenuPresenter.isOverflowReserved();
    }

    public boolean canShowOverflowMenu() {
        return isOverflowReserved() && getVisibility() == 0;
    }

    public void dismissPopupMenus() {
        if (this.mActionMenuPresenter != null) {
            this.mActionMenuPresenter.dismissPopupMenus();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int measureChildView(View child, int availableWidth, int childSpecHeight, int spacing) {
        child.measure(View.MeasureSpec.makeMeasureSpec(availableWidth, Integer.MIN_VALUE), childSpecHeight);
        return Math.max(0, (availableWidth - child.getMeasuredWidth()) - spacing);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static int next(int x, int val, boolean isRtl) {
        return isRtl ? x - val : x + val;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int positionChild(View child, int x, int y, int contentHeight, boolean reverse) {
        int childWidth = child.getMeasuredWidth();
        int childHeight = child.getMeasuredHeight();
        int childTop = y + ((contentHeight - childHeight) / 2);
        if (reverse) {
            child.layout(x - childWidth, childTop, x, childTop + childHeight);
        } else {
            child.layout(x, childTop, x + childWidth, childTop + childHeight);
        }
        return reverse ? -childWidth : childWidth;
    }

    /* loaded from: classes.dex */
    protected class VisibilityAnimListener implements ViewPropertyAnimatorListener {
        private boolean mCanceled = false;
        int mFinalVisibility;

        protected VisibilityAnimListener() {
        }

        public VisibilityAnimListener withFinalVisibility(ViewPropertyAnimatorCompat animation, int visibility) {
            AbsActionBarView.this.mVisibilityAnim = animation;
            this.mFinalVisibility = visibility;
            return this;
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorListener
        public void onAnimationStart(View view) {
            AbsActionBarView.this.setVisibility(0);
            this.mCanceled = false;
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(View view) {
            if (!this.mCanceled) {
                AbsActionBarView.this.mVisibilityAnim = null;
                AbsActionBarView.this.setVisibility(this.mFinalVisibility);
                if (AbsActionBarView.this.mSplitView != null && AbsActionBarView.this.mMenuView != null) {
                    AbsActionBarView.this.mMenuView.setVisibility(this.mFinalVisibility);
                }
            }
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorListener
        public void onAnimationCancel(View view) {
            this.mCanceled = true;
        }
    }
}