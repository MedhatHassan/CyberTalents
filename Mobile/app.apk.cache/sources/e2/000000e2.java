package android.support.v4.content;

import android.content.Context;
import android.content.Intent;
import java.io.File;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ContextCompatHoneycomb {
    ContextCompatHoneycomb() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void startActivities(Context context, Intent[] intents) {
        context.startActivities(intents);
    }

    public static File getObbDir(Context context) {
        return context.getObbDir();
    }
}