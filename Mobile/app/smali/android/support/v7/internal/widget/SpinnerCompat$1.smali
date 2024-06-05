.class Landroid/support/v7/internal/widget/SpinnerCompat$1;
.super Landroid/support/v7/widget/ListPopupWindow$ForwardingListener;
.source "SpinnerCompat.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Landroid/support/v7/internal/widget/SpinnerCompat;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;II)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Landroid/support/v7/internal/widget/SpinnerCompat;

.field final synthetic val$popup:Landroid/support/v7/internal/widget/SpinnerCompat$DropdownPopup;


# direct methods
.method constructor <init>(Landroid/support/v7/internal/widget/SpinnerCompat;Landroid/view/View;Landroid/support/v7/internal/widget/SpinnerCompat$DropdownPopup;)V
    .locals 0
    .param p2, "x0"    # Landroid/view/View;

    .prologue
    .line 189
    iput-object p1, p0, Landroid/support/v7/internal/widget/SpinnerCompat$1;->this$0:Landroid/support/v7/internal/widget/SpinnerCompat;

    iput-object p3, p0, Landroid/support/v7/internal/widget/SpinnerCompat$1;->val$popup:Landroid/support/v7/internal/widget/SpinnerCompat$DropdownPopup;

    invoke-direct {p0, p2}, Landroid/support/v7/widget/ListPopupWindow$ForwardingListener;-><init>(Landroid/view/View;)V

    return-void
.end method


# virtual methods
.method public getPopup()Landroid/support/v7/widget/ListPopupWindow;
    .locals 1

    .prologue
    .line 192
    iget-object v0, p0, Landroid/support/v7/internal/widget/SpinnerCompat$1;->val$popup:Landroid/support/v7/internal/widget/SpinnerCompat$DropdownPopup;

    return-object v0
.end method

.method public onForwardingStarted()Z
    .locals 1

    .prologue
    .line 197
    iget-object v0, p0, Landroid/support/v7/internal/widget/SpinnerCompat$1;->this$0:Landroid/support/v7/internal/widget/SpinnerCompat;

    invoke-static {v0}, Landroid/support/v7/internal/widget/SpinnerCompat;->access$100(Landroid/support/v7/internal/widget/SpinnerCompat;)Landroid/support/v7/internal/widget/SpinnerCompat$SpinnerPopup;

    move-result-object v0

    invoke-interface {v0}, Landroid/support/v7/internal/widget/SpinnerCompat$SpinnerPopup;->isShowing()Z

    move-result v0

    if-nez v0, :cond_0

    .line 198
    iget-object v0, p0, Landroid/support/v7/internal/widget/SpinnerCompat$1;->this$0:Landroid/support/v7/internal/widget/SpinnerCompat;

    invoke-static {v0}, Landroid/support/v7/internal/widget/SpinnerCompat;->access$100(Landroid/support/v7/internal/widget/SpinnerCompat;)Landroid/support/v7/internal/widget/SpinnerCompat$SpinnerPopup;

    move-result-object v0

    invoke-interface {v0}, Landroid/support/v7/internal/widget/SpinnerCompat$SpinnerPopup;->show()V

    .line 200
    :cond_0
    const/4 v0, 0x1

    return v0
.end method
