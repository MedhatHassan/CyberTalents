package android.support.v4.widget;

import android.view.View;
import android.widget.PopupMenu;

/* loaded from: classes.dex */
class PopupMenuCompatKitKat {
    PopupMenuCompatKitKat() {
    }

    public static View.OnTouchListener getDragToOpenListener(Object popupMenu) {
        return ((PopupMenu) popupMenu).getDragToOpenListener();
    }
}