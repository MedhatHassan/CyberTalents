package android.support.v4.view.accessibility;

import android.view.accessibility.AccessibilityNodeInfo;
import java.util.List;

/* loaded from: classes.dex */
class AccessibilityNodeInfoCompatApi21 {
    AccessibilityNodeInfoCompatApi21() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<Object> getActionList(Object info) {
        List result = ((AccessibilityNodeInfo) info).getActionList();
        return result;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void addAction(Object info, int id, CharSequence label) {
        AccessibilityNodeInfo.AccessibilityAction aa = new AccessibilityNodeInfo.AccessibilityAction(id, label);
        ((AccessibilityNodeInfo) info).addAction(aa);
    }

    public static Object obtainCollectionInfo(int rowCount, int columnCount, boolean hierarchical, int selectionMode) {
        return AccessibilityNodeInfo.CollectionInfo.obtain(rowCount, columnCount, hierarchical, selectionMode);
    }

    public static Object obtainCollectionItemInfo(int rowIndex, int rowSpan, int columnIndex, int columnSpan, boolean heading, boolean selected) {
        return AccessibilityNodeInfo.CollectionItemInfo.obtain(rowIndex, rowSpan, columnIndex, columnSpan, heading, selected);
    }

    /* loaded from: classes.dex */
    static class CollectionItemInfo {
        CollectionItemInfo() {
        }

        public static boolean isSelected(Object info) {
            return ((AccessibilityNodeInfo.CollectionItemInfo) info).isSelected();
        }
    }

    /* loaded from: classes.dex */
    static class AccessibilityAction {
        AccessibilityAction() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static int getId(Object action) {
            return ((AccessibilityNodeInfo.AccessibilityAction) action).getId();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static CharSequence getLabel(Object action) {
            return ((AccessibilityNodeInfo.AccessibilityAction) action).getLabel();
        }
    }
}