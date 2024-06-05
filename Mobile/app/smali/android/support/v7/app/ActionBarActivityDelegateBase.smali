.class Landroid/support/v7/app/ActionBarActivityDelegateBase;
.super Landroid/support/v7/app/ActionBarActivityDelegate;
.source "ActionBarActivityDelegateBase.java"

# interfaces
.implements Landroid/support/v7/internal/view/menu/MenuBuilder$Callback;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;,
        Landroid/support/v7/app/ActionBarActivityDelegateBase$ActionMenuPresenterCallback;,
        Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelMenuPresenterCallback;,
        Landroid/support/v7/app/ActionBarActivityDelegateBase$ActionModeCallbackWrapper;
    }
.end annotation


# static fields
.field private static final TAG:Ljava/lang/String; = "ActionBarActivityDelegateBase"


# instance fields
.field private mActionMenuPresenterCallback:Landroid/support/v7/app/ActionBarActivityDelegateBase$ActionMenuPresenterCallback;

.field mActionMode:Landroid/support/v7/view/ActionMode;

.field mActionModePopup:Landroid/widget/PopupWindow;

.field mActionModeView:Landroid/support/v7/internal/widget/ActionBarContextView;

.field private mClosingActionMenu:Z

.field private mDecorContentParent:Landroid/support/v7/internal/widget/DecorContentParent;

.field private mEnableDefaultActionBarUp:Z

.field private mFeatureIndeterminateProgress:Z

.field private mFeatureProgress:Z

.field private mInvalidatePanelMenuFeatures:I

.field private mInvalidatePanelMenuPosted:Z

.field private final mInvalidatePanelMenuRunnable:Ljava/lang/Runnable;

.field private mPanelMenuPresenterCallback:Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelMenuPresenterCallback;

.field private mPanels:[Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;

.field private mPreparedPanel:Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;

.field mShowActionModePopup:Ljava/lang/Runnable;

.field private mStatusGuard:Landroid/view/View;

.field private mSubDecor:Landroid/view/ViewGroup;

.field private mSubDecorInstalled:Z

.field private mTempRect1:Landroid/graphics/Rect;

.field private mTempRect2:Landroid/graphics/Rect;

.field private mTitleToSet:Ljava/lang/CharSequence;

.field private mToolbarListMenuPresenter:Landroid/support/v7/internal/view/menu/ListMenuPresenter;

.field private mWindowDecor:Landroid/view/ViewGroup;


# direct methods
.method constructor <init>(Landroid/support/v7/app/ActionBarActivity;)V
    .locals 1
    .param p1, "activity"    # Landroid/support/v7/app/ActionBarActivity;

    .prologue
    .line 133
    invoke-direct {p0, p1}, Landroid/support/v7/app/ActionBarActivityDelegate;-><init>(Landroid/support/v7/app/ActionBarActivity;)V

    .line 111
    new-instance v0, Landroid/support/v7/app/ActionBarActivityDelegateBase$1;

    invoke-direct {v0, p0}, Landroid/support/v7/app/ActionBarActivityDelegateBase$1;-><init>(Landroid/support/v7/app/ActionBarActivityDelegateBase;)V

    iput-object v0, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mInvalidatePanelMenuRunnable:Ljava/lang/Runnable;

    .line 134
    return-void
.end method

.method static synthetic access$000(Landroid/support/v7/app/ActionBarActivityDelegateBase;)I
    .locals 1
    .param p0, "x0"    # Landroid/support/v7/app/ActionBarActivityDelegateBase;

    .prologue
    .line 79
    iget v0, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mInvalidatePanelMenuFeatures:I

    return v0
.end method

.method static synthetic access$002(Landroid/support/v7/app/ActionBarActivityDelegateBase;I)I
    .locals 0
    .param p0, "x0"    # Landroid/support/v7/app/ActionBarActivityDelegateBase;
    .param p1, "x1"    # I

    .prologue
    .line 79
    iput p1, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mInvalidatePanelMenuFeatures:I

    return p1
.end method

.method static synthetic access$100(Landroid/support/v7/app/ActionBarActivityDelegateBase;I)V
    .locals 0
    .param p0, "x0"    # Landroid/support/v7/app/ActionBarActivityDelegateBase;
    .param p1, "x1"    # I

    .prologue
    .line 79
    invoke-direct {p0, p1}, Landroid/support/v7/app/ActionBarActivityDelegateBase;->doInvalidatePanelMenu(I)V

    return-void
.end method

.method static synthetic access$202(Landroid/support/v7/app/ActionBarActivityDelegateBase;Z)Z
    .locals 0
    .param p0, "x0"    # Landroid/support/v7/app/ActionBarActivityDelegateBase;
    .param p1, "x1"    # Z

    .prologue
    .line 79
    iput-boolean p1, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mInvalidatePanelMenuPosted:Z

    return p1
.end method

.method static synthetic access$300(Landroid/support/v7/app/ActionBarActivityDelegateBase;I)I
    .locals 1
    .param p0, "x0"    # Landroid/support/v7/app/ActionBarActivityDelegateBase;
    .param p1, "x1"    # I

    .prologue
    .line 79
    invoke-direct {p0, p1}, Landroid/support/v7/app/ActionBarActivityDelegateBase;->updateStatusGuard(I)I

    move-result v0

    return v0
.end method

.method static synthetic access$600(Landroid/support/v7/app/ActionBarActivityDelegateBase;Landroid/view/Menu;)Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;
    .locals 1
    .param p0, "x0"    # Landroid/support/v7/app/ActionBarActivityDelegateBase;
    .param p1, "x1"    # Landroid/view/Menu;

    .prologue
    .line 79
    invoke-direct {p0, p1}, Landroid/support/v7/app/ActionBarActivityDelegateBase;->findMenuPanel(Landroid/view/Menu;)Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$700(Landroid/support/v7/app/ActionBarActivityDelegateBase;ILandroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;Landroid/view/Menu;)V
    .locals 0
    .param p0, "x0"    # Landroid/support/v7/app/ActionBarActivityDelegateBase;
    .param p1, "x1"    # I
    .param p2, "x2"    # Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;
    .param p3, "x3"    # Landroid/view/Menu;

    .prologue
    .line 79
    invoke-direct {p0, p1, p2, p3}, Landroid/support/v7/app/ActionBarActivityDelegateBase;->callOnPanelClosed(ILandroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;Landroid/view/Menu;)V

    return-void
.end method

.method static synthetic access$800(Landroid/support/v7/app/ActionBarActivityDelegateBase;Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;Z)V
    .locals 0
    .param p0, "x0"    # Landroid/support/v7/app/ActionBarActivityDelegateBase;
    .param p1, "x1"    # Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;
    .param p2, "x2"    # Z

    .prologue
    .line 79
    invoke-direct {p0, p1, p2}, Landroid/support/v7/app/ActionBarActivityDelegateBase;->closePanel(Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;Z)V

    return-void
.end method

.method static synthetic access$900(Landroid/support/v7/app/ActionBarActivityDelegateBase;Landroid/support/v7/internal/view/menu/MenuBuilder;)V
    .locals 0
    .param p0, "x0"    # Landroid/support/v7/app/ActionBarActivityDelegateBase;
    .param p1, "x1"    # Landroid/support/v7/internal/view/menu/MenuBuilder;

    .prologue
    .line 79
    invoke-direct {p0, p1}, Landroid/support/v7/app/ActionBarActivityDelegateBase;->checkCloseActionMenu(Landroid/support/v7/internal/view/menu/MenuBuilder;)V

    return-void
.end method

.method private applyFixedSizeWindow()V
    .locals 13

    .prologue
    .line 381
    iget-object v11, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mActivity:Landroid/support/v7/app/ActionBarActivity;

    sget-object v12, Landroid/support/v7/appcompat/R$styleable;->Theme:[I

    invoke-virtual {v11, v12}, Landroid/support/v7/app/ActionBarActivity;->obtainStyledAttributes([I)Landroid/content/res/TypedArray;

    move-result-object v0

    .line 383
    .local v0, "a":Landroid/content/res/TypedArray;
    const/4 v5, 0x0

    .line 384
    .local v5, "mFixedWidthMajor":Landroid/util/TypedValue;
    const/4 v6, 0x0

    .line 385
    .local v6, "mFixedWidthMinor":Landroid/util/TypedValue;
    const/4 v3, 0x0

    .line 386
    .local v3, "mFixedHeightMajor":Landroid/util/TypedValue;
    const/4 v4, 0x0

    .line 388
    .local v4, "mFixedHeightMinor":Landroid/util/TypedValue;
    sget v11, Landroid/support/v7/appcompat/R$styleable;->Theme_windowFixedWidthMajor:I

    invoke-virtual {v0, v11}, Landroid/content/res/TypedArray;->hasValue(I)Z

    move-result v11

    if-eqz v11, :cond_1

    .line 389
    if-nez v5, :cond_0

    new-instance v5, Landroid/util/TypedValue;

    .end local v5    # "mFixedWidthMajor":Landroid/util/TypedValue;
    invoke-direct {v5}, Landroid/util/TypedValue;-><init>()V

    .line 390
    .restart local v5    # "mFixedWidthMajor":Landroid/util/TypedValue;
    :cond_0
    sget v11, Landroid/support/v7/appcompat/R$styleable;->Theme_windowFixedWidthMajor:I

    invoke-virtual {v0, v11, v5}, Landroid/content/res/TypedArray;->getValue(ILandroid/util/TypedValue;)Z

    .line 392
    :cond_1
    sget v11, Landroid/support/v7/appcompat/R$styleable;->Theme_windowFixedWidthMinor:I

    invoke-virtual {v0, v11}, Landroid/content/res/TypedArray;->hasValue(I)Z

    move-result v11

    if-eqz v11, :cond_3

    .line 393
    if-nez v6, :cond_2

    new-instance v6, Landroid/util/TypedValue;

    .end local v6    # "mFixedWidthMinor":Landroid/util/TypedValue;
    invoke-direct {v6}, Landroid/util/TypedValue;-><init>()V

    .line 394
    .restart local v6    # "mFixedWidthMinor":Landroid/util/TypedValue;
    :cond_2
    sget v11, Landroid/support/v7/appcompat/R$styleable;->Theme_windowFixedWidthMinor:I

    invoke-virtual {v0, v11, v6}, Landroid/content/res/TypedArray;->getValue(ILandroid/util/TypedValue;)Z

    .line 396
    :cond_3
    sget v11, Landroid/support/v7/appcompat/R$styleable;->Theme_windowFixedHeightMajor:I

    invoke-virtual {v0, v11}, Landroid/content/res/TypedArray;->hasValue(I)Z

    move-result v11

    if-eqz v11, :cond_5

    .line 397
    if-nez v3, :cond_4

    new-instance v3, Landroid/util/TypedValue;

    .end local v3    # "mFixedHeightMajor":Landroid/util/TypedValue;
    invoke-direct {v3}, Landroid/util/TypedValue;-><init>()V

    .line 398
    .restart local v3    # "mFixedHeightMajor":Landroid/util/TypedValue;
    :cond_4
    sget v11, Landroid/support/v7/appcompat/R$styleable;->Theme_windowFixedHeightMajor:I

    invoke-virtual {v0, v11, v3}, Landroid/content/res/TypedArray;->getValue(ILandroid/util/TypedValue;)Z

    .line 400
    :cond_5
    sget v11, Landroid/support/v7/appcompat/R$styleable;->Theme_windowFixedHeightMinor:I

    invoke-virtual {v0, v11}, Landroid/content/res/TypedArray;->hasValue(I)Z

    move-result v11

    if-eqz v11, :cond_7

    .line 401
    if-nez v4, :cond_6

    new-instance v4, Landroid/util/TypedValue;

    .end local v4    # "mFixedHeightMinor":Landroid/util/TypedValue;
    invoke-direct {v4}, Landroid/util/TypedValue;-><init>()V

    .line 402
    .restart local v4    # "mFixedHeightMinor":Landroid/util/TypedValue;
    :cond_6
    sget v11, Landroid/support/v7/appcompat/R$styleable;->Theme_windowFixedHeightMinor:I

    invoke-virtual {v0, v11, v4}, Landroid/content/res/TypedArray;->getValue(ILandroid/util/TypedValue;)Z

    .line 405
    :cond_7
    iget-object v11, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mActivity:Landroid/support/v7/app/ActionBarActivity;

    invoke-virtual {v11}, Landroid/support/v7/app/ActionBarActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v11

    invoke-virtual {v11}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v7

    .line 406
    .local v7, "metrics":Landroid/util/DisplayMetrics;
    iget v11, v7, Landroid/util/DisplayMetrics;->widthPixels:I

    iget v12, v7, Landroid/util/DisplayMetrics;->heightPixels:I

    if-ge v11, v12, :cond_c

    const/4 v2, 0x1

    .line 407
    .local v2, "isPortrait":Z
    :goto_0
    const/4 v10, -0x1

    .line 408
    .local v10, "w":I
    const/4 v1, -0x1

    .line 410
    .local v1, "h":I
    if-eqz v2, :cond_d

    move-object v9, v6

    .line 411
    .local v9, "tvw":Landroid/util/TypedValue;
    :goto_1
    if-eqz v9, :cond_8

    iget v11, v9, Landroid/util/TypedValue;->type:I

    if-eqz v11, :cond_8

    .line 412
    iget v11, v9, Landroid/util/TypedValue;->type:I

    const/4 v12, 0x5

    if-ne v11, v12, :cond_e

    .line 413
    invoke-virtual {v9, v7}, Landroid/util/TypedValue;->getDimension(Landroid/util/DisplayMetrics;)F

    move-result v11

    float-to-int v10, v11

    .line 419
    :cond_8
    :goto_2
    if-eqz v2, :cond_f

    move-object v8, v3

    .line 420
    .local v8, "tvh":Landroid/util/TypedValue;
    :goto_3
    if-eqz v8, :cond_9

    iget v11, v8, Landroid/util/TypedValue;->type:I

    if-eqz v11, :cond_9

    .line 421
    iget v11, v8, Landroid/util/TypedValue;->type:I

    const/4 v12, 0x5

    if-ne v11, v12, :cond_10

    .line 422
    invoke-virtual {v8, v7}, Landroid/util/TypedValue;->getDimension(Landroid/util/DisplayMetrics;)F

    move-result v11

    float-to-int v1, v11

    .line 428
    :cond_9
    :goto_4
    const/4 v11, -0x1

    if-ne v10, v11, :cond_a

    const/4 v11, -0x1

    if-eq v1, v11, :cond_b

    .line 429
    :cond_a
    iget-object v11, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mActivity:Landroid/support/v7/app/ActionBarActivity;

    invoke-virtual {v11}, Landroid/support/v7/app/ActionBarActivity;->getWindow()Landroid/view/Window;

    move-result-object v11

    invoke-virtual {v11, v10, v1}, Landroid/view/Window;->setLayout(II)V

    .line 432
    :cond_b
    invoke-virtual {v0}, Landroid/content/res/TypedArray;->recycle()V

    .line 433
    return-void

    .line 406
    .end local v1    # "h":I
    .end local v2    # "isPortrait":Z
    .end local v8    # "tvh":Landroid/util/TypedValue;
    .end local v9    # "tvw":Landroid/util/TypedValue;
    .end local v10    # "w":I
    :cond_c
    const/4 v2, 0x0

    goto :goto_0

    .restart local v1    # "h":I
    .restart local v2    # "isPortrait":Z
    .restart local v10    # "w":I
    :cond_d
    move-object v9, v5

    .line 410
    goto :goto_1

    .line 414
    .restart local v9    # "tvw":Landroid/util/TypedValue;
    :cond_e
    iget v11, v9, Landroid/util/TypedValue;->type:I

    const/4 v12, 0x6

    if-ne v11, v12, :cond_8

    .line 415
    iget v11, v7, Landroid/util/DisplayMetrics;->widthPixels:I

    int-to-float v11, v11

    iget v12, v7, Landroid/util/DisplayMetrics;->widthPixels:I

    int-to-float v12, v12

    invoke-virtual {v9, v11, v12}, Landroid/util/TypedValue;->getFraction(FF)F

    move-result v11

    float-to-int v10, v11

    goto :goto_2

    :cond_f
    move-object v8, v4

    .line 419
    goto :goto_3

    .line 423
    .restart local v8    # "tvh":Landroid/util/TypedValue;
    :cond_10
    iget v11, v8, Landroid/util/TypedValue;->type:I

    const/4 v12, 0x6

    if-ne v11, v12, :cond_9

    .line 424
    iget v11, v7, Landroid/util/DisplayMetrics;->heightPixels:I

    int-to-float v11, v11

    iget v12, v7, Landroid/util/DisplayMetrics;->heightPixels:I

    int-to-float v12, v12

    invoke-virtual {v8, v11, v12}, Landroid/util/TypedValue;->getFraction(FF)F

    move-result v11

    float-to-int v1, v11

    goto :goto_4
.end method

.method private callOnPanelClosed(ILandroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;Landroid/view/Menu;)V
    .locals 1
    .param p1, "featureId"    # I
    .param p2, "panel"    # Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;
    .param p3, "menu"    # Landroid/view/Menu;

    .prologue
    .line 1076
    if-nez p3, :cond_1

    .line 1078
    if-nez p2, :cond_0

    .line 1079
    if-ltz p1, :cond_0

    iget-object v0, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mPanels:[Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;

    array-length v0, v0

    if-ge p1, v0, :cond_0

    .line 1080
    iget-object v0, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mPanels:[Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;

    aget-object p2, v0, p1

    .line 1084
    :cond_0
    if-eqz p2, :cond_1

    .line 1086
    iget-object p3, p2, Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;->menu:Landroid/support/v7/internal/view/menu/MenuBuilder;

    .line 1091
    :cond_1
    if-eqz p2, :cond_2

    iget-boolean v0, p2, Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;->isOpen:Z

    if-nez v0, :cond_2

    .line 1095
    :goto_0
    return-void

    .line 1094
    :cond_2
    invoke-virtual {p0}, Landroid/support/v7/app/ActionBarActivityDelegateBase;->getWindowCallback()Landroid/support/v7/internal/app/WindowCallback;

    move-result-object v0

    invoke-interface {v0, p1, p3}, Landroid/support/v7/internal/app/WindowCallback;->onPanelClosed(ILandroid/view/Menu;)V

    goto :goto_0
.end method

.method private checkCloseActionMenu(Landroid/support/v7/internal/view/menu/MenuBuilder;)V
    .locals 2
    .param p1, "menu"    # Landroid/support/v7/internal/view/menu/MenuBuilder;

    .prologue
    .line 1032
    iget-boolean v1, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mClosingActionMenu:Z

    if-eqz v1, :cond_0

    .line 1043
    :goto_0
    return-void

    .line 1036
    :cond_0
    const/4 v1, 0x1

    iput-boolean v1, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mClosingActionMenu:Z

    .line 1037
    iget-object v1, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mDecorContentParent:Landroid/support/v7/internal/widget/DecorContentParent;

    invoke-interface {v1}, Landroid/support/v7/internal/widget/DecorContentParent;->dismissPopups()V

    .line 1038
    invoke-virtual {p0}, Landroid/support/v7/app/ActionBarActivityDelegateBase;->getWindowCallback()Landroid/support/v7/internal/app/WindowCallback;

    move-result-object v0

    .line 1039
    .local v0, "cb":Landroid/support/v7/internal/app/WindowCallback;
    if-eqz v0, :cond_1

    invoke-virtual {p0}, Landroid/support/v7/app/ActionBarActivityDelegateBase;->isDestroyed()Z

    move-result v1

    if-nez v1, :cond_1

    .line 1040
    const/16 v1, 0x8

    invoke-interface {v0, v1, p1}, Landroid/support/v7/internal/app/WindowCallback;->onPanelClosed(ILandroid/view/Menu;)V

    .line 1042
    :cond_1
    const/4 v1, 0x0

    iput-boolean v1, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mClosingActionMenu:Z

    goto :goto_0
.end method

.method private closePanel(Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;Z)V
    .locals 3
    .param p1, "st"    # Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;
    .param p2, "doCallback"    # Z

    .prologue
    const/4 v2, 0x0

    const/4 v1, 0x0

    .line 1046
    if-eqz p2, :cond_1

    iget v0, p1, Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;->featureId:I

    if-nez v0, :cond_1

    iget-object v0, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mDecorContentParent:Landroid/support/v7/internal/widget/DecorContentParent;

    if-eqz v0, :cond_1

    iget-object v0, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mDecorContentParent:Landroid/support/v7/internal/widget/DecorContentParent;

    invoke-interface {v0}, Landroid/support/v7/internal/widget/DecorContentParent;->isOverflowMenuShowing()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 1048
    iget-object v0, p1, Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;->menu:Landroid/support/v7/internal/view/menu/MenuBuilder;

    invoke-direct {p0, v0}, Landroid/support/v7/app/ActionBarActivityDelegateBase;->checkCloseActionMenu(Landroid/support/v7/internal/view/menu/MenuBuilder;)V

    .line 1072
    :cond_0
    :goto_0
    return-void

    .line 1052
    :cond_1
    iget-boolean v0, p1, Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;->isOpen:Z

    if-eqz v0, :cond_2

    .line 1053
    if-eqz p2, :cond_2

    .line 1054
    iget v0, p1, Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;->featureId:I

    invoke-direct {p0, v0, p1, v2}, Landroid/support/v7/app/ActionBarActivityDelegateBase;->callOnPanelClosed(ILandroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;Landroid/view/Menu;)V

    .line 1058
    :cond_2
    iput-boolean v1, p1, Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;->isPrepared:Z

    .line 1059
    iput-boolean v1, p1, Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;->isHandled:Z

    .line 1060
    iput-boolean v1, p1, Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;->isOpen:Z

    .line 1063
    iput-object v2, p1, Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;->shownPanelView:Landroid/view/View;

    .line 1067
    const/4 v0, 0x1

    iput-boolean v0, p1, Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;->refreshDecorView:Z

    .line 1069
    iget-object v0, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mPreparedPanel:Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;

    if-ne v0, p1, :cond_0

    .line 1070
    iput-object v2, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mPreparedPanel:Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;

    goto :goto_0
.end method

.method private doInvalidatePanelMenu(I)V
    .locals 5
    .param p1, "featureId"    # I

    .prologue
    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 1161
    invoke-direct {p0, p1, v4}, Landroid/support/v7/app/ActionBarActivityDelegateBase;->getPanelState(IZ)Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;

    move-result-object v1

    .line 1162
    .local v1, "st":Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;
    const/4 v0, 0x0

    .line 1163
    .local v0, "savedActionViewStates":Landroid/os/Bundle;
    iget-object v2, v1, Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;->menu:Landroid/support/v7/internal/view/menu/MenuBuilder;

    if-eqz v2, :cond_1

    .line 1164
    new-instance v0, Landroid/os/Bundle;

    .end local v0    # "savedActionViewStates":Landroid/os/Bundle;
    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 1165
    .restart local v0    # "savedActionViewStates":Landroid/os/Bundle;
    iget-object v2, v1, Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;->menu:Landroid/support/v7/internal/view/menu/MenuBuilder;

    invoke-virtual {v2, v0}, Landroid/support/v7/internal/view/menu/MenuBuilder;->saveActionViewStates(Landroid/os/Bundle;)V

    .line 1166
    invoke-virtual {v0}, Landroid/os/Bundle;->size()I

    move-result v2

    if-lez v2, :cond_0

    .line 1167
    iput-object v0, v1, Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;->frozenActionViewState:Landroid/os/Bundle;

    .line 1170
    :cond_0
    iget-object v2, v1, Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;->menu:Landroid/support/v7/internal/view/menu/MenuBuilder;

    invoke-virtual {v2}, Landroid/support/v7/internal/view/menu/MenuBuilder;->stopDispatchingItemsChanged()V

    .line 1171
    iget-object v2, v1, Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;->menu:Landroid/support/v7/internal/view/menu/MenuBuilder;

    invoke-virtual {v2}, Landroid/support/v7/internal/view/menu/MenuBuilder;->clear()V

    .line 1173
    :cond_1
    iput-boolean v4, v1, Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;->refreshMenuContent:Z

    .line 1174
    iput-boolean v4, v1, Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;->refreshDecorView:Z

    .line 1177
    const/16 v2, 0x8

    if-eq p1, v2, :cond_2

    if-nez p1, :cond_3

    :cond_2
    iget-object v2, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mDecorContentParent:Landroid/support/v7/internal/widget/DecorContentParent;

    if-eqz v2, :cond_3

    .line 1179
    invoke-direct {p0, v3, v3}, Landroid/support/v7/app/ActionBarActivityDelegateBase;->getPanelState(IZ)Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;

    move-result-object v1

    .line 1180
    if-eqz v1, :cond_3

    .line 1181
    iput-boolean v3, v1, Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;->isPrepared:Z

    .line 1182
    const/4 v2, 0x0

    invoke-direct {p0, v1, v2}, Landroid/support/v7/app/ActionBarActivityDelegateBase;->preparePanel(Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;Landroid/view/KeyEvent;)Z

    .line 1185
    :cond_3
    return-void
.end method

.method private ensureToolbarListMenuPresenter()V
    .locals 5

    .prologue
    .line 1264
    iget-object v2, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mToolbarListMenuPresenter:Landroid/support/v7/internal/view/menu/ListMenuPresenter;

    if-nez v2, :cond_0

    .line 1266
    new-instance v1, Landroid/util/TypedValue;

    invoke-direct {v1}, Landroid/util/TypedValue;-><init>()V

    .line 1267
    .local v1, "outValue":Landroid/util/TypedValue;
    iget-object v2, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mActivity:Landroid/support/v7/app/ActionBarActivity;

    invoke-virtual {v2}, Landroid/support/v7/app/ActionBarActivity;->getTheme()Landroid/content/res/Resources$Theme;

    move-result-object v2

    sget v3, Landroid/support/v7/appcompat/R$attr;->panelMenuListTheme:I

    const/4 v4, 0x1

    invoke-virtual {v2, v3, v1, v4}, Landroid/content/res/Resources$Theme;->resolveAttribute(ILandroid/util/TypedValue;Z)Z

    .line 1269
    new-instance v0, Landroid/view/ContextThemeWrapper;

    iget-object v3, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mActivity:Landroid/support/v7/app/ActionBarActivity;

    iget v2, v1, Landroid/util/TypedValue;->resourceId:I

    if-eqz v2, :cond_1

    iget v2, v1, Landroid/util/TypedValue;->resourceId:I

    :goto_0
    invoke-direct {v0, v3, v2}, Landroid/view/ContextThemeWrapper;-><init>(Landroid/content/Context;I)V

    .line 1274
    .local v0, "context":Landroid/content/Context;
    new-instance v2, Landroid/support/v7/internal/view/menu/ListMenuPresenter;

    sget v3, Landroid/support/v7/appcompat/R$layout;->abc_list_menu_item_layout:I

    invoke-direct {v2, v0, v3}, Landroid/support/v7/internal/view/menu/ListMenuPresenter;-><init>(Landroid/content/Context;I)V

    iput-object v2, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mToolbarListMenuPresenter:Landroid/support/v7/internal/view/menu/ListMenuPresenter;

    .line 1277
    .end local v0    # "context":Landroid/content/Context;
    .end local v1    # "outValue":Landroid/util/TypedValue;
    :cond_0
    return-void

    .line 1269
    .restart local v1    # "outValue":Landroid/util/TypedValue;
    :cond_1
    sget v2, Landroid/support/v7/appcompat/R$style;->Theme_AppCompat_CompactMenu:I

    goto :goto_0
.end method

.method private findMenuPanel(Landroid/view/Menu;)Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;
    .locals 5
    .param p1, "menu"    # Landroid/view/Menu;

    .prologue
    .line 1098
    iget-object v3, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mPanels:[Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;

    .line 1099
    .local v3, "panels":[Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;
    if-eqz v3, :cond_0

    array-length v0, v3

    .line 1100
    .local v0, "N":I
    :goto_0
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_1
    if-ge v1, v0, :cond_2

    .line 1101
    aget-object v2, v3, v1

    .line 1102
    .local v2, "panel":Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;
    if-eqz v2, :cond_1

    iget-object v4, v2, Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;->menu:Landroid/support/v7/internal/view/menu/MenuBuilder;

    if-ne v4, p1, :cond_1

    .line 1106
    .end local v2    # "panel":Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;
    :goto_2
    return-object v2

    .line 1099
    .end local v0    # "N":I
    .end local v1    # "i":I
    :cond_0
    const/4 v0, 0x0

    goto :goto_0

    .line 1100
    .restart local v0    # "N":I
    .restart local v1    # "i":I
    .restart local v2    # "panel":Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;
    :cond_1
    add-int/lit8 v1, v1, 0x1

    goto :goto_1

    .line 1106
    .end local v2    # "panel":Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;
    :cond_2
    const/4 v2, 0x0

    goto :goto_2
.end method

.method private getPanelState(IZ)Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;
    .locals 5
    .param p1, "featureId"    # I
    .param p2, "required"    # Z

    .prologue
    const/4 v4, 0x0

    .line 1111
    iget-object v0, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mPanels:[Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;

    .local v0, "ar":[Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;
    if-eqz v0, :cond_0

    array-length v3, v0

    if-gt v3, p1, :cond_2

    .line 1112
    :cond_0
    add-int/lit8 v3, p1, 0x1

    new-array v1, v3, [Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;

    .line 1113
    .local v1, "nar":[Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;
    if-eqz v0, :cond_1

    .line 1114
    array-length v3, v0

    invoke-static {v0, v4, v1, v4, v3}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 1116
    :cond_1
    move-object v0, v1

    iput-object v1, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mPanels:[Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;

    .line 1119
    .end local v1    # "nar":[Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;
    :cond_2
    aget-object v2, v0, p1

    .line 1120
    .local v2, "st":Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;
    if-nez v2, :cond_3

    .line 1121
    new-instance v2, Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;

    .end local v2    # "st":Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;
    invoke-direct {v2, p1}, Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;-><init>(I)V

    .restart local v2    # "st":Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;
    aput-object v2, v0, p1

    .line 1123
    :cond_3
    return-object v2
.end method

.method private initializePanelContent(Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;)Z
    .locals 4
    .param p1, "st"    # Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;

    .prologue
    const/4 v1, 0x0

    .line 922
    iget-object v2, p1, Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;->menu:Landroid/support/v7/internal/view/menu/MenuBuilder;

    if-nez v2, :cond_1

    .line 934
    :cond_0
    :goto_0
    return v1

    .line 926
    :cond_1
    iget-object v2, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mPanelMenuPresenterCallback:Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelMenuPresenterCallback;

    if-nez v2, :cond_2

    .line 927
    new-instance v2, Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelMenuPresenterCallback;

    const/4 v3, 0x0

    invoke-direct {v2, p0, v3}, Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelMenuPresenterCallback;-><init>(Landroid/support/v7/app/ActionBarActivityDelegateBase;Landroid/support/v7/app/ActionBarActivityDelegateBase$1;)V

    iput-object v2, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mPanelMenuPresenterCallback:Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelMenuPresenterCallback;

    .line 930
    :cond_2
    iget-object v2, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mPanelMenuPresenterCallback:Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelMenuPresenterCallback;

    invoke-virtual {p1, v2}, Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;->getListMenuView(Landroid/support/v7/internal/view/menu/MenuPresenter$Callback;)Landroid/support/v7/internal/view/menu/MenuView;

    move-result-object v0

    .line 932
    .local v0, "menuView":Landroid/support/v7/internal/view/menu/MenuView;
    check-cast v0, Landroid/view/View;

    .end local v0    # "menuView":Landroid/support/v7/internal/view/menu/MenuView;
    iput-object v0, p1, Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;->shownPanelView:Landroid/view/View;

    .line 934
    iget-object v2, p1, Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;->shownPanelView:Landroid/view/View;

    if-eqz v2, :cond_0

    const/4 v1, 0x1

    goto :goto_0
.end method

.method private initializePanelDecor(Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;)V
    .locals 1
    .param p1, "st"    # Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;

    .prologue
    .line 830
    iget-object v0, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mWindowDecor:Landroid/view/ViewGroup;

    iput-object v0, p1, Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;->decorView:Landroid/view/ViewGroup;

    .line 831
    invoke-virtual {p0}, Landroid/support/v7/app/ActionBarActivityDelegateBase;->getActionBarThemedContext()Landroid/content/Context;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;->setStyle(Landroid/content/Context;)V

    .line 832
    return-void
.end method

.method private initializePanelMenu(Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;)Z
    .locals 9
    .param p1, "st"    # Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;

    .prologue
    const/4 v8, 0x1

    .line 879
    iget-object v1, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mActivity:Landroid/support/v7/app/ActionBarActivity;

    .line 882
    .local v1, "context":Landroid/content/Context;
    iget v6, p1, Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;->featureId:I

    if-eqz v6, :cond_0

    iget v6, p1, Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;->featureId:I

    const/16 v7, 0x8

    if-ne v6, v7, :cond_3

    :cond_0
    iget-object v6, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mDecorContentParent:Landroid/support/v7/internal/widget/DecorContentParent;

    if-eqz v6, :cond_3

    .line 884
    new-instance v4, Landroid/util/TypedValue;

    invoke-direct {v4}, Landroid/util/TypedValue;-><init>()V

    .line 885
    .local v4, "outValue":Landroid/util/TypedValue;
    invoke-virtual {v1}, Landroid/content/Context;->getTheme()Landroid/content/res/Resources$Theme;

    move-result-object v0

    .line 886
    .local v0, "baseTheme":Landroid/content/res/Resources$Theme;
    sget v6, Landroid/support/v7/appcompat/R$attr;->actionBarTheme:I

    invoke-virtual {v0, v6, v4, v8}, Landroid/content/res/Resources$Theme;->resolveAttribute(ILandroid/util/TypedValue;Z)Z

    .line 888
    const/4 v5, 0x0

    .line 889
    .local v5, "widgetTheme":Landroid/content/res/Resources$Theme;
    iget v6, v4, Landroid/util/TypedValue;->resourceId:I

    if-eqz v6, :cond_4

    .line 890
    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v6

    invoke-virtual {v6}, Landroid/content/res/Resources;->newTheme()Landroid/content/res/Resources$Theme;

    move-result-object v5

    .line 891
    invoke-virtual {v5, v0}, Landroid/content/res/Resources$Theme;->setTo(Landroid/content/res/Resources$Theme;)V

    .line 892
    iget v6, v4, Landroid/util/TypedValue;->resourceId:I

    invoke-virtual {v5, v6, v8}, Landroid/content/res/Resources$Theme;->applyStyle(IZ)V

    .line 893
    sget v6, Landroid/support/v7/appcompat/R$attr;->actionBarWidgetTheme:I

    invoke-virtual {v5, v6, v4, v8}, Landroid/content/res/Resources$Theme;->resolveAttribute(ILandroid/util/TypedValue;Z)Z

    .line 900
    :goto_0
    iget v6, v4, Landroid/util/TypedValue;->resourceId:I

    if-eqz v6, :cond_2

    .line 901
    if-nez v5, :cond_1

    .line 902
    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v6

    invoke-virtual {v6}, Landroid/content/res/Resources;->newTheme()Landroid/content/res/Resources$Theme;

    move-result-object v5

    .line 903
    invoke-virtual {v5, v0}, Landroid/content/res/Resources$Theme;->setTo(Landroid/content/res/Resources$Theme;)V

    .line 905
    :cond_1
    iget v6, v4, Landroid/util/TypedValue;->resourceId:I

    invoke-virtual {v5, v6, v8}, Landroid/content/res/Resources$Theme;->applyStyle(IZ)V

    .line 908
    :cond_2
    if-eqz v5, :cond_3

    .line 909
    new-instance v2, Landroid/view/ContextThemeWrapper;

    const/4 v6, 0x0

    invoke-direct {v2, v1, v6}, Landroid/view/ContextThemeWrapper;-><init>(Landroid/content/Context;I)V

    .line 910
    .end local v1    # "context":Landroid/content/Context;
    .local v2, "context":Landroid/content/Context;
    invoke-virtual {v2}, Landroid/content/Context;->getTheme()Landroid/content/res/Resources$Theme;

    move-result-object v6

    invoke-virtual {v6, v5}, Landroid/content/res/Resources$Theme;->setTo(Landroid/content/res/Resources$Theme;)V

    move-object v1, v2

    .line 914
    .end local v0    # "baseTheme":Landroid/content/res/Resources$Theme;
    .end local v2    # "context":Landroid/content/Context;
    .end local v4    # "outValue":Landroid/util/TypedValue;
    .end local v5    # "widgetTheme":Landroid/content/res/Resources$Theme;
    .restart local v1    # "context":Landroid/content/Context;
    :cond_3
    new-instance v3, Landroid/support/v7/internal/view/menu/MenuBuilder;

    invoke-direct {v3, v1}, Landroid/support/v7/internal/view/menu/MenuBuilder;-><init>(Landroid/content/Context;)V

    .line 915
    .local v3, "menu":Landroid/support/v7/internal/view/menu/MenuBuilder;
    invoke-virtual {v3, p0}, Landroid/support/v7/internal/view/menu/MenuBuilder;->setCallback(Landroid/support/v7/internal/view/menu/MenuBuilder$Callback;)V

    .line 916
    invoke-virtual {p1, v3}, Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;->setMenu(Landroid/support/v7/internal/view/menu/MenuBuilder;)V

    .line 918
    return v8

    .line 896
    .end local v3    # "menu":Landroid/support/v7/internal/view/menu/MenuBuilder;
    .restart local v0    # "baseTheme":Landroid/content/res/Resources$Theme;
    .restart local v4    # "outValue":Landroid/util/TypedValue;
    .restart local v5    # "widgetTheme":Landroid/content/res/Resources$Theme;
    :cond_4
    sget v6, Landroid/support/v7/appcompat/R$attr;->actionBarWidgetTheme:I

    invoke-virtual {v0, v6, v4, v8}, Landroid/content/res/Resources$Theme;->resolveAttribute(ILandroid/util/TypedValue;Z)Z

    goto :goto_0
.end method

.method private invalidatePanelMenu(I)V
    .locals 3
    .param p1, "featureId"    # I

    .prologue
    const/4 v2, 0x1

    .line 1152
    iget v0, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mInvalidatePanelMenuFeatures:I

    shl-int v1, v2, p1

    or-int/2addr v0, v1

    iput v0, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mInvalidatePanelMenuFeatures:I

    .line 1154
    iget-boolean v0, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mInvalidatePanelMenuPosted:Z

    if-nez v0, :cond_0

    iget-object v0, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mWindowDecor:Landroid/view/ViewGroup;

    if-eqz v0, :cond_0

    .line 1155
    iget-object v0, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mWindowDecor:Landroid/view/ViewGroup;

    iget-object v1, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mInvalidatePanelMenuRunnable:Ljava/lang/Runnable;

    invoke-static {v0, v1}, Landroid/support/v4/view/ViewCompat;->postOnAnimation(Landroid/view/View;Ljava/lang/Runnable;)V

    .line 1156
    iput-boolean v2, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mInvalidatePanelMenuPosted:Z

    .line 1158
    :cond_0
    return-void
.end method

.method private openPanel(ILandroid/view/KeyEvent;)V
    .locals 1
    .param p1, "featureId"    # I
    .param p2, "event"    # Landroid/view/KeyEvent;

    .prologue
    .line 774
    if-nez p1, :cond_0

    iget-object v0, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mDecorContentParent:Landroid/support/v7/internal/widget/DecorContentParent;

    if-eqz v0, :cond_0

    iget-object v0, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mDecorContentParent:Landroid/support/v7/internal/widget/DecorContentParent;

    invoke-interface {v0}, Landroid/support/v7/internal/widget/DecorContentParent;->canShowOverflowMenu()Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mActivity:Landroid/support/v7/app/ActionBarActivity;

    invoke-static {v0}, Landroid/view/ViewConfiguration;->get(Landroid/content/Context;)Landroid/view/ViewConfiguration;

    move-result-object v0

    invoke-static {v0}, Landroid/support/v4/view/ViewConfigurationCompat;->hasPermanentMenuKey(Landroid/view/ViewConfiguration;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 777
    iget-object v0, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mDecorContentParent:Landroid/support/v7/internal/widget/DecorContentParent;

    invoke-interface {v0}, Landroid/support/v7/internal/widget/DecorContentParent;->showOverflowMenu()Z

    .line 781
    :goto_0
    return-void

    .line 779
    :cond_0
    const/4 v0, 0x1

    invoke-direct {p0, p1, v0}, Landroid/support/v7/app/ActionBarActivityDelegateBase;->getPanelState(IZ)Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;

    move-result-object v0

    invoke-direct {p0, v0, p2}, Landroid/support/v7/app/ActionBarActivityDelegateBase;->openPanel(Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;Landroid/view/KeyEvent;)V

    goto :goto_0
.end method

.method private openPanel(Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;Landroid/view/KeyEvent;)V
    .locals 9
    .param p1, "st"    # Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;
    .param p2, "event"    # Landroid/view/KeyEvent;

    .prologue
    const/4 v6, 0x0

    const/4 v5, 0x1

    .line 785
    iget-boolean v7, p1, Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;->isOpen:Z

    if-nez v7, :cond_0

    invoke-virtual {p0}, Landroid/support/v7/app/ActionBarActivityDelegateBase;->isDestroyed()Z

    move-result v7

    if-eqz v7, :cond_1

    .line 827
    :cond_0
    :goto_0
    return-void

    .line 791
    :cond_1
    iget v7, p1, Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;->featureId:I

    if-nez v7, :cond_2

    .line 792
    iget-object v2, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mActivity:Landroid/support/v7/app/ActionBarActivity;

    .line 793
    .local v2, "context":Landroid/content/Context;
    invoke-virtual {v2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v7

    invoke-virtual {v7}, Landroid/content/res/Resources;->getConfiguration()Landroid/content/res/Configuration;

    move-result-object v1

    .line 794
    .local v1, "config":Landroid/content/res/Configuration;
    iget v7, v1, Landroid/content/res/Configuration;->screenLayout:I

    and-int/lit8 v7, v7, 0xf

    const/4 v8, 0x4

    if-ne v7, v8, :cond_3

    move v4, v5

    .line 796
    .local v4, "isXLarge":Z
    :goto_1
    invoke-virtual {v2}, Landroid/content/Context;->getApplicationInfo()Landroid/content/pm/ApplicationInfo;

    move-result-object v7

    iget v7, v7, Landroid/content/pm/ApplicationInfo;->targetSdkVersion:I

    const/16 v8, 0xb

    if-lt v7, v8, :cond_4

    move v3, v5

    .line 799
    .local v3, "isHoneycombApp":Z
    :goto_2
    if-eqz v4, :cond_2

    if-nez v3, :cond_0

    .line 804
    .end local v1    # "config":Landroid/content/res/Configuration;
    .end local v2    # "context":Landroid/content/Context;
    .end local v3    # "isHoneycombApp":Z
    .end local v4    # "isXLarge":Z
    :cond_2
    invoke-virtual {p0}, Landroid/support/v7/app/ActionBarActivityDelegateBase;->getWindowCallback()Landroid/support/v7/internal/app/WindowCallback;

    move-result-object v0

    .line 805
    .local v0, "cb":Landroid/support/v7/internal/app/WindowCallback;
    if-eqz v0, :cond_5

    iget v7, p1, Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;->featureId:I

    iget-object v8, p1, Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;->menu:Landroid/support/v7/internal/view/menu/MenuBuilder;

    invoke-interface {v0, v7, v8}, Landroid/support/v7/internal/app/WindowCallback;->onMenuOpened(ILandroid/view/Menu;)Z

    move-result v7

    if-nez v7, :cond_5

    .line 807
    invoke-direct {p0, p1, v5}, Landroid/support/v7/app/ActionBarActivityDelegateBase;->closePanel(Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;Z)V

    goto :goto_0

    .end local v0    # "cb":Landroid/support/v7/internal/app/WindowCallback;
    .restart local v1    # "config":Landroid/content/res/Configuration;
    .restart local v2    # "context":Landroid/content/Context;
    :cond_3
    move v4, v6

    .line 794
    goto :goto_1

    .restart local v4    # "isXLarge":Z
    :cond_4
    move v3, v6

    .line 796
    goto :goto_2

    .line 812
    .end local v1    # "config":Landroid/content/res/Configuration;
    .end local v2    # "context":Landroid/content/Context;
    .end local v4    # "isXLarge":Z
    .restart local v0    # "cb":Landroid/support/v7/internal/app/WindowCallback;
    :cond_5
    invoke-direct {p0, p1, p2}, Landroid/support/v7/app/ActionBarActivityDelegateBase;->preparePanel(Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;Landroid/view/KeyEvent;)Z

    move-result v7

    if-eqz v7, :cond_0

    .line 816
    iget-object v7, p1, Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;->decorView:Landroid/view/ViewGroup;

    if-eqz v7, :cond_6

    iget-boolean v7, p1, Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;->refreshDecorView:Z

    if-eqz v7, :cond_7

    .line 817
    :cond_6
    invoke-direct {p0, p1}, Landroid/support/v7/app/ActionBarActivityDelegateBase;->initializePanelDecor(Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;)V

    .line 821
    :cond_7
    invoke-direct {p0, p1}, Landroid/support/v7/app/ActionBarActivityDelegateBase;->initializePanelContent(Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;)Z

    move-result v7

    if-eqz v7, :cond_0

    invoke-virtual {p1}, Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;->hasPanelItems()Z

    move-result v7

    if-eqz v7, :cond_0

    .line 825
    iput-boolean v6, p1, Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;->isHandled:Z

    .line 826
    iput-boolean v5, p1, Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;->isOpen:Z

    goto :goto_0
.end method

.method private preparePanel(Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;Landroid/view/KeyEvent;)Z
    .locals 8
    .param p1, "st"    # Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;
    .param p2, "event"    # Landroid/view/KeyEvent;

    .prologue
    const/4 v7, 0x0

    const/4 v3, 0x1

    const/4 v4, 0x0

    .line 938
    invoke-virtual {p0}, Landroid/support/v7/app/ActionBarActivityDelegateBase;->isDestroyed()Z

    move-result v2

    if-eqz v2, :cond_1

    .line 1028
    :cond_0
    :goto_0
    return v4

    .line 943
    :cond_1
    iget-boolean v2, p1, Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;->isPrepared:Z

    if-eqz v2, :cond_2

    move v4, v3

    .line 944
    goto :goto_0

    .line 947
    :cond_2
    iget-object v2, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mPreparedPanel:Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;

    if-eqz v2, :cond_3

    iget-object v2, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mPreparedPanel:Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;

    if-eq v2, p1, :cond_3

    .line 949
    iget-object v2, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mPreparedPanel:Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;

    invoke-direct {p0, v2, v4}, Landroid/support/v7/app/ActionBarActivityDelegateBase;->closePanel(Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;Z)V

    .line 952
    :cond_3
    iget v2, p1, Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;->featureId:I

    if-eqz v2, :cond_4

    iget v2, p1, Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;->featureId:I

    const/16 v5, 0x8

    if-ne v2, v5, :cond_a

    :cond_4
    move v0, v3

    .line 955
    .local v0, "isActionBarMenu":Z
    :goto_1
    if-eqz v0, :cond_5

    iget-object v2, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mDecorContentParent:Landroid/support/v7/internal/widget/DecorContentParent;

    if-eqz v2, :cond_5

    .line 958
    iget-object v2, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mDecorContentParent:Landroid/support/v7/internal/widget/DecorContentParent;

    invoke-interface {v2}, Landroid/support/v7/internal/widget/DecorContentParent;->setMenuPrepared()V

    .line 962
    :cond_5
    iget-object v2, p1, Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;->menu:Landroid/support/v7/internal/view/menu/MenuBuilder;

    if-eqz v2, :cond_6

    iget-boolean v2, p1, Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;->refreshMenuContent:Z

    if-eqz v2, :cond_c

    .line 963
    :cond_6
    iget-object v2, p1, Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;->menu:Landroid/support/v7/internal/view/menu/MenuBuilder;

    if-nez v2, :cond_7

    .line 964
    invoke-direct {p0, p1}, Landroid/support/v7/app/ActionBarActivityDelegateBase;->initializePanelMenu(Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;)Z

    move-result v2

    if-eqz v2, :cond_0

    iget-object v2, p1, Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;->menu:Landroid/support/v7/internal/view/menu/MenuBuilder;

    if-eqz v2, :cond_0

    .line 969
    :cond_7
    if-eqz v0, :cond_9

    iget-object v2, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mDecorContentParent:Landroid/support/v7/internal/widget/DecorContentParent;

    if-eqz v2, :cond_9

    .line 970
    iget-object v2, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mActionMenuPresenterCallback:Landroid/support/v7/app/ActionBarActivityDelegateBase$ActionMenuPresenterCallback;

    if-nez v2, :cond_8

    .line 971
    new-instance v2, Landroid/support/v7/app/ActionBarActivityDelegateBase$ActionMenuPresenterCallback;

    invoke-direct {v2, p0, v7}, Landroid/support/v7/app/ActionBarActivityDelegateBase$ActionMenuPresenterCallback;-><init>(Landroid/support/v7/app/ActionBarActivityDelegateBase;Landroid/support/v7/app/ActionBarActivityDelegateBase$1;)V

    iput-object v2, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mActionMenuPresenterCallback:Landroid/support/v7/app/ActionBarActivityDelegateBase$ActionMenuPresenterCallback;

    .line 973
    :cond_8
    iget-object v2, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mDecorContentParent:Landroid/support/v7/internal/widget/DecorContentParent;

    iget-object v5, p1, Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;->menu:Landroid/support/v7/internal/view/menu/MenuBuilder;

    iget-object v6, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mActionMenuPresenterCallback:Landroid/support/v7/app/ActionBarActivityDelegateBase$ActionMenuPresenterCallback;

    invoke-interface {v2, v5, v6}, Landroid/support/v7/internal/widget/DecorContentParent;->setMenu(Landroid/view/Menu;Landroid/support/v7/internal/view/menu/MenuPresenter$Callback;)V

    .line 978
    :cond_9
    iget-object v2, p1, Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;->menu:Landroid/support/v7/internal/view/menu/MenuBuilder;

    invoke-virtual {v2}, Landroid/support/v7/internal/view/menu/MenuBuilder;->stopDispatchingItemsChanged()V

    .line 979
    invoke-virtual {p0}, Landroid/support/v7/app/ActionBarActivityDelegateBase;->getWindowCallback()Landroid/support/v7/internal/app/WindowCallback;

    move-result-object v2

    iget v5, p1, Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;->featureId:I

    iget-object v6, p1, Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;->menu:Landroid/support/v7/internal/view/menu/MenuBuilder;

    invoke-interface {v2, v5, v6}, Landroid/support/v7/internal/app/WindowCallback;->onCreatePanelMenu(ILandroid/view/Menu;)Z

    move-result v2

    if-nez v2, :cond_b

    .line 981
    invoke-virtual {p1, v7}, Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;->setMenu(Landroid/support/v7/internal/view/menu/MenuBuilder;)V

    .line 983
    if-eqz v0, :cond_0

    iget-object v2, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mDecorContentParent:Landroid/support/v7/internal/widget/DecorContentParent;

    if-eqz v2, :cond_0

    .line 985
    iget-object v2, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mDecorContentParent:Landroid/support/v7/internal/widget/DecorContentParent;

    iget-object v3, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mActionMenuPresenterCallback:Landroid/support/v7/app/ActionBarActivityDelegateBase$ActionMenuPresenterCallback;

    invoke-interface {v2, v7, v3}, Landroid/support/v7/internal/widget/DecorContentParent;->setMenu(Landroid/view/Menu;Landroid/support/v7/internal/view/menu/MenuPresenter$Callback;)V

    goto :goto_0

    .end local v0    # "isActionBarMenu":Z
    :cond_a
    move v0, v4

    .line 952
    goto :goto_1

    .line 991
    .restart local v0    # "isActionBarMenu":Z
    :cond_b
    iput-boolean v4, p1, Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;->refreshMenuContent:Z

    .line 996
    :cond_c
    iget-object v2, p1, Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;->menu:Landroid/support/v7/internal/view/menu/MenuBuilder;

    invoke-virtual {v2}, Landroid/support/v7/internal/view/menu/MenuBuilder;->stopDispatchingItemsChanged()V

    .line 1000
    iget-object v2, p1, Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;->frozenActionViewState:Landroid/os/Bundle;

    if-eqz v2, :cond_d

    .line 1001
    iget-object v2, p1, Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;->menu:Landroid/support/v7/internal/view/menu/MenuBuilder;

    iget-object v5, p1, Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;->frozenActionViewState:Landroid/os/Bundle;

    invoke-virtual {v2, v5}, Landroid/support/v7/internal/view/menu/MenuBuilder;->restoreActionViewStates(Landroid/os/Bundle;)V

    .line 1002
    iput-object v7, p1, Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;->frozenActionViewState:Landroid/os/Bundle;

    .line 1006
    :cond_d
    invoke-virtual {p0}, Landroid/support/v7/app/ActionBarActivityDelegateBase;->getWindowCallback()Landroid/support/v7/internal/app/WindowCallback;

    move-result-object v2

    iget-object v5, p1, Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;->menu:Landroid/support/v7/internal/view/menu/MenuBuilder;

    invoke-interface {v2, v4, v7, v5}, Landroid/support/v7/internal/app/WindowCallback;->onPreparePanel(ILandroid/view/View;Landroid/view/Menu;)Z

    move-result v2

    if-nez v2, :cond_f

    .line 1007
    if-eqz v0, :cond_e

    iget-object v2, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mDecorContentParent:Landroid/support/v7/internal/widget/DecorContentParent;

    if-eqz v2, :cond_e

    .line 1010
    iget-object v2, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mDecorContentParent:Landroid/support/v7/internal/widget/DecorContentParent;

    iget-object v3, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mActionMenuPresenterCallback:Landroid/support/v7/app/ActionBarActivityDelegateBase$ActionMenuPresenterCallback;

    invoke-interface {v2, v7, v3}, Landroid/support/v7/internal/widget/DecorContentParent;->setMenu(Landroid/view/Menu;Landroid/support/v7/internal/view/menu/MenuPresenter$Callback;)V

    .line 1012
    :cond_e
    iget-object v2, p1, Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;->menu:Landroid/support/v7/internal/view/menu/MenuBuilder;

    invoke-virtual {v2}, Landroid/support/v7/internal/view/menu/MenuBuilder;->startDispatchingItemsChanged()V

    goto/16 :goto_0

    .line 1017
    :cond_f
    if-eqz p2, :cond_10

    invoke-virtual {p2}, Landroid/view/KeyEvent;->getDeviceId()I

    move-result v2

    :goto_2
    invoke-static {v2}, Landroid/view/KeyCharacterMap;->load(I)Landroid/view/KeyCharacterMap;

    move-result-object v1

    .line 1019
    .local v1, "kmap":Landroid/view/KeyCharacterMap;
    invoke-virtual {v1}, Landroid/view/KeyCharacterMap;->getKeyboardType()I

    move-result v2

    if-eq v2, v3, :cond_11

    move v2, v3

    :goto_3
    iput-boolean v2, p1, Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;->qwertyMode:Z

    .line 1020
    iget-object v2, p1, Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;->menu:Landroid/support/v7/internal/view/menu/MenuBuilder;

    iget-boolean v5, p1, Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;->qwertyMode:Z

    invoke-virtual {v2, v5}, Landroid/support/v7/internal/view/menu/MenuBuilder;->setQwertyMode(Z)V

    .line 1021
    iget-object v2, p1, Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;->menu:Landroid/support/v7/internal/view/menu/MenuBuilder;

    invoke-virtual {v2}, Landroid/support/v7/internal/view/menu/MenuBuilder;->startDispatchingItemsChanged()V

    .line 1024
    iput-boolean v3, p1, Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;->isPrepared:Z

    .line 1025
    iput-boolean v4, p1, Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;->isHandled:Z

    .line 1026
    iput-object p1, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mPreparedPanel:Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;

    move v4, v3

    .line 1028
    goto/16 :goto_0

    .line 1017
    .end local v1    # "kmap":Landroid/view/KeyCharacterMap;
    :cond_10
    const/4 v2, -0x1

    goto :goto_2

    .restart local v1    # "kmap":Landroid/view/KeyCharacterMap;
    :cond_11
    move v2, v4

    .line 1019
    goto :goto_3
.end method

.method private reopenMenu(Landroid/support/v7/internal/view/menu/MenuBuilder;Z)V
    .locals 8
    .param p1, "menu"    # Landroid/support/v7/internal/view/menu/MenuBuilder;
    .param p2, "toggleMenuMode"    # Z

    .prologue
    const/4 v7, 0x0

    const/16 v6, 0x8

    const/4 v5, 0x1

    const/4 v4, 0x0

    .line 835
    iget-object v2, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mDecorContentParent:Landroid/support/v7/internal/widget/DecorContentParent;

    if-eqz v2, :cond_5

    iget-object v2, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mDecorContentParent:Landroid/support/v7/internal/widget/DecorContentParent;

    invoke-interface {v2}, Landroid/support/v7/internal/widget/DecorContentParent;->canShowOverflowMenu()Z

    move-result v2

    if-eqz v2, :cond_5

    iget-object v2, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mActivity:Landroid/support/v7/app/ActionBarActivity;

    invoke-static {v2}, Landroid/view/ViewConfiguration;->get(Landroid/content/Context;)Landroid/view/ViewConfiguration;

    move-result-object v2

    invoke-static {v2}, Landroid/support/v4/view/ViewConfigurationCompat;->hasPermanentMenuKey(Landroid/view/ViewConfiguration;)Z

    move-result v2

    if-eqz v2, :cond_0

    iget-object v2, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mDecorContentParent:Landroid/support/v7/internal/widget/DecorContentParent;

    invoke-interface {v2}, Landroid/support/v7/internal/widget/DecorContentParent;->isOverflowMenuShowPending()Z

    move-result v2

    if-eqz v2, :cond_5

    .line 839
    :cond_0
    invoke-virtual {p0}, Landroid/support/v7/app/ActionBarActivityDelegateBase;->getWindowCallback()Landroid/support/v7/internal/app/WindowCallback;

    move-result-object v0

    .line 841
    .local v0, "cb":Landroid/support/v7/internal/app/WindowCallback;
    iget-object v2, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mDecorContentParent:Landroid/support/v7/internal/widget/DecorContentParent;

    invoke-interface {v2}, Landroid/support/v7/internal/widget/DecorContentParent;->isOverflowMenuShowing()Z

    move-result v2

    if-eqz v2, :cond_1

    if-nez p2, :cond_4

    .line 842
    :cond_1
    if-eqz v0, :cond_3

    invoke-virtual {p0}, Landroid/support/v7/app/ActionBarActivityDelegateBase;->isDestroyed()Z

    move-result v2

    if-nez v2, :cond_3

    .line 844
    iget-boolean v2, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mInvalidatePanelMenuPosted:Z

    if-eqz v2, :cond_2

    iget v2, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mInvalidatePanelMenuFeatures:I

    and-int/lit8 v2, v2, 0x1

    if-eqz v2, :cond_2

    .line 846
    iget-object v2, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mWindowDecor:Landroid/view/ViewGroup;

    iget-object v3, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mInvalidatePanelMenuRunnable:Ljava/lang/Runnable;

    invoke-virtual {v2, v3}, Landroid/view/ViewGroup;->removeCallbacks(Ljava/lang/Runnable;)Z

    .line 847
    iget-object v2, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mInvalidatePanelMenuRunnable:Ljava/lang/Runnable;

    invoke-interface {v2}, Ljava/lang/Runnable;->run()V

    .line 850
    :cond_2
    invoke-direct {p0, v4, v5}, Landroid/support/v7/app/ActionBarActivityDelegateBase;->getPanelState(IZ)Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;

    move-result-object v1

    .line 854
    .local v1, "st":Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;
    iget-object v2, v1, Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;->menu:Landroid/support/v7/internal/view/menu/MenuBuilder;

    if-eqz v2, :cond_3

    iget-boolean v2, v1, Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;->refreshMenuContent:Z

    if-nez v2, :cond_3

    iget-object v2, v1, Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;->menu:Landroid/support/v7/internal/view/menu/MenuBuilder;

    invoke-interface {v0, v4, v7, v2}, Landroid/support/v7/internal/app/WindowCallback;->onPreparePanel(ILandroid/view/View;Landroid/view/Menu;)Z

    move-result v2

    if-eqz v2, :cond_3

    .line 856
    iget-object v2, v1, Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;->menu:Landroid/support/v7/internal/view/menu/MenuBuilder;

    invoke-interface {v0, v6, v2}, Landroid/support/v7/internal/app/WindowCallback;->onMenuOpened(ILandroid/view/Menu;)Z

    .line 857
    iget-object v2, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mDecorContentParent:Landroid/support/v7/internal/widget/DecorContentParent;

    invoke-interface {v2}, Landroid/support/v7/internal/widget/DecorContentParent;->showOverflowMenu()Z

    .line 876
    .end local v0    # "cb":Landroid/support/v7/internal/app/WindowCallback;
    .end local v1    # "st":Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;
    :cond_3
    :goto_0
    return-void

    .line 861
    .restart local v0    # "cb":Landroid/support/v7/internal/app/WindowCallback;
    :cond_4
    iget-object v2, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mDecorContentParent:Landroid/support/v7/internal/widget/DecorContentParent;

    invoke-interface {v2}, Landroid/support/v7/internal/widget/DecorContentParent;->hideOverflowMenu()Z

    .line 862
    invoke-virtual {p0}, Landroid/support/v7/app/ActionBarActivityDelegateBase;->isDestroyed()Z

    move-result v2

    if-nez v2, :cond_3

    .line 863
    invoke-direct {p0, v4, v5}, Landroid/support/v7/app/ActionBarActivityDelegateBase;->getPanelState(IZ)Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;

    move-result-object v1

    .line 864
    .restart local v1    # "st":Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;
    iget-object v2, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mActivity:Landroid/support/v7/app/ActionBarActivity;

    iget-object v3, v1, Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;->menu:Landroid/support/v7/internal/view/menu/MenuBuilder;

    invoke-virtual {v2, v6, v3}, Landroid/support/v7/app/ActionBarActivity;->onPanelClosed(ILandroid/view/Menu;)V

    goto :goto_0

    .line 870
    .end local v0    # "cb":Landroid/support/v7/internal/app/WindowCallback;
    .end local v1    # "st":Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;
    :cond_5
    invoke-direct {p0, v4, v5}, Landroid/support/v7/app/ActionBarActivityDelegateBase;->getPanelState(IZ)Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;

    move-result-object v1

    .line 872
    .restart local v1    # "st":Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;
    iput-boolean v5, v1, Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;->refreshDecorView:Z

    .line 873
    invoke-direct {p0, v1, v4}, Landroid/support/v7/app/ActionBarActivityDelegateBase;->closePanel(Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;Z)V

    .line 875
    invoke-direct {p0, v1, v7}, Landroid/support/v7/app/ActionBarActivityDelegateBase;->openPanel(Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;Landroid/view/KeyEvent;)V

    goto :goto_0
.end method

.method private throwFeatureRequestIfSubDecorInstalled()V
    .locals 2

    .prologue
    .line 1280
    iget-boolean v0, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mSubDecorInstalled:Z

    if-eqz v0, :cond_0

    .line 1281
    new-instance v0, Landroid/util/AndroidRuntimeException;

    const-string v1, "supportRequestWindowFeature() must be called before adding content"

    invoke-direct {v0, v1}, Landroid/util/AndroidRuntimeException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 1284
    :cond_0
    return-void
.end method

.method private updateStatusGuard(I)I
    .locals 12
    .param p1, "insetTop"    # I

    .prologue
    const/4 v11, -0x1

    const/4 v7, 0x0

    .line 1194
    const/4 v6, 0x0

    .line 1196
    .local v6, "showStatusGuard":Z
    iget-object v8, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mActionModeView:Landroid/support/v7/internal/widget/ActionBarContextView;

    if-eqz v8, :cond_3

    .line 1197
    iget-object v8, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mActionModeView:Landroid/support/v7/internal/widget/ActionBarContextView;

    invoke-virtual {v8}, Landroid/support/v7/internal/widget/ActionBarContextView;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v8

    instance-of v8, v8, Landroid/view/ViewGroup$MarginLayoutParams;

    if-eqz v8, :cond_3

    .line 1198
    iget-object v8, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mActionModeView:Landroid/support/v7/internal/widget/ActionBarContextView;

    invoke-virtual {v8}, Landroid/support/v7/internal/widget/ActionBarContextView;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v3

    check-cast v3, Landroid/view/ViewGroup$MarginLayoutParams;

    .line 1200
    .local v3, "mlp":Landroid/view/ViewGroup$MarginLayoutParams;
    const/4 v4, 0x0

    .line 1202
    .local v4, "mlpChanged":Z
    iget-object v8, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mActionModeView:Landroid/support/v7/internal/widget/ActionBarContextView;

    invoke-virtual {v8}, Landroid/support/v7/internal/widget/ActionBarContextView;->isShown()Z

    move-result v8

    if-eqz v8, :cond_8

    .line 1203
    iget-object v8, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mTempRect1:Landroid/graphics/Rect;

    if-nez v8, :cond_0

    .line 1204
    new-instance v8, Landroid/graphics/Rect;

    invoke-direct {v8}, Landroid/graphics/Rect;-><init>()V

    iput-object v8, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mTempRect1:Landroid/graphics/Rect;

    .line 1205
    new-instance v8, Landroid/graphics/Rect;

    invoke-direct {v8}, Landroid/graphics/Rect;-><init>()V

    iput-object v8, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mTempRect2:Landroid/graphics/Rect;

    .line 1207
    :cond_0
    iget-object v0, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mTempRect1:Landroid/graphics/Rect;

    .line 1208
    .local v0, "insets":Landroid/graphics/Rect;
    iget-object v1, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mTempRect2:Landroid/graphics/Rect;

    .line 1209
    .local v1, "localInsets":Landroid/graphics/Rect;
    invoke-virtual {v0, v7, p1, v7, v7}, Landroid/graphics/Rect;->set(IIII)V

    .line 1211
    iget-object v8, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mSubDecor:Landroid/view/ViewGroup;

    invoke-static {v8, v0, v1}, Landroid/support/v7/internal/widget/ViewUtils;->computeFitSystemWindows(Landroid/view/View;Landroid/graphics/Rect;Landroid/graphics/Rect;)V

    .line 1212
    iget v8, v1, Landroid/graphics/Rect;->top:I

    if-nez v8, :cond_5

    move v5, p1

    .line 1213
    .local v5, "newMargin":I
    :goto_0
    iget v8, v3, Landroid/view/ViewGroup$MarginLayoutParams;->topMargin:I

    if-eq v8, v5, :cond_1

    .line 1214
    const/4 v4, 0x1

    .line 1215
    iput p1, v3, Landroid/view/ViewGroup$MarginLayoutParams;->topMargin:I

    .line 1217
    iget-object v8, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mStatusGuard:Landroid/view/View;

    if-nez v8, :cond_6

    .line 1218
    new-instance v8, Landroid/view/View;

    iget-object v9, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mActivity:Landroid/support/v7/app/ActionBarActivity;

    invoke-direct {v8, v9}, Landroid/view/View;-><init>(Landroid/content/Context;)V

    iput-object v8, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mStatusGuard:Landroid/view/View;

    .line 1219
    iget-object v8, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mStatusGuard:Landroid/view/View;

    iget-object v9, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mActivity:Landroid/support/v7/app/ActionBarActivity;

    invoke-virtual {v9}, Landroid/support/v7/app/ActionBarActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v9

    sget v10, Landroid/support/v7/appcompat/R$color;->abc_input_method_navigation_guard:I

    invoke-virtual {v9, v10}, Landroid/content/res/Resources;->getColor(I)I

    move-result v9

    invoke-virtual {v8, v9}, Landroid/view/View;->setBackgroundColor(I)V

    .line 1221
    iget-object v8, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mSubDecor:Landroid/view/ViewGroup;

    iget-object v9, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mStatusGuard:Landroid/view/View;

    new-instance v10, Landroid/view/ViewGroup$LayoutParams;

    invoke-direct {v10, v11, p1}, Landroid/view/ViewGroup$LayoutParams;-><init>(II)V

    invoke-virtual {v8, v9, v11, v10}, Landroid/view/ViewGroup;->addView(Landroid/view/View;ILandroid/view/ViewGroup$LayoutParams;)V

    .line 1235
    :cond_1
    :goto_1
    iget-object v8, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mStatusGuard:Landroid/view/View;

    if-eqz v8, :cond_7

    const/4 v6, 0x1

    .line 1241
    :goto_2
    iget-boolean v8, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mOverlayActionMode:Z

    if-nez v8, :cond_2

    if-eqz v6, :cond_2

    .line 1242
    const/4 p1, 0x0

    .line 1251
    .end local v0    # "insets":Landroid/graphics/Rect;
    .end local v1    # "localInsets":Landroid/graphics/Rect;
    .end local v5    # "newMargin":I
    :cond_2
    :goto_3
    if-eqz v4, :cond_3

    .line 1252
    iget-object v8, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mActionModeView:Landroid/support/v7/internal/widget/ActionBarContextView;

    invoke-virtual {v8, v3}, Landroid/support/v7/internal/widget/ActionBarContextView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 1256
    .end local v3    # "mlp":Landroid/view/ViewGroup$MarginLayoutParams;
    .end local v4    # "mlpChanged":Z
    :cond_3
    iget-object v8, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mStatusGuard:Landroid/view/View;

    if-eqz v8, :cond_4

    .line 1257
    iget-object v8, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mStatusGuard:Landroid/view/View;

    if-eqz v6, :cond_9

    :goto_4
    invoke-virtual {v8, v7}, Landroid/view/View;->setVisibility(I)V

    .line 1260
    :cond_4
    return p1

    .restart local v0    # "insets":Landroid/graphics/Rect;
    .restart local v1    # "localInsets":Landroid/graphics/Rect;
    .restart local v3    # "mlp":Landroid/view/ViewGroup$MarginLayoutParams;
    .restart local v4    # "mlpChanged":Z
    :cond_5
    move v5, v7

    .line 1212
    goto :goto_0

    .line 1225
    .restart local v5    # "newMargin":I
    :cond_6
    iget-object v8, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mStatusGuard:Landroid/view/View;

    invoke-virtual {v8}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v2

    .line 1226
    .local v2, "lp":Landroid/view/ViewGroup$LayoutParams;
    iget v8, v2, Landroid/view/ViewGroup$LayoutParams;->height:I

    if-eq v8, p1, :cond_1

    .line 1227
    iput p1, v2, Landroid/view/ViewGroup$LayoutParams;->height:I

    .line 1228
    iget-object v8, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mStatusGuard:Landroid/view/View;

    invoke-virtual {v8, v2}, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    goto :goto_1

    .end local v2    # "lp":Landroid/view/ViewGroup$LayoutParams;
    :cond_7
    move v6, v7

    .line 1235
    goto :goto_2

    .line 1246
    .end local v0    # "insets":Landroid/graphics/Rect;
    .end local v1    # "localInsets":Landroid/graphics/Rect;
    .end local v5    # "newMargin":I
    :cond_8
    iget v8, v3, Landroid/view/ViewGroup$MarginLayoutParams;->topMargin:I

    if-eqz v8, :cond_2

    .line 1247
    const/4 v4, 0x1

    .line 1248
    iput v7, v3, Landroid/view/ViewGroup$MarginLayoutParams;->topMargin:I

    goto :goto_3

    .line 1257
    .end local v3    # "mlp":Landroid/view/ViewGroup$MarginLayoutParams;
    .end local v4    # "mlpChanged":Z
    :cond_9
    const/16 v7, 0x8

    goto :goto_4
.end method


# virtual methods
.method public addContentView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    .locals 3
    .param p1, "v"    # Landroid/view/View;
    .param p2, "lp"    # Landroid/view/ViewGroup$LayoutParams;

    .prologue
    .line 243
    invoke-virtual {p0}, Landroid/support/v7/app/ActionBarActivityDelegateBase;->ensureSubDecor()V

    .line 244
    iget-object v1, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mActivity:Landroid/support/v7/app/ActionBarActivity;

    const v2, 0x1020002

    invoke-virtual {v1, v2}, Landroid/support/v7/app/ActionBarActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/view/ViewGroup;

    .line 245
    .local v0, "contentParent":Landroid/view/ViewGroup;
    invoke-virtual {v0, p1, p2}, Landroid/view/ViewGroup;->addView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V

    .line 246
    iget-object v1, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mActivity:Landroid/support/v7/app/ActionBarActivity;

    invoke-virtual {v1}, Landroid/support/v7/app/ActionBarActivity;->onSupportContentChanged()V

    .line 247
    return-void
.end method

.method public createSupportActionBar()Landroid/support/v7/app/ActionBar;
    .locals 3

    .prologue
    .line 155
    invoke-virtual {p0}, Landroid/support/v7/app/ActionBarActivityDelegateBase;->ensureSubDecor()V

    .line 156
    new-instance v0, Landroid/support/v7/internal/app/WindowDecorActionBar;

    iget-object v1, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mActivity:Landroid/support/v7/app/ActionBarActivity;

    iget-boolean v2, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mOverlayActionBar:Z

    invoke-direct {v0, v1, v2}, Landroid/support/v7/internal/app/WindowDecorActionBar;-><init>(Landroid/support/v7/app/ActionBarActivity;Z)V

    .line 157
    .local v0, "ab":Landroid/support/v7/app/ActionBar;
    iget-boolean v1, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mEnableDefaultActionBarUp:Z

    invoke-virtual {v0, v1}, Landroid/support/v7/app/ActionBar;->setDefaultDisplayHomeAsUpEnabled(Z)V

    .line 158
    return-object v0
.end method

.method createView(Ljava/lang/String;Landroid/content/Context;Landroid/util/AttributeSet;)Landroid/view/View;
    .locals 2
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "context"    # Landroid/content/Context;
        .annotation build Landroid/support/annotation/NonNull;
        .end annotation
    .end param
    .param p3, "attrs"    # Landroid/util/AttributeSet;
        .annotation build Landroid/support/annotation/NonNull;
        .end annotation
    .end param

    .prologue
    .line 754
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x15

    if-ge v0, v1, :cond_1

    .line 757
    const/4 v0, -0x1

    invoke-virtual {p1}, Ljava/lang/String;->hashCode()I

    move-result v1

    sparse-switch v1, :sswitch_data_0

    :cond_0
    :goto_0
    packed-switch v0, :pswitch_data_0

    .line 770
    :cond_1
    const/4 v0, 0x0

    :goto_1
    return-object v0

    .line 757
    :sswitch_0
    const-string v1, "EditText"

    invoke-virtual {p1, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    const/4 v0, 0x0

    goto :goto_0

    :sswitch_1
    const-string v1, "Spinner"

    invoke-virtual {p1, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    :sswitch_2
    const-string v1, "CheckBox"

    invoke-virtual {p1, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    const/4 v0, 0x2

    goto :goto_0

    :sswitch_3
    const-string v1, "RadioButton"

    invoke-virtual {p1, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    const/4 v0, 0x3

    goto :goto_0

    :sswitch_4
    const-string v1, "CheckedTextView"

    invoke-virtual {p1, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    const/4 v0, 0x4

    goto :goto_0

    .line 759
    :pswitch_0
    new-instance v0, Landroid/support/v7/internal/widget/TintEditText;

    invoke-direct {v0, p2, p3}, Landroid/support/v7/internal/widget/TintEditText;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    goto :goto_1

    .line 761
    :pswitch_1
    new-instance v0, Landroid/support/v7/internal/widget/TintSpinner;

    invoke-direct {v0, p2, p3}, Landroid/support/v7/internal/widget/TintSpinner;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    goto :goto_1

    .line 763
    :pswitch_2
    new-instance v0, Landroid/support/v7/internal/widget/TintCheckBox;

    invoke-direct {v0, p2, p3}, Landroid/support/v7/internal/widget/TintCheckBox;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    goto :goto_1

    .line 765
    :pswitch_3
    new-instance v0, Landroid/support/v7/internal/widget/TintRadioButton;

    invoke-direct {v0, p2, p3}, Landroid/support/v7/internal/widget/TintRadioButton;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    goto :goto_1

    .line 767
    :pswitch_4
    new-instance v0, Landroid/support/v7/internal/widget/TintCheckedTextView;

    invoke-direct {v0, p2, p3}, Landroid/support/v7/internal/widget/TintCheckedTextView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    goto :goto_1

    .line 757
    nop

    :sswitch_data_0
    .sparse-switch
        -0x56c015e7 -> :sswitch_4
        -0x1440b607 -> :sswitch_1
        0x2e46a6ed -> :sswitch_3
        0x5f7507c3 -> :sswitch_2
        0x63577677 -> :sswitch_0
    .end sparse-switch

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
        :pswitch_4
    .end packed-switch
.end method

.method final ensureSubDecor()V
    .locals 11

    .prologue
    const v10, 0x1020002

    const/4 v9, 0x1

    const/4 v8, 0x0

    const/4 v7, 0x0

    .line 255
    iget-boolean v5, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mSubDecorInstalled:Z

    if-nez v5, :cond_6

    .line 256
    iget-boolean v5, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mHasActionBar:Z

    if-eqz v5, :cond_8

    .line 262
    new-instance v2, Landroid/util/TypedValue;

    invoke-direct {v2}, Landroid/util/TypedValue;-><init>()V

    .line 263
    .local v2, "outValue":Landroid/util/TypedValue;
    iget-object v5, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mActivity:Landroid/support/v7/app/ActionBarActivity;

    invoke-virtual {v5}, Landroid/support/v7/app/ActionBarActivity;->getTheme()Landroid/content/res/Resources$Theme;

    move-result-object v5

    sget v6, Landroid/support/v7/appcompat/R$attr;->actionBarTheme:I

    invoke-virtual {v5, v6, v2, v9}, Landroid/content/res/Resources$Theme;->resolveAttribute(ILandroid/util/TypedValue;Z)Z

    .line 266
    iget v5, v2, Landroid/util/TypedValue;->resourceId:I

    if-eqz v5, :cond_7

    .line 267
    new-instance v4, Landroid/view/ContextThemeWrapper;

    iget-object v5, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mActivity:Landroid/support/v7/app/ActionBarActivity;

    iget v6, v2, Landroid/util/TypedValue;->resourceId:I

    invoke-direct {v4, v5, v6}, Landroid/view/ContextThemeWrapper;-><init>(Landroid/content/Context;I)V

    .line 273
    .local v4, "themedContext":Landroid/content/Context;
    :goto_0
    invoke-static {v4}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v5

    sget v6, Landroid/support/v7/appcompat/R$layout;->abc_screen_toolbar:I

    invoke-virtual {v5, v6, v7}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v5

    check-cast v5, Landroid/view/ViewGroup;

    iput-object v5, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mSubDecor:Landroid/view/ViewGroup;

    .line 276
    iget-object v5, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mSubDecor:Landroid/view/ViewGroup;

    sget v6, Landroid/support/v7/appcompat/R$id;->decor_content_parent:I

    invoke-virtual {v5, v6}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Landroid/support/v7/internal/widget/DecorContentParent;

    iput-object v5, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mDecorContentParent:Landroid/support/v7/internal/widget/DecorContentParent;

    .line 278
    iget-object v5, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mDecorContentParent:Landroid/support/v7/internal/widget/DecorContentParent;

    invoke-virtual {p0}, Landroid/support/v7/app/ActionBarActivityDelegateBase;->getWindowCallback()Landroid/support/v7/internal/app/WindowCallback;

    move-result-object v6

    invoke-interface {v5, v6}, Landroid/support/v7/internal/widget/DecorContentParent;->setWindowCallback(Landroid/support/v7/internal/app/WindowCallback;)V

    .line 283
    iget-boolean v5, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mOverlayActionBar:Z

    if-eqz v5, :cond_0

    .line 284
    iget-object v5, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mDecorContentParent:Landroid/support/v7/internal/widget/DecorContentParent;

    const/16 v6, 0x9

    invoke-interface {v5, v6}, Landroid/support/v7/internal/widget/DecorContentParent;->initFeature(I)V

    .line 286
    :cond_0
    iget-boolean v5, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mFeatureProgress:Z

    if-eqz v5, :cond_1

    .line 287
    iget-object v5, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mDecorContentParent:Landroid/support/v7/internal/widget/DecorContentParent;

    const/4 v6, 0x2

    invoke-interface {v5, v6}, Landroid/support/v7/internal/widget/DecorContentParent;->initFeature(I)V

    .line 289
    :cond_1
    iget-boolean v5, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mFeatureIndeterminateProgress:Z

    if-eqz v5, :cond_2

    .line 290
    iget-object v5, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mDecorContentParent:Landroid/support/v7/internal/widget/DecorContentParent;

    const/4 v6, 0x5

    invoke-interface {v5, v6}, Landroid/support/v7/internal/widget/DecorContentParent;->initFeature(I)V

    .line 336
    .end local v2    # "outValue":Landroid/util/TypedValue;
    .end local v4    # "themedContext":Landroid/content/Context;
    :cond_2
    :goto_1
    iget-object v5, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mSubDecor:Landroid/view/ViewGroup;

    invoke-static {v5}, Landroid/support/v7/internal/widget/ViewUtils;->makeOptionalFitsSystemWindows(Landroid/view/View;)V

    .line 339
    iget-object v5, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mActivity:Landroid/support/v7/app/ActionBarActivity;

    iget-object v6, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mSubDecor:Landroid/view/ViewGroup;

    invoke-virtual {v5, v6}, Landroid/support/v7/app/ActionBarActivity;->superSetContentView(Landroid/view/View;)V

    .line 343
    iget-object v5, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mActivity:Landroid/support/v7/app/ActionBarActivity;

    invoke-virtual {v5, v10}, Landroid/support/v7/app/ActionBarActivity;->findViewById(I)Landroid/view/View;

    move-result-object v1

    .line 344
    .local v1, "decorContent":Landroid/view/View;
    const/4 v5, -0x1

    invoke-virtual {v1, v5}, Landroid/view/View;->setId(I)V

    .line 345
    iget-object v5, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mActivity:Landroid/support/v7/app/ActionBarActivity;

    sget v6, Landroid/support/v7/appcompat/R$id;->action_bar_activity_content:I

    invoke-virtual {v5, v6}, Landroid/support/v7/app/ActionBarActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    .line 346
    .local v0, "abcContent":Landroid/view/View;
    invoke-virtual {v0, v10}, Landroid/view/View;->setId(I)V

    .line 350
    instance-of v5, v1, Landroid/widget/FrameLayout;

    if-eqz v5, :cond_3

    .line 351
    check-cast v1, Landroid/widget/FrameLayout;

    .end local v1    # "decorContent":Landroid/view/View;
    invoke-virtual {v1, v7}, Landroid/widget/FrameLayout;->setForeground(Landroid/graphics/drawable/Drawable;)V

    .line 355
    :cond_3
    iget-object v5, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mTitleToSet:Ljava/lang/CharSequence;

    if-eqz v5, :cond_4

    iget-object v5, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mDecorContentParent:Landroid/support/v7/internal/widget/DecorContentParent;

    if-eqz v5, :cond_4

    .line 356
    iget-object v5, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mDecorContentParent:Landroid/support/v7/internal/widget/DecorContentParent;

    iget-object v6, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mTitleToSet:Ljava/lang/CharSequence;

    invoke-interface {v5, v6}, Landroid/support/v7/internal/widget/DecorContentParent;->setWindowTitle(Ljava/lang/CharSequence;)V

    .line 357
    iput-object v7, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mTitleToSet:Ljava/lang/CharSequence;

    .line 360
    :cond_4
    invoke-direct {p0}, Landroid/support/v7/app/ActionBarActivityDelegateBase;->applyFixedSizeWindow()V

    .line 362
    invoke-virtual {p0}, Landroid/support/v7/app/ActionBarActivityDelegateBase;->onSubDecorInstalled()V

    .line 364
    iput-boolean v9, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mSubDecorInstalled:Z

    .line 371
    invoke-direct {p0, v8, v8}, Landroid/support/v7/app/ActionBarActivityDelegateBase;->getPanelState(IZ)Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;

    move-result-object v3

    .line 372
    .local v3, "st":Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;
    invoke-virtual {p0}, Landroid/support/v7/app/ActionBarActivityDelegateBase;->isDestroyed()Z

    move-result v5

    if-nez v5, :cond_6

    if-eqz v3, :cond_5

    iget-object v5, v3, Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;->menu:Landroid/support/v7/internal/view/menu/MenuBuilder;

    if-nez v5, :cond_6

    .line 373
    :cond_5
    const/16 v5, 0x8

    invoke-direct {p0, v5}, Landroid/support/v7/app/ActionBarActivityDelegateBase;->invalidatePanelMenu(I)V

    .line 376
    .end local v0    # "abcContent":Landroid/view/View;
    .end local v3    # "st":Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;
    :cond_6
    return-void

    .line 269
    .restart local v2    # "outValue":Landroid/util/TypedValue;
    :cond_7
    iget-object v4, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mActivity:Landroid/support/v7/app/ActionBarActivity;

    .restart local v4    # "themedContext":Landroid/content/Context;
    goto/16 :goto_0

    .line 293
    .end local v2    # "outValue":Landroid/util/TypedValue;
    .end local v4    # "themedContext":Landroid/content/Context;
    :cond_8
    iget-boolean v5, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mOverlayActionMode:Z

    if-eqz v5, :cond_9

    .line 294
    iget-object v5, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mActivity:Landroid/support/v7/app/ActionBarActivity;

    invoke-static {v5}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v5

    sget v6, Landroid/support/v7/appcompat/R$layout;->abc_screen_simple_overlay_action_mode:I

    invoke-virtual {v5, v6, v7}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v5

    check-cast v5, Landroid/view/ViewGroup;

    iput-object v5, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mSubDecor:Landroid/view/ViewGroup;

    .line 301
    :goto_2
    sget v5, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v6, 0x15

    if-lt v5, v6, :cond_a

    .line 304
    iget-object v5, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mSubDecor:Landroid/view/ViewGroup;

    new-instance v6, Landroid/support/v7/app/ActionBarActivityDelegateBase$2;

    invoke-direct {v6, p0}, Landroid/support/v7/app/ActionBarActivityDelegateBase$2;-><init>(Landroid/support/v7/app/ActionBarActivityDelegateBase;)V

    invoke-static {v5, v6}, Landroid/support/v4/view/ViewCompat;->setOnApplyWindowInsetsListener(Landroid/view/View;Landroid/support/v4/view/OnApplyWindowInsetsListener;)V

    goto/16 :goto_1

    .line 297
    :cond_9
    iget-object v5, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mActivity:Landroid/support/v7/app/ActionBarActivity;

    invoke-static {v5}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v5

    sget v6, Landroid/support/v7/appcompat/R$layout;->abc_screen_simple:I

    invoke-virtual {v5, v6, v7}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v5

    check-cast v5, Landroid/view/ViewGroup;

    iput-object v5, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mSubDecor:Landroid/view/ViewGroup;

    goto :goto_2

    .line 325
    :cond_a
    iget-object v5, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mSubDecor:Landroid/view/ViewGroup;

    check-cast v5, Landroid/support/v7/internal/widget/FitWindowsViewGroup;

    new-instance v6, Landroid/support/v7/app/ActionBarActivityDelegateBase$3;

    invoke-direct {v6, p0}, Landroid/support/v7/app/ActionBarActivityDelegateBase$3;-><init>(Landroid/support/v7/app/ActionBarActivityDelegateBase;)V

    invoke-interface {v5, v6}, Landroid/support/v7/internal/widget/FitWindowsViewGroup;->setOnFitSystemWindowsListener(Landroid/support/v7/internal/widget/FitWindowsViewGroup$OnFitSystemWindowsListener;)V

    goto/16 :goto_1
.end method

.method getHomeAsUpIndicatorAttrId()I
    .locals 1

    .prologue
    .line 711
    sget v0, Landroid/support/v7/appcompat/R$attr;->homeAsUpIndicator:I

    return v0
.end method

.method public onBackPressed()Z
    .locals 3

    .prologue
    const/4 v1, 0x1

    .line 675
    iget-object v2, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mActionMode:Landroid/support/v7/view/ActionMode;

    if-eqz v2, :cond_1

    .line 676
    iget-object v2, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mActionMode:Landroid/support/v7/view/ActionMode;

    invoke-virtual {v2}, Landroid/support/v7/view/ActionMode;->finish()V

    .line 686
    :cond_0
    :goto_0
    return v1

    .line 681
    :cond_1
    invoke-virtual {p0}, Landroid/support/v7/app/ActionBarActivityDelegateBase;->getSupportActionBar()Landroid/support/v7/app/ActionBar;

    move-result-object v0

    .line 682
    .local v0, "ab":Landroid/support/v7/app/ActionBar;
    if-eqz v0, :cond_2

    invoke-virtual {v0}, Landroid/support/v7/app/ActionBar;->collapseActionView()Z

    move-result v2

    if-nez v2, :cond_0

    .line 686
    :cond_2
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public onConfigurationChanged(Landroid/content/res/Configuration;)V
    .locals 2
    .param p1, "newConfig"    # Landroid/content/res/Configuration;

    .prologue
    .line 188
    iget-boolean v1, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mHasActionBar:Z

    if-eqz v1, :cond_0

    iget-boolean v1, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mSubDecorInstalled:Z

    if-eqz v1, :cond_0

    .line 191
    invoke-virtual {p0}, Landroid/support/v7/app/ActionBarActivityDelegateBase;->getSupportActionBar()Landroid/support/v7/app/ActionBar;

    move-result-object v0

    .line 192
    .local v0, "ab":Landroid/support/v7/app/ActionBar;
    if-eqz v0, :cond_0

    .line 193
    invoke-virtual {v0, p1}, Landroid/support/v7/app/ActionBar;->onConfigurationChanged(Landroid/content/res/Configuration;)V

    .line 196
    .end local v0    # "ab":Landroid/support/v7/app/ActionBar;
    :cond_0
    return-void
.end method

.method public onContentChanged()V
    .locals 0

    .prologue
    .line 252
    return-void
.end method

.method onCreate(Landroid/os/Bundle;)V
    .locals 3
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    const/4 v2, 0x1

    .line 138
    invoke-super {p0, p1}, Landroid/support/v7/app/ActionBarActivityDelegate;->onCreate(Landroid/os/Bundle;)V

    .line 140
    iget-object v1, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mActivity:Landroid/support/v7/app/ActionBarActivity;

    invoke-virtual {v1}, Landroid/support/v7/app/ActionBarActivity;->getWindow()Landroid/view/Window;

    move-result-object v1

    invoke-virtual {v1}, Landroid/view/Window;->getDecorView()Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/view/ViewGroup;

    iput-object v1, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mWindowDecor:Landroid/view/ViewGroup;

    .line 142
    iget-object v1, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mActivity:Landroid/support/v7/app/ActionBarActivity;

    invoke-static {v1}, Landroid/support/v4/app/NavUtils;->getParentActivityName(Landroid/app/Activity;)Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_0

    .line 144
    invoke-virtual {p0}, Landroid/support/v7/app/ActionBarActivityDelegateBase;->peekSupportActionBar()Landroid/support/v7/app/ActionBar;

    move-result-object v0

    .line 145
    .local v0, "ab":Landroid/support/v7/app/ActionBar;
    if-nez v0, :cond_1

    .line 146
    iput-boolean v2, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mEnableDefaultActionBarUp:Z

    .line 151
    .end local v0    # "ab":Landroid/support/v7/app/ActionBar;
    :cond_0
    :goto_0
    return-void

    .line 148
    .restart local v0    # "ab":Landroid/support/v7/app/ActionBar;
    :cond_1
    invoke-virtual {v0, v2}, Landroid/support/v7/app/ActionBar;->setDefaultDisplayHomeAsUpEnabled(Z)V

    goto :goto_0
.end method

.method public onCreatePanelMenu(ILandroid/view/Menu;)Z
    .locals 1
    .param p1, "featureId"    # I
    .param p2, "menu"    # Landroid/view/Menu;

    .prologue
    .line 503
    if-eqz p1, :cond_0

    .line 504
    invoke-virtual {p0}, Landroid/support/v7/app/ActionBarActivityDelegateBase;->getWindowCallback()Landroid/support/v7/internal/app/WindowCallback;

    move-result-object v0

    invoke-interface {v0, p1, p2}, Landroid/support/v7/internal/app/WindowCallback;->onCreatePanelMenu(ILandroid/view/Menu;)Z

    move-result v0

    .line 506
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public onCreatePanelView(I)Landroid/view/View;
    .locals 4
    .param p1, "featureId"    # I

    .prologue
    .line 476
    const/4 v1, 0x0

    .line 479
    .local v1, "panelView":Landroid/view/View;
    iget-object v3, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mActionMode:Landroid/support/v7/view/ActionMode;

    if-nez v3, :cond_1

    .line 481
    invoke-virtual {p0}, Landroid/support/v7/app/ActionBarActivityDelegateBase;->getWindowCallback()Landroid/support/v7/internal/app/WindowCallback;

    move-result-object v0

    .line 482
    .local v0, "callback":Landroid/support/v7/internal/app/WindowCallback;
    if-eqz v0, :cond_0

    .line 483
    invoke-interface {v0, p1}, Landroid/support/v7/internal/app/WindowCallback;->onCreatePanelView(I)Landroid/view/View;

    move-result-object v1

    .line 486
    :cond_0
    if-nez v1, :cond_1

    iget-object v3, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mToolbarListMenuPresenter:Landroid/support/v7/internal/view/menu/ListMenuPresenter;

    if-nez v3, :cond_1

    .line 491
    const/4 v3, 0x1

    invoke-direct {p0, p1, v3}, Landroid/support/v7/app/ActionBarActivityDelegateBase;->getPanelState(IZ)Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;

    move-result-object v2

    .line 492
    .local v2, "st":Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;
    const/4 v3, 0x0

    invoke-direct {p0, v2, v3}, Landroid/support/v7/app/ActionBarActivityDelegateBase;->openPanel(Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;Landroid/view/KeyEvent;)V

    .line 493
    iget-boolean v3, v2, Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;->isOpen:Z

    if-eqz v3, :cond_1

    .line 494
    iget-object v1, v2, Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;->shownPanelView:Landroid/view/View;

    .line 498
    .end local v0    # "callback":Landroid/support/v7/internal/app/WindowCallback;
    .end local v2    # "st":Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;
    :cond_1
    return-object v1
.end method

.method onKeyDown(ILandroid/view/KeyEvent;)Z
    .locals 1
    .param p1, "keyCode"    # I
    .param p2, "event"    # Landroid/view/KeyEvent;

    .prologue
    .line 749
    invoke-virtual {p0, p1, p2}, Landroid/support/v7/app/ActionBarActivityDelegateBase;->onKeyShortcut(ILandroid/view/KeyEvent;)Z

    move-result v0

    return v0
.end method

.method onKeyShortcut(ILandroid/view/KeyEvent;)Z
    .locals 6
    .param p1, "keyCode"    # I
    .param p2, "ev"    # Landroid/view/KeyEvent;

    .prologue
    const/4 v3, 0x0

    const/4 v2, 0x1

    .line 718
    iget-object v4, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mPreparedPanel:Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;

    if-eqz v4, :cond_1

    .line 719
    iget-object v4, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mPreparedPanel:Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;

    invoke-virtual {p2}, Landroid/view/KeyEvent;->getKeyCode()I

    move-result v5

    invoke-virtual {p0, v4, v5, p2, v2}, Landroid/support/v7/app/ActionBarActivityDelegateBase;->performPanelShortcut(Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;ILandroid/view/KeyEvent;I)Z

    move-result v0

    .line 721
    .local v0, "handled":Z
    if-eqz v0, :cond_1

    .line 722
    iget-object v3, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mPreparedPanel:Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;

    if-eqz v3, :cond_0

    .line 723
    iget-object v3, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mPreparedPanel:Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;

    iput-boolean v2, v3, Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;->isHandled:Z

    .line 742
    .end local v0    # "handled":Z
    :cond_0
    :goto_0
    return v2

    .line 733
    :cond_1
    iget-object v4, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mPreparedPanel:Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;

    if-nez v4, :cond_2

    .line 734
    invoke-direct {p0, v3, v2}, Landroid/support/v7/app/ActionBarActivityDelegateBase;->getPanelState(IZ)Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;

    move-result-object v1

    .line 735
    .local v1, "st":Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;
    invoke-direct {p0, v1, p2}, Landroid/support/v7/app/ActionBarActivityDelegateBase;->preparePanel(Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;Landroid/view/KeyEvent;)Z

    .line 736
    invoke-virtual {p2}, Landroid/view/KeyEvent;->getKeyCode()I

    move-result v4

    invoke-virtual {p0, v1, v4, p2, v2}, Landroid/support/v7/app/ActionBarActivityDelegateBase;->performPanelShortcut(Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;ILandroid/view/KeyEvent;I)Z

    move-result v0

    .line 737
    .restart local v0    # "handled":Z
    iput-boolean v3, v1, Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;->isPrepared:Z

    .line 738
    if-nez v0, :cond_0

    .end local v0    # "handled":Z
    .end local v1    # "st":Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;
    :cond_2
    move v2, v3

    .line 742
    goto :goto_0
.end method

.method public onMenuItemSelected(Landroid/support/v7/internal/view/menu/MenuBuilder;Landroid/view/MenuItem;)Z
    .locals 3
    .param p1, "menu"    # Landroid/support/v7/internal/view/menu/MenuBuilder;
    .param p2, "item"    # Landroid/view/MenuItem;

    .prologue
    .line 552
    invoke-virtual {p0}, Landroid/support/v7/app/ActionBarActivityDelegateBase;->getWindowCallback()Landroid/support/v7/internal/app/WindowCallback;

    move-result-object v0

    .line 553
    .local v0, "cb":Landroid/support/v7/internal/app/WindowCallback;
    if-eqz v0, :cond_0

    invoke-virtual {p0}, Landroid/support/v7/app/ActionBarActivityDelegateBase;->isDestroyed()Z

    move-result v2

    if-nez v2, :cond_0

    .line 554
    invoke-virtual {p1}, Landroid/support/v7/internal/view/menu/MenuBuilder;->getRootMenu()Landroid/support/v7/internal/view/menu/MenuBuilder;

    move-result-object v2

    invoke-direct {p0, v2}, Landroid/support/v7/app/ActionBarActivityDelegateBase;->findMenuPanel(Landroid/view/Menu;)Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;

    move-result-object v1

    .line 555
    .local v1, "panel":Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;
    if-eqz v1, :cond_0

    .line 556
    iget v2, v1, Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;->featureId:I

    invoke-interface {v0, v2, p2}, Landroid/support/v7/internal/app/WindowCallback;->onMenuItemSelected(ILandroid/view/MenuItem;)Z

    move-result v2

    .line 559
    .end local v1    # "panel":Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;
    :goto_0
    return v2

    :cond_0
    const/4 v2, 0x0

    goto :goto_0
.end method

.method public onMenuModeChange(Landroid/support/v7/internal/view/menu/MenuBuilder;)V
    .locals 1
    .param p1, "menu"    # Landroid/support/v7/internal/view/menu/MenuBuilder;

    .prologue
    .line 564
    const/4 v0, 0x1

    invoke-direct {p0, p1, v0}, Landroid/support/v7/app/ActionBarActivityDelegateBase;->reopenMenu(Landroid/support/v7/internal/view/menu/MenuBuilder;Z)V

    .line 565
    return-void
.end method

.method onMenuOpened(ILandroid/view/Menu;)Z
    .locals 3
    .param p1, "featureId"    # I
    .param p2, "menu"    # Landroid/view/Menu;

    .prologue
    const/4 v1, 0x1

    .line 539
    const/16 v2, 0x8

    if-ne p1, v2, :cond_1

    .line 540
    invoke-virtual {p0}, Landroid/support/v7/app/ActionBarActivityDelegateBase;->getSupportActionBar()Landroid/support/v7/app/ActionBar;

    move-result-object v0

    .line 541
    .local v0, "ab":Landroid/support/v7/app/ActionBar;
    if-eqz v0, :cond_0

    .line 542
    invoke-virtual {v0, v1}, Landroid/support/v7/app/ActionBar;->dispatchMenuVisibilityChanged(Z)V

    .line 546
    .end local v0    # "ab":Landroid/support/v7/app/ActionBar;
    :cond_0
    :goto_0
    return v1

    :cond_1
    iget-object v1, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mActivity:Landroid/support/v7/app/ActionBarActivity;

    invoke-virtual {v1, p1, p2}, Landroid/support/v7/app/ActionBarActivity;->superOnMenuOpened(ILandroid/view/Menu;)Z

    move-result v1

    goto :goto_0
.end method

.method public onPanelClosed(ILandroid/view/Menu;)V
    .locals 4
    .param p1, "featureId"    # I
    .param p2, "menu"    # Landroid/view/Menu;

    .prologue
    const/4 v3, 0x0

    .line 519
    invoke-direct {p0, p1, v3}, Landroid/support/v7/app/ActionBarActivityDelegateBase;->getPanelState(IZ)Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;

    move-result-object v1

    .line 520
    .local v1, "st":Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;
    if-eqz v1, :cond_0

    .line 522
    invoke-direct {p0, v1, v3}, Landroid/support/v7/app/ActionBarActivityDelegateBase;->closePanel(Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;Z)V

    .line 525
    :cond_0
    const/16 v2, 0x8

    if-ne p1, v2, :cond_2

    .line 526
    invoke-virtual {p0}, Landroid/support/v7/app/ActionBarActivityDelegateBase;->getSupportActionBar()Landroid/support/v7/app/ActionBar;

    move-result-object v0

    .line 527
    .local v0, "ab":Landroid/support/v7/app/ActionBar;
    if-eqz v0, :cond_1

    .line 528
    invoke-virtual {v0, v3}, Landroid/support/v7/app/ActionBar;->dispatchMenuVisibilityChanged(Z)V

    .line 535
    .end local v0    # "ab":Landroid/support/v7/app/ActionBar;
    :cond_1
    :goto_0
    return-void

    .line 530
    :cond_2
    invoke-virtual {p0}, Landroid/support/v7/app/ActionBarActivityDelegateBase;->isDestroyed()Z

    move-result v2

    if-nez v2, :cond_1

    .line 533
    iget-object v2, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mActivity:Landroid/support/v7/app/ActionBarActivity;

    invoke-virtual {v2, p1, p2}, Landroid/support/v7/app/ActionBarActivity;->superOnPanelClosed(ILandroid/view/Menu;)V

    goto :goto_0
.end method

.method public onPostResume()V
    .locals 2

    .prologue
    .line 208
    invoke-virtual {p0}, Landroid/support/v7/app/ActionBarActivityDelegateBase;->getSupportActionBar()Landroid/support/v7/app/ActionBar;

    move-result-object v0

    .line 209
    .local v0, "ab":Landroid/support/v7/app/ActionBar;
    if-eqz v0, :cond_0

    .line 210
    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/support/v7/app/ActionBar;->setShowHideAnimationEnabled(Z)V

    .line 212
    :cond_0
    return-void
.end method

.method public onPreparePanel(ILandroid/view/View;Landroid/view/Menu;)Z
    .locals 1
    .param p1, "featureId"    # I
    .param p2, "view"    # Landroid/view/View;
    .param p3, "menu"    # Landroid/view/Menu;

    .prologue
    .line 511
    if-eqz p1, :cond_0

    .line 512
    invoke-virtual {p0}, Landroid/support/v7/app/ActionBarActivityDelegateBase;->getWindowCallback()Landroid/support/v7/internal/app/WindowCallback;

    move-result-object v0

    invoke-interface {v0, p1, p2, p3}, Landroid/support/v7/internal/app/WindowCallback;->onPreparePanel(ILandroid/view/View;Landroid/view/Menu;)Z

    move-result v0

    .line 514
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public onStop()V
    .locals 2

    .prologue
    .line 200
    invoke-virtual {p0}, Landroid/support/v7/app/ActionBarActivityDelegateBase;->getSupportActionBar()Landroid/support/v7/app/ActionBar;

    move-result-object v0

    .line 201
    .local v0, "ab":Landroid/support/v7/app/ActionBar;
    if-eqz v0, :cond_0

    .line 202
    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/support/v7/app/ActionBar;->setShowHideAnimationEnabled(Z)V

    .line 204
    :cond_0
    return-void
.end method

.method onSubDecorInstalled()V
    .locals 0

    .prologue
    .line 378
    return-void
.end method

.method public onTitleChanged(Ljava/lang/CharSequence;)V
    .locals 1
    .param p1, "title"    # Ljava/lang/CharSequence;

    .prologue
    .line 465
    iget-object v0, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mDecorContentParent:Landroid/support/v7/internal/widget/DecorContentParent;

    if-eqz v0, :cond_0

    .line 466
    iget-object v0, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mDecorContentParent:Landroid/support/v7/internal/widget/DecorContentParent;

    invoke-interface {v0, p1}, Landroid/support/v7/internal/widget/DecorContentParent;->setWindowTitle(Ljava/lang/CharSequence;)V

    .line 472
    :goto_0
    return-void

    .line 467
    :cond_0
    invoke-virtual {p0}, Landroid/support/v7/app/ActionBarActivityDelegateBase;->getSupportActionBar()Landroid/support/v7/app/ActionBar;

    move-result-object v0

    if-eqz v0, :cond_1

    .line 468
    invoke-virtual {p0}, Landroid/support/v7/app/ActionBarActivityDelegateBase;->getSupportActionBar()Landroid/support/v7/app/ActionBar;

    move-result-object v0

    invoke-virtual {v0, p1}, Landroid/support/v7/app/ActionBar;->setWindowTitle(Ljava/lang/CharSequence;)V

    goto :goto_0

    .line 470
    :cond_1
    iput-object p1, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mTitleToSet:Ljava/lang/CharSequence;

    goto :goto_0
.end method

.method final performPanelShortcut(Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;ILandroid/view/KeyEvent;I)Z
    .locals 2
    .param p1, "st"    # Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;
    .param p2, "keyCode"    # I
    .param p3, "event"    # Landroid/view/KeyEvent;
    .param p4, "flags"    # I

    .prologue
    .line 1128
    invoke-virtual {p3}, Landroid/view/KeyEvent;->isSystem()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 1129
    const/4 v0, 0x0

    .line 1148
    :cond_0
    :goto_0
    return v0

    .line 1132
    :cond_1
    const/4 v0, 0x0

    .line 1136
    .local v0, "handled":Z
    iget-boolean v1, p1, Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;->isPrepared:Z

    if-nez v1, :cond_2

    invoke-direct {p0, p1, p3}, Landroid/support/v7/app/ActionBarActivityDelegateBase;->preparePanel(Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;Landroid/view/KeyEvent;)Z

    move-result v1

    if-eqz v1, :cond_3

    :cond_2
    iget-object v1, p1, Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;->menu:Landroid/support/v7/internal/view/menu/MenuBuilder;

    if-eqz v1, :cond_3

    .line 1138
    iget-object v1, p1, Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;->menu:Landroid/support/v7/internal/view/menu/MenuBuilder;

    invoke-virtual {v1, p2, p3, p4}, Landroid/support/v7/internal/view/menu/MenuBuilder;->performShortcut(ILandroid/view/KeyEvent;I)Z

    move-result v0

    .line 1141
    :cond_3
    if-eqz v0, :cond_0

    .line 1143
    and-int/lit8 v1, p4, 0x1

    if-nez v1, :cond_0

    iget-object v1, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mDecorContentParent:Landroid/support/v7/internal/widget/DecorContentParent;

    if-nez v1, :cond_0

    .line 1144
    const/4 v1, 0x1

    invoke-direct {p0, p1, v1}, Landroid/support/v7/app/ActionBarActivityDelegateBase;->closePanel(Landroid/support/v7/app/ActionBarActivityDelegateBase$PanelFeatureState;Z)V

    goto :goto_0
.end method

.method public setContentView(I)V
    .locals 3
    .param p1, "resId"    # I

    .prologue
    .line 225
    invoke-virtual {p0}, Landroid/support/v7/app/ActionBarActivityDelegateBase;->ensureSubDecor()V

    .line 226
    iget-object v1, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mActivity:Landroid/support/v7/app/ActionBarActivity;

    const v2, 0x1020002

    invoke-virtual {v1, v2}, Landroid/support/v7/app/ActionBarActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/view/ViewGroup;

    .line 227
    .local v0, "contentParent":Landroid/view/ViewGroup;
    invoke-virtual {v0}, Landroid/view/ViewGroup;->removeAllViews()V

    .line 228
    iget-object v1, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mActivity:Landroid/support/v7/app/ActionBarActivity;

    invoke-virtual {v1}, Landroid/support/v7/app/ActionBarActivity;->getLayoutInflater()Landroid/view/LayoutInflater;

    move-result-object v1

    invoke-virtual {v1, p1, v0}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    .line 229
    iget-object v1, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mActivity:Landroid/support/v7/app/ActionBarActivity;

    invoke-virtual {v1}, Landroid/support/v7/app/ActionBarActivity;->onSupportContentChanged()V

    .line 230
    return-void
.end method

.method public setContentView(Landroid/view/View;)V
    .locals 3
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 216
    invoke-virtual {p0}, Landroid/support/v7/app/ActionBarActivityDelegateBase;->ensureSubDecor()V

    .line 217
    iget-object v1, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mActivity:Landroid/support/v7/app/ActionBarActivity;

    const v2, 0x1020002

    invoke-virtual {v1, v2}, Landroid/support/v7/app/ActionBarActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/view/ViewGroup;

    .line 218
    .local v0, "contentParent":Landroid/view/ViewGroup;
    invoke-virtual {v0}, Landroid/view/ViewGroup;->removeAllViews()V

    .line 219
    invoke-virtual {v0, p1}, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V

    .line 220
    iget-object v1, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mActivity:Landroid/support/v7/app/ActionBarActivity;

    invoke-virtual {v1}, Landroid/support/v7/app/ActionBarActivity;->onSupportContentChanged()V

    .line 221
    return-void
.end method

.method public setContentView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    .locals 3
    .param p1, "v"    # Landroid/view/View;
    .param p2, "lp"    # Landroid/view/ViewGroup$LayoutParams;

    .prologue
    .line 234
    invoke-virtual {p0}, Landroid/support/v7/app/ActionBarActivityDelegateBase;->ensureSubDecor()V

    .line 235
    iget-object v1, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mActivity:Landroid/support/v7/app/ActionBarActivity;

    const v2, 0x1020002

    invoke-virtual {v1, v2}, Landroid/support/v7/app/ActionBarActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/view/ViewGroup;

    .line 236
    .local v0, "contentParent":Landroid/view/ViewGroup;
    invoke-virtual {v0}, Landroid/view/ViewGroup;->removeAllViews()V

    .line 237
    invoke-virtual {v0, p1, p2}, Landroid/view/ViewGroup;->addView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V

    .line 238
    iget-object v1, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mActivity:Landroid/support/v7/app/ActionBarActivity;

    invoke-virtual {v1}, Landroid/support/v7/app/ActionBarActivity;->onSupportContentChanged()V

    .line 239
    return-void
.end method

.method setSupportActionBar(Landroid/support/v7/widget/Toolbar;)V
    .locals 5
    .param p1, "toolbar"    # Landroid/support/v7/widget/Toolbar;

    .prologue
    .line 163
    invoke-virtual {p0}, Landroid/support/v7/app/ActionBarActivityDelegateBase;->getSupportActionBar()Landroid/support/v7/app/ActionBar;

    move-result-object v0

    .line 164
    .local v0, "ab":Landroid/support/v7/app/ActionBar;
    instance-of v2, v0, Landroid/support/v7/internal/app/WindowDecorActionBar;

    if-eqz v2, :cond_0

    .line 165
    new-instance v2, Ljava/lang/IllegalStateException;

    const-string v3, "This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead."

    invoke-direct {v2, v3}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 168
    :cond_0
    instance-of v2, v0, Landroid/support/v7/internal/app/ToolbarActionBar;

    if-eqz v2, :cond_1

    .line 170
    check-cast v0, Landroid/support/v7/internal/app/ToolbarActionBar;

    .end local v0    # "ab":Landroid/support/v7/app/ActionBar;
    const/4 v2, 0x0

    invoke-virtual {v0, v2}, Landroid/support/v7/internal/app/ToolbarActionBar;->setListMenuPresenter(Landroid/support/v7/internal/view/menu/ListMenuPresenter;)V

    .line 175
    :cond_1
    new-instance v1, Landroid/support/v7/internal/app/ToolbarActionBar;

    iget-object v2, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mActivity:Landroid/support/v7/app/ActionBarActivity;

    invoke-virtual {v2}, Landroid/support/v7/app/ActionBarActivity;->getTitle()Ljava/lang/CharSequence;

    move-result-object v2

    iget-object v3, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mActivity:Landroid/support/v7/app/ActionBarActivity;

    invoke-virtual {v3}, Landroid/support/v7/app/ActionBarActivity;->getWindow()Landroid/view/Window;

    move-result-object v3

    iget-object v4, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mDefaultWindowCallback:Landroid/support/v7/internal/app/WindowCallback;

    invoke-direct {v1, p1, v2, v3, v4}, Landroid/support/v7/internal/app/ToolbarActionBar;-><init>(Landroid/support/v7/widget/Toolbar;Ljava/lang/CharSequence;Landroid/view/Window;Landroid/support/v7/internal/app/WindowCallback;)V

    .line 177
    .local v1, "tbab":Landroid/support/v7/internal/app/ToolbarActionBar;
    invoke-direct {p0}, Landroid/support/v7/app/ActionBarActivityDelegateBase;->ensureToolbarListMenuPresenter()V

    .line 178
    iget-object v2, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mToolbarListMenuPresenter:Landroid/support/v7/internal/view/menu/ListMenuPresenter;

    invoke-virtual {v1, v2}, Landroid/support/v7/internal/app/ToolbarActionBar;->setListMenuPresenter(Landroid/support/v7/internal/view/menu/ListMenuPresenter;)V

    .line 179
    invoke-virtual {p0, v1}, Landroid/support/v7/app/ActionBarActivityDelegateBase;->setSupportActionBar(Landroid/support/v7/app/ActionBar;)V

    .line 180
    invoke-virtual {v1}, Landroid/support/v7/internal/app/ToolbarActionBar;->getWrappedWindowCallback()Landroid/support/v7/internal/app/WindowCallback;

    move-result-object v2

    invoke-virtual {p0, v2}, Landroid/support/v7/app/ActionBarActivityDelegateBase;->setWindowCallback(Landroid/support/v7/internal/app/WindowCallback;)V

    .line 181
    invoke-virtual {v1}, Landroid/support/v7/internal/app/ToolbarActionBar;->invalidateOptionsMenu()Z

    .line 182
    return-void
.end method

.method setSupportProgress(I)V
    .locals 0
    .param p1, "progress"    # I

    .prologue
    .line 707
    return-void
.end method

.method setSupportProgressBarIndeterminate(Z)V
    .locals 0
    .param p1, "indeterminate"    # Z

    .prologue
    .line 702
    return-void
.end method

.method setSupportProgressBarIndeterminateVisibility(Z)V
    .locals 0
    .param p1, "visible"    # Z

    .prologue
    .line 697
    return-void
.end method

.method setSupportProgressBarVisibility(Z)V
    .locals 0
    .param p1, "visible"    # Z

    .prologue
    .line 692
    return-void
.end method

.method public startSupportActionMode(Landroid/support/v7/view/ActionMode$Callback;)Landroid/support/v7/view/ActionMode;
    .locals 4
    .param p1, "callback"    # Landroid/support/v7/view/ActionMode$Callback;

    .prologue
    .line 569
    if-nez p1, :cond_0

    .line 570
    new-instance v2, Ljava/lang/IllegalArgumentException;

    const-string v3, "ActionMode callback can not be null."

    invoke-direct {v2, v3}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 573
    :cond_0
    iget-object v2, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mActionMode:Landroid/support/v7/view/ActionMode;

    if-eqz v2, :cond_1

    .line 574
    iget-object v2, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mActionMode:Landroid/support/v7/view/ActionMode;

    invoke-virtual {v2}, Landroid/support/v7/view/ActionMode;->finish()V

    .line 577
    :cond_1
    new-instance v1, Landroid/support/v7/app/ActionBarActivityDelegateBase$ActionModeCallbackWrapper;

    invoke-direct {v1, p0, p1}, Landroid/support/v7/app/ActionBarActivityDelegateBase$ActionModeCallbackWrapper;-><init>(Landroid/support/v7/app/ActionBarActivityDelegateBase;Landroid/support/v7/view/ActionMode$Callback;)V

    .line 579
    .local v1, "wrappedCallback":Landroid/support/v7/view/ActionMode$Callback;
    invoke-virtual {p0}, Landroid/support/v7/app/ActionBarActivityDelegateBase;->getSupportActionBar()Landroid/support/v7/app/ActionBar;

    move-result-object v0

    .line 580
    .local v0, "ab":Landroid/support/v7/app/ActionBar;
    if-eqz v0, :cond_2

    .line 581
    invoke-virtual {v0, v1}, Landroid/support/v7/app/ActionBar;->startActionMode(Landroid/support/v7/view/ActionMode$Callback;)Landroid/support/v7/view/ActionMode;

    move-result-object v2

    iput-object v2, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mActionMode:Landroid/support/v7/view/ActionMode;

    .line 582
    iget-object v2, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mActionMode:Landroid/support/v7/view/ActionMode;

    if-eqz v2, :cond_2

    .line 583
    iget-object v2, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mActivity:Landroid/support/v7/app/ActionBarActivity;

    iget-object v3, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mActionMode:Landroid/support/v7/view/ActionMode;

    invoke-virtual {v2, v3}, Landroid/support/v7/app/ActionBarActivity;->onSupportActionModeStarted(Landroid/support/v7/view/ActionMode;)V

    .line 587
    :cond_2
    iget-object v2, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mActionMode:Landroid/support/v7/view/ActionMode;

    if-nez v2, :cond_3

    .line 589
    invoke-virtual {p0, v1}, Landroid/support/v7/app/ActionBarActivityDelegateBase;->startSupportActionModeFromWindow(Landroid/support/v7/view/ActionMode$Callback;)Landroid/support/v7/view/ActionMode;

    move-result-object v2

    iput-object v2, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mActionMode:Landroid/support/v7/view/ActionMode;

    .line 592
    :cond_3
    iget-object v2, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mActionMode:Landroid/support/v7/view/ActionMode;

    return-object v2
.end method

.method startSupportActionModeFromWindow(Landroid/support/v7/view/ActionMode$Callback;)Landroid/support/v7/view/ActionMode;
    .locals 11
    .param p1, "callback"    # Landroid/support/v7/view/ActionMode$Callback;

    .prologue
    const/4 v10, 0x0

    const/4 v7, 0x1

    const/4 v8, 0x0

    .line 605
    iget-object v6, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mActionMode:Landroid/support/v7/view/ActionMode;

    if-eqz v6, :cond_0

    .line 606
    iget-object v6, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mActionMode:Landroid/support/v7/view/ActionMode;

    invoke-virtual {v6}, Landroid/support/v7/view/ActionMode;->finish()V

    .line 609
    :cond_0
    new-instance v5, Landroid/support/v7/app/ActionBarActivityDelegateBase$ActionModeCallbackWrapper;

    invoke-direct {v5, p0, p1}, Landroid/support/v7/app/ActionBarActivityDelegateBase$ActionModeCallbackWrapper;-><init>(Landroid/support/v7/app/ActionBarActivityDelegateBase;Landroid/support/v7/view/ActionMode$Callback;)V

    .line 610
    .local v5, "wrappedCallback":Landroid/support/v7/view/ActionMode$Callback;
    invoke-virtual {p0}, Landroid/support/v7/app/ActionBarActivityDelegateBase;->getActionBarThemedContext()Landroid/content/Context;

    move-result-object v0

    .line 612
    .local v0, "context":Landroid/content/Context;
    iget-object v6, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mActionModeView:Landroid/support/v7/internal/widget/ActionBarContextView;

    if-nez v6, :cond_1

    .line 613
    iget-boolean v6, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mIsFloating:Z

    if-eqz v6, :cond_5

    .line 614
    new-instance v6, Landroid/support/v7/internal/widget/ActionBarContextView;

    invoke-direct {v6, v0}, Landroid/support/v7/internal/widget/ActionBarContextView;-><init>(Landroid/content/Context;)V

    iput-object v6, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mActionModeView:Landroid/support/v7/internal/widget/ActionBarContextView;

    .line 615
    new-instance v6, Landroid/widget/PopupWindow;

    sget v9, Landroid/support/v7/appcompat/R$attr;->actionModePopupWindowStyle:I

    invoke-direct {v6, v0, v10, v9}, Landroid/widget/PopupWindow;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    iput-object v6, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mActionModePopup:Landroid/widget/PopupWindow;

    .line 617
    iget-object v6, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mActionModePopup:Landroid/widget/PopupWindow;

    iget-object v9, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mActionModeView:Landroid/support/v7/internal/widget/ActionBarContextView;

    invoke-virtual {v6, v9}, Landroid/widget/PopupWindow;->setContentView(Landroid/view/View;)V

    .line 618
    iget-object v6, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mActionModePopup:Landroid/widget/PopupWindow;

    const/4 v9, -0x1

    invoke-virtual {v6, v9}, Landroid/widget/PopupWindow;->setWidth(I)V

    .line 620
    new-instance v2, Landroid/util/TypedValue;

    invoke-direct {v2}, Landroid/util/TypedValue;-><init>()V

    .line 621
    .local v2, "heightValue":Landroid/util/TypedValue;
    iget-object v6, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mActivity:Landroid/support/v7/app/ActionBarActivity;

    invoke-virtual {v6}, Landroid/support/v7/app/ActionBarActivity;->getTheme()Landroid/content/res/Resources$Theme;

    move-result-object v6

    sget v9, Landroid/support/v7/appcompat/R$attr;->actionBarSize:I

    invoke-virtual {v6, v9, v2, v7}, Landroid/content/res/Resources$Theme;->resolveAttribute(ILandroid/util/TypedValue;Z)Z

    .line 622
    iget v6, v2, Landroid/util/TypedValue;->data:I

    iget-object v9, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mActivity:Landroid/support/v7/app/ActionBarActivity;

    invoke-virtual {v9}, Landroid/support/v7/app/ActionBarActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v9

    invoke-virtual {v9}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v9

    invoke-static {v6, v9}, Landroid/util/TypedValue;->complexToDimensionPixelSize(ILandroid/util/DisplayMetrics;)I

    move-result v1

    .line 624
    .local v1, "height":I
    iget-object v6, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mActionModeView:Landroid/support/v7/internal/widget/ActionBarContextView;

    invoke-virtual {v6, v1}, Landroid/support/v7/internal/widget/ActionBarContextView;->setContentHeight(I)V

    .line 625
    iget-object v6, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mActionModePopup:Landroid/widget/PopupWindow;

    const/4 v9, -0x2

    invoke-virtual {v6, v9}, Landroid/widget/PopupWindow;->setHeight(I)V

    .line 626
    new-instance v6, Landroid/support/v7/app/ActionBarActivityDelegateBase$4;

    invoke-direct {v6, p0}, Landroid/support/v7/app/ActionBarActivityDelegateBase$4;-><init>(Landroid/support/v7/app/ActionBarActivityDelegateBase;)V

    iput-object v6, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mShowActionModePopup:Ljava/lang/Runnable;

    .line 644
    .end local v1    # "height":I
    .end local v2    # "heightValue":Landroid/util/TypedValue;
    :cond_1
    :goto_0
    iget-object v6, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mActionModeView:Landroid/support/v7/internal/widget/ActionBarContextView;

    if-eqz v6, :cond_3

    .line 645
    iget-object v6, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mActionModeView:Landroid/support/v7/internal/widget/ActionBarContextView;

    invoke-virtual {v6}, Landroid/support/v7/internal/widget/ActionBarContextView;->killMode()V

    .line 646
    new-instance v3, Landroid/support/v7/internal/view/StandaloneActionMode;

    iget-object v9, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mActionModeView:Landroid/support/v7/internal/widget/ActionBarContextView;

    iget-object v6, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mActionModePopup:Landroid/widget/PopupWindow;

    if-nez v6, :cond_6

    move v6, v7

    :goto_1
    invoke-direct {v3, v0, v9, v5, v6}, Landroid/support/v7/internal/view/StandaloneActionMode;-><init>(Landroid/content/Context;Landroid/support/v7/internal/widget/ActionBarContextView;Landroid/support/v7/view/ActionMode$Callback;Z)V

    .line 648
    .local v3, "mode":Landroid/support/v7/view/ActionMode;
    invoke-virtual {v3}, Landroid/support/v7/view/ActionMode;->getMenu()Landroid/view/Menu;

    move-result-object v6

    invoke-interface {p1, v3, v6}, Landroid/support/v7/view/ActionMode$Callback;->onCreateActionMode(Landroid/support/v7/view/ActionMode;Landroid/view/Menu;)Z

    move-result v6

    if-eqz v6, :cond_7

    .line 649
    invoke-virtual {v3}, Landroid/support/v7/view/ActionMode;->invalidate()V

    .line 650
    iget-object v6, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mActionModeView:Landroid/support/v7/internal/widget/ActionBarContextView;

    invoke-virtual {v6, v3}, Landroid/support/v7/internal/widget/ActionBarContextView;->initForMode(Landroid/support/v7/view/ActionMode;)V

    .line 651
    iget-object v6, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mActionModeView:Landroid/support/v7/internal/widget/ActionBarContextView;

    invoke-virtual {v6, v8}, Landroid/support/v7/internal/widget/ActionBarContextView;->setVisibility(I)V

    .line 652
    iput-object v3, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mActionMode:Landroid/support/v7/view/ActionMode;

    .line 653
    iget-object v6, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mActionModePopup:Landroid/widget/PopupWindow;

    if-eqz v6, :cond_2

    .line 654
    iget-object v6, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mActivity:Landroid/support/v7/app/ActionBarActivity;

    invoke-virtual {v6}, Landroid/support/v7/app/ActionBarActivity;->getWindow()Landroid/view/Window;

    move-result-object v6

    invoke-virtual {v6}, Landroid/view/Window;->getDecorView()Landroid/view/View;

    move-result-object v6

    iget-object v7, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mShowActionModePopup:Ljava/lang/Runnable;

    invoke-virtual {v6, v7}, Landroid/view/View;->post(Ljava/lang/Runnable;)Z

    .line 656
    :cond_2
    iget-object v6, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mActionModeView:Landroid/support/v7/internal/widget/ActionBarContextView;

    const/16 v7, 0x20

    invoke-virtual {v6, v7}, Landroid/support/v7/internal/widget/ActionBarContextView;->sendAccessibilityEvent(I)V

    .line 659
    iget-object v6, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mActionModeView:Landroid/support/v7/internal/widget/ActionBarContextView;

    invoke-virtual {v6}, Landroid/support/v7/internal/widget/ActionBarContextView;->getParent()Landroid/view/ViewParent;

    move-result-object v6

    if-eqz v6, :cond_3

    .line 660
    iget-object v6, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mActionModeView:Landroid/support/v7/internal/widget/ActionBarContextView;

    invoke-virtual {v6}, Landroid/support/v7/internal/widget/ActionBarContextView;->getParent()Landroid/view/ViewParent;

    move-result-object v6

    check-cast v6, Landroid/view/View;

    invoke-static {v6}, Landroid/support/v4/view/ViewCompat;->requestApplyInsets(Landroid/view/View;)V

    .line 666
    .end local v3    # "mode":Landroid/support/v7/view/ActionMode;
    :cond_3
    :goto_2
    iget-object v6, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mActionMode:Landroid/support/v7/view/ActionMode;

    if-eqz v6, :cond_4

    iget-object v6, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mActivity:Landroid/support/v7/app/ActionBarActivity;

    if-eqz v6, :cond_4

    .line 667
    iget-object v6, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mActivity:Landroid/support/v7/app/ActionBarActivity;

    iget-object v7, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mActionMode:Landroid/support/v7/view/ActionMode;

    invoke-virtual {v6, v7}, Landroid/support/v7/app/ActionBarActivity;->onSupportActionModeStarted(Landroid/support/v7/view/ActionMode;)V

    .line 669
    :cond_4
    iget-object v6, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mActionMode:Landroid/support/v7/view/ActionMode;

    return-object v6

    .line 634
    :cond_5
    iget-object v6, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mActivity:Landroid/support/v7/app/ActionBarActivity;

    sget v9, Landroid/support/v7/appcompat/R$id;->action_mode_bar_stub:I

    invoke-virtual {v6, v9}, Landroid/support/v7/app/ActionBarActivity;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/support/v7/internal/widget/ViewStubCompat;

    .line 636
    .local v4, "stub":Landroid/support/v7/internal/widget/ViewStubCompat;
    if-eqz v4, :cond_1

    .line 638
    invoke-static {v0}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v6

    invoke-virtual {v4, v6}, Landroid/support/v7/internal/widget/ViewStubCompat;->setLayoutInflater(Landroid/view/LayoutInflater;)V

    .line 639
    invoke-virtual {v4}, Landroid/support/v7/internal/widget/ViewStubCompat;->inflate()Landroid/view/View;

    move-result-object v6

    check-cast v6, Landroid/support/v7/internal/widget/ActionBarContextView;

    iput-object v6, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mActionModeView:Landroid/support/v7/internal/widget/ActionBarContextView;

    goto/16 :goto_0

    .end local v4    # "stub":Landroid/support/v7/internal/widget/ViewStubCompat;
    :cond_6
    move v6, v8

    .line 646
    goto :goto_1

    .line 663
    .restart local v3    # "mode":Landroid/support/v7/view/ActionMode;
    :cond_7
    iput-object v10, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mActionMode:Landroid/support/v7/view/ActionMode;

    goto :goto_2
.end method

.method public supportInvalidateOptionsMenu()V
    .locals 2

    .prologue
    .line 597
    invoke-virtual {p0}, Landroid/support/v7/app/ActionBarActivityDelegateBase;->getSupportActionBar()Landroid/support/v7/app/ActionBar;

    move-result-object v0

    .line 598
    .local v0, "ab":Landroid/support/v7/app/ActionBar;
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Landroid/support/v7/app/ActionBar;->invalidateOptionsMenu()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 601
    :goto_0
    return-void

    .line 600
    :cond_0
    const/4 v1, 0x0

    invoke-direct {p0, v1}, Landroid/support/v7/app/ActionBarActivityDelegateBase;->invalidatePanelMenu(I)V

    goto :goto_0
.end method

.method public supportRequestWindowFeature(I)Z
    .locals 1
    .param p1, "featureId"    # I

    .prologue
    const/4 v0, 0x1

    .line 437
    packed-switch p1, :pswitch_data_0

    .line 460
    :pswitch_0
    iget-object v0, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mActivity:Landroid/support/v7/app/ActionBarActivity;

    invoke-virtual {v0, p1}, Landroid/support/v7/app/ActionBarActivity;->requestWindowFeature(I)Z

    move-result v0

    :goto_0
    return v0

    .line 439
    :pswitch_1
    invoke-direct {p0}, Landroid/support/v7/app/ActionBarActivityDelegateBase;->throwFeatureRequestIfSubDecorInstalled()V

    .line 440
    iput-boolean v0, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mHasActionBar:Z

    goto :goto_0

    .line 443
    :pswitch_2
    invoke-direct {p0}, Landroid/support/v7/app/ActionBarActivityDelegateBase;->throwFeatureRequestIfSubDecorInstalled()V

    .line 444
    iput-boolean v0, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mOverlayActionBar:Z

    goto :goto_0

    .line 447
    :pswitch_3
    invoke-direct {p0}, Landroid/support/v7/app/ActionBarActivityDelegateBase;->throwFeatureRequestIfSubDecorInstalled()V

    .line 448
    iput-boolean v0, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mOverlayActionMode:Z

    goto :goto_0

    .line 451
    :pswitch_4
    invoke-direct {p0}, Landroid/support/v7/app/ActionBarActivityDelegateBase;->throwFeatureRequestIfSubDecorInstalled()V

    .line 452
    iput-boolean v0, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mFeatureProgress:Z

    goto :goto_0

    .line 455
    :pswitch_5
    invoke-direct {p0}, Landroid/support/v7/app/ActionBarActivityDelegateBase;->throwFeatureRequestIfSubDecorInstalled()V

    .line 456
    iput-boolean v0, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mFeatureIndeterminateProgress:Z

    goto :goto_0

    .line 437
    nop

    :pswitch_data_0
    .packed-switch 0x2
        :pswitch_4
        :pswitch_0
        :pswitch_0
        :pswitch_5
        :pswitch_0
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
    .end packed-switch
.end method
