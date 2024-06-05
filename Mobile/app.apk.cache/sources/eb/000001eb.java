package android.support.v4.view;

import android.view.KeyEvent;
import android.view.View;

/* loaded from: classes.dex */
class KeyEventCompatEclair {
    KeyEventCompatEclair() {
    }

    public static Object getKeyDispatcherState(View view) {
        return view.getKeyDispatcherState();
    }

    public static boolean dispatch(KeyEvent event, KeyEvent.Callback receiver, Object state, Object target) {
        return event.dispatch(receiver, (KeyEvent.DispatcherState) state, target);
    }

    public static void startTracking(KeyEvent event) {
        event.startTracking();
    }

    public static boolean isTracking(KeyEvent event) {
        return event.isTracking();
    }
}