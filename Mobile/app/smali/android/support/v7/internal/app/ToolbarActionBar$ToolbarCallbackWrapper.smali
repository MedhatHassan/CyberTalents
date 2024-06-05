.class Landroid/support/v7/internal/app/ToolbarActionBar$ToolbarCallbackWrapper;
.super Landroid/support/v7/widget/WindowCallbackWrapper;
.source "ToolbarActionBar.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/support/v7/internal/app/ToolbarActionBar;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "ToolbarCallbackWrapper"
.end annotation


# instance fields
.field final synthetic this$0:Landroid/support/v7/internal/app/ToolbarActionBar;


# direct methods
.method public constructor <init>(Landroid/support/v7/internal/app/ToolbarActionBar;Landroid/support/v7/internal/app/WindowCallback;)V
    .locals 0
    .param p2, "wrapped"    # Landroid/support/v7/internal/app/WindowCallback;

    .prologue
    .line 510
    iput-object p1, p0, Landroid/support/v7/internal/app/ToolbarActionBar$ToolbarCallbackWrapper;->this$0:Landroid/support/v7/internal/app/ToolbarActionBar;

    .line 511
    invoke-direct {p0, p2}, Landroid/support/v7/widget/WindowCallbackWrapper;-><init>(Landroid/support/v7/internal/app/WindowCallback;)V

    .line 512
    return-void
.end method


# virtual methods
.method public onCreatePanelView(I)Landroid/view/View;
    .locals 3
    .param p1, "featureId"    # I

    .prologue
    .line 526
    packed-switch p1, :pswitch_data_0

    .line 545
    :cond_0
    invoke-super {p0, p1}, Landroid/support/v7/widget/WindowCallbackWrapper;->onCreatePanelView(I)Landroid/view/View;

    move-result-object v1

    :goto_0
    return-object v1

    .line 528
    :pswitch_0
    iget-object v1, p0, Landroid/support/v7/internal/app/ToolbarActionBar$ToolbarCallbackWrapper;->this$0:Landroid/support/v7/internal/app/ToolbarActionBar;

    invoke-static {v1}, Landroid/support/v7/internal/app/ToolbarActionBar;->access$100(Landroid/support/v7/internal/app/ToolbarActionBar;)Z

    move-result v1

    if-nez v1, :cond_1

    .line 530
    iget-object v1, p0, Landroid/support/v7/internal/app/ToolbarActionBar$ToolbarCallbackWrapper;->this$0:Landroid/support/v7/internal/app/ToolbarActionBar;

    invoke-virtual {v1}, Landroid/support/v7/internal/app/ToolbarActionBar;->populateOptionsMenu()V

    .line 531
    iget-object v1, p0, Landroid/support/v7/internal/app/ToolbarActionBar$ToolbarCallbackWrapper;->this$0:Landroid/support/v7/internal/app/ToolbarActionBar;

    invoke-static {v1}, Landroid/support/v7/internal/app/ToolbarActionBar;->access$400(Landroid/support/v7/internal/app/ToolbarActionBar;)Landroid/support/v7/widget/Toolbar;

    move-result-object v1

    iget-object v2, p0, Landroid/support/v7/internal/app/ToolbarActionBar$ToolbarCallbackWrapper;->this$0:Landroid/support/v7/internal/app/ToolbarActionBar;

    invoke-static {v2}, Landroid/support/v7/internal/app/ToolbarActionBar;->access$300(Landroid/support/v7/internal/app/ToolbarActionBar;)Ljava/lang/Runnable;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/support/v7/widget/Toolbar;->removeCallbacks(Ljava/lang/Runnable;)Z

    .line 534
    :cond_1
    iget-object v1, p0, Landroid/support/v7/internal/app/ToolbarActionBar$ToolbarCallbackWrapper;->this$0:Landroid/support/v7/internal/app/ToolbarActionBar;

    invoke-static {v1}, Landroid/support/v7/internal/app/ToolbarActionBar;->access$100(Landroid/support/v7/internal/app/ToolbarActionBar;)Z

    move-result v1

    if-eqz v1, :cond_0

    iget-object v1, p0, Landroid/support/v7/internal/app/ToolbarActionBar$ToolbarCallbackWrapper;->this$0:Landroid/support/v7/internal/app/ToolbarActionBar;

    invoke-static {v1}, Landroid/support/v7/internal/app/ToolbarActionBar;->access$000(Landroid/support/v7/internal/app/ToolbarActionBar;)Landroid/support/v7/internal/app/WindowCallback;

    move-result-object v1

    if-eqz v1, :cond_0

    .line 536
    iget-object v1, p0, Landroid/support/v7/internal/app/ToolbarActionBar$ToolbarCallbackWrapper;->this$0:Landroid/support/v7/internal/app/ToolbarActionBar;

    invoke-static {v1}, Landroid/support/v7/internal/app/ToolbarActionBar;->access$500(Landroid/support/v7/internal/app/ToolbarActionBar;)Landroid/view/Menu;

    move-result-object v0

    .line 538
    .local v0, "menu":Landroid/view/Menu;
    iget-object v1, p0, Landroid/support/v7/internal/app/ToolbarActionBar$ToolbarCallbackWrapper;->this$0:Landroid/support/v7/internal/app/ToolbarActionBar;

    invoke-static {v1}, Landroid/support/v7/internal/app/ToolbarActionBar;->access$000(Landroid/support/v7/internal/app/ToolbarActionBar;)Landroid/support/v7/internal/app/WindowCallback;

    move-result-object v1

    const/4 v2, 0x0

    invoke-interface {v1, p1, v2, v0}, Landroid/support/v7/internal/app/WindowCallback;->onPreparePanel(ILandroid/view/View;Landroid/view/Menu;)Z

    move-result v1

    if-eqz v1, :cond_0

    iget-object v1, p0, Landroid/support/v7/internal/app/ToolbarActionBar$ToolbarCallbackWrapper;->this$0:Landroid/support/v7/internal/app/ToolbarActionBar;

    invoke-static {v1}, Landroid/support/v7/internal/app/ToolbarActionBar;->access$000(Landroid/support/v7/internal/app/ToolbarActionBar;)Landroid/support/v7/internal/app/WindowCallback;

    move-result-object v1

    invoke-interface {v1, p1, v0}, Landroid/support/v7/internal/app/WindowCallback;->onMenuOpened(ILandroid/view/Menu;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 540
    iget-object v1, p0, Landroid/support/v7/internal/app/ToolbarActionBar$ToolbarCallbackWrapper;->this$0:Landroid/support/v7/internal/app/ToolbarActionBar;

    invoke-static {v1, v0}, Landroid/support/v7/internal/app/ToolbarActionBar;->access$600(Landroid/support/v7/internal/app/ToolbarActionBar;Landroid/view/Menu;)Landroid/view/View;

    move-result-object v1

    goto :goto_0

    .line 526
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
    .end packed-switch
.end method

.method public onPreparePanel(ILandroid/view/View;Landroid/view/Menu;)Z
    .locals 3
    .param p1, "featureId"    # I
    .param p2, "view"    # Landroid/view/View;
    .param p3, "menu"    # Landroid/view/Menu;

    .prologue
    .line 516
    invoke-super {p0, p1, p2, p3}, Landroid/support/v7/widget/WindowCallbackWrapper;->onPreparePanel(ILandroid/view/View;Landroid/view/Menu;)Z

    move-result v0

    .line 517
    .local v0, "result":Z
    if-eqz v0, :cond_0

    iget-object v1, p0, Landroid/support/v7/internal/app/ToolbarActionBar$ToolbarCallbackWrapper;->this$0:Landroid/support/v7/internal/app/ToolbarActionBar;

    invoke-static {v1}, Landroid/support/v7/internal/app/ToolbarActionBar;->access$100(Landroid/support/v7/internal/app/ToolbarActionBar;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 518
    iget-object v1, p0, Landroid/support/v7/internal/app/ToolbarActionBar$ToolbarCallbackWrapper;->this$0:Landroid/support/v7/internal/app/ToolbarActionBar;

    invoke-static {v1}, Landroid/support/v7/internal/app/ToolbarActionBar;->access$200(Landroid/support/v7/internal/app/ToolbarActionBar;)Landroid/support/v7/internal/widget/DecorToolbar;

    move-result-object v1

    invoke-interface {v1}, Landroid/support/v7/internal/widget/DecorToolbar;->setMenuPrepared()V

    .line 519
    iget-object v1, p0, Landroid/support/v7/internal/app/ToolbarActionBar$ToolbarCallbackWrapper;->this$0:Landroid/support/v7/internal/app/ToolbarActionBar;

    const/4 v2, 0x1

    invoke-static {v1, v2}, Landroid/support/v7/internal/app/ToolbarActionBar;->access$102(Landroid/support/v7/internal/app/ToolbarActionBar;Z)Z

    .line 521
    :cond_0
    return v0
.end method
