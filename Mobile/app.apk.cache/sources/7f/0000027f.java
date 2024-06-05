package android.support.v4.view.accessibility;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.view.accessibility.AccessibilityManager;
import java.util.List;

/* loaded from: classes.dex */
class AccessibilityManagerCompatIcs {

    /* loaded from: classes.dex */
    interface AccessibilityStateChangeListenerBridge {
        void onAccessibilityStateChanged(boolean z);
    }

    AccessibilityManagerCompatIcs() {
    }

    public static Object newAccessibilityStateChangeListener(final AccessibilityStateChangeListenerBridge bridge) {
        return new AccessibilityManager.AccessibilityStateChangeListener() { // from class: android.support.v4.view.accessibility.AccessibilityManagerCompatIcs.1
            @Override // android.view.accessibility.AccessibilityManager.AccessibilityStateChangeListener
            public void onAccessibilityStateChanged(boolean enabled) {
                AccessibilityStateChangeListenerBridge.this.onAccessibilityStateChanged(enabled);
            }
        };
    }

    public static boolean addAccessibilityStateChangeListener(AccessibilityManager manager, Object listener) {
        return manager.addAccessibilityStateChangeListener((AccessibilityManager.AccessibilityStateChangeListener) listener);
    }

    public static boolean removeAccessibilityStateChangeListener(AccessibilityManager manager, Object listener) {
        return manager.removeAccessibilityStateChangeListener((AccessibilityManager.AccessibilityStateChangeListener) listener);
    }

    public static List<AccessibilityServiceInfo> getEnabledAccessibilityServiceList(AccessibilityManager manager, int feedbackTypeFlags) {
        return manager.getEnabledAccessibilityServiceList(feedbackTypeFlags);
    }

    public static List<AccessibilityServiceInfo> getInstalledAccessibilityServiceList(AccessibilityManager manager) {
        return manager.getInstalledAccessibilityServiceList();
    }

    public static boolean isTouchExplorationEnabled(AccessibilityManager manager) {
        return manager.isTouchExplorationEnabled();
    }
}