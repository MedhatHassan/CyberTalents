package android.support.v4.view;

import android.os.Build;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;

/* loaded from: classes.dex */
public class ViewParentCompat {
    static final ViewParentCompatImpl IMPL;

    /* loaded from: classes.dex */
    interface ViewParentCompatImpl {
        boolean requestSendAccessibilityEvent(ViewParent viewParent, View view, AccessibilityEvent accessibilityEvent);
    }

    /* loaded from: classes.dex */
    static class ViewParentCompatStubImpl implements ViewParentCompatImpl {
        ViewParentCompatStubImpl() {
        }

        @Override // android.support.v4.view.ViewParentCompat.ViewParentCompatImpl
        public boolean requestSendAccessibilityEvent(ViewParent parent, View child, AccessibilityEvent event) {
            if (child == null) {
                return false;
            }
            AccessibilityManager manager = (AccessibilityManager) child.getContext().getSystemService("accessibility");
            manager.sendAccessibilityEvent(event);
            return true;
        }
    }

    /* loaded from: classes.dex */
    static class ViewParentCompatICSImpl extends ViewParentCompatStubImpl {
        ViewParentCompatICSImpl() {
        }

        @Override // android.support.v4.view.ViewParentCompat.ViewParentCompatStubImpl, android.support.v4.view.ViewParentCompat.ViewParentCompatImpl
        public boolean requestSendAccessibilityEvent(ViewParent parent, View child, AccessibilityEvent event) {
            return ViewParentCompatICS.requestSendAccessibilityEvent(parent, child, event);
        }
    }

    static {
        int version = Build.VERSION.SDK_INT;
        if (version >= 14) {
            IMPL = new ViewParentCompatICSImpl();
        } else {
            IMPL = new ViewParentCompatStubImpl();
        }
    }

    private ViewParentCompat() {
    }

    public static boolean requestSendAccessibilityEvent(ViewParent parent, View child, AccessibilityEvent event) {
        return IMPL.requestSendAccessibilityEvent(parent, child, event);
    }
}