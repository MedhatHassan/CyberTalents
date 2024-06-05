using System;
using System.CodeDom.Compiler;
using System.ComponentModel;
using System.Diagnostics;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Markup;

namespace FirstWPFApp
{
  public class MainWindow : Window, IComponentConnector
  {
    public char[] Letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ{}_".ToCharArray();
    internal TextBox TextBox1;
    internal Button Button1;
    private bool _contentLoaded;

    public MainWindow() => this.InitializeComponent();

    private void Button_Click(object sender, RoutedEventArgs e)
    {
      if (!this.TextBox1.Text.Equals(new string(new char[5]
      {
        this.Letters[5],
        this.Letters[14],
        this.Letters[13],
        this.Letters[25],
        this.Letters[24]
      })))
        return;
      int num = (int) MessageBox.Show(new string(new char[18]
      {
        this.Letters[5],
        this.Letters[11],
        this.Letters[0],
        this.Letters[6],
        this.Letters[26],
        this.Letters[8],
        this.Letters[28],
        this.Letters[11],
        this.Letters[14],
        this.Letters[21],
        this.Letters[4],
        this.Letters[28],
        this.Letters[5],
        this.Letters[14],
        this.Letters[13],
        this.Letters[25],
        this.Letters[24],
        this.Letters[27]
      }));
    }

    [DebuggerNonUserCode]
    [GeneratedCode("PresentationBuildTasks", "4.0.0.0")]
    public void InitializeComponent()
    {
      if (this._contentLoaded)
        return;
      this._contentLoaded = true;
      Application.LoadComponent((object) this, new Uri("/FirstWPFApp;component/mainwindow.xaml", UriKind.Relative));
    }

    [DebuggerNonUserCode]
    [GeneratedCode("PresentationBuildTasks", "4.0.0.0")]
    [EditorBrowsable(EditorBrowsableState.Never)]
    void IComponentConnector.Connect(int connectionId, object target)
    {
      if (connectionId != 1)
      {
        if (connectionId == 2)
        {
          this.Button1 = (Button) target;
          this.Button1.Click += new RoutedEventHandler(this.Button_Click);
        }
        else
          this._contentLoaded = true;
      }
      else
        this.TextBox1 = (TextBox) target;
    }
  }
}
