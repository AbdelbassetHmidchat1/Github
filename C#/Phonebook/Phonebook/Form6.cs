﻿using System;
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

    public partial class Showcontacts : Form
    {
        private DataTable phonebook;




        public Showcontacts(DataTable phonebook)
        {
            InitializeComponent();
            this.phonebook = phonebook;
            dataGridView1.DataSource = phonebook;


        }





        private void dataGridView1_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {

        }
    }
}
