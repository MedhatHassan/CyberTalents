.class Lcom/labs/adnromeda/test1/MainActivity$1;
.super Ljava/lang/Object;
.source "MainActivity.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/labs/adnromeda/test1/MainActivity;->onCreate(Landroid/os/Bundle;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/labs/adnromeda/test1/MainActivity;

.field final synthetic val$txtPassword:Landroid/widget/EditText;

.field final synthetic val$txtUsername:Landroid/widget/EditText;


# direct methods
.method constructor <init>(Lcom/labs/adnromeda/test1/MainActivity;Landroid/widget/EditText;Landroid/widget/EditText;)V
    .locals 0

    .prologue
    .line 43
    iput-object p1, p0, Lcom/labs/adnromeda/test1/MainActivity$1;->this$0:Lcom/labs/adnromeda/test1/MainActivity;

    iput-object p2, p0, Lcom/labs/adnromeda/test1/MainActivity$1;->val$txtUsername:Landroid/widget/EditText;

    iput-object p3, p0, Lcom/labs/adnromeda/test1/MainActivity$1;->val$txtPassword:Landroid/widget/EditText;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 7
    .param p1, "v"    # Landroid/view/View;

    .prologue
    const/4 v6, 0x0

    .line 48
    iget-object v3, p0, Lcom/labs/adnromeda/test1/MainActivity$1;->val$txtUsername:Landroid/widget/EditText;

    invoke-virtual {v3}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v2

    .line 49
    .local v2, "user":Ljava/lang/String;
    iget-object v3, p0, Lcom/labs/adnromeda/test1/MainActivity$1;->val$txtPassword:Landroid/widget/EditText;

    invoke-virtual {v3}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    .line 51
    .local v1, "pass":Ljava/lang/String;
    const-string v3, "credentials check"

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v4, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, ":"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 53
    iget-object v3, p0, Lcom/labs/adnromeda/test1/MainActivity$1;->this$0:Lcom/labs/adnromeda/test1/MainActivity;

    invoke-static {v3}, Lcom/labs/adnromeda/test1/MainActivity;->access$000(Lcom/labs/adnromeda/test1/MainActivity;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/String;->compareTo(Ljava/lang/String;)I

    move-result v3

    if-nez v3, :cond_0

    iget-object v3, p0, Lcom/labs/adnromeda/test1/MainActivity$1;->this$0:Lcom/labs/adnromeda/test1/MainActivity;

    invoke-static {v3}, Lcom/labs/adnromeda/test1/MainActivity;->access$100(Lcom/labs/adnromeda/test1/MainActivity;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Ljava/lang/String;->compareTo(Ljava/lang/String;)I

    move-result v3

    if-nez v3, :cond_0

    .line 55
    const-string v3, "credentials check"

    const-string v4, "granted access"

    invoke-static {v3, v4}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 58
    iget-object v3, p0, Lcom/labs/adnromeda/test1/MainActivity$1;->this$0:Lcom/labs/adnromeda/test1/MainActivity;

    invoke-virtual {v3}, Lcom/labs/adnromeda/test1/MainActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v3

    const-string v4, "access granted!"

    invoke-static {v3, v4, v6}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v3

    invoke-virtual {v3}, Landroid/widget/Toast;->show()V

    .line 59
    new-instance v0, Landroid/content/Intent;

    iget-object v3, p0, Lcom/labs/adnromeda/test1/MainActivity$1;->this$0:Lcom/labs/adnromeda/test1/MainActivity;

    invoke-virtual {v3}, Lcom/labs/adnromeda/test1/MainActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v3

    const-class v4, Lcom/labs/adnromeda/test1/MainActivity2;

    invoke-direct {v0, v3, v4}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 60
    .local v0, "intent":Landroid/content/Intent;
    iget-object v3, p0, Lcom/labs/adnromeda/test1/MainActivity$1;->this$0:Lcom/labs/adnromeda/test1/MainActivity;

    invoke-virtual {v3, v0}, Lcom/labs/adnromeda/test1/MainActivity;->startActivity(Landroid/content/Intent;)V

    .line 65
    .end local v0    # "intent":Landroid/content/Intent;
    :goto_0
    return-void

    .line 63
    :cond_0
    iget-object v3, p0, Lcom/labs/adnromeda/test1/MainActivity$1;->this$0:Lcom/labs/adnromeda/test1/MainActivity;

    invoke-virtual {v3}, Lcom/labs/adnromeda/test1/MainActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v3

    const-string v4, "access denied!"

    invoke-static {v3, v4, v6}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v3

    invoke-virtual {v3}, Landroid/widget/Toast;->show()V

    goto :goto_0
.end method
