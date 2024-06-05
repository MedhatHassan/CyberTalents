.class public Landroid/support/v7/internal/view/SupportActionModeWrapper;
.super Landroid/view/ActionMode;
.source "SupportActionModeWrapper.java"


# annotations
.annotation build Landroid/annotation/TargetApi;
    value = 0xb
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/support/v7/internal/view/SupportActionModeWrapper$CallbackWrapper;
    }
.end annotation


# instance fields
.field final mContext:Landroid/content/Context;

.field final mWrappedObject:Landroid/support/v7/view/ActionMode;


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/support/v7/view/ActionMode;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "supportActionMode"    # Landroid/support/v7/view/ActionMode;

    .prologue
    .line 44
    invoke-direct {p0}, Landroid/view/ActionMode;-><init>()V

    .line 45
    iput-object p1, p0, Landroid/support/v7/internal/view/SupportActionModeWrapper;->mContext:Landroid/content/Context;

    .line 46
    iput-object p2, p0, Landroid/support/v7/internal/view/SupportActionModeWrapper;->mWrappedObject:Landroid/support/v7/view/ActionMode;

    .line 47
    return-void
.end method


# virtual methods
.method public finish()V
    .locals 1

    .prologue
    .line 76
    iget-object v0, p0, Landroid/support/v7/internal/view/SupportActionModeWrapper;->mWrappedObject:Landroid/support/v7/view/ActionMode;

    invoke-virtual {v0}, Landroid/support/v7/view/ActionMode;->finish()V

    .line 77
    return-void
.end method

.method public getCustomView()Landroid/view/View;
    .locals 1

    .prologue
    .line 106
    iget-object v0, p0, Landroid/support/v7/internal/view/SupportActionModeWrapper;->mWrappedObject:Landroid/support/v7/view/ActionMode;

    invoke-virtual {v0}, Landroid/support/v7/view/ActionMode;->getCustomView()Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

.method public getMenu()Landroid/view/Menu;
    .locals 2

    .prologue
    .line 81
    iget-object v1, p0, Landroid/support/v7/internal/view/SupportActionModeWrapper;->mContext:Landroid/content/Context;

    iget-object v0, p0, Landroid/support/v7/internal/view/SupportActionModeWrapper;->mWrappedObject:Landroid/support/v7/view/ActionMode;

    invoke-virtual {v0}, Landroid/support/v7/view/ActionMode;->getMenu()Landroid/view/Menu;

    move-result-object v0

    check-cast v0, Landroid/support/v4/internal/view/SupportMenu;

    invoke-static {v1, v0}, Landroid/support/v7/internal/view/menu/MenuWrapperFactory;->wrapSupportMenu(Landroid/content/Context;Landroid/support/v4/internal/view/SupportMenu;)Landroid/view/Menu;

    move-result-object v0

    return-object v0
.end method

.method public getMenuInflater()Landroid/view/MenuInflater;
    .locals 1

    .prologue
    .line 116
    iget-object v0, p0, Landroid/support/v7/internal/view/SupportActionModeWrapper;->mWrappedObject:Landroid/support/v7/view/ActionMode;

    invoke-virtual {v0}, Landroid/support/v7/view/ActionMode;->getMenuInflater()Landroid/view/MenuInflater;

    move-result-object v0

    return-object v0
.end method

.method public getSubtitle()Ljava/lang/CharSequence;
    .locals 1

    .prologue
    .line 96
    iget-object v0, p0, Landroid/support/v7/internal/view/SupportActionModeWrapper;->mWrappedObject:Landroid/support/v7/view/ActionMode;

    invoke-virtual {v0}, Landroid/support/v7/view/ActionMode;->getSubtitle()Ljava/lang/CharSequence;

    move-result-object v0

    return-object v0
.end method

.method public getTag()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 51
    iget-object v0, p0, Landroid/support/v7/internal/view/SupportActionModeWrapper;->mWrappedObject:Landroid/support/v7/view/ActionMode;

    invoke-virtual {v0}, Landroid/support/v7/view/ActionMode;->getTag()Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public getTitle()Ljava/lang/CharSequence;
    .locals 1

    .prologue
    .line 86
    iget-object v0, p0, Landroid/support/v7/internal/view/SupportActionModeWrapper;->mWrappedObject:Landroid/support/v7/view/ActionMode;

    invoke-virtual {v0}, Landroid/support/v7/view/ActionMode;->getTitle()Ljava/lang/CharSequence;

    move-result-object v0

    return-object v0
.end method

.method public getTitleOptionalHint()Z
    .locals 1

    .prologue
    .line 121
    iget-object v0, p0, Landroid/support/v7/internal/view/SupportActionModeWrapper;->mWrappedObject:Landroid/support/v7/view/ActionMode;

    invoke-virtual {v0}, Landroid/support/v7/view/ActionMode;->getTitleOptionalHint()Z

    move-result v0

    return v0
.end method

.method public invalidate()V
    .locals 1

    .prologue
    .line 71
    iget-object v0, p0, Landroid/support/v7/internal/view/SupportActionModeWrapper;->mWrappedObject:Landroid/support/v7/view/ActionMode;

    invoke-virtual {v0}, Landroid/support/v7/view/ActionMode;->invalidate()V

    .line 72
    return-void
.end method

.method public isTitleOptional()Z
    .locals 1

    .prologue
    .line 131
    iget-object v0, p0, Landroid/support/v7/internal/view/SupportActionModeWrapper;->mWrappedObject:Landroid/support/v7/view/ActionMode;

    invoke-virtual {v0}, Landroid/support/v7/view/ActionMode;->isTitleOptional()Z

    move-result v0

    return v0
.end method

.method public setCustomView(Landroid/view/View;)V
    .locals 1
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 111
    iget-object v0, p0, Landroid/support/v7/internal/view/SupportActionModeWrapper;->mWrappedObject:Landroid/support/v7/view/ActionMode;

    invoke-virtual {v0, p1}, Landroid/support/v7/view/ActionMode;->setCustomView(Landroid/view/View;)V

    .line 112
    return-void
.end method

.method public setSubtitle(I)V
    .locals 1
    .param p1, "resId"    # I

    .prologue
    .line 101
    iget-object v0, p0, Landroid/support/v7/internal/view/SupportActionModeWrapper;->mWrappedObject:Landroid/support/v7/view/ActionMode;

    invoke-virtual {v0, p1}, Landroid/support/v7/view/ActionMode;->setSubtitle(I)V

    .line 102
    return-void
.end method

.method public setSubtitle(Ljava/lang/CharSequence;)V
    .locals 1
    .param p1, "subtitle"    # Ljava/lang/CharSequence;

    .prologue
    .line 66
    iget-object v0, p0, Landroid/support/v7/internal/view/SupportActionModeWrapper;->mWrappedObject:Landroid/support/v7/view/ActionMode;

    invoke-virtual {v0, p1}, Landroid/support/v7/view/ActionMode;->setSubtitle(Ljava/lang/CharSequence;)V

    .line 67
    return-void
.end method

.method public setTag(Ljava/lang/Object;)V
    .locals 1
    .param p1, "tag"    # Ljava/lang/Object;

    .prologue
    .line 56
    iget-object v0, p0, Landroid/support/v7/internal/view/SupportActionModeWrapper;->mWrappedObject:Landroid/support/v7/view/ActionMode;

    invoke-virtual {v0, p1}, Landroid/support/v7/view/ActionMode;->setTag(Ljava/lang/Object;)V

    .line 57
    return-void
.end method

.method public setTitle(I)V
    .locals 1
    .param p1, "resId"    # I

    .prologue
    .line 91
    iget-object v0, p0, Landroid/support/v7/internal/view/SupportActionModeWrapper;->mWrappedObject:Landroid/support/v7/view/ActionMode;

    invoke-virtual {v0, p1}, Landroid/support/v7/view/ActionMode;->setTitle(I)V

    .line 92
    return-void
.end method

.method public setTitle(Ljava/lang/CharSequence;)V
    .locals 1
    .param p1, "title"    # Ljava/lang/CharSequence;

    .prologue
    .line 61
    iget-object v0, p0, Landroid/support/v7/internal/view/SupportActionModeWrapper;->mWrappedObject:Landroid/support/v7/view/ActionMode;

    invoke-virtual {v0, p1}, Landroid/support/v7/view/ActionMode;->setTitle(Ljava/lang/CharSequence;)V

    .line 62
    return-void
.end method

.method public setTitleOptionalHint(Z)V
    .locals 1
    .param p1, "titleOptional"    # Z

    .prologue
    .line 126
    iget-object v0, p0, Landroid/support/v7/internal/view/SupportActionModeWrapper;->mWrappedObject:Landroid/support/v7/view/ActionMode;

    invoke-virtual {v0, p1}, Landroid/support/v7/view/ActionMode;->setTitleOptionalHint(Z)V

    .line 127
    return-void
.end method
