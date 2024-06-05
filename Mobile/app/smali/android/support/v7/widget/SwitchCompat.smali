.class public Landroid/support/v7/widget/SwitchCompat;
.super Landroid/widget/CompoundButton;
.source "SwitchCompat.java"


# static fields
.field private static final CHECKED_STATE_SET:[I

.field private static final MONOSPACE:I = 0x3

.field private static final SANS:I = 0x1

.field private static final SERIF:I = 0x2

.field private static final TEXT_APPEARANCE_ATTRS:[I

.field private static final THUMB_ANIMATION_DURATION:I = 0xfa

.field private static final TOUCH_MODE_DOWN:I = 0x1

.field private static final TOUCH_MODE_DRAGGING:I = 0x2

.field private static final TOUCH_MODE_IDLE:I


# instance fields
.field private mMinFlingVelocity:I

.field private mOffLayout:Landroid/text/Layout;

.field private mOnLayout:Landroid/text/Layout;

.field private mPositionAnimator:Landroid/view/animation/Animation;

.field private mShowText:Z

.field private mSplitTrack:Z

.field private mSwitchBottom:I

.field private mSwitchHeight:I

.field private mSwitchLeft:I

.field private mSwitchMinWidth:I

.field private mSwitchPadding:I

.field private mSwitchRight:I

.field private mSwitchTop:I

.field private mSwitchTransformationMethod:Landroid/text/method/TransformationMethod;

.field private mSwitchWidth:I

.field private final mTempRect:Landroid/graphics/Rect;

.field private mTextColors:Landroid/content/res/ColorStateList;

.field private mTextOff:Ljava/lang/CharSequence;

.field private mTextOn:Ljava/lang/CharSequence;

.field private mTextPaint:Landroid/text/TextPaint;

.field private mThumbDrawable:Landroid/graphics/drawable/Drawable;

.field private mThumbPosition:F

.field private mThumbTextPadding:I

.field private mThumbWidth:I

.field private final mTintManager:Landroid/support/v7/internal/widget/TintManager;

.field private mTouchMode:I

.field private mTouchSlop:I

.field private mTouchX:F

.field private mTouchY:F

.field private mTrackDrawable:Landroid/graphics/drawable/Drawable;

.field private mVelocityTracker:Landroid/view/VelocityTracker;


# direct methods
.method static constructor <clinit>()V
    .locals 5

    .prologue
    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 78
    const/4 v0, 0x3

    new-array v0, v0, [I

    const v1, 0x1010098

    aput v1, v0, v3

    const v1, 0x1010095

    aput v1, v0, v4

    const/4 v1, 0x2

    sget v2, Landroid/support/v7/appcompat/R$attr;->textAllCaps:I

    aput v2, v0, v1

    sput-object v0, Landroid/support/v7/widget/SwitchCompat;->TEXT_APPEARANCE_ATTRS:[I

    .line 150
    new-array v0, v4, [I

    const v1, 0x10100a0

    aput v1, v0, v3

    sput-object v0, Landroid/support/v7/widget/SwitchCompat;->CHECKED_STATE_SET:[I

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 160
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Landroid/support/v7/widget/SwitchCompat;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 161
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 171
    sget v0, Landroid/support/v7/appcompat/R$attr;->switchStyle:I

    invoke-direct {p0, p1, p2, v0}, Landroid/support/v7/widget/SwitchCompat;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 172
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 8
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;
    .param p3, "defStyleAttr"    # I

    .prologue
    const/4 v7, 0x1

    const/4 v6, 0x0

    .line 185
    invoke-direct {p0, p1, p2, p3}, Landroid/widget/CompoundButton;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 103
    invoke-static {}, Landroid/view/VelocityTracker;->obtain()Landroid/view/VelocityTracker;

    move-result-object v4

    iput-object v4, p0, Landroid/support/v7/widget/SwitchCompat;->mVelocityTracker:Landroid/view/VelocityTracker;

    .line 145
    new-instance v4, Landroid/graphics/Rect;

    invoke-direct {v4}, Landroid/graphics/Rect;-><init>()V

    iput-object v4, p0, Landroid/support/v7/widget/SwitchCompat;->mTempRect:Landroid/graphics/Rect;

    .line 187
    new-instance v4, Landroid/text/TextPaint;

    invoke-direct {v4, v7}, Landroid/text/TextPaint;-><init>(I)V

    iput-object v4, p0, Landroid/support/v7/widget/SwitchCompat;->mTextPaint:Landroid/text/TextPaint;

    .line 189
    invoke-virtual {p0}, Landroid/support/v7/widget/SwitchCompat;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    .line 190
    .local v3, "res":Landroid/content/res/Resources;
    iget-object v4, p0, Landroid/support/v7/widget/SwitchCompat;->mTextPaint:Landroid/text/TextPaint;

    invoke-virtual {v3}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v5

    iget v5, v5, Landroid/util/DisplayMetrics;->density:F

    iput v5, v4, Landroid/text/TextPaint;->density:F

    .line 192
    sget-object v4, Landroid/support/v7/appcompat/R$styleable;->SwitchCompat:[I

    invoke-static {p1, p2, v4, p3, v6}, Landroid/support/v7/internal/widget/TintTypedArray;->obtainStyledAttributes(Landroid/content/Context;Landroid/util/AttributeSet;[III)Landroid/support/v7/internal/widget/TintTypedArray;

    move-result-object v0

    .line 194
    .local v0, "a":Landroid/support/v7/internal/widget/TintTypedArray;
    sget v4, Landroid/support/v7/appcompat/R$styleable;->SwitchCompat_android_thumb:I

    invoke-virtual {v0, v4}, Landroid/support/v7/internal/widget/TintTypedArray;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v4

    iput-object v4, p0, Landroid/support/v7/widget/SwitchCompat;->mThumbDrawable:Landroid/graphics/drawable/Drawable;

    .line 195
    sget v4, Landroid/support/v7/appcompat/R$styleable;->SwitchCompat_track:I

    invoke-virtual {v0, v4}, Landroid/support/v7/internal/widget/TintTypedArray;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v4

    iput-object v4, p0, Landroid/support/v7/widget/SwitchCompat;->mTrackDrawable:Landroid/graphics/drawable/Drawable;

    .line 196
    sget v4, Landroid/support/v7/appcompat/R$styleable;->SwitchCompat_android_textOn:I

    invoke-virtual {v0, v4}, Landroid/support/v7/internal/widget/TintTypedArray;->getText(I)Ljava/lang/CharSequence;

    move-result-object v4

    iput-object v4, p0, Landroid/support/v7/widget/SwitchCompat;->mTextOn:Ljava/lang/CharSequence;

    .line 197
    sget v4, Landroid/support/v7/appcompat/R$styleable;->SwitchCompat_android_textOff:I

    invoke-virtual {v0, v4}, Landroid/support/v7/internal/widget/TintTypedArray;->getText(I)Ljava/lang/CharSequence;

    move-result-object v4

    iput-object v4, p0, Landroid/support/v7/widget/SwitchCompat;->mTextOff:Ljava/lang/CharSequence;

    .line 198
    sget v4, Landroid/support/v7/appcompat/R$styleable;->SwitchCompat_showText:I

    invoke-virtual {v0, v4, v7}, Landroid/support/v7/internal/widget/TintTypedArray;->getBoolean(IZ)Z

    move-result v4

    iput-boolean v4, p0, Landroid/support/v7/widget/SwitchCompat;->mShowText:Z

    .line 199
    sget v4, Landroid/support/v7/appcompat/R$styleable;->SwitchCompat_thumbTextPadding:I

    invoke-virtual {v0, v4, v6}, Landroid/support/v7/internal/widget/TintTypedArray;->getDimensionPixelSize(II)I

    move-result v4

    iput v4, p0, Landroid/support/v7/widget/SwitchCompat;->mThumbTextPadding:I

    .line 201
    sget v4, Landroid/support/v7/appcompat/R$styleable;->SwitchCompat_switchMinWidth:I

    invoke-virtual {v0, v4, v6}, Landroid/support/v7/internal/widget/TintTypedArray;->getDimensionPixelSize(II)I

    move-result v4

    iput v4, p0, Landroid/support/v7/widget/SwitchCompat;->mSwitchMinWidth:I

    .line 203
    sget v4, Landroid/support/v7/appcompat/R$styleable;->SwitchCompat_switchPadding:I

    invoke-virtual {v0, v4, v6}, Landroid/support/v7/internal/widget/TintTypedArray;->getDimensionPixelSize(II)I

    move-result v4

    iput v4, p0, Landroid/support/v7/widget/SwitchCompat;->mSwitchPadding:I

    .line 205
    sget v4, Landroid/support/v7/appcompat/R$styleable;->SwitchCompat_splitTrack:I

    invoke-virtual {v0, v4, v6}, Landroid/support/v7/internal/widget/TintTypedArray;->getBoolean(IZ)Z

    move-result v4

    iput-boolean v4, p0, Landroid/support/v7/widget/SwitchCompat;->mSplitTrack:Z

    .line 207
    sget v4, Landroid/support/v7/appcompat/R$styleable;->SwitchCompat_switchTextAppearance:I

    invoke-virtual {v0, v4, v6}, Landroid/support/v7/internal/widget/TintTypedArray;->getResourceId(II)I

    move-result v1

    .line 209
    .local v1, "appearance":I
    if-eqz v1, :cond_0

    .line 210
    invoke-virtual {p0, p1, v1}, Landroid/support/v7/widget/SwitchCompat;->setSwitchTextAppearance(Landroid/content/Context;I)V

    .line 213
    :cond_0
    invoke-virtual {v0}, Landroid/support/v7/internal/widget/TintTypedArray;->getTintManager()Landroid/support/v7/internal/widget/TintManager;

    move-result-object v4

    iput-object v4, p0, Landroid/support/v7/widget/SwitchCompat;->mTintManager:Landroid/support/v7/internal/widget/TintManager;

    .line 215
    invoke-virtual {v0}, Landroid/support/v7/internal/widget/TintTypedArray;->recycle()V

    .line 217
    invoke-static {p1}, Landroid/view/ViewConfiguration;->get(Landroid/content/Context;)Landroid/view/ViewConfiguration;

    move-result-object v2

    .line 218
    .local v2, "config":Landroid/view/ViewConfiguration;
    invoke-virtual {v2}, Landroid/view/ViewConfiguration;->getScaledTouchSlop()I

    move-result v4

    iput v4, p0, Landroid/support/v7/widget/SwitchCompat;->mTouchSlop:I

    .line 219
    invoke-virtual {v2}, Landroid/view/ViewConfiguration;->getScaledMinimumFlingVelocity()I

    move-result v4

    iput v4, p0, Landroid/support/v7/widget/SwitchCompat;->mMinFlingVelocity:I

    .line 222
    invoke-virtual {p0}, Landroid/support/v7/widget/SwitchCompat;->refreshDrawableState()V

    .line 223
    invoke-virtual {p0}, Landroid/support/v7/widget/SwitchCompat;->isChecked()Z

    move-result v4

    invoke-virtual {p0, v4}, Landroid/support/v7/widget/SwitchCompat;->setChecked(Z)V

    .line 224
    return-void
.end method

.method static synthetic access$000(Landroid/support/v7/widget/SwitchCompat;F)V
    .locals 0
    .param p0, "x0"    # Landroid/support/v7/widget/SwitchCompat;
    .param p1, "x1"    # F

    .prologue
    .line 71
    invoke-direct {p0, p1}, Landroid/support/v7/widget/SwitchCompat;->setThumbPosition(F)V

    return-void
.end method

.method private animateThumbToCheckedState(Z)V
    .locals 6
    .param p1, "newCheckedState"    # Z

    .prologue
    .line 706
    iget v1, p0, Landroid/support/v7/widget/SwitchCompat;->mThumbPosition:F

    .line 707
    .local v1, "startPosition":F
    if-eqz p1, :cond_0

    const/high16 v2, 0x3f800000    # 1.0f

    .line 708
    .local v2, "targetPosition":F
    :goto_0
    sub-float v0, v2, v1

    .line 710
    .local v0, "diff":F
    new-instance v3, Landroid/support/v7/widget/SwitchCompat$1;

    invoke-direct {v3, p0, v1, v0}, Landroid/support/v7/widget/SwitchCompat$1;-><init>(Landroid/support/v7/widget/SwitchCompat;FF)V

    iput-object v3, p0, Landroid/support/v7/widget/SwitchCompat;->mPositionAnimator:Landroid/view/animation/Animation;

    .line 716
    iget-object v3, p0, Landroid/support/v7/widget/SwitchCompat;->mPositionAnimator:Landroid/view/animation/Animation;

    const-wide/16 v4, 0xfa

    invoke-virtual {v3, v4, v5}, Landroid/view/animation/Animation;->setDuration(J)V

    .line 717
    iget-object v3, p0, Landroid/support/v7/widget/SwitchCompat;->mPositionAnimator:Landroid/view/animation/Animation;

    invoke-virtual {p0, v3}, Landroid/support/v7/widget/SwitchCompat;->startAnimation(Landroid/view/animation/Animation;)V

    .line 718
    return-void

    .line 707
    .end local v0    # "diff":F
    .end local v2    # "targetPosition":F
    :cond_0
    const/4 v2, 0x0

    goto :goto_0
.end method

.method private cancelPositionAnimator()V
    .locals 1

    .prologue
    .line 721
    iget-object v0, p0, Landroid/support/v7/widget/SwitchCompat;->mPositionAnimator:Landroid/view/animation/Animation;

    if-eqz v0, :cond_0

    .line 722
    invoke-virtual {p0}, Landroid/support/v7/widget/SwitchCompat;->clearAnimation()V

    .line 723
    const/4 v0, 0x0

    iput-object v0, p0, Landroid/support/v7/widget/SwitchCompat;->mPositionAnimator:Landroid/view/animation/Animation;

    .line 725
    :cond_0
    return-void
.end method

.method private cancelSuperTouch(Landroid/view/MotionEvent;)V
    .locals 2
    .param p1, "ev"    # Landroid/view/MotionEvent;

    .prologue
    .line 671
    invoke-static {p1}, Landroid/view/MotionEvent;->obtain(Landroid/view/MotionEvent;)Landroid/view/MotionEvent;

    move-result-object v0

    .line 672
    .local v0, "cancel":Landroid/view/MotionEvent;
    const/4 v1, 0x3

    invoke-virtual {v0, v1}, Landroid/view/MotionEvent;->setAction(I)V

    .line 673
    invoke-super {p0, v0}, Landroid/widget/CompoundButton;->onTouchEvent(Landroid/view/MotionEvent;)Z

    .line 674
    invoke-virtual {v0}, Landroid/view/MotionEvent;->recycle()V

    .line 675
    return-void
.end method

.method private static constrain(FFF)F
    .locals 1
    .param p0, "amount"    # F
    .param p1, "low"    # F
    .param p2, "high"    # F

    .prologue
    .line 1060
    cmpg-float v0, p0, p1

    if-gez v0, :cond_0

    .end local p1    # "low":F
    :goto_0
    return p1

    .restart local p1    # "low":F
    :cond_0
    cmpl-float v0, p0, p2

    if-lez v0, :cond_1

    move p1, p2

    goto :goto_0

    :cond_1
    move p1, p0

    goto :goto_0
.end method

.method private getTargetCheckedState()Z
    .locals 2

    .prologue
    .line 728
    iget v0, p0, Landroid/support/v7/widget/SwitchCompat;->mThumbPosition:F

    const/high16 v1, 0x3f000000    # 0.5f

    cmpl-float v0, v0, v1

    if-lez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private getThumbOffset()I
    .locals 3

    .prologue
    .line 947
    invoke-static {p0}, Landroid/support/v7/internal/widget/ViewUtils;->isLayoutRtl(Landroid/view/View;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 948
    const/high16 v1, 0x3f800000    # 1.0f

    iget v2, p0, Landroid/support/v7/widget/SwitchCompat;->mThumbPosition:F

    sub-float v0, v1, v2

    .line 952
    .local v0, "thumbPosition":F
    :goto_0
    invoke-direct {p0}, Landroid/support/v7/widget/SwitchCompat;->getThumbScrollRange()I

    move-result v1

    int-to-float v1, v1

    mul-float/2addr v1, v0

    const/high16 v2, 0x3f000000    # 0.5f

    add-float/2addr v1, v2

    float-to-int v1, v1

    return v1

    .line 950
    .end local v0    # "thumbPosition":F
    :cond_0
    iget v0, p0, Landroid/support/v7/widget/SwitchCompat;->mThumbPosition:F

    .restart local v0    # "thumbPosition":F
    goto :goto_0
.end method

.method private getThumbScrollRange()I
    .locals 3

    .prologue
    .line 956
    iget-object v1, p0, Landroid/support/v7/widget/SwitchCompat;->mTrackDrawable:Landroid/graphics/drawable/Drawable;

    if-eqz v1, :cond_0

    .line 957
    iget-object v0, p0, Landroid/support/v7/widget/SwitchCompat;->mTempRect:Landroid/graphics/Rect;

    .line 958
    .local v0, "padding":Landroid/graphics/Rect;
    iget-object v1, p0, Landroid/support/v7/widget/SwitchCompat;->mTrackDrawable:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v1, v0}, Landroid/graphics/drawable/Drawable;->getPadding(Landroid/graphics/Rect;)Z

    .line 959
    iget v1, p0, Landroid/support/v7/widget/SwitchCompat;->mSwitchWidth:I

    iget v2, p0, Landroid/support/v7/widget/SwitchCompat;->mThumbWidth:I

    sub-int/2addr v1, v2

    iget v2, v0, Landroid/graphics/Rect;->left:I

    sub-int/2addr v1, v2

    iget v2, v0, Landroid/graphics/Rect;->right:I

    sub-int/2addr v1, v2

    .line 961
    .end local v0    # "padding":Landroid/graphics/Rect;
    :goto_0
    return v1

    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

.method private hitThumb(FF)Z
    .locals 7
    .param p1, "x"    # F
    .param p2, "y"    # F

    .prologue
    .line 580
    invoke-direct {p0}, Landroid/support/v7/widget/SwitchCompat;->getThumbOffset()I

    move-result v2

    .line 582
    .local v2, "thumbOffset":I
    iget-object v5, p0, Landroid/support/v7/widget/SwitchCompat;->mThumbDrawable:Landroid/graphics/drawable/Drawable;

    iget-object v6, p0, Landroid/support/v7/widget/SwitchCompat;->mTempRect:Landroid/graphics/Rect;

    invoke-virtual {v5, v6}, Landroid/graphics/drawable/Drawable;->getPadding(Landroid/graphics/Rect;)Z

    .line 583
    iget v5, p0, Landroid/support/v7/widget/SwitchCompat;->mSwitchTop:I

    iget v6, p0, Landroid/support/v7/widget/SwitchCompat;->mTouchSlop:I

    sub-int v4, v5, v6

    .line 584
    .local v4, "thumbTop":I
    iget v5, p0, Landroid/support/v7/widget/SwitchCompat;->mSwitchLeft:I

    add-int/2addr v5, v2

    iget v6, p0, Landroid/support/v7/widget/SwitchCompat;->mTouchSlop:I

    sub-int v1, v5, v6

    .line 585
    .local v1, "thumbLeft":I
    iget v5, p0, Landroid/support/v7/widget/SwitchCompat;->mThumbWidth:I

    add-int/2addr v5, v1

    iget-object v6, p0, Landroid/support/v7/widget/SwitchCompat;->mTempRect:Landroid/graphics/Rect;

    iget v6, v6, Landroid/graphics/Rect;->left:I

    add-int/2addr v5, v6

    iget-object v6, p0, Landroid/support/v7/widget/SwitchCompat;->mTempRect:Landroid/graphics/Rect;

    iget v6, v6, Landroid/graphics/Rect;->right:I

    add-int/2addr v5, v6

    iget v6, p0, Landroid/support/v7/widget/SwitchCompat;->mTouchSlop:I

    add-int v3, v5, v6

    .line 587
    .local v3, "thumbRight":I
    iget v5, p0, Landroid/support/v7/widget/SwitchCompat;->mSwitchBottom:I

    iget v6, p0, Landroid/support/v7/widget/SwitchCompat;->mTouchSlop:I

    add-int v0, v5, v6

    .line 588
    .local v0, "thumbBottom":I
    int-to-float v5, v1

    cmpl-float v5, p1, v5

    if-lez v5, :cond_0

    int-to-float v5, v3

    cmpg-float v5, p1, v5

    if-gez v5, :cond_0

    int-to-float v5, v4

    cmpl-float v5, p2, v5

    if-lez v5, :cond_0

    int-to-float v5, v0

    cmpg-float v5, p2, v5

    if-gez v5, :cond_0

    const/4 v5, 0x1

    :goto_0
    return v5

    :cond_0
    const/4 v5, 0x0

    goto :goto_0
.end method

.method private makeLayout(Ljava/lang/CharSequence;)Landroid/text/Layout;
    .locals 8
    .param p1, "text"    # Ljava/lang/CharSequence;

    .prologue
    .line 566
    iget-object v0, p0, Landroid/support/v7/widget/SwitchCompat;->mSwitchTransformationMethod:Landroid/text/method/TransformationMethod;

    if-eqz v0, :cond_0

    iget-object v0, p0, Landroid/support/v7/widget/SwitchCompat;->mSwitchTransformationMethod:Landroid/text/method/TransformationMethod;

    invoke-interface {v0, p1, p0}, Landroid/text/method/TransformationMethod;->getTransformation(Ljava/lang/CharSequence;Landroid/view/View;)Ljava/lang/CharSequence;

    move-result-object v1

    .line 570
    .local v1, "transformed":Ljava/lang/CharSequence;
    :goto_0
    new-instance v0, Landroid/text/StaticLayout;

    iget-object v2, p0, Landroid/support/v7/widget/SwitchCompat;->mTextPaint:Landroid/text/TextPaint;

    iget-object v3, p0, Landroid/support/v7/widget/SwitchCompat;->mTextPaint:Landroid/text/TextPaint;

    invoke-static {v1, v3}, Landroid/text/Layout;->getDesiredWidth(Ljava/lang/CharSequence;Landroid/text/TextPaint;)F

    move-result v3

    float-to-double v4, v3

    invoke-static {v4, v5}, Ljava/lang/Math;->ceil(D)D

    move-result-wide v4

    double-to-int v3, v4

    sget-object v4, Landroid/text/Layout$Alignment;->ALIGN_NORMAL:Landroid/text/Layout$Alignment;

    const/high16 v5, 0x3f800000    # 1.0f

    const/4 v6, 0x0

    const/4 v7, 0x1

    invoke-direct/range {v0 .. v7}, Landroid/text/StaticLayout;-><init>(Ljava/lang/CharSequence;Landroid/text/TextPaint;ILandroid/text/Layout$Alignment;FFZ)V

    return-object v0

    .end local v1    # "transformed":Ljava/lang/CharSequence;
    :cond_0
    move-object v1, p1

    .line 566
    goto :goto_0
.end method

.method private setThumbPosition(F)V
    .locals 0
    .param p1, "position"    # F

    .prologue
    .line 737
    iput p1, p0, Landroid/support/v7/widget/SwitchCompat;->mThumbPosition:F

    .line 738
    invoke-virtual {p0}, Landroid/support/v7/widget/SwitchCompat;->invalidate()V

    .line 739
    return-void
.end method

.method private stopDrag(Landroid/view/MotionEvent;)V
    .locals 7
    .param p1, "ev"    # Landroid/view/MotionEvent;

    .prologue
    const/4 v6, 0x0

    const/4 v1, 0x1

    const/4 v3, 0x0

    .line 683
    iput v3, p0, Landroid/support/v7/widget/SwitchCompat;->mTouchMode:I

    .line 687
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getAction()I

    move-result v4

    if-ne v4, v1, :cond_1

    invoke-virtual {p0}, Landroid/support/v7/widget/SwitchCompat;->isEnabled()Z

    move-result v4

    if-eqz v4, :cond_1

    move v0, v1

    .line 689
    .local v0, "commitChange":Z
    :goto_0
    if-eqz v0, :cond_5

    .line 690
    iget-object v4, p0, Landroid/support/v7/widget/SwitchCompat;->mVelocityTracker:Landroid/view/VelocityTracker;

    const/16 v5, 0x3e8

    invoke-virtual {v4, v5}, Landroid/view/VelocityTracker;->computeCurrentVelocity(I)V

    .line 691
    iget-object v4, p0, Landroid/support/v7/widget/SwitchCompat;->mVelocityTracker:Landroid/view/VelocityTracker;

    invoke-virtual {v4}, Landroid/view/VelocityTracker;->getXVelocity()F

    move-result v2

    .line 692
    .local v2, "xvel":F
    invoke-static {v2}, Ljava/lang/Math;->abs(F)F

    move-result v4

    iget v5, p0, Landroid/support/v7/widget/SwitchCompat;->mMinFlingVelocity:I

    int-to-float v5, v5

    cmpl-float v4, v4, v5

    if-lez v4, :cond_4

    .line 693
    invoke-static {p0}, Landroid/support/v7/internal/widget/ViewUtils;->isLayoutRtl(Landroid/view/View;)Z

    move-result v4

    if-eqz v4, :cond_3

    cmpg-float v4, v2, v6

    if-gez v4, :cond_2

    .line 701
    .end local v2    # "xvel":F
    .local v1, "newState":Z
    :cond_0
    :goto_1
    invoke-virtual {p0, v1}, Landroid/support/v7/widget/SwitchCompat;->setChecked(Z)V

    .line 702
    invoke-direct {p0, p1}, Landroid/support/v7/widget/SwitchCompat;->cancelSuperTouch(Landroid/view/MotionEvent;)V

    .line 703
    return-void

    .end local v0    # "commitChange":Z
    .end local v1    # "newState":Z
    :cond_1
    move v0, v3

    .line 687
    goto :goto_0

    .restart local v0    # "commitChange":Z
    .restart local v2    # "xvel":F
    :cond_2
    move v1, v3

    .line 693
    goto :goto_1

    :cond_3
    cmpl-float v4, v2, v6

    if-gtz v4, :cond_0

    move v1, v3

    goto :goto_1

    .line 695
    :cond_4
    invoke-direct {p0}, Landroid/support/v7/widget/SwitchCompat;->getTargetCheckedState()Z

    move-result v1

    .restart local v1    # "newState":Z
    goto :goto_1

    .line 698
    .end local v1    # "newState":Z
    .end local v2    # "xvel":F
    :cond_5
    invoke-virtual {p0}, Landroid/support/v7/widget/SwitchCompat;->isChecked()Z

    move-result v1

    .restart local v1    # "newState":Z
    goto :goto_1
.end method


# virtual methods
.method public draw(Landroid/graphics/Canvas;)V
    .locals 15
    .param p1, "c"    # Landroid/graphics/Canvas;

    .prologue
    .line 820
    iget-object v1, p0, Landroid/support/v7/widget/SwitchCompat;->mTempRect:Landroid/graphics/Rect;

    .line 821
    .local v1, "padding":Landroid/graphics/Rect;
    iget v3, p0, Landroid/support/v7/widget/SwitchCompat;->mSwitchLeft:I

    .line 822
    .local v3, "switchLeft":I
    iget v5, p0, Landroid/support/v7/widget/SwitchCompat;->mSwitchTop:I

    .line 823
    .local v5, "switchTop":I
    iget v4, p0, Landroid/support/v7/widget/SwitchCompat;->mSwitchRight:I

    .line 824
    .local v4, "switchRight":I
    iget v2, p0, Landroid/support/v7/widget/SwitchCompat;->mSwitchBottom:I

    .line 826
    .local v2, "switchBottom":I
    invoke-direct {p0}, Landroid/support/v7/widget/SwitchCompat;->getThumbOffset()I

    move-result v13

    add-int v6, v3, v13

    .line 829
    .local v6, "thumbInitialLeft":I
    iget-object v13, p0, Landroid/support/v7/widget/SwitchCompat;->mTrackDrawable:Landroid/graphics/drawable/Drawable;

    if-eqz v13, :cond_0

    .line 830
    iget-object v13, p0, Landroid/support/v7/widget/SwitchCompat;->mTrackDrawable:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v13, v1}, Landroid/graphics/drawable/Drawable;->getPadding(Landroid/graphics/Rect;)Z

    .line 833
    iget v13, v1, Landroid/graphics/Rect;->left:I

    add-int/2addr v6, v13

    .line 836
    move v10, v3

    .line 837
    .local v10, "trackLeft":I
    move v12, v5

    .line 838
    .local v12, "trackTop":I
    move v11, v4

    .line 839
    .local v11, "trackRight":I
    move v9, v2

    .line 840
    .local v9, "trackBottom":I
    iget-object v13, p0, Landroid/support/v7/widget/SwitchCompat;->mTrackDrawable:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v13, v10, v12, v11, v9}, Landroid/graphics/drawable/Drawable;->setBounds(IIII)V

    .line 844
    .end local v9    # "trackBottom":I
    .end local v10    # "trackLeft":I
    .end local v11    # "trackRight":I
    .end local v12    # "trackTop":I
    :cond_0
    iget-object v13, p0, Landroid/support/v7/widget/SwitchCompat;->mThumbDrawable:Landroid/graphics/drawable/Drawable;

    if-eqz v13, :cond_1

    .line 845
    iget-object v13, p0, Landroid/support/v7/widget/SwitchCompat;->mThumbDrawable:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v13, v1}, Landroid/graphics/drawable/Drawable;->getPadding(Landroid/graphics/Rect;)Z

    .line 847
    iget v13, v1, Landroid/graphics/Rect;->left:I

    sub-int v7, v6, v13

    .line 848
    .local v7, "thumbLeft":I
    iget v13, p0, Landroid/support/v7/widget/SwitchCompat;->mThumbWidth:I

    add-int/2addr v13, v6

    iget v14, v1, Landroid/graphics/Rect;->right:I

    add-int v8, v13, v14

    .line 849
    .local v8, "thumbRight":I
    iget-object v13, p0, Landroid/support/v7/widget/SwitchCompat;->mThumbDrawable:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v13, v7, v5, v8, v2}, Landroid/graphics/drawable/Drawable;->setBounds(IIII)V

    .line 851
    invoke-virtual {p0}, Landroid/support/v7/widget/SwitchCompat;->getBackground()Landroid/graphics/drawable/Drawable;

    move-result-object v0

    .line 852
    .local v0, "background":Landroid/graphics/drawable/Drawable;
    if-eqz v0, :cond_1

    .line 853
    invoke-static {v0, v7, v5, v8, v2}, Landroid/support/v4/graphics/drawable/DrawableCompat;->setHotspotBounds(Landroid/graphics/drawable/Drawable;IIII)V

    .line 859
    .end local v0    # "background":Landroid/graphics/drawable/Drawable;
    .end local v7    # "thumbLeft":I
    .end local v8    # "thumbRight":I
    :cond_1
    invoke-super/range {p0 .. p1}, Landroid/widget/CompoundButton;->draw(Landroid/graphics/Canvas;)V

    .line 860
    return-void
.end method

.method public drawableHotspotChanged(FF)V
    .locals 1
    .param p1, "x"    # F
    .param p2, "y"    # F

    .prologue
    .line 993
    invoke-super {p0, p1, p2}, Landroid/widget/CompoundButton;->drawableHotspotChanged(FF)V

    .line 995
    iget-object v0, p0, Landroid/support/v7/widget/SwitchCompat;->mThumbDrawable:Landroid/graphics/drawable/Drawable;

    if-eqz v0, :cond_0

    .line 996
    iget-object v0, p0, Landroid/support/v7/widget/SwitchCompat;->mThumbDrawable:Landroid/graphics/drawable/Drawable;

    invoke-static {v0, p1, p2}, Landroid/support/v4/graphics/drawable/DrawableCompat;->setHotspot(Landroid/graphics/drawable/Drawable;FF)V

    .line 999
    :cond_0
    iget-object v0, p0, Landroid/support/v7/widget/SwitchCompat;->mTrackDrawable:Landroid/graphics/drawable/Drawable;

    if-eqz v0, :cond_1

    .line 1000
    iget-object v0, p0, Landroid/support/v7/widget/SwitchCompat;->mTrackDrawable:Landroid/graphics/drawable/Drawable;

    invoke-static {v0, p1, p2}, Landroid/support/v4/graphics/drawable/DrawableCompat;->setHotspot(Landroid/graphics/drawable/Drawable;FF)V

    .line 1002
    :cond_1
    return-void
.end method

.method protected drawableStateChanged()V
    .locals 2

    .prologue
    .line 976
    invoke-super {p0}, Landroid/widget/CompoundButton;->drawableStateChanged()V

    .line 978
    invoke-virtual {p0}, Landroid/support/v7/widget/SwitchCompat;->getDrawableState()[I

    move-result-object v0

    .line 980
    .local v0, "myDrawableState":[I
    iget-object v1, p0, Landroid/support/v7/widget/SwitchCompat;->mThumbDrawable:Landroid/graphics/drawable/Drawable;

    if-eqz v1, :cond_0

    .line 981
    iget-object v1, p0, Landroid/support/v7/widget/SwitchCompat;->mThumbDrawable:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v1, v0}, Landroid/graphics/drawable/Drawable;->setState([I)Z

    .line 984
    :cond_0
    iget-object v1, p0, Landroid/support/v7/widget/SwitchCompat;->mTrackDrawable:Landroid/graphics/drawable/Drawable;

    if-eqz v1, :cond_1

    .line 985
    iget-object v1, p0, Landroid/support/v7/widget/SwitchCompat;->mTrackDrawable:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v1, v0}, Landroid/graphics/drawable/Drawable;->setState([I)Z

    .line 988
    :cond_1
    invoke-virtual {p0}, Landroid/support/v7/widget/SwitchCompat;->invalidate()V

    .line 989
    return-void
.end method

.method public getCompoundPaddingLeft()I
    .locals 3

    .prologue
    .line 917
    invoke-static {p0}, Landroid/support/v7/internal/widget/ViewUtils;->isLayoutRtl(Landroid/view/View;)Z

    move-result v1

    if-nez v1, :cond_1

    .line 918
    invoke-super {p0}, Landroid/widget/CompoundButton;->getCompoundPaddingLeft()I

    move-result v0

    .line 924
    :cond_0
    :goto_0
    return v0

    .line 920
    :cond_1
    invoke-super {p0}, Landroid/widget/CompoundButton;->getCompoundPaddingLeft()I

    move-result v1

    iget v2, p0, Landroid/support/v7/widget/SwitchCompat;->mSwitchWidth:I

    add-int v0, v1, v2

    .line 921
    .local v0, "padding":I
    invoke-virtual {p0}, Landroid/support/v7/widget/SwitchCompat;->getText()Ljava/lang/CharSequence;

    move-result-object v1

    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 922
    iget v1, p0, Landroid/support/v7/widget/SwitchCompat;->mSwitchPadding:I

    add-int/2addr v0, v1

    goto :goto_0
.end method

.method public getCompoundPaddingRight()I
    .locals 3

    .prologue
    .line 929
    invoke-static {p0}, Landroid/support/v7/internal/widget/ViewUtils;->isLayoutRtl(Landroid/view/View;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 930
    invoke-super {p0}, Landroid/widget/CompoundButton;->getCompoundPaddingRight()I

    move-result v0

    .line 936
    :cond_0
    :goto_0
    return v0

    .line 932
    :cond_1
    invoke-super {p0}, Landroid/widget/CompoundButton;->getCompoundPaddingRight()I

    move-result v1

    iget v2, p0, Landroid/support/v7/widget/SwitchCompat;->mSwitchWidth:I

    add-int v0, v1, v2

    .line 933
    .local v0, "padding":I
    invoke-virtual {p0}, Landroid/support/v7/widget/SwitchCompat;->getText()Ljava/lang/CharSequence;

    move-result-object v1

    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 934
    iget v1, p0, Landroid/support/v7/widget/SwitchCompat;->mSwitchPadding:I

    add-int/2addr v0, v1

    goto :goto_0
.end method

.method public getShowText()Z
    .locals 1

    .prologue
    .line 488
    iget-boolean v0, p0, Landroid/support/v7/widget/SwitchCompat;->mShowText:Z

    return v0
.end method

.method public getSplitTrack()Z
    .locals 1

    .prologue
    .line 439
    iget-boolean v0, p0, Landroid/support/v7/widget/SwitchCompat;->mSplitTrack:Z

    return v0
.end method

.method public getSwitchMinWidth()I
    .locals 1

    .prologue
    .line 342
    iget v0, p0, Landroid/support/v7/widget/SwitchCompat;->mSwitchMinWidth:I

    return v0
.end method

.method public getSwitchPadding()I
    .locals 1

    .prologue
    .line 321
    iget v0, p0, Landroid/support/v7/widget/SwitchCompat;->mSwitchPadding:I

    return v0
.end method

.method public getTextOff()Ljava/lang/CharSequence;
    .locals 1

    .prologue
    .line 461
    iget-object v0, p0, Landroid/support/v7/widget/SwitchCompat;->mTextOff:Ljava/lang/CharSequence;

    return-object v0
.end method

.method public getTextOn()Ljava/lang/CharSequence;
    .locals 1

    .prologue
    .line 446
    iget-object v0, p0, Landroid/support/v7/widget/SwitchCompat;->mTextOn:Ljava/lang/CharSequence;

    return-object v0
.end method

.method public getThumbDrawable()Landroid/graphics/drawable/Drawable;
    .locals 1

    .prologue
    .line 420
    iget-object v0, p0, Landroid/support/v7/widget/SwitchCompat;->mThumbDrawable:Landroid/graphics/drawable/Drawable;

    return-object v0
.end method

.method public getThumbTextPadding()I
    .locals 1

    .prologue
    .line 361
    iget v0, p0, Landroid/support/v7/widget/SwitchCompat;->mThumbTextPadding:I

    return v0
.end method

.method public getTrackDrawable()Landroid/graphics/drawable/Drawable;
    .locals 1

    .prologue
    .line 389
    iget-object v0, p0, Landroid/support/v7/widget/SwitchCompat;->mTrackDrawable:Landroid/graphics/drawable/Drawable;

    return-object v0
.end method

.method public jumpDrawablesToCurrentState()V
    .locals 2

    .prologue
    .line 1011
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0xb

    if-lt v0, v1, :cond_2

    .line 1012
    invoke-super {p0}, Landroid/widget/CompoundButton;->jumpDrawablesToCurrentState()V

    .line 1014
    iget-object v0, p0, Landroid/support/v7/widget/SwitchCompat;->mThumbDrawable:Landroid/graphics/drawable/Drawable;

    if-eqz v0, :cond_0

    .line 1015
    iget-object v0, p0, Landroid/support/v7/widget/SwitchCompat;->mThumbDrawable:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v0}, Landroid/graphics/drawable/Drawable;->jumpToCurrentState()V

    .line 1018
    :cond_0
    iget-object v0, p0, Landroid/support/v7/widget/SwitchCompat;->mTrackDrawable:Landroid/graphics/drawable/Drawable;

    if-eqz v0, :cond_1

    .line 1019
    iget-object v0, p0, Landroid/support/v7/widget/SwitchCompat;->mTrackDrawable:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v0}, Landroid/graphics/drawable/Drawable;->jumpToCurrentState()V

    .line 1022
    :cond_1
    iget-object v0, p0, Landroid/support/v7/widget/SwitchCompat;->mPositionAnimator:Landroid/view/animation/Animation;

    if-eqz v0, :cond_2

    iget-object v0, p0, Landroid/support/v7/widget/SwitchCompat;->mPositionAnimator:Landroid/view/animation/Animation;

    invoke-virtual {v0}, Landroid/view/animation/Animation;->hasStarted()Z

    move-result v0

    if-eqz v0, :cond_2

    iget-object v0, p0, Landroid/support/v7/widget/SwitchCompat;->mPositionAnimator:Landroid/view/animation/Animation;

    invoke-virtual {v0}, Landroid/view/animation/Animation;->hasEnded()Z

    move-result v0

    if-nez v0, :cond_2

    .line 1024
    invoke-virtual {p0}, Landroid/support/v7/widget/SwitchCompat;->clearAnimation()V

    .line 1025
    const/4 v0, 0x0

    iput-object v0, p0, Landroid/support/v7/widget/SwitchCompat;->mPositionAnimator:Landroid/view/animation/Animation;

    .line 1028
    :cond_2
    return-void
.end method

.method protected onCreateDrawableState(I)[I
    .locals 2
    .param p1, "extraSpace"    # I

    .prologue
    .line 967
    add-int/lit8 v1, p1, 0x1

    invoke-super {p0, v1}, Landroid/widget/CompoundButton;->onCreateDrawableState(I)[I

    move-result-object v0

    .line 968
    .local v0, "drawableState":[I
    invoke-virtual {p0}, Landroid/support/v7/widget/SwitchCompat;->isChecked()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 969
    sget-object v1, Landroid/support/v7/widget/SwitchCompat;->CHECKED_STATE_SET:[I

    invoke-static {v0, v1}, Landroid/support/v7/widget/SwitchCompat;->mergeDrawableStates([I[I)[I

    .line 971
    :cond_0
    return-object v0
.end method

.method protected onDraw(Landroid/graphics/Canvas;)V
    .locals 20
    .param p1, "canvas"    # Landroid/graphics/Canvas;

    .prologue
    .line 864
    invoke-super/range {p0 .. p1}, Landroid/widget/CompoundButton;->onDraw(Landroid/graphics/Canvas;)V

    .line 866
    move-object/from16 v0, p0

    iget-object v7, v0, Landroid/support/v7/widget/SwitchCompat;->mTempRect:Landroid/graphics/Rect;

    .line 867
    .local v7, "padding":Landroid/graphics/Rect;
    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/support/v7/widget/SwitchCompat;->mTrackDrawable:Landroid/graphics/drawable/Drawable;

    move-object/from16 v16, v0

    .line 868
    .local v16, "trackDrawable":Landroid/graphics/drawable/Drawable;
    if-eqz v16, :cond_4

    .line 869
    move-object/from16 v0, v16

    invoke-virtual {v0, v7}, Landroid/graphics/drawable/Drawable;->getPadding(Landroid/graphics/Rect;)Z

    .line 874
    :goto_0
    move-object/from16 v0, p0

    iget v13, v0, Landroid/support/v7/widget/SwitchCompat;->mSwitchTop:I

    .line 875
    .local v13, "switchTop":I
    move-object/from16 v0, p0

    iget v9, v0, Landroid/support/v7/widget/SwitchCompat;->mSwitchBottom:I

    .line 876
    .local v9, "switchBottom":I
    iget v0, v7, Landroid/graphics/Rect;->top:I

    move/from16 v17, v0

    add-int v11, v13, v17

    .line 877
    .local v11, "switchInnerTop":I
    iget v0, v7, Landroid/graphics/Rect;->bottom:I

    move/from16 v17, v0

    sub-int v10, v9, v17

    .line 879
    .local v10, "switchInnerBottom":I
    move-object/from16 v0, p0

    iget-object v14, v0, Landroid/support/v7/widget/SwitchCompat;->mThumbDrawable:Landroid/graphics/drawable/Drawable;

    .line 880
    .local v14, "thumbDrawable":Landroid/graphics/drawable/Drawable;
    if-eqz v16, :cond_0

    .line 881
    move-object/from16 v0, v16

    move-object/from16 v1, p1

    invoke-virtual {v0, v1}, Landroid/graphics/drawable/Drawable;->draw(Landroid/graphics/Canvas;)V

    .line 884
    :cond_0
    invoke-virtual/range {p1 .. p1}, Landroid/graphics/Canvas;->save()I

    move-result v8

    .line 886
    .local v8, "saveCount":I
    if-eqz v14, :cond_1

    .line 887
    move-object/from16 v0, p1

    invoke-virtual {v14, v0}, Landroid/graphics/drawable/Drawable;->draw(Landroid/graphics/Canvas;)V

    .line 890
    :cond_1
    invoke-direct/range {p0 .. p0}, Landroid/support/v7/widget/SwitchCompat;->getTargetCheckedState()Z

    move-result v17

    if-eqz v17, :cond_5

    move-object/from16 v0, p0

    iget-object v12, v0, Landroid/support/v7/widget/SwitchCompat;->mOnLayout:Landroid/text/Layout;

    .line 891
    .local v12, "switchText":Landroid/text/Layout;
    :goto_1
    if-eqz v12, :cond_3

    .line 892
    invoke-virtual/range {p0 .. p0}, Landroid/support/v7/widget/SwitchCompat;->getDrawableState()[I

    move-result-object v5

    .line 893
    .local v5, "drawableState":[I
    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/support/v7/widget/SwitchCompat;->mTextColors:Landroid/content/res/ColorStateList;

    move-object/from16 v17, v0

    if-eqz v17, :cond_2

    .line 894
    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/support/v7/widget/SwitchCompat;->mTextPaint:Landroid/text/TextPaint;

    move-object/from16 v17, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/support/v7/widget/SwitchCompat;->mTextColors:Landroid/content/res/ColorStateList;

    move-object/from16 v18, v0

    const/16 v19, 0x0

    move-object/from16 v0, v18

    move/from16 v1, v19

    invoke-virtual {v0, v5, v1}, Landroid/content/res/ColorStateList;->getColorForState([II)I

    move-result v18

    invoke-virtual/range {v17 .. v18}, Landroid/text/TextPaint;->setColor(I)V

    .line 896
    :cond_2
    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/support/v7/widget/SwitchCompat;->mTextPaint:Landroid/text/TextPaint;

    move-object/from16 v17, v0

    move-object/from16 v0, v17

    iput-object v5, v0, Landroid/text/TextPaint;->drawableState:[I

    .line 899
    if-eqz v14, :cond_6

    .line 900
    invoke-virtual {v14}, Landroid/graphics/drawable/Drawable;->getBounds()Landroid/graphics/Rect;

    move-result-object v3

    .line 901
    .local v3, "bounds":Landroid/graphics/Rect;
    iget v0, v3, Landroid/graphics/Rect;->left:I

    move/from16 v17, v0

    iget v0, v3, Landroid/graphics/Rect;->right:I

    move/from16 v18, v0

    add-int v4, v17, v18

    .line 906
    .end local v3    # "bounds":Landroid/graphics/Rect;
    .local v4, "cX":I
    :goto_2
    div-int/lit8 v17, v4, 0x2

    invoke-virtual {v12}, Landroid/text/Layout;->getWidth()I

    move-result v18

    div-int/lit8 v18, v18, 0x2

    sub-int v6, v17, v18

    .line 907
    .local v6, "left":I
    add-int v17, v11, v10

    div-int/lit8 v17, v17, 0x2

    invoke-virtual {v12}, Landroid/text/Layout;->getHeight()I

    move-result v18

    div-int/lit8 v18, v18, 0x2

    sub-int v15, v17, v18

    .line 908
    .local v15, "top":I
    int-to-float v0, v6

    move/from16 v17, v0

    int-to-float v0, v15

    move/from16 v18, v0

    move-object/from16 v0, p1

    move/from16 v1, v17

    move/from16 v2, v18

    invoke-virtual {v0, v1, v2}, Landroid/graphics/Canvas;->translate(FF)V

    .line 909
    move-object/from16 v0, p1

    invoke-virtual {v12, v0}, Landroid/text/Layout;->draw(Landroid/graphics/Canvas;)V

    .line 912
    .end local v4    # "cX":I
    .end local v5    # "drawableState":[I
    .end local v6    # "left":I
    .end local v15    # "top":I
    :cond_3
    move-object/from16 v0, p1

    invoke-virtual {v0, v8}, Landroid/graphics/Canvas;->restoreToCount(I)V

    .line 913
    return-void

    .line 871
    .end local v8    # "saveCount":I
    .end local v9    # "switchBottom":I
    .end local v10    # "switchInnerBottom":I
    .end local v11    # "switchInnerTop":I
    .end local v12    # "switchText":Landroid/text/Layout;
    .end local v13    # "switchTop":I
    .end local v14    # "thumbDrawable":Landroid/graphics/drawable/Drawable;
    :cond_4
    invoke-virtual {v7}, Landroid/graphics/Rect;->setEmpty()V

    goto/16 :goto_0

    .line 890
    .restart local v8    # "saveCount":I
    .restart local v9    # "switchBottom":I
    .restart local v10    # "switchInnerBottom":I
    .restart local v11    # "switchInnerTop":I
    .restart local v13    # "switchTop":I
    .restart local v14    # "thumbDrawable":Landroid/graphics/drawable/Drawable;
    :cond_5
    move-object/from16 v0, p0

    iget-object v12, v0, Landroid/support/v7/widget/SwitchCompat;->mOffLayout:Landroid/text/Layout;

    goto :goto_1

    .line 903
    .restart local v5    # "drawableState":[I
    .restart local v12    # "switchText":Landroid/text/Layout;
    :cond_6
    invoke-virtual/range {p0 .. p0}, Landroid/support/v7/widget/SwitchCompat;->getWidth()I

    move-result v4

    .restart local v4    # "cX":I
    goto :goto_2
.end method

.method public onInitializeAccessibilityEvent(Landroid/view/accessibility/AccessibilityEvent;)V
    .locals 1
    .param p1, "event"    # Landroid/view/accessibility/AccessibilityEvent;
    .annotation build Landroid/annotation/TargetApi;
        value = 0xe
    .end annotation

    .prologue
    .line 1033
    invoke-super {p0, p1}, Landroid/widget/CompoundButton;->onInitializeAccessibilityEvent(Landroid/view/accessibility/AccessibilityEvent;)V

    .line 1034
    const-class v0, Landroid/support/v7/widget/SwitchCompat;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/view/accessibility/AccessibilityEvent;->setClassName(Ljava/lang/CharSequence;)V

    .line 1035
    return-void
.end method

.method public onInitializeAccessibilityNodeInfo(Landroid/view/accessibility/AccessibilityNodeInfo;)V
    .locals 5
    .param p1, "info"    # Landroid/view/accessibility/AccessibilityNodeInfo;

    .prologue
    .line 1039
    sget v3, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v4, 0xe

    if-lt v3, v4, :cond_0

    .line 1040
    invoke-super {p0, p1}, Landroid/widget/CompoundButton;->onInitializeAccessibilityNodeInfo(Landroid/view/accessibility/AccessibilityNodeInfo;)V

    .line 1041
    const-class v3, Landroid/support/v7/widget/SwitchCompat;

    invoke-virtual {v3}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p1, v3}, Landroid/view/accessibility/AccessibilityNodeInfo;->setClassName(Ljava/lang/CharSequence;)V

    .line 1042
    invoke-virtual {p0}, Landroid/support/v7/widget/SwitchCompat;->isChecked()Z

    move-result v3

    if-eqz v3, :cond_1

    iget-object v2, p0, Landroid/support/v7/widget/SwitchCompat;->mTextOn:Ljava/lang/CharSequence;

    .line 1043
    .local v2, "switchText":Ljava/lang/CharSequence;
    :goto_0
    invoke-static {v2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_0

    .line 1044
    invoke-virtual {p1}, Landroid/view/accessibility/AccessibilityNodeInfo;->getText()Ljava/lang/CharSequence;

    move-result-object v1

    .line 1045
    .local v1, "oldText":Ljava/lang/CharSequence;
    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-eqz v3, :cond_2

    .line 1046
    invoke-virtual {p1, v2}, Landroid/view/accessibility/AccessibilityNodeInfo;->setText(Ljava/lang/CharSequence;)V

    .line 1054
    .end local v1    # "oldText":Ljava/lang/CharSequence;
    .end local v2    # "switchText":Ljava/lang/CharSequence;
    :cond_0
    :goto_1
    return-void

    .line 1042
    :cond_1
    iget-object v2, p0, Landroid/support/v7/widget/SwitchCompat;->mTextOff:Ljava/lang/CharSequence;

    goto :goto_0

    .line 1048
    .restart local v1    # "oldText":Ljava/lang/CharSequence;
    .restart local v2    # "switchText":Ljava/lang/CharSequence;
    :cond_2
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    .line 1049
    .local v0, "newText":Ljava/lang/StringBuilder;
    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/CharSequence;)Ljava/lang/StringBuilder;

    move-result-object v3

    const/16 v4, 0x20

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/CharSequence;)Ljava/lang/StringBuilder;

    .line 1050
    invoke-virtual {p1, v0}, Landroid/view/accessibility/AccessibilityNodeInfo;->setText(Ljava/lang/CharSequence;)V

    goto :goto_1
.end method

.method protected onLayout(ZIIII)V
    .locals 9
    .param p1, "changed"    # Z
    .param p2, "left"    # I
    .param p3, "top"    # I
    .param p4, "right"    # I
    .param p5, "bottom"    # I

    .prologue
    .line 765
    invoke-super/range {p0 .. p5}, Landroid/widget/CompoundButton;->onLayout(ZIIII)V

    .line 767
    const/4 v0, 0x0

    .line 768
    .local v0, "opticalInsetLeft":I
    const/4 v1, 0x0

    .line 769
    .local v1, "opticalInsetRight":I
    iget-object v7, p0, Landroid/support/v7/widget/SwitchCompat;->mThumbDrawable:Landroid/graphics/drawable/Drawable;

    if-eqz v7, :cond_0

    .line 770
    iget-object v6, p0, Landroid/support/v7/widget/SwitchCompat;->mTempRect:Landroid/graphics/Rect;

    .line 771
    .local v6, "trackPadding":Landroid/graphics/Rect;
    iget-object v7, p0, Landroid/support/v7/widget/SwitchCompat;->mTrackDrawable:Landroid/graphics/drawable/Drawable;

    if-eqz v7, :cond_1

    .line 772
    iget-object v7, p0, Landroid/support/v7/widget/SwitchCompat;->mTrackDrawable:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v7, v6}, Landroid/graphics/drawable/Drawable;->getPadding(Landroid/graphics/Rect;)Z

    .line 777
    :goto_0
    const/4 v0, 0x0

    .line 778
    const/4 v1, 0x0

    .line 783
    .end local v6    # "trackPadding":Landroid/graphics/Rect;
    :cond_0
    invoke-static {p0}, Landroid/support/v7/internal/widget/ViewUtils;->isLayoutRtl(Landroid/view/View;)Z

    move-result v7

    if-eqz v7, :cond_2

    .line 784
    invoke-virtual {p0}, Landroid/support/v7/widget/SwitchCompat;->getPaddingLeft()I

    move-result v7

    add-int/lit8 v3, v7, 0x0

    .line 785
    .local v3, "switchLeft":I
    iget v7, p0, Landroid/support/v7/widget/SwitchCompat;->mSwitchWidth:I

    add-int/2addr v7, v3

    add-int/lit8 v7, v7, 0x0

    add-int/lit8 v4, v7, 0x0

    .line 793
    .local v4, "switchRight":I
    :goto_1
    invoke-virtual {p0}, Landroid/support/v7/widget/SwitchCompat;->getGravity()I

    move-result v7

    and-int/lit8 v7, v7, 0x70

    sparse-switch v7, :sswitch_data_0

    .line 796
    invoke-virtual {p0}, Landroid/support/v7/widget/SwitchCompat;->getPaddingTop()I

    move-result v5

    .line 797
    .local v5, "switchTop":I
    iget v7, p0, Landroid/support/v7/widget/SwitchCompat;->mSwitchHeight:I

    add-int v2, v5, v7

    .line 812
    .local v2, "switchBottom":I
    :goto_2
    iput v3, p0, Landroid/support/v7/widget/SwitchCompat;->mSwitchLeft:I

    .line 813
    iput v5, p0, Landroid/support/v7/widget/SwitchCompat;->mSwitchTop:I

    .line 814
    iput v2, p0, Landroid/support/v7/widget/SwitchCompat;->mSwitchBottom:I

    .line 815
    iput v4, p0, Landroid/support/v7/widget/SwitchCompat;->mSwitchRight:I

    .line 816
    return-void

    .line 774
    .end local v2    # "switchBottom":I
    .end local v3    # "switchLeft":I
    .end local v4    # "switchRight":I
    .end local v5    # "switchTop":I
    .restart local v6    # "trackPadding":Landroid/graphics/Rect;
    :cond_1
    invoke-virtual {v6}, Landroid/graphics/Rect;->setEmpty()V

    goto :goto_0

    .line 787
    .end local v6    # "trackPadding":Landroid/graphics/Rect;
    :cond_2
    invoke-virtual {p0}, Landroid/support/v7/widget/SwitchCompat;->getWidth()I

    move-result v7

    invoke-virtual {p0}, Landroid/support/v7/widget/SwitchCompat;->getPaddingRight()I

    move-result v8

    sub-int/2addr v7, v8

    add-int/lit8 v4, v7, 0x0

    .line 788
    .restart local v4    # "switchRight":I
    iget v7, p0, Landroid/support/v7/widget/SwitchCompat;->mSwitchWidth:I

    sub-int v7, v4, v7

    add-int/lit8 v7, v7, 0x0

    add-int/lit8 v3, v7, 0x0

    .restart local v3    # "switchLeft":I
    goto :goto_1

    .line 801
    :sswitch_0
    invoke-virtual {p0}, Landroid/support/v7/widget/SwitchCompat;->getPaddingTop()I

    move-result v7

    invoke-virtual {p0}, Landroid/support/v7/widget/SwitchCompat;->getHeight()I

    move-result v8

    add-int/2addr v7, v8

    invoke-virtual {p0}, Landroid/support/v7/widget/SwitchCompat;->getPaddingBottom()I

    move-result v8

    sub-int/2addr v7, v8

    div-int/lit8 v7, v7, 0x2

    iget v8, p0, Landroid/support/v7/widget/SwitchCompat;->mSwitchHeight:I

    div-int/lit8 v8, v8, 0x2

    sub-int v5, v7, v8

    .line 803
    .restart local v5    # "switchTop":I
    iget v7, p0, Landroid/support/v7/widget/SwitchCompat;->mSwitchHeight:I

    add-int v2, v5, v7

    .line 804
    .restart local v2    # "switchBottom":I
    goto :goto_2

    .line 807
    .end local v2    # "switchBottom":I
    .end local v5    # "switchTop":I
    :sswitch_1
    invoke-virtual {p0}, Landroid/support/v7/widget/SwitchCompat;->getHeight()I

    move-result v7

    invoke-virtual {p0}, Landroid/support/v7/widget/SwitchCompat;->getPaddingBottom()I

    move-result v8

    sub-int v2, v7, v8

    .line 808
    .restart local v2    # "switchBottom":I
    iget v7, p0, Landroid/support/v7/widget/SwitchCompat;->mSwitchHeight:I

    sub-int v5, v2, v7

    .restart local v5    # "switchTop":I
    goto :goto_2

    .line 793
    nop

    :sswitch_data_0
    .sparse-switch
        0x10 -> :sswitch_0
        0x50 -> :sswitch_1
    .end sparse-switch
.end method

.method public onMeasure(II)V
    .locals 12
    .param p1, "widthMeasureSpec"    # I
    .param p2, "heightMeasureSpec"    # I

    .prologue
    .line 493
    iget-boolean v10, p0, Landroid/support/v7/widget/SwitchCompat;->mShowText:Z

    if-eqz v10, :cond_1

    .line 494
    iget-object v10, p0, Landroid/support/v7/widget/SwitchCompat;->mOnLayout:Landroid/text/Layout;

    if-nez v10, :cond_0

    .line 495
    iget-object v10, p0, Landroid/support/v7/widget/SwitchCompat;->mTextOn:Ljava/lang/CharSequence;

    invoke-direct {p0, v10}, Landroid/support/v7/widget/SwitchCompat;->makeLayout(Ljava/lang/CharSequence;)Landroid/text/Layout;

    move-result-object v10

    iput-object v10, p0, Landroid/support/v7/widget/SwitchCompat;->mOnLayout:Landroid/text/Layout;

    .line 498
    :cond_0
    iget-object v10, p0, Landroid/support/v7/widget/SwitchCompat;->mOffLayout:Landroid/text/Layout;

    if-nez v10, :cond_1

    .line 499
    iget-object v10, p0, Landroid/support/v7/widget/SwitchCompat;->mTextOff:Ljava/lang/CharSequence;

    invoke-direct {p0, v10}, Landroid/support/v7/widget/SwitchCompat;->makeLayout(Ljava/lang/CharSequence;)Landroid/text/Layout;

    move-result-object v10

    iput-object v10, p0, Landroid/support/v7/widget/SwitchCompat;->mOffLayout:Landroid/text/Layout;

    .line 503
    :cond_1
    iget-object v2, p0, Landroid/support/v7/widget/SwitchCompat;->mTempRect:Landroid/graphics/Rect;

    .line 506
    .local v2, "padding":Landroid/graphics/Rect;
    iget-object v10, p0, Landroid/support/v7/widget/SwitchCompat;->mThumbDrawable:Landroid/graphics/drawable/Drawable;

    if-eqz v10, :cond_3

    .line 508
    iget-object v10, p0, Landroid/support/v7/widget/SwitchCompat;->mThumbDrawable:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v10, v2}, Landroid/graphics/drawable/Drawable;->getPadding(Landroid/graphics/Rect;)Z

    .line 509
    iget-object v10, p0, Landroid/support/v7/widget/SwitchCompat;->mThumbDrawable:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v10}, Landroid/graphics/drawable/Drawable;->getIntrinsicWidth()I

    move-result v10

    iget v11, v2, Landroid/graphics/Rect;->left:I

    sub-int/2addr v10, v11

    iget v11, v2, Landroid/graphics/Rect;->right:I

    sub-int v8, v10, v11

    .line 510
    .local v8, "thumbWidth":I
    iget-object v10, p0, Landroid/support/v7/widget/SwitchCompat;->mThumbDrawable:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v10}, Landroid/graphics/drawable/Drawable;->getIntrinsicHeight()I

    move-result v7

    .line 517
    .local v7, "thumbHeight":I
    :goto_0
    iget-boolean v10, p0, Landroid/support/v7/widget/SwitchCompat;->mShowText:Z

    if-eqz v10, :cond_4

    .line 518
    iget-object v10, p0, Landroid/support/v7/widget/SwitchCompat;->mOnLayout:Landroid/text/Layout;

    invoke-virtual {v10}, Landroid/text/Layout;->getWidth()I

    move-result v10

    iget-object v11, p0, Landroid/support/v7/widget/SwitchCompat;->mOffLayout:Landroid/text/Layout;

    invoke-virtual {v11}, Landroid/text/Layout;->getWidth()I

    move-result v11

    invoke-static {v10, v11}, Ljava/lang/Math;->max(II)I

    move-result v10

    iget v11, p0, Landroid/support/v7/widget/SwitchCompat;->mThumbTextPadding:I

    mul-int/lit8 v11, v11, 0x2

    add-int v0, v10, v11

    .line 524
    .local v0, "maxTextWidth":I
    :goto_1
    invoke-static {v0, v8}, Ljava/lang/Math;->max(II)I

    move-result v10

    iput v10, p0, Landroid/support/v7/widget/SwitchCompat;->mThumbWidth:I

    .line 527
    iget-object v10, p0, Landroid/support/v7/widget/SwitchCompat;->mTrackDrawable:Landroid/graphics/drawable/Drawable;

    if-eqz v10, :cond_5

    .line 528
    iget-object v10, p0, Landroid/support/v7/widget/SwitchCompat;->mTrackDrawable:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v10, v2}, Landroid/graphics/drawable/Drawable;->getPadding(Landroid/graphics/Rect;)Z

    .line 529
    iget-object v10, p0, Landroid/support/v7/widget/SwitchCompat;->mTrackDrawable:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v10}, Landroid/graphics/drawable/Drawable;->getIntrinsicHeight()I

    move-result v9

    .line 537
    .local v9, "trackHeight":I
    :goto_2
    iget v3, v2, Landroid/graphics/Rect;->left:I

    .line 538
    .local v3, "paddingLeft":I
    iget v4, v2, Landroid/graphics/Rect;->right:I

    .line 540
    .local v4, "paddingRight":I
    iget v10, p0, Landroid/support/v7/widget/SwitchCompat;->mSwitchMinWidth:I

    iget v11, p0, Landroid/support/v7/widget/SwitchCompat;->mThumbWidth:I

    mul-int/lit8 v11, v11, 0x2

    add-int/2addr v11, v3

    add-int/2addr v11, v4

    invoke-static {v10, v11}, Ljava/lang/Math;->max(II)I

    move-result v6

    .line 542
    .local v6, "switchWidth":I
    invoke-static {v9, v7}, Ljava/lang/Math;->max(II)I

    move-result v5

    .line 543
    .local v5, "switchHeight":I
    iput v6, p0, Landroid/support/v7/widget/SwitchCompat;->mSwitchWidth:I

    .line 544
    iput v5, p0, Landroid/support/v7/widget/SwitchCompat;->mSwitchHeight:I

    .line 546
    invoke-super {p0, p1, p2}, Landroid/widget/CompoundButton;->onMeasure(II)V

    .line 548
    invoke-virtual {p0}, Landroid/support/v7/widget/SwitchCompat;->getMeasuredHeight()I

    move-result v1

    .line 549
    .local v1, "measuredHeight":I
    if-ge v1, v5, :cond_2

    .line 550
    invoke-static {p0}, Landroid/support/v4/view/ViewCompat;->getMeasuredWidthAndState(Landroid/view/View;)I

    move-result v10

    invoke-virtual {p0, v10, v5}, Landroid/support/v7/widget/SwitchCompat;->setMeasuredDimension(II)V

    .line 552
    :cond_2
    return-void

    .line 512
    .end local v0    # "maxTextWidth":I
    .end local v1    # "measuredHeight":I
    .end local v3    # "paddingLeft":I
    .end local v4    # "paddingRight":I
    .end local v5    # "switchHeight":I
    .end local v6    # "switchWidth":I
    .end local v7    # "thumbHeight":I
    .end local v8    # "thumbWidth":I
    .end local v9    # "trackHeight":I
    :cond_3
    const/4 v8, 0x0

    .line 513
    .restart local v8    # "thumbWidth":I
    const/4 v7, 0x0

    .restart local v7    # "thumbHeight":I
    goto :goto_0

    .line 521
    :cond_4
    const/4 v0, 0x0

    .restart local v0    # "maxTextWidth":I
    goto :goto_1

    .line 531
    :cond_5
    invoke-virtual {v2}, Landroid/graphics/Rect;->setEmpty()V

    .line 532
    const/4 v9, 0x0

    .restart local v9    # "trackHeight":I
    goto :goto_2
.end method

.method public onPopulateAccessibilityEvent(Landroid/view/accessibility/AccessibilityEvent;)V
    .locals 2
    .param p1, "event"    # Landroid/view/accessibility/AccessibilityEvent;
    .annotation build Landroid/annotation/TargetApi;
        value = 0xe
    .end annotation

    .prologue
    .line 557
    invoke-super {p0, p1}, Landroid/widget/CompoundButton;->onPopulateAccessibilityEvent(Landroid/view/accessibility/AccessibilityEvent;)V

    .line 559
    invoke-virtual {p0}, Landroid/support/v7/widget/SwitchCompat;->isChecked()Z

    move-result v1

    if-eqz v1, :cond_1

    iget-object v0, p0, Landroid/support/v7/widget/SwitchCompat;->mTextOn:Ljava/lang/CharSequence;

    .line 560
    .local v0, "text":Ljava/lang/CharSequence;
    :goto_0
    if-eqz v0, :cond_0

    .line 561
    invoke-virtual {p1}, Landroid/view/accessibility/AccessibilityEvent;->getText()Ljava/util/List;

    move-result-object v1

    invoke-interface {v1, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 563
    :cond_0
    return-void

    .line 559
    .end local v0    # "text":Ljava/lang/CharSequence;
    :cond_1
    iget-object v0, p0, Landroid/support/v7/widget/SwitchCompat;->mTextOff:Ljava/lang/CharSequence;

    goto :goto_0
.end method

.method public onTouchEvent(Landroid/view/MotionEvent;)Z
    .locals 12
    .param p1, "ev"    # Landroid/view/MotionEvent;

    .prologue
    const/4 v11, 0x2

    const/high16 v7, 0x3f800000    # 1.0f

    const/4 v10, 0x0

    const/4 v8, 0x1

    .line 593
    iget-object v9, p0, Landroid/support/v7/widget/SwitchCompat;->mVelocityTracker:Landroid/view/VelocityTracker;

    invoke-virtual {v9, p1}, Landroid/view/VelocityTracker;->addMovement(Landroid/view/MotionEvent;)V

    .line 594
    invoke-static {p1}, Landroid/support/v4/view/MotionEventCompat;->getActionMasked(Landroid/view/MotionEvent;)I

    move-result v0

    .line 595
    .local v0, "action":I
    packed-switch v0, :pswitch_data_0

    .line 667
    :cond_0
    :goto_0
    :pswitch_0
    invoke-super {p0, p1}, Landroid/widget/CompoundButton;->onTouchEvent(Landroid/view/MotionEvent;)Z

    move-result v7

    :goto_1
    return v7

    .line 597
    :pswitch_1
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v5

    .line 598
    .local v5, "x":F
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v6

    .line 599
    .local v6, "y":F
    invoke-virtual {p0}, Landroid/support/v7/widget/SwitchCompat;->isEnabled()Z

    move-result v7

    if-eqz v7, :cond_0

    invoke-direct {p0, v5, v6}, Landroid/support/v7/widget/SwitchCompat;->hitThumb(FF)Z

    move-result v7

    if-eqz v7, :cond_0

    .line 600
    iput v8, p0, Landroid/support/v7/widget/SwitchCompat;->mTouchMode:I

    .line 601
    iput v5, p0, Landroid/support/v7/widget/SwitchCompat;->mTouchX:F

    .line 602
    iput v6, p0, Landroid/support/v7/widget/SwitchCompat;->mTouchY:F

    goto :goto_0

    .line 608
    .end local v5    # "x":F
    .end local v6    # "y":F
    :pswitch_2
    iget v9, p0, Landroid/support/v7/widget/SwitchCompat;->mTouchMode:I

    packed-switch v9, :pswitch_data_1

    goto :goto_0

    .line 614
    :pswitch_3
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v5

    .line 615
    .restart local v5    # "x":F
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v6

    .line 616
    .restart local v6    # "y":F
    iget v7, p0, Landroid/support/v7/widget/SwitchCompat;->mTouchX:F

    sub-float v7, v5, v7

    invoke-static {v7}, Ljava/lang/Math;->abs(F)F

    move-result v7

    iget v9, p0, Landroid/support/v7/widget/SwitchCompat;->mTouchSlop:I

    int-to-float v9, v9

    cmpl-float v7, v7, v9

    if-gtz v7, :cond_1

    iget v7, p0, Landroid/support/v7/widget/SwitchCompat;->mTouchY:F

    sub-float v7, v6, v7

    invoke-static {v7}, Ljava/lang/Math;->abs(F)F

    move-result v7

    iget v9, p0, Landroid/support/v7/widget/SwitchCompat;->mTouchSlop:I

    int-to-float v9, v9

    cmpl-float v7, v7, v9

    if-lez v7, :cond_0

    .line 618
    :cond_1
    iput v11, p0, Landroid/support/v7/widget/SwitchCompat;->mTouchMode:I

    .line 619
    invoke-virtual {p0}, Landroid/support/v7/widget/SwitchCompat;->getParent()Landroid/view/ViewParent;

    move-result-object v7

    invoke-interface {v7, v8}, Landroid/view/ViewParent;->requestDisallowInterceptTouchEvent(Z)V

    .line 620
    iput v5, p0, Landroid/support/v7/widget/SwitchCompat;->mTouchX:F

    .line 621
    iput v6, p0, Landroid/support/v7/widget/SwitchCompat;->mTouchY:F

    move v7, v8

    .line 622
    goto :goto_1

    .line 628
    .end local v5    # "x":F
    .end local v6    # "y":F
    :pswitch_4
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v5

    .line 629
    .restart local v5    # "x":F
    invoke-direct {p0}, Landroid/support/v7/widget/SwitchCompat;->getThumbScrollRange()I

    move-result v4

    .line 630
    .local v4, "thumbScrollRange":I
    iget v9, p0, Landroid/support/v7/widget/SwitchCompat;->mTouchX:F

    sub-float v3, v5, v9

    .line 632
    .local v3, "thumbScrollOffset":F
    if-eqz v4, :cond_4

    .line 633
    int-to-float v9, v4

    div-float v1, v3, v9

    .line 639
    .local v1, "dPos":F
    :goto_2
    invoke-static {p0}, Landroid/support/v7/internal/widget/ViewUtils;->isLayoutRtl(Landroid/view/View;)Z

    move-result v9

    if-eqz v9, :cond_2

    .line 640
    neg-float v1, v1

    .line 642
    :cond_2
    iget v9, p0, Landroid/support/v7/widget/SwitchCompat;->mThumbPosition:F

    add-float/2addr v9, v1

    invoke-static {v9, v10, v7}, Landroid/support/v7/widget/SwitchCompat;->constrain(FFF)F

    move-result v2

    .line 643
    .local v2, "newPos":F
    iget v7, p0, Landroid/support/v7/widget/SwitchCompat;->mThumbPosition:F

    cmpl-float v7, v2, v7

    if-eqz v7, :cond_3

    .line 644
    iput v5, p0, Landroid/support/v7/widget/SwitchCompat;->mTouchX:F

    .line 645
    invoke-direct {p0, v2}, Landroid/support/v7/widget/SwitchCompat;->setThumbPosition(F)V

    :cond_3
    move v7, v8

    .line 647
    goto/16 :goto_1

    .line 637
    .end local v1    # "dPos":F
    .end local v2    # "newPos":F
    :cond_4
    cmpl-float v9, v3, v10

    if-lez v9, :cond_5

    move v1, v7

    .restart local v1    # "dPos":F
    :goto_3
    goto :goto_2

    .end local v1    # "dPos":F
    :cond_5
    const/high16 v1, -0x40800000    # -1.0f

    goto :goto_3

    .line 655
    .end local v3    # "thumbScrollOffset":F
    .end local v4    # "thumbScrollRange":I
    .end local v5    # "x":F
    :pswitch_5
    iget v7, p0, Landroid/support/v7/widget/SwitchCompat;->mTouchMode:I

    if-ne v7, v11, :cond_6

    .line 656
    invoke-direct {p0, p1}, Landroid/support/v7/widget/SwitchCompat;->stopDrag(Landroid/view/MotionEvent;)V

    .line 658
    invoke-super {p0, p1}, Landroid/widget/CompoundButton;->onTouchEvent(Landroid/view/MotionEvent;)Z

    move v7, v8

    .line 659
    goto/16 :goto_1

    .line 661
    :cond_6
    const/4 v7, 0x0

    iput v7, p0, Landroid/support/v7/widget/SwitchCompat;->mTouchMode:I

    .line 662
    iget-object v7, p0, Landroid/support/v7/widget/SwitchCompat;->mVelocityTracker:Landroid/view/VelocityTracker;

    invoke-virtual {v7}, Landroid/view/VelocityTracker;->clear()V

    goto/16 :goto_0

    .line 595
    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_1
        :pswitch_5
        :pswitch_2
        :pswitch_5
    .end packed-switch

    .line 608
    :pswitch_data_1
    .packed-switch 0x0
        :pswitch_0
        :pswitch_3
        :pswitch_4
    .end packed-switch
.end method

.method public setChecked(Z)V
    .locals 1
    .param p1, "checked"    # Z

    .prologue
    .line 748
    invoke-super {p0, p1}, Landroid/widget/CompoundButton;->setChecked(Z)V

    .line 752
    invoke-virtual {p0}, Landroid/support/v7/widget/SwitchCompat;->isChecked()Z

    move-result p1

    .line 754
    invoke-virtual {p0}, Landroid/support/v7/widget/SwitchCompat;->getWindowToken()Landroid/os/IBinder;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 755
    invoke-direct {p0, p1}, Landroid/support/v7/widget/SwitchCompat;->animateThumbToCheckedState(Z)V

    .line 761
    :goto_0
    return-void

    .line 758
    :cond_0
    invoke-direct {p0}, Landroid/support/v7/widget/SwitchCompat;->cancelPositionAnimator()V

    .line 759
    if-eqz p1, :cond_1

    const/high16 v0, 0x3f800000    # 1.0f

    :goto_1
    invoke-direct {p0, v0}, Landroid/support/v7/widget/SwitchCompat;->setThumbPosition(F)V

    goto :goto_0

    :cond_1
    const/4 v0, 0x0

    goto :goto_1
.end method

.method public setShowText(Z)V
    .locals 1
    .param p1, "showText"    # Z

    .prologue
    .line 478
    iget-boolean v0, p0, Landroid/support/v7/widget/SwitchCompat;->mShowText:Z

    if-eq v0, p1, :cond_0

    .line 479
    iput-boolean p1, p0, Landroid/support/v7/widget/SwitchCompat;->mShowText:Z

    .line 480
    invoke-virtual {p0}, Landroid/support/v7/widget/SwitchCompat;->requestLayout()V

    .line 482
    :cond_0
    return-void
.end method

.method public setSplitTrack(Z)V
    .locals 0
    .param p1, "splitTrack"    # Z

    .prologue
    .line 431
    iput-boolean p1, p0, Landroid/support/v7/widget/SwitchCompat;->mSplitTrack:Z

    .line 432
    invoke-virtual {p0}, Landroid/support/v7/widget/SwitchCompat;->invalidate()V

    .line 433
    return-void
.end method

.method public setSwitchMinWidth(I)V
    .locals 0
    .param p1, "pixels"    # I

    .prologue
    .line 331
    iput p1, p0, Landroid/support/v7/widget/SwitchCompat;->mSwitchMinWidth:I

    .line 332
    invoke-virtual {p0}, Landroid/support/v7/widget/SwitchCompat;->requestLayout()V

    .line 333
    return-void
.end method

.method public setSwitchPadding(I)V
    .locals 0
    .param p1, "pixels"    # I

    .prologue
    .line 311
    iput p1, p0, Landroid/support/v7/widget/SwitchCompat;->mSwitchPadding:I

    .line 312
    invoke-virtual {p0}, Landroid/support/v7/widget/SwitchCompat;->requestLayout()V

    .line 313
    return-void
.end method

.method public setSwitchTextAppearance(Landroid/content/Context;I)V
    .locals 7
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "resid"    # I

    .prologue
    const/4 v6, 0x0

    .line 231
    sget-object v4, Landroid/support/v7/widget/SwitchCompat;->TEXT_APPEARANCE_ATTRS:[I

    invoke-virtual {p1, p2, v4}, Landroid/content/Context;->obtainStyledAttributes(I[I)Landroid/content/res/TypedArray;

    move-result-object v1

    .line 236
    .local v1, "appearance":Landroid/content/res/TypedArray;
    invoke-virtual {v1, v6}, Landroid/content/res/TypedArray;->getColorStateList(I)Landroid/content/res/ColorStateList;

    move-result-object v2

    .line 237
    .local v2, "colors":Landroid/content/res/ColorStateList;
    if-eqz v2, :cond_1

    .line 238
    iput-object v2, p0, Landroid/support/v7/widget/SwitchCompat;->mTextColors:Landroid/content/res/ColorStateList;

    .line 244
    :goto_0
    const/4 v4, 0x1

    invoke-virtual {v1, v4, v6}, Landroid/content/res/TypedArray;->getDimensionPixelSize(II)I

    move-result v3

    .line 245
    .local v3, "ts":I
    if-eqz v3, :cond_0

    .line 246
    int-to-float v4, v3

    iget-object v5, p0, Landroid/support/v7/widget/SwitchCompat;->mTextPaint:Landroid/text/TextPaint;

    invoke-virtual {v5}, Landroid/text/TextPaint;->getTextSize()F

    move-result v5

    cmpl-float v4, v4, v5

    if-eqz v4, :cond_0

    .line 247
    iget-object v4, p0, Landroid/support/v7/widget/SwitchCompat;->mTextPaint:Landroid/text/TextPaint;

    int-to-float v5, v3

    invoke-virtual {v4, v5}, Landroid/text/TextPaint;->setTextSize(F)V

    .line 248
    invoke-virtual {p0}, Landroid/support/v7/widget/SwitchCompat;->requestLayout()V

    .line 252
    :cond_0
    const/4 v4, 0x2

    invoke-virtual {v1, v4, v6}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    move-result v0

    .line 253
    .local v0, "allCaps":Z
    if-eqz v0, :cond_2

    .line 254
    new-instance v4, Landroid/support/v7/internal/text/AllCapsTransformationMethod;

    invoke-virtual {p0}, Landroid/support/v7/widget/SwitchCompat;->getContext()Landroid/content/Context;

    move-result-object v5

    invoke-direct {v4, v5}, Landroid/support/v7/internal/text/AllCapsTransformationMethod;-><init>(Landroid/content/Context;)V

    iput-object v4, p0, Landroid/support/v7/widget/SwitchCompat;->mSwitchTransformationMethod:Landroid/text/method/TransformationMethod;

    .line 259
    :goto_1
    invoke-virtual {v1}, Landroid/content/res/TypedArray;->recycle()V

    .line 260
    return-void

    .line 241
    .end local v0    # "allCaps":Z
    .end local v3    # "ts":I
    :cond_1
    invoke-virtual {p0}, Landroid/support/v7/widget/SwitchCompat;->getTextColors()Landroid/content/res/ColorStateList;

    move-result-object v4

    iput-object v4, p0, Landroid/support/v7/widget/SwitchCompat;->mTextColors:Landroid/content/res/ColorStateList;

    goto :goto_0

    .line 256
    .restart local v0    # "allCaps":Z
    .restart local v3    # "ts":I
    :cond_2
    const/4 v4, 0x0

    iput-object v4, p0, Landroid/support/v7/widget/SwitchCompat;->mSwitchTransformationMethod:Landroid/text/method/TransformationMethod;

    goto :goto_1
.end method

.method public setSwitchTypeface(Landroid/graphics/Typeface;)V
    .locals 1
    .param p1, "tf"    # Landroid/graphics/Typeface;

    .prologue
    .line 297
    iget-object v0, p0, Landroid/support/v7/widget/SwitchCompat;->mTextPaint:Landroid/text/TextPaint;

    invoke-virtual {v0}, Landroid/text/TextPaint;->getTypeface()Landroid/graphics/Typeface;

    move-result-object v0

    if-eq v0, p1, :cond_0

    .line 298
    iget-object v0, p0, Landroid/support/v7/widget/SwitchCompat;->mTextPaint:Landroid/text/TextPaint;

    invoke-virtual {v0, p1}, Landroid/text/TextPaint;->setTypeface(Landroid/graphics/Typeface;)Landroid/graphics/Typeface;

    .line 300
    invoke-virtual {p0}, Landroid/support/v7/widget/SwitchCompat;->requestLayout()V

    .line 301
    invoke-virtual {p0}, Landroid/support/v7/widget/SwitchCompat;->invalidate()V

    .line 303
    :cond_0
    return-void
.end method

.method public setSwitchTypeface(Landroid/graphics/Typeface;I)V
    .locals 6
    .param p1, "tf"    # Landroid/graphics/Typeface;
    .param p2, "style"    # I

    .prologue
    const/4 v3, 0x0

    const/4 v2, 0x0

    .line 269
    if-lez p2, :cond_4

    .line 270
    if-nez p1, :cond_1

    .line 271
    invoke-static {p2}, Landroid/graphics/Typeface;->defaultFromStyle(I)Landroid/graphics/Typeface;

    move-result-object p1

    .line 276
    :goto_0
    invoke-virtual {p0, p1}, Landroid/support/v7/widget/SwitchCompat;->setSwitchTypeface(Landroid/graphics/Typeface;)V

    .line 278
    if-eqz p1, :cond_2

    invoke-virtual {p1}, Landroid/graphics/Typeface;->getStyle()I

    move-result v1

    .line 279
    .local v1, "typefaceStyle":I
    :goto_1
    xor-int/lit8 v4, v1, -0x1

    and-int v0, p2, v4

    .line 280
    .local v0, "need":I
    iget-object v4, p0, Landroid/support/v7/widget/SwitchCompat;->mTextPaint:Landroid/text/TextPaint;

    and-int/lit8 v5, v0, 0x1

    if-eqz v5, :cond_0

    const/4 v2, 0x1

    :cond_0
    invoke-virtual {v4, v2}, Landroid/text/TextPaint;->setFakeBoldText(Z)V

    .line 281
    iget-object v4, p0, Landroid/support/v7/widget/SwitchCompat;->mTextPaint:Landroid/text/TextPaint;

    and-int/lit8 v2, v0, 0x2

    if-eqz v2, :cond_3

    const/high16 v2, -0x41800000    # -0.25f

    :goto_2
    invoke-virtual {v4, v2}, Landroid/text/TextPaint;->setTextSkewX(F)V

    .line 287
    .end local v0    # "need":I
    .end local v1    # "typefaceStyle":I
    :goto_3
    return-void

    .line 273
    :cond_1
    invoke-static {p1, p2}, Landroid/graphics/Typeface;->create(Landroid/graphics/Typeface;I)Landroid/graphics/Typeface;

    move-result-object p1

    goto :goto_0

    :cond_2
    move v1, v2

    .line 278
    goto :goto_1

    .restart local v0    # "need":I
    .restart local v1    # "typefaceStyle":I
    :cond_3
    move v2, v3

    .line 281
    goto :goto_2

    .line 283
    .end local v0    # "need":I
    .end local v1    # "typefaceStyle":I
    :cond_4
    iget-object v4, p0, Landroid/support/v7/widget/SwitchCompat;->mTextPaint:Landroid/text/TextPaint;

    invoke-virtual {v4, v2}, Landroid/text/TextPaint;->setFakeBoldText(Z)V

    .line 284
    iget-object v2, p0, Landroid/support/v7/widget/SwitchCompat;->mTextPaint:Landroid/text/TextPaint;

    invoke-virtual {v2, v3}, Landroid/text/TextPaint;->setTextSkewX(F)V

    .line 285
    invoke-virtual {p0, p1}, Landroid/support/v7/widget/SwitchCompat;->setSwitchTypeface(Landroid/graphics/Typeface;)V

    goto :goto_3
.end method

.method public setTextOff(Ljava/lang/CharSequence;)V
    .locals 0
    .param p1, "textOff"    # Ljava/lang/CharSequence;

    .prologue
    .line 468
    iput-object p1, p0, Landroid/support/v7/widget/SwitchCompat;->mTextOff:Ljava/lang/CharSequence;

    .line 469
    invoke-virtual {p0}, Landroid/support/v7/widget/SwitchCompat;->requestLayout()V

    .line 470
    return-void
.end method

.method public setTextOn(Ljava/lang/CharSequence;)V
    .locals 0
    .param p1, "textOn"    # Ljava/lang/CharSequence;

    .prologue
    .line 453
    iput-object p1, p0, Landroid/support/v7/widget/SwitchCompat;->mTextOn:Ljava/lang/CharSequence;

    .line 454
    invoke-virtual {p0}, Landroid/support/v7/widget/SwitchCompat;->requestLayout()V

    .line 455
    return-void
.end method

.method public setThumbDrawable(Landroid/graphics/drawable/Drawable;)V
    .locals 0
    .param p1, "thumb"    # Landroid/graphics/drawable/Drawable;

    .prologue
    .line 399
    iput-object p1, p0, Landroid/support/v7/widget/SwitchCompat;->mThumbDrawable:Landroid/graphics/drawable/Drawable;

    .line 400
    invoke-virtual {p0}, Landroid/support/v7/widget/SwitchCompat;->requestLayout()V

    .line 401
    return-void
.end method

.method public setThumbResource(I)V
    .locals 1
    .param p1, "resId"    # I

    .prologue
    .line 410
    iget-object v0, p0, Landroid/support/v7/widget/SwitchCompat;->mTintManager:Landroid/support/v7/internal/widget/TintManager;

    invoke-virtual {v0, p1}, Landroid/support/v7/internal/widget/TintManager;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    invoke-virtual {p0, v0}, Landroid/support/v7/widget/SwitchCompat;->setThumbDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 411
    return-void
.end method

.method public setThumbTextPadding(I)V
    .locals 0
    .param p1, "pixels"    # I

    .prologue
    .line 351
    iput p1, p0, Landroid/support/v7/widget/SwitchCompat;->mThumbTextPadding:I

    .line 352
    invoke-virtual {p0}, Landroid/support/v7/widget/SwitchCompat;->requestLayout()V

    .line 353
    return-void
.end method

.method public setTrackDrawable(Landroid/graphics/drawable/Drawable;)V
    .locals 0
    .param p1, "track"    # Landroid/graphics/drawable/Drawable;

    .prologue
    .line 370
    iput-object p1, p0, Landroid/support/v7/widget/SwitchCompat;->mTrackDrawable:Landroid/graphics/drawable/Drawable;

    .line 371
    invoke-virtual {p0}, Landroid/support/v7/widget/SwitchCompat;->requestLayout()V

    .line 372
    return-void
.end method

.method public setTrackResource(I)V
    .locals 1
    .param p1, "resId"    # I

    .prologue
    .line 380
    iget-object v0, p0, Landroid/support/v7/widget/SwitchCompat;->mTintManager:Landroid/support/v7/internal/widget/TintManager;

    invoke-virtual {v0, p1}, Landroid/support/v7/internal/widget/TintManager;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    invoke-virtual {p0, v0}, Landroid/support/v7/widget/SwitchCompat;->setTrackDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 381
    return-void
.end method

.method public toggle()V
    .locals 1

    .prologue
    .line 743
    invoke-virtual {p0}, Landroid/support/v7/widget/SwitchCompat;->isChecked()Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    invoke-virtual {p0, v0}, Landroid/support/v7/widget/SwitchCompat;->setChecked(Z)V

    .line 744
    return-void

    .line 743
    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method protected verifyDrawable(Landroid/graphics/drawable/Drawable;)Z
    .locals 1
    .param p1, "who"    # Landroid/graphics/drawable/Drawable;

    .prologue
    .line 1006
    invoke-super {p0, p1}, Landroid/widget/CompoundButton;->verifyDrawable(Landroid/graphics/drawable/Drawable;)Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Landroid/support/v7/widget/SwitchCompat;->mThumbDrawable:Landroid/graphics/drawable/Drawable;

    if-eq p1, v0, :cond_0

    iget-object v0, p0, Landroid/support/v7/widget/SwitchCompat;->mTrackDrawable:Landroid/graphics/drawable/Drawable;

    if-ne p1, v0, :cond_1

    :cond_0
    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method
