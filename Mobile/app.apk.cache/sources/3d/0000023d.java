package android.support.v4.view;

import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

/* loaded from: classes.dex */
public class ViewGroupCompat {
    static final ViewGroupCompatImpl IMPL;
    public static final int LAYOUT_MODE_CLIP_BOUNDS = 0;
    public static final int LAYOUT_MODE_OPTICAL_BOUNDS = 1;

    /* loaded from: classes.dex */
    interface ViewGroupCompatImpl {
        int getLayoutMode(ViewGroup viewGroup);

        boolean isTransitionGroup(ViewGroup viewGroup);

        boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent);

        void setLayoutMode(ViewGroup viewGroup, int i);

        void setMotionEventSplittingEnabled(ViewGroup viewGroup, boolean z);

        void setTransitionGroup(ViewGroup viewGroup, boolean z);
    }

    /* loaded from: classes.dex */
    static class ViewGroupCompatStubImpl implements ViewGroupCompatImpl {
        ViewGroupCompatStubImpl() {
        }

        @Override // android.support.v4.view.ViewGroupCompat.ViewGroupCompatImpl
        public boolean onRequestSendAccessibilityEvent(ViewGroup group, View child, AccessibilityEvent event) {
            return true;
        }

        @Override // android.support.v4.view.ViewGroupCompat.ViewGroupCompatImpl
        public void setMotionEventSplittingEnabled(ViewGroup group, boolean split) {
        }

        @Override // android.support.v4.view.ViewGroupCompat.ViewGroupCompatImpl
        public int getLayoutMode(ViewGroup group) {
            return 0;
        }

        @Override // android.support.v4.view.ViewGroupCompat.ViewGroupCompatImpl
        public void setLayoutMode(ViewGroup group, int mode) {
        }

        @Override // android.support.v4.view.ViewGroupCompat.ViewGroupCompatImpl
        public void setTransitionGroup(ViewGroup group, boolean isTransitionGroup) {
        }

        @Override // android.support.v4.view.ViewGroupCompat.ViewGroupCompatImpl
        public boolean isTransitionGroup(ViewGroup group) {
            return false;
        }
    }

    /* loaded from: classes.dex */
    static class ViewGroupCompatHCImpl extends ViewGroupCompatStubImpl {
        ViewGroupCompatHCImpl() {
        }

        @Override // android.support.v4.view.ViewGroupCompat.ViewGroupCompatStubImpl, android.support.v4.view.ViewGroupCompat.ViewGroupCompatImpl
        public void setMotionEventSplittingEnabled(ViewGroup group, boolean split) {
            ViewGroupCompatHC.setMotionEventSplittingEnabled(group, split);
        }
    }

    /* loaded from: classes.dex */
    static class ViewGroupCompatIcsImpl extends ViewGroupCompatHCImpl {
        ViewGroupCompatIcsImpl() {
        }

        @Override // android.support.v4.view.ViewGroupCompat.ViewGroupCompatStubImpl, android.support.v4.view.ViewGroupCompat.ViewGroupCompatImpl
        public boolean onRequestSendAccessibilityEvent(ViewGroup group, View child, AccessibilityEvent event) {
            return ViewGroupCompatIcs.onRequestSendAccessibilityEvent(group, child, event);
        }
    }

    /* loaded from: classes.dex */
    static class ViewGroupCompatJellybeanMR2Impl extends ViewGroupCompatIcsImpl {
        ViewGroupCompatJellybeanMR2Impl() {
        }

        @Override // android.support.v4.view.ViewGroupCompat.ViewGroupCompatStubImpl, android.support.v4.view.ViewGroupCompat.ViewGroupCompatImpl
        public int getLayoutMode(ViewGroup group) {
            return ViewGroupCompatJellybeanMR2.getLayoutMode(group);
        }

        @Override // android.support.v4.view.ViewGroupCompat.ViewGroupCompatStubImpl, android.support.v4.view.ViewGroupCompat.ViewGroupCompatImpl
        public void setLayoutMode(ViewGroup group, int mode) {
            ViewGroupCompatJellybeanMR2.setLayoutMode(group, mode);
        }
    }

    /* loaded from: classes.dex */
    static class ViewGroupCompatApi21Impl extends ViewGroupCompatJellybeanMR2Impl {
        ViewGroupCompatApi21Impl() {
        }

        @Override // android.support.v4.view.ViewGroupCompat.ViewGroupCompatStubImpl, android.support.v4.view.ViewGroupCompat.ViewGroupCompatImpl
        public void setTransitionGroup(ViewGroup group, boolean isTransitionGroup) {
            ViewGroupCompatApi21.setTransitionGroup(group, isTransitionGroup);
        }

        @Override // android.support.v4.view.ViewGroupCompat.ViewGroupCompatStubImpl, android.support.v4.view.ViewGroupCompat.ViewGroupCompatImpl
        public boolean isTransitionGroup(ViewGroup group) {
            return ViewGroupCompatApi21.isTransitionGroup(group);
        }
    }

    static {
        int version = Build.VERSION.SDK_INT;
        if (version >= 21) {
            IMPL = new ViewGroupCompatApi21Impl();
        } else if (version >= 18) {
            IMPL = new ViewGroupCompatJellybeanMR2Impl();
        } else if (version >= 14) {
            IMPL = new ViewGroupCompatIcsImpl();
        } else if (version >= 11) {
            IMPL = new ViewGroupCompatHCImpl();
        } else {
            IMPL = new ViewGroupCompatStubImpl();
        }
    }

    private ViewGroupCompat() {
    }

    public static boolean onRequestSendAccessibilityEvent(ViewGroup group, View child, AccessibilityEvent event) {
        return IMPL.onRequestSendAccessibilityEvent(group, child, event);
    }

    public static void setMotionEventSplittingEnabled(ViewGroup group, boolean split) {
        IMPL.setMotionEventSplittingEnabled(group, split);
    }

    public static int getLayoutMode(ViewGroup group) {
        return IMPL.getLayoutMode(group);
    }

    public static void setLayoutMode(ViewGroup group, int mode) {
        IMPL.setLayoutMode(group, mode);
    }

    public static void setTransitionGroup(ViewGroup group, boolean isTransitionGroup) {
        IMPL.setTransitionGroup(group, isTransitionGroup);
    }

    public static boolean isTransitionGroup(ViewGroup group) {
        return IMPL.isTransitionGroup(group);
    }
}