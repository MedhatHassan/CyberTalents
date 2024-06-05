package android.support.v4.view.accessibility;

import android.view.accessibility.AccessibilityNodeInfo;

/* loaded from: classes.dex */
class AccessibilityNodeInfoCompatKitKat {
    AccessibilityNodeInfoCompatKitKat() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int getLiveRegion(Object info) {
        return ((AccessibilityNodeInfo) info).getLiveRegion();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setLiveRegion(Object info, int mode) {
        ((AccessibilityNodeInfo) info).setLiveRegion(mode);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object getCollectionInfo(Object info) {
        return ((AccessibilityNodeInfo) info).getCollectionInfo();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object getCollectionItemInfo(Object info) {
        return ((AccessibilityNodeInfo) info).getCollectionItemInfo();
    }

    public static void setCollectionInfo(Object info, Object collectionInfo) {
        ((AccessibilityNodeInfo) info).setCollectionInfo((AccessibilityNodeInfo.CollectionInfo) collectionInfo);
    }

    public static void setCollectionItemInfo(Object info, Object collectionItemInfo) {
        ((AccessibilityNodeInfo) info).setCollectionItemInfo((AccessibilityNodeInfo.CollectionItemInfo) collectionItemInfo);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object getRangeInfo(Object info) {
        return ((AccessibilityNodeInfo) info).getRangeInfo();
    }

    public static Object obtainCollectionInfo(int rowCount, int columnCount, boolean hierarchical, int selectionMode) {
        return AccessibilityNodeInfo.CollectionInfo.obtain(rowCount, columnCount, hierarchical);
    }

    public static Object obtainCollectionItemInfo(int rowIndex, int rowSpan, int columnIndex, int columnSpan, boolean heading) {
        return AccessibilityNodeInfo.CollectionItemInfo.obtain(rowIndex, rowSpan, columnIndex, columnSpan, heading);
    }

    /* loaded from: classes.dex */
    static class CollectionInfo {
        CollectionInfo() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static int getColumnCount(Object info) {
            return ((AccessibilityNodeInfo.CollectionInfo) info).getColumnCount();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static int getRowCount(Object info) {
            return ((AccessibilityNodeInfo.CollectionInfo) info).getRowCount();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static boolean isHierarchical(Object info) {
            return ((AccessibilityNodeInfo.CollectionInfo) info).isHierarchical();
        }
    }

    /* loaded from: classes.dex */
    static class CollectionItemInfo {
        CollectionItemInfo() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static int getColumnIndex(Object info) {
            return ((AccessibilityNodeInfo.CollectionItemInfo) info).getColumnIndex();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static int getColumnSpan(Object info) {
            return ((AccessibilityNodeInfo.CollectionItemInfo) info).getColumnSpan();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static int getRowIndex(Object info) {
            return ((AccessibilityNodeInfo.CollectionItemInfo) info).getRowIndex();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static int getRowSpan(Object info) {
            return ((AccessibilityNodeInfo.CollectionItemInfo) info).getRowSpan();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static boolean isHeading(Object info) {
            return ((AccessibilityNodeInfo.CollectionItemInfo) info).isHeading();
        }
    }

    /* loaded from: classes.dex */
    static class RangeInfo {
        RangeInfo() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static float getCurrent(Object info) {
            return ((AccessibilityNodeInfo.RangeInfo) info).getCurrent();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static float getMax(Object info) {
            return ((AccessibilityNodeInfo.RangeInfo) info).getMax();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static float getMin(Object info) {
            return ((AccessibilityNodeInfo.RangeInfo) info).getMin();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static int getType(Object info) {
            return ((AccessibilityNodeInfo.RangeInfo) info).getType();
        }
    }
}