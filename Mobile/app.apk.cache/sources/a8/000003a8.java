package android.support.v7.internal.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcelable;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.support.v4.view.ViewPropertyAnimatorListenerAdapter;
import android.support.v4.widget.ScrollerCompat;
import android.support.v7.appcompat.R;
import android.support.v7.internal.VersionUtils;
import android.support.v7.internal.app.WindowCallback;
import android.support.v7.internal.view.menu.MenuPresenter;
import android.support.v7.internal.widget.ActivityChooserView;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes.dex */
public class ActionBarOverlayLayout extends ViewGroup implements DecorContentParent {
    static final int[] ATTRS = {R.attr.actionBarSize, 16842841};
    private static final String TAG = "ActionBarOverlayLayout";
    private final int ACTION_BAR_ANIMATE_DELAY;
    private ActionBarContainer mActionBarBottom;
    private int mActionBarHeight;
    private ActionBarContainer mActionBarTop;
    private ActionBarVisibilityCallback mActionBarVisibilityCallback;
    private final Runnable mAddActionBarHideOffset;
    private boolean mAnimatingForFling;
    private final Rect mBaseContentInsets;
    private final Rect mBaseInnerInsets;
    private final ViewPropertyAnimatorListener mBottomAnimatorListener;
    private ContentFrameLayout mContent;
    private final Rect mContentInsets;
    private ViewPropertyAnimatorCompat mCurrentActionBarBottomAnimator;
    private ViewPropertyAnimatorCompat mCurrentActionBarTopAnimator;
    private DecorToolbar mDecorToolbar;
    private ScrollerCompat mFlingEstimator;
    private boolean mHasNonEmbeddedTabs;
    private boolean mHideOnContentScroll;
    private int mHideOnContentScrollReference;
    private boolean mIgnoreWindowContentOverlay;
    private final Rect mInnerInsets;
    private final Rect mLastBaseContentInsets;
    private final Rect mLastInnerInsets;
    private int mLastSystemUiVisibility;
    private boolean mOverlayMode;
    private final Runnable mRemoveActionBarHideOffset;
    private final ViewPropertyAnimatorListener mTopAnimatorListener;
    private Drawable mWindowContentOverlay;
    private int mWindowVisibility;

    /* loaded from: classes.dex */
    public interface ActionBarVisibilityCallback {
        void enableContentAnimations(boolean z);

        void hideForSystem();

        void onContentScrollStarted();

        void onContentScrollStopped();

        void onWindowVisibilityChanged(int i);

        void showForSystem();
    }

    public ActionBarOverlayLayout(Context context) {
        super(context);
        this.mWindowVisibility = 0;
        this.mBaseContentInsets = new Rect();
        this.mLastBaseContentInsets = new Rect();
        this.mContentInsets = new Rect();
        this.mBaseInnerInsets = new Rect();
        this.mInnerInsets = new Rect();
        this.mLastInnerInsets = new Rect();
        this.ACTION_BAR_ANIMATE_DELAY = 600;
        this.mTopAnimatorListener = new ViewPropertyAnimatorListenerAdapter() { // from class: android.support.v7.internal.widget.ActionBarOverlayLayout.1
            @Override // android.support.v4.view.ViewPropertyAnimatorListenerAdapter, android.support.v4.view.ViewPropertyAnimatorListener
            public void onAnimationEnd(View view) {
                ActionBarOverlayLayout.this.mCurrentActionBarTopAnimator = null;
                ActionBarOverlayLayout.this.mAnimatingForFling = false;
            }

            @Override // android.support.v4.view.ViewPropertyAnimatorListenerAdapter, android.support.v4.view.ViewPropertyAnimatorListener
            public void onAnimationCancel(View view) {
                ActionBarOverlayLayout.this.mCurrentActionBarTopAnimator = null;
                ActionBarOverlayLayout.this.mAnimatingForFling = false;
            }
        };
        this.mBottomAnimatorListener = new ViewPropertyAnimatorListenerAdapter() { // from class: android.support.v7.internal.widget.ActionBarOverlayLayout.2
            @Override // android.support.v4.view.ViewPropertyAnimatorListenerAdapter, android.support.v4.view.ViewPropertyAnimatorListener
            public void onAnimationEnd(View view) {
                ActionBarOverlayLayout.this.mCurrentActionBarBottomAnimator = null;
                ActionBarOverlayLayout.this.mAnimatingForFling = false;
            }

            @Override // android.support.v4.view.ViewPropertyAnimatorListenerAdapter, android.support.v4.view.ViewPropertyAnimatorListener
            public void onAnimationCancel(View view) {
                ActionBarOverlayLayout.this.mCurrentActionBarBottomAnimator = null;
                ActionBarOverlayLayout.this.mAnimatingForFling = false;
            }
        };
        this.mRemoveActionBarHideOffset = new Runnable() { // from class: android.support.v7.internal.widget.ActionBarOverlayLayout.3
            @Override // java.lang.Runnable
            public void run() {
                ActionBarOverlayLayout.this.haltActionBarHideOffsetAnimations();
                ActionBarOverlayLayout.this.mCurrentActionBarTopAnimator = ViewCompat.animate(ActionBarOverlayLayout.this.mActionBarTop).translationY(0.0f).setListener(ActionBarOverlayLayout.this.mTopAnimatorListener);
                if (ActionBarOverlayLayout.this.mActionBarBottom != null && ActionBarOverlayLayout.this.mActionBarBottom.getVisibility() != 8) {
                    ActionBarOverlayLayout.this.mCurrentActionBarBottomAnimator = ViewCompat.animate(ActionBarOverlayLayout.this.mActionBarBottom).translationY(0.0f).setListener(ActionBarOverlayLayout.this.mBottomAnimatorListener);
                }
            }
        };
        this.mAddActionBarHideOffset = new Runnable() { // from class: android.support.v7.internal.widget.ActionBarOverlayLayout.4
            @Override // java.lang.Runnable
            public void run() {
                ActionBarOverlayLayout.this.haltActionBarHideOffsetAnimations();
                ActionBarOverlayLayout.this.mCurrentActionBarTopAnimator = ViewCompat.animate(ActionBarOverlayLayout.this.mActionBarTop).translationY(-ActionBarOverlayLayout.this.mActionBarTop.getHeight()).setListener(ActionBarOverlayLayout.this.mTopAnimatorListener);
                if (ActionBarOverlayLayout.this.mActionBarBottom != null && ActionBarOverlayLayout.this.mActionBarBottom.getVisibility() != 8) {
                    ActionBarOverlayLayout.this.mCurrentActionBarBottomAnimator = ViewCompat.animate(ActionBarOverlayLayout.this.mActionBarBottom).translationY(ActionBarOverlayLayout.this.mActionBarBottom.getHeight()).setListener(ActionBarOverlayLayout.this.mBottomAnimatorListener);
                }
            }
        };
        init(context);
    }

    public ActionBarOverlayLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mWindowVisibility = 0;
        this.mBaseContentInsets = new Rect();
        this.mLastBaseContentInsets = new Rect();
        this.mContentInsets = new Rect();
        this.mBaseInnerInsets = new Rect();
        this.mInnerInsets = new Rect();
        this.mLastInnerInsets = new Rect();
        this.ACTION_BAR_ANIMATE_DELAY = 600;
        this.mTopAnimatorListener = new ViewPropertyAnimatorListenerAdapter() { // from class: android.support.v7.internal.widget.ActionBarOverlayLayout.1
            @Override // android.support.v4.view.ViewPropertyAnimatorListenerAdapter, android.support.v4.view.ViewPropertyAnimatorListener
            public void onAnimationEnd(View view) {
                ActionBarOverlayLayout.this.mCurrentActionBarTopAnimator = null;
                ActionBarOverlayLayout.this.mAnimatingForFling = false;
            }

            @Override // android.support.v4.view.ViewPropertyAnimatorListenerAdapter, android.support.v4.view.ViewPropertyAnimatorListener
            public void onAnimationCancel(View view) {
                ActionBarOverlayLayout.this.mCurrentActionBarTopAnimator = null;
                ActionBarOverlayLayout.this.mAnimatingForFling = false;
            }
        };
        this.mBottomAnimatorListener = new ViewPropertyAnimatorListenerAdapter() { // from class: android.support.v7.internal.widget.ActionBarOverlayLayout.2
            @Override // android.support.v4.view.ViewPropertyAnimatorListenerAdapter, android.support.v4.view.ViewPropertyAnimatorListener
            public void onAnimationEnd(View view) {
                ActionBarOverlayLayout.this.mCurrentActionBarBottomAnimator = null;
                ActionBarOverlayLayout.this.mAnimatingForFling = false;
            }

            @Override // android.support.v4.view.ViewPropertyAnimatorListenerAdapter, android.support.v4.view.ViewPropertyAnimatorListener
            public void onAnimationCancel(View view) {
                ActionBarOverlayLayout.this.mCurrentActionBarBottomAnimator = null;
                ActionBarOverlayLayout.this.mAnimatingForFling = false;
            }
        };
        this.mRemoveActionBarHideOffset = new Runnable() { // from class: android.support.v7.internal.widget.ActionBarOverlayLayout.3
            @Override // java.lang.Runnable
            public void run() {
                ActionBarOverlayLayout.this.haltActionBarHideOffsetAnimations();
                ActionBarOverlayLayout.this.mCurrentActionBarTopAnimator = ViewCompat.animate(ActionBarOverlayLayout.this.mActionBarTop).translationY(0.0f).setListener(ActionBarOverlayLayout.this.mTopAnimatorListener);
                if (ActionBarOverlayLayout.this.mActionBarBottom != null && ActionBarOverlayLayout.this.mActionBarBottom.getVisibility() != 8) {
                    ActionBarOverlayLayout.this.mCurrentActionBarBottomAnimator = ViewCompat.animate(ActionBarOverlayLayout.this.mActionBarBottom).translationY(0.0f).setListener(ActionBarOverlayLayout.this.mBottomAnimatorListener);
                }
            }
        };
        this.mAddActionBarHideOffset = new Runnable() { // from class: android.support.v7.internal.widget.ActionBarOverlayLayout.4
            @Override // java.lang.Runnable
            public void run() {
                ActionBarOverlayLayout.this.haltActionBarHideOffsetAnimations();
                ActionBarOverlayLayout.this.mCurrentActionBarTopAnimator = ViewCompat.animate(ActionBarOverlayLayout.this.mActionBarTop).translationY(-ActionBarOverlayLayout.this.mActionBarTop.getHeight()).setListener(ActionBarOverlayLayout.this.mTopAnimatorListener);
                if (ActionBarOverlayLayout.this.mActionBarBottom != null && ActionBarOverlayLayout.this.mActionBarBottom.getVisibility() != 8) {
                    ActionBarOverlayLayout.this.mCurrentActionBarBottomAnimator = ViewCompat.animate(ActionBarOverlayLayout.this.mActionBarBottom).translationY(ActionBarOverlayLayout.this.mActionBarBottom.getHeight()).setListener(ActionBarOverlayLayout.this.mBottomAnimatorListener);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        TypedArray ta = getContext().getTheme().obtainStyledAttributes(ATTRS);
        this.mActionBarHeight = ta.getDimensionPixelSize(0, 0);
        this.mWindowContentOverlay = ta.getDrawable(1);
        setWillNotDraw(this.mWindowContentOverlay == null);
        ta.recycle();
        this.mIgnoreWindowContentOverlay = context.getApplicationInfo().targetSdkVersion < 19;
        this.mFlingEstimator = ScrollerCompat.create(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        haltActionBarHideOffsetAnimations();
    }

    public void setActionBarVisibilityCallback(ActionBarVisibilityCallback cb) {
        this.mActionBarVisibilityCallback = cb;
        if (getWindowToken() != null) {
            this.mActionBarVisibilityCallback.onWindowVisibilityChanged(this.mWindowVisibility);
            if (this.mLastSystemUiVisibility != 0) {
                int newVis = this.mLastSystemUiVisibility;
                onWindowSystemUiVisibilityChanged(newVis);
                ViewCompat.requestApplyInsets(this);
            }
        }
    }

    public void setOverlayMode(boolean overlayMode) {
        this.mOverlayMode = overlayMode;
        this.mIgnoreWindowContentOverlay = overlayMode && getContext().getApplicationInfo().targetSdkVersion < 19;
    }

    public boolean isInOverlayMode() {
        return this.mOverlayMode;
    }

    public void setHasNonEmbeddedTabs(boolean hasNonEmbeddedTabs) {
        this.mHasNonEmbeddedTabs = hasNonEmbeddedTabs;
    }

    public void setShowingForActionMode(boolean showing) {
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration newConfig) {
        if (Build.VERSION.SDK_INT >= 8) {
            super.onConfigurationChanged(newConfig);
        }
        init(getContext());
        ViewCompat.requestApplyInsets(this);
    }

    @Override // android.view.View
    public void onWindowSystemUiVisibilityChanged(int visible) {
        if (Build.VERSION.SDK_INT >= 16) {
            super.onWindowSystemUiVisibilityChanged(visible);
        }
        pullChildren();
        int diff = this.mLastSystemUiVisibility ^ visible;
        this.mLastSystemUiVisibility = visible;
        boolean barVisible = (visible & 4) == 0;
        boolean stable = (visible & 256) != 0;
        if (this.mActionBarVisibilityCallback != null) {
            this.mActionBarVisibilityCallback.enableContentAnimations(stable ? false : true);
            if (barVisible || !stable) {
                this.mActionBarVisibilityCallback.showForSystem();
            } else {
                this.mActionBarVisibilityCallback.hideForSystem();
            }
        }
        if ((diff & 256) != 0 && this.mActionBarVisibilityCallback != null) {
            ViewCompat.requestApplyInsets(this);
        }
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int visibility) {
        super.onWindowVisibilityChanged(visibility);
        this.mWindowVisibility = visibility;
        if (this.mActionBarVisibilityCallback != null) {
            this.mActionBarVisibilityCallback.onWindowVisibilityChanged(visibility);
        }
    }

    private boolean applyInsets(View view, Rect insets, boolean left, boolean top, boolean bottom, boolean right) {
        boolean changed = false;
        LayoutParams lp = (LayoutParams) view.getLayoutParams();
        if (left && lp.leftMargin != insets.left) {
            changed = true;
            lp.leftMargin = insets.left;
        }
        if (top && lp.topMargin != insets.top) {
            changed = true;
            lp.topMargin = insets.top;
        }
        if (right && lp.rightMargin != insets.right) {
            changed = true;
            lp.rightMargin = insets.right;
        }
        if (bottom && lp.bottomMargin != insets.bottom) {
            lp.bottomMargin = insets.bottom;
            return true;
        }
        return changed;
    }

    @Override // android.view.View
    protected boolean fitSystemWindows(Rect insets) {
        pullChildren();
        int vis = ViewCompat.getWindowSystemUiVisibility(this);
        if ((vis & 256) != 0) {
        }
        boolean changed = applyInsets(this.mActionBarTop, insets, true, true, false, true);
        if (this.mActionBarBottom != null) {
            changed |= applyInsets(this.mActionBarBottom, insets, true, false, true, true);
        }
        this.mBaseInnerInsets.set(insets);
        ViewUtils.computeFitSystemWindows(this, this.mBaseInnerInsets, this.mBaseContentInsets);
        if (!this.mLastBaseContentInsets.equals(this.mBaseContentInsets)) {
            changed = true;
            this.mLastBaseContentInsets.set(this.mBaseContentInsets);
        }
        if (changed) {
            requestLayout();
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new LayoutParams(getContext(), attrs);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams p) {
        return new LayoutParams(p);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams p) {
        return p instanceof LayoutParams;
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        pullChildren();
        int topInset = 0;
        int bottomInset = 0;
        measureChildWithMargins(this.mActionBarTop, widthMeasureSpec, 0, heightMeasureSpec, 0);
        LayoutParams lp = (LayoutParams) this.mActionBarTop.getLayoutParams();
        int maxWidth = Math.max(0, this.mActionBarTop.getMeasuredWidth() + lp.leftMargin + lp.rightMargin);
        int maxHeight = Math.max(0, this.mActionBarTop.getMeasuredHeight() + lp.topMargin + lp.bottomMargin);
        int childState = ViewUtils.combineMeasuredStates(0, ViewCompat.getMeasuredState(this.mActionBarTop));
        if (this.mActionBarBottom != null) {
            measureChildWithMargins(this.mActionBarBottom, widthMeasureSpec, 0, heightMeasureSpec, 0);
            LayoutParams lp2 = (LayoutParams) this.mActionBarBottom.getLayoutParams();
            maxWidth = Math.max(maxWidth, this.mActionBarBottom.getMeasuredWidth() + lp2.leftMargin + lp2.rightMargin);
            maxHeight = Math.max(maxHeight, this.mActionBarBottom.getMeasuredHeight() + lp2.topMargin + lp2.bottomMargin);
            childState = ViewUtils.combineMeasuredStates(childState, ViewCompat.getMeasuredState(this.mActionBarBottom));
        }
        int vis = ViewCompat.getWindowSystemUiVisibility(this);
        boolean stable = (vis & 256) != 0;
        if (stable) {
            topInset = this.mActionBarHeight;
            if (this.mHasNonEmbeddedTabs) {
                View tabs = this.mActionBarTop.getTabContainer();
                if (tabs != null) {
                    topInset += this.mActionBarHeight;
                }
            }
        } else if (this.mActionBarTop.getVisibility() != 8) {
            topInset = this.mActionBarTop.getMeasuredHeight();
        }
        if (this.mDecorToolbar.isSplit() && this.mActionBarBottom != null) {
            bottomInset = stable ? this.mActionBarHeight : this.mActionBarBottom.getMeasuredHeight();
        }
        this.mContentInsets.set(this.mBaseContentInsets);
        this.mInnerInsets.set(this.mBaseInnerInsets);
        if (!this.mOverlayMode && !stable) {
            this.mContentInsets.top += topInset;
            this.mContentInsets.bottom += bottomInset;
        } else {
            this.mInnerInsets.top += topInset;
            this.mInnerInsets.bottom += bottomInset;
        }
        applyInsets(this.mContent, this.mContentInsets, true, true, true, true);
        if (!this.mLastInnerInsets.equals(this.mInnerInsets)) {
            this.mLastInnerInsets.set(this.mInnerInsets);
            this.mContent.dispatchFitSystemWindows(this.mInnerInsets);
        }
        measureChildWithMargins(this.mContent, widthMeasureSpec, 0, heightMeasureSpec, 0);
        LayoutParams lp3 = (LayoutParams) this.mContent.getLayoutParams();
        int maxWidth2 = Math.max(maxWidth, this.mContent.getMeasuredWidth() + lp3.leftMargin + lp3.rightMargin);
        int maxHeight2 = Math.max(maxHeight, this.mContent.getMeasuredHeight() + lp3.topMargin + lp3.bottomMargin);
        int childState2 = ViewUtils.combineMeasuredStates(childState, ViewCompat.getMeasuredState(this.mContent));
        setMeasuredDimension(ViewCompat.resolveSizeAndState(Math.max(maxWidth2 + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), widthMeasureSpec, childState2), ViewCompat.resolveSizeAndState(Math.max(maxHeight2 + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), heightMeasureSpec, childState2 << 16));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        int childTop;
        int count = getChildCount();
        int parentLeft = getPaddingLeft();
        int paddingRight = (right - left) - getPaddingRight();
        int parentTop = getPaddingTop();
        int parentBottom = (bottom - top) - getPaddingBottom();
        for (int i = 0; i < count; i++) {
            View child = getChildAt(i);
            if (child.getVisibility() != 8) {
                LayoutParams lp = (LayoutParams) child.getLayoutParams();
                int width = child.getMeasuredWidth();
                int height = child.getMeasuredHeight();
                int childLeft = parentLeft + lp.leftMargin;
                if (child == this.mActionBarBottom) {
                    childTop = (parentBottom - height) - lp.bottomMargin;
                } else {
                    childTop = parentTop + lp.topMargin;
                }
                child.layout(childLeft, childTop, childLeft + width, childTop + height);
            }
        }
    }

    @Override // android.view.View
    public void draw(Canvas c) {
        super.draw(c);
        if (this.mWindowContentOverlay != null && !this.mIgnoreWindowContentOverlay) {
            int top = this.mActionBarTop.getVisibility() == 0 ? (int) (this.mActionBarTop.getBottom() + ViewCompat.getTranslationY(this.mActionBarTop) + 0.5f) : 0;
            this.mWindowContentOverlay.setBounds(0, top, getWidth(), this.mWindowContentOverlay.getIntrinsicHeight() + top);
            this.mWindowContentOverlay.draw(c);
        }
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onStartNestedScroll(View child, View target, int axes) {
        if ((axes & 2) == 0 || this.mActionBarTop.getVisibility() != 0) {
            return false;
        }
        return this.mHideOnContentScroll;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScrollAccepted(View child, View target, int axes) {
        super.onNestedScrollAccepted(child, target, axes);
        this.mHideOnContentScrollReference = getActionBarHideOffset();
        haltActionBarHideOffsetAnimations();
        if (this.mActionBarVisibilityCallback != null) {
            this.mActionBarVisibilityCallback.onContentScrollStarted();
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScroll(View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed) {
        this.mHideOnContentScrollReference += dyConsumed;
        setActionBarHideOffset(this.mHideOnContentScrollReference);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onStopNestedScroll(View target) {
        super.onStopNestedScroll(target);
        if (this.mHideOnContentScroll && !this.mAnimatingForFling) {
            if (this.mHideOnContentScrollReference <= this.mActionBarTop.getHeight()) {
                postRemoveActionBarHideOffset();
            } else {
                postAddActionBarHideOffset();
            }
        }
        if (this.mActionBarVisibilityCallback != null) {
            this.mActionBarVisibilityCallback.onContentScrollStopped();
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedFling(View target, float velocityX, float velocityY, boolean consumed) {
        if (!this.mHideOnContentScroll || !consumed) {
            return false;
        }
        if (shouldHideActionBarOnFling(velocityX, velocityY)) {
            addActionBarHideOffset();
        } else {
            removeActionBarHideOffset();
        }
        this.mAnimatingForFling = true;
        return true;
    }

    void pullChildren() {
        if (this.mContent == null) {
            this.mContent = (ContentFrameLayout) findViewById(R.id.action_bar_activity_content);
            this.mActionBarTop = (ActionBarContainer) findViewById(R.id.action_bar_container);
            this.mDecorToolbar = getDecorToolbar(findViewById(R.id.action_bar));
            this.mActionBarBottom = (ActionBarContainer) findViewById(R.id.split_action_bar);
        }
    }

    private DecorToolbar getDecorToolbar(View view) {
        if (view instanceof DecorToolbar) {
            return (DecorToolbar) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        throw new IllegalStateException("Can't make a decor toolbar out of " + view.getClass().getSimpleName());
    }

    public void setHideOnContentScrollEnabled(boolean hideOnContentScroll) {
        if (hideOnContentScroll != this.mHideOnContentScroll) {
            this.mHideOnContentScroll = hideOnContentScroll;
            if (!hideOnContentScroll) {
                if (VersionUtils.isAtLeastL()) {
                    stopNestedScroll();
                }
                haltActionBarHideOffsetAnimations();
                setActionBarHideOffset(0);
            }
        }
    }

    public boolean isHideOnContentScrollEnabled() {
        return this.mHideOnContentScroll;
    }

    public int getActionBarHideOffset() {
        if (this.mActionBarTop != null) {
            return -((int) ViewCompat.getTranslationY(this.mActionBarTop));
        }
        return 0;
    }

    public void setActionBarHideOffset(int offset) {
        haltActionBarHideOffsetAnimations();
        int topHeight = this.mActionBarTop.getHeight();
        int offset2 = Math.max(0, Math.min(offset, topHeight));
        ViewCompat.setTranslationY(this.mActionBarTop, -offset2);
        if (this.mActionBarBottom != null && this.mActionBarBottom.getVisibility() != 8) {
            float fOffset = offset2 / topHeight;
            int bOffset = (int) (this.mActionBarBottom.getHeight() * fOffset);
            ViewCompat.setTranslationY(this.mActionBarBottom, bOffset);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void haltActionBarHideOffsetAnimations() {
        removeCallbacks(this.mRemoveActionBarHideOffset);
        removeCallbacks(this.mAddActionBarHideOffset);
        if (this.mCurrentActionBarTopAnimator != null) {
            this.mCurrentActionBarTopAnimator.cancel();
        }
        if (this.mCurrentActionBarBottomAnimator != null) {
            this.mCurrentActionBarBottomAnimator.cancel();
        }
    }

    private void postRemoveActionBarHideOffset() {
        haltActionBarHideOffsetAnimations();
        postDelayed(this.mRemoveActionBarHideOffset, 600L);
    }

    private void postAddActionBarHideOffset() {
        haltActionBarHideOffsetAnimations();
        postDelayed(this.mAddActionBarHideOffset, 600L);
    }

    private void removeActionBarHideOffset() {
        haltActionBarHideOffsetAnimations();
        this.mRemoveActionBarHideOffset.run();
    }

    private void addActionBarHideOffset() {
        haltActionBarHideOffsetAnimations();
        this.mAddActionBarHideOffset.run();
    }

    private boolean shouldHideActionBarOnFling(float velocityX, float velocityY) {
        this.mFlingEstimator.fling(0, 0, 0, (int) velocityY, 0, 0, Integer.MIN_VALUE, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        int finalY = this.mFlingEstimator.getFinalY();
        return finalY > this.mActionBarTop.getHeight();
    }

    @Override // android.support.v7.internal.widget.DecorContentParent
    public void setWindowCallback(WindowCallback cb) {
        pullChildren();
        this.mDecorToolbar.setWindowCallback(cb);
    }

    @Override // android.support.v7.internal.widget.DecorContentParent
    public void setWindowTitle(CharSequence title) {
        pullChildren();
        this.mDecorToolbar.setWindowTitle(title);
    }

    @Override // android.support.v7.internal.widget.DecorContentParent
    public CharSequence getTitle() {
        pullChildren();
        return this.mDecorToolbar.getTitle();
    }

    @Override // android.support.v7.internal.widget.DecorContentParent
    public void initFeature(int windowFeature) {
        pullChildren();
        switch (windowFeature) {
            case 2:
                this.mDecorToolbar.initProgress();
                return;
            case 5:
                this.mDecorToolbar.initIndeterminateProgress();
                return;
            case 9:
                setOverlayMode(true);
                return;
            default:
                return;
        }
    }

    @Override // android.support.v7.internal.widget.DecorContentParent
    public void setUiOptions(int uiOptions) {
    }

    @Override // android.support.v7.internal.widget.DecorContentParent
    public boolean hasIcon() {
        pullChildren();
        return this.mDecorToolbar.hasIcon();
    }

    @Override // android.support.v7.internal.widget.DecorContentParent
    public boolean hasLogo() {
        pullChildren();
        return this.mDecorToolbar.hasLogo();
    }

    @Override // android.support.v7.internal.widget.DecorContentParent
    public void setIcon(int resId) {
        pullChildren();
        this.mDecorToolbar.setIcon(resId);
    }

    @Override // android.support.v7.internal.widget.DecorContentParent
    public void setIcon(Drawable d) {
        pullChildren();
        this.mDecorToolbar.setIcon(d);
    }

    @Override // android.support.v7.internal.widget.DecorContentParent
    public void setLogo(int resId) {
        pullChildren();
        this.mDecorToolbar.setLogo(resId);
    }

    @Override // android.support.v7.internal.widget.DecorContentParent
    public boolean canShowOverflowMenu() {
        pullChildren();
        return this.mDecorToolbar.canShowOverflowMenu();
    }

    @Override // android.support.v7.internal.widget.DecorContentParent
    public boolean isOverflowMenuShowing() {
        pullChildren();
        return this.mDecorToolbar.isOverflowMenuShowing();
    }

    @Override // android.support.v7.internal.widget.DecorContentParent
    public boolean isOverflowMenuShowPending() {
        pullChildren();
        return this.mDecorToolbar.isOverflowMenuShowPending();
    }

    @Override // android.support.v7.internal.widget.DecorContentParent
    public boolean showOverflowMenu() {
        pullChildren();
        return this.mDecorToolbar.showOverflowMenu();
    }

    @Override // android.support.v7.internal.widget.DecorContentParent
    public boolean hideOverflowMenu() {
        pullChildren();
        return this.mDecorToolbar.hideOverflowMenu();
    }

    @Override // android.support.v7.internal.widget.DecorContentParent
    public void setMenuPrepared() {
        pullChildren();
        this.mDecorToolbar.setMenuPrepared();
    }

    @Override // android.support.v7.internal.widget.DecorContentParent
    public void setMenu(Menu menu, MenuPresenter.Callback cb) {
        pullChildren();
        this.mDecorToolbar.setMenu(menu, cb);
    }

    @Override // android.support.v7.internal.widget.DecorContentParent
    public void saveToolbarHierarchyState(SparseArray<Parcelable> toolbarStates) {
        pullChildren();
        this.mDecorToolbar.saveHierarchyState(toolbarStates);
    }

    @Override // android.support.v7.internal.widget.DecorContentParent
    public void restoreToolbarHierarchyState(SparseArray<Parcelable> toolbarStates) {
        pullChildren();
        this.mDecorToolbar.restoreHierarchyState(toolbarStates);
    }

    @Override // android.support.v7.internal.widget.DecorContentParent
    public void dismissPopups() {
        pullChildren();
        this.mDecorToolbar.dismissPopupMenus();
    }

    /* loaded from: classes.dex */
    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public LayoutParams(Context c, AttributeSet attrs) {
            super(c, attrs);
        }

        public LayoutParams(int width, int height) {
            super(width, height);
        }

        public LayoutParams(ViewGroup.LayoutParams source) {
            super(source);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams source) {
            super(source);
        }
    }
}