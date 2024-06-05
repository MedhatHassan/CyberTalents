.class Landroid/support/v7/internal/widget/ActivityChooserView$Callbacks;
.super Ljava/lang/Object;
.source "ActivityChooserView.java"

# interfaces
.implements Landroid/widget/AdapterView$OnItemClickListener;
.implements Landroid/view/View$OnClickListener;
.implements Landroid/view/View$OnLongClickListener;
.implements Landroid/widget/PopupWindow$OnDismissListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/support/v7/internal/widget/ActivityChooserView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "Callbacks"
.end annotation


# instance fields
.field final synthetic this$0:Landroid/support/v7/internal/widget/ActivityChooserView;


# direct methods
.method private constructor <init>(Landroid/support/v7/internal/widget/ActivityChooserView;)V
    .locals 0

    .prologue
    .line 533
    iput-object p1, p0, Landroid/support/v7/internal/widget/ActivityChooserView$Callbacks;->this$0:Landroid/support/v7/internal/widget/ActivityChooserView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Landroid/support/v7/internal/widget/ActivityChooserView;Landroid/support/v7/internal/widget/ActivityChooserView$1;)V
    .locals 0
    .param p1, "x0"    # Landroid/support/v7/internal/widget/ActivityChooserView;
    .param p2, "x1"    # Landroid/support/v7/internal/widget/ActivityChooserView$1;

    .prologue
    .line 533
    invoke-direct {p0, p1}, Landroid/support/v7/internal/widget/ActivityChooserView$Callbacks;-><init>(Landroid/support/v7/internal/widget/ActivityChooserView;)V

    return-void
.end method

.method private notifyOnDismissListener()V
    .locals 1

    .prologue
    .line 609
    iget-object v0, p0, Landroid/support/v7/internal/widget/ActivityChooserView$Callbacks;->this$0:Landroid/support/v7/internal/widget/ActivityChooserView;

    invoke-static {v0}, Landroid/support/v7/internal/widget/ActivityChooserView;->access$1000(Landroid/support/v7/internal/widget/ActivityChooserView;)Landroid/widget/PopupWindow$OnDismissListener;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 610
    iget-object v0, p0, Landroid/support/v7/internal/widget/ActivityChooserView$Callbacks;->this$0:Landroid/support/v7/internal/widget/ActivityChooserView;

    invoke-static {v0}, Landroid/support/v7/internal/widget/ActivityChooserView;->access$1000(Landroid/support/v7/internal/widget/ActivityChooserView;)Landroid/widget/PopupWindow$OnDismissListener;

    move-result-object v0

    invoke-interface {v0}, Landroid/widget/PopupWindow$OnDismissListener;->onDismiss()V

    .line 612
    :cond_0
    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 5
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 569
    iget-object v3, p0, Landroid/support/v7/internal/widget/ActivityChooserView$Callbacks;->this$0:Landroid/support/v7/internal/widget/ActivityChooserView;

    invoke-static {v3}, Landroid/support/v7/internal/widget/ActivityChooserView;->access$700(Landroid/support/v7/internal/widget/ActivityChooserView;)Landroid/widget/FrameLayout;

    move-result-object v3

    if-ne p1, v3, :cond_1

    .line 570
    iget-object v3, p0, Landroid/support/v7/internal/widget/ActivityChooserView$Callbacks;->this$0:Landroid/support/v7/internal/widget/ActivityChooserView;

    invoke-virtual {v3}, Landroid/support/v7/internal/widget/ActivityChooserView;->dismissPopup()Z

    .line 571
    iget-object v3, p0, Landroid/support/v7/internal/widget/ActivityChooserView$Callbacks;->this$0:Landroid/support/v7/internal/widget/ActivityChooserView;

    invoke-static {v3}, Landroid/support/v7/internal/widget/ActivityChooserView;->access$000(Landroid/support/v7/internal/widget/ActivityChooserView;)Landroid/support/v7/internal/widget/ActivityChooserView$ActivityChooserViewAdapter;

    move-result-object v3

    invoke-virtual {v3}, Landroid/support/v7/internal/widget/ActivityChooserView$ActivityChooserViewAdapter;->getDefaultActivity()Landroid/content/pm/ResolveInfo;

    move-result-object v0

    .line 572
    .local v0, "defaultActivity":Landroid/content/pm/ResolveInfo;
    iget-object v3, p0, Landroid/support/v7/internal/widget/ActivityChooserView$Callbacks;->this$0:Landroid/support/v7/internal/widget/ActivityChooserView;

    invoke-static {v3}, Landroid/support/v7/internal/widget/ActivityChooserView;->access$000(Landroid/support/v7/internal/widget/ActivityChooserView;)Landroid/support/v7/internal/widget/ActivityChooserView$ActivityChooserViewAdapter;

    move-result-object v3

    invoke-virtual {v3}, Landroid/support/v7/internal/widget/ActivityChooserView$ActivityChooserViewAdapter;->getDataModel()Landroid/support/v7/internal/widget/ActivityChooserModel;

    move-result-object v3

    invoke-virtual {v3, v0}, Landroid/support/v7/internal/widget/ActivityChooserModel;->getActivityIndex(Landroid/content/pm/ResolveInfo;)I

    move-result v1

    .line 573
    .local v1, "index":I
    iget-object v3, p0, Landroid/support/v7/internal/widget/ActivityChooserView$Callbacks;->this$0:Landroid/support/v7/internal/widget/ActivityChooserView;

    invoke-static {v3}, Landroid/support/v7/internal/widget/ActivityChooserView;->access$000(Landroid/support/v7/internal/widget/ActivityChooserView;)Landroid/support/v7/internal/widget/ActivityChooserView$ActivityChooserViewAdapter;

    move-result-object v3

    invoke-virtual {v3}, Landroid/support/v7/internal/widget/ActivityChooserView$ActivityChooserViewAdapter;->getDataModel()Landroid/support/v7/internal/widget/ActivityChooserModel;

    move-result-object v3

    invoke-virtual {v3, v1}, Landroid/support/v7/internal/widget/ActivityChooserModel;->chooseActivity(I)Landroid/content/Intent;

    move-result-object v2

    .line 574
    .local v2, "launchIntent":Landroid/content/Intent;
    if-eqz v2, :cond_0

    .line 575
    const/high16 v3, 0x80000

    invoke-virtual {v2, v3}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 576
    iget-object v3, p0, Landroid/support/v7/internal/widget/ActivityChooserView$Callbacks;->this$0:Landroid/support/v7/internal/widget/ActivityChooserView;

    invoke-virtual {v3}, Landroid/support/v7/internal/widget/ActivityChooserView;->getContext()Landroid/content/Context;

    move-result-object v3

    invoke-virtual {v3, v2}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    .line 584
    .end local v0    # "defaultActivity":Landroid/content/pm/ResolveInfo;
    .end local v1    # "index":I
    .end local v2    # "launchIntent":Landroid/content/Intent;
    :cond_0
    :goto_0
    return-void

    .line 578
    :cond_1
    iget-object v3, p0, Landroid/support/v7/internal/widget/ActivityChooserView$Callbacks;->this$0:Landroid/support/v7/internal/widget/ActivityChooserView;

    invoke-static {v3}, Landroid/support/v7/internal/widget/ActivityChooserView;->access$800(Landroid/support/v7/internal/widget/ActivityChooserView;)Landroid/widget/FrameLayout;

    move-result-object v3

    if-ne p1, v3, :cond_2

    .line 579
    iget-object v3, p0, Landroid/support/v7/internal/widget/ActivityChooserView$Callbacks;->this$0:Landroid/support/v7/internal/widget/ActivityChooserView;

    const/4 v4, 0x0

    invoke-static {v3, v4}, Landroid/support/v7/internal/widget/ActivityChooserView;->access$602(Landroid/support/v7/internal/widget/ActivityChooserView;Z)Z

    .line 580
    iget-object v3, p0, Landroid/support/v7/internal/widget/ActivityChooserView$Callbacks;->this$0:Landroid/support/v7/internal/widget/ActivityChooserView;

    iget-object v4, p0, Landroid/support/v7/internal/widget/ActivityChooserView$Callbacks;->this$0:Landroid/support/v7/internal/widget/ActivityChooserView;

    invoke-static {v4}, Landroid/support/v7/internal/widget/ActivityChooserView;->access$900(Landroid/support/v7/internal/widget/ActivityChooserView;)I

    move-result v4

    invoke-static {v3, v4}, Landroid/support/v7/internal/widget/ActivityChooserView;->access$500(Landroid/support/v7/internal/widget/ActivityChooserView;I)V

    goto :goto_0

    .line 582
    :cond_2
    new-instance v3, Ljava/lang/IllegalArgumentException;

    invoke-direct {v3}, Ljava/lang/IllegalArgumentException;-><init>()V

    throw v3
.end method

.method public onDismiss()V
    .locals 2

    .prologue
    .line 602
    invoke-direct {p0}, Landroid/support/v7/internal/widget/ActivityChooserView$Callbacks;->notifyOnDismissListener()V

    .line 603
    iget-object v0, p0, Landroid/support/v7/internal/widget/ActivityChooserView$Callbacks;->this$0:Landroid/support/v7/internal/widget/ActivityChooserView;

    iget-object v0, v0, Landroid/support/v7/internal/widget/ActivityChooserView;->mProvider:Landroid/support/v4/view/ActionProvider;

    if-eqz v0, :cond_0

    .line 604
    iget-object v0, p0, Landroid/support/v7/internal/widget/ActivityChooserView$Callbacks;->this$0:Landroid/support/v7/internal/widget/ActivityChooserView;

    iget-object v0, v0, Landroid/support/v7/internal/widget/ActivityChooserView;->mProvider:Landroid/support/v4/view/ActionProvider;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/support/v4/view/ActionProvider;->subUiVisibilityChanged(Z)V

    .line 606
    :cond_0
    return-void
.end method

.method public onItemClick(Landroid/widget/AdapterView;Landroid/view/View;IJ)V
    .locals 5
    .param p2, "view"    # Landroid/view/View;
    .param p3, "position"    # I
    .param p4, "id"    # J
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/widget/AdapterView",
            "<*>;",
            "Landroid/view/View;",
            "IJ)V"
        }
    .end annotation

    .prologue
    .line 538
    .local p1, "parent":Landroid/widget/AdapterView;, "Landroid/widget/AdapterView<*>;"
    invoke-virtual {p1}, Landroid/widget/AdapterView;->getAdapter()Landroid/widget/Adapter;

    move-result-object v0

    check-cast v0, Landroid/support/v7/internal/widget/ActivityChooserView$ActivityChooserViewAdapter;

    .line 539
    .local v0, "adapter":Landroid/support/v7/internal/widget/ActivityChooserView$ActivityChooserViewAdapter;
    invoke-virtual {v0, p3}, Landroid/support/v7/internal/widget/ActivityChooserView$ActivityChooserViewAdapter;->getItemViewType(I)I

    move-result v1

    .line 540
    .local v1, "itemViewType":I
    packed-switch v1, :pswitch_data_0

    .line 563
    new-instance v3, Ljava/lang/IllegalArgumentException;

    invoke-direct {v3}, Ljava/lang/IllegalArgumentException;-><init>()V

    throw v3

    .line 542
    :pswitch_0
    iget-object v3, p0, Landroid/support/v7/internal/widget/ActivityChooserView$Callbacks;->this$0:Landroid/support/v7/internal/widget/ActivityChooserView;

    const v4, 0x7fffffff

    invoke-static {v3, v4}, Landroid/support/v7/internal/widget/ActivityChooserView;->access$500(Landroid/support/v7/internal/widget/ActivityChooserView;I)V

    .line 565
    :cond_0
    :goto_0
    return-void

    .line 545
    :pswitch_1
    iget-object v3, p0, Landroid/support/v7/internal/widget/ActivityChooserView$Callbacks;->this$0:Landroid/support/v7/internal/widget/ActivityChooserView;

    invoke-virtual {v3}, Landroid/support/v7/internal/widget/ActivityChooserView;->dismissPopup()Z

    .line 546
    iget-object v3, p0, Landroid/support/v7/internal/widget/ActivityChooserView$Callbacks;->this$0:Landroid/support/v7/internal/widget/ActivityChooserView;

    invoke-static {v3}, Landroid/support/v7/internal/widget/ActivityChooserView;->access$600(Landroid/support/v7/internal/widget/ActivityChooserView;)Z

    move-result v3

    if-eqz v3, :cond_1

    .line 548
    if-lez p3, :cond_0

    .line 549
    iget-object v3, p0, Landroid/support/v7/internal/widget/ActivityChooserView$Callbacks;->this$0:Landroid/support/v7/internal/widget/ActivityChooserView;

    invoke-static {v3}, Landroid/support/v7/internal/widget/ActivityChooserView;->access$000(Landroid/support/v7/internal/widget/ActivityChooserView;)Landroid/support/v7/internal/widget/ActivityChooserView$ActivityChooserViewAdapter;

    move-result-object v3

    invoke-virtual {v3}, Landroid/support/v7/internal/widget/ActivityChooserView$ActivityChooserViewAdapter;->getDataModel()Landroid/support/v7/internal/widget/ActivityChooserModel;

    move-result-object v3

    invoke-virtual {v3, p3}, Landroid/support/v7/internal/widget/ActivityChooserModel;->setDefaultActivity(I)V

    goto :goto_0

    .line 554
    :cond_1
    iget-object v3, p0, Landroid/support/v7/internal/widget/ActivityChooserView$Callbacks;->this$0:Landroid/support/v7/internal/widget/ActivityChooserView;

    invoke-static {v3}, Landroid/support/v7/internal/widget/ActivityChooserView;->access$000(Landroid/support/v7/internal/widget/ActivityChooserView;)Landroid/support/v7/internal/widget/ActivityChooserView$ActivityChooserViewAdapter;

    move-result-object v3

    invoke-virtual {v3}, Landroid/support/v7/internal/widget/ActivityChooserView$ActivityChooserViewAdapter;->getShowDefaultActivity()Z

    move-result v3

    if-eqz v3, :cond_2

    .line 555
    :goto_1
    iget-object v3, p0, Landroid/support/v7/internal/widget/ActivityChooserView$Callbacks;->this$0:Landroid/support/v7/internal/widget/ActivityChooserView;

    invoke-static {v3}, Landroid/support/v7/internal/widget/ActivityChooserView;->access$000(Landroid/support/v7/internal/widget/ActivityChooserView;)Landroid/support/v7/internal/widget/ActivityChooserView$ActivityChooserViewAdapter;

    move-result-object v3

    invoke-virtual {v3}, Landroid/support/v7/internal/widget/ActivityChooserView$ActivityChooserViewAdapter;->getDataModel()Landroid/support/v7/internal/widget/ActivityChooserModel;

    move-result-object v3

    invoke-virtual {v3, p3}, Landroid/support/v7/internal/widget/ActivityChooserModel;->chooseActivity(I)Landroid/content/Intent;

    move-result-object v2

    .line 556
    .local v2, "launchIntent":Landroid/content/Intent;
    if-eqz v2, :cond_0

    .line 557
    const/high16 v3, 0x80000

    invoke-virtual {v2, v3}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 558
    iget-object v3, p0, Landroid/support/v7/internal/widget/ActivityChooserView$Callbacks;->this$0:Landroid/support/v7/internal/widget/ActivityChooserView;

    invoke-virtual {v3}, Landroid/support/v7/internal/widget/ActivityChooserView;->getContext()Landroid/content/Context;

    move-result-object v3

    invoke-virtual {v3, v2}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    goto :goto_0

    .line 554
    .end local v2    # "launchIntent":Landroid/content/Intent;
    :cond_2
    add-int/lit8 p3, p3, 0x1

    goto :goto_1

    .line 540
    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method

.method public onLongClick(Landroid/view/View;)Z
    .locals 3
    .param p1, "view"    # Landroid/view/View;

    .prologue
    const/4 v2, 0x1

    .line 589
    iget-object v0, p0, Landroid/support/v7/internal/widget/ActivityChooserView$Callbacks;->this$0:Landroid/support/v7/internal/widget/ActivityChooserView;

    invoke-static {v0}, Landroid/support/v7/internal/widget/ActivityChooserView;->access$700(Landroid/support/v7/internal/widget/ActivityChooserView;)Landroid/widget/FrameLayout;

    move-result-object v0

    if-ne p1, v0, :cond_1

    .line 590
    iget-object v0, p0, Landroid/support/v7/internal/widget/ActivityChooserView$Callbacks;->this$0:Landroid/support/v7/internal/widget/ActivityChooserView;

    invoke-static {v0}, Landroid/support/v7/internal/widget/ActivityChooserView;->access$000(Landroid/support/v7/internal/widget/ActivityChooserView;)Landroid/support/v7/internal/widget/ActivityChooserView$ActivityChooserViewAdapter;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v7/internal/widget/ActivityChooserView$ActivityChooserViewAdapter;->getCount()I

    move-result v0

    if-lez v0, :cond_0

    .line 591
    iget-object v0, p0, Landroid/support/v7/internal/widget/ActivityChooserView$Callbacks;->this$0:Landroid/support/v7/internal/widget/ActivityChooserView;

    invoke-static {v0, v2}, Landroid/support/v7/internal/widget/ActivityChooserView;->access$602(Landroid/support/v7/internal/widget/ActivityChooserView;Z)Z

    .line 592
    iget-object v0, p0, Landroid/support/v7/internal/widget/ActivityChooserView$Callbacks;->this$0:Landroid/support/v7/internal/widget/ActivityChooserView;

    iget-object v1, p0, Landroid/support/v7/internal/widget/ActivityChooserView$Callbacks;->this$0:Landroid/support/v7/internal/widget/ActivityChooserView;

    invoke-static {v1}, Landroid/support/v7/internal/widget/ActivityChooserView;->access$900(Landroid/support/v7/internal/widget/ActivityChooserView;)I

    move-result v1

    invoke-static {v0, v1}, Landroid/support/v7/internal/widget/ActivityChooserView;->access$500(Landroid/support/v7/internal/widget/ActivityChooserView;I)V

    .line 597
    :cond_0
    return v2

    .line 595
    :cond_1
    new-instance v0, Ljava/lang/IllegalArgumentException;

    invoke-direct {v0}, Ljava/lang/IllegalArgumentException;-><init>()V

    throw v0
.end method
