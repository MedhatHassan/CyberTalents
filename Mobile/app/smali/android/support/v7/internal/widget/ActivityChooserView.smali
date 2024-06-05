.class public Landroid/support/v7/internal/widget/ActivityChooserView;
.super Landroid/view/ViewGroup;
.source "ActivityChooserView.java"

# interfaces
.implements Landroid/support/v7/internal/widget/ActivityChooserModel$ActivityChooserModelClient;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/support/v7/internal/widget/ActivityChooserView$ActivityChooserViewAdapter;,
        Landroid/support/v7/internal/widget/ActivityChooserView$Callbacks;
    }
.end annotation


# instance fields
.field private final mActivityChooserContent:Landroid/support/v7/widget/LinearLayoutCompat;

.field private final mActivityChooserContentBackground:Landroid/graphics/drawable/Drawable;

.field private final mAdapter:Landroid/support/v7/internal/widget/ActivityChooserView$ActivityChooserViewAdapter;

.field private final mCallbacks:Landroid/support/v7/internal/widget/ActivityChooserView$Callbacks;

.field private mDefaultActionButtonContentDescription:I

.field private final mDefaultActivityButton:Landroid/widget/FrameLayout;

.field private final mDefaultActivityButtonImage:Landroid/widget/ImageView;

.field private final mExpandActivityOverflowButton:Landroid/widget/FrameLayout;

.field private final mExpandActivityOverflowButtonImage:Landroid/widget/ImageView;

.field private mInitialActivityCount:I

.field private mIsAttachedToWindow:Z

.field private mIsSelectingDefaultActivity:Z

.field private final mListPopupMaxWidth:I

.field private mListPopupWindow:Landroid/support/v7/widget/ListPopupWindow;

.field private final mModelDataSetOberver:Landroid/database/DataSetObserver;

.field private mOnDismissListener:Landroid/widget/PopupWindow$OnDismissListener;

.field private final mOnGlobalLayoutListener:Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;

.field mProvider:Landroid/support/v4/view/ActionProvider;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 190
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Landroid/support/v7/internal/widget/ActivityChooserView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 191
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 200
    const/4 v0, 0x0

    invoke-direct {p0, p1, p2, v0}, Landroid/support/v7/internal/widget/ActivityChooserView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 201
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 8
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;
    .param p3, "defStyle"    # I

    .prologue
    const/4 v7, 0x0

    const/4 v6, 0x4

    .line 211
    invoke-direct {p0, p1, p2, p3}, Landroid/view/ViewGroup;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 124
    new-instance v4, Landroid/support/v7/internal/widget/ActivityChooserView$1;

    invoke-direct {v4, p0}, Landroid/support/v7/internal/widget/ActivityChooserView$1;-><init>(Landroid/support/v7/internal/widget/ActivityChooserView;)V

    iput-object v4, p0, Landroid/support/v7/internal/widget/ActivityChooserView;->mModelDataSetOberver:Landroid/database/DataSetObserver;

    .line 138
    new-instance v4, Landroid/support/v7/internal/widget/ActivityChooserView$2;

    invoke-direct {v4, p0}, Landroid/support/v7/internal/widget/ActivityChooserView$2;-><init>(Landroid/support/v7/internal/widget/ActivityChooserView;)V

    iput-object v4, p0, Landroid/support/v7/internal/widget/ActivityChooserView;->mOnGlobalLayoutListener:Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;

    .line 172
    iput v6, p0, Landroid/support/v7/internal/widget/ActivityChooserView;->mInitialActivityCount:I

    .line 213
    sget-object v4, Landroid/support/v7/appcompat/R$styleable;->ActivityChooserView:[I

    const/4 v5, 0x0

    invoke-virtual {p1, p2, v4, p3, v5}, Landroid/content/Context;->obtainStyledAttributes(Landroid/util/AttributeSet;[III)Landroid/content/res/TypedArray;

    move-result-object v0

    .line 216
    .local v0, "attributesArray":Landroid/content/res/TypedArray;
    sget v4, Landroid/support/v7/appcompat/R$styleable;->ActivityChooserView_initialActivityCount:I

    invoke-virtual {v0, v4, v6}, Landroid/content/res/TypedArray;->getInt(II)I

    move-result v4

    iput v4, p0, Landroid/support/v7/internal/widget/ActivityChooserView;->mInitialActivityCount:I

    .line 220
    sget v4, Landroid/support/v7/appcompat/R$styleable;->ActivityChooserView_expandActivityOverflowButtonDrawable:I

    invoke-virtual {v0, v4}, Landroid/content/res/TypedArray;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v1

    .line 223
    .local v1, "expandActivityOverflowButtonDrawable":Landroid/graphics/drawable/Drawable;
    invoke-virtual {v0}, Landroid/content/res/TypedArray;->recycle()V

    .line 225
    invoke-virtual {p0}, Landroid/support/v7/internal/widget/ActivityChooserView;->getContext()Landroid/content/Context;

    move-result-object v4

    invoke-static {v4}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v2

    .line 226
    .local v2, "inflater":Landroid/view/LayoutInflater;
    sget v4, Landroid/support/v7/appcompat/R$layout;->abc_activity_chooser_view:I

    const/4 v5, 0x1

    invoke-virtual {v2, v4, p0, v5}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    .line 228
    new-instance v4, Landroid/support/v7/internal/widget/ActivityChooserView$Callbacks;

    invoke-direct {v4, p0, v7}, Landroid/support/v7/internal/widget/ActivityChooserView$Callbacks;-><init>(Landroid/support/v7/internal/widget/ActivityChooserView;Landroid/support/v7/internal/widget/ActivityChooserView$1;)V

    iput-object v4, p0, Landroid/support/v7/internal/widget/ActivityChooserView;->mCallbacks:Landroid/support/v7/internal/widget/ActivityChooserView$Callbacks;

    .line 230
    sget v4, Landroid/support/v7/appcompat/R$id;->activity_chooser_view_content:I

    invoke-virtual {p0, v4}, Landroid/support/v7/internal/widget/ActivityChooserView;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/support/v7/widget/LinearLayoutCompat;

    iput-object v4, p0, Landroid/support/v7/internal/widget/ActivityChooserView;->mActivityChooserContent:Landroid/support/v7/widget/LinearLayoutCompat;

    .line 231
    iget-object v4, p0, Landroid/support/v7/internal/widget/ActivityChooserView;->mActivityChooserContent:Landroid/support/v7/widget/LinearLayoutCompat;

    invoke-virtual {v4}, Landroid/support/v7/widget/LinearLayoutCompat;->getBackground()Landroid/graphics/drawable/Drawable;

    move-result-object v4

    iput-object v4, p0, Landroid/support/v7/internal/widget/ActivityChooserView;->mActivityChooserContentBackground:Landroid/graphics/drawable/Drawable;

    .line 233
    sget v4, Landroid/support/v7/appcompat/R$id;->default_activity_button:I

    invoke-virtual {p0, v4}, Landroid/support/v7/internal/widget/ActivityChooserView;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/FrameLayout;

    iput-object v4, p0, Landroid/support/v7/internal/widget/ActivityChooserView;->mDefaultActivityButton:Landroid/widget/FrameLayout;

    .line 234
    iget-object v4, p0, Landroid/support/v7/internal/widget/ActivityChooserView;->mDefaultActivityButton:Landroid/widget/FrameLayout;

    iget-object v5, p0, Landroid/support/v7/internal/widget/ActivityChooserView;->mCallbacks:Landroid/support/v7/internal/widget/ActivityChooserView$Callbacks;

    invoke-virtual {v4, v5}, Landroid/widget/FrameLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 235
    iget-object v4, p0, Landroid/support/v7/internal/widget/ActivityChooserView;->mDefaultActivityButton:Landroid/widget/FrameLayout;

    iget-object v5, p0, Landroid/support/v7/internal/widget/ActivityChooserView;->mCallbacks:Landroid/support/v7/internal/widget/ActivityChooserView$Callbacks;

    invoke-virtual {v4, v5}, Landroid/widget/FrameLayout;->setOnLongClickListener(Landroid/view/View$OnLongClickListener;)V

    .line 236
    iget-object v4, p0, Landroid/support/v7/internal/widget/ActivityChooserView;->mDefaultActivityButton:Landroid/widget/FrameLayout;

    sget v5, Landroid/support/v7/appcompat/R$id;->image:I

    invoke-virtual {v4, v5}, Landroid/widget/FrameLayout;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/ImageView;

    iput-object v4, p0, Landroid/support/v7/internal/widget/ActivityChooserView;->mDefaultActivityButtonImage:Landroid/widget/ImageView;

    .line 238
    sget v4, Landroid/support/v7/appcompat/R$id;->expand_activities_button:I

    invoke-virtual {p0, v4}, Landroid/support/v7/internal/widget/ActivityChooserView;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/FrameLayout;

    iput-object v4, p0, Landroid/support/v7/internal/widget/ActivityChooserView;->mExpandActivityOverflowButton:Landroid/widget/FrameLayout;

    .line 239
    iget-object v4, p0, Landroid/support/v7/internal/widget/ActivityChooserView;->mExpandActivityOverflowButton:Landroid/widget/FrameLayout;

    iget-object v5, p0, Landroid/support/v7/internal/widget/ActivityChooserView;->mCallbacks:Landroid/support/v7/internal/widget/ActivityChooserView$Callbacks;

    invoke-virtual {v4, v5}, Landroid/widget/FrameLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 240
    iget-object v4, p0, Landroid/support/v7/internal/widget/ActivityChooserView;->mExpandActivityOverflowButton:Landroid/widget/FrameLayout;

    sget v5, Landroid/support/v7/appcompat/R$id;->image:I

    invoke-virtual {v4, v5}, Landroid/widget/FrameLayout;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/ImageView;

    iput-object v4, p0, Landroid/support/v7/internal/widget/ActivityChooserView;->mExpandActivityOverflowButtonImage:Landroid/widget/ImageView;

    .line 242
    iget-object v4, p0, Landroid/support/v7/internal/widget/ActivityChooserView;->mExpandActivityOverflowButtonImage:Landroid/widget/ImageView;

    invoke-virtual {v4, v1}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 244
    new-instance v4, Landroid/support/v7/internal/widget/ActivityChooserView$ActivityChooserViewAdapter;

    invoke-direct {v4, p0, v7}, Landroid/support/v7/internal/widget/ActivityChooserView$ActivityChooserViewAdapter;-><init>(Landroid/support/v7/internal/widget/ActivityChooserView;Landroid/support/v7/internal/widget/ActivityChooserView$1;)V

    iput-object v4, p0, Landroid/support/v7/internal/widget/ActivityChooserView;->mAdapter:Landroid/support/v7/internal/widget/ActivityChooserView$ActivityChooserViewAdapter;

    .line 245
    iget-object v4, p0, Landroid/support/v7/internal/widget/ActivityChooserView;->mAdapter:Landroid/support/v7/internal/widget/ActivityChooserView$ActivityChooserViewAdapter;

    new-instance v5, Landroid/support/v7/internal/widget/ActivityChooserView$3;

    invoke-direct {v5, p0}, Landroid/support/v7/internal/widget/ActivityChooserView$3;-><init>(Landroid/support/v7/internal/widget/ActivityChooserView;)V

    invoke-virtual {v4, v5}, Landroid/support/v7/internal/widget/ActivityChooserView$ActivityChooserViewAdapter;->registerDataSetObserver(Landroid/database/DataSetObserver;)V

    .line 253
    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    .line 254
    .local v3, "resources":Landroid/content/res/Resources;
    invoke-virtual {v3}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v4

    iget v4, v4, Landroid/util/DisplayMetrics;->widthPixels:I

    div-int/lit8 v4, v4, 0x2

    sget v5, Landroid/support/v7/appcompat/R$dimen;->abc_config_prefDialogWidth:I

    invoke-virtual {v3, v5}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v5

    invoke-static {v4, v5}, Ljava/lang/Math;->max(II)I

    move-result v4

    iput v4, p0, Landroid/support/v7/internal/widget/ActivityChooserView;->mListPopupMaxWidth:I

    .line 256
    return-void
.end method

.method static synthetic access$000(Landroid/support/v7/internal/widget/ActivityChooserView;)Landroid/support/v7/internal/widget/ActivityChooserView$ActivityChooserViewAdapter;
    .locals 1
    .param p0, "x0"    # Landroid/support/v7/internal/widget/ActivityChooserView;

    .prologue
    .line 68
    iget-object v0, p0, Landroid/support/v7/internal/widget/ActivityChooserView;->mAdapter:Landroid/support/v7/internal/widget/ActivityChooserView$ActivityChooserViewAdapter;

    return-object v0
.end method

.method static synthetic access$100(Landroid/support/v7/internal/widget/ActivityChooserView;)Landroid/support/v7/widget/ListPopupWindow;
    .locals 1
    .param p0, "x0"    # Landroid/support/v7/internal/widget/ActivityChooserView;

    .prologue
    .line 68
    invoke-direct {p0}, Landroid/support/v7/internal/widget/ActivityChooserView;->getListPopupWindow()Landroid/support/v7/widget/ListPopupWindow;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$1000(Landroid/support/v7/internal/widget/ActivityChooserView;)Landroid/widget/PopupWindow$OnDismissListener;
    .locals 1
    .param p0, "x0"    # Landroid/support/v7/internal/widget/ActivityChooserView;

    .prologue
    .line 68
    iget-object v0, p0, Landroid/support/v7/internal/widget/ActivityChooserView;->mOnDismissListener:Landroid/widget/PopupWindow$OnDismissListener;

    return-object v0
.end method

.method static synthetic access$1100(Landroid/support/v7/internal/widget/ActivityChooserView;)Landroid/database/DataSetObserver;
    .locals 1
    .param p0, "x0"    # Landroid/support/v7/internal/widget/ActivityChooserView;

    .prologue
    .line 68
    iget-object v0, p0, Landroid/support/v7/internal/widget/ActivityChooserView;->mModelDataSetOberver:Landroid/database/DataSetObserver;

    return-object v0
.end method

.method static synthetic access$400(Landroid/support/v7/internal/widget/ActivityChooserView;)V
    .locals 0
    .param p0, "x0"    # Landroid/support/v7/internal/widget/ActivityChooserView;

    .prologue
    .line 68
    invoke-direct {p0}, Landroid/support/v7/internal/widget/ActivityChooserView;->updateAppearance()V

    return-void
.end method

.method static synthetic access$500(Landroid/support/v7/internal/widget/ActivityChooserView;I)V
    .locals 0
    .param p0, "x0"    # Landroid/support/v7/internal/widget/ActivityChooserView;
    .param p1, "x1"    # I

    .prologue
    .line 68
    invoke-direct {p0, p1}, Landroid/support/v7/internal/widget/ActivityChooserView;->showPopupUnchecked(I)V

    return-void
.end method

.method static synthetic access$600(Landroid/support/v7/internal/widget/ActivityChooserView;)Z
    .locals 1
    .param p0, "x0"    # Landroid/support/v7/internal/widget/ActivityChooserView;

    .prologue
    .line 68
    iget-boolean v0, p0, Landroid/support/v7/internal/widget/ActivityChooserView;->mIsSelectingDefaultActivity:Z

    return v0
.end method

.method static synthetic access$602(Landroid/support/v7/internal/widget/ActivityChooserView;Z)Z
    .locals 0
    .param p0, "x0"    # Landroid/support/v7/internal/widget/ActivityChooserView;
    .param p1, "x1"    # Z

    .prologue
    .line 68
    iput-boolean p1, p0, Landroid/support/v7/internal/widget/ActivityChooserView;->mIsSelectingDefaultActivity:Z

    return p1
.end method

.method static synthetic access$700(Landroid/support/v7/internal/widget/ActivityChooserView;)Landroid/widget/FrameLayout;
    .locals 1
    .param p0, "x0"    # Landroid/support/v7/internal/widget/ActivityChooserView;

    .prologue
    .line 68
    iget-object v0, p0, Landroid/support/v7/internal/widget/ActivityChooserView;->mDefaultActivityButton:Landroid/widget/FrameLayout;

    return-object v0
.end method

.method static synthetic access$800(Landroid/support/v7/internal/widget/ActivityChooserView;)Landroid/widget/FrameLayout;
    .locals 1
    .param p0, "x0"    # Landroid/support/v7/internal/widget/ActivityChooserView;

    .prologue
    .line 68
    iget-object v0, p0, Landroid/support/v7/internal/widget/ActivityChooserView;->mExpandActivityOverflowButton:Landroid/widget/FrameLayout;

    return-object v0
.end method

.method static synthetic access$900(Landroid/support/v7/internal/widget/ActivityChooserView;)I
    .locals 1
    .param p0, "x0"    # Landroid/support/v7/internal/widget/ActivityChooserView;

    .prologue
    .line 68
    iget v0, p0, Landroid/support/v7/internal/widget/ActivityChooserView;->mInitialActivityCount:I

    return v0
.end method

.method private getListPopupWindow()Landroid/support/v7/widget/ListPopupWindow;
    .locals 2

    .prologue
    .line 484
    iget-object v0, p0, Landroid/support/v7/internal/widget/ActivityChooserView;->mListPopupWindow:Landroid/support/v7/widget/ListPopupWindow;

    if-nez v0, :cond_0

    .line 485
    new-instance v0, Landroid/support/v7/widget/ListPopupWindow;

    invoke-virtual {p0}, Landroid/support/v7/internal/widget/ActivityChooserView;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/support/v7/widget/ListPopupWindow;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Landroid/support/v7/internal/widget/ActivityChooserView;->mListPopupWindow:Landroid/support/v7/widget/ListPopupWindow;

    .line 486
    iget-object v0, p0, Landroid/support/v7/internal/widget/ActivityChooserView;->mListPopupWindow:Landroid/support/v7/widget/ListPopupWindow;

    iget-object v1, p0, Landroid/support/v7/internal/widget/ActivityChooserView;->mAdapter:Landroid/support/v7/internal/widget/ActivityChooserView$ActivityChooserViewAdapter;

    invoke-virtual {v0, v1}, Landroid/support/v7/widget/ListPopupWindow;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 487
    iget-object v0, p0, Landroid/support/v7/internal/widget/ActivityChooserView;->mListPopupWindow:Landroid/support/v7/widget/ListPopupWindow;

    invoke-virtual {v0, p0}, Landroid/support/v7/widget/ListPopupWindow;->setAnchorView(Landroid/view/View;)V

    .line 488
    iget-object v0, p0, Landroid/support/v7/internal/widget/ActivityChooserView;->mListPopupWindow:Landroid/support/v7/widget/ListPopupWindow;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/support/v7/widget/ListPopupWindow;->setModal(Z)V

    .line 489
    iget-object v0, p0, Landroid/support/v7/internal/widget/ActivityChooserView;->mListPopupWindow:Landroid/support/v7/widget/ListPopupWindow;

    iget-object v1, p0, Landroid/support/v7/internal/widget/ActivityChooserView;->mCallbacks:Landroid/support/v7/internal/widget/ActivityChooserView$Callbacks;

    invoke-virtual {v0, v1}, Landroid/support/v7/widget/ListPopupWindow;->setOnItemClickListener(Landroid/widget/AdapterView$OnItemClickListener;)V

    .line 490
    iget-object v0, p0, Landroid/support/v7/internal/widget/ActivityChooserView;->mListPopupWindow:Landroid/support/v7/widget/ListPopupWindow;

    iget-object v1, p0, Landroid/support/v7/internal/widget/ActivityChooserView;->mCallbacks:Landroid/support/v7/internal/widget/ActivityChooserView$Callbacks;

    invoke-virtual {v0, v1}, Landroid/support/v7/widget/ListPopupWindow;->setOnDismissListener(Landroid/widget/PopupWindow$OnDismissListener;)V

    .line 492
    :cond_0
    iget-object v0, p0, Landroid/support/v7/internal/widget/ActivityChooserView;->mListPopupWindow:Landroid/support/v7/widget/ListPopupWindow;

    return-object v0
.end method

.method private showPopupUnchecked(I)V
    .locals 9
    .param p1, "maxActivityCount"    # I

    .prologue
    const/4 v5, 0x1

    const/4 v6, 0x0

    .line 327
    iget-object v7, p0, Landroid/support/v7/internal/widget/ActivityChooserView;->mAdapter:Landroid/support/v7/internal/widget/ActivityChooserView$ActivityChooserViewAdapter;

    invoke-virtual {v7}, Landroid/support/v7/internal/widget/ActivityChooserView$ActivityChooserViewAdapter;->getDataModel()Landroid/support/v7/internal/widget/ActivityChooserModel;

    move-result-object v7

    if-nez v7, :cond_0

    .line 328
    new-instance v5, Ljava/lang/IllegalStateException;

    const-string v6, "No data model. Did you call #setDataModel?"

    invoke-direct {v5, v6}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v5

    .line 331
    :cond_0
    invoke-virtual {p0}, Landroid/support/v7/internal/widget/ActivityChooserView;->getViewTreeObserver()Landroid/view/ViewTreeObserver;

    move-result-object v7

    iget-object v8, p0, Landroid/support/v7/internal/widget/ActivityChooserView;->mOnGlobalLayoutListener:Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;

    invoke-virtual {v7, v8}, Landroid/view/ViewTreeObserver;->addOnGlobalLayoutListener(Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;)V

    .line 333
    iget-object v7, p0, Landroid/support/v7/internal/widget/ActivityChooserView;->mDefaultActivityButton:Landroid/widget/FrameLayout;

    invoke-virtual {v7}, Landroid/widget/FrameLayout;->getVisibility()I

    move-result v7

    if-nez v7, :cond_4

    move v2, v5

    .line 336
    .local v2, "defaultActivityButtonShown":Z
    :goto_0
    iget-object v7, p0, Landroid/support/v7/internal/widget/ActivityChooserView;->mAdapter:Landroid/support/v7/internal/widget/ActivityChooserView$ActivityChooserViewAdapter;

    invoke-virtual {v7}, Landroid/support/v7/internal/widget/ActivityChooserView$ActivityChooserViewAdapter;->getActivityCount()I

    move-result v0

    .line 337
    .local v0, "activityCount":I
    if-eqz v2, :cond_5

    move v3, v5

    .line 338
    .local v3, "maxActivityCountOffset":I
    :goto_1
    const v7, 0x7fffffff

    if-eq p1, v7, :cond_6

    add-int v7, p1, v3

    if-le v0, v7, :cond_6

    .line 340
    iget-object v7, p0, Landroid/support/v7/internal/widget/ActivityChooserView;->mAdapter:Landroid/support/v7/internal/widget/ActivityChooserView$ActivityChooserViewAdapter;

    invoke-virtual {v7, v5}, Landroid/support/v7/internal/widget/ActivityChooserView$ActivityChooserViewAdapter;->setShowFooterView(Z)V

    .line 341
    iget-object v7, p0, Landroid/support/v7/internal/widget/ActivityChooserView;->mAdapter:Landroid/support/v7/internal/widget/ActivityChooserView$ActivityChooserViewAdapter;

    add-int/lit8 v8, p1, -0x1

    invoke-virtual {v7, v8}, Landroid/support/v7/internal/widget/ActivityChooserView$ActivityChooserViewAdapter;->setMaxActivityCount(I)V

    .line 347
    :goto_2
    invoke-direct {p0}, Landroid/support/v7/internal/widget/ActivityChooserView;->getListPopupWindow()Landroid/support/v7/widget/ListPopupWindow;

    move-result-object v4

    .line 348
    .local v4, "popupWindow":Landroid/support/v7/widget/ListPopupWindow;
    invoke-virtual {v4}, Landroid/support/v7/widget/ListPopupWindow;->isShowing()Z

    move-result v7

    if-nez v7, :cond_3

    .line 349
    iget-boolean v7, p0, Landroid/support/v7/internal/widget/ActivityChooserView;->mIsSelectingDefaultActivity:Z

    if-nez v7, :cond_1

    if-nez v2, :cond_7

    .line 350
    :cond_1
    iget-object v6, p0, Landroid/support/v7/internal/widget/ActivityChooserView;->mAdapter:Landroid/support/v7/internal/widget/ActivityChooserView$ActivityChooserViewAdapter;

    invoke-virtual {v6, v5, v2}, Landroid/support/v7/internal/widget/ActivityChooserView$ActivityChooserViewAdapter;->setShowDefaultActivity(ZZ)V

    .line 354
    :goto_3
    iget-object v6, p0, Landroid/support/v7/internal/widget/ActivityChooserView;->mAdapter:Landroid/support/v7/internal/widget/ActivityChooserView$ActivityChooserViewAdapter;

    invoke-virtual {v6}, Landroid/support/v7/internal/widget/ActivityChooserView$ActivityChooserViewAdapter;->measureContentWidth()I

    move-result v6

    iget v7, p0, Landroid/support/v7/internal/widget/ActivityChooserView;->mListPopupMaxWidth:I

    invoke-static {v6, v7}, Ljava/lang/Math;->min(II)I

    move-result v1

    .line 355
    .local v1, "contentWidth":I
    invoke-virtual {v4, v1}, Landroid/support/v7/widget/ListPopupWindow;->setContentWidth(I)V

    .line 356
    invoke-virtual {v4}, Landroid/support/v7/widget/ListPopupWindow;->show()V

    .line 357
    iget-object v6, p0, Landroid/support/v7/internal/widget/ActivityChooserView;->mProvider:Landroid/support/v4/view/ActionProvider;

    if-eqz v6, :cond_2

    .line 358
    iget-object v6, p0, Landroid/support/v7/internal/widget/ActivityChooserView;->mProvider:Landroid/support/v4/view/ActionProvider;

    invoke-virtual {v6, v5}, Landroid/support/v4/view/ActionProvider;->subUiVisibilityChanged(Z)V

    .line 360
    :cond_2
    invoke-virtual {v4}, Landroid/support/v7/widget/ListPopupWindow;->getListView()Landroid/widget/ListView;

    move-result-object v5

    invoke-virtual {p0}, Landroid/support/v7/internal/widget/ActivityChooserView;->getContext()Landroid/content/Context;

    move-result-object v6

    sget v7, Landroid/support/v7/appcompat/R$string;->abc_activitychooserview_choose_application:I

    invoke-virtual {v6, v7}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Landroid/widget/ListView;->setContentDescription(Ljava/lang/CharSequence;)V

    .line 363
    .end local v1    # "contentWidth":I
    :cond_3
    return-void

    .end local v0    # "activityCount":I
    .end local v2    # "defaultActivityButtonShown":Z
    .end local v3    # "maxActivityCountOffset":I
    .end local v4    # "popupWindow":Landroid/support/v7/widget/ListPopupWindow;
    :cond_4
    move v2, v6

    .line 333
    goto :goto_0

    .restart local v0    # "activityCount":I
    .restart local v2    # "defaultActivityButtonShown":Z
    :cond_5
    move v3, v6

    .line 337
    goto :goto_1

    .line 343
    .restart local v3    # "maxActivityCountOffset":I
    :cond_6
    iget-object v7, p0, Landroid/support/v7/internal/widget/ActivityChooserView;->mAdapter:Landroid/support/v7/internal/widget/ActivityChooserView$ActivityChooserViewAdapter;

    invoke-virtual {v7, v6}, Landroid/support/v7/internal/widget/ActivityChooserView$ActivityChooserViewAdapter;->setShowFooterView(Z)V

    .line 344
    iget-object v7, p0, Landroid/support/v7/internal/widget/ActivityChooserView;->mAdapter:Landroid/support/v7/internal/widget/ActivityChooserView$ActivityChooserViewAdapter;

    invoke-virtual {v7, p1}, Landroid/support/v7/internal/widget/ActivityChooserView$ActivityChooserViewAdapter;->setMaxActivityCount(I)V

    goto :goto_2

    .line 352
    .restart local v4    # "popupWindow":Landroid/support/v7/widget/ListPopupWindow;
    :cond_7
    iget-object v7, p0, Landroid/support/v7/internal/widget/ActivityChooserView;->mAdapter:Landroid/support/v7/internal/widget/ActivityChooserView$ActivityChooserViewAdapter;

    invoke-virtual {v7, v6, v6}, Landroid/support/v7/internal/widget/ActivityChooserView$ActivityChooserViewAdapter;->setShowDefaultActivity(ZZ)V

    goto :goto_3
.end method

.method private updateAppearance()V
    .locals 10

    .prologue
    const/4 v9, 0x0

    const/4 v8, 0x1

    .line 500
    iget-object v6, p0, Landroid/support/v7/internal/widget/ActivityChooserView;->mAdapter:Landroid/support/v7/internal/widget/ActivityChooserView$ActivityChooserViewAdapter;

    invoke-virtual {v6}, Landroid/support/v7/internal/widget/ActivityChooserView$ActivityChooserViewAdapter;->getCount()I

    move-result v6

    if-lez v6, :cond_2

    .line 501
    iget-object v6, p0, Landroid/support/v7/internal/widget/ActivityChooserView;->mExpandActivityOverflowButton:Landroid/widget/FrameLayout;

    invoke-virtual {v6, v8}, Landroid/widget/FrameLayout;->setEnabled(Z)V

    .line 506
    :goto_0
    iget-object v6, p0, Landroid/support/v7/internal/widget/ActivityChooserView;->mAdapter:Landroid/support/v7/internal/widget/ActivityChooserView$ActivityChooserViewAdapter;

    invoke-virtual {v6}, Landroid/support/v7/internal/widget/ActivityChooserView$ActivityChooserViewAdapter;->getActivityCount()I

    move-result v1

    .line 507
    .local v1, "activityCount":I
    iget-object v6, p0, Landroid/support/v7/internal/widget/ActivityChooserView;->mAdapter:Landroid/support/v7/internal/widget/ActivityChooserView$ActivityChooserViewAdapter;

    invoke-virtual {v6}, Landroid/support/v7/internal/widget/ActivityChooserView$ActivityChooserViewAdapter;->getHistorySize()I

    move-result v3

    .line 508
    .local v3, "historySize":I
    if-eq v1, v8, :cond_0

    if-le v1, v8, :cond_3

    if-lez v3, :cond_3

    .line 509
    :cond_0
    iget-object v6, p0, Landroid/support/v7/internal/widget/ActivityChooserView;->mDefaultActivityButton:Landroid/widget/FrameLayout;

    invoke-virtual {v6, v9}, Landroid/widget/FrameLayout;->setVisibility(I)V

    .line 510
    iget-object v6, p0, Landroid/support/v7/internal/widget/ActivityChooserView;->mAdapter:Landroid/support/v7/internal/widget/ActivityChooserView$ActivityChooserViewAdapter;

    invoke-virtual {v6}, Landroid/support/v7/internal/widget/ActivityChooserView$ActivityChooserViewAdapter;->getDefaultActivity()Landroid/content/pm/ResolveInfo;

    move-result-object v0

    .line 511
    .local v0, "activity":Landroid/content/pm/ResolveInfo;
    invoke-virtual {p0}, Landroid/support/v7/internal/widget/ActivityChooserView;->getContext()Landroid/content/Context;

    move-result-object v6

    invoke-virtual {v6}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v5

    .line 512
    .local v5, "packageManager":Landroid/content/pm/PackageManager;
    iget-object v6, p0, Landroid/support/v7/internal/widget/ActivityChooserView;->mDefaultActivityButtonImage:Landroid/widget/ImageView;

    invoke-virtual {v0, v5}, Landroid/content/pm/ResolveInfo;->loadIcon(Landroid/content/pm/PackageManager;)Landroid/graphics/drawable/Drawable;

    move-result-object v7

    invoke-virtual {v6, v7}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 513
    iget v6, p0, Landroid/support/v7/internal/widget/ActivityChooserView;->mDefaultActionButtonContentDescription:I

    if-eqz v6, :cond_1

    .line 514
    invoke-virtual {v0, v5}, Landroid/content/pm/ResolveInfo;->loadLabel(Landroid/content/pm/PackageManager;)Ljava/lang/CharSequence;

    move-result-object v4

    .line 515
    .local v4, "label":Ljava/lang/CharSequence;
    invoke-virtual {p0}, Landroid/support/v7/internal/widget/ActivityChooserView;->getContext()Landroid/content/Context;

    move-result-object v6

    iget v7, p0, Landroid/support/v7/internal/widget/ActivityChooserView;->mDefaultActionButtonContentDescription:I

    new-array v8, v8, [Ljava/lang/Object;

    aput-object v4, v8, v9

    invoke-virtual {v6, v7, v8}, Landroid/content/Context;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    .line 517
    .local v2, "contentDescription":Ljava/lang/String;
    iget-object v6, p0, Landroid/support/v7/internal/widget/ActivityChooserView;->mDefaultActivityButton:Landroid/widget/FrameLayout;

    invoke-virtual {v6, v2}, Landroid/widget/FrameLayout;->setContentDescription(Ljava/lang/CharSequence;)V

    .line 523
    .end local v0    # "activity":Landroid/content/pm/ResolveInfo;
    .end local v2    # "contentDescription":Ljava/lang/String;
    .end local v4    # "label":Ljava/lang/CharSequence;
    .end local v5    # "packageManager":Landroid/content/pm/PackageManager;
    :cond_1
    :goto_1
    iget-object v6, p0, Landroid/support/v7/internal/widget/ActivityChooserView;->mDefaultActivityButton:Landroid/widget/FrameLayout;

    invoke-virtual {v6}, Landroid/widget/FrameLayout;->getVisibility()I

    move-result v6

    if-nez v6, :cond_4

    .line 524
    iget-object v6, p0, Landroid/support/v7/internal/widget/ActivityChooserView;->mActivityChooserContent:Landroid/support/v7/widget/LinearLayoutCompat;

    iget-object v7, p0, Landroid/support/v7/internal/widget/ActivityChooserView;->mActivityChooserContentBackground:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v6, v7}, Landroid/support/v7/widget/LinearLayoutCompat;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 528
    :goto_2
    return-void

    .line 503
    .end local v1    # "activityCount":I
    .end local v3    # "historySize":I
    :cond_2
    iget-object v6, p0, Landroid/support/v7/internal/widget/ActivityChooserView;->mExpandActivityOverflowButton:Landroid/widget/FrameLayout;

    invoke-virtual {v6, v9}, Landroid/widget/FrameLayout;->setEnabled(Z)V

    goto :goto_0

    .line 520
    .restart local v1    # "activityCount":I
    .restart local v3    # "historySize":I
    :cond_3
    iget-object v6, p0, Landroid/support/v7/internal/widget/ActivityChooserView;->mDefaultActivityButton:Landroid/widget/FrameLayout;

    const/16 v7, 0x8

    invoke-virtual {v6, v7}, Landroid/widget/FrameLayout;->setVisibility(I)V

    goto :goto_1

    .line 526
    :cond_4
    iget-object v6, p0, Landroid/support/v7/internal/widget/ActivityChooserView;->mActivityChooserContent:Landroid/support/v7/widget/LinearLayoutCompat;

    const/4 v7, 0x0

    invoke-virtual {v6, v7}, Landroid/support/v7/widget/LinearLayoutCompat;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    goto :goto_2
.end method


# virtual methods
.method public dismissPopup()Z
    .locals 2

    .prologue
    .line 371
    invoke-virtual {p0}, Landroid/support/v7/internal/widget/ActivityChooserView;->isShowingPopup()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 372
    invoke-direct {p0}, Landroid/support/v7/internal/widget/ActivityChooserView;->getListPopupWindow()Landroid/support/v7/widget/ListPopupWindow;

    move-result-object v1

    invoke-virtual {v1}, Landroid/support/v7/widget/ListPopupWindow;->dismiss()V

    .line 373
    invoke-virtual {p0}, Landroid/support/v7/internal/widget/ActivityChooserView;->getViewTreeObserver()Landroid/view/ViewTreeObserver;

    move-result-object v0

    .line 374
    .local v0, "viewTreeObserver":Landroid/view/ViewTreeObserver;
    invoke-virtual {v0}, Landroid/view/ViewTreeObserver;->isAlive()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 375
    iget-object v1, p0, Landroid/support/v7/internal/widget/ActivityChooserView;->mOnGlobalLayoutListener:Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;

    invoke-virtual {v0, v1}, Landroid/view/ViewTreeObserver;->removeGlobalOnLayoutListener(Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;)V

    .line 378
    .end local v0    # "viewTreeObserver":Landroid/view/ViewTreeObserver;
    :cond_0
    const/4 v1, 0x1

    return v1
.end method

.method public getDataModel()Landroid/support/v7/internal/widget/ActivityChooserModel;
    .locals 1

    .prologue
    .line 440
    iget-object v0, p0, Landroid/support/v7/internal/widget/ActivityChooserView;->mAdapter:Landroid/support/v7/internal/widget/ActivityChooserView$ActivityChooserViewAdapter;

    invoke-virtual {v0}, Landroid/support/v7/internal/widget/ActivityChooserView$ActivityChooserViewAdapter;->getDataModel()Landroid/support/v7/internal/widget/ActivityChooserModel;

    move-result-object v0

    return-object v0
.end method

.method public isShowingPopup()Z
    .locals 1

    .prologue
    .line 387
    invoke-direct {p0}, Landroid/support/v7/internal/widget/ActivityChooserView;->getListPopupWindow()Landroid/support/v7/widget/ListPopupWindow;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v7/widget/ListPopupWindow;->isShowing()Z

    move-result v0

    return v0
.end method

.method protected onAttachedToWindow()V
    .locals 2

    .prologue
    .line 392
    invoke-super {p0}, Landroid/view/ViewGroup;->onAttachedToWindow()V

    .line 393
    iget-object v1, p0, Landroid/support/v7/internal/widget/ActivityChooserView;->mAdapter:Landroid/support/v7/internal/widget/ActivityChooserView$ActivityChooserViewAdapter;

    invoke-virtual {v1}, Landroid/support/v7/internal/widget/ActivityChooserView$ActivityChooserViewAdapter;->getDataModel()Landroid/support/v7/internal/widget/ActivityChooserModel;

    move-result-object v0

    .line 394
    .local v0, "dataModel":Landroid/support/v7/internal/widget/ActivityChooserModel;
    if-eqz v0, :cond_0

    .line 395
    iget-object v1, p0, Landroid/support/v7/internal/widget/ActivityChooserView;->mModelDataSetOberver:Landroid/database/DataSetObserver;

    invoke-virtual {v0, v1}, Landroid/support/v7/internal/widget/ActivityChooserModel;->registerObserver(Ljava/lang/Object;)V

    .line 397
    :cond_0
    const/4 v1, 0x1

    iput-boolean v1, p0, Landroid/support/v7/internal/widget/ActivityChooserView;->mIsAttachedToWindow:Z

    .line 398
    return-void
.end method

.method protected onDetachedFromWindow()V
    .locals 3

    .prologue
    .line 402
    invoke-super {p0}, Landroid/view/ViewGroup;->onDetachedFromWindow()V

    .line 403
    iget-object v2, p0, Landroid/support/v7/internal/widget/ActivityChooserView;->mAdapter:Landroid/support/v7/internal/widget/ActivityChooserView$ActivityChooserViewAdapter;

    invoke-virtual {v2}, Landroid/support/v7/internal/widget/ActivityChooserView$ActivityChooserViewAdapter;->getDataModel()Landroid/support/v7/internal/widget/ActivityChooserModel;

    move-result-object v0

    .line 404
    .local v0, "dataModel":Landroid/support/v7/internal/widget/ActivityChooserModel;
    if-eqz v0, :cond_0

    .line 405
    iget-object v2, p0, Landroid/support/v7/internal/widget/ActivityChooserView;->mModelDataSetOberver:Landroid/database/DataSetObserver;

    invoke-virtual {v0, v2}, Landroid/support/v7/internal/widget/ActivityChooserModel;->unregisterObserver(Ljava/lang/Object;)V

    .line 407
    :cond_0
    invoke-virtual {p0}, Landroid/support/v7/internal/widget/ActivityChooserView;->getViewTreeObserver()Landroid/view/ViewTreeObserver;

    move-result-object v1

    .line 408
    .local v1, "viewTreeObserver":Landroid/view/ViewTreeObserver;
    invoke-virtual {v1}, Landroid/view/ViewTreeObserver;->isAlive()Z

    move-result v2

    if-eqz v2, :cond_1

    .line 409
    iget-object v2, p0, Landroid/support/v7/internal/widget/ActivityChooserView;->mOnGlobalLayoutListener:Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;

    invoke-virtual {v1, v2}, Landroid/view/ViewTreeObserver;->removeGlobalOnLayoutListener(Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;)V

    .line 411
    :cond_1
    invoke-virtual {p0}, Landroid/support/v7/internal/widget/ActivityChooserView;->isShowingPopup()Z

    move-result v2

    if-eqz v2, :cond_2

    .line 412
    invoke-virtual {p0}, Landroid/support/v7/internal/widget/ActivityChooserView;->dismissPopup()Z

    .line 414
    :cond_2
    const/4 v2, 0x0

    iput-boolean v2, p0, Landroid/support/v7/internal/widget/ActivityChooserView;->mIsAttachedToWindow:Z

    .line 415
    return-void
.end method

.method protected onLayout(ZIIII)V
    .locals 4
    .param p1, "changed"    # Z
    .param p2, "left"    # I
    .param p3, "top"    # I
    .param p4, "right"    # I
    .param p5, "bottom"    # I

    .prologue
    const/4 v3, 0x0

    .line 433
    iget-object v0, p0, Landroid/support/v7/internal/widget/ActivityChooserView;->mActivityChooserContent:Landroid/support/v7/widget/LinearLayoutCompat;

    sub-int v1, p4, p2

    sub-int v2, p5, p3

    invoke-virtual {v0, v3, v3, v1, v2}, Landroid/support/v7/widget/LinearLayoutCompat;->layout(IIII)V

    .line 434
    invoke-virtual {p0}, Landroid/support/v7/internal/widget/ActivityChooserView;->isShowingPopup()Z

    move-result v0

    if-nez v0, :cond_0

    .line 435
    invoke-virtual {p0}, Landroid/support/v7/internal/widget/ActivityChooserView;->dismissPopup()Z

    .line 437
    :cond_0
    return-void
.end method

.method protected onMeasure(II)V
    .locals 3
    .param p1, "widthMeasureSpec"    # I
    .param p2, "heightMeasureSpec"    # I

    .prologue
    .line 419
    iget-object v0, p0, Landroid/support/v7/internal/widget/ActivityChooserView;->mActivityChooserContent:Landroid/support/v7/widget/LinearLayoutCompat;

    .line 423
    .local v0, "child":Landroid/view/View;
    iget-object v1, p0, Landroid/support/v7/internal/widget/ActivityChooserView;->mDefaultActivityButton:Landroid/widget/FrameLayout;

    invoke-virtual {v1}, Landroid/widget/FrameLayout;->getVisibility()I

    move-result v1

    if-eqz v1, :cond_0

    .line 424
    invoke-static {p2}, Landroid/view/View$MeasureSpec;->getSize(I)I

    move-result v1

    const/high16 v2, 0x40000000    # 2.0f

    invoke-static {v1, v2}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result p2

    .line 427
    :cond_0
    invoke-virtual {p0, v0, p1, p2}, Landroid/support/v7/internal/widget/ActivityChooserView;->measureChild(Landroid/view/View;II)V

    .line 428
    invoke-virtual {v0}, Landroid/view/View;->getMeasuredWidth()I

    move-result v1

    invoke-virtual {v0}, Landroid/view/View;->getMeasuredHeight()I

    move-result v2

    invoke-virtual {p0, v1, v2}, Landroid/support/v7/internal/widget/ActivityChooserView;->setMeasuredDimension(II)V

    .line 429
    return-void
.end method

.method public setActivityChooserModel(Landroid/support/v7/internal/widget/ActivityChooserModel;)V
    .locals 1
    .param p1, "dataModel"    # Landroid/support/v7/internal/widget/ActivityChooserModel;

    .prologue
    .line 262
    iget-object v0, p0, Landroid/support/v7/internal/widget/ActivityChooserView;->mAdapter:Landroid/support/v7/internal/widget/ActivityChooserView$ActivityChooserViewAdapter;

    invoke-virtual {v0, p1}, Landroid/support/v7/internal/widget/ActivityChooserView$ActivityChooserViewAdapter;->setDataModel(Landroid/support/v7/internal/widget/ActivityChooserModel;)V

    .line 263
    invoke-virtual {p0}, Landroid/support/v7/internal/widget/ActivityChooserView;->isShowingPopup()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 264
    invoke-virtual {p0}, Landroid/support/v7/internal/widget/ActivityChooserView;->dismissPopup()Z

    .line 265
    invoke-virtual {p0}, Landroid/support/v7/internal/widget/ActivityChooserView;->showPopup()Z

    .line 267
    :cond_0
    return-void
.end method

.method public setDefaultActionButtonContentDescription(I)V
    .locals 0
    .param p1, "resourceId"    # I

    .prologue
    .line 475
    iput p1, p0, Landroid/support/v7/internal/widget/ActivityChooserView;->mDefaultActionButtonContentDescription:I

    .line 476
    return-void
.end method

.method public setExpandActivityOverflowButtonContentDescription(I)V
    .locals 2
    .param p1, "resourceId"    # I

    .prologue
    .line 295
    invoke-virtual {p0}, Landroid/support/v7/internal/widget/ActivityChooserView;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v1, p1}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 296
    .local v0, "contentDescription":Ljava/lang/CharSequence;
    iget-object v1, p0, Landroid/support/v7/internal/widget/ActivityChooserView;->mExpandActivityOverflowButtonImage:Landroid/widget/ImageView;

    invoke-virtual {v1, v0}, Landroid/widget/ImageView;->setContentDescription(Ljava/lang/CharSequence;)V

    .line 297
    return-void
.end method

.method public setExpandActivityOverflowButtonDrawable(Landroid/graphics/drawable/Drawable;)V
    .locals 1
    .param p1, "drawable"    # Landroid/graphics/drawable/Drawable;

    .prologue
    .line 281
    iget-object v0, p0, Landroid/support/v7/internal/widget/ActivityChooserView;->mExpandActivityOverflowButtonImage:Landroid/widget/ImageView;

    invoke-virtual {v0, p1}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 282
    return-void
.end method

.method public setInitialActivityCount(I)V
    .locals 0
    .param p1, "itemCount"    # I

    .prologue
    .line 461
    iput p1, p0, Landroid/support/v7/internal/widget/ActivityChooserView;->mInitialActivityCount:I

    .line 462
    return-void
.end method

.method public setOnDismissListener(Landroid/widget/PopupWindow$OnDismissListener;)V
    .locals 0
    .param p1, "listener"    # Landroid/widget/PopupWindow$OnDismissListener;

    .prologue
    .line 449
    iput-object p1, p0, Landroid/support/v7/internal/widget/ActivityChooserView;->mOnDismissListener:Landroid/widget/PopupWindow$OnDismissListener;

    .line 450
    return-void
.end method

.method public setProvider(Landroid/support/v4/view/ActionProvider;)V
    .locals 0
    .param p1, "provider"    # Landroid/support/v4/view/ActionProvider;

    .prologue
    .line 304
    iput-object p1, p0, Landroid/support/v7/internal/widget/ActivityChooserView;->mProvider:Landroid/support/v4/view/ActionProvider;

    .line 305
    return-void
.end method

.method public showPopup()Z
    .locals 2

    .prologue
    const/4 v0, 0x0

    .line 313
    invoke-virtual {p0}, Landroid/support/v7/internal/widget/ActivityChooserView;->isShowingPopup()Z

    move-result v1

    if-nez v1, :cond_0

    iget-boolean v1, p0, Landroid/support/v7/internal/widget/ActivityChooserView;->mIsAttachedToWindow:Z

    if-nez v1, :cond_1

    .line 318
    :cond_0
    :goto_0
    return v0

    .line 316
    :cond_1
    iput-boolean v0, p0, Landroid/support/v7/internal/widget/ActivityChooserView;->mIsSelectingDefaultActivity:Z

    .line 317
    iget v0, p0, Landroid/support/v7/internal/widget/ActivityChooserView;->mInitialActivityCount:I

    invoke-direct {p0, v0}, Landroid/support/v7/internal/widget/ActivityChooserView;->showPopupUnchecked(I)V

    .line 318
    const/4 v0, 0x1

    goto :goto_0
.end method
