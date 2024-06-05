package android.support.v7.internal.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

/* loaded from: classes.dex */
public class TintImageView extends ImageView {
    private static final int[] TINT_ATTRS = {16842964, 16843033};
    private final TintManager mTintManager;

    public TintImageView(Context context) {
        this(context, null);
    }

    public TintImageView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TintImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TintTypedArray a = TintTypedArray.obtainStyledAttributes(context, attrs, TINT_ATTRS, defStyleAttr, 0);
        if (a.length() > 0) {
            if (a.hasValue(0)) {
                setBackgroundDrawable(a.getDrawable(0));
            }
            if (a.hasValue(1)) {
                setImageDrawable(a.getDrawable(1));
            }
        }
        a.recycle();
        this.mTintManager = a.getTintManager();
    }

    @Override // android.widget.ImageView
    public void setImageResource(int resId) {
        setImageDrawable(this.mTintManager.getDrawable(resId));
    }
}