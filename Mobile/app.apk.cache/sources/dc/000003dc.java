package android.support.v7.internal.widget;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.R;
import android.support.v7.internal.widget.AbsSpinnerCompat;
import android.support.v7.internal.widget.AdapterViewCompat;
import android.support.v7.widget.ListPopupWindow;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.SpinnerAdapter;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class SpinnerCompat extends AbsSpinnerCompat implements DialogInterface.OnClickListener {
    private static final int MAX_ITEMS_MEASURED = 15;
    public static final int MODE_DIALOG = 0;
    public static final int MODE_DROPDOWN = 1;
    private static final int MODE_THEME = -1;
    private static final String TAG = "Spinner";
    private boolean mDisableChildrenWhenDisabled;
    int mDropDownWidth;
    private ListPopupWindow.ForwardingListener mForwardingListener;
    private int mGravity;
    private SpinnerPopup mPopup;
    private DropDownAdapter mTempAdapter;
    private Rect mTempRect;
    private final TintManager mTintManager;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public interface SpinnerPopup {
        void dismiss();

        Drawable getBackground();

        CharSequence getHintText();

        int getHorizontalOffset();

        int getVerticalOffset();

        boolean isShowing();

        void setAdapter(ListAdapter listAdapter);

        void setBackgroundDrawable(Drawable drawable);

        void setHorizontalOffset(int i);

        void setPromptText(CharSequence charSequence);

        void setVerticalOffset(int i);

        void show();
    }

    SpinnerCompat(Context context) {
        this(context, (AttributeSet) null);
    }

    SpinnerCompat(Context context, int mode) {
        this(context, null, R.attr.spinnerStyle, mode);
    }

    SpinnerCompat(Context context, AttributeSet attrs) {
        this(context, attrs, R.attr.spinnerStyle);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SpinnerCompat(Context context, AttributeSet attrs, int defStyle) {
        this(context, attrs, defStyle, -1);
    }

    SpinnerCompat(Context context, AttributeSet attrs, int defStyle, int mode) {
        super(context, attrs, defStyle);
        this.mTempRect = new Rect();
        TintTypedArray a = TintTypedArray.obtainStyledAttributes(context, attrs, R.styleable.Spinner, defStyle, 0);
        setBackgroundDrawable(a.getDrawable(R.styleable.Spinner_android_background));
        switch (mode == -1 ? a.getInt(R.styleable.Spinner_spinnerMode, 0) : mode) {
            case 0:
                this.mPopup = new DialogPopup();
                break;
            case 1:
                final DropdownPopup popup = new DropdownPopup(context, attrs, defStyle);
                this.mDropDownWidth = a.getLayoutDimension(R.styleable.Spinner_android_dropDownWidth, -2);
                popup.setBackgroundDrawable(a.getDrawable(R.styleable.Spinner_android_popupBackground));
                this.mPopup = popup;
                this.mForwardingListener = new ListPopupWindow.ForwardingListener(this) { // from class: android.support.v7.internal.widget.SpinnerCompat.1
                    @Override // android.support.v7.widget.ListPopupWindow.ForwardingListener
                    public ListPopupWindow getPopup() {
                        return popup;
                    }

                    @Override // android.support.v7.widget.ListPopupWindow.ForwardingListener
                    public boolean onForwardingStarted() {
                        if (!SpinnerCompat.this.mPopup.isShowing()) {
                            SpinnerCompat.this.mPopup.show();
                            return true;
                        }
                        return true;
                    }
                };
                break;
        }
        this.mGravity = a.getInt(R.styleable.Spinner_android_gravity, 17);
        this.mPopup.setPromptText(a.getString(R.styleable.Spinner_prompt));
        this.mDisableChildrenWhenDisabled = a.getBoolean(R.styleable.Spinner_disableChildrenWhenDisabled, false);
        a.recycle();
        if (this.mTempAdapter != null) {
            this.mPopup.setAdapter(this.mTempAdapter);
            this.mTempAdapter = null;
        }
        this.mTintManager = a.getTintManager();
    }

    public void setPopupBackgroundDrawable(Drawable background) {
        if (!(this.mPopup instanceof DropdownPopup)) {
            Log.e(TAG, "setPopupBackgroundDrawable: incompatible spinner mode; ignoring...");
        } else {
            ((DropdownPopup) this.mPopup).setBackgroundDrawable(background);
        }
    }

    public void setPopupBackgroundResource(int resId) {
        setPopupBackgroundDrawable(this.mTintManager.getDrawable(resId));
    }

    public Drawable getPopupBackground() {
        return this.mPopup.getBackground();
    }

    public void setDropDownVerticalOffset(int pixels) {
        this.mPopup.setVerticalOffset(pixels);
    }

    public int getDropDownVerticalOffset() {
        return this.mPopup.getVerticalOffset();
    }

    public void setDropDownHorizontalOffset(int pixels) {
        this.mPopup.setHorizontalOffset(pixels);
    }

    public int getDropDownHorizontalOffset() {
        return this.mPopup.getHorizontalOffset();
    }

    public void setDropDownWidth(int pixels) {
        if (!(this.mPopup instanceof DropdownPopup)) {
            Log.e(TAG, "Cannot set dropdown width for MODE_DIALOG, ignoring");
        } else {
            this.mDropDownWidth = pixels;
        }
    }

    public int getDropDownWidth() {
        return this.mDropDownWidth;
    }

    @Override // android.view.View
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        if (this.mDisableChildrenWhenDisabled) {
            int count = getChildCount();
            for (int i = 0; i < count; i++) {
                getChildAt(i).setEnabled(enabled);
            }
        }
    }

    public void setGravity(int gravity) {
        if (this.mGravity != gravity) {
            if ((gravity & 7) == 0) {
                gravity |= 8388611;
            }
            this.mGravity = gravity;
            requestLayout();
        }
    }

    @Override // android.support.v7.internal.widget.AbsSpinnerCompat, android.support.v7.internal.widget.AdapterViewCompat
    public void setAdapter(SpinnerAdapter adapter) {
        super.setAdapter(adapter);
        this.mRecycler.clear();
        int targetSdkVersion = getContext().getApplicationInfo().targetSdkVersion;
        if (targetSdkVersion >= 21 && adapter != null && adapter.getViewTypeCount() != 1) {
            throw new IllegalArgumentException("Spinner adapter view type count must be 1");
        }
        if (this.mPopup != null) {
            this.mPopup.setAdapter(new DropDownAdapter(adapter));
        } else {
            this.mTempAdapter = new DropDownAdapter(adapter);
        }
    }

    @Override // android.view.View
    public int getBaseline() {
        int childBaseline;
        View child = null;
        if (getChildCount() > 0) {
            child = getChildAt(0);
        } else if (this.mAdapter != null && this.mAdapter.getCount() > 0) {
            child = makeView(0, false);
            this.mRecycler.put(0, child);
        }
        if (child == null || (childBaseline = child.getBaseline()) < 0) {
            return -1;
        }
        return child.getTop() + childBaseline;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v7.internal.widget.AdapterViewCompat, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.mPopup != null && this.mPopup.isShowing()) {
            this.mPopup.dismiss();
        }
    }

    @Override // android.support.v7.internal.widget.AdapterViewCompat
    public void setOnItemClickListener(AdapterViewCompat.OnItemClickListener l) {
        throw new RuntimeException("setOnItemClickListener cannot be used with a spinner.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setOnItemClickListenerInt(AdapterViewCompat.OnItemClickListener l) {
        super.setOnItemClickListener(l);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        if (this.mForwardingListener == null || !this.mForwardingListener.onTouch(this, event)) {
            return super.onTouchEvent(event);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v7.internal.widget.AbsSpinnerCompat, android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if (this.mPopup != null && View.MeasureSpec.getMode(widthMeasureSpec) == Integer.MIN_VALUE) {
            int measuredWidth = getMeasuredWidth();
            setMeasuredDimension(Math.min(Math.max(measuredWidth, measureContentWidth(getAdapter(), getBackground())), View.MeasureSpec.getSize(widthMeasureSpec)), getMeasuredHeight());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v7.internal.widget.AdapterViewCompat, android.view.ViewGroup, android.view.View
    public void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        this.mInLayout = true;
        layout(0, false);
        this.mInLayout = false;
    }

    @Override // android.support.v7.internal.widget.AbsSpinnerCompat
    void layout(int delta, boolean animate) {
        int childrenLeft = this.mSpinnerPadding.left;
        int childrenWidth = ((getRight() - getLeft()) - this.mSpinnerPadding.left) - this.mSpinnerPadding.right;
        if (this.mDataChanged) {
            handleDataChanged();
        }
        if (this.mItemCount == 0) {
            resetList();
            return;
        }
        if (this.mNextSelectedPosition >= 0) {
            setSelectedPositionInt(this.mNextSelectedPosition);
        }
        recycleAllViews();
        removeAllViewsInLayout();
        this.mFirstPosition = this.mSelectedPosition;
        if (this.mAdapter != null) {
            View sel = makeView(this.mSelectedPosition, true);
            int width = sel.getMeasuredWidth();
            int selectedOffset = childrenLeft;
            int layoutDirection = ViewCompat.getLayoutDirection(this);
            int absoluteGravity = GravityCompat.getAbsoluteGravity(this.mGravity, layoutDirection);
            switch (absoluteGravity & 7) {
                case 1:
                    selectedOffset = ((childrenWidth / 2) + childrenLeft) - (width / 2);
                    break;
                case 5:
                    selectedOffset = (childrenLeft + childrenWidth) - width;
                    break;
            }
            sel.offsetLeftAndRight(selectedOffset);
        }
        this.mRecycler.clear();
        invalidate();
        checkSelectionChanged();
        this.mDataChanged = false;
        this.mNeedSync = false;
        setNextSelectedPositionInt(this.mSelectedPosition);
    }

    private View makeView(int position, boolean addChild) {
        View child;
        if (!this.mDataChanged && (child = this.mRecycler.get(position)) != null) {
            setUpChild(child, addChild);
            return child;
        }
        View child2 = this.mAdapter.getView(position, null, this);
        setUpChild(child2, addChild);
        return child2;
    }

    private void setUpChild(View child, boolean addChild) {
        ViewGroup.LayoutParams lp = child.getLayoutParams();
        if (lp == null) {
            lp = generateDefaultLayoutParams();
        }
        if (addChild) {
            addViewInLayout(child, 0, lp);
        }
        child.setSelected(hasFocus());
        if (this.mDisableChildrenWhenDisabled) {
            child.setEnabled(isEnabled());
        }
        int childHeightSpec = ViewGroup.getChildMeasureSpec(this.mHeightMeasureSpec, this.mSpinnerPadding.top + this.mSpinnerPadding.bottom, lp.height);
        int childWidthSpec = ViewGroup.getChildMeasureSpec(this.mWidthMeasureSpec, this.mSpinnerPadding.left + this.mSpinnerPadding.right, lp.width);
        child.measure(childWidthSpec, childHeightSpec);
        int childTop = this.mSpinnerPadding.top + ((((getMeasuredHeight() - this.mSpinnerPadding.bottom) - this.mSpinnerPadding.top) - child.getMeasuredHeight()) / 2);
        int childBottom = childTop + child.getMeasuredHeight();
        int width = child.getMeasuredWidth();
        int childRight = 0 + width;
        child.layout(0, childTop, childRight, childBottom);
    }

    @Override // android.view.View
    public boolean performClick() {
        boolean handled = super.performClick();
        if (!handled) {
            handled = true;
            if (!this.mPopup.isShowing()) {
                this.mPopup.show();
            }
        }
        return handled;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialog, int which) {
        setSelection(which);
        dialog.dismiss();
    }

    public void setPrompt(CharSequence prompt) {
        this.mPopup.setPromptText(prompt);
    }

    public void setPromptId(int promptId) {
        setPrompt(getContext().getText(promptId));
    }

    public CharSequence getPrompt() {
        return this.mPopup.getHintText();
    }

    int measureContentWidth(SpinnerAdapter adapter, Drawable background) {
        if (adapter == null) {
            return 0;
        }
        int width = 0;
        View itemView = null;
        int itemType = 0;
        int widthMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int heightMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int start = Math.max(0, getSelectedItemPosition());
        int end = Math.min(adapter.getCount(), start + 15);
        int count = end - start;
        for (int i = Math.max(0, start - (15 - count)); i < end; i++) {
            int positionType = adapter.getItemViewType(i);
            if (positionType != itemType) {
                itemType = positionType;
                itemView = null;
            }
            itemView = adapter.getView(i, itemView, this);
            if (itemView.getLayoutParams() == null) {
                itemView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            }
            itemView.measure(widthMeasureSpec, heightMeasureSpec);
            width = Math.max(width, itemView.getMeasuredWidth());
        }
        if (background != null) {
            background.getPadding(this.mTempRect);
            return width + this.mTempRect.left + this.mTempRect.right;
        }
        return width;
    }

    @Override // android.support.v7.internal.widget.AbsSpinnerCompat, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState ss = new SavedState(super.onSaveInstanceState());
        ss.showDropdown = this.mPopup != null && this.mPopup.isShowing();
        return ss;
    }

    @Override // android.support.v7.internal.widget.AbsSpinnerCompat, android.view.View
    public void onRestoreInstanceState(Parcelable state) {
        ViewTreeObserver vto;
        SavedState ss = (SavedState) state;
        super.onRestoreInstanceState(ss.getSuperState());
        if (ss.showDropdown && (vto = getViewTreeObserver()) != null) {
            ViewTreeObserver.OnGlobalLayoutListener listener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: android.support.v7.internal.widget.SpinnerCompat.2
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    if (!SpinnerCompat.this.mPopup.isShowing()) {
                        SpinnerCompat.this.mPopup.show();
                    }
                    ViewTreeObserver vto2 = SpinnerCompat.this.getViewTreeObserver();
                    if (vto2 != null) {
                        vto2.removeGlobalOnLayoutListener(this);
                    }
                }
            };
            vto.addOnGlobalLayoutListener(listener);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class SavedState extends AbsSpinnerCompat.SavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: android.support.v7.internal.widget.SpinnerCompat.SavedState.1
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
        boolean showDropdown;

        SavedState(Parcelable superState) {
            super(superState);
        }

        private SavedState(Parcel in) {
            super(in);
            this.showDropdown = in.readByte() != 0;
        }

        @Override // android.support.v7.internal.widget.AbsSpinnerCompat.SavedState, android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel out, int flags) {
            super.writeToParcel(out, flags);
            out.writeByte((byte) (this.showDropdown ? 1 : 0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class DropDownAdapter implements ListAdapter, SpinnerAdapter {
        private SpinnerAdapter mAdapter;
        private ListAdapter mListAdapter;

        public DropDownAdapter(SpinnerAdapter adapter) {
            this.mAdapter = adapter;
            if (adapter instanceof ListAdapter) {
                this.mListAdapter = (ListAdapter) adapter;
            }
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.mAdapter == null) {
                return 0;
            }
            return this.mAdapter.getCount();
        }

        @Override // android.widget.Adapter
        public Object getItem(int position) {
            if (this.mAdapter == null) {
                return null;
            }
            return this.mAdapter.getItem(position);
        }

        @Override // android.widget.Adapter
        public long getItemId(int position) {
            if (this.mAdapter == null) {
                return -1L;
            }
            return this.mAdapter.getItemId(position);
        }

        @Override // android.widget.Adapter
        public View getView(int position, View convertView, ViewGroup parent) {
            return getDropDownView(position, convertView, parent);
        }

        @Override // android.widget.SpinnerAdapter
        public View getDropDownView(int position, View convertView, ViewGroup parent) {
            if (this.mAdapter == null) {
                return null;
            }
            return this.mAdapter.getDropDownView(position, convertView, parent);
        }

        @Override // android.widget.Adapter
        public boolean hasStableIds() {
            return this.mAdapter != null && this.mAdapter.hasStableIds();
        }

        @Override // android.widget.Adapter
        public void registerDataSetObserver(DataSetObserver observer) {
            if (this.mAdapter != null) {
                this.mAdapter.registerDataSetObserver(observer);
            }
        }

        @Override // android.widget.Adapter
        public void unregisterDataSetObserver(DataSetObserver observer) {
            if (this.mAdapter != null) {
                this.mAdapter.unregisterDataSetObserver(observer);
            }
        }

        @Override // android.widget.ListAdapter
        public boolean areAllItemsEnabled() {
            ListAdapter adapter = this.mListAdapter;
            if (adapter != null) {
                return adapter.areAllItemsEnabled();
            }
            return true;
        }

        @Override // android.widget.ListAdapter
        public boolean isEnabled(int position) {
            ListAdapter adapter = this.mListAdapter;
            if (adapter != null) {
                return adapter.isEnabled(position);
            }
            return true;
        }

        @Override // android.widget.Adapter
        public int getItemViewType(int position) {
            return 0;
        }

        @Override // android.widget.Adapter
        public int getViewTypeCount() {
            return 1;
        }

        @Override // android.widget.Adapter
        public boolean isEmpty() {
            return getCount() == 0;
        }
    }

    /* loaded from: classes.dex */
    private class DialogPopup implements SpinnerPopup, DialogInterface.OnClickListener {
        private ListAdapter mListAdapter;
        private AlertDialog mPopup;
        private CharSequence mPrompt;

        private DialogPopup() {
        }

        @Override // android.support.v7.internal.widget.SpinnerCompat.SpinnerPopup
        public void dismiss() {
            if (this.mPopup != null) {
                this.mPopup.dismiss();
                this.mPopup = null;
            }
        }

        @Override // android.support.v7.internal.widget.SpinnerCompat.SpinnerPopup
        public boolean isShowing() {
            if (this.mPopup != null) {
                return this.mPopup.isShowing();
            }
            return false;
        }

        @Override // android.support.v7.internal.widget.SpinnerCompat.SpinnerPopup
        public void setAdapter(ListAdapter adapter) {
            this.mListAdapter = adapter;
        }

        @Override // android.support.v7.internal.widget.SpinnerCompat.SpinnerPopup
        public void setPromptText(CharSequence hintText) {
            this.mPrompt = hintText;
        }

        @Override // android.support.v7.internal.widget.SpinnerCompat.SpinnerPopup
        public CharSequence getHintText() {
            return this.mPrompt;
        }

        @Override // android.support.v7.internal.widget.SpinnerCompat.SpinnerPopup
        public void show() {
            if (this.mListAdapter != null) {
                AlertDialog.Builder builder = new AlertDialog.Builder(SpinnerCompat.this.getContext());
                if (this.mPrompt != null) {
                    builder.setTitle(this.mPrompt);
                }
                this.mPopup = builder.setSingleChoiceItems(this.mListAdapter, SpinnerCompat.this.getSelectedItemPosition(), this).create();
                this.mPopup.show();
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialog, int which) {
            SpinnerCompat.this.setSelection(which);
            if (SpinnerCompat.this.mOnItemClickListener != null) {
                SpinnerCompat.this.performItemClick(null, which, this.mListAdapter.getItemId(which));
            }
            dismiss();
        }

        @Override // android.support.v7.internal.widget.SpinnerCompat.SpinnerPopup
        public void setBackgroundDrawable(Drawable bg) {
            Log.e(SpinnerCompat.TAG, "Cannot set popup background for MODE_DIALOG, ignoring");
        }

        @Override // android.support.v7.internal.widget.SpinnerCompat.SpinnerPopup
        public void setVerticalOffset(int px) {
            Log.e(SpinnerCompat.TAG, "Cannot set vertical offset for MODE_DIALOG, ignoring");
        }

        @Override // android.support.v7.internal.widget.SpinnerCompat.SpinnerPopup
        public void setHorizontalOffset(int px) {
            Log.e(SpinnerCompat.TAG, "Cannot set horizontal offset for MODE_DIALOG, ignoring");
        }

        @Override // android.support.v7.internal.widget.SpinnerCompat.SpinnerPopup
        public Drawable getBackground() {
            return null;
        }

        @Override // android.support.v7.internal.widget.SpinnerCompat.SpinnerPopup
        public int getVerticalOffset() {
            return 0;
        }

        @Override // android.support.v7.internal.widget.SpinnerCompat.SpinnerPopup
        public int getHorizontalOffset() {
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class DropdownPopup extends ListPopupWindow implements SpinnerPopup {
        private ListAdapter mAdapter;
        private CharSequence mHintText;

        public DropdownPopup(Context context, AttributeSet attrs, int defStyleAttr) {
            super(context, attrs, defStyleAttr);
            setAnchorView(SpinnerCompat.this);
            setModal(true);
            setPromptPosition(0);
            setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: android.support.v7.internal.widget.SpinnerCompat.DropdownPopup.1
                @Override // android.widget.AdapterView.OnItemClickListener
                public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                    SpinnerCompat.this.setSelection(position);
                    if (SpinnerCompat.this.mOnItemClickListener != null) {
                        SpinnerCompat.this.performItemClick(v, position, DropdownPopup.this.mAdapter.getItemId(position));
                    }
                    DropdownPopup.this.dismiss();
                }
            });
        }

        @Override // android.support.v7.widget.ListPopupWindow, android.support.v7.internal.widget.SpinnerCompat.SpinnerPopup
        public void setAdapter(ListAdapter adapter) {
            super.setAdapter(adapter);
            this.mAdapter = adapter;
        }

        @Override // android.support.v7.internal.widget.SpinnerCompat.SpinnerPopup
        public CharSequence getHintText() {
            return this.mHintText;
        }

        @Override // android.support.v7.internal.widget.SpinnerCompat.SpinnerPopup
        public void setPromptText(CharSequence hintText) {
            this.mHintText = hintText;
        }

        void computeContentWidth() {
            int hOffset;
            Drawable background = getBackground();
            int hOffset2 = 0;
            if (background != null) {
                background.getPadding(SpinnerCompat.this.mTempRect);
                hOffset2 = ViewUtils.isLayoutRtl(SpinnerCompat.this) ? SpinnerCompat.this.mTempRect.right : -SpinnerCompat.this.mTempRect.left;
            } else {
                Rect rect = SpinnerCompat.this.mTempRect;
                SpinnerCompat.this.mTempRect.right = 0;
                rect.left = 0;
            }
            int spinnerPaddingLeft = SpinnerCompat.this.getPaddingLeft();
            int spinnerPaddingRight = SpinnerCompat.this.getPaddingRight();
            int spinnerWidth = SpinnerCompat.this.getWidth();
            if (SpinnerCompat.this.mDropDownWidth == -2) {
                int contentWidth = SpinnerCompat.this.measureContentWidth((SpinnerAdapter) this.mAdapter, getBackground());
                int contentWidthLimit = (SpinnerCompat.this.getContext().getResources().getDisplayMetrics().widthPixels - SpinnerCompat.this.mTempRect.left) - SpinnerCompat.this.mTempRect.right;
                if (contentWidth > contentWidthLimit) {
                    contentWidth = contentWidthLimit;
                }
                setContentWidth(Math.max(contentWidth, (spinnerWidth - spinnerPaddingLeft) - spinnerPaddingRight));
            } else if (SpinnerCompat.this.mDropDownWidth == -1) {
                setContentWidth((spinnerWidth - spinnerPaddingLeft) - spinnerPaddingRight);
            } else {
                setContentWidth(SpinnerCompat.this.mDropDownWidth);
            }
            if (ViewUtils.isLayoutRtl(SpinnerCompat.this)) {
                hOffset = hOffset2 + ((spinnerWidth - spinnerPaddingRight) - getWidth());
            } else {
                hOffset = hOffset2 + spinnerPaddingLeft;
            }
            setHorizontalOffset(hOffset);
        }

        public void show(int textDirection, int textAlignment) {
            ViewTreeObserver vto;
            boolean wasShowing = isShowing();
            computeContentWidth();
            setInputMethodMode(2);
            super.show();
            ListView listView = getListView();
            listView.setChoiceMode(1);
            setSelection(SpinnerCompat.this.getSelectedItemPosition());
            if (!wasShowing && (vto = SpinnerCompat.this.getViewTreeObserver()) != null) {
                final ViewTreeObserver.OnGlobalLayoutListener layoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: android.support.v7.internal.widget.SpinnerCompat.DropdownPopup.2
                    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                    public void onGlobalLayout() {
                        DropdownPopup.this.computeContentWidth();
                        DropdownPopup.super.show();
                    }
                };
                vto.addOnGlobalLayoutListener(layoutListener);
                setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: android.support.v7.internal.widget.SpinnerCompat.DropdownPopup.3
                    @Override // android.widget.PopupWindow.OnDismissListener
                    public void onDismiss() {
                        ViewTreeObserver vto2 = SpinnerCompat.this.getViewTreeObserver();
                        if (vto2 != null) {
                            vto2.removeGlobalOnLayoutListener(layoutListener);
                        }
                    }
                });
            }
        }
    }
}