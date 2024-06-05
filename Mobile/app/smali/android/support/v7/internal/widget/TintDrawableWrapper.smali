.class Landroid/support/v7/internal/widget/TintDrawableWrapper;
.super Landroid/support/v7/internal/widget/DrawableWrapper;
.source "TintDrawableWrapper.java"


# instance fields
.field private mCurrentColor:I

.field private final mTintMode:Landroid/graphics/PorterDuff$Mode;

.field private final mTintStateList:Landroid/content/res/ColorStateList;


# direct methods
.method public constructor <init>(Landroid/graphics/drawable/Drawable;Landroid/content/res/ColorStateList;)V
    .locals 1
    .param p1, "drawable"    # Landroid/graphics/drawable/Drawable;
    .param p2, "tintStateList"    # Landroid/content/res/ColorStateList;

    .prologue
    .line 36
    sget-object v0, Landroid/support/v7/internal/widget/TintManager;->DEFAULT_MODE:Landroid/graphics/PorterDuff$Mode;

    invoke-direct {p0, p1, p2, v0}, Landroid/support/v7/internal/widget/TintDrawableWrapper;-><init>(Landroid/graphics/drawable/Drawable;Landroid/content/res/ColorStateList;Landroid/graphics/PorterDuff$Mode;)V

    .line 37
    return-void
.end method

.method public constructor <init>(Landroid/graphics/drawable/Drawable;Landroid/content/res/ColorStateList;Landroid/graphics/PorterDuff$Mode;)V
    .locals 0
    .param p1, "drawable"    # Landroid/graphics/drawable/Drawable;
    .param p2, "tintStateList"    # Landroid/content/res/ColorStateList;
    .param p3, "tintMode"    # Landroid/graphics/PorterDuff$Mode;

    .prologue
    .line 41
    invoke-direct {p0, p1}, Landroid/support/v7/internal/widget/DrawableWrapper;-><init>(Landroid/graphics/drawable/Drawable;)V

    .line 42
    iput-object p2, p0, Landroid/support/v7/internal/widget/TintDrawableWrapper;->mTintStateList:Landroid/content/res/ColorStateList;

    .line 43
    iput-object p3, p0, Landroid/support/v7/internal/widget/TintDrawableWrapper;->mTintMode:Landroid/graphics/PorterDuff$Mode;

    .line 44
    return-void
.end method

.method private updateTint([I)Z
    .locals 3
    .param p1, "state"    # [I

    .prologue
    .line 59
    iget-object v1, p0, Landroid/support/v7/internal/widget/TintDrawableWrapper;->mTintStateList:Landroid/content/res/ColorStateList;

    if-eqz v1, :cond_1

    .line 60
    iget-object v1, p0, Landroid/support/v7/internal/widget/TintDrawableWrapper;->mTintStateList:Landroid/content/res/ColorStateList;

    iget v2, p0, Landroid/support/v7/internal/widget/TintDrawableWrapper;->mCurrentColor:I

    invoke-virtual {v1, p1, v2}, Landroid/content/res/ColorStateList;->getColorForState([II)I

    move-result v0

    .line 61
    .local v0, "color":I
    iget v1, p0, Landroid/support/v7/internal/widget/TintDrawableWrapper;->mCurrentColor:I

    if-eq v0, v1, :cond_1

    .line 62
    if-eqz v0, :cond_0

    .line 63
    iget-object v1, p0, Landroid/support/v7/internal/widget/TintDrawableWrapper;->mTintMode:Landroid/graphics/PorterDuff$Mode;

    invoke-virtual {p0, v0, v1}, Landroid/support/v7/internal/widget/TintDrawableWrapper;->setColorFilter(ILandroid/graphics/PorterDuff$Mode;)V

    .line 67
    :goto_0
    iput v0, p0, Landroid/support/v7/internal/widget/TintDrawableWrapper;->mCurrentColor:I

    .line 68
    const/4 v1, 0x1

    .line 71
    .end local v0    # "color":I
    :goto_1
    return v1

    .line 65
    .restart local v0    # "color":I
    :cond_0
    invoke-virtual {p0}, Landroid/support/v7/internal/widget/TintDrawableWrapper;->clearColorFilter()V

    goto :goto_0

    .line 71
    .end local v0    # "color":I
    :cond_1
    const/4 v1, 0x0

    goto :goto_1
.end method


# virtual methods
.method public isStateful()Z
    .locals 1

    .prologue
    .line 48
    iget-object v0, p0, Landroid/support/v7/internal/widget/TintDrawableWrapper;->mTintStateList:Landroid/content/res/ColorStateList;

    if-eqz v0, :cond_0

    iget-object v0, p0, Landroid/support/v7/internal/widget/TintDrawableWrapper;->mTintStateList:Landroid/content/res/ColorStateList;

    invoke-virtual {v0}, Landroid/content/res/ColorStateList;->isStateful()Z

    move-result v0

    if-nez v0, :cond_1

    :cond_0
    invoke-super {p0}, Landroid/support/v7/internal/widget/DrawableWrapper;->isStateful()Z

    move-result v0

    if-eqz v0, :cond_2

    :cond_1
    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_2
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public setState([I)Z
    .locals 2
    .param p1, "stateSet"    # [I

    .prologue
    .line 53
    invoke-super {p0, p1}, Landroid/support/v7/internal/widget/DrawableWrapper;->setState([I)Z

    move-result v0

    .line 54
    .local v0, "handled":Z
    invoke-direct {p0, p1}, Landroid/support/v7/internal/widget/TintDrawableWrapper;->updateTint([I)Z

    move-result v1

    if-nez v1, :cond_0

    if-eqz v0, :cond_1

    :cond_0
    const/4 v0, 0x1

    .line 55
    :goto_0
    return v0

    .line 54
    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method
