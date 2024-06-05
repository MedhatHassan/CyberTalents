.class public Landroid/support/v7/internal/widget/TintManager;
.super Ljava/lang/Object;
.source "TintManager.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/support/v7/internal/widget/TintManager$ColorFilterLruCache;
    }
.end annotation


# static fields
.field private static final COLOR_FILTER_CACHE:Landroid/support/v7/internal/widget/TintManager$ColorFilterLruCache;

.field private static final CONTAINERS_WITH_TINT_CHILDREN:[I

.field private static final DEBUG:Z

.field static final DEFAULT_MODE:Landroid/graphics/PorterDuff$Mode;

.field private static final TAG:Ljava/lang/String;

.field private static final TINT_COLOR_BACKGROUND_MULTIPLY:[I

.field private static final TINT_COLOR_CONTROL_ACTIVATED:[I

.field private static final TINT_COLOR_CONTROL_NORMAL:[I

.field private static final TINT_COLOR_CONTROL_STATE_LIST:[I


# instance fields
.field private final mContext:Landroid/content/Context;

.field private mDefaultColorStateList:Landroid/content/res/ColorStateList;

.field private final mResources:Landroid/content/res/Resources;

.field private mSwitchThumbStateList:Landroid/content/res/ColorStateList;

.field private mSwitchTrackStateList:Landroid/content/res/ColorStateList;

.field private final mTypedValue:Landroid/util/TypedValue;


# direct methods
.method static constructor <clinit>()V
    .locals 8

    .prologue
    const/4 v7, 0x6

    const/4 v6, 0x3

    const/4 v5, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 37
    const-class v0, Landroid/support/v7/internal/widget/TintManager;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Landroid/support/v7/internal/widget/TintManager;->TAG:Ljava/lang/String;

    .line 40
    sget-object v0, Landroid/graphics/PorterDuff$Mode;->SRC_IN:Landroid/graphics/PorterDuff$Mode;

    sput-object v0, Landroid/support/v7/internal/widget/TintManager;->DEFAULT_MODE:Landroid/graphics/PorterDuff$Mode;

    .line 42
    new-instance v0, Landroid/support/v7/internal/widget/TintManager$ColorFilterLruCache;

    invoke-direct {v0, v7}, Landroid/support/v7/internal/widget/TintManager$ColorFilterLruCache;-><init>(I)V

    sput-object v0, Landroid/support/v7/internal/widget/TintManager;->COLOR_FILTER_CACHE:Landroid/support/v7/internal/widget/TintManager$ColorFilterLruCache;

    .line 48
    const/16 v0, 0xe

    new-array v0, v0, [I

    sget v1, Landroid/support/v7/appcompat/R$drawable;->abc_ic_ab_back_mtrl_am_alpha:I

    aput v1, v0, v3

    sget v1, Landroid/support/v7/appcompat/R$drawable;->abc_ic_go_search_api_mtrl_alpha:I

    aput v1, v0, v4

    sget v1, Landroid/support/v7/appcompat/R$drawable;->abc_ic_search_api_mtrl_alpha:I

    aput v1, v0, v5

    sget v1, Landroid/support/v7/appcompat/R$drawable;->abc_ic_commit_search_api_mtrl_alpha:I

    aput v1, v0, v6

    const/4 v1, 0x4

    sget v2, Landroid/support/v7/appcompat/R$drawable;->abc_ic_clear_mtrl_alpha:I

    aput v2, v0, v1

    const/4 v1, 0x5

    sget v2, Landroid/support/v7/appcompat/R$drawable;->abc_ic_menu_share_mtrl_alpha:I

    aput v2, v0, v1

    sget v1, Landroid/support/v7/appcompat/R$drawable;->abc_ic_menu_copy_mtrl_am_alpha:I

    aput v1, v0, v7

    const/4 v1, 0x7

    sget v2, Landroid/support/v7/appcompat/R$drawable;->abc_ic_menu_cut_mtrl_alpha:I

    aput v2, v0, v1

    const/16 v1, 0x8

    sget v2, Landroid/support/v7/appcompat/R$drawable;->abc_ic_menu_selectall_mtrl_alpha:I

    aput v2, v0, v1

    const/16 v1, 0x9

    sget v2, Landroid/support/v7/appcompat/R$drawable;->abc_ic_menu_paste_mtrl_am_alpha:I

    aput v2, v0, v1

    const/16 v1, 0xa

    sget v2, Landroid/support/v7/appcompat/R$drawable;->abc_ic_menu_moreoverflow_mtrl_alpha:I

    aput v2, v0, v1

    const/16 v1, 0xb

    sget v2, Landroid/support/v7/appcompat/R$drawable;->abc_ic_voice_search_api_mtrl_alpha:I

    aput v2, v0, v1

    const/16 v1, 0xc

    sget v2, Landroid/support/v7/appcompat/R$drawable;->abc_textfield_search_default_mtrl_alpha:I

    aput v2, v0, v1

    const/16 v1, 0xd

    sget v2, Landroid/support/v7/appcompat/R$drawable;->abc_textfield_default_mtrl_alpha:I

    aput v2, v0, v1

    sput-object v0, Landroid/support/v7/internal/widget/TintManager;->TINT_COLOR_CONTROL_NORMAL:[I

    .line 69
    new-array v0, v6, [I

    sget v1, Landroid/support/v7/appcompat/R$drawable;->abc_textfield_activated_mtrl_alpha:I

    aput v1, v0, v3

    sget v1, Landroid/support/v7/appcompat/R$drawable;->abc_textfield_search_activated_mtrl_alpha:I

    aput v1, v0, v4

    sget v1, Landroid/support/v7/appcompat/R$drawable;->abc_cab_background_top_mtrl_alpha:I

    aput v1, v0, v5

    sput-object v0, Landroid/support/v7/internal/widget/TintManager;->TINT_COLOR_CONTROL_ACTIVATED:[I

    .line 79
    new-array v0, v6, [I

    sget v1, Landroid/support/v7/appcompat/R$drawable;->abc_popup_background_mtrl_mult:I

    aput v1, v0, v3

    sget v1, Landroid/support/v7/appcompat/R$drawable;->abc_cab_background_internal_bg:I

    aput v1, v0, v4

    sget v1, Landroid/support/v7/appcompat/R$drawable;->abc_menu_hardkey_panel_mtrl_mult:I

    aput v1, v0, v5

    sput-object v0, Landroid/support/v7/internal/widget/TintManager;->TINT_COLOR_BACKGROUND_MULTIPLY:[I

    .line 89
    new-array v0, v7, [I

    sget v1, Landroid/support/v7/appcompat/R$drawable;->abc_edit_text_material:I

    aput v1, v0, v3

    sget v1, Landroid/support/v7/appcompat/R$drawable;->abc_tab_indicator_material:I

    aput v1, v0, v4

    sget v1, Landroid/support/v7/appcompat/R$drawable;->abc_textfield_search_material:I

    aput v1, v0, v5

    sget v1, Landroid/support/v7/appcompat/R$drawable;->abc_spinner_mtrl_am_alpha:I

    aput v1, v0, v6

    const/4 v1, 0x4

    sget v2, Landroid/support/v7/appcompat/R$drawable;->abc_btn_check_material:I

    aput v2, v0, v1

    const/4 v1, 0x5

    sget v2, Landroid/support/v7/appcompat/R$drawable;->abc_btn_radio_material:I

    aput v2, v0, v1

    sput-object v0, Landroid/support/v7/internal/widget/TintManager;->TINT_COLOR_CONTROL_STATE_LIST:[I

    .line 102
    new-array v0, v4, [I

    sget v1, Landroid/support/v7/appcompat/R$drawable;->abc_cab_background_top_material:I

    aput v1, v0, v3

    sput-object v0, Landroid/support/v7/internal/widget/TintManager;->CONTAINERS_WITH_TINT_CHILDREN:[I

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 126
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 127
    iput-object p1, p0, Landroid/support/v7/internal/widget/TintManager;->mContext:Landroid/content/Context;

    .line 128
    new-instance v0, Landroid/support/v7/internal/widget/TintResources;

    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-direct {v0, v1, p0}, Landroid/support/v7/internal/widget/TintResources;-><init>(Landroid/content/res/Resources;Landroid/support/v7/internal/widget/TintManager;)V

    iput-object v0, p0, Landroid/support/v7/internal/widget/TintManager;->mResources:Landroid/content/res/Resources;

    .line 129
    new-instance v0, Landroid/util/TypedValue;

    invoke-direct {v0}, Landroid/util/TypedValue;-><init>()V

    iput-object v0, p0, Landroid/support/v7/internal/widget/TintManager;->mTypedValue:Landroid/util/TypedValue;

    .line 130
    return-void
.end method

.method private static arrayContains([II)Z
    .locals 5
    .param p0, "array"    # [I
    .param p1, "value"    # I

    .prologue
    .line 204
    move-object v0, p0

    .local v0, "arr$":[I
    array-length v3, v0

    .local v3, "len$":I
    const/4 v1, 0x0

    .local v1, "i$":I
    :goto_0
    if-ge v1, v3, :cond_1

    aget v2, v0, v1

    .line 205
    .local v2, "id":I
    if-ne v2, p1, :cond_0

    .line 206
    const/4 v4, 0x1

    .line 209
    .end local v2    # "id":I
    :goto_1
    return v4

    .line 204
    .restart local v2    # "id":I
    :cond_0
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 209
    .end local v2    # "id":I
    :cond_1
    const/4 v4, 0x0

    goto :goto_1
.end method

.method private getDefaultColorStateList()Landroid/content/res/ColorStateList;
    .locals 9

    .prologue
    const/4 v6, 0x7

    const/4 v8, 0x1

    const/4 v7, 0x0

    .line 221
    iget-object v5, p0, Landroid/support/v7/internal/widget/TintManager;->mDefaultColorStateList:Landroid/content/res/ColorStateList;

    if-nez v5, :cond_0

    .line 227
    sget v5, Landroid/support/v7/appcompat/R$attr;->colorControlNormal:I

    invoke-virtual {p0, v5}, Landroid/support/v7/internal/widget/TintManager;->getThemeAttrColor(I)I

    move-result v1

    .line 228
    .local v1, "colorControlNormal":I
    sget v5, Landroid/support/v7/appcompat/R$attr;->colorControlActivated:I

    invoke-virtual {p0, v5}, Landroid/support/v7/internal/widget/TintManager;->getThemeAttrColor(I)I

    move-result v0

    .line 230
    .local v0, "colorControlActivated":I
    new-array v4, v6, [[I

    .line 231
    .local v4, "states":[[I
    new-array v2, v6, [I

    .line 232
    .local v2, "colors":[I
    const/4 v3, 0x0

    .line 235
    .local v3, "i":I
    new-array v5, v8, [I

    const v6, -0x101009e

    aput v6, v5, v7

    aput-object v5, v4, v3

    .line 236
    sget v5, Landroid/support/v7/appcompat/R$attr;->colorControlNormal:I

    invoke-virtual {p0, v5}, Landroid/support/v7/internal/widget/TintManager;->getDisabledThemeAttrColor(I)I

    move-result v5

    aput v5, v2, v3

    .line 237
    add-int/lit8 v3, v3, 0x1

    .line 239
    new-array v5, v8, [I

    const v6, 0x101009c

    aput v6, v5, v7

    aput-object v5, v4, v3

    .line 240
    aput v0, v2, v3

    .line 241
    add-int/lit8 v3, v3, 0x1

    .line 243
    new-array v5, v8, [I

    const v6, 0x10102fe

    aput v6, v5, v7

    aput-object v5, v4, v3

    .line 244
    aput v0, v2, v3

    .line 245
    add-int/lit8 v3, v3, 0x1

    .line 247
    new-array v5, v8, [I

    const v6, 0x10100a7

    aput v6, v5, v7

    aput-object v5, v4, v3

    .line 248
    aput v0, v2, v3

    .line 249
    add-int/lit8 v3, v3, 0x1

    .line 251
    new-array v5, v8, [I

    const v6, 0x10100a0

    aput v6, v5, v7

    aput-object v5, v4, v3

    .line 252
    aput v0, v2, v3

    .line 253
    add-int/lit8 v3, v3, 0x1

    .line 255
    new-array v5, v8, [I

    const v6, 0x10100a1

    aput v6, v5, v7

    aput-object v5, v4, v3

    .line 256
    aput v0, v2, v3

    .line 257
    add-int/lit8 v3, v3, 0x1

    .line 260
    new-array v5, v7, [I

    aput-object v5, v4, v3

    .line 261
    aput v1, v2, v3

    .line 262
    add-int/lit8 v3, v3, 0x1

    .line 264
    new-instance v5, Landroid/content/res/ColorStateList;

    invoke-direct {v5, v4, v2}, Landroid/content/res/ColorStateList;-><init>([[I[I)V

    iput-object v5, p0, Landroid/support/v7/internal/widget/TintManager;->mDefaultColorStateList:Landroid/content/res/ColorStateList;

    .line 266
    .end local v0    # "colorControlActivated":I
    .end local v1    # "colorControlNormal":I
    .end local v2    # "colors":[I
    .end local v3    # "i":I
    .end local v4    # "states":[[I
    :cond_0
    iget-object v5, p0, Landroid/support/v7/internal/widget/TintManager;->mDefaultColorStateList:Landroid/content/res/ColorStateList;

    return-object v5
.end method

.method public static getDrawable(Landroid/content/Context;I)Landroid/graphics/drawable/Drawable;
    .locals 1
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "resId"    # I

    .prologue
    .line 119
    invoke-static {p1}, Landroid/support/v7/internal/widget/TintManager;->isInTintList(I)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 120
    new-instance v0, Landroid/support/v7/internal/widget/TintManager;

    invoke-direct {v0, p0}, Landroid/support/v7/internal/widget/TintManager;-><init>(Landroid/content/Context;)V

    invoke-virtual {v0, p1}, Landroid/support/v7/internal/widget/TintManager;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    .line 122
    :goto_0
    return-object v0

    :cond_0
    invoke-static {p0, p1}, Landroid/support/v4/content/ContextCompat;->getDrawable(Landroid/content/Context;I)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    goto :goto_0
.end method

.method private getSwitchThumbColorStateList()Landroid/content/res/ColorStateList;
    .locals 7

    .prologue
    const/4 v4, 0x3

    const/4 v6, 0x1

    const/4 v5, 0x0

    .line 295
    iget-object v3, p0, Landroid/support/v7/internal/widget/TintManager;->mSwitchThumbStateList:Landroid/content/res/ColorStateList;

    if-nez v3, :cond_0

    .line 296
    new-array v2, v4, [[I

    .line 297
    .local v2, "states":[[I
    new-array v0, v4, [I

    .line 298
    .local v0, "colors":[I
    const/4 v1, 0x0

    .line 301
    .local v1, "i":I
    new-array v3, v6, [I

    const v4, -0x101009e

    aput v4, v3, v5

    aput-object v3, v2, v1

    .line 302
    sget v3, Landroid/support/v7/appcompat/R$attr;->colorSwitchThumbNormal:I

    invoke-virtual {p0, v3}, Landroid/support/v7/internal/widget/TintManager;->getDisabledThemeAttrColor(I)I

    move-result v3

    aput v3, v0, v1

    .line 303
    add-int/lit8 v1, v1, 0x1

    .line 305
    new-array v3, v6, [I

    const v4, 0x10100a0

    aput v4, v3, v5

    aput-object v3, v2, v1

    .line 306
    sget v3, Landroid/support/v7/appcompat/R$attr;->colorControlActivated:I

    invoke-virtual {p0, v3}, Landroid/support/v7/internal/widget/TintManager;->getThemeAttrColor(I)I

    move-result v3

    aput v3, v0, v1

    .line 307
    add-int/lit8 v1, v1, 0x1

    .line 310
    new-array v3, v5, [I

    aput-object v3, v2, v1

    .line 311
    sget v3, Landroid/support/v7/appcompat/R$attr;->colorSwitchThumbNormal:I

    invoke-virtual {p0, v3}, Landroid/support/v7/internal/widget/TintManager;->getThemeAttrColor(I)I

    move-result v3

    aput v3, v0, v1

    .line 312
    add-int/lit8 v1, v1, 0x1

    .line 314
    new-instance v3, Landroid/content/res/ColorStateList;

    invoke-direct {v3, v2, v0}, Landroid/content/res/ColorStateList;-><init>([[I[I)V

    iput-object v3, p0, Landroid/support/v7/internal/widget/TintManager;->mSwitchThumbStateList:Landroid/content/res/ColorStateList;

    .line 316
    .end local v0    # "colors":[I
    .end local v1    # "i":I
    .end local v2    # "states":[[I
    :cond_0
    iget-object v3, p0, Landroid/support/v7/internal/widget/TintManager;->mSwitchThumbStateList:Landroid/content/res/ColorStateList;

    return-object v3
.end method

.method private getSwitchTrackColorStateList()Landroid/content/res/ColorStateList;
    .locals 9

    .prologue
    const v8, 0x1010030

    const/4 v4, 0x3

    const/4 v7, 0x1

    const v6, 0x3e99999a    # 0.3f

    const/4 v5, 0x0

    .line 270
    iget-object v3, p0, Landroid/support/v7/internal/widget/TintManager;->mSwitchTrackStateList:Landroid/content/res/ColorStateList;

    if-nez v3, :cond_0

    .line 271
    new-array v2, v4, [[I

    .line 272
    .local v2, "states":[[I
    new-array v0, v4, [I

    .line 273
    .local v0, "colors":[I
    const/4 v1, 0x0

    .line 276
    .local v1, "i":I
    new-array v3, v7, [I

    const v4, -0x101009e

    aput v4, v3, v5

    aput-object v3, v2, v1

    .line 277
    const v3, 0x3dcccccd    # 0.1f

    invoke-virtual {p0, v8, v3}, Landroid/support/v7/internal/widget/TintManager;->getThemeAttrColor(IF)I

    move-result v3

    aput v3, v0, v1

    .line 278
    add-int/lit8 v1, v1, 0x1

    .line 280
    new-array v3, v7, [I

    const v4, 0x10100a0

    aput v4, v3, v5

    aput-object v3, v2, v1

    .line 281
    sget v3, Landroid/support/v7/appcompat/R$attr;->colorControlActivated:I

    invoke-virtual {p0, v3, v6}, Landroid/support/v7/internal/widget/TintManager;->getThemeAttrColor(IF)I

    move-result v3

    aput v3, v0, v1

    .line 282
    add-int/lit8 v1, v1, 0x1

    .line 285
    new-array v3, v5, [I

    aput-object v3, v2, v1

    .line 286
    invoke-virtual {p0, v8, v6}, Landroid/support/v7/internal/widget/TintManager;->getThemeAttrColor(IF)I

    move-result v3

    aput v3, v0, v1

    .line 287
    add-int/lit8 v1, v1, 0x1

    .line 289
    new-instance v3, Landroid/content/res/ColorStateList;

    invoke-direct {v3, v2, v0}, Landroid/content/res/ColorStateList;-><init>([[I[I)V

    iput-object v3, p0, Landroid/support/v7/internal/widget/TintManager;->mSwitchTrackStateList:Landroid/content/res/ColorStateList;

    .line 291
    .end local v0    # "colors":[I
    .end local v1    # "i":I
    .end local v2    # "states":[[I
    :cond_0
    iget-object v3, p0, Landroid/support/v7/internal/widget/TintManager;->mSwitchTrackStateList:Landroid/content/res/ColorStateList;

    return-object v3
.end method

.method private static isInTintList(I)Z
    .locals 1
    .param p0, "drawableId"    # I

    .prologue
    .line 213
    sget-object v0, Landroid/support/v7/internal/widget/TintManager;->TINT_COLOR_BACKGROUND_MULTIPLY:[I

    invoke-static {v0, p0}, Landroid/support/v7/internal/widget/TintManager;->arrayContains([II)Z

    move-result v0

    if-nez v0, :cond_0

    sget-object v0, Landroid/support/v7/internal/widget/TintManager;->TINT_COLOR_CONTROL_NORMAL:[I

    invoke-static {v0, p0}, Landroid/support/v7/internal/widget/TintManager;->arrayContains([II)Z

    move-result v0

    if-nez v0, :cond_0

    sget-object v0, Landroid/support/v7/internal/widget/TintManager;->TINT_COLOR_CONTROL_ACTIVATED:[I

    invoke-static {v0, p0}, Landroid/support/v7/internal/widget/TintManager;->arrayContains([II)Z

    move-result v0

    if-nez v0, :cond_0

    sget-object v0, Landroid/support/v7/internal/widget/TintManager;->TINT_COLOR_CONTROL_STATE_LIST:[I

    invoke-static {v0, p0}, Landroid/support/v7/internal/widget/TintManager;->arrayContains([II)Z

    move-result v0

    if-nez v0, :cond_0

    sget-object v0, Landroid/support/v7/internal/widget/TintManager;->CONTAINERS_WITH_TINT_CHILDREN:[I

    invoke-static {v0, p0}, Landroid/support/v7/internal/widget/TintManager;->arrayContains([II)Z

    move-result v0

    if-eqz v0, :cond_1

    :cond_0
    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method


# virtual methods
.method getDisabledThemeAttrColor(I)I
    .locals 5
    .param p1, "attr"    # I

    .prologue
    .line 341
    iget-object v1, p0, Landroid/support/v7/internal/widget/TintManager;->mContext:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getTheme()Landroid/content/res/Resources$Theme;

    move-result-object v1

    const v2, 0x1010033

    iget-object v3, p0, Landroid/support/v7/internal/widget/TintManager;->mTypedValue:Landroid/util/TypedValue;

    const/4 v4, 0x1

    invoke-virtual {v1, v2, v3, v4}, Landroid/content/res/Resources$Theme;->resolveAttribute(ILandroid/util/TypedValue;Z)Z

    .line 342
    iget-object v1, p0, Landroid/support/v7/internal/widget/TintManager;->mTypedValue:Landroid/util/TypedValue;

    invoke-virtual {v1}, Landroid/util/TypedValue;->getFloat()F

    move-result v0

    .line 344
    .local v0, "disabledAlpha":F
    invoke-virtual {p0, p1, v0}, Landroid/support/v7/internal/widget/TintManager;->getThemeAttrColor(IF)I

    move-result v1

    return v1
.end method

.method public getDrawable(I)Landroid/graphics/drawable/Drawable;
    .locals 4
    .param p1, "resId"    # I

    .prologue
    .line 133
    iget-object v2, p0, Landroid/support/v7/internal/widget/TintManager;->mContext:Landroid/content/Context;

    invoke-static {v2, p1}, Landroid/support/v4/content/ContextCompat;->getDrawable(Landroid/content/Context;I)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    .line 135
    .local v0, "drawable":Landroid/graphics/drawable/Drawable;
    if-eqz v0, :cond_0

    .line 136
    sget-object v2, Landroid/support/v7/internal/widget/TintManager;->TINT_COLOR_CONTROL_STATE_LIST:[I

    invoke-static {v2, p1}, Landroid/support/v7/internal/widget/TintManager;->arrayContains([II)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 137
    new-instance v1, Landroid/support/v7/internal/widget/TintDrawableWrapper;

    invoke-direct {p0}, Landroid/support/v7/internal/widget/TintManager;->getDefaultColorStateList()Landroid/content/res/ColorStateList;

    move-result-object v2

    invoke-direct {v1, v0, v2}, Landroid/support/v7/internal/widget/TintDrawableWrapper;-><init>(Landroid/graphics/drawable/Drawable;Landroid/content/res/ColorStateList;)V

    .end local v0    # "drawable":Landroid/graphics/drawable/Drawable;
    .local v1, "drawable":Landroid/graphics/drawable/Drawable;
    move-object v0, v1

    .line 149
    .end local v1    # "drawable":Landroid/graphics/drawable/Drawable;
    .restart local v0    # "drawable":Landroid/graphics/drawable/Drawable;
    :cond_0
    :goto_0
    return-object v0

    .line 138
    :cond_1
    sget v2, Landroid/support/v7/appcompat/R$drawable;->abc_switch_track_mtrl_alpha:I

    if-ne p1, v2, :cond_2

    .line 139
    new-instance v1, Landroid/support/v7/internal/widget/TintDrawableWrapper;

    invoke-direct {p0}, Landroid/support/v7/internal/widget/TintManager;->getSwitchTrackColorStateList()Landroid/content/res/ColorStateList;

    move-result-object v2

    invoke-direct {v1, v0, v2}, Landroid/support/v7/internal/widget/TintDrawableWrapper;-><init>(Landroid/graphics/drawable/Drawable;Landroid/content/res/ColorStateList;)V

    .end local v0    # "drawable":Landroid/graphics/drawable/Drawable;
    .restart local v1    # "drawable":Landroid/graphics/drawable/Drawable;
    move-object v0, v1

    .end local v1    # "drawable":Landroid/graphics/drawable/Drawable;
    .restart local v0    # "drawable":Landroid/graphics/drawable/Drawable;
    goto :goto_0

    .line 140
    :cond_2
    sget v2, Landroid/support/v7/appcompat/R$drawable;->abc_switch_thumb_material:I

    if-ne p1, v2, :cond_3

    .line 141
    new-instance v1, Landroid/support/v7/internal/widget/TintDrawableWrapper;

    invoke-direct {p0}, Landroid/support/v7/internal/widget/TintManager;->getSwitchThumbColorStateList()Landroid/content/res/ColorStateList;

    move-result-object v2

    sget-object v3, Landroid/graphics/PorterDuff$Mode;->MULTIPLY:Landroid/graphics/PorterDuff$Mode;

    invoke-direct {v1, v0, v2, v3}, Landroid/support/v7/internal/widget/TintDrawableWrapper;-><init>(Landroid/graphics/drawable/Drawable;Landroid/content/res/ColorStateList;Landroid/graphics/PorterDuff$Mode;)V

    .end local v0    # "drawable":Landroid/graphics/drawable/Drawable;
    .restart local v1    # "drawable":Landroid/graphics/drawable/Drawable;
    move-object v0, v1

    .end local v1    # "drawable":Landroid/graphics/drawable/Drawable;
    .restart local v0    # "drawable":Landroid/graphics/drawable/Drawable;
    goto :goto_0

    .line 143
    :cond_3
    sget-object v2, Landroid/support/v7/internal/widget/TintManager;->CONTAINERS_WITH_TINT_CHILDREN:[I

    invoke-static {v2, p1}, Landroid/support/v7/internal/widget/TintManager;->arrayContains([II)Z

    move-result v2

    if-eqz v2, :cond_4

    .line 144
    iget-object v2, p0, Landroid/support/v7/internal/widget/TintManager;->mResources:Landroid/content/res/Resources;

    invoke-virtual {v2, p1}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    goto :goto_0

    .line 146
    :cond_4
    invoke-virtual {p0, p1, v0}, Landroid/support/v7/internal/widget/TintManager;->tintDrawable(ILandroid/graphics/drawable/Drawable;)V

    goto :goto_0
.end method

.method getThemeAttrColor(I)I
    .locals 3
    .param p1, "attr"    # I

    .prologue
    .line 320
    iget-object v0, p0, Landroid/support/v7/internal/widget/TintManager;->mContext:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getTheme()Landroid/content/res/Resources$Theme;

    move-result-object v0

    iget-object v1, p0, Landroid/support/v7/internal/widget/TintManager;->mTypedValue:Landroid/util/TypedValue;

    const/4 v2, 0x1

    invoke-virtual {v0, p1, v1, v2}, Landroid/content/res/Resources$Theme;->resolveAttribute(ILandroid/util/TypedValue;Z)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 321
    iget-object v0, p0, Landroid/support/v7/internal/widget/TintManager;->mTypedValue:Landroid/util/TypedValue;

    iget v0, v0, Landroid/util/TypedValue;->type:I

    const/16 v1, 0x10

    if-lt v0, v1, :cond_0

    iget-object v0, p0, Landroid/support/v7/internal/widget/TintManager;->mTypedValue:Landroid/util/TypedValue;

    iget v0, v0, Landroid/util/TypedValue;->type:I

    const/16 v1, 0x1f

    if-gt v0, v1, :cond_0

    .line 323
    iget-object v0, p0, Landroid/support/v7/internal/widget/TintManager;->mTypedValue:Landroid/util/TypedValue;

    iget v0, v0, Landroid/util/TypedValue;->data:I

    .line 328
    :goto_0
    return v0

    .line 324
    :cond_0
    iget-object v0, p0, Landroid/support/v7/internal/widget/TintManager;->mTypedValue:Landroid/util/TypedValue;

    iget v0, v0, Landroid/util/TypedValue;->type:I

    const/4 v1, 0x3

    if-ne v0, v1, :cond_1

    .line 325
    iget-object v0, p0, Landroid/support/v7/internal/widget/TintManager;->mResources:Landroid/content/res/Resources;

    iget-object v1, p0, Landroid/support/v7/internal/widget/TintManager;->mTypedValue:Landroid/util/TypedValue;

    iget v1, v1, Landroid/util/TypedValue;->resourceId:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getColor(I)I

    move-result v0

    goto :goto_0

    .line 328
    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method getThemeAttrColor(IF)I
    .locals 4
    .param p1, "attr"    # I
    .param p2, "alpha"    # F

    .prologue
    .line 332
    invoke-virtual {p0, p1}, Landroid/support/v7/internal/widget/TintManager;->getThemeAttrColor(I)I

    move-result v0

    .line 333
    .local v0, "color":I
    invoke-static {v0}, Landroid/graphics/Color;->alpha(I)I

    move-result v1

    .line 336
    .local v1, "originalAlpha":I
    const v2, 0xffffff

    and-int/2addr v2, v0

    int-to-float v3, v1

    mul-float/2addr v3, p2

    invoke-static {v3}, Ljava/lang/Math;->round(F)I

    move-result v3

    shl-int/lit8 v3, v3, 0x18

    or-int/2addr v2, v3

    return v2
.end method

.method tintDrawable(ILandroid/graphics/drawable/Drawable;)V
    .locals 7
    .param p1, "resId"    # I
    .param p2, "drawable"    # Landroid/graphics/drawable/Drawable;

    .prologue
    .line 153
    const/4 v5, 0x0

    .line 154
    .local v5, "tintMode":Landroid/graphics/PorterDuff$Mode;
    const/4 v3, 0x0

    .line 155
    .local v3, "colorAttrSet":Z
    const/4 v2, 0x0

    .line 156
    .local v2, "colorAttr":I
    const/4 v0, -0x1

    .line 158
    .local v0, "alpha":I
    sget-object v6, Landroid/support/v7/internal/widget/TintManager;->TINT_COLOR_CONTROL_NORMAL:[I

    invoke-static {v6, p1}, Landroid/support/v7/internal/widget/TintManager;->arrayContains([II)Z

    move-result v6

    if-eqz v6, :cond_4

    .line 159
    sget v2, Landroid/support/v7/appcompat/R$attr;->colorControlNormal:I

    .line 160
    const/4 v3, 0x1

    .line 174
    :cond_0
    :goto_0
    if-eqz v3, :cond_3

    .line 175
    if-nez v5, :cond_1

    .line 176
    sget-object v5, Landroid/support/v7/internal/widget/TintManager;->DEFAULT_MODE:Landroid/graphics/PorterDuff$Mode;

    .line 178
    :cond_1
    invoke-virtual {p0, v2}, Landroid/support/v7/internal/widget/TintManager;->getThemeAttrColor(I)I

    move-result v1

    .line 181
    .local v1, "color":I
    sget-object v6, Landroid/support/v7/internal/widget/TintManager;->COLOR_FILTER_CACHE:Landroid/support/v7/internal/widget/TintManager$ColorFilterLruCache;

    invoke-virtual {v6, v1, v5}, Landroid/support/v7/internal/widget/TintManager$ColorFilterLruCache;->get(ILandroid/graphics/PorterDuff$Mode;)Landroid/graphics/PorterDuffColorFilter;

    move-result-object v4

    .line 183
    .local v4, "filter":Landroid/graphics/PorterDuffColorFilter;
    if-nez v4, :cond_2

    .line 185
    new-instance v4, Landroid/graphics/PorterDuffColorFilter;

    .end local v4    # "filter":Landroid/graphics/PorterDuffColorFilter;
    invoke-direct {v4, v1, v5}, Landroid/graphics/PorterDuffColorFilter;-><init>(ILandroid/graphics/PorterDuff$Mode;)V

    .line 186
    .restart local v4    # "filter":Landroid/graphics/PorterDuffColorFilter;
    sget-object v6, Landroid/support/v7/internal/widget/TintManager;->COLOR_FILTER_CACHE:Landroid/support/v7/internal/widget/TintManager$ColorFilterLruCache;

    invoke-virtual {v6, v1, v5, v4}, Landroid/support/v7/internal/widget/TintManager$ColorFilterLruCache;->put(ILandroid/graphics/PorterDuff$Mode;Landroid/graphics/PorterDuffColorFilter;)Landroid/graphics/PorterDuffColorFilter;

    .line 190
    :cond_2
    invoke-virtual {p2, v4}, Landroid/graphics/drawable/Drawable;->setColorFilter(Landroid/graphics/ColorFilter;)V

    .line 192
    const/4 v6, -0x1

    if-eq v0, v6, :cond_3

    .line 193
    invoke-virtual {p2, v0}, Landroid/graphics/drawable/Drawable;->setAlpha(I)V

    .line 201
    .end local v1    # "color":I
    .end local v4    # "filter":Landroid/graphics/PorterDuffColorFilter;
    :cond_3
    return-void

    .line 161
    :cond_4
    sget-object v6, Landroid/support/v7/internal/widget/TintManager;->TINT_COLOR_CONTROL_ACTIVATED:[I

    invoke-static {v6, p1}, Landroid/support/v7/internal/widget/TintManager;->arrayContains([II)Z

    move-result v6

    if-eqz v6, :cond_5

    .line 162
    sget v2, Landroid/support/v7/appcompat/R$attr;->colorControlActivated:I

    .line 163
    const/4 v3, 0x1

    goto :goto_0

    .line 164
    :cond_5
    sget-object v6, Landroid/support/v7/internal/widget/TintManager;->TINT_COLOR_BACKGROUND_MULTIPLY:[I

    invoke-static {v6, p1}, Landroid/support/v7/internal/widget/TintManager;->arrayContains([II)Z

    move-result v6

    if-eqz v6, :cond_6

    .line 165
    const v2, 0x1010031

    .line 166
    const/4 v3, 0x1

    .line 167
    sget-object v5, Landroid/graphics/PorterDuff$Mode;->MULTIPLY:Landroid/graphics/PorterDuff$Mode;

    goto :goto_0

    .line 168
    :cond_6
    sget v6, Landroid/support/v7/appcompat/R$drawable;->abc_list_divider_mtrl_alpha:I

    if-ne p1, v6, :cond_0

    .line 169
    const v2, 0x1010030

    .line 170
    const/4 v3, 0x1

    .line 171
    const v6, 0x42233333    # 40.8f

    invoke-static {v6}, Ljava/lang/Math;->round(F)I

    move-result v0

    goto :goto_0
.end method
