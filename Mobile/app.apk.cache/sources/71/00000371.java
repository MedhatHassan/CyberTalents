package android.support.v7.internal.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.support.v4.view.ViewConfigurationCompat;
import android.support.v7.appcompat.R;
import android.view.ViewConfiguration;

/* loaded from: classes.dex */
public class ActionBarPolicy {
    private Context mContext;

    public static ActionBarPolicy get(Context context) {
        return new ActionBarPolicy(context);
    }

    private ActionBarPolicy(Context context) {
        this.mContext = context;
    }

    public int getMaxActionButtons() {
        return this.mContext.getResources().getInteger(R.integer.abc_max_action_buttons);
    }

    public boolean showsOverflowMenuButton() {
        return Build.VERSION.SDK_INT >= 19 || !ViewConfigurationCompat.hasPermanentMenuKey(ViewConfiguration.get(this.mContext));
    }

    public int getEmbeddedMenuWidthLimit() {
        return this.mContext.getResources().getDisplayMetrics().widthPixels / 2;
    }

    public boolean hasEmbeddedTabs() {
        int targetSdk = this.mContext.getApplicationInfo().targetSdkVersion;
        return targetSdk >= 16 ? this.mContext.getResources().getBoolean(R.bool.abc_action_bar_embed_tabs) : this.mContext.getResources().getBoolean(R.bool.abc_action_bar_embed_tabs_pre_jb);
    }

    public int getTabContainerHeight() {
        TypedArray a = this.mContext.obtainStyledAttributes(null, R.styleable.ActionBar, R.attr.actionBarStyle, 0);
        int height = a.getLayoutDimension(R.styleable.ActionBar_height, 0);
        Resources r = this.mContext.getResources();
        if (!hasEmbeddedTabs()) {
            height = Math.min(height, r.getDimensionPixelSize(R.dimen.abc_action_bar_stacked_max_height));
        }
        a.recycle();
        return height;
    }

    public boolean enableHomeButtonByDefault() {
        return this.mContext.getApplicationInfo().targetSdkVersion < 14;
    }

    public int getStackedTabMaxWidth() {
        return this.mContext.getResources().getDimensionPixelSize(R.dimen.abc_action_bar_stacked_tab_max_width);
    }
}