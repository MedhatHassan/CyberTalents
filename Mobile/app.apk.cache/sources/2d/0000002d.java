package android.support.v4.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat21;
import android.support.v4.content.ContextCompat;
import android.view.View;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class ActivityCompat extends ContextCompat {
    public static boolean invalidateOptionsMenu(Activity activity) {
        if (Build.VERSION.SDK_INT >= 11) {
            ActivityCompatHoneycomb.invalidateOptionsMenu(activity);
            return true;
        }
        return false;
    }

    public static void startActivity(Activity activity, Intent intent, @Nullable Bundle options) {
        if (Build.VERSION.SDK_INT >= 16) {
            ActivityCompatJB.startActivity(activity, intent, options);
        } else {
            activity.startActivity(intent);
        }
    }

    public static void startActivityForResult(Activity activity, Intent intent, int requestCode, @Nullable Bundle options) {
        if (Build.VERSION.SDK_INT >= 16) {
            ActivityCompatJB.startActivityForResult(activity, intent, requestCode, options);
        } else {
            activity.startActivityForResult(intent, requestCode);
        }
    }

    public static void finishAffinity(Activity activity) {
        if (Build.VERSION.SDK_INT >= 16) {
            ActivityCompatJB.finishAffinity(activity);
        } else {
            activity.finish();
        }
    }

    public static void finishAfterTransition(Activity activity) {
        if (Build.VERSION.SDK_INT >= 21) {
            ActivityCompat21.finishAfterTransition(activity);
        } else {
            activity.finish();
        }
    }

    public static void setEnterSharedElementCallback(Activity activity, SharedElementCallback callback) {
        if (Build.VERSION.SDK_INT >= 21) {
            ActivityCompat21.setEnterSharedElementCallback(activity, createCallback(callback));
        }
    }

    public static void setExitSharedElementCallback(Activity activity, SharedElementCallback callback) {
        if (Build.VERSION.SDK_INT >= 21) {
            ActivityCompat21.setExitSharedElementCallback(activity, createCallback(callback));
        }
    }

    public static void postponeEnterTransition(Activity activity) {
        if (Build.VERSION.SDK_INT >= 21) {
            ActivityCompat21.postponeEnterTransition(activity);
        }
    }

    public static void startPostponedEnterTransition(Activity activity) {
        if (Build.VERSION.SDK_INT >= 21) {
            ActivityCompat21.startPostponedEnterTransition(activity);
        }
    }

    private static ActivityCompat21.SharedElementCallback21 createCallback(SharedElementCallback callback) {
        if (callback == null) {
            return null;
        }
        ActivityCompat21.SharedElementCallback21 newCallback = new SharedElementCallback21Impl(callback);
        return newCallback;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class SharedElementCallback21Impl extends ActivityCompat21.SharedElementCallback21 {
        private SharedElementCallback mCallback;

        public SharedElementCallback21Impl(SharedElementCallback callback) {
            this.mCallback = callback;
        }

        @Override // android.support.v4.app.ActivityCompat21.SharedElementCallback21
        public void onSharedElementStart(List<String> sharedElementNames, List<View> sharedElements, List<View> sharedElementSnapshots) {
            this.mCallback.onSharedElementStart(sharedElementNames, sharedElements, sharedElementSnapshots);
        }

        @Override // android.support.v4.app.ActivityCompat21.SharedElementCallback21
        public void onSharedElementEnd(List<String> sharedElementNames, List<View> sharedElements, List<View> sharedElementSnapshots) {
            this.mCallback.onSharedElementEnd(sharedElementNames, sharedElements, sharedElementSnapshots);
        }

        @Override // android.support.v4.app.ActivityCompat21.SharedElementCallback21
        public void onRejectSharedElements(List<View> rejectedSharedElements) {
            this.mCallback.onRejectSharedElements(rejectedSharedElements);
        }

        @Override // android.support.v4.app.ActivityCompat21.SharedElementCallback21
        public void onMapSharedElements(List<String> names, Map<String, View> sharedElements) {
            this.mCallback.onMapSharedElements(names, sharedElements);
        }

        @Override // android.support.v4.app.ActivityCompat21.SharedElementCallback21
        public Parcelable onCaptureSharedElementSnapshot(View sharedElement, Matrix viewToGlobalMatrix, RectF screenBounds) {
            return this.mCallback.onCaptureSharedElementSnapshot(sharedElement, viewToGlobalMatrix, screenBounds);
        }

        @Override // android.support.v4.app.ActivityCompat21.SharedElementCallback21
        public View onCreateSnapshotView(Context context, Parcelable snapshot) {
            return this.mCallback.onCreateSnapshotView(context, snapshot);
        }
    }
}