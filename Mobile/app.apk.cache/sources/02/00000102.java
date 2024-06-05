package android.support.v4.content.res;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;

/* loaded from: classes.dex */
public class ResourcesCompat {
    public static Drawable getDrawable(Resources res, int id, Resources.Theme theme) throws Resources.NotFoundException {
        int version = Build.VERSION.SDK_INT;
        return version >= 21 ? ResourcesCompatApi21.getDrawable(res, id, theme) : res.getDrawable(id);
    }
}