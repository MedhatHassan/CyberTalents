package android.support.v7.internal.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.appcompat.R;
import android.support.v7.internal.text.AllCapsTransformationMethod;
import android.util.AttributeSet;
import android.widget.TextView;

/* loaded from: classes.dex */
public class CompatTextView extends TextView {
    public CompatTextView(Context context) {
        this(context, null);
    }

    public CompatTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CompatTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        TypedArray style = context.obtainStyledAttributes(attrs, R.styleable.CompatTextView, defStyle, 0);
        boolean allCaps = style.getBoolean(R.styleable.CompatTextView_textAllCaps, false);
        style.recycle();
        if (allCaps) {
            setTransformationMethod(new AllCapsTransformationMethod(context));
        }
    }
}