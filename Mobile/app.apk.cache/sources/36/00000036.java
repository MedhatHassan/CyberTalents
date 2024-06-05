package android.support.v4.app;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.util.Pair;
import android.view.View;

/* loaded from: classes.dex */
public class ActivityOptionsCompat {
    public static ActivityOptionsCompat makeCustomAnimation(Context context, int enterResId, int exitResId) {
        return Build.VERSION.SDK_INT >= 16 ? new ActivityOptionsImplJB(ActivityOptionsCompatJB.makeCustomAnimation(context, enterResId, exitResId)) : new ActivityOptionsCompat();
    }

    public static ActivityOptionsCompat makeScaleUpAnimation(View source, int startX, int startY, int startWidth, int startHeight) {
        return Build.VERSION.SDK_INT >= 16 ? new ActivityOptionsImplJB(ActivityOptionsCompatJB.makeScaleUpAnimation(source, startX, startY, startWidth, startHeight)) : new ActivityOptionsCompat();
    }

    public static ActivityOptionsCompat makeThumbnailScaleUpAnimation(View source, Bitmap thumbnail, int startX, int startY) {
        return Build.VERSION.SDK_INT >= 16 ? new ActivityOptionsImplJB(ActivityOptionsCompatJB.makeThumbnailScaleUpAnimation(source, thumbnail, startX, startY)) : new ActivityOptionsCompat();
    }

    public static ActivityOptionsCompat makeSceneTransitionAnimation(Activity activity, View sharedElement, String sharedElementName) {
        return Build.VERSION.SDK_INT >= 21 ? new ActivityOptionsImpl21(ActivityOptionsCompat21.makeSceneTransitionAnimation(activity, sharedElement, sharedElementName)) : new ActivityOptionsCompat();
    }

    public static ActivityOptionsCompat makeSceneTransitionAnimation(Activity activity, Pair<View, String>... sharedElements) {
        if (Build.VERSION.SDK_INT >= 21) {
            View[] views = null;
            String[] names = null;
            if (sharedElements != null) {
                views = new View[sharedElements.length];
                names = new String[sharedElements.length];
                for (int i = 0; i < sharedElements.length; i++) {
                    views[i] = sharedElements[i].first;
                    names[i] = sharedElements[i].second;
                }
            }
            return new ActivityOptionsImpl21(ActivityOptionsCompat21.makeSceneTransitionAnimation(activity, views, names));
        }
        return new ActivityOptionsCompat();
    }

    /* loaded from: classes.dex */
    private static class ActivityOptionsImplJB extends ActivityOptionsCompat {
        private final ActivityOptionsCompatJB mImpl;

        ActivityOptionsImplJB(ActivityOptionsCompatJB impl) {
            this.mImpl = impl;
        }

        @Override // android.support.v4.app.ActivityOptionsCompat
        public Bundle toBundle() {
            return this.mImpl.toBundle();
        }

        @Override // android.support.v4.app.ActivityOptionsCompat
        public void update(ActivityOptionsCompat otherOptions) {
            if (otherOptions instanceof ActivityOptionsImplJB) {
                ActivityOptionsImplJB otherImpl = (ActivityOptionsImplJB) otherOptions;
                this.mImpl.update(otherImpl.mImpl);
            }
        }
    }

    /* loaded from: classes.dex */
    private static class ActivityOptionsImpl21 extends ActivityOptionsCompat {
        private final ActivityOptionsCompat21 mImpl;

        ActivityOptionsImpl21(ActivityOptionsCompat21 impl) {
            this.mImpl = impl;
        }

        @Override // android.support.v4.app.ActivityOptionsCompat
        public Bundle toBundle() {
            return this.mImpl.toBundle();
        }

        @Override // android.support.v4.app.ActivityOptionsCompat
        public void update(ActivityOptionsCompat otherOptions) {
            if (otherOptions instanceof ActivityOptionsImpl21) {
                ActivityOptionsImpl21 otherImpl = (ActivityOptionsImpl21) otherOptions;
                this.mImpl.update(otherImpl.mImpl);
            }
        }
    }

    protected ActivityOptionsCompat() {
    }

    public Bundle toBundle() {
        return null;
    }

    public void update(ActivityOptionsCompat otherOptions) {
    }
}