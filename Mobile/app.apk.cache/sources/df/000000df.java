package android.support.v4.content;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import java.io.File;

/* loaded from: classes.dex */
public class ContextCompat {
    private static final String DIR_ANDROID = "Android";
    private static final String DIR_CACHE = "cache";
    private static final String DIR_DATA = "data";
    private static final String DIR_FILES = "files";
    private static final String DIR_OBB = "obb";
    private static final String TAG = "ContextCompat";

    public static boolean startActivities(Context context, Intent[] intents) {
        return startActivities(context, intents, null);
    }

    public static boolean startActivities(Context context, Intent[] intents, Bundle options) {
        int version = Build.VERSION.SDK_INT;
        if (version >= 16) {
            ContextCompatJellybean.startActivities(context, intents, options);
            return true;
        } else if (version >= 11) {
            ContextCompatHoneycomb.startActivities(context, intents);
            return true;
        } else {
            return false;
        }
    }

    public static File[] getObbDirs(Context context) {
        File single;
        int version = Build.VERSION.SDK_INT;
        if (version >= 19) {
            return ContextCompatKitKat.getObbDirs(context);
        }
        if (version >= 11) {
            single = ContextCompatHoneycomb.getObbDir(context);
        } else {
            single = buildPath(Environment.getExternalStorageDirectory(), DIR_ANDROID, DIR_OBB, context.getPackageName());
        }
        return new File[]{single};
    }

    public static File[] getExternalFilesDirs(Context context, String type) {
        File single;
        int version = Build.VERSION.SDK_INT;
        if (version >= 19) {
            return ContextCompatKitKat.getExternalFilesDirs(context, type);
        }
        if (version >= 8) {
            single = ContextCompatFroyo.getExternalFilesDir(context, type);
        } else {
            single = buildPath(Environment.getExternalStorageDirectory(), DIR_ANDROID, DIR_DATA, context.getPackageName(), DIR_FILES, type);
        }
        return new File[]{single};
    }

    public static File[] getExternalCacheDirs(Context context) {
        File single;
        int version = Build.VERSION.SDK_INT;
        if (version >= 19) {
            return ContextCompatKitKat.getExternalCacheDirs(context);
        }
        if (version >= 8) {
            single = ContextCompatFroyo.getExternalCacheDir(context);
        } else {
            single = buildPath(Environment.getExternalStorageDirectory(), DIR_ANDROID, DIR_DATA, context.getPackageName(), DIR_CACHE);
        }
        return new File[]{single};
    }

    private static File buildPath(File base, String... segments) {
        File cur;
        int len$ = segments.length;
        int i$ = 0;
        File cur2 = base;
        while (i$ < len$) {
            String segment = segments[i$];
            if (cur2 == null) {
                cur = new File(segment);
            } else {
                cur = segment != null ? new File(cur2, segment) : cur2;
            }
            i$++;
            cur2 = cur;
        }
        return cur2;
    }

    public static final Drawable getDrawable(Context context, int id) {
        int version = Build.VERSION.SDK_INT;
        return version >= 21 ? ContextCompatApi21.getDrawable(context, id) : context.getResources().getDrawable(id);
    }

    public final File getNoBackupFilesDir(Context context) {
        int version = Build.VERSION.SDK_INT;
        if (version >= 21) {
            return ContextCompatApi21.getNoBackupFilesDir(context);
        }
        ApplicationInfo appInfo = context.getApplicationInfo();
        return createFilesDir(new File(appInfo.dataDir, "no_backup"));
    }

    public final File getCodeCacheDir(Context context) {
        int version = Build.VERSION.SDK_INT;
        if (version >= 21) {
            return ContextCompatApi21.getCodeCacheDir(context);
        }
        ApplicationInfo appInfo = context.getApplicationInfo();
        return createFilesDir(new File(appInfo.dataDir, "code_cache"));
    }

    private static synchronized File createFilesDir(File file) {
        synchronized (ContextCompat.class) {
            if (!file.exists() && !file.mkdirs() && !file.exists()) {
                Log.w(TAG, "Unable to create files subdir " + file.getPath());
                file = null;
            }
        }
        return file;
    }
}