package android.support.v7.internal.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class TintDrawableWrapper extends DrawableWrapper {
    private int mCurrentColor;
    private final PorterDuff.Mode mTintMode;
    private final ColorStateList mTintStateList;

    public TintDrawableWrapper(Drawable drawable, ColorStateList tintStateList) {
        this(drawable, tintStateList, TintManager.DEFAULT_MODE);
    }

    public TintDrawableWrapper(Drawable drawable, ColorStateList tintStateList, PorterDuff.Mode tintMode) {
        super(drawable);
        this.mTintStateList = tintStateList;
        this.mTintMode = tintMode;
    }

    @Override // android.support.v7.internal.widget.DrawableWrapper, android.graphics.drawable.Drawable
    public boolean isStateful() {
        return (this.mTintStateList != null && this.mTintStateList.isStateful()) || super.isStateful();
    }

    @Override // android.support.v7.internal.widget.DrawableWrapper, android.graphics.drawable.Drawable
    public boolean setState(int[] stateSet) {
        boolean handled = super.setState(stateSet);
        return updateTint(stateSet) || handled;
    }

    private boolean updateTint(int[] state) {
        int color;
        if (this.mTintStateList != null && (color = this.mTintStateList.getColorForState(state, this.mCurrentColor)) != this.mCurrentColor) {
            if (color != 0) {
                setColorFilter(color, this.mTintMode);
            } else {
                clearColorFilter();
            }
            this.mCurrentColor = color;
            return true;
        }
        return false;
    }
}