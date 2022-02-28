using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Text.RegularExpressions;

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
        public void ResetLabels()
        {
            label5.Text = "";
            label6.Text = "";
            label7.Text = "";
            label8.Text = "";
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

            if(Regex.IsMatch(textBox1.Text, @"^^([a-z]|[A-Z]){4,}$"))
            {
                label5.Text = "";

            }
            else
            {
                label5.Text = "name must contain at least 4 letters and must be only in letters  ";
            }
            if (Regex.IsMatch(textBox2.Text, @"^^([a-z]|[A-Z]){4,}"))
            {
                label6.Text = "";

            }
            else
            {
                label6.Text = "name must contain at least 4 letters and must be only in letters  ";
            }
            if (Regex.IsMatch(textBox3.Text, @"^^(06|07)\d{8}$"))
            {
                label7.Text = "";

            }
            else
            {
                label7.Text = "the format of the phone number is incorrect ";
            }
            if (Regex.IsMatch(textBox4.Text, @"^^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$"))
            {
                label8.Text = "";


            }
            else
            {
                label8.Text = "the format of the email is incorrect ";
            }
            if (label5.Text == "" && label6.Text == "" && label7.Text == ""  && label8.Text == "")
            {
                row[0] = textBox1.Text;
                row[1] = textBox2.Text;
                row[2] = textBox3.Text;
                row[3] = textBox4.Text;




                phonebook.Rows.Add(row);
                MessageBox.Show("Contact succesfully added");
                ResetTextboxes();
                ResetLabels();



            }
            else
            {
                MessageBox.Show("retry again");
                ResetTextboxes();
                ResetLabels();
            }


            


        }

        private void Createcontactpanel_Load(object sender, EventArgs e)
        {

        }
    }
}
