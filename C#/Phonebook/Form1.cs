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

    public partial class Form1 : Form
    {
        DataTable phonebook = new DataTable();

       
        public Form1()
        {
            InitializeComponent();
        }

        private void panel1_Paint(object sender, PaintEventArgs e)
        {

        }

        private void button3_Click(object sender, EventArgs e)
        {
            loadform(new Dialpanel());
        }

        private void panelheader_Paint(object sender, PaintEventArgs e)
        {

        }

        private void button1_Click(object sender, EventArgs e)
        {
            loadform(new Showcontacts(this.phonebook));
        }

        private void button2_Click(object sender, EventArgs e)
        {
            loadform(new Deletecontactpanel(this.phonebook));
        }

        private void panel1_Paint_1(object sender, PaintEventArgs e)
        {

        }

        private void button4_Click(object sender, EventArgs e)
        {
            loadform(new Createcontactpanel(this.phonebook));
        }

        private void pictureBox1_Click(object sender, EventArgs e)
        {

        }
        private void loadform(object Form)
        {
            if(this.mainpanel.Controls.Count > 0)
                this.mainpanel.Controls.RemoveAt(0);
            Form f = Form as Form;
            f.TopLevel = false;
            f.Dock = DockStyle.Fill;   
            this.mainpanel.Controls.Add(f); 
            this.mainpanel.Tag = f;
            f.Show();
        }
    }
}
