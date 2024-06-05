package android.support.v4.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.support.annotation.IntDef;
import android.support.annotation.NonNull;
import android.support.v4.media.session.PlaybackStateCompat;
import android.support.v4.view.ViewCompat;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.Transformation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class MaterialProgressDrawable extends Drawable implements Animatable {
    private static final int ANIMATION_DURATION = 1333;
    private static final int ARROW_HEIGHT = 5;
    private static final int ARROW_HEIGHT_LARGE = 6;
    private static final float ARROW_OFFSET_ANGLE = 5.0f;
    private static final int ARROW_WIDTH = 10;
    private static final int ARROW_WIDTH_LARGE = 12;
    private static final float CENTER_RADIUS = 8.75f;
    private static final float CENTER_RADIUS_LARGE = 12.5f;
    private static final int CIRCLE_DIAMETER = 40;
    private static final int CIRCLE_DIAMETER_LARGE = 56;
    static final int DEFAULT = 1;
    static final int LARGE = 0;
    private static final float MAX_PROGRESS_ARC = 0.8f;
    private static final float NUM_POINTS = 5.0f;
    private static final float STROKE_WIDTH = 2.5f;
    private static final float STROKE_WIDTH_LARGE = 3.0f;
    private Animation mAnimation;
    boolean mFinishing;
    private double mHeight;
    private View mParent;
    private Resources mResources;
    private float mRotation;
    private float mRotationCount;
    private double mWidth;
    private static final Interpolator LINEAR_INTERPOLATOR = new LinearInterpolator();
    private static final Interpolator END_CURVE_INTERPOLATOR = new EndCurveInterpolator();
    private static final Interpolator START_CURVE_INTERPOLATOR = new StartCurveInterpolator();
    private static final Interpolator EASE_INTERPOLATOR = new AccelerateDecelerateInterpolator();
    private final int[] COLORS = {ViewCompat.MEASURED_STATE_MASK};
    private final ArrayList<Animation> mAnimators = new ArrayList<>();
    private final Drawable.Callback mCallback = new Drawable.Callback() { // from class: android.support.v4.widget.MaterialProgressDrawable.3
        @Override // android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(Drawable d) {
            MaterialProgressDrawable.this.invalidateSelf();
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void scheduleDrawable(Drawable d, Runnable what, long when) {
            MaterialProgressDrawable.this.scheduleSelf(what, when);
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void unscheduleDrawable(Drawable d, Runnable what) {
            MaterialProgressDrawable.this.unscheduleSelf(what);
        }
    };
    private final Ring mRing = new Ring(this.mCallback);

    @Retention(RetentionPolicy.CLASS)
    @IntDef({0, PlaybackStateCompat.ACTION_STOP})
    /* loaded from: classes.dex */
    public @interface ProgressDrawableSize {
    }

    public MaterialProgressDrawable(Context context, View parent) {
        this.mParent = parent;
        this.mResources = context.getResources();
        this.mRing.setColors(this.COLORS);
        updateSizes(1);
        setupAnimators();
    }

    private void setSizeParameters(double progressCircleWidth, double progressCircleHeight, double centerRadius, double strokeWidth, float arrowWidth, float arrowHeight) {
        Ring ring = this.mRing;
        DisplayMetrics metrics = this.mResources.getDisplayMetrics();
        float screenDensity = metrics.density;
        this.mWidth = screenDensity * progressCircleWidth;
        this.mHeight = screenDensity * progressCircleHeight;
        ring.setStrokeWidth(((float) strokeWidth) * screenDensity);
        ring.setCenterRadius(screenDensity * centerRadius);
        ring.setColorIndex(0);
        ring.setArrowDimensions(arrowWidth * screenDensity, arrowHeight * screenDensity);
        ring.setInsets((int) this.mWidth, (int) this.mHeight);
    }

    public void updateSizes(@ProgressDrawableSize int size) {
        if (size == 0) {
            setSizeParameters(56.0d, 56.0d, 12.5d, 3.0d, 12.0f, 6.0f);
        } else {
            setSizeParameters(40.0d, 40.0d, 8.75d, 2.5d, 10.0f, 5.0f);
        }
    }

    public void showArrow(boolean show) {
        this.mRing.setShowArrow(show);
    }

    public void setArrowScale(float scale) {
        this.mRing.setArrowScale(scale);
    }

    public void setStartEndTrim(float startAngle, float endAngle) {
        this.mRing.setStartTrim(startAngle);
        this.mRing.setEndTrim(endAngle);
    }

    public void setProgressRotation(float rotation) {
        this.mRing.setRotation(rotation);
    }

    public void setBackgroundColor(int color) {
        this.mRing.setBackgroundColor(color);
    }

    public void setColorSchemeColors(int... colors) {
        this.mRing.setColors(colors);
        this.mRing.setColorIndex(0);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return (int) this.mHeight;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return (int) this.mWidth;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas c) {
        Rect bounds = getBounds();
        int saveCount = c.save();
        c.rotate(this.mRotation, bounds.exactCenterX(), bounds.exactCenterY());
        this.mRing.draw(c, bounds);
        c.restoreToCount(saveCount);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int alpha) {
        this.mRing.setAlpha(alpha);
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.mRing.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.mRing.setColorFilter(colorFilter);
    }

    void setRotation(float rotation) {
        this.mRotation = rotation;
        invalidateSelf();
    }

    private float getRotation() {
        return this.mRotation;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        ArrayList<Animation> animators = this.mAnimators;
        int N = animators.size();
        for (int i = 0; i < N; i++) {
            Animation animator = animators.get(i);
            if (animator.hasStarted() && !animator.hasEnded()) {
                return true;
            }
        }
        return false;
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        this.mAnimation.reset();
        this.mRing.storeOriginals();
        if (this.mRing.getEndTrim() != this.mRing.getStartTrim()) {
            this.mFinishing = true;
            this.mAnimation.setDuration(666L);
            this.mParent.startAnimation(this.mAnimation);
            return;
        }
        this.mRing.setColorIndex(0);
        this.mRing.resetOriginals();
        this.mAnimation.setDuration(1333L);
        this.mParent.startAnimation(this.mAnimation);
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        this.mParent.clearAnimation();
        setRotation(0.0f);
        this.mRing.setShowArrow(false);
        this.mRing.setColorIndex(0);
        this.mRing.resetOriginals();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void applyFinishTranslation(float interpolatedTime, Ring ring) {
        float targetRotation = (float) (Math.floor(ring.getStartingRotation() / MAX_PROGRESS_ARC) + 1.0d);
        float startTrim = ring.getStartingStartTrim() + ((ring.getStartingEndTrim() - ring.getStartingStartTrim()) * interpolatedTime);
        ring.setStartTrim(startTrim);
        float rotation = ring.getStartingRotation() + ((targetRotation - ring.getStartingRotation()) * interpolatedTime);
        ring.setRotation(rotation);
    }

    private void setupAnimators() {
        final Ring ring = this.mRing;
        Animation animation = new Animation() { // from class: android.support.v4.widget.MaterialProgressDrawable.1
            @Override // android.view.animation.Animation
            public void applyTransformation(float interpolatedTime, Transformation t) {
                if (MaterialProgressDrawable.this.mFinishing) {
                    MaterialProgressDrawable.this.applyFinishTranslation(interpolatedTime, ring);
                    return;
                }
                float minProgressArc = (float) Math.toRadians(ring.getStrokeWidth() / (6.283185307179586d * ring.getCenterRadius()));
                float startingEndTrim = ring.getStartingEndTrim();
                float startingTrim = ring.getStartingStartTrim();
                float startingRotation = ring.getStartingRotation();
                float minArc = MaterialProgressDrawable.MAX_PROGRESS_ARC - minProgressArc;
                float endTrim = startingEndTrim + (MaterialProgressDrawable.START_CURVE_INTERPOLATOR.getInterpolation(interpolatedTime) * minArc);
                ring.setEndTrim(endTrim);
                float startTrim = startingTrim + (MaterialProgressDrawable.MAX_PROGRESS_ARC * MaterialProgressDrawable.END_CURVE_INTERPOLATOR.getInterpolation(interpolatedTime));
                ring.setStartTrim(startTrim);
                float rotation = startingRotation + (0.25f * interpolatedTime);
                ring.setRotation(rotation);
                float groupRotation = (144.0f * interpolatedTime) + (720.0f * (MaterialProgressDrawable.this.mRotationCount / 5.0f));
                MaterialProgressDrawable.this.setRotation(groupRotation);
            }
        };
        animation.setRepeatCount(-1);
        animation.setRepeatMode(1);
        animation.setInterpolator(LINEAR_INTERPOLATOR);
        animation.setAnimationListener(new Animation.AnimationListener() { // from class: android.support.v4.widget.MaterialProgressDrawable.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation2) {
                MaterialProgressDrawable.this.mRotationCount = 0.0f;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation2) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation2) {
                ring.storeOriginals();
                ring.goToNextColor();
                ring.setStartTrim(ring.getEndTrim());
                if (MaterialProgressDrawable.this.mFinishing) {
                    MaterialProgressDrawable.this.mFinishing = false;
                    animation2.setDuration(1333L);
                    ring.setShowArrow(false);
                    return;
                }
                MaterialProgressDrawable.this.mRotationCount = (MaterialProgressDrawable.this.mRotationCount + 1.0f) % 5.0f;
            }
        });
        this.mAnimation = animation;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class Ring {
        private int mAlpha;
        private Path mArrow;
        private int mArrowHeight;
        private float mArrowScale;
        private int mArrowWidth;
        private int mBackgroundColor;
        private final Drawable.Callback mCallback;
        private int mColorIndex;
        private int[] mColors;
        private double mRingCenterRadius;
        private boolean mShowArrow;
        private float mStartingEndTrim;
        private float mStartingRotation;
        private float mStartingStartTrim;
        private final RectF mTempBounds = new RectF();
        private final Paint mPaint = new Paint();
        private final Paint mArrowPaint = new Paint();
        private float mStartTrim = 0.0f;
        private float mEndTrim = 0.0f;
        private float mRotation = 0.0f;
        private float mStrokeWidth = 5.0f;
        private float mStrokeInset = MaterialProgressDrawable.STROKE_WIDTH;
        private final Paint mCirclePaint = new Paint();

        public Ring(Drawable.Callback callback) {
            this.mCallback = callback;
            this.mPaint.setStrokeCap(Paint.Cap.SQUARE);
            this.mPaint.setAntiAlias(true);
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mArrowPaint.setStyle(Paint.Style.FILL);
            this.mArrowPaint.setAntiAlias(true);
        }

        public void setBackgroundColor(int color) {
            this.mBackgroundColor = color;
        }

        public void setArrowDimensions(float width, float height) {
            this.mArrowWidth = (int) width;
            this.mArrowHeight = (int) height;
        }

        public void draw(Canvas c, Rect bounds) {
            RectF arcBounds = this.mTempBounds;
            arcBounds.set(bounds);
            arcBounds.inset(this.mStrokeInset, this.mStrokeInset);
            float startAngle = (this.mStartTrim + this.mRotation) * 360.0f;
            float endAngle = (this.mEndTrim + this.mRotation) * 360.0f;
            float sweepAngle = endAngle - startAngle;
            this.mPaint.setColor(this.mColors[this.mColorIndex]);
            c.drawArc(arcBounds, startAngle, sweepAngle, false, this.mPaint);
            drawTriangle(c, startAngle, sweepAngle, bounds);
            if (this.mAlpha < 255) {
                this.mCirclePaint.setColor(this.mBackgroundColor);
                this.mCirclePaint.setAlpha(255 - this.mAlpha);
                c.drawCircle(bounds.exactCenterX(), bounds.exactCenterY(), bounds.width() / 2, this.mCirclePaint);
            }
        }

        private void drawTriangle(Canvas c, float startAngle, float sweepAngle, Rect bounds) {
            if (this.mShowArrow) {
                if (this.mArrow == null) {
                    this.mArrow = new Path();
                    this.mArrow.setFillType(Path.FillType.EVEN_ODD);
                } else {
                    this.mArrow.reset();
                }
                float inset = (((int) this.mStrokeInset) / 2) * this.mArrowScale;
                float x = (float) ((this.mRingCenterRadius * Math.cos(0.0d)) + bounds.exactCenterX());
                float y = (float) ((this.mRingCenterRadius * Math.sin(0.0d)) + bounds.exactCenterY());
                this.mArrow.moveTo(0.0f, 0.0f);
                this.mArrow.lineTo(this.mArrowWidth * this.mArrowScale, 0.0f);
                this.mArrow.lineTo((this.mArrowWidth * this.mArrowScale) / 2.0f, this.mArrowHeight * this.mArrowScale);
                this.mArrow.offset(x - inset, y);
                this.mArrow.close();
                this.mArrowPaint.setColor(this.mColors[this.mColorIndex]);
                c.rotate((startAngle + sweepAngle) - 5.0f, bounds.exactCenterX(), bounds.exactCenterY());
                c.drawPath(this.mArrow, this.mArrowPaint);
            }
        }

        public void setColors(@NonNull int[] colors) {
            this.mColors = colors;
            setColorIndex(0);
        }

        public void setColorIndex(int index) {
            this.mColorIndex = index;
        }

        public void goToNextColor() {
            this.mColorIndex = (this.mColorIndex + 1) % this.mColors.length;
        }

        public void setColorFilter(ColorFilter filter) {
            this.mPaint.setColorFilter(filter);
            invalidateSelf();
        }

        public void setAlpha(int alpha) {
            this.mAlpha = alpha;
        }

        public int getAlpha() {
            return this.mAlpha;
        }

        public void setStrokeWidth(float strokeWidth) {
            this.mStrokeWidth = strokeWidth;
            this.mPaint.setStrokeWidth(strokeWidth);
            invalidateSelf();
        }

        public float getStrokeWidth() {
            return this.mStrokeWidth;
        }

        public void setStartTrim(float startTrim) {
            this.mStartTrim = startTrim;
            invalidateSelf();
        }

        public float getStartTrim() {
            return this.mStartTrim;
        }

        public float getStartingStartTrim() {
            return this.mStartingStartTrim;
        }

        public float getStartingEndTrim() {
            return this.mStartingEndTrim;
        }

        public void setEndTrim(float endTrim) {
            this.mEndTrim = endTrim;
            invalidateSelf();
        }

        public float getEndTrim() {
            return this.mEndTrim;
        }

        public void setRotation(float rotation) {
            this.mRotation = rotation;
            invalidateSelf();
        }

        public float getRotation() {
            return this.mRotation;
        }

        public void setInsets(int width, int height) {
            float insets;
            float minEdge = Math.min(width, height);
            if (this.mRingCenterRadius <= 0.0d || minEdge < 0.0f) {
                insets = (float) Math.ceil(this.mStrokeWidth / 2.0f);
            } else {
                insets = (float) ((minEdge / 2.0f) - this.mRingCenterRadius);
            }
            this.mStrokeInset = insets;
        }

        public float getInsets() {
            return this.mStrokeInset;
        }

        public void setCenterRadius(double centerRadius) {
            this.mRingCenterRadius = centerRadius;
        }

        public double getCenterRadius() {
            return this.mRingCenterRadius;
        }

        public void setShowArrow(boolean show) {
            if (this.mShowArrow != show) {
                this.mShowArrow = show;
                invalidateSelf();
            }
        }

        public void setArrowScale(float scale) {
            if (scale != this.mArrowScale) {
                this.mArrowScale = scale;
                invalidateSelf();
            }
        }

        public float getStartingRotation() {
            return this.mStartingRotation;
        }

        public void storeOriginals() {
            this.mStartingStartTrim = this.mStartTrim;
            this.mStartingEndTrim = this.mEndTrim;
            this.mStartingRotation = this.mRotation;
        }

        public void resetOriginals() {
            this.mStartingStartTrim = 0.0f;
            this.mStartingEndTrim = 0.0f;
            this.mStartingRotation = 0.0f;
            setStartTrim(0.0f);
            setEndTrim(0.0f);
            setRotation(0.0f);
        }

        private void invalidateSelf() {
            this.mCallback.invalidateDrawable(null);
        }
    }

    /* loaded from: classes.dex */
    private static class EndCurveInterpolator extends AccelerateDecelerateInterpolator {
        private EndCurveInterpolator() {
        }

        @Override // android.view.animation.AccelerateDecelerateInterpolator, android.animation.TimeInterpolator
        public float getInterpolation(float input) {
            return super.getInterpolation(Math.max(0.0f, (input - 0.5f) * 2.0f));
        }
    }

    /* loaded from: classes.dex */
    private static class StartCurveInterpolator extends AccelerateDecelerateInterpolator {
        private StartCurveInterpolator() {
        }

        @Override // android.view.animation.AccelerateDecelerateInterpolator, android.animation.TimeInterpolator
        public float getInterpolation(float input) {
            return super.getInterpolation(Math.min(1.0f, 2.0f * input));
        }
    }
}