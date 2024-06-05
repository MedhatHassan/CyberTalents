package android.support.v7.internal.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RadioButton;

/* loaded from: classes.dex */
public class TintRadioButton extends RadioButton {
    private static final int[] TINT_ATTRS = {16843015};
    private final TintManager mTintManager;

    public TintRadioButton(Context context) {
        this(context, null);
    }

    public TintRadioButton(Context context, AttributeSet attrs) {
        this(context, attrs, 16842878);
    }

    public TintRadioButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TintTypedArray a = TintTypedArray.obtainStyledAttributes(context, attrs, TINT_ATTRS, defStyleAttr, 0);
        setButtonDrawable(a.getDrawable(0));
        a.recycle();
        this.mTintManager = a.getTintManager();
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(int resid) {
        setButtonDrawable(this.mTintManager.getDrawable(resid));
    }
}