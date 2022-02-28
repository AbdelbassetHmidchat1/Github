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
    public partial class Createcontactpanel : Form
    {
        private DataTable phonebook;
        public Createcontactpanel(DataTable phonebook)
        {
            InitializeComponent();
            this.phonebook = phonebook;
            while (!phonebook.Columns.Contains("First Name")) 
            {
                Addcolumn();
            }

        }
        public void Addcolumn()
        {
            phonebook.Columns.Add("First Name");
            phonebook.Columns.Add("Last Name");
            phonebook.Columns.Add("Phone Number");
            phonebook.Columns.Add("Email");

        }
        public void ResetTextboxes()
        {
            textBox1.Text = "";
            textBox2.Text = "";
            textBox3.Text = "";
            textBox4.Text = "";

        }

        private void button1_Click(object sender, EventArgs e)
        {
            Button btn = (Button)sender;
            ResetTextboxes();
            


        }
        
        private void button2_Click(object sender, EventArgs e)
        {
            Button btn = (Button)sender;
            DataRow row = phonebook.NewRow();
            row[0] = textBox1.Text;
            row[1] = textBox2.Text;
            row[2] = textBox3.Text;
            row[3] = textBox4.Text;
            phonebook.Rows.Add(row);
            MessageBox.Show("Contact succesfully added");
            ResetTextboxes();

            


        }
    }
}
