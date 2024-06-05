package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.IntDef;
import android.support.v4.media.session.PlaybackStateCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.R;
import android.support.v7.internal.widget.TintTypedArray;
import android.support.v7.internal.widget.ViewUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes.dex */
public class LinearLayoutCompat extends ViewGroup {
    public static final int HORIZONTAL = 0;
    private static final int INDEX_BOTTOM = 2;
    private static final int INDEX_CENTER_VERTICAL = 0;
    private static final int INDEX_FILL = 3;
    private static final int INDEX_TOP = 1;
    public static final int SHOW_DIVIDER_BEGINNING = 1;
    public static final int SHOW_DIVIDER_END = 4;
    public static final int SHOW_DIVIDER_MIDDLE = 2;
    public static final int SHOW_DIVIDER_NONE = 0;
    public static final int VERTICAL = 1;
    private static final int VERTICAL_GRAVITY_COUNT = 4;
    private boolean mBaselineAligned;
    private int mBaselineAlignedChildIndex;
    private int mBaselineChildTop;
    private Drawable mDivider;
    private int mDividerHeight;
    private int mDividerPadding;
    private int mDividerWidth;
    private int mGravity;
    private int[] mMaxAscent;
    private int[] mMaxDescent;
    private int mOrientation;
    private int mShowDividers;
    private int mTotalLength;
    private boolean mUseLargestChild;
    private float mWeightSum;

    @Retention(RetentionPolicy.SOURCE)
    @IntDef(flag = true, value = {0, PlaybackStateCompat.ACTION_STOP, PlaybackStateCompat.ACTION_PAUSE, PlaybackStateCompat.ACTION_PLAY})
    /* loaded from: classes.dex */
    public @interface DividerMode {
    }

    @Retention(RetentionPolicy.SOURCE)
    @IntDef({0, PlaybackStateCompat.ACTION_STOP})
    /* loaded from: classes.dex */
    public @interface OrientationMode {
    }

    public LinearLayoutCompat(Context context) {
        this(context, null);
    }

    public LinearLayoutCompat(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LinearLayoutCompat(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mBaselineAligned = true;
        this.mBaselineAlignedChildIndex = -1;
        this.mBaselineChildTop = 0;
        this.mGravity = 8388659;
        TintTypedArray a = TintTypedArray.obtainStyledAttributes(context, attrs, R.styleable.LinearLayoutCompat, defStyleAttr, 0);
        int index = a.getInt(R.styleable.LinearLayoutCompat_android_orientation, -1);
        if (index >= 0) {
            setOrientation(index);
        }
        int index2 = a.getInt(R.styleable.LinearLayoutCompat_android_gravity, -1);
        if (index2 >= 0) {
            setGravity(index2);
        }
        boolean baselineAligned = a.getBoolean(R.styleable.LinearLayoutCompat_android_baselineAligned, true);
        if (!baselineAligned) {
            setBaselineAligned(baselineAligned);
        }
        this.mWeightSum = a.getFloat(R.styleable.LinearLayoutCompat_android_weightSum, -1.0f);
        this.mBaselineAlignedChildIndex = a.getInt(R.styleable.LinearLayoutCompat_android_baselineAlignedChildIndex, -1);
        this.mUseLargestChild = a.getBoolean(R.styleable.LinearLayoutCompat_measureWithLargestChild, false);
        setDividerDrawable(a.getDrawable(R.styleable.LinearLayoutCompat_divider));
        this.mShowDividers = a.getInt(R.styleable.LinearLayoutCompat_showDividers, 0);
        this.mDividerPadding = a.getDimensionPixelSize(R.styleable.LinearLayoutCompat_dividerPadding, 0);
        a.recycle();
    }

    public void setShowDividers(int showDividers) {
        if (showDividers != this.mShowDividers) {
            requestLayout();
        }
        this.mShowDividers = showDividers;
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public int getShowDividers() {
        return this.mShowDividers;
    }

    public Drawable getDividerDrawable() {
        return this.mDivider;
    }

    public void setDividerDrawable(Drawable divider) {
        if (divider != this.mDivider) {
            this.mDivider = divider;
            if (divider != null) {
                this.mDividerWidth = divider.getIntrinsicWidth();
                this.mDividerHeight = divider.getIntrinsicHeight();
            } else {
                this.mDividerWidth = 0;
                this.mDividerHeight = 0;
            }
            setWillNotDraw(divider == null);
            requestLayout();
        }
    }

    public void setDividerPadding(int padding) {
        this.mDividerPadding = padding;
    }

    public int getDividerPadding() {
        return this.mDividerPadding;
    }

    public int getDividerWidth() {
        return this.mDividerWidth;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.mDivider != null) {
            if (this.mOrientation == 1) {
                drawDividersVertical(canvas);
            } else {
                drawDividersHorizontal(canvas);
            }
        }
    }

    void drawDividersVertical(Canvas canvas) {
        int bottom;
        int count = getVirtualChildCount();
        for (int i = 0; i < count; i++) {
            View child = getVirtualChildAt(i);
            if (child != null && child.getVisibility() != 8 && hasDividerBeforeChildAt(i)) {
                LayoutParams lp = (LayoutParams) child.getLayoutParams();
                int top = (child.getTop() - lp.topMargin) - this.mDividerHeight;
                drawHorizontalDivider(canvas, top);
            }
        }
        if (hasDividerBeforeChildAt(count)) {
            View child2 = getVirtualChildAt(count - 1);
            if (child2 == null) {
                bottom = (getHeight() - getPaddingBottom()) - this.mDividerHeight;
            } else {
                LayoutParams lp2 = (LayoutParams) child2.getLayoutParams();
                bottom = child2.getBottom() + lp2.bottomMargin;
            }
            drawHorizontalDivider(canvas, bottom);
        }
    }

    void drawDividersHorizontal(Canvas canvas) {
        int position;
        int position2;
        int count = getVirtualChildCount();
        boolean isLayoutRtl = ViewUtils.isLayoutRtl(this);
        for (int i = 0; i < count; i++) {
            View child = getVirtualChildAt(i);
            if (child != null && child.getVisibility() != 8 && hasDividerBeforeChildAt(i)) {
                LayoutParams lp = (LayoutParams) child.getLayoutParams();
                if (isLayoutRtl) {
                    position2 = child.getRight() + lp.rightMargin;
                } else {
                    position2 = (child.getLeft() - lp.leftMargin) - this.mDividerWidth;
                }
                drawVerticalDivider(canvas, position2);
            }
        }
        if (hasDividerBeforeChildAt(count)) {
            View child2 = getVirtualChildAt(count - 1);
            if (child2 == null) {
                if (isLayoutRtl) {
                    position = getPaddingLeft();
                } else {
                    position = (getWidth() - getPaddingRight()) - this.mDividerWidth;
                }
            } else {
                LayoutParams lp2 = (LayoutParams) child2.getLayoutParams();
                if (isLayoutRtl) {
                    position = (child2.getLeft() - lp2.leftMargin) - this.mDividerWidth;
                } else {
                    position = child2.getRight() + lp2.rightMargin;
                }
            }
            drawVerticalDivider(canvas, position);
        }
    }

    void drawHorizontalDivider(Canvas canvas, int top) {
        this.mDivider.setBounds(getPaddingLeft() + this.mDividerPadding, top, (getWidth() - getPaddingRight()) - this.mDividerPadding, this.mDividerHeight + top);
        this.mDivider.draw(canvas);
    }

    void drawVerticalDivider(Canvas canvas, int left) {
        this.mDivider.setBounds(left, getPaddingTop() + this.mDividerPadding, this.mDividerWidth + left, (getHeight() - getPaddingBottom()) - this.mDividerPadding);
        this.mDivider.draw(canvas);
    }

    public boolean isBaselineAligned() {
        return this.mBaselineAligned;
    }

    public void setBaselineAligned(boolean baselineAligned) {
        this.mBaselineAligned = baselineAligned;
    }

    public boolean isMeasureWithLargestChildEnabled() {
        return this.mUseLargestChild;
    }

    public void setMeasureWithLargestChildEnabled(boolean enabled) {
        this.mUseLargestChild = enabled;
    }

    @Override // android.view.View
    public int getBaseline() {
        int majorGravity;
        if (this.mBaselineAlignedChildIndex < 0) {
            return super.getBaseline();
        }
        if (getChildCount() <= this.mBaselineAlignedChildIndex) {
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
        }
        View child = getChildAt(this.mBaselineAlignedChildIndex);
        int childBaseline = child.getBaseline();
        if (childBaseline == -1) {
            if (this.mBaselineAlignedChildIndex != 0) {
                throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
            }
            return -1;
        }
        int childTop = this.mBaselineChildTop;
        if (this.mOrientation == 1 && (majorGravity = this.mGravity & 112) != 48) {
            switch (majorGravity) {
                case 16:
                    childTop += ((((getBottom() - getTop()) - getPaddingTop()) - getPaddingBottom()) - this.mTotalLength) / 2;
                    break;
                case 80:
                    childTop = ((getBottom() - getTop()) - getPaddingBottom()) - this.mTotalLength;
                    break;
            }
        }
        LayoutParams lp = (LayoutParams) child.getLayoutParams();
        return lp.topMargin + childTop + childBaseline;
    }

    public int getBaselineAlignedChildIndex() {
        return this.mBaselineAlignedChildIndex;
    }

    public void setBaselineAlignedChildIndex(int i) {
        if (i < 0 || i >= getChildCount()) {
            throw new IllegalArgumentException("base aligned child index out of range (0, " + getChildCount() + ")");
        }
        this.mBaselineAlignedChildIndex = i;
    }

    View getVirtualChildAt(int index) {
        return getChildAt(index);
    }

    int getVirtualChildCount() {
        return getChildCount();
    }

    public float getWeightSum() {
        return this.mWeightSum;
    }

    public void setWeightSum(float weightSum) {
        this.mWeightSum = Math.max(0.0f, weightSum);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (this.mOrientation == 1) {
            measureVertical(widthMeasureSpec, heightMeasureSpec);
        } else {
            measureHorizontal(widthMeasureSpec, heightMeasureSpec);
        }
    }

    protected boolean hasDividerBeforeChildAt(int childIndex) {
        if (childIndex == 0) {
            return (this.mShowDividers & 1) != 0;
        } else if (childIndex == getChildCount()) {
            return (this.mShowDividers & 4) != 0;
        } else if ((this.mShowDividers & 2) != 0) {
            boolean hasVisibleViewBefore = false;
            int i = childIndex - 1;
            while (true) {
                if (i < 0) {
                    break;
                } else if (getChildAt(i).getVisibility() == 8) {
                    i--;
                } else {
                    hasVisibleViewBefore = true;
                    break;
                }
            }
            return hasVisibleViewBefore;
        } else {
            return false;
        }
    }

    void measureVertical(int widthMeasureSpec, int heightMeasureSpec) {
        this.mTotalLength = 0;
        int maxWidth = 0;
        int childState = 0;
        int alternativeMaxWidth = 0;
        int weightedMaxWidth = 0;
        boolean allFillParent = true;
        float totalWeight = 0.0f;
        int count = getVirtualChildCount();
        int widthMode = View.MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = View.MeasureSpec.getMode(heightMeasureSpec);
        boolean matchWidth = false;
        boolean skippedMeasure = false;
        int baselineChildIndex = this.mBaselineAlignedChildIndex;
        boolean useLargestChild = this.mUseLargestChild;
        int largestChildHeight = Integer.MIN_VALUE;
        int i = 0;
        while (i < count) {
            View child = getVirtualChildAt(i);
            if (child == null) {
                this.mTotalLength += measureNullChild(i);
            } else if (child.getVisibility() == 8) {
                i += getChildrenSkipCount(child, i);
            } else {
                if (hasDividerBeforeChildAt(i)) {
                    this.mTotalLength += this.mDividerHeight;
                }
                LayoutParams lp = (LayoutParams) child.getLayoutParams();
                totalWeight += lp.weight;
                if (heightMode == 1073741824 && lp.height == 0 && lp.weight > 0.0f) {
                    int totalLength = this.mTotalLength;
                    this.mTotalLength = Math.max(totalLength, lp.topMargin + totalLength + lp.bottomMargin);
                    skippedMeasure = true;
                } else {
                    int oldHeight = Integer.MIN_VALUE;
                    if (lp.height == 0 && lp.weight > 0.0f) {
                        oldHeight = 0;
                        lp.height = -2;
                    }
                    measureChildBeforeLayout(child, i, widthMeasureSpec, 0, heightMeasureSpec, totalWeight == 0.0f ? this.mTotalLength : 0);
                    if (oldHeight != Integer.MIN_VALUE) {
                        lp.height = oldHeight;
                    }
                    int childHeight = child.getMeasuredHeight();
                    int totalLength2 = this.mTotalLength;
                    this.mTotalLength = Math.max(totalLength2, totalLength2 + childHeight + lp.topMargin + lp.bottomMargin + getNextLocationOffset(child));
                    if (useLargestChild) {
                        largestChildHeight = Math.max(childHeight, largestChildHeight);
                    }
                }
                if (baselineChildIndex >= 0 && baselineChildIndex == i + 1) {
                    this.mBaselineChildTop = this.mTotalLength;
                }
                if (i < baselineChildIndex && lp.weight > 0.0f) {
                    throw new RuntimeException("A child of LinearLayout with index less than mBaselineAlignedChildIndex has weight > 0, which won't work.  Either remove the weight, or don't set mBaselineAlignedChildIndex.");
                }
                boolean matchWidthLocally = false;
                if (widthMode != 1073741824 && lp.width == -1) {
                    matchWidth = true;
                    matchWidthLocally = true;
                }
                int margin = lp.leftMargin + lp.rightMargin;
                int measuredWidth = child.getMeasuredWidth() + margin;
                maxWidth = Math.max(maxWidth, measuredWidth);
                childState = ViewUtils.combineMeasuredStates(childState, ViewCompat.getMeasuredState(child));
                allFillParent = allFillParent && lp.width == -1;
                if (lp.weight > 0.0f) {
                    if (!matchWidthLocally) {
                        margin = measuredWidth;
                    }
                    weightedMaxWidth = Math.max(weightedMaxWidth, margin);
                } else {
                    if (!matchWidthLocally) {
                        margin = measuredWidth;
                    }
                    alternativeMaxWidth = Math.max(alternativeMaxWidth, margin);
                }
                i += getChildrenSkipCount(child, i);
            }
            i++;
        }
        if (this.mTotalLength > 0 && hasDividerBeforeChildAt(count)) {
            this.mTotalLength += this.mDividerHeight;
        }
        if (useLargestChild && (heightMode == Integer.MIN_VALUE || heightMode == 0)) {
            this.mTotalLength = 0;
            int i2 = 0;
            while (i2 < count) {
                View child2 = getVirtualChildAt(i2);
                if (child2 == null) {
                    this.mTotalLength += measureNullChild(i2);
                } else if (child2.getVisibility() == 8) {
                    i2 += getChildrenSkipCount(child2, i2);
                } else {
                    LayoutParams lp2 = (LayoutParams) child2.getLayoutParams();
                    int totalLength3 = this.mTotalLength;
                    this.mTotalLength = Math.max(totalLength3, totalLength3 + largestChildHeight + lp2.topMargin + lp2.bottomMargin + getNextLocationOffset(child2));
                }
                i2++;
            }
        }
        this.mTotalLength += getPaddingTop() + getPaddingBottom();
        int heightSize = this.mTotalLength;
        int heightSizeAndState = ViewCompat.resolveSizeAndState(Math.max(heightSize, getSuggestedMinimumHeight()), heightMeasureSpec, 0);
        int heightSize2 = heightSizeAndState & ViewCompat.MEASURED_SIZE_MASK;
        int delta = heightSize2 - this.mTotalLength;
        if (skippedMeasure || (delta != 0 && totalWeight > 0.0f)) {
            float weightSum = this.mWeightSum > 0.0f ? this.mWeightSum : totalWeight;
            this.mTotalLength = 0;
            for (int i3 = 0; i3 < count; i3++) {
                View child3 = getVirtualChildAt(i3);
                if (child3.getVisibility() != 8) {
                    LayoutParams lp3 = (LayoutParams) child3.getLayoutParams();
                    float childExtra = lp3.weight;
                    if (childExtra > 0.0f) {
                        int share = (int) ((delta * childExtra) / weightSum);
                        weightSum -= childExtra;
                        delta -= share;
                        int childWidthMeasureSpec = getChildMeasureSpec(widthMeasureSpec, getPaddingLeft() + getPaddingRight() + lp3.leftMargin + lp3.rightMargin, lp3.width);
                        if (lp3.height != 0 || heightMode != 1073741824) {
                            int childHeight2 = child3.getMeasuredHeight() + share;
                            if (childHeight2 < 0) {
                                childHeight2 = 0;
                            }
                            child3.measure(childWidthMeasureSpec, View.MeasureSpec.makeMeasureSpec(childHeight2, 1073741824));
                        } else {
                            if (share <= 0) {
                                share = 0;
                            }
                            child3.measure(childWidthMeasureSpec, View.MeasureSpec.makeMeasureSpec(share, 1073741824));
                        }
                        childState = ViewUtils.combineMeasuredStates(childState, ViewCompat.getMeasuredState(child3) & (-256));
                    }
                    int margin2 = lp3.leftMargin + lp3.rightMargin;
                    int measuredWidth2 = child3.getMeasuredWidth() + margin2;
                    maxWidth = Math.max(maxWidth, measuredWidth2);
                    if (!(widthMode != 1073741824 && lp3.width == -1)) {
                        margin2 = measuredWidth2;
                    }
                    alternativeMaxWidth = Math.max(alternativeMaxWidth, margin2);
                    allFillParent = allFillParent && lp3.width == -1;
                    int totalLength4 = this.mTotalLength;
                    this.mTotalLength = Math.max(totalLength4, child3.getMeasuredHeight() + totalLength4 + lp3.topMargin + lp3.bottomMargin + getNextLocationOffset(child3));
                }
            }
            this.mTotalLength += getPaddingTop() + getPaddingBottom();
        } else {
            alternativeMaxWidth = Math.max(alternativeMaxWidth, weightedMaxWidth);
            if (useLargestChild && heightMode != 1073741824) {
                for (int i4 = 0; i4 < count; i4++) {
                    View child4 = getVirtualChildAt(i4);
                    if (child4 != null && child4.getVisibility() != 8 && ((LayoutParams) child4.getLayoutParams()).weight > 0.0f) {
                        child4.measure(View.MeasureSpec.makeMeasureSpec(child4.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(largestChildHeight, 1073741824));
                    }
                }
            }
        }
        if (!allFillParent && widthMode != 1073741824) {
            maxWidth = alternativeMaxWidth;
        }
        setMeasuredDimension(ViewCompat.resolveSizeAndState(Math.max(maxWidth + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), widthMeasureSpec, childState), heightSizeAndState);
        if (matchWidth) {
            forceUniformWidth(count, heightMeasureSpec);
        }
    }

    private void forceUniformWidth(int count, int heightMeasureSpec) {
        int uniformMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
        for (int i = 0; i < count; i++) {
            View child = getVirtualChildAt(i);
            if (child.getVisibility() != 8) {
                LayoutParams lp = (LayoutParams) child.getLayoutParams();
                if (lp.width == -1) {
                    int oldHeight = lp.height;
                    lp.height = child.getMeasuredHeight();
                    measureChildWithMargins(child, uniformMeasureSpec, 0, heightMeasureSpec, 0);
                    lp.height = oldHeight;
                }
            }
        }
    }

    void measureHorizontal(int widthMeasureSpec, int heightMeasureSpec) {
        int childBaseline;
        int childBaseline2;
        this.mTotalLength = 0;
        int maxHeight = 0;
        int childState = 0;
        int alternativeMaxHeight = 0;
        int weightedMaxHeight = 0;
        boolean allFillParent = true;
        float totalWeight = 0.0f;
        int count = getVirtualChildCount();
        int widthMode = View.MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = View.MeasureSpec.getMode(heightMeasureSpec);
        boolean matchHeight = false;
        boolean skippedMeasure = false;
        if (this.mMaxAscent == null || this.mMaxDescent == null) {
            this.mMaxAscent = new int[4];
            this.mMaxDescent = new int[4];
        }
        int[] maxAscent = this.mMaxAscent;
        int[] maxDescent = this.mMaxDescent;
        maxAscent[3] = -1;
        maxAscent[2] = -1;
        maxAscent[1] = -1;
        maxAscent[0] = -1;
        maxDescent[3] = -1;
        maxDescent[2] = -1;
        maxDescent[1] = -1;
        maxDescent[0] = -1;
        boolean baselineAligned = this.mBaselineAligned;
        boolean useLargestChild = this.mUseLargestChild;
        boolean isExactly = widthMode == 1073741824;
        int largestChildWidth = Integer.MIN_VALUE;
        int i = 0;
        while (i < count) {
            View child = getVirtualChildAt(i);
            if (child == null) {
                this.mTotalLength += measureNullChild(i);
            } else if (child.getVisibility() == 8) {
                i += getChildrenSkipCount(child, i);
            } else {
                if (hasDividerBeforeChildAt(i)) {
                    this.mTotalLength += this.mDividerWidth;
                }
                LayoutParams lp = (LayoutParams) child.getLayoutParams();
                totalWeight += lp.weight;
                if (widthMode == 1073741824 && lp.width == 0 && lp.weight > 0.0f) {
                    if (isExactly) {
                        this.mTotalLength += lp.leftMargin + lp.rightMargin;
                    } else {
                        int totalLength = this.mTotalLength;
                        this.mTotalLength = Math.max(totalLength, lp.leftMargin + totalLength + lp.rightMargin);
                    }
                    if (baselineAligned) {
                        int freeSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                        child.measure(freeSpec, freeSpec);
                    } else {
                        skippedMeasure = true;
                    }
                } else {
                    int oldWidth = Integer.MIN_VALUE;
                    if (lp.width == 0 && lp.weight > 0.0f) {
                        oldWidth = 0;
                        lp.width = -2;
                    }
                    measureChildBeforeLayout(child, i, widthMeasureSpec, totalWeight == 0.0f ? this.mTotalLength : 0, heightMeasureSpec, 0);
                    if (oldWidth != Integer.MIN_VALUE) {
                        lp.width = oldWidth;
                    }
                    int childWidth = child.getMeasuredWidth();
                    if (isExactly) {
                        this.mTotalLength += lp.leftMargin + childWidth + lp.rightMargin + getNextLocationOffset(child);
                    } else {
                        int totalLength2 = this.mTotalLength;
                        this.mTotalLength = Math.max(totalLength2, totalLength2 + childWidth + lp.leftMargin + lp.rightMargin + getNextLocationOffset(child));
                    }
                    if (useLargestChild) {
                        largestChildWidth = Math.max(childWidth, largestChildWidth);
                    }
                }
                boolean matchHeightLocally = false;
                if (heightMode != 1073741824 && lp.height == -1) {
                    matchHeight = true;
                    matchHeightLocally = true;
                }
                int margin = lp.topMargin + lp.bottomMargin;
                int childHeight = child.getMeasuredHeight() + margin;
                childState = ViewUtils.combineMeasuredStates(childState, ViewCompat.getMeasuredState(child));
                if (baselineAligned && (childBaseline2 = child.getBaseline()) != -1) {
                    int gravity = (lp.gravity < 0 ? this.mGravity : lp.gravity) & 112;
                    int index = ((gravity >> 4) & (-2)) >> 1;
                    maxAscent[index] = Math.max(maxAscent[index], childBaseline2);
                    maxDescent[index] = Math.max(maxDescent[index], childHeight - childBaseline2);
                }
                maxHeight = Math.max(maxHeight, childHeight);
                allFillParent = allFillParent && lp.height == -1;
                if (lp.weight > 0.0f) {
                    if (!matchHeightLocally) {
                        margin = childHeight;
                    }
                    weightedMaxHeight = Math.max(weightedMaxHeight, margin);
                } else {
                    if (!matchHeightLocally) {
                        margin = childHeight;
                    }
                    alternativeMaxHeight = Math.max(alternativeMaxHeight, margin);
                }
                i += getChildrenSkipCount(child, i);
            }
            i++;
        }
        if (this.mTotalLength > 0 && hasDividerBeforeChildAt(count)) {
            this.mTotalLength += this.mDividerWidth;
        }
        if (maxAscent[1] != -1 || maxAscent[0] != -1 || maxAscent[2] != -1 || maxAscent[3] != -1) {
            int ascent = Math.max(maxAscent[3], Math.max(maxAscent[0], Math.max(maxAscent[1], maxAscent[2])));
            int descent = Math.max(maxDescent[3], Math.max(maxDescent[0], Math.max(maxDescent[1], maxDescent[2])));
            maxHeight = Math.max(maxHeight, ascent + descent);
        }
        if (useLargestChild && (widthMode == Integer.MIN_VALUE || widthMode == 0)) {
            this.mTotalLength = 0;
            int i2 = 0;
            while (i2 < count) {
                View child2 = getVirtualChildAt(i2);
                if (child2 == null) {
                    this.mTotalLength += measureNullChild(i2);
                } else if (child2.getVisibility() == 8) {
                    i2 += getChildrenSkipCount(child2, i2);
                } else {
                    LayoutParams lp2 = (LayoutParams) child2.getLayoutParams();
                    if (isExactly) {
                        this.mTotalLength += lp2.leftMargin + largestChildWidth + lp2.rightMargin + getNextLocationOffset(child2);
                    } else {
                        int totalLength3 = this.mTotalLength;
                        this.mTotalLength = Math.max(totalLength3, totalLength3 + largestChildWidth + lp2.leftMargin + lp2.rightMargin + getNextLocationOffset(child2));
                    }
                }
                i2++;
            }
        }
        this.mTotalLength += getPaddingLeft() + getPaddingRight();
        int widthSize = this.mTotalLength;
        int widthSizeAndState = ViewCompat.resolveSizeAndState(Math.max(widthSize, getSuggestedMinimumWidth()), widthMeasureSpec, 0);
        int widthSize2 = widthSizeAndState & ViewCompat.MEASURED_SIZE_MASK;
        int delta = widthSize2 - this.mTotalLength;
        if (skippedMeasure || (delta != 0 && totalWeight > 0.0f)) {
            float weightSum = this.mWeightSum > 0.0f ? this.mWeightSum : totalWeight;
            maxAscent[3] = -1;
            maxAscent[2] = -1;
            maxAscent[1] = -1;
            maxAscent[0] = -1;
            maxDescent[3] = -1;
            maxDescent[2] = -1;
            maxDescent[1] = -1;
            maxDescent[0] = -1;
            maxHeight = -1;
            this.mTotalLength = 0;
            for (int i3 = 0; i3 < count; i3++) {
                View child3 = getVirtualChildAt(i3);
                if (child3 != null && child3.getVisibility() != 8) {
                    LayoutParams lp3 = (LayoutParams) child3.getLayoutParams();
                    float childExtra = lp3.weight;
                    if (childExtra > 0.0f) {
                        int share = (int) ((delta * childExtra) / weightSum);
                        weightSum -= childExtra;
                        delta -= share;
                        int childHeightMeasureSpec = getChildMeasureSpec(heightMeasureSpec, getPaddingTop() + getPaddingBottom() + lp3.topMargin + lp3.bottomMargin, lp3.height);
                        if (lp3.width != 0 || widthMode != 1073741824) {
                            int childWidth2 = child3.getMeasuredWidth() + share;
                            if (childWidth2 < 0) {
                                childWidth2 = 0;
                            }
                            child3.measure(View.MeasureSpec.makeMeasureSpec(childWidth2, 1073741824), childHeightMeasureSpec);
                        } else {
                            if (share <= 0) {
                                share = 0;
                            }
                            child3.measure(View.MeasureSpec.makeMeasureSpec(share, 1073741824), childHeightMeasureSpec);
                        }
                        childState = ViewUtils.combineMeasuredStates(childState, ViewCompat.getMeasuredState(child3) & ViewCompat.MEASURED_STATE_MASK);
                    }
                    if (isExactly) {
                        this.mTotalLength += child3.getMeasuredWidth() + lp3.leftMargin + lp3.rightMargin + getNextLocationOffset(child3);
                    } else {
                        int totalLength4 = this.mTotalLength;
                        this.mTotalLength = Math.max(totalLength4, child3.getMeasuredWidth() + totalLength4 + lp3.leftMargin + lp3.rightMargin + getNextLocationOffset(child3));
                    }
                    boolean matchHeightLocally2 = heightMode != 1073741824 && lp3.height == -1;
                    int margin2 = lp3.topMargin + lp3.bottomMargin;
                    int childHeight2 = child3.getMeasuredHeight() + margin2;
                    maxHeight = Math.max(maxHeight, childHeight2);
                    if (!matchHeightLocally2) {
                        margin2 = childHeight2;
                    }
                    alternativeMaxHeight = Math.max(alternativeMaxHeight, margin2);
                    allFillParent = allFillParent && lp3.height == -1;
                    if (baselineAligned && (childBaseline = child3.getBaseline()) != -1) {
                        int gravity2 = (lp3.gravity < 0 ? this.mGravity : lp3.gravity) & 112;
                        int index2 = ((gravity2 >> 4) & (-2)) >> 1;
                        maxAscent[index2] = Math.max(maxAscent[index2], childBaseline);
                        maxDescent[index2] = Math.max(maxDescent[index2], childHeight2 - childBaseline);
                    }
                }
            }
            this.mTotalLength += getPaddingLeft() + getPaddingRight();
            if (maxAscent[1] != -1 || maxAscent[0] != -1 || maxAscent[2] != -1 || maxAscent[3] != -1) {
                int ascent2 = Math.max(maxAscent[3], Math.max(maxAscent[0], Math.max(maxAscent[1], maxAscent[2])));
                int descent2 = Math.max(maxDescent[3], Math.max(maxDescent[0], Math.max(maxDescent[1], maxDescent[2])));
                maxHeight = Math.max(maxHeight, ascent2 + descent2);
            }
        } else {
            alternativeMaxHeight = Math.max(alternativeMaxHeight, weightedMaxHeight);
            if (useLargestChild && widthMode != 1073741824) {
                for (int i4 = 0; i4 < count; i4++) {
                    View child4 = getVirtualChildAt(i4);
                    if (child4 != null && child4.getVisibility() != 8 && ((LayoutParams) child4.getLayoutParams()).weight > 0.0f) {
                        child4.measure(View.MeasureSpec.makeMeasureSpec(largestChildWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(child4.getMeasuredHeight(), 1073741824));
                    }
                }
            }
        }
        if (!allFillParent && heightMode != 1073741824) {
            maxHeight = alternativeMaxHeight;
        }
        setMeasuredDimension(((-16777216) & childState) | widthSizeAndState, ViewCompat.resolveSizeAndState(Math.max(maxHeight + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), heightMeasureSpec, childState << 16));
        if (matchHeight) {
            forceUniformHeight(count, widthMeasureSpec);
        }
    }

    private void forceUniformHeight(int count, int widthMeasureSpec) {
        int uniformMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824);
        for (int i = 0; i < count; i++) {
            View child = getVirtualChildAt(i);
            if (child.getVisibility() != 8) {
                LayoutParams lp = (LayoutParams) child.getLayoutParams();
                if (lp.height == -1) {
                    int oldWidth = lp.width;
                    lp.width = child.getMeasuredWidth();
                    measureChildWithMargins(child, widthMeasureSpec, 0, uniformMeasureSpec, 0);
                    lp.width = oldWidth;
                }
            }
        }
    }

    int getChildrenSkipCount(View child, int index) {
        return 0;
    }

    int measureNullChild(int childIndex) {
        return 0;
    }

    void measureChildBeforeLayout(View child, int childIndex, int widthMeasureSpec, int totalWidth, int heightMeasureSpec, int totalHeight) {
        measureChildWithMargins(child, widthMeasureSpec, totalWidth, heightMeasureSpec, totalHeight);
    }

    int getLocationOffset(View child) {
        return 0;
    }

    int getNextLocationOffset(View child) {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean changed, int l, int t, int r, int b) {
        if (this.mOrientation == 1) {
            layoutVertical(l, t, r, b);
        } else {
            layoutHorizontal(l, t, r, b);
        }
    }

    void layoutVertical(int left, int top, int right, int bottom) {
        int childTop;
        int childLeft;
        int paddingLeft = getPaddingLeft();
        int width = right - left;
        int childRight = width - getPaddingRight();
        int childSpace = (width - paddingLeft) - getPaddingRight();
        int count = getVirtualChildCount();
        int majorGravity = this.mGravity & 112;
        int minorGravity = this.mGravity & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        switch (majorGravity) {
            case 16:
                childTop = getPaddingTop() + (((bottom - top) - this.mTotalLength) / 2);
                break;
            case 80:
                childTop = ((getPaddingTop() + bottom) - top) - this.mTotalLength;
                break;
            default:
                childTop = getPaddingTop();
                break;
        }
        int i = 0;
        while (i < count) {
            View child = getVirtualChildAt(i);
            if (child == null) {
                childTop += measureNullChild(i);
            } else if (child.getVisibility() != 8) {
                int childWidth = child.getMeasuredWidth();
                int childHeight = child.getMeasuredHeight();
                LayoutParams lp = (LayoutParams) child.getLayoutParams();
                int gravity = lp.gravity;
                if (gravity < 0) {
                    gravity = minorGravity;
                }
                int layoutDirection = ViewCompat.getLayoutDirection(this);
                int absoluteGravity = GravityCompat.getAbsoluteGravity(gravity, layoutDirection);
                switch (absoluteGravity & 7) {
                    case 1:
                        childLeft = ((((childSpace - childWidth) / 2) + paddingLeft) + lp.leftMargin) - lp.rightMargin;
                        break;
                    case 5:
                        childLeft = (childRight - childWidth) - lp.rightMargin;
                        break;
                    default:
                        childLeft = paddingLeft + lp.leftMargin;
                        break;
                }
                if (hasDividerBeforeChildAt(i)) {
                    childTop += this.mDividerHeight;
                }
                int childTop2 = childTop + lp.topMargin;
                setChildFrame(child, childLeft, childTop2 + getLocationOffset(child), childWidth, childHeight);
                childTop = childTop2 + lp.bottomMargin + childHeight + getNextLocationOffset(child);
                i += getChildrenSkipCount(child, i);
            }
            i++;
        }
    }

    void layoutHorizontal(int left, int top, int right, int bottom) {
        int childLeft;
        int childTop;
        boolean isLayoutRtl = ViewUtils.isLayoutRtl(this);
        int paddingTop = getPaddingTop();
        int height = bottom - top;
        int childBottom = height - getPaddingBottom();
        int childSpace = (height - paddingTop) - getPaddingBottom();
        int count = getVirtualChildCount();
        int majorGravity = this.mGravity & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        int minorGravity = this.mGravity & 112;
        boolean baselineAligned = this.mBaselineAligned;
        int[] maxAscent = this.mMaxAscent;
        int[] maxDescent = this.mMaxDescent;
        int layoutDirection = ViewCompat.getLayoutDirection(this);
        switch (GravityCompat.getAbsoluteGravity(majorGravity, layoutDirection)) {
            case 1:
                childLeft = getPaddingLeft() + (((right - left) - this.mTotalLength) / 2);
                break;
            case 5:
                childLeft = ((getPaddingLeft() + right) - left) - this.mTotalLength;
                break;
            default:
                childLeft = getPaddingLeft();
                break;
        }
        int start = 0;
        int dir = 1;
        if (isLayoutRtl) {
            start = count - 1;
            dir = -1;
        }
        int i = 0;
        while (i < count) {
            int childIndex = start + (dir * i);
            View child = getVirtualChildAt(childIndex);
            if (child == null) {
                childLeft += measureNullChild(childIndex);
            } else if (child.getVisibility() != 8) {
                int childWidth = child.getMeasuredWidth();
                int childHeight = child.getMeasuredHeight();
                int childBaseline = -1;
                LayoutParams lp = (LayoutParams) child.getLayoutParams();
                if (baselineAligned && lp.height != -1) {
                    childBaseline = child.getBaseline();
                }
                int gravity = lp.gravity;
                if (gravity < 0) {
                    gravity = minorGravity;
                }
                switch (gravity & 112) {
                    case 16:
                        childTop = ((((childSpace - childHeight) / 2) + paddingTop) + lp.topMargin) - lp.bottomMargin;
                        break;
                    case 48:
                        childTop = paddingTop + lp.topMargin;
                        if (childBaseline != -1) {
                            childTop += maxAscent[1] - childBaseline;
                            break;
                        }
                        break;
                    case 80:
                        childTop = (childBottom - childHeight) - lp.bottomMargin;
                        if (childBaseline != -1) {
                            int descent = child.getMeasuredHeight() - childBaseline;
                            childTop -= maxDescent[2] - descent;
                            break;
                        }
                        break;
                    default:
                        childTop = paddingTop;
                        break;
                }
                if (hasDividerBeforeChildAt(childIndex)) {
                    childLeft += this.mDividerWidth;
                }
                int childLeft2 = childLeft + lp.leftMargin;
                setChildFrame(child, childLeft2 + getLocationOffset(child), childTop, childWidth, childHeight);
                childLeft = childLeft2 + lp.rightMargin + childWidth + getNextLocationOffset(child);
                i += getChildrenSkipCount(child, childIndex);
            }
            i++;
        }
    }

    private void setChildFrame(View child, int left, int top, int width, int height) {
        child.layout(left, top, left + width, top + height);
    }

    public void setOrientation(int orientation) {
        if (this.mOrientation != orientation) {
            this.mOrientation = orientation;
            requestLayout();
        }
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public void setGravity(int gravity) {
        if (this.mGravity != gravity) {
            if ((8388615 & gravity) == 0) {
                gravity |= 8388611;
            }
            if ((gravity & 112) == 0) {
                gravity |= 48;
            }
            this.mGravity = gravity;
            requestLayout();
        }
    }

    public void setHorizontalGravity(int horizontalGravity) {
        int gravity = horizontalGravity & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        if ((this.mGravity & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK) != gravity) {
            this.mGravity = (this.mGravity & (-8388616)) | gravity;
            requestLayout();
        }
    }

    public void setVerticalGravity(int verticalGravity) {
        int gravity = verticalGravity & 112;
        if ((this.mGravity & 112) != gravity) {
            this.mGravity = (this.mGravity & (-113)) | gravity;
            requestLayout();
        }
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new LayoutParams(getContext(), attrs);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public LayoutParams generateDefaultLayoutParams() {
        if (this.mOrientation == 0) {
            return new LayoutParams(-2, -2);
        }
        if (this.mOrientation == 1) {
            return new LayoutParams(-1, -2);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams p) {
        return new LayoutParams(p);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams p) {
        return p instanceof LayoutParams;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent event) {
        if (Build.VERSION.SDK_INT >= 14) {
            super.onInitializeAccessibilityEvent(event);
            event.setClassName(LinearLayoutCompat.class.getName());
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
        if (Build.VERSION.SDK_INT >= 14) {
            super.onInitializeAccessibilityNodeInfo(info);
            info.setClassName(LinearLayoutCompat.class.getName());
        }
    }

    /* loaded from: classes.dex */
    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public int gravity;
        public float weight;

        public LayoutParams(Context c, AttributeSet attrs) {
            super(c, attrs);
            this.gravity = -1;
            TypedArray a = c.obtainStyledAttributes(attrs, R.styleable.LinearLayoutCompat_Layout);
            this.weight = a.getFloat(R.styleable.LinearLayoutCompat_Layout_android_layout_weight, 0.0f);
            this.gravity = a.getInt(R.styleable.LinearLayoutCompat_Layout_android_layout_gravity, -1);
            a.recycle();
        }

        public LayoutParams(int width, int height) {
            super(width, height);
            this.gravity = -1;
            this.weight = 0.0f;
        }

        public LayoutParams(int width, int height, float weight) {
            super(width, height);
            this.gravity = -1;
            this.weight = weight;
        }

        public LayoutParams(ViewGroup.LayoutParams p) {
            super(p);
            this.gravity = -1;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams source) {
            super(source);
            this.gravity = -1;
        }

        public LayoutParams(LayoutParams source) {
            super((ViewGroup.MarginLayoutParams) source);
            this.gravity = -1;
            this.weight = source.weight;
            this.gravity = source.gravity;
        }
    }
}