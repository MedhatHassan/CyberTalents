package android.support.v7.internal;

import android.os.Build;

/* loaded from: classes.dex */
public class VersionUtils {
    private VersionUtils() {
    }

    public static boolean isAtLeastL() {
        return Build.VERSION.SDK_INT >= 21;
    }
}