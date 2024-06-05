.class Landroid/support/v7/internal/widget/TintResources;
.super Landroid/content/res/Resources;
.source "TintResources.java"


# instance fields
.field private final mTintManager:Landroid/support/v7/internal/widget/TintManager;


# direct methods
.method public constructor <init>(Landroid/content/res/Resources;Landroid/support/v7/internal/widget/TintManager;)V
    .locals 3
    .param p1, "resources"    # Landroid/content/res/Resources;
    .param p2, "tintManager"    # Landroid/support/v7/internal/widget/TintManager;

    .prologue
    .line 33
    invoke-virtual {p1}, Landroid/content/res/Resources;->getAssets()Landroid/content/res/AssetManager;

    move-result-object v0

    invoke-virtual {p1}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v1

    invoke-virtual {p1}, Landroid/content/res/Resources;->getConfiguration()Landroid/content/res/Configuration;

    move-result-object v2

    invoke-direct {p0, v0, v1, v2}, Landroid/content/res/Resources;-><init>(Landroid/content/res/AssetManager;Landroid/util/DisplayMetrics;Landroid/content/res/Configuration;)V

    .line 34
    iput-object p2, p0, Landroid/support/v7/internal/widget/TintResources;->mTintManager:Landroid/support/v7/internal/widget/TintManager;

    .line 35
    return-void
.end method


# virtual methods
.method public getDrawable(I)Landroid/graphics/drawable/Drawable;
    .locals 2
    .param p1, "id"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/content/res/Resources$NotFoundException;
        }
    .end annotation

    .prologue
    .line 43
    invoke-super {p0, p1}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    .line 44
    .local v0, "d":Landroid/graphics/drawable/Drawable;
    if-eqz v0, :cond_0

    .line 45
    iget-object v1, p0, Landroid/support/v7/internal/widget/TintResources;->mTintManager:Landroid/support/v7/internal/widget/TintManager;

    invoke-virtual {v1, p1, v0}, Landroid/support/v7/internal/widget/TintManager;->tintDrawable(ILandroid/graphics/drawable/Drawable;)V

    .line 47
    :cond_0
    return-object v0
.end method
