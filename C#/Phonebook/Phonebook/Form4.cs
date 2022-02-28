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

    public partial class Deletecontactpanel : Form
    {
        private DataTable phonebook;

        public Deletecontactpanel(DataTable phonebook)
        {
            InitializeComponent();
            this.phonebook = phonebook;
        }

        private void textBox1_TextChanged(object sender, EventArgs e)
        {

        }

        private void button1_Click(object sender, EventArgs e)
        {
            phonebook.AcceptChanges();

            foreach (DataRow dr in phonebook.Rows)
            {
                if (dr["First Name"].ToString() == textBox1.Text)
                {
                    dr.Delete();
                    MessageBox.Show("Contact deleted succesfully");
                }

                else
                {
                    MessageBox.Show("Contact not found");
                }

            }
            phonebook.AcceptChanges();

        }
    }
}
