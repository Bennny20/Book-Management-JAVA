package ui;

import dao.ListBook;
import dto.Book;
import java.awt.event.ItemEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class UIBookManagement extends javax.swing.JFrame {

    ListBook listBook = null;

    boolean addNewBook = false;

    int indexItem[] = {0, 1, 2, 3, 4, 5};
    String header[] = {"Book ID", "Book name", "Author", "Publisher", "Published year", "For rent"};

    public void loadTableBook() throws SQLException {
        clearAllBook();
        listBook = new ListBook();
        tbBook.setModel(listBook.tableBook());

        listBook.setColumnOrder(indexItem, tbBook.getColumnModel());
        listBook.setTitleOder(header, tbBook);
    }

    public void loadPublisedYear() {
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        for (int i = 1975; i <= 2020; i++) {
            model.addElement(i);
        }

        cbxPublisedYear.setModel(model);
        cbxPublisedYear.setSelectedIndex(-1);
    }

    public void loadTableBookAscending() throws SQLException {
        clearBookSort();
        listBook = new ListBook();
        tbBook.setModel(listBook.tableBookAscending());

        listBook.setColumnOrder(indexItem, tbBook.getColumnModel());
        listBook.setTitleOder(header, tbBook);
    }
    
    public void loadTableBookDescending() throws SQLException {
        clearBookSort();
        listBook = new ListBook();
        tbBook.setModel(listBook.tableBookDescending());

        listBook.setColumnOrder(indexItem, tbBook.getColumnModel());
        listBook.setTitleOder(header, tbBook);
    }

    public void loadSortByName() {
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        model.addElement("Ascending");
        model.addElement("Descending");

        cbxSortByName.setModel(model);
        cbxSortByName.setSelectedIndex(-1);
    }
    
    public void displayDetailBook(Book book){
        tfBookID.setText(book.getBookID());
        tfBookName.setText(book.getBookName());
        tfAuthor.setText(book.getAuthor());
        tfPublisher.setText(book.getPublisher());
        cbxPublisedYear.setSelectedIndex(book.getPublishedYear() - 1975);
        if (book.isForRent() == true) {
            cbForRent.setSelected(true);
        } else
            cbForRent.setSelected(false);
    }
    
    public void loadTableBookSearchByName(String bookName) throws SQLException {
        clearSearchByName();
        listBook = new ListBook();
        tbBook.setModel(listBook.tableBookSearchByName(bookName));

        listBook.setColumnOrder(indexItem, tbBook.getColumnModel());
        listBook.setTitleOder(header, tbBook);
    }
    
    public boolean checkBook(){
        if (tfBookID.getText().length() == 0 || tfBookID.getText().length() > 10) {
            JOptionPane.showMessageDialog(null, "Book ID phải khác rỗng và không vượt quá 10 kí tự!");
            tfBookID.requestFocus();
            return false;
        }
        if (tfBookID.getText().matches("^[a-zA-Z0-9]{1,10}$") == false) {
            JOptionPane.showMessageDialog(null, "Book ID không chứa khoảng trắng và kí tự đặc biệt!");
            tfBookID.requestFocus();
            return false;
        }
        if (tfBookName.getText().length() == 0 || tfBookName.getText().length() > 50) {
            JOptionPane.showMessageDialog(null, "Book Name phải khác rỗng và không vượt quá 50 kí tự!");
            tfBookName.requestFocus();
            return false;
        }
        if (tfAuthor.getText().length() == 0 || tfAuthor.getText().length() > 50) {
            JOptionPane.showMessageDialog(null, "Author phải khác rỗng và không vượt quá 50 kí tự!");
            tfAuthor.requestFocus();
            return false;
        }
        if (tfPublisher.getText().length() == 0 || tfPublisher.getText().length() > 50) {
            JOptionPane.showMessageDialog(null, "Publisher phải khác rỗng và không vượt quá 50 kí tự!");
            tfPublisher.requestFocus();
            return false;
        }
        if (cbxPublisedYear.getSelectedIndex() < 0) {
            JOptionPane.showMessageDialog(null, "Publised Year phải được chọn!");
            cbxPublisedYear.requestFocus();
            return false;
        }
        return true;
    }

    public UIBookManagement() throws SQLException {
        initComponents();
        setLocationRelativeTo(null);

        tbBook.setDefaultEditor(Object.class, null);
        loadTableBook();
        loadPublisedYear();
        loadSortByName();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbBook = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        cbxSortByName = new javax.swing.JComboBox<>();
        btSearchByName = new javax.swing.JButton();
        tfSearchByName = new javax.swing.JTextField();
        btGetAllBook = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        tfBookID = new javax.swing.JTextField();
        btFindByID = new javax.swing.JButton();
        tfBookName = new javax.swing.JTextField();
        tfAuthor = new javax.swing.JTextField();
        tfPublisher = new javax.swing.JTextField();
        cbxPublisedYear = new javax.swing.JComboBox<>();
        cbForRent = new javax.swing.JCheckBox();
        btAddNew = new javax.swing.JButton();
        btSave = new javax.swing.JButton();
        btRemove = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Book Management");

        jPanel3.setLayout(new java.awt.GridLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Main part:"));

        tbBook.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbBook.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbBookMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbBook);

        jLabel2.setText("Sort by name:");

        cbxSortByName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxSortByName.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxSortByNameItemStateChanged(evt);
            }
        });

        btSearchByName.setText("Search by name");
        btSearchByName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSearchByNameActionPerformed(evt);
            }
        });

        btGetAllBook.setText("Get all Book");
        btGetAllBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGetAllBookActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbxSortByName, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66)
                        .addComponent(btSearchByName, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfSearchByName, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(262, 262, 262)
                        .addComponent(btGetAllBook, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbxSortByName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btSearchByName)
                    .addComponent(tfSearchByName, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(btGetAllBook)
                .addContainerGap(75, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel1);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Detailed part:"));

        jLabel3.setText("Book ID:");

        jLabel4.setText("Book name:");

        jLabel5.setText("Author:");

        jLabel6.setText("Publisher:");

        jLabel7.setText("Published Year:");

        btFindByID.setText("Find by ID");
        btFindByID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFindByIDActionPerformed(evt);
            }
        });

        cbxPublisedYear.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbForRent.setText("For rent");

        btAddNew.setText("Add new");
        btAddNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAddNewActionPerformed(evt);
            }
        });

        btSave.setText("Save");
        btSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSaveActionPerformed(evt);
            }
        });

        btRemove.setText("Remove");
        btRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRemoveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbForRent)
                            .addComponent(cbxPublisedYear, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(tfBookID, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(btFindByID, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(tfBookName)
                                .addComponent(tfAuthor)
                                .addComponent(tfPublisher))))
                    .addComponent(btAddNew)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(178, 178, 178)
                        .addComponent(btSave)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btRemove)))
                .addContainerGap(176, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tfBookID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btFindByID))
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tfBookName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tfAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(tfPublisher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cbxPublisedYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(cbForRent)
                .addGap(35, 35, 35)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btAddNew)
                    .addComponent(btSave)
                    .addComponent(btRemove))
                .addGap(135, 135, 135))
        );

        jPanel3.add(jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 1353, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(553, 553, 553)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbBookMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbBookMouseClicked
        addNewBook = false;
        clearMouseClickedBook();
        int row = tbBook.getSelectedRow();
        Book book = listBook.getListBook().get(row);
        displayDetailBook(book);
    }//GEN-LAST:event_tbBookMouseClicked

    private void btGetAllBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGetAllBookActionPerformed
        clearAllBook();
        try {
            loadTableBook();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_btGetAllBookActionPerformed

    private void cbxSortByNameItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxSortByNameItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            if (cbxSortByName.getSelectedIndex() == 0) {
                try {
                    loadTableBookAscending();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
            if (cbxSortByName.getSelectedIndex() == 1) {
                try {
                    loadTableBookDescending();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        }
    }//GEN-LAST:event_cbxSortByNameItemStateChanged

    private void btFindByIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFindByIDActionPerformed
        addNewBook=false;
        String bookID = tfBookID.getText();
        try {
            loadTableBook();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        for (int i=0; i<listBook.getListBook().size(); i++){
            if (bookID.equals(listBook.getListBook().get(i).getBookID())){
                clearMouseClickedBook();
                Book book = listBook.getListBook().get(i);
                displayDetailBook(book);
                tbBook.setRowSelectionInterval(i, i);
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Không tìm thấy ID này!");
    }//GEN-LAST:event_btFindByIDActionPerformed

    private void btSearchByNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSearchByNameActionPerformed
        String bookName=tfSearchByName.getText();
        if (bookName.length() == 0){
            JOptionPane.showMessageDialog(null, "Search by name phải khác rỗng!");
            return;
        }
        for (int i=0; i<listBook.getListBook().size(); i++){
            if (listBook.getListBook().get(i).getBookName().contains(bookName)==true){
                try {
                    loadTableBookSearchByName(bookName);
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Không tìm thấy tên sách này!");
    }//GEN-LAST:event_btSearchByNameActionPerformed

    private void btAddNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAddNewActionPerformed
        addNewBook = true;
        try {
            loadTableBook();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        clearNewBook();
    }//GEN-LAST:event_btAddNewActionPerformed

    private void btSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSaveActionPerformed
        if (checkBook() == false) {
            return;
        }

        Book book = new Book(tfBookID.getText(), tfBookName.getText(), tfAuthor.getText(), tfPublisher.getText(), cbxPublisedYear.getSelectedIndex()+1975, cbForRent.isSelected());

        if (addNewBook == true) {
            try {
                for (int i = 0; i < listBook.getListBook().size(); i++) {
                    if (tfBookID.getText().equals(listBook.getListBook().get(i).getBookID())) {
                        JOptionPane.showMessageDialog(null, "ID đã tồn tại!");
                        return;
                    }
                }
                if (listBook.addBook(book) == true) {
                    addNewBook = false;
                    loadTableBook();
//                    clearAll();
                }
            } catch (SQLException ex) {
                Logger.getLogger(UIBookManagement.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                if (listBook.UpdateBook(book) == true) {
                    loadTableBook();
//                    clearAll();
                }
            } catch (SQLException ex) {
                Logger.getLogger(UIBookManagement.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btSaveActionPerformed

    private void btRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRemoveActionPerformed
        try {
            int row = tbBook.getSelectedRow();
            Book book = listBook.getListBook().get(row);
            listBook.deleteBook(book);
            loadTableBook();
//            clearAll();
        } catch (SQLException ex) {
            Logger.getLogger(UIBookManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btRemoveActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UIBookManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UIBookManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UIBookManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UIBookManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new UIBookManagement().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(UIBookManagement.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAddNew;
    private javax.swing.JButton btFindByID;
    private javax.swing.JButton btGetAllBook;
    private javax.swing.JButton btRemove;
    private javax.swing.JButton btSave;
    private javax.swing.JButton btSearchByName;
    private javax.swing.JCheckBox cbForRent;
    private javax.swing.JComboBox<String> cbxPublisedYear;
    private javax.swing.JComboBox<String> cbxSortByName;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbBook;
    private javax.swing.JTextField tfAuthor;
    private javax.swing.JTextField tfBookID;
    private javax.swing.JTextField tfBookName;
    private javax.swing.JTextField tfPublisher;
    private javax.swing.JTextField tfSearchByName;
    // End of variables declaration//GEN-END:variables

    private void clearAllBook() {
        tfBookID.setText("");
        tfBookName.setText("");
        tfBookName.setEnabled(false);
        tfAuthor.setText("");
        tfAuthor.setEnabled(false);
        tfPublisher.setText("");
        tfPublisher.setEnabled(false);
        cbxPublisedYear.setSelectedIndex(-1);
        cbxPublisedYear.setEnabled(false);
        cbForRent.setSelected(false);
        cbForRent.setEnabled(false);
        
        cbxSortByName.setSelectedIndex(-1);
        cbxSortByName.setEnabled(true);
        tfSearchByName.setText("");
        
        btSave.setEnabled(false);
        btRemove.setEnabled(false);
    }

    private void clearMouseClickedBook() {
        tfBookName.setEnabled(true);
        tfAuthor.setEnabled(true);
        tfPublisher.setEnabled(true);
        cbxPublisedYear.setEnabled(true);
        cbForRent.setEnabled(true);
        
        btSave.setEnabled(true);
        btRemove.setEnabled(true);
    }

    private void clearNewBook() {
        tfBookID.setText("");
        tfBookName.setText("");
        tfBookName.setEnabled(true);
        tfAuthor.setText("");
        tfAuthor.setEnabled(true);
        tfPublisher.setText("");
        tfPublisher.setEnabled(true);
        cbxPublisedYear.setSelectedIndex(-1);
        cbxPublisedYear.setEnabled(true);
        cbForRent.setSelected(false);
        cbForRent.setEnabled(true);
        
        btSave.setEnabled(true);
        btRemove.setEnabled(false);
    }

    private void clearSearchByName() {
        clearAllBook();
        cbxSortByName.setEnabled(false);
    }

    private void clearBookSort() {
        tfBookID.setText("");
        tfBookName.setText("");
        tfBookName.setEnabled(false);
        tfAuthor.setText("");
        tfAuthor.setEnabled(false);
        tfPublisher.setText("");
        tfPublisher.setEnabled(false);
        cbxPublisedYear.setSelectedIndex(-1);
        cbxPublisedYear.setEnabled(false);
        cbForRent.setSelected(false);
        cbForRent.setEnabled(false);
        
        cbxSortByName.setEnabled(true);
        tfSearchByName.setText("");
        
        btSave.setEnabled(false);
        btRemove.setEnabled(false);
    }
}