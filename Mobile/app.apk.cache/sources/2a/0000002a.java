package android.support.v4.app;

import android.app.ActionBar;
import android.app.Activity;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
class ActionBarDrawerToggleHoneycomb {
    private static final String TAG = "ActionBarDrawerToggleHoneycomb";
    private static final int[] THEME_ATTRS = {16843531};

    ActionBarDrawerToggleHoneycomb() {
    }

    public static Object setActionBarUpIndicator(Object info, Activity activity, Drawable drawable, int contentDescRes) {
        if (info == null) {
            info = new SetIndicatorInfo(activity);
        }
        SetIndicatorInfo sii = (SetIndicatorInfo) info;
        if (sii.setHomeAsUpIndicator != null) {
            try {
                ActionBar actionBar = activity.getActionBar();
                sii.setHomeAsUpIndicator.invoke(actionBar, drawable);
                sii.setHomeActionContentDescription.invoke(actionBar, Integer.valueOf(contentDescRes));
            } catch (Exception e) {
                Log.w(TAG, "Couldn't set home-as-up indicator via JB-MR2 API", e);
            }
        } else if (sii.upIndicatorView != null) {
            sii.upIndicatorView.setImageDrawable(drawable);
        } else {
            Log.w(TAG, "Couldn't set home-as-up indicator");
        }
        return info;
    }

    public static Object setActionBarDescription(Object info, Activity activity, int contentDescRes) {
        if (info == null) {
            info = new SetIndicatorInfo(activity);
        }
        SetIndicatorInfo sii = (SetIndicatorInfo) info;
        if (sii.setHomeAsUpIndicator != null) {
            try {
                ActionBar actionBar = activity.getActionBar();
                sii.setHomeActionContentDescription.invoke(actionBar, Integer.valueOf(contentDescRes));
                if (Build.VERSION.SDK_INT <= 19) {
                    actionBar.setSubtitle(actionBar.getSubtitle());
                }
            } catch (Exception e) {
                Log.w(TAG, "Couldn't set content description via JB-MR2 API", e);
            }
        }
        return info;
    }

    public static Drawable getThemeUpIndicator(Activity activity) {
        TypedArray a = activity.obtainStyledAttributes(THEME_ATTRS);
        Drawable result = a.getDrawable(0);
        a.recycle();
        return result;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class SetIndicatorInfo {
        public Method setHomeActionContentDescription;
        public Method setHomeAsUpIndicator;
        public ImageView upIndicatorView;

        SetIndicatorInfo(Activity activity) {
            try {
                this.setHomeAsUpIndicator = ActionBar.class.getDeclaredMethod("setHomeAsUpIndicator", Drawable.class);
                this.setHomeActionContentDescription = ActionBar.class.getDeclaredMethod("setHomeActionContentDescription", Integer.TYPE);
            } catch (NoSuchMethodException e) {
                View home = activity.findViewById(16908332);
                if (home != null) {
                    ViewGroup parent = (ViewGroup) home.getParent();
                    int childCount = parent.getChildCount();
                    if (childCount == 2) {
                        View first = parent.getChildAt(0);
                        View second = parent.getChildAt(1);
                        View up = first.getId() == 16908332 ? second : first;
                        if (up instanceof ImageView) {
                            this.upIndicatorView = (ImageView) up;
                        }
                    }
                }
            }
        }
    }
}