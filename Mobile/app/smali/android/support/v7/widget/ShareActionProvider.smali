.class public Landroid/support/v7/widget/ShareActionProvider;
.super Landroid/support/v4/view/ActionProvider;
.source "ShareActionProvider.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/support/v7/widget/ShareActionProvider$1;,
        Landroid/support/v7/widget/ShareActionProvider$ShareActivityChooserModelPolicy;,
        Landroid/support/v7/widget/ShareActionProvider$ShareMenuItemOnMenuItemClickListener;,
        Landroid/support/v7/widget/ShareActionProvider$OnShareTargetSelectedListener;
    }
.end annotation


# static fields
.field private static final DEFAULT_INITIAL_ACTIVITY_COUNT:I = 0x4

.field public static final DEFAULT_SHARE_HISTORY_FILE_NAME:Ljava/lang/String; = "share_history.xml"


# instance fields
.field private final mContext:Landroid/content/Context;

.field private mMaxShownActivityCount:I

.field private mOnChooseActivityListener:Landroid/support/v7/internal/widget/ActivityChooserModel$OnChooseActivityListener;

.field private final mOnMenuItemClickListener:Landroid/support/v7/widget/ShareActionProvider$ShareMenuItemOnMenuItemClickListener;

.field private mOnShareTargetSelectedListener:Landroid/support/v7/widget/ShareActionProvider$OnShareTargetSelectedListener;

.field private mShareHistoryFileName:Ljava/lang/String;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 157
    invoke-direct {p0, p1}, Landroid/support/v4/view/ActionProvider;-><init>(Landroid/content/Context;)V

    .line 124
    const/4 v0, 0x4

    iput v0, p0, Landroid/support/v7/widget/ShareActionProvider;->mMaxShownActivityCount:I

    .line 129
    new-instance v0, Landroid/support/v7/widget/ShareActionProvider$ShareMenuItemOnMenuItemClickListener;

    const/4 v1, 0x0

    invoke-direct {v0, p0, v1}, Landroid/support/v7/widget/ShareActionProvider$ShareMenuItemOnMenuItemClickListener;-><init>(Landroid/support/v7/widget/ShareActionProvider;Landroid/support/v7/widget/ShareActionProvider$1;)V

    iput-object v0, p0, Landroid/support/v7/widget/ShareActionProvider;->mOnMenuItemClickListener:Landroid/support/v7/widget/ShareActionProvider$ShareMenuItemOnMenuItemClickListener;

    .line 145
    const-string v0, "share_history.xml"

    iput-object v0, p0, Landroid/support/v7/widget/ShareActionProvider;->mShareHistoryFileName:Ljava/lang/String;

    .line 158
    iput-object p1, p0, Landroid/support/v7/widget/ShareActionProvider;->mContext:Landroid/content/Context;

    .line 159
    return-void
.end method

.method static synthetic access$100(Landroid/support/v7/widget/ShareActionProvider;)Landroid/content/Context;
    .locals 1
    .param p0, "x0"    # Landroid/support/v7/widget/ShareActionProvider;

    .prologue
    .line 87
    iget-object v0, p0, Landroid/support/v7/widget/ShareActionProvider;->mContext:Landroid/content/Context;

    return-object v0
.end method

.method static synthetic access$200(Landroid/support/v7/widget/ShareActionProvider;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Landroid/support/v7/widget/ShareActionProvider;

    .prologue
    .line 87
    iget-object v0, p0, Landroid/support/v7/widget/ShareActionProvider;->mShareHistoryFileName:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$400(Landroid/support/v7/widget/ShareActionProvider;)Landroid/support/v7/widget/ShareActionProvider$OnShareTargetSelectedListener;
    .locals 1
    .param p0, "x0"    # Landroid/support/v7/widget/ShareActionProvider;

    .prologue
    .line 87
    iget-object v0, p0, Landroid/support/v7/widget/ShareActionProvider;->mOnShareTargetSelectedListener:Landroid/support/v7/widget/ShareActionProvider$OnShareTargetSelectedListener;

    return-object v0
.end method

.method private setActivityChooserPolicyIfNeeded()V
    .locals 3

    .prologue
    .line 330
    iget-object v1, p0, Landroid/support/v7/widget/ShareActionProvider;->mOnShareTargetSelectedListener:Landroid/support/v7/widget/ShareActionProvider$OnShareTargetSelectedListener;

    if-nez v1, :cond_0

    .line 338
    :goto_0
    return-void

    .line 333
    :cond_0
    iget-object v1, p0, Landroid/support/v7/widget/ShareActionProvider;->mOnChooseActivityListener:Landroid/support/v7/internal/widget/ActivityChooserModel$OnChooseActivityListener;

    if-nez v1, :cond_1

    .line 334
    new-instance v1, Landroid/support/v7/widget/ShareActionProvider$ShareActivityChooserModelPolicy;

    const/4 v2, 0x0

    invoke-direct {v1, p0, v2}, Landroid/support/v7/widget/ShareActionProvider$ShareActivityChooserModelPolicy;-><init>(Landroid/support/v7/widget/ShareActionProvider;Landroid/support/v7/widget/ShareActionProvider$1;)V

    iput-object v1, p0, Landroid/support/v7/widget/ShareActionProvider;->mOnChooseActivityListener:Landroid/support/v7/internal/widget/ActivityChooserModel$OnChooseActivityListener;

    .line 336
    :cond_1
    iget-object v1, p0, Landroid/support/v7/widget/ShareActionProvider;->mContext:Landroid/content/Context;

    iget-object v2, p0, Landroid/support/v7/widget/ShareActionProvider;->mShareHistoryFileName:Ljava/lang/String;

    invoke-static {v1, v2}, Landroid/support/v7/internal/widget/ActivityChooserModel;->get(Landroid/content/Context;Ljava/lang/String;)Landroid/support/v7/internal/widget/ActivityChooserModel;

    move-result-object v0

    .line 337
    .local v0, "dataModel":Landroid/support/v7/internal/widget/ActivityChooserModel;
    iget-object v1, p0, Landroid/support/v7/widget/ShareActionProvider;->mOnChooseActivityListener:Landroid/support/v7/internal/widget/ActivityChooserModel$OnChooseActivityListener;

    invoke-virtual {v0, v1}, Landroid/support/v7/internal/widget/ActivityChooserModel;->setOnChooseActivityListener(Landroid/support/v7/internal/widget/ActivityChooserModel$OnChooseActivityListener;)V

    goto :goto_0
.end method


# virtual methods
.method public hasSubMenu()Z
    .locals 1

    .prologue
    .line 207
    const/4 v0, 0x1

    return v0
.end method

.method public onCreateActionView()Landroid/view/View;
    .locals 7

    .prologue
    .line 182
    iget-object v4, p0, Landroid/support/v7/widget/ShareActionProvider;->mContext:Landroid/content/Context;

    iget-object v5, p0, Landroid/support/v7/widget/ShareActionProvider;->mShareHistoryFileName:Ljava/lang/String;

    invoke-static {v4, v5}, Landroid/support/v7/internal/widget/ActivityChooserModel;->get(Landroid/content/Context;Ljava/lang/String;)Landroid/support/v7/internal/widget/ActivityChooserModel;

    move-result-object v1

    .line 183
    .local v1, "dataModel":Landroid/support/v7/internal/widget/ActivityChooserModel;
    new-instance v0, Landroid/support/v7/internal/widget/ActivityChooserView;

    iget-object v4, p0, Landroid/support/v7/widget/ShareActionProvider;->mContext:Landroid/content/Context;

    invoke-direct {v0, v4}, Landroid/support/v7/internal/widget/ActivityChooserView;-><init>(Landroid/content/Context;)V

    .line 184
    .local v0, "activityChooserView":Landroid/support/v7/internal/widget/ActivityChooserView;
    invoke-virtual {v0, v1}, Landroid/support/v7/internal/widget/ActivityChooserView;->setActivityChooserModel(Landroid/support/v7/internal/widget/ActivityChooserModel;)V

    .line 187
    new-instance v3, Landroid/util/TypedValue;

    invoke-direct {v3}, Landroid/util/TypedValue;-><init>()V

    .line 188
    .local v3, "outTypedValue":Landroid/util/TypedValue;
    iget-object v4, p0, Landroid/support/v7/widget/ShareActionProvider;->mContext:Landroid/content/Context;

    invoke-virtual {v4}, Landroid/content/Context;->getTheme()Landroid/content/res/Resources$Theme;

    move-result-object v4

    sget v5, Landroid/support/v7/appcompat/R$attr;->actionModeShareDrawable:I

    const/4 v6, 0x1

    invoke-virtual {v4, v5, v3, v6}, Landroid/content/res/Resources$Theme;->resolveAttribute(ILandroid/util/TypedValue;Z)Z

    .line 189
    iget-object v4, p0, Landroid/support/v7/widget/ShareActionProvider;->mContext:Landroid/content/Context;

    iget v5, v3, Landroid/util/TypedValue;->resourceId:I

    invoke-static {v4, v5}, Landroid/support/v7/internal/widget/TintManager;->getDrawable(Landroid/content/Context;I)Landroid/graphics/drawable/Drawable;

    move-result-object v2

    .line 190
    .local v2, "drawable":Landroid/graphics/drawable/Drawable;
    invoke-virtual {v0, v2}, Landroid/support/v7/internal/widget/ActivityChooserView;->setExpandActivityOverflowButtonDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 191
    invoke-virtual {v0, p0}, Landroid/support/v7/internal/widget/ActivityChooserView;->setProvider(Landroid/support/v4/view/ActionProvider;)V

    .line 194
    sget v4, Landroid/support/v7/appcompat/R$string;->abc_shareactionprovider_share_with_application:I

    invoke-virtual {v0, v4}, Landroid/support/v7/internal/widget/ActivityChooserView;->setDefaultActionButtonContentDescription(I)V

    .line 196
    sget v4, Landroid/support/v7/appcompat/R$string;->abc_shareactionprovider_share_with:I

    invoke-virtual {v0, v4}, Landroid/support/v7/internal/widget/ActivityChooserView;->setExpandActivityOverflowButtonContentDescription(I)V

    .line 199
    return-object v0
.end method

.method public onPrepareSubMenu(Landroid/view/SubMenu;)V
    .locals 10
    .param p1, "subMenu"    # Landroid/view/SubMenu;

    .prologue
    const/4 v9, 0x0

    .line 216
    invoke-interface {p1}, Landroid/view/SubMenu;->clear()V

    .line 218
    iget-object v7, p0, Landroid/support/v7/widget/ShareActionProvider;->mContext:Landroid/content/Context;

    iget-object v8, p0, Landroid/support/v7/widget/ShareActionProvider;->mShareHistoryFileName:Ljava/lang/String;

    invoke-static {v7, v8}, Landroid/support/v7/internal/widget/ActivityChooserModel;->get(Landroid/content/Context;Ljava/lang/String;)Landroid/support/v7/internal/widget/ActivityChooserModel;

    move-result-object v2

    .line 219
    .local v2, "dataModel":Landroid/support/v7/internal/widget/ActivityChooserModel;
    iget-object v7, p0, Landroid/support/v7/widget/ShareActionProvider;->mContext:Landroid/content/Context;

    invoke-virtual {v7}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v6

    .line 221
    .local v6, "packageManager":Landroid/content/pm/PackageManager;
    invoke-virtual {v2}, Landroid/support/v7/internal/widget/ActivityChooserModel;->getActivityCount()I

    move-result v3

    .line 222
    .local v3, "expandedActivityCount":I
    iget v7, p0, Landroid/support/v7/widget/ShareActionProvider;->mMaxShownActivityCount:I

    invoke-static {v3, v7}, Ljava/lang/Math;->min(II)I

    move-result v1

    .line 225
    .local v1, "collapsedActivityCount":I
    const/4 v5, 0x0

    .local v5, "i":I
    :goto_0
    if-ge v5, v1, :cond_0

    .line 226
    invoke-virtual {v2, v5}, Landroid/support/v7/internal/widget/ActivityChooserModel;->getActivity(I)Landroid/content/pm/ResolveInfo;

    move-result-object v0

    .line 227
    .local v0, "activity":Landroid/content/pm/ResolveInfo;
    invoke-virtual {v0, v6}, Landroid/content/pm/ResolveInfo;->loadLabel(Landroid/content/pm/PackageManager;)Ljava/lang/CharSequence;

    move-result-object v7

    invoke-interface {p1, v9, v5, v5, v7}, Landroid/view/SubMenu;->add(IIILjava/lang/CharSequence;)Landroid/view/MenuItem;

    move-result-object v7

    invoke-virtual {v0, v6}, Landroid/content/pm/ResolveInfo;->loadIcon(Landroid/content/pm/PackageManager;)Landroid/graphics/drawable/Drawable;

    move-result-object v8

    invoke-interface {v7, v8}, Landroid/view/MenuItem;->setIcon(Landroid/graphics/drawable/Drawable;)Landroid/view/MenuItem;

    move-result-object v7

    iget-object v8, p0, Landroid/support/v7/widget/ShareActionProvider;->mOnMenuItemClickListener:Landroid/support/v7/widget/ShareActionProvider$ShareMenuItemOnMenuItemClickListener;

    invoke-interface {v7, v8}, Landroid/view/MenuItem;->setOnMenuItemClickListener(Landroid/view/MenuItem$OnMenuItemClickListener;)Landroid/view/MenuItem;

    .line 225
    add-int/lit8 v5, v5, 0x1

    goto :goto_0

    .line 232
    .end local v0    # "activity":Landroid/content/pm/ResolveInfo;
    :cond_0
    if-ge v1, v3, :cond_1

    .line 234
    iget-object v7, p0, Landroid/support/v7/widget/ShareActionProvider;->mContext:Landroid/content/Context;

    sget v8, Landroid/support/v7/appcompat/R$string;->abc_activity_chooser_view_see_all:I

    invoke-virtual {v7, v8}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v7

    invoke-interface {p1, v9, v1, v1, v7}, Landroid/view/SubMenu;->addSubMenu(IIILjava/lang/CharSequence;)Landroid/view/SubMenu;

    move-result-object v4

    .line 237
    .local v4, "expandedSubMenu":Landroid/view/SubMenu;
    const/4 v5, 0x0

    :goto_1
    if-ge v5, v3, :cond_1

    .line 238
    invoke-virtual {v2, v5}, Landroid/support/v7/internal/widget/ActivityChooserModel;->getActivity(I)Landroid/content/pm/ResolveInfo;

    move-result-object v0

    .line 239
    .restart local v0    # "activity":Landroid/content/pm/ResolveInfo;
    invoke-virtual {v0, v6}, Landroid/content/pm/ResolveInfo;->loadLabel(Landroid/content/pm/PackageManager;)Ljava/lang/CharSequence;

    move-result-object v7

    invoke-interface {v4, v9, v5, v5, v7}, Landroid/view/SubMenu;->add(IIILjava/lang/CharSequence;)Landroid/view/MenuItem;

    move-result-object v7

    invoke-virtual {v0, v6}, Landroid/content/pm/ResolveInfo;->loadIcon(Landroid/content/pm/PackageManager;)Landroid/graphics/drawable/Drawable;

    move-result-object v8

    invoke-interface {v7, v8}, Landroid/view/MenuItem;->setIcon(Landroid/graphics/drawable/Drawable;)Landroid/view/MenuItem;

    move-result-object v7

    iget-object v8, p0, Landroid/support/v7/widget/ShareActionProvider;->mOnMenuItemClickListener:Landroid/support/v7/widget/ShareActionProvider$ShareMenuItemOnMenuItemClickListener;

    invoke-interface {v7, v8}, Landroid/view/MenuItem;->setOnMenuItemClickListener(Landroid/view/MenuItem$OnMenuItemClickListener;)Landroid/view/MenuItem;

    .line 237
    add-int/lit8 v5, v5, 0x1

    goto :goto_1

    .line 244
    .end local v0    # "activity":Landroid/content/pm/ResolveInfo;
    .end local v4    # "expandedSubMenu":Landroid/view/SubMenu;
    :cond_1
    return-void
.end method

.method public setOnShareTargetSelectedListener(Landroid/support/v7/widget/ShareActionProvider$OnShareTargetSelectedListener;)V
    .locals 0
    .param p1, "listener"    # Landroid/support/v7/widget/ShareActionProvider$OnShareTargetSelectedListener;

    .prologue
    .line 172
    iput-object p1, p0, Landroid/support/v7/widget/ShareActionProvider;->mOnShareTargetSelectedListener:Landroid/support/v7/widget/ShareActionProvider$OnShareTargetSelectedListener;

    .line 173
    invoke-direct {p0}, Landroid/support/v7/widget/ShareActionProvider;->setActivityChooserPolicyIfNeeded()V

    .line 174
    return-void
.end method

.method public setShareHistoryFileName(Ljava/lang/String;)V
    .locals 0
    .param p1, "shareHistoryFile"    # Ljava/lang/String;

    .prologue
    .line 278
    iput-object p1, p0, Landroid/support/v7/widget/ShareActionProvider;->mShareHistoryFileName:Ljava/lang/String;

    .line 279
    invoke-direct {p0}, Landroid/support/v7/widget/ShareActionProvider;->setActivityChooserPolicyIfNeeded()V

    .line 280
    return-void
.end method

.method public setShareIntent(Landroid/content/Intent;)V
    .locals 3
    .param p1, "shareIntent"    # Landroid/content/Intent;

    .prologue
    .line 302
    iget-object v1, p0, Landroid/support/v7/widget/ShareActionProvider;->mContext:Landroid/content/Context;

    iget-object v2, p0, Landroid/support/v7/widget/ShareActionProvider;->mShareHistoryFileName:Ljava/lang/String;

    invoke-static {v1, v2}, Landroid/support/v7/internal/widget/ActivityChooserModel;->get(Landroid/content/Context;Ljava/lang/String;)Landroid/support/v7/internal/widget/ActivityChooserModel;

    move-result-object v0

    .line 304
    .local v0, "dataModel":Landroid/support/v7/internal/widget/ActivityChooserModel;
    invoke-virtual {v0, p1}, Landroid/support/v7/internal/widget/ActivityChooserModel;->setIntent(Landroid/content/Intent;)V

    .line 305
    return-void
.end method
