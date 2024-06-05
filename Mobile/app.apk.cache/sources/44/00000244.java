package android.support.v4.view;

import android.view.ViewGroup;

/* loaded from: classes.dex */
class ViewGroupCompatApi21 {
    ViewGroupCompatApi21() {
    }

    public static void setTransitionGroup(ViewGroup group, boolean isTransitionGroup) {
        group.setTransitionGroup(isTransitionGroup);
    }

    public static boolean isTransitionGroup(ViewGroup group) {
        return group.isTransitionGroup();
    }
}