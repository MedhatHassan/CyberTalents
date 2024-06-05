package android.support.v7.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.appcompat.R;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class DrawerArrowDrawable extends Drawable {
    private static final float ARROW_HEAD_ANGLE = (float) Math.toRadians(45.0d);
    private final float mBarGap;
    private final float mBarSize;
    private final float mBarThickness;
    private final float mMiddleArrowSize;
    private float mProgress;
    private final int mSize;
    private final boolean mSpin;
    private final float mTopBottomArrowSize;
    private final Paint mPaint = new Paint();
    private final Path mPath = new Path();
    private boolean mVerticalMirror = false;

    abstract boolean isLayoutRtl();

    /* JADX INFO: Access modifiers changed from: package-private */
    public DrawerArrowDrawable(Context context) {
        TypedArray typedArray = context.getTheme().obtainStyledAttributes(null, R.styleable.DrawerArrowToggle, R.attr.drawerArrowStyle, R.style.Base_Widget_AppCompat_DrawerArrowToggle);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setColor(typedArray.getColor(R.styleable.DrawerArrowToggle_color, 0));
        this.mSize = typedArray.getDimensionPixelSize(R.styleable.DrawerArrowToggle_drawableSize, 0);
        this.mBarSize = typedArray.getDimension(R.styleable.DrawerArrowToggle_barSize, 0.0f);
        this.mTopBottomArrowSize = typedArray.getDimension(R.styleable.DrawerArrowToggle_topBottomBarArrowSize, 0.0f);
        this.mBarThickness = typedArray.getDimension(R.styleable.DrawerArrowToggle_thickness, 0.0f);
        this.mBarGap = typedArray.getDimension(R.styleable.DrawerArrowToggle_gapBetweenBars, 0.0f);
        this.mSpin = typedArray.getBoolean(R.styleable.DrawerArrowToggle_spinBars, true);
        this.mMiddleArrowSize = typedArray.getDimension(R.styleable.DrawerArrowToggle_middleBarArrowSize, 0.0f);
        typedArray.recycle();
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeJoin(Paint.Join.ROUND);
        this.mPaint.setStrokeCap(Paint.Cap.SQUARE);
        this.mPaint.setStrokeWidth(this.mBarThickness);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setVerticalMirror(boolean verticalMirror) {
        this.mVerticalMirror = verticalMirror;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        boolean isRtl = isLayoutRtl();
        float arrowSize = lerp(this.mBarSize, this.mTopBottomArrowSize, this.mProgress);
        float middleBarSize = lerp(this.mBarSize, this.mMiddleArrowSize, this.mProgress);
        float middleBarCut = lerp(0.0f, this.mBarThickness / 2.0f, this.mProgress);
        float rotation = lerp(0.0f, ARROW_HEAD_ANGLE, this.mProgress);
        float canvasRotate = lerp(isRtl ? 0.0f : -180.0f, isRtl ? 180.0f : 0.0f, this.mProgress);
        float topBottomBarOffset = lerp(this.mBarGap + this.mBarThickness, 0.0f, this.mProgress);
        this.mPath.rewind();
        float arrowEdge = (-middleBarSize) / 2.0f;
        this.mPath.moveTo(arrowEdge + middleBarCut, 0.0f);
        this.mPath.rLineTo(middleBarSize - middleBarCut, 0.0f);
        float arrowWidth = (float) Math.round(arrowSize * Math.cos(rotation));
        float arrowHeight = (float) Math.round(arrowSize * Math.sin(rotation));
        this.mPath.moveTo(arrowEdge, topBottomBarOffset);
        this.mPath.rLineTo(arrowWidth, arrowHeight);
        this.mPath.moveTo(arrowEdge, -topBottomBarOffset);
        this.mPath.rLineTo(arrowWidth, -arrowHeight);
        this.mPath.moveTo(0.0f, 0.0f);
        this.mPath.close();
        canvas.save();
        if (this.mSpin) {
            canvas.rotate((this.mVerticalMirror ^ isRtl ? -1 : 1) * canvasRotate, bounds.centerX(), bounds.centerY());
        } else if (isRtl) {
            canvas.rotate(180.0f, bounds.centerX(), bounds.centerY());
        }
        canvas.translate(bounds.centerX(), bounds.centerY());
        canvas.drawPath(this.mPath, this.mPaint);
        canvas.restore();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.mPaint.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.mPaint.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.mSize;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.mSize;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public float getProgress() {
        return this.mProgress;
    }

    public void setProgress(float progress) {
        this.mProgress = progress;
        invalidateSelf();
    }

    private static float lerp(float a, float b, float t) {
        return ((b - a) * t) + a;
    }
}