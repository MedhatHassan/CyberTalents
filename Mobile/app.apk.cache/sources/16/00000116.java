package android.support.v4.graphics.drawable;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;

/* loaded from: classes.dex */
class DrawableCompatL {
    DrawableCompatL() {
    }

    public static void setHotspot(Drawable drawable, float x, float y) {
        drawable.setHotspot(x, y);
    }

    public static void setHotspotBounds(Drawable drawable, int left, int top, int right, int bottom) {
        drawable.setHotspotBounds(left, top, right, bottom);
    }

    public static void setTint(Drawable drawable, int tint) {
        drawable.setTint(tint);
    }

    public static void setTintList(Drawable drawable, ColorStateList tint) {
        drawable.setTintList(tint);
    }

    public static void setTintMode(Drawable drawable, PorterDuff.Mode tintMode) {
        drawable.setTintMode(tintMode);
    }
}