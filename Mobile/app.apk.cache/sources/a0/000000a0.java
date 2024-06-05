package android.support.v4.app;

import android.app.PendingIntent;
import android.os.Bundle;
import android.support.v4.app.RemoteInputCompatBase;

/* loaded from: classes.dex */
class NotificationCompatBase {

    /* loaded from: classes.dex */
    public static abstract class Action {

        /* loaded from: classes.dex */
        public interface Factory {
            Action build(int i, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle, RemoteInputCompatBase.RemoteInput[] remoteInputArr);

            Action[] newArray(int i);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public abstract PendingIntent getActionIntent();

        /* JADX INFO: Access modifiers changed from: protected */
        public abstract Bundle getExtras();

        /* JADX INFO: Access modifiers changed from: protected */
        public abstract int getIcon();

        /* JADX INFO: Access modifiers changed from: protected */
        public abstract RemoteInputCompatBase.RemoteInput[] getRemoteInputs();

        /* JADX INFO: Access modifiers changed from: protected */
        public abstract CharSequence getTitle();
    }

    /* loaded from: classes.dex */
    public static abstract class UnreadConversation {

        /* loaded from: classes.dex */
        public interface Factory {
            UnreadConversation build(String[] strArr, RemoteInputCompatBase.RemoteInput remoteInput, PendingIntent pendingIntent, PendingIntent pendingIntent2, String[] strArr2, long j);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract long getLatestTimestamp();

        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract String[] getMessages();

        abstract String getParticipant();

        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract String[] getParticipants();

        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract PendingIntent getReadPendingIntent();

        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract RemoteInputCompatBase.RemoteInput getRemoteInput();

        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract PendingIntent getReplyPendingIntent();
    }

    NotificationCompatBase() {
    }
}