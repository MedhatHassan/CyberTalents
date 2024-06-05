package android.support.v7.internal.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import java.lang.reflect.Field;

/* loaded from: classes.dex */
public class ListViewCompat extends ListView {
    public static final int INVALID_POSITION = -1;
    public static final int NO_POSITION = -1;
    private static final int[] STATE_SET_NOTHING = {0};
    private Field mIsChildViewEnabled;
    int mSelectionBottomPadding;
    int mSelectionLeftPadding;
    int mSelectionRightPadding;
    int mSelectionTopPadding;
    private GateKeeperDrawable mSelector;
    final Rect mSelectorRect;

    public ListViewCompat(Context context) {
        this(context, null);
    }

    public ListViewCompat(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ListViewCompat(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mSelectorRect = new Rect();
        this.mSelectionLeftPadding = 0;
        this.mSelectionTopPadding = 0;
        this.mSelectionRightPadding = 0;
        this.mSelectionBottomPadding = 0;
        try {
            this.mIsChildViewEnabled = AbsListView.class.getDeclaredField("mIsChildViewEnabled");
            this.mIsChildViewEnabled.setAccessible(true);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    @Override // android.widget.AbsListView
    public void setSelector(Drawable sel) {
        this.mSelector = new GateKeeperDrawable(sel);
        super.setSelector(this.mSelector);
        Rect padding = new Rect();
        sel.getPadding(padding);
        this.mSelectionLeftPadding = padding.left;
        this.mSelectionTopPadding = padding.top;
        this.mSelectionRightPadding = padding.right;
        this.mSelectionBottomPadding = padding.bottom;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        this.mSelector.setEnabled(true);
        updateSelectorStateCompat();
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        drawSelectorCompat(canvas);
        super.dispatchDraw(canvas);
    }

    protected void updateSelectorStateCompat() {
        Drawable selector = getSelector();
        if (selector != null && shouldShowSelectorCompat()) {
            selector.setState(getDrawableState());
        }
    }

    protected boolean shouldShowSelectorCompat() {
        return touchModeDrawsInPressedStateCompat() && isPressed();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean touchModeDrawsInPressedStateCompat() {
        return false;
    }

    protected void drawSelectorCompat(Canvas canvas) {
        if (!this.mSelectorRect.isEmpty()) {
            Drawable selector = getSelector();
            selector.setBounds(this.mSelectorRect);
            selector.draw(canvas);
        }
    }

    public int lookForSelectablePosition(int position, boolean lookDown) {
        int position2;
        ListAdapter adapter = getAdapter();
        if (adapter == null || isInTouchMode()) {
            return -1;
        }
        int count = adapter.getCount();
        if (!getAdapter().areAllItemsEnabled()) {
            if (lookDown) {
                position2 = Math.max(0, position);
                while (position2 < count && !adapter.isEnabled(position2)) {
                    position2++;
                }
            } else {
                position2 = Math.min(position, count - 1);
                while (position2 >= 0 && !adapter.isEnabled(position2)) {
                    position2--;
                }
            }
            if (position2 < 0 || position2 >= count) {
                return -1;
            }
            return position2;
        } else if (position < 0 || position >= count) {
            return -1;
        } else {
            return position;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void positionSelectorLikeTouchCompat(int position, View sel, float x, float y) {
        positionSelectorLikeFocusCompat(position, sel);
        Drawable selector = getSelector();
        if (selector != null && position != -1) {
            DrawableCompat.setHotspot(selector, x, y);
        }
    }

    protected void positionSelectorLikeFocusCompat(int position, View sel) {
        Drawable selector = getSelector();
        boolean manageState = (selector == null || position == -1) ? false : true;
        if (manageState) {
            selector.setVisible(false, false);
        }
        positionSelectorCompat(position, sel);
        if (manageState) {
            Rect bounds = this.mSelectorRect;
            float x = bounds.exactCenterX();
            float y = bounds.exactCenterY();
            selector.setVisible(getVisibility() == 0, false);
            DrawableCompat.setHotspot(selector, x, y);
        }
    }

    protected void positionSelectorCompat(int position, View sel) {
        Rect selectorRect = this.mSelectorRect;
        selectorRect.set(sel.getLeft(), sel.getTop(), sel.getRight(), sel.getBottom());
        selectorRect.left -= this.mSelectionLeftPadding;
        selectorRect.top -= this.mSelectionTopPadding;
        selectorRect.right += this.mSelectionRightPadding;
        selectorRect.bottom += this.mSelectionBottomPadding;
        try {
            boolean isChildViewEnabled = this.mIsChildViewEnabled.getBoolean(this);
            if (sel.isEnabled() != isChildViewEnabled) {
                this.mIsChildViewEnabled.set(this, Boolean.valueOf(!isChildViewEnabled));
                if (position != -1) {
                    refreshDrawableState();
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public int measureHeightOfChildrenCompat(int widthMeasureSpec, int startPosition, int endPosition, int maxHeight, int disallowPartialChildPosition) {
        int heightMeasureSpec;
        int paddingTop = getListPaddingTop();
        int paddingBottom = getListPaddingBottom();
        getListPaddingLeft();
        getListPaddingRight();
        int reportedDividerHeight = getDividerHeight();
        Drawable divider = getDivider();
        ListAdapter adapter = getAdapter();
        if (adapter == null) {
            return paddingTop + paddingBottom;
        }
        int returnedHeight = paddingTop + paddingBottom;
        int dividerHeight = (reportedDividerHeight <= 0 || divider == null) ? 0 : reportedDividerHeight;
        int prevHeightWithoutPartialChild = 0;
        View child = null;
        int viewType = 0;
        int count = adapter.getCount();
        int i = 0;
        while (i < count) {
            int newType = adapter.getItemViewType(i);
            if (newType != viewType) {
                child = null;
                viewType = newType;
            }
            child = adapter.getView(i, child, this);
            ViewGroup.LayoutParams childLp = child.getLayoutParams();
            if (childLp != null && childLp.height > 0) {
                heightMeasureSpec = View.MeasureSpec.makeMeasureSpec(childLp.height, 1073741824);
            } else {
                heightMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
            }
            child.measure(widthMeasureSpec, heightMeasureSpec);
            if (i > 0) {
                returnedHeight += dividerHeight;
            }
            returnedHeight += child.getMeasuredHeight();
            if (returnedHeight >= maxHeight) {
                return (disallowPartialChildPosition < 0 || i <= disallowPartialChildPosition || prevHeightWithoutPartialChild <= 0 || returnedHeight == maxHeight) ? maxHeight : prevHeightWithoutPartialChild;
            }
            if (disallowPartialChildPosition >= 0 && i >= disallowPartialChildPosition) {
                prevHeightWithoutPartialChild = returnedHeight;
            }
            i++;
        }
        int prevHeightWithoutPartialChild2 = returnedHeight;
        return prevHeightWithoutPartialChild2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setSelectorEnabled(boolean enabled) {
        this.mSelector.setEnabled(enabled);
    }

    /* loaded from: classes.dex */
    private static class GateKeeperDrawable extends DrawableWrapper {
        private boolean mEnabled;

        public GateKeeperDrawable(Drawable drawable) {
            super(drawable);
            this.mEnabled = true;
        }

        void setEnabled(boolean enabled) {
            this.mEnabled = enabled;
        }

        @Override // android.support.v7.internal.widget.DrawableWrapper, android.graphics.drawable.Drawable
        public boolean setState(int[] stateSet) {
            if (this.mEnabled) {
                return super.setState(stateSet);
            }
            return false;
        }

        @Override // android.support.v7.internal.widget.DrawableWrapper, android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            if (this.mEnabled) {
                super.draw(canvas);
            }
        }

        @Override // android.support.v7.internal.widget.DrawableWrapper, android.graphics.drawable.Drawable
        public void setHotspot(float x, float y) {
            if (this.mEnabled) {
                super.setHotspot(x, y);
            }
        }

        @Override // android.support.v7.internal.widget.DrawableWrapper, android.graphics.drawable.Drawable
        public void setHotspotBounds(int left, int top, int right, int bottom) {
            if (this.mEnabled) {
                super.setHotspotBounds(left, top, right, bottom);
            }
        }

        @Override // android.support.v7.internal.widget.DrawableWrapper, android.graphics.drawable.Drawable
        public boolean setVisible(boolean visible, boolean restart) {
            if (this.mEnabled) {
                return super.setVisible(visible, restart);
            }
            return false;
        }
    }
}