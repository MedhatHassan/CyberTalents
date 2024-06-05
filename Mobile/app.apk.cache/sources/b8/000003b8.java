package android.support.v7.internal.widget;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ActionProvider;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.support.v7.appcompat.R;
import android.support.v7.internal.widget.ActivityChooserModel;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.ListPopupWindow;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

/* loaded from: classes.dex */
public class ActivityChooserView extends ViewGroup implements ActivityChooserModel.ActivityChooserModelClient {
    private final LinearLayoutCompat mActivityChooserContent;
    private final Drawable mActivityChooserContentBackground;
    private final ActivityChooserViewAdapter mAdapter;
    private final Callbacks mCallbacks;
    private int mDefaultActionButtonContentDescription;
    private final FrameLayout mDefaultActivityButton;
    private final ImageView mDefaultActivityButtonImage;
    private final FrameLayout mExpandActivityOverflowButton;
    private final ImageView mExpandActivityOverflowButtonImage;
    private int mInitialActivityCount;
    private boolean mIsAttachedToWindow;
    private boolean mIsSelectingDefaultActivity;
    private final int mListPopupMaxWidth;
    private ListPopupWindow mListPopupWindow;
    private final DataSetObserver mModelDataSetOberver;
    private PopupWindow.OnDismissListener mOnDismissListener;
    private final ViewTreeObserver.OnGlobalLayoutListener mOnGlobalLayoutListener;
    ActionProvider mProvider;

    public ActivityChooserView(Context context) {
        this(context, null);
    }

    public ActivityChooserView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ActivityChooserView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.mModelDataSetOberver = new DataSetObserver() { // from class: android.support.v7.internal.widget.ActivityChooserView.1
            @Override // android.database.DataSetObserver
            public void onChanged() {
                super.onChanged();
                ActivityChooserView.this.mAdapter.notifyDataSetChanged();
            }

            @Override // android.database.DataSetObserver
            public void onInvalidated() {
                super.onInvalidated();
                ActivityChooserView.this.mAdapter.notifyDataSetInvalidated();
            }
        };
        this.mOnGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: android.support.v7.internal.widget.ActivityChooserView.2
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (ActivityChooserView.this.isShowingPopup()) {
                    if (!ActivityChooserView.this.isShown()) {
                        ActivityChooserView.this.getListPopupWindow().dismiss();
                        return;
                    }
                    ActivityChooserView.this.getListPopupWindow().show();
                    if (ActivityChooserView.this.mProvider != null) {
                        ActivityChooserView.this.mProvider.subUiVisibilityChanged(true);
                    }
                }
            }
        };
        this.mInitialActivityCount = 4;
        TypedArray attributesArray = context.obtainStyledAttributes(attrs, R.styleable.ActivityChooserView, defStyle, 0);
        this.mInitialActivityCount = attributesArray.getInt(R.styleable.ActivityChooserView_initialActivityCount, 4);
        Drawable expandActivityOverflowButtonDrawable = attributesArray.getDrawable(R.styleable.ActivityChooserView_expandActivityOverflowButtonDrawable);
        attributesArray.recycle();
        LayoutInflater inflater = LayoutInflater.from(getContext());
        inflater.inflate(R.layout.abc_activity_chooser_view, (ViewGroup) this, true);
        this.mCallbacks = new Callbacks();
        this.mActivityChooserContent = (LinearLayoutCompat) findViewById(R.id.activity_chooser_view_content);
        this.mActivityChooserContentBackground = this.mActivityChooserContent.getBackground();
        this.mDefaultActivityButton = (FrameLayout) findViewById(R.id.default_activity_button);
        this.mDefaultActivityButton.setOnClickListener(this.mCallbacks);
        this.mDefaultActivityButton.setOnLongClickListener(this.mCallbacks);
        this.mDefaultActivityButtonImage = (ImageView) this.mDefaultActivityButton.findViewById(R.id.image);
        this.mExpandActivityOverflowButton = (FrameLayout) findViewById(R.id.expand_activities_button);
        this.mExpandActivityOverflowButton.setOnClickListener(this.mCallbacks);
        this.mExpandActivityOverflowButtonImage = (ImageView) this.mExpandActivityOverflowButton.findViewById(R.id.image);
        this.mExpandActivityOverflowButtonImage.setImageDrawable(expandActivityOverflowButtonDrawable);
        this.mAdapter = new ActivityChooserViewAdapter();
        this.mAdapter.registerDataSetObserver(new DataSetObserver() { // from class: android.support.v7.internal.widget.ActivityChooserView.3
            @Override // android.database.DataSetObserver
            public void onChanged() {
                super.onChanged();
                ActivityChooserView.this.updateAppearance();
            }
        });
        Resources resources = context.getResources();
        this.mListPopupMaxWidth = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R.dimen.abc_config_prefDialogWidth));
    }

    @Override // android.support.v7.internal.widget.ActivityChooserModel.ActivityChooserModelClient
    public void setActivityChooserModel(ActivityChooserModel dataModel) {
        this.mAdapter.setDataModel(dataModel);
        if (isShowingPopup()) {
            dismissPopup();
            showPopup();
        }
    }

    public void setExpandActivityOverflowButtonDrawable(Drawable drawable) {
        this.mExpandActivityOverflowButtonImage.setImageDrawable(drawable);
    }

    public void setExpandActivityOverflowButtonContentDescription(int resourceId) {
        CharSequence contentDescription = getContext().getString(resourceId);
        this.mExpandActivityOverflowButtonImage.setContentDescription(contentDescription);
    }

    public void setProvider(ActionProvider provider) {
        this.mProvider = provider;
    }

    public boolean showPopup() {
        if (isShowingPopup() || !this.mIsAttachedToWindow) {
            return false;
        }
        this.mIsSelectingDefaultActivity = false;
        showPopupUnchecked(this.mInitialActivityCount);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showPopupUnchecked(int maxActivityCount) {
        if (this.mAdapter.getDataModel() == null) {
            throw new IllegalStateException("No data model. Did you call #setDataModel?");
        }
        getViewTreeObserver().addOnGlobalLayoutListener(this.mOnGlobalLayoutListener);
        boolean defaultActivityButtonShown = this.mDefaultActivityButton.getVisibility() == 0;
        int activityCount = this.mAdapter.getActivityCount();
        int maxActivityCountOffset = defaultActivityButtonShown ? 1 : 0;
        if (maxActivityCount != Integer.MAX_VALUE && activityCount > maxActivityCount + maxActivityCountOffset) {
            this.mAdapter.setShowFooterView(true);
            this.mAdapter.setMaxActivityCount(maxActivityCount - 1);
        } else {
            this.mAdapter.setShowFooterView(false);
            this.mAdapter.setMaxActivityCount(maxActivityCount);
        }
        ListPopupWindow popupWindow = getListPopupWindow();
        if (!popupWindow.isShowing()) {
            if (this.mIsSelectingDefaultActivity || !defaultActivityButtonShown) {
                this.mAdapter.setShowDefaultActivity(true, defaultActivityButtonShown);
            } else {
                this.mAdapter.setShowDefaultActivity(false, false);
            }
            int contentWidth = Math.min(this.mAdapter.measureContentWidth(), this.mListPopupMaxWidth);
            popupWindow.setContentWidth(contentWidth);
            popupWindow.show();
            if (this.mProvider != null) {
                this.mProvider.subUiVisibilityChanged(true);
            }
            popupWindow.getListView().setContentDescription(getContext().getString(R.string.abc_activitychooserview_choose_application));
        }
    }

    public boolean dismissPopup() {
        if (isShowingPopup()) {
            getListPopupWindow().dismiss();
            ViewTreeObserver viewTreeObserver = getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeGlobalOnLayoutListener(this.mOnGlobalLayoutListener);
                return true;
            }
            return true;
        }
        return true;
    }

    public boolean isShowingPopup() {
        return getListPopupWindow().isShowing();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ActivityChooserModel dataModel = this.mAdapter.getDataModel();
        if (dataModel != null) {
            dataModel.registerObserver(this.mModelDataSetOberver);
        }
        this.mIsAttachedToWindow = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ActivityChooserModel dataModel = this.mAdapter.getDataModel();
        if (dataModel != null) {
            dataModel.unregisterObserver(this.mModelDataSetOberver);
        }
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.removeGlobalOnLayoutListener(this.mOnGlobalLayoutListener);
        }
        if (isShowingPopup()) {
            dismissPopup();
        }
        this.mIsAttachedToWindow = false;
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        View child = this.mActivityChooserContent;
        if (this.mDefaultActivityButton.getVisibility() != 0) {
            heightMeasureSpec = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(heightMeasureSpec), 1073741824);
        }
        measureChild(child, widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(child.getMeasuredWidth(), child.getMeasuredHeight());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        this.mActivityChooserContent.layout(0, 0, right - left, bottom - top);
        if (!isShowingPopup()) {
            dismissPopup();
        }
    }

    public ActivityChooserModel getDataModel() {
        return this.mAdapter.getDataModel();
    }

    public void setOnDismissListener(PopupWindow.OnDismissListener listener) {
        this.mOnDismissListener = listener;
    }

    public void setInitialActivityCount(int itemCount) {
        this.mInitialActivityCount = itemCount;
    }

    public void setDefaultActionButtonContentDescription(int resourceId) {
        this.mDefaultActionButtonContentDescription = resourceId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ListPopupWindow getListPopupWindow() {
        if (this.mListPopupWindow == null) {
            this.mListPopupWindow = new ListPopupWindow(getContext());
            this.mListPopupWindow.setAdapter(this.mAdapter);
            this.mListPopupWindow.setAnchorView(this);
            this.mListPopupWindow.setModal(true);
            this.mListPopupWindow.setOnItemClickListener(this.mCallbacks);
            this.mListPopupWindow.setOnDismissListener(this.mCallbacks);
        }
        return this.mListPopupWindow;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateAppearance() {
        if (this.mAdapter.getCount() > 0) {
            this.mExpandActivityOverflowButton.setEnabled(true);
        } else {
            this.mExpandActivityOverflowButton.setEnabled(false);
        }
        int activityCount = this.mAdapter.getActivityCount();
        int historySize = this.mAdapter.getHistorySize();
        if (activityCount == 1 || (activityCount > 1 && historySize > 0)) {
            this.mDefaultActivityButton.setVisibility(0);
            ResolveInfo activity = this.mAdapter.getDefaultActivity();
            PackageManager packageManager = getContext().getPackageManager();
            this.mDefaultActivityButtonImage.setImageDrawable(activity.loadIcon(packageManager));
            if (this.mDefaultActionButtonContentDescription != 0) {
                CharSequence label = activity.loadLabel(packageManager);
                String contentDescription = getContext().getString(this.mDefaultActionButtonContentDescription, label);
                this.mDefaultActivityButton.setContentDescription(contentDescription);
            }
        } else {
            this.mDefaultActivityButton.setVisibility(8);
        }
        if (this.mDefaultActivityButton.getVisibility() == 0) {
            this.mActivityChooserContent.setBackgroundDrawable(this.mActivityChooserContentBackground);
        } else {
            this.mActivityChooserContent.setBackgroundDrawable(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class Callbacks implements AdapterView.OnItemClickListener, View.OnClickListener, View.OnLongClickListener, PopupWindow.OnDismissListener {
        private Callbacks() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            ActivityChooserViewAdapter adapter = (ActivityChooserViewAdapter) parent.getAdapter();
            int itemViewType = adapter.getItemViewType(position);
            switch (itemViewType) {
                case 0:
                    ActivityChooserView.this.dismissPopup();
                    if (!ActivityChooserView.this.mIsSelectingDefaultActivity) {
                        if (!ActivityChooserView.this.mAdapter.getShowDefaultActivity()) {
                            position++;
                        }
                        Intent launchIntent = ActivityChooserView.this.mAdapter.getDataModel().chooseActivity(position);
                        if (launchIntent != null) {
                            launchIntent.addFlags(AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END);
                            ActivityChooserView.this.getContext().startActivity(launchIntent);
                            return;
                        }
                        return;
                    } else if (position > 0) {
                        ActivityChooserView.this.mAdapter.getDataModel().setDefaultActivity(position);
                        return;
                    } else {
                        return;
                    }
                case 1:
                    ActivityChooserView.this.showPopupUnchecked(ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
                    return;
                default:
                    throw new IllegalArgumentException();
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != ActivityChooserView.this.mDefaultActivityButton) {
                if (view == ActivityChooserView.this.mExpandActivityOverflowButton) {
                    ActivityChooserView.this.mIsSelectingDefaultActivity = false;
                    ActivityChooserView.this.showPopupUnchecked(ActivityChooserView.this.mInitialActivityCount);
                    return;
                }
                throw new IllegalArgumentException();
            }
            ActivityChooserView.this.dismissPopup();
            ResolveInfo defaultActivity = ActivityChooserView.this.mAdapter.getDefaultActivity();
            int index = ActivityChooserView.this.mAdapter.getDataModel().getActivityIndex(defaultActivity);
            Intent launchIntent = ActivityChooserView.this.mAdapter.getDataModel().chooseActivity(index);
            if (launchIntent != null) {
                launchIntent.addFlags(AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END);
                ActivityChooserView.this.getContext().startActivity(launchIntent);
            }
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (view == ActivityChooserView.this.mDefaultActivityButton) {
                if (ActivityChooserView.this.mAdapter.getCount() > 0) {
                    ActivityChooserView.this.mIsSelectingDefaultActivity = true;
                    ActivityChooserView.this.showPopupUnchecked(ActivityChooserView.this.mInitialActivityCount);
                }
                return true;
            }
            throw new IllegalArgumentException();
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            notifyOnDismissListener();
            if (ActivityChooserView.this.mProvider != null) {
                ActivityChooserView.this.mProvider.subUiVisibilityChanged(false);
            }
        }

        private void notifyOnDismissListener() {
            if (ActivityChooserView.this.mOnDismissListener != null) {
                ActivityChooserView.this.mOnDismissListener.onDismiss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class ActivityChooserViewAdapter extends BaseAdapter {
        private static final int ITEM_VIEW_TYPE_ACTIVITY = 0;
        private static final int ITEM_VIEW_TYPE_COUNT = 3;
        private static final int ITEM_VIEW_TYPE_FOOTER = 1;
        public static final int MAX_ACTIVITY_COUNT_DEFAULT = 4;
        public static final int MAX_ACTIVITY_COUNT_UNLIMITED = Integer.MAX_VALUE;
        private ActivityChooserModel mDataModel;
        private boolean mHighlightDefaultActivity;
        private int mMaxActivityCount;
        private boolean mShowDefaultActivity;
        private boolean mShowFooterView;

        private ActivityChooserViewAdapter() {
            this.mMaxActivityCount = 4;
        }

        public void setDataModel(ActivityChooserModel dataModel) {
            ActivityChooserModel oldDataModel = ActivityChooserView.this.mAdapter.getDataModel();
            if (oldDataModel != null && ActivityChooserView.this.isShown()) {
                oldDataModel.unregisterObserver(ActivityChooserView.this.mModelDataSetOberver);
            }
            this.mDataModel = dataModel;
            if (dataModel != null && ActivityChooserView.this.isShown()) {
                dataModel.registerObserver(ActivityChooserView.this.mModelDataSetOberver);
            }
            notifyDataSetChanged();
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getItemViewType(int position) {
            return (this.mShowFooterView && position == getCount() + (-1)) ? 1 : 0;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getViewTypeCount() {
            return 3;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            int activityCount = this.mDataModel.getActivityCount();
            if (!this.mShowDefaultActivity && this.mDataModel.getDefaultActivity() != null) {
                activityCount--;
            }
            int count = Math.min(activityCount, this.mMaxActivityCount);
            if (this.mShowFooterView) {
                return count + 1;
            }
            return count;
        }

        @Override // android.widget.Adapter
        public Object getItem(int position) {
            int itemViewType = getItemViewType(position);
            switch (itemViewType) {
                case 0:
                    if (!this.mShowDefaultActivity && this.mDataModel.getDefaultActivity() != null) {
                        position++;
                    }
                    return this.mDataModel.getActivity(position);
                case 1:
                    return null;
                default:
                    throw new IllegalArgumentException();
            }
        }

        @Override // android.widget.Adapter
        public long getItemId(int position) {
            return position;
        }

        @Override // android.widget.Adapter
        public View getView(int position, View convertView, ViewGroup parent) {
            int itemViewType = getItemViewType(position);
            switch (itemViewType) {
                case 0:
                    if (convertView == null || convertView.getId() != R.id.list_item) {
                        convertView = LayoutInflater.from(ActivityChooserView.this.getContext()).inflate(R.layout.abc_activity_chooser_view_list_item, parent, false);
                    }
                    PackageManager packageManager = ActivityChooserView.this.getContext().getPackageManager();
                    ImageView iconView = (ImageView) convertView.findViewById(R.id.icon);
                    ResolveInfo activity = (ResolveInfo) getItem(position);
                    iconView.setImageDrawable(activity.loadIcon(packageManager));
                    TextView titleView = (TextView) convertView.findViewById(R.id.title);
                    titleView.setText(activity.loadLabel(packageManager));
                    if (!this.mShowDefaultActivity || position != 0 || this.mHighlightDefaultActivity) {
                    }
                    return convertView;
                case 1:
                    if (convertView == null || convertView.getId() != 1) {
                        convertView = LayoutInflater.from(ActivityChooserView.this.getContext()).inflate(R.layout.abc_activity_chooser_view_list_item, parent, false);
                        convertView.setId(1);
                        TextView titleView2 = (TextView) convertView.findViewById(R.id.title);
                        titleView2.setText(ActivityChooserView.this.getContext().getString(R.string.abc_activity_chooser_view_see_all));
                    }
                    return convertView;
                default:
                    throw new IllegalArgumentException();
            }
        }

        public int measureContentWidth() {
            int oldMaxActivityCount = this.mMaxActivityCount;
            this.mMaxActivityCount = MAX_ACTIVITY_COUNT_UNLIMITED;
            int contentWidth = 0;
            View itemView = null;
            int widthMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
            int heightMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
            int count = getCount();
            for (int i = 0; i < count; i++) {
                itemView = getView(i, itemView, null);
                itemView.measure(widthMeasureSpec, heightMeasureSpec);
                contentWidth = Math.max(contentWidth, itemView.getMeasuredWidth());
            }
            this.mMaxActivityCount = oldMaxActivityCount;
            return contentWidth;
        }

        public void setMaxActivityCount(int maxActivityCount) {
            if (this.mMaxActivityCount != maxActivityCount) {
                this.mMaxActivityCount = maxActivityCount;
                notifyDataSetChanged();
            }
        }

        public ResolveInfo getDefaultActivity() {
            return this.mDataModel.getDefaultActivity();
        }

        public void setShowFooterView(boolean showFooterView) {
            if (this.mShowFooterView != showFooterView) {
                this.mShowFooterView = showFooterView;
                notifyDataSetChanged();
            }
        }

        public int getActivityCount() {
            return this.mDataModel.getActivityCount();
        }

        public int getHistorySize() {
            return this.mDataModel.getHistorySize();
        }

        public int getMaxActivityCount() {
            return this.mMaxActivityCount;
        }

        public ActivityChooserModel getDataModel() {
            return this.mDataModel;
        }

        public void setShowDefaultActivity(boolean showDefaultActivity, boolean highlightDefaultActivity) {
            if (this.mShowDefaultActivity != showDefaultActivity || this.mHighlightDefaultActivity != highlightDefaultActivity) {
                this.mShowDefaultActivity = showDefaultActivity;
                this.mHighlightDefaultActivity = highlightDefaultActivity;
                notifyDataSetChanged();
            }
        }

        public boolean getShowDefaultActivity() {
            return this.mShowDefaultActivity;
        }
    }
}