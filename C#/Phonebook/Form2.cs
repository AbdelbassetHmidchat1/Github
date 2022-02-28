using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Phonebook
{
    public partial class Dialpanel : Form
    {
        public Dialpanel()
        {
            InitializeComponent();
        }

        private void button11_Click(object sender, EventArgs e)
        {
            Button btn = (Button)sender;
            label1.Text += btn.Text;


        }

        private void button2_Click(object sender, EventArgs e)
        {
            Button btn = (Button)sender;
            label1.Text += btn.Text;



        }

        private void button1_Click(object sender, EventArgs e)
        {
            Button btn = (Button)sender;
            label1.Text += btn.Text;



        }

        private void button3_Click(object sender, EventArgs e)
        {
            Button btn = (Button)sender;
            label1.Text += btn.Text;



        }

        private void button5_Click(object sender, EventArgs e)
        {
            Button btn = (Button)sender;
            label1.Text += btn.Text;



        }

        private void button6_Click(object sender, EventArgs e)
        {
            Button btn = (Button)sender;
            label1.Text += btn.Text;


        }

        private void button4_Click(object sender, EventArgs e)
        {
            Button btn = (Button)sender;
            label1.Text += btn.Text;


        }

        private void button8_Click(object sender, EventArgs e)
        {
            Button btn = (Button)sender;
            label1.Text += btn.Text;


        }

        private void button9_Click(object sender, EventArgs e)
        {
            Button btn = (Button)sender;
            label1.Text += btn.Text;


        }

        private void button7_Click(object sender, EventArgs e)
        {
            Button btn = (Button)sender;
            label1.Text += btn.Text;


        }

        private void button12_Click(object sender, EventArgs e)
        {
            Button btn = (Button)sender;
            label1.Text += btn.Text;


        }

        private void button10_Click(object sender, EventArgs e)
        {
            Button btn = (Button)sender;
            label1.Text += btn.Text;

        }

        private void button13_Click(object sender, EventArgs e)
        {
            Button btn = (Button)sender;
            MessageBox.Show("Dialing");

        }

        private void button14_Click(object sender, EventArgs e)
        {
            Button btn = (Button)sender;
            while (label1.Text.Length > 0) { 
            string result = label1.Text.Substring(0, label1.Text.Length-1);
            label1.Text = result;
            }









        }

        private void Dialpanel_Load(object sender, EventArgs e)
        {

        }

        private void label1_Click(object sender, EventArgs e)
        {

        }
    }
}
