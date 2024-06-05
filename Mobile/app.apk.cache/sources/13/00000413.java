package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.text.TextUtilsCompat;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.widget.ListViewAutoScrollHelper;
import android.support.v4.widget.PopupWindowCompat;
import android.support.v7.appcompat.R;
import android.support.v7.internal.widget.ActivityChooserView;
import android.support.v7.internal.widget.AppCompatPopupWindow;
import android.support.v7.internal.widget.ListViewCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import java.lang.reflect.Method;
import java.util.Locale;

/* loaded from: classes.dex */
public class ListPopupWindow {
    private static final boolean DEBUG = false;
    private static final int EXPAND_LIST_TIMEOUT = 250;
    public static final int INPUT_METHOD_FROM_FOCUSABLE = 0;
    public static final int INPUT_METHOD_NEEDED = 1;
    public static final int INPUT_METHOD_NOT_NEEDED = 2;
    public static final int MATCH_PARENT = -1;
    public static final int POSITION_PROMPT_ABOVE = 0;
    public static final int POSITION_PROMPT_BELOW = 1;
    private static final String TAG = "ListPopupWindow";
    public static final int WRAP_CONTENT = -2;
    private static Method sClipToWindowEnabledMethod;
    private ListAdapter mAdapter;
    private Context mContext;
    private boolean mDropDownAlwaysVisible;
    private View mDropDownAnchorView;
    private int mDropDownGravity;
    private int mDropDownHeight;
    private int mDropDownHorizontalOffset;
    private DropDownListView mDropDownList;
    private Drawable mDropDownListHighlight;
    private int mDropDownVerticalOffset;
    private boolean mDropDownVerticalOffsetSet;
    private int mDropDownWidth;
    private boolean mForceIgnoreOutsideTouch;
    private Handler mHandler;
    private final ListSelectorHider mHideSelector;
    private AdapterView.OnItemClickListener mItemClickListener;
    private AdapterView.OnItemSelectedListener mItemSelectedListener;
    private int mLayoutDirection;
    int mListItemExpandMaximum;
    private boolean mModal;
    private DataSetObserver mObserver;
    private PopupWindow mPopup;
    private int mPromptPosition;
    private View mPromptView;
    private final ResizePopupRunnable mResizePopupRunnable;
    private final PopupScrollListener mScrollListener;
    private Runnable mShowDropDownRunnable;
    private Rect mTempRect;
    private final PopupTouchInterceptor mTouchInterceptor;

    static {
        try {
            sClipToWindowEnabledMethod = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", Boolean.TYPE);
        } catch (NoSuchMethodException e) {
            Log.i(TAG, "Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.");
        }
    }

    public ListPopupWindow(Context context) {
        this(context, null, R.attr.listPopupWindowStyle);
    }

    public ListPopupWindow(Context context, AttributeSet attrs) {
        this(context, attrs, R.attr.listPopupWindowStyle);
    }

    public ListPopupWindow(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public ListPopupWindow(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        this.mDropDownHeight = -2;
        this.mDropDownWidth = -2;
        this.mDropDownGravity = 0;
        this.mDropDownAlwaysVisible = false;
        this.mForceIgnoreOutsideTouch = false;
        this.mListItemExpandMaximum = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.mPromptPosition = 0;
        this.mResizePopupRunnable = new ResizePopupRunnable();
        this.mTouchInterceptor = new PopupTouchInterceptor();
        this.mScrollListener = new PopupScrollListener();
        this.mHideSelector = new ListSelectorHider();
        this.mHandler = new Handler();
        this.mTempRect = new Rect();
        this.mContext = context;
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.ListPopupWindow, defStyleAttr, defStyleRes);
        this.mDropDownHorizontalOffset = a.getDimensionPixelOffset(R.styleable.ListPopupWindow_android_dropDownHorizontalOffset, 0);
        this.mDropDownVerticalOffset = a.getDimensionPixelOffset(R.styleable.ListPopupWindow_android_dropDownVerticalOffset, 0);
        if (this.mDropDownVerticalOffset != 0) {
            this.mDropDownVerticalOffsetSet = true;
        }
        a.recycle();
        this.mPopup = new AppCompatPopupWindow(context, attrs, defStyleAttr);
        this.mPopup.setInputMethodMode(1);
        Locale locale = this.mContext.getResources().getConfiguration().locale;
        this.mLayoutDirection = TextUtilsCompat.getLayoutDirectionFromLocale(locale);
    }

    public void setAdapter(ListAdapter adapter) {
        if (this.mObserver == null) {
            this.mObserver = new PopupDataSetObserver();
        } else if (this.mAdapter != null) {
            this.mAdapter.unregisterDataSetObserver(this.mObserver);
        }
        this.mAdapter = adapter;
        if (this.mAdapter != null) {
            adapter.registerDataSetObserver(this.mObserver);
        }
        if (this.mDropDownList != null) {
            this.mDropDownList.setAdapter(this.mAdapter);
        }
    }

    public void setPromptPosition(int position) {
        this.mPromptPosition = position;
    }

    public int getPromptPosition() {
        return this.mPromptPosition;
    }

    public void setModal(boolean modal) {
        this.mModal = modal;
        this.mPopup.setFocusable(modal);
    }

    public boolean isModal() {
        return this.mModal;
    }

    public void setForceIgnoreOutsideTouch(boolean forceIgnoreOutsideTouch) {
        this.mForceIgnoreOutsideTouch = forceIgnoreOutsideTouch;
    }

    public void setDropDownAlwaysVisible(boolean dropDownAlwaysVisible) {
        this.mDropDownAlwaysVisible = dropDownAlwaysVisible;
    }

    public boolean isDropDownAlwaysVisible() {
        return this.mDropDownAlwaysVisible;
    }

    public void setSoftInputMode(int mode) {
        this.mPopup.setSoftInputMode(mode);
    }

    public int getSoftInputMode() {
        return this.mPopup.getSoftInputMode();
    }

    public void setListSelector(Drawable selector) {
        this.mDropDownListHighlight = selector;
    }

    public Drawable getBackground() {
        return this.mPopup.getBackground();
    }

    public void setBackgroundDrawable(Drawable d) {
        this.mPopup.setBackgroundDrawable(d);
    }

    public void setAnimationStyle(int animationStyle) {
        this.mPopup.setAnimationStyle(animationStyle);
    }

    public int getAnimationStyle() {
        return this.mPopup.getAnimationStyle();
    }

    public View getAnchorView() {
        return this.mDropDownAnchorView;
    }

    public void setAnchorView(View anchor) {
        this.mDropDownAnchorView = anchor;
    }

    public int getHorizontalOffset() {
        return this.mDropDownHorizontalOffset;
    }

    public void setHorizontalOffset(int offset) {
        this.mDropDownHorizontalOffset = offset;
    }

    public int getVerticalOffset() {
        if (this.mDropDownVerticalOffsetSet) {
            return this.mDropDownVerticalOffset;
        }
        return 0;
    }

    public void setVerticalOffset(int offset) {
        this.mDropDownVerticalOffset = offset;
        this.mDropDownVerticalOffsetSet = true;
    }

    public void setDropDownGravity(int gravity) {
        this.mDropDownGravity = gravity;
    }

    public int getWidth() {
        return this.mDropDownWidth;
    }

    public void setWidth(int width) {
        this.mDropDownWidth = width;
    }

    public void setContentWidth(int width) {
        Drawable popupBackground = this.mPopup.getBackground();
        if (popupBackground != null) {
            popupBackground.getPadding(this.mTempRect);
            this.mDropDownWidth = this.mTempRect.left + this.mTempRect.right + width;
            return;
        }
        setWidth(width);
    }

    public int getHeight() {
        return this.mDropDownHeight;
    }

    public void setHeight(int height) {
        this.mDropDownHeight = height;
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener clickListener) {
        this.mItemClickListener = clickListener;
    }

    public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener selectedListener) {
        this.mItemSelectedListener = selectedListener;
    }

    public void setPromptView(View prompt) {
        boolean showing = isShowing();
        if (showing) {
            removePromptView();
        }
        this.mPromptView = prompt;
        if (showing) {
            show();
        }
    }

    public void postShow() {
        this.mHandler.post(this.mShowDropDownRunnable);
    }

    public void show() {
        int widthSpec;
        int heightSpec;
        boolean z = true;
        boolean z2 = false;
        int height = buildDropDown();
        int widthSpec2 = 0;
        int heightSpec2 = 0;
        boolean noInputMethod = isInputMethodNotNeeded();
        if (this.mPopup.isShowing()) {
            if (this.mDropDownWidth == -1) {
                widthSpec = -1;
            } else if (this.mDropDownWidth == -2) {
                widthSpec = getAnchorView().getWidth();
            } else {
                widthSpec = this.mDropDownWidth;
            }
            if (this.mDropDownHeight == -1) {
                heightSpec = noInputMethod ? height : -1;
                if (noInputMethod) {
                    this.mPopup.setWindowLayoutMode(this.mDropDownWidth != -1 ? 0 : -1, 0);
                } else {
                    this.mPopup.setWindowLayoutMode(this.mDropDownWidth == -1 ? -1 : 0, -1);
                }
            } else {
                heightSpec = this.mDropDownHeight == -2 ? height : this.mDropDownHeight;
            }
            PopupWindow popupWindow = this.mPopup;
            if (!this.mForceIgnoreOutsideTouch && !this.mDropDownAlwaysVisible) {
                z2 = true;
            }
            popupWindow.setOutsideTouchable(z2);
            this.mPopup.update(getAnchorView(), this.mDropDownHorizontalOffset, this.mDropDownVerticalOffset, widthSpec, heightSpec);
            return;
        }
        if (this.mDropDownWidth == -1) {
            widthSpec2 = -1;
        } else if (this.mDropDownWidth == -2) {
            this.mPopup.setWidth(getAnchorView().getWidth());
        } else {
            this.mPopup.setWidth(this.mDropDownWidth);
        }
        if (this.mDropDownHeight == -1) {
            heightSpec2 = -1;
        } else if (this.mDropDownHeight == -2) {
            this.mPopup.setHeight(height);
        } else {
            this.mPopup.setHeight(this.mDropDownHeight);
        }
        this.mPopup.setWindowLayoutMode(widthSpec2, heightSpec2);
        setPopupClipToScreenEnabled(true);
        PopupWindow popupWindow2 = this.mPopup;
        if (this.mForceIgnoreOutsideTouch || this.mDropDownAlwaysVisible) {
            z = false;
        }
        popupWindow2.setOutsideTouchable(z);
        this.mPopup.setTouchInterceptor(this.mTouchInterceptor);
        PopupWindowCompat.showAsDropDown(this.mPopup, getAnchorView(), this.mDropDownHorizontalOffset, this.mDropDownVerticalOffset, this.mDropDownGravity);
        this.mDropDownList.setSelection(-1);
        if (!this.mModal || this.mDropDownList.isInTouchMode()) {
            clearListSelection();
        }
        if (!this.mModal) {
            this.mHandler.post(this.mHideSelector);
        }
    }

    public void dismiss() {
        this.mPopup.dismiss();
        removePromptView();
        this.mPopup.setContentView(null);
        this.mDropDownList = null;
        this.mHandler.removeCallbacks(this.mResizePopupRunnable);
    }

    public void setOnDismissListener(PopupWindow.OnDismissListener listener) {
        this.mPopup.setOnDismissListener(listener);
    }

    private void removePromptView() {
        if (this.mPromptView != null) {
            ViewParent parent = this.mPromptView.getParent();
            if (parent instanceof ViewGroup) {
                ViewGroup group = (ViewGroup) parent;
                group.removeView(this.mPromptView);
            }
        }
    }

    public void setInputMethodMode(int mode) {
        this.mPopup.setInputMethodMode(mode);
    }

    public int getInputMethodMode() {
        return this.mPopup.getInputMethodMode();
    }

    public void setSelection(int position) {
        DropDownListView list = this.mDropDownList;
        if (!isShowing() || list == null) {
            return;
        }
        list.mListSelectionHidden = false;
        list.setSelection(position);
        if (Build.VERSION.SDK_INT >= 11 && list.getChoiceMode() != 0) {
            list.setItemChecked(position, true);
        }
    }

    public void clearListSelection() {
        DropDownListView list = this.mDropDownList;
        if (list == null) {
            return;
        }
        list.mListSelectionHidden = true;
        list.requestLayout();
    }

    public boolean isShowing() {
        return this.mPopup.isShowing();
    }

    public boolean isInputMethodNotNeeded() {
        return this.mPopup.getInputMethodMode() == 2;
    }

    public boolean performItemClick(int position) {
        if (isShowing()) {
            if (this.mItemClickListener != null) {
                DropDownListView list = this.mDropDownList;
                View child = list.getChildAt(position - list.getFirstVisiblePosition());
                ListAdapter adapter = list.getAdapter();
                this.mItemClickListener.onItemClick(list, child, position, adapter.getItemId(position));
            }
            return true;
        }
        return false;
    }

    public Object getSelectedItem() {
        if (isShowing()) {
            return this.mDropDownList.getSelectedItem();
        }
        return null;
    }

    public int getSelectedItemPosition() {
        if (isShowing()) {
            return this.mDropDownList.getSelectedItemPosition();
        }
        return -1;
    }

    public long getSelectedItemId() {
        if (isShowing()) {
            return this.mDropDownList.getSelectedItemId();
        }
        return Long.MIN_VALUE;
    }

    public View getSelectedView() {
        if (isShowing()) {
            return this.mDropDownList.getSelectedView();
        }
        return null;
    }

    public ListView getListView() {
        return this.mDropDownList;
    }

    void setListItemExpandMax(int max) {
        this.mListItemExpandMaximum = max;
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (isShowing() && keyCode != 62 && (this.mDropDownList.getSelectedItemPosition() >= 0 || !isConfirmKey(keyCode))) {
            int curIndex = this.mDropDownList.getSelectedItemPosition();
            boolean below = !this.mPopup.isAboveAnchor();
            ListAdapter adapter = this.mAdapter;
            int firstItem = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            int lastItem = Integer.MIN_VALUE;
            if (adapter != null) {
                boolean allEnabled = adapter.areAllItemsEnabled();
                firstItem = allEnabled ? 0 : this.mDropDownList.lookForSelectablePosition(0, true);
                lastItem = allEnabled ? adapter.getCount() - 1 : this.mDropDownList.lookForSelectablePosition(adapter.getCount() - 1, false);
            }
            if ((below && keyCode == 19 && curIndex <= firstItem) || (!below && keyCode == 20 && curIndex >= lastItem)) {
                clearListSelection();
                this.mPopup.setInputMethodMode(1);
                show();
                return true;
            }
            this.mDropDownList.mListSelectionHidden = false;
            boolean consumed = this.mDropDownList.onKeyDown(keyCode, event);
            if (consumed) {
                this.mPopup.setInputMethodMode(2);
                this.mDropDownList.requestFocusFromTouch();
                show();
                switch (keyCode) {
                    case 19:
                    case 20:
                    case 23:
                    case 66:
                        return true;
                }
            } else if (below && keyCode == 20) {
                if (curIndex == lastItem) {
                    return true;
                }
            } else if (!below && keyCode == 19 && curIndex == firstItem) {
                return true;
            }
        }
        return false;
    }

    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if (!isShowing() || this.mDropDownList.getSelectedItemPosition() < 0) {
            return false;
        }
        boolean consumed = this.mDropDownList.onKeyUp(keyCode, event);
        if (consumed && isConfirmKey(keyCode)) {
            dismiss();
            return consumed;
        }
        return consumed;
    }

    public boolean onKeyPreIme(int keyCode, KeyEvent event) {
        if (keyCode == 4 && isShowing()) {
            View anchorView = this.mDropDownAnchorView;
            if (event.getAction() == 0 && event.getRepeatCount() == 0) {
                KeyEvent.DispatcherState state = anchorView.getKeyDispatcherState();
                if (state != null) {
                    state.startTracking(event, this);
                    return true;
                }
                return true;
            } else if (event.getAction() == 1) {
                KeyEvent.DispatcherState state2 = anchorView.getKeyDispatcherState();
                if (state2 != null) {
                    state2.handleUpEvent(event);
                }
                if (event.isTracking() && !event.isCanceled()) {
                    dismiss();
                    return true;
                }
            }
        }
        return false;
    }

    public View.OnTouchListener createDragToOpenListener(View src) {
        return new ForwardingListener(src) { // from class: android.support.v7.widget.ListPopupWindow.1
            @Override // android.support.v7.widget.ListPopupWindow.ForwardingListener
            public ListPopupWindow getPopup() {
                return ListPopupWindow.this;
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    private int buildDropDown() {
        int childWidthSpec;
        int otherHeights = 0;
        if (this.mDropDownList == null) {
            Context context = this.mContext;
            this.mShowDropDownRunnable = new Runnable() { // from class: android.support.v7.widget.ListPopupWindow.2
                @Override // java.lang.Runnable
                public void run() {
                    View view = ListPopupWindow.this.getAnchorView();
                    if (view != null && view.getWindowToken() != null) {
                        ListPopupWindow.this.show();
                    }
                }
            };
            this.mDropDownList = new DropDownListView(context, !this.mModal);
            if (this.mDropDownListHighlight != null) {
                this.mDropDownList.setSelector(this.mDropDownListHighlight);
            }
            this.mDropDownList.setAdapter(this.mAdapter);
            this.mDropDownList.setOnItemClickListener(this.mItemClickListener);
            this.mDropDownList.setFocusable(true);
            this.mDropDownList.setFocusableInTouchMode(true);
            this.mDropDownList.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: android.support.v7.widget.ListPopupWindow.3
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    DropDownListView dropDownList;
                    if (position == -1 || (dropDownList = ListPopupWindow.this.mDropDownList) == null) {
                        return;
                    }
                    dropDownList.mListSelectionHidden = false;
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> parent) {
                }
            });
            this.mDropDownList.setOnScrollListener(this.mScrollListener);
            if (this.mItemSelectedListener != null) {
                this.mDropDownList.setOnItemSelectedListener(this.mItemSelectedListener);
            }
            ViewGroup dropDownView = this.mDropDownList;
            View hintView = this.mPromptView;
            if (hintView != null) {
                LinearLayout hintContainer = new LinearLayout(context);
                hintContainer.setOrientation(1);
                LinearLayout.LayoutParams hintParams = new LinearLayout.LayoutParams(-1, 0, 1.0f);
                switch (this.mPromptPosition) {
                    case 0:
                        hintContainer.addView(hintView);
                        hintContainer.addView(dropDownView, hintParams);
                        break;
                    case 1:
                        hintContainer.addView(dropDownView, hintParams);
                        hintContainer.addView(hintView);
                        break;
                    default:
                        Log.e(TAG, "Invalid hint position " + this.mPromptPosition);
                        break;
                }
                int widthSpec = View.MeasureSpec.makeMeasureSpec(this.mDropDownWidth, Integer.MIN_VALUE);
                hintView.measure(widthSpec, 0);
                LinearLayout.LayoutParams hintParams2 = (LinearLayout.LayoutParams) hintView.getLayoutParams();
                otherHeights = hintView.getMeasuredHeight() + hintParams2.topMargin + hintParams2.bottomMargin;
                dropDownView = hintContainer;
            }
            this.mPopup.setContentView(dropDownView);
        } else {
            ViewGroup viewGroup = (ViewGroup) this.mPopup.getContentView();
            View view = this.mPromptView;
            if (view != null) {
                LinearLayout.LayoutParams hintParams3 = (LinearLayout.LayoutParams) view.getLayoutParams();
                otherHeights = view.getMeasuredHeight() + hintParams3.topMargin + hintParams3.bottomMargin;
            }
        }
        int padding = 0;
        Drawable background = this.mPopup.getBackground();
        if (background != null) {
            background.getPadding(this.mTempRect);
            padding = this.mTempRect.top + this.mTempRect.bottom;
            if (!this.mDropDownVerticalOffsetSet) {
                this.mDropDownVerticalOffset = -this.mTempRect.top;
            }
        } else {
            this.mTempRect.setEmpty();
        }
        if (this.mPopup.getInputMethodMode() == 2) {
        }
        int maxHeight = this.mPopup.getMaxAvailableHeight(getAnchorView(), this.mDropDownVerticalOffset);
        if (this.mDropDownAlwaysVisible || this.mDropDownHeight == -1) {
            return maxHeight + padding;
        }
        switch (this.mDropDownWidth) {
            case -2:
                childWidthSpec = View.MeasureSpec.makeMeasureSpec(this.mContext.getResources().getDisplayMetrics().widthPixels - (this.mTempRect.left + this.mTempRect.right), Integer.MIN_VALUE);
                break;
            case -1:
                childWidthSpec = View.MeasureSpec.makeMeasureSpec(this.mContext.getResources().getDisplayMetrics().widthPixels - (this.mTempRect.left + this.mTempRect.right), 1073741824);
                break;
            default:
                childWidthSpec = View.MeasureSpec.makeMeasureSpec(this.mDropDownWidth, 1073741824);
                break;
        }
        int listContent = this.mDropDownList.measureHeightOfChildrenCompat(childWidthSpec, 0, -1, maxHeight - otherHeights, -1);
        if (listContent > 0) {
            otherHeights += padding;
        }
        return listContent + otherHeights;
    }

    /* loaded from: classes.dex */
    public static abstract class ForwardingListener implements View.OnTouchListener {
        private int mActivePointerId;
        private Runnable mDisallowIntercept;
        private boolean mForwarding;
        private final float mScaledTouchSlop;
        private final View mSrc;
        private Runnable mTriggerLongPress;
        private boolean mWasLongPress;
        private final int[] mTmpLocation = new int[2];
        private final int mTapTimeout = ViewConfiguration.getTapTimeout();
        private final int mLongPressTimeout = (this.mTapTimeout + ViewConfiguration.getLongPressTimeout()) / 2;

        public abstract ListPopupWindow getPopup();

        public ForwardingListener(View src) {
            this.mSrc = src;
            this.mScaledTouchSlop = ViewConfiguration.get(src.getContext()).getScaledTouchSlop();
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View v, MotionEvent event) {
            boolean forwarding;
            boolean wasForwarding = this.mForwarding;
            if (wasForwarding) {
                forwarding = this.mWasLongPress ? onTouchForwarded(event) : onTouchForwarded(event) || !onForwardingStopped();
            } else {
                forwarding = onTouchObserved(event) && onForwardingStarted();
                if (forwarding) {
                    long now = SystemClock.uptimeMillis();
                    MotionEvent e = MotionEvent.obtain(now, now, 3, 0.0f, 0.0f, 0);
                    this.mSrc.onTouchEvent(e);
                    e.recycle();
                }
            }
            this.mForwarding = forwarding;
            return forwarding || wasForwarding;
        }

        protected boolean onForwardingStarted() {
            ListPopupWindow popup = getPopup();
            if (popup != null && !popup.isShowing()) {
                popup.show();
                return true;
            }
            return true;
        }

        protected boolean onForwardingStopped() {
            ListPopupWindow popup = getPopup();
            if (popup != null && popup.isShowing()) {
                popup.dismiss();
                return true;
            }
            return true;
        }

        private boolean onTouchObserved(MotionEvent srcEvent) {
            View src = this.mSrc;
            if (src.isEnabled()) {
                int actionMasked = MotionEventCompat.getActionMasked(srcEvent);
                switch (actionMasked) {
                    case 0:
                        this.mActivePointerId = srcEvent.getPointerId(0);
                        this.mWasLongPress = false;
                        if (this.mDisallowIntercept == null) {
                            this.mDisallowIntercept = new DisallowIntercept();
                        }
                        src.postDelayed(this.mDisallowIntercept, this.mTapTimeout);
                        if (this.mTriggerLongPress == null) {
                            this.mTriggerLongPress = new TriggerLongPress();
                        }
                        src.postDelayed(this.mTriggerLongPress, this.mLongPressTimeout);
                        return false;
                    case 1:
                    case 3:
                        clearCallbacks();
                        return false;
                    case 2:
                        int activePointerIndex = srcEvent.findPointerIndex(this.mActivePointerId);
                        if (activePointerIndex >= 0) {
                            float x = srcEvent.getX(activePointerIndex);
                            float y = srcEvent.getY(activePointerIndex);
                            if (pointInView(src, x, y, this.mScaledTouchSlop)) {
                                return false;
                            }
                            clearCallbacks();
                            src.getParent().requestDisallowInterceptTouchEvent(true);
                            return true;
                        }
                        return false;
                    default:
                        return false;
                }
            }
            return false;
        }

        private void clearCallbacks() {
            if (this.mTriggerLongPress != null) {
                this.mSrc.removeCallbacks(this.mTriggerLongPress);
            }
            if (this.mDisallowIntercept != null) {
                this.mSrc.removeCallbacks(this.mDisallowIntercept);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void onLongPress() {
            clearCallbacks();
            View src = this.mSrc;
            if (src.isEnabled() && onForwardingStarted()) {
                this.mSrc.getParent().requestDisallowInterceptTouchEvent(true);
                long now = SystemClock.uptimeMillis();
                MotionEvent e = MotionEvent.obtain(now, now, 3, 0.0f, 0.0f, 0);
                this.mSrc.onTouchEvent(e);
                e.recycle();
                this.mForwarding = true;
                this.mWasLongPress = true;
            }
        }

        private boolean onTouchForwarded(MotionEvent srcEvent) {
            DropDownListView dst;
            boolean z = true;
            View src = this.mSrc;
            ListPopupWindow popup = getPopup();
            if (popup == null || !popup.isShowing() || (dst = popup.mDropDownList) == null || !dst.isShown()) {
                return false;
            }
            MotionEvent dstEvent = MotionEvent.obtainNoHistory(srcEvent);
            toGlobalMotionEvent(src, dstEvent);
            toLocalMotionEvent(dst, dstEvent);
            boolean handled = dst.onForwardedEvent(dstEvent, this.mActivePointerId);
            dstEvent.recycle();
            int action = MotionEventCompat.getActionMasked(srcEvent);
            boolean keepForwarding = (action == 1 || action == 3) ? false : true;
            if (!handled || !keepForwarding) {
                z = false;
            }
            return z;
        }

        private static boolean pointInView(View view, float localX, float localY, float slop) {
            return localX >= (-slop) && localY >= (-slop) && localX < ((float) (view.getRight() - view.getLeft())) + slop && localY < ((float) (view.getBottom() - view.getTop())) + slop;
        }

        private boolean toLocalMotionEvent(View view, MotionEvent event) {
            int[] loc = this.mTmpLocation;
            view.getLocationOnScreen(loc);
            event.offsetLocation(-loc[0], -loc[1]);
            return true;
        }

        private boolean toGlobalMotionEvent(View view, MotionEvent event) {
            int[] loc = this.mTmpLocation;
            view.getLocationOnScreen(loc);
            event.offsetLocation(loc[0], loc[1]);
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public class DisallowIntercept implements Runnable {
            private DisallowIntercept() {
            }

            @Override // java.lang.Runnable
            public void run() {
                ViewParent parent = ForwardingListener.this.mSrc.getParent();
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public class TriggerLongPress implements Runnable {
            private TriggerLongPress() {
            }

            @Override // java.lang.Runnable
            public void run() {
                ForwardingListener.this.onLongPress();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class DropDownListView extends ListViewCompat {
        private ViewPropertyAnimatorCompat mClickAnimation;
        private boolean mDrawsInPressedState;
        private boolean mHijackFocus;
        private boolean mListSelectionHidden;
        private ListViewAutoScrollHelper mScrollHelper;

        public DropDownListView(Context context, boolean hijackFocus) {
            super(context, null, R.attr.dropDownListViewStyle);
            this.mHijackFocus = hijackFocus;
            setCacheColorHint(0);
        }

        public boolean onForwardedEvent(MotionEvent event, int activePointerId) {
            boolean handledEvent = true;
            boolean clearPressedItem = false;
            int actionMasked = MotionEventCompat.getActionMasked(event);
            switch (actionMasked) {
                case 1:
                    handledEvent = false;
                case 2:
                    int activeIndex = event.findPointerIndex(activePointerId);
                    if (activeIndex < 0) {
                        handledEvent = false;
                        break;
                    } else {
                        int x = (int) event.getX(activeIndex);
                        int y = (int) event.getY(activeIndex);
                        int position = pointToPosition(x, y);
                        if (position == -1) {
                            clearPressedItem = true;
                            break;
                        } else {
                            View child = getChildAt(position - getFirstVisiblePosition());
                            setPressedItem(child, position, x, y);
                            handledEvent = true;
                            if (actionMasked == 1) {
                                clickPressedItem(child, position);
                                break;
                            }
                        }
                    }
                    break;
                case 3:
                    handledEvent = false;
                    break;
            }
            if (!handledEvent || clearPressedItem) {
                clearPressedItem();
            }
            if (handledEvent) {
                if (this.mScrollHelper == null) {
                    this.mScrollHelper = new ListViewAutoScrollHelper(this);
                }
                this.mScrollHelper.setEnabled(true);
                this.mScrollHelper.onTouch(this, event);
            } else if (this.mScrollHelper != null) {
                this.mScrollHelper.setEnabled(false);
            }
            return handledEvent;
        }

        private void clickPressedItem(View child, int position) {
            long id = getItemIdAtPosition(position);
            performItemClick(child, position, id);
        }

        private void clearPressedItem() {
            this.mDrawsInPressedState = false;
            setPressed(false);
            drawableStateChanged();
            if (this.mClickAnimation != null) {
                this.mClickAnimation.cancel();
                this.mClickAnimation = null;
            }
        }

        private void setPressedItem(View child, int position, float x, float y) {
            this.mDrawsInPressedState = true;
            setPressed(true);
            layoutChildren();
            setSelection(position);
            positionSelectorLikeTouchCompat(position, child, x, y);
            setSelectorEnabled(false);
            refreshDrawableState();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.support.v7.internal.widget.ListViewCompat
        public boolean touchModeDrawsInPressedStateCompat() {
            return this.mDrawsInPressedState || super.touchModeDrawsInPressedStateCompat();
        }

        @Override // android.view.View
        public boolean isInTouchMode() {
            return (this.mHijackFocus && this.mListSelectionHidden) || super.isInTouchMode();
        }

        @Override // android.view.View
        public boolean hasWindowFocus() {
            return this.mHijackFocus || super.hasWindowFocus();
        }

        @Override // android.view.View
        public boolean isFocused() {
            return this.mHijackFocus || super.isFocused();
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean hasFocus() {
            return this.mHijackFocus || super.hasFocus();
        }
    }

    /* loaded from: classes.dex */
    private class PopupDataSetObserver extends DataSetObserver {
        private PopupDataSetObserver() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            if (ListPopupWindow.this.isShowing()) {
                ListPopupWindow.this.show();
            }
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            ListPopupWindow.this.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class ListSelectorHider implements Runnable {
        private ListSelectorHider() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ListPopupWindow.this.clearListSelection();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class ResizePopupRunnable implements Runnable {
        private ResizePopupRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ListPopupWindow.this.mDropDownList != null && ListPopupWindow.this.mDropDownList.getCount() > ListPopupWindow.this.mDropDownList.getChildCount() && ListPopupWindow.this.mDropDownList.getChildCount() <= ListPopupWindow.this.mListItemExpandMaximum) {
                ListPopupWindow.this.mPopup.setInputMethodMode(2);
                ListPopupWindow.this.show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class PopupTouchInterceptor implements View.OnTouchListener {
        private PopupTouchInterceptor() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View v, MotionEvent event) {
            int action = event.getAction();
            int x = (int) event.getX();
            int y = (int) event.getY();
            if (action == 0 && ListPopupWindow.this.mPopup != null && ListPopupWindow.this.mPopup.isShowing() && x >= 0 && x < ListPopupWindow.this.mPopup.getWidth() && y >= 0 && y < ListPopupWindow.this.mPopup.getHeight()) {
                ListPopupWindow.this.mHandler.postDelayed(ListPopupWindow.this.mResizePopupRunnable, 250L);
                return false;
            } else if (action == 1) {
                ListPopupWindow.this.mHandler.removeCallbacks(ListPopupWindow.this.mResizePopupRunnable);
                return false;
            } else {
                return false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class PopupScrollListener implements AbsListView.OnScrollListener {
        private PopupScrollListener() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView view, int scrollState) {
            if (scrollState == 1 && !ListPopupWindow.this.isInputMethodNotNeeded() && ListPopupWindow.this.mPopup.getContentView() != null) {
                ListPopupWindow.this.mHandler.removeCallbacks(ListPopupWindow.this.mResizePopupRunnable);
                ListPopupWindow.this.mResizePopupRunnable.run();
            }
        }
    }

    private static boolean isConfirmKey(int keyCode) {
        return keyCode == 66 || keyCode == 23;
    }

    private void setPopupClipToScreenEnabled(boolean clip) {
        if (sClipToWindowEnabledMethod != null) {
            try {
                sClipToWindowEnabledMethod.invoke(this.mPopup, Boolean.valueOf(clip));
            } catch (Exception e) {
                Log.i(TAG, "Could not call setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
        }
    }
}