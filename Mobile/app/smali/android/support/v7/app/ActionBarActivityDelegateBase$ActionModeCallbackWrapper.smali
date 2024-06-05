.class Landroid/support/v7/app/ActionBarActivityDelegateBase$ActionModeCallbackWrapper;
.super Ljava/lang/Object;
.source "ActionBarActivityDelegateBase.java"

# interfaces
.implements Landroid/support/v7/view/ActionMode$Callback;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/support/v7/app/ActionBarActivityDelegateBase;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "ActionModeCallbackWrapper"
.end annotation


# instance fields
.field private mWrapped:Landroid/support/v7/view/ActionMode$Callback;

.field final synthetic this$0:Landroid/support/v7/app/ActionBarActivityDelegateBase;


# direct methods
.method public constructor <init>(Landroid/support/v7/app/ActionBarActivityDelegateBase;Landroid/support/v7/view/ActionMode$Callback;)V
    .locals 0
    .param p2, "wrapped"    # Landroid/support/v7/view/ActionMode$Callback;

    .prologue
    .line 1292
    iput-object p1, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase$ActionModeCallbackWrapper;->this$0:Landroid/support/v7/app/ActionBarActivityDelegateBase;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 1293
    iput-object p2, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase$ActionModeCallbackWrapper;->mWrapped:Landroid/support/v7/view/ActionMode$Callback;

    .line 1294
    return-void
.end method


# virtual methods
.method public onActionItemClicked(Landroid/support/v7/view/ActionMode;Landroid/view/MenuItem;)Z
    .locals 1
    .param p1, "mode"    # Landroid/support/v7/view/ActionMode;
    .param p2, "item"    # Landroid/view/MenuItem;

    .prologue
    .line 1305
    iget-object v0, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase$ActionModeCallbackWrapper;->mWrapped:Landroid/support/v7/view/ActionMode$Callback;

    invoke-interface {v0, p1, p2}, Landroid/support/v7/view/ActionMode$Callback;->onActionItemClicked(Landroid/support/v7/view/ActionMode;Landroid/view/MenuItem;)Z

    move-result v0

    return v0
.end method

.method public onCreateActionMode(Landroid/support/v7/view/ActionMode;Landroid/view/Menu;)Z
    .locals 1
    .param p1, "mode"    # Landroid/support/v7/view/ActionMode;
    .param p2, "menu"    # Landroid/view/Menu;

    .prologue
    .line 1297
    iget-object v0, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase$ActionModeCallbackWrapper;->mWrapped:Landroid/support/v7/view/ActionMode$Callback;

    invoke-interface {v0, p1, p2}, Landroid/support/v7/view/ActionMode$Callback;->onCreateActionMode(Landroid/support/v7/view/ActionMode;Landroid/view/Menu;)Z

    move-result v0

    return v0
.end method

.method public onDestroyActionMode(Landroid/support/v7/view/ActionMode;)V
    .locals 2
    .param p1, "mode"    # Landroid/support/v7/view/ActionMode;

    .prologue
    .line 1309
    iget-object v0, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase$ActionModeCallbackWrapper;->mWrapped:Landroid/support/v7/view/ActionMode$Callback;

    invoke-interface {v0, p1}, Landroid/support/v7/view/ActionMode$Callback;->onDestroyActionMode(Landroid/support/v7/view/ActionMode;)V

    .line 1310
    iget-object v0, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase$ActionModeCallbackWrapper;->this$0:Landroid/support/v7/app/ActionBarActivityDelegateBase;

    iget-object v0, v0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mActionModePopup:Landroid/widget/PopupWindow;

    if-eqz v0, :cond_3

    .line 1311
    iget-object v0, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase$ActionModeCallbackWrapper;->this$0:Landroid/support/v7/app/ActionBarActivityDelegateBase;

    iget-object v0, v0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mActivity:Landroid/support/v7/app/ActionBarActivity;

    invoke-virtual {v0}, Landroid/support/v7/app/ActionBarActivity;->getWindow()Landroid/view/Window;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/Window;->getDecorView()Landroid/view/View;

    move-result-object v0

    iget-object v1, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase$ActionModeCallbackWrapper;->this$0:Landroid/support/v7/app/ActionBarActivityDelegateBase;

    iget-object v1, v1, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mShowActionModePopup:Ljava/lang/Runnable;

    invoke-virtual {v0, v1}, Landroid/view/View;->removeCallbacks(Ljava/lang/Runnable;)Z

    .line 1312
    iget-object v0, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase$ActionModeCallbackWrapper;->this$0:Landroid/support/v7/app/ActionBarActivityDelegateBase;

    iget-object v0, v0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mActionModePopup:Landroid/widget/PopupWindow;

    invoke-virtual {v0}, Landroid/widget/PopupWindow;->dismiss()V

    .line 1319
    :cond_0
    :goto_0
    iget-object v0, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase$ActionModeCallbackWrapper;->this$0:Landroid/support/v7/app/ActionBarActivityDelegateBase;

    iget-object v0, v0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mActionModeView:Landroid/support/v7/internal/widget/ActionBarContextView;

    if-eqz v0, :cond_1

    .line 1320
    iget-object v0, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase$ActionModeCallbackWrapper;->this$0:Landroid/support/v7/app/ActionBarActivityDelegateBase;

    iget-object v0, v0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mActionModeView:Landroid/support/v7/internal/widget/ActionBarContextView;

    invoke-virtual {v0}, Landroid/support/v7/internal/widget/ActionBarContextView;->removeAllViews()V

    .line 1322
    :cond_1
    iget-object v0, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase$ActionModeCallbackWrapper;->this$0:Landroid/support/v7/app/ActionBarActivityDelegateBase;

    iget-object v0, v0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mActivity:Landroid/support/v7/app/ActionBarActivity;

    if-eqz v0, :cond_2

    .line 1324
    :try_start_0
    iget-object v0, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase$ActionModeCallbackWrapper;->this$0:Landroid/support/v7/app/ActionBarActivityDelegateBase;

    iget-object v0, v0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mActivity:Landroid/support/v7/app/ActionBarActivity;

    iget-object v1, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase$ActionModeCallbackWrapper;->this$0:Landroid/support/v7/app/ActionBarActivityDelegateBase;

    iget-object v1, v1, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mActionMode:Landroid/support/v7/view/ActionMode;

    invoke-virtual {v0, v1}, Landroid/support/v7/app/ActionBarActivity;->onSupportActionModeFinished(Landroid/support/v7/view/ActionMode;)V
    :try_end_0
    .catch Ljava/lang/AbstractMethodError; {:try_start_0 .. :try_end_0} :catch_0

    .line 1329
    :cond_2
    :goto_1
    iget-object v0, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase$ActionModeCallbackWrapper;->this$0:Landroid/support/v7/app/ActionBarActivityDelegateBase;

    const/4 v1, 0x0

    iput-object v1, v0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mActionMode:Landroid/support/v7/view/ActionMode;

    .line 1330
    return-void

    .line 1313
    :cond_3
    iget-object v0, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase$ActionModeCallbackWrapper;->this$0:Landroid/support/v7/app/ActionBarActivityDelegateBase;

    iget-object v0, v0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mActionModeView:Landroid/support/v7/internal/widget/ActionBarContextView;

    if-eqz v0, :cond_0

    .line 1314
    iget-object v0, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase$ActionModeCallbackWrapper;->this$0:Landroid/support/v7/app/ActionBarActivityDelegateBase;

    iget-object v0, v0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mActionModeView:Landroid/support/v7/internal/widget/ActionBarContextView;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/support/v7/internal/widget/ActionBarContextView;->setVisibility(I)V

    .line 1315
    iget-object v0, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase$ActionModeCallbackWrapper;->this$0:Landroid/support/v7/app/ActionBarActivityDelegateBase;

    iget-object v0, v0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mActionModeView:Landroid/support/v7/internal/widget/ActionBarContextView;

    invoke-virtual {v0}, Landroid/support/v7/internal/widget/ActionBarContextView;->getParent()Landroid/view/ViewParent;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 1316
    iget-object v0, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase$ActionModeCallbackWrapper;->this$0:Landroid/support/v7/app/ActionBarActivityDelegateBase;

    iget-object v0, v0, Landroid/support/v7/app/ActionBarActivityDelegateBase;->mActionModeView:Landroid/support/v7/internal/widget/ActionBarContextView;

    invoke-virtual {v0}, Landroid/support/v7/internal/widget/ActionBarContextView;->getParent()Landroid/view/ViewParent;

    move-result-object v0

    check-cast v0, Landroid/view/View;

    invoke-static {v0}, Landroid/support/v4/view/ViewCompat;->requestApplyInsets(Landroid/view/View;)V

    goto :goto_0

    .line 1325
    :catch_0
    move-exception v0

    goto :goto_1
.end method

.method public onPrepareActionMode(Landroid/support/v7/view/ActionMode;Landroid/view/Menu;)Z
    .locals 1
    .param p1, "mode"    # Landroid/support/v7/view/ActionMode;
    .param p2, "menu"    # Landroid/view/Menu;

    .prologue
    .line 1301
    iget-object v0, p0, Landroid/support/v7/app/ActionBarActivityDelegateBase$ActionModeCallbackWrapper;->mWrapped:Landroid/support/v7/view/ActionMode$Callback;

    invoke-interface {v0, p1, p2}, Landroid/support/v7/view/ActionMode$Callback;->onPrepareActionMode(Landroid/support/v7/view/ActionMode;Landroid/view/Menu;)Z

    move-result v0

    return v0
.end method
