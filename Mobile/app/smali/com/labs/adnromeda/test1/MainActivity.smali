.class public Lcom/labs/adnromeda/test1/MainActivity;
.super Landroid/support/v7/app/ActionBarActivity;
.source "MainActivity.java"


# instance fields
.field public weezy:I


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 16
    invoke-direct {p0}, Landroid/support/v7/app/ActionBarActivity;-><init>()V

    .line 18
    const/16 v0, 0x98

    iput v0, p0, Lcom/labs/adnromeda/test1/MainActivity;->weezy:I

    return-void
.end method

.method static synthetic access$000(Lcom/labs/adnromeda/test1/MainActivity;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/labs/adnromeda/test1/MainActivity;

    .prologue
    .line 16
    invoke-direct {p0}, Lcom/labs/adnromeda/test1/MainActivity;->getUser()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$100(Lcom/labs/adnromeda/test1/MainActivity;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/labs/adnromeda/test1/MainActivity;

    .prologue
    .line 16
    invoke-direct {p0}, Lcom/labs/adnromeda/test1/MainActivity;->getPass()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method private getPass()Ljava/lang/String;
    .locals 2

    .prologue
    .line 29
    iget v0, p0, Lcom/labs/adnromeda/test1/MainActivity;->weezy:I

    const/16 v1, 0x98

    if-le v0, v1, :cond_0

    const-string v0, "Saruman"

    :goto_0
    return-object v0

    :cond_0
    const-string v0, "Gandalf"

    goto :goto_0
.end method

.method private getUser()Ljava/lang/String;
    .locals 3

    .prologue
    .line 21
    iget v1, p0, Lcom/labs/adnromeda/test1/MainActivity;->weezy:I

    const/16 v2, 0x98

    if-le v1, v2, :cond_0

    const-string v0, "Legolas"

    .line 22
    .local v0, "resp":Ljava/lang/String;
    :goto_0
    iget v1, p0, Lcom/labs/adnromeda/test1/MainActivity;->weezy:I

    add-int/lit8 v1, v1, 0x64

    iput v1, p0, Lcom/labs/adnromeda/test1/MainActivity;->weezy:I

    .line 23
    return-object v0

    .line 21
    .end local v0    # "resp":Ljava/lang/String;
    :cond_0
    const-string v0, "Aragon"

    goto :goto_0
.end method


# virtual methods
.method protected onCreate(Landroid/os/Bundle;)V
    .locals 4
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 34
    invoke-super {p0, p1}, Landroid/support/v7/app/ActionBarActivity;->onCreate(Landroid/os/Bundle;)V

    .line 35
    const v3, 0x7f030017

    invoke-virtual {p0, v3}, Lcom/labs/adnromeda/test1/MainActivity;->setContentView(I)V

    .line 37
    const v3, 0x7f0b0041

    invoke-virtual {p0, v3}, Lcom/labs/adnromeda/test1/MainActivity;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/EditText;

    .line 38
    .local v2, "txtUsername":Landroid/widget/EditText;
    const v3, 0x7f0b0042

    invoke-virtual {p0, v3}, Lcom/labs/adnromeda/test1/MainActivity;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/EditText;

    .line 40
    .local v1, "txtPassword":Landroid/widget/EditText;
    const v3, 0x7f0b0043

    invoke-virtual {p0, v3}, Lcom/labs/adnromeda/test1/MainActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    .line 43
    .local v0, "button":Landroid/widget/Button;
    new-instance v3, Lcom/labs/adnromeda/test1/MainActivity$1;

    invoke-direct {v3, p0, v2, v1}, Lcom/labs/adnromeda/test1/MainActivity$1;-><init>(Lcom/labs/adnromeda/test1/MainActivity;Landroid/widget/EditText;Landroid/widget/EditText;)V

    invoke-virtual {v0, v3}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 68
    return-void
.end method

.method public onCreateOptionsMenu(Landroid/view/Menu;)Z
    .locals 2
    .param p1, "menu"    # Landroid/view/Menu;

    .prologue
    .line 74
    invoke-virtual {p0}, Lcom/labs/adnromeda/test1/MainActivity;->getMenuInflater()Landroid/view/MenuInflater;

    move-result-object v0

    const/high16 v1, 0x7f0c0000

    invoke-virtual {v0, v1, p1}, Landroid/view/MenuInflater;->inflate(ILandroid/view/Menu;)V

    .line 75
    const/4 v0, 0x1

    return v0
.end method

.method public onOptionsItemSelected(Landroid/view/MenuItem;)Z
    .locals 2
    .param p1, "item"    # Landroid/view/MenuItem;

    .prologue
    .line 83
    invoke-interface {p1}, Landroid/view/MenuItem;->getItemId()I

    move-result v0

    .line 86
    .local v0, "id":I
    const v1, 0x7f0b0046

    if-ne v0, v1, :cond_0

    .line 87
    const/4 v1, 0x1

    .line 90
    :goto_0
    return v1

    :cond_0
    invoke-super {p0, p1}, Landroid/support/v7/app/ActionBarActivity;->onOptionsItemSelected(Landroid/view/MenuItem;)Z

    move-result v1

    goto :goto_0
.end method
