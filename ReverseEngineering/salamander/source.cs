using System;
using System.ComponentModel;
using System.Drawing;
using System.Windows.Forms;

namespace Challenge
{
  public class Form1 : Form
  {
    private IContainer components;
    private Button button1;
    private Label label1;
    private TextBox textBox1;

    public Form1() => this.InitializeComponent();

    private void Form1_Load(object sender, EventArgs e)
    {
    }

    private void label1_Click(object sender, EventArgs e)
    {
    }

    private void button1_Click(object sender, EventArgs e)
    {
      try
      {
        if (this.textBox1.Text == Environment.UserName)
        {
          int num1 = (int) MessageBox.Show(string.Format("FLAG{0}", (object) "{0_54l4m4nd3r_0}"));
        }
        else
        {
          int num2 = (int) MessageBox.Show("Unvalid Password");
        }
      }
      catch (Exception ex)
      {
        int num = (int) MessageBox.Show(ex.Message);
      }
    }

    private void textBox1_TextChanged(object sender, EventArgs e)
    {
    }

    protected override void Dispose(bool disposing)
    {
      if (disposing && this.components != null)
        this.components.Dispose();
      base.Dispose(disposing);
    }

    private void InitializeComponent()
    {
      this.button1 = new Button();
      this.label1 = new Label();
      this.textBox1 = new TextBox();
      this.SuspendLayout();
      this.button1.Location = new Point(133, 112);
      this.button1.Name = "button1";
      this.button1.Size = new Size(100, 23);
      this.button1.TabIndex = 0;
      this.button1.Text = "Login";
      this.button1.UseVisualStyleBackColor = true;
      this.button1.Click += new EventHandler(this.button1_Click);
      this.label1.AutoSize = true;
      this.label1.Location = new Point(28, 67);
      this.label1.Name = "label1";
      this.label1.Size = new Size(99, 13);
      this.label1.TabIndex = 1;
      this.label1.Text = "Enter the Password";
      this.label1.Click += new EventHandler(this.label1_Click);
      this.textBox1.Location = new Point(133, 64);
      this.textBox1.Name = "textBox1";
      this.textBox1.Size = new Size(100, 20);
      this.textBox1.TabIndex = 2;
      this.textBox1.TextChanged += new EventHandler(this.textBox1_TextChanged);
      this.AutoScaleDimensions = new SizeF(6f, 13f);
      this.AutoScaleMode = AutoScaleMode.Font;
      this.ClientSize = new Size(429, 196);
      this.Controls.Add((Control) this.textBox1);
      this.Controls.Add((Control) this.label1);
      this.Controls.Add((Control) this.button1);
      this.Name = nameof (Form1);
      this.Text = "CyberTalents ";
      this.Load += new EventHandler(this.Form1_Load);
      this.ResumeLayout(false);
      this.PerformLayout();
    }
  }
}
