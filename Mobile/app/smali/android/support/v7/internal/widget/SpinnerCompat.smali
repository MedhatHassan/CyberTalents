.class Landroid/support/v7/internal/widget/SpinnerCompat;
.super Landroid/support/v7/internal/widget/AbsSpinnerCompat;
.source "SpinnerCompat.java"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/support/v7/internal/widget/SpinnerCompat$DropdownPopup;,
        Landroid/support/v7/internal/widget/SpinnerCompat$DialogPopup;,
        Landroid/support/v7/internal/widget/SpinnerCompat$SpinnerPopup;,
        Landroid/support/v7/internal/widget/SpinnerCompat$DropDownAdapter;,
        Landroid/support/v7/internal/widget/SpinnerCompat$SavedState;
    }
.end annotation


# static fields
.field private static final MAX_ITEMS_MEASURED:I = 0xf

.field public static final MODE_DIALOG:I = 0x0

.field public static final MODE_DROPDOWN:I = 0x1

.field private static final MODE_THEME:I = -0x1

.field private static final TAG:Ljava/lang/String; = "Spinner"


# instance fields
.field private mDisableChildrenWhenDisabled:Z

.field mDropDownWidth:I

.field private mForwardingListener:Landroid/support/v7/widget/ListPopupWindow$ForwardingListener;

.field private mGravity:I

.field private mPopup:Landroid/support/v7/internal/widget/SpinnerCompat$SpinnerPopup;

.field private mTempAdapter:Landroid/support/v7/internal/widget/SpinnerCompat$DropDownAdapter;

.field private mTempRect:Landroid/graphics/Rect;

.field private final mTintManager:Landroid/support/v7/internal/widget/TintManager;


# direct methods
.method constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 100
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Landroid/support/v7/internal/widget/SpinnerCompat;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 101
    return-void
.end method

.method constructor <init>(Landroid/content/Context;I)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "mode"    # I

    .prologue
    .line 114
    const/4 v0, 0x0

    sget v1, Landroid/support/v7/appcompat/R$attr;->spinnerStyle:I

    invoke-direct {p0, p1, v0, v1, p2}, Landroid/support/v7/internal/widget/SpinnerCompat;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;II)V

    .line 115
    return-void
.end method

.method constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 125
    sget v0, Landroid/support/v7/appcompat/R$attr;->spinnerStyle:I

    invoke-direct {p0, p1, p2, v0}, Landroid/support/v7/internal/widget/SpinnerCompat;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 126
    return-void
.end method

.method constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;
    .param p3, "defStyle"    # I

    .prologue
    .line 141
    const/4 v0, -0x1

    invoke-direct {p0, p1, p2, p3, v0}, Landroid/support/v7/internal/widget/SpinnerCompat;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;II)V

    .line 142
    return-void
.end method

.method constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;II)V
    .locals 6
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;
    .param p3, "defStyle"    # I
    .param p4, "mode"    # I

    .prologue
    const/4 v5, 0x0

    const/4 v4, 0x0

    .line 161
    invoke-direct {p0, p1, p2, p3}, Landroid/support/v7/internal/widget/AbsSpinnerCompat;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 89
    new-instance v2, Landroid/graphics/Rect;

    invoke-direct {v2}, Landroid/graphics/Rect;-><init>()V

    iput-object v2, p0, Landroid/support/v7/internal/widget/SpinnerCompat;->mTempRect:Landroid/graphics/Rect;

    .line 163
    sget-object v2, Landroid/support/v7/appcompat/R$styleable;->Spinner:[I

    invoke-static {p1, p2, v2, p3, v4}, Landroid/support/v7/internal/widget/TintTypedArray;->obtainStyledAttributes(Landroid/content/Context;Landroid/util/AttributeSet;[III)Landroid/support/v7/internal/widget/TintTypedArray;

    move-result-object v0

    .line 167
    .local v0, "a":Landroid/support/v7/internal/widget/TintTypedArray;
    sget v2, Landroid/support/v7/appcompat/R$styleable;->Spinner_android_background:I

    invoke-virtual {v0, v2}, Landroid/support/v7/internal/widget/TintTypedArray;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v2

    invoke-virtual {p0, v2}, Landroid/support/v7/internal/widget/SpinnerCompat;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 169
    const/4 v2, -0x1

    if-ne p4, v2, :cond_0

    .line 170
    sget v2, Landroid/support/v7/appcompat/R$styleable;->Spinner_spinnerMode:I

    invoke-virtual {v0, v2, v4}, Landroid/support/v7/internal/widget/TintTypedArray;->getInt(II)I

    move-result p4

    .line 173
    :cond_0
    packed-switch p4, :pswitch_data_0

    .line 207
    :goto_0
    sget v2, Landroid/support/v7/appcompat/R$styleable;->Spinner_android_gravity:I

    const/16 v3, 0x11

    invoke-virtual {v0, v2, v3}, Landroid/support/v7/internal/widget/TintTypedArray;->getInt(II)I

    move-result v2

    iput v2, p0, Landroid/support/v7/internal/widget/SpinnerCompat;->mGravity:I

    .line 209
    iget-object v2, p0, Landroid/support/v7/internal/widget/SpinnerCompat;->mPopup:Landroid/support/v7/internal/widget/SpinnerCompat$SpinnerPopup;

    sget v3, Landroid/support/v7/appcompat/R$styleable;->Spinner_prompt:I

    invoke-virtual {v0, v3}, Landroid/support/v7/internal/widget/TintTypedArray;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-interface {v2, v3}, Landroid/support/v7/internal/widget/SpinnerCompat$SpinnerPopup;->setPromptText(Ljava/lang/CharSequence;)V

    .line 211
    sget v2, Landroid/support/v7/appcompat/R$styleable;->Spinner_disableChildrenWhenDisabled:I

    invoke-virtual {v0, v2, v4}, Landroid/support/v7/internal/widget/TintTypedArray;->getBoolean(IZ)Z

    move-result v2

    iput-boolean v2, p0, Landroid/support/v7/internal/widget/SpinnerCompat;->mDisableChildrenWhenDisabled:Z

    .line 214
    invoke-virtual {v0}, Landroid/support/v7/internal/widget/TintTypedArray;->recycle()V

    .line 218
    iget-object v2, p0, Landroid/support/v7/internal/widget/SpinnerCompat;->mTempAdapter:Landroid/support/v7/internal/widget/SpinnerCompat$DropDownAdapter;

    if-eqz v2, :cond_1

    .line 219
    iget-object v2, p0, Landroid/support/v7/internal/widget/SpinnerCompat;->mPopup:Landroid/support/v7/internal/widget/SpinnerCompat$SpinnerPopup;

    iget-object v3, p0, Landroid/support/v7/internal/widget/SpinnerCompat;->mTempAdapter:Landroid/support/v7/internal/widget/SpinnerCompat$DropDownAdapter;

    invoke-interface {v2, v3}, Landroid/support/v7/internal/widget/SpinnerCompat$SpinnerPopup;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 220
    iput-object v5, p0, Landroid/support/v7/internal/widget/SpinnerCompat;->mTempAdapter:Landroid/support/v7/internal/widget/SpinnerCompat$DropDownAdapter;

    .line 224
    :cond_1
    invoke-virtual {v0}, Landroid/support/v7/internal/widget/TintTypedArray;->getTintManager()Landroid/support/v7/internal/widget/TintManager;

    move-result-object v2

    iput-object v2, p0, Landroid/support/v7/internal/widget/SpinnerCompat;->mTintManager:Landroid/support/v7/internal/widget/TintManager;

    .line 225
    return-void

    .line 175
    :pswitch_0
    new-instance v2, Landroid/support/v7/internal/widget/SpinnerCompat$DialogPopup;

    invoke-direct {v2, p0, v5}, Landroid/support/v7/internal/widget/SpinnerCompat$DialogPopup;-><init>(Landroid/support/v7/internal/widget/SpinnerCompat;Landroid/support/v7/internal/widget/SpinnerCompat$1;)V

    iput-object v2, p0, Landroid/support/v7/internal/widget/SpinnerCompat;->mPopup:Landroid/support/v7/internal/widget/SpinnerCompat$SpinnerPopup;

    goto :goto_0

    .line 180
    :pswitch_1
    new-instance v1, Landroid/support/v7/internal/widget/SpinnerCompat$DropdownPopup;

    invoke-direct {v1, p0, p1, p2, p3}, Landroid/support/v7/internal/widget/SpinnerCompat$DropdownPopup;-><init>(Landroid/support/v7/internal/widget/SpinnerCompat;Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 182
    .local v1, "popup":Landroid/support/v7/internal/widget/SpinnerCompat$DropdownPopup;
    sget v2, Landroid/support/v7/appcompat/R$styleable;->Spinner_android_dropDownWidth:I

    const/4 v3, -0x2

    invoke-virtual {v0, v2, v3}, Landroid/support/v7/internal/widget/TintTypedArray;->getLayoutDimension(II)I

    move-result v2

    iput v2, p0, Landroid/support/v7/internal/widget/SpinnerCompat;->mDropDownWidth:I

    .line 185
    sget v2, Landroid/support/v7/appcompat/R$styleable;->Spinner_android_popupBackground:I

    invoke-virtual {v0, v2}, Landroid/support/v7/internal/widget/TintTypedArray;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/support/v7/internal/widget/SpinnerCompat$DropdownPopup;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 188
    iput-object v1, p0, Landroid/support/v7/internal/widget/SpinnerCompat;->mPopup:Landroid/support/v7/internal/widget/SpinnerCompat$SpinnerPopup;

    .line 189
    new-instance v2, Landroid/support/v7/internal/widget/SpinnerCompat$1;

    invoke-direct {v2, p0, p0, v1}, Landroid/support/v7/internal/widget/SpinnerCompat$1;-><init>(Landroid/support/v7/internal/widget/SpinnerCompat;Landroid/view/View;Landroid/support/v7/internal/widget/SpinnerCompat$DropdownPopup;)V

    iput-object v2, p0, Landroid/support/v7/internal/widget/SpinnerCompat;->mForwardingListener:Landroid/support/v7/widget/ListPopupWindow$ForwardingListener;

    goto :goto_0

    .line 173
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method static synthetic access$100(Landroid/support/v7/internal/widget/SpinnerCompat;)Landroid/support/v7/internal/widget/SpinnerCompat$SpinnerPopup;
    .locals 1
    .param p0, "x0"    # Landroid/support/v7/internal/widget/SpinnerCompat;

    .prologue
    .line 53
    iget-object v0, p0, Landroid/support/v7/internal/widget/SpinnerCompat;->mPopup:Landroid/support/v7/internal/widget/SpinnerCompat$SpinnerPopup;

    return-object v0
.end method

.method static synthetic access$400(Landroid/support/v7/internal/widget/SpinnerCompat;)Landroid/graphics/Rect;
    .locals 1
    .param p0, "x0"    # Landroid/support/v7/internal/widget/SpinnerCompat;

    .prologue
    .line 53
    iget-object v0, p0, Landroid/support/v7/internal/widget/SpinnerCompat;->mTempRect:Landroid/graphics/Rect;

    return-object v0
.end method

.method private makeView(IZ)Landroid/view/View;
    .locals 4
    .param p1, "position"    # I
    .param p2, "addChild"    # Z

    .prologue
    .line 527
    iget-boolean v2, p0, Landroid/support/v7/internal/widget/SpinnerCompat;->mDataChanged:Z

    if-nez v2, :cond_0

    .line 528
    iget-object v2, p0, Landroid/support/v7/internal/widget/SpinnerCompat;->mRecycler:Landroid/support/v7/internal/widget/AbsSpinnerCompat$RecycleBin;

    invoke-virtual {v2, p1}, Landroid/support/v7/internal/widget/AbsSpinnerCompat$RecycleBin;->get(I)Landroid/view/View;

    move-result-object v0

    .line 529
    .local v0, "child":Landroid/view/View;
    if-eqz v0, :cond_0

    .line 531
    invoke-direct {p0, v0, p2}, Landroid/support/v7/internal/widget/SpinnerCompat;->setUpChild(Landroid/view/View;Z)V

    move-object v1, v0

    .line 543
    .end local v0    # "child":Landroid/view/View;
    .local v1, "child":Landroid/view/View;
    :goto_0
    return-object v1

    .line 538
    .end local v1    # "child":Landroid/view/View;
    :cond_0
    iget-object v2, p0, Landroid/support/v7/internal/widget/SpinnerCompat;->mAdapter:Landroid/widget/SpinnerAdapter;

    const/4 v3, 0x0

    invoke-interface {v2, p1, v3, p0}, Landroid/widget/SpinnerAdapter;->getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    .line 541
    .restart local v0    # "child":Landroid/view/View;
    invoke-direct {p0, v0, p2}, Landroid/support/v7/internal/widget/SpinnerCompat;->setUpChild(Landroid/view/View;Z)V

    move-object v1, v0

    .line 543
    .end local v0    # "child":Landroid/view/View;
    .restart local v1    # "child":Landroid/view/View;
    goto :goto_0
.end method

.method private setUpChild(Landroid/view/View;Z)V
    .locals 11
    .param p1, "child"    # Landroid/view/View;
    .param p2, "addChild"    # Z

    .prologue
    .line 556
    invoke-virtual {p1}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v6

    .line 557
    .local v6, "lp":Landroid/view/ViewGroup$LayoutParams;
    if-nez v6, :cond_0

    .line 558
    invoke-virtual {p0}, Landroid/support/v7/internal/widget/SpinnerCompat;->generateDefaultLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v6

    .line 561
    :cond_0
    if-eqz p2, :cond_1

    .line 562
    const/4 v8, 0x0

    invoke-virtual {p0, p1, v8, v6}, Landroid/support/v7/internal/widget/SpinnerCompat;->addViewInLayout(Landroid/view/View;ILandroid/view/ViewGroup$LayoutParams;)Z

    .line 565
    :cond_1
    invoke-virtual {p0}, Landroid/support/v7/internal/widget/SpinnerCompat;->hasFocus()Z

    move-result v8

    invoke-virtual {p1, v8}, Landroid/view/View;->setSelected(Z)V

    .line 566
    iget-boolean v8, p0, Landroid/support/v7/internal/widget/SpinnerCompat;->mDisableChildrenWhenDisabled:Z

    if-eqz v8, :cond_2

    .line 567
    invoke-virtual {p0}, Landroid/support/v7/internal/widget/SpinnerCompat;->isEnabled()Z

    move-result v8

    invoke-virtual {p1, v8}, Landroid/view/View;->setEnabled(Z)V

    .line 571
    :cond_2
    iget v8, p0, Landroid/support/v7/internal/widget/SpinnerCompat;->mHeightMeasureSpec:I

    iget-object v9, p0, Landroid/support/v7/internal/widget/SpinnerCompat;->mSpinnerPadding:Landroid/graphics/Rect;

    iget v9, v9, Landroid/graphics/Rect;->top:I

    iget-object v10, p0, Landroid/support/v7/internal/widget/SpinnerCompat;->mSpinnerPadding:Landroid/graphics/Rect;

    iget v10, v10, Landroid/graphics/Rect;->bottom:I

    add-int/2addr v9, v10

    iget v10, v6, Landroid/view/ViewGroup$LayoutParams;->height:I

    invoke-static {v8, v9, v10}, Landroid/view/ViewGroup;->getChildMeasureSpec(III)I

    move-result v1

    .line 573
    .local v1, "childHeightSpec":I
    iget v8, p0, Landroid/support/v7/internal/widget/SpinnerCompat;->mWidthMeasureSpec:I

    iget-object v9, p0, Landroid/support/v7/internal/widget/SpinnerCompat;->mSpinnerPadding:Landroid/graphics/Rect;

    iget v9, v9, Landroid/graphics/Rect;->left:I

    iget-object v10, p0, Landroid/support/v7/internal/widget/SpinnerCompat;->mSpinnerPadding:Landroid/graphics/Rect;

    iget v10, v10, Landroid/graphics/Rect;->right:I

    add-int/2addr v9, v10

    iget v10, v6, Landroid/view/ViewGroup$LayoutParams;->width:I

    invoke-static {v8, v9, v10}, Landroid/view/ViewGroup;->getChildMeasureSpec(III)I

    move-result v5

    .line 577
    .local v5, "childWidthSpec":I
    invoke-virtual {p1, v5, v1}, Landroid/view/View;->measure(II)V

    .line 583
    iget-object v8, p0, Landroid/support/v7/internal/widget/SpinnerCompat;->mSpinnerPadding:Landroid/graphics/Rect;

    iget v8, v8, Landroid/graphics/Rect;->top:I

    invoke-virtual {p0}, Landroid/support/v7/internal/widget/SpinnerCompat;->getMeasuredHeight()I

    move-result v9

    iget-object v10, p0, Landroid/support/v7/internal/widget/SpinnerCompat;->mSpinnerPadding:Landroid/graphics/Rect;

    iget v10, v10, Landroid/graphics/Rect;->bottom:I

    sub-int/2addr v9, v10

    iget-object v10, p0, Landroid/support/v7/internal/widget/SpinnerCompat;->mSpinnerPadding:Landroid/graphics/Rect;

    iget v10, v10, Landroid/graphics/Rect;->top:I

    sub-int/2addr v9, v10

    invoke-virtual {p1}, Landroid/view/View;->getMeasuredHeight()I

    move-result v10

    sub-int/2addr v9, v10

    div-int/lit8 v9, v9, 0x2

    add-int v4, v8, v9

    .line 586
    .local v4, "childTop":I
    invoke-virtual {p1}, Landroid/view/View;->getMeasuredHeight()I

    move-result v8

    add-int v0, v4, v8

    .line 588
    .local v0, "childBottom":I
    invoke-virtual {p1}, Landroid/view/View;->getMeasuredWidth()I

    move-result v7

    .line 589
    .local v7, "width":I
    const/4 v2, 0x0

    .line 590
    .local v2, "childLeft":I
    add-int v3, v2, v7

    .line 592
    .local v3, "childRight":I
    invoke-virtual {p1, v2, v4, v3, v0}, Landroid/view/View;->layout(IIII)V

    .line 593
    return-void
.end method


# virtual methods
.method public getBaseline()I
    .locals 5

    .prologue
    const/4 v2, -0x1

    const/4 v4, 0x0

    .line 378
    const/4 v0, 0x0

    .line 380
    .local v0, "child":Landroid/view/View;
    invoke-virtual {p0}, Landroid/support/v7/internal/widget/SpinnerCompat;->getChildCount()I

    move-result v3

    if-lez v3, :cond_2

    .line 381
    invoke-virtual {p0, v4}, Landroid/support/v7/internal/widget/SpinnerCompat;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    .line 387
    :cond_0
    :goto_0
    if-eqz v0, :cond_1

    .line 388
    invoke-virtual {v0}, Landroid/view/View;->getBaseline()I

    move-result v1

    .line 389
    .local v1, "childBaseline":I
    if-ltz v1, :cond_1

    invoke-virtual {v0}, Landroid/view/View;->getTop()I

    move-result v2

    add-int/2addr v2, v1

    .line 391
    .end local v1    # "childBaseline":I
    :cond_1
    return v2

    .line 382
    :cond_2
    iget-object v3, p0, Landroid/support/v7/internal/widget/SpinnerCompat;->mAdapter:Landroid/widget/SpinnerAdapter;

    if-eqz v3, :cond_0

    iget-object v3, p0, Landroid/support/v7/internal/widget/SpinnerCompat;->mAdapter:Landroid/widget/SpinnerAdapter;

    invoke-interface {v3}, Landroid/widget/SpinnerAdapter;->getCount()I

    move-result v3

    if-lez v3, :cond_0

    .line 383
    invoke-direct {p0, v4, v4}, Landroid/support/v7/internal/widget/SpinnerCompat;->makeView(IZ)Landroid/view/View;

    move-result-object v0

    .line 384
    iget-object v3, p0, Landroid/support/v7/internal/widget/SpinnerCompat;->mRecycler:Landroid/support/v7/internal/widget/AbsSpinnerCompat$RecycleBin;

    invoke-virtual {v3, v4, v0}, Landroid/support/v7/internal/widget/AbsSpinnerCompat$RecycleBin;->put(ILandroid/view/View;)V

    goto :goto_0
.end method

.method public getDropDownHorizontalOffset()I
    .locals 1

    .prologue
    .line 298
    iget-object v0, p0, Landroid/support/v7/internal/widget/SpinnerCompat;->mPopup:Landroid/support/v7/internal/widget/SpinnerCompat$SpinnerPopup;

    invoke-interface {v0}, Landroid/support/v7/internal/widget/SpinnerCompat$SpinnerPopup;->getHorizontalOffset()I

    move-result v0

    return v0
.end method

.method public getDropDownVerticalOffset()I
    .locals 1

    .prologue
    .line 278
    iget-object v0, p0, Landroid/support/v7/internal/widget/SpinnerCompat;->mPopup:Landroid/support/v7/internal/widget/SpinnerCompat$SpinnerPopup;

    invoke-interface {v0}, Landroid/support/v7/internal/widget/SpinnerCompat$SpinnerPopup;->getVerticalOffset()I

    move-result v0

    return v0
.end method

.method public getDropDownWidth()I
    .locals 1

    .prologue
    .line 328
    iget v0, p0, Landroid/support/v7/internal/widget/SpinnerCompat;->mDropDownWidth:I

    return v0
.end method

.method public getPopupBackground()Landroid/graphics/drawable/Drawable;
    .locals 1

    .prologue
    .line 258
    iget-object v0, p0, Landroid/support/v7/internal/widget/SpinnerCompat;->mPopup:Landroid/support/v7/internal/widget/SpinnerCompat$SpinnerPopup;

    invoke-interface {v0}, Landroid/support/v7/internal/widget/SpinnerCompat$SpinnerPopup;->getBackground()Landroid/graphics/drawable/Drawable;

    move-result-object v0

    return-object v0
.end method

.method public getPrompt()Ljava/lang/CharSequence;
    .locals 1

    .prologue
    .line 635
    iget-object v0, p0, Landroid/support/v7/internal/widget/SpinnerCompat;->mPopup:Landroid/support/v7/internal/widget/SpinnerCompat$SpinnerPopup;

    invoke-interface {v0}, Landroid/support/v7/internal/widget/SpinnerCompat$SpinnerPopup;->getHintText()Ljava/lang/CharSequence;

    move-result-object v0

    return-object v0
.end method

.method layout(IZ)V
    .locals 10
    .param p1, "delta"    # I
    .param p2, "animate"    # Z

    .prologue
    const/4 v9, 0x0

    .line 461
    iget-object v7, p0, Landroid/support/v7/internal/widget/SpinnerCompat;->mSpinnerPadding:Landroid/graphics/Rect;

    iget v1, v7, Landroid/graphics/Rect;->left:I

    .line 462
    .local v1, "childrenLeft":I
    invoke-virtual {p0}, Landroid/support/v7/internal/widget/SpinnerCompat;->getRight()I

    move-result v7

    invoke-virtual {p0}, Landroid/support/v7/internal/widget/SpinnerCompat;->getLeft()I

    move-result v8

    sub-int/2addr v7, v8

    iget-object v8, p0, Landroid/support/v7/internal/widget/SpinnerCompat;->mSpinnerPadding:Landroid/graphics/Rect;

    iget v8, v8, Landroid/graphics/Rect;->left:I

    sub-int/2addr v7, v8

    iget-object v8, p0, Landroid/support/v7/internal/widget/SpinnerCompat;->mSpinnerPadding:Landroid/graphics/Rect;

    iget v8, v8, Landroid/graphics/Rect;->right:I

    sub-int v2, v7, v8

    .line 464
    .local v2, "childrenWidth":I
    iget-boolean v7, p0, Landroid/support/v7/internal/widget/SpinnerCompat;->mDataChanged:Z

    if-eqz v7, :cond_0

    .line 465
    invoke-virtual {p0}, Landroid/support/v7/internal/widget/SpinnerCompat;->handleDataChanged()V

    .line 469
    :cond_0
    iget v7, p0, Landroid/support/v7/internal/widget/SpinnerCompat;->mItemCount:I

    if-nez v7, :cond_1

    .line 470
    invoke-virtual {p0}, Landroid/support/v7/internal/widget/SpinnerCompat;->resetList()V

    .line 512
    :goto_0
    return-void

    .line 474
    :cond_1
    iget v7, p0, Landroid/support/v7/internal/widget/SpinnerCompat;->mNextSelectedPosition:I

    if-ltz v7, :cond_2

    .line 475
    iget v7, p0, Landroid/support/v7/internal/widget/SpinnerCompat;->mNextSelectedPosition:I

    invoke-virtual {p0, v7}, Landroid/support/v7/internal/widget/SpinnerCompat;->setSelectedPositionInt(I)V

    .line 478
    :cond_2
    invoke-virtual {p0}, Landroid/support/v7/internal/widget/SpinnerCompat;->recycleAllViews()V

    .line 481
    invoke-virtual {p0}, Landroid/support/v7/internal/widget/SpinnerCompat;->removeAllViewsInLayout()V

    .line 484
    iget v7, p0, Landroid/support/v7/internal/widget/SpinnerCompat;->mSelectedPosition:I

    iput v7, p0, Landroid/support/v7/internal/widget/SpinnerCompat;->mFirstPosition:I

    .line 485
    iget-object v7, p0, Landroid/support/v7/internal/widget/SpinnerCompat;->mAdapter:Landroid/widget/SpinnerAdapter;

    if-eqz v7, :cond_3

    .line 486
    iget v7, p0, Landroid/support/v7/internal/widget/SpinnerCompat;->mSelectedPosition:I

    const/4 v8, 0x1

    invoke-direct {p0, v7, v8}, Landroid/support/v7/internal/widget/SpinnerCompat;->makeView(IZ)Landroid/view/View;

    move-result-object v4

    .line 487
    .local v4, "sel":Landroid/view/View;
    invoke-virtual {v4}, Landroid/view/View;->getMeasuredWidth()I

    move-result v6

    .line 488
    .local v6, "width":I
    move v5, v1

    .line 489
    .local v5, "selectedOffset":I
    invoke-static {p0}, Landroid/support/v4/view/ViewCompat;->getLayoutDirection(Landroid/view/View;)I

    move-result v3

    .line 490
    .local v3, "layoutDirection":I
    iget v7, p0, Landroid/support/v7/internal/widget/SpinnerCompat;->mGravity:I

    invoke-static {v7, v3}, Landroid/support/v4/view/GravityCompat;->getAbsoluteGravity(II)I

    move-result v0

    .line 491
    .local v0, "absoluteGravity":I
    and-int/lit8 v7, v0, 0x7

    sparse-switch v7, :sswitch_data_0

    .line 499
    :goto_1
    invoke-virtual {v4, v5}, Landroid/view/View;->offsetLeftAndRight(I)V

    .line 503
    .end local v0    # "absoluteGravity":I
    .end local v3    # "layoutDirection":I
    .end local v4    # "sel":Landroid/view/View;
    .end local v5    # "selectedOffset":I
    .end local v6    # "width":I
    :cond_3
    iget-object v7, p0, Landroid/support/v7/internal/widget/SpinnerCompat;->mRecycler:Landroid/support/v7/internal/widget/AbsSpinnerCompat$RecycleBin;

    invoke-virtual {v7}, Landroid/support/v7/internal/widget/AbsSpinnerCompat$RecycleBin;->clear()V

    .line 505
    invoke-virtual {p0}, Landroid/support/v7/internal/widget/SpinnerCompat;->invalidate()V

    .line 507
    invoke-virtual {p0}, Landroid/support/v7/internal/widget/SpinnerCompat;->checkSelectionChanged()V

    .line 509
    iput-boolean v9, p0, Landroid/support/v7/internal/widget/SpinnerCompat;->mDataChanged:Z

    .line 510
    iput-boolean v9, p0, Landroid/support/v7/internal/widget/SpinnerCompat;->mNeedSync:Z

    .line 511
    iget v7, p0, Landroid/support/v7/internal/widget/SpinnerCompat;->mSelectedPosition:I

    invoke-virtual {p0, v7}, Landroid/support/v7/internal/widget/SpinnerCompat;->setNextSelectedPositionInt(I)V

    goto :goto_0

    .line 493
    .restart local v0    # "absoluteGravity":I
    .restart local v3    # "layoutDirection":I
    .restart local v4    # "sel":Landroid/view/View;
    .restart local v5    # "selectedOffset":I
    .restart local v6    # "width":I
    :sswitch_0
    div-int/lit8 v7, v2, 0x2

    add-int/2addr v7, v1

    div-int/lit8 v8, v6, 0x2

    sub-int v5, v7, v8

    .line 494
    goto :goto_1

    .line 496
    :sswitch_1
    add-int v7, v1, v2

    sub-int v5, v7, v6

    goto :goto_1

    .line 491
    nop

    :sswitch_data_0
    .sparse-switch
        0x1 -> :sswitch_0
        0x5 -> :sswitch_1
    .end sparse-switch
.end method

.method measureContentWidth(Landroid/widget/SpinnerAdapter;Landroid/graphics/drawable/Drawable;)I
    .locals 13
    .param p1, "adapter"    # Landroid/widget/SpinnerAdapter;
    .param p2, "background"    # Landroid/graphics/drawable/Drawable;

    .prologue
    .line 639
    if-nez p1, :cond_1

    .line 640
    const/4 v8, 0x0

    .line 679
    :cond_0
    :goto_0
    return v8

    .line 643
    :cond_1
    const/4 v8, 0x0

    .line 644
    .local v8, "width":I
    const/4 v5, 0x0

    .line 645
    .local v5, "itemView":Landroid/view/View;
    const/4 v4, 0x0

    .line 646
    .local v4, "itemType":I
    const/4 v10, 0x0

    const/4 v11, 0x0

    invoke-static {v10, v11}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v9

    .line 648
    .local v9, "widthMeasureSpec":I
    const/4 v10, 0x0

    const/4 v11, 0x0

    invoke-static {v10, v11}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v2

    .line 653
    .local v2, "heightMeasureSpec":I
    const/4 v10, 0x0

    invoke-virtual {p0}, Landroid/support/v7/internal/widget/SpinnerCompat;->getSelectedItemPosition()I

    move-result v11

    invoke-static {v10, v11}, Ljava/lang/Math;->max(II)I

    move-result v7

    .line 654
    .local v7, "start":I
    invoke-interface {p1}, Landroid/widget/SpinnerAdapter;->getCount()I

    move-result v10

    add-int/lit8 v11, v7, 0xf

    invoke-static {v10, v11}, Ljava/lang/Math;->min(II)I

    move-result v1

    .line 655
    .local v1, "end":I
    sub-int v0, v1, v7

    .line 656
    .local v0, "count":I
    const/4 v10, 0x0

    rsub-int/lit8 v11, v0, 0xf

    sub-int v11, v7, v11

    invoke-static {v10, v11}, Ljava/lang/Math;->max(II)I

    move-result v7

    .line 657
    move v3, v7

    .local v3, "i":I
    :goto_1
    if-ge v3, v1, :cond_4

    .line 658
    invoke-interface {p1, v3}, Landroid/widget/SpinnerAdapter;->getItemViewType(I)I

    move-result v6

    .line 659
    .local v6, "positionType":I
    if-eq v6, v4, :cond_2

    .line 660
    move v4, v6

    .line 661
    const/4 v5, 0x0

    .line 663
    :cond_2
    invoke-interface {p1, v3, v5, p0}, Landroid/widget/SpinnerAdapter;->getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v5

    .line 664
    invoke-virtual {v5}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v10

    if-nez v10, :cond_3

    .line 665
    new-instance v10, Landroid/view/ViewGroup$LayoutParams;

    const/4 v11, -0x2

    const/4 v12, -0x2

    invoke-direct {v10, v11, v12}, Landroid/view/ViewGroup$LayoutParams;-><init>(II)V

    invoke-virtual {v5, v10}, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 669
    :cond_3
    invoke-virtual {v5, v9, v2}, Landroid/view/View;->measure(II)V

    .line 670
    invoke-virtual {v5}, Landroid/view/View;->getMeasuredWidth()I

    move-result v10

    invoke-static {v8, v10}, Ljava/lang/Math;->max(II)I

    move-result v8

    .line 657
    add-int/lit8 v3, v3, 0x1

    goto :goto_1

    .line 674
    .end local v6    # "positionType":I
    :cond_4
    if-eqz p2, :cond_0

    .line 675
    iget-object v10, p0, Landroid/support/v7/internal/widget/SpinnerCompat;->mTempRect:Landroid/graphics/Rect;

    invoke-virtual {p2, v10}, Landroid/graphics/drawable/Drawable;->getPadding(Landroid/graphics/Rect;)Z

    .line 676
    iget-object v10, p0, Landroid/support/v7/internal/widget/SpinnerCompat;->mTempRect:Landroid/graphics/Rect;

    iget v10, v10, Landroid/graphics/Rect;->left:I

    iget-object v11, p0, Landroid/support/v7/internal/widget/SpinnerCompat;->mTempRect:Landroid/graphics/Rect;

    iget v11, v11, Landroid/graphics/Rect;->right:I

    add-int/2addr v10, v11

    add-int/2addr v8, v10

    goto :goto_0
.end method

.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 0
    .param p1, "dialog"    # Landroid/content/DialogInterface;
    .param p2, "which"    # I

    .prologue
    .line 611
    invoke-virtual {p0, p2}, Landroid/support/v7/internal/widget/SpinnerCompat;->setSelection(I)V

    .line 612
    invoke-interface {p1}, Landroid/content/DialogInterface;->dismiss()V

    .line 613
    return-void
.end method

.method protected onDetachedFromWindow()V
    .locals 1

    .prologue
    .line 397
    invoke-super {p0}, Landroid/support/v7/internal/widget/AbsSpinnerCompat;->onDetachedFromWindow()V

    .line 399
    iget-object v0, p0, Landroid/support/v7/internal/widget/SpinnerCompat;->mPopup:Landroid/support/v7/internal/widget/SpinnerCompat$SpinnerPopup;

    if-eqz v0, :cond_0

    iget-object v0, p0, Landroid/support/v7/internal/widget/SpinnerCompat;->mPopup:Landroid/support/v7/internal/widget/SpinnerCompat$SpinnerPopup;

    invoke-interface {v0}, Landroid/support/v7/internal/widget/SpinnerCompat$SpinnerPopup;->isShowing()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 400
    iget-object v0, p0, Landroid/support/v7/internal/widget/SpinnerCompat;->mPopup:Landroid/support/v7/internal/widget/SpinnerCompat$SpinnerPopup;

    invoke-interface {v0}, Landroid/support/v7/internal/widget/SpinnerCompat$SpinnerPopup;->dismiss()V

    .line 402
    :cond_0
    return-void
.end method

.method protected onLayout(ZIIII)V
    .locals 2
    .param p1, "changed"    # Z
    .param p2, "l"    # I
    .param p3, "t"    # I
    .param p4, "r"    # I
    .param p5, "b"    # I

    .prologue
    const/4 v1, 0x0

    .line 447
    invoke-super/range {p0 .. p5}, Landroid/support/v7/internal/widget/AbsSpinnerCompat;->onLayout(ZIIII)V

    .line 448
    const/4 v0, 0x1

    iput-boolean v0, p0, Landroid/support/v7/internal/widget/SpinnerCompat;->mInLayout:Z

    .line 449
    invoke-virtual {p0, v1, v1}, Landroid/support/v7/internal/widget/SpinnerCompat;->layout(IZ)V

    .line 450
    iput-boolean v1, p0, Landroid/support/v7/internal/widget/SpinnerCompat;->mInLayout:Z

    .line 451
    return-void
.end method

.method protected onMeasure(II)V
    .locals 3
    .param p1, "widthMeasureSpec"    # I
    .param p2, "heightMeasureSpec"    # I

    .prologue
    .line 430
    invoke-super {p0, p1, p2}, Landroid/support/v7/internal/widget/AbsSpinnerCompat;->onMeasure(II)V

    .line 431
    iget-object v1, p0, Landroid/support/v7/internal/widget/SpinnerCompat;->mPopup:Landroid/support/v7/internal/widget/SpinnerCompat$SpinnerPopup;

    if-eqz v1, :cond_0

    invoke-static {p1}, Landroid/view/View$MeasureSpec;->getMode(I)I

    move-result v1

    const/high16 v2, -0x80000000

    if-ne v1, v2, :cond_0

    .line 432
    invoke-virtual {p0}, Landroid/support/v7/internal/widget/SpinnerCompat;->getMeasuredWidth()I

    move-result v0

    .line 433
    .local v0, "measuredWidth":I
    invoke-virtual {p0}, Landroid/support/v7/internal/widget/SpinnerCompat;->getAdapter()Landroid/widget/SpinnerAdapter;

    move-result-object v1

    invoke-virtual {p0}, Landroid/support/v7/internal/widget/SpinnerCompat;->getBackground()Landroid/graphics/drawable/Drawable;

    move-result-object v2

    invoke-virtual {p0, v1, v2}, Landroid/support/v7/internal/widget/SpinnerCompat;->measureContentWidth(Landroid/widget/SpinnerAdapter;Landroid/graphics/drawable/Drawable;)I

    move-result v1

    invoke-static {v0, v1}, Ljava/lang/Math;->max(II)I

    move-result v1

    invoke-static {p1}, Landroid/view/View$MeasureSpec;->getSize(I)I

    move-result v2

    invoke-static {v1, v2}, Ljava/lang/Math;->min(II)I

    move-result v1

    invoke-virtual {p0}, Landroid/support/v7/internal/widget/SpinnerCompat;->getMeasuredHeight()I

    move-result v2

    invoke-virtual {p0, v1, v2}, Landroid/support/v7/internal/widget/SpinnerCompat;->setMeasuredDimension(II)V

    .line 438
    .end local v0    # "measuredWidth":I
    :cond_0
    return-void
.end method

.method public onRestoreInstanceState(Landroid/os/Parcelable;)V
    .locals 4
    .param p1, "state"    # Landroid/os/Parcelable;

    .prologue
    .line 691
    move-object v1, p1

    check-cast v1, Landroid/support/v7/internal/widget/SpinnerCompat$SavedState;

    .line 693
    .local v1, "ss":Landroid/support/v7/internal/widget/SpinnerCompat$SavedState;
    invoke-virtual {v1}, Landroid/support/v7/internal/widget/SpinnerCompat$SavedState;->getSuperState()Landroid/os/Parcelable;

    move-result-object v3

    invoke-super {p0, v3}, Landroid/support/v7/internal/widget/AbsSpinnerCompat;->onRestoreInstanceState(Landroid/os/Parcelable;)V

    .line 695
    iget-boolean v3, v1, Landroid/support/v7/internal/widget/SpinnerCompat$SavedState;->showDropdown:Z

    if-eqz v3, :cond_0

    .line 696
    invoke-virtual {p0}, Landroid/support/v7/internal/widget/SpinnerCompat;->getViewTreeObserver()Landroid/view/ViewTreeObserver;

    move-result-object v2

    .line 697
    .local v2, "vto":Landroid/view/ViewTreeObserver;
    if-eqz v2, :cond_0

    .line 698
    new-instance v0, Landroid/support/v7/internal/widget/SpinnerCompat$2;

    invoke-direct {v0, p0}, Landroid/support/v7/internal/widget/SpinnerCompat$2;-><init>(Landroid/support/v7/internal/widget/SpinnerCompat;)V

    .line 711
    .local v0, "listener":Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;
    invoke-virtual {v2, v0}, Landroid/view/ViewTreeObserver;->addOnGlobalLayoutListener(Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;)V

    .line 714
    .end local v0    # "listener":Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;
    .end local v2    # "vto":Landroid/view/ViewTreeObserver;
    :cond_0
    return-void
.end method

.method public onSaveInstanceState()Landroid/os/Parcelable;
    .locals 2

    .prologue
    .line 684
    new-instance v0, Landroid/support/v7/internal/widget/SpinnerCompat$SavedState;

    invoke-super {p0}, Landroid/support/v7/internal/widget/AbsSpinnerCompat;->onSaveInstanceState()Landroid/os/Parcelable;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/support/v7/internal/widget/SpinnerCompat$SavedState;-><init>(Landroid/os/Parcelable;)V

    .line 685
    .local v0, "ss":Landroid/support/v7/internal/widget/SpinnerCompat$SavedState;
    iget-object v1, p0, Landroid/support/v7/internal/widget/SpinnerCompat;->mPopup:Landroid/support/v7/internal/widget/SpinnerCompat$SpinnerPopup;

    if-eqz v1, :cond_0

    iget-object v1, p0, Landroid/support/v7/internal/widget/SpinnerCompat;->mPopup:Landroid/support/v7/internal/widget/SpinnerCompat$SpinnerPopup;

    invoke-interface {v1}, Landroid/support/v7/internal/widget/SpinnerCompat$SpinnerPopup;->isShowing()Z

    move-result v1

    if-eqz v1, :cond_0

    const/4 v1, 0x1

    :goto_0
    iput-boolean v1, v0, Landroid/support/v7/internal/widget/SpinnerCompat$SavedState;->showDropdown:Z

    .line 686
    return-object v0

    .line 685
    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public onTouchEvent(Landroid/view/MotionEvent;)Z
    .locals 1
    .param p1, "event"    # Landroid/view/MotionEvent;

    .prologue
    .line 421
    iget-object v0, p0, Landroid/support/v7/internal/widget/SpinnerCompat;->mForwardingListener:Landroid/support/v7/widget/ListPopupWindow$ForwardingListener;

    if-eqz v0, :cond_0

    iget-object v0, p0, Landroid/support/v7/internal/widget/SpinnerCompat;->mForwardingListener:Landroid/support/v7/widget/ListPopupWindow$ForwardingListener;

    invoke-virtual {v0, p0, p1}, Landroid/support/v7/widget/ListPopupWindow$ForwardingListener;->onTouch(Landroid/view/View;Landroid/view/MotionEvent;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 422
    const/4 v0, 0x1

    .line 425
    :goto_0
    return v0

    :cond_0
    invoke-super {p0, p1}, Landroid/support/v7/internal/widget/AbsSpinnerCompat;->onTouchEvent(Landroid/view/MotionEvent;)Z

    move-result v0

    goto :goto_0
.end method

.method public performClick()Z
    .locals 2

    .prologue
    .line 597
    invoke-super {p0}, Landroid/support/v7/internal/widget/AbsSpinnerCompat;->performClick()Z

    move-result v0

    .line 599
    .local v0, "handled":Z
    if-nez v0, :cond_0

    .line 600
    const/4 v0, 0x1

    .line 602
    iget-object v1, p0, Landroid/support/v7/internal/widget/SpinnerCompat;->mPopup:Landroid/support/v7/internal/widget/SpinnerCompat$SpinnerPopup;

    invoke-interface {v1}, Landroid/support/v7/internal/widget/SpinnerCompat$SpinnerPopup;->isShowing()Z

    move-result v1

    if-nez v1, :cond_0

    .line 603
    iget-object v1, p0, Landroid/support/v7/internal/widget/SpinnerCompat;->mPopup:Landroid/support/v7/internal/widget/SpinnerCompat$SpinnerPopup;

    invoke-interface {v1}, Landroid/support/v7/internal/widget/SpinnerCompat$SpinnerPopup;->show()V

    .line 607
    :cond_0
    return v0
.end method

.method public bridge synthetic setAdapter(Landroid/widget/Adapter;)V
    .locals 0
    .param p1, "x0"    # Landroid/widget/Adapter;

    .prologue
    .line 53
    check-cast p1, Landroid/widget/SpinnerAdapter;

    .end local p1    # "x0":Landroid/widget/Adapter;
    invoke-virtual {p0, p1}, Landroid/support/v7/internal/widget/SpinnerCompat;->setAdapter(Landroid/widget/SpinnerAdapter;)V

    return-void
.end method

.method public setAdapter(Landroid/widget/SpinnerAdapter;)V
    .locals 3
    .param p1, "adapter"    # Landroid/widget/SpinnerAdapter;

    .prologue
    .line 360
    invoke-super {p0, p1}, Landroid/support/v7/internal/widget/AbsSpinnerCompat;->setAdapter(Landroid/widget/SpinnerAdapter;)V

    .line 362
    iget-object v1, p0, Landroid/support/v7/internal/widget/SpinnerCompat;->mRecycler:Landroid/support/v7/internal/widget/AbsSpinnerCompat$RecycleBin;

    invoke-virtual {v1}, Landroid/support/v7/internal/widget/AbsSpinnerCompat$RecycleBin;->clear()V

    .line 364
    invoke-virtual {p0}, Landroid/support/v7/internal/widget/SpinnerCompat;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/Context;->getApplicationInfo()Landroid/content/pm/ApplicationInfo;

    move-result-object v1

    iget v0, v1, Landroid/content/pm/ApplicationInfo;->targetSdkVersion:I

    .line 365
    .local v0, "targetSdkVersion":I
    const/16 v1, 0x15

    if-lt v0, v1, :cond_0

    if-eqz p1, :cond_0

    invoke-interface {p1}, Landroid/widget/SpinnerAdapter;->getViewTypeCount()I

    move-result v1

    const/4 v2, 0x1

    if-eq v1, v2, :cond_0

    .line 367
    new-instance v1, Ljava/lang/IllegalArgumentException;

    const-string v2, "Spinner adapter view type count must be 1"

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 369
    :cond_0
    iget-object v1, p0, Landroid/support/v7/internal/widget/SpinnerCompat;->mPopup:Landroid/support/v7/internal/widget/SpinnerCompat$SpinnerPopup;

    if-eqz v1, :cond_1

    .line 370
    iget-object v1, p0, Landroid/support/v7/internal/widget/SpinnerCompat;->mPopup:Landroid/support/v7/internal/widget/SpinnerCompat$SpinnerPopup;

    new-instance v2, Landroid/support/v7/internal/widget/SpinnerCompat$DropDownAdapter;

    invoke-direct {v2, p1}, Landroid/support/v7/internal/widget/SpinnerCompat$DropDownAdapter;-><init>(Landroid/widget/SpinnerAdapter;)V

    invoke-interface {v1, v2}, Landroid/support/v7/internal/widget/SpinnerCompat$SpinnerPopup;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 374
    :goto_0
    return-void

    .line 372
    :cond_1
    new-instance v1, Landroid/support/v7/internal/widget/SpinnerCompat$DropDownAdapter;

    invoke-direct {v1, p1}, Landroid/support/v7/internal/widget/SpinnerCompat$DropDownAdapter;-><init>(Landroid/widget/SpinnerAdapter;)V

    iput-object v1, p0, Landroid/support/v7/internal/widget/SpinnerCompat;->mTempAdapter:Landroid/support/v7/internal/widget/SpinnerCompat$DropDownAdapter;

    goto :goto_0
.end method

.method public setDropDownHorizontalOffset(I)V
    .locals 1
    .param p1, "pixels"    # I

    .prologue
    .line 288
    iget-object v0, p0, Landroid/support/v7/internal/widget/SpinnerCompat;->mPopup:Landroid/support/v7/internal/widget/SpinnerCompat$SpinnerPopup;

    invoke-interface {v0, p1}, Landroid/support/v7/internal/widget/SpinnerCompat$SpinnerPopup;->setHorizontalOffset(I)V

    .line 289
    return-void
.end method

.method public setDropDownVerticalOffset(I)V
    .locals 1
    .param p1, "pixels"    # I

    .prologue
    .line 268
    iget-object v0, p0, Landroid/support/v7/internal/widget/SpinnerCompat;->mPopup:Landroid/support/v7/internal/widget/SpinnerCompat$SpinnerPopup;

    invoke-interface {v0, p1}, Landroid/support/v7/internal/widget/SpinnerCompat$SpinnerPopup;->setVerticalOffset(I)V

    .line 269
    return-void
.end method

.method public setDropDownWidth(I)V
    .locals 2
    .param p1, "pixels"    # I

    .prologue
    .line 312
    iget-object v0, p0, Landroid/support/v7/internal/widget/SpinnerCompat;->mPopup:Landroid/support/v7/internal/widget/SpinnerCompat$SpinnerPopup;

    instance-of v0, v0, Landroid/support/v7/internal/widget/SpinnerCompat$DropdownPopup;

    if-nez v0, :cond_0

    .line 313
    const-string v0, "Spinner"

    const-string v1, "Cannot set dropdown width for MODE_DIALOG, ignoring"

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 317
    :goto_0
    return-void

    .line 316
    :cond_0
    iput p1, p0, Landroid/support/v7/internal/widget/SpinnerCompat;->mDropDownWidth:I

    goto :goto_0
.end method

.method public setEnabled(Z)V
    .locals 3
    .param p1, "enabled"    # Z

    .prologue
    .line 333
    invoke-super {p0, p1}, Landroid/support/v7/internal/widget/AbsSpinnerCompat;->setEnabled(Z)V

    .line 334
    iget-boolean v2, p0, Landroid/support/v7/internal/widget/SpinnerCompat;->mDisableChildrenWhenDisabled:Z

    if-eqz v2, :cond_0

    .line 335
    invoke-virtual {p0}, Landroid/support/v7/internal/widget/SpinnerCompat;->getChildCount()I

    move-result v0

    .line 336
    .local v0, "count":I
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    if-ge v1, v0, :cond_0

    .line 337
    invoke-virtual {p0, v1}, Landroid/support/v7/internal/widget/SpinnerCompat;->getChildAt(I)Landroid/view/View;

    move-result-object v2

    invoke-virtual {v2, p1}, Landroid/view/View;->setEnabled(Z)V

    .line 336
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 340
    .end local v0    # "count":I
    .end local v1    # "i":I
    :cond_0
    return-void
.end method

.method public setGravity(I)V
    .locals 1
    .param p1, "gravity"    # I

    .prologue
    .line 349
    iget v0, p0, Landroid/support/v7/internal/widget/SpinnerCompat;->mGravity:I

    if-eq v0, p1, :cond_1

    .line 350
    and-int/lit8 v0, p1, 0x7

    if-nez v0, :cond_0

    .line 351
    const v0, 0x800003

    or-int/2addr p1, v0

    .line 353
    :cond_0
    iput p1, p0, Landroid/support/v7/internal/widget/SpinnerCompat;->mGravity:I

    .line 354
    invoke-virtual {p0}, Landroid/support/v7/internal/widget/SpinnerCompat;->requestLayout()V

    .line 356
    :cond_1
    return-void
.end method

.method public setOnItemClickListener(Landroid/support/v7/internal/widget/AdapterViewCompat$OnItemClickListener;)V
    .locals 2
    .param p1, "l"    # Landroid/support/v7/internal/widget/AdapterViewCompat$OnItemClickListener;

    .prologue
    .line 412
    new-instance v0, Ljava/lang/RuntimeException;

    const-string v1, "setOnItemClickListener cannot be used with a spinner."

    invoke-direct {v0, v1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method setOnItemClickListenerInt(Landroid/support/v7/internal/widget/AdapterViewCompat$OnItemClickListener;)V
    .locals 0
    .param p1, "l"    # Landroid/support/v7/internal/widget/AdapterViewCompat$OnItemClickListener;

    .prologue
    .line 416
    invoke-super {p0, p1}, Landroid/support/v7/internal/widget/AbsSpinnerCompat;->setOnItemClickListener(Landroid/support/v7/internal/widget/AdapterViewCompat$OnItemClickListener;)V

    .line 417
    return-void
.end method

.method public setPopupBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V
    .locals 2
    .param p1, "background"    # Landroid/graphics/drawable/Drawable;

    .prologue
    .line 234
    iget-object v0, p0, Landroid/support/v7/internal/widget/SpinnerCompat;->mPopup:Landroid/support/v7/internal/widget/SpinnerCompat$SpinnerPopup;

    instance-of v0, v0, Landroid/support/v7/internal/widget/SpinnerCompat$DropdownPopup;

    if-nez v0, :cond_0

    .line 235
    const-string v0, "Spinner"

    const-string v1, "setPopupBackgroundDrawable: incompatible spinner mode; ignoring..."

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 239
    :goto_0
    return-void

    .line 238
    :cond_0
    iget-object v0, p0, Landroid/support/v7/internal/widget/SpinnerCompat;->mPopup:Landroid/support/v7/internal/widget/SpinnerCompat$SpinnerPopup;

    check-cast v0, Landroid/support/v7/internal/widget/SpinnerCompat$DropdownPopup;

    invoke-virtual {v0, p1}, Landroid/support/v7/internal/widget/SpinnerCompat$DropdownPopup;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    goto :goto_0
.end method

.method public setPopupBackgroundResource(I)V
    .locals 1
    .param p1, "resId"    # I

    .prologue
    .line 248
    iget-object v0, p0, Landroid/support/v7/internal/widget/SpinnerCompat;->mTintManager:Landroid/support/v7/internal/widget/TintManager;

    invoke-virtual {v0, p1}, Landroid/support/v7/internal/widget/TintManager;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    invoke-virtual {p0, v0}, Landroid/support/v7/internal/widget/SpinnerCompat;->setPopupBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 249
    return-void
.end method

.method public setPrompt(Ljava/lang/CharSequence;)V
    .locals 1
    .param p1, "prompt"    # Ljava/lang/CharSequence;

    .prologue
    .line 620
    iget-object v0, p0, Landroid/support/v7/internal/widget/SpinnerCompat;->mPopup:Landroid/support/v7/internal/widget/SpinnerCompat$SpinnerPopup;

    invoke-interface {v0, p1}, Landroid/support/v7/internal/widget/SpinnerCompat$SpinnerPopup;->setPromptText(Ljava/lang/CharSequence;)V

    .line 621
    return-void
.end method

.method public setPromptId(I)V
    .locals 1
    .param p1, "promptId"    # I

    .prologue
    .line 628
    invoke-virtual {p0}, Landroid/support/v7/internal/widget/SpinnerCompat;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-virtual {v0, p1}, Landroid/content/Context;->getText(I)Ljava/lang/CharSequence;

    move-result-object v0

    invoke-virtual {p0, v0}, Landroid/support/v7/internal/widget/SpinnerCompat;->setPrompt(Ljava/lang/CharSequence;)V

    .line 629
    return-void
.end method
