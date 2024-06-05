package android.support.v4.graphics;

import android.graphics.Bitmap;
import android.os.Build;

/* loaded from: classes.dex */
public class BitmapCompat {
    static final BitmapImpl IMPL;

    /* loaded from: classes.dex */
    interface BitmapImpl {
        int getAllocationByteCount(Bitmap bitmap);

        boolean hasMipMap(Bitmap bitmap);

        void setHasMipMap(Bitmap bitmap, boolean z);
    }

    /* loaded from: classes.dex */
    static class BaseBitmapImpl implements BitmapImpl {
        BaseBitmapImpl() {
        }

        @Override // android.support.v4.graphics.BitmapCompat.BitmapImpl
        public boolean hasMipMap(Bitmap bitmap) {
            return false;
        }

        @Override // android.support.v4.graphics.BitmapCompat.BitmapImpl
        public void setHasMipMap(Bitmap bitmap, boolean hasMipMap) {
        }

        @Override // android.support.v4.graphics.BitmapCompat.BitmapImpl
        public int getAllocationByteCount(Bitmap bitmap) {
            return bitmap.getRowBytes() * bitmap.getHeight();
        }
    }

    /* loaded from: classes.dex */
    static class HcMr1BitmapCompatImpl extends BaseBitmapImpl {
        HcMr1BitmapCompatImpl() {
        }

        @Override // android.support.v4.graphics.BitmapCompat.BaseBitmapImpl, android.support.v4.graphics.BitmapCompat.BitmapImpl
        public int getAllocationByteCount(Bitmap bitmap) {
            return BitmapCompatHoneycombMr1.getAllocationByteCount(bitmap);
        }
    }

    /* loaded from: classes.dex */
    static class JbMr2BitmapCompatImpl extends HcMr1BitmapCompatImpl {
        JbMr2BitmapCompatImpl() {
        }

        @Override // android.support.v4.graphics.BitmapCompat.BaseBitmapImpl, android.support.v4.graphics.BitmapCompat.BitmapImpl
        public boolean hasMipMap(Bitmap bitmap) {
            return BitmapCompatJellybeanMR2.hasMipMap(bitmap);
        }

        @Override // android.support.v4.graphics.BitmapCompat.BaseBitmapImpl, android.support.v4.graphics.BitmapCompat.BitmapImpl
        public void setHasMipMap(Bitmap bitmap, boolean hasMipMap) {
            BitmapCompatJellybeanMR2.setHasMipMap(bitmap, hasMipMap);
        }
    }

    /* loaded from: classes.dex */
    static class KitKatBitmapCompatImpl extends JbMr2BitmapCompatImpl {
        KitKatBitmapCompatImpl() {
        }

        @Override // android.support.v4.graphics.BitmapCompat.HcMr1BitmapCompatImpl, android.support.v4.graphics.BitmapCompat.BaseBitmapImpl, android.support.v4.graphics.BitmapCompat.BitmapImpl
        public int getAllocationByteCount(Bitmap bitmap) {
            return BitmapCompatKitKat.getAllocationByteCount(bitmap);
        }
    }

    static {
        int version = Build.VERSION.SDK_INT;
        if (version >= 19) {
            IMPL = new KitKatBitmapCompatImpl();
        } else if (version >= 18) {
            IMPL = new JbMr2BitmapCompatImpl();
        } else if (version >= 12) {
            IMPL = new HcMr1BitmapCompatImpl();
        } else {
            IMPL = new BaseBitmapImpl();
        }
    }

    public static boolean hasMipMap(Bitmap bitmap) {
        return IMPL.hasMipMap(bitmap);
    }

    public static void setHasMipMap(Bitmap bitmap, boolean hasMipMap) {
        IMPL.setHasMipMap(bitmap, hasMipMap);
    }

    public static int getAllocationByteCount(Bitmap bitmap) {
        return IMPL.getAllocationByteCount(bitmap);
    }
}