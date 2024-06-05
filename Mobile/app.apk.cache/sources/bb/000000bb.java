package android.support.v4.app;

import android.app.Notification;
import android.app.NotificationManager;

/* loaded from: classes.dex */
class NotificationManagerCompatEclair {
    NotificationManagerCompatEclair() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void cancelNotification(NotificationManager notificationManager, String tag, int id) {
        notificationManager.cancel(tag, id);
    }

    public static void postNotification(NotificationManager notificationManager, String tag, int id, Notification notification) {
        notificationManager.notify(tag, id, notification);
    }
}