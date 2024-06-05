package android.support.v4.text;

import android.os.Build;

/* loaded from: classes.dex */
public class ICUCompat {
    private static final ICUCompatImpl IMPL;

    /* loaded from: classes.dex */
    interface ICUCompatImpl {
        String addLikelySubtags(String str);

        String getScript(String str);
    }

    /* loaded from: classes.dex */
    static class ICUCompatImplBase implements ICUCompatImpl {
        ICUCompatImplBase() {
        }

        @Override // android.support.v4.text.ICUCompat.ICUCompatImpl
        public String getScript(String locale) {
            return null;
        }

        @Override // android.support.v4.text.ICUCompat.ICUCompatImpl
        public String addLikelySubtags(String locale) {
            return locale;
        }
    }

    /* loaded from: classes.dex */
    static class ICUCompatImplIcs implements ICUCompatImpl {
        ICUCompatImplIcs() {
        }

        @Override // android.support.v4.text.ICUCompat.ICUCompatImpl
        public String getScript(String locale) {
            return ICUCompatIcs.getScript(locale);
        }

        @Override // android.support.v4.text.ICUCompat.ICUCompatImpl
        public String addLikelySubtags(String locale) {
            return ICUCompatIcs.addLikelySubtags(locale);
        }
    }

    static {
        int version = Build.VERSION.SDK_INT;
        if (version >= 14) {
            IMPL = new ICUCompatImplIcs();
        } else {
            IMPL = new ICUCompatImplBase();
        }
    }

    public static String getScript(String locale) {
        return IMPL.getScript(locale);
    }

    public static String addLikelySubtags(String locale) {
        return IMPL.addLikelySubtags(locale);
    }
}