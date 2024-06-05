.class public Landroid/support/v7/internal/view/menu/ActionMenuItemView;
.super Landroid/support/v7/internal/widget/CompatTextView;
.source "ActionMenuItemView.java"

# interfaces
.implements Landroid/support/v7/internal/view/menu/MenuView$ItemView;
.implements Landroid/view/View$OnClickListener;
.implements Landroid/view/View$OnLongClickListener;
.implements Landroid/support/v7/widget/ActionMenuView$ActionMenuChildView;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/support/v7/internal/view/menu/ActionMenuItemView$PopupCallback;,
        Landroid/support/v7/internal/view/menu/ActionMenuItemView$ActionMenuItemForwardingListener;
    }
.end annotation


# static fields
.field private static final MAX_ICON_SIZE:I = 0x20

.field private static final TAG:Ljava/lang/String; = "ActionMenuItemView"


# instance fields
.field private mAllowTextWithIcon:Z

.field private mExpandedFormat:Z

.field private mForwardingListener:Landroid/support/v7/widget/ListPopupWindow$ForwardingListener;

.field private mIcon:Landroid/graphics/drawable/Drawable;

.field private mItemData:Landroid/support/v7/internal/view/menu/MenuItemImpl;

.field private mItemInvoker:Landroid/support/v7/internal/view/menu/MenuBuilder$ItemInvoker;

.field private mMaxIconSize:I

.field private mMinWidth:I

.field private mPopupCallback:Landroid/support/v7/internal/view/menu/ActionMenuItemView$PopupCallback;

.field private mSavedPaddingLeft:I

.field private mTitle:Ljava/lang/CharSequence;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 68
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Landroid/support/v7/internal/view/menu/ActionMenuItemView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 69
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 72
    const/4 v0, 0x0

    invoke-direct {p0, p1, p2, v0}, Landroid/support/v7/internal/view/menu/ActionMenuItemView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 73
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 5
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;
    .param p3, "defStyle"    # I

    .prologue
    const/4 v4, 0x0

    .line 76
    invoke-direct {p0, p1, p2, p3}, Landroid/support/v7/internal/widget/CompatTextView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 77
    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    .line 78
    .local v2, "res":Landroid/content/res/Resources;
    sget v3, Landroid/support/v7/appcompat/R$bool;->abc_config_allowActionMenuItemTextWithIcon:I

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getBoolean(I)Z

    move-result v3

    iput-boolean v3, p0, Landroid/support/v7/internal/view/menu/ActionMenuItemView;->mAllowTextWithIcon:Z

    .line 80
    sget-object v3, Landroid/support/v7/appcompat/R$styleable;->ActionMenuItemView:[I

    invoke-virtual {p1, p2, v3, p3, v4}, Landroid/content/Context;->obtainStyledAttributes(Landroid/util/AttributeSet;[III)Landroid/content/res/TypedArray;

    move-result-object v0

    .line 82
    .local v0, "a":Landroid/content/res/TypedArray;
    sget v3, Landroid/support/v7/appcompat/R$styleable;->ActionMenuItemView_android_minWidth:I

    invoke-virtual {v0, v3, v4}, Landroid/content/res/TypedArray;->getDimensionPixelSize(II)I

    move-result v3

    iput v3, p0, Landroid/support/v7/internal/view/menu/ActionMenuItemView;->mMinWidth:I

    .line 84
    invoke-virtual {v0}, Landroid/content/res/TypedArray;->recycle()V

    .line 86
    invoke-virtual {v2}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v3

    iget v1, v3, Landroid/util/DisplayMetrics;->density:F

    .line 87
    .local v1, "density":F
    const/high16 v3, 0x42000000    # 32.0f

    mul-float/2addr v3, v1

    const/high16 v4, 0x3f000000    # 0.5f

    add-float/2addr v3, v4

    float-to-int v3, v3

    iput v3, p0, Landroid/support/v7/internal/view/menu/ActionMenuItemView;->mMaxIconSize:I

    .line 89
    invoke-virtual {p0, p0}, Landroid/support/v7/internal/view/menu/ActionMenuItemView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 90
    invoke-virtual {p0, p0}, Landroid/support/v7/internal/view/menu/ActionMenuItemView;->setOnLongClickListener(Landroid/view/View$OnLongClickListener;)V

    .line 92
    new-instance v3, Landroid/support/v7/internal/text/AllCapsTransformationMethod;

    invoke-direct {v3, p1}, Landroid/support/v7/internal/text/AllCapsTransformationMethod;-><init>(Landroid/content/Context;)V

    invoke-virtual {p0, v3}, Landroid/support/v7/internal/view/menu/ActionMenuItemView;->setTransformationMethod(Landroid/text/method/TransformationMethod;)V

    .line 94
    const/4 v3, -0x1

    iput v3, p0, Landroid/support/v7/internal/view/menu/ActionMenuItemView;->mSavedPaddingLeft:I

    .line 95
    return-void
.end method

.method static synthetic access$000(Landroid/support/v7/internal/view/menu/ActionMenuItemView;)Landroid/support/v7/internal/view/menu/ActionMenuItemView$PopupCallback;
    .locals 1
    .param p0, "x0"    # Landroid/support/v7/internal/view/menu/ActionMenuItemView;

    .prologue
    .line 46
    iget-object v0, p0, Landroid/support/v7/internal/view/menu/ActionMenuItemView;->mPopupCallback:Landroid/support/v7/internal/view/menu/ActionMenuItemView$PopupCallback;

    return-object v0
.end method

.method static synthetic access$100(Landroid/support/v7/internal/view/menu/ActionMenuItemView;)Landroid/support/v7/internal/view/menu/MenuBuilder$ItemInvoker;
    .locals 1
    .param p0, "x0"    # Landroid/support/v7/internal/view/menu/ActionMenuItemView;

    .prologue
    .line 46
    iget-object v0, p0, Landroid/support/v7/internal/view/menu/ActionMenuItemView;->mItemInvoker:Landroid/support/v7/internal/view/menu/MenuBuilder$ItemInvoker;

    return-object v0
.end method

.method static synthetic access$200(Landroid/support/v7/internal/view/menu/ActionMenuItemView;)Landroid/support/v7/internal/view/menu/MenuItemImpl;
    .locals 1
    .param p0, "x0"    # Landroid/support/v7/internal/view/menu/ActionMenuItemView;

    .prologue
    .line 46
    iget-object v0, p0, Landroid/support/v7/internal/view/menu/ActionMenuItemView;->mItemData:Landroid/support/v7/internal/view/menu/MenuItemImpl;

    return-object v0
.end method

.method private updateTextButtonVisibility()V
    .locals 4

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 179
    iget-object v3, p0, Landroid/support/v7/internal/view/menu/ActionMenuItemView;->mTitle:Ljava/lang/CharSequence;

    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_2

    move v0, v1

    .line 180
    .local v0, "visible":Z
    :goto_0
    iget-object v3, p0, Landroid/support/v7/internal/view/menu/ActionMenuItemView;->mIcon:Landroid/graphics/drawable/Drawable;

    if-eqz v3, :cond_0

    iget-object v3, p0, Landroid/support/v7/internal/view/menu/ActionMenuItemView;->mItemData:Landroid/support/v7/internal/view/menu/MenuItemImpl;

    invoke-virtual {v3}, Landroid/support/v7/internal/view/menu/MenuItemImpl;->showsTextAsAction()Z

    move-result v3

    if-eqz v3, :cond_1

    iget-boolean v3, p0, Landroid/support/v7/internal/view/menu/ActionMenuItemView;->mAllowTextWithIcon:Z

    if-nez v3, :cond_0

    iget-boolean v3, p0, Landroid/support/v7/internal/view/menu/ActionMenuItemView;->mExpandedFormat:Z

    if-eqz v3, :cond_1

    :cond_0
    move v2, v1

    :cond_1
    and-int/2addr v0, v2

    .line 183
    if-eqz v0, :cond_3

    iget-object v1, p0, Landroid/support/v7/internal/view/menu/ActionMenuItemView;->mTitle:Ljava/lang/CharSequence;

    :goto_1
    invoke-virtual {p0, v1}, Landroid/support/v7/internal/view/menu/ActionMenuItemView;->setText(Ljava/lang/CharSequence;)V

    .line 184
    return-void

    .end local v0    # "visible":Z
    :cond_2
    move v0, v2

    .line 179
    goto :goto_0

    .line 183
    .restart local v0    # "visible":Z
    :cond_3
    const/4 v1, 0x0

    goto :goto_1
.end method


# virtual methods
.method public getItemData()Landroid/support/v7/internal/view/menu/MenuItemImpl;
    .locals 1

    .prologue
    .line 114
    iget-object v0, p0, Landroid/support/v7/internal/view/menu/ActionMenuItemView;->mItemData:Landroid/support/v7/internal/view/menu/MenuItemImpl;

    return-object v0
.end method

.method public hasText()Z
    .locals 1

    .prologue
    .line 209
    invoke-virtual {p0}, Landroid/support/v7/internal/view/menu/ActionMenuItemView;->getText()Ljava/lang/CharSequence;

    move-result-object v0

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public initialize(Landroid/support/v7/internal/view/menu/MenuItemImpl;I)V
    .locals 1
    .param p1, "itemData"    # Landroid/support/v7/internal/view/menu/MenuItemImpl;
    .param p2, "menuType"    # I

    .prologue
    .line 118
    iput-object p1, p0, Landroid/support/v7/internal/view/menu/ActionMenuItemView;->mItemData:Landroid/support/v7/internal/view/menu/MenuItemImpl;

    .line 120
    invoke-virtual {p1}, Landroid/support/v7/internal/view/menu/MenuItemImpl;->getIcon()Landroid/graphics/drawable/Drawable;

    move-result-object v0

    invoke-virtual {p0, v0}, Landroid/support/v7/internal/view/menu/ActionMenuItemView;->setIcon(Landroid/graphics/drawable/Drawable;)V

    .line 121
    invoke-virtual {p1, p0}, Landroid/support/v7/internal/view/menu/MenuItemImpl;->getTitleForItemView(Landroid/support/v7/internal/view/menu/MenuView$ItemView;)Ljava/lang/CharSequence;

    move-result-object v0

    invoke-virtual {p0, v0}, Landroid/support/v7/internal/view/menu/ActionMenuItemView;->setTitle(Ljava/lang/CharSequence;)V

    .line 122
    invoke-virtual {p1}, Landroid/support/v7/internal/view/menu/MenuItemImpl;->getItemId()I

    move-result v0

    invoke-virtual {p0, v0}, Landroid/support/v7/internal/view/menu/ActionMenuItemView;->setId(I)V

    .line 124
    invoke-virtual {p1}, Landroid/support/v7/internal/view/menu/MenuItemImpl;->isVisible()Z

    move-result v0

    if-eqz v0, :cond_1

    const/4 v0, 0x0

    :goto_0
    invoke-virtual {p0, v0}, Landroid/support/v7/internal/view/menu/ActionMenuItemView;->setVisibility(I)V

    .line 125
    invoke-virtual {p1}, Landroid/support/v7/internal/view/menu/MenuItemImpl;->isEnabled()Z

    move-result v0

    invoke-virtual {p0, v0}, Landroid/support/v7/internal/view/menu/ActionMenuItemView;->setEnabled(Z)V

    .line 126
    invoke-virtual {p1}, Landroid/support/v7/internal/view/menu/MenuItemImpl;->hasSubMenu()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 127
    iget-object v0, p0, Landroid/support/v7/internal/view/menu/ActionMenuItemView;->mForwardingListener:Landroid/support/v7/widget/ListPopupWindow$ForwardingListener;

    if-nez v0, :cond_0

    .line 128
    new-instance v0, Landroid/support/v7/internal/view/menu/ActionMenuItemView$ActionMenuItemForwardingListener;

    invoke-direct {v0, p0}, Landroid/support/v7/internal/view/menu/ActionMenuItemView$ActionMenuItemForwardingListener;-><init>(Landroid/support/v7/internal/view/menu/ActionMenuItemView;)V

    iput-object v0, p0, Landroid/support/v7/internal/view/menu/ActionMenuItemView;->mForwardingListener:Landroid/support/v7/widget/ListPopupWindow$ForwardingListener;

    .line 131
    :cond_0
    return-void

    .line 124
    :cond_1
    const/16 v0, 0x8

    goto :goto_0
.end method

.method public needsDividerAfter()Z
    .locals 1

    .prologue
    .line 232
    invoke-virtual {p0}, Landroid/support/v7/internal/view/menu/ActionMenuItemView;->hasText()Z

    move-result v0

    return v0
.end method

.method public needsDividerBefore()Z
    .locals 1

    .prologue
    .line 228
    invoke-virtual {p0}, Landroid/support/v7/internal/view/menu/ActionMenuItemView;->hasText()Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Landroid/support/v7/internal/view/menu/ActionMenuItemView;->mItemData:Landroid/support/v7/internal/view/menu/MenuItemImpl;

    invoke-virtual {v0}, Landroid/support/v7/internal/view/menu/MenuItemImpl;->getIcon()Landroid/graphics/drawable/Drawable;

    move-result-object v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public onClick(Landroid/view/View;)V
    .locals 2
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 144
    iget-object v0, p0, Landroid/support/v7/internal/view/menu/ActionMenuItemView;->mItemInvoker:Landroid/support/v7/internal/view/menu/MenuBuilder$ItemInvoker;

    if-eqz v0, :cond_0

    .line 145
    iget-object v0, p0, Landroid/support/v7/internal/view/menu/ActionMenuItemView;->mItemInvoker:Landroid/support/v7/internal/view/menu/MenuBuilder$ItemInvoker;

    iget-object v1, p0, Landroid/support/v7/internal/view/menu/ActionMenuItemView;->mItemData:Landroid/support/v7/internal/view/menu/MenuItemImpl;

    invoke-interface {v0, v1}, Landroid/support/v7/internal/view/menu/MenuBuilder$ItemInvoker;->invokeItem(Landroid/support/v7/internal/view/menu/MenuItemImpl;)Z

    .line 147
    :cond_0
    return-void
.end method

.method public onConfigurationChanged(Landroid/content/res/Configuration;)V
    .locals 2
    .param p1, "newConfig"    # Landroid/content/res/Configuration;

    .prologue
    .line 98
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x8

    if-lt v0, v1, :cond_0

    .line 99
    invoke-super {p0, p1}, Landroid/support/v7/internal/widget/CompatTextView;->onConfigurationChanged(Landroid/content/res/Configuration;)V

    .line 102
    :cond_0
    invoke-virtual {p0}, Landroid/support/v7/internal/view/menu/ActionMenuItemView;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    sget v1, Landroid/support/v7/appcompat/R$bool;->abc_config_allowActionMenuItemTextWithIcon:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getBoolean(I)Z

    move-result v0

    iput-boolean v0, p0, Landroid/support/v7/internal/view/menu/ActionMenuItemView;->mAllowTextWithIcon:Z

    .line 104
    invoke-direct {p0}, Landroid/support/v7/internal/view/menu/ActionMenuItemView;->updateTextButtonVisibility()V

    .line 105
    return-void
.end method

.method public onLongClick(Landroid/view/View;)Z
    .locals 13
    .param p1, "v"    # Landroid/view/View;

    .prologue
    const/4 v10, 0x1

    const/4 v9, 0x0

    .line 237
    invoke-virtual {p0}, Landroid/support/v7/internal/view/menu/ActionMenuItemView;->hasText()Z

    move-result v11

    if-eqz v11, :cond_0

    .line 265
    :goto_0
    return v9

    .line 242
    :cond_0
    const/4 v11, 0x2

    new-array v6, v11, [I

    .line 243
    .local v6, "screenPos":[I
    new-instance v2, Landroid/graphics/Rect;

    invoke-direct {v2}, Landroid/graphics/Rect;-><init>()V

    .line 244
    .local v2, "displayFrame":Landroid/graphics/Rect;
    invoke-virtual {p0, v6}, Landroid/support/v7/internal/view/menu/ActionMenuItemView;->getLocationOnScreen([I)V

    .line 245
    invoke-virtual {p0, v2}, Landroid/support/v7/internal/view/menu/ActionMenuItemView;->getWindowVisibleDisplayFrame(Landroid/graphics/Rect;)V

    .line 247
    invoke-virtual {p0}, Landroid/support/v7/internal/view/menu/ActionMenuItemView;->getContext()Landroid/content/Context;

    move-result-object v1

    .line 248
    .local v1, "context":Landroid/content/Context;
    invoke-virtual {p0}, Landroid/support/v7/internal/view/menu/ActionMenuItemView;->getWidth()I

    move-result v8

    .line 249
    .local v8, "width":I
    invoke-virtual {p0}, Landroid/support/v7/internal/view/menu/ActionMenuItemView;->getHeight()I

    move-result v3

    .line 250
    .local v3, "height":I
    aget v11, v6, v10

    div-int/lit8 v12, v3, 0x2

    add-int v4, v11, v12

    .line 251
    .local v4, "midy":I
    aget v11, v6, v9

    div-int/lit8 v12, v8, 0x2

    add-int v5, v11, v12

    .line 252
    .local v5, "referenceX":I
    invoke-static {p1}, Landroid/support/v4/view/ViewCompat;->getLayoutDirection(Landroid/view/View;)I

    move-result v11

    if-nez v11, :cond_1

    .line 253
    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v11

    invoke-virtual {v11}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v11

    iget v7, v11, Landroid/util/DisplayMetrics;->widthPixels:I

    .line 254
    .local v7, "screenWidth":I
    sub-int v5, v7, v5

    .line 256
    .end local v7    # "screenWidth":I
    :cond_1
    iget-object v11, p0, Landroid/support/v7/internal/view/menu/ActionMenuItemView;->mItemData:Landroid/support/v7/internal/view/menu/MenuItemImpl;

    invoke-virtual {v11}, Landroid/support/v7/internal/view/menu/MenuItemImpl;->getTitle()Ljava/lang/CharSequence;

    move-result-object v11

    invoke-static {v1, v11, v9}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v0

    .line 257
    .local v0, "cheatSheet":Landroid/widget/Toast;
    invoke-virtual {v2}, Landroid/graphics/Rect;->height()I

    move-result v11

    if-ge v4, v11, :cond_2

    .line 259
    const v9, 0x800035

    invoke-virtual {v0, v9, v5, v3}, Landroid/widget/Toast;->setGravity(III)V

    .line 264
    :goto_1
    invoke-virtual {v0}, Landroid/widget/Toast;->show()V

    move v9, v10

    .line 265
    goto :goto_0

    .line 262
    :cond_2
    const/16 v11, 0x51

    invoke-virtual {v0, v11, v9, v3}, Landroid/widget/Toast;->setGravity(III)V

    goto :goto_1
.end method

.method protected onMeasure(II)V
    .locals 12
    .param p1, "widthMeasureSpec"    # I
    .param p2, "heightMeasureSpec"    # I

    .prologue
    const/high16 v11, 0x40000000    # 2.0f

    .line 270
    invoke-virtual {p0}, Landroid/support/v7/internal/view/menu/ActionMenuItemView;->hasText()Z

    move-result v3

    .line 271
    .local v3, "textVisible":Z
    if-eqz v3, :cond_0

    iget v7, p0, Landroid/support/v7/internal/view/menu/ActionMenuItemView;->mSavedPaddingLeft:I

    if-ltz v7, :cond_0

    .line 272
    iget v7, p0, Landroid/support/v7/internal/view/menu/ActionMenuItemView;->mSavedPaddingLeft:I

    invoke-virtual {p0}, Landroid/support/v7/internal/view/menu/ActionMenuItemView;->getPaddingTop()I

    move-result v8

    invoke-virtual {p0}, Landroid/support/v7/internal/view/menu/ActionMenuItemView;->getPaddingRight()I

    move-result v9

    invoke-virtual {p0}, Landroid/support/v7/internal/view/menu/ActionMenuItemView;->getPaddingBottom()I

    move-result v10

    invoke-super {p0, v7, v8, v9, v10}, Landroid/support/v7/internal/widget/CompatTextView;->setPadding(IIII)V

    .line 276
    :cond_0
    invoke-super {p0, p1, p2}, Landroid/support/v7/internal/widget/CompatTextView;->onMeasure(II)V

    .line 278
    invoke-static {p1}, Landroid/view/View$MeasureSpec;->getMode(I)I

    move-result v5

    .line 279
    .local v5, "widthMode":I
    invoke-static {p1}, Landroid/view/View$MeasureSpec;->getSize(I)I

    move-result v6

    .line 280
    .local v6, "widthSize":I
    invoke-virtual {p0}, Landroid/support/v7/internal/view/menu/ActionMenuItemView;->getMeasuredWidth()I

    move-result v1

    .line 281
    .local v1, "oldMeasuredWidth":I
    const/high16 v7, -0x80000000

    if-ne v5, v7, :cond_3

    iget v7, p0, Landroid/support/v7/internal/view/menu/ActionMenuItemView;->mMinWidth:I

    invoke-static {v6, v7}, Ljava/lang/Math;->min(II)I

    move-result v2

    .line 284
    .local v2, "targetWidth":I
    :goto_0
    if-eq v5, v11, :cond_1

    iget v7, p0, Landroid/support/v7/internal/view/menu/ActionMenuItemView;->mMinWidth:I

    if-lez v7, :cond_1

    if-ge v1, v2, :cond_1

    .line 286
    invoke-static {v2, v11}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v7

    invoke-super {p0, v7, p2}, Landroid/support/v7/internal/widget/CompatTextView;->onMeasure(II)V

    .line 290
    :cond_1
    if-nez v3, :cond_2

    iget-object v7, p0, Landroid/support/v7/internal/view/menu/ActionMenuItemView;->mIcon:Landroid/graphics/drawable/Drawable;

    if-eqz v7, :cond_2

    .line 293
    invoke-virtual {p0}, Landroid/support/v7/internal/view/menu/ActionMenuItemView;->getMeasuredWidth()I

    move-result v4

    .line 294
    .local v4, "w":I
    iget-object v7, p0, Landroid/support/v7/internal/view/menu/ActionMenuItemView;->mIcon:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v7}, Landroid/graphics/drawable/Drawable;->getBounds()Landroid/graphics/Rect;

    move-result-object v7

    invoke-virtual {v7}, Landroid/graphics/Rect;->width()I

    move-result v0

    .line 295
    .local v0, "dw":I
    sub-int v7, v4, v0

    div-int/lit8 v7, v7, 0x2

    invoke-virtual {p0}, Landroid/support/v7/internal/view/menu/ActionMenuItemView;->getPaddingTop()I

    move-result v8

    invoke-virtual {p0}, Landroid/support/v7/internal/view/menu/ActionMenuItemView;->getPaddingRight()I

    move-result v9

    invoke-virtual {p0}, Landroid/support/v7/internal/view/menu/ActionMenuItemView;->getPaddingBottom()I

    move-result v10

    invoke-super {p0, v7, v8, v9, v10}, Landroid/support/v7/internal/widget/CompatTextView;->setPadding(IIII)V

    .line 297
    .end local v0    # "dw":I
    .end local v4    # "w":I
    :cond_2
    return-void

    .line 281
    .end local v2    # "targetWidth":I
    :cond_3
    iget v2, p0, Landroid/support/v7/internal/view/menu/ActionMenuItemView;->mMinWidth:I

    goto :goto_0
.end method

.method public onTouchEvent(Landroid/view/MotionEvent;)Z
    .locals 1
    .param p1, "e"    # Landroid/view/MotionEvent;

    .prologue
    .line 135
    iget-object v0, p0, Landroid/support/v7/internal/view/menu/ActionMenuItemView;->mItemData:Landroid/support/v7/internal/view/menu/MenuItemImpl;

    invoke-virtual {v0}, Landroid/support/v7/internal/view/menu/MenuItemImpl;->hasSubMenu()Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Landroid/support/v7/internal/view/menu/ActionMenuItemView;->mForwardingListener:Landroid/support/v7/widget/ListPopupWindow$ForwardingListener;

    if-eqz v0, :cond_0

    iget-object v0, p0, Landroid/support/v7/internal/view/menu/ActionMenuItemView;->mForwardingListener:Landroid/support/v7/widget/ListPopupWindow$ForwardingListener;

    invoke-virtual {v0, p0, p1}, Landroid/support/v7/widget/ListPopupWindow$ForwardingListener;->onTouch(Landroid/view/View;Landroid/view/MotionEvent;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 137
    const/4 v0, 0x1

    .line 139
    :goto_0
    return v0

    :cond_0
    invoke-super {p0, p1}, Landroid/support/v7/internal/widget/CompatTextView;->onTouchEvent(Landroid/view/MotionEvent;)Z

    move-result v0

    goto :goto_0
.end method

.method public prefersCondensedTitle()Z
    .locals 1

    .prologue
    .line 158
    const/4 v0, 0x1

    return v0
.end method

.method public setCheckable(Z)V
    .locals 0
    .param p1, "checkable"    # Z

    .prologue
    .line 163
    return-void
.end method

.method public setChecked(Z)V
    .locals 0
    .param p1, "checked"    # Z

    .prologue
    .line 167
    return-void
.end method

.method public setExpandedFormat(Z)V
    .locals 1
    .param p1, "expandedFormat"    # Z

    .prologue
    .line 170
    iget-boolean v0, p0, Landroid/support/v7/internal/view/menu/ActionMenuItemView;->mExpandedFormat:Z

    if-eq v0, p1, :cond_0

    .line 171
    iput-boolean p1, p0, Landroid/support/v7/internal/view/menu/ActionMenuItemView;->mExpandedFormat:Z

    .line 172
    iget-object v0, p0, Landroid/support/v7/internal/view/menu/ActionMenuItemView;->mItemData:Landroid/support/v7/internal/view/menu/MenuItemImpl;

    if-eqz v0, :cond_0

    .line 173
    iget-object v0, p0, Landroid/support/v7/internal/view/menu/ActionMenuItemView;->mItemData:Landroid/support/v7/internal/view/menu/MenuItemImpl;

    invoke-virtual {v0}, Landroid/support/v7/internal/view/menu/MenuItemImpl;->actionFormatChanged()V

    .line 176
    :cond_0
    return-void
.end method

.method public setIcon(Landroid/graphics/drawable/Drawable;)V
    .locals 7
    .param p1, "icon"    # Landroid/graphics/drawable/Drawable;

    .prologue
    const/4 v6, 0x0

    const/4 v5, 0x0

    .line 187
    iput-object p1, p0, Landroid/support/v7/internal/view/menu/ActionMenuItemView;->mIcon:Landroid/graphics/drawable/Drawable;

    .line 188
    if-eqz p1, :cond_2

    .line 189
    invoke-virtual {p1}, Landroid/graphics/drawable/Drawable;->getIntrinsicWidth()I

    move-result v2

    .line 190
    .local v2, "width":I
    invoke-virtual {p1}, Landroid/graphics/drawable/Drawable;->getIntrinsicHeight()I

    move-result v0

    .line 191
    .local v0, "height":I
    iget v3, p0, Landroid/support/v7/internal/view/menu/ActionMenuItemView;->mMaxIconSize:I

    if-le v2, v3, :cond_0

    .line 192
    iget v3, p0, Landroid/support/v7/internal/view/menu/ActionMenuItemView;->mMaxIconSize:I

    int-to-float v3, v3

    int-to-float v4, v2

    div-float v1, v3, v4

    .line 193
    .local v1, "scale":F
    iget v2, p0, Landroid/support/v7/internal/view/menu/ActionMenuItemView;->mMaxIconSize:I

    .line 194
    int-to-float v3, v0

    mul-float/2addr v3, v1

    float-to-int v0, v3

    .line 196
    .end local v1    # "scale":F
    :cond_0
    iget v3, p0, Landroid/support/v7/internal/view/menu/ActionMenuItemView;->mMaxIconSize:I

    if-le v0, v3, :cond_1

    .line 197
    iget v3, p0, Landroid/support/v7/internal/view/menu/ActionMenuItemView;->mMaxIconSize:I

    int-to-float v3, v3

    int-to-float v4, v0

    div-float v1, v3, v4

    .line 198
    .restart local v1    # "scale":F
    iget v0, p0, Landroid/support/v7/internal/view/menu/ActionMenuItemView;->mMaxIconSize:I

    .line 199
    int-to-float v3, v2

    mul-float/2addr v3, v1

    float-to-int v2, v3

    .line 201
    .end local v1    # "scale":F
    :cond_1
    invoke-virtual {p1, v6, v6, v2, v0}, Landroid/graphics/drawable/Drawable;->setBounds(IIII)V

    .line 203
    .end local v0    # "height":I
    .end local v2    # "width":I
    :cond_2
    invoke-virtual {p0, p1, v5, v5, v5}, Landroid/support/v7/internal/view/menu/ActionMenuItemView;->setCompoundDrawables(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V

    .line 205
    invoke-direct {p0}, Landroid/support/v7/internal/view/menu/ActionMenuItemView;->updateTextButtonVisibility()V

    .line 206
    return-void
.end method

.method public setItemInvoker(Landroid/support/v7/internal/view/menu/MenuBuilder$ItemInvoker;)V
    .locals 0
    .param p1, "invoker"    # Landroid/support/v7/internal/view/menu/MenuBuilder$ItemInvoker;

    .prologue
    .line 150
    iput-object p1, p0, Landroid/support/v7/internal/view/menu/ActionMenuItemView;->mItemInvoker:Landroid/support/v7/internal/view/menu/MenuBuilder$ItemInvoker;

    .line 151
    return-void
.end method

.method public setPadding(IIII)V
    .locals 0
    .param p1, "l"    # I
    .param p2, "t"    # I
    .param p3, "r"    # I
    .param p4, "b"    # I

    .prologue
    .line 109
    iput p1, p0, Landroid/support/v7/internal/view/menu/ActionMenuItemView;->mSavedPaddingLeft:I

    .line 110
    invoke-super {p0, p1, p2, p3, p4}, Landroid/support/v7/internal/widget/CompatTextView;->setPadding(IIII)V

    .line 111
    return-void
.end method

.method public setPopupCallback(Landroid/support/v7/internal/view/menu/ActionMenuItemView$PopupCallback;)V
    .locals 0
    .param p1, "popupCallback"    # Landroid/support/v7/internal/view/menu/ActionMenuItemView$PopupCallback;

    .prologue
    .line 154
    iput-object p1, p0, Landroid/support/v7/internal/view/menu/ActionMenuItemView;->mPopupCallback:Landroid/support/v7/internal/view/menu/ActionMenuItemView$PopupCallback;

    .line 155
    return-void
.end method

.method public setShortcut(ZC)V
    .locals 0
    .param p1, "showShortcut"    # Z
    .param p2, "shortcutKey"    # C

    .prologue
    .line 214
    return-void
.end method

.method public setTitle(Ljava/lang/CharSequence;)V
    .locals 1
    .param p1, "title"    # Ljava/lang/CharSequence;

    .prologue
    .line 217
    iput-object p1, p0, Landroid/support/v7/internal/view/menu/ActionMenuItemView;->mTitle:Ljava/lang/CharSequence;

    .line 219
    iget-object v0, p0, Landroid/support/v7/internal/view/menu/ActionMenuItemView;->mTitle:Ljava/lang/CharSequence;

    invoke-virtual {p0, v0}, Landroid/support/v7/internal/view/menu/ActionMenuItemView;->setContentDescription(Ljava/lang/CharSequence;)V

    .line 220
    invoke-direct {p0}, Landroid/support/v7/internal/view/menu/ActionMenuItemView;->updateTextButtonVisibility()V

    .line 221
    return-void
.end method

.method public showsIcon()Z
    .locals 1

    .prologue
    .line 224
    const/4 v0, 0x1

    return v0
.end method
