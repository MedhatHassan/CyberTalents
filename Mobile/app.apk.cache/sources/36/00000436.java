package android.support.v7.widget;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ActionProvider;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.support.v7.appcompat.R;
import android.support.v7.internal.widget.ActivityChooserModel;
import android.support.v7.internal.widget.ActivityChooserView;
import android.support.v7.internal.widget.TintManager;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* loaded from: classes.dex */
public class ShareActionProvider extends ActionProvider {
    private static final int DEFAULT_INITIAL_ACTIVITY_COUNT = 4;
    public static final String DEFAULT_SHARE_HISTORY_FILE_NAME = "share_history.xml";
    private final Context mContext;
    private int mMaxShownActivityCount;
    private ActivityChooserModel.OnChooseActivityListener mOnChooseActivityListener;
    private final ShareMenuItemOnMenuItemClickListener mOnMenuItemClickListener;
    private OnShareTargetSelectedListener mOnShareTargetSelectedListener;
    private String mShareHistoryFileName;

    /* loaded from: classes.dex */
    public interface OnShareTargetSelectedListener {
        boolean onShareTargetSelected(ShareActionProvider shareActionProvider, Intent intent);
    }

    public ShareActionProvider(Context context) {
        super(context);
        this.mMaxShownActivityCount = 4;
        this.mOnMenuItemClickListener = new ShareMenuItemOnMenuItemClickListener();
        this.mShareHistoryFileName = DEFAULT_SHARE_HISTORY_FILE_NAME;
        this.mContext = context;
    }

    public void setOnShareTargetSelectedListener(OnShareTargetSelectedListener listener) {
        this.mOnShareTargetSelectedListener = listener;
        setActivityChooserPolicyIfNeeded();
    }

    @Override // android.support.v4.view.ActionProvider
    public View onCreateActionView() {
        ActivityChooserModel dataModel = ActivityChooserModel.get(this.mContext, this.mShareHistoryFileName);
        ActivityChooserView activityChooserView = new ActivityChooserView(this.mContext);
        activityChooserView.setActivityChooserModel(dataModel);
        TypedValue outTypedValue = new TypedValue();
        this.mContext.getTheme().resolveAttribute(R.attr.actionModeShareDrawable, outTypedValue, true);
        Drawable drawable = TintManager.getDrawable(this.mContext, outTypedValue.resourceId);
        activityChooserView.setExpandActivityOverflowButtonDrawable(drawable);
        activityChooserView.setProvider(this);
        activityChooserView.setDefaultActionButtonContentDescription(R.string.abc_shareactionprovider_share_with_application);
        activityChooserView.setExpandActivityOverflowButtonContentDescription(R.string.abc_shareactionprovider_share_with);
        return activityChooserView;
    }

    @Override // android.support.v4.view.ActionProvider
    public boolean hasSubMenu() {
        return true;
    }

    @Override // android.support.v4.view.ActionProvider
    public void onPrepareSubMenu(SubMenu subMenu) {
        subMenu.clear();
        ActivityChooserModel dataModel = ActivityChooserModel.get(this.mContext, this.mShareHistoryFileName);
        PackageManager packageManager = this.mContext.getPackageManager();
        int expandedActivityCount = dataModel.getActivityCount();
        int collapsedActivityCount = Math.min(expandedActivityCount, this.mMaxShownActivityCount);
        for (int i = 0; i < collapsedActivityCount; i++) {
            ResolveInfo activity = dataModel.getActivity(i);
            subMenu.add(0, i, i, activity.loadLabel(packageManager)).setIcon(activity.loadIcon(packageManager)).setOnMenuItemClickListener(this.mOnMenuItemClickListener);
        }
        if (collapsedActivityCount < expandedActivityCount) {
            SubMenu expandedSubMenu = subMenu.addSubMenu(0, collapsedActivityCount, collapsedActivityCount, this.mContext.getString(R.string.abc_activity_chooser_view_see_all));
            for (int i2 = 0; i2 < expandedActivityCount; i2++) {
                ResolveInfo activity2 = dataModel.getActivity(i2);
                expandedSubMenu.add(0, i2, i2, activity2.loadLabel(packageManager)).setIcon(activity2.loadIcon(packageManager)).setOnMenuItemClickListener(this.mOnMenuItemClickListener);
            }
        }
    }

    public void setShareHistoryFileName(String shareHistoryFile) {
        this.mShareHistoryFileName = shareHistoryFile;
        setActivityChooserPolicyIfNeeded();
    }

    public void setShareIntent(Intent shareIntent) {
        ActivityChooserModel dataModel = ActivityChooserModel.get(this.mContext, this.mShareHistoryFileName);
        dataModel.setIntent(shareIntent);
    }

    /* loaded from: classes.dex */
    private class ShareMenuItemOnMenuItemClickListener implements MenuItem.OnMenuItemClickListener {
        private ShareMenuItemOnMenuItemClickListener() {
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem item) {
            ActivityChooserModel dataModel = ActivityChooserModel.get(ShareActionProvider.this.mContext, ShareActionProvider.this.mShareHistoryFileName);
            int itemId = item.getItemId();
            Intent launchIntent = dataModel.chooseActivity(itemId);
            if (launchIntent != null) {
                launchIntent.addFlags(AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END);
                ShareActionProvider.this.mContext.startActivity(launchIntent);
                return true;
            }
            return true;
        }
    }

    private void setActivityChooserPolicyIfNeeded() {
        if (this.mOnShareTargetSelectedListener != null) {
            if (this.mOnChooseActivityListener == null) {
                this.mOnChooseActivityListener = new ShareActivityChooserModelPolicy();
            }
            ActivityChooserModel dataModel = ActivityChooserModel.get(this.mContext, this.mShareHistoryFileName);
            dataModel.setOnChooseActivityListener(this.mOnChooseActivityListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class ShareActivityChooserModelPolicy implements ActivityChooserModel.OnChooseActivityListener {
        private ShareActivityChooserModelPolicy() {
        }

        @Override // android.support.v7.internal.widget.ActivityChooserModel.OnChooseActivityListener
        public boolean onChooseActivity(ActivityChooserModel host, Intent intent) {
            if (ShareActionProvider.this.mOnShareTargetSelectedListener != null) {
                ShareActionProvider.this.mOnShareTargetSelectedListener.onShareTargetSelected(ShareActionProvider.this, intent);
                return false;
            }
            return false;
        }
    }
}