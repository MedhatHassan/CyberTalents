package android.support.v4.view;

import android.view.VelocityTracker;

/* loaded from: classes.dex */
class VelocityTrackerCompatHoneycomb {
    VelocityTrackerCompatHoneycomb() {
    }

    public static float getXVelocity(VelocityTracker tracker, int pointerId) {
        return tracker.getXVelocity(pointerId);
    }

    public static float getYVelocity(VelocityTracker tracker, int pointerId) {
        return tracker.getYVelocity(pointerId);
    }
}