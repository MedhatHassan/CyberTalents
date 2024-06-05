package android.support.v7.internal.widget;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.view.ViewCompat;
import android.support.v7.internal.widget.AdapterViewCompat;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SpinnerAdapter;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class AbsSpinnerCompat extends AdapterViewCompat<SpinnerAdapter> {
    SpinnerAdapter mAdapter;
    private DataSetObserver mDataSetObserver;
    int mHeightMeasureSpec;
    final RecycleBin mRecycler;
    int mSelectionBottomPadding;
    int mSelectionLeftPadding;
    int mSelectionRightPadding;
    int mSelectionTopPadding;
    final Rect mSpinnerPadding;
    private Rect mTouchFrame;
    int mWidthMeasureSpec;

    abstract void layout(int i, boolean z);

    AbsSpinnerCompat(Context context) {
        super(context);
        this.mSelectionLeftPadding = 0;
        this.mSelectionTopPadding = 0;
        this.mSelectionRightPadding = 0;
        this.mSelectionBottomPadding = 0;
        this.mSpinnerPadding = new Rect();
        this.mRecycler = new RecycleBin();
        initAbsSpinner();
    }

    AbsSpinnerCompat(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbsSpinnerCompat(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.mSelectionLeftPadding = 0;
        this.mSelectionTopPadding = 0;
        this.mSelectionRightPadding = 0;
        this.mSelectionBottomPadding = 0;
        this.mSpinnerPadding = new Rect();
        this.mRecycler = new RecycleBin();
        initAbsSpinner();
    }

    private void initAbsSpinner() {
        setFocusable(true);
        setWillNotDraw(false);
    }

    @Override // android.support.v7.internal.widget.AdapterViewCompat
    public void setAdapter(SpinnerAdapter adapter) {
        if (this.mAdapter != null) {
            this.mAdapter.unregisterDataSetObserver(this.mDataSetObserver);
            resetList();
        }
        this.mAdapter = adapter;
        this.mOldSelectedPosition = -1;
        this.mOldSelectedRowId = Long.MIN_VALUE;
        if (this.mAdapter != null) {
            this.mOldItemCount = this.mItemCount;
            this.mItemCount = this.mAdapter.getCount();
            checkFocus();
            this.mDataSetObserver = new AdapterViewCompat.AdapterDataSetObserver();
            this.mAdapter.registerDataSetObserver(this.mDataSetObserver);
            int position = this.mItemCount > 0 ? 0 : -1;
            setSelectedPositionInt(position);
            setNextSelectedPositionInt(position);
            if (this.mItemCount == 0) {
                checkSelectionChanged();
            }
        } else {
            checkFocus();
            resetList();
            checkSelectionChanged();
        }
        requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void resetList() {
        this.mDataChanged = false;
        this.mNeedSync = false;
        removeAllViewsInLayout();
        this.mOldSelectedPosition = -1;
        this.mOldSelectedRowId = Long.MIN_VALUE;
        setSelectedPositionInt(-1);
        setNextSelectedPositionInt(-1);
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthMode = View.MeasureSpec.getMode(widthMeasureSpec);
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        Rect rect = this.mSpinnerPadding;
        if (paddingLeft <= this.mSelectionLeftPadding) {
            paddingLeft = this.mSelectionLeftPadding;
        }
        rect.left = paddingLeft;
        Rect rect2 = this.mSpinnerPadding;
        if (paddingTop <= this.mSelectionTopPadding) {
            paddingTop = this.mSelectionTopPadding;
        }
        rect2.top = paddingTop;
        Rect rect3 = this.mSpinnerPadding;
        if (paddingRight <= this.mSelectionRightPadding) {
            paddingRight = this.mSelectionRightPadding;
        }
        rect3.right = paddingRight;
        Rect rect4 = this.mSpinnerPadding;
        if (paddingBottom <= this.mSelectionBottomPadding) {
            paddingBottom = this.mSelectionBottomPadding;
        }
        rect4.bottom = paddingBottom;
        if (this.mDataChanged) {
            handleDataChanged();
        }
        int preferredHeight = 0;
        int preferredWidth = 0;
        boolean needsMeasuring = true;
        int selectedPosition = getSelectedItemPosition();
        if (selectedPosition >= 0 && this.mAdapter != null && selectedPosition < this.mAdapter.getCount()) {
            View view = this.mRecycler.get(selectedPosition);
            if (view == null) {
                view = this.mAdapter.getView(selectedPosition, null, this);
            }
            if (view != null) {
                this.mRecycler.put(selectedPosition, view);
                if (view.getLayoutParams() == null) {
                    this.mBlockLayoutRequests = true;
                    view.setLayoutParams(generateDefaultLayoutParams());
                    this.mBlockLayoutRequests = false;
                }
                measureChild(view, widthMeasureSpec, heightMeasureSpec);
                preferredHeight = getChildHeight(view) + this.mSpinnerPadding.top + this.mSpinnerPadding.bottom;
                preferredWidth = getChildWidth(view) + this.mSpinnerPadding.left + this.mSpinnerPadding.right;
                needsMeasuring = false;
            }
        }
        if (needsMeasuring) {
            preferredHeight = this.mSpinnerPadding.top + this.mSpinnerPadding.bottom;
            if (widthMode == 0) {
                preferredWidth = this.mSpinnerPadding.left + this.mSpinnerPadding.right;
            }
        }
        int preferredHeight2 = Math.max(preferredHeight, getSuggestedMinimumHeight());
        int preferredWidth2 = Math.max(preferredWidth, getSuggestedMinimumWidth());
        int heightSize = ViewCompat.resolveSizeAndState(preferredHeight2, heightMeasureSpec, 0);
        int widthSize = ViewCompat.resolveSizeAndState(preferredWidth2, widthMeasureSpec, 0);
        setMeasuredDimension(widthSize, heightSize);
        this.mHeightMeasureSpec = heightMeasureSpec;
        this.mWidthMeasureSpec = widthMeasureSpec;
    }

    int getChildHeight(View child) {
        return child.getMeasuredHeight();
    }

    int getChildWidth(View child) {
        return child.getMeasuredWidth();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.LayoutParams(-1, -2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void recycleAllViews() {
        int childCount = getChildCount();
        RecycleBin recycleBin = this.mRecycler;
        int position = this.mFirstPosition;
        for (int i = 0; i < childCount; i++) {
            View v = getChildAt(i);
            int index = position + i;
            recycleBin.put(index, v);
        }
    }

    public void setSelection(int position, boolean animate) {
        boolean shouldAnimate = animate && this.mFirstPosition <= position && position <= (this.mFirstPosition + getChildCount()) + (-1);
        setSelectionInt(position, shouldAnimate);
    }

    @Override // android.support.v7.internal.widget.AdapterViewCompat
    public void setSelection(int position) {
        setNextSelectedPositionInt(position);
        requestLayout();
        invalidate();
    }

    void setSelectionInt(int position, boolean animate) {
        if (position != this.mOldSelectedPosition) {
            this.mBlockLayoutRequests = true;
            int delta = position - this.mSelectedPosition;
            setNextSelectedPositionInt(position);
            layout(delta, animate);
            this.mBlockLayoutRequests = false;
        }
    }

    @Override // android.support.v7.internal.widget.AdapterViewCompat
    public View getSelectedView() {
        if (this.mItemCount <= 0 || this.mSelectedPosition < 0) {
            return null;
        }
        return getChildAt(this.mSelectedPosition - this.mFirstPosition);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (!this.mBlockLayoutRequests) {
            super.requestLayout();
        }
    }

    @Override // android.support.v7.internal.widget.AdapterViewCompat
    public SpinnerAdapter getAdapter() {
        return this.mAdapter;
    }

    @Override // android.support.v7.internal.widget.AdapterViewCompat
    public int getCount() {
        return this.mItemCount;
    }

    public int pointToPosition(int x, int y) {
        Rect frame = this.mTouchFrame;
        if (frame == null) {
            this.mTouchFrame = new Rect();
            frame = this.mTouchFrame;
        }
        int count = getChildCount();
        for (int i = count - 1; i >= 0; i--) {
            View child = getChildAt(i);
            if (child.getVisibility() == 0) {
                child.getHitRect(frame);
                if (frame.contains(x, y)) {
                    return this.mFirstPosition + i;
                }
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: android.support.v7.internal.widget.AbsSpinnerCompat.SavedState.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel in) {
                return new SavedState(in);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int size) {
                return new SavedState[size];
            }
        };
        int position;
        long selectedId;

        /* JADX INFO: Access modifiers changed from: package-private */
        public SavedState(Parcelable superState) {
            super(superState);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public SavedState(Parcel in) {
            super(in);
            this.selectedId = in.readLong();
            this.position = in.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel out, int flags) {
            super.writeToParcel(out, flags);
            out.writeLong(this.selectedId);
            out.writeInt(this.position);
        }

        public String toString() {
            return "AbsSpinner.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " selectedId=" + this.selectedId + " position=" + this.position + "}";
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        Parcelable superState = super.onSaveInstanceState();
        SavedState ss = new SavedState(superState);
        ss.selectedId = getSelectedItemId();
        if (ss.selectedId >= 0) {
            ss.position = getSelectedItemPosition();
        } else {
            ss.position = -1;
        }
        return ss;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable state) {
        SavedState ss = (SavedState) state;
        super.onRestoreInstanceState(ss.getSuperState());
        if (ss.selectedId >= 0) {
            this.mDataChanged = true;
            this.mNeedSync = true;
            this.mSyncRowId = ss.selectedId;
            this.mSyncPosition = ss.position;
            this.mSyncMode = 0;
            requestLayout();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class RecycleBin {
        private final SparseArray<View> mScrapHeap = new SparseArray<>();

        RecycleBin() {
        }

        public void put(int position, View v) {
            this.mScrapHeap.put(position, v);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public View get(int position) {
            View result = this.mScrapHeap.get(position);
            if (result != null) {
                this.mScrapHeap.delete(position);
            }
            return result;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void clear() {
            SparseArray<View> scrapHeap = this.mScrapHeap;
            int count = scrapHeap.size();
            for (int i = 0; i < count; i++) {
                View view = scrapHeap.valueAt(i);
                if (view != null) {
                    AbsSpinnerCompat.this.removeDetachedView(view, true);
                }
            }
            scrapHeap.clear();
        }
    }
}